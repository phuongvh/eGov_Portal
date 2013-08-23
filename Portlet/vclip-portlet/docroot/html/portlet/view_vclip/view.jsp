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
<%@ include file="/html/portlet/view_vclip/init.jsp"%>
<%
	String displayStyle = prefs.getValue("displayStyleExt","1");

%><form>
	<c:if test= '<%= (displayStyle.equals("1")) %>' >
		<%@ include file="/html/portlet/view_vclip/style/style1.jsp" %>		
	</c:if>
	<c:if test= '<%= (displayStyle.equals("2")) %>' >
		<%@ include file="/html/portlet/view_vclip/style/style2.jsp" %>
	</c:if>
</form>