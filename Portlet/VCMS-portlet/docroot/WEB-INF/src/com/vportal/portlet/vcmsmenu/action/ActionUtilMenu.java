
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

package com.vportal.portlet.vcmsmenu.action;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.security.permission.PermissionChecker;
import com.vportal.portal.kernel.security.permission.ActionKeysExt;
import com.vportal.portlet.vcms.model.VcmsCategory;
import com.vportal.portlet.vcms.model.VcmsPortion;
import com.vportal.portlet.vcms.service.VcmsCategoryServiceUtil;
import com.vportal.portlet.vcms.service.VcmsPortionServiceUtil;
import com.vportal.portlet.vcms.service.permission.VcmsCategoryPermission;
import com.vportal.portlet.vcms.service.permission.VcmsPortionPermission;

public class ActionUtilMenu {

	public static final String DEFAULT_CATEGORY_ID = "0";

	public static String getCategoryTree(long groupId, String language,
			String parentId, String categoryId) throws SystemException,
			PortalException, Exception {

		StringBuffer sb = new StringBuffer();

		List categories = new ArrayList();

		sb.append("<div>");
		try {
			categories = VcmsCategoryServiceUtil.getCategoriesByParent(groupId,
					parentId, language);

		} catch (Exception ex) {
			System.err.println(ex);
		}

		sb.append("</div>");
		int indent = 2;

		return sb.toString();
	}

	public static String getCategoryTree(long groupId, String language,
			String portletNamespace, PermissionChecker permissionChecker) {

		StringBuffer sb = new StringBuffer();
		
		try {
			List portions = VcmsPortionServiceUtil.getPortionsByS_L(groupId,
					language);

			if ((portions == null) || (portions.size() <= 0)) {
				return null;
			}

			for (int j = 0; j < portions.size(); j++) {
				VcmsPortion portion = (VcmsPortion) portions.get(j);

				if (VcmsPortionPermission.contains(permissionChecker, portion,
						ActionKeysExt.MANAGE_CATEGORIES_PORTION)) {

					sb.append("<tr>");
					sb.append("<td width=\"100%\" valign=\"middle\" ");
					sb
							.append(portion.getCategorizable() ? "style=\"font-color: #F1F1f1\">"
									: ">");
					sb.append(StringPool.NBSP);
					sb.append(StringPool.NBSP);
					sb.append("<input type=\"radio\" name=\"");
					sb.append(portletNamespace + "portion\" ");
					sb.append("value=\"" + portion.getPortionId() + "\" ");
					sb.append(" />");
					sb.append("<b>").append(portion.getName()).append("</b>");
					sb.append("</td>");
					sb.append("</tr>");

					if (!portion.getCategorizable()) {
						continue;
					}

					List categories = VcmsCategoryServiceUtil
							.getCategoriesByP_P(portion.getGroupId(), portion
									.getPortionId(), DEFAULT_CATEGORY_ID,
									language);

					if ((categories == null) || (categories.size() <= 0)) {
						continue;
					}

					int indent = 2;
					traverseCategoryTree2(sb, categories, indent,
							portletNamespace, permissionChecker);
				}
			}
		} catch (Exception ex) {
			// Ignore ...
		}
		// }
		return sb.toString();
	}
   public static String getCategory(List categories,String portletNamespace,
			PermissionChecker permissionChecker)throws SystemException,
			PortalException {
	   StringBuffer sb = new StringBuffer();
	   traverseCategoryTree2(sb,categories,2,portletNamespace,permissionChecker);
	   return sb.toString();
   }
	private static void traverseCategoryTree2(StringBuffer sb, List categories,
			int indent, String portletNamespace,
			PermissionChecker permissionChecker) throws SystemException,
			PortalException {

		if ((categories == null) || (categories.size() <= 0)) {
			return;
		}

		for (int i = 0; i < categories.size(); i++) {
			VcmsCategory category = (VcmsCategory) categories.get(i);

			if (VcmsCategoryPermission.contains(permissionChecker, category,
					ActionKeysExt.ADD_ARTICLES_CATEGORY)) {

				sb.append("<tr>");
				sb.append("<td width=\"100%\" valign=\"middle\" ");
				sb
						.append(category.getAnchored() ? "style=\"font-color: #F1F1f1\" >"
								: ">");
				for (int j = 0; j < indent; j++) {
					sb.append(StringPool.NBSP);
				}
				sb.append("<input type=\"checkbox\" name=\"");
				sb.append(portletNamespace + "category\" id=\"");
				sb.append(portletNamespace + "category_"
						+ category.getCategoryId() + "\" ");
				sb.append("value=\"" + category.getCategoryId() + "\" ");
				sb.append(" />");
				sb.append("<label for=\"");
				sb.append(portletNamespace + "category_"
						+ category.getCategoryId() + "\" >");
				sb.append(category.getName());
				sb.append("</label>");
				sb.append("</td>");
				sb.append("<td>");
				// if(category.getParentId().equals("0")){
				sb.append("<select id=\"" + portletNamespace + "select_style_menu_"
						+ category.getCategoryId() + "\">");
						sb.append("<option id=\"" + portletNamespace + "options_select_style_menu_0_"
								+ category.getCategoryId() + "\" value=\"0\">");
						sb.append("</option>");
//						if(arrCategoriesStyle[i].equals("1")){
//							sb.append("<option value=\"1\" selected >Style1");	
//						}else{
							sb.append("<option id=\"" + portletNamespace + "options_select_style_menu_1_"
								+ category.getCategoryId() + "\" value=\"1\">Style1");
						//}
						
						sb.append("</option>");
				sb.append("</select>");
				// }
				sb.append("</td>");
				sb.append("</tr>");

				if (category.getAnchored()) {
					// continue;
				}

				try {
					traverseCategoryTree2(sb, VcmsCategoryServiceUtil
							.getCategoriesByParent(category.getGroupId(),
									category.getCategoryId(), category
											.getLanguage()), (indent + 2),
							portletNamespace, permissionChecker);
				} catch (Exception ex) {
					// Ignore ...
				}
			}
		}
	}
}
