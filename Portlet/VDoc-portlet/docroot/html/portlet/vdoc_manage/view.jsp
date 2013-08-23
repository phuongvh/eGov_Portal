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

<%
		String redirect = ParamUtil.getString(request, "redirect"); 
		String tabsNames = "statistics-tab,document-tab,generalmanage-tab,config-tab";	
		
		PortletURL portletURL = renderResponse.createRenderURL();
		portletURL.setWindowState(WindowState.MAXIMIZED);
		portletURL.setParameter("tabs1", tabs1);
		portletURL.setParameter("tabs2", tabs2);
		portletURL.setParameter("language", language);
		portletURL.setParameter("groupId", String.valueOf(groupId));
		
		PortletURL selecttURL = renderResponse.createRenderURL();
		selecttURL.setWindowState(WindowState.MAXIMIZED);	
		selecttURL.setParameter("jspPage", "/html/portlet/vdoc_manage/view.jsp");
	%>	
	
<form action="<%=portletURL.toString()%>" method="post" name="<portlet:namespace />fm" >

<input name="<portlet:namespace /><%=Constants.CMD%>" type="hidden" value="">
<input type="hidden" name="<portlet:namespace />docId" value="" />
<input type="hidden" name="<portlet:namespace />docIds" value="" />	
<input name="<portlet:namespace />tabs1" type="hidden" value="<%=tabs1%>">
<input name="<portlet:namespace />tabs2" type="hidden" value="<%=tabs2%>">
<input name="<portlet:namespace />redirect" type="hidden" 
	value="<portlet:renderURL windowState="<%=WindowState.MAXIMIZED.toString()%>">
	<portlet:param name="tabs1" value="<%=tabs1%>" />
	<portlet:param name="tabs2" value="<%=tabs2%>" />
	</portlet:renderURL>">

<div>
<table width="100%" cellpadding="0" cellspacing="0" border="0">	
<tr>	
	<td>	
		<h2><liferay-ui:message key="Document Administration" /></h2></td>
		
	<td align="right">
		<select name="<portlet:namespace/>action" onchange="<portlet:namespace/>choiceAction()">
			<option value="0" selected="selected">-- <liferay-ui:message key="quick-action" /> --</option>
			<option value="1"><liferay-ui:message key="portlet.vdoc.add-document" /></option>
			<option value="2"><liferay-ui:message key="portlet.vdoc.add-field" /></option>
			<option value="3"><liferay-ui:message key="portlet.vdoc.add-org" /></option>
		</select>
	</td>
</tr>		
</table>
</div>
		
<div class="portlet-font" style="font-weight: bold; float: left; margin-right: 10px;" align="left">
	<liferay-ui:message key="language" />
</div>

<div class="portlet-font" style="float: left; margin-right: 10px" align="left">
	<select name="<portlet:namespace />language" onChange="javascript:<portlet:namespace />submitForm();">
		<%
			for (int i = 0; i < locales.length; i++) {
		%>
			<option <%=((language.equals(locales[i].getLanguage() + "_" + locales[i].getCountry())) ? "selected" : "")%> value="<%=locales[i].getLanguage() + "_" + locales[i].getCountry()%>"><%=locales[i].getDisplayName(locales[i])%></option
		><%
				}
			%>
	</select>
</div>		

	
<br/><br/>

<liferay-ui:tabs names="<%=tabsNames%>" param="tabs1" url="<%=portletURL.toString()%>" />
<c:choose>
	<c:when test='<%=tabs1.equals("generalmanage-tab")%>'>
		<%@include file="/html/portlet/vdoc_manage/general_manage/general_manage.jsp" %>
	</c:when>
	<c:when test='<%=tabs1.equals("document-tab")%>'>
		<%@include file="/html/portlet/vdoc_manage/document/view_document.jsp" %>
	</c:when>	
	<c:when test='<%=tabs1.equals("config-tab")%>'>
		<%@include file="/html/portlet/vdoc_manage/configuration/configuration.jsp" %>
	</c:when>	
	<c:otherwise>
		<%@include file="/html/portlet/vdoc_manage/statistics/statistics.jsp" %>
	</c:otherwise>
</c:choose>	
</form>			

<portlet:renderURL var="addDocURL">
	<portlet:param name="jspPage" value="/html/portlet/vdoc_manage/document/edit_document.jsp"/>
	<portlet:param name="docId" value=""/>
</portlet:renderURL>
<portlet:renderURL var="addFieldURL">
	<portlet:param name="jspPage" value="/html/portlet/vdoc_manage/general_manage/edit_field.jsp"/>
	<portlet:param name="fieldId" value=""/>
</portlet:renderURL>
<portlet:renderURL var="addOrgURL">
	<portlet:param name="jspPage" value="/html/portlet/vdoc_manage/general_manage/edit_org.jsp"/>
	<portlet:param name="orgId" value=""/>
</portlet:renderURL>

<script type="text/javascript">
function <portlet:namespace />addDoc() {
	submitForm(document.<portlet:namespace />fm, '<%=addDocURL.toString() %>');
};
function <portlet:namespace />addField() {
	submitForm(document.<portlet:namespace />fm, '<%=addFieldURL.toString() %>');
};
function <portlet:namespace />addOrg() {
	submitForm(document.<portlet:namespace />fm, '<%=addOrgURL.toString() %>');
};

function <portlet:namespace />choiceAction(){
	var type = document.<portlet:namespace/>fm.<portlet:namespace/>action.value;
	if (type == 1){
		<portlet:namespace />addDoc();
	}else if(type == 2){
		<portlet:namespace />addField();
	}else if(type == 3){
		<portlet:namespace />addOrg();
	}
};
function <portlet:namespace />submitForm() {
	submitForm(document.<portlet:namespace />fm,'<%=selecttURL.toString()%>');
};
</script>