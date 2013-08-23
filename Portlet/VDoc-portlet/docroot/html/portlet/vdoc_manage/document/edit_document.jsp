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
<%@ include file="/html/portlet/vdoc_manage/init.jsp" %>
<portlet:defineObjects />
<liferay-theme:defineObjects/>

<%
	String docId = ""; 
	docId = request.getParameter("docId");
	vdocDocument doc = new vdocDocumentImpl();
	String base = StringPool.BLANK;
	String content = StringPool.BLANK;
	String process = StringPool.BLANK;
	String note = StringPool.BLANK;
	String fieldId = StringPool.BLANK;
	
	if((docId != null) && (docId.trim().length() > 0)){
		doc = vdocDocumentServiceUtil.getDocument(docId);
		content = doc.getContent();
		base = doc.getBase();
		process = doc.getProcess();
		note = doc.getNote();
		fieldId = doc.getFieldId();
	}
		
	List<vdocDORel> selectedOrg = vdocDORelServiceUtil.getRelByDoc(docId);
	String[] arrayOrg = null;
	String orgId = "";
	
	if(Validator.isNotNull(selectedOrg) && selectedOrg.size() > 0){
		for(int i = 0; i < selectedOrg.size(); i++){
			vdocDORel DO = (vdocDORel)selectedOrg.get(i);
			orgId += DO.getOrgId() + (i < selectedOrg.size() - 1 ? "," : "");
		}
	}
	arrayOrg = StringUtil.split(orgId, StringPool.COMMA);
	
	String currentURL = request.getParameter("currentURL");
	
%>
<portlet:actionURL var="updateDocumentURL" name="updateDocument"/>

<script>	
	
	function saveDocument(url){
		document.<portlet:namespace />fm.<portlet:namespace />process.value = parent.<portlet:namespace />art_process.getHTML();
		document.<portlet:namespace />fm.<portlet:namespace />content.value = parent.<portlet:namespace />art_content.getHTML();
		document.<portlet:namespace />fm.<portlet:namespace />base.value = parent.<portlet:namespace />art_base.getHTML();
		document.<portlet:namespace />fm.<portlet:namespace />note.value = parent.<portlet:namespace />art_note.getHTML();
		submitForm(document.<portlet:namespace />fm);
	};
	
	function <portlet:namespace />save_approveDoc() {	
		document.<portlet:namespace />fm.<portlet:namespace />saveAndApprove.value = 'save-approve';
		submitForm(document.<portlet:namespace />fm);
	};
	
	function <portlet:namespace />save_publishDoc() {		
	
		document.<portlet:namespace />fm.<portlet:namespace />saveAndPublish.value = 'save-publish';
		submitForm(document.<portlet:namespace />fm);
	};
	
	function <portlet:namespace />initContentEditor() {
		
		document.<portlet:namespace />fm.<portlet:namespace />content.value = "<%= UnicodeFormatter.toString(content) %>";
		return "<%= UnicodeFormatter.toString(content) %>";
	};
	
	function <portlet:namespace />initBaseEditor() {
	
		document.<portlet:namespace />fm.<portlet:namespace />base.value = "<%= UnicodeFormatter.toString(base) %>";
		return "<%= UnicodeFormatter.toString(base) %>";
	};
	
	function <portlet:namespace />initProcessEditor() {
	
		document.<portlet:namespace />fm.<portlet:namespace />process.value = "<%= UnicodeFormatter.toString(process) %>";
		return "<%= UnicodeFormatter.toString(process) %>";
	};
	
	function <portlet:namespace />initNoteEditor() {

		document.<portlet:namespace />fm.<portlet:namespace />note.value = "<%= UnicodeFormatter.toString(note) %>";
		return "<%= UnicodeFormatter.toString(note) %>";
	};
	
	function <portlet:namespace/>hide(choice){
		if(choice == 1){
			jQuery("#<portlet:namespace/>note").slideUp('fast');
		}else if(choice == 2){
			jQuery("#<portlet:namespace/>note").slideDown('fast');
		}
	}
</script>
<portlet:renderURL var="backURL">
	<portlet:param name="jspPage" value="<%= currentURL %>"></portlet:param>
</portlet:renderURL>

<liferay-ui:tabs names='<%= LanguageUtil.get(pageContext,((docId != null) && (docId.trim().length() > 0)) ? "portlet.vdoc.document.edit-edit.doc.tab" : "portlet.vdoc.document.edit-add.doc.tab") %>' backURL="<%= backURL.toString() %>"/>
<br/>

<form action="<%= updateDocumentURL.toString() %>" name="<portlet:namespace />fm" method="post" 
		 enctype="multipart/form-data" >
	<input type="hidden" name="docId" value="<%= (docId != null) ? docId : "" %>" />	 
	<input name="<portlet:namespace />saveAndApprove" type="hidden" value="">
	<input name="<portlet:namespace />saveAndPublish" type="hidden" value="">	
	
	<table width="100%" cellspacing="0" cellpadding="0" border="0">
		<tr>
			<td width="70%">
				<table width="100%" cellspacing="0" cellpadding="0" border="0">
					<tr height="30">
						<td><b><%= LanguageUtil.get(pageContext, "portlet.vdoc.document.edit-doc.language") %></b></td>
						<td>
							<select name="language" style="width: 200px">
							   
							<%
								String selectedLanguage = ((doc != null) ? doc.getLanguage() : "vi_VN");
								for(int i = 0; i < locales.length; i++){
							%>
								<option <%= (selectedLanguage.equals(locales[i].getLanguage() + "_" + locales[i].getCountry())) ? "selected" : "" %> value="<%= locales[i].getLanguage() + "_" + locales[i].getCountry() %>"><%= locales[i].getDisplayName(locales[i]) %></option>
							<%} %>
							</select>
						</td>
					</tr>
					<tr height="30">
						<td valign="top"><b><%= LanguageUtil.get(pageContext, "portlet.vdoc.document.edit-doc.title") %></b></td>
						<td style="padding-bottom: 10px">
							<textarea name="title" style="width: 400px;"><%= (doc!=null) ? doc.getTitle() : "" %></textarea>
						</td>
					</tr>
					
					<tr height="30">
						<td valign="top"><b><%= LanguageUtil.get(pageContext, "portlet.vdoc.document.edit-doc.process") %></b></td>
						<td style="padding-bottom: 10px">
						<div id="process"> 
    								<liferay-ui:input-editor name="art_process"  initMethod="initProcessEditor" width="1000" />
    								<input name="<portlet:namespace />process" type="hidden" value=""/>
						</div>	
						</td>
					</tr>
					
					<tr height="30">
						<td valign="top"><b><%= LanguageUtil.get(pageContext, "portlet.vdoc.document.edit-doc.style") %></b></td>
						<td style="padding-bottom: 10px">
							<textarea name="style" style="width: 400px;"><%= (doc!=null) ? doc.getStyle() : "" %></textarea>
						</td>
					</tr>
				</table>
			</td>
			<td valign="top" style="padding-left:10px;">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">	
					<tr height="30">
						<td><b><%= LanguageUtil.get(pageContext, "portlet.vdoc.document.edit-doc.select-fields") %></b></td>
						<td>
							<select name="fieldId" style="width:200px;">
								<option value="0">---<liferay-ui:message key="select" />---</option>
								<%			
									out.println(ActionUtil.getFieldTree(groupId,language,fieldId,fieldId));
								%>
							</select>	
						</td>
						<td></td>
					</tr>	
					<tr>
						<td valign="top"><b><%= LanguageUtil.get(pageContext, "portlet.vdoc.document.edit-doc.select-org") %></b></td>
						<td >
							<select name="orgId" multiple style="width: 200px;height: 250px">
							<%
								out.println(ActionUtil.getOrgTree(groupId,language,parentId2,"",arrayOrg));
							%>
							</select>
						</td>
						<td></td>
					</tr>
				</table>
			</td>
			<td></td>
		</tr>
	</table>
	
	<!-- Thanh phan so luong ho so -->
	<div style="font-size:14px;padding-bottom:5px;font-weight:bold;"><%= LanguageUtil.get(pageContext, "portlet.vdoc.document.edit-doc.content") %></div>

							
		<div id="content"> 
    		<liferay-ui:input-editor name="art_content" initMethod="initContentEditor" width="1000" />			
			<input id="idcontent" name="<portlet:namespace />content" type="hidden" value="" />
		</div>

	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr height="30">
			<td valign="top" ><b><%= LanguageUtil.get(pageContext, "portlet.vdoc.document.edit-doc.time") %></b></td>
			<td style="padding-bottom: 10px">
				<textarea name="time" style="width: 400px;"><%= (doc!=null) ? doc.getTime() : "" %></textarea>
			</td>
		</tr>
		<tr height="30">
			<td valign="top" ><b><%= LanguageUtil.get(pageContext, "portlet.vdoc.document.edit-doc.objects") %></b></td>
			<td style="padding-bottom: 10px">
				<textarea name="objects" style="width: 400px;"><%= (doc!=null) ? doc.getObjects() : "" %></textarea>
			</td>
		</tr>
		<tr height="30">
			<td valign="top" ><b><%= LanguageUtil.get(pageContext, "portlet.vdoc.document.edit-doc.result") %></b></td>
			<td style="padding-bottom: 10px">
				<textarea name="result" style="width: 400px;"><%= (doc!=null) ? doc.getResult() : "" %></textarea>
			</td>
		</tr>
		<tr height="30">
			<td valign="top" ><b><%= LanguageUtil.get(pageContext, "portlet.vdoc.document.edit-doc.cost") %></b></td>
			<td style="padding-bottom: 10px">
				<textarea name="cost" style="width: 400px;"><%= (doc!=null) ? doc.getCost() : "" %></textarea>
			</td>
		</tr>
		<tr height="30">
			<td valign="top"><b><%= LanguageUtil.get(pageContext, "portlet.vdoc.document.edit-doc.require") %></b></td>
			<td style="padding-bottom: 10px">
				<textarea name="require" style="width: 400px;"><%= (doc!=null) ? doc.getRequire() : "" %></textarea>
			</td>
		</tr>
		<tr height="30">
			<td valign="top" ><b><%= LanguageUtil.get(pageContext, "portlet.vdoc.document.edit-doc.base") %></b></td>
			<td style="padding-bottom: 10px">
				<div id="base"> 
	    			<liferay-ui:input-editor name="art_base" initMethod="initBaseEditor" width="1000" />			
					<input name="<portlet:namespace />base" type="hidden" value=""/>
				</div>
			</td>
		</tr>
		<tr height="30">
			<td valign="top" ><b><%= LanguageUtil.get(pageContext, "portlet.vdoc.document.edit-doc.note") %></b></td>
			<td style="padding-bottom: 10px">
				<div id="base"> 
	    			<liferay-ui:input-editor name="art_note" initMethod="initNoteEditor" width="1000" />			
					<input name="<portlet:namespace />note" type="hidden" value=""/>
				</div>
			</td>
		</tr>
		<c:if test="<%= doc.getDocId().trim().length() == 0 %>">
		<tr height="30">
			<td><b><%= LanguageUtil.get(pageContext, "portlet.vdoc.document.edit-doc.permissions") %></b></td>
			<td>
				<liferay-ui:input-permissions modelName="<%=vdocDocument.class.getName() %>"/>
			</td>
		</tr>
		</c:if>
	</table>
	
	<br/>
		<div><liferay-ui:message key="portlet.vdoc.document.edit-doc.attachment" />	
			<vportal:file-upload entryId="<%= GetterUtil.getLong(doc.getDocId(), 0) %>" entryClass="<%= vdocDocument.class %>" maxAttachment="<%=maxAttachmentDocument%>" style="2"/>
		</div>
	<br/>
</form>

<div align="center">	
	<input type="button" value='<%= LanguageUtil.get(pageContext, "portlet.vdoc.document.edit-doc.save") %>' onClick="saveDocument('<portlet:namespace />');">
	<c:if test="<%=doc.getStatusDoc()!=1%>">
	<input type="button" value='<%= LanguageUtil.get(pageContext, "portlet.vdoc.document.edit-doc.save-approve") %>' onClick="javascript:<portlet:namespace />save_approveDoc();">
	</c:if>
	<input type="button" value='<%= LanguageUtil.get(pageContext, "portlet.vdoc.document.edit-doc.save-publish") %>' onClick="javascript:<portlet:namespace />save_publishDoc();">	
	<input type="button" value='<%= LanguageUtil.get(pageContext, "portlet.vdoc.cancel-button") %>' onclick="history.back()" />
</div>

<%!
	
	public static final String EDITOR_WYSIWYG_IMPL_KEY = "editor.wysiwyg.portal-web.docroot.html.portlet.journal.edit_article_content.jsp";
	public static final String EDITOR_WYSIWYG_IMPL_KEY_DEFAULT = "editor.wysiwyg.default";
	public static final String EDITOR_WYSIWYG_IMPL_KEY_SIMPLE = "editor.wysiwyg.default";
%> 

























