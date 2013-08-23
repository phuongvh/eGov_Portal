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
<%@ include file="/html/portlet/manage_vclip/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<% boolean showTabclip =  PortletPermissionUtil.contains(permissionChecker , plid.longValue() , WebKeysVClip.Clip_type_id, ActionKeysClipExt.VIEW_TAB_CLIP);
	boolean showTabclipType =  PortletPermissionUtil.contains(permissionChecker , plid.longValue() ,WebKeysVClip.Clip_type_id, ActionKeysClipExt.VIEW_TAB_CLIPTYPE);
	if(showTabclip== true && showTabclipType == false){
		tab1Names = "vportal.vclip.clip, ";
	}
	if(showTabclipType==true && showTabclip== false){
		tab1Names = " ,vportal.vclip.clipType";
	}
	%>	
<form name="<portlet:namespace />fm" action="<%=portletURL.toString() %>" method="post" >

	<liferay-ui:tabs names="<%=tab1Names %>" url="<%=portletURL.toString()+\"&language\"+language  %>" >
		<c:choose>
			<c:when test='<%= tabs1.equals("vportal.vclip.clipType") %>'>				
				<%@include file="/html/portlet/manage_vclip/view_cliptypes.jsp"%>				
			</c:when>					
			<c:otherwise>				
				<%@include file="/html/portlet/manage_vclip/view_clips.jsp"%>
			</c:otherwise>
		</c:choose>
	</liferay-ui:tabs>
	<br><br>
</form>

