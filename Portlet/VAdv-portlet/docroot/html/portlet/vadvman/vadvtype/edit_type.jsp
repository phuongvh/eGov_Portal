<%--/**
 * Copyright (c)  Vietsoftware, Inc. All rights reserved.
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
 */ --%>
<%@include file="/html/portlet/vadvman/init.jsp"%>
<%
	String redirect = ParamUtil.getString(request, "redirect");
	String typeIdTemp = ParamUtil.getString(request, "typeId");	
	AdvType type = null;
	if(Validator.isNotNull(typeIdTemp) || !typeIdTemp.equals(""))
		type = AdvTypeServiceUtil.getType(Long.valueOf(typeIdTemp));
	if (type == null){
		type = new AdvTypeImpl();
	}
	
	String itypeId = ((type != null && Long.toString(type.getTypeId()) != null) ? Long.toString(type.getTypeId()) : null);
	
	PortletURL formAction = renderResponse.createActionURL();
	formAction.setParameter("jspPage","/html/portlet/vadvman/vadvtype/view_type.jsp");
%>

<script language="javascript">
	function <portlet:namespace />submitForm(type) {
		var myform = document.<portlet:namespace />fm;
		myform.action="<%= formAction.toString() %>";
		myform.method="post";
		
		var name = myform.<portlet:namespace />name;
		
		if (type == 0) {
			return ;
		}
		resetField(name);
		
		if (name.value.length<1) {
			alert("<%= LanguageUtil.get(pageContext, "VAdvman.form.nameType") %> <%= LanguageUtil.get(pageContext, "VAdvman.form.cannotBlank") %>");
			showErrorField(name);
			name.focus();
			return false;			
		}	
		submitForm(document.<portlet:namespace />fm, '<portlet:actionURL name="_updateType" windowState="<%= WindowState.MAXIMIZED.toString() %>"></portlet:actionURL>');
	}	
</script>
	
	
<c:if test='<%= itypeId != null %>'>
	<liferay-ui:tabs names="update" backURL="<%= redirect %>" />
</c:if>
<c:if test='<%= itypeId == null %>'>
	<liferay-ui:tabs names="add" backURL="<%= redirect %>" />
</c:if>	
	
<form action="<portlet:actionURL><portlet:param name="struts_action" value="/vadvman/type" />
	</portlet:actionURL>" method="post" name="<portlet:namespace />fm">	
	<input name="<portlet:namespace />typeId" type="hidden" value="<%= (itypeId != null) ? itypeId : "" %>">
	<input name="<portlet:namespace />cmd" type="hidden" value="<%=Validator.isNotNull(type.getTypeId()) ? "doupdate" : "doadd" %>">	
	<input name="<portlet:namespace />redirect" type="hidden" value="<%= redirect %>"/>
	
<table>	
<tr height="30">
	<td><%= LanguageUtil.get(pageContext, "VAdvman.form.nameType") %> :</td>
	<td>
		<input type="text" name="<portlet:namespace />name" value="<%= (type != null) ? type.getName() : "" %>" />
	</td>
</tr>
	
<tr height="30">	
	<td><%= LanguageUtil.get(pageContext, "VAdvman.form.descriptionType") %> :</td>
	<td>
		<textarea name="<portlet:namespace />description" id="<portlet:namespace />description" class="lfr-textarea" ><%= (type != null) ? type.getDescription() : "" %></textarea>
	</td>
</tr>
	
</table>
	
	<br/>		
	<input type="button" class="portlet-form-button" value="<liferay-ui:message key="save" />" onclick="<portlet:namespace />submitForm(1)" />	
	<input type="button" class="portlet-form-button" value="<liferay-ui:message key="cancel"/>" onClick="self.location = '<%= redirect %>';" >	
</form>
<c:if test="<%= windowState.equals(WindowState.MAXIMIZED) %>">
	<script type="text/javascript">
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />name);
	</script>
</c:if>	