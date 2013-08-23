<%--/**
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
 */ --%>
<%@ include file="/html/portlet/manage_vclip/init.jsp" %>

<%
	String redirect = ParamUtil.getString(request, "redirect");
	String cmd = ParamUtil.getString(request, Constants.CMD);
	String clipTypeId = ParamUtil.getString(request, WebKeysVClip.CLIP_TYPE_ID);
	ClipType clipType = (ClipType) request.getAttribute(WebKeysVClip.CLIP_TYPE);
	if (clipType == null) {
		clipType = new ClipTypeImpl();
	}
	if(Validator.isNotNull(clipTypeId)){
		clipType = ClipTypeLocalServiceUtil.getClipType(clipTypeId);
	}
	PortletURL formAction=renderResponse.createActionURL();
	formAction.setWindowState(WindowState.MAXIMIZED);
	formAction.setParameter("tabs1",tabs1);
	formAction.setParameter("redirect",redirect);
%>
<script >
		
	function <portlet:namespace />validate() {
		var myform = document.<portlet:namespace />fm;
		var title = document.<portlet:namespace />fm.<portlet:namespace />title;
		var name = document.<portlet:namespace />fm.<portlet:namespace />name;
		var description = document.<portlet:namespace />fm.<portlet:namespace />description;
		
		resetField(name);
		resetField(title);
		resetField(description);	
			
		if(title.value.length > 300){
			alert("<%=LanguageUtil.get(pageContext,"vportal.vclip.form.validSize")+" 300" %>");
			showErrorField(title);
			return false;
		}
		
		if(name.value==""){
			alert("<%=LanguageUtil.get(pageContext,"vportal.vclip.form.enterClipTypeName")%>");
			showErrorField(name);
			return false;
		}
		
		if(name.value.length > 300){
			alert("<%=LanguageUtil.get(pageContext,"vportal.vclip.form.validSize")+" 300" %>");
			showErrorField(name);
			return false;
		}
		
		if(description.value.length > 1000){
			alert("<%=LanguageUtil.get(pageContext,"vportal.vclip.form.validSize")+" 1000" %>");
			showErrorField(description);
			return false;
		}
		
		return true;
	}
	
	function <portlet:namespace />submitForm(type) {
		if (type!=0) {
			if (!<portlet:namespace />validate()) {
				return;
			}
		}
		var myform = document.<portlet:namespace />fm;
		myform.method = "post";
		myform.submit();
	}

</script>

<vportal:tabs names="vportal.vclip.clipType" backURL="<%= redirect %>" />


<script>
	function <portlet:namespace />submit(){
		document.<portlet:namespace />fm.submit();
	}
</script>

<fieldset>
<form name="<portlet:namespace />fm" method="post" action="<portlet:actionURL></portlet:actionURL>" enctype="multipart/form-data">
<div class="portlet-font" style="font-weight: bold; float: left; margin-right: 10px">
	<table align="center">
		<input type="hidden" name="<%=Constants.CMD%>"	value="<%=Constants.SAVE%>">
		<input type="hidden" name="type" value="cliptype">
		<input type="hidden" name="<%=WebKeysVClip.CLIP_TYPE_ID%>" value="<%=(Validator.isNotNull(clipTypeId))? clipTypeId : clipType.getId()%>">
		<input type="hidden" name="redirect" value="<%=redirect%>">
		<tr>
			<td colspan="2" align="center">	<strong><%=LanguageUtil.get(pageContext,"vportal.vclip.cliptype.info") %></strong></td>
		</tr>
		
		<input type="hidden" name="language" value="<%=language%>">
		
		<tr>
			<td><%=LanguageUtil.get(pageContext,"vportal.vclip.cliptitle.title") %>:</td>
			 <td ><input size="64" type="text" name="<portlet:namespace />title" value="<%=clipType.getTitle()%>" ></td> 
			<!--<td ><liferay-ui:input-field model="<%= ClipType.class %>" bean="<%= clipType %>" field="title" /></td>-->
		</tr>
		
		<tr>
			<td><%=LanguageUtil.get(pageContext,"vportal.vclip.cliptitle.name") %>:</td>
			 <td ><input size="64"  type="text" name="<portlet:namespace />name" value="<%=clipType.getName() %>"></td> 
			<!--<td ><liferay-ui:input-field model="<%= ClipType.class %>" bean="<%= clipType %>" field="name" /></td>-->
		</tr>
				
		<tr>
			<td valign="top"><%=LanguageUtil.get(pageContext,"vportal.vclip.cliptitle.description") %>:</td>
			<td valign="top"></td>
		</tr>
		<tr>
			<td valign="top"></td>
			<td valign="top">
				 <textarea  rows="10" cols="70" name="<portlet:namespace />description"><%=clipType.getDescription()%></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<br>
				<input class="portlet-form-button" type="button" value="<%=LanguageUtil.get(pageContext,"vportal.vclip.save") %>" onclick="<portlet:namespace />submitForm(1)">
				
				<input class="portlet-form-button" type="button" value="<%=LanguageUtil.get(pageContext,"vportal.vclip.cancel") %>"
					onclick="javascript:document.location='<portlet:renderURL>

					<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.CANCEL%>" />
					<portlet:param name="tabs1" value="<%=tabs1%>" />
				</portlet:renderURL>'" >
			</td>
		</tr>
		
	</table>
</form>
</fieldset>

