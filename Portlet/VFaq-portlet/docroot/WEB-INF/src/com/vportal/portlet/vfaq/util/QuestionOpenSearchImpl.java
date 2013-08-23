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

/*package com.vportal.portlet.vfaq.util;


import javax.portlet.PortletURL;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.search.HitsOpenSearchImpl;
import com.liferay.portal.theme.ThemeDisplay;
import com.vportal.portal.util.PortletKeysExt;
import com.vportal.portlet.vfaq.service.FAQQuestionServiceUtil;

public class QuestionOpenSearchImpl extends HitsOpenSearchImpl {
	public static final String SEARCH_PATH = "/c/faq/open_search";

	public static final String TITLE = "Liferay FAQ Search: ";

	public Hits getHits(
			long companyId, String keywords, int start, int end)
		throws Exception {

		return FAQQuestionServiceUtil.search(companyId, 0, 0, keywords, start, end);
	}

	public String getSearchPath() {
		return SEARCH_PATH;
	}

	public String getTitle(String keywords) {
		return TITLE + keywords;
	}
}
*/