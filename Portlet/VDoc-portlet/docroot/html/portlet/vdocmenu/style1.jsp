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
<%
	
	
	String redirect = StringPool.BLANK;
	String cmd = ParamUtil.getString(request, Constants.CMD);
	
	// Initial date values	
	Calendar currentDate = new GregorianCalendar();
	int proFromDay = currentDate.get(Calendar.DATE);
	int proFromMonth = currentDate.get(Calendar.MONTH) - period;
	int proFromYear = currentDate.get(Calendar.YEAR);
	int proFromHour = currentDate.get(Calendar.HOUR);
	int proFromMinute = currentDate.get(Calendar.MINUTE);
	
	int proToDay = currentDate.get(Calendar.DATE);
	int proToMonth = currentDate.get(Calendar.MONTH);
	int proToYear = currentDate.get(Calendar.YEAR);
	int proToHour = currentDate.get(Calendar.HOUR);
	int proToMinute = currentDate.get(Calendar.MINUTE);

	Date pubDateFrom = new GregorianCalendar(proFromYear, proFromMonth, proFromDay, proFromHour, proFromMinute).getTime();	
	Date pubDateTo = new GregorianCalendar(proToYear, proToMonth, proToDay, proToHour, proToMinute).getTime();

	List documents = new ArrayList();
	
    documents = vdocDocumentServiceUtil.getDocByPublishDate(groupId, language, pubDateFrom, pubDateTo, vdocDocumentServiceImpl.PUBLISHED, documentPerPortlet);
	
	PortletURL viewURL = PortletURLFactoryUtil.create(request,portletSelectId, plId, PortletRequest.RENDER_PHASE);	
	viewURL.setParameter("jspPage", "/html/portlet/vdocview/view.jsp");
	viewURL.setParameter("language", language);
	viewURL.setParameter("groupId", String.valueOf(groupId));
	viewURL.setWindowState(WindowState.NORMAL);	
		
%>

		
<table width="100%">
		<tr height="3"><td colspan="3"></td></tr>
		<tr class="center_top_background">
			<td id="left_top_tab"></td>		    			
			<td>
				<div align="left" class="title1"><%=title%></div>
			</td>
			<td id="right_top_tabs"></td>
		</tr>
	</table>
	<table width="100%" cellspacing="0" cellpadding="0" border="0">
		<tr>		
			<td class="boder_top" bgcolor="#FFFFFF" style="padding-top:0px;">
				<table width="100%">
				<%
				    String description = "";
					if (documents!= null && documents.size()>0){
						if (documents.size() >0){
							for (int i=0; i<documents.size();i++){
								vdocDocument doc = (vdocDocument)documents.get(i);
								viewURL.setParameter("docId",doc.getDocId());
								viewURL.setParameter("cmd","documentview");	
								
								description = doc.getTitle();
								
				
				%>		             
               	 	 	<tr height="5">
							<td colspan="4"></td>
						</tr>
	              	 	<tr>
	              	 		  <td width="5"></td>
	               	 	 	  <td width="10" valign="top" >		               	 	 	  		
	               	 	 	  		<div style="background:transparent url(<%=themeDisplay.getPathThemeImage() %>/HN_image/tieudiem_boll.gif) no-repeat scroll left 5px;">
	               	 	 	  			&nbsp;
	               	 	 	  		</div>		               	 	 	  		
	               	 	  	  </td>
	               	 	  	  <td align="left" valign="top">		               	 	  	  		
	               	 	  	  	 	<a href="<%=viewURL%>"><%=StringUtil.shorten(description, 80)%></a>		               	 	  	  	 
	               	 	  	  </td>
	               	 	  	  <td width="7"></td>
	               	 	</tr>
	               	 	<tr  height="5">
	               	 		<td colspan="4"></td>
	               	 	</tr>			
			  	<%}}}%>
			  	</table>				
			</td>
		</tr>
	</table>						               
							                
	<table width="100%">
		<tr>
			<td width="4"><img src="<%= themeDisplay.getPathThemeImage() %>/HN_image/i_34.gif" width="4" height="4"/></td>
			<td id="center_bottom_background"></td>
			<td width="4"><img src="<%= themeDisplay.getPathThemeImage() %>/HN_image/i_35.gif" width="4" height="4"/></td>
		</tr>
		<tr height="3"><td colspan="3"></td></tr>
	</table>		