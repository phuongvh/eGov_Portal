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
 * Copyright (c) Vietsoftware, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial types of the Software.
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

<%
boolean showAddTypeButton = showButtons && true;
//PortletPermissionUtil.contains(permissionChecker, plid.longValue(),PortletKeysExt.VCMS,ActionKeysExt.ADD_TYPE);

List headerNames = new ArrayList();

headerNames.add("portlet.vcms.type.list.name");
headerNames.add("portlet.vcms.type.list.code");
headerNames.add("");

SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, headerNames, null);
searchContainer.setEmptyResultsMessage("there-are-no-types");

List types = new ArrayList();

types = (List)VcmsTypeServiceUtil.getTypesByS_L(groupId, language);
List results = new ArrayList();
for (int i = 0; i < types.size(); i++) {
	VcmsType type = (VcmsType)types.get(i);
	results.add(type);
}

int total = results.size();

searchContainer.setTotal(total);
results = ListUtil.subList(results, searchContainer.getStart(), searchContainer.getEnd());
searchContainer.setResults(results);

List resultRows = searchContainer.getResultRows();
for (int i = 0; i < results.size(); i++) {
	VcmsType type = (VcmsType)results.get(i);
	
	ResultRow row = new ResultRow(type, type.getPrimaryKey().toString(), i);

	PortletURL rowURL = renderResponse.createRenderURL();

	rowURL.setWindowState(WindowState.MAXIMIZED);

	rowURL.setParameter("struts_action", "/vcms/edit_type");
	rowURL.setParameter("redirect", currentURL);
	rowURL.setParameter("typeId", type.getTypeId());

	// Name and description

	StringBuffer sb = new StringBuffer();

	String code = type.getCode();
	String name = type.getName();
	String description = type.getDescription();
	
	
	
	sb.append("<table cellspacing='3' cellpadding='0' width='100%' border='0'>");
	sb.append("<tr>");
	sb.append("<td width='1%'><img src='" + themeDisplay.getPathThemeImage() + "/vcms/type.gif' valign='middle' /></td>");
	sb.append("<td width='99%' align='left'><b>");
	sb.append("<a href=\"" + rowURL.toString() + "\">" + name + "</a>");
	sb.append("</b></td>");	
	sb.append("</tr>");
	
	if (Validator.isNotNull(description)) {
		sb.append("<tr>");
		sb.append("<td colspan='2' align='left'><span style='font-size: xx-small;'>");
		sb.append(description);
		sb.append("</span></td>");
		sb.append("</tr>");
	}
	
	sb.append("</table>");
	
	row.addText(sb.toString());

	// Code

	row.addText(code);
	
	// Actions
	
	row.addJSP("right", SearchEntry.DEFAULT_VALIGN, "/html/portlet/vcms/type_action.jsp");

	// Add result row

	resultRows.add(row);
}

%>


<c:if test="<%=showAddTypeButton%>">
	<input class="portlet-form-button" type="button" value='<%= LanguageUtil.get(pageContext, "portlet.vcms.button.add") %>' onClick="javascript:<portlet:namespace />updateType('<%= Constants.ADD %>', true);" />
</c:if>
<br /><br />
<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
