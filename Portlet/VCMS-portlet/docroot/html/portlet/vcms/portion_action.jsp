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
<%
/**
 * Copyright (c) 2000-2006 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ include file="/html/portlet/vcms/init.jsp" %>

<%
String redirect = currentURL;

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

VcmsPortion portion = (VcmsPortion)row.getObject();
%>
<liferay-ui:icon-menu>
<c:if test="<%= VcmsPortionPermission.contains(permissionChecker, portion, ActionKeysExt.VIEW_ARTICLES) %>">
	<c:if test="<%= (portion != null) & !portion.getCategorizable() %>">
		<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>" var="listArticleURL">
			<portlet:param name="jspPage" value="/html/portlet/vcms/view.jsp" />
			<portlet:param name="cmd_portion" value="VIEW_ARTICLES_BY_PORTION" />
			<portlet:param name="tabs2" value="portlet.vcms.tabs.articles.published" />
			<portlet:param name="tabs1" value="portlet.vcms.tabs.article" />
			<portlet:param name="redirect" value="<%= redirect %>" />
			<portlet:param name="fromPortionId" value="<%= portion.getPortionId() %>" />
		</portlet:renderURL>
		
		<liferay-ui:icon image="list_article" url="<%= listArticleURL %>" message="<%= LanguageUtil.get(pageContext, \"portlet.vcms.tooltip.articles-of-portion\") %>" />
	</c:if>
</c:if>
<c:if test="<%= (portion != null) & portion.getCategorizable() %>">
	<c:if test="<%= VcmsPortionPermission.contains(permissionChecker, portion, ActionKeysExt.ADD_CATEGORIES_PORTION) %>">
		<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>" var="addCategoryURL">
			<portlet:param name="jspPage" value="/html/portlet/vcms/edit_category.jsp" />
			<portlet:param name="add_category_portion" value="ADD_CATEGORIES_PORTION" />
			<portlet:param name="redirect" value="<%= redirect %>" />
			<portlet:param name="fromPortionId" value="<%= portion.getPortionId() %>" />
		</portlet:renderURL>
		<liferay-ui:icon image="add_location" url="<%= addCategoryURL %>" message="<%= LanguageUtil.get(pageContext, \"portlet.vcms.tooltip.add-category-of-portion\") %>" />
	</c:if>
</c:if>
<c:if test="<%= VcmsPortionPermission.contains(permissionChecker, portion, ActionKeysExt.UPDATE) %>">
	<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>" var="editURL">
		<portlet:param name="jspPage" value="/html/portlet/vcms/edit_portion.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
		<portlet:param name="portionId" value="<%= portion.getPortionId() %>" />
	</portlet:renderURL>

	<liferay-ui:icon image="edit" url="<%= editURL %>" />
</c:if>
<c:if test="<%= VcmsPortionPermission.contains(permissionChecker, portion, ActionKeysExt.PERMISSIONS) %>">
	<liferay-security:permissionsURL
		modelResource="<%= VcmsPortion.class.getName() %>"
		modelResourceDescription="<%= portion.getName() %>"
		resourcePrimKey="<%= String.valueOf(portion.getPortionId()) %>"
		var="permissionsURL"
	/>

	<liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />
</c:if>

<c:if test="<%= VcmsPortionPermission.contains(permissionChecker, portion, ActionKeysExt.DELETE) %>">
	
	
	<portlet:actionURL name="deletePortion" var="deletePortionURL">
      	<portlet:param name="portionId" value="<%= portion.getPortionId() %>" />
    </portlet:actionURL>
	
	

	<liferay-ui:icon-delete url="<%= deletePortionURL %>" />
</c:if>
</liferay-ui:icon-menu>