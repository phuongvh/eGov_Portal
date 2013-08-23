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

<%@ include file="/html/portlet/init.jsp" %>	
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.vportal.portlet.vimagegallery.*" %>
<%@ page import="com.vportal.portlet.vimagegallery.model.*" %>
<%@ page import="com.vportal.portlet.vimagegallery.model.impl.*" %>
<%@ page import="com.vportal.portlet.vimagegallery.service.*" %>
<%@ page import="com.vportal.portlet.vimagegallery.*" %>
<%@ page import="com.vportal.portlet.vimagegallery.util.*" %>
<%@ page import="com.liferay.portal.service.permission.PortletPermissionUtil"%>
<%@ page import="com.liferay.portal.theme.*" %>
<%@ page import="com.liferay.portal.util.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.vportal.portal.util.*" %>
<%@ page import="com.vportal.portal.model.*" %>
<%@ page import="com.vportal.portal.service.*" %>
<%@ page import="com.vportal.portlet.vimagegallery.service.permission.TFCategoryPermission" %>	
<%@ page import="com.vportal.portlet.vimagegallery.service.permission.TFImagePermission" %>
<%@ page import="com.vportal.portlet.vimagegallery.ImageSizeException" %>
<%@ page import="com.vportal.portlet.vimagegallery.NoSuchTFCategoryException" %>
<%@ page import="com.vportal.portlet.vimagegallery.NoSuchTFImageException" %>
<%@ page import="com.vportal.portlet.vimagegallery.TFCategoryNameException" %>
<%@ page import="com.vportal.portlet.vimagegallery.TFImageNameException" %>


<script language="javascript">
	function showErrorField(field) {
		field.style.border="2px solid red";
		field.focus();
	}
	function resetField(field) {
		field.style.border="1px solid #CCC";
	}
</script>
	
<%		
	String tabs1 = ParamUtil.getString(request, "tabs1");
	long groupId = ParamUtil.getLong(request, "groupId",0);	
	if(groupId == 0){
		groupId = portletGroupId.longValue();
	}
	
	boolean showTabs = false;
	boolean showButtons = true;
	if (portletConfig.getPortletName().equals(PortletKeysExt.VIMAGEGALLERY)) {		
		showButtons = true;
		showTabs = true;
	}
%>