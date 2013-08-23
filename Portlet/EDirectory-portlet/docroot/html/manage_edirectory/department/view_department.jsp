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
<%@page
	import="com.vportal.portlet.edirectory.service.persistence.EDDepartmentUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ page
	import="com.liferay.portal.service.permission.PortletPermissionUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors"%>

<%@page import="com.vportal.portlet.edirectory.action.ActionUtil"%>
<%@page import="com.vportal.portlet.edirectory.model.EDDepartment"%>
<%@page
	import="com.vportal.portlet.edirectory.service.EDDepartmentLocalServiceUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<style>
.a {
	padding-right: 20px;
	padding-left: 0px;
}
</style>

<%
	PortletURL rowUrl = renderResponse.createRenderURL();
	rowUrl.setParameter("jspPage",
			"/html/manage_edirectory/department/sub_department.jsp");

	ThemeDisplay theme1 = (ThemeDisplay) request
			.getAttribute(WebKeys.THEME_DISPLAY);
	long groupId = theme1.getScopeGroupId();

	int count = EDDepartmentLocalServiceUtil.getEDDepartmentsCount();
%>



<portlet:renderURL windowState="normal" var="addDepartmentURL">
	<portlet:param name="jspPage"
		value="/html/manage_edirectory/department/add_department.jsp"></portlet:param>
</portlet:renderURL>
<br />
<c:if
	test='<%=PortletPermissionUtil.contains(permissionChecker,
						plid, portletDisplay.getId(), "ADD_FUNCTION")%>'>
	<input type="button"
		value='<%=LanguageUtil.get(pageContext,
						"managecontacts.agency.view-button.addagency")%>'
		onClick="window.location.href='<%=addDepartmentURL.toString()%>' " />
</c:if>
<br />
<br />
<br />

<!--  Danh sách đơn vị -->
<%-- <portlet:renderURL var="renderTabDepartmentURL"> --%>
<%-- 	<portlet:param name="jspPage" value="/html/manage_edirectory/view.jsp?tab1=tab.danhba.donvi"/> --%>
<%-- </portlet:renderURL> --%>
<%
	PortletURL renderTabDepartmentURL = renderResponse
			.createRenderURL();
	renderTabDepartmentURL.setParameter("jspPage",
			"/html/manage_edirectory/view.jsp?tab1=tab.danhba.donvi");
	SessionErrors.add(request, "do-not-delete");
%>
com.liferay.portal.kernel.dao.search.SearchContainer searchContainer = (com.liferay.portal.kernel.dao.search.SearchContainer) pageContext.getAttribute("searchContainer");
	<liferay-ui:search-container-results>
		<%
			List<EDDepartment> donviList = EDDepartmentLocalServiceUtil
							.getByParent(0);
					results = ListUtil.subList(donviList,
							searchContainer.getStart(),
							searchContainer.getEnd());
					total = donviList.size();
					pageContext.setAttribute("results", results);
					pageContext.setAttribute("total", total);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.vportal.portlet.edirectory.model.EDDepartment"
		keyProperty="id" modelVar="donvi">
		<%
			StringBuffer name = new StringBuffer();
					name.append("<a style='text-decoration:none'><b>"
							+ donvi.getName() + "</b></a><br/>");
					List<EDDepartment> donviconList = EDDepartmentLocalServiceUtil
							.getByParent(donvi.getId());
					if (donviconList.size() > 0) {
						name.append("<img class='a' src='/EDirectory-portlet/html/manage_edirectory/department/images/children.gif'/>");
						name.append("<a style = 'text-decoration: underline'>"
								+ "Đơn vị cấp dưới " + ":</a>");
						for (EDDepartment dvc : donviconList) {
							rowUrl.setParameter("parentId",
									String.valueOf(donvi.getId()));
							name.append("<a style = 'text-decoration:none' onclick='window.location.href=\""
									+ rowUrl.toString()
									+ "\"'>"
									+ dvc.getName() + "</a>,");
						}
						name.deleteCharAt(name.length() - 1);
					}
		%>
		<liferay-ui:search-container-column-text
			name='<%=LanguageUtil.get(pageContext,
							"managecontacts.agency.view-title.table.agency")%>'
			value='<%=name.toString()%>' />
		<liferay-ui:search-container-column-text
			name='<%=LanguageUtil
							.get(pageContext,
									"managecontacts.agency.view-title.table.date.create")%>'
			value='<%=ActionUtil.parseDateToString(donvi
							.getCreatedDate())%>' />
		<liferay-ui:search-container-column-text
			name='<%=LanguageUtil.get(pageContext,
								"managecontacts.agency.view-title.table.level")%>'>
			<aui:select name="vitri" label="">
				<%
					for (int i = 0; i < count; i++) {
				%>
				<aui:option value="<%=i + 1%>"
					selected="<%=(donvi.getLevelEd() == (i + 1))%>"><%=i + 1%>
				</aui:option>
				<%
					}
				%>
			</aui:select>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-jsp
			path='/html/manage_edirectory/department/actions_department.jsp'
			align="right" />
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
</liferay-ui:search-container>






