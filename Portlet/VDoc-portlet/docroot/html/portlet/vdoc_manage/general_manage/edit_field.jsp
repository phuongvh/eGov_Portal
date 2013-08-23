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
<%@page import="com.vportal.portlet.vdoc.model.impl.vdocFieldImpl"%>
<%@page import="com.vportal.portlet.vdoc.model.vdocField"%>
<%@ include file="/html/portlet/vdoc_manage/init.jsp" %>
<portlet:defineObjects />
<liferay-theme:defineObjects/>

<%
	String fieldId = ""; 
	fieldId = request.getParameter("fieldId");
	vdocField field = new vdocFieldImpl();
	String _parentId1 = "0";
	if((fieldId != null) &&(fieldId.trim().length() > 0 )){
		field = vdocFieldServiceUtil.getField(fieldId);
		_parentId1 = field.getParentId();
	}
	int count = vdocFieldServiceUtil.countFieldByG_L(groupId, language);
%>

<portlet:actionURL name="updateField" var="updateFieldURL"/>
<liferay-ui:tabs names='<%= LanguageUtil.get(pageContext,((fieldId != null) &&(fieldId.trim().length() > 0 )) ? "portlet.vdoc.general-manage.update-fields-tab" : "portlet.vdoc.general-manage.add-fields-tab") %>'/>

<form action="<%= updateFieldURL.toString()%>" name="fm" method="post">
	<input type="hidden" name="fieldId" value="<%= (fieldId != null) ? fieldId : "" %>" />
	<table style="width: 100%;border: 0; ">
		<tr height="30">
			<td><b><liferay-ui:message key="portlet.vdoc.general-manage.edit.field-parent" /></b></td>
			<td>
				<select name="parentId" style="width:200px;">
					<option value="0">---<%= LanguageUtil.get(pageContext, "portlet.vdoc.general-manage.edit.field-parent") %>---</option>
					<%	
						out.println(ActionUtil.getFieldTree(groupId, language, _parentId1, fieldId));
					%>	
				</select>
			</td>
		</tr>
		<tr height="30">
			<td><b><liferay-ui:message key="portlet.vdoc.general-manage.edit.name" /></b></td>
			<td><input type="text" name="name" value="<%= field.getName() %>" size="60px"> </td>
		</tr>
		<tr height="30">
			<td><b><liferay-ui:message key="portlet.vdoc.general-manage.edit.description" /></b></td>
			<td><liferay-ui:input-textarea param="description"  defaultValue="<%= field.getDescription() %>"/> </td>
		</tr>
		<tr height="30">
			<td><b><liferay-ui:message key="portlet.vdoc.general-manage.edit.language" /></b></td>
			<td>
				<select name="<portlet:namespace />language" style="width: 200px">
					<%	String selectedLanguage = ((field != null) ? field.getLanguage() : language);
						for (int i = 0; i < locales.length; i++) {
					%>		    
					<option <%= (selectedLanguage.equals(locales[i].getLanguage() + "_" + locales[i].getCountry())) ? "selected" : "" %> value="<%= locales[i].getLanguage() + "_" + locales[i].getCountry() %>"><%= locales[i].getDisplayName(locales[i]) %></option>		    
					<%}%>
	    		</select>
			</td>
		</tr>
		<tr height="30">
			<td><b><liferay-ui:message key="portlet.vdoc.general-manage.position" /></b></td>
			<td> 
				<select name="position">
					<%for(int i = 0; i< count; i++){ %>
								<option value="<%= i+1 %>" selected="<%= (field.getPosition() == (i+1)) %>" ><%= i+1 %>  </option>
					<%} %>
				</select> 
			</td>
		</tr>
		<tr height="30">
			<td><b><liferay-ui:message key="portlet.vdoc.general-manage.edit.status" /></b></td>
			<td><input type="checkbox" <%= (field.getStatusField()) ? "checked=\"checked\"" : "" %> name="<portlet:namespace />status" value="true" /></td>
		</tr>
		<c:if test="<%= (field.getName().trim().length() == 0) %>">
		<tr height="30">
			<td><b><liferay-ui:message key="portlet.vdoc.general-manage.edit.permissions" /></b></td>
			<td>
				<liferay-ui:input-permissions modelName="<%=vdocField.class.getName() %>"/>
			</td>
		</tr>
		</c:if>		
	</table>
	<br/>
	<input type="submit" value='<%= LanguageUtil.get(pageContext, "portlet.vdoc.general-manage.edit.save") %>'>
	<input type="button" value='<%= LanguageUtil.get(pageContext, "portlet.vdoc.cancel-button") %>' onClick="history.back()">
</form>