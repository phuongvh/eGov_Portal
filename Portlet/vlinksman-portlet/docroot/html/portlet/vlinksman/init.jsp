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

<%@ include file="/html/portlet/init.jsp"%>
<%@page import="com.vportal.portlet.vlinksman.util.PortletKeysExt"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.vportal.portlet.vlinksman.*"%>
<%@page import="com.vportal.portlet.vlinksman.model.*"%>
<%@page import="com.vportal.portlet.vlinksman.model.impl.*"%>
<%@page import="com.vportal.portlet.vlinksman.*"%>
<%@page import="com.vportal.portlet.vlinksman.service.*"%>
<%@page import="com.vportal.portlet.vlinksman.service.impl.*"%>
<%@page import="com.vportal.portlet.vlinksman.service.permission.*"%>
<%@page import="com.vportal.portlet.vlinksman.util.*"%>
<%@page import="com.vportal.portal.model.*"%>
<%@page import="com.vportal.portal.service.*"%>
<%@page import="java.util.*"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchEntry"%>
<%@page import="com.liferay.portal.kernel.dao.search.TextSearchEntry"%>
<%@page import="com.vportal.portlet.vlinksman.service.permission.LinkGroupPermission"%>
<%@page import="com.vportal.portlet.vlinksman.util.ActionKeysExt"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>


<script language="javascript">
	function showErrorField(field) {
		field.style.border = "2px solid red";
		field.focus();
	}
	function resetField(field) {
		field.style.border = "1px solid #CCC";
	}

	function clearField(field) {
		field.value = "";
	}
</script>

<%
	long groupId = ParamUtil.getLong(request, "groupId", 0);
	if (groupId == 0) {
		groupId = portletGroupId.longValue();
	}
	boolean showButtons = false;
	if (portletConfig.getPortletName().equals(PortletKeysExt.VLINKSMAN)) {
		showButtons = true;
	}
%>