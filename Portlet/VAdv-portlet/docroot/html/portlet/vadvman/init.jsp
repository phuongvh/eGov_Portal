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
<%@include file="/html/portlet/init.jsp"%>
<%@page import="com.vportal.portlet.vadvman.util.PortletKeysExt" %>
<%@page import="com.vportal.portlet.vadvman.util.ActionKeysExt"%>
<%@page import="com.vportal.portlet.vadvman.model.AdvType"%>
<%@page import="com.vportal.portlet.vadvman.service.AdvTypeServiceUtil"%>
<%@page import="com.vportal.portlet.vadvman.service.AdvItemServiceUtil"%>
<%@page import="com.vportal.portlet.vadvman.util.VAdvmanUtil"%>
<%@page import="com.vportal.portlet.vadvman.model.impl.AdvTypeImpl"%>
<%@page import="com.vportal.portlet.vadvman.service.permission.AdvTypePermission"%>
<%@page import="com.vportal.portlet.vadvman.model.AdvItem"%>
<%@page import="com.vportal.portlet.vadvman.service.permission.AdvItemPermission"%>
<%@page import="com.vportal.portlet.vadvman.InvalidItemDescriptionException"%>
<%@page import="com.vportal.portlet.vadvman.ItemExpirationDateException"%>
<%@page import="com.vportal.portlet.vadvman.model.impl.AdvItemImpl"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@page import="com.liferay.portal.kernel.util.HttpUtil" %>

<%@ taglib uri="http://www.vietsoftware.com/tld" prefix="vportal" %>

<%
	String tabs1 = ParamUtil.getString(request, "tabs1");
	String language = ParamUtil.getString(request, "language", "vi_VN");
	long typeId = ParamUtil.getLong(request,"typeId");
	String keywords = ParamUtil.getString(request,"keywords");
	String status = ParamUtil.getString(request,"status", "0");
	String cmdSearchFlag = ParamUtil.getString(request,"cmd-search-flag",StringPool.BLANK);
%>
<script language="javascript">
	function showErrorField(field) {
		field.style.border="2px solid red";
		field.focus();
	}
	function resetField(field) {
		field.style.border="1px solid #CCC";
	}
	
	function clearField(field){
		field.value = "";
	}
</script>
	
