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
package com.vportal.portlet.vclip.util;

import java.util.List;

import com.liferay.portal.NoSuchLayoutException;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutConstants;
import com.liferay.portal.model.LayoutTypePortlet;
import com.liferay.portal.service.LayoutLocalServiceUtil;

public class WebKeysVClip {

	public static final String IS_CLIP_MENU = "isClipMenu";

	public static final String CLIP_TYPE = "clipType";
	public static final String CLIP_TYPE_RESULT_SEARCH = "clip_type_result";
	public static final String CLIP_TYPE_ID = "clipTypeId";

	public static final String CLIP = "clip";
	public static final String CLIP_RESULT_SEARCH = "clip_result";
	public static final String CLIP_ID = "clipId";
	public static final String OBJECT = "object";
	public static final String VCLIP = "vclip";
	public static final String VCLIP_LIST_ATTACHMENT = "list_attechment";
	public static final String CONTENT_PORTLET = "vclipcontent";
	public static final String HITCOUNT = "hitCount";
	public static final String HITCOUNTVIEW = "hitCountView";
	public static final String LIST_TOP_CLIP = "list_Top_Clip";
	public static final String Clip_type_id = "vclip_WAR_vclipportlet";

	public static long getPLId(long groupId, String portletName)
			throws Exception {
		return getPLId(groupId, portletName, false);
	}

	public static long getPLId(long groupId, String portletName,
			boolean privateLayout) throws Exception {
		List layouts = LayoutLocalServiceUtil
				.getLayouts(groupId, privateLayout);

		for (int i = 0; i < layouts.size(); i++) {
			Layout layout = (Layout) layouts.get(i);

			if (!layout.getType().equals(LayoutConstants.TYPE_PORTLET)) {
				continue;
			}

			LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet) layout
					.getLayoutType();

			if (layoutTypePortlet.hasPortletId(portletName)) {
				return layout.getPlid();
			}
		}

		throw new NoSuchLayoutException("FindClipAction No public -->");

	}
}
