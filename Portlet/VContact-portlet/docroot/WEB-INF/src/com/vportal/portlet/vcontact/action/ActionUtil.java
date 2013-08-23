package com.vportal.portlet.vcontact.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.vportal.portal.service.AttachmentLocalServiceUtil;
import com.vportal.portlet.vcontact.model.VContact;
import com.vportal.portlet.vcontact.service.VContactServiceUtil;
import com.vportal.portlet.vcontact.util.ActionKeyExt;

public class ActionUtil {
	public static void getContact(ActionRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);

		getContact(httpReq);
	}

	public static void getContact(RenderRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);

		getContact(httpReq);
	}

	public static void getContact(HttpServletRequest req) throws Exception {

		long Id = ParamUtil.getLong(req, "Id");

		VContact contact = null;

		if (Id > 0) {

			contact = VContactServiceUtil.getContact(Id);
		}
		req.setAttribute("contact", contact);
	}

	public static void getAttachmentList(ActionRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);
		getAttachmentList(httpReq);
	}

	public static void getAttachmentList(RenderRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);
		getAttachmentList(httpReq);
	}

	public static void getAttachmentList(HttpServletRequest req)
			throws Exception {

		String Id = ParamUtil.getString(req, "Id");

		if (Validator.isNull(Id)) {
			return;
		}

		List listAttachment = AttachmentLocalServiceUtil.getAttachments(Long
				.parseLong(Id), VContact.class);

		if (listAttachment == null) {
			listAttachment = new ArrayList();
		}

		req.setAttribute(ActionKeyExt.VCONTACT_LIST_ATTACHMENT,
				"listAttachment");
	}

}
