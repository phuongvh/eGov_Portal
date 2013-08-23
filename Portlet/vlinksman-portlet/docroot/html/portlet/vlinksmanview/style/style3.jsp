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

<%@page import="com.vportal.portlet.vlinksman.model.LinkGroup"%>
<%@page import="com.vportal.portlet.vlinksman.service.LinkGroupServiceUtil"%>
<%@page import="com.vportal.portlet.vlinksman.service.LinksServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String temp1 = "box_left_portlet " + styleBullet + " " +styleTitle;
	String temp2 = styleBorder;	
	List listLinks = new ArrayList();
	List<LinkGroup> linkGroups = LinkGroupServiceUtil.getAll();
	
%>
		<script>
		$(document).ready(function() {
// 		   $(".blocklink2").equalHeights();
		   $(this).find('.no-image a.title_porlet:first').addClass("selected");
			$("#linkTab0").removeClass('block_hidden_only_for_screen'); 	
			$(this).find(".no-image #gallery:first").removeClass('block_hidden_only_for_screen');
		});
		</script>

	<div class="wd-introduction wd-introduction-four">
		<h2 class="wd-tlh1-5">Li&#234;n k&#7871;t Website S&#7903; - Ng&#224;nh - Qu&#7853;n huy&#7879;n</h2>
		<div class="wd-table wd-table-3">
			<table cellspacing="0" cellpadding="0">
				<thead>
					<tr>
						<%	
							for(int i=0;i<linkGroups.size() ;i++){
								
								LinkGroup linkGroup = LinkGroupServiceUtil.getLinkGroup(linkGroups.get(i).getLinkgroupId());
								listLinks = LinksServiceUtil.getByLinkG_GL(groupId, linkGroup.getLinkgroupId());
								if(listLinks.size()>0){
						%>			                        		                      
						<th class="wd-w20"><%= linkGroup.getName() %></th>	
										
						<%}
							}	  	
						%>
						</tr>
					</thead>
					<tbody>
						<tr>
							<%	
							for(int i=0;i<linkGroups.size() ;i++){
								
								LinkGroup linkGroup = LinkGroupServiceUtil.getLinkGroup(linkGroups.get(i).getLinkgroupId());
								listLinks = LinksServiceUtil.getByLinkG_GL(groupId, linkGroup.getLinkgroupId());	
								if(listLinks.size()>0){
							%>																
									<td class="wd-w20">
										<ul class="wd-link-weblist">
										<%	
											for(int j=0;j<listLinks.size();j++){
											Links link = (Links)listLinks.get(j);	
										%>
											<li>
				                				<a href="<%=link.getUrl()%>" target="<%= (link.getIsTargetBlank())? "_blank":"_self"%>"><%=link.getName()%></a>
			                   				</li>	         				
			                   				
											<%}%>		      
										</ul>
									</td>
								
						        <%}
						        
						        }%>																
							</tr>
						</tbody>
				</table>
		</div>
	</div>