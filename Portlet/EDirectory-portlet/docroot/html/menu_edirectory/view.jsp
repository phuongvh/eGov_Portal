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
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/html/menu_edirectory/init.jsp" %>
<%@include file="/html/menu_edirectory/css.jsp" %>


	

			<div class="wd-boxs">
				<h2 class="wd-tlh1-1 wd-alignment">Danh bạ điện tử</h2>
				
		<%	
			PortletURL categoryURL = PortletURLFactoryUtil.create(request,portletSelectId, plId, PortletRequest.RENDER_PHASE);
			categoryURL.setParameter("jspPage","/html/content_edirectory/view.jsp");
			categoryURL.setParameter("groupId", String.valueOf(groupId));
			List<EDDepartment> departmentList = EDDepartmentLocalServiceUtil.getByParent(0);
			int k=0;
     		for(EDDepartment dep : departmentList) 
     		{ 
     			
     			categoryURL.setParameter("depId", String.valueOf(dep.getId()));
     			k++;
  		%>		
  				<div class="wd-contact-sub">
  					<!-- Menu cha : Nếu menu nào được chọn thì show các menu con -->
  					
  					<h4 class="wd-title-sub">
						<a href="<%=categoryURL%>"><%=dep.getName()%></a>
					</h4>
					<%
						//Duyệt nếu trong menu cha có menu con thì hiển thị các menucon
      					List<EDDepartment> subDeps = EDDepartmentLocalServiceUtil.getByParent(dep.getId());
      					if(Validator.isNotNull(subDeps)) {		//start if			
  					%>
  					<ul class="wd-other-news wd-list">
  						<% 
  							for(EDDepartment subDep : subDeps)
  							{//star for 2 
  						%>
  						<li>
  							<!-- Menu hiện đang được chọn -->
							<%
								categoryURL.setParameter("depId", String.valueOf(subDep.getId()));
							%>
							<a href="<%=categoryURL%>"><%=subDep.getName()%></a>
						</li>
						<%
  							}//end for 2
						%>
  					</ul>
  					<%
      					}//end if
  					%>
  				</div>
  		<%
     		}
  		%>
  		</div>
