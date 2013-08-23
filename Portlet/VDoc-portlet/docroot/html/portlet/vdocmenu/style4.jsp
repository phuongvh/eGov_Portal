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
%>

<form name="<portlet:namespace/>fm" method="POST">										

<%
		String arrOrgs[] = StringUtil.split(orgsHN,StringPool.PERIOD);
	    List<vdocOrg> orgList = new ArrayList<vdocOrg>();
		if(arrOrgs.length>0){
			for(int i=0;i<arrOrgs.length;i++){														
				vdocOrg orgHN = (vdocOrg)vdocOrgServiceUtil.getOrg(arrOrgs[i]);
				if(orgHN.getParentId().equals("0")){
					orgList.add(orgHN);
				}
			}
		}
	%>       
	<div class="wd-boxs">
	<!-- Hien thi don vi co parentId = 0 -->
	
	<h2 class="wd-tlh1-1"><%= title %></h2>
	<%	for(vdocOrg org2 : orgList){
			orgURL.setParameter("orgId",org2.getOrgId());
	%>
		<ul class="wd-list-link">
	
		<li> 
			<a href="<%=orgURL%>"><%=org2.getName()%></a>
		</li>
		<%
			List<vdocOrg> listOrgByParent = vdocOrgServiceUtil.getOrgByG_L_P(groupId ,language ,org2.getOrgId());
			if(Validator.isNotNull(listOrgByParent)){
		%>
		
			<% 
				for(vdocOrg subOrg : listOrgByParent){
					orgURL.setParameter("orgId",subOrg.getOrgId());

			%> 
			<li>  				
				<a href="<%=orgURL%>">&nbsp;<%=subOrg.getName()%></a>
			</li>				
				<%}%>
		</ul>
		<%}%>
	
	<%} %> 
  </div>
</form>

