
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

package com.vportal.portlet.vcmsviewcontent.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassInvoker;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.vportal.portal.NoSuchAccessCounterException;
import com.vportal.portal.service.AccessCounterServiceUtil;
import com.vportal.portal.util.AttachmentUtil;
import com.vportal.portal.util.PortalUtilExt;
import com.vportal.portal.util.PropsUtilExt;
import com.vportal.portlet.vcms.model.VcmsArticle;
import com.vportal.portlet.vcms.model.VcmsCARelation;
import com.vportal.portlet.vcms.model.VcmsCategory;
import com.vportal.portlet.vcms.model.VcmsDiscussion;
import com.vportal.portlet.vcms.model.VcmsTARelation;
import com.vportal.portlet.vcms.service.VcmsArticleServiceUtil;
import com.vportal.portlet.vcms.service.VcmsCARelationServiceUtil;
import com.vportal.portlet.vcms.service.VcmsCategoryServiceUtil;
import com.vportal.portlet.vcms.service.VcmsDiscussionServiceUtil;
import com.vportal.portlet.vcms.service.VcmsStatusLocalServiceUtil;
import com.vportal.portlet.vcms.service.VcmsTARelationServiceUtil;
import com.vportal.portlet.vcms.util.VCMSOpenSearchImpl;
import com.vportal.portlet.vcms.util.VCMSUtil;
import com.vportal.portlet.vcms.util.WebKeysExt;
import com.vportal.portlet.vcmsview.util.ConstantsExt;
import com.vportal.portlet.vcmsviewcontent.util.LayoutPortletUtil;
import com.vportal.util.HtmlExt;

/**
 * Portlet implementation class VcmsViewContent
 */
public class VcmsViewContent extends MVCPortlet {
	@Override
	public void doEditDefaults(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		PortletPreferences prefs = renderRequest.getPreferences();

		String layoutPortletId = ParamUtil.getString(renderRequest, "layoutPortletId",
				StringPool.BLANK);
		System.out.println("eeeeeeeeeeeeeeeeeeeeee");
		super.doEditDefaults(renderRequest, renderResponse);
	}
	
	@Override
	public void doEdit(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		PortletPreferences prefs = renderRequest.getPreferences();

		String layoutPortletId = ParamUtil.getString(renderRequest, "layoutPortletId",
				StringPool.BLANK);
		super.doEdit(renderRequest, renderResponse);
	}
	private static int hitIncrease = 0;
	@Override
	public void processAction(ActionRequest req,
			ActionResponse res) throws IOException, PortletException {
		// TODO Auto-generated method stub
		PortletPreferences prefs = req.getPreferences();

		String layoutPortletId = ParamUtil.getString(req, "layoutPortletId",
				StringPool.BLANK);

		String portletSelectId = ParamUtil.getString(req, "portletSelectId",
				StringPool.BLANK);
		String portionId = ParamUtil.getString(req, "portionId",
				StringPool.BLANK);
		String showMenuContent = ParamUtil.getString(req, "showMenuContent",
				StringPool.BLANK);

		String displayDefaultCat = ParamUtil.getString(req, "categories");

		String defaultShowNews = ParamUtil.getString(req, "defaultShowNews");

		String emailSubject = ParamUtil.getString(req, "emailSubject");

		String emailContent = ParamUtil.getString(req, "emailContent");

		String displayContent = ParamUtil.getString(req, "displayContent");

		String typeId = ParamUtil.getString(req, "typeId", StringPool.BLANK);

		String categoryId = ParamUtil.getString(req, "categoryId",
				StringPool.BLANK);

		// style view

		String defaultStyle = ParamUtil.getString(req, "defaultStyle");

		String tabsStyle = ParamUtil.getString(req, "tabsStyle");

		String stickyStyle = ParamUtil.getString(req, "stickyStyle");

		String typeStyle = ParamUtil.getString(req, "typeStyle");

		int numberOfNews = ParamUtil.getInteger(req, "numberOfNews");

		int displayNews = ParamUtil.getInteger(req, "displayNews");

		int numberArticlesInCat = ParamUtil.getInteger(req,
				"numberArticlesInCat");
		
		String titlecategory = ParamUtil.getString(req, "titlecategory", StringPool.BLANK);

		int numberArticlesNextInCat = ParamUtil.getInteger(req,
				"numberArticlesNextInCat");

		int nextNewByNewest = ParamUtil.getInteger(req, "nextNewByNewest");

		int nextNewByOrder = ParamUtil.getInteger(req, "nextNewByOrder");

		int nextNewByInFlow = ParamUtil.getInteger(req, "nextNewByInFlow");

		int articleDisplayInType = ParamUtil.getInteger(req,
				"articleDisplayInType");

		int numberOfStickedNews = ParamUtil.getInteger(req,
				"numberOfStickedNews");
		
		int numberOfNewestArticle = ParamUtil.getInteger(req,
				"numberOfNewestArticle");
		
		boolean pagingDisplay = ParamUtil.getBoolean(req, "pagingDisplay");

		boolean isDisplaySendEmail = ParamUtil.getBoolean(req,
				"isDisplaySendEmail");

		boolean isDisplayPrintArticle = ParamUtil.getBoolean(req,
				"isDisplayPrintArticle");

		boolean isDisplayDiscussion = ParamUtil.getBoolean(req,
				"isDisplayDiscussion");

		boolean isDisplayImageNew = ParamUtil.getBoolean(req,
				"isDisplayImageNew");

		int pagingStyle = ParamUtil.getInteger(req, "pagingStyle");

		int displayStyle = ParamUtil.getInteger(req, "displayStyle");

		int columnDisplay = ParamUtil.getInteger(req, "columnDisplay");

		boolean isDisplayDate = ParamUtil.getBoolean(req, "isDisplayDate");

		boolean pagingType = ParamUtil.getBoolean(req, "pagingType");

		// URL Search
		//hoan lam moi lai cach hien thi vcmsview content
		
		int numberArticles = ParamUtil.getInteger(req, ConstantsExt.NUMBER_OF_ARTICLES);
		int numberArticlesDisplayImages = ParamUtil.getInteger(req, ConstantsExt.NUMBER_OF_ARTICLES_DISPLAY_IMAGES);
		boolean groupCategory = ParamUtil.getBoolean(req, ConstantsExt.GROUP_CATEGORYS);
		String displayDefaultPortion = ParamUtil.getString(req, "portions");
		
		//hoan
		long currentPlid = PortalUtilExt.getPlid(req);

		long plId = 0;

		long groupId = 0;
		try {
			groupId = PortalUtilExt.getPortletGroupId(req);
		} catch (PortalException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {

			plId = PortalUtil.getPlidFromPortletId(groupId, false,
					portletSelectId);

		} catch (Exception ex) {
		}

		HttpServletRequest httpReq =PortalUtil.getHttpServletRequest(req);

		PortletURL articleURL = PortletURLFactoryUtil.create(httpReq, portletSelectId,
				plId, PortletRequest.ACTION_PHASE);

		articleURL.setParameter("jspPage", "/html/portlet/vcmsviewcontent/view.jsp");

		VCMSOpenSearchImpl.URL_PORTLET = articleURL.toString();

		// END

		prefs.setValue(ConstantsExt.NUMBER_OF_NEWS, String
				.valueOf(numberOfNews));

		prefs.setValue(ConstantsExt.DISPLAY_NEWS, String.valueOf(displayNews));

		prefs.setValue(ConstantsExt.NEXT_NEWS_BY_NEWEST, String
				.valueOf(nextNewByNewest));

		prefs.setValue(ConstantsExt.NEXT_NEWS_BY_ORDER, String
				.valueOf(nextNewByOrder));

		prefs.setValue(ConstantsExt.NEXT_NEWS_BY_IN_FLOW, String
				.valueOf(nextNewByInFlow));

		prefs.setValue("numberOfStickedNews", String
				.valueOf(numberOfStickedNews));
		
		prefs.setValue(ConstantsExt.NUMBER_OF_NEWEST_ARTICLE, String.valueOf(numberOfNewestArticle));

		prefs.setValue(ConstantsExt.PAGING_DISPLAY, String
				.valueOf(pagingDisplay));

		prefs.setValue(ConstantsExt.PAGING_STYLE, String.valueOf(pagingStyle));

		prefs
				.setValue(ConstantsExt.DISPLAY_STYLE, String
						.valueOf(displayStyle));

		prefs
				.setValue(ConstantsExt.EMAIL_SUBJECT, String
						.valueOf(emailSubject));

		prefs
				.setValue(ConstantsExt.EMAIL_CONTENT, String
						.valueOf(emailContent));

		prefs.setValue(ConstantsExt.IS_DISPLAY_SEND_EMAIL, String
				.valueOf(isDisplaySendEmail));

		prefs.setValue(ConstantsExt.IS_DISPLAY_PRINT_ARTICLE, String
				.valueOf(isDisplayPrintArticle));

		prefs.setValue("isDisplayImageNew", String.valueOf(isDisplayImageNew));

		prefs.setValue(ConstantsExt.IS_DISPLAY_DISCUSSION_ARTICLE, String
				.valueOf(isDisplayDiscussion));

		prefs.setValue(ConstantsExt.IS_DISPLAY_DEFAULT_CATEGORY,
				displayDefaultCat);
		
		prefs.setValue("titlecategory", titlecategory);

		prefs.setValue(ConstantsExt.LAYOUT_PORTLET_ID, String
				.valueOf(layoutPortletId));

		prefs.setValue(ConstantsExt.PORTLET_SELECTED_ID, String
				.valueOf(portletSelectId));

		prefs.setValue(ConstantsExt.NUMBER_ARTICLES_IN_CAT_DEFAULT, String
				.valueOf(numberArticlesInCat));

		prefs.setValue(ConstantsExt.NUMBER_ARTICLES_NEXT_IN_CAT_DEFAULT, String
				.valueOf(numberArticlesNextInCat));

		prefs.setValue("displayContent", displayContent);

		prefs.setValue("articleDisplayInType", String
				.valueOf(articleDisplayInType));

		prefs.setValue("isDisplayDate", String.valueOf(isDisplayDate));

		prefs.setValue("pagingType", String.valueOf(pagingType));

		prefs.setValue("columnDisplay", String.valueOf(columnDisplay));

		prefs.setValue("portionId", portionId);

		prefs.setValue("showMenuContent", showMenuContent);

		prefs.setValue("defaultShowNews", defaultShowNews);

		prefs.setValue("typeId", typeId);

		prefs.setValue("categoryId", categoryId);

		prefs.setValue("defaultStyle", defaultStyle);

		prefs.setValue("tabsStyle", tabsStyle);

		prefs.setValue("stickyStyle", stickyStyle);

		prefs.setValue("typeStyle", typeStyle);
		
		//hoan
		prefs.setValue(ConstantsExt.NUMBER_OF_ARTICLES,String.valueOf(numberArticles));
		prefs.setValue(ConstantsExt.NUMBER_OF_ARTICLES_DISPLAY_IMAGES, String.valueOf(numberArticlesDisplayImages));
		prefs.setValue(ConstantsExt.GROUP_CATEGORYS, String.valueOf(groupCategory));
		//hoan
		prefs.store();
		try {
			selectLayoutPortlet(req);
		} catch (Exception e) {
			// TODO: handle exception
		}

		super.processAction(req, res);
	}
	@Override
	public void render(RenderRequest req, RenderResponse res)
			throws PortletException, IOException {
		// TODO Auto-generated method stub
		try {
			String cmd = ParamUtil.getString(req, "cmd", StringPool.BLANK);

			if (Validator.isNotNull(cmd) && cmd.equals("PUBLISHED_RSS")) {
				/*return mapping.findForward("vportlet.vcmsviewcontent.rss");*/
			}
			// init portlet preferences
			PortletPreferences prefs = req.getPreferences();

			// get param to switch
			String categoryId = ParamUtil.getString(req, ConstantsExt.CATEGORY_ID);
			String articleId = ParamUtil.getString(req, ConstantsExt.ARTICLE_ID);
			String cat_parent = ParamUtil.getString(req, "cat_parent",
					StringPool.BLANK);

			String cat_style = ParamUtil.getString(req, "cat_style",
					StringPool.BLANK);

			String categoriesSelectedCats = ParamUtil.getString(req,
					"categoriesSelectedCats", StringPool.BLANK);
			boolean openNewTab = getOpenNewTab(req, prefs);

			if (Validator.isNotNull(articleId)) { // display article
				displayArticleDetails(req, prefs);
			}
			HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);
			HttpSession session = httpReq.getSession();
			session.setAttribute("CAT_PARENT_ID", cat_parent);
			session.setAttribute("CATEGORY_ID", categoryId);
			session.setAttribute("CATEGORY_STYLE", cat_style);
			req.setAttribute(ConstantsExt.OPEN_NEW_TAB, new Boolean(openNewTab));
			session.setAttribute("SELETED_DISPLAY_CATS_IN_CONTENT",
					categoriesSelectedCats);
			
			MethodKey methodkeyVisitCount = new MethodKey("com.liferay.portal.util.WebAppPool", "get", String.class,String.class);
			Object[] argsVisitCount = new Object[]{String.valueOf(PortalUtil.getDefaultCompanyId()),PropsUtilExt.VCMS_VISIT_COUNT};
			
			
			//loi doan nay comment
//			int totalVisit = 0 ;
//			totalVisit = Integer.parseInt(GetterUtil.get(
//					(String) PortalClassInvoker.invoke(false, methodkeyVisitCount, argsVisitCount),"0"));
//			if(totalVisit == 0){
//				try {
//					totalVisit = AccessCounterServiceUtil.getTotalHits(PortalUtil.getDefaultCompanyId());
//				} catch (Exception e1) {
//				}
//			}
//			
//			totalVisit++;
//			hitIncrease++;
			
			
			
			/*MethodKey method = new MethodKey("com.liferay.portal.util.WebAppPool", "put",String.class,String.class,Object.class);
			Object[] args = new Object[]{MainServlet.DEFAULT_COMPANY_ID,PropsUtilExt.VCMS_VISIT_COUNT,String.valueOf(totalVisit)};
			PortalClassInvoker.invoke(false, method, args);*/

			// update hits to database
			if(hitIncrease > 200) {
				try {
					updateHits(hitIncrease);
					hitIncrease = 0;
				} catch (Exception e) {
					
				}
			}
			List selectLayouts = new ArrayList();
			LayoutPortletUtil.getLayoutPortletIds(selectLayouts ,req,"vcmsviewcontent_WAR_VCMSportlet_INSTANCE_");
			req.setAttribute("SELECT_LAYOUTS", selectLayouts);
			selectLayoutPortlet(req);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		super.render(req, res);
	}

	
	private void selectLayoutPortlet(PortletRequest req) throws Exception {

		String cmd = ParamUtil.getString(req, "cmd");
		long layoutPlid = ParamUtil.getLong(req, "layoutIdSelected");

		List selectPortletLayoutIds = null;

		// StringBuffer strPortletIds = new StringBuffer();

		if (Validator.isNotNull(cmd) && cmd.equals("SELECT_LAYOUT")) {
			selectPortletLayoutIds = LayoutPortletUtil
					.getPortletIdsByLayout(layoutPlid);
		}

		req.setAttribute("SELECT_PORTLET_LAYOUT_IDS", selectPortletLayoutIds);

		req.setAttribute("PLID_LAYOUT", String.valueOf(layoutPlid));

		List selectLayouts = new ArrayList();

		LayoutPortletUtil.getLayoutPortletIds(selectLayouts, req,
				"vcmsviewcontent_WAR_VCMSportlet_INSTANCE_");

		req.setAttribute("SELECT_LAYOUTS", selectLayouts);
	}
	
	public void saveConfiguration(ActionRequest  req,ActionResponse res) throws ReadOnlyException, PortalException, SystemException, ValidatorException, IOException{
		// Save these settings to preferences
				// long companyId = PortalUtil.getCompanyId(req);
				PortletPreferences prefs = req.getPreferences();

				String layoutPortletId = ParamUtil.getString(req, "layoutPortletId",
						StringPool.BLANK);

				String portletSelectId = ParamUtil.getString(req, "portletSelectId",
						StringPool.BLANK);
				String portionId = ParamUtil.getString(req, "portionId",
						StringPool.BLANK);
				String showMenuContent = ParamUtil.getString(req, "showMenuContent",
						StringPool.BLANK);

				String displayDefaultCat = ParamUtil.getString(req, "categories");

				String defaultShowNews = ParamUtil.getString(req, "defaultShowNews");

				String emailSubject = ParamUtil.getString(req, "emailSubject");

				String emailContent = ParamUtil.getString(req, "emailContent");

				String displayContent = ParamUtil.getString(req, "displayContent");

				String typeId = ParamUtil.getString(req, "typeId", StringPool.BLANK);

				String categoryId = ParamUtil.getString(req, "categoryId",
						StringPool.BLANK);

				// style view

				String defaultStyle = ParamUtil.getString(req, "defaultStyle");

				String tabsStyle = ParamUtil.getString(req, "tabsStyle");

				String stickyStyle = ParamUtil.getString(req, "stickyStyle");

				String typeStyle = ParamUtil.getString(req, "typeStyle");

				int numberOfNews = ParamUtil.getInteger(req, "numberOfNews");

				int displayNews = ParamUtil.getInteger(req, "displayNews");

				int numberArticlesInCat = ParamUtil.getInteger(req,
						"numberArticlesInCat");

				int numberArticlesNextInCat = ParamUtil.getInteger(req,
						"numberArticlesNextInCat");

				int nextNewByNewest = ParamUtil.getInteger(req, "nextNewByNewest");

				int nextNewByOrder = ParamUtil.getInteger(req, "nextNewByOrder");

				int nextNewByInFlow = ParamUtil.getInteger(req, "nextNewByInFlow");

				int articleDisplayInType = ParamUtil.getInteger(req,
						"articleDisplayInType");

				int numberOfStickedNews = ParamUtil.getInteger(req,
						"numberOfStickedNews");

				boolean pagingDisplay = ParamUtil.getBoolean(req, "pagingDisplay");

				boolean isDisplaySendEmail = ParamUtil.getBoolean(req,
						"isDisplaySendEmail");

				boolean isDisplayPrintArticle = ParamUtil.getBoolean(req,
						"isDisplayPrintArticle");

				boolean isDisplayDiscussion = ParamUtil.getBoolean(req,
						"isDisplayDiscussion");

				boolean isDisplayImageNew = ParamUtil.getBoolean(req,
						"isDisplayImageNew");

				int pagingStyle = ParamUtil.getInteger(req, "pagingStyle");

				int displayStyle = ParamUtil.getInteger(req, "displayStyle");
				
				String newestStyle = ParamUtil.getString(req, "newestStyle");

				int columnDisplay = ParamUtil.getInteger(req, "columnDisplay");

				boolean isDisplayDate = ParamUtil.getBoolean(req, "isDisplayDate");

				boolean pagingType = ParamUtil.getBoolean(req, "pagingType");

				// URL Search

				long currentPlid = PortalUtilExt.getPlid(req);

				long plId = 0;

				long groupId = PortalUtilExt.getPortletGroupId(req);

				try {

					plId = PortalUtil.getPlidFromPortletId(groupId, false,
							portletSelectId);

				} catch (Exception ex) {
				}

				HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);
				PortletURL articleURL = PortletURLFactoryUtil.create(httpReq, portletSelectId,
						plId, PortletRequest.ACTION_PHASE);
				articleURL.setParameter("struts_action", "/vcmsviewcontent/view");

				VCMSOpenSearchImpl.URL_PORTLET = articleURL.toString();

				// END

				prefs.setValue(ConstantsExt.NUMBER_OF_NEWS, String
						.valueOf(numberOfNews));

				prefs.setValue(ConstantsExt.DISPLAY_NEWS, String.valueOf(displayNews));

				prefs.setValue(ConstantsExt.NEXT_NEWS_BY_NEWEST, String
						.valueOf(nextNewByNewest));

				prefs.setValue(ConstantsExt.NEXT_NEWS_BY_ORDER, String
						.valueOf(nextNewByOrder));

				prefs.setValue(ConstantsExt.NEXT_NEWS_BY_IN_FLOW, String
						.valueOf(nextNewByInFlow));

				prefs.setValue("numberOfStickedNews", String
						.valueOf(numberOfStickedNews));

				prefs.setValue(ConstantsExt.PAGING_DISPLAY, String
						.valueOf(pagingDisplay));

				prefs.setValue(ConstantsExt.PAGING_STYLE, String.valueOf(pagingStyle));

				prefs
						.setValue(ConstantsExt.DISPLAY_STYLE, String
								.valueOf(displayStyle));

				prefs
						.setValue(ConstantsExt.EMAIL_SUBJECT, String
								.valueOf(emailSubject));

				prefs
						.setValue(ConstantsExt.EMAIL_CONTENT, String
								.valueOf(emailContent));

				prefs.setValue(ConstantsExt.IS_DISPLAY_SEND_EMAIL, String
						.valueOf(isDisplaySendEmail));

				prefs.setValue(ConstantsExt.IS_DISPLAY_PRINT_ARTICLE, String
						.valueOf(isDisplayPrintArticle));

				prefs.setValue("isDisplayImageNew", String.valueOf(isDisplayImageNew));

				prefs.setValue(ConstantsExt.IS_DISPLAY_DISCUSSION_ARTICLE, String
						.valueOf(isDisplayDiscussion));

				prefs.setValue(ConstantsExt.IS_DISPLAY_DEFAULT_CATEGORY,
						displayDefaultCat);

				prefs.setValue(ConstantsExt.LAYOUT_PORTLET_ID, String
						.valueOf(layoutPortletId));

				prefs.setValue(ConstantsExt.PORTLET_SELECTED_ID, String
						.valueOf(portletSelectId));

				prefs.setValue(ConstantsExt.NUMBER_ARTICLES_IN_CAT_DEFAULT, String
						.valueOf(numberArticlesInCat));

				prefs.setValue(ConstantsExt.NUMBER_ARTICLES_NEXT_IN_CAT_DEFAULT, String
						.valueOf(numberArticlesNextInCat));

				prefs.setValue("displayContent", displayContent);

				prefs.setValue("articleDisplayInType", String
						.valueOf(articleDisplayInType));

				prefs.setValue("isDisplayDate", String.valueOf(isDisplayDate));

				prefs.setValue("pagingType", String.valueOf(pagingType));

				prefs.setValue("columnDisplay", String.valueOf(columnDisplay));

				prefs.setValue("portionId", portionId);

				prefs.setValue("showMenuContent", showMenuContent);

				prefs.setValue("defaultShowNews", defaultShowNews);

				prefs.setValue("typeId", typeId);

				prefs.setValue("categoryId", categoryId);

				prefs.setValue("defaultStyle", defaultStyle);

				prefs.setValue("tabsStyle", tabsStyle);

				prefs.setValue("stickyStyle", stickyStyle);

				prefs.setValue("typeStyle", typeStyle);
				
				prefs.setValue("newestStyle", newestStyle);

				prefs.store();
				try {
					selectLayoutPortlet(req);
				} catch (Exception e) {
					// TODO: handle exception
				}
	}
	
	private long getGroupId(PortletRequest req, PortletPreferences prefs) throws PortalException, SystemException {
		long groupId = PortalUtilExt.getPortletGroupId((RenderRequest) req);
		return groupId;
	}

	private String getLanguage(PortletRequest req, PortletPreferences prefs) {
		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		String languageId = themeDisplay.getLanguageId();
		return languageId;
	}

	private int getArrangement(PortletRequest req, PortletPreferences prefs)
			throws Exception {
		int arrangement = GetterUtil.getInteger(prefs.getValue(
				ConstantsExt.ARRANGEMENT, StringPool.BLANK));
		if (arrangement < 1) {
			arrangement = 1;
		}

		return arrangement;

	}

	private int getNumberOfNews(PortletRequest req, PortletPreferences prefs)
			throws Exception {
		int numberOfNews = GetterUtil.getInteger(prefs.getValue(
				ConstantsExt.NUMBER_OF_NEWS, StringPool.BLANK));
		if (numberOfNews < 1) {
			numberOfNews = 5;
		}

		return numberOfNews;

	}

	private int getDisplayNews(PortletRequest req, PortletPreferences prefs)
			throws Exception {
		int displayNews = GetterUtil.getInteger(prefs.getValue(
				ConstantsExt.DISPLAY_NEWS, StringPool.BLANK));
		if (displayNews < 1) {
			displayNews = 1;
		}

		return displayNews;
	}

	private int getNextNewsByNewest(PortletRequest req, PortletPreferences prefs)
			throws Exception {
		int nextNewByNewest = GetterUtil.getInteger(prefs.getValue(
				ConstantsExt.NEXT_NEWS_BY_NEWEST, StringPool.BLANK));
		if (nextNewByNewest < 1) {
			nextNewByNewest = 3;
		}

		return nextNewByNewest;
	}

	private int getNextNewByOrder(PortletRequest req, PortletPreferences prefs)
			throws Exception {
		int nextNewByOrder = GetterUtil.getInteger(prefs.getValue(
				ConstantsExt.NEXT_NEWS_BY_ORDER, StringPool.BLANK));
		if (nextNewByOrder < 1) {
			nextNewByOrder = 3;
		}

		return nextNewByOrder;
	}

	private int getNextNewByInFlow(PortletRequest req, PortletPreferences prefs)
			throws Exception {
		int nextNewByInFlow = GetterUtil.getInteger(prefs.getValue(
				ConstantsExt.NEXT_NEWS_BY_IN_FLOW, StringPool.BLANK));
		if (nextNewByInFlow < 1) {
			nextNewByInFlow = 3;
		}

		return nextNewByInFlow;
	}

	private boolean getPagingDisplay(PortletRequest req,
			PortletPreferences prefs) throws Exception {
		boolean pagingDisplay = GetterUtil.getBoolean(prefs.getValue(
				ConstantsExt.PAGING_DISPLAY, StringPool.BLANK));
		return pagingDisplay;

	}

	private int getPagingStyle(PortletRequest req, PortletPreferences prefs)
			throws Exception {
		int pagingStyle = GetterUtil.getInteger(prefs.getValue(
				ConstantsExt.PAGING_STYLE, StringPool.BLANK));
		if (pagingStyle < 1) {
			pagingStyle = 1;
		}

		return pagingStyle;

	}

	private boolean getStickedNews(PortletRequest req, PortletPreferences prefs)
			throws Exception {
		boolean stickedNews = GetterUtil.getBoolean(prefs.getValue(
				ConstantsExt.STICKED_NEWS, StringPool.BLANK));
		return stickedNews;
	}

	private int getNumberOfStickedNews(PortletRequest req,
			PortletPreferences prefs) throws Exception {
		int numberOfStickedNews = GetterUtil.getInteger(prefs.getValue(
				ConstantsExt.NUMBER_OF_STICKED_NEWS, StringPool.BLANK));
		return numberOfStickedNews;

	}

	private int getDisplayStyle(PortletRequest req, PortletPreferences prefs)
			throws Exception {
		int displayStyle = GetterUtil.getInteger(prefs.getValue(
				ConstantsExt.DISPLAY_STYLE, StringPool.BLANK));
		if (displayStyle < 1) {
			displayStyle = 1;
		}

		return displayStyle;

	}

	private String getCategoryDisplay(PortletRequest req,
			PortletPreferences prefs) throws Exception {
		StringBuffer categoryIds = new StringBuffer();
		String categoryId = prefs.getValue(ConstantsExt.CATEGORY_DISPLAY,
				StringPool.BLANK);
		categoryIds.append(categoryId);
		return categoryIds.toString();

	}

	private boolean getOpenNewTab(PortletRequest req, PortletPreferences prefs)
			throws Exception {
		boolean openNewTab = GetterUtil.getBoolean(prefs.getValue(
				ConstantsExt.OPEN_NEW_TAB, StringPool.BLANK));
		return openNewTab;
	}

	private void displayOverallNews(PortletRequest req, PortletPreferences prefs)
			throws Exception {
		// get info from request or portlet preferences

		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);

		long groupId = getGroupId(req, prefs);
		long companyId = themeDisplay.getCompanyId();

		long statusId = VcmsStatusLocalServiceUtil.getByC_G_A(companyId,
				groupId, true).getStatusId();

		String language = getLanguage(req, prefs);
		boolean stickedNews = getStickedNews(req, prefs);
		int numberOfStickedNews = getNumberOfStickedNews(req, prefs);
		int displayStyle = getDisplayStyle(req, prefs);
		int arrangement = getArrangement(req, prefs);

		// categoryDisplay must have format: id1,number11,number12|id2,number...
		String categoryDisplay = getCategoryDisplay(req, prefs);

		String[] categoryInfoArr = categoryDisplay.split(";");
		String[][] categoryList = new String[categoryInfoArr.length][3];
		for (int i = 0; i < categoryInfoArr.length; i++) {
			String categoryInfo = categoryInfoArr[i];
			if (categoryInfo.length() < 1) {
				continue;
			}
			String[] info = categoryInfo.split(",");
			if (info.length < 3) {
				continue;
			}
			categoryList[i][0] = info[0];// id of category
			categoryList[i][1] = info[1];// number of articles
			categoryList[i][2] = info[2];// number of show-info-articles
		}

		// find sticked news
		if (stickedNews) {
			List stickedArticles = VcmsArticleServiceUtil.getTopNewArticles(
					groupId, language, statusId, true, numberOfStickedNews);
			req
					.setAttribute(ConstantsExt.LIST_STICKED_ARTICLE,
							stickedArticles);
		}

		// find category and articles in it
		List categoryArticleList = new ArrayList();
		for (int i = 0; i < categoryList.length; i++) {
			String categoryId = categoryList[i][0];
			if (Validator.isNull(categoryId)) {
				continue;
			}
			int numberOfArticles = Integer.parseInt(categoryList[i][1]);
			int numberOfShowInfoArticles = Integer.parseInt(categoryList[i][2]);
			try {
				// get category
				VcmsCategory category = VcmsCategoryServiceUtil
						.getCategory(categoryId);
				// get articles in it
				List articleList;

				if (arrangement == 2) {// order by modified date
					articleList = VcmsArticleServiceUtil.getTopNewArticles(
							groupId, language, categoryId, statusId,
							numberOfArticles, VCMSUtil
									.getArticleOrderByComparator(
											"modifiedDate", "desc"));
				} else if (arrangement == 3) {// order by published date
					articleList = VcmsArticleServiceUtil.getTopNewArticles(
							groupId, language, categoryId, statusId,
							numberOfArticles, VCMSUtil
									.getArticleOrderByComparator(
											"publishedDate", "desc"));
				} else {// order by created date
					articleList = VcmsArticleServiceUtil.getTopNewArticles(
							groupId, language, categoryId, statusId,
							numberOfArticles, VCMSUtil
									.getArticleOrderByComparator("createdDate",
											"desc"));
				}

				// if no article, pass to next category
				if (articleList.size() < 1) {
					continue;
				}

				// else, add category and article to result
				// categoryArticle contains 3 object:
				// + [0]: category
				// + [1]: show-intro articles
				// + [2]: link articles
				Object[] categoryArticle = new Object[3];
				categoryArticle[0] = category;
				// if list of article is smaller than number of intro articles:
				if (articleList.size() < numberOfShowInfoArticles) {
					categoryArticle[1] = articleList;
					categoryArticle[2] = new ArrayList();
				} else {// if list of article is smaller than number of articles
					categoryArticle[1] = articleList.subList(0,
							numberOfShowInfoArticles);
					categoryArticle[2] = articleList.subList(
							numberOfShowInfoArticles, articleList.size());
				}
				categoryArticleList.add(categoryArticle);
			} catch (Exception e) {
				continue;
			}
		}

		req.setAttribute(ConstantsExt.LIST_CATEGORY_ARTICLE,
				categoryArticleList);
		req.setAttribute(ConstantsExt.PAGING_STYLE, String
				.valueOf(displayStyle));
	}

	private void displayArticleDetails(PortletRequest req,
			PortletPreferences prefs) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);

		long groupId = getGroupId(req, prefs);
		long companyId = themeDisplay.getCompanyId();

		long statusId = VcmsStatusLocalServiceUtil.getByC_G_A(companyId,
				groupId, true).getStatusId();

		String language = getLanguage(req, prefs);
		int nextOldByOrder = getNextNewByOrder(req, prefs);
		int nextNewByOrder = getNextNewsByNewest(req, prefs);
		int numArticleOfThread = getNextNewByInFlow(req, prefs);

		String categoryId = ParamUtil.getString(req, ConstantsExt.CATEGORY_ID);
		String articleId = ParamUtil.getString(req, ConstantsExt.ARTICLE_ID);
		List listCat = VcmsCARelationServiceUtil
				.getRelationsByArticle(articleId);

		VcmsCategory category = null;

		if (Validator.isNotNull(categoryId)) {
			category = VcmsCategoryServiceUtil.getCategory(categoryId);

		} else {

			if (Validator.isNotNull(listCat) && listCat.size() > 0) {
				for (int i = 0; i < listCat.size(); i++) {
					VcmsCARelation CARel = (VcmsCARelation) listCat.get(0);
					category = VcmsCategoryServiceUtil.getCategory(CARel
							.getCategoryId());
				}
			}

		}

		// get article
		VcmsArticle article = VcmsArticleServiceUtil.getArticle(articleId);

		// get older articles
		List olderArticles = VcmsArticleServiceUtil
				.getOlderArticles(groupId, language, null, categoryId,
						articleId, statusId, nextOldByOrder);
		// get news articles
		List newArticles = VcmsArticleServiceUtil
				.getNewArticles(groupId, language, null, categoryId, articleId,
						statusId, nextNewByOrder);

		// get articles of thread
		List threadArticles = VcmsTARelationServiceUtil
				.getRelationsByArticle(articleId);

		List articleOfThread = new ArrayList();

		String threadId = "";

		for (int i = 0; i < threadArticles.size(); i++) {
			VcmsTARelation VcmsTA = (VcmsTARelation) threadArticles.get(0);
			threadId = VcmsTA.getThreadId();

			articleOfThread = (List) VcmsArticleServiceUtil
					.getArticlesInThread(groupId, language, threadId, statusId,
							numArticleOfThread);
		}

		req.setAttribute(ConstantsExt.CATEGORY, category);
		req.setAttribute(ConstantsExt.ARTICLE, article);
		req.setAttribute(ConstantsExt.LIST_NEXT_OLDER_ARTICLE, olderArticles);
		req.setAttribute(ConstantsExt.LIST_NEXT_NEWEST_ARTICLE, newArticles);
		req.setAttribute(ConstantsExt.LIST_ARTICLE_OF_THREAD, articleOfThread);

	}

	private void displayCategoryDetails(PortletRequest req,
			PortletPreferences prefs) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);

		long groupId = getGroupId(req, prefs);
		long companyId = themeDisplay.getCompanyId();

		long statusId = VcmsStatusLocalServiceUtil.getByC_G_A(companyId,
				groupId, true).getStatusId();

		String language = getLanguage(req, prefs);
		int arrangement = getArrangement(req, prefs);
		int numberOfNews = getNumberOfNews(req, prefs);
		int displayNews = getDisplayNews(req, prefs);
		boolean openNewTab = getOpenNewTab(req, prefs);
		boolean pagingDisplay = getPagingDisplay(req, prefs);
		int pagingStyle = getPagingStyle(req, prefs);

		String categoryId = ParamUtil.getString(req, ConstantsExt.CATEGORY_ID);
		if (Validator.isNotNull(categoryId)) {
			Object[] categoryArticle = new Object[3];
			List categoryArticleList = new ArrayList();
			List articleList;

			VcmsCategory category = VcmsCategoryServiceUtil
					.getCategory(categoryId);
			if (arrangement == 2) {// order by modified date
				articleList = VcmsArticleServiceUtil.getTopNewArticles(groupId,
						language, categoryId, statusId, numberOfNews, VCMSUtil
								.getArticleOrderByComparator("modifiedDate",
										"desc"));
			} else if (arrangement == 3) {// order by published date
				articleList = VcmsArticleServiceUtil.getTopNewArticles(groupId,
						language, categoryId, statusId, numberOfNews, VCMSUtil
								.getArticleOrderByComparator("publishedDate",
										"desc"));
			} else {// order by created date
				articleList = VcmsArticleServiceUtil.getTopNewArticles(groupId,
						language, categoryId, statusId, numberOfNews, VCMSUtil
								.getArticleOrderByComparator("createdDate",
										"desc"));
			}

			// categoryArticle contains 3 object:
			// + [0]: category
			// + [1]: show-intro articles
			// + [2]: link articles
			categoryArticle[0] = category;
			// if list of article is smaller than number of intro articles:
			if (articleList.size() < displayNews) {
				categoryArticle[1] = articleList;
				categoryArticle[2] = new ArrayList();
			} else {// if list of article is smaller than number of articles
				categoryArticle[1] = articleList.subList(0, displayNews);
				categoryArticle[2] = articleList.subList(displayNews,
						articleList.size());
			}
			categoryArticleList.add(categoryArticle);

			req.setAttribute(ConstantsExt.PAGING_STYLE,
					new Integer(pagingStyle));
			req
					.setAttribute(ConstantsExt.OPEN_NEW_TAB, new Boolean(
							openNewTab));
			req.setAttribute(ConstantsExt.PAGING_DISPLAY, new Boolean(
					pagingDisplay));
			req.setAttribute(ConstantsExt.LIST_CATEGORY_ARTICLE,
					categoryArticleList);
		}
	}

	private void updateDiscussion(ActionRequest req) throws Exception {
		String discussionId = ParamUtil.get(req, "discussionId",
				StringPool.BLANK);

		String visitorName = ParamUtil
				.get(req, "visitorName", StringPool.BLANK);
		String visitorEmail = ParamUtil.get(req, "visitorEmail",
				StringPool.BLANK);
		String visitorPhone = ParamUtil.get(req, "visitorPhone",
				StringPool.BLANK);
		boolean approved = ParamUtil.getBoolean(req, "approved");
		String articleId = ParamUtil.get(req, "articleId", StringPool.BLANK);
		String title = ParamUtil.get(req, "title", StringPool.BLANK);
		String content = ParamUtil.get(req, "content", StringPool.BLANK);
		long groupId = ParamUtil.getLong(req, "groupId");
		String language = ParamUtil.get(req, "language", StringPool.BLANK);

		long companyId = PortalUtil.getCompanyId(req);

		// Welform discussion content
		content = HtmlExt.welform(content, false);

		VcmsDiscussion discussion = null;

		if (Validator.isNull(discussionId)) {
			discussion = VcmsDiscussionServiceUtil.addDiscussion(visitorName,
					visitorEmail, visitorPhone, groupId, companyId, articleId,
					title, content, false, language, true, true);
		} else {
			discussion = VcmsDiscussionServiceUtil.getDiscussion(discussionId);
			discussion = VcmsDiscussionServiceUtil.updateDiscussion(
					discussionId, visitorName, visitorEmail, visitorPhone,
					groupId, companyId, articleId, title, content, discussion
							.getHasAttachment(), approved, language);
		}

		boolean hasAttachment = false;

		String portletId = WebKeysExt.VCMS;
		AttachmentUtil attachment = new AttachmentUtil();

		attachment.addFile(req,PortalUtil.getUploadPortletRequest(req), portletId, VcmsDiscussion.class, Long
				.parseLong(discussion.getDiscussionId()),0,StringPool.BLANK);

		List addedAttachments = attachment.getAttachment(VcmsDiscussion.class,
				Long.parseLong(discussion.getDiscussionId()));

		hasAttachment = ((addedAttachments != null) && (addedAttachments.size() > 0));

		if (hasAttachment) {
			discussion.setHasAttachment(true);
			VcmsDiscussionServiceUtil.updateDiscussion(discussion);
		}

	}
	
	private void updateHits(int hitIncrease) throws Exception {
		try {
			
			Date date = new Date();
			AccessCounterServiceUtil.updateCounter(PortalUtil.getDefaultCompanyId(), date, hitIncrease);
		} catch (NoSuchAccessCounterException nac) {
			AccessCounterServiceUtil.addCounter(PortalUtil.getDefaultCompanyId(), hitIncrease);
		}		
	}
}
