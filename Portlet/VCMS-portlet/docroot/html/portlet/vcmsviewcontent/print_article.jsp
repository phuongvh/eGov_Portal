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
<%@ page import="com.vportal.util.HtmlExt" %>
<%@ page import="com.liferay.portal.theme.PortletDisplay" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="com.vportal.portlet.vcms.*" %>
<%@ page import="com.vportal.portlet.vcms.model.*" %>
<%@ page import="com.vportal.portlet.vcms.action.*" %>
<%@ page import="com.vportal.portlet.vcms.service.*" %>
<%@ page import="com.vportal.portlet.vcms.service.impl.*" %>
<%@ include file="/html/portlet/vcmsviewcontent/css.jsp"%> 
<liferay-theme:defineObjects />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%
	String printArticleId =  request.getParameter("printArticleId");
	VcmsArticle printArticle = (VcmsArticle)VcmsArticleServiceUtil.getArticle(printArticleId);
%>

<style>
	a {
	    color: #BF5932;
	    text-decoration: none;
	}
	
	a:hover{
		color: #F45316;
	}	
	
	.wd-information {
	    border-bottom: 1px solid #C3C3C3;
	    border-left: 1px solid #C3C3C3;
	    border-right: 1px solid #C3C3C3;
	    clear: both;
	    overflow: hidden;
	    padding: 13px 17px;
	}
	
	.wd-information p {
	    margin: 4px 0;
	}
		
</style>

<div  style="position: relative; ;z-index: 20;">
	<img style="min-width: 620px;min-height: 90px;width: 100%;max-height: 180px;" src="/VCMS-portlet/html/portlet/vcmsviewcontent/images/bannerPrintf.JPG">	
</div>

<div style="heigth:28px;width:620px;" >	
	<table width="100%">
	<tr>
		
	</tr>
	</table>
</div>	
	
<div>	
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	 <tr>
	    <td height="8" align="right" style="padding-right:15px;">
			<img src="/VCMS-portlet/html/portlet/vcmsviewcontent/images/icon-print.png"><a href="#" onclick="javascript:window.print();" style="font-size: 12px; font-family: Arial;"> &nbsp; In bài vi&#7871;t</a>
		</td>	     
    </tr>     
    
	<tr>
		<td align="justify" valign="top">
			<div style="font-family:Arial; padding-left:15x;padding-right:5px;padding-bottom:5px; color:#0260AA; float:left; font-size:14px;font-weight:bold;text-decoration:none;width:99%;">
				<%=printArticle.getTitle()%>
			</div>
			<div style="padding-top:0px;">
				<%-- <%
					if(printArticle.getHasImage()){
				%>
				
					<table width="100" border="0" align="left" cellpadding="7" cellspacing="0">
						<tr>
					  		<td valign="top">
					  			<div style="background-color:#FFFFFF;border:1px solid #78A3B9;float:left;margin-right:5px;padding:4px;">
					  				<img src="/image/images?img_id=<%=printArticle.getImage()  %>" width="183" align="absmiddle" />
					  			</div>
					  			<div style="padding: 4px;margin-right:5px; font-size: 12px; font-family: Arial; text-align: justify;"><%=printArticle.getImageTitle() %></div>
					  		</td>
						</tr>
				  	</table>
				<%
					}
				%> --%>
			 	<div align="justify">
			 		<b><span style="color:gray; font-family: Arial; size:10px;"><%=printArticle.getLead()%></span></b>
			 	</div>
			 	<div align="justify">
			 		<%=printArticle.getContent()%>
			 	</div>			 							 	
			</div>
		</td>
	</tr>
	
	</table>
</div>	
	
<div align="center" style="background-color:#f1e6d7; padding: 3px 0px;margin-bottom: 11px;"></div>
<div class="wd-information">
						<p>&#169; <span>C&#7893;ng Giao ti&#7871;p &#273;i&#7879;n t&#7917; Th&#224;nh ph&#7889; H&#224; N&#7897;i</span></p>
						<p>Gi&#225;m &#273;&#7889;c: <span>Hoa Thanh H&#7843;i</span></p>
						<p>S&#7889; gi&#7845;y ph&#233;p: 70/GP-TT&#272;T, c&#7845;p ng&#224;y 26/06/2009</p>
						<p>&#272;&#7883;a ch&#7881;: s&#7889; 185 Gi&#7843;ng V&#245;, &#272;&#7889;ng &#272;a, H&#224; N&#7897;i - &#272;i&#7879;n tho&#7841;i: (04)35121395 - Fax : (04)35121395; Email: <a class="link-email" href="mailto:conggiaotiepdientu@hanoi.gov.vn">conggiaotiepdientu@hanoi.gov.vn</a></p>
						<p>Ghi r&#245; ngu&#7891;n 'C&#7893;ng Giao ti&#7871;p &#273;i&#7879;n t&#7917; TP H&#224; N&#7897;i' ho&#7863;c <a href="www.hanoi.gov.vn">'www.hanoi.gov.vn'</a> khi ph&#225;t h&#224;nh l&#7841;i th&#244;ng tin t&#7915; Website n&#224;y. </p>
					</div>