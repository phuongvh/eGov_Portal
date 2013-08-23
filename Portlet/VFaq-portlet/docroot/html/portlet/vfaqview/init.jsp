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
	
<%@ page import="com.vportal.portlet.vfaq.*" %>
<%@ page import="com.vportal.portlet.vfaq.model.*" %>
<%@ page import="com.vportal.portlet.vfaq.action.*" %>
<%@ page import="com.vportal.portlet.vfaq.service.*" %>
<%@ page import="com.vportal.portlet.vfaq.service.impl.*" %>
<%@ page import="com.vportal.portlet.vfaq.service.permission.*" %>
	
<%@page import="com.vportal.portlet.vfaq.util.FAQUtil"%>
<%@page import="com.vportal.portlet.vfaq.service.FAQCategoryServiceUtil"%>
	
<%@page import="com.vportal.portal.model.Attachment"%>
	
<%@page import="com.vportal.portlet.vfaq.util.WebKeysExt"%>
<%@page import="com.vportal.portlet.vfaq.util.ActionKeysExt"%>	

<%@page import="com.vportal.portal.service.AttachmentServiceUtil"%>	
	