<%--
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
--%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ include file="/html/init.jsp" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
  		PortletURL backURL = renderResponse.createRenderURL();
		backURL.setParameter("jspPage", "/html/manage_edirectory/view.jsp?tab1=tab.danhba.donvi");
// 		PortletURL rowUrl = renderResponse.createRenderURL();
// 		rowUrl.setParameter("jspPage", "/html/quanlydanhba/donvi/donvicapduoi.jsp");
		String tabsName = "tab.danhba.donvi";						
		PortletURL portletURL = renderResponse.createRenderURL();
		portletURL.setWindowState(WindowState.MAXIMIZED);	
		portletURL.setParameter("tab1", tab1);
		
		long parentId = Long.valueOf(renderRequest.getParameter("parentId"));		
		int count = EDDepartmentLocalServiceUtil.getEDDepartmentsCount();

%>
<br/>

<liferay-ui:tabs names="<%= tabsName %>" param="tab1" url="<%= portletURL.toString() %>" >

<!-- Danh sách Đơn vị cấp dưới-->

<aui:button type="button" value='<%=LanguageUtil.get(pageContext, "managecontacts.agency.add-button.back") %>'  onClick="<%= backURL.toString() %>" />
<br/><br/><br/>
<liferay-ui:search-container emptyResultsMessage="Không có dữ liệu" delta="3">
	
	<liferay-ui:search-container-results>
		<%
			List<EDDepartment> donVi = EDDepartmentLocalServiceUtil.getByParent(parentId);
			results = ListUtil.subList(donVi, searchContainer.getStart(), searchContainer.getEnd());
			total = donVi.size();
			
			pageContext.setAttribute("results", results);
			pageContext.setAttribute("total", total);
		%>
	</liferay-ui:search-container-results>
	
	<liferay-ui:search-container-row className="com.vportal.portlet.edirectory.model.EDDepartment" keyProperty="donviId" modelVar="donvi">
		<liferay-ui:search-container-column-text name='<%=LanguageUtil.get(pageContext, "managecontacts.agency.view-title.table.agency") %>' property="name"/>
		<liferay-ui:search-container-column-text name='<%=LanguageUtil.get(pageContext, "managecontacts.agency.view-title.table.date.create") %>' value='<%= ActionUtil.parseDateToString(donvi.getCreatedDate()) %>'/>
		<liferay-ui:search-container-column-text name='<%=LanguageUtil.get(pageContext, "managecontacts.agency.view-title.table.level") %>'>
			<aui:select name="vitri" label="" >
			<% for(int i =0; i <count ; i++){ %>
				<aui:option value="<%= i+1 %>"  selected="<%= (donvi.getLevelEd() == (i+1)) %>"><%= i+1 %>  </aui:option>
			<%} %>
			</aui:select>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-jsp	path="/html/manage_edirectory/department/actions_department.jsp" align="right" />
		
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />

</liferay-ui:search-container>
</liferay-ui:tabs>













