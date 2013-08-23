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

cal.set(Calendar.DATE, 1);

int month = cal.get(Calendar.MONTH);
int year = cal.get(Calendar.YEAR);

int maxDayOfMonth = cal.getActualMaximum(Calendar.DATE);
int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

DateFormat dateFormat = new SimpleDateFormat("MMMM, yyyy", locale);
DateFormat timeFormat = new SimpleDateFormat("h:mma", locale);
%>

<table border="0" cellpadding="0" cellspacing="0" width="100%">
<tr>
	<td>
		<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td>
				<a href="<%= leaderURL.toString() %>&<portlet:namespace />month=<%= cal.get(Calendar.MONTH) - 1 %>&<portlet:namespace />day=<%= selDay %>&<portlet:namespace />year=<%= selYear %>&<portlet:namespace />status=<%= status %>&<portlet:namespace />tabs1=<%= "month" %>">
				<img border="0" src="<%= themeDisplay.getPathThemeImage() %>/arrows/01_left.png">
				</a>
			</td>
			<td style="padding-left: 10px;"></td>
			<td>
				<b><%= dateFormat.format(Time.getDate(cal)) %></b>
			</td>
			<td style="padding-left: 10px;"></td>
			<td>
				<a href="<%= leaderURL.toString() %>&<portlet:namespace />month=<%= cal.get(Calendar.MONTH) + 1 %>&<portlet:namespace />day=<%= selDay %>&<portlet:namespace />year=<%= selYear %>&<portlet:namespace />status=<%= status %>&<portlet:namespace />tabs1=<%= "month" %>">
				<img border="0" src="<%= themeDisplay.getPathThemeImage() %>/arrows/01_right.png">
				</a>
			</td>
		</tr>
		</table>
	</td>
	
</tr>
</table>

<br>

<table border="0" cellpadding="0" cellspacing="0" width="100%">
<tr class="portlet-section-header">

	<%
	for (int i = 0; i < 7;  i++) {
		int daysIndex = (selCal.getFirstDayOfWeek() + i - 1) % 7;
	%>

		<td style="padding-left: 1px;"></td>
		<td align="center" height="25" width="<%= (i == 0 || i == 6) ? "15" : "14" %>%">
			<span style="font-size: x-small;"><b>
			<%= LanguageUtil.get(pageContext, CalendarUtil.DAYS_ABBREVIATION[daysIndex]) %>
			</b></span>
		</td>

	<%
	}
	%>

	<td></td>
</tr>
<tr>

	<%
	if (((selCal.getFirstDayOfWeek()) == Calendar.MONDAY)) {
		if (dayOfWeek == 1) {
			dayOfWeek += 6;
		}
		else {
			dayOfWeek --;
		}
	}

	for (int i = 1; i < dayOfWeek; i++) {
	%>

		<td class="portlet-section-header"></td>
		<td height="100"></td>

	<%
	}

	for (int i = 1; i <= maxDayOfMonth; i++) {
		if (dayOfWeek > 7) {
	%>

				<td class="portlet-section-header"></td>
			</tr>
			<tr>
				<td class="portlet-section-header" colspan="15"></td>
			</tr>
			<tr>

		<%
			dayOfWeek = 1;
		}

		dayOfWeek++;

		Calendar tempCal = (Calendar)selCal.clone();

		tempCal.set(Calendar.MONTH, month);
		tempCal.set(Calendar.DATE, i);
		tempCal.set(Calendar.YEAR, year);

		String className = "";

		if ((tempCal.get(Calendar.MONTH) == curMonth) &&
			(tempCal.get(Calendar.DATE) == curDay) &&
			(tempCal.get(Calendar.YEAR) == curYear)) {

			className = "portlet-section-header";
		}
		%>

		<td class="portlet-section-header"></td>
		<td height="100" valign="top">
			<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr class="<%= className %>">
				<td>
					<table border="0" cellpadding="4" cellspacing="0" width="100%">
					<tr>
						<td>
							<span style="font-size: x-small;"><b>
							<a href="<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/vcalendar/leader" /><portlet:param name="tabs1" value="day" /><portlet:param name="month" value="<%= Integer.toString(month) %>" /><portlet:param name="day" value="<%= Integer.toString(i) %>" /><portlet:param name="year" value="<%= Integer.toString(year) %>" /></portlet:renderURL>"><%= i %></a>
							</b></span>

							<c:if test="<%= tempCal.get(Calendar.DAY_OF_WEEK) == cal.getFirstDayOfWeek() %>">
								<span style="font-size: xx-small;">
								[<a href="<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/vcalendar/leader" /><portlet:param name="tabs1" value="week" /><portlet:param name="month" value="<%= Integer.toString(month) %>" /><portlet:param name="day" value="<%= Integer.toString(i) %>" /><portlet:param name="year" value="<%= Integer.toString(year) %>" /></portlet:renderURL>"><%= LanguageUtil.get(pageContext, "week") %> <%= tempCal.get(Calendar.WEEK_OF_YEAR) %></a>]
								</span>
							</c:if>
						</td>
						<td align="right">
						<!--them nut them moi vao day 01_plus.gif-->
							
						</td>
					</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
				    <%
				       List results = VCalServiceUtil.findByD_S(new Date(Integer.toString(tempCal.get(Calendar.MONTH)+1)+"/"+Integer.toString(tempCal.get(Calendar.DATE))+"/"+Integer.toString(tempCal.get(Calendar.YEAR))),status);
					  for(int k=0;k<results.size();k++){
					   VCal vCal=(VCal)results.get(k);
					      out.print(vCal.getTitle()+"<br>");
					   }
					  %>	
				</td>
			</tr>
			</table>
		</td>

	<%
	}

	for (int i = 7; i >= dayOfWeek; i--) {
	%>

		<td class="portlet-section-header"><img border="0" height="1" hspace="0" src="<%= themeDisplay.getPathThemeImage() %>/spacer.gif" vspace="0" width="1"></td>
		<td height="100"></td>

	<%
	}
	%>

	<td class="portlet-section-header"><img border="0" height="1" hspace="0" src="<%= themeDisplay.getPathThemeImage() %>/spacer.gif" vspace="0" width="1"></td>
</tr>
<tr>
	<td class="portlet-section-header" colspan="15"></td>
</tr>
</table>