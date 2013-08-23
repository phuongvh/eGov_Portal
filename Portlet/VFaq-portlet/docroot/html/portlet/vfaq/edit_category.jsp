
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

<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.vportal.portlet.vfaq.model.impl.FAQCategoryImpl"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ include file="/html/portlet/vfaq/init.jsp" %>
<%@ taglib uri="http://www.vietsoftware.com/tld" prefix="vportal" %>
<%
	String redirect = ParamUtil.getString(request, "redirect");
	

// 	FAQCategory category = (FAQCategory) request.getAttribute(WebKeysExt.VFAQ_CATEGORY);
// 	List listCategory = (List)request.getAttribute(WebKeysExt.VFAQ_LIST_CATEGORY);
	FAQCategory category = null;
	
// 	if(Validator.isNotNull(category)){
// 	List imageList = AttachmentServiceUtil.getAttachments(category.getId(), FAQCategory.class);;
// 	}
	
	//String categoryId = ((category != null && Long.toString(category.getId()) != null) ? Long.toString(category.getId()) : "0");
	String categoryId = ParamUtil.getString(request,"categoryId","0");
	
	if(!categoryId.equals("0") && categoryId != null){
		 category = FAQCategoryLocalServiceUtil.getCategory(Long.valueOf(categoryId));
	}	
		
	String parentId = ((category != null && Long.toString(category.getParent()) !=null) ? Long.toString(category.getParent()) : "0");

	PortletURL returnURL = renderResponse.createRenderURL();
	returnURL.setWindowState(WindowState.MAXIMIZED);
	returnURL.setParameter("jspPage", "/html/portlet/vfaq/view.jsp");
	
	PortletURL actionURL = renderResponse.createActionURL();
	actionURL.setWindowState(WindowState.MAXIMIZED);
	actionURL.setParameter("jspPage", "/html/portlet/vfaq/edit_category.jsp");
	actionURL.setParameter(Constants.CMD, Constants.ADD);
%>
<%-- <portlet:actionURL name="actionURL" var="actionURL"/> --%>
<script language="javascript">
	function <portlet:namespace />submitForm(type) {
		var addContentForm = document.<portlet:namespace />fm;
		if (type==0) {
			addContentForm.action="<%= returnURL.toString() %>";
			addContentForm.submit();
			return;
		}
		addContentForm.action="<%= actionURL.toString() %>";
		addContentForm.method="post";
		var name = addContentForm.<portlet:namespace />name;
		var description = addContentForm.<portlet:namespace />description;
		resetField(name);
		resetField(description);
		if (name.value.length < 1) {
			alert("<%= LanguageUtil.get(pageContext, "pFAQ.form.categoryName") %> <%= LanguageUtil.get(pageContext, "pFAQ.form.cannotBlank") %>");
			showErrorField(name);
			return ;
		}
		if (description.value.length < 1) {
			alert("<%= LanguageUtil.get(pageContext, "pFAQ.form.description") %> <%= LanguageUtil.get(pageContext, "pFAQ.form.cannotBlank") %>");
			showErrorField(description);
			return ;
		}
		submitForm(document.<portlet:namespace />fm, '<portlet:actionURL windowState="<%=WindowState.MAXIMIZED.toString()%>" name="updateCategory"></portlet:actionURL>');
	}
	
	function showErrorField(field) {
		field.style.border="2px solid red";
		field.focus();
	}
	function resetField(field) {
		field.style.border="1px solid #CCC";
	}
</script>
	
<c:if test='<%= !categoryId.equals("0") %>'>
	<liferay-ui:tabs names="update" backURL="<%= redirect %>" />
</c:if>
<c:if test='<%= categoryId.equals("0") %>'>
	<liferay-ui:tabs names="add" backURL="<%= redirect %>" />
</c:if>
	
<%-- <form action="<%= actionURL.toString() %>" enctype="multipart/form-data" method="post" name="<portlet:namespace />fm" >
<input name="<portlet:namespace />categoryId" type="hidden" value="<%= (Validator.isNotNull(categoryId)) ? categoryId : "" %>">
<input name="<portlet:namespace />language" type="hidden" value="vi_VN">
<input name="<portlet:namespace />redirect" type="hidden" value="<%= redirect %>"> --%>

<form action="<portlet:actionURL><portlet:param name="struts_action" value="/vfaq/category" />
	</portlet:actionURL>" method="post" name="<portlet:namespace />fm" enctype="multipart/form-data" >	
	<input name="<portlet:namespace />categoryId" type="hidden" value="<%= (Validator.isNotNull(categoryId)) ? categoryId : "" %>">
	<input name="<portlet:namespace />language" type="hidden" value="vi_VN">
	<input name="<portlet:namespace />redirect" type="hidden" value="<%= redirect %>">
	<input name="<portlet:namespace />tabs1" type="hidden" value="<%= tabs1 %>">
	<input name="<portlet:namespace />tabs2" type="hidden" value="<%= tabs2 %>">

<table width="100%">
<tr height="30">
	<td><%= LanguageUtil.get(pageContext, "pFAQ.form.categoryName") %> :</td>
	<td>
		<input type="text" class="form-text" name="<portlet:namespace />name" style="width: 400px;" value="<%= (category != null) ? category.getName() : "" %>" />
<%-- 		<liferay-ui:input-field model="<%= FAQCategory.class %>" bean="<%= category %>" field="name" /> --%>
	</td>
</tr>
	
<tr height="30">
	<td><%= LanguageUtil.get(pageContext, "pFAQ.title.description") %> :</td>
	<td>
		<textarea class="form-text" cols="23" rows="5" name="<portlet:namespace />description" style="width: 400px;"><%= (category != null) ? category.getDescription() : "" %></textarea>
	</td>
</tr>
	
<tr height="30">
	<td><%= LanguageUtil.get(pageContext, "pFAQ.form.parentCategory") %>:</td>
	<td>
		<select name="<portlet:namespace />parent" style="width: 250px;">
			<option value="0">---Ch&#7885;n danh m&#7909;c cha---</option>
			<%
				out.println(ActionUtil.getCategoryTree(groupId,language, Long.parseLong(parentId), Long.parseLong(categoryId),null));
			%>
		</select>
	</td>
</tr>
			
<tr height="30">
	<td><%= LanguageUtil.get(pageContext, "pFAQ.form.order") %>:</td>
	<td>
		<input type="text" class="form-text" name="<portlet:namespace />catOrder" style="width: 400px;" value="<%= (category != null) ? category.getCatorder() : "" %>" />
	</td>
</tr>
	
<tr height="30">
	<td><%= LanguageUtil.get(pageContext, "pFAQ.form.level") %>:</td>
	<td>
		<input type="text" class="form-text" name="<portlet:namespace />catLevel" style="width: 400px;" value="<%= (category != null) ? category.getCatlevel() : "" %>" />
	</td>
</tr>
	
<tr height="30">
	<td><%= LanguageUtil.get(pageContext, "pFAQ.form.image") %>:</td>
	<td>
		<vportal:file-upload entryId="<%= GetterUtil.getLong(categoryId,0) %>" entryClass="<%= FAQCategory.class %>" style="2" />	
	</td>
</tr>

<c:if test='<%= categoryId.equals("0") %>'>
<tr height="30">
	<td colspan="2">
			<liferay-ui:input-permissions modelName="<%= FAQCategory.class.getName() %>" />
	</td>
</tr>
</c:if>	
	
<tr>
	<td colspan="2">
		<input type="button" class="portlet-form-button" value="<%= LanguageUtil.get(pageContext, "save") %>" onclick="<portlet:namespace />submitForm(1);" />
		<input type="button" class="portlet-form-button" name="<portlet:namespace />btnBack" value="<%= LanguageUtil.get(pageContext, "cancel") %>" onclick="self.location = '<%= redirect %>';" />
	</td>
</tr>
</table>
</form>
<c:if test="<%= windowState.equals(WindowState.MAXIMIZED) %>">
	<script type="text/javascript">
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />name);
	</script>
</c:if>	