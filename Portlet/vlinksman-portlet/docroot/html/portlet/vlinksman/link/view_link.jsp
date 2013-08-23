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

<%@page import="com.liferay.portal.kernel.dao.search.SearchEntry"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.vportal.portlet.vlinksman.model.Links"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.vportal.portlet.vlinksman.service.LinksServiceUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.vportal.portlet.vlinksman.service.LinkGroupServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.dao.search.TextSearchEntry"%>
<%@page import="com.vportal.portlet.vlinksman.model.LinkGroup"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<portlet:actionURL name="_deleteLink" var="_deleteLinkURL"></portlet:actionURL>
<portlet:actionURL name="_viewByGroupLink" var="_viewByGroupLinkURL"></portlet:actionURL>
<script>
	
	function <portlet:namespace />updatePosition(selector) {
		document.<portlet:namespace />fm.<portlet:namespace />position.value = selector.value;
		document.<portlet:namespace />fm.<portlet:namespace />cmd.value = 'update_position';
		submitForm(document.<portlet:namespace />fm, '<portlet:actionURL windowState="<%=WindowState.MAXIMIZED.toString()%>" name="_updatePositionLink"></portlet:actionURL>');
	}
	
	function <portlet:namespace />changeType(){		
		submitForm(document.<portlet:namespace />fm);	
	}
	

    Liferay.provide(window,'<portlet:namespace />deleteAll', function(){
		var linkIds = document.<portlet:namespace/>fm.<portlet:namespace />linkIds.value;
		linkIds = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
		if (linkIds.length >0){
			if (confirm('<%=UnicodeLanguageUtil.get(pageContext,
					"are-you-sure-you-want-to-delete-the-selected-links")%>')) {
				document.<portlet:namespace />fm.<portlet:namespace />cmd.value = "dodelete";
				document.<portlet:namespace />fm.<portlet:namespace />linkIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
				submitForm(document.<portlet:namespace />fm, '<portlet:actionURL windowState="<%=WindowState.MAXIMIZED.toString()%>" name="_deleteLink"></portlet:actionURL>');
			}
		} else {
			alert("<%=LanguageUtil.get(pageContext,
					"you-must-select-a-link-to-delete")%> ");
		}
	},
    	['liferay-util-list-fields']
);
</script>

<%
	long linkgroupId = ParamUtil.getLong(request, "linkgroupId");	
	List<LinkGroup> linkGroups = LinkGroupServiceUtil.getAll();

	List results = null;
	if (linkgroupId == 0) {
		results = LinksServiceUtil.getAll();
		
	} else {
		results = LinksServiceUtil.getByLinkGroupId(linkgroupId);		
	}

	//boolean showAddLink = showButtons && PortletPermissionUtil.
	//	contains(permissionChecker , plid.longValue() , PortletKeysExt.VLINKSMAN, ActionKeysExt.ADD_LINK);	
	boolean showAddLink = true;
	//boolean showDeleteAll = showButtons && PortletPermissionUtil.
	//	contains(permissionChecker , plid.longValue(), PortletKeysExt.VLINKSMAN, ActionKeysExt.DELETE_ALL);
	boolean showDeleteAll = true;
%>

<form name="<portlet:namespace />fm"
	action="<portlet:actionURL><portlet:param name="struts_action" value="/vlinksman/link" /></portlet:actionURL>"
	method="POST">
	<input name="<portlet:namespace />linkIds" type="hidden" value="">
	<input name="<portlet:namespace />cmd" type="hidden" value="dodelete">
	<input name="<portlet:namespace />redirect" type="hidden"
		value="<%=currentURL%>"> <input
		name="<portlet:namespace />position" type="hidden" value="" />

	<%
		PortletURL _portletURL = renderResponse.createRenderURL();
		_portletURL.setWindowState(WindowState.MAXIMIZED);
		_portletURL.setParameter("jspPage", "/html/portlet/vlinksman/view.jsp");

		StringBuffer sb = new StringBuffer();

		List headerNames = new ArrayList();
		headerNames.add("Vlinksman.name");
		headerNames.add("VLinksman.form.description");
		headerNames.add("VLinksman.form.url");
		headerNames.add("Vlinksman.index");
		headerNames.add(StringPool.BLANK);

		SearchContainer searchCtn = new SearchContainer(renderRequest,
				null, null, SearchContainer.DEFAULT_CUR_PARAM, 10,
				_portletURL, headerNames, null);
		searchCtn.setEmptyResultsMessage("there-are-no-links");

		int total = results.size();

		results = ListUtil.subList(results, searchCtn.getStart(),
				searchCtn.getEnd());
		searchCtn.setResults(results);
		searchCtn.setTotal(total);

		//if (showDeleteAll){	
		searchCtn.setRowChecker(new RowChecker(renderResponse));
		//}
		List resultRows = searchCtn.getResultRows();
		for (int i = 0; i < results.size(); i++) {
			Links link = (Links) results.get(i);

			long position = link.getPosition();
			ResultRow row = new ResultRow(link, link.getLinkId(), i);
			
			PortletURL rowURL = renderResponse.createRenderURL();
			row.addText(link.getName());
			row.addText(link.getDescription());
			row.addText(link.getUrl());

			sb = new StringBuffer();
			sb.append("<select name=\"");
			sb.append(renderResponse.getNamespace() + "position_"
					+ link.getLinkId() + "\" ");
			sb.append("onChange=\"javascript:"
					+ renderResponse.getNamespace()
					+ "updatePosition(this);\">");

			for (int j = 1; j <= total; j++) {
				sb.append("<option value=\"" + j + "|" + link.getLinkId()
						+ "\" " + ((j == position) ? "selected" : "") + ">");
				sb.append(j);
				sb.append("</option>");
			}

			sb.append("</select>");
			row.addText(sb.toString());

			//button
			row.addJSP("right", SearchEntry.DEFAULT_VALIGN,
					"/html/portlet/vlinksman/link/link_action.jsp",
					application, request, response);
			resultRows.add(row);
		}
	%>
	<!-- Button addLink -->
	<portlet:renderURL var = "addLink"
		 windowState="<%=WindowState.MAXIMIZED.toString()%>">	
		<portlet:param name="jspPage" value="/html/portlet/vlinksman/link/edit_link.jsp"/>		
			<portlet:param name="redirect" value="<%=currentURL%>"/>
			<portlet:param name="cmd" value="showadd" />
	</portlet:renderURL>
	<div class="portlet-font"
		style="font-weight: bold; float: left; margin-right: 10px">
		<input class="portlet-form-button" type="button"
			value="<%= LanguageUtil.get(pageContext, "VLinksman.form.action.add") %>"
			onclick="self.location='<%=addLink%>'">
	</div>

	<!-- Button deleteAll -->
	<div class="portlet-font"
		style="font-weight: bold; float: left; margin-right: 10px">
		<input class="portlet-form-button" type="button"
			value="<%= LanguageUtil.get(pageContext, "VLinksman.form.action.delete") %>"
			onclick="<portlet:namespace />deleteAll();" />
	</div>

	<div class="portlet-font"
		style="font-weight: bold; float: left; margin-right: 10px">
		<label><%= LanguageUtil.get(pageContext, "VLinksman.title.linkgroup") %></label> <select
			name="<portlet:namespace />linkgroupId" style="width: 150px;"
			onChange="javascript:<portlet:namespace />changeType();">
			<option value="0">-- <%= LanguageUtil.get(pageContext, "VLinksman.showAll") %> --</option>
			<%
				for (int i = 0; i < linkGroups.size(); i++) {
					LinkGroup linkgroup = (LinkGroup) linkGroups.get(i);
			%>
			<option value="<%=linkgroup.getLinkgroupId()%>"
				<%=(linkgroup.getLinkgroupId() == linkgroupId)
						? "selected"
						: ""%>><%=linkgroup.getName()%></option>
			<%
				}
			%>
		</select>
	</div>


	<br /> <br />
	<liferay-ui:search-iterator searchContainer="<%=searchCtn%>" />
</form>
<br />
