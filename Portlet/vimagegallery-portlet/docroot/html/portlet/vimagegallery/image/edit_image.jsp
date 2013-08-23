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

<%@page import="com.vportal.portlet.vimagegallery.util.PropsKeys"%>
<%@ include file="/html/portlet/vimagegallery/init.jsp" %>
<!------------------------- Java ----------------------------->		
<%
	PortletURL backURL = renderResponse.createRenderURL();
	backURL.setWindowState(WindowState.MAXIMIZED);
	backURL.setParameter("jspPage", "/html/portlet/vimagegallery/view.jsp");
	backURL.setParameter("tabs1", tabs1);
	
	String redirect = ParamUtil.getString(request, "redirect");	
	String imageIdTemp =ParamUtil.getString(request, "id") ;
	
	TFImage image = null;
	if(imageIdTemp.equals("")){
			image = new TFImageImpl();
	}else{
		image = TFImageServiceUtil.getImage(Long.valueOf(imageIdTemp));
	}
	
	List listCategory = TFCategoryServiceUtil.getByGroupId(groupId);
	
	List listImage = (List)request.getAttribute("listImage");	
	if(listImage == null){
		listImage = new ArrayList();	
	}
	
	String id = ((image != null && Long.toString(image.getId()) != null) ? Long.toString(image.getId()) : null);
	String categoryId = ParamUtil.getString(request, "categoryId");
	
	PortletURL formAction = renderResponse.createActionURL();
	formAction.setParameter("jspPage", "/html/portlet/vimagegallery/image/edit_image.jsp");	

%>
<portlet:actionURL name="updateImage" var="updateImageUrl"/>
<script language="javascript">
	function <portlet:namespace />submitForm(type) {
		var myform = document.<portlet:namespace />fm;
		myform.action="<%= formAction.toString() %>";
		myform.method="post";	

		var name = myform.<portlet:namespace />name;
		var image = myform.<portlet:namespace />image;
		
		if (type == 0) {
			myform.submit();
			return ;
		}
		resetField(name);		
		
		if (name.value.length<1) {
			alert("<%= LanguageUtil.get(pageContext, "VImageGallery.form.imageName") %> <%= LanguageUtil.get(pageContext, "VImageGallery.form.cannotBlank") %>");
			showErrorField(name);
			name.focus();
			return false;			
		}	
		
		if (!image.disabled) {
			if (image.value.length<1){
				alert("<%= LanguageUtil.get(pageContext, "VImageGallery.form.imageImage")%> <%= LanguageUtil.get(pageContext, "VImageGallery.form.cannotBlank")%>");
				showErrorField(image);
				image.focus();
				return false;
			}
			
			if (!/(\.(gif|jpg|jpeg|bmp|png))$/i.test(image.value)){
				alert("<%= LanguageUtil.get(pageContext, "VImageGallery.form.validateImage")%>");
				showErrorField(image);				
				image.focus();
				return false;
			}
		}
	
		submitForm(document.<portlet:namespace />fm,'<portlet:actionURL name="updateImage"></portlet:actionURL>');
				
	}
	
	function <portlet:namespace />removeImage() {
		document.<portlet:namespace />fm.<portlet:namespace /><%=Constants.CMD%>.value="remove_image";
		submitForm(document.<portlet:namespace />fm);
	}
	
	function <portlet:namespace/>backForm(){
		var myform = document.<portlet:namespace />fm;
		var image = myform.<portlet:namespace />image;
		if (!image.disabled) {
			if (image.value.length<1){
				alert("<%= LanguageUtil.get(pageContext, "VImageGallery.form.imageImage")%> <%= LanguageUtil.get(pageContext, "VImageGallery.form.cannotBlank")%>");
				showErrorField(image);
				image.focus();
				return false;
			}
			
			if (!/(\.(gif|jpg|jpeg|bmp|png))$/i.test(image.value)){
				alert("<%= LanguageUtil.get(pageContext, "VImageGallery.form.validateImage")%>");
				showErrorField(image);				
				image.focus();
				return false;
			}
		}else{
			self.location = '<%= backURL %>';
			
		}		
	}		
</script>
<!------------------------- HTML ----------------------------->		
<c:if test='<%= !id.equalsIgnoreCase("0") %>'>
	<liferay-ui:tabs names="VImageGallery.form.image.update" backURL="<%= redirect %>" />
</c:if>
<c:if test='<%= id.equalsIgnoreCase("0") %>'>
	<liferay-ui:tabs names="VImageGallery.form.image.add-new" backURL="<%= redirect %>" />
</c:if>
	
<form action="<portlet:actionURL name="updateImage">
	</portlet:actionURL>" method="post" name="<portlet:namespace />fm" enctype="multipart/form-data">
	<input name="<portlet:namespace />id" type="hidden" value="<%= (id != null) ? id : "" %>">
	<input name="<portlet:namespace />cmd" type="hidden" value="<%= Validator.isNotNull(image.getId()) ? "doupdate" : "doadd" %>">
	<input name="<portlet:namespace />redirect" type="hidden" value="<%= redirect %>">
	<input name="<portlet:namespace />groupId" type="hidden" value="<%= groupId %>">

<liferay-ui:error exception="<%= TFImageNameException.class %>">
	<liferay-ui:message key="image-names-must-end-with-one-of-the-following-extensions" /> <%= StringUtil.merge(PropsUtil.getArray(PropsKeys.IG_IMAGE_EXTENSIONS), ", ") %>.
</liferay-ui:error>
	
<liferay-ui:error exception="<%= ImageSizeException.class %>" message="please-enter-a-file-with-a-valid-file-size" />
<liferay-ui:error exception="<%= NoSuchTFCategoryException.class %>" message="please-enter-a-valid-catgory" />


<%
// String imageMaxSize = String.valueOf(PropsValues.IG_IMAGE_MAX_SIZE / 1024);
String imageMaxSize = String.valueOf(GetterUtil.getInteger(PropsUtil.get(PropsKeys.IG_IMAGE_MAX_SIZE))/1024);
redirect = "/vimagegallery/image/view_image.jsp";
%>

<c:if test="<%= !imageMaxSize.equals(\"0\") %>">
	<i><%= LanguageUtil.format(pageContext, "upload-images-no-larger-than-x-k", imageMaxSize, false) %></i>
</c:if>

<table class="lfr-table">
	<!--CategoryId -->
	<tr>
		<td><%= LanguageUtil.get(pageContext, "VImageGallery.form.categoryId") %> :</td>
		<td>	
			<select name="<portlet:namespace />categoryId" id="<portlet:namespace />categoryId" style="width:180px;">
				<%
					for(int i=0; i<listCategory.size();i++)	{
						TFCategory category = (TFCategory)listCategory.get(i);				
				%>
					<option value="<%= category.getId()%>" <%= (String.valueOf(category.getId()).equals(String.valueOf(image.getCategoryId()))  ? "selected":"") %> ><%= category.getName() %></option>
				<%								
					}
				%>	
			</select>							
		</td>		
	</tr>
	<!--Image name -->
	<tr>
		<td><%= LanguageUtil.get(pageContext, "VImageGallery.form.imageName") %> :</td>
		<td>			
			<liferay-ui:input-field model="<%= TFImage.class %>" bean="<%= image %>" field="name" />
<%-- 				<liferay-ui:input-field model="<%= TFImage.class %>" name="<portlet:namespace />name" field="name" /> --%>
			
		</td>
	</tr>
	<br>
	
	<!--Image description -->
	<tr>
		<td><%= LanguageUtil.get(pageContext, "VImageGallery.form.imageDesc") %> :</td>
		<td>
			<textarea class="lfr-textarea" name="<portlet:namespace />description" id="<portlet:namespace />description"><%= (image != null) ? image.getDescription() : "" %></textarea>			
		</td>
	</tr>
	<br>
		
	<!-- Image-->		
	<tr>
		<td><%= LanguageUtil.get(pageContext,"VImageGallery.form.image") %> :</td>		
		<td>					
			<c:if test='<%= !image.getImage().equals("")%>'>
				<p style="margin: 0px; padding: 0px; padding-bottom: 10px">
					<table cellspacing="0" cellpadding="0" width="100%" border="0">
						<tr>
							<td width="1%" valign="middle"><img src="/vimagegallery-portlet/html/portlet/vimagegallery/picture/delete.gif" /></td>
							<td width="25%" valign="middle"><a href="#removeImage" onClick="<portlet:namespace />removeImage();"><%= LanguageUtil.get(pageContext, "VImageGallery.image.remove-image") %></a></td>					
							<td width="1%" valign="middle"><img src='/vimagegallery-portlet/html/portlet/vimagegallery/picture/large-image.gif'/></td>
							<td  valign="middle"><a href="<%= themeDisplay.getPathImage() + "/vimagegallery?img_id=" + image.getImage() %>" target="_blank"><%= LanguageUtil.get(pageContext, "VImageGallery.image.fullsize-image") %></a></td>
						</tr>
					</table>
				</p>
				<img src="<%= themeDisplay.getPathImage() + "/vimagegallery?img_id=" + image.getImage() %>" border="0" width="120" height="100"/><br>
				<input type="file" class="lfr-input-text"  name="<portlet:namespace />image" disabled="true" value="<%= image.getImage() %>" />
			</c:if>
		
			<c:if test='<%= image.getImage().equals("") %>'>
				<input type="file" class="lfr-input-text"  name="<portlet:namespace />image" />
			</c:if>
				
		</td>
	</tr>
				
	<!-- isShow -->
	<tr>
		<td><%= LanguageUtil.get(pageContext, "VImageGallery.form.isShow") %> :</td>
		<td>			
			<input type="checkbox" value="1"  id="<portlet:namespace />isShow" name="<portlet:namespace />isShow" <%= ((image != null) && image.getIsShow()) ? "checked=\"checked\"" : "" %> />
		</td>
	</tr>		
	
</table>
				
	<br>	
	<input type="button" class="portlet-form-button" value="<liferay-ui:message key="save" />" onclick="<portlet:namespace />submitForm(1)" />
	<c:if test='<%= !id.equalsIgnoreCase("0") %>'>
		<input type="button" class="portlet-form-button" value="<liferay-ui:message key ="back"/>" onClick="<portlet:namespace />backForm()">
	</c:if>
	<c:if test='<%= id.equalsIgnoreCase("0") %>'>
			<input type="button" class="portlet-form-button" value="<liferay-ui:message key="cancel" />" onClick="history.back()" />
	</c:if>
</form>
<c:if test="<%= windowState.equals(WindowState.MAXIMIZED) %>">

	<script type="text/javascript">
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />name);
	</script>
	
</c:if>