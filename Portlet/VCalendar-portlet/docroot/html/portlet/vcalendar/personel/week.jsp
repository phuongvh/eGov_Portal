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

DateFormat dateFormatDayOfWeek = new SimpleDateFormat("EEE", locale);
DateFormat dateFormatMonthAndDay = new SimpleDateFormat("M/d", locale);
%>

<table border="0" cellpadding="0" cellspacing="0" width="100%">
<tr>
	<td>
		<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td>

				<%
				cal.add(Calendar.DATE, -7);
				%>

				<a href="<%= personelURL.toString() %>&<portlet:namespace />month=<%= cal.get(Calendar.MONTH) %>&<portlet:namespace />day=<%= cal.get(Calendar.DATE) %>&<portlet:namespace />year=<%= cal.get(Calendar.YEAR) %>&<portlet:namespace />status=<%= status %>&<portlet:namespace />tabs1=<%= "week" %>">
				<img border="0" src="<%= themeDisplay.getPathThemeImage() %>/arrows/01_left.png">
				</a>
			</td>
			<td style="padding-left: 10px;"></td>
			<td>

				<%
				cal.add(Calendar.DATE, 7);
				%>

				<b><%= dateFormatDate.format(Time.getDate(cal)) %> -

				<%
				cal.add(Calendar.DATE, 6);
				%>

				<%= dateFormatDate.format(Time.getDate(cal)) %></b>
			</td>
			<td style="padding-left: 10px;"></td>
			<td>

				<%
				cal.add(Calendar.DATE, 1);
				%>

				<a href="<%= personelURL.toString() %>&<portlet:namespace />month=<%= cal.get(Calendar.MONTH) %>&<portlet:namespace />day=<%= cal.get(Calendar.DATE) %>&<portlet:namespace />year=<%= cal.get(Calendar.YEAR) %>&<portlet:namespace />status=<%= status %>&<portlet:namespace />tabs1=<%= "week" %>">
				<img border="0" src="<%= themeDisplay.getPathThemeImage() %>/arrows/01_right.png">
				</a>
			</td>
		</tr>
		</table>
	</td>
	
</tr>
</table>

<br>

<table border="1" cellpadding="0" cellspacing="0" width="100%">

<%
cal = (Calendar)selCal.clone();

for (int i = 0; i < 7; i++) {
%>
 	
	<tr >
		<td class="portlet-section-header" colspan="5"></td>
	</tr>
	<tr>
		<td class="portlet-section-header" style="padding-left: 1px;"></td>

		<%
		String className = "portlet-font";

		if ((cal.get(Calendar.MONTH) == curMonth) &&
			(cal.get(Calendar.DATE) == curDay) &&
			(cal.get(Calendar.YEAR) == curYear)) {

			className = "portlet-section-header";
		}
		%>

		<td class="<%= className %>" valign="top" align="center" width="30%">
			<table border="0" cellpadding="8" cellspacing="0">
			<tr>
				<td class="<%= className %>" style="font-size: x-small;">
					<b><%= dateFormatDayOfWeek.format(Time.getDate(cal)) %></b><br>

					<a href="<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/vcalendar/view" /><portlet:param name="tabs1" value="day" /><portlet:param name="month" value="<%= Integer.toString(cal.get(Calendar.MONTH)) %>" /><portlet:param name="day" value="<%= Integer.toString(cal.get(Calendar.DATE)) %>" /><portlet:param name="year" value="<%= Integer.toString(cal.get(Calendar.YEAR)) %>" /></portlet:renderURL>">
					<%= dateFormatMonthAndDay.format(Time.getDate(cal)) %>
					</a>

				<!-- them moi 01_plus.png-->
				</td>
			</tr>
			</table>
		</td>
		<td class="portlet-section-header" style="padding-left: 1px;"></td>
		<td valign="top" width="99%">
			<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td>
					<table border="0" cellpadding="4" cellspacing="0" width="100%">
					  <tr>
						  <td align="center">
                            <%
                             List results = VCalServiceUtil.findByU_D_S(userId,status,new Date(Integer.toString(cal.get(Calendar.MONTH)+1)+"/"+Integer.toString(cal.get(Calendar.DATE))+"/"+Integer.toString(cal.get(Calendar.YEAR))));
							  for(int k=0;k<results.size();k++){
							   VCal vCal=(VCal)results.get(k);
							      out.print(vCal.getTitle()+"<br>");
							   }
							  %>						    
						  </td>
					  </tr>
					</table>
				</td>
			</tr>
			</table>
		</td>
		<td class="portlet-section-header" style="padding-left: 1px;"></td>
	</tr>

	<c:if test="<%= i + 1 == 7 %>">
		<tr>
			<td class="portlet-section-header" colspan="5"></td>
		</tr>
	</c:if>

<%
	cal.add(Calendar.DATE, 1);
}
%>

</table>