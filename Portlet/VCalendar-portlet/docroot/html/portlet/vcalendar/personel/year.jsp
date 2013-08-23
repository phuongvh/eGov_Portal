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
<script type="text/javascript">
	function <portlet:namespace />updateCalendar(month, day, year) {
		self.location = '<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="tabs1" value="day" /><portlet:param name="status" value="<%= String.valueOf(status) %>" /></portlet:renderURL>&<portlet:namespace />month=' + month + '&<portlet:namespace />day=' + day + '&<portlet:namespace />year=' + year;
	}
</script>
<table border="0" cellpadding="0" cellspacing="0">
<tr>
	<td>
		<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td>
				<a href="<%= personelURL.toString() %>&<portlet:namespace />month=<%= selMonth %>&<portlet:namespace />day=<%= selDay %>&<portlet:namespace />year=<%= selYear - 1 %>&<portlet:namespace />status=<%= status %>&<portlet:namespace />tabs1=<%= "year" %>">
				<img border="0" src="<%= themeDisplay.getPathThemeImage() %>/arrows/01_left.gif">
				</a>
			</td>
			<td style="padding-left: 10px;"></td>
			<td>
				<select onChange="self.location = '<%= personelURL.toString() %>&<portlet:namespace />tabs1=<%= "year" %>&<portlet:namespace />year=' + this.value;">

					<%
					for (int i = -10; i <= 10; i++) {
					%>

						<option <%= ((curYear - selYear + i) == 0) ? "selected" : "" %> value="<%= Integer.toString(curYear + i) %>"><%= curYear + i %></option>

					<%
					}
					%>

				</select>
			</td>
			<td style="padding-left: 10px;"></td>
			<td>
				<a href="<%= personelURL.toString() %>&<portlet:namespace />month=<%= selMonth %>&<portlet:namespace />day=<%= selDay %>&<portlet:namespace />year=<%= selYear + 1 %>&<portlet:namespace />status=<%= status %>&<portlet:namespace />tabs1=<%= "year" %>">
				<img border="0" src="<%= themeDisplay.getPathThemeImage() %>/arrows/01_right.gif">
				</a>
			</td>
		</tr>
		</table>
	</td>
</tr>
<tr>
	<td colspan="2">
		<br>

		<%
		List calendars = new ArrayList(12);

		for (int j = 0; j < 12; j++) {
			Calendar cal = (Calendar)selCal.clone();

			cal.set(Calendar.MONTH, j);
			cal.set(Calendar.DATE, 1);

			calendars.add(cal);
		}
		%>

		<liferay-ui:table-iterator
			list="<%= calendars %>"
			listType="java.util.Calendar"
			rowLength="3"
			rowPadding="30"
			rowValign="top">

			<%
			int month = tableIteratorObj.get(Calendar.MONTH);
			int year = tableIteratorObj.get(Calendar.YEAR);

			int maxDayOfMonth = tableIteratorObj.getActualMaximum(Calendar.DATE);

			Set data = new HashSet();

			for (int i = 1; i <= maxDayOfMonth; i++) {
				Calendar tempCal = (Calendar)selCal.clone();

				tempCal.set(Calendar.MONTH, month);
				tempCal.set(Calendar.DATE, i);
				tempCal.set(Calendar.YEAR, year);

		//		boolean hasEvents = CalEventLocalServiceUtil.hasEvents(portletGroupId, tempCal, eventType);

			//	if (hasEvents) {
				//	data.add(new Integer(i));
				//}
			}
			%>

			<liferay-ui:calendar
				month="<%= month %>"
				day="<%= 1 %>"
				year="<%= year %>"
				headerPattern="MMMM"
				data="<%= data %>"
			/>
		</liferay-ui:table-iterator>
	</td>
</tr>
</table>