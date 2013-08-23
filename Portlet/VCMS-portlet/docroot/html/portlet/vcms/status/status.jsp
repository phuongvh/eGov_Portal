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
//boolean showAddStatusButton = showButtons && showAddStatus;
boolean showAddStatusButton = true;
List headerNames = new ArrayList();

headerNames.add("portlet.vcms.status.name");
headerNames.add("portlet.vcms.status.edit.primary");
headerNames.add("portlet.vcms.status.edit.active");
headerNames.add(StringPool.BLANK);
%>
	<c:if test="<%=showAddStatusButton%>">
		<div class="portlet-font" style="font-weight: bold; float: left; margin-right: 10px">
			<input class="portlet-form-button" type="button" value='<%= LanguageUtil.get(pageContext, "portlet.vcms.button.add") %>' onClick="javascript:<portlet:namespace />updateStatus('<%= Constants.ADD %>', true);" />
		</div>
	</c:if>

	<br><br><div class="beta-separator"></div><br>
<liferay-ui:search-container
	emptyResultsMessage="<%=LanguageUtil.get(pageContext,\"portlet.vcms.status.empty\")%> delta="5"
	iteratorURL="<%=portletURL%>">
	
	<liferay-ui:search-container-results results="<%=VcmsStatusLocalServiceUtil.getVcmsStatuses(searchContainer.getStart(), searchContainer.getEnd())%>"
		total="<%=VcmsStatusLocalServiceUtil.getVcmsStatusesCount()%>" />

	<liferay-ui:search-container-row
		className="com.vportal.portlet.vcms.model.VcmsStatus"
		escapedModel="<%=false%>" keyProperty="statusId" modelVar="status">
		<% 
			PortletURL rowURL = renderResponse.createRenderURL();
			
			rowURL.setWindowState(WindowState.MAXIMIZED);
			
			rowURL.setParameter("jspPage", "/html/portlet/vcms/status/edit_status.jsp");
			rowURL.setParameter("statusId", String.valueOf(status.getStatusId()));
		
			StringBuffer sb = new StringBuffer();
			
			String title = status.getName();
			String description = status.getDescription();
			
			sb.append("<b><a href=\"" + rowURL.toString() + "\">" + title + "</a></b>");
			
			if (Validator.isNotNull(description)) {
				sb.append("<br /><span style=\"font-size: xx-small;\">");
				sb.append(description);
				sb.append("</span>");
			}
		%> 
		<liferay-ui:search-container-column-text href="<%=rowURL%>"
			name="<%=LanguageUtil.get(pageContext,\"portlet.vcms.status.name\")%>"
			value="<%=sb.toString()%>" /> 
			<%	
				String primaryImage = "";
				String activeImage = "";
				if(status.getIsPrimary())
					primaryImage = "<img src='" + themeDisplay.getPathThemeImage() + "/messages/success.png' />";
				if(status.getActive())
					activeImage = "<img src='" + themeDisplay.getPathThemeImages() + "/messages/success.png' />";
			%>
		<liferay-ui:search-container-column-text href="<%=rowURL%>"
			name="<%=LanguageUtil.get(pageContext,\"portlet.vcms.status.edit.primary\")%>"
			value="<%=primaryImage %>"/>


		<liferay-ui:search-container-column-text href="<%=rowURL%>"
			name="<%=LanguageUtil.get(pageContext,\"portlet.vcms.category.list.anchored\")%>"
			value="<%=activeImage %>"/>
	
		<liferay-ui:search-container-column-jsp align="right"
			path="/html/portlet/vcms/status/status_action.jsp" valign="top" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
