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
	List linkById = (List)LinksServiceUtil.getByLinkGroupId(Long.parseLong(lgId));
	LinkGroup linkGroup = LinkGroupServiceUtil.getLinkGroup(Long.parseLong(lgId));
%>
<form name="<portlet:namespace />fm">	
<table width="100%" cellpadding="0" cellspacing="0" border="0">
<tr>
  <td>    
	<div class="box_left_portlet border_light_blue bullet_white_green title_light_blue">
		<div class="title">
			<div class="title_wrap">
			<div><%=linkGroup.getName()%></div>
			</div> 
		</div>
		<div class="content">
			<ul> 
			<%
				PortletURL rowURL = renderResponse.createRenderURL();
				rowURL.setWindowState(WindowState.NORMAL);
				rowURL.setParameter("jspPage", "/html/portlet/vlinksmanview/view.jsp");
				for(int i=0;i<linkById.size();i++){
					Links link = (Links)linkById.get(i);
			%>
			  <li class="top">
				<a href="<%= link.getUrl()%>" target="blank"><%= link.getName()%></a>
			  </li>
			  <%  }  %>
			  <li style="float:right"><a href="<%=rowURL.toString()%>">Quay l&#7841;i</a></li>
		    </ul>
		  </div>
	  </div>
 </td>
 </tr>
</table>
</form>
