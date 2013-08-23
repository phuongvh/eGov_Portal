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
<jsp:directive.page import="com.vportal.portlet.vclip.util.WebKeysVClip"/>
<jsp:directive.page import="com.liferay.portal.kernel.util.UnicodeFormatter"/>
<%@ include file="/html/portlet/manage_vclip/init.jsp" %>
<%	
	String redirect = ParamUtil.getString(request, "redirect");
	List attachmentList = (List)request.getAttribute(WebKeysVClip.VCLIP_LIST_ATTACHMENT);
	List imageList = (List)request.getAttribute("imageList");
	String clipId = ParamUtil.getString(request, WebKeysVClip.CLIP_ID);
	ClipType searchClipType=new ClipTypeImpl();
	//searchClipType.setLanguage(language);
	List allClipType=ClipTypeServiceUtil.findClipType(searchClipType);
	Clip clip = (Clip) request.getAttribute(WebKeysVClip.CLIP);
	if (clip == null) {
		clip = new ClipImpl();
		clip.setId("0");
	}
	if(Validator.isNotNull(clipId)){
		 clip = ClipLocalServiceUtil.getClip(clipId);
	}
	String editorContent=clip.getDescription();
	
	PortletURL formAction=renderResponse.createActionURL();
	formAction.setWindowState(WindowState.MAXIMIZED);
	formAction.setParameter("tabs1",tabs1);
	formAction.setParameter("redirect",redirect);	
%>
<script>
	function initContentEditor() {
		document.<portlet:namespace />fm.<portlet:namespace />content.value = "<%= UnicodeFormatter.toString(editorContent) %>";
		return "<%= UnicodeFormatter.toString(editorContent) %>";
	};
</script>
<script>
	function <portlet:namespace />submitForm() {
		var addContentForm = document.<portlet:namespace />fm;
		var name = addContentForm.<portlet:namespace />name;
		var url = addContentForm.<portlet:namespace />url;
		var image = addContentForm.<portlet:namespace />image;
		var title = addContentForm.<portlet:namespace />title;
		var descriptionValue = parent.<portlet:namespace />editor.getHTML();
		var select=document.<portlet:namespace />fm.<portlet:namespace /><%=WebKeysVClip.CLIP_TYPE_ID %>;		
		
		resetField(name);		
		resetField(title);		
		if (name.value.length < 1) {
			alert("<%=LanguageUtil.get(pageContext,"vportal.vclip.form.enterClipName")%>");
			showErrorField(name);
			return ;
		}	
		
		if(select.selectedIndex== -1){
			alert("<%=LanguageUtil.get(pageContext,"vportal.vclip.mustAddClipType")%>");
			showErrorField(select);
			return ;
		}		
		if(title.value.length < 1){
			alert("<%=LanguageUtil.get(pageContext,"vportal.vclip.form.enterTitle")%>");
			showErrorField(title);
			return ;
		}
		if(descriptionValue.length > 3900){		
			alert("<%=LanguageUtil.get(pageContext,"vportal.vclip.form.validSize")+" 4000"%>");
			showErrorField(editorContent);
			return ;
		}

		addContentForm.<portlet:namespace />description.value = parent.<portlet:namespace />editor.getHTML();		
		addContentForm.submit();
	}
	
	function showErrorField(field) {
		field.style.border="2px solid red";
		field.focus();
	}
	function resetField(field) {
		field.style.border="1px solid #CCC";
	}
	
	function <portlet:namespace />removeAttachment() {
		var attachment_0 = document.<portlet:namespace />fm.<portlet:namespace />file;
		var removeAttach = document.<portlet:namespace />fm.<portlet:namespace />removeAttach;
		if (removeAttach.checked) {
			attachment_0.disabled = false;
		} else {
			attachment_0.disabled = true;
		}
	}
</script>	

<form name="<portlet:namespace />fm" method="post" action="<%= formAction.toString() %>" enctype="multipart/form-data">

<vportal:tabs names="clip" backURL="<%= redirect %>" />
<fieldset>
	<div align="center">
		<strong ><%=LanguageUtil.get(pageContext,"vportal.vclip.clip.info") %></strong>
	</div>
</fieldset>

<fieldset>
<table>
	<tr>
	<td width="70%">
	  <table align="center">
		<input type="hidden" name="<portlet:namespace /><%=Constants.CMD%>"	value="<%=Constants.SAVE%>">
		<input type="hidden" name="<portlet:namespace /><%=WebKeysVClip.CLIP_ID%>" value="<%=clip.getId()%>">
		<input type="hidden" name="<portlet:namespace />language" value="<%=language%>">
		<input type="hidden" name="<portlet:namespace />redirect" value="<%=redirect%>">
		<input type="hidden" name="<portlet:namespace />type" value="clip">
						
		<tr>
			<td><%=LanguageUtil.get(pageContext,"vportal.vclip.cliptitle.name") %></td>
			<td colspan="3">
				<select name="<portlet:namespace /><%=WebKeysVClip.CLIP_TYPE_ID %>">
					<%
						for(int i=0;i<allClipType.size();i++){
							ClipType cType=(ClipType)allClipType.get(i);
					%>
					<option <%=(cType.getId().equals(clip.getClipTypeId()))?"selected":"" %> value="<%=cType.getId() %>"><%=cType.getTitle() %></option>
					<%
						}
					%>
				</select>
				<%
				if(allClipType.size()==0) {
				%>
				<input style="border:2px solid red";" class="portlet-form-button" type="button" value="<%=LanguageUtil.get(pageContext,"vportal.vclip.addClipType") %>" 
					onClick="self.location = '<portlet:renderURL windowState="<%=WindowState.MAXIMIZED.toString()%>">
							<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.EDIT%>" />	
							<portlet:param name="tabs1" value="<%=tabs1%>" />
							<portlet:param name="language" value="<%=language %>" />
							<portlet:param name="redirect" value="<%=currentURL.toString()%>" />
							
					</portlet:renderURL>';" >
				<%
				}
				%>
			</td>
		</tr>
		
		<tr>
			<td><%=LanguageUtil.get(pageContext,"vportal.vclip.clip.name") %>:</td>
			<td ><input size="64"  type="text" name="<portlet:namespace />name" value="<%=clip.getName() %>"></td>
		</tr>
		
		<tr>
			<td><%=LanguageUtil.get(pageContext,"vportal.vclip.clip.image") %>:
			<br/><br/><%=LanguageUtil.get(pageContext,"vportal.vclip.clip.url") %>:
			</td>
			<td ><!-- <input size="64" type="text" name="<portlet:namespace />url" value="<%=clip.getUrl() %>"> -->
				<input type="hidden" name="<portlet:namespace />url" value="<%=clip.getUrl() %>" />
 				<vportal:file-upload entryId="<%=GetterUtil.getLong(clipId , 0)%>" entryClass="<%=Clip.class%>" style="2" maxAttachment="2"/>						
	<%--	 <vportal:file-upload attachmentList="<%= attachmentList %>" /> 	--%>		  
			</td>
		</tr>

		<tr>
			<td valign="top"><%=LanguageUtil.get(pageContext,"vportal.vclip.cliptitle.title") %>:</td>
			<td> </td>
		</tr>
		<tr>
			<td colspan="2">
				<textarea rows="5" cols="80"  name="<portlet:namespace />title" ><%=clip.getTitle() %></textarea>
			</td>
		</tr>
	  </table>
	</td>
	<td valign="top" align="center">		
	</td>
	</tr>
	
</table>
<br />
</fieldset>

<fieldset>
<legend><%=LanguageUtil.get(pageContext,"vportal.vclip.cliptitle.description") %>:</legend>
	<div id="editorContent" style="display:block; width: 700px">
		<liferay-ui:input-editor editorImpl="editor.wysiwyg.default" width="100%" height="300" initMethod="initContentEditor" />
		<input name="<portlet:namespace />description" type="hidden" value="" />
	</div>
</fieldset>

<fieldset>
	<br>
	<div align="center">
	<input type="button" class="portlet-form-button" value="<liferay-ui:message key="save" />" onclick="<portlet:namespace />submitForm()" />		
	<input class="portlet-form-button" type="button" value="<%=LanguageUtil.get(pageContext,"vportal.vclip.cancel") %>"
		onclick="javascript:document.location='<portlet:renderURL>
		<portlet:param name="struts_action" value="/vclip/cliptype" />
		<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.CANCEL%>" />
		<portlet:param name="tabs1" value="<%=tabs1%>" />
	</portlet:renderURL>'" >
	</div>
	<br>
</fieldset>
</form>