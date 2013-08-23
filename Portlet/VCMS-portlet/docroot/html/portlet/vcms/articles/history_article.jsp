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
<%@ include file="/html/portlet/vcms/init.jsp" %>
<%	
	String redirect = ParamUtil.getString(request, "redirect");
	String articleId = ParamUtil.getString(request,"articleId");
	
	
	VcmsArticle article = (VcmsArticle) request.getAttribute(WebKeysExt.VCMS_ARTICLE);
	if(Validator.isNotNull(articleId)){
		
		article = (VcmsArticle)VcmsArticleServiceUtil.getArticle(articleId);
	}
	
	List listHistory = new ArrayList();
	
	listHistory = (List)VcmsArticleStatusLocalServiceUtil.getRelationByArticleId(articleId);	
%>

<table width="100%">
<tr>	
	<td><%= LanguageUtil.get(pageContext, "portlet.vcms.article.history") %>: <%=article.getTitle()%></td>
</tr>
	
<tr height="15"><td>&nbsp;</td></tr>
	
<tr>	
	<td width="100%">	
	<table width="100%" cellspacing="5" cellpadding="5" border="1">
	<tr height="30">
		<td width="50" align="center">STT</td>
		<td width="150" align="center"><%= LanguageUtil.get(pageContext, "date") %></td>
		<td width="150" align="center"><%= LanguageUtil.get(pageContext, "portlet.vcms.article.modifier") %></td>
		<td>&nbsp;<%= LanguageUtil.get(pageContext, "status") %></td>
		<td width="80">&nbsp;<%= LanguageUtil.get(pageContext, "active") %></td>
	
	<%	if(Validator.isNotNull(listHistory) && listHistory.size()>0){
			for(int i=0;i<listHistory.size();i++){
				VcmsArticleStatus  vArticleStatus = (VcmsArticleStatus)listHistory.get(i);
	%>
	<tr height="25">
		<td align="center"><%=(i+1)%></td>
		<td>&nbsp;<%=dateFormatDateTime.format(vArticleStatus.getCreatedDate())%></td>
		<td>&nbsp;<%=vArticleStatus.getCreatedByUser()%></td>
		<td>&nbsp;<%=VcmsStatusLocalServiceUtil.getVcmsStatus(vArticleStatus.getStatusId()).getName()%></td>
		<td align="center">			
			<%if(vArticleStatus.getActive()){%>
				<img src="/html/portlet/vcms/up.png" title="<%= LanguageUtil.get(pageContext, "portlet.vcms.article.up") %>"/>
			<%}else{%>
				<img src="/html/portlet/vcms/down.png" title="<%= LanguageUtil.get(pageContext, "portlet.vcms.article.down") %>" />
			<%}%>
		</td>
	</tr>
	<%}}%>
	</table>
	</td>
</tr>
</table>	

<br/>		
<div>		
	<input class="portlet-form-button" type="button" value='<%= LanguageUtil.get(pageContext, "portlet.vcms.button.return") %>' onClick="self.location = '<%= redirect %>';">
</div>
	
	