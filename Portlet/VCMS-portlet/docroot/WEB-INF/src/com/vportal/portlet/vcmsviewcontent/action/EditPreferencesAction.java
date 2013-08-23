
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

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.vportal.portal.util.PortalUtilExt;
import com.vportal.portlet.vcms.util.VCMSOpenSearchImpl;
import com.vportal.portlet.vcmsview.util.ConstantsExt;
import com.vportal.portlet.vcmsviewcontent.util.LayoutPortletUtil;

public class EditPreferencesAction implements ConfigurationAction{

	public void processAction(PortletConfig portletConfig,
			ActionRequest req, ActionResponse res)
			throws Exception {
		// TODO Auto-generated method stub
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

				HttpServletRequest httpReq =PortalUtil.getHttpServletRequest(req);

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

				prefs.store();
				try {
					selectLayoutPortlet(req);
				} catch (Exception e) {
					// TODO: handle exception
				}/*

				sendRedirect(req, res);*/
	}

	public String render(PortletConfig portletConfig,
			RenderRequest req, RenderResponse renderResponse)
			throws Exception {
		// TODO Auto-generated method stub
		selectLayoutPortlet(req);
		return null;
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
				"vcmsviewcontent_INSTANCE_");

		req.setAttribute("SELECT_LAYOUTS", selectLayouts);
	}
	
	
}
