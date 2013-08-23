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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="/html/portlet/vdoc_manage/init.jsp" %>

<%	
	
	String docId = ParamUtil.getString(request,"docId");	
	
	vdocDocument document = new vdocDocumentImpl();
	
	if (document == null){
		document = new vdocDocumentImpl();
	}		
		
	document = vdocDocumentServiceUtil.getDocument(docId);
	
%>
<portlet:actionURL name="cancelApprovePublish" var="cancelApprovePublishURL" />

<form action="<%= cancelApprovePublishURL %>" method="post" name="<portlet:namespace />fm" >

<input name="<portlet:namespace />docId" type="hidden" value="<%= document.getDocId() %>">

<table border="0" cellpadding="4" cellspacing="0" width="100%">
	<tr>
		<td align="left">			
			<%= LanguageUtil.get(pageContext, ((document.getStatusDoc() == vdocDocumentServiceImpl.PUBLISHED) ? "portlet.vdoc.document.cancel-publish" :  "portlet.vdoc.document.cancel-approve")) %>: <font  style="font-size: 13pt; font-family: tahoma, arial"><%= document.getTitle() %></font>
		</td>
	</tr>
</table>
<div class="beta-separator"></div><br>
<table border="0" cellpadding="4" cellspacing="0" width="100%">
	<tr>
		<td align="left" width="100%" valign="top">
			<fieldset style="border:1px solid">
				<legend><%= LanguageUtil.get(pageContext, ((document.getStatusDoc() == vdocDocumentServiceImpl.PUBLISHED) ? "portlet.vdoc.document.cancel-pub.attached-message" :  "portlet.vdoc.document.cancel-ap.attached-message")) %></legend>
				<table border="0" cellpadding="4" cellspacing="0" width="100%">
					<tr>
						<td align="left" width="100%">
							<textarea name="<portlet:namespace />message" rows="10" style="font-family: verdana, arial, tahoma; font-size: 13px; padding: 10px; width: 90%"></textarea>
						</td>
					</tr>
				</table>
			</fieldset>
		</td>
	</tr>
	<tr>
		<td align="center" width="100%" valign="top">			
			<input type="submit" value='<%= LanguageUtil.get(pageContext, ((document.getStatusDoc() == vdocDocumentServiceImpl.PUBLISHED) ? "portlet.vdoc.document.cancel-publish" :  "portlet.vdoc.document.cancel-approve")) %>'>
			<input type="button" value='<%= LanguageUtil.get(pageContext, "portlet.vdoc.cancel-button") %>' onclick="history.back()" />			
		</td>
	</tr>
</table>
</form>
<script type="text/javascript">
	document.<portlet:namespace />fm.<portlet:namespace />message.focus();
</script>
