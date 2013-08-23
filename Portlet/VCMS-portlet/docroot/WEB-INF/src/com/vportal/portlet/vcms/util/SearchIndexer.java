/**
 * Copyright (c) Vietsoftware, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

/*

 * @(#)SearchIndexer.java
 *
 * Copyright (c) 2007 VietSoftware, Inc.
 * 51 Le Dai Hanh street, Hai Ba Trung district, Hanoi, Vietnam.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * VietSoftware, Inc. ("Confidential Information").  You shall not 
 * disclose such Confidential Information and shall use it only in 
 * accordance with the terms of the license agreement you entered 
 * into with VietSoftware, Inc.
 *
 */

package com.vportal.portlet.vcms.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletURL;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.DocumentImpl;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.vportal.portal.util.PortletKeysExt;
import com.vportal.portlet.vcms.model.VcmsArticle;
import com.vportal.portlet.vcms.model.VcmsCARelation;
import com.vportal.portlet.vcms.service.VcmsArticleServiceUtil;
import com.vportal.portlet.vcms.service.VcmsCARelationServiceUtil;

public class SearchIndexer extends BaseIndexer {

	public static final String[] CLASS_NAMES = { VcmsArticle.class.getName() };

	public static final String PORTLET_ID = PortletKeysExt.VCMS;

	
	public String[] getClassNames() {
		// TODO Auto-generated method stub
		System.out.println("getClassNames calling ");
		return CLASS_NAMES;
	}

	
	public Summary getSummary(Document document, String snippet,
			PortletURL portletURL) {
		// TODO Auto-generated method stub
		System.out.println("getSummary calling ");
		// Title
		String title = document.get(Field.TITLE);

		// Content
		String content = snippet;
		if (Validator.isNull(snippet)) {
			content = StringUtil.shorten(document.get(Field.CONTENT), 200);
		}

		// Portlet URL
		String articleId = document.get(Field.ENTRY_CLASS_PK);

		// URL
		portletURL.setParameter("jspPage",
				"/VCMS-portlet/html/portlet/vcmsviewcontent/view.jsp");
		portletURL.setParameter("articleId", articleId);

		VcmsCARelation category = null;
		try {
			category = VcmsCARelationServiceUtil
					.findRelationsByArticle(articleId);
		} catch (Exception e) {
			// TODO: handle exception
		}

		String categoryId = "";
		if (category != null) {
			categoryId = String.valueOf(category.getCategoryId());
		}
		portletURL.setParameter("categoryId", categoryId);

		return new Summary(title, content, portletURL);
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		// TODO Auto-generated method stub
		VcmsArticle article = (VcmsArticle) obj;

		Document document = new DocumentImpl();

		document.addUID(PORTLET_ID, article.getGroupId(),
				article.getArticleId());

		SearchEngineUtil.deleteDocument(article.getCompanyId(),
				document.get(Field.UID));
	}

	@Override
	public void postProcessSearchQuery(BooleanQuery searchQuery,
			SearchContext searchContext) throws Exception {
		// TODO Auto-generated method stub
		addSearchTerm(searchQuery, searchContext, Field.TITLE, true);
		addSearchTerm(searchQuery, searchContext, Field.CONTENT, true);

	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("doGetDocument calling in SampleIndexer class ");
		VcmsArticle article = (VcmsArticle) obj;
		long companyId = article.getCompanyId();
		long groupId = getParentGroupId(article.getGroupId());
		long scopeGroupId = article.getGroupId();
		String articleId = article.getArticleId();
		String title = article.getTitle();
		String lead = article.getLead();
		String content = article.getContent();
		String language = article.getLanguage();
		Date publishDate = article.getPublishedDate();
		// System.out.println("VcmsArticle primary key = -----"
		// + article.getExpandoBridge());

		// ExpandoBridge expandoBridge = article.getExpandoBridge();

		Document document = new DocumentImpl();

		document.addUID(PORTLET_ID, groupId, articleId);

		document.addModifiedDate(publishDate);

		document.addKeyword(Field.COMPANY_ID, companyId);
		document.addKeyword(Field.PORTLET_ID, PORTLET_ID);
		document.addKeyword(Field.GROUP_ID, groupId);
		document.addKeyword(Field.SCOPE_GROUP_ID, scopeGroupId);
		document.addKeyword(FieldExt.LANGUAGE, language );
		
		System.out.println(String.valueOf(publishDate));

		document.addText(Field.TITLE, title);
		document.addText(Field.CONTENT, processContent(document, content));
		// document.addText(Field.CONTENT, content);
		document.addKeyword(Field.ENTRY_CLASS_NAME, VcmsArticle.class.getName());
		document.addKeyword(Field.ENTRY_CLASS_PK, articleId);

		// ExpandoBridgeIndexerUtil.addAttributes(document, expandoBridge);
		System.out.println("document == " + document);
		return document;
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("doReindex calling ");
		VcmsArticle article = (VcmsArticle) obj;

		System.out.println(" document creation here");
		Document document = getDocument(article);
		System.out.println("document is === " + document);

		SearchEngineUtil.updateDocument(article.getCompanyId(), document);
		System.out.println("updateDocument is === " + document);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("doReindex calling ");
		VcmsArticle entry = VcmsArticleServiceUtil.getArticle(String
				.valueOf(classPK));
		doReindex(entry);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("doReindex calling of string ");
		long companyId = GetterUtil.getLong(ids[0]);
		reindexEntries(companyId);
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {
		// TODO Auto-generated method stub
		return PORTLET_ID;
	}

	protected void reindexEntries(long companyId) throws Exception {
		int count = VcmsArticleServiceUtil.countArticleByCompanyId(companyId);

		int pages = count / Indexer.DEFAULT_INTERVAL;

		for (int i = 0; i <= pages; i++) {
			int start = (i * Indexer.DEFAULT_INTERVAL);
			int end = start + Indexer.DEFAULT_INTERVAL;

			reindexEntries(companyId, start, end);
		}
	}

	protected void reindexEntries(long companyId, int start, int end)
			throws Exception {
		
		List<VcmsArticle> listVcmsArticle = VcmsArticleServiceUtil
				.getArticleByCompanyId(companyId, start, end);
		if (listVcmsArticle.isEmpty()) {
			return;
		}
		
		Collection<Document> documents = new ArrayList<Document>();
		for (VcmsArticle entry : listVcmsArticle) {
			Document document = getDocument(entry);
			documents.add(document);
		}
		
		SearchEngineUtil.updateDocuments(companyId, documents);
	}

	protected String processContent(Document document, String content) {
		if ((content != null)
				&& ((content.indexOf("<dynamic-content") != -1) || (content
						.indexOf("<static-content") != -1))) {

			content = getIndexableContent(document, content);

			content = StringUtil
					.replace(content, "<![CDATA[", StringPool.BLANK);
			content = StringUtil.replace(content, "]]>", StringPool.BLANK);
		}

		content = StringUtil.replace(content, "&amp;", "&");
		content = StringUtil.replace(content, "&lt;", "<");
		content = StringUtil.replace(content, "&gt;", ">");

		content = HtmlUtil.extractText(content);

		return content;
	}

	protected String getIndexableContent(Document document, String content) {
		try {
			com.liferay.portal.kernel.xml.Document contentDocument = SAXReaderUtil
					.read(content);

			Element rootElement = contentDocument.getRootElement();

			return getIndexableContent(document, rootElement);
		} catch (Exception e) {
			_log.error(e, e);

			return content;
		}
	}

	protected String getIndexableContent(Document document, Element rootElement)
			throws Exception {

		StringBundler sb = new StringBundler();

		LinkedList<Element> queue = new LinkedList<Element>(
				rootElement.elements());

		Element element = null;

		while ((element = queue.poll()) != null) {
			String elType = element.attributeValue("type", StringPool.BLANK);
			String elIndexType = element.attributeValue("index-type",
					StringPool.BLANK);

			indexField(document, element, elType, elIndexType);

			if (elType.equals("text") || elType.equals("text_box")
					|| elType.equals("text_area")) {

				for (Element dynamicContentElement : element
						.elements("dynamic-content")) {

					String text = dynamicContentElement.getText();

					sb.append(text);
					sb.append(StringPool.SPACE);
				}
			} else if (element.getName().equals("static-content")) {
				String text = element.getText();

				sb.append(text);
				sb.append(StringPool.SPACE);
			}

			queue.addAll(element.elements());
		}

		return sb.toString();
	}

	protected void indexField(Document document, Element element,
			String elType, String elIndexType) {

		if (Validator.isNull(elIndexType)) {
			return;
		}

		Element dynamicContentElement = element.element("dynamic-content");

		String fieldName = encodeFieldName(element.attributeValue("name",
				StringPool.BLANK));
		String[] value = new String[] { dynamicContentElement.getText() };

		if (elType.equals("multi-list")) {
			List<Element> optionElements = dynamicContentElement.elements();

			value = new String[optionElements.size()];

			for (int i = 0; i < optionElements.size(); i++) {
				value[i] = optionElements.get(i).getText();
			}
		}

		if (elIndexType.equals("keyword")) {
			document.addKeyword(fieldName, value);
		} else if (elIndexType.equals("text")) {
			document.addText(fieldName,
					StringUtil.merge(value, StringPool.SPACE));
		}
	}

	protected String encodeFieldName(String name) {
		return _FIELD_NAMESPACE.concat(StringPool.FORWARD_SLASH).concat(name);
	}

	protected void addSearchTerm(BooleanQuery searchQuery,
			SearchContext searchContext, String field, boolean like)
			throws Exception {

		if (Validator.isNull(field)) {
			return;
		}

		String value = String.valueOf(searchContext.getAttribute(field));

		if (Validator.isNull(value)) {
			return;
		}

		if (searchContext.isAndSearch()) {
			searchQuery.addRequiredTerm(field, value, like);
		} else {
			searchQuery.addTerm(field, value, like);
		}
	}

	protected static final String _FIELD_NAMESPACE = "web_content";

	private static Log _log = LogFactoryUtil.getLog(VcmsArticle.class);


	
	public String getPortletId() {
		// TODO Auto-generated method stub
		return PORTLET_ID;
	}


	@Override
	protected Summary doGetSummary(Document document, Locale locale,
			String snippet, PortletURL portletURL) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("doGetSummary calling ");
		// Title
		String title = document.get(Field.TITLE);

		// Content
		String content = snippet;
		if (Validator.isNull(snippet)) {
			content = StringUtil.shorten(document.get(Field.CONTENT), 200);
		}

		// Portlet URL
		String articleId = document.get(Field.ENTRY_CLASS_PK);

		// URL
		portletURL.setParameter("jspPage",
				"/VCMS-portlet/html/portlet/vcmsviewcontent/view.jsp");
		portletURL.setParameter("articleId", articleId);

		VcmsCARelation category = null;
		try {
			category = VcmsCARelationServiceUtil
					.findRelationsByArticle(articleId);
		} catch (Exception e) {
			// TODO: handle exception
		}

		String categoryId = "";
		if (category != null) {
			categoryId = String.valueOf(category.getCategoryId());
		}
		portletURL.setParameter("categoryId", categoryId);

		return new Summary(title, content, portletURL);
	}
}
