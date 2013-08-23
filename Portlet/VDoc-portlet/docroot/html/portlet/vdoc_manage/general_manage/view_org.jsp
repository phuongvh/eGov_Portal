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

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%@ page import="javax.portlet.PortletURL" %>

<%@page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>

<%@ page import="java.util.List" %>
<%@ page import="com.vportal.portlet.vdoc.service.util.ActionUtil" %>
<%@ page import="com.vportal.portlet.vdoc.model.vdocOrg" %>
<%@ page import="com.vportal.portlet.vdoc.model.impl.vdocOrgImpl"%>
<%@ page import="com.vportal.portlet.vdoc.service.vdocOrgService"%>
<%@ page import="com.vportal.portlet.vdoc.service.vdocOrgServiceUtil" %>
<%@page import="com.vportal.portlet.vdoc.service.vdocDocumentServiceUtil"%>

<portlet:defineObjects />
<liferay-theme:defineObjects/>

<portlet:actionURL name="updateOrgPosition" var="updateOrgPositionURL"/>

<script type="text/javascript">
function <portlet:namespace />updateOrgPosition(selector) {
// 		document.<portlet:namespace />fm.<portlet:namespace />position.value = selector.value;
		submitForm(document.<portlet:namespace/>fm, '<%=updateOrgPositionURL.toString()%>');
}
</script>

<%
	// Add Org
	PortletURL addOrgURL = renderResponse.createRenderURL();
	addOrgURL.setParameter("jspPage","/html/portlet/vdoc_manage/general_manage/edit_org.jsp");
	
	// Render search container
	PortletURL renderTabOrgURL = renderResponse.createRenderURL();
	renderTabOrgURL.setParameter("jspPage","/html/portlet/vdoc_manage/view.jsp?tabs1=generalmanage-tab&tabs2=portlet.vdoc.general-manage.orgs-tab");
	
	PortletURL subOrgURL = renderResponse.createRenderURL();
	subOrgURL.setParameter("jspPage", "/html/portlet/vdoc_manage/view.jsp?tabs1=generalmanage-tab&tabs2=organization-tab");
	
	PortletURL orgURL = renderResponse.createRenderURL();
	orgURL.setParameter("jspPage", "/html/portlet/vdoc_manage/view.jsp?tabs1=generalmanage-tab&tabs2=organization-tab");
	
	String listParent="";
	String listURL = "";
	
	String parentIds[]=null;	
	if(!parentId2.equals(StringPool .BLANK) && !parentId2.equals("0")){
		listParent = ActionUtil.getListParent(parentId2);
		parentIds = listParent.split(",");
	}
	if(!listParent.equals("")){
		listURL = "<a href=\""+orgURL.toString()+"\">Th&#432; m&#7909;c g&#7889;c</a>";
		for(int i=parentIds.length-1;i>=0;i--){
	vdocOrg org = vdocOrgServiceUtil.getOrg(parentIds[i]);
	orgURL.setParameter("parentId2", org.getOrgId());	
	listURL = listURL +" >> " + "<a href=\""+orgURL.toString()+"\">"+ org.getName()+"</a>";
		}
	}
%>

<input type="button" value='<%=LanguageUtil.get(pageContext, "portlet.vdoc.add-org")%>' onclick="window.location.href='<%=addOrgURL.toString()%>' " />
<br/>
<%=listURL%>

<br/><br/>
<%
	List<vdocOrg> listOrg = vdocOrgServiceUtil.getOrgByG_L_P(groupId, language, parentId2);
	int count = vdocOrgServiceUtil.countOrgByG_L_P(groupId,language,parentId2);
%>
<form name="<portlet:namespace/>fm" method="post">
<input type="hidden" name="userId" value="<%=themeDisplay.getUserId()%>" />
<liferay-ui:search-container emptyResultsMessage='<%=LanguageUtil.get(pageContext, "portlet.vdoc.general-manage.org.empty-result-message")%>' delta="15" iteratorURL="<%=renderTabOrgURL%>">
	<liferay-ui:search-container-results>
		<%
			results = ListUtil.subList(listOrg, searchContainer.getStart(), searchContainer.getEnd());
			total = listOrg.size();			
			pageContext.setAttribute("results", results);
			pageContext.setAttribute("total", total);
		%>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="com.vportal.portlet.vdoc.model.vdocOrg" modelVar="org" keyProperty="orgId">
		<%			
			List<vdocOrg> children = vdocOrgServiceUtil.getOrgByG_L_P(groupId, language, org.getOrgId());
			int childrenCount = 0;
			childrenCount = children.size();
			
			PortletURL rowURL = renderResponse.createRenderURL();
			rowURL.setParameter("jspPage", "/html/portlet/vdoc_manage/view.jsp?tabs1=generalmanage-tab&tabs2=organization-tab");
			rowURL.setParameter("parentId2", org.getOrgId());
			
			StringBuffer sb = new StringBuffer();
			sb.append("<table cellspacing='3' cellpadding='0' width='100%' border='0'>");
			sb.append("<tr>");
			sb.append("<td width='1%'><img src='" + themeDisplay.getPathThemeImages() + "/phutho2012/category.gif' valign='middle' /></td>");
			sb.append("<td width='99%'><b><a href=\""+	rowURL.toString()+"\">" + org.getName() + "</a></b></td>");
			sb.append("</tr>");		
			
			if (childrenCount > 0) {
				sb.append("<tr>");
				sb.append("<td width='1%'><img src='" + themeDisplay.getPathThemeImages() + "/phutho2012/children.gif' valign='middle' /></td>");
				sb.append("<td width='99%' align='left'><span style='font-size: xx-small;'><b><u>" + LanguageUtil.get(pageContext, "portlet.vdoc.field.list.sub-org","sub-org") + "</u>:");
				for (int j = 0; j < childrenCount; j ++) {
					vdocOrg child = (vdocOrg) children.get(j);
				
					subOrgURL.setParameter("orgId",child.getOrgId());
					subOrgURL.setParameter("parentId2",child.getOrgId());
					sb.append("<a href=\""+subOrgURL.toString()+"\">"+child.getName()+"</a>");
					
					if (j < childrenCount - 1) {
						sb.append(", ");
					}
				}
				sb.append("</b></span></td>");
				sb.append("</tr>");
			}
			
			sb.append("</table>");
		%>
		<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(pageContext, "portlet.vdoc.general-manage.name-orgs") %>' value='<%= String.valueOf(org.getOrgId()) %>' />
		<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(pageContext, "portlet.vdoc.general-manage.name-orgs") %>' value='<%= sb.toString() %>' />
		<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(pageContext, "portlet.vdoc.general-manage.position") %>'>
			<select name="position" label="" onChange="<portlet:namespace />updateOrgPosition(this)">
			<% for(int i =0; i < count ; i++){ %>
				<option value="<%= i+1+ "|" + org.getPrimaryKey() %>"  <%= ((i+1) ==org.getPosition())? "selected":"" %>><%= i+1 %>  </option>
				<%} %>
			</select>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-jsp path="/html/portlet/vdoc_manage/general_manage/org_actions.jsp"/>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
</liferay-ui:search-container>
</form>


