<%--/**
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
 */ --%>
<%@page import="com.vportal.portlet.vadvman.service.AdvTypeServiceUtil"%>
<%@page import="com.vportal.portlet.vadvman.model.AdvType"%>
<%@page import="com.vportal.portlet.vadvman.model.AdvItem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.vportal.portlet.vadvman.service.AdvItemServiceUtil"%>
<div align="center">
	<%
		AdvType type = AdvTypeServiceUtil.getType(typeId);
	%>
	<%=type.getName()%>
</div>
<p/>
<div >
	<%
		for(int i=0;i<listItem.size();i++){
			AdvItem itemTemp = (AdvItem)listItem.get(i);
			if (itemTemp.getExpriedDate()!=null && itemTemp.getExpriedDate().before(new Date())){%>
				
	<%	
			}else{%>
			<a  style="text-decoration: none;" href="<%= itemTemp.getUrl()%>" target="<%= (itemTemp.getIsTargetBlank())? "_blank":"_self"%>" /><%=itemTemp.getDescription()+"   ,   " %></a>				
	<%			
			}
		}
	%>
</div>