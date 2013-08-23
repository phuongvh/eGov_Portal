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

<%@ include file="/html/portlet/vfile/tabs.jsp" %>
<%
    String redirect = ParamUtil.getString(request, "redirect");
	String fileId = ParamUtil.getString(request, "fileId","0");
	String cmd = ParamUtil.getString(request,Constants.CMD,Constants.ADD);
	Calendar currentDate = new GregorianCalendar();
	VFile vfile=null;
	Calendar birthday = new GregorianCalendar();
	try{
	if(!fileId.equals("0")){
	  vfile=VFileServiceUtil.findById(Long.parseLong(fileId));
	  birthday = Calendar.getInstance();
	  birthday.setTime(vfile.getBirthday()) ;
	  
	  }
	}catch(Exception e){
	}
%>
<script type="text/javascript" >
	function <portlet:namespace />saveEvent(){
		submitForm(document.<portlet:namespace />fm, '<portlet:actionURL windowState="<%=WindowState.MAXIMIZED.toString()%>" name="updateVFile"></portlet:actionURL>');
	}
</script>

<%-- JS check validate --%>

<script>
	function <portlet:namespace />submitForm() {
		var addContentForm = document.<portlet:namespace />fm;
		var fullname = addContentForm.<portlet:namespace />fullname;
		var address = addContentForm.<portlet:namespace />address;
		var phone = addContentForm.<portlet:namespace />phone;
		var position = addContentForm.<portlet:namespace />position;
		resetField(fullname);
		resetField(address);		
		resetField(phone);
		resetField(position);
		
		if (fullname.value.length < 1) {
			alert("<%= LanguageUtil.get(pageContext, "pVfile.form.fullname") %> <%= LanguageUtil.get(pageContext, "pVfile.form.cannotBlank") %>");
			showErrorField(fullname);
			return ;
		}
		if (address.value.length < 1) {
			alert("<%= LanguageUtil.get(pageContext, "pVfile.form.address") %> <%= LanguageUtil.get(pageContext, "pVfile.form.cannotBlank") %>");
			showErrorField(address);
			return ;
		}
		if (phone.value.length < 1) {
			alert("<%= LanguageUtil.get(pageContext, "pVfile.form.phone") %> <%= LanguageUtil.get(pageContext, "pVfile.form.cannotBlank") %>");
			showErrorField(phone);
			return ;
		}
		if (phone.value.length > 11) {
			alert("<%= LanguageUtil.get(pageContext, "pVfile.form.phone") %> <%= LanguageUtil.get(pageContext, "pVfile.form.phone has maximum 11 digits") %>");
			showErrorField(phone);
			return ;
		}
		if (position.value.length < 1) {
			alert("<%= LanguageUtil.get(pageContext, "pVfile.form.position") %> <%= LanguageUtil.get(pageContext, "pVfile.form.cannotBlank") %>");
			showErrorField(position);
			return ;
		}
		submitForm(document.<portlet:namespace />fm, '<portlet:actionURL windowState="<%=WindowState.MAXIMIZED.toString()%>" name="updateVFile"></portlet:actionURL>');
// 		addContentForm.submit();
	}
	function showErrorField(field) {
		field.style.border="2px solid red";
		field.focus();
	}
	function resetField(field) {
		field.style.border="1px solid #CCC";
	}
	function checkPhone(phone) {
		var filter  = /^\+?[0-9\-]+\*?$/;
		
		if (filter.test(phone)) {
			return true;
		}
		return false;
	}
</script>

<%-- End JS check validate --%>


<form  action="<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>">
	<portlet:param name="struts_action" value="/vcalendar/edit_file" /></portlet:actionURL>" 
		method="post" name="<portlet:namespace />fm" onSubmit="<portlet:namespace />saveEvent(); return false;">
<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= cmd%>" />
<input name="<portlet:namespace />redirect" type="hidden" value="<%= redirect %>" />
<input name="<portlet:namespace />fileId" type="hidden" value="<%= fileId %>" />

<liferay-ui:tabs
	names="event"
	backURL="<%= redirect %>"
/>
<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tr >
	<td >
	pVfile.form.fullname
		<liferay-ui:message key="pVfile.form.fullname" />
	</td>
	<td>
	    <input id="<portlet:namespace />title" name="<portlet:namespace />fullname" style="width: 350px;" value="<%=(vfile!=null)?vfile.getFullname():""%>" type="text">
	</td>
</tr>
<tr>
 <td height="3px;">
 </td>
 </tr>
<tr>
    <td>
		Ng&#224;y sinh
	</td>
	<td>
	    <liferay-ui:input-date
				disableNamespace="<%= false %>"
				monthParam="dateMonth"
				monthValue="<%=birthday.get(Calendar.MONTH) %>"
				dayParam="dateDay"
				dayValue="<%= birthday.get(Calendar.DATE)  %>"
				yearParam="dateYear"
				yearValue="<%=birthday.get(Calendar.YEAR) %>"
				yearRangeStart="<%= curYear-100 %>"
				yearRangeEnd="<%= curYear+10 %>"
				firstDayOfWeek="<%= currentDate.getFirstDayOfWeek() - 1 %>"
				disabled="<%= false %>"
			/>
	
	</td>
</tr>
<tr>
 <td height="3px;">
 </td>
 </tr>
<tr>
	<td>
		&#272;&#7883;a ch&#7881;
	</td>
	<td>
	    <input id="<portlet:namespace />address" name="<portlet:namespace />address" style="width: 350px;" value="<%=(vfile!=null)?vfile.getAddress():""%>" type="text">
	</td>
</tr>
<tr>
 <td height="3px;">
 </td>
 </tr>
<tr>
	<td>
		&#272;i&#7879;n tho&#7841;i
	</td>
	<td>
	    <input id="<portlet:namespace />title" name="<portlet:namespace />phone" style="width: 350px;" value="<%=(vfile!=null)?vfile.getPhone():""%>" type="text">
	</td>
</tr>
<tr>
 <td height="3px;">
 </td>
 </tr>
<tr>
	<td>
		Ch&#7913;c v&#7909;
	</td>
	<td>
	    <input id="<portlet:namespace />title" name="<portlet:namespace />position" style="width: 350px;" value="<%=(vfile!=null)?vfile.getPosition():""%>" type="text">
	</td>
</tr>
<tr>
 <td colspan="2">
<br />

<input type="button" onclick="<portlet:namespace />submitForm();" value="<liferay-ui:message key="save"  />" />

<input type="reset" value="<liferay-ui:message key="cancel" />" />
</td>
</tr>
</table>

</form>