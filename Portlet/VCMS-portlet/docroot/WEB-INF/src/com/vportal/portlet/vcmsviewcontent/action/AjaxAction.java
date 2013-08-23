
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

/*package com.vportal.portlet.vcmsviewcontent.action;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.vportal.portlet.vcms.model.VcmsArticle;
import com.vportal.portlet.vcms.service.VcmsArticleServiceUtil;
import com.vportal.portlet.vcmsview.util.ConstantsExt;
import com.vportal.util.MailUtil;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

*//**
 * @author donghh
 * @version 1.0.0
 * @since 14/06/2008
 *//*

public class AjaxAction extends MVCPortlet{

	@Override
	public void processAction(ActionRequest req,
			ActionResponse res) throws IOException, PortletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
		HttpServletResponse response = PortalUtil.getHttpServletResponse(res);
			
		String strJSON = getJSON(mapping,form,request,response);

	}
	@Override
	public void render(RenderRequest req, RenderResponse res)
			throws PortletException, IOException {
		// TODO Auto-generated method stub
		String categoryId = ParamUtil.getString(req, "categoryId");
		String articleNumber = ParamUtil.getString(req,"articleNumber");
		if(Validator.isNotNull(categoryId)){
			req.setAttribute(categoryId, "categoryId");
			req.setAttribute(articleNumber, "articleNumber");
		}
	}
	
	public String getJSON(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
				
		String cmd = ParamUtil.getString(req,"cmd");
		
		System.out.println("CMD = "+cmd);
		
		JSONObject json = new JSONObject();
		if(Validator.isNotNull(cmd) && Validator.equals(cmd,"sent_to_friend")){
			_sentToFriend(req,json);
		}
		
		return json.toString();
	}
	
	private JSONObject _sentToFriend(HttpServletRequest req, JSONObject json) throws Exception{
		
		String articleId = ParamUtil.getString(req,"articleId");
		String pathArticle = ParamUtil.getString(req,"pathArticle");
		
		String toname = ParamUtil.getString(req,"toname");
		String toaddress = ParamUtil.getString(req,"toaddress");
		String fromname = ParamUtil.getString(req,"fromname");
		String fromaddress = ParamUtil.getString(req,"fromaddress");
		String content = ParamUtil.getString(req,"content");
		
		String status = "";
		
		//Send mail...
		ThemeDisplay themeDisplay = (ThemeDisplay) req
		.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId = themeDisplay.getCompanyId();

		if(Validator.isNotNull(articleId) && Validator.isNotNull(toname) && Validator.isNotNull(fromname)&& 
				Validator.isNotNull(toaddress)&& Validator.isNotNull(fromaddress)&&
				_validate(toname,fromname,toaddress,fromaddress)){
			
			VcmsArticle article = (VcmsArticle)VcmsArticleServiceUtil.getArticle(articleId);
			
			String emailSubject = PrefsPropsUtil.getContent(companyId,
					ConstantsExt.EMAIL_SUBJECT);
			
			String emailContent = PrefsPropsUtil.getContent(companyId,
					ConstantsExt.EMAIL_CONTENT);

			String linkArticle =  "<a href=\"" + pathArticle + "\">" + article.getTitle() + 
			"<img border=\"0\" src=\"" + PortalUtil.getPortalURL(req) + "/image/images?img_id=" + article.getImage() +"\" hspace=\"3\" vspace=\"3\" />" +
			"</a>" + article.getLead();  
			
			String linkPortalURL = "<a href=\"" + PortalUtil.getPortalURL(req)+ "\">" + PortalUtil.getPortalURL(req) + "</a>";
			
			emailSubject = StringUtil.replace(emailSubject, "[$FROM_NAME$]",fromname);
			emailContent = StringUtil.replace(emailContent, new String[] {
					"[$TO_NAME$]", "[$PORTAL_URL$]", "[$MESSAGE$]",
					"[$FROM_NAME$]","[$ARTICLE_LINK$]"}, new String[] {
					toname, linkPortalURL ,
					content, fromname,linkArticle});
			
			
			InternetAddress emailFrom = new InternetAddress(fromaddress);
			emailFrom.setPersonal(fromname);

			InternetAddress emailTo = new InternetAddress(toaddress);
			emailTo.setPersonal(toname);

			boolean htmlFormat = true;
			MailUtil.send(emailFrom, emailTo, emailSubject, emailContent,
					htmlFormat);
			
			status = "true";
		}else{
			
			status = "false";
		}
		
		json.put("status", status);
		
		return json;
		
	}
	
	private boolean _validate(String toname,String fromname,String toemail,String fromemail){
		if(Validator.isNull(toname)||Validator.isNull(fromname)||Validator.isNull(toemail)||Validator.isNull(fromemail)){
			return false;
		}else{
			if(_validateFormatEmail(toemail) == false){
				return false;
			}
			if(_validateFormatEmail(fromemail) == false){
				return false;
			}			
		}
		
		return true;
	}
	
	private boolean _validateFormatEmail(String email){
			boolean matchFound = false;
		
			Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
			// Match the given string with the pattern
			Matcher m = p.matcher(email);

			// check whether match is found
			matchFound = m.matches();
		
			return matchFound;
	}

}
*/