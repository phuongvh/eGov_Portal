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

<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@include file="/html/portlet/vlinksman/init.jsp"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://www.vietsoftware.com/tld" prefix="vportal" %>

<%
	Links link = (Links) request.getAttribute("link");
	if (link == null) {
		link = new LinksImpl();
	}
	
	String itemIdTemp = ParamUtil.getString(request, "linkId");
	Links item = null;
	if(Validator.isNotNull(itemIdTemp) || !itemIdTemp.equals(""))
		item = LinksServiceUtil.getLinks(Long.valueOf(itemIdTemp));
	if (item == null){
		item = new LinksImpl();
	}
	
	String itemId = ((item != null && Long.toString(item.getLinkId()) != null) ? Long.toString(item.getLinkId()) : null);

	List linkGroups = LinkGroupServiceUtil.getByGroupId(groupId);
	List listLinks = new ArrayList();
	listLinks = LinksServiceUtil.getByGroupId(groupId);

	String linkId = ParamUtil.getString(request, "linkIds", "0");
	if(!linkId.equals("0") && linkId != null){
		link = LinksServiceUtil.getLinks(Long.valueOf(linkId));
	}
	//	String linkId = ((link != null && Long.toString(link.getLinkId()) != null) ? Long.toString(link.getLinkId()) : null);
	String linkgroupId = ParamUtil.getString(request, "linkgroupId",
			StringPool.BLANK);

	String redirect = ParamUtil.getString(request, "redirect");

	PortletURL formAction = renderResponse.createActionURL();
%>

<script language="javascript">	
		
	function <portlet:namespace />submitForm(type) {
		var myform = document.<portlet:namespace />fm;		
		myform.action="<%=formAction.toString()%>";		
		myform.method="post";
		
		var name = myform.<portlet:namespace />name		
		var url = myform.<portlet:namespace />url;
		
		// validate URL	
		var r = new RegExp(/^(([\w]+:)?\/\/)?(([\d\w]|%[a-fA-f\d]{2,2})+(:([\d\w]|%[a-fA-f\d]{2,2})+)?@)?([\d\w][-\d\w]{0,253}[\d\w]\.)+[\w]{2,4}(:[\d]+)?(\/([-+_~.\d\w]|%[a-fA-f\d]{2,2})*)*(\?(&?([-+_~.\d\w]|%[a-fA-f\d]{2,2})=?)*)?(#([-+_~.\d\w]|%[a-fA-f\d]{2,2})*)?$/);
			
		if (type == 0) {
			myform.submit();
			return ;
		}
		resetField(name);
		resetField(url);
		
		if (name.value.length<1) {
			alert("<%=LanguageUtil.get(pageContext, "VLinksman.form.name")%> <%=LanguageUtil.get(pageContext,
					"VLinksman.form.cannotBlank")%>");
			showErrorField(name);
			name.focus();
			return false;			
		}		
		if (url.value.length<1){
			alert("<%=LanguageUtil.get(pageContext, "VLinksman.form.url")%> <%=LanguageUtil.get(pageContext,
					"VLinksman.form.cannotBlank")%>");
			showErrorField(url);
			url.focus();
			return false;
		}
		
		if(!r.test(url.value)){
			alert("<%=LanguageUtil.get(pageContext, "VLinksman.form.url")%> <%=LanguageUtil.get(pageContext, "VLinksman.form.invalid")%>");
			showErrorField(url);
			url.value = "";
			return false;
		}

		submitForm(
				document.<portlet:namespace />fm,'<portlet:actionURL windowState="<%=WindowState.MAXIMIZED.toString()%>" name="_updateLink"></portlet:actionURL>');
	}	
	
</script>
<portlet:actionURL name="_updateLink" var="_updateLinkURL" />
<c:if test="<%=!linkId.equalsIgnoreCase(\"0\")%>">
	<liferay-ui:tabs
		names="<%=LanguageUtil.get(pageContext,\"VLinksman.form.action.update\")%>"
		backURL="<%=redirect%>" />
</c:if>
<c:if test="<%=linkId.equalsIgnoreCase(\"0\")%>">
	<liferay-ui:tabs names="<%=LanguageUtil.get(pageContext,\"VLinksman.form.action.add\")%>"
		backURL="<%=redirect%>" />
</c:if>
<!-- enctype="multipart/form-data" --> 
<form action="<%=_updateLinkURL.toString()%>" method="post"
	name="<portlet:namespace />fm" enctype="multipart/form-data" >
	
	<input name="<portlet:namespace />linkId" type="hidden" value="<%=(linkId != null) ? linkId : ""%>"> 
	<input name="<portlet:namespace />cmd" type="hidden" value="<%=Validator.isNotNull(link.getLinkId()) ? "doupdate" : "doadd"%>">
	<input name="<portlet:namespace />redirect" type="hidden" value="<%=renderResponse.createRenderURL().toString() %>" /> 

	<input name="<portlet:namespace />groupId"type="hidden" value="<%=groupId%>" />

	<table class="lfr-table">
		<tr height="30">
			<td><%=LanguageUtil.get(pageContext,
					"VLinksman.form.linkgroupId")%></td>
			<td><select name="<portlet:namespace />linkgroupId"
				style="width: 180px">
					<%
						for (int i = 0; i < linkGroups.size(); i++) {
							LinkGroup linkGroup = (LinkGroup) linkGroups.get(i);
					%>
					<option value="<%=linkGroup.getLinkgroupId()%>"
						<%=(String.valueOf(linkGroup.getLinkgroupId()).equals(
						String.valueOf(link.getLinkgroupId()))
						? "selected"
						: "")%>><%=linkGroup.getName()%></option>
					<%
						}
					%>
			</select></td>
		</tr>
		<tr height="30">
			<td><%=LanguageUtil.get(pageContext, "VLinksman.form.images")%>
				:</td>
			<td><vportal:file-upload entryId="<%=GetterUtil.getLong(itemId , 0)%>" entryClass="<%=Links.class%>" style="2" />
			</td>
		</tr>
		
		<tr height="30">
			<td><%=LanguageUtil.get(pageContext, "VLinksman.form.name")%>
				:</td>
			<td><liferay-ui:input-field model="<%=Links.class%>"
					bean="<%=link%>" field="name" /></td>
		</tr>
<!-- 		<tr height="30"> -->
<%-- 			<td><%=LanguageUtil.get(pageContext, "VLinksman.form.imagename")%> --%>
<!-- 				:</td> -->
<%-- 			<td><liferay-ui:input-field model="<%=Links.class%>" --%>
<%-- 					bean="<%=link%>" field="imageName" /></td> --%>
<!-- 		</tr> -->
		<tr height="30">
			<td><%=LanguageUtil.get(pageContext, "description")%> :</td>
			<td><textarea name="<portlet:namespace />description"
					class="lfr-textarea"><%=(link != null) ? link.getDescription() : ""%></textarea>
			</td>
		</tr>

		<tr height="30">
			<td><%=LanguageUtil.get(pageContext, "url")%> :</td>
			<td><liferay-ui:input-field model="<%=Links.class%>"
					bean="<%=link%>" field="url" /></td>
		</tr>

		<tr height="30">
			<td colspan="2"><b><%=LanguageUtil.get(pageContext,"The-URL-of-the-link-must-be-entered-in-the-format")%> : <font color="red">http://www.</font>*
			</b></td>
		</tr>
		<tr height="30">
	<td><%= LanguageUtil.get(pageContext, "Vlinksman.form.isTargetBlank") %> :</td>
	<td>		
		&nbsp;<input type="checkbox" name="<portlet:namespace />isTargetBlank" id="<portlet:namespace />isTargetBlank" <%= ((item != null) && item.getIsTargetBlank()) ? "checked" : "" %>/></td>
	</tr>	
	</table>

	<br /> <input type="submit" class="portlet-form-button"
		value="<%= LanguageUtil.get(pageContext, "VLinksman.form.action.save") %>" /> <input type="button"
		class="portlet-form-button"
		value="<%= LanguageUtil.get(pageContext, "VLinksman.form.action.cancel") %>"
		onClick="self.location = '<%=redirect%>';" />
</form>
<c:if test="<%=windowState.equals(WindowState.MAXIMIZED)%>">
	<script type="text/javascript">
		Liferay.Util
				.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />name);
	</script>
</c:if>