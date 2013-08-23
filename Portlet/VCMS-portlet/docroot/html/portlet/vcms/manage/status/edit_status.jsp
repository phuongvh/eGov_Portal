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
VcmsStatus status = null;
String statusIdTemp =ParamUtil.getString(request, "statusId") ;
if(statusIdTemp != "")
	status = VcmsStatusLocalServiceUtil.getVcmsStatus(Long.valueOf(statusIdTemp));

String redirect = ParamUtil.getString(request, "redirect");
//VcmsStatus status = (VcmsStatus) request.getAttribute("VCMS_STATUS");

int total = VcmsStatusLocalServiceUtil.countByGroupId(groupId);
%>

<script type="text/javascript">
	function <portlet:namespace />saveStatus() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= status == null ? Constants.ADD : Constants.UPDATE %>";
		submitForm(document.<portlet:namespace />fm);
	}
</script>

<form action="<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>" name="updateStatus">
</portlet:actionURL>" method="post" name="<portlet:namespace />fm" enctype="multipart/form-data">
	<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="">
	<input name="<portlet:namespace />statusId" type="hidden" value="<%= (status != null) ? status.getStatusId() : "" %>">
	<input name="<portlet:namespace />groupId" type="hidden" value="<%= groupId %>">
	
<!--<liferay-ui:error exception="<%= InvalidCategoryNameException.class %>" message="portlet.vcms.category.exception.please-enter-a-valid-category-name" />
<liferay-ui:error exception="<%= InvalidCategoryHrefException.class %>" message="portlet.vcms.category.exception.please-enter-a-valid-category-href" />
<liferay-ui:error exception="<%= InvalidCategoryPortionException.class %>" message="portlet.vcms.category.exception.please-select-a-valid-parent-category" />-->
	
	
<c:if test='<%= status != null %>'>
	<liferay-ui:tabs names="<%= LanguageUtil.get(pageContext, \"portlet.vcms.status.edit.update\") %>" backURL="<%= redirect %>" />
</c:if>
<c:if test='<%= status == null %>'>
	<liferay-ui:tabs names="<%= LanguageUtil.get(pageContext, \"portlet.vcms.status.edit.add-new\") %>" backURL="<%= redirect %>" />
</c:if>		
		
<div class="beta-separator"></div>
<table border="0" cellpadding="4" cellspacing="0" width="100%">
	<tr height="30">
		<td>
			<%= LanguageUtil.get(pageContext, "portlet.vcms.status.edit.title") %>:
		</td>
		<td>
			<input type="text" style="width: 300px" maxlength="200" name="<portlet:namespace />title" value="<%= (status != null) ? status.getName() : "" %>" />
		</td>
	</tr>
	<tr height="30">
		<td valign="top">
			<%= LanguageUtil.get(pageContext, "portlet.vcms.status.edit.description") %>:
		</td>
		<td>
			<textarea class="form-text" style="width: 300px" maxlength="500" rows="5" name="<portlet:namespace />description"><%= (status != null) ? status.getDescription() : "" %></textarea>
		</td>
	</tr>
	<tr height="30">
		<td>
			<%= LanguageUtil.get(pageContext, "portlet.vcms.status.edit.cssClass") %>:
		</td>
		<td>
			<input type="text" style="width: 300px" maxlength="200" name="<portlet:namespace />cssClass" value="<%= (status != null) ? status.getCssClass() : "" %>" />
		</td>
	</tr>
	<tr height="30">
		<td>
			<%= LanguageUtil.get(pageContext, "portlet.vcms.status.edit.textColor") %>:
		</td>
		<td>
			<input type="text" style="width: 300px" maxlength="200" name="<portlet:namespace />textColor" value="<%= (status != null) ? status.getTextColor() : "" %>" />
		</td>
	</tr>
	<tr height="30">
		<td>
			<%= LanguageUtil.get(pageContext, "portlet.vcms.status.edit.position") %>:
		</td>
		<td>
			<select name="position">
				<%
					for(int i=1; i<total+1; i++){
				%>
						<option value="<%= i %>" <%= (status != null && i==status.getPosition())?"selected":"" %>><%= i %></option>
				<%
					}
				%>
				<%
					if(status == null){
				%>
						<option value="<%= total+1 %>" selected><%= LanguageUtil.get(pageContext, "portlet.vcms.status.edit.position.last") %></option>
				<%
					}
				%>
			</select>
		</td>
	</tr>
		
	<tr height="30">
		<td>
			<%= LanguageUtil.get(pageContext, "portlet.vcms.status.edit.primary") %>:
		</td>
		<td>
			<input type="checkbox" class="form-text" name="<portlet:namespace />isPrimary" value="1" <%= (status != null && status.getIsPrimary()) ? "checked": "" %> />
		</td>
	</tr>
		
	<tr height="30">
		<td>
			<%= LanguageUtil.get(pageContext, "portlet.vcms.status.edit.active") %>:
		</td>
		<td>
			<input type="checkbox" class="form-text" name="<portlet:namespace />active" value="1" <%= (status != null && status.getActive()) ? "checked": "" %> />
		</td>
	</tr>
		
	<c:if test="<%= status == null %>">

		<tr height="30">
			<td valign="top">
				<liferay-ui:message key="permissions" /> : 
			</td>
			<td>
				<liferay-ui:input-permissions
					modelName="<%= VcmsStatus.class.getName() %>"
				/>
			</td>
		</tr>

	</c:if>

</table>
		
<br>	
<div>
	<input class="portlet-form-button" type="submit" value='<%= LanguageUtil.get(pageContext, "portlet.vcms.button.save") %>'>
	<input class="portlet-form-button" type="button" value='<%= LanguageUtil.get(pageContext, "portlet.vcms.button.cancel") %>' onClick="self.location = '<%= redirect %>';">
</div>	
</form>

<script type="text/javascript">
	document.<portlet:namespace />fm.<portlet:namespace />title.focus();
</script>