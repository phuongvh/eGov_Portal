package com.vportal.portlet.vcontactview;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.vportal.portal.service.AttachmentLocalServiceUtil;
import com.vportal.portal.taglib.FileUploadUtil;
import com.vportal.portlet.vcontact.model.VContact;
import com.vportal.portlet.vcontact.model.impl.VContactImpl;
import com.vportal.portlet.vcontact.service.VContactServiceUtil;
import com.vportal.portal.util.PortletKeysExt;

public class ViewAction extends MVCPortlet {
	public void _add(ActionRequest req, ActionResponse rep) throws Exception {

		UploadPortletRequest uploadReq = PortalUtil
				.getUploadPortletRequest(req);
		long Id = ParamUtil.getLong(uploadReq, "Id");
		long groupId = ParamUtil.getLong(uploadReq, "groupId");
		long companyId = PortalUtil.getCompanyId(req);
		String guestName = ParamUtil.getString(uploadReq, "guestName");
		String email = ParamUtil.getString(uploadReq, "email");
		String phone = ParamUtil.getString(uploadReq, "phone");
		String fax = ParamUtil.getString(uploadReq, "fax");
		String address = ParamUtil.getString(uploadReq, "address");
		String title = ParamUtil.getString(uploadReq, "title");
		String content = ParamUtil.getString(uploadReq, "content");
		//String validatorCaptcha = ParamUtil.get(uploadReq, "validatorCaptcha", "");
		String captchaTextEntered = ParamUtil.getString(uploadReq, "validatorCaptcha");
		//String s [] = uploadReq.getParameterValues("captchaText");

		boolean checkCapcha = checkCaptcha(req, uploadReq, captchaTextEntered);
		boolean hasAttach = false;
		int status = 0;

		String[] communityPermissions = uploadReq
				.getParameterValues("communityPermissions");
		String[] guestPermissions = uploadReq
				.getParameterValues("guestPermissions");

		ThemeDisplay themeDisplay = (ThemeDisplay) uploadReq
				.getAttribute(WebKeys.THEME_DISPLAY);
		Layout layout = themeDisplay.getLayout();
		long userId = themeDisplay.getUserId();
		
		//boolean bChechCaptcha = checkCaptcha(req, uploadReq);
		if(checkCapcha)
		{
			VContact contact = new VContactImpl();
	
			if (Id <= 0) {
	
				contact = VContactServiceUtil.addContact(groupId, companyId,
						layout.getPlid(), guestName, email, title, address, phone,
						fax, content, hasAttach, status, userId,
						communityPermissions, guestPermissions);
	
				_attachFile(contact, req ,uploadReq);
			}
		}
	}

	// Attach File
	public void _attachFile(VContact contact, ActionRequest req ,UploadPortletRequest uploadRequest)
			throws Exception {
		if (contact != null) {

			String portletId = PortletKeysExt.VCONTACT;

			/*AttachmentManager am = new AttachmentManager(portletId,
					VContact.class, contact.getId());

			am.addFile(req);*/
			
			 FileUploadUtil.uploadFile(req, uploadRequest, portletId, VContact.class, contact.getId(), GetterUtil.getLong(0), StringPool.BLANK);
			 
			 List addedAttachments = AttachmentLocalServiceUtil.getAttachments(contact.getId(), VContact.class);
			if (Validator.isNull(addedAttachments)) {
				contact.setHasAttach(true);

				VContactServiceUtil.updateContact(contact);
			}
		}
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		try {
			com.liferay.portal.kernel.captcha.CaptchaUtil.serveImage(
					resourceRequest, resourceResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean checkCaptcha(PortletRequest request,
			   UploadPortletRequest uploadReq, String enteredCaptchaText) throws Exception {
			  
			  PortletSession session = request.getPortletSession();
			  String captchaText = getCaptchaValueFromSession(session);
			  if (Validator.isNull(captchaText)) {
			   SessionMessages.add(request,
			     "Internal Error! Captcha text not found in session");
			   SessionErrors.add(request, "error-captcha");
			   return false;
			  }
			  if (!captchaText.equals(enteredCaptchaText)) {
			   SessionMessages.add(request,
			     "Internal Error! Captcha text not found in session");
			   SessionErrors.add(request, "error-captcha");
			   return false;
			  }
			  return true;
	}

	public String getCaptchaValueFromSession(PortletSession session) {
		Enumeration<String> atNames = session.getAttributeNames();
		while (atNames.hasMoreElements()) {
			String name = atNames.nextElement();
			if (name.contains("CAPTCHA_TEXT")) {
				return (String) session.getAttribute(name);
			}
		}
		return null;
	}

	public void _savePreferences(ActionRequest req, ActionResponse res)
			throws Exception {

		try {

			boolean isPhone = ParamUtil.getBoolean(req, "isPhone");
			boolean isFax = ParamUtil.getBoolean(req, "isFax");
			boolean isAddress = ParamUtil.getBoolean(req, "isAddress");
			boolean isAttach = ParamUtil.getBoolean(req, "isAttach");
			boolean isTyping = ParamUtil.getBoolean(req, "isTyping");
			boolean isCodeActive = ParamUtil.getBoolean(req, "isCodeActive");

			String styleTitle = ParamUtil.getString(req, "styleTitle");
			String styleBorder = ParamUtil.getString(req, "styleBorder");
			String styleBullet = ParamUtil.getString(req, "styleBullet");
			String styleContent = ParamUtil.getString(req, "styleContent");

			String themeType = ParamUtil.getString(req, "themeType");
			String themeSelected = ParamUtil.getString(req, "themeSelected");

			String style = ParamUtil.getString(req, "style");
			String numberAtt = ParamUtil.getString(req, "numberAtt");
			String title = ParamUtil.getString(req, "title");
			String titlePortlet = ParamUtil.getString(req, "titlePortlet");

			PortletPreferences prefs = req.getPreferences();

			prefs.setValue("isPhone", String.valueOf(isPhone));
			prefs.setValue("isFax", String.valueOf(isFax));
			prefs.setValue("isAddress", String.valueOf(isAddress));
			prefs.setValue("isAttach", String.valueOf(isAttach));
			prefs.setValue("isTyping", String.valueOf(isTyping));
			prefs.setValue("isCodeActive", String.valueOf(isCodeActive));
			prefs.setValue("style", style);
			prefs.setValue("numberAtt", numberAtt);
			prefs.setValue("title", title);
			prefs.setValue("titlePortlet", titlePortlet);

			prefs.setValue("styleTitle", styleTitle);
			prefs.setValue("styleBorder", styleBorder);
			prefs.setValue("styleBullet", styleBullet);
			prefs.setValue("styleContent", styleContent);

			prefs.setValue("themeType", themeType);
			prefs.setValue("themeSelected", themeSelected);

			prefs.store();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
