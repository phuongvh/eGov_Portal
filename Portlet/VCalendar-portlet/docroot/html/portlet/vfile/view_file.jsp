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
<%@ include file="/html/portlet/vfile/tabs.jsp" %>
<portlet:renderURL var="addFile"
	  windowState="<%= WindowState.MAXIMIZED.toString() %>">	  
	  <portlet:param name="tabs" value="<%=tabs %>" />
	  <portlet:param name="jspPage" value="/html/portlet/vfile/edit_file.jsp" />
</portlet:renderURL>


<table border="0" cellpadding="0" cellspacing="0" width="100%">
<tr>
	<td>
	  <input type="button"  value="<liferay-ui:message key="add" />" onClick="self.location = '<%=addFile %>'" />	 
	</td>
</tr>
<tr>
	<td colspan=2>
 		 <%
		    String language = ParamUtil.getString(request, "language", "vi_VN");
			PortletURL portletURL = renderResponse.createRenderURL();
			List headerNames = new ArrayList();
			headerNames.add("vfile.name");
			headerNames.add("vfile.position");
			headerNames.add("vfile.phone");
			headerNames.add("vfile.address");

			headerNames.add(StringPool.BLANK);
			SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, headerNames, null);			
			searchContainer.setEmptyResultsMessage("there are no leader in this system");
			List results = VFileServiceUtil.findByAll(searchContainer.getStart(),searchContainer.getEnd());
			int total = VFileServiceUtil.countAll();
			searchContainer.setResults(results);
			List resultRows = searchContainer.getResultRows();
			searchContainer.setTotal(results.size());
		    for(int i=0;i<results.size();i++){
			  VFile vfile = (VFile)results.get(i);
			  ResultRow row = new ResultRow(vfile, vfile.getFileId(), i);
			   
				// Title and type
		
				row.addText(vfile.getFullname());
				row.addText(vfile.getPosition());
				row.addText(vfile.getPhone());
				row.addText(vfile.getAddress());

				// Actions
				row.addJSP("right", SearchEntry.DEFAULT_VALIGN, "/html/portlet/vfile/button_file.jsp",application,request,response);
				// Add result row
			
				resultRows.add(row);
		
			}
		%>
	<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
	</td>
</tr>		
</table>
	