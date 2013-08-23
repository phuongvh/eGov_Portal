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
<%@page import="com.vportal.portlet.vcms.service.VcmsStatusLocalServiceUtil"%>
<%
/**
 * Copyright (c) 2001-2009 VietSoftware, Inc. All rights reserved.
 *
 */
%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
boolean showAddStatusButton = showButtons && showAddStatus;

List headerNames = new ArrayList();

headerNames.add("portlet.vcms.status.name");
headerNames.add("portlet.vcms.status.edit.primary");
headerNames.add("portlet.vcms.status.edit.active");
headerNames.add("portlet.vcms.status.edit.position");
headerNames.add("");

SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, headerNames, null);
searchContainer.setEmptyResultsMessage("there-are-no-status");
RowChecker rowChecker = new RowChecker(renderResponse);

int total = VcmsStatusLocalServiceUtil.countByGroupId(groupId);
List results = VcmsStatusLocalServiceUtil.getByGroupId(groupId,searchContainer.getStart(), searchContainer.getEnd());

searchContainer.setTotal(total);
searchContainer.setResults(results);

List resultRows = searchContainer.getResultRows();
for (int i = 0; i < results.size(); i++) {
	VcmsStatus status = (VcmsStatus)results.get(i);
	
	ResultRow row = new ResultRow(status, status.getPrimaryKey(), i);
	
	PortletURL rowURL = renderResponse.createRenderURL();
	
	rowURL.setWindowState(WindowState.MAXIMIZED);
	
	rowURL.setParameter("jspPage","/html/portlet/vcms/manage/status/edit_status.jsp" );
	rowURL.setParameter("redirect", currentURL);
	rowURL.setParameter("statusId", String.valueOf(status.getStatusId()));
	
	// Name and description
	
	StringBuffer sb = new StringBuffer();
	
	String title = status.getName();
	String description = status.getDescription();
	
	sb.append("<b><a href=\"" + rowURL.toString() + "\">" + title + "</a></b>");
	
	if (Validator.isNotNull(description)) {
		sb.append("<br /><span style=\"font-size: xx-small;\">");
		sb.append(description);
		sb.append("</span>");
	}
	
	row.addText(sb.toString());
	String primaryImage = "";
	String activeImage = "";
	
	if(status.getIsPrimary())
		primaryImage = "<img src='" + themeDisplay.getPathThemeImage() + "/messages/success.png' />";
	if(status.getActive())
		activeImage = "<img src='" + themeDisplay.getPathThemeImages() + "/messages/success.png' />";
	row.addText("left", "middle", primaryImage);
	row.addText("left", "middle", activeImage);
	row.addText("left", "middle",String.valueOf(status.getPosition()));
	// Actions
	
	row.addJSP("right", SearchEntry.DEFAULT_VALIGN,"/html/portlet/vcms/manage/status/status_action.jsp" ,application,request,response);
	
	// Add result row
	
	resultRows.add(row);
}
%>
	<c:if test="<%=showAddStatusButton%>">
		<div class="portlet-font" style="font-weight: bold; float: left; margin-right: 10px">
			<input class="portlet-form-button" type="button" value='<%= LanguageUtil.get(pageContext, "portlet.vcms.button.add") %>' onClick="javascript:<portlet:namespace />updateStatus('<%= Constants.ADD %>', true);" />
		</div>
	</c:if>

	<br><br><div class="beta-separator"></div><br>

<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
