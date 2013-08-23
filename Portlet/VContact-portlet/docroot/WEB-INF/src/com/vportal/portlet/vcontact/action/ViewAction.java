package com.vportal.portlet.vcontact.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.vportal.portlet.vcontact.model.VContact;
import com.vportal.portlet.vcontact.service.VContactServiceUtil;

/**
 * Portlet implementation class ViewAction
 */
public class ViewAction extends MVCPortlet {
 
	public void _delete(ActionRequest req, ActionResponse rep) {
		String[] Ids = StringUtil.split(ParamUtil.getString(req, "Ids"));
		for (int i = 0; i < Ids.length; i++) {
			try {
				VContactServiceUtil.deleteContact(Long.parseLong(Ids[i]));
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void _update(ActionRequest req, ActionResponse rep) throws Exception {
		String Id = ParamUtil.getString(req, "Id");
		int status = ParamUtil.getInteger(req, "status");
		VContact contact = VContactServiceUtil.getContact(Long.parseLong(Id));
		contact.setStatus(status);
		VContactServiceUtil.updateContact(contact);
	}

	public void _delete(ActionRequest req) throws Exception {

		String[] Ids = StringUtil.split(ParamUtil.getString(req, "Ids"));
		for (int i = 0; i < Ids.length; i++) {
			try {
				VContactServiceUtil.deleteContact(Long.parseLong(Ids[i]));
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
	}
}
