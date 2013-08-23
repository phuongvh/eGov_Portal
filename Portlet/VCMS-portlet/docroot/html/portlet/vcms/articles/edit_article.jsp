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
<%@ include file="/html/portlet/vcms/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");
String articleId = ParamUtil.getString(request, "articleId","");

VcmsArticle article = null;
try{
	article = VcmsArticleServiceUtil.getArticle(articleId);
}catch(Exception e){
}	

String articleLead = ((article != null) ? article.getLead() : StringPool.BLANK);
String articleContent = ((article != null) ? article.getContent() : StringPool.BLANK);
String articleSource = ((article != null) ? article.getSource() : StringPool.BLANK);
String articleAuthor = ((article != null) ? article.getAuthor() : StringPool.BLANK);

String strCatId = "";
String strPortionId = "";
String strTypeId = "";

List listCategoryId = (List)VcmsCARelationServiceUtil.getRelationsByArticle(articleId);
List listPortionId = (List)VcmsPARelationServiceUtil.getRelationsByArticle(articleId);
List listTypeId = (List)VcmsArticleTypeLocalServiceUtil.getByArticleId(articleId);

if (Validator.isNotNull(listCategoryId) && listCategoryId.size()>0){
	for (int i = 0; i < listCategoryId.size();i ++){
		VcmsCARelation CA = (VcmsCARelation)listCategoryId.get(i);		
		strCatId += CA.getCategoryId() + (i < listCategoryId.size() -1 ? ",":"");				
	}
}

if (Validator.isNotNull(listPortionId) && listPortionId.size()>0){
	for (int i = 0; i < listPortionId.size();i ++){
		VcmsPARelation PA = (VcmsPARelation)listPortionId.get(i);		
		strPortionId += PA.getPortionId() + (i < listPortionId.size() -1 ? ",":"");				
	}
}

if (Validator.isNotNull(listTypeId) && listTypeId.size()>0){
	for (int i = 0; i < listTypeId.size();i ++){		
		VcmsArticleType vArticleType = (VcmsArticleType)listTypeId.get(i);
		strTypeId += String.valueOf(vArticleType.getTypeId()) + (i < listTypeId.size() -1 ? ",":"");				
	}
}

String[] strPortion = ((article != null) ? StringUtil.split(strPortionId, StringPool.COMMA): null);
String[] strCategory = ((article != null) ? StringUtil.split(strCatId, StringPool.COMMA): null);
String[] strType = ((article != null) ? StringUtil.split(strTypeId, StringPool.COMMA): null);

List attachedMessages = new ArrayList();

List listType = new ArrayList();
listType = VcmsTypeServiceUtil.getTypesByS_L(groupId, language);



if (Validator.isNotNull(articleId)) {
	attachedMessages = VcmsAttachedMessageServiceUtil.getMessages(articleId);
}
//System.out.println("test"+articleId);

PortletURL popUpPollList = renderResponse.createRenderURL();
popUpPollList.setWindowState(LiferayWindowState.EXCLUSIVE);
popUpPollList.setParameter("jspPage","/html/portlet/vcms/articles/poll_list.jsp" );
popUpPollList.setParameter("groupId",String.valueOf(groupId));

%>
<portlet:renderURL var="popupPollList" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
  <portlet:param name="jspPage" value="/html/portlet/vcms/articles/poll_list.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="popupThreadList" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
  <portlet:param name="jspPage" value="/html/portlet/vcms/articles/thread_articles.jsp"/>
</portlet:renderURL>
<script >	
	
	function <portlet:namespace />saveDraft() {
		var categories = '';
		var portions = '';
		
		
		var cObjects = document.getElementsByName("<portlet:namespace />category");
		var pObjects = document.getElementsByName("<portlet:namespace />portion");
		var articleId = document.<portlet:namespace />fm.<portlet:namespace />articleId.value;

		for (i = 0; (cObjects != null) && (i < cObjects.length); i ++) {
			if (cObjects[i].checked) {
				categories += cObjects[i].value + ',';
			}
		}
		
		for (i = 0; (pObjects != null) && (i < pObjects.length); i ++) {
			if (pObjects[i].checked) {
				portions += pObjects[i].value + ',';
			}
		}	
		
		alertContent();
		document.<portlet:namespace />fm.<portlet:namespace />cmd.value =  articleId == null ? "add" :"update" ;
		document.<portlet:namespace />fm.<portlet:namespace />lead.value = parent.<portlet:namespace />art_lead.getHTML();
		document.<portlet:namespace />fm.<portlet:namespace />portions.value = portions;
		document.<portlet:namespace />fm.<portlet:namespace />categories.value = categories;
		var customValue = window.art_content.getHTML(); 
		document.<portlet:namespace />fm.<portlet:namespace />content.value = customValue;	
		submitForm(document.<portlet:namespace />fm);
		
	}
	
	function <portlet:namespace />save_sendArticle() {
		var categories = '';
		var portions = '';
		
		var cObjects = document.getElementsByName("<portlet:namespace />category");
		var pObjects = document.getElementsByName("<portlet:namespace />portion");
		
		for (i = 0; (cObjects != null) && (i < cObjects.length); i ++) {
			if (cObjects[i].checked) {
				categories += cObjects[i].value + ',';
			}
		}
		
		for (i = 0; (pObjects != null) && (i < pObjects.length); i ++) {
			if (pObjects[i].checked) {
				portions += pObjects[i].value + ',';
			}
		}	
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= articleId == null ? Constants.ADD : Constants.UPDATE %>";
		document.<portlet:namespace />fm.<portlet:namespace />save_send.value = 'save_send';
		document.<portlet:namespace />fm.<portlet:namespace />lead.value = parent.<portlet:namespace />art_lead.getHTML();
		document.<portlet:namespace />fm.<portlet:namespace />content.value = parent.<portlet:namespace />art_content.getHTML();
		document.<portlet:namespace />fm.<portlet:namespace />portions.value = portions;
		document.<portlet:namespace />fm.<portlet:namespace />categories.value = categories;
		submitForm(document.<portlet:namespace />fm);
	}
	
	
	function <portlet:namespace />saveAndApproveArticle(){
		
		var categories = '';
		var portions = '';
		
		var cObjects = document.getElementsByName("<portlet:namespace />category");
		var pObjects = document.getElementsByName("<portlet:namespace />portion");
		
		for (i = 0; (cObjects != null) && (i < cObjects.length); i ++) {
			if (cObjects[i].checked) {
				categories += cObjects[i].value + ',';
			}
		}
		
		for (i = 0; (pObjects != null) && (i < pObjects.length); i ++) {
			if (pObjects[i].checked) {
				portions += pObjects[i].value + ',';
			}
		}
		
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= articleId == null ? Constants.ADD : Constants.UPDATE %>";
		document.<portlet:namespace />fm.<portlet:namespace />saveAndApprove.value = 'SaveAndApprove';
		document.<portlet:namespace />fm.<portlet:namespace />lead.value = parent.<portlet:namespace />art_lead.getHTML();
		document.<portlet:namespace />fm.<portlet:namespace />content.value = parent.<portlet:namespace />art_content.getHTML();
		document.<portlet:namespace />fm.<portlet:namespace />portions.value = portions;
		document.<portlet:namespace />fm.<portlet:namespace />categories.value = categories;
		submitForm(document.<portlet:namespace />fm);		        
	}
	
	function <portlet:namespace />saveAndPublishArticle(){
		
		var categories = '';
		var portions = '';
		
		var cObjects = document.getElementsByName("<portlet:namespace />category");
		var pObjects = document.getElementsByName("<portlet:namespace />portion");
		
		for (i = 0; (cObjects != null) && (i < cObjects.length); i ++) {
			if (cObjects[i].checked) {
				categories += cObjects[i].value + ',';
			}
		}
		
		for (i = 0; (pObjects != null) && (i < pObjects.length); i ++) {
			if (pObjects[i].checked) {
				portions += pObjects[i].value + ',';
			}
		}
		
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= article == null ? Constants.ADD : Constants.UPDATE %>";
		document.<portlet:namespace />fm.<portlet:namespace />saveAndPublish.value = 'SaveAndPublish';
		document.<portlet:namespace />fm.<portlet:namespace />lead.value = parent.<portlet:namespace />art_lead.getHTML();
		document.<portlet:namespace />fm.<portlet:namespace />content.value = parent.<portlet:namespace />art_content.getHTML();
		document.<portlet:namespace />fm.<portlet:namespace />portions.value = portions;
		document.<portlet:namespace />fm.<portlet:namespace />categories.value = categories;
		submitForm(document.<portlet:namespace />fm,'<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>" name="removeArticleImage"></portlet:actionURL>');
	}
	
	function <portlet:namespace />removeImage() {
		
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "remove_image";
		submitForm(document.<portlet:namespace />fm,'<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>" name="removeArticleImage"><portlet:param name="articleId" value="<%= articleId %>" /></portlet:actionURL>');
	}
	
	function <portlet:namespace />removeAttachment(attachmentId) {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "remove_attachment";
		document.<portlet:namespace />fm.<portlet:namespace />attachmentId.value = attachmentId;
		submitForm(document.<portlet:namespace />fm);
	}
	
	function <portlet:namespace />downloadAttachment(attachmentId) {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "download_attachment";
		document.<portlet:namespace />fm.<portlet:namespace />attachmentId.value = attachmentId;
		document.<portlet:namespace />fm.<portlet:namespace />redirect.value = '<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/vcms/edit_article" /><portlet:param name="articleId" value="<%= articleId %>" /></portlet:renderURL>';
		submitForm(document.<portlet:namespace />fm);
	}
	
	function <portlet:namespace />removePoll() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "remove_poll";
		submitForm(document.<portlet:namespace />fm);
	}
	
	function <portlet:namespace />removeThread() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "remove_thread";
		submitForm(document.<portlet:namespace />fm,'<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>" name="removeThread"></portlet:actionURL>');
	}
	
	var <portlet:namespace />pollsMessageBox = null;
	var <portlet:namespace />articlesBox = null;
	
	function <portlet:namespace />closePollsMessageBox(){
		document.getElementById('<portlet:namespace />polls_box').innerHTML = <portlet:namespace />pollsMessageBox.innerHTML;
	};
	
	function <portlet:namespace />showPollsList(){

 		<%-- var organizationWindow = window.open(
 				'<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>">
 				<portlet:param name="jpsPage" value="/html/portlet/vcms/articles/poll_list.jsp" />
 				</portlet:renderURL>',
		 '<%= LanguageUtil.get(pageContext, "portlet.vcms.article.edit.list-polls") %>',
			'directories=no, height=640, location=no, menubar=no, resizable=yes,  scrollbars=yes, status=no, toolbar=no, width=680');
                         
 		 void('');
		organizationWindow.focus(); --%>
		AUI().use('aui-dialog', 'aui-io', 'event', 'event-custom', function(A) {
			   
		    var dialog = new A.Dialog({
		            title: '<%= LanguageUtil.get(pageContext, "portlet.vcms.article.edit.list-polls") %>',
		            centered: true,
		            draggable: true,
		            modal: true,
		            width: 600,
		            buttons:[                   
		                     {
		                    	 cssClass: 'button_close',
		                    	 text:'Close',handler:function() {
		                         this.close();
		                        }
		                     }
		                ]
		        }).plug(A.Plugin.IO, {uri: '<%=popupPollList %>'}).render();
		       
		        dialog.show();
		       
		  });
	};	
    
	function <portlet:namespace />showThreadsList(){		
		var groupId = document.<portlet:namespace />fm.<portlet:namespace />groupId.value;
		var threadId = document.<portlet:namespace />fm.<portlet:namespace />threadId.value;
		<%-- var popup = Liferay.Popup({title: '<%= LanguageUtil.get(pageContext, "portlet.vcms.article.edit.list-threads") %>',modal:false,width:700,height:500});
		jQuery(popup).load('<%= themeDisplay.getPathMain() %>/vcms/article_threads?groupId=' + groupId); --%>
		AUI().use('aui-dialog', 'aui-io', 'event', 'event-custom', function(A) {
			   
		    var dialog = new A.Dialog({
		            title: '<%= LanguageUtil.get(pageContext, "portlet.vcms.article.edit.list-threads") %>',
		            centered: true,
		            draggable: true,
		            modal: true,
		            width: 600,
		            buttons:[                   
		                     {
		                    	 cssClass: 'button_close',
		                    	 text:'Close',handler:function() {
		                         this.close();
		                        }
		                     }
		                ]
		        }).plug(A.Plugin.IO, {data: {groupId:groupId},uri: '<%=popupThreadList %>'}).render();
		       
		        dialog.show();
		       
		  });
    };
    
	function <portlet:namespace />showFormMessage(){		
		var groupId = document.<portlet:namespace />fm.<portlet:namespace />groupId.value;		
		var popup = Liferay.Popup({title: '<%= LanguageUtil.get(pageContext, "portlet.vcms.article.edit.message") %>',modal:false,width:500,height:400});
        jQuery(popup).load('<%= themeDisplay.getPathMain() %>/vcms/article_messages?groupId=' + groupId);
    };	
    
	
	
	function <portlet:namespace />initLeadEditor() {
		document.<portlet:namespace />fm.<portlet:namespace />art_lead.value = "<%= UnicodeFormatter.toString(articleLead) %>";
		return "<%= UnicodeFormatter.toString(articleLead) %>";
	};
	
	function <portlet:namespace />initContentEditor() {
		document.<portlet:namespace />fm.<portlet:namespace />art_content.value = "<%= UnicodeFormatter.toString(articleContent) %>";
		return "<%= UnicodeFormatter.toString(articleContent) %>";
	};
</script>
<form action="<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>" name="updateArticle">
	<portlet:param name="redirect" value='<%=redirect %>' /></portlet:actionURL>" method="post" name="<portlet:namespace />fm" onSubmit="<portlet:namespace />saveDraft(); return false;" enctype="multipart/form-data">

<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= articleId == null ? Constants.ADD : Constants.UPDATE %>">
<input name="<portlet:namespace />attachmentId" type="hidden" value="">
<input name="<portlet:namespace />redirect" type="hidden" value="<%= redirect %>">
<input name="<portlet:namespace />articleId" type="hidden" value="<%= (articleId != null) ? articleId : "" %>">
<input name="<portlet:namespace />groupId" type="hidden" value="<%= groupId %>">
<input name="<portlet:namespace />language" type="hidden" value="<%= language %>">	
<input name="<portlet:namespace />save_send" type="hidden" value="">
<input name="<portlet:namespace />portions" type="hidden" value="">
<input name="<portlet:namespace />categories" type="hidden" value="<%=strCategory%>">
	

<liferay-ui:error exception="<%= InvalidArticleTitleException.class %>" message="portlet.vcms.article.exception.please-enter-a-valid-article-title" />
<liferay-ui:error exception="<%= InvalidArticleContentException.class %>" message="portlet.vcms.article.exception.article-content-must-not-be-null" />

	
<c:if test='<%= article != null %>'>
	<liferay-ui:tabs names="<%= LanguageUtil.get(pageContext, \"portlet.vcms.article.edit.update\") %>" backURL="<%= redirect %>" />
</c:if>
<c:if test='<%= article == null %>'>
	<liferay-ui:tabs names="<%= LanguageUtil.get(pageContext, \"portlet.vcms.article.edit.add-new\") %>" backURL="<%= redirect %>" />
</c:if>
	
<div class="beta-separator"></div>
		
<c:if test="<%= (attachedMessages != null) && (attachedMessages.size() > 0) %>">
<fieldset>
	<legend><%= LanguageUtil.get(pageContext, "portlet.vcms.article.edit.attached-message") %></legend>
	<div style="padding: 2px">
		<%
			for (int i = 0; i < attachedMessages.size(); i ++) {
				VcmsAttachedMessage attachedMessage = (VcmsAttachedMessage) attachedMessages.get(i);
				
				// Display...
				out.println("<img src='" + themeDisplay.getPathThemeImage() + "/vcms/message-notation.gif' valign='middle' />");
				out.println(!attachedMessage.getReadMessage() ? ("<b>[" + LanguageUtil.get(pageContext, "portlet.vcms.article.edit.unread-message") + "]</b> ") : "");
				out.println(attachedMessage.getContent());
				if (i < attachedMessages.size() - 1) {
					out.println("<br /><div class=\"beta-separator\"></div><br />");
				}
				
				// Update status
				VcmsAttachedMessageServiceUtil.updateMessage(attachedMessage.getMessageId(), true);
			}
		%>
	</div>
</fieldset>
<br/>
</c:if>
			
	<table border="0" cellpadding="4" cellspacing="0" width="100%">
	<tr>
		<td width="65%" valign="top">
			<table border="0" cellpadding="4" cellspacing="0" width="98%">
			<tr>
				<td width="100%" align="left"  valign="top">
					<table border="0" cellpadding="4" cellspacing="0" width="100%">
						<tr>
							<td align="left" width="100%" valign="top">
								<fieldset>
									<legend><%= LanguageUtil.get(pageContext, "portlet.vcms.article.cancel-ap.attached-message") %></legend>
									<table border="0" cellpadding="4" cellspacing="0" width="100%">
										<tr>
											<td align="left" width="100%">
												<textarea name="<portlet:namespace />attachedMessage" rows="2" style="border:1px dotted gray; font-family: verdana, arial, tahoma; font-size: 13px; padding: 10px; width: 95%"></textarea>
											</td>
										</tr>
									</table>
								</fieldset>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<tr height="5"><td>&nbsp;</td></tr>	
					
			<tr>
				<td width="100%" align="left">
					<b><%= LanguageUtil.get(pageContext, "portlet.vcms.article.edit.title") %>:</b>
				</td>
			</tr>
				
			<tr>
				<td width="100%" align="left">
					<input type="text" maxlength="1000" style="width: 98%; padding: 3px; font-size: 13pt; font-family: tahoma, verdana" name="<portlet:namespace />title" value="<%= (article != null) ? HtmlUtil.escape(article.getTitle()) : "" %>" />
				</td>
			</tr>
				
			<tr height="5"><td>&nbsp;</td></tr>
											
			<tr>
				<td width="100%" align="left">
					<b><%= LanguageUtil.get(pageContext, "portlet.vcms.article.edit.lead") %>:</b>
				</td>
			</tr>
			<tr>
				<td width="100%" align="left">
<%-- 					<vportal:input-editor name="<%= renderResponse.getNamespace() + \"art_lead\" %>" editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY_SIMPLE %>" toolbarSet="Basic" width="100%" height="<%= ((article != null) && (article.getHasImage())) ? \"250\" : \"200\" %>" initMethod="<%= renderResponse.getNamespace() + \"initLeadEditor\" %>" /> --%>
					<liferay-ui:input-editor name="art_lead" editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY_SIMPLE %>" toolbarSet="Basic" width="100%" height="<%= ((article != null) && (article.getHasImage())) ? \"250\" : \"200\" %>" initMethod="initLeadEditor" />.
<!-- 					<aui:input name="lead" type="hidden" /> -->
					<input type="hidden" name="<portlet:namespace />lead" />
				</td>
			</tr>	
				
			<tr height="5"><td>&nbsp;</td></tr>	
				
			<tr>
				<td width="100%">
				<fieldset>
				<legend><%= LanguageUtil.get(pageContext, "portlet.vcms.article.edit.image") %></legend>
					<table border="0" cellpadding="4" cellspacing="0" width="100%">
					<tr>
						<td width="30%" align="left">
							<b><%= LanguageUtil.get(pageContext, "portlet.vcms.article.edit.image-title") %>:</b>
						</td>
						<td width="70%"><input type="text" style="width: 230px" maxlength="150" name="<portlet:namespace />imageTitle" value="<%= ((article != null) ? article.getImageTitle() : "" )%>" /></td>
					</tr>
					<c:if test="<%= (article != null) && (article.getHasImage()) %>">
					<tr height="3"><td colspan="2">&nbsp;</td></tr>
					<tr>
						<td width="30%" align="left">							
							<p style="margin: 0px; padding: 0px; padding-bottom: 10px">
								<table cellspacing="0" cellpadding="0" width="100%" border="0">
									<tr>
										<td width="1%" valign="middle"><img src="<%= themeDisplay.getPathThemeImage() %>/vcms/delete.gif" valign="middle" /></td>
										<td width="99%" valign="middle" style="padding-left: 5px"><a href="#removeImage" onClick="<portlet:namespace />removeImage();"><%= LanguageUtil.get(pageContext, "portlet.vcms.article.edit.remove-image") %></a></td>
									</tr>
									<tr>
										<td width="1%" valign="middle"><img src="<%= themeDisplay.getPathThemeImage() %>/vcms/large-image.gif" valign="middle" /></td>
										<td width="99%" valign="middle" style="padding-left: 5px"><a href="<%= themeDisplay.getPathImage() + "/images?img_id=" + article.getImage() %>" target="_blank"><%= LanguageUtil.get(pageContext, "portlet.vcms.article.edit.large-image") %></a></td>
									</tr>
								</table>
							</p>
						</td>
						<td width="70%">
							<img src="<%= themeDisplay.getPathImage() + "/images?img_id=" + WebKeysExt.VCMS_ARTICLE_SMALL_IMAGE_KEY + article.getArticleId() %>" border="1" />
						</td>
					</tr>
					</c:if>
				
					<c:if test="<%= !((article != null) && (article.getHasImage())) %>">
					<tr height="30">
						<td width="30%">
							<b><%= LanguageUtil.get(pageContext, "portlet.vcms.article.select.image") %></b></td>
						
						<td width="70%">
							<input type="file" class="form-text" name="<portlet:namespace />image" />							
						</td>
					</tr>
					</c:if>		
					</table>
				</fieldset>				
				</td>
			</tr>
			</table>
		</td>
							
		<td width="35%" valign="top" style="padding-left: 10px; border-left:1px dotted gray">
			<fieldset>
			<legend><%= LanguageUtil.get(pageContext, "portlet.vcms.article.select") %></legend>					
				<div style="overflow: auto; height: 150px; border:1px solid">
					<table cellspacing="3" cellpadding="0" width="100%" border="0">
						<%= ActionUtil.getCategoryTree(groupId, language, renderResponse.getNamespace(),strPortion, strCategory) %>
					</table>
				</div>			
			</fieldset>				
			<p style="margin: 0px; padding: 0px; margin-top: 10px" />
				
			<fieldset>
			<legend><%= LanguageUtil.get(pageContext, "portlet.vcms.article.select.typeArticle") %></legend>					
				<div style="overflow: auto; height: 120px; border:1px solid;float: left;width: 100%;">
					
					<table cellspacing="3" cellpadding="0" border="0" width="100%">
					<%	if(Validator.isNotNull(listType) && listType.size()>0){
							for(int i=0;i<listType.size();i++){
								VcmsType vType = (VcmsType)listType.get(i);
					%>								
					<tr>
						<td width="30">&nbsp;<input type="checkbox" name="<portlet:namespace/>typeIds" id="<portlet:namespace/>typeId_<%=vType.getTypeId()%>" 
									<% if(Validator.isNotNull(strType)){
										for(int j=0;j<strType.length;j++){%>	
										<%= strType[j].equals(vType.getTypeId())? "checked=\"checked\"" : "" %>
									<%}}%> value="<%=vType.getTypeId()%>"></td>
						<td><label for="<portlet:namespace/>typeId_<%=vType.getTypeId()%>"><%=vType.getName()%></label></td>			
					</tr>	
					<%						
						}
					}
					%>
					</table>								
				</div>				
			</fieldset>				
			<p style="margin: 0px; padding: 0px; margin-top: 10px" />	
			
				
			<fieldset>
				<legend><%= LanguageUtil.get(pageContext, "portlet.vcms.article.edit.poll") %></legend>
				<table border="0" cellpadding="4" cellspacing="0" width="100%">
					<tr>
						<td width="100%" align="left">
							<div id="<portlet:namespace />pollContainer" style="margin: 0px; padding: 0px">
								<c:if test="<%= (article != null) && (article.getHasPoll()) %>">
									<%
										PollsQuestion pollsQuestion = PollsQuestionServiceUtil.getQuestion(Long.parseLong(article.getPollId()));
									%>
									<table cellspacing="0" cellpadding="0" width="100%" border="0">
										<tr>
											<td width="1%" valign="middle" style="padding-bottom: 3px"><img src="<%= themeDisplay.getPathThemeImage() %>/vcms/delete.gif" valign="middle" /></td>
											<td width="99%" valign="middle" style="padding-bottom: 3px; padding-left: 5px"><a href="#removePoll" onClick="javascript:<portlet:namespace />removePoll();"><%= LanguageUtil.get(pageContext, "portlet.vcms.article.edit.remove-poll") %></a></td>
										</tr>
										<tr>
											<td width="100%" colspan="2" valign="middle" style="padding-top: 10px; border-top:1px dotted gray"><b><%= pollsQuestion.getTitle() %></b></td>
										</tr>
									</table>
								</c:if>
										
								<c:if test="<%= !((article != null) && (article.getHasPoll())) %>">
									<a href="#browsePoll" onClick="javascript:<portlet:namespace />showPollsList()"><%= LanguageUtil.get(pageContext, "portlet.vcms.article.edit.browse-poll") %>...</a>
								</c:if>
							</div>
							<input id="<portlet:namespace />pollId" name="<portlet:namespace />pollId" type="hidden" value="<%= ((article != null) && (article.getHasPoll())) ? article.getPollId() : "" %>">
						</td>
					</tr>
				</table>
			</fieldset>
										
			<p style="margin: 0px; padding: 0px; margin-top: 10px" />
										
			<fieldset>
				<legend><%= LanguageUtil.get(pageContext, "portlet.vcms.article.edit.thread") %></legend>
				<table border="0" cellpadding="4" cellspacing="0" width="100%">
				<tr>
					<td width="100%" align="left">
					<div id="<portlet:namespace />threadContainer" style="margin: 0px; padding: 0px">						
					<%
						List listThread = new ArrayList();
						VcmsThread vThread =  null;
						String threadId = "";
						try {
							listThread = VcmsTARelationServiceUtil.getRelationsByArticle(articleId);							
							if(Validator.isNotNull(listThread) && listThread.size()>0){
								for(int i=0;i<listThread.size();i++){
									VcmsTARelation TA = (VcmsTARelation)listThread.get(i);									
									threadId = TA.getThreadId();									
 									vThread = VcmsThreadServiceUtil.getThread(threadId);
										
					%>
							<table cellspacing="0" cellpadding="0" width="100%" border="0">
								<tr>
									<td width="1%" valign="middle" style="padding-bottom: 3px"><img src="<%= themeDisplay.getPathThemeImage() %>/vcms/delete.gif" valign="middle" onClick="javascript:<portlet:namespace />removeThread();" /></td>
									<td width="99%" valign="middle" style="padding-bottom: 3px; padding-left: 5px"><a href="#removePoll" onClick="javascript:<portlet:namespace />removeThread();"><%= LanguageUtil.get(pageContext, "portlet.vcms.article.edit.remove-thread") %></a></td>
								</tr>
								<tr>
									<td width="100%" colspan="2" valign="middle" style="padding-top: 10px; border-top:1px dotted gray"><b><%= vThread.getTitle() %></b></td>
								</tr>
							</table>
							
					<%			}
							}
						}catch (Exception ex){}	%>
						
						
						<a href="#browseThread" onClick="javascript:<portlet:namespace />showThreadsList()"><%= LanguageUtil.get(pageContext, "portlet.vcms.article.edit.browse-thread") %>...</a>
						
					</div>
				
					
					<input name="<portlet:namespace />threadId" type="hidden" value="<%=threadId%>">	
					</td>
				</tr>
				</table>
			</fieldset>							
						
			<p style="margin: 0px; padding: 0px; margin-top: 10px" />				
			
			<c:if test="<%= article == null %>">
			<fieldset>
				<legend><liferay-ui:message key="permissions" /></legend>
				<table border="0" cellpadding="4" cellspacing="0" width="100%">
					<tr>
						<td width="100%" align="center">					
							<liferay-ui:input-permissions
								modelName="<%= VcmsArticle.class.getName() %>"
							/>
						
						</td>
					</tr>
				</table>
			</fieldset>
			</c:if>
		</td>
	</tr>
	<tr>
		<tr>
			<td width="100%" colspan="2" align="left">
				<b><%= LanguageUtil.get(pageContext, "portlet.vcms.article.edit.content") %>:</b>
			</td>
		</tr>
		<tr>
			<td width="100%" colspan="2" align="left">
<%-- 				<vportal:input-editor  name="<%= renderResponse.getNamespace() + \"art_content\" %>" editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY_DEFAULT %>" toolbarSet="liferay-article" width="100%" height="500" initMethod="<%= renderResponse.getNamespace() + \"initContentEditor\" %>" /> --%>
<%-- 				<liferay-ui:input-editor name="<portlet:namespace />content" editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY_DEFAULT %>" toolbarSet="liferay-article" width="100%" height="500" initMethod="<%= renderResponse.getNamespace() + \"initContentEditor\" %>" />. --%>
<%-- 				<input name="<portlet:namespace />content" type="hidden" /> --%>
<%-- 						<liferay-ui:input-editor name='<%= renderResponse.getNamespace() + "structure_el_TextAreaField_content" %>' editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY %>" toolbarSet="liferay-article" onChangeMethod='<%= renderResponse.getNamespace() + "editorContentChanged" %>' width="100%" /> --%>
						
						<liferay-ui:input-editor name="art_content" initMethod="initContentEditor" />						
						<input name="<portlet:namespace />content" type="hidden" value="" />
			</td>
		</tr>
	</tr>
							
	<tr height="5"><td colspan="2">&nbsp;</td></tr>
	
	<tr>						
		<td colspan="2">
		<table width="100%">
		<tr height="30">
			<td width="20%"><b><%= LanguageUtil.get(pageContext, "portlet.vcms.article.edit.author") %>:</b></td>
			<td><input type="text" name="<portlet:namespace />author" style="width:200px;" value="<%=articleAuthor%>"></td>
		</tr>
		<tr height="30">
			<td width="20%"><b><%= LanguageUtil.get(pageContext, "portlet.vcms.article.edit.source") %>:</b></td>
			<td><input type="text" name="<portlet:namespace />source" style="width:300px;" value="<%=articleSource%>"></td>
		</tr>
		</table>
		</td>
	</tr>	
							
	<tr>
		<td width="100%" colspan="2" align="left">
			<p style="margin: 0px; padding: 0px; margin-top: 10px" />
			<fieldset>
				<legend><%= LanguageUtil.get(pageContext, "portlet.vcms.article.edit.attachments") %></legend>
				<table border="0" cellpadding="4" cellspacing="0" width="100%">
				<tr>
					<td>		
						<vportal:file-upload entryId="<%=GetterUtil.getLong(articleId , 0)%>" entryClass="<%=VcmsArticle.class%>"  maxAttachment="5"/>	
					</td>
				</tr>
				</table>
			</fieldset>
		</td>
	</tr>
</table>
<br/>
<table border="0" cellpadding="4" cellspacing="0" width="100%">
	<tr>
		<td width="100%" align="center">
							
			<c:if test="<%=tabs2.equals(\"0\")%>">
				<input class="portlet-form-button" type="submit" value='<%= LanguageUtil.get(pageContext, "portlet.vcms.button.save-draft") %>'>
				<!--<input class="portlet-form-button" type="button" value='<%= LanguageUtil.get(pageContext, "save-send") %>' onClick="javascript:<portlet:namespace />save_sendArticle();">-->
			</c:if>
			
			<c:if test="<%=!tabs2.equals(\"0\")%>">				
				<input class="portlet-form-button" type="submit" value='<%= LanguageUtil.get(pageContext, "save") %>'>				
			</c:if>			
		
			<input class="portlet-form-button" type="button" value='<%= LanguageUtil.get(pageContext, "portlet.vcms.button.cancel") %>' onClick="self.location = '<%= redirect %>';">		
		</td>
	</tr>
</table>
</form>

<script type="text/javascript">
	document.<portlet:namespace />fm.<portlet:namespace />title.focus();
	
	function alertContent(){
		var content = parent.<portlet:namespace />art_content.getHTML();
		document.<portlet:namespace />fm.<portlet:namespace />content.value = content;		
		
		var lead = parent.<portlet:namespace />art_lead.getHTML();
		document.<portlet:namespace />fm.<portlet:namespace />lead.value = lead;		
	}
</script>
	
<%!
public static final String EDITOR_WYSIWYG_IMPL_KEY_DEFAULT = "editor.wysiwyg.default";
public static final String EDITOR_WYSIWYG_IMPL_KEY_SIMPLE = "editor.wysiwyg.default";
%>