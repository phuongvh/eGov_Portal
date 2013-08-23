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
<%@page import="com.vportal.portlet.vcalendar.service.VFileServiceUtil"%>
<%@page import="com.vportal.portlet.vcalendar.model.impl.VFileImpl"%>
<%@page import="com.vportal.portlet.vcalendar.model.VFile"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.vportal.portlet.vcalendar.model.VCal"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.vportal.portlet.vcalendar.service.VCalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>

<br>
<%
        Calendar cal1=(Calendar)selCal.clone();
		String styleId = ParamUtil.getString(request, "styleId", "0");
		String type = ParamUtil.getString(request, "type", "0");
		SearchContainer searchContainer = new SearchContainer();
		List headerNames = new ArrayList();
		VFile vfile = null;
		headerNames.add("vfile.time");
		headerNames.add("vfile.leadership");
		headerNames.add("vfile.title");
		headerNames.add(StringPool.BLANK);
		
		searchContainer.setHeaderNames(headerNames);
		searchContainer.setEmptyResultsMessage("there-are-no-events-on-this-day");
		List results=null;
		if(styleId.equals("0")){ 
		    results = VCalServiceUtil.findByD_S_G(new Date(Integer.toString(cal1.get(Calendar.MONTH)+1)+"/"+Integer.toString(cal1.get(Calendar.DATE))+"/"+Integer.toString(cal1.get(Calendar.YEAR))),Integer.parseInt(type),groupId);
		 }else{
		    results = VCalServiceUtil.findByUser(userId,new Date(Integer.toString(cal1.get(Calendar.MONTH)+1)+"/"+Integer.toString(cal1.get(Calendar.DATE))+"/"+Integer.toString(cal1.get(Calendar.YEAR))),groupId);
		 }
		List resultRows = searchContainer.getResultRows();
		searchContainer.setTotal(results.size());
	    for(int i=0;i<results.size();i++){
	    	VCal vCal=(VCal)results.get(i);
			   User curUser = UserLocalServiceUtil.getUserById(userId);
			   Date endDate = vCal.getEndDate();
			   int startHours =vCal.getStartDate().getHours();
		       int startMinutes=vCal.getStartDate().getMinutes();
		       int endHours =vCal.getEndDate().getHours();
		       int endMinutes=vCal.getEndDate().getMinutes();
		       vfile = VFileServiceUtil.findById(vCal.getFileId());
		       String track = "0";		       
		       StringBuffer sb = new StringBuffer();
		       PortletURL detailURL = renderResponse.createRenderURL();
		       detailURL.setWindowState(LiferayWindowState.POP_UP);
		       detailURL.setParameter("struts_action","/vcalendar/detail");
		       detailURL.setParameter("calId",Long.toString(vCal.getCalId()));
		        sb.append(vCal.getTitle());
			    ResultRow row = new ResultRow(vCal, vCal.getCalId(), i);
				// Time
		    	row.addText(vCal.getTime());
				// Title and type
			    row.addText(vfile.getFullname());
				row.addText(sb.toString());
			    
				// Action
				if(styleId.equals("0")){
				row.addJSP("right", SearchEntry.DEFAULT_VALIGN, "/html/portlet/vcalendar/button_persion.jsp" ,application , request ,response );
				// Add result row
				}
				resultRows.add(row);
		  
		}
	%>
<form action="" method="post" name="<portlet:namespace />fm">
<input name="<portlet:namespace />redirect" type="hidden" value="<%= currentURL %>">	
<portlet:renderURL var="addCal"
			windowState="<%= WindowState.MAXIMIZED.toString() %>">
	    	<portlet:param name="redirect" value="<%= currentURL %>"/>
	    	<portlet:param name="jspPage" value="/html/portlet/vcalendar/edit_vcalendar.jsp" />
		    <portlet:param name="month" value="<%= String.valueOf(selMonth) %>" />
		    <portlet:param name="tabs" value="<%=tabs%>" />
		    <portlet:param name="action" value="add_action" />
		    <portlet:param name="status" value="<%= String.valueOf(status) %>" />
		    <portlet:param name="day" value="<%= String.valueOf(selDay) %>" />
		    <portlet:param name="year" value="<%= String.valueOf(selYear) %>" />
</portlet:renderURL>		
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td align="left">
	  <input type="button" value="<liferay-ui:message key="add" />" onClick="self.location = '<%=addCal %>'" />
	</td>
	<%-- <td align="right">
	  <select onchange="<portlet:namespace/>findStyle();" name="<portlet:namespace />styleId">
	    <option value="0" <%=(styleId.equals("0"))?"selected":""%>>Ch&#7911; tr&#236; cu&#7897;c h&#7885;p</option>
		<option value="1" <%=(styleId.equals("1"))?"selected":""%>>Th&#224;nh ph&#7847;n tham gia</option>
	  </select>
	 <%
	 if(styleId.equals("0")){
	 %>
	<select onchange="<portlet:namespace/>findStyle();" name="<portlet:namespace />type">
	    <option value="0" <%=(type.equals("0"))?"selected":""%>>Ch&#432;a &#273;&#432;&#7907;c duy&#7879;t</option>
		<option value="1" <%=(type.equals("1"))?"selected":""%>>&#272;&#227; &#273;&#432;&#7907;c duy&#7879;t</option>
		<option value="2" <%=(type.equals("2"))?"selected":""%>>L&#7883;ch &#273;&#227; h&#7911;y</option>
	 </select>
	<%
	 }
	%> 
	</td> --%>
  </tr>
  <tr>
    <td colspan="2">
	  <liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
	</td>
  </tr>
</table>

</form>
	
<script language="javascript" type="text/javascript">
function <portlet:namespace/>findStyle(){
	 submitForm(document.<portlet:namespace />fm, '<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/vcalendar/view" /><portlet:param name="month" value="<%= String.valueOf(selMonth) %>" /><portlet:param name="tabs" value="<%=tabs%>" /><portlet:param name="action" value="add_action" /><portlet:param name="status" value="<%= String.valueOf(status) %>" /><portlet:param name="day" value="<%= String.valueOf(selDay) %>" /><portlet:param name="year" value="<%= String.valueOf(selYear) %>" /><portlet:param name="status" value="<%=Integer.toString(status)%>" /></portlet:renderURL>');
	}
</script>
		
	