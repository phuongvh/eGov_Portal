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
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@page import="com.vportal.portal.model.Attachment"%>
<%@page import="com.vportal.portal.service.AttachmentLocalServiceUtil"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.vportal.portlet.vcalendar.model.impl.VFileImpl"%>
<%@page import="com.vportal.portlet.vcalendar.service.VFileServiceWrapper"%>
<%@page import="com.vportal.portlet.vcalendar.model.VFileModel"%>
<%@page import="com.vportal.portlet.vcalendar.util.VCalUtil"%>
<%@page import="com.vportal.portlet.vcalendar.model.VCal"%>
<%@page import="com.vportal.portlet.vcalendar.service.VFileServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="com.vportal.portlet.vcalendar.service.VCalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@page import="com.vportal.portlet.vcalendar.model.VFile"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.Time"%>
<%@ include file="/html/portlet/vcalendarview/javascript.jsp" %>

<%
    String title = prefs.getValue("title","");
	PortletURL vcalendarURL = renderResponse.createRenderURL();
	vcalendarURL.setParameter("struts_action","/vcalendar/display");
	PortletURL vcalendarListURL = renderResponse.createRenderURL();
	vcalendarListURL.setParameter("struts_action","/vcalendar/display");
	Calendar cal = (Calendar)selCal.clone();
	
	DateFormat dateFormatDayOfWeek = new SimpleDateFormat("EEE", locale);
	DateFormat dateFormatMonthAndDay = new SimpleDateFormat("M/d", locale);
	DateFormat dateFormat = new SimpleDateFormat("MMMM, yyyy", locale);
	DateFormat timeFormat = new SimpleDateFormat("h:mma", locale);
	
	int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	int month = cal.get(Calendar.MONTH);
	int day = cal.get(Calendar.DATE);
	int year = cal.get(Calendar.YEAR);
	int maxDayOfMonth = cal.getActualMaximum(Calendar.DATE);
	cal.add(Calendar.DATE, 1);	
	VFile vfile=null;
	
	cal = VCalUtil.getFirstDayOfWeek(cal);
		
	int pMonth = cal.get(Calendar.MONTH);
	int pDay = cal.get(Calendar.DATE);
	int pYear = cal.get(Calendar.YEAR);
	
	long month1 = ParamUtil.getLong(request, "month",selMonth);		
%>
					<div class="wd-introduction wd-introduction-four">
						<h2 class="wd-tlh1-4">L&#7882;CH C&#212;NG T&#193;C</h2>
						<h3 class="wd-tlh3-7">&#7910;Y BAN NH&#194;N D&#194;N TH&#192;NH PH&#7888; H&#192; N&#7896;I</h3>
						<div class="wd-txt-center">
							<fieldset>
								<ul class="wd-view-date wd-view-date-two">
									<li class="wd-year">
	  								<label><liferay-ui:message key="vfile.year" /> </label>  								
									<select onChange="self.location = '<%= vcalendarListURL.toString() %>&<portlet:namespace />month=0&<portlet:namespace />day=1&<portlet:namespace />year=' + this.value;">
										<%
											for (int i = -10; i <= 10; i++) {
										%>
											<option <%= ((curYear - selYear + i) == 0) ? "selected" : "" %> value="<%= Integer.toString(curYear + i) %>"><%= curYear + i %> </option>
								
										<%
											}
										%>										
									</select>
									</li>									
										<%										
										cal.add(Calendar.DATE, 1);
										String dateweek = dateFormatDate.format(Time.getDate(cal)) +" - "; 
										cal.add(Calendar.DATE, 6);
										dateweek = dateweek + dateFormatDate.format(Time.getDate(cal)) ;
										cal.add(Calendar.DATE, 1);
										
										%>
									<li>
									<label> <liferay-ui:message key="vfile.week" />	</label>								
									 <select onChange="<portlet:namespace />submitForm(''+this.value);">
									 
											<%
											for (int i = 1; i <= 52; i++) {
												Calendar tempcal = (Calendar)selCal.clone();
												tempcal.set(Calendar.YEAR, year);
												tempcal.set(Calendar.WEEK_OF_YEAR, i-1);												
												
												Calendar firstTempCal = (Calendar)tempcal.clone();
												firstTempCal = VCalUtil.getFirstDayOfWeek(firstTempCal);
												firstTempCal.add(Calendar.DATE, 1);
												
												Calendar nextTempCal = (Calendar)firstTempCal.clone();
												nextTempCal.add(Calendar.DATE, 6);												
											%>
								
												<option value="<%= dateFormatDate.format(Time.getDate(tempcal)) %>" <%= ((cal.get(Calendar.WEEK_OF_YEAR)) == i) ? "selected" : "" %>><liferay-ui:message key="vfile.week" /> <%= i %> <%= ((cal.get(Calendar.WEEK_OF_YEAR)) == i) ? "( "+dateweek+" )" : "( "+dateFormatDate.format(Time.getDate(firstTempCal))  +" - "+dateFormatDate.format(Time.getDate(nextTempCal)) +" )" %></option>
												
											<%											
											}
											%>
								
										</select>									
									</li>
									<li>
<!-- Print  							<img src="fileprint.png" onClick="var slideShowWindow = window.open('<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>">				
											<portlet:param name="struts_action" value="/html/portlet/vcalendarview/print_calendar.jsp" />
											<portlet:param name="year" value="<%=String.valueOf(pYear)%>" />
											<portlet:param name="month" value="<%=String.valueOf(pMonth+1)%>" />
											<portlet:param name="day" value="<%=String.valueOf(pDay)%>" />	
											<portlet:param name="dateweek" value="<%=dateweek%>" />
											</portlet:renderURL>', 'slideShow', 'directories=no,width=1000,height=500,scrollbars=yes,location=no,menubar=no,resizable=yes,left='.concat((screen.width - 400)/2).concat(',top=').concat((screen.height - 300)/2)); void(''); slideShowWindow.focus();"/>&nbsp;&nbsp;
										
										<a href="#" onClick="var slideShowWindow = window.open('<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>">
											<portlet:param name="jspPage" value="/html/portlet/vcalendarview/print_calendar.jsp" />	
											<portlet:param name="year" value="<%=String.valueOf(pYear)%>" />
											<portlet:param name="month" value="<%=String.valueOf(pMonth)%>" />
											<portlet:param name="day" value="<%=String.valueOf(pDay)%>" />	
											<portlet:param name="dateweek" value="<%=dateweek%>" />
											</portlet:renderURL>', 'slideShow', 'directories=no,width=1000,height=500,scrollbars=yes,location=no,menubar=no,resizable=yes,left='.concat((screen.width - 400)/2).concat(',top=').concat((screen.height - 300)/2)); void(''); slideShowWindow.focus();"><b><liferay-ui:message key="vfile.printcalendar" /></b></a>
								</li>
	-->							
								</ul>
							</fieldset>
						</div>
						<div class="wd-table wd-table-two">
							<table cellspacing="0" cellpadding="0">
								<thead>
									<tr>
										<th width="12%">&nbsp;</th>
									    <%
											cal.add(Calendar.DATE, -7);    
									    	Date mon = new Date(Integer.toString(cal.get(Calendar.MONTH)+1)+"/"+Integer.toString(cal.get(Calendar.DATE))+"/"+Integer.toString(cal.get(Calendar.YEAR)));
									    	
									 	 %>
										<th width="12%"><p><liferay-ui:message key="Monday" /><br /><%= dateFormatDate.format(Time.getDate(cal)) %></span></th>
										<% 
											cal.add(Calendar.DATE, 1);
											Date tues = new Date(Integer.toString(cal.get(Calendar.MONTH)+1)+"/"+Integer.toString(cal.get(Calendar.DATE))+"/"+Integer.toString(cal.get(Calendar.YEAR)));
    										
										 %>
										<th width="12%"><p><liferay-ui:message key="Tuesday" /><br /><%= dateFormatDate.format(Time.getDate(cal)) %></span></th>
										<% 
											cal.add(Calendar.DATE, 1);
											Date we = new Date(Integer.toString(cal.get(Calendar.MONTH)+1)+"/"+Integer.toString(cal.get(Calendar.DATE))+"/"+Integer.toString(cal.get(Calendar.YEAR)));
											    										
										 %>										
										<th width="12%"><p><liferay-ui:message key="Wedday" /><br /><%= dateFormatDate.format(Time.getDate(cal)) %></span></th>
										<% 
											cal.add(Calendar.DATE, 1); 
											Date thus = new Date(Integer.toString(cal.get(Calendar.MONTH)+1)+"/"+Integer.toString(cal.get(Calendar.DATE))+"/"+Integer.toString(cal.get(Calendar.YEAR)));
											   										
										 %>
										<th width="12%"><p><liferay-ui:message key="ThusDay" /><br /><%= dateFormatDate.format(Time.getDate(cal)) %></span></th>
										<% 
											cal.add(Calendar.DATE, 1);
											Date fri = new Date(Integer.toString(cal.get(Calendar.MONTH)+1)+"/"+Integer.toString(cal.get(Calendar.DATE))+"/"+Integer.toString(cal.get(Calendar.YEAR)));
											    										
										 %>
										<th width="12%"><p><liferay-ui:message key="FriDay" /><br /><%= dateFormatDate.format(Time.getDate(cal)) %></span></th>
										<% 
											cal.add(Calendar.DATE, 1);
											Date sa = new Date(Integer.toString(cal.get(Calendar.MONTH)+1)+"/"+Integer.toString(cal.get(Calendar.DATE))+"/"+Integer.toString(cal.get(Calendar.YEAR)));
											    										
										 %>
										<th width="12%"><p><liferay-ui:message key="SatDay" /><br /><%= dateFormatDate.format(Time.getDate(cal)) %></span></th>
										<% 
											cal.add(Calendar.DATE, 1);
											Date sun = new Date(Integer.toString(cal.get(Calendar.MONTH)+1)+"/"+Integer.toString(cal.get(Calendar.DATE))+"/"+Integer.toString(cal.get(Calendar.YEAR)));
											    										
										 %>
										<th width="12%"><p><liferay-ui:message key="SunDay" /><br /><%= dateFormatDate.format(Time.getDate(cal)) %></span></th>
									</tr>
								</thead>
								<tbody>
									<% 
										VCal sche = null;
										List leader = VFileServiceUtil.findByAll();
										for(int k=0; k<leader.size(); k++){
											VFile file = (VFile)leader.get(k);
											List todoM = VCalServiceUtil.findByF_D_G_T(file.getFileId(), mon, groupId,0);
											List todoT = VCalServiceUtil.findByF_D_G_T(file.getFileId(), tues , groupId,0);
											List todoW = VCalServiceUtil.findByF_D_G_T(file.getFileId(), we, groupId,0);
											List todoTh = VCalServiceUtil.findByF_D_G_T(file.getFileId(), thus, groupId,0);
											List todoF = VCalServiceUtil.findByF_D_G_T(file.getFileId(), fri, groupId,0);
											List todoSa = VCalServiceUtil.findByF_D_G_T(file.getFileId(), sa, groupId,0);
											List todoSu = VCalServiceUtil.findByF_D_G_T(file.getFileId(), sun, groupId,0);
									%>
											<tr>
											<td><p><strong><%=file.getFullname() %></strong></p></td>
										<!-- Get Monday work	 -->
										<%	
											if(todoM.size()<0){
										%>
												<td>&nbsp</td>
										<%}else{											
										%>
										<td>
										<%for(int m=0; m<todoM.size(); m++){
												sche = (VCal)todoM.get(m);
												List<Attachment> atts = AttachmentLocalServiceUtil.getAttachments(sche.getCalId(), VCal.class);
												
												%>
											<p><%=sche.getTime() %>: <%=sche.getDescription() %>
												</br>
												<%
												for(Attachment att : atts){
													
												DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(att.getFileEntryId());
												String url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + att.getFolderId() + StringPool.SLASH + HttpUtil.encodeURL(fileEntry.getTitle(), true);	
												%>
												
												<a href="<%= url%>"><%= fileEntry.getTitle() %></a>
												
												
												<%} %>
											</p> 
											</p> 
											<%} 
												}%>											
										</td>
										<!-- Get Tuesday work	 -->
										<%	
											if(todoT.size()<0){
										%>
												<td>&nbsp;</td>
										<%}else{
										%>
										<td>
										<%	for(int m=0; m<todoT.size(); m++){
												sche = (VCal)todoT.get(m); 
												List<Attachment> atts = AttachmentLocalServiceUtil.getAttachments(sche.getCalId(), VCal.class);
												
												%>
											<p><%=sche.getTime() %>: <%=sche.getDescription() %>
												</br>
												<%
												for(Attachment att : atts){
													
												DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(att.getFileEntryId());
												String url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + att.getFolderId() + StringPool.SLASH + HttpUtil.encodeURL(fileEntry.getTitle(), true);	
												%>
												
												<a href="<%= url%>"><%= fileEntry.getTitle() %></a>
												
												
												<%} %>
											</p> 
											<%}
												}%>											
										</td>
										
										<!-- Get Wesday work	 -->
										<%	
											if(todoW.size()<0){
										%>
												<td>&nbsp;</td>
										<%}else{									
										%>
										<td>
										<%for(int m=0; m<todoW.size(); m++){
											sche = (VCal)todoW.get(m); 
											List<Attachment> atts = AttachmentLocalServiceUtil.getAttachments(sche.getCalId(), VCal.class);
												
												%>
											<p><%=sche.getTime() %>: <%=sche.getDescription() %>
												</br>
												<%
												for(Attachment att : atts){
													
												DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(att.getFileEntryId());
												String url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + att.getFolderId() + StringPool.SLASH + HttpUtil.encodeURL(fileEntry.getTitle(), true);	
												%>
												
												<a href="<%= url%>"><%= fileEntry.getTitle() %></a>
												
												
												<%} %>
											</p> 
												<%}
											}%>											
										</td>
										
										<!-- Get Thusday work	 -->
										<%	
											if(todoTh.size()<0){
										%>
												<td>&nbsp;</td>
										<%}else{
											
										%>
										<td>
										<%for(int m=0; m<todoTh.size(); m++){
											sche = (VCal)todoTh.get(m); 						
											List<Attachment> atts = AttachmentLocalServiceUtil.getAttachments(sche.getCalId(), VCal.class);
												
										%>
											<p><%=sche.getTime() %>: <%=sche.getDescription() %>
												</br>
												<%
												for(Attachment att : atts){
													
												DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(att.getFileEntryId());
												String url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + att.getFolderId() + StringPool.SLASH + HttpUtil.encodeURL(fileEntry.getTitle(), true);	
												%>
												
												<a href="<%= url%>"><%= fileEntry.getTitle() %></a>
												
												
												<%} %>
											</p> 
												<%}
											}%>											
										</td>
										
										<!-- Get Friday work	 -->
										<%	
											if(todoF.size()<0){
										%>
												<td>&nbsp;</td>
										<%}else{
											
										%>
										<td>
										<%for(int m=0; m<todoF.size(); m++){
											sche = (VCal)todoF.get(m);						
											List<Attachment> atts = AttachmentLocalServiceUtil.getAttachments(sche.getCalId(), VCal.class);
											
											%>
										<p><%=sche.getTime() %>: <%=sche.getDescription() %>
											</br>
											<%
											for(Attachment att : atts){
												
											DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(att.getFileEntryId());
											String url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + att.getFolderId() + StringPool.SLASH + HttpUtil.encodeURL(fileEntry.getTitle(), true);	
											%>
											
											<a href="<%= url%>"><%= fileEntry.getTitle() %></a>
											
											
											<%} %>
										</p> 
												<%}
											}%>	
											
										<!-- Get Sartuday work	 -->
										<%	
											if(todoSa.size()<0){
										%>
												<td>&nbsp;</td>
										<%}else{
											
										%>
										<td>
										<%for(int m=0; m<todoSa.size(); m++){
											sche = (VCal)todoSa.get(m); 						
											List<Attachment> atts = AttachmentLocalServiceUtil.getAttachments(sche.getCalId(), VCal.class);
												
												%>
											<p><%=sche.getTime() %>: <%=sche.getDescription() %>
												</br>
												<%
												for(Attachment att : atts){
													
												DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(att.getFileEntryId());
												String url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + att.getFolderId() + StringPool.SLASH + HttpUtil.encodeURL(fileEntry.getTitle(), true);	
												%>
												
												<a href="<%= url%>"><%= fileEntry.getTitle() %></a>
												
												
												<%} %>
											</p> 
												<%}
											}%>												
										</td>
										
										<!-- Get Sunday work	 -->
										<%	
											if(todoSu.size()<0){
										%>
												<td>&nbsp;</td>
										<%}else{
											
										%>
										<td>
										<%for(int m=0; m<todoSu.size(); m++){
											sche = (VCal)todoSu.get(m); %>
											<p><%=sche.getTime() %>: <%=sche.getDescription() %>
												</br><vportal:file-download entryId="<%= sche.getCalId() %>" entryClass="<%= VCal.class %>" />
											</p> 
												<%}
											}%>												
										</td>
									</tr>
									
									<%	
									
										}
									%>
										
								</tbody>
							</table>
						</div>
					</div>

<script type="text/javascript">
	function <portlet:namespace />submitForm(value){	
    var value_array=value.split("/");	
	self.location = '<portlet:renderURL></portlet:renderURL>&<portlet:namespace />month=' + (value_array[1]-1) + '&<portlet:namespace />day=' + 
														value_array[0] + '&<portlet:namespace />year=' + value_array[2];
	}
	var offsetxpoint=-60 //Customize x offset of tooltip
	var offsetypoint=20 //Customize y offset of tooltip
	var ie=document.all
	var ns6=document.getElementById && !document.all
	var enabletip=false
	if (ie||ns6)
	var tipobj=document.all? document.all["dhtmltooltip"] : document.getElementById? document.getElementById("dhtmltooltip") : ""
	
	function ietruebody(){
	return (document.compatMode && document.compatMode!="BackCompat")? document.documentElement : document.body
	}
	
	function ddrivetip(thetext, thecolor, thewidth){
	if (ns6||ie){
	if (typeof thewidth!="undefined") tipobj.style.width=thewidth+"px"
	if (typeof thecolor!="undefined" && thecolor!="") tipobj.style.backgroundColor=thecolor
	tipobj.innerHTML=thetext
	enabletip=true
	return false
	}
	}
	
	function positiontip(e){
	if (enabletip){
	var curX=(ns6)?e.pageX : event.clientX+ietruebody().scrollLeft;
	var curY=(ns6)?e.pageY : event.clientY+ietruebody().scrollTop;
	//Find out how close the mouse is to the corner of the window
	var rightedge=ie&&!window.opera? ietruebody().clientWidth-event.clientX-offsetxpoint : window.innerWidth-e.clientX-offsetxpoint-20
	var bottomedge=ie&&!window.opera? ietruebody().clientHeight-event.clientY-offsetypoint : window.innerHeight-e.clientY-offsetypoint-20
	
	var leftedge=(offsetxpoint<0)? offsetxpoint*(-1) : -1000
	
	//if the horizontal distance isn't enough to accomodate the width of the context menu
	if (rightedge<tipobj.offsetWidth)
	//move the horizontal position of the menu to the left by it's width
	tipobj.style.left=ie? ietruebody().scrollLeft+event.clientX-tipobj.offsetWidth+"px" : window.pageXOffset+e.clientX-tipobj.offsetWidth+"px"
	else if (curX<leftedge)
	tipobj.style.left="5px"
	else
	//position the horizontal position of the menu where the mouse is positioned
	tipobj.style.left=curX+offsetxpoint+"px"
	
	//same concept with the vertical position
	if (bottomedge<tipobj.offsetHeight)
	tipobj.style.top=ie? ietruebody().scrollTop+event.clientY-tipobj.offsetHeight-offsetypoint+"px" : window.pageYOffset+e.clientY-tipobj.offsetHeight-offsetypoint+"px"
	else
	tipobj.style.top=curY+offsetypoint+"px"
	tipobj.style.visibility="visible"
	}
	}
	
	function hideddrivetip(){
	if (ns6||ie){
	enabletip=false
	tipobj.style.visibility="hidden"
	tipobj.style.left="-1000px"
	tipobj.style.backgroundColor=''
	tipobj.style.width=''
	}
	}
	
	document.onmousemove=positiontip
</script>