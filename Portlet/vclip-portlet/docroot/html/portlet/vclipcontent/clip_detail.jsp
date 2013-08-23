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
<%
	Clip clipBean = (Clip)request.getAttribute("clipBean");
%>
<div style="padding: 5px;">
<table width="100%" class="text_none">
	<tr>
		<td colspan="2"><p class="public_title"><%= clipBean.getTitle()%></p></td>
	</tr>
	<tr>
		<td width="50%">
			<b>L&#432;&#7907;t xem : &nbsp; <%=clipBean.getHitcountview()%></b>
		</td>
		<td style="display:<%=allowDownload.equals("true")?"block":"none"%>;">
			<table>
				<tr>
					<td><b>L&#432;&#7907;t download :&nbsp;&nbsp; <%=clipBean.getHitcount()%></b> &nbsp;&nbsp;</td>
					<td><a href="<%= themeDisplay.getPathMain()%>/document_library/get_file?p_l_id=<%= themeDisplay.getPlid() %><%= clipBean.getUrl() %>">
							<img onclick= "inceaseCounter(<%=clipBean.getId()%>)" src="/vclip-portlet/html/portlet/vclipcontent/images/download.png"/>
						</a>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td colspan="2" style="display:<%=allowDescription.equals("true")?"":"none"%>">
			<p><%= clipBean.getDescription()%></p>

		</td>
	</tr>
</table>
</div>
