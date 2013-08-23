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
<%@ include file="/html/portlet/vsitemap/init.jsp" %>
<%@ taglib  uri="http://liferay.com/tld/ui"  prefix="liferay-ui" %>


<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<liferay-theme:defineObjects />

<%
	String redirect = ParamUtil.getString(request, "redirect"); 
	List listBranch = new ArrayList();	
	
	listBranch = (List)VsmBranchServiceUtil.getByG_L(groupId, language);
	Long tempid1 = ParamUtil.getLong(request, "id");
	/* VsmBranch vsmBranch = (VsmBranchImpl) request.getAttribute("vsmBranch"); */
	VsmBranch vsmBranch = null; 
	if (tempid1!=0){vsmBranch = VsmBranchServiceUtil.getBranch(tempid1);}
	/* VsmBranch vsmBranch = VsmBranchServiceUtil.getBranch(tempid); */
	if(vsmBranch == null){
			vsmBranch = new VsmBranchImpl();
	}
	String branchId = ((vsmBranch != null && Long.toString(vsmBranch.getBranchId()) != null) ? Long.toString(vsmBranch.getBranchId()) : null);
	PortletURL formAction = renderResponse.createActionURL();
	formAction.setParameter("jspPage", "/vsitemap/edit_branch.jsp");	
%>
<portlet:actionURL name="updateBranch" var="updateBranchUrl"/>

<script>
	
	function <portlet:namespace />changeRssableStatus() {		
		var href = document.<portlet:namespace />fm.<portlet:namespace />href;
		var anchored = document.<portlet:namespace />fm.<portlet:namespace />anchored;
		if (!anchored.checked){
		anchored.value=false;}
		else{anchored.value=true;}
		
		href.disabled = !anchored.checked;
	}
	
	function <portlet:namespace />removeImage() {
		document.<portlet:namespace />fm.<portlet:namespace />cmd.value = "remove_icon";
		submitForm(document.<portlet:namespace />fm);
	}
		
	function <portlet:namespace />submitForm(type) {
		var myform = document.<portlet:namespace />fm;
		myform.action="<%= updateBranchUrl.toString() %>";
		myform.method="post";
		
		var name = myform.<portlet:namespace />name;
		var description = myform.<portlet:namespace />description;	
		var anchored = document.<portlet:namespace />fm.<portlet:namespace />anchored;
		var icon = document.<portlet:namespace />fm.<portlet:namespace />icon;
		
		if (!anchored.checked){
			anchored.value=false;}
			else{anchored.value=true;}
		if (type == 0) {
			
			myform.submit();
			return ;
		}
		resetField(name);
		resetField(description);
		
		if (name.value.length<1) {
			alert("<%= LanguageUtil.get(pageContext, "VSitemap.form.nameLink.cannotBlank") %>");
			showErrorField(name);
			name.focus();
			return false;			
		}
		myform.submit();
	}
</script>

<form action="<%=updateBranchUrl.toString()%>" method="post" name="<portlet:namespace />fm" enctype="multipart/form-data" >	
	<input name="<portlet:namespace />id" type="hidden" value="<%= (branchId != null) ? branchId : "" %>">
	<input name="<portlet:namespace />cmd" type="hidden" />
	<input name="<portlet:namespace />redirect" type="hidden" value="<%= redirect %>"/>	
	<input name="<portlet:namespace />groupId" type="hidden" value="<%= groupId %>"/>
	<input name="<portlet:namespace />language" type="hidden" value="<%= language %>"/>
	

<liferay-ui:error exception="<%= IconNameException.class %>">
	<liferay-ui:message key="image-names-must-end-with-one-of-the-following-extensions" /> 
</liferay-ui:error>

<liferay-ui:error exception="<%= IconSizeException.class %>" message="please-enter-a-file-with-a-valid-file-size" />
<!--<liferay-ui:error />-->

<c:if test="<%= !branchId.equalsIgnoreCase(\"0\") %>">
	<liferay-ui:tabs names="C&#7853;p Nh&#7853;t" backURL="<%= redirect %>" />
</c:if>
<c:if test="<%= branchId.equalsIgnoreCase(\"0\") %>">
	<liferay-ui:tabs names="Th&#234;m" backURL="<%= redirect %>" />
</c:if>
	
<table class="lfr-table">
<tr height="30">
	<td><%=LanguageUtil.get(pageContext, "portlet.vsitemap.branch.edit.parentid") %></td>
	<td>
		<select name="<portlet:namespace />parentId" style="width: 200px;">
			<option value="0">--- Ch&#x1ECD;n li&#234;n k&#x1EBF;t cha ---</option>
			<%	for(int i = 0; i < listBranch.size(); i++){
					VsmBranch branch = (VsmBranch)listBranch.get(i);
					if(branch.getBranchId() == vsmBranch.getParentId()){	
			%>
				<option value="<%=branch.getBranchId() %>" ><%= branch.getName() %></option>
			<%	}else{	%>
				<option value="<%= branch.getBranchId() %>"><%= branch.getName()  %></option>
				<%	}}%>			
		</select>
				
			
		
	</td>
</tr>
			
<tr height="30">
	<td><%=LanguageUtil.get(pageContext, "portlet.vsitemap.branch.edit.name") %></td>
	<td>		    	
		<c:if test="<%= branchId.equalsIgnoreCase(\"0\") %>">
    	<liferay-ui:input-field model="<%= VsmBranch.class %>" field="name"  />
    	</c:if>
    	<c:if test="<%= !branchId.equalsIgnoreCase(\"0\") %>">
    	<liferay-ui:input-field model="<%= VsmBranch.class %>" field="name" defaultValue="<%= vsmBranch.getName() %>" />
    	</c:if>
    	
	</td>
</tr>
	
<tr height="30">
	<td>
		<%= LanguageUtil.get(pageContext, "portlet.vsitemap.branch.edit.anchored") %>
	</td>
	<td>
		<input type="checkbox" value="1" id="<portlet:namespace />anchored" name="<portlet:namespace />anchored"  <%= (vsmBranch.getAnchored()==true)? "checked=\"checked\"":"" %>  onClick="javascript:<portlet:namespace />changeRssableStatus();" />
	</td>
</tr>
	
<tr height="30">
	<td>
		<% LanguageUtil.get(pageContext, "portlet.vsitemap.branch.edit.href"); %>
	</td>
	<td>
	<input class="form-text" style="width: 200px" maxlength="100" <%= Validator.isNotNull(vsmBranch.getHref()) ? "" : "disabled" %> id="<portlet:namespace />href" name="<portlet:namespace />href" value="<%= (vsmBranch != null) ? vsmBranch.getHref() : "" %>" />				 
	
	</td>
</tr>
	
<tr height="30">
	<td>
		<% LanguageUtil.get(pageContext, "portlet.vsitemap.branch.edit.icon"); %>
	</td>
<td>
	<c:if test="<%= !vsmBranch.getIcon().equals(\"\")%>">
		<p style="margin: 0px; padding: 0px; padding-bottom: 10px">
			<table cellspacing="0" cellpadding="0" width="100%" border="0">
				<tr>
					<td width="1%" valign="middle"><img src="/html/portlet/vsitemap/images/delete.gif" valign="middle" /></td>
					<td width="25%" valign="middle" style="padding-left: 5px"><a href="#removeImage" onClick="<portlet:namespace />removeImage();"><%= LanguageUtil.get(pageContext, "portlet.vsitemap.branch.edit.remove-image") %></a></td>				
					<td width="1%" valign="middle"><img src="/html/portlet/vsitemap/images/large-image.gif" valign="middle" /></td>
					<td valign="middle" style="padding-left: 5px"><a href="<%= themeDisplay.getPathImage() + "/images?img_id=" + vsmBranch.getIcon() %>" target="_blank"><%= LanguageUtil.get(pageContext, "portlet.vsitemap.branch.edit.fullsize-image") %></a></td>
				</tr>						
			</table>
		</p>
		<img src="<%= themeDisplay.getPathImage() + "/images?img_id=" + vsmBranch.getIcon() %>" border="0" width="200" />
		</c:if>
		<c:if test="<%= vsmBranch.getIcon().equals(\"\")%>">
		<input type="file" class="form-text" width="200" style="width:200px" name="<portlet:namespace />icon"  />
		</c:if>
	
		
	</td>
</tr>
<tr>
	<td colspan="2"><br/></td>
</tr>	

<tr height="30">
	<td><%=LanguageUtil.get(pageContext, "portlet.vsitemap.branch.edit.description") %></td>
	<td>				
		<textarea name="<portlet:namespace />description" id="<portlet:namespace />description" class="lfr-textarea"  style="width:350px"><%= (vsmBranch != null) ? vsmBranch.getDescription() : "" %></textarea>
	</td>
</tr>		
</table>
			
<br/>


	
<input type="button" class="portlet-form-button" name="Save" value="<liferay-ui:message key="L&#x1B0;u" />" onclick="<portlet:namespace />submitForm(1)" />		
<input class="portlet-form-button" type="button" 
		value="<liferay-ui:message key="Hu&#x1EF7;" />"
		onclick="history.back()">
		
		
</form>

<c:if test="<%= windowState.equals(WindowState.MAXIMIZED) %>">
	<script type="text/javascript">
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />name);
	</script>
</c:if>				
				