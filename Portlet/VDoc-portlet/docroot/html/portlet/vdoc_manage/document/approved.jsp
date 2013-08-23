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
<%@page import="javax.portlet.WindowState"%>
<%@ page import="com.vportal.portlet.vdoc.service.impl.vdocDocumentServiceImpl"%>
<%@ page import="com.vportal.portlet.vdoc.service.util.ActionUtil"%>
<%@ page import="com.vportal.portlet.vdoc.service.persistence.vdocDocumentPersistence"%>
<%@ page import="com.vportal.portlet.vdoc.model.vdocDocument"%>
<%@ page import="com.vportal.portlet.vdoc.service.vdocDocumentService"%>
<%@ page import="com.vportal.portlet.vdoc.service.vdocDocumentServiceUtil" %>
<%@ page import="com.vportal.portlet.vdoc.model.vdocDocument" %>

<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="java.util.List"%>


<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects />
<liferay-theme:defineObjects/>

<portlet:actionURL name="deleteDocument" var="deleteDocumentURL"></portlet:actionURL>
<portlet:actionURL name="publishDocument" var="publishDocumentURL"></portlet:actionURL>
<%
	PortletURL searchURL = renderResponse.createRenderURL();
	searchURL.setWindowState(WindowState.MAXIMIZED);
	searchURL.setParameter("jspPage","/html/portlet/vdoc_manage/view.jsp");
	searchURL.setParameter("tabs1",tabs1);
	searchURL.setParameter("tabs2",tabs2);
	searchURL.setParameter("cmd-searchdoc-flag","true");
%>

<script type="text/javascript">
function <portlet:namespace />submitdeleteDocument() {
		submitForm(document.<portlet:namespace/>fm, '<%=deleteDocumentURL.toString()%>');
}
function <portlet:namespace />submitPublishDocument() {
	submitForm(document.<portlet:namespace/>fm, '<%=publishDocumentURL.toString()%>');
}
function <portlet:namespace />doSearchDocuments() {
	var actionSumit = document.<portlet:namespace />fm;
	actionSumit.action = "<%=searchURL.toString()%>";
	actionSumit.submit();
	
}
</script>

<%
	String fieldId = ParamUtil.getString(request,"fieldId",StringPool.BLANK);
	String orgId = ParamUtil.getString(request,"orgId",StringPool.BLANK);
	String keywords = ParamUtil.getString(request,"keywords",StringPool.BLANK);
	
	String searchFlag = renderRequest.getParameter("cmd-searchdoc-flag");
	int styleOrder = ParamUtil.getInteger(request,"styleOrder",3);
%>

<table width="100%">	
<tr>	
	<td><b><%=LanguageUtil.get(pageContext, "portlet.vdoc.document.keyword")%></b></td>	
	<td><b><%=LanguageUtil.get(pageContext, "portlet.vdoc.document.fields")%></b></td>
	<td><b><%=LanguageUtil.get(pageContext, "portlet.vdoc.document.org")%></b></td>
	<td><b><%=LanguageUtil.get(pageContext, "portlet.vdoc.document.order")%></b></td>
	<td>&nbsp;</td>
</tr>
	
<tr>
	<td><input type="text" name="<portlet:namespace/>keywords" value="<%=keywords%>" style="width:200px;"/></td>
	<td>
		<select name="<portlet:namespace />fieldId" style="width:180px;" onchange="javascript:<portlet:namespace />doSearchDocuments();">
			<option value="0">---<liferay-ui:message key="all" />---</option>
			<%
				out.println(ActionUtil.getFieldTree(groupId, language, fieldId, fieldId));
			%>
		</select>
	</td>	
				
	<td>
		<select name="<portlet:namespace />orgId" style="width: 180px" onchange="javascript:<portlet:namespace />doSearchDocuments();">
			<option value="0">---<liferay-ui:message key="all" />---</option>
			<%
				out.println(ActionUtil.getOrgTree(groupId,language,orgId,orgId));
			%>
		</select>
	</td>
	<td>			
		<select name="<portlet:namespace />styleOrder" onchange="javascript:<portlet:namespace />doSearchDocuments();">
			<option value="3" >Gi&#7843;m d&#7847;n theo ngày</option>
			<option value="4" >T&#259;ng d&#7847;n theo ngày</option>	
			<option value="2" >Tiêu &#273;&#7873; th&#7911; t&#7909;c (A-Z)</option>
			<option value="1" >Tiêu &#273;&#7873; th&#7911; t&#7909;c (Z-A)</option>
		</select>		
	</td>			
				
	<td>			
		<input class="portlet-form-button" type="button" style="width:120px;height:23px;font-weight:bold" value="<%=LanguageUtil.get(pageContext, "portlet.vdoc.document.search-button")%>" 
				onclick="javascript:<portlet:namespace />doSearchDocuments();"></td>
</tr>				
</table>

<br>
<hr width="100%">				
<br>

<input type="button" value='<%=LanguageUtil.get(pageContext, "portlet.vdoc.document.delete")%>' onclick="<portlet:namespace/>deleteDocument()"/>
<input type="button" value='<%=LanguageUtil.get(pageContext, "portlet.vdoc.document.publish")%>'  onclick="<portlet:namespace/>publishDocument()" />

<br/><br/>
<aui:form name="fm" Method="post">
<input name="<portlet:namespace />allRowIds" type="hidden" value="">
<%
	PortletURL renderTabApprovedURL = renderResponse.createRenderURL();
	renderTabApprovedURL.setParameter("jspPage", "/html/portlet/vdoc_manage/view.jsp?tabs1=document-tab&tabs2=portlet.vdoc.information-tab.approved");
%>
<br/><br/>
<liferay-ui:search-container emptyResultsMessage='<%=LanguageUtil.get(pageContext, "portlet.vdoc.document.empty-result-message")%>' delta="15" iteratorURL="<%=renderTabApprovedURL%>">
	<liferay-ui:search-container-results>
		<%
			List<vdocDocument> vdocDocumentList = null;
			if(Validator.isNotNull(searchFlag) && Validator.equals(searchFlag, "true")){
				vdocDocumentList = vdocDocumentServiceUtil.searchDocument(groupId, language, fieldId, orgId, keywords, vdocDocumentServiceImpl.PUBLISH_PENDING); 								
			}else{
				vdocDocumentList = vdocDocumentServiceUtil.getDocByG_L_S(groupId, language, vdocDocumentServiceImpl.PUBLISH_PENDING);
			}
				
			results = ListUtil.subList(vdocDocumentList, searchContainer.getStart(), searchContainer.getEnd());
			total = vdocDocumentList.size();
			pageContext.setAttribute("results", results);
			pageContext.setAttribute("total", total);
		%>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="com.vportal.portlet.vdoc.model.vdocDocument" keyProperty="docId" modelVar="document">
		<%
			String name1 = "<input type='checkbox' name='<portlet:namespace />allRowIds' onclick='Liferay.Util.checkAll(AUI().one(this).ancestor('table.taglib-search-iterator'), '<portlet:namespace/> allRowId', this);'/>";
    		String name="<input type='checkbox'  onclick=\"Liferay.Util.checkAll(AUI().one(this).ancestor('table.taglib-search-iterator'), '<portlet:namespace />allRowIds', this);\" />";
    		String input="<input type='checkbox' name='<portlet:namespace />allRowIds' value='"+document.getDocId()+"'/>";
		
			String titleDoc = document.getTitle();
			StringBuffer title = new StringBuffer();
			title.append("<table cellspacing='3' cellpadding='0' width='100%' border='0'>");
			title.append("<tr>");
			title.append("<td width='1%'><img src='" + themeDisplay.getPathThemeImages() + "/phutho2012/publish_pending.gif'/></td>");
			title.append("<td width='99%' align='left'><b>" + titleDoc + "</b></td>");
			title.append("</tr>");
			title.append("</table>");
		%>
		<liferay-ui:search-container-column-text  name="<%=name %>" value="<%=input %>" />
		<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(pageContext, "portlet.vdoc.document.approve-date") %>' value="<%= ActionUtil.parseDateToString(document.getApprovedDate()) %>"/>
		<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(pageContext, "portlet.vdoc.document.title") %>' value='<%= title.toString() %>'  />
		<liferay-ui:search-container-column-jsp path="/html/portlet/vdoc_manage/document/document_actions.jsp"></liferay-ui:search-container-column-jsp>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
</liferay-ui:search-container>
</aui:form>

<aui:script >
	Liferay.provide(
		window,
		'<portlet:namespace/>deleteDocument',
		function() {
		document.<portlet:namespace />fm.<portlet:namespace />allRowIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "allRowIds");
		
		if(document.<portlet:namespace />fm.<portlet:namespace />allRowIds.value.length>0)
		{
			if (confirm("<%= LanguageUtil.get(pageContext, "portlet.vdoc.are-you-want-to-delete-document") %>")) {
			
		        document.<portlet:namespace />fm.<portlet:namespace />allRowIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "allRowIds");
		    
				<portlet:namespace/>submitdeleteDocument();
			}
		}	else{
			alert("<%= LanguageUtil.get(pageContext, "portlet.vdoc.must-select-document-before-delete") %>");
			}
		},
		['liferay-util-list-fields']
	);
</aui:script>

<aui:script >
	Liferay.provide(
		window,
		'<portlet:namespace/>publishDocument',
		function() {
		document.<portlet:namespace />fm.<portlet:namespace />allRowIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "allRowIds");
		
		if(document.<portlet:namespace />fm.<portlet:namespace />allRowIds.value.length>0)
		{
			if (confirm("Are you want to publish document")) {
			
		        document.<portlet:namespace />fm.<portlet:namespace />allRowIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "allRowIds");
		    
				<portlet:namespace/>submitPublishDocument();
			}
		}	else{
			alert("<%= LanguageUtil.get(pageContext, "portlet.vdoc.must-select-document-before-publish.") %>");
			}
		},
		['liferay-util-list-fields']
	);
</aui:script>













