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
<%	
	String tabsReportNames = "";
	if(showTabReportUser){
		tabsReportNames = "portlet.vcms.tabs.report_user";
	}
	if(showTabReportCategory){
		tabsReportNames += ",portlet.vcms.tabs.report_category";
	}
	if(showTabReportByDate){
		tabsReportNames += ",portlet.vcms.tabs.report_bydate";
	}
	if(showTabReportByType){
		tabsReportNames += ",portlet.vcms.tabs.report_bytype";
	}		
%>
<liferay-ui:tabs names="<%= tabsReportNames %>" url="<%=portletURL.toString()%>" param="tabs3"/>
<c:choose>		
		<c:when test='<%= tabs3.equals("portlet.vcms.tabs.report_category")&& showTabReportCategory%>'>
			<%@ include file="/html/portlet/vcms/report/report_category.jsp" %>
		</c:when>
		<c:when test='<%= tabs3.equals("portlet.vcms.tabs.report_bydate")&& showTabReportByDate%>'>			
			<jsp:include page="/html/portlet/vcms/report/report_bydate.jsp"/>
		</c:when>
		<c:when test='<%= tabs3.equals("portlet.vcms.tabs.report_bytype")&& showTabReportByType%>'>			
			<jsp:include page="/html/portlet/vcms/report/report_bytype.jsp"/>
		</c:when>
		<c:otherwise>
			<jsp:include page="/html/portlet/vcms/report/report_user.jsp"/>
		</c:otherwise>
</c:choose>













