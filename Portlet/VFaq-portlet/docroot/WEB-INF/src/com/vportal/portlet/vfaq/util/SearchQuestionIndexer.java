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

//package com.vportal.portlet.vfaq.util;
//
//import java.io.IOException;
//
//import javax.portlet.PortletURL;
//
//import com.liferay.portal.kernel.search.Document;
//import com.liferay.portal.kernel.search.DocumentImpl;
//import com.liferay.portal.kernel.search.Field;
//import com.liferay.portal.kernel.search.Hits;
//import com.liferay.portal.kernel.search.SearchContext;
//import com.liferay.portal.kernel.search.SearchEngineUtil;
//import com.liferay.portal.kernel.search.SearchException;
//import com.liferay.portal.kernel.search.Summary;
//import com.vportal.portal.util.PortletKeysExt;
//import com.vportal.portlet.vfaq.model.FAQQuestion;
//import com.vportal.portlet.vfaq.service.FAQQuestionServiceUtil;
//import com.liferay.portal.kernel.search.Indexer;
//import com.liferay.portal.kernel.util.HtmlUtil;
//import com.liferay.portal.kernel.util.StringUtil;
//
//public class SearchQuestionIndexer implements Indexer {
//
//	public static final String PORTLET_ID = PortletKeysExt.FAQ_QUESTION;
//
//	public static void addQuestion(long groupId, long companyId, String quesId,
//			String title, String content) throws IOException, SearchException {
//
//		Document doc = getAddQuestionDocument(groupId, companyId, quesId,
//				title, content);
//		SearchEngineUtil.addDocument(companyId, doc);
//	}
//
//	public static Document getAddQuestionDocument(long groupId, long companyId,
//			String quesId, String title, String content) {
//		content = HtmlUtil.extractText(content);
//
//		Document doc = new DocumentImpl();
//
//		doc.addUID(PORTLET_ID, quesId);
//
//		doc.addKeyword(Field.COMPANY_ID, companyId);
//		doc.addKeyword(Field.PORTLET_ID, PORTLET_ID);
//		doc.addKeyword(Field.GROUP_ID, groupId);
//
//		doc.addText(Field.TITLE, title);
//		doc.addText(Field.CONTENT, content);
//
//		doc.addModifiedDate();
//
//		doc.addKeyword(Field.ENTRY_CLASS_NAME, FAQQuestion.class.getName());
//		doc.addKeyword(Field.ENTRY_CLASS_PK, quesId);
//		return doc;
//	}
//
//	public static void updateQuestion(long groupId, long companyId,
//			String quesId, String title, String content) throws IOException,
//			SearchException {
//		Document doc = getAddQuestionDocument(groupId, companyId, quesId,
//				title, content);
//		SearchEngineUtil.updateDocument(companyId, doc);
//		/* SearchEngineUtil.updateDocument(companyId, doc.get(Field.UID), doc); */
//	}
//
//	public static void deleteQuestion(long companyId, String quesId)
//			throws IOException, SearchException, NumberFormatException {
//		SearchEngineUtil.deleteDocument(companyId,
//				getEntryUID(Long.parseLong(quesId)));
//	}
//
//	public static String getEntryUID(long quesId) {
//		Document doc = new DocumentImpl();
//		doc.addUID(PORTLET_ID, quesId);
//
//		return doc.get(Field.UID);
//	}
//
//	public Summary getSummary(
//			com.liferay.portal.kernel.search.Document doc, PortletURL portletURL) {
//
//		// Title
//
//		String title = doc.get(Field.TITLE);
//
//		// Content
//
//		String content = doc.get(Field.CONTENT);
//
//		content = StringUtil.shorten(content, 200);
//
//		// Portlet URL
//
//		String quesId = doc.get(Field.ENTRY_CLASS_PK);
//
//		portletURL.setParameter("struts_action", "/vfaq/search");
//		portletURL.setParameter("quesId", quesId);
//
//		return new Summary(title, content, portletURL);
//	}
//
//	public void reIndex(String[] ids) throws SearchException {
//		try {
//			FAQQuestionServiceUtil.reIndex(ids);
//		} catch (Exception e) {
//			throw new SearchException(e);
//		}
//	}
//
//	@Override
//	public void delete(Object arg0) throws SearchException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public String[] getClassNames() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Document getDocument(Object arg0) throws SearchException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Summary getSummary(Document doc, String arg1, PortletURL portletURL) {
//		// TODO Auto-generated method stub
//		String title = doc.get(Field.TITLE);
//
//		// Content
//
//		String content = doc.get(Field.CONTENT);
//
//		content = StringUtil.shorten(content, 200);
//
//		// Portlet URL
//
//		String quesId = doc.get(Field.ENTRY_CLASS_PK);
//
//		portletURL.setParameter("struts_action", "/vfaq/search");
//		portletURL.setParameter("quesId", quesId);
//
//		return new Summary(title, content, portletURL);
//	}
//
//	@Override
//	public void reindex(Object arg0) throws SearchException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void reindex(String[] ids) throws SearchException {
//		// TODO Auto-generated method stub
//		try {
//			FAQQuestionServiceUtil.reIndex(ids);
//		} catch (Exception e) {
//			throw new SearchException(e);
//		}
//	}
//
//	@Override
//	public void reindex(String arg0, long arg1) throws SearchException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public Hits search(SearchContext arg0) throws SearchException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}
