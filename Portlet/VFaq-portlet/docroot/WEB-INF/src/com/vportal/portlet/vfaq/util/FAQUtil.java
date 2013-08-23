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

package com.vportal.portlet.vfaq.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.vportal.portlet.vfaq.model.FAQCategory;
import com.vportal.portlet.vfaq.model.impl.FAQCategoryImpl;

public class FAQUtil {
	/**
	 * Ham nhan vao mot list cac group, sau do sap xep chung theo thu tu
	 * cha-con.
	 * 
	 * @param listGroup
	 *            List cac group can truyen vao
	 * @return Tra ve mot List cac group da duoc sap xep, bo sung them group co
	 *         ten la ROOT
	 */
	public static List sort(List listGroup) {
		// add the root of category to the list
		FAQCategory category = new FAQCategoryImpl();
		category.setId(0);
		category.setParent(0);
		listGroup.add(0, category);

		List sortedList = new ArrayList();
		int maxGroupId = 0;
		// sort the list
		for (int i = 0; i < listGroup.size(); i++) {
			FAQCategory node = (FAQCategory) listGroup.get(i);
			int groupItemId = (int) node.getId();
			if (groupItemId > maxGroupId) {
				maxGroupId = groupItemId;
			}
		}
		String[] mark = new String[maxGroupId + 1];
		DFS(sortedList, mark, listGroup, 0);
		sortedList.remove(0);

		return sortedList;
	}

	/**
	 * Ham tim nut con cua mot nut
	 * 
	 * @param tree
	 *            Cay k-phan
	 * @param parentId
	 *            ID cua nut cha
	 * @return danh sach cac nut con cua nut cha
	 */
	private static List findChildNodes(List tree, int parentId) {
		List childNodes = new ArrayList();

		for (int i = 1; i < tree.size(); i++) {
			FAQCategory parent = (FAQCategory) tree.get(i);
			if (parent.getParent() == parentId) {
				childNodes.add(tree.get(i));
			}
		}

		return childNodes;
	}

	/**
	 * Ham tim kiem theo chieu sau
	 * 
	 * @param result
	 *            ket qua tra ve cua ham
	 * @param mark
	 *            dung de danh dau, truyen vao 1 mang String binh thuong
	 * @param tree
	 *            cay K-phan
	 * @param u
	 *            chi so cua nut cha
	 */
	private static void DFS(List result, String[] mark, List tree, int u) {
		FAQCategory currentNode = findByGroupId(tree, u);
		List childNodes = findChildNodes(tree, (int) currentNode.getId());
		mark[u] = "grey";
		result.add(currentNode);

		for (int i = 0; i < childNodes.size(); i++) {
			FAQCategory node = (FAQCategory) childNodes.get(i);
			String currentColor = mark[(int) node.getId()];
			if (currentColor == null) {
				DFS(result, mark, tree, (int) node.getId());
			}
		}
		mark[u] = "black";
	}

	/**
	 * ham tim kiem group trong 1 tree dua theo group_id
	 * 
	 * @param tree
	 *            cay K-phan
	 * @param groupId
	 *            group_id cua group can tim
	 * @return tra ve group neu tim thay va tra ve null neu khong tim thay
	 */
	private static FAQCategory findByGroupId(List tree, int groupId) {
		for (int i = 0; i < tree.size(); i++) {
			FAQCategory node = (FAQCategory) tree.get(i);
			if ((int) node.getId() == groupId) {
				return node;
			}
		}
		return null;
	}

	/**
	 * Dinh dang hien thi giua parent-child. Cac group la child se thut vao so
	 * voi group la cha 1 don vi bang " - "
	 * 
	 * @param tree
	 *            danh sach group cha va con, da sap xep thu tu
	 * @return tra ve 1 danh sach da duoc dinh dang
	 */
	public static List formatByLevel(List tree) {
		int[] level = new int[tree.size()];
		List result = new ArrayList();
		for (int i = 0; i < tree.size() - 1; i++) {
			FAQCategory currentCategory = (FAQCategory) tree.get(i);
			for (int j = 0; j < tree.size(); j++) {
				FAQCategory testedCategory = (FAQCategory) tree.get(j);
				if (testedCategory.getParent() == (int) currentCategory.getId()) {
					level[j] = level[i] + 1;
				}
			}
		}
		String minus = "- ";
		for (int i = 0; i < tree.size(); i++) {
			String back = "";
			for (int j = 0; j < level[i]; j++) {
				back += minus;
			}
			FAQCategory dept = (FAQCategory) tree.get(i);
			String name = dept.getName();
			name = back + name;
			dept.setName(name);
			result.add(dept);
		}
		return result;
	}

	/**
	 * Generate the random prefix.<br />
	 * Copied from: com.vportal.portlet.newsadmin.utils.NewsUtils
	 * 
	 * @return The random prefix
	 */

	public static String getRandPrefix() {
		Calendar c = Calendar.getInstance();
		String curTime = String.valueOf(c.getTimeInMillis());
		if (Validator.isNotNull(curTime) && curTime.length() > 23) {
			curTime = curTime.substring(10, 23);
		}
		return curTime;
	}

	/**
	 * Ham phan tich ngay thang<br />
	 * Copied from com.vportal.portlet.edirectory.util.EDirectoryUtil
	 * 
	 * @param date
	 *            Ngay thang can phan tich
	 * @return Dang dd/MM/yyyy cua ngay thang nhap vao
	 */
	public static String dateParser(Date date) {
		if (date == null) {
			return "";
		}
		Calendar cal = Calendar.getInstance();
		String dateStr = "";
		cal.setTime(date);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		dateStr = day + "/" + month + "/" + year;
		return dateStr;
	}

	/**
	 * Ham chuyen 1 xau sang ngay thang<br />
	 * Copied from com.vportal.portlet.edirectory.util.EDirectoryUtil
	 * 
	 * @param date
	 *            Xau chua ngay thang, co dang: dd/MM/yyyy
	 * @return Doi tuong ngay thang
	 */
	public static Date dateParser(String date) {
		try {
			SimpleDateFormat result = new SimpleDateFormat("dd/MM/yyyy");
			Date newDate = result.parse(date);
			return newDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean isValidRole(ActionRequest req) {
		// ThemeDisplay themeDisplay = (ThemeDisplay) req
		// .getAttribute(WebKeys.THEME_DISPLAY);
		// themeDisplay.getUser().getUserId();
		// String userId = PortalUtil.getUserId(req);
		// if (RoleChecker.isEditor(userId) ||
		// RoleChecker.isAdministrator(userId)
		// || RoleChecker.isGeneralEditor(userId)
		// || RoleChecker.isWriter(userId)) {
		// return true;
		// }
		// return false;
		return true;
	}

	public static void setLanguageAndLocale(RenderRequest req) {
		// set attribute
		Locale[] locales = LanguageUtil.getAvailableLocales();
		String portalSiteId = ParamUtil.getString(req, "portalSiteId");
		String language = ParamUtil.getString(req, "language");
		req.setAttribute("locales", locales);
		req.setAttribute("portalSiteId", portalSiteId);
		req.setAttribute("language", language);
	}

	public static String trimString(String str, int length) {
		try {
			StringBuffer buff = new StringBuffer();
			int index = str.indexOf(" ", length);
			buff.append(str.substring(0, index));
			buff.append("...");
			return buff.toString();
		} catch (StringIndexOutOfBoundsException e) {
			return str;
		}
	}
	
	public static PermissionChecker getPermissionChecker() throws PrincipalException {
		PermissionChecker permissionChecker =
			PermissionThreadLocal.getPermissionChecker();

		if (permissionChecker == null) {
			throw new PrincipalException("PermissionChecker not initialized");
		}

		return permissionChecker;
	}
}
