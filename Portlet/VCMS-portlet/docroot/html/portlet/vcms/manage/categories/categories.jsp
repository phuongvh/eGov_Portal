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
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.vportal.portlet.vcms.service.VcmsPortionServiceUtil"%>
<%@page import="com.vportal.portlet.vcms.service.VcmsCategoryServiceUtil"%>
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
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%
	

	
boolean showAddCategoryButton = showButtons && PortletPermissionUtil.contains(permissionChecker , plid.longValue() , PortletKeysExt.VCMS , ActionKeysExt.ADD_CATEGORY);
PortletURL subCategoryURL = renderResponse.createRenderURL();
subCategoryURL.setWindowState(WindowState.MAXIMIZED);
subCategoryURL.setParameter("jspPage", "/html/portlet/vcms/view.jsp");
subCategoryURL.setParameter("tabs1", "portlet.vcms.tabs.category");
subCategoryURL.setParameter("language", language);
subCategoryURL.setParameter("groupId", String.valueOf(groupId));
List headerNames = new ArrayList();

headerNames.add("portlet.vcms.category.list.name");
headerNames.add("portlet.vcms.category.list.image");
headerNames.add("portlet.vcms.category.list.anchored");
headerNames.add("portlet.vcms.category.list.position");
headerNames.add(StringPool.BLANK);

SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, headerNames, null);
searchContainer.setEmptyResultsMessage("there-are-no-categories");
	
// Filter and get only appropriate portions to put into the searchContainer
VcmsPortion portion = null;
List results = null;
int total = 0;
if (Validator.isNull(portionId)) {
	results = VcmsCategoryServiceUtil.getCategoriesByParent(groupId, parentId, language, searchContainer.getStart(), searchContainer.getEnd());
	total = VcmsCategoryServiceUtil.countCategoriesByParent(groupId, parentId, language);
} else {
	results = VcmsCategoryServiceUtil.getCategoriesByP_P(groupId, portionId, parentId, language, searchContainer.getStart(), searchContainer.getEnd());
	total = VcmsCategoryServiceUtil.countCategoriesByP_P(groupId, portionId, parentId, language);
	portion = VcmsPortionServiceUtil.getPortion(portionId);
}

searchContainer.setTotal(total);
searchContainer.setResults(results);
List resultRows = searchContainer.getResultRows();
for (int i = 0; i < results.size(); i++) {
	VcmsCategory category = (VcmsCategory)results.get(i);
	
	ResultRow row = new ResultRow(category, category.getPrimaryKey().toString(), i);
	
	PortletURL rowURL = renderResponse.createRenderURL();
	categoryURL.setParameter("portionId", portionId);
	categoryURL.setParameter("parentId",category.getCategoryId());
	
	rowURL.setWindowState(WindowState.MAXIMIZED);
	rowURL.setParameter("jspPage", "/html/portlet/vcms/manage/categories/edit_category.jsp");
	rowURL.setParameter("redirect", currentURL);
	rowURL.setParameter("categoryId", category.getCategoryId());
	
	// Name and description
	
	StringBuffer sb = new StringBuffer();
	
	boolean hasImage = category.getHasImage();
	boolean anchored = category.getAnchored();
	String name = category.getName();
	String description = category.getDescription();
	long position = category.getPosition();
	
	List children = VcmsCategoryServiceUtil.getCategoriesByParent(groupId, category.getCategoryId(), language);
	int childrenCount = children.size();
	
	sb.append("<table cellspacing='3' cellpadding='0' width='100%' border='0'>");
	sb.append("<tr>");
	sb.append("<td width='1%'><img src='" + themeDisplay.getPathThemeImage() + "/vcms/category.gif' valign='middle' /></td>");
	sb.append("<td width='99%'><b><a href=\""+categoryURL.toString()+"\">" + name + "</a></b></td>");
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
		sb.append("<td width='99%' align='left'><span style='font-size: xx-small;'><b><u>" + LanguageUtil.get(pageContext, "portlet.vcms.category.list.sub-category") + "</u>:");
		for (int j = 0; j < childrenCount; j ++) {
			VcmsCategory child = (VcmsCategory) children.get(j);
			subCategoryURL.setParameter("portionId", portionId);
			subCategoryURL.setParameter("parentId",child.getCategoryId());
			sb.append("<a href=\""+subCategoryURL.toString()+"\">"+child.getName()+"</a>");
			
			if (j < childrenCount - 1) {
				sb.append(", ");
			}
		}
		sb.append("</b></span></td>");
		sb.append("</tr>");
	}
	
	sb.append("</table>");
	
	row.addText(sb.toString());
	
	// Has Image?
	
	row.addText((hasImage ? LanguageUtil.get(pageContext, "portlet.vcms.selection.yes") : LanguageUtil.get(pageContext, "portlet.vcms.selection.no")));
	
	// Anchored?
	
	row.addText((anchored ? LanguageUtil.get(pageContext, "portlet.vcms.selection.true") : LanguageUtil.get(pageContext, "portlet.vcms.selection.false")));
	
	// Position
	
	sb = new StringBuffer();
	sb.append("<select name=\"");
	sb.append(renderResponse.getNamespace() + "position_" + category.getCategoryId() + "\" ");
	sb.append("onChange=\"javascript:" 
				+ renderResponse.getNamespace() 
				+ "updateCategoryPosition(this);\">" );
	
	for (int j = 1; j <= total; j ++) {
		sb.append("<option value=\"" + j + "|" + category.getCategoryId() + "\" " + ((j == position) ? "selected" : "") + ">");
		sb.append(j);
		sb.append("</option>");
	}
	
	sb.append("</select>");
	
	row.addText(sb.toString());
	
	// Actions
	
	row.addJSP("right", SearchEntry.DEFAULT_VALIGN, "/html/portlet/vcms/manage/categories/category_action.jsp",application,request,response);
	
	// Add result row
	
	resultRows.add(row);
}

%>
<style>
	div.portlet-msg-error:FIRST-CHILD{
		display: none;
	}
</style>
<liferay-ui:error exception="<%= DeleteCategoryException.class %>" message="portlet.vcms.category.exception.you-cannot-delete-a-category-which-contains-entries" />

<div class="portlet-font" style="font-weight: bold; float: left; margin-right: 10px">
	<%= LanguageUtil.get(pageContext, "portlet.vcms.category.search-panel.portion") %>:
</div>

<div class="portlet-font" style="float: left; margin-right: 10px">
	<select style="width: 100px" name="<portlet:namespace />portionId" onChange="javascript:<portlet:namespace />submitForm();">
		<option selected value=""><%= LanguageUtil.get(pageContext, "portlet.vcms.category.search-panel.all-portion") %></option>
		<%		
			List portions = VcmsPortionServiceUtil.getPortionsByS_L(groupId, language);
			
			for (int i = 0; i < portions.size(); i++) {
				VcmsPortion portion2 = (VcmsPortion) portions.get(i);
			if (VcmsPortionPermission.contains(permissionChecker, portion2,
					ActionKeysExt.MANAGE_CATEGORIES_PORTION)) {
						
				if (!portion2.getCategorizable()) {
					continue;
				}
			
		%>			
			<option <%= portionId.equals(portion2.getPortionId()) ? "selected" : "" %> value="<%= portion2.getPortionId() %>"><%= portion2.getName() %></option>
			
		<%	}}	%>
	</select>
</div>
<div class="portlet-font" style="font-weight: bold; float: left; margin-right: 10px">
	<%= LanguageUtil.get(pageContext, "portlet.vcms.category.search-panel.parent-category") %>:
</div>

<div class="portlet-font" style="float: left; margin-right: 10px">
	<select style="width: 100px" name="<portlet:namespace />parentId" <%= ((portion != null) && (portion.getCategorizable())) ? "" : "disabled" %> onChange="javascript:<portlet:namespace />submitForm();">
		<option value="0" <%= ("0".equals(parentId)) ? "selected" : "" %>><%= LanguageUtil.get(pageContext, "portlet.vcms.category.search-panel.root-category") %></option>
		<%
			// Print out the categories tree
			if (portion != null) {
				out.println(ActionUtil.getCategoryTree(portionId, parentId));
			}
		%>
	</select>
</div>

<div class="portlet-font" style="float: left; margin-right: 10px">
	<input class="portlet-form-button" type="button" value='<%= LanguageUtil.get(pageContext, "portlet.vcms.button.filter") %>' onClick="javascript:<portlet:namespace />submitForm();" />
</div>
<c:if test="<%=showAddCategoryButton%>">
	<div class="portlet-font" style="float: left; margin-right: 10px">
		<input class="portlet-form-button" type="button" value='<%= LanguageUtil.get(pageContext, "portlet.vcms.button.add") %>' onClick="javascript:<portlet:namespace />updateCategory('<%= Constants.ADD %>', true);" />
	</div>
</c:if>
<br /><br />
<input type="hidden" name="<portlet:namespace />position" value="" />
<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />

