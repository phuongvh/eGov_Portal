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
/**
 * Copyright (c) 2000-2008 VSI, Inc. All rights reserved.
 *
**/
%>

<%@ include file="/html/portlet/vcmsmenu/init.jsp" %>

<%
	PortletURL categoryURL = null;
	if(plId!=0){
		categoryURL = PortletURLFactoryUtil.create(request,portletSelectId, plId, PortletRequest.RENDER_PHASE);
	} else {
		categoryURL = PortletURLFactoryUtil.create(request,portletSelectId, currentPlid, PortletRequest.RENDER_PHASE);
	}
	categoryURL.setParameter("jspPage", "/html/portlet/vcmsviewcontent/view.jsp");
	categoryURL.setParameter("categoriesSelectedCats", categories);
	categoryURL.setParameter("groupId", String.valueOf(groupId));
	categoryURL.setParameter("language", language);
	categoryURL.setParameter("styleBorder",styleBorder);
	categoryURL.setWindowState(WindowState.NORMAL);
%>

<%
	String portionId2="";
	VcmsPortion portions = null;
	String title="";
	String images="";
	if (Validator.isNotNull(portionId) && (portionId.indexOf("|") > 0)) {
		String[] ppIds = StringUtil.split(portionId, "|");
		portionId2 = ppIds[0];
		if(ppIds[1].equals("0")){
			portions = VcmsPortionServiceUtil.getPortion(portionId2);
			title = portions.getName();
		}else{
			VcmsCategory category = VcmsCategoryServiceUtil.getCategory(ppIds[1]);
			title = category.getName();
			images = category.getImage();
		}
	}
%>

<form name="<portlet:namespace/>fm" method="POST">
	<% if(styleBorder.equals("Style1")) { %>
		<%@ include file="/html/portlet/vcmsmenu/styles/style1.jspf" %>
	<% } else if(styleBorder.equals("Style2")) { %>
		<%@ include file="/html/portlet/vcmsmenu/styles/style2.jspf" %>
	<% } else if(styleBorder.equals("Style3")) { %>
		<%@ include file="/html/portlet/vcmsmenu/styles/style3.jspf" %>
	<% } else if(styleBorder.equals("Style4")) { %>
		<%@ include file="/html/portlet/vcmsmenu/styles/style4.jspf" %>
	<% } else if(styleBorder.equals("Style5")) { %> 
		<%@ include file="/html/portlet/vcmsmenu/styles/style5.jspf" %>
	<% } else if(styleBorder.equals("Style6")) { %> 
		<%@ include file="/html/portlet/vcmsmenu/styles/style6.jspf" %>
	<% } else if(styleBorder.equals("Style7")) { %> 
		<%@ include file="/html/portlet/vcmsmenu/styles/style7.jspf" %>
	<% }else { %>
		<%@ include file="/html/portlet/vcmsmenu/styles/default.jspf" %>
	<% } %>
</form>