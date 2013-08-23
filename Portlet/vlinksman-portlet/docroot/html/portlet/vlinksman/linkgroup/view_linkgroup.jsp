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

<%@page import="com.vportal.portlet.vlinksman.model.LinkGroup"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%
	List<LinkGroup> linkGroups = LinkGroupServiceUtil.getAll();
	for(int i=0;i<linkGroups.size() ;i++){
	
	LinkGroup linkGroup = LinkGroupServiceUtil.getLinkGroup(linkGroups.get(i).getLinkgroupId());

	}
%>
<form name="<portlet:namespace />fm" action="<portlet:actionURL><portlet:param name="struts_action" value="/vlinksman/type" /></portlet:actionURL>" method="POST">
	<input name="<portlet:namespace />ids" type="hidden" value="">
	<input name="<portlet:namespace />cmd" type="hidden" value="">
	<input name="<portlet:namespace />redirect" type="hidden" value="<%= currentURL %>">
	
<%	
	PortletURL typeURL = renderResponse.createRenderURL();
	typeURL.setWindowState(WindowState.MAXIMIZED);	
	typeURL.setParameter("jspPage", "/html/portlet/vlinksman/linkgroup/edit_linkgroup.jsp");
		
	List headerNames = new ArrayList();
	headerNames.add("Vlinksman.name");
	headerNames.add("VLinksman.form.description");
	headerNames.add("VLinksman.form.url");
	headerNames.add("createdate");
	headerNames.add(StringPool.BLANK);
	
	SearchContainer searchCtn = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 10, portletURL, headerNames, null);	
	searchCtn.setEmptyResultsMessage("there-are-no-linkgroups");	
	
	List results = new ArrayList();
	for (int i = 0; i < linkGroups.size(); i++) {
		LinkGroup linkGroup = (LinkGroup)linkGroups.get(i);
		results.add(linkGroup);
	}

	// Collections.sort(results);
	
	int total = results.size();
	results = ListUtil.subList(results, searchCtn.getStart(), searchCtn.getEnd());
	
	searchCtn.setResults(results);
	searchCtn.setTotal(total);

	List resultRows = searchCtn.getResultRows();
	for (int i = 0; i < results.size(); i++) {
		LinkGroup linkGroup = (LinkGroup)results.get(i);

		ResultRow row = new ResultRow(linkGroup, linkGroup.getLinkgroupId(), i);
		int count = LinksServiceUtil.getByLinkGroupId(linkGroup.getLinkgroupId()).size();
		PortletURL rowURL = renderResponse.createRenderURL();
		row.addText(linkGroup.getName());
		row.addText(linkGroup.getDescription());
		row.addText(String.valueOf(count));
		row.addText(linkGroup.getCreatedDate().toLocaleString());
		rowURL.setWindowState(WindowState.MAXIMIZED);

		rowURL.setParameter("jspPage","/html/portlet/vlinksman/linkgroup/edit_linkgroup.jsp" );
		rowURL.setParameter("redirect", currentURL);
		rowURL.setParameter(Constants.CMD , "showupdate" );
		rowURL.setParameter("Id", Long.toString(linkGroup.getLinkgroupId()));
		
		//button
		row.addJSP("right", SearchEntry.DEFAULT_VALIGN, "/html/portlet/vlinksman/linkgroup/linkgroup_action.jsp",application,request,response);
		
		resultRows.add(row);
	}
%>
<portlet:renderURL var = "addLinkGroup">
	<portlet:param name="tabs1" value="VLinksman.title.linkgroup" />
	<portlet:param name="jspPage" value="/html/portlet/vlinksman/linkgroup/edit_linkgroup.jsp" />
	<portlet:param name="redirect" value="<%= currentURL %>"/>
	<portlet:param name="cmd" value="showadd" />
	</portlet:renderURL>
<input type="button" value="<%= LanguageUtil.get(pageContext, "VLinksman.form.action.add") %>"
	onclick="javascript:document.location='<%=addLinkGroup%>'">	
	
<liferay-ui:search-iterator searchContainer="<%= searchCtn %>" />

<br>
</form>	