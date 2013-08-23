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
 * Copyright (c) 2000-2006 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
%>

<%@ include file="/html/portlet/vcms/init.jsp" %>
<%
String redirect = ParamUtil.getString(request, "redirect");
String portionIdTemp = ParamUtil.getString(request, "portionId");
VcmsPortion portion = null;
if(portionIdTemp != "")
	portion = VcmsPortionServiceUtil.getPortion(ParamUtil.getString(request, "portionId"));
String portionId2 = ((portion != null) ? portion.getPortionId() : null);

%>


<form  method="post" name="<portlet:namespace />fm" >
<input name="<portlet:namespace />portionId" type="hidden" value="<%= portionId2 %>">
<input name="<portlet:namespace />groupId" type="hidden" value="<%= groupId %>">

<liferay-ui:error exception="<%= InvalidPortionNameException.class %>" message="portlet.vcms.portion.exception.please-enter-a-valid-portion-name" />
<liferay-ui:error exception="<%= InvalidPortionCodeException.class %>" message="portlet.vcms.portion.exception.please-enter-a-valid-portion-code" />
<liferay-ui:error exception="<%= DuplicatePortionCodeException.class %>" message="portlet.vcms.portion.exception.the-portal-code-you-have-entered-is-already-used" />


<c:if test='<%= portionId2 != null %>'>
	<liferay-ui:tabs names="<%= LanguageUtil.get(pageContext, \"portlet.vcms.portion.edit.update\") %>" backURL="<%= redirect %>" />
</c:if>
<c:if test='<%= portionId2 == null %>'>
	<liferay-ui:tabs names="<%= LanguageUtil.get(pageContext, \"portlet.vcms.portion.edit.add-new\") %>" backURL="<%= redirect %>" />
</c:if>	
	

<table border="0" cellpadding="4" cellspacing="0" width="100%">
	<tr height="30">
		<td>
			<%= LanguageUtil.get(pageContext, "portlet.vcms.portion.edit.language") %>:
		</td>
		<td>
			<input type="hidden" name="<portlet:namespace />language" value="<%= (portion != null) ? portion.getLanguage() : language %>" />
			<select name="<portlet:namespace />language_tmp" disabled style="width: 200px">
				<%	for (int i = 0; i < locales.length; i++) {	%>
					<option <%= (language.equals(locales[i].getLanguage() + "_" + locales[i].getCountry())) ? "selected" : "" %> value="<%= locales[i].getLanguage() + "_" + locales[i].getCountry() %>"><%= locales[i].getDisplayName(locales[i]) %></option>
				<%	}	%>
			</select>
		</td>
	</tr>
	<tr height="30">
		<td>
			<%= LanguageUtil.get(pageContext, "portlet.vcms.portion.edit.code") %>:
		</td>
		<td>
			<input type="text" style="width: 300px" maxlength="150" name="<portlet:namespace />code" value="<%= (portion != null) ? portion.getCode() : "" %>" />
		</td>
	</tr>
	<tr height="30">
		<td>
			<%= LanguageUtil.get(pageContext, "portlet.vcms.portion.edit.name") %>:
		</td>
		<td>
			<input type="text" style="width: 300px" maxlength="150" name="<portlet:namespace />name" value="<%= (portion != null) ? portion.getName() : "" %>" />
		</td>
	</tr>
	<%
	  if(!(((portion != null) && portion.getCategorizable())&&VcmsCategoryServiceUtil.getCategoriesByPortion(groupId,portionId2,language).size()>0)){
	%>				
	<tr height="30">
		<td>
			<%= LanguageUtil.get(pageContext, "portlet.vcms.portion.edit.categorizable") %>
		</td>
		<td>
			<input type="checkbox" value="1" name="<portlet:namespace />categorizable" <%= ((portion != null) && portion.getCategorizable()) ? "checked" : "" %> />		
		</td>
	</tr>
	<%
	}else{
	%>	
	<input type="hidden" value="1" name="<portlet:namespace />categorizable" />	
	<%
	}
		%>			
	<tr height="30">
		<td valign="top">
			<%= LanguageUtil.get(pageContext, "portlet.vcms.portion.edit.description") %>:
		</td>
		<td>
			<textarea style="width: 300px" maxlength="500" rows="5" name="<portlet:namespace />description"><%= (portion != null) ? portion.getDescription() : "" %></textarea>
		</td>
	</tr>
	
	<c:if test="<%= portion == null %>">

		<tr height="30">
			<td valign="top">
				<liferay-ui:message key="permissions" />
			</td>
			<td>
				<liferay-ui:input-permissions
					modelName="<%= VcmsPortion.class.getName() %>"
				/>
			</td>
		</tr>
	</c:if>
</table>

<br>
	
<div>	
	<input class="portlet-form-button" type="button" value='<%= LanguageUtil.get(pageContext, "portlet.vcms.button.save") %>' onClick="<portlet:namespace />submitForm()">
			
			<input class="portlet-form-button" type="button" value='<%= LanguageUtil.get(pageContext, "portlet.vcms.button.cancel") %>' onClick="self.location = '<%= redirect %>';">
</div>	

</form>

<script type="text/javascript">
	document.<portlet:namespace />fm.<portlet:namespace />code.focus();
</script>
<script type="text/javascript">

function showErrorField(field) {
	//field.style.border="2px solid red";
	field.focus();
}
function resetField(field) {
	field.style.border="1px solid #CCC";
}

function clearField(field){
	field.value = "";
}

function <portlet:namespace />submitForm(){
		
		var code = document.<portlet:namespace />fm.<portlet:namespace />code;		
		var name = document.<portlet:namespace />fm.<portlet:namespace />name;					
	
		
		if(code.value==""){
			alert("<%=LanguageUtil.get(pageContext,"vportal.portlet.vcms.addCode")%>");
			showErrorField(code);			
			return false;
		}
		
		if(name.value==""){
			alert("<%=LanguageUtil.get(pageContext,"vportal.portlet.vcms.addName")%>");
			showErrorField(name);			
			return false;
		}
				
		
		submitForm(document.<portlet:namespace />fm, '<portlet:actionURL windowState="<%=WindowState.MAXIMIZED.toString()%>" name="updatePortion"></portlet:actionURL>');		
		return true;
	}
</script>