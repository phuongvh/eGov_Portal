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

<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%
	String temp1 = "box_left_portlet " + styleBullet + " " +styleTitle;
	String temp2 = styleBorder;
	
	List listLinks = new ArrayList();
	
	if(style==1){
		listLinks = LinksServiceUtil.getByLinkG_GL(groupId, Long.parseLong(linkgroupId));

	}else if(style==3){
		listLinks = LinksServiceUtil.getByGroupId(groupId);

	}	

%>


<div class="<%=temp1%>">
	<div class="title">
		<div class="title_wrap">
			<div><%=titlePortlet%></div>
		</div> 
	</div>
	
	<div align="center" class="<%=temp2%>">
	<table>	
		<td height="50" bgcolor="#ffffff"><div align="center">
          <select class="text_none" name="<portlet:namespace/>link" onchange="<portlet:namespace/>visitSite();">
            <option value="0">-----------<%=LanguageUtil.get(pageContext, "VLinksman.form.select") %>---------</option>
        	<% if(Validator.isNotNull(listLinks) && listLinks.size()>0){
        		for(int i=0;i<listLinks.size();i++){
        			Links link = (Links)listLinks.get(i);%>
        		<option value="<%=link.getUrl()%>"><%=link.getName()%></option>
        	<%}}%>
          </select>
	    </div></td>
	  </tr>
	</table>
	</div>	
</div>
			  
