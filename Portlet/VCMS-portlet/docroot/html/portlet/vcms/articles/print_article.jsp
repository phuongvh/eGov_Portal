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
<%@ include file="/html/portlet/init.jsp" %>
<%@ include file="/html/portlet/vcms/css.jsp"%>
	
<%@ page import="java.text.DateFormat" %>
	
<%@ page import="com.vportal.portlet.vcms.*" %>
<%@ page import="com.vportal.portlet.vcms.model.*" %>
<%@ page import="com.vportal.portlet.vcms.action.*" %>
<%@ page import="com.vportal.portlet.vcms.service.*" %>
<%@ page import="com.vportal.portlet.vcms.service.impl.*" %>
<%@ page import="com.vportal.portlet.vcms.job.*" %>
<%@ page import="com.vportal.portlet.vcms.util.*" %>
<%@ page import="com.vportal.portlet.vcmsviewcontent.util.*" %>	

<%@ page import="com.vportal.portal.util.*" %>
<%@ page import="com.vportal.portal.model.*" %>
<%@ page import="com.vportal.portal.service.*" %>
<%@ page import="com.vportal.portlet.vcms.model.VcmsPortion" %>
<%@ page import="com.vportal.portlet.vcmsview.util.ConstantsExt" %>	
<%@ page import="com.vportal.portlet.vcmsmenu.action.ActionUtilMenu" %>	
<%@ page import="com.vportal.portal.util.PortalUtilExt" %>	

<%@ page import="java.util.*" %>

<%	
	String printArticleId =  request.getParameter("printArticleId");
	VcmsArticle article = (VcmsArticle)VcmsArticleServiceUtil.getArticle(printArticleId);
	String leadArticle = article.getLead();
	String contentArticle = article.getContent();	
%>
	
<div style="padding-left:5x;padding-right:5px;"><font style="font-size:18px;color:#336699;"><b><%=article.getTitle()%></b></font></div>

<div style="padding-top:5px;">
	<img src="/VCMS-portlet/html/portlet/vcms/images/print.png">
		<a href="#" onclick="javascript:window.print();"><liferay-ui:message key="print-article" /></a>
</div>	
	
<div style="padding-top:5px;">
<c:if test="<%=article.getHasImage()%>">
	<table width="100" border="0" align="left" cellpadding="7" cellspacing="0">
	<tr>
	  <td></td>
	</tr>
  </table>
</c:if>
	
<p align="justify"><b><span style="color:gray;"><%=leadArticle%></span></b>

	<c:if test="<%=article.getHasImage()%>">
	<br /> <br /><br />
	</c:if>
	<%=contentArticle%>
</p>													
 
 </div>	