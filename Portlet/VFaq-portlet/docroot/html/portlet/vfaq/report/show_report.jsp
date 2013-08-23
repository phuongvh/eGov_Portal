<%
	String tabsReportNames = "";
	if(showTabReportQByDate){
		tabsReportNames = "com.vportal.portlet.vfaq.report_questionbydate";
	}
	if(showTabReportAByDate){
		tabsReportNames += ",com.vportal.portlet.vfaq.report_answerbydate";
	}
	if(showTabReportQC){
		tabsReportNames += ",com.vportal.portlet.vfaq.report_byCategory";
	}
%>
<liferay-ui:tabs names="<%= tabsReportNames %>" url="<%=portletURL.toString()%>" param="tabs3"/>
<c:choose>
		<c:when test='<%= tabs3.equals("com.vportal.portlet.vfaq.report_byCategory")&& showTabReportQC%>'>			
			<%@ include file="/html/portlet/vfaq/report/report_Qcategory.jsp"%>
		</c:when>
		<c:when test='<%= tabs3.equals("com.vportal.portlet.vfaq.report_answerbydate")&& showTabReportAByDate%>'>			
			<%@ include file="/html/portlet/vfaq/report/report_ASbyDate.jsp"%>
		</c:when>
		<c:otherwise>
			<%@ include file="/html/portlet/vfaq/report/report_QbyDate.jsp" %>
		</c:otherwise>
</c:choose>
	

