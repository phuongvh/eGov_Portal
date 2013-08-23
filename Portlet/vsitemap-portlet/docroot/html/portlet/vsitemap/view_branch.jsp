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

<%@page import="javax.swing.text.Position"%>
<%@page import="com.liferay.portal.kernel.xml.Branch"%>
<%@ include file="/html/portlet/vsitemap/init.jsp" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>

<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<portlet:defineObjects/>
<portlet:actionURL name="updatePosition" var="updatePositionUrl"/>

<script type="text/javascript">
function <portlet:namespace />updateBranchPosition(selector) {	

	var myform = document.<portlet:namespace />fm;
	myform.action= '<%= updatePositionUrl.toString()%>';
	myform.method="post";
	document.<portlet:namespace />fm.<portlet:namespace />position.value = selector.value;
 	myform.submit();
}
</script>


<%
		PortletURL portletURL = renderResponse.createRenderURL();
		portletURL.setWindowState(WindowState.MAXIMIZED);
		portletURL.setParameter("jspPage", "/html/portlet/vsitemap/edit_branch.jsp");
		VsmBranch branch = null;
		List listBranch = new ArrayList();
		listBranch = (List)VsmBranchServiceUtil.getByG_L(groupId, language);

	%>

	<input class="portlet-form-button" type="button" 
		value="Thêm m&#7899;i"
		onclick="window.location.href='<%= portletURL.toString() %>'">

<br>
<br /><br />
<hr />
<br />
<form name="<portlet:namespace />fm" action="<%=updatePositionUrl.toString()%>" method="POST" enctype="multipart/form-data" >
	<input name="<portlet:namespace />ids" type="hidden" value="">
	<input name="<portlet:namespace />cmd" type="hidden" >
	<input name="<portlet:namespace />redirect" type="hidden" value="<%= currentURL %>">
	<input type="hidden" name="<portlet:namespace />position" value="" />		
<liferay-ui:search-container emptyResultsMessage="Ch&#432;a c&#243; link n&#224;o" delta="6">
	
	<liferay-ui:search-container-results>
		<%
		
		List list = new ArrayList();
		for (int i = 0; i < listBranch.size(); i++) {
			branch = (VsmBranch)listBranch.get(i);
		list.add(branch);}
		List result = ListUtil.subList(list, searchContainer.getStart(), searchContainer.getEnd());
		total = list.size();
		pageContext.setAttribute("results", result);
		pageContext.setAttribute("total", total);
		%>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="com.vportal.portlet.vsitemap.model.VsmBranch" rowVar="branch1"  keyProperty="branchId"> 
		<liferay-ui:search-container-column-text name="T&#234;n" property="name"/>
		<liferay-ui:search-container-column-text name="H&#236;nh &#7843;nh" property="hasIcon"/>
		<liferay-ui:search-container-column-text name="Li&#234;n k&#7871;t"  property="anchored"/>
		<liferay-ui:search-container-column-text name="Mi&#234;u t&#7843;"  property="description"/>
		
		<liferay-ui:search-container-column-text name="V&#7883; tr&#237;">
			<select id="SelectPosition" name="SelectPosition" onchange="javascript:<portlet:namespace />updateBranchPosition(this)" >
				<% for(int j = 0; j < total; j++) { branch = VsmBranchServiceUtil.getBranch(Long.valueOf(branch1.getPrimaryKey())); %> 
					<option value="<%=j+1 + "|" + branch1.getPrimaryKey()%>" <%=(j+1==branch.getPosition()) ? "selected" : "" %>><%=j+1%></option>
				<% } %> 
				
			</select> 
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-jsp	path="/html/portlet/vsitemap/branch_action.jsp" align="right" />
		</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
	
</form>
