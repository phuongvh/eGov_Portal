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
<%@page import="com.vportal.portlet.vadvman.DeleteTypeException"%>
<%@page import="com.liferay.portal.security.auth.PrincipalException"%>
<%@page import="com.vportal.portlet.vadvman.NoSuchAdvTypeException"%>
<%@page import="com.vportal.portlet.vadvman.NoSuchAdvItemException"%>
<%
/**
 * Copyright (c) VietSoftware, Inc. All rights reserved.
 *
 */
%>




<liferay-ui:error exception="<%= NoSuchAdvItemException.class %>" message="the-item-could-not-be-found" />
<liferay-ui:error exception="<%= NoSuchAdvTypeException.class %>" message="the-type-could-not-be-found" />
<liferay-ui:error exception="<%= PrincipalException.class %>" message="you-do-not-have-the-required-permissions" />
<liferay-ui:error exception="<%= DeleteTypeException.class %>" message="you-must-delete-item-before-delete-type" />
	
	