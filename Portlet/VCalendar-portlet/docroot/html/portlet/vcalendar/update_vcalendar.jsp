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
<%@page import="java.text.Format"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.Time"%>
<%@page import="com.liferay.portlet.calendar.EventTitleException"%>
<%@page import="com.liferay.portlet.calendar.EventEndDateException"%>
<%@page import="com.liferay.portlet.calendar.EventStartDateException"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@ include file="/html/portlet/vcalendar/init.jsp" %>
<%
    String redirect = ParamUtil.getString(request, "redirect");
	String calId = ParamUtil.getString(request, "calId","0");
	String comment = ParamUtil.getString(request, "comment","");
	String type = ParamUtil.getString(request, "type","");
	int status = ParamUtil.getInteger(request, "status",0);
	String cmd = ParamUtil.getString(request,Constants.CMD,Constants.ADD);
	VCal vCal=null;
	
	Calendar currentDate = new GregorianCalendar();
	int startYear = currentDate.get(Calendar.YEAR);
	int startMonth = currentDate.get(Calendar.MONTH);
	int startDay = currentDate.get(Calendar.DATE);
	int startHours = 0;
	int startMinutes = 0;
	int endYear = currentDate.get(Calendar.YEAR);
	int endMonth = currentDate.get(Calendar.MONTH);
	int endDay = currentDate.get(Calendar.DATE);
	int endHours = 0;
	int endMinutes = 0;
	
	String monthTab = ParamUtil.getString(request,"month");
	String dayTab = ParamUtil.getString(request, "day");
	String yearTab = ParamUtil.getString(request, "year");
	
	try{
		if(!calId.equals("0")){
			vCal=VCalServiceUtil.findById(Long.parseLong(calId));
		}
	}catch(Exception e){
	}	
	String parten = "dd/MM/yyyy";
	Format format = new SimpleDateFormat(parten);
	String createDate = format.format(vCal.getStartDate());
	
%>


<form enctype="multipart/form-data" action="<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>">
	<portlet:param name="struts_action" value="/vcalendar/edit_event" />
	<portlet:param name="month" value="<%= String.valueOf(selMonth) %>" />
	<portlet:param name="tabs" value="<%=tabs%>" /><portlet:param name="action" value="add_action" />
	<portlet:param name="status" value="<%= String.valueOf(status) %>" />
	<portlet:param name="day" value="<%= String.valueOf(selDay) %>" />
	<portlet:param name="year" value="<%= String.valueOf(selYear) %>" />
	</portlet:actionURL>" method="post" name="<portlet:namespace />fm" 
	onSubmit="<portlet:namespace />saveEvent(); return false;">
<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= cmd%>" />
<input name="<portlet:namespace />redirect" type="hidden" value="<%= renderResponse.createRenderURL().toString() %>" />
<input name="<portlet:namespace />calId" type="hidden" value="<%= calId %>" />
	
<c:if test='<%= calId != "0" %>'>
	<liferay-ui:tabs names="update" backURL="<%= redirect %>" />
</c:if>
<c:if test='<%= calId == "0" %>'>
	<liferay-ui:tabs names="add" backURL="<%= redirect %>" />
</c:if>	
  
<liferay-ui:error exception="<%= EventStartDateException.class %>" message="please-enter-a-valid-start-date" />
<liferay-ui:error exception="<%= EventEndDateException.class %>" message="please-enter-a-valid-end-date" />
<liferay-ui:error exception="<%= EventTitleException.class %>" message="please-enter-a-valid-title" />

<table class="lfr-table">

<%
String tabs1 = ParamUtil.getString(request, "tabs1", "Monday");
Calendar cal = (Calendar)selCal.clone();

cal = VCalUtil.getFirstDayOfWeek(cal);

cal.add(Calendar.DATE, 1);
int startDateDay = ParamUtil.getInteger(request, "startDateDay", cal.get(Calendar.DATE));
int startDateMonth = ParamUtil.getInteger(request, "startDateMonth", cal.get(Calendar.MONTH));
int startDateYear = ParamUtil.getInteger(request, "startDateYear", cal.get(Calendar.YEAR));
int endDateDay = ParamUtil.getInteger(request, "endDateDay", startDateDay);
int endDateMonth = ParamUtil.getInteger(request, "endDateMonth", startDateMonth);
int endDateYear = ParamUtil.getInteger(request, "endDateYear", startDateYear);
PortletURL mondayURL = renderResponse.createRenderURL();
mondayURL.setWindowState(WindowState.MAXIMIZED);
mondayURL.setParameter("struts_action","/vcalendar/edit_event");
mondayURL.setParameter("startDateMonth",Integer.toString(cal.get(Calendar.MONTH)));
mondayURL.setParameter("startDateDay",Integer.toString(cal.get(Calendar.DATE)));
mondayURL.setParameter("startDateYear",Integer.toString(cal.get(Calendar.YEAR)));
mondayURL.setParameter("status",Integer.toString(status));
mondayURL.setParameter("day", dayTab);
mondayURL.setParameter("month", monthTab);
mondayURL.setParameter("year", yearTab);
mondayURL.setParameter("tabs1","Monday");
cal.add(Calendar.DATE, 1);
PortletURL tuesdayURL = renderResponse.createRenderURL();
tuesdayURL.setWindowState(WindowState.MAXIMIZED);
tuesdayURL.setParameter("struts_action","/vcalendar/edit_event");
tuesdayURL.setParameter("startDateMonth",Integer.toString(cal.get(Calendar.MONTH)));
tuesdayURL.setParameter("startDateDay",Integer.toString(cal.get(Calendar.DATE)));
tuesdayURL.setParameter("startDateYear",Integer.toString(cal.get(Calendar.YEAR)));
tuesdayURL.setParameter("status",Integer.toString(status));
tuesdayURL.setParameter("day", dayTab);
tuesdayURL.setParameter("month", monthTab);
tuesdayURL.setParameter("year", yearTab);
tuesdayURL.setParameter("tabs1","Tuesday");
cal.add(Calendar.DATE, 1);
PortletURL webdayURL = renderResponse.createRenderURL();
webdayURL.setWindowState(WindowState.MAXIMIZED);
webdayURL.setParameter("struts_action","/vcalendar/edit_event");
webdayURL.setParameter("startDateMonth",Integer.toString(cal.get(Calendar.MONTH)));
webdayURL.setParameter("startDateDay",Integer.toString(cal.get(Calendar.DATE)));
webdayURL.setParameter("startDateYear",Integer.toString(cal.get(Calendar.YEAR)));
webdayURL.setParameter("status",Integer.toString(status));
webdayURL.setParameter("day", dayTab);
webdayURL.setParameter("month", monthTab);
webdayURL.setParameter("year", yearTab);
webdayURL.setParameter("tabs1","Wedday");

cal.add(Calendar.DATE, 1);
PortletURL thusdayURL = renderResponse.createRenderURL();
thusdayURL.setWindowState(WindowState.MAXIMIZED);
thusdayURL.setParameter("struts_action","/vcalendar/edit_event");
thusdayURL.setParameter("startDateMonth",Integer.toString(cal.get(Calendar.MONTH)));
thusdayURL.setParameter("startDateDay",Integer.toString(cal.get(Calendar.DATE)));
thusdayURL.setParameter("startDateYear",Integer.toString(cal.get(Calendar.YEAR)));
thusdayURL.setParameter("status",Integer.toString(status));
thusdayURL.setParameter("day", dayTab);
thusdayURL.setParameter("month", monthTab);
thusdayURL.setParameter("year", yearTab);
thusdayURL.setParameter("tabs1","ThusDay");
cal.add(Calendar.DATE, 1);
PortletURL fridayURL = renderResponse.createRenderURL();
fridayURL.setWindowState(WindowState.MAXIMIZED);
fridayURL.setParameter("struts_action","/vcalendar/edit_event");
fridayURL.setParameter("startDateMonth",Integer.toString(cal.get(Calendar.MONTH)));
fridayURL.setParameter("startDateDay",Integer.toString(cal.get(Calendar.DATE)));
fridayURL.setParameter("startDateYear",Integer.toString(cal.get(Calendar.YEAR)));
fridayURL.setParameter("status",Integer.toString(status));
fridayURL.setParameter("day", dayTab);
fridayURL.setParameter("month", monthTab);
fridayURL.setParameter("year", yearTab);
fridayURL.setParameter("tabs1","FriDay");
cal.add(Calendar.DATE, 1);
PortletURL satdayURL = renderResponse.createRenderURL();
satdayURL.setWindowState(WindowState.MAXIMIZED);
satdayURL.setParameter("struts_action","/vcalendar/edit_event");
satdayURL.setParameter("startDateMonth",Integer.toString(cal.get(Calendar.MONTH)));
satdayURL.setParameter("startDateDay",Integer.toString(cal.get(Calendar.DATE)));
satdayURL.setParameter("startDateYear",Integer.toString(cal.get(Calendar.YEAR)));
satdayURL.setParameter("status",Integer.toString(status));
satdayURL.setParameter("day", dayTab);
satdayURL.setParameter("month", monthTab);
satdayURL.setParameter("year", yearTab);
satdayURL.setParameter("tabs1","SatDay");
cal.add(Calendar.DATE, 1);
PortletURL sundayURL = renderResponse.createRenderURL();
sundayURL.setWindowState(WindowState.MAXIMIZED);
sundayURL.setParameter("struts_action","/vcalendar/edit_event");
sundayURL.setParameter("startDateMonth",Integer.toString(cal.get(Calendar.MONTH)));
sundayURL.setParameter("startDateDay",Integer.toString(cal.get(Calendar.DATE)));
sundayURL.setParameter("startDateYear",Integer.toString(cal.get(Calendar.YEAR)));
sundayURL.setParameter("status",Integer.toString(status));
sundayURL.setParameter("day", dayTab);
sundayURL.setParameter("month", monthTab);
sundayURL.setParameter("year", yearTab);
sundayURL.setParameter("tabs1","SunDay");
if(cmd.equals(Constants.ADD)){
%>
<tr>
 <td align="right" colspan="2" style="font: bold;"> 	
   Tu&#7847;n Th&#7913; 
		<select onChange="<portlet:namespace />submitForm(''+this.value);">
			<%
			
			int month = cal.get(Calendar.MONTH);
			int day = cal.get(Calendar.DATE);
			int year = cal.get(Calendar.YEAR);
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

					<option value="<%= dateFormatDate.format(Time.getDate(tempcal)) %>" <%= ((cal.get(Calendar.WEEK_OF_YEAR)) == i) ? "selected" : "" %>><%= i %> <%="( "+dateFormatDate.format(Time.getDate(firstTempCal))+" - " + ""+dateFormatDate.format(Time.getDate(nextTempCal))+" )" %></option>

				<%
				}
				%>

			</select>	
 </td>
</tr>
<tr>
 <td colspan="2">
   <liferay-ui:tabs names="Monday,Tuesday,Wedday,ThusDay,FriDay,SatDay,SunDay"
        url0="<%= mondayURL.toString() %>"
        url1="<%=tuesdayURL.toString()%>"
		url2="<%=webdayURL.toString()%>"
		url3="<%= thusdayURL.toString() %>"
        url4="<%=fridayURL.toString()%>"
		url5="<%=satdayURL.toString()%>"
		url6="<%=sundayURL.toString()%>"
        param="tabs1"/>    
 </td>
</tr> 
<%
}
%>
<input name="<portlet:namespace />startDatetime" type="hidden" value="<%=startDateMonth+1 %>/<%=startDateDay %>/<%=startDateYear %>" /> 
<tr>
	<td>
		Ng&#224;y
	</td>
	<td>
		<%=createDate %>
		
	</td>
</tr>
<tr>
	<td>		
		L&#227;nh &#273;&#7841;o
	</td>
	<td>
	    <select name="<portlet:namespace />fileId" id="<portlet:namespace />fileId" >
		   <%
		   List list = VFileServiceUtil.findByGroupId(groupId.intValue());
		   for(int i=0;i<list.size();i++){
			   VFile vfile = (VFile)list.get(i);
		  %>
		  <option value="<%= vfile.getFileId() %>"><%=vfile.getFullname() %></option>
		  <%
		   }
		  %>
		</select>
	</td>
</tr>
<tr>
 <td height="3">
 </td>
</tr>
<tr>
 <td>
   <liferay-ui:message key="title" />
 </td>
 <td>
   <input type="text" value="<%=(vCal!=null)?vCal.getTitle():""%>" name="<portlet:namespace />title" id="<portlet:namespace />title" style="width:500px;"> 
 </td>
</tr> 
<tr>
 <td height="3">
 </td>
</tr>
<tr>
	<td>
		<liferay-ui:message key="description" />
	</td>
	<td>
		<textarea id="<portlet:namespace />description" name="<portlet:namespace />description" style="height: 105px; width: 500px;"><%=(vCal!=null)?vCal.getDescription():""%></textarea>
	</td>
</tr>
<tr>
 <td height="3">
 </td>
</tr>
<tr>
	<td>
		Th&#224;nh ph&#7847;n
	</td>
	<td>
		<textarea id="<portlet:namespace />listguest" name="<portlet:namespace />listguest" style="height: 150px; width: 500px;"><%=(vCal!=null)?vCal.getGuest():""%></textarea>
	</td>
</tr>
<tr>
 <td height="3">
 </td>
</tr>
<tr>
	<td>
		&#272;&#7883;a &#273;i&#7875;m
	</td>
	<td>
		<textarea id="<portlet:namespace />location" name="<portlet:namespace />location" style="height: 50px; width: 500px;"><%=(vCal!=null)?vCal.getLocation():""%></textarea>
	</td>
</tr>
<tr>
 <td height="3">
 </td>
</tr>
<tr>
 <td>
   Th&#7901;i gian
 </td>
 <td>
   <input type="text" value="<%=(vCal!=null)?vCal.getTime():""%>" name="<portlet:namespace />time" id="<portlet:namespace />time" style="width:250px;"> 
 </td>
</tr>
<tr>
 <td height="3">
 </td>
</tr>
<tr>
	<td>&#272;&#237;nh k&#232;m</td>		  
	<td><vportal:file-upload entryId="<%=GetterUtil.getLong(calId , 0)%>" entryClass="<%=VCal.class%>" style="2" maxAttachment="2" /></td>
</tr>			   
</table>

<br />

<input type="button" onclick="<portlet:namespace />checkValidate();" value="<liferay-ui:message key="save" />" />

<input type="button" value="Quay l&#7841;i" onclick="<portlet:namespace />backVcal();"/>

</table>

</form>
<script language="javascript" type="text/javascript">
 function <portlet:namespace />ckshowtime(){
  var divshowtime = document.getElementById('divshowtime');
  var ckshowtime = document.<portlet:namespace />fm.<portlet:namespace />showtime;
  if(ckshowtime.checked){
    divshowtime.style.display = "";
  }else{
     divshowtime.style.display = "none";
  }
 }
  function <portlet:namespace />saveVcal(){
		<%-- submitForm(document.<portlet:namespace />fm, '<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/vcalendar/edit_event" /><portlet:param name="month" value="<%= String.valueOf(selMonth) %>" /><portlet:param name="action" value="add_action" /><portlet:param name="status" value="<%= String.valueOf(status) %>" /><portlet:param name="day" value="<%= String.valueOf(selDay) %>" /><portlet:param name="year" value="<%= String.valueOf(selYear) %>" /></portlet:actionURL>'); --%>
		submitForm(document.<portlet:namespace />fm, '<portlet:actionURL windowState="<%=WindowState.MAXIMIZED.toString()%>" name="updatevCal"></portlet:actionURL>');
  }
  function <portlet:namespace />checkValidate() {
	  var addContentForm = document.<portlet:namespace />fm;
		var title = addContentForm.<portlet:namespace />title;
		var description = addContentForm.<portlet:namespace />description;
		var listguest = addContentForm.<portlet:namespace />listguest;
		var location = addContentForm.<portlet:namespace />location;
		var time = addContentForm.<portlet:namespace />time;
		resetField(title);
/* 		resetField(description);		
		resetField(listguest);
		resetField(location); */
		resetField(time);
		if (title.value.length < 1) {
			alert("<%= LanguageUtil.get(pageContext, "pVcalendar.form.tittle") %> <%= LanguageUtil.get(pageContext, "pVfile.form.cannotBlank") %>");
			showErrorField(title);
			return ;
		}
		
<%--   CHECK VALIDATE MÔ TẢ, NGƯỜI THAM GIA, ĐỊA ĐIỂM
		if (description.value.length < 1) {
			alert("<%= LanguageUtil.get(pageContext, "pVfile.form.address") %> <%= LanguageUtil.get(pageContext, "pVfile.form.cannotBlank") %>");
			showErrorField(address);
			return ;
		}
		if (listguest.value.length < 1) {
			alert("<%= LanguageUtil.get(pageContext, "pVfile.form.phone") %> <%= LanguageUtil.get(pageContext, "pVfile.form.cannotBlank") %>");
			showErrorField(phone);
			return ;
		}
		if (location.value.length > 11) {
			alert("<%= LanguageUtil.get(pageContext, "pVfile.form.phone") %> <%= LanguageUtil.get(pageContext, "pVfile.form.phone have 11 digits") %>");
			showErrorField(phone);
			return ;
		} --%>
		if (time.value.length < 1) {
			alert("<%= LanguageUtil.get(pageContext, "pVcalendar.form.time") %> <%= LanguageUtil.get(pageContext, "pVfile.form.cannotBlank") %>");
			showErrorField(time);
			return ;
		}
		submitForm(document.<portlet:namespace />fm, '<portlet:actionURL windowState="<%=WindowState.MAXIMIZED.toString()%>" name="updatevCal"></portlet:actionURL>');
}
	function showErrorField(field) {
		field.style.border="2px solid red";
		field.focus();
	}
	function resetField(field) {
		field.style.border="1px solid #CCC";
	}
	
  
  function <portlet:namespace />backVcal(){
		submitForm(document.<portlet:namespace />fm, '<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="<%=(status==0)?\"/vcalendar/view\":\"/vcalendar/leader\"%>" /><portlet:param name="month" value="<%= String.valueOf(selMonth) %>" /><portlet:param name="action" value="add_action" /><portlet:param name="status" value="<%= String.valueOf(status) %>" /><portlet:param name="day" value="<%= String.valueOf(selDay) %>" /><portlet:param name="year" value="<%= String.valueOf(selYear) %>" /></portlet:renderURL>');
  }
  function <portlet:namespace />submitForm(value){				
    var value_array=value.split("/");	
	self.location = '<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/vcalendar/edit_event" /></portlet:renderURL>&<portlet:namespace />status=<%=status%>&<portlet:namespace />month=' + (value_array[1]-1) + '&<portlet:namespace />day=' + value_array[0] + '&<portlet:namespace />year=' + value_array[2];
}
 function <portlet:namespace />addlistguest(){
   	 var obj = document.<portlet:namespace />fm.<portlet:namespace />guest;
   	 document.<portlet:namespace />fm.<portlet:namespace />guest.options[obj.length] = new Option(document.<portlet:namespace />fm.<portlet:namespace />addguest.value,document.<portlet:namespace />fm.<portlet:namespace />addguest.value);
   	 document.<portlet:namespace />fm.<portlet:namespace />addguest.value = "";
 }
 function <portlet:namespace />deletelistguest(){
    var obj = document.<portlet:namespace />fm.<portlet:namespace />guest;
    for(var i=0;i<obj.length;i++){
       if(obj[i].selected){
         obj.remove(i);
       }
    }
 }
</script>