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
	String articleId = ParamUtil.getString(request,"articleId");
	String _tabs2 = ParamUtil.getString(request,"tabs2");
	String titleArticle = "";
	try {
		VcmsArticle article = VcmsArticleServiceUtil.getArticle(articleId);
		titleArticle = article.getTitle();
	} catch (Exception ex){}
	
	PortletURL portletVersionURL = renderResponse.createRenderURL();
	
	portletVersionURL.setWindowState(WindowState.MAXIMIZED);
	
	portletVersionURL.setParameter("jspPage", "/html/portlet/vcms/view.jsp");
	portletVersionURL.setParameter("tabs1", tabs1);
	portletVersionURL.setParameter("tabs2", tabs2);
	portletVersionURL.setParameter("language", language);
	portletVersionURL.setParameter("groupId", String.valueOf(groupId));	
	
%>

<liferay-ui:tabs names="<%= LanguageUtil.get(pageContext, \"portlet.vcms.article.restore-article\") %>" backURL="<%= redirect %>" />

<form name="<portlet:namespace/>fm" method="POST">
<input type="hidden" name="<portlet:namespace/>titleArticle" value="<%=titleArticle%>">
<input type="hidden" name="<portlet:namespace/>articleVersionId" value="">
<input type="hidden" name="<portlet:namespace/>cmd" value="">
<%

List headerNames = new ArrayList();

headerNames.add("portlet.vcms.article.title");
headerNames.add("portlet.vcms.article.version-name");
headerNames.add(StringPool.BLANK);

SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletVersionURL, headerNames, null);
searchContainer.setEmptyResultsMessage("there-are-no-version");

/* List articleVersionList = (List)request.getAttribute("articleVersionList");	 */
List articleVersionList = VcmsArticleVersionServiceUtil.listVersionByArticleId(articleId);


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

	//rowURL.setWindowState(WindowState.MAXIMIZED);

	//rowURL.setParameter("struts_action", "/vcms/edit_article");
	//rowURL.setParameter("redirect", currentURL);
	//rowURL.setParameter("articleVersionId", String.valueOf(articleVersion.getArticleVersionId()));

	// Name and description

	StringBuffer sb = new StringBuffer();
	StringBuffer sb1 = new StringBuffer();
			
	String title = articleVersion.getTitle();
	String leadArticle = HtmlExt.welform(articleVersion.getLead(), false);
	String versionName = articleVersion.getVersionName();
	
	int ch = 185;
	int ch1 = 65;
	int space = 0;
	if(leadArticle.length()>ch){
		  space = leadArticle.indexOf(" ",ch);
		  if(space>0){
			  leadArticle = leadArticle.substring(0,space) + " ...";
		  }
	}
	
	if(title.length()>ch1){
		  space = title.indexOf(" ",ch1);
		  if(space>0){
			  title = title.substring(0,space) + " ...";
		  }
	}
				

	sb.append("<b>" + title + "</b>");
	sb.append("<br/>");
	if(articleVersion.getHasImage()){
		sb.append("<img width='70' height='50' style='float: left; padding-right: 5px;' src='" + themeDisplay.getPathImage() + "/vcms?img_id=" + articleVersion.getImage() + "' valign='middle' />");
	} else {
		sb.append("<img width='70' height='50' style='float: left; padding-right: 5px;' src='/html/portlet/vcms/images.jpg' />");
		
	}
	sb.append(leadArticle + "<br/>");	

	
	row.addText(sb.toString());

	row.addText(versionName);
	
	if(!_tabs2.equals(String.valueOf(statusId)))
		row.addJSP("right", SearchEntry.DEFAULT_VALIGN, "/html/portlet/vcms/articles/articleversion_action.jsp",application,request,response);
	else
		row.addText("");

	// Add result row

	resultRows.add(row);
}

%>
<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
<br />
<input class="portlet-form-button" type="button" value='<%= LanguageUtil.get(pageContext, "back") %>' onClick="self.location = '<%= redirect %>';">
</form>