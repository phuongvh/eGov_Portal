<%--/**
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
 */ --%>
<%@ include file="/html/portlet/manage_vclip/init.jsp" %>
<jsp:directive.page import="com.vportal.portlet.vclip.service.ClipServiceUtil"/>
<jsp:directive.page import="javax.portlet.PortletURL"/>
<jsp:directive.page import="com.liferay.portlet.PortletURLUtil"/>

<jsp:directive.page import="java.util.Locale"/>
<jsp:directive.page import="com.liferay.portal.kernel.language.LanguageUtil"/>
<jsp:directive.page import="java.util.List"/>
<jsp:directive.page import="com.liferay.portal.kernel.dao.search.ResultRow"/>
<jsp:directive.page import="com.liferay.portal.kernel.util.ParamUtil"/>

<jsp:directive.page import="com.liferay.portal.kernel.util.Constants"/>
<jsp:directive.page import="com.liferay.portal.kernel.util.StringPool"/>
<jsp:directive.page import="java.util.ArrayList"/>
<jsp:directive.page import="com.liferay.portal.security.permission.PermissionChecker"/>
<jsp:directive.page import="com.vportal.portlet.vclip.service.permission.ClipPermission"/>
<jsp:directive.page import="com.vportal.portlet.vclip.service.permission.ClipTypePermission"/>
<jsp:directive.page import="javax.portlet.WindowState" />
<jsp:directive.page import="com.vportal.portlet.vclip.model.*"/>
<jsp:directive.page import="com.vportal.portlet.vclip.util.*"/>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>


<%
// 	Locale[] locales = LanguageUtil.getAvailableLocales();
	 language = ParamUtil.getString(request, "language", "vi_VN");

	 tabs1 = ParamUtil.getString(request, "tabs1");
	
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	String id = null;
	idName=WebKeysVClip.CLIP_TYPE_ID;
	String action = "/vclip/cliptype";
	
	Object obj=row.getObject();
	
	
	try {// object of row is instance of Clip
		id = ((Clip)obj ).getId();
		idName=WebKeysVClip.CLIP_ID;		
		
		
	}catch(Exception ex){// object of row is instance of ClipType
		id = ((ClipType) obj).getId();
		idName=WebKeysVClip.CLIP_TYPE_ID;
	
	}

	if(obj instanceof Clip){
		%>
	
	<liferay-ui:icon-menu>			
		<c:if test="<%=ClipPermission.contains(permissionChecker,(Clip)obj, ActionKeysClipExt.VIEW) %>" >			
			<portlet:renderURL windowState="<%=WindowState.MAXIMIZED.toString()%>"
				var="editURL">
				<portlet:param name="jspPage" value="/html/portlet/manage_vclip/edit_clip.jsp" />
				<portlet:param name="type" value="clip" />
				<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.EDIT%>" />
				<portlet:param name="redirect" value="<%=currentURL%>" />
				<portlet:param name="tabs1" value="<%=tabs1%>" />
				<portlet:param name="language" value="<%=language %>" />
				<portlet:param name="<%=idName %>" value="<%=id%>" />
			</portlet:renderURL>
			<liferay-ui:icon image="edit" url="<%=editURL%>" />
		</c:if>
			
		<c:if test="<%= ClipPermission.contains(permissionChecker,(Clip)obj, ActionKeysClipExt.PERMISSIONS) %>">
				<liferay-security:permissionsURL
					modelResource="<%= Clip.class.getName() %>"
					modelResourceDescription="<%= ((Clip)obj ).getTitle() %>"
					resourcePrimKey="<%= ((Clip)obj ).getId() %>"
														 
					var="permissionsURL"/>
				<liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />
		</c:if>	
		<c:if test="<%= ClipPermission.contains(permissionChecker,(Clip)obj, ActionKeysClipExt.DELETE) %>">	
			<portlet:actionURL windowState="<%=WindowState.MAXIMIZED.toString()%>"
				var="deleteURL">
				<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.DELETE%>" />
				<portlet:param name="redirect" value="<%=currentURL%>" />
				<portlet:param name="<%=idName %>" value="<%=id%>" />
				<portlet:param name="tabs1" value="<%=tabs1%>" />
				<portlet:param name="language" value="<%=language %>" />
				<portlet:param name="type" value="clip" />
			</portlet:actionURL>
			<liferay-ui:icon image="delete" url="<%=deleteURL%>" />
		</c:if>
		
		</liferay-ui:icon-menu>
		<%
	}else if(obj instanceof ClipType){
		%>
		<liferay-ui:icon-menu>
		<c:if test="<%=ClipTypePermission.contains(permissionChecker,(ClipType)obj, ActionKeysClipExt.VIEW) %>" >
			
			<portlet:renderURL windowState="<%=WindowState.MAXIMIZED.toString()%>"
				var="editURL">
				<portlet:param name="jspPage" value="/html/portlet/manage_vclip/edit_cliptype.jsp" />
				<portlet:param name="type" value="cliptype" />
				<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.EDIT%>" />
				<portlet:param name="redirect" value="<%=currentURL%>" />
				<portlet:param name="tabs1" value="<%=tabs1%>" />
				<portlet:param name="language" value="<%=language %>" />
				<portlet:param name="<%=idName%>" value="<%=id%>" />
			</portlet:renderURL>
			<liferay-ui:icon image="edit" url="<%=editURL%>" />
			
			<c:if test="<%=ClipTypePermission.contains(permissionChecker,(ClipType)obj, ActionKeysClipExt.PERMISSIONS) %>" >
				<liferay-security:permissionsURL
					modelResource="<%= ClipType.class.getName() %>"
					modelResourceDescription="<%= ((ClipType)obj ).getTitle() %>"
					resourcePrimKey="<%= ((ClipType)obj ).getId() %>"
														 
					var="permissionsURL"/>
				<liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />
			</c:if>	
			
			<portlet:actionURL windowState="<%=WindowState.MAXIMIZED.toString()%>"
				var="deleteURL">
				<portlet:param name="type" value="cliptype" />
				<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.DELETE%>" />
				<portlet:param name="redirect" value="<%=currentURL%>" />
				<portlet:param name="<%=idName %>" value="<%=id%>" />
				<portlet:param name="tabs1" value="<%=tabs1%>" />
				<portlet:param name="language" value="<%=language %>" />
			</portlet:actionURL>
			<liferay-ui:icon image="delete" url="<%=deleteURL%>" />
			
		</c:if>
		</liferay-ui:icon-menu>	
		<%
	}
%>

