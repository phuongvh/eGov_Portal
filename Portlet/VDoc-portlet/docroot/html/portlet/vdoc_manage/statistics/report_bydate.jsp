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
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.vportal.portlet.vdoc.service.vdocDocumentServiceUtil"%>
<%@page import="com.vportal.portlet.vdoc.service.persistence.vdocDocumentFinderUtil"%>
<%@page import="com.vportal.portlet.vdoc.service.vdocDocumentServiceUtil"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://www.vietsoftware.com/tld" prefix="vportal" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<portlet:defineObjects/>
<liferay-theme:defineObjects/>

<%

	Calendar currentDate = new GregorianCalendar();
	
	int fromDay = ParamUtil.getInteger(request, "fromDay", curDay);
	int fromMonth = ParamUtil.getInteger(request, "fromMonth", curMonth);
	int fromYear = ParamUtil.getInteger(request, "fromYear", curYear-1);
	
	int toDay = ParamUtil.getInteger(request, "toDay", curDay+1);
	int toMonth = ParamUtil.getInteger(request, "toMonth", curMonth);
	int toYear = ParamUtil.getInteger(request, "toYear", curYear);	
	
	String[] strType = request.getParameterValues("typeIds");
	if(Validator.isNotNull(strType)){
		renderURL.setParameter("typeIds",strType);
	}
	
	String strTypeIds="";	
	int begin = 0;
	int end = 100000;
	
	// Convert Date...
	Date dateFrom  = new GregorianCalendar(fromYear, fromMonth, fromDay).getTime();	
	Date dateTo = new GregorianCalendar(toYear, toMonth, toDay).getTime();
	
// 	String byUser = ParamUtil.getString(request,"byUser","");	
	
		
// 	List listType = VcmsTypeServiceUtil.getTypesByS_L(groupId, language);
	
%>

<table width="100%">
	<tr>	
		<td valign="top" width="38%" style="padding-top: 5px;">			   	
	   			<label for="<portlet:namespace/>isDate"><b><%= LanguageUtil.get(pageContext, "portlet.vdoc.article.search.from-date") %></b></label>	       	
	    		<liferay-ui:input-date
					disableNamespace="<%= false %>"
					formName='<%= renderResponse.getNamespace() + "fm" %>'
					monthParam="fromMonth"
					monthValue="<%= fromMonth %>"
					dayParam="fromDay"
					dayValue="<%= fromDay %>"
					yearParam="fromYear"
					yearValue="<%=fromYear %>"
					yearRangeStart="<%= curYear-10 %>"
					yearRangeEnd="<%= curYear+10 %>"
					firstDayOfWeek="<%= currentDate.getFirstDayOfWeek() - 1 %>"
					disabled="<%= false %>"	/>
				<br/><br/>
				
				<b><%= LanguageUtil.get(pageContext, "portlet.vdoc.article.search.to-date") %></b>
	       	
	         	<liferay-ui:input-date
					disableNamespace="<%= false %>"
					formName='<%= renderResponse.getNamespace() + "fm" %>'
					monthParam="toMonth"
					monthValue="<%= toMonth %>"
					dayParam="toDay"
					dayValue="<%= toDay %>"
					yearParam="toYear"
					yearValue="<%=curYear %>"
					yearRangeStart="<%= curYear-10 %>"
					yearRangeEnd="<%= curYear+10 %>"
					firstDayOfWeek="<%= currentDate.getFirstDayOfWeek() - 1 %>"
					disabled="<%= false %>"/>	
					
	  		<br/>
	  		<br/>

</td>
</tr>
</table>
<liferay-ui:search-container emptyResultsMessage='<%= LanguageUtil.get(pageContext,"portlet.vdoc.report.empty") %>' delta="15" deltaConfigurable="15">
	<liferay-ui:search-container-results>
		<%
			List listDoc = vdocDocumentServiceUtil.getDocbyModifyDate(groupId,language,dateFrom,dateTo,2);
			results = ListUtil.subList(listDoc, searchContainer.getStart(), searchContainer.getEnd());
			total = listDoc.size();
			pageContext.setAttribute("results", results);
			pageContext.setAttribute("total", total);
		%>
	</liferay-ui:search-container-results>
		<liferay-ui:search-container-row className="com.vportal.portlet.vdoc.model.vdocDocument" keyProperty="docId" modelVar="document">
		<%
		
		
			String titleDoc = document.getTitle();
		%>
		<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(pageContext, "portlet.vdoc.document.modify-date") %>' value="<%= ActionUtil.parseDateToString(document.getModifiedDate()) %>"/>
		<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(pageContext, "portlet.vdoc.document.title") %>' value='<%= titleDoc.toString() %>'  />
		<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(pageContext, "portlet.vdoc.document.approve-date") %>' value="<%= ActionUtil.parseDateToString(document.getApprovedDate()) %>"/>
		<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(pageContext, "portlet.vdoc.document.org") %>' value="<%= document.getOrgRels() %>"/>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
</liferay-ui:search-container>

<portlet:actionURL name="exportToExcel" var="exportToExcelUrl" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="fromDay" value="<%=String.valueOf(fromDay)%>"></portlet:param>
	<portlet:param name="fromMonth" value="<%=String.valueOf(fromMonth)%>"></portlet:param>
	<portlet:param name="fromYear" value="<%=String.valueOf(fromYear)%>"></portlet:param>
	<portlet:param name="toDay" value="<%=String.valueOf(toDay)%>"></portlet:param>
	<portlet:param name="toMonth" value="<%=String.valueOf(toMonth)%>"></portlet:param>
	<portlet:param name="toYear" value="<%=String.valueOf(toYear)%>"></portlet:param>
	<portlet:param name="language" value="<%=language%>"></portlet:param>
	<portlet:param name="groupId" value="<%=String.valueOf(groupId)%>"></portlet:param>
	<portlet:param name="cmd" value="reportBydate"></portlet:param>
	
</portlet:actionURL>
<br/>
<a href="<%=exportToExcelUrl.toString() %>">
	<input name="btnExport" type="button" value="Xu&#7845;t b&#225;o c&#225;o" />
</a>