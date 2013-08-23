
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

package com.vportal.portlet.vcmsview.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutConstants;
import com.liferay.portal.model.LayoutTypePortlet;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.vportal.portlet.vcms.util.WebKeysExt;
import com.vportal.portlet.vcmsview.util.ConstantsExt;

public class EditPreferencesAction implements ConfigurationAction {

	public void processAction(PortletConfig portletConfig,
			ActionRequest req, ActionResponse res)
			throws Exception {
		// TODO Auto-generated method stub
		String cmd = ParamUtil.getString(req, Constants.CMD);

		if (!cmd.equals(Constants.UPDATE)) {
			return;
		}

		PortletPreferences prefs = req.getPreferences();

		int arrangement = getArrangement(req, prefs);
		int numberOfNews = getNumberOfNews(req, prefs);
		int displayNews = getDisplayNews(req, prefs);
		int nextNewByNewest = getNextNewsByNewest(req, prefs);
		int nextNewByOrder = getNextNewByOrder(req, prefs);
		int nextNewByInFlow = getNextNewByInFlow(req, prefs);
		boolean pagingDisplay = getPagingDisplay(req, prefs);
		int pagingStyle = getPagingStyle(req, prefs);
		boolean stickedNews = getStickedNews(req, prefs);
		int numberOfStickedNews = getNumberOfStickedNews(req, prefs);
		int displayStyle = getDisplayStyle(req, prefs);
		long openNewTab = getOpenNewTab(req, prefs);
		String categoryDisplay = getCategoryDisplay(req, prefs);

		prefs.setValue(ConstantsExt.ARRANGEMENT, String.valueOf(arrangement));
		prefs.setValue(ConstantsExt.NUMBER_OF_NEWS, String
				.valueOf(numberOfNews));
		prefs.setValue(ConstantsExt.DISPLAY_NEWS, String.valueOf(displayNews));
		prefs.setValue(ConstantsExt.NEXT_NEWS_BY_NEWEST, String
				.valueOf(nextNewByNewest));
		prefs.setValue(ConstantsExt.NEXT_NEWS_BY_ORDER, String
				.valueOf(nextNewByOrder));
		prefs.setValue(ConstantsExt.NEXT_NEWS_BY_IN_FLOW, String
				.valueOf(nextNewByInFlow));
		prefs.setValue(ConstantsExt.PAGING_DISPLAY, String
				.valueOf(pagingDisplay));
		prefs.setValue(ConstantsExt.PAGING_STYLE, String.valueOf(pagingStyle));
		prefs.setValue(ConstantsExt.STICKED_NEWS, String.valueOf(stickedNews));
		prefs.setValue(ConstantsExt.NUMBER_OF_STICKED_NEWS, String
				.valueOf(numberOfStickedNews));
		prefs
				.setValue(ConstantsExt.DISPLAY_STYLE, String
						.valueOf(displayStyle));
		prefs.setValue(ConstantsExt.OPEN_NEW_TAB, String.valueOf(openNewTab));
		prefs.setValue(ConstantsExt.CATEGORY_DISPLAY, categoryDisplay);

		prefs.store();

		res.sendRedirect(ParamUtil.getString(req, "redirect"));
	}

	public String render(PortletConfig portletConfig,
			RenderRequest req, RenderResponse res)
			throws Exception {
		// TODO Auto-generated method stub
		PortletPreferences prefs = req.getPreferences();

		int arrangement = getArrangement(req, prefs);
		int numberOfNews = getNumberOfNews(req, prefs);
		int displayNews = getDisplayNews(req, prefs);
		int nextNewByNewest = getNextNewsByNewest(req, prefs);
		int nextNewByOrder = getNextNewByOrder(req, prefs);
		int nextNewByInFlow = getNextNewByInFlow(req, prefs);
		boolean pagingDisplay = getPagingDisplay(req, prefs);
		int pagingStyle = getPagingStyle(req, prefs);
		boolean stickedNews = getStickedNews(req, prefs);
		int numberOfStickedNews = getNumberOfStickedNews(req, prefs);
		long openNewTab = getOpenNewTab(req, prefs);
		List layoutList = getLayoutList(req, prefs);
		int displayStyle = getDisplayStyle(req, prefs);
		// categoryDisplay must have format: id1,number11,number12;id2,number...
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
			categoryList[i][1] = info[1];// number of show-info-article
			categoryList[i][2] = info[2];// number of link-article
		}

		// arrangement: sap xep tin
		// numberOfNews: tong so tin khi xem tung chuyen muc
		// displayNews: so tin hien thi intro
		// nextNews...: cac tin tiep theo dc lay ra theo tieu chi...
		// pagingDisplay: true neu hien thi phan trang
		// pagingStyle: cach hien thi phan trang
		// stickedNew: true neu co tin treo dau trang
		// numberOfStickedNews: so luong tin treo dau trang
		// displayStyle: cach hien thi
		// categoryDisplay: cac khu vuc/chuyen muc dc hien thi
		req.setAttribute(ConstantsExt.ARRANGEMENT, new Integer(arrangement));
		req
				.setAttribute(ConstantsExt.NUMBER_OF_NEWS, new Integer(
						numberOfNews));
		req.setAttribute(ConstantsExt.DISPLAY_NEWS, new Integer(displayNews));
		req.setAttribute(ConstantsExt.NEXT_NEWS_BY_NEWEST, new Integer(
				nextNewByNewest));
		req.setAttribute(ConstantsExt.NEXT_NEWS_BY_ORDER, new Integer(
				nextNewByOrder));
		req.setAttribute(ConstantsExt.NEXT_NEWS_BY_IN_FLOW, new Integer(
				nextNewByInFlow));
		req.setAttribute(ConstantsExt.PAGING_DISPLAY,
				new Boolean(pagingDisplay));
		req.setAttribute(ConstantsExt.PAGING_STYLE, new Integer(pagingStyle));
		req.setAttribute(ConstantsExt.STICKED_NEWS, new Boolean(stickedNews));
		req.setAttribute(ConstantsExt.NUMBER_OF_STICKED_NEWS, new Integer(
				numberOfStickedNews));
		req.setAttribute(ConstantsExt.DISPLAY_STYLE, new Integer(displayStyle));
		req.setAttribute(ConstantsExt.OPEN_NEW_TAB, new Long(openNewTab));
		req.setAttribute(ConstantsExt.CATEGORY_DISPLAY, categoryList);
		req.setAttribute(ConstantsExt.LIST_LAYOUT, layoutList);
		
		return null;
	}
	
	private int getArrangement(PortletRequest req, PortletPreferences prefs)
			throws Exception {
		int arrangement = ParamUtil.getInteger(req, ConstantsExt.ARRANGEMENT);
		if (arrangement < 1) {
			arrangement = GetterUtil.getInteger(prefs.getValue(
					ConstantsExt.ARRANGEMENT, StringPool.BLANK));
		}
		if (arrangement < 1) {
			arrangement = 1;
		}
		return arrangement;

	}

	private int getNumberOfNews(PortletRequest req, PortletPreferences prefs)
			throws Exception {
		int numberOfNews = ParamUtil.getInteger(req,
				ConstantsExt.NUMBER_OF_NEWS);
		if (numberOfNews < 1) {
			numberOfNews = GetterUtil.getInteger(prefs.getValue(
					ConstantsExt.NUMBER_OF_NEWS, StringPool.BLANK));
		}
		if (numberOfNews < 1) {
			numberOfNews = 5;
		}
		return numberOfNews;

	}

	private int getDisplayNews(PortletRequest req, PortletPreferences prefs)
			throws Exception {
		int displayNews = ParamUtil.getInteger(req, ConstantsExt.DISPLAY_NEWS);
		if (displayNews < 1) {
			displayNews = GetterUtil.getInteger(prefs.getValue(
					ConstantsExt.DISPLAY_NEWS, StringPool.BLANK));
		}
		if (displayNews < 1) {
			displayNews = 3;
		}
		return displayNews;

	}

	private int getNextNewsByNewest(PortletRequest req, PortletPreferences prefs)
			throws Exception {
		int nextNewByNewest = ParamUtil.getInteger(req,
				ConstantsExt.NEXT_NEWS_BY_NEWEST);
		if (nextNewByNewest < 1) {
			nextNewByNewest = GetterUtil.getInteger(prefs.getValue(
					ConstantsExt.NEXT_NEWS_BY_NEWEST, StringPool.BLANK));
		}
		if (nextNewByNewest < 1) {
			nextNewByNewest = 3;
		}
		return nextNewByNewest;

	}

	private int getNextNewByOrder(PortletRequest req, PortletPreferences prefs)
			throws Exception {
		int nextNewByOrder = ParamUtil.getInteger(req,
				ConstantsExt.NEXT_NEWS_BY_ORDER);
		if (nextNewByOrder < 1) {
			nextNewByOrder = GetterUtil.getInteger(prefs.getValue(
					ConstantsExt.NEXT_NEWS_BY_ORDER, StringPool.BLANK));
		}
		if (nextNewByOrder < 1) {
			nextNewByOrder = 3;
		}
		return nextNewByOrder;

	}

	private int getNextNewByInFlow(PortletRequest req, PortletPreferences prefs)
			throws Exception {
		int nextNewByInFlow = ParamUtil.getInteger(req,
				ConstantsExt.NEXT_NEWS_BY_IN_FLOW);
		if (nextNewByInFlow < 1) {
			nextNewByInFlow = GetterUtil.getInteger(prefs.getValue(
					ConstantsExt.NEXT_NEWS_BY_IN_FLOW, StringPool.BLANK));
		}
		if (nextNewByInFlow < 1) {
			nextNewByInFlow = 3;
		}

		return nextNewByInFlow;

	}

	private boolean getPagingDisplay(PortletRequest req,
			PortletPreferences prefs) throws Exception {
		String param = req.getParameter(ConstantsExt.PAGING_DISPLAY);

		boolean pagingDisplay = false;

		if (req instanceof ActionRequest) {
			pagingDisplay = Validator.isNotNull(param) ? true : false;
		} else if (req instanceof RenderRequest) {
			pagingDisplay = GetterUtil.getBoolean(prefs.getValue(
					ConstantsExt.PAGING_DISPLAY, StringPool.BLANK));
		}

		return pagingDisplay;
	}

	private int getPagingStyle(PortletRequest req, PortletPreferences prefs)
			throws Exception {
		int pagingStyle = ParamUtil.getInteger(req, ConstantsExt.PAGING_STYLE);
		if (pagingStyle < 1) {
			pagingStyle = GetterUtil.getInteger(prefs.getValue(
					ConstantsExt.PAGING_STYLE, StringPool.BLANK));
		}
		if (pagingStyle < 1) {
			pagingStyle = 1;
		}

		return pagingStyle;

	}

	private boolean getStickedNews(PortletRequest req, PortletPreferences prefs)
			throws Exception {

		String param = req.getParameter(ConstantsExt.STICKED_NEWS);

		boolean stickedNews = false;

		if (req instanceof ActionRequest) {
			stickedNews = Validator.isNotNull(param) ? true : false;
		} else if (req instanceof RenderRequest) {
			stickedNews = GetterUtil.getBoolean(prefs.getValue(
					ConstantsExt.STICKED_NEWS, StringPool.BLANK));
		}

		return stickedNews;
	}

	private int getNumberOfStickedNews(PortletRequest req,
			PortletPreferences prefs) throws Exception {
		int numberOfStickedNews = ParamUtil.getInteger(req,
				ConstantsExt.NUMBER_OF_STICKED_NEWS);
		if (numberOfStickedNews < 1) {
			numberOfStickedNews = GetterUtil.getInteger(prefs.getValue(
					ConstantsExt.NUMBER_OF_STICKED_NEWS, StringPool.BLANK));
		}
		return numberOfStickedNews;

	}

	private int getDisplayStyle(PortletRequest req, PortletPreferences prefs)
			throws Exception {
		int displayStyle = ParamUtil
				.getInteger(req, ConstantsExt.DISPLAY_STYLE);
		if (displayStyle < 1) {
			displayStyle = GetterUtil.getInteger(prefs.getValue(
					ConstantsExt.DISPLAY_STYLE, StringPool.BLANK));
		}
		if (displayStyle < 1) {
			displayStyle = 1;
		}

		return displayStyle;

	}

	private long getOpenNewTab(PortletRequest req, PortletPreferences prefs)
			throws Exception {

		long openNewTab = ParamUtil.getLong(req, ConstantsExt.OPEN_NEW_TAB);

		if (openNewTab < 1) {
			openNewTab = GetterUtil.getInteger(prefs.getValue(
					ConstantsExt.OPEN_NEW_TAB, StringPool.BLANK));
		}

		return openNewTab;
	}

	private String getCategoryDisplay(PortletRequest req,
			PortletPreferences prefs) throws Exception {
		StringBuffer categoryIds = new StringBuffer();
		String[] categoryIdArr = req
				.getParameterValues(ConstantsExt.CATEGORY_ID);
		if (categoryIdArr == null) {
			String categoryId = prefs.getValue(ConstantsExt.CATEGORY_DISPLAY,
					StringPool.BLANK);
			categoryIds.append(categoryId);
		} else {
			for (int i = 0; i < categoryIdArr.length; i++) {
				categoryIds.append(categoryIdArr[i]);
				categoryIds.append(",");
				String articleText = ParamUtil.getString(req,
						ConstantsExt.ARTICLE_TEXT_ + categoryIdArr[i]);
				if (Validator.isNull(articleText)) {
					articleText = ConstantsExt.DEFAULT_ARTICLE_TEXT;
				}
				categoryIds.append(articleText);
				categoryIds.append(",");
				String articleNoText = ParamUtil.getString(req,
						ConstantsExt.ARTICLE_NO_TEXT_ + categoryIdArr[i]);
				if (Validator.isNull(articleNoText)) {
					articleNoText = ConstantsExt.DEFAULT_ARTICLE_NO_TEXT;
				}
				categoryIds.append(articleNoText);
				categoryIds.append(";");
			}
		}
		return categoryIds.toString();

	}

	private List getLayoutList(PortletRequest req, PortletPreferences prefs)
			throws Exception {
		boolean privateLayout = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		
		long groupId = PortalUtil.getScopeGroupId(req);
		long currentPlId = themeDisplay.getPlid();
		
		String portletId = WebKeysExt.VCMS_VIEW_CONTENT;

		// get current portlet layout
		Layout currentLayout = LayoutLocalServiceUtil.getLayout(currentPlId);
		
		privateLayout = currentLayout.getPrivateLayout();
		
		// find portlet in layout
		List layouts = LayoutLocalServiceUtil
				.getLayouts(groupId, privateLayout);
		List layoutList = new ArrayList();


		for (int i = 0; i < layouts.size(); i++) {
			Layout layout = (Layout) layouts.get(i);
			
			//layout.get
			if (!layout.getType().equals(LayoutConstants.TYPE_PORTLET)) {
				continue;
			}

			LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet) layout
					.getLayoutType();
			
						
			if (layoutTypePortlet.hasPortletId(portletId)) {
				layoutList.add(layout);
			}
		}

		return layoutList;
	}
}
