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
<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<%@ page import="com.vportal.portlet.vdoc.service.impl.vdocDocumentServiceImpl"%>
<%@ page import="com.vportal.portlet.vdoc.service.util.ActionUtil"%>
<%@ page import="com.vportal.portlet.vdoc.service.persistence.vdocDocumentPersistence"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ page import="com.vportal.portlet.vdoc.model.vdocDocument"%>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="java.util.List"%>

<%@ page import="com.vportal.portlet.vdoc.service.vdocDocumentService"%>
<%@ page import="com.vportal.portlet.vdoc.service.vdocDocumentServiceUtil" %>
<%@ page import="com.vportal.portlet.vdoc.model.vdocDocument" %>

<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects />
<liferay-theme:defineObjects/>

<portlet:actionURL name="deleteDocument" var="deleteDocumentURL"></portlet:actionURL>
<portlet:actionURL name="approveDocument" var="approveDocumentURL"></portlet:actionURL>
<%
	PortletURL submitURL = renderResponse.createRenderURL();
	submitURL.setWindowState(WindowState.MAXIMIZED);
	submitURL.setParameter("jspPage", "/html/portlet/vdoc_manage/view.jsp");
	submitURL.setParameter("tabs1", tabs1);
	submitURL.setParameter("tabs2", tabs2);
	submitURL.setParameter("cmd-searchdoc-flag","true");
		
%>

<script type="text/javascript">
function <portlet:namespace />submitdeleteDocument() {
		submitForm(document.<portlet:namespace/>fm, '<%=deleteDocumentURL.toString()%>');
}
function <portlet:namespace />submitApproveDocument() {
	submitForm(document.<portlet:namespace/>fm, '<%=approveDocumentURL.toString()%>');
}
function <portlet:namespace />doSearchDocuments() {
	var submitAction = document.<portlet:namespace />fm;
	submitAction.action = "<%= submitURL.toString()%>";
	submitAction.submit();
}
</script>

<%
	String fieldId = ParamUtil.getString(request,"fieldId",StringPool.BLANK);
	String orgId = ParamUtil.getString(request,"orgId",StringPool.BLANK);
	String keywords = ParamUtil.getString(request,"keywords",StringPool.BLANK);	
	
	
	String searchFlag = renderRequest.getParameter("cmd-searchdoc-flag");
	int styleOrder = ParamUtil.getInteger(request,"styleOrder",3);
	
// 	System.out.println("FieldId: " + fieldId+ " OrgId: " + orgId + " StyleOrder: "+styleOrder+ " SearchFlag: "+searchFlag);
	String currentURL = themeDisplay.getURLCurrent();
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
		</select></td>
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
			<option value="3" >Giam dan theo ngay</option>
			<option value="4" >Tang dan theo ngay</option>	
			<option value="2" >Tieu de thu tuc(A-Z)</option>
			<option value="1" >Tieu de thu tuc(Z-A)</option>
		</select>		
	</td>							
	<td>			
		<input class="portlet-form-button" type="submit" style="width:120px;height:23px;font-weight:bold" value="<%=LanguageUtil.get(pageContext, "portlet.vdoc.document.search-button")%>" 
				onclick="javascpirt:<portlet:namespace />doSearchDocuments();">
				
	</td>
</tr>				
</table>

<br>
<hr width="100%">				
<br>

<portlet:renderURL var="addDocument">
	<portlet:param name="jspPage" value="/html/portlet/vdoc_manage/document/edit_document.jsp"/>
	<portlet:param name="currentURL" value="<%=currentURL%>"></portlet:param>
</portlet:renderURL>

<input type="button" value='<%=LanguageUtil.get(pageContext, "portlet.vdoc.document.add")%>'  onclick="window.location.href='<%=addDocument.toString()%>' " />
<input type="button" value='<%=LanguageUtil.get(pageContext, "portlet.vdoc.document.approve")%>'  onclick="<portlet:namespace/>approveDocument()" />
<input type="button" value='<%=LanguageUtil.get(pageContext, "portlet.vdoc.document.delete")%>' onclick="<portlet:namespace/>deleteDocument()"/>


<%-- <img alt="<%= themeDisplay.getPathThemeImages()%>" src="<%= themeDisplay.getPathThemeImages()+"/phutho2012/approval_pending.gif"%> "> --%>
<%
	PortletURL renderTabApprovalPendingURL = renderResponse.createRenderURL();
	renderTabApprovalPendingURL.setParameter("jspPage", "/html/portlet/vdoc_manage/view.jsp?tabs1=document-tab&tabs2=portlet.vdoc.information-tab.not-approve");
%>
<br/><br/>
<aui:form name="fm" Method="post">
<input name="<portlet:namespace />allRowIds" type="hidden" value="">

<liferay-ui:search-container emptyResultsMessage='<%=LanguageUtil.get(pageContext, "portlet.vdoc.document.empty-result-message")%>' delta="15" iteratorURL="<%=renderTabApprovalPendingURL%>">
	<liferay-ui:search-container-results>
		<%
			List<vdocDocument> vdocDocumentList = null;
			if(Validator.isNotNull(searchFlag) && Validator.equals(searchFlag, "true")){
				vdocDocumentList = vdocDocumentServiceUtil.searchDocument(groupId, language, fieldId, orgId, keywords, vdocDocumentServiceImpl.APPROVAL_PENDING); 								
			}else{
				vdocDocumentList = vdocDocumentServiceUtil.getDocByG_L_S(groupId, language, vdocDocumentServiceImpl.APPROVAL_PENDING);
			}

			results = ListUtil.subList(vdocDocumentList, searchContainer.getStart(), searchContainer.getEnd());
			total = vdocDocumentList.size();

			pageContext.setAttribute("results", results);
			pageContext.setAttribute("total", total);
			
			
		%>
	</liferay-ui:search-container-results>
	<%System.out.print("4545"); %>
	<liferay-ui:search-container-row className="com.vportal.portlet.vdoc.model.vdocDocument" keyProperty="docId" modelVar="document">
			<%System.out.print("3434"); %>
			<%
				
				String name1 = "<input type='checkbox' name='<portlet:namespace />allRowIds' onclick='Liferay.Util.checkAll(AUI().one(this).ancestor('table.taglib-search-iterator'), '<portlet:namespace/> allRowId', this);'/>";
	        	String name="<input type='checkbox'  onclick=\"Liferay.Util.checkAll(AUI().one(this).ancestor('table.taglib-search-iterator'), '<portlet:namespace />allRowIds', this);\" />";
	        	String input="<input type='checkbox' name='<portlet:namespace />allRowIds' value='"+document.getDocId()+"'/>";
	        	
				String titleDoc = document.getTitle();
				StringBuffer title = new StringBuffer();
				title.append("<table cellspacing='3' cellpadding='0' width='100%' border='0'>");
				title.append("<tr>");
				title.append("<td width='1%'><img src='" + themeDisplay.getPathThemeImages() + "/phutho2012/approval_pending.gif'/></td>");
				title.append("<td width='99%' align='left'><b>" + titleDoc + "</b></td>");
				title.append("</tr>");
				title.append("</table>");
				
				
			%>
	<%-- 		<liferay-ui:search-container-column-text  name="<%=name %>" value="<%=input %>" /> --%>
			<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(pageContext, "portlet.vdoc.document.create-date") %>' value="<%= ActionUtil.parseDateToString(document.getCreatedDate()) %>"/>
			<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(pageContext, "portlet.vdoc.document.title") %>' value='<%= title.toString() %>'  />
			<liferay-ui:search-container-column-jsp path="/html/portlet/vdoc_manage/document/document_actions.jsp"></liferay-ui:search-container-column-jsp>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" ></liferay-ui:search-iterator>
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
		'<portlet:namespace/>approveDocument',
		function() {
		document.<portlet:namespace />fm.<portlet:namespace />allRowIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "allRowIds");
		
		if(document.<portlet:namespace />fm.<portlet:namespace />allRowIds.value.length>0)
		{
			if (confirm("Are you want to approve document")) {
			
		        document.<portlet:namespace />fm.<portlet:namespace />allRowIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "allRowIds");
		    
				<portlet:namespace/>submitApproveDocument();
			}
		}	else{
			alert("You must select document before approve.");
			}
		},
		['liferay-util-list-fields']
	);
</aui:script>

<portlet:actionURL name="searchDoc" var="searchDocURL" />
<%-- <form name="fm" method="post" action="<%=searchDocURL %>"> --%>
 <!-- 	<input type="submit" name="search"  /> --> 
<!-- </form> -->







