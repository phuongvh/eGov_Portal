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
String cmd = ParamUtil.getString(request, "cmd");
String threadId = ParamUtil.getString(request, "threadId");
VcmsThread thread = null;
if(Validator.isNotNull(threadId)){
	thread = VcmsThreadLocalServiceUtil.getVcmsThread(threadId);
}
//(VcmsThread) request.getAttribute(WebKeysExt.VCMS_THREAD);

%>

<script type="text/javascript">
	function <portlet:namespace />saveThread() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= thread == null ? Constants.ADD : Constants.UPDATE %>";
		submitForm(document.<portlet:namespace />fm);
	}
	
	function <portlet:namespace />removeImage() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "remove_image";
		submitForm(document.<portlet:namespace />fm);
	}
</script>

<form action="<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>" name="updateThread">
</portlet:actionURL>" method="post" name="<portlet:namespace />fm" enctype="multipart/form-data">
<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="">
<input name="<portlet:namespace />redirect" type="hidden" value="<%= redirect %>">
<input name="<portlet:namespace />threadId" type="hidden" value="<%= (thread != null) ? thread.getThreadId() : "" %>">
<input name="<portlet:namespace />groupId" type="hidden" value="<%= groupId %>">

<liferay-ui:error exception="<%= InvalidThreadTitleException.class %>" message="portlet.vcms.thread.exception.please-enter-a-valid-thread-title" />

<c:if test='<%= cmd.equalsIgnoreCase("update") %>'>
	<liferay-ui:tabs names="<%= LanguageUtil.get(pageContext, \"portlet.vcms.thread.edit.update\") %>" backURL="<%= redirect %>" />
</c:if>
<c:if test='<%= !cmd.equalsIgnoreCase("update") %>'>
	<liferay-ui:tabs names="<%= LanguageUtil.get(pageContext,\"portlet.vcms.thread.edit.add-new\") %>" backURL="<%= redirect %>" />
</c:if>	
	
<div class="beta-separator"></div>
<table border="0" cellpadding="4" cellspacing="0" width="100%">
<td height="30">
	<td>
		<%= LanguageUtil.get(pageContext, "portlet.vcms.thread.edit.language") %>:
	</td>
	<td>
		<input type="hidden" name="<portlet:namespace />language" value="<%= (thread != null) ? thread.getLanguage() : language %>" />
		<select name="<portlet:namespace />language" disabled style="width: 200px">
			<%
			
			String selectedLanguage = ((thread != null) ? thread.getLanguage() : language);
			for (int i = 0; i < locales.length; i++) {
			%>
			
				<option <%= (selectedLanguage.equals(locales[i].getLanguage() + "_" + locales[i].getCountry())) ? "selected" : "" %> value="<%= locales[i].getLanguage() + "_" + locales[i].getCountry() %>"><%= locales[i].getDisplayName(locales[i]) %></option>
			
			<%
			}
			%>
		</select>
	</td>
</tr>
<td height="30">
	<td>
		<%= LanguageUtil.get(pageContext, "portlet.vcms.thread.edit.title") %>:
	</td>
	<td>
		<input type="text" style="width: 300px" maxlength="200" name="<portlet:namespace />title" value="<%= (thread != null) ? thread.getTitle() : "" %>" />
	</td>
</tr>
<td height="30">
	<td valign="top">
		<%= LanguageUtil.get(pageContext, "portlet.vcms.thread.edit.description") %>:
	</td>
	<td>
		<textarea class="form-text" style="width: 300px" maxlength="500" rows="5" name="<portlet:namespace />description"><%= (thread != null) ? thread.getDescription() : "" %></textarea>
	</td>
</tr>
<td height="30">
	<td valign="top">
		<%= LanguageUtil.get(pageContext, "portlet.vcms.thread.edit.image") %>:
	</td>
	<td>
		<c:if test="<%= (thread != null) && (thread.getHasImage()) %>">
			<p style="margin: 0px; padding: 0px; padding-bottom: 10px">
				<table cellspacing="0" cellpadding="0" width="100%" border="0">
					<tr>
						<td width="1%" valign="middle"><img src="<%= themeDisplay.getPathThemeImage() %>/vcms/delete.gif" valign="middle" /></td>
						<td width="99%" valign="middle" style="padding-left: 5px"><a href="#removeImage" onClick="<portlet:namespace />removeImage();"><%= LanguageUtil.get(pageContext, "portlet.vcms.thread.edit.remove-image") %></a></td>
					</tr>
					<tr>
						<td width="1%" valign="middle"><img src="<%= themeDisplay.getPathThemeImage() %>/vcms/large-image.gif" valign="middle" /></td>
						<td width="99%" valign="middle" style="padding-left: 5px"><a href="<%= themeDisplay.getPathImage() + "/images?img_id=" + thread.getImage() %>" target="_blank"><%= LanguageUtil.get(pageContext, "portlet.vcms.thread.edit.large-image") %></a></td>
					</tr>
				</table>
			</p>
			<img src="<%= themeDisplay.getPathImage() + "/images?img_id=" + thread.getImage() %>" border="0" width="200" />
		</c:if>
		<c:if test="<%= !((thread != null) && (thread.getHasImage())) %>">
			<input type="file" class="form-text" style="width: 300px" name="<portlet:namespace />image" />
		</c:if>
	</td>
</tr>
	
<c:if test="<%= thread == null %>">
<td height="30">
	<td valign="top">
		<liferay-ui:message key="permissions" /> : 
	</td>
	<td>
		<liferay-ui:input-permissions
			modelName="<%= VcmsThread.class.getName() %>"
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