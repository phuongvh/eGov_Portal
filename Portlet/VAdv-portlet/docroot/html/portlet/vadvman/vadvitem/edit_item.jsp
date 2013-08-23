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
<%@include file="/html/portlet/vadvman/init.jsp"%>
<%
	String redirect = ParamUtil.getString(request, "redirect");
	String itemIdTemp = ParamUtil.getString(request, "itemId");
	AdvItem item = null;
	if(Validator.isNotNull(itemIdTemp) || !itemIdTemp.equals(""))
		item = AdvItemServiceUtil.getItem(Long.valueOf(itemIdTemp));
	if (item == null){
		item = new AdvItemImpl();
	}	
	
	List listType = AdvTypeServiceUtil.getTypeByG(groupId);
	
	String itemId = ((item != null && Long.toString(item.getItemId()) != null) ? Long.toString(item.getItemId()) : null);
	
	PortletURL formAction = renderResponse.createActionURL();
	formAction.setParameter("jspPage", "/html/portlet/vadvman/vadvtype/view_item.jspf");
	
	Calendar currentDate = new GregorianCalendar();
	

	int expiredYear = currentDate.get(Calendar.YEAR);
	int expiredMonth = currentDate.get(Calendar.MONTH);
	int expiredDay = currentDate.get(Calendar.DATE);
	
	try {
		if (Validator.isNotNull(itemId)){
			expiredYear = item.getExpriedDate().getYear() + 1900 ;
			expiredMonth = item.getExpriedDate().getMonth();
			expiredDay = item.getExpriedDate().getDate();
		}
	} catch(Exception ex){}

	
	int expiredDateDate = ParamUtil.getInteger(request,"expiredDay", expiredDay);
	int expiredDateMonth = ParamUtil.getInteger(request,"expiredMonth", expiredMonth);
	int expiredDateYear = ParamUtil.getInteger(request,"expiredYear" , expiredYear);
%>

<script language="javascript">	
	function <portlet:namespace />disableInputDate() {		
		var checkbox = document.getElementById('<portlet:namespace />neverExpired');
		var date = document.getElementById('<portlet:namespace />date');
		if (checkbox.checked){
			date.style.display = 'none';
		}else {
			date.style.display = '';
		}		
	};	
	
	function <portlet:namespace />submitForm() {
		submitForm(document.<portlet:namespace />fm,'<portlet:actionURL name="_updateItem" windowState="<%= WindowState.MAXIMIZED.toString() %>"></portlet:actionURL>'); 
	}
</script>

<c:if test='<%= itemId != null %>'>
	<liferay-ui:tabs names="update" backURL="<%= redirect %>" />
</c:if>
<c:if test='<%= itemId == null %>'>
	<liferay-ui:tabs names="add" backURL="<%= redirect %>" />
</c:if>
	
<liferay-ui:error exception="<%= ItemExpirationDateException.class %>" message="please-enter-invalid-expried-date" />
<liferay-ui:error exception="<%= InvalidItemDescriptionException.class %>" message="please-enter-invalid-description" />
	
<form action="<portlet:actionURL><portlet:param name="struts_action" value="/vadvman/item" />
	</portlet:actionURL>" method="post" name="<portlet:namespace />fm" enctype="multipart/form-data" >	
	<input name="<portlet:namespace />itemId" type="hidden" value="<%= (itemId != null) ? itemId : "" %>">
	<input name="<portlet:namespace />cmd" type="hidden" value="<%=Validator.isNotNull(item.getItemId()) ? "doupdate" : "doadd" %>">
	<input name="<portlet:namespace />redirect" type="hidden" value="<%= redirect %>">

<table>
<tr height="30">	
	<td width="30%"><%= LanguageUtil.get(pageContext, "VAdvman.form.typeId") %> :</td>
	<td width="70%">
		<select name="<portlet:namespace />typeId" id="<portlet:namespace />typeId" style="width:180px;">
			<%	for(int i=0; i<listType.size();i++)	{
					AdvType type = (AdvType)listType.get(i);	 %>
				<option value="<%= type.getTypeId()%>" <%= (String.valueOf(type.getTypeId()).equals(String.valueOf(item.getTypeId()))  ? "selected":"") %> ><%= type.getName() %></option>
			<%	}	%>	
		</select>
	<td>
</tr>
	
<tr height="30">
	<td><%= LanguageUtil.get(pageContext, "VAdvman.form.nameItem") %> :</td>
	<td>
		<vportal:file-upload entryId="<%=GetterUtil.getLong(itemId , 0)%>" entryClass="<%=AdvItem.class%>" style="2" />
	</td>	
</tr>
	
<tr height="30">	
	<td><%= LanguageUtil.get(pageContext, "VAdvman.form.descriptionItem") %> :</td>
	<td>
		<textarea name="<portlet:namespace />description" class="lfr-textarea" ><%= (item != null) ? item.getDescription() : "" %></textarea></td>
</tr>
		
<tr height="30">
	<td><%= LanguageUtil.get(pageContext, "VAdvman.form.url") %> :</td>
	<td>
		<liferay-ui:input-field model="<%= AdvItem.class %>" bean="<%= item %>" field="url" /></td>
</tr>
	
<tr height="30">
	<td><%= LanguageUtil.get(pageContext, "VAdvman.form.txtMouseOver") %> :</td>
	<td>
		<liferay-ui:input-field model="<%= AdvItem.class %>" bean="<%= item %>" field="txtMouseOver" /></td>
</tr>

<tr height="30">
	<td><%= LanguageUtil.get(pageContext, "VAdvman.form.expriedDate") %> :</td>
	<td>
		<table width="100%">
		<tr height="30" id="<portlet:namespace/>date" style="<%=Validator.isNull(item.getExpriedDate())? "display:none":""%>;">
			<td align="left"  ><liferay-ui:input-date
				disableNamespace="<%= false %>"
				monthParam="expiredMonth"
				monthValue="<%= expiredMonth %>"
				dayParam="expiredDay"
				dayValue="<%= expiredDay %>"
				yearParam="expiredYear"
				yearValue="<%= expiredYear %>"
				yearRangeStart="<%= curYear-10 %>"
				yearRangeEnd="<%= curYear+10 %>"
				firstDayOfWeek="<%= currentDate.getFirstDayOfWeek() - 1 %>"
				disabled="false"	/></td>
		</tr>	
		<tr height="30">
			<td>
				&nbsp;<input type="checkbox" name="<portlet:namespace/>neverExpired" id="<portlet:namespace/>neverExpired" 
					onClick="javascript:<portlet:namespace />disableInputDate();" <%= Validator.isNull(item.getExpriedDate())? "checked":""%>/>
				<label for="<portlet:namespace/>neverExpired" >Vô h&#7841;n</label></td>
		</tr>
		</table>
	</td>
</tr>
	
<tr height="30">
	<td><%= LanguageUtil.get(pageContext, "VAdvman.form.isTargetBlank") %> :</td>
	<td>		
		&nbsp;<input type="checkbox" name="<portlet:namespace />isTargetBlank" id="<portlet:namespace />isTargetBlank" <%= ((item != null) && item.getIsTargetBlank()) ? "checked" : "" %>/></td>
</tr>	
		<c:if test="<%= item.getItemId()==0 %>">

			
				<tr>
					<td><liferay-ui:message key="permissions" /></td>
					<td width="100%" align="left">					
						<liferay-ui:input-permissions
							modelName="<%= AdvItem.class.getName() %>"
						/>
					
					</td>
				</tr>
			</c:if>	
</table>

	<br/>		
	<input type="submit" class="portlet-form-button" value="<liferay-ui:message key="save" />" onclick="<portlet:namespace />submitForm();" />	
	<input type="button" class="portlet-form-button" value="<liferay-ui:message key="cancel"/>" onClick="self.location = '<%= redirect %>';" />	
</form>
<c:if test="<%= windowState.equals(WindowState.MAXIMIZED) %>">
	<script type="text/javascript">
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />description);
	</script>
</c:if>		