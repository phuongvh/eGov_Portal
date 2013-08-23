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

<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="javax.portlet.ActionRequest"%>
<%@ page import="java.util.*"%>
<%@ page import="com.vportal.portlet.vdoc.model.vdocOrg" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.StringUtil" %>
<%@ page import="com.vportal.portlet.vdoc.service.vdocOrgServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>


<liferay-theme:defineObjects />
<portlet:defineObjects/>

<%
	PortletURL orgURL = PortletURLFactoryUtil.create(request, portletSelectId, plid, PortletRequest.RENDER_PHASE);
// 	orgURL.setParameter(ActionRequest.ACTION_NAME, "ipcVdoc");
// 	List<vdocOrg> listOrgByParent = new ArrayList<vdocOrg>();
%>

<form name="<portlet:namespace/>fm" method="POST">										

<%-- 				<div align="left" class="title1"><b><%=title%></b></div> --%>
				<div class="div_title"><%= title %></div>
					<!-- Danh sach cac don vi da duoc chon -->
			 	    <%
						String arrOrgs[] = StringUtil.split(orgs,StringPool.COMMA);
			 	    	List<vdocOrg> orgList = new ArrayList<vdocOrg>();
						if(arrOrgs.length>0){
							for(int i=0;i<arrOrgs.length;i++){														
								vdocOrg org = (vdocOrg)vdocOrgServiceUtil.getOrg(arrOrgs[i]);
								if(org.getParentId().equals("0")){
									orgList.add(org);
								}
							}
						}
					%>       
					
					<!-- Hien thi don vi co parentId = 0 -->
					<%	for(vdocOrg org2 : orgList){
							orgURL.setParameter("orgId",org2.getOrgId());
					%>
					<div class="arrowsidemenu">
						<div class="menuheaders">
							<a href="<%=orgURL%>">&nbsp;<b><%=org2.getName()%></b></a>
						</div>
						<!-- Hien thi don vi con -->
					 			<%
					 				List<vdocOrg> listOrgByParent = vdocOrgServiceUtil.getOrgByG_L_P(groupId ,language ,org2.getOrgId());
									if(Validator.isNotNull(listOrgByParent)){
								%>
									<ul class="menucontents">
										<% 
											for(vdocOrg subOrg : listOrgByParent){
												orgURL.setParameter("orgId",subOrg.getOrgId());
// 												orgURL.setParameter("org_parent",subOrg.getParentId());
					 					%> 
					 					<li>  				
					 						<a href="<%=orgURL%>">&nbsp;<%=subOrg.getName()%></a>
					 					</li>				
					  				<%}%>
					 				</ul>
					  			<%}%>
					  </div>
					  			<%} %>   
</form>

