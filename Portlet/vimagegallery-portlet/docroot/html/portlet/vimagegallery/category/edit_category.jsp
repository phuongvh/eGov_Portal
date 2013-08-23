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
<%@include file="/html/portlet/vimagegallery/init.jsp"%>
<!------------------------- Java ----------------------------->
<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.MAXIMIZED);
	portletURL.setParameter("jspPage", "/html/portlet/vimagegallery/view.jsp");
	portletURL.setParameter("tabs1", tabs1);
	String redirect = ParamUtil.getString(request, "redirect");
	List listCategory = new ArrayList();

	listCategory = TFCategoryServiceUtil.getByGroupId(groupId);
	String categoryIdTemp = ParamUtil.getString(request, "categoryId");
	long categoryId = 0;
	if (categoryIdTemp.length() > 0) {
		categoryId = Long.parseLong(categoryIdTemp);
	}
	TFCategory category = new TFCategoryImpl();
	if (categoryId > 0)
		category = TFCategoryServiceUtil.getCategory(categoryId);
	// 	TFCategory category = (TFCategory) request.getAttribute("category");
	if (category == null) {
		category = new TFCategoryImpl();
	}
	String id = ((category != null && Long.toString(category.getId()) != null)
			? Long.toString(category.getId())
			: null);
	PortletURL formAction = renderResponse.createActionURL();
	formAction.setParameter("jspPage",
			"/html/portlet/vimagegallery/category/edit_category.jsp");
%>
<!------------------------- Javascript ----------------------------->
<script language="javascript">
	function <portlet:namespace />submitForm(type) {
		var myform = document.<portlet:namespace />fm;
		myform.action="<%=formAction.toString()%>";
		myform.method="post";
		
		var name = myform.<portlet:namespace />name;
		var image = myform.<portlet:namespace />image;	
		
		if (type == 0) {
			myform.submit();
			return ;
		}
		resetField(name);

		
		if (name.value.length<1) {
			alert("<%=LanguageUtil.get(pageContext,
					"VImageGallery.form.categoryName")%> <%=LanguageUtil.get(pageContext,
					"VImageGallery.form.cannotBlank")%>");
			showErrorField(name);
			name.focus();
			return false;			
		}	
		
		if (!image.disabled) {
			if (image.value.length<1){
				alert("<%=LanguageUtil.get(pageContext,
					"VImageGallery.form.categoryIntro")%> <%=LanguageUtil.get(pageContext,
					"VImageGallery.form.cannotBlank")%>");
				showErrorField(image);
				image.focus();
				return false;
			}
		
			if (!/(\.(gif|jpg|jpeg|bmp|png))$/i.test(image.value)){
				alert("<%=LanguageUtil.get(pageContext,
					"VImageGallery.form.validateImage")%>");
				showErrorField(image);			
				image.focus();
				return false;
				}
		}
		/* myform.submit(); */
		submitForm(document.<portlet:namespace />fm,'<portlet:actionURL name="updateCategory"></portlet:actionURL>');
	}
	
	function <portlet:namespace />removeImage() {
		document.<portlet:namespace />fm.<portlet:namespace /><%=Constants.CMD%>.value = "remove_image";
		submitForm(document.<portlet:namespace />fm);
	}
	
	function <portlet:namespace/>backForm(){
		var myform = document.<portlet:namespace />fm;
		var image = myform.<portlet:namespace />image;
		if (!image.disabled) {
			if (image.value.length<1){
				alert("<%=LanguageUtil.get(pageContext,
					"VImageGallery.form.imageImage")%> <%=LanguageUtil.get(pageContext,
					"VImageGallery.form.cannotBlank")%>");
				showErrorField(image);
				image.focus();
				return false;
			}			
			if (!/(\.(gif|jpg|jpeg|bmp|png))$/i.test(image.value)){
				alert("<%=LanguageUtil.get(pageContext,
					"VImageGallery.form.validateImage")%>");
				showErrorField(image);	
				image.focus();
				return false;
			}
		}else{
			self.location = '<%=portletURL%>';
		}		
	}
</script>

<!------------------------- HTML ----------------------------->
<form
	action="<portlet:actionURL name="updateCategory"></portlet:actionURL>"
	method="post" name="<portlet:namespace />fm"
	enctype="multipart/form-data">

	<input name="<portlet:namespace />groupId" type="hidden"
		value="<%=groupId%>"> <input name="<portlet:namespace />id"
		type="hidden" value="<%=(id != null) ? id : ""%>"> <input
		name="<portlet:namespace />cmd" type="hidden"
		value="<%=Validator.isNotNull(category.getId())
					? "doupdate"
					: "doadd"%>">
	<input name="<portlet:namespace />redirect" type="hidden"
		value="<%=redirect%>" />

	<c:if test='<%=!id.equalsIgnoreCase("0")%>'>
		<liferay-ui:tabs names="VImageGallery.form.category.update"
			backURL="<%=redirect%>" />
	</c:if>
	<c:if test='<%=id.equalsIgnoreCase("0")%>'>
		<liferay-ui:tabs names="VImageGallery.form.category.add-new"
			backURL="<%=redirect%>" />
	</c:if>

	<liferay-ui:error exception="<%=TFCategoryNameException.class%>">
		<liferay-ui:message
			key="image-names-must-end-with-one-of-the-following-extensions" />


		<%=StringUtil.merge(
						PropsUtil.getArray(PropsKeys.IG_IMAGE_EXTENSIONS), ", ")%>.
</liferay-ui:error>

	<liferay-ui:error exception="<%=ImageSizeException.class%>"
		message="please-enter-a-file-with-a-valid-file-size" />
	<liferay-ui:error exception="<%=NoSuchTFCategoryException.class%>"
		message="please-enter-a-valid-catgory" />


	<table class="lfr-table">
		<!-- Name -->
		<tr>
			<td><%=LanguageUtil.get(pageContext,
					"VImageGallery.form.categoryName")%> :</td>
			<td><liferay-ui:input-field model="<%=TFCategory.class%>"
					bean="<%=category%>" field="name" /></td>
		</tr>
		<!-- Description -->
		<tr>
			<td><%=LanguageUtil.get(pageContext,
					"VImageGallery.form.categoryDesc")%> :</td>
			<td><textarea name="<portlet:namespace />description"
					id="<portlet:namespace />description" class="lfr-textarea"><%=(category != null) ? category.getDescription() : ""%></textarea>
			</td>
		</tr>
		<!-- Image introdution  -->
		<tr>
			<td><%=LanguageUtil.get(pageContext,
					"VImageGallery.form.categoryIntro")%> :</td>
			<td><c:if test="<%=!category.getImage().equals(\"\")%>">
					<p style="margin: 0px; padding: 0px; padding-bottom: 10px">
					<table cellspacing="0" cellpadding="0" width="100%" border="0">
						<tr>
							<td width="1%" valign="middle"><img
								src="/vimagegallery/html/portlet/vimagegallery/picture/delete.gif"
								valign="middle" /></td>
							<td width="25%" valign="middle"><a href="#removeImage"
								onClick="<portlet:namespace />removeImage();"><%=LanguageUtil.get(pageContext,
						"VImageGallery.image.remove-image")%></a></td>
							<td width="1%" valign="middle"><img
								src="/vimagegallery/html/portlet/vimagegallery/picture/large-image.gif"
								valign="middle" /></td>
							<td valign="middle"><a
								href="<%=themeDisplay.getPathImage()
						+ "/vimagegallery?img_id=" + category.getImage()%>"
								target="_blank"><%=LanguageUtil.get(pageContext,
						"VImageGallery.image.fullsize-image")%></a></td>
						</tr>
					</table>
					</p>
					<img
						src="<%=themeDisplay.getPathImage()
						+ "/vimagegallery?img_id=" + category.getImage()%>"
						border="0" width="120" height="100" />
					<br>
					<input type="file" class="lfr-input-text"
						name="<portlet:namespace />image" disabled="false"
						value="<%=category.getImage()%>" />
				</c:if> <c:if test="<%=category.getImage().equals(\"\")%>">
					<input type="file" class="lfr-input-text"
						name="<portlet:namespace />image" />
				</c:if></td>
		</tr>

			<tr height="30">
				<td><liferay-ui:message key="permissions" />:</td>
				<td><liferay-ui:input-permissions
						modelName="<%=TFCategory.class.getName()%>" /></td>
			</tr>

	</table>
	<br /> <input type="button" class="portlet-form-button" name="Save"
		value="<liferay-ui:message key="save" />"
		onclick="<portlet:namespace />submitForm(1)" /> <input type="button"
		class="portlet-form-button"
		value="<liferay-ui:message key="cancel" />"
		onClick="<portlet:namespace />backForm()" />

	<%-- <c:if test="<%=!id.equalsIgnoreCase(\"0\")%>">
		<input type="button" class="portlet-form-button"
			value="<liferay-ui:message key ="back"/>"
			onclick="history.back()">
	</c:if> --%>
	<c:if test="<%=id.equalsIgnoreCase(\"0\")%>">

	</c:if>


</form>
<c:if test="<%=windowState.equals(WindowState.MAXIMIZED)%>">
	<script type="text/javascript">
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />name);
	</script>
</c:if>
