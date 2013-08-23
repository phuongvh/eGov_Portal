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

<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String temp1 = "box_left_portlet " + styleBullet + " " +styleTitle;
	String temp2 = styleBorder;
	List<LinkGroup> linkGroups = LinkGroupServiceUtil.getAll();
	List listLinks = new ArrayList();
%>



<script type="text/javascript">		
					(function($) {
			$.fn.equalHeights = function(minHeight, maxHeight) {
				tallest = (minHeight) ? minHeight : 0;
				this.each(function() {
					if($(this).height() > tallest) {
						tallest = $(this).height();
					}
				});
				if((maxHeight) && tallest > maxHeight) tallest = maxHeight;
				return this.each(function() {
					$(this).height(tallest).css("overflow","auto");
				});
			}
		})(jQuery);
		</script>	
		<script>
		$(document).ready(function() {
		   $(".blocklink").equalHeights();
		   $(".blocklink:first-child").addClass("leftradius");
		   $(".blocklink:last-child").addClass("rightradius");
		});
		</script>

<div class="blockgroup" style="width: 100%; background-color: #edecec;margin-top: 10px;">     
     	<%								
     	for(int i=0;i<linkGroups.size() ;i++){			
			LinkGroup linkGroup = LinkGroupServiceUtil.getLinkGroup(linkGroups.get(i).getLinkgroupId());
			listLinks = LinksServiceUtil.getByLinkG_GL(groupId, linkGroup.getLinkgroupId());	
			if(listLinks.size()>0){
						
			%>
		<c:if test="<%=linkGroups.size() == 1 %>">	        
        	<div class="blocklink" style="width: 95%;border-radius: 10px 10px 10px 10px;">
            <table>
            <%	for(int j=0;j<listLinks.size();j++){
							Links link = (Links)listLinks.get(j);	%>
                   <tr class="tr_style1"><td class="td_style1">
                   		<div class="imglk">
                   			<img src= "<%= themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + link.getFolderId() + StringPool.SLASH + HttpUtil.encodeURL(HtmlUtil.unescape(link.getImageName())) %>"/>
                   		</div>
	                   <div class="ndlk">
	                   		<a href="<%=link.getUrl()%>" target="<%= (link.getIsTargetBlank())? "_blank":"_self"%>"><%=link.getName()%></a>
	                   </div>	                   
	                   </td>
                   </tr>
              <%}%>                  
            </table>
            </div>       
       </c:if>
       <c:if test="<%=linkGroups.size() == 2 %>">	        
        	<c:if test="<%=i == 1 %>">
       			<div class="blocklink" style="width: 46%;border-left: 0px;">
	            <table>
	            <%	for(int j=0;j<listLinks.size();j++){
								Links link = (Links)listLinks.get(j);	%>
	                   <tr class="tr_style1"><td class="td_style1">
	                   		<div class="imglk">
	                   			<img src= "<%= themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + link.getFolderId() + StringPool.SLASH + HttpUtil.encodeURL(HtmlUtil.unescape(link.getImageName())) %>"/>
	                   		</div>
		                   <div class="ndlk">
		                   		<a href="<%=link.getUrl()%>" target="<%= (link.getIsTargetBlank())? "_blank":"_self"%>"><%=link.getName()%></a>
		                   </div>	                   
		                   </td>
	                   </tr>
	              <%}%>                  
	            </table>
	            </div>
       		</c:if>        
        	<c:if test="<%=i != 1 %>">
       			<div class="blocklink" style="width: 46%;">
	            <table>
	            <%	for(int j=0;j<listLinks.size();j++){
								Links link = (Links)listLinks.get(j);	%>
	                   <tr class="tr_style1"><td class="td_style1">
	                   		<div class="imglk">
	                   			<img src= "<%= themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + link.getFolderId() + StringPool.SLASH + HttpUtil.encodeURL(HtmlUtil.unescape(link.getImageName())) %>"/>
	                   		</div>
		                   <div class="ndlk">
		                   		<a href="<%=link.getUrl()%>" target="<%= (link.getIsTargetBlank())? "_blank":"_self"%>"><%=link.getName()%></a>
		                   </div>	                   
		                   </td>
	                   </tr>
	              <%}%>                  
	            </table>
	            </div>
       		</c:if>         
       </c:if>
       <c:if test="<%=linkGroups.size() == 3 %>">	
       		<c:if test="<%=i == 0 %>">
       			<div class="blocklink" style="width: 33%;">
	            <table>
	            <%	for(int j=0;j<listLinks.size();j++){
								Links link = (Links)listLinks.get(j);	%>
	                   <tr class="tr_style1"><td class="td_style1">
	                   		<div class="imglk">
	                   			<img src= "<%= themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + link.getFolderId() + StringPool.SLASH + HttpUtil.encodeURL(HtmlUtil.unescape(link.getImageName())) %>"/>
	                   		</div>
		                   <div class="ndlk">
		                   		<a href="<%=link.getUrl()%>" target="<%= (link.getIsTargetBlank())? "_blank":"_self"%>"><%=link.getName()%></a>
		                   </div>	                   
		                   </td>
	                   </tr>
	              <%}%>                  
	            </table>
	            </div>
       		</c:if>
       
       		<c:if test="<%=i == 1 %>">
       			<div class="blocklink" style="width: 32%;border-left: 0px;border-right: 0px;">
	            <table>
	            <%	for(int j=0;j<listLinks.size();j++){
								Links link = (Links)listLinks.get(j);	%>
	                   <tr class="tr_style1"><td class="td_style1">
	                   		<div class="imglk">
	                   			<img src= "<%= themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + link.getFolderId() + StringPool.SLASH + HttpUtil.encodeURL(HtmlUtil.unescape(link.getImageName())) %>"/>
	                   		</div>
		                   <div class="ndlk">
		                   		<a href="<%=link.getUrl()%>" target="<%= (link.getIsTargetBlank())? "_blank":"_self"%>"><%=link.getName()%></a>
		                   </div>	                   
		                   </td>
	                   </tr>
	              <%}%>                  
	            </table>
	            </div>
       		</c:if>        
        	<c:if test="<%=i == 2 %>">
       			<div class="blocklink" style="width: 32%;">
	            <table>
	            <%	for(int j=0;j<listLinks.size();j++){
								Links link = (Links)listLinks.get(j);	%>
	                   <tr class="tr_style1"><td class="td_style1">
	                   		<div class="imglk">
	                   			<img src= "<%= themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + link.getFolderId() + StringPool.SLASH + HttpUtil.encodeURL(HtmlUtil.unescape(link.getImageName())) %>"/>
	                   		</div>
		                   <div class="ndlk">
		                   		<a href="<%=link.getUrl()%>" target="<%= (link.getIsTargetBlank())? "_blank":"_self"%>"><%=link.getName()%></a>
		                   </div>	                   
		                   </td>
	                   </tr>
	              <%}%>                  
	            </table>
	            </div>
       		</c:if>       
       </c:if>
       <c:if test="<%=linkGroups.size() > 3 %>">	        
        	<div class="blocklink" style="width: <%=90/linkGroups.size()%>%;">
            <table>
            <%	for(int j=0;j<listLinks.size();j++){
							Links link = (Links)listLinks.get(j);	%>
                   <tr class="tr_style1"><td class="td_style1">
                   		<div class="imglk">
                   			<img src= "<%= themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + link.getFolderId() + StringPool.SLASH + HttpUtil.encodeURL(HtmlUtil.unescape(link.getImageName())) %>"/>
                   		</div>
	                   <div class="ndlk">
	                   		<a href="<%=link.getUrl()%>" target="<%= (link.getIsTargetBlank())? "_blank":"_self"%>"><%=link.getName()%></a>
	                   </div>	                   
	                   </td>
                   </tr>
              <%}%>                  
            </table>
            </div>       
       </c:if>           
      <%}
      }%>  
                            
</div>

<div class="clear"></div>




