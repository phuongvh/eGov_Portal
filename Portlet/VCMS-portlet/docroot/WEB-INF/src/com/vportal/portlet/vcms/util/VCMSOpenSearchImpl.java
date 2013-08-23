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

package com.vportal.portlet.vcms.util;


import javax.servlet.http.HttpServletRequest;

import com.vportal.portal.search.HitsOpenSearchImpl;
import com.vportal.portlet.vcms.service.VcmsArticleServiceUtil;
import com.liferay.portal.kernel.search.Hits;

/**
 * @author 
 * @version 1.0.00, Jul 14, 2008
 * @version 1.1.00, Dec 17, 2012
 */

public class VCMSOpenSearchImpl extends HitsOpenSearchImpl {
	public static final String SEARCH_PATH = "/c/vcms/open_search";
	public static String URL_PORTLET = "";
	public static final String TITLE = "VCMS Search: ";

	public Hits getHits(
			HttpServletRequest req,long companyId,long groupId, String keywords, int start, int end)
		throws Exception {
		return VcmsArticleServiceUtil.search(req,companyId,groupId,Long.parseLong("0"), keywords, start, end);		
	}
	
	public String getSearchPath() {
		return SEARCH_PATH;
	}

	public String getTitle(String keywords) {
		return TITLE + keywords;
	}

	@Override
	public String getPortletId() {
		return PortletKeysVCMS.VCMS;
		//return "vcms";
	}
	
	
}