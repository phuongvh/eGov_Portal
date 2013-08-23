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
<%@page import="com.liferay.portal.kernel.language.LanguageUtil" %>

<portlet:defineObjects/>
<%	
	PortletPreferences prefs1 = renderRequest.getPreferences();
	int maxAttachmentDocument1 = GetterUtil.getInteger(prefs1.getValue("numberFile", "5"));
%>

<portlet:actionURL name="EditConfigurationAction" var="EditConfigurationActionURL" />

<form name="<portlet:namespace />fm1" method="post" action="<%= EditConfigurationActionURL %>">	
<!-- 		<input type="submit" value="Save1"/>												 -->
</form>

<form name="<portlet:namespace />fm2" method="post" action="<%=EditConfigurationActionURL %>">
	<table width="50%" border="0" cellspacing="1" cellpadding="4">
	<tr>
		<td>S&#7889; t&#7853;p tin &#273;ính kèm th&#7911; t&#7909;c</td>
		<td>
			<select name="<portlet:namespace />numberFile">
				<%for(int i=1;i<=10;i++){%>
					<option value="<%=i%>" <%= (maxAttachmentDocument1 == i) ? "selected" : "" %>><%=i%></option>
				<%}%>						
			</select></td>
	</tr>
	</table>
					
	<br/>
	<div align="center">
	<input type="submit" value="Save"  />
	</div>
</form>

