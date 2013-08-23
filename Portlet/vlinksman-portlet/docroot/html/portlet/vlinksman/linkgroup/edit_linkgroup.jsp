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

<%@include file="/html/portlet/vlinksman/init.jsp"%>

<%
	String redirect = ParamUtil.getString(request, "redirect");	
	LinkGroup linkGroup = (LinkGroup)request.getAttribute("linkGroup");
	if (linkGroup == null){
		linkGroup = new LinkGroupImpl();
	}
	
	String Id = ParamUtil.getString(request, "Id", "0");
// 	String Id = ((linkGroup != null && Long.toString(linkGroup.getLinkgroupId()) != null) ? Long.toString(linkGroup.getLinkgroupId()) : null);
	if(!Id.equals("0") && Id != null){
		linkGroup = LinkGroupServiceUtil.getLinkGroup(Long.valueOf(Id));
	}
	PortletURL formAction = renderResponse.createActionURL();	
%>

<script language="javascript">
	function <portlet:namespace />submitForm() {		
		var myform = document.<portlet:namespace />fm;
		var name = myform.<portlet:namespace />name;
		resetField(name);
		if (name.value.length < 1) {
			alert("<%= LanguageUtil.get(pageContext, "vlink.form.name") %>");
			showErrorField(name);
			return false;
		}
		else{
			submitForm(document.<portlet:namespace />fm, '<portlet:actionURL windowState="<%=WindowState.MAXIMIZED.toString()%>" name="_updateLinkGroup"></portlet:actionURL>');	
		}
		
	}	
</script>
	
<c:if test="<%= !Id.equalsIgnoreCase(\"0\") %>">
	<liferay-ui:tabs names="<%= LanguageUtil.get(pageContext, \"VLinksman.form.action.update\") %>" backURL="<%= redirect %>" />
</c:if>
<c:if test="<%= Id.equalsIgnoreCase(\"0\") %>">
	<liferay-ui:tabs names="<%= LanguageUtil.get(pageContext, \"VLinksman.form.action.add\") %>" backURL="<%= redirect %>" />
</c:if>	
	
<liferay-ui:error exception="<%= InvalidNameLinkGroupException.class %>" message="VLinksman.exception-please-enter-valid-linkgroup-name" />
<portlet:actionURL name="_updateLinkGroup" var="_updateLinkGroupURL"/>
		
<form action="<%= _updateLinkGroupURL.toString() %>" method="post" name="<portlet:namespace />fm" >	
	<input name="<portlet:namespace />Id" type="hidden" value="<%= Id%>">
	<input name="<portlet:namespace />cmd" type="hidden" value="<%=Validator.isNotNull(linkGroup.getLinkgroupId()) ? "doupdate" : "doadd" %>">	
	<input name="<portlet:namespace />redirect" type="hidden" value="<%= redirect %>"/>	
	<input name="<portlet:namespace />groupId" type="hidden" value="<%= groupId %>"/>	
<table>	
<tr height="30">
	<td><%= LanguageUtil.get(pageContext, "VLinksman.form.linkgroup.name") %> :</td>
	<td>
		<liferay-ui:input-field model="<%= LinkGroup.class %>" bean="<%= linkGroup %>" field="name" />
	</td>
</tr>
	
<tr height="30">	
	<td><%= LanguageUtil.get(pageContext, "VLinksman.form.description") %> :</td>
	<td>
		<textarea name="<portlet:namespace />description" class="lfr-textarea" ><%= (linkGroup != null) ? linkGroup.getDescription() : "" %></textarea>
	</td>
</tr>	
</table>
	
<br/>
<input type="button" class="portlet-form-button" value="<%= LanguageUtil.get(pageContext, "VLinksman.form.action.save") %>" onclick=" return <portlet:namespace />submitForm();" />	
<input type="button" class="portlet-form-button" value="<%= LanguageUtil.get(pageContext, "VLinksman.form.action.cancel") %>" onClick="self.location = '<%= redirect %>';" >	
</form>	
<c:if test="<%= windowState.equals(WindowState.MAXIMIZED) %>">
	<script type="text/javascript">
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />name);
	</script>
</c:if>