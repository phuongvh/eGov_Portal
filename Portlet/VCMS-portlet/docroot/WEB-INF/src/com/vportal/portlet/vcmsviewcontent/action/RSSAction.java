/**
 * Copyright (c) Vietsoftware, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.vportal.portlet.vcmsviewcontent.action;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.util.RSSUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.vportal.portlet.vcms.service.VcmsCategoryServiceUtil;

/**
 * <a href="RSSAction.java.html"><b><i>View Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class RSSAction extends MVCPortlet {

	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		try {
			HttpServletRequest request = PortalUtil
					.getHttpServletRequest(actionRequest);
			HttpServletResponse response = PortalUtil
					.getHttpServletResponse(actionResponse);

			ServletResponseUtil.sendFile(response, null, getRSS(request),
					ContentTypes.TEXT_XML_UTF8);

		} catch (Exception e) {
			PortalUtil.sendError(e, actionRequest, actionResponse);
		}
	}
	

	protected byte[] getRSS(HttpServletRequest request) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		Layout layout = themeDisplay.getLayout();

		long plid = ParamUtil.getLong(request, "p_l_id");
		long companyId = ParamUtil.getLong(request, "companyId");
		long groupId = ParamUtil.getLong(request, "groupId");
		String categoryId = ParamUtil.getString(request, "categoryId", "0");
		String portletSelectId = ParamUtil.getString(request,
				"portletSelectId", "0");
		long organizationId = ParamUtil.getLong(request, "organizationId");
		int max = ParamUtil.getInteger(request, "max",
				SearchContainer.DEFAULT_DELTA);
		String type = ParamUtil
				.getString(request, "type", RSSUtil.ATOM);
		double version = ParamUtil.getDouble(request, "version",
				RSSUtil.VERSION_DEFAULT);
		String displayStyle = ParamUtil.getString(request, "displayStyle",
				RSSUtil.DISPLAY_STYLE_FULL_CONTENT);

		String feedURL = themeDisplay.getURLPortal()
				+ themeDisplay.getPathMain() + "/vcmsviewcontent/view?";

		String entryURL = feedURL;

		String rss = StringPool.BLANK;

		if (layout != null) {
			groupId = layout.getGroupId();			
			PortletURL rssURL = PortletURLFactoryUtil.create(request, portletSelectId,
					plid, PortletRequest.RENDER_PHASE);
			rssURL.setParameter("struts_action", "/vcmsviewcontent/view");
			rssURL.setParameter("categoryId", categoryId);
			rssURL.setParameter("cat_parent", categoryId);
			feedURL = rssURL.toString();

			entryURL = feedURL;

			rss = VcmsCategoryServiceUtil.getCategoriesByRSS(categoryId, 5,
					type, version, displayStyle, entryURL, entryURL, 5,
					themeDisplay);
		}
		return rss.getBytes(StringPool.UTF8);
	}

	private static Log _log = LogFactoryUtil.getLog(RSSAction.class);

}