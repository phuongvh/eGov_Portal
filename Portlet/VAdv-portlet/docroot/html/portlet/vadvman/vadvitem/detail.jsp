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
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portlet.documentlibrary.util.DLUtil"%>
<%@page import="com.liferay.portal.kernel.util.PropsKeys"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryServiceUtil"%>
<%@ include file="/html/portlet/vadvman/init.jsp" %>
<%	
	String redirect = ParamUtil.getString(request, "redirect");
	String itemId =  ParamUtil.getString(request, "itemId");//(String)request.getAttribute("itemId");
	String extension = StringPool.BLANK;
	try {
		if(Validator.isNotNull(itemId)){

			AdvItem item = AdvItemServiceUtil.getItem(Long.parseLong(itemId));
			AdvType type = AdvTypeServiceUtil.getType(item.getTypeId());

			DLFileEntry fileEntry = DLFileEntryServiceUtil.getFileEntry(groupId, item.getFolderId(), item.getName());
			String fileExtension =fileEntry.getTitle();
			extension = fileExtension.substring(fileExtension.lastIndexOf(".")+1,fileExtension.length());
			//Check format file to show
			boolean validImageExtension = false;	

			String[] imageExtensions = PropsUtil.getArray(PropsKeys.BLOGS_IMAGE_EXTENSIONS);
			String fileExtension2 = item.getName();
			String extensionFile = fileExtension2.substring(fileExtension2.lastIndexOf("."),fileExtension2.length());
			for (int i = 0; i < imageExtensions.length; i++) {
				if (extensionFile.equals(imageExtensions[i])) {
					validImageExtension = true;
				}
			}

%>
<input name="<portlet:namespace />redirect" type="hidden" value="<%= currentURL %>"/>
	
<table class="lfr-table" width="100%">
<tr>
	<td width="50%" valign="top">		
		<fieldset style="border:1px dotted gray;">
		<legend><strong>Thông tin qu&#7843;ng cáo</strong></legend>
		<table class="lfr-table">
			<tr>
				<td width="35%" align="left"><b>Tên file:</b></td>
				<td width="65%" align="left"><%= item.getName()%></td>		
			</tr>
				
			<tr>
				<td width="35%" align="left"><b>Mô t&#7843;:</b></td>				
				<td width="65%" align="left"><%= item.getDescription()%></td>
			</tr>
				
			<tr>
				<td width="35%" align="left"><b>&#272;&#432;&#7901;ng d&#7851;n:</b></td>
				<td width="65%" align="left"><%= item.getUrl()%></td>
			</tr>			
			
			<tr>
				<td colspan="2"><br/></td>
			</tr>
				
			<tr>
				<td width="35%" align="left"><b>Ki&#7875;u qu&#7843;ng cáo:</b></td>
				<td width="65%" align="left"><%= type.getName()%></td>
			</tr>	
				
			<tr>
				<td width="35%" align="left"><b>Kích th&#432;&#7899;c:</b></td>
				<td width="65%" align="left"><%= fileEntry.getSize()%> k</td>
			</tr>
				
			<tr>
				<td width="35%" align="left"><b>Download</b></td>
				<td width="65%" align="left">
					<!--img src="<%= themeDisplay.getPathThemeImage() %>/vcms/<%=extension%>.png"/ title="<%=extension%>"-->
					<a href="<%=themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + item.getFolderId() + StringPool.SLASH + HttpUtil.encodeURL(fileEntry.getTitle(), true)%>"><font color="blue"><%= fileEntry.getTitle()%></font></a>
				</td>
			</tr>
			<!--tr>
				<td></td>
				<td><img src="/c/document_library/get_file?p_l_id=<%= layout.getPlid()%>&folderId=<%=item.getFolderId()%>&name=<%=fileEntry.getName()%>" width="640px" height="480px" /></td>
			</tr-->
				
			<c:if test="<%=item.getExpriedDate()!=null && item.getExpriedDate().before(new Date())%>">
			<tr>
				<td colspan="2"><font color="red"><b>Qu&#7843;ng cáo này &#273;ã h&#7871;t h&#7841;n !</b></font></td>
			</tr>
			</c:if>	
		
		</table>
		</fieldset>
	</td>
				
	<td width="50%">
		<table class="lfr-table" align="center">	
		<tr>
			<!--Display Image-->
			<c:if test="<%= validImageExtension  %>">
				<td>
					<div>
						<img src="<%= themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + item.getFolderId() + StringPool.SLASH + HttpUtil.encodeURL(HtmlUtil.unescape(item.getName())) %>">
					</div>
				</td>
			</c:if>
			<!--Display Flash & Video-->
			<c:if test="<%= !validImageExtension %>">
				<td>
					<script type="text/javascript" src="/html/portlet/vadvman/swfobject.js"></script>
					  <div id="preview">This div will be replaced</div>
					  	  
					  <script type="text/javascript">
						  var s1 = new SWFObject("/html/portlet/vadvman/player.swf","ply","470","300","9","#ffffff");
						  var fileURL = encodeURIComponent("<%= themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + item.getFolderId() + StringPool.SLASH + HttpUtil.encodeURL(HtmlUtil.unescape(item.getName())) %>");						  
						  s1.addParam("allowfullscreen","false");
						  s1.addParam("allowscriptaccess","always");
						  s1.addParam("wmode","opaque");
						  s1.addParam("flashvars",'&file=' + fileURL +  '&controlbar=none&autostart=true');
						  s1.write("preview");
					</script>
				</td>
			</c:if>
		</tr>	
		</table>
	</td>
</tr>
</table>
	
<%
		}
	} catch(Exception ex){
		ex.printStackTrace();
		out.println("<b>File qu&#7843;ng cáo này không t&#7891;n t&#7841;i !</b><br/>");
	}
%>

<br/>	
<input type="button" class="portlet-form-button" value="<liferay-ui:message key="back"/>" onClick="self.location = '<%= redirect %>';" >