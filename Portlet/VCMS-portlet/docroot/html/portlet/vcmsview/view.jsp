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
<%@ include file="/html/portlet/vcmsview/init.jsp"%>
	
<%
String categoryId = ParamUtil.getString(request, ConstantsExt.CATEGORY_ID);
String articleId = ParamUtil.getString(request, ConstantsExt.ARTICLE_ID);
%>

<% if (Validator.isNotNull(articleId)) { %>
	<%@ include file="/html/portlet/vcmsview/article_view.jsp" %>
<% } else if (Validator.isNotNull(articleId) && Validator.isNotNull(categoryId)) { %>
	<%@ include file="/html/portlet/vcmsview/category_view.jsp" %>
<% } else {%>
	<%@ include file="/html/portlet/vcmsview/overall_view.jsp" %>
<% } %>