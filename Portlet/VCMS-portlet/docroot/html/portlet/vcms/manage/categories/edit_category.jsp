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
VcmsCategory category = null;
String categoryIdTemp = ParamUtil.getString(request, "categoryId");
if(categoryIdTemp != "")
	category = VcmsCategoryServiceUtil.getCategory(categoryIdTemp);

String categoryId = ((category != null) ? category.getCategoryId() : null);
String parentId2 = ((category != null) ? category.getPortionId()+"|"+category.getParentId() : null);
String fromPortionId = ParamUtil.getString(request,"fromPortionId");
String fromCategoryId = ParamUtil.getString(request,"fromCategoryId");

VcmsPortion portionForCat = null ;
VcmsCategory categoryForCat = null;

if(Validator.isNotNull(fromPortionId)){
	portionForCat = VcmsPortionServiceUtil.getPortion(fromPortionId);
}

if(Validator.isNotNull(fromCategoryId)){
	categoryForCat = VcmsCategoryServiceUtil.getCategory(fromCategoryId);
}

	PortletURL portletURL = renderResponse.createRenderURL();
	
	portletURL.setWindowState(WindowState.MAXIMIZED);
	
	portletURL.setParameter("jspPage", "/html/portlet/vcms/view");
	portletURL.setParameter("tabs1", "portlet.vcms.tabs.category");
	portletURL.setParameter("language", language);
	portletURL.setParameter("groupId", String.valueOf(groupId));
	portletURL.setParameter("portionId", portionId);
	portletURL.setParameter("parentId", parentId);
	
	PortletURL updateCategoryURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.MAXIMIZED);
	portletURL.setParameter("language", language);
	portletURL.setParameter("groupId", String.valueOf(groupId));
	portletURL.setParameter("portionId", portionId);
	portletURL.setParameter("parentId", parentId);
	portletURL.setParameter("action", "updateCategory");
%>
<script type="text/javascript">
		
	function <portlet:namespace />saveCategory() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= category == null ? Constants.ADD : Constants.UPDATE %>";
		submitForm(document.<portlet:namespace />fm);
	}
	
	function <portlet:namespace />removeImage() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "remove_image";
		submitForm(document.<portlet:namespace />fm,'<portlet:actionURL name="removeImage" windowState="<%= WindowState.MAXIMIZED.toString() %>" ></portlet:actionURL>');
	}
	
	function <portlet:namespace />changeHrefStatus() {
		if (<%= Validator.isNotNull(categoryId) && category.getRssable() %>) {
			return;
		}
		
		var rssable = document.<portlet:namespace />fm.<portlet:namespace />rssable;
		var href = document.<portlet:namespace />fm.<portlet:namespace />href;
		var anchored = document.<portlet:namespace />fm.<portlet:namespace />anchored;
		
		anchored.disabled = rssable.checked;
		href.disabled = (rssable.checked || !anchored.checked);
		
		if (!href.disabled) {
			href.focus();
			flag = "";
		}
	}
	
	function <portlet:namespace />changeRssableStatus() {
		
		if (<%= Validator.isNotNull(categoryId) %>) {
			return;
		}
		
		var rssable = document.<portlet:namespace />fm.<portlet:namespace />rssable;
		var href = document.<portlet:namespace />fm.<portlet:namespace />href;
		var anchored = document.<portlet:namespace />fm.<portlet:namespace />anchored;
		
		rssable.disabled = anchored.checked;
		href.disabled = !anchored.checked;
	}
	
	
</script>
<form action="<portlet:actionURL></portlet:actionURL>" method="post" name="<portlet:namespace />fm"  enctype="multipart/form-data">
<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="">
<input name="<portlet:namespace />categoryId" type="hidden" value="<%= (categoryId != null) ? categoryId : "" %>">
<input name="<portlet:namespace />groupId" type="hidden" value="<%= groupId %>">

<liferay-ui:error exception="<%= InvalidCategoryNameException.class %>" message="portlet.vcms.category.exception.please-enter-a-valid-category-name" />
<liferay-ui:error exception="<%= InvalidCategoryHrefException.class %>" message="portlet.vcms.category.exception.please-enter-a-valid-category-href" />
<liferay-ui:error exception="<%= InvalidCategoryPortionException.class %>" message="portlet.vcms.category.exception.please-select-a-valid-parent-category" />

<table border="0" cellpadding="4" cellspacing="0" width="100%">
	<tr>
		<td  style="font-size: small">
			<b>
			<c:if test="<%= categoryId != null %>"><%= LanguageUtil.get(pageContext, "portlet.vcms.category.edit.update") %></c:if>
			<c:if test="<%= categoryId == null %>"><%= LanguageUtil.get(pageContext, "portlet.vcms.category.edit.add-new") %></c:if>
			</b>
		</td>
	</tr>
</table>
<br><div class="beta-separator"></div><br>
<table border="0" cellpadding="4" cellspacing="0" width="100%">
	<tr>
		<td width="30%"  class="tdHeightDefault">
			<%= LanguageUtil.get(pageContext, "portlet.vcms.category.edit.language") %>:
		</td>
		<td width="70%"  class="tdHeightDefault">
			<input type="hidden" name="<portlet:namespace />language" value="<%= (category != null) ? category.getLanguage() : language %>" />
			<select name="<portlet:namespace />language" disabled style="width: 200px">
				<%
				
				String selectedLanguage = ((category != null) ? category.getLanguage() : language);
				for (int i = 0; i < locales.length; i++) {
				%>
				
					<option <%= (selectedLanguage.equals(locales[i].getLanguage() + "_" + locales[i].getCountry())) ? "selected" : "" %> value="<%= locales[i].getLanguage() + "_" + locales[i].getCountry() %>"><%= locales[i].getDisplayName(locales[i]) %></option>
				
				<%
				}
				%>
			</select>
		</td>
	</tr>
	<c:if test="<%=Validator.isNull(fromPortionId) && Validator.isNull(fromCategoryId) %>">
		<tr>
			<td width="30%"  class="tdHeightDefault">
				<%= LanguageUtil.get(pageContext, "portlet.vcms.category.edit.parent-category") %>:
			</td>
			<td width="70%"  class="tdHeightDefault">
				<select name="<portlet:namespace />parentId" style="width: 200px">
					<%
						// Print out categories tree
						out.println(ActionUtil.getCategoryTree(groupId, language, parentId2, categoryId,permissionChecker));
					%>
				</select>
			</td>
		</tr>
	</c:if>
	<c:if test="<%=Validator.isNotNull(fromPortionId)%>">
		<tr>
			<td width="30%"  class="tdHeightDefault">
				Khu v&#7921;c bài vi&#7871;t : 
			</td>
			<td width="70%"  class="tdHeightDefault">
				<b><%=portionForCat.getName()%></b>
				<input name="<portlet:namespace />parentId" type="hidden" value="<%= fromPortionId %>|0">
			</td>
		</tr>
	</c:if>
	<c:if test="<%=Validator.isNotNull(fromCategoryId)%>">
		<tr>
			<td width="30%"  class="tdHeightDefault">
				Chuyên m&#7909;c m&#7913;c cha : 
			</td>
			<td width="70%"  class="tdHeightDefault">
				<b><%=categoryForCat.getName()%></b>
				<input name="<portlet:namespace />parentId" type="hidden" value="<%=categoryForCat.getPortionId()%>|<%= fromCategoryId %>">
			</td>
		</tr>
	</c:if>
	<tr>
		<td width="30%"  class="tdHeightDefault">
			<%= LanguageUtil.get(pageContext, "portlet.vcms.category.edit.name") %>:
		</td>
		<td width="70%"  class="tdHeightDefault">
			<input class="form-text" style="width: 300px" maxlength="200" name="<portlet:namespace />name" value="<%= (category != null) ? category.getName() : "" %>" />
		</td>
	</tr>
	<tr>
		<td width="30%"  valign="top" class="tdHeightDefault">
			<%= LanguageUtil.get(pageContext, "portlet.vcms.category.edit.description") %>:
		</td>
		<td width="70%"  class="tdHeightDefault">
			<textarea class="form-text" style="width: 300px" maxlength="500" rows="5" name="<portlet:namespace />description"><%= (category != null) ? category.getDescription() : "" %></textarea>
		</td>
	</tr>
	<tr>
		<td width="30%"  class="tdHeightDefault">
			<%= LanguageUtil.get(pageContext, "portlet.vcms.category.edit.anchored") %>
		</td>
		<td width="70%"  class="tdHeightDefault">
			<input type="checkbox" value="1" <%= Validator.isNotNull(categoryId) ? "disabled" : "" %> id="<portlet:namespace />anchored" name="<portlet:namespace />anchored" <%= ((category != null) && category.getAnchored()) ? "checked" : "" %> onClick="javascript:<portlet:namespace />changeHrefStatus();" />
		</td>
	</tr>
	<tr>
		<td width="30%"  class="tdHeightDefault">
			<%= LanguageUtil.get(pageContext, "portlet.vcms.category.edit.href") %>:
		</td>
		<td width="70%"  class="tdHeightDefault">
			<input class="form-text" style="width: 300px" maxlength="100" <%= Validator.isNotNull(categoryId) ? "disabled" : "" %> id="<portlet:namespace />href" name="<portlet:namespace />href" value="<%= (category != null) ? category.getHref() : "" %>" />
		</td>
	</tr>
	<tr>
		<td width="30%"  class="tdHeightDefault">
			<%= LanguageUtil.get(pageContext, "portlet.vcms.category.edit.rssable") %>
		</td>
		<td width="70%"  class="tdHeightDefault">
			<input type="checkbox" value="1" id="<portlet:namespace />rssable" name="<portlet:namespace />rssable" <%= ((category != null) && category.getRssable()) ? "checked" : "" %> onClick="javascript: <portlet:namespace />changeRssableStatus();" />
		</td>
	</tr>
	<tr>
		<td width="30%"  valign="top" class="tdHeightDefault">
			<%= LanguageUtil.get(pageContext, "portlet.vcms.category.edit.image") %>:
		</td>
		<td width="70%"  class="tdHeightDefault">
			<c:if test="<%= (category != null) && (category.getHasImage()) %>">
				<p style="margin: 0px; padding: 0px; padding-bottom: 10px">
					<table cellspacing="0" cellpadding="0" width="100%" border="0">
						<tr>
							<td width="1%" valign="middle" class="tdHeightDefault"><img src="<%= themeDisplay.getPathThemeImage() %>/vcms/delete.gif" valign="middle" /></td>
							<td width="99%" valign="middle" class="tdHeightDefault" style="padding-left: 5px"><a href="#removeImage" onClick="<portlet:namespace />removeImage();"><%= LanguageUtil.get(pageContext, "portlet.vcms.category.edit.remove-image") %></a></td>
						</tr>
						<tr>
							<td width="1%" valign="middle" class="tdHeightDefault"><img src="<%= themeDisplay.getPathThemeImage() %>/vcms/large-image.gif" valign="middle" /></td>
							<td width="99%" valign="middle" class="tdHeightDefault" style="padding-left: 5px"><a href="<%= themeDisplay.getPathImage() + "/images?img_id=" + category.getImage() %>" target="_blank"><%= LanguageUtil.get(pageContext, "portlet.vcms.category.edit.fullsize-image") %></a></td>
						</tr>
					</table>
				</p>
				<img src="<%= themeDisplay.getPathImage() + "/images?img_id=" + category.getImage() %>" border="0" width="200" />
			</c:if>
			<c:if test="<%= !((category != null) && (category.getHasImage())) %>">
				<input type="file" class="form-text" width="300" style="width:300px" name="<portlet:namespace />image" />
			</c:if>
		</td>
	</tr>
	
	<c:if test="<%= category == null %>">
		<tr>
			<td colspan="2">
				<br />
			</td>
		</tr>
		<tr>
			<td width="30%"  valign="top" class="tdHeightDefault">
				<liferay-ui:message key="permissions"  /> : 
			</td>
			<td width="70%"  class="tdHeightDefault">
				<liferay-ui:input-permissions
					modelName="<%= VcmsCategory.class.getName() %>"
				/>
			</td>
		</tr>
	</c:if>
	<tr>
		<td width="100%" colspan="2" align="center" class="tdHeightDefault">
			<input class="portlet-form-button" type="button" value='<%= LanguageUtil.get(pageContext, "save") %>' onClick="<portlet:namespace />submitForm()">
			
			<input class="portlet-form-button" type="button" value='<%= LanguageUtil.get(pageContext, "cancel") %>' onClick="self.location = '<%= redirect %>';">
		</td>
	</tr>
</table>

<br>

</form>

<script type="text/javascript">
	var lengthSelect = document.<portlet:namespace />fm.<portlet:namespace />parentId.length;
	for(var i=0;i<lengthSelect;i++){
		var catValue = document.<portlet:namespace />fm.<portlet:namespace />parentId.options[i].value;
		var catValueSplit = catValue.split("|");
		var namePortion = document.<portlet:namespace />fm.<portlet:namespace />parentId.options[i].text;
		var valuePortion = document.<portlet:namespace />fm.<portlet:namespace />parentId.options[i].value;
		
		if(catValueSplit[0] == "<%=portionId%>"){
			document.<portlet:namespace />fm.<portlet:namespace />parentId.options[i] = new Option(namePortion,valuePortion,true,true);
			break;
		}
	}
	
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

	document.<portlet:namespace />fm.<portlet:namespace />name.focus();
	<portlet:namespace />changeHrefStatus();
	<portlet:namespace />changeRssableStatus();
	
function <portlet:namespace />submitForm(){
	
	
		
		var name = document.<portlet:namespace />fm.<portlet:namespace />name;		
		var href = document.<portlet:namespace />fm.<portlet:namespace />href;					
		var anchored = document.<portlet:namespace />fm.<portlet:namespace />anchored;
		
		if(name.value==""){
			alert("<%=LanguageUtil.get(pageContext,"vportal.portlet.vcms.addName")%>");
			showErrorField(name);			
			return false;
		}
		
		if (document.getElementById("<portlet:namespace />anchored").checked){			
			if(href.value == ""){				
				alert("<%=LanguageUtil.get(pageContext,"vportal.portlet.vcms.addHref")%>");
				showErrorField(href);			
				return false;
			}
		 }		
		submitForm(document.<portlet:namespace />fm, '<portlet:actionURL windowState="<%=WindowState.MAXIMIZED.toString()%>" name="updateCategory"></portlet:actionURL>');		
		
	}
</script>
