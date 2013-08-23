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

package com.vportal.portlet.vfile.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.prefs.Preferences;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liferay.portal.kernel.dao.search.ResultRow;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.dao.search.SearchEntry;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.vportal.portlet.vcalendar.model.VCal;
import com.vportal.portlet.vcalendar.model.VFile;
import com.vportal.portlet.vcalendar.service.VCalServiceUtil;
import com.vportal.portlet.vcalendar.service.VFileServiceUtil;

/**
 * Portlet implementation class VFileAction
 */
public class VFileAction extends MVCPortlet {

	public void addVFile(ActionRequest req , ActionResponse rep) throws Exception {
		Layout layout = (Layout)req.getAttribute(WebKeys.LAYOUT);
		long fileId = ParamUtil.getLong(req, "fileId");
		String fullname = ParamUtil.getString(req, "fullname");
		String phone = ParamUtil.getString(req, "phone");
		String address = ParamUtil.getString(req, "address");
		String position = ParamUtil.getString(req, "position");
		int dateMonth = ParamUtil.getInteger(req, "dateMonth");
		int dateDay = ParamUtil.getInteger(req, "dateDay");
		int dateYear = ParamUtil.getInteger(req, "dateYear");
		Date birthday = new Date(Integer.toString(dateMonth+1)+"/"+dateDay+"/"+dateYear);					
		Long groupId = PortalUtil.getScopeGroupId(layout.getPlid());
		int status = groupId.intValue();	
		VFileServiceUtil.addVFile(fullname, phone, address, position, birthday, status);
		String path = ParamUtil.getString(req, "redirect");
		rep.sendRedirect(path);
	}
	
	public void updateVFile(ActionRequest req ,ActionResponse rep) throws Exception {
		Layout layout = (Layout)req.getAttribute(WebKeys.LAYOUT);
		long fileId = ParamUtil.getLong(req, "fileId");
		String fullname = ParamUtil.getString(req, "fullname");
		String phone = ParamUtil.getString(req, "phone");
		String address = ParamUtil.getString(req, "address");
		String position = ParamUtil.getString(req, "position");
		int dateMonth = ParamUtil.getInteger(req, "dateMonth");
		int dateDay = ParamUtil.getInteger(req, "dateDay");
		int dateYear = ParamUtil.getInteger(req, "dateYear");
		Date birthday = new Date(Integer.toString(dateMonth+1)+"/"+dateDay+"/"+dateYear);
		Long groupId = PortalUtil.getScopeGroupId(layout.getPlid());
		int status = groupId.intValue();
		VFileServiceUtil.updateVFile(fileId,fullname, phone, address, position, birthday, status);
	}
	public void deleteVFile(ActionRequest req ,ActionResponse rep) throws Exception {
		long fileId = ParamUtil.getLong(req, "fileId");
		List<VCal>  listCalFile = VCalServiceUtil.findByF(fileId);
		for (VCal vCal : listCalFile) {
			VCalServiceUtil.deletevCal(vCal.getCalId());
		}
		VFileServiceUtil.deleteVFile(fileId);
	}

	/* Hien Thi Danh Sach Lanh Dao
	 * (non-Javadoc)
	 * @see javax.portlet.GenericPortlet#render(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	/*@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		String language = ParamUtil.getString(request, "language", "vi_VN");
		PortletURL portletURL = response.createRenderURL();
		 
		List headerNames = new ArrayList();
		headerNames.add("vfile.name");
		headerNames.add("vfile.position");
		headerNames.add("vfile.phone");
		headerNames.add("vfile.address");
		headerNames.add("vfile.birthdate");
		headerNames.add(StringPool.BLANK);
		SearchContainer searchContainer = new SearchContainer(request, null, null, SearchContainer.DEFAULT_CUR_PARAM, 
				SearchContainer.DEFAULT_DELTA, portletURL, headerNames, "there are no leader in this system");			 
		// tham so truyen vao Searchcontainer:
		// portletRequest, display term, display term, current result page, number of result per page, portletURL, header names, empty message
		//List results = VFileServiceUtil.findByAll(0, VFileServiceUtil.countAll());
		try {
			//ServletContext application = 

			HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(request);
			HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(response);
			ServletContext servletContext = httpRequest.getSession().getServletContext();
			List results = VFileServiceUtil.findByAll(searchContainer.getStart(), searchContainer.getEnd());
			searchContainer.setResults(results);
			searchContainer.setTotal(results.size());
			List resultRows = searchContainer.getResultRows();
			for(int i=0; i<results.size(); i++){
				VFile vfile = (VFile)results.get(i);
				ResultRow row = new ResultRow(vfile, vfile.getFileId(), i);
				row.addText(vfile.getFullname());
				row.addText(vfile.getPosition());
				row.addText(vfile.getPhone());
				row.addText(vfile.getAddress());
				row.addText(vfile.getBirthday().toString());
				row.addJSP("right",SearchEntry.DEFAULT_VALIGN,"/docroot/html/portlet/vfile/button_file.jsp",servletContext,httpRequest,httpResponse);
				resultRows.add(row);
				httpRequest.setAttribute("allLeader", searchContainer);
			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.render(request, response);
	}
	*/
	
	
}
