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
<%@ include file="/html/portlet/vcms/init.jsp" %>


<%
	String redirect = ParamUtil.getString(request, "redirect");
	PortletURL portletVersionURL = renderResponse.createRenderURL();
	
	portletVersionURL.setWindowState(WindowState.MAXIMIZED);
	
	portletVersionURL.setParameter("struts_action", "/vcms/view");
	portletVersionURL.setParameter("tabs1", tabs1);
	portletVersionURL.setParameter("tabs2", tabs2);
	portletVersionURL.setParameter("language", language);
	portletVersionURL.setParameter("groupId", String.valueOf(groupId));	
%>

<%

List headerNames = new ArrayList();

headerNames.add("portlet.vcms.article.title");
headerNames.add("portlet.vcms.article.version-name");
//headerNames.add(StringPool.BLANK);

SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletVersionURL, headerNames, null);
searchContainer.setEmptyResultsMessage("there-are-no-version");

List articleVersionList = (List)request.getAttribute("articleVersionList");	

if (articleVersionList == null) {
	articleVersionList = new ArrayList();
}

int total = articleVersionList.size();

List results = new ArrayList();
searchContainer.setTotal(total);
results = ListUtil.subList(articleVersionList, searchContainer.getStart(), searchContainer.getEnd());
searchContainer.setResults(results);

List resultRows = searchContainer.getResultRows();
for (int i = 0; i < results.size(); i++) {
	VcmsArticleVersion articleVersion = (VcmsArticleVersion)results.get(i);
	
	ResultRow row = new ResultRow(articleVersion, String.valueOf(articleVersion), i);

	PortletURL rowURL = renderResponse.createRenderURL();

	rowURL.setWindowState(WindowState.MAXIMIZED);

	rowURL.setParameter("struts_action", "/vcms/edit_article");
	rowURL.setParameter("redirect", currentURL);
	rowURL.setParameter("articleVersionId", String.valueOf(articleVersion.getArticleVersionId()));

	// Name and description

	StringBuffer sb = new StringBuffer();

	String title = articleVersion.getTitle();
	String versionName = articleVersion.getVersionName();
		
	
	sb.append("<table cellspacing='3' cellpadding='0' width='100%' border='0'>");
	sb.append("<tr>");
	sb.append("<td width='1%' ><img src='" + themeDisplay.getPathThemeImage() + "/vcms/portion.gif' valign='middle' /></td>");
	sb.append("<td width='99%' align='left'><b>" + title + "</b>");
	sb.append("</td>");
	sb.append("</tr>");
	
	sb.append("</table>");
	
	row.addText(sb.toString());

	row.addText(versionName);
	
	// Actions
	row.addJSP("right", SearchEntry.DEFAULT_VALIGN, "/html/portlet/vcms/articleversion_action.jsp");

	// Add result row

	resultRows.add(row);
}

%>

<br />
<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />

<br /><br />
<input class="portlet-form-button" type="button" value='<%= LanguageUtil.get(pageContext, "Back") %>' onClick="self.location = '<%= redirect %>';">
