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
<%@ include file="/html/portlet/vdoc_manage/init.jsp" %>
<portlet:defineObjects />
<liferay-theme:defineObjects/>

<%
	String orgId = ""; 
	orgId = request.getParameter("orgId");
	vdocOrg org = new vdocOrgImpl();
	String _parentId2 = "0";
	if((orgId != null) && (orgId.trim().length() > 0 )){
		org = vdocOrgServiceUtil.getOrg(orgId);
		_parentId2 = org.getParentId();
	}
	int count = vdocOrgServiceUtil.countOrgByG_L(groupId, language);
%>
<portlet:actionURL name="updateOrg" var="updateOrgURL"/>
<liferay-ui:tabs names='<%= LanguageUtil.get(pageContext,((orgId != null) && (orgId.trim().length() > 0 )) ? "portlet.vdoc.general-manage.update-orgs-tab" : "portlet.vdoc.general-manage.add-orgs-tab") %>'/>
	
<form action="<%= updateOrgURL.toString() %>" name="fm" method="post">
	<input type="hidden" name="orgId" value="<%= (orgId != null) ? orgId : "" %>" />
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr height="30">	
			<td><b><liferay-ui:message key="portlet.vdoc.general-manage.edit.org-parent" /></b></td>
			<td>
				<select name="parentId" style="width: 200px">
					<option value="0">---<%= LanguageUtil.get(pageContext, "portlet.vdoc.general-manage.edit.org-parent") %>---</option>
					<%			
						out.println(ActionUtil.getOrgTree(groupId, language, _parentId2, orgId));	
					%>
				</select></td>	
		</tr>
			
		<tr height="30">
			<td><b><liferay-ui:message key="portlet.vdoc.general-manage.edit.name" /></b></td>
			<td>
	 			<input name="<portlet:namespace />name" type="text" style="width:200px;" value="<%= org.getName() %>"> 
			</td>
		</tr>
	
		<tr height="30">
			<td valign="top"><b><liferay-ui:message key="portlet.vdoc.general-manage.edit.description" /></b></td>
			<td>
				<liferay-ui:input-textarea param="description"  defaultValue="<%= org.getDescription() %>"/> </td>
		</tr>
	
		<tr height="30">
			<td valign="top"><b><liferay-ui:message key="portlet.vdoc.general-manage.edit.address" /></b></td>
			<td>
				<liferay-ui:input-textarea param="address"  defaultValue="<%= org.getDescription() %>"/>		</td>
		</tr>
	
		<tr height="30">
			<td><b><liferay-ui:message key="portlet.vdoc.general-manage.edit.phone" /></b></td>
			<td>
	 			<input name="<portlet:namespace />phone" type="text" value="<%=org.getPhone() %>">
			</td>
		</tr>
	
		<tr height="30">
			<td><b><liferay-ui:message key="portlet.vdoc.general-manage.position" /></b></td>
			<td> 
				<select name="portlet.vdoc.general-manage.position">
					<%for(int i = 0; i< count; i++){ %>
								<option value="<%= i+1 %>" selected="<%= (org.getPosition() == (i+1)) %>" ><%= i+1 %>  </option>
					<%} %>
				</select> 
			</td>
		</tr>
		
		<tr height="30">
			<td><b><liferay-ui:message key="portlet.vdoc.general-manage.edit.status" /></b></td>
			<td><input type="checkbox" <%= (org.getStatusOrg()) ? "checked=\"checked\"" : "" %> name="<portlet:namespace />status" value="true" /></td>
		</tr>
		
		<tr height="30">
			<td><b><liferay-ui:message key="portlet.vdoc.general-manage.edit.fax" /></b></td>
			<td>
	   			<input type="text" name="<portlet:namespace />fax" value="<%=org.getFax() %>">
	  		</td>
		</tr>
	
		<tr height="30">
			<td><b><liferay-ui:message key="portlet.vdoc.general-manage.edit.language" /></b></td>
			<td>
				<select name="<portlet:namespace />language" style="width: 200px">
					<%	String selectedLanguage = ((org != null) ? org.getLanguage() : language);
						for (int i = 0; i < locales.length; i++) {
					%>		    
					<option <%= (selectedLanguage.equals(locales[i].getLanguage() + "_" + locales[i].getCountry())) ? "selected" : "" %> value="<%= locales[i].getLanguage() + "_" + locales[i].getCountry() %>"><%= locales[i].getDisplayName(locales[i]) %></option>		    
					<%}%>
	    		</select>
			</td>
		</tr>
		<c:if test="<%= (org.getName().trim().length() == 0) %>">
		<tr height="30">
			<td><b><liferay-ui:message key="portlet.vdoc.general-manage.edit.permissions" /></b></td>
			<td>
				<liferay-ui:input-permissions modelName="<%= vdocOrg.class.getName() %>"/>
			</td>
		</tr>
		</c:if>
	</table>
	<br/>
		
	<input type="submit" value='<%= LanguageUtil.get(pageContext, "portlet.vdoc.general-manage.edit.save") %>'>
	<input type="button" value='<%= LanguageUtil.get(pageContext, "portlet.vdoc.cancel-button") %>' onClick="history.back()">

</form>
		