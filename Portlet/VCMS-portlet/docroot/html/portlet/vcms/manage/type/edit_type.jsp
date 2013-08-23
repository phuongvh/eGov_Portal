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
<%@page import="com.vportal.portlet.vcms.service.persistence.VcmsStatusUtil"%>
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
 * all copies or substantial types of the Software.
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

	List listArticle = new ArrayList();
	//VcmsType type = (VcmsType) request.getAttribute(WebKeysExt.VCMS_TYPE);
		VcmsType type = null;
	String typeIdTemp = ParamUtil.getString(request, "typeId","");
	if(typeIdTemp != "")
		type = VcmsTypeServiceUtil.getType(typeIdTemp);
	//String typeId2 = ((type != null) ? type.getTypeId() : null);

	
	
%>

<script type="text/javascript">
	function <portlet:namespace />saveType() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= type == null ? Constants.ADD : Constants.UPDATE %>";
		submitForm(document.<portlet:namespace />fm);
	}

</script>

<form action="<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>" name="updateType">
</portlet:actionURL>" method="post" name="<portlet:namespace />fm" >
<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="">
<input name="<portlet:namespace />redirect" type="hidden" value="<%= redirect %>">
<input name="<portlet:namespace />typeId" type="hidden" value="<%= (type != null) ? type.getTypeId() : "" %>">
<input name="<portlet:namespace />groupId" type="hidden" value="<%= groupId %>">

<liferay-ui:error exception="<%= InvalidTypeNameException.class %>" message="portlet.vcms.type.exception.please-enter-a-valid-type-name" />
<liferay-ui:error exception="<%= InvalidTypeCodeException.class %>" message="portlet.vcms.type.exception.please-enter-a-valid-type-code" />
<liferay-ui:error exception="<%= DuplicateTypeCodeException.class %>" message="portlet.vcms.type.exception.the-portal-code-you-have-entered-is-already-used" />

<c:if test='<%= type != null %>'>
	<liferay-ui:tabs names="<%= LanguageUtil.get(pageContext, \"portlet.vcms.type.edit.update\") %>" backURL="<%= redirect %>" />
</c:if>
<c:if test='<%= type == null %>'>
	<liferay-ui:tabs names="<%= LanguageUtil.get(pageContext, \"portlet.vcms.type.edit.add-new\") %>" backURL="<%= redirect %>" />
</c:if>	
	
<table border="0" cellpadding="4" cellspacing="0" width="100%">
<tr height="30">
	<td>
		<%= LanguageUtil.get(pageContext, "language") %>:
	</td>
	<td>
		<input type="hidden" name="<portlet:namespace />language" value="<%= (type != null) ? type.getLanguage() : language %>" />
		<select name="<portlet:namespace />language_tmp" disabled style="width: 180px">
			<%	for (int i = 0; i < locales.length; i++) {	%>			
				<option <%= (language.equals(locales[i].getLanguage() + "_" + locales[i].getCountry())) ? "selected" : "" %> value="<%= locales[i].getLanguage() + "_" + locales[i].getCountry() %>"><%= locales[i].getDisplayName(locales[i]) %></option>
			
			<%	}	%>
		</select>
	</td>
</tr>
<tr height="30">
	<td>
		<%= LanguageUtil.get(pageContext, "code") %>:
	</td>
	<td>
		<input type="text" style="width: 300px" maxlength="150" name="<portlet:namespace />code" value="<%= (type != null) ? type.getCode() : "" %>" />
	</td>
</tr>
<tr height="30">
	<td>
		<%= LanguageUtil.get(pageContext, "name") %>:
	</td>
	<td>
		<input type="text" style="width: 300px" maxlength="150" name="<portlet:namespace />name" value="<%= (type != null) ? type.getName() : "" %>" />
	</td>
</tr>

<tr height="30">
	<td valign="top">
		<%= LanguageUtil.get(pageContext, "description") %>:
	</td>
	<td>
		<textarea class="form-text" style="width: 300px" maxlength="500" rows="5" name="<portlet:namespace />description"><%= (type != null) ? type.getDescription() : "" %></textarea>
	</td>
</tr>

<c:if test="<%= type == null %>">
	<tr height="30">
		<td>
			<liferay-ui:message key="permissions" />:
		</td>
		<td>
			<liferay-ui:input-permissions
				modelName="<%= VcmsType.class.getName() %>"
			/>
		</td>
	</tr>
</c:if>
</table>

	
					
	
<div>		
	<input class="portlet-form-button" type="submit" value='<%= LanguageUtil.get(pageContext, "portlet.vcms.button.save") %>'>		
	<input class="portlet-form-button" type="button" value='<%= LanguageUtil.get(pageContext, "portlet.vcms.button.cancel") %>' onClick="self.location = '<%= redirect %>';">
</div>	

</form>

<script type="text/javascript">
	document.<portlet:namespace />fm.<portlet:namespace />code.focus();

	function <portlet:namespace />updateArticlePosition(selector) {
		document.<portlet:namespace />fm.<portlet:namespace />position.value = selector.value;
		//document.<portlet:namespace />fm.<portlet:namespace />redirect.value = currentURL;
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = 'update_position';
		submitForm(document.<portlet:namespace />fm, '<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="jspPage" value="/html/portlet/vcms/manage/type/edit_type.jsp" /></portlet:actionURL>');
	}
</script>
