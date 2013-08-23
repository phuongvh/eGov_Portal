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

package com.vportal.portlet.vcms.util;

import java.rmi.RemoteException;
import java.text.Normalizer;
import java.util.Map;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.BaseFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.vportal.portlet.vcms.model.VcmsArticle;
import com.vportal.portlet.vcms.model.VcmsCategory;
import com.vportal.portlet.vcms.service.VcmsArticleServiceUtil;
import com.vportal.portlet.vcms.service.VcmsCategoryServiceUtil;
import com.vportal.portlet.vcms.util.PortletKeysExt;

public class VCMSFriendlyURLMapper extends BaseFriendlyURLMapper {

	public String buildPath(LiferayPortletURL portletURL) {
		// TODO Auto-generated method stub

		String friendlyURLPath = null;

		String portletId = portletURL.getPortletId();

		VcmsArticle article = null;
		VcmsCategory category = null;
		try {

			String articleId = GetterUtil.getString(
					portletURL.getParameter("articleId"), "0");
			String categoryId = GetterUtil.getString(
					portletURL.getParameter("categoryId"), "0");

			if (!Validator.equals(articleId, "0")
					|| !Validator.equals(categoryId, "0")) {

				if (portletId.equals(_PORTLET_DEFAULT_INSTANCE)) {
					portletId = _PORTLET_ID;
				}

				String[] arrInstance = StringUtil.split(portletId, "_");

				// friendlyURLPath = "/vcmsviewcontent/" + arrInstance[2];

				friendlyURLPath = StringPool.FORWARD_SLASH + getMapping()
						+ StringPool.FORWARD_SLASH + arrInstance[4];

				portletURL.addParameterIncludedInPath("p_p_id");
				portletURL.addParameterIncludedInPath("p_p_lifecycle");
				// portletURL.addParameterIncludedInPath("p_p_state");// k co
				// portletURL.addParameterIncludedInPath("p_p_mode");// k co
				portletURL.addParameterIncludedInPath("p_p_col_id");
				portletURL.addParameterIncludedInPath("p_p_col_count");
				portletURL.addParameterIncludedInPath("p_p_col_pos");
				portletURL.addParameterIncludedInPath("jspPage");

				if (!categoryId.equalsIgnoreCase("0")) {
					friendlyURLPath += StringPool.FORWARD_SLASH + categoryId;
					portletURL.addParameterIncludedInPath("categoryId");
				}

				if (!articleId.equalsIgnoreCase("0")) {
					friendlyURLPath += StringPool.FORWARD_SLASH + articleId;
					portletURL.addParameterIncludedInPath("articleId");
				}

				if (!articleId.equalsIgnoreCase("0")) {
					article = VcmsArticleServiceUtil.getArticle(articleId);
					friendlyURLPath += StringPool.FORWARD_SLASH
							+ Normalizer
									.normalize(article.getTitle(),
											Normalizer.Form.NFD)
									.replaceAll("[^\\p{ASCII}]", "")
									// .replaceAll("-", "")									
//									.replaceAll(" ", "-")									
									.replaceAll("[^a-zA-Z0-9-]", "-")
									.replaceAll("-{2,}", "-")
									.toLowerCase() + ".html";
				}

				if (!categoryId.equalsIgnoreCase("0") && articleId.equalsIgnoreCase("0")) {
					category = VcmsCategoryServiceUtil.getCategory(categoryId);
					friendlyURLPath += StringPool.FORWARD_SLASH
							+ Normalizer
									.normalize(category.getName(),
											Normalizer.Form.NFD)
									.replaceAll("[^\\p{ASCII}]", "")
									// .replaceAll("-", "")
//									.replaceAll("\\b\\s{1,}\\b", "-")
									.replaceAll("[^a-zA-Z0-9-]", "-")
									.replaceAll("-{2,}", "-")
									.toLowerCase() + ".html";
				}
			}

		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return friendlyURLPath;
	}

	public void populateParams(String friendlyURLPath,
			Map<String, String[]> params, Map<String, Object> arg2) {
		// TODO Auto-generated method stub
		String[] arrURL = friendlyURLPath.split("/");

		String portletId = PortletKeysExt.VCMSVIEWCONTENT + "_INSTANCE_"
				+ arrURL[2];

		String namespace = StringPool.UNDERLINE + portletId
				+ StringPool.UNDERLINE;

		params.put("p_p_id", new String[] { portletId });
		params.put("p_p_state", new String[] { WindowState.NORMAL.toString() });
		params.put("p_p_lifecycle", new String[] { "0" });
		params.put("p_p_mode", new String[] { PortletMode.VIEW.toString() });

		for (int i = 3; i < arrURL.length; i++) {
			if (i == 3) {
				
				params.put(namespace + "categoryId", new String[] { arrURL[3] });
			} else if (i == 4) {
				if (Validator.isNumber(arrURL[4])) {
					params.put(namespace + "articleId",
							new String[] { arrURL[4] });
				}
			}
		}

	}

	public String getMapping() {
		return _MAPPING;
	}

	public String getPortletId() {
		return _PORTLET_ID;
	}

	public boolean isCheckMappingWithPrefix() {
		return _CHECK_MAPPING_WITH_PREFIX;
	}

	private static final String LIFECYCLE_RENDER = "0";

	private static final String LIFECYCLE_ACTION = "1";

	private static final String LIFECYCLE_RESOURCE = "2";

	private static final boolean _CHECK_MAPPING_WITH_PREFIX = true;

	private static final String _MAPPING = "vcmsviewcontent";

	private static final String _PORTLET_DEFAULT_INSTANCE = PortletKeysExt.VCMSVIEWCONTENT
			+ "_INSTANCE_0000";

	private static final String _PORTLET_ID = PortletKeysExt.VCMSVIEWCONTENT;
}
