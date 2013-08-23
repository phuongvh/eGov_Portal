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
Calendar cal = (Calendar)selCal.clone();
%>
<table border="0" cellpadding="0" cellspacing="0" width="100%">
<tr>
	<td>
		<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td>

				<%
				cal.add(Calendar.DATE, -1);
				%>

				<a href="<%= leaderURL.toString() %>&<portlet:namespace />month=<%= cal.get(Calendar.MONTH) %>&<portlet:namespace />day=<%= cal.get(Calendar.DATE) %>&<portlet:namespace />year=<%= cal.get(Calendar.YEAR) %>&<portlet:namespace />status=<%= status %>">
				<img border="0" src="<%= themeDisplay.getPathThemeImage() %>/arrows/01_left.png">
				</a>
			</td>
			<td style="padding-left: 10px;"></td>
			<td>

				<%
				cal.add(Calendar.DATE, 1);
				%>

				<b><%= dateFormatDate.format(Time.getDate(cal)) %></b>
			</td>
			<td style="padding-left: 10px;"></td>
			<td>

				<%
				cal.add(Calendar.DATE, 1);
				%>

				<a href="<%= leaderURL.toString() %>&<portlet:namespace />month=<%= cal.get(Calendar.MONTH) %>&<portlet:namespace />day=<%= cal.get(Calendar.DATE) %>&<portlet:namespace />year=<%= cal.get(Calendar.YEAR) %>&<portlet:namespace />status=<%= status %>">
				<img border="0" src="<%= themeDisplay.getPathThemeImage() %>/arrows/01_right.png">
				</a>
			</td>
		</tr>
		</table>
	</td>
</tr>
</table>
<br>
<%
        Calendar cal1=(Calendar)selCal.clone();
		SearchContainer searchContainer = new SearchContainer();
		List headerNames = new ArrayList();
		
		headerNames.add("time");
		headerNames.add("title");
		headerNames.add(StringPool.BLANK);
		
		searchContainer.setHeaderNames(headerNames);
		searchContainer.setEmptyResultsMessage("there-are-no-events-on-this-day");
		Date startDate =new Date(Integer.toString(cal1.get(Calendar.MONTH)+1)+"/"+Integer.toString(cal1.get(Calendar.DATE))+"/"+Integer.toString(cal1.get(Calendar.YEAR)));
		List results= VCalServiceUtil.findByD_S_G(startDate,0,groupId);
		
		List resultRows = searchContainer.getResultRows();
		searchContainer.setTotal(results.size());
	    for(int i=0;i<results.size();i++){
		   VCal vCal=(VCal)results.get(i);
		   StringBuffer sb = new StringBuffer();
	       PortletURL detailURL = renderResponse.createRenderURL();
	       detailURL.setWindowState(LiferayWindowState.POP_UP);
	       detailURL.setParameter("struts_action","/vcalendar/detail");
	       detailURL.setParameter("calId",Long.toString(vCal.getCalId()));
	     
	       	   sb.append("<a href='#'>");
	    	   sb.append(vCal.getTitle());
	    	   sb.append("</a>");
		    ResultRow row = new ResultRow(vCal, vCal.getCalId(), i);
			// Time
	    
		    row.addText(vCal.getTime());
			row.addText(sb.toString());
		    
			// Action
			row.addJSP("right", SearchEntry.DEFAULT_VALIGN, "/html/portlet/vcalendar/button.jsp");
			// Add result row
		
			resultRows.add(row);
		  
		}
	%>
<form action="" method="post" name="<portlet:namespace />fm">	
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td align="left">
	    <c:if test = "<%= PortletPermissionUtil.contains(permissionChecker, plid.longValue(),"vcalendar", ActionKeysExt.VIEW_CALENDAR_ADD)%>">
	    <%
	    Calendar addcal = (Calendar)selCal.clone();
	    addcal.add(Calendar.DATE, 1);
	    %>
		  <input type="button" value="<liferay-ui:message key="add" />" onClick="self.location = '<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/vcalendar/edit_event" /><portlet:param name="month" value="<%= String.valueOf(addcal.get(Calendar.MONTH)) %>" /><portlet:param name="tabs" value="<%=tabs%>" /><portlet:param name="action" value="add_action" /><portlet:param name="status" value="<%= String.valueOf(status) %>" /><portlet:param name="day" value="<%= String.valueOf(addcal.get(Calendar.DATE)) %>" /><portlet:param name="year" value="<%= String.valueOf(addcal.get(Calendar.YEAR)) %>" /></portlet:renderURL>';" />
		</c:if>
	</td>
	<td align="right">
	</td>
  </tr>
  <tr>
    <td colspan="2">
	  <liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
	</td>
  </tr>
</table>

</form>
	
<script language="javascript" type="text/javascript">
function <portlet:namespace/>findStyle(){
	 submitForm(document.<portlet:namespace />fm, '<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/vcalendar/leader" /><portlet:param name="month" value="<%= String.valueOf(selMonth) %>" /><portlet:param name="action" value="add_action" /><portlet:param name="status" value="<%= String.valueOf(status) %>" /><portlet:param name="day" value="<%= String.valueOf(selDay) %>" /><portlet:param name="year" value="<%= String.valueOf(selYear) %>" /><portlet:param name="status" value="<%=Integer.toString(status)%>" /></portlet:renderURL>');
	}
</script>