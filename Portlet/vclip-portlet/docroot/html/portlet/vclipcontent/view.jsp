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
<%@ include file="/html/portlet/vclipcontent/init.jsp" %>
<c:choose>
	<c:when test=' <%= Validator.isNotNull(request.getParameter("ajax_type")) %>'>
		<%@ include file="/html/portlet/vclipcontent/clip_by_type.jsp"%>
	</c:when>
	<c:when test=' <%= Validator.isNotNull(request.getParameter("ajax")) %> '>
		<%@ include file="/html/portlet/vclipcontent/clip_detail.jsp"%>
	</c:when>	 
	<c:when test='<%= displayStyle.equals("2") %>'>
		<%@ include file="/html/portlet/vclipcontent/style/style2.jsp"%>
	</c:when>
	<c:otherwise>	
  		<%@ include file="/html/portlet/vclipcontent/style/style1.jsp"%>  
	</c:otherwise>
</c:choose>