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
<%@page import="com.liferay.portal.model.ResourcePermission"%>
<%@page import="com.liferay.portal.model.ResourceConstants"%>
<%@page import="com.vportal.portlet.vcms.model.VcmsPortion"%>
<%@page import="com.liferay.portal.service.PermissionLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.ResourcePermissionLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.ResourcePermissionServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.vportal.portal.kernel.security.permission.ActionKeysExt"%>
<%@page import="com.vportal.portlet.vcms.util.PortletKeysVCMS"%>
<%@page import="com.vportal.portal.util.PortletKeysExt"%>
<%@page import="com.liferay.portal.service.permission.PortletPermissionUtil"%>
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
<%@ page
	import="com.vportal.portlet.vcms.service.VcmsPortionServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page
	import="com.vportal.portlet.vcms.service.VcmsCategoryServiceUtil"%>
<%@ page import="com.vportal.portlet.vcms.DeletePortionException"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<%@ page import="com.vportal.portlet.vcms.action.ActionUtil"%>

<%
boolean showAddPortionButton = showButtons && PortletPermissionUtil.contains(permissionChecker, plid.longValue(),PortletKeysVCMS.VCMS,ActionKeysExt.ADD_PORTION);
List headerNames = new ArrayList();

headerNames.add("portlet.vcms.portion.list.name");
headerNames.add("portlet.vcms.portion.list.code");
headerNames.add("");

SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, headerNames, null);
searchContainer.setEmptyResultsMessage("there-are-no-portions");
// Filter and get only appropriate portions to put into the searchContainer
List results = VcmsPortionServiceUtil.getPortionsByS_L(groupId, language, searchContainer.getStart(), searchContainer.getEnd());
/* for(int i=0;i<=results.size();i++){
	List test =  ResourcePermissionLocalServiceUtil.getResourcePermissions(companyId, VcmsPortion.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf( ( (VcmsPortion)results.get(i)).getPrimaryKey()));
	for(int j=0;i<test.size();j++){
		ResourcePermission rp = (ResourcePermission)test.get(i);
		System.out.println("name" + rp.getName() + "  scope " + rp.getScope());
	}
	PermissionLocalServiceUtil.hasUserPermission(user.getUserId(), actionId, resourceId);
}
*/
int total = VcmsPortionServiceUtil.countPortionsByS_L(groupId, language);
searchContainer.setTotal(total);
searchContainer.setResults(results);

List resultRows = searchContainer.getResultRows();
for (int i = 0; i < results.size(); i++) {
	VcmsPortion portion = (VcmsPortion)results.get(i);
	
	ResultRow row = new ResultRow(portion, portion.getPrimaryKey().toString(), i);
	categoryURL.setParameter("portionId", portion.getPortionId());
	PortletURL rowURL = renderResponse.createRenderURL();

	rowURL.setWindowState(WindowState.MAXIMIZED);

	rowURL.setParameter("jsp", "html/portlet/vcms/manage/portion/edit_portion.jsp");
	rowURL.setParameter("redirect", currentURL);
	rowURL.setParameter("portionId", portion.getPortionId());

	// Name and description

	StringBuffer sb = new StringBuffer();

	String code = portion.getCode();
	String name = portion.getName();
	String description = portion.getDescription();
	
	List children = VcmsCategoryServiceUtil.getCategoriesByP_P(groupId, portion.getPortionId(), ActionUtil.DEFAULT_CATEGORY_ID, language);
	int childrenCount = children.size();
	
	sb.append("<table cellspacing='3' cellpadding='0' width='100%' border='0'>");
	sb.append("<tr>");
	sb.append("<td width='1%'><img src='" + themeDisplay.getPathThemeImage() + "/vcms/portion.gif' valign='middle' /></td>");
	sb.append("<td width='99%' align='left'><b><a href=\""+categoryURL.toString()+"\">" + name + "</a></b></td>");
	sb.append("</tr>");
	
	if (Validator.isNotNull(description)) {
		sb.append("<tr>");
		sb.append("<td colspan='2' align='left'><span style='font-size: xx-small;'>");
		sb.append(description);
		sb.append("</span></td>");
		sb.append("</tr>");
	}
	
	if (childrenCount > 0) {
		sb.append("<tr>");
		sb.append("<td width='1%'><img src='" + themeDisplay.getPathThemeImage() + "/vcms/children.gif' valign='middle' /></td>");
		sb.append("<td width='99%' align='left'><span style='font-size: xx-small;'><b><u>" + LanguageUtil.get(pageContext, "portlet.vcms.portion.list.category") + "</u>:");
		for (int j = 0; j < childrenCount; j ++) {
			VcmsCategory child = (VcmsCategory) children.get(j);
			categoryURL.setParameter("parentId",child.getCategoryId());
			sb.append("<a href=\""+categoryURL.toString()+"\">"+child.getName()+"</a>");
			
			if (j < childrenCount - 1) {
				sb.append(", ");
			}
		}
		sb.append("</b></span></td>");
		sb.append("</tr>");
	}
	
	sb.append("</table>");
	
	row.addText(sb.toString());

	// Code

	row.addText(code);
	
	// Actions
	
	row.addJSP("right", SearchEntry.DEFAULT_VALIGN, "/html/portlet/vcms/manage/portion/portion_action.jsp",application,request,response);

	// Add result row

	resultRows.add(row);
}

%>

<liferay-ui:error exception="<%= DeletePortionException.class %>" message="portlet.vcms.portion.exception.you-cannot-delete-a-portion-which-contains-entries" />
<c:if test="<%=showAddPortionButton%>">
	<input class="portlet-form-button" type="button" value='<%= LanguageUtil.get(pageContext, "portlet.vcms.button.add") %>' onClick="javascript:<portlet:namespace />updatePortion('<%= Constants.ADD %>', true);" />
</c:if>
<br /><br />
<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />

