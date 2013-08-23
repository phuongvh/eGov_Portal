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
package com.vportal.portlet.vclipcontent;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;

import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.vportal.portlet.vclip.model.Clip;
import com.vportal.portlet.vclip.service.ClipServiceUtil;
import com.vportal.portlet.vclip.service.ClipTypeServiceUtil;
import com.vportal.portlet.vclip.util.WebKeysVClip;
import com.vportal.portlet.viewvclip.util.ConstantsExt;

/**
 * Portlet implementation class VclipContentAction
 */
public class VclipContentAction extends MVCPortlet {

	@Override
	public void processAction(ActionRequest req, ActionResponse res)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		String cmd = ParamUtil.getString(req, Constants.CMD);
		String id = ParamUtil.getString(req, "clipId");
		try {
			if (cmd.equals(ConstantsExt.HITCOUNT)) {
				ClipServiceUtil.increaseHitCount(id);
			}
			if (cmd.equals(ConstantsExt.HITCOUNTVIEW)) {
				ClipServiceUtil.increaseHitCountView(id);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		res.setRenderParameter("jspPage", "/html/portlet/vclipcontent/view.jsp");
		super.processAction(req, res);
	}

	@Override
	public void render(RenderRequest req, RenderResponse res)
			throws PortletException, IOException {
		try {
			PortletPreferences prefs = req.getPreferences();
			String style = prefs.getValue("displayStyle", "1");

			if (style.equals("1")) {
				viewStyle1(req);
			} else {
				viewStyle2(req);
			}
		} catch (Exception e) {
		}

		super.render(req, res);
	}

	public void viewStyle1(RenderRequest req) throws Exception {
		String clipId = ParamUtil.getString(req, "clipId");
		String clipTypeId = ParamUtil.getString(req, WebKeysVClip.CLIP_TYPE_ID);

		if (Validator.isNotNull(clipId)) {
			Clip clipBean = (Clip) ClipServiceUtil.findById(clipId);
			req.setAttribute(WebKeysVClip.CLIP, clipBean);
		}

		if (Validator.isNotNull(clipTypeId)) {
			List clipListByType = (List) ClipServiceUtil
					.findByClipTypeId(clipTypeId);
			req.setAttribute("clipList", clipListByType);
		} else {
			List clipList = ClipServiceUtil.getAll();
			req.setAttribute("clipList", clipList);
		}
	}

	public void viewStyle2(RenderRequest req) throws Exception {
		List clipTypeList = ClipTypeServiceUtil.findAll();
		List clipList = null;
		Clip clipBean = null;

		String clipTypeId = ParamUtil.getString(req, "selectedType");
		String selectedClipId = ParamUtil.getString(req, "selectedClipId");

		if (Validator.isNotNull(clipTypeId)) {
			clipList = (List) ClipServiceUtil.findByClipTypeId(clipTypeId);
		} else {
			clipList = ClipServiceUtil.getAll();
		}

		if (Validator.isNotNull(selectedClipId)) {
			clipBean = (Clip) ClipServiceUtil.findById(selectedClipId);
		}

		req.setAttribute("clipTypeList", clipTypeList);
		req.setAttribute("clipList", clipList);
		req.setAttribute("clipBean", clipBean);
	}

	protected boolean isCheckMethodOnProcessAction() {
		return false;
	}

	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;

	public void EditPreferenceAction(ActionRequest req, ActionResponse res) {
		String cmd = ParamUtil.getString(req, Constants.CMD);
		if (!cmd.equals(Constants.UPDATE)) {
			return;
		}
		PortletPreferences prefs = req.getPreferences();
		// getPreferences
		String displayStyle = ParamUtil.getString(req, "displayStyle");
		String allowDescription = ParamUtil.getString(req, "allowDescription");
		String allowDownload = ParamUtil.getString(req, "allowDownload");
		String displayClipNumber = ParamUtil
				.getString(req, "displayClipNumber");
		// setPreferences

		try {
			prefs.setValue("displayStyle", displayStyle);
			prefs.setValue("allowDescription", allowDescription);
			prefs.setValue("allowDownload", allowDownload);
			prefs.setValue("displayClipNumber", displayClipNumber);

			prefs.store();

		} catch (ReadOnlyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ValidatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		res.setRenderParameter("jspPage", "/html/portlet/vclipcontent/view.jsp");
	}
}
