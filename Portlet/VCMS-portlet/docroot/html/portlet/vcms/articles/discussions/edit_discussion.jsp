<%
/**
 * Copyright (c) 2000-2009 VSI, Inc. All rights reserved.
 */
%>

<%@ include file="/html/portlet/vcms/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");
VcmsDiscussion discussion = (VcmsDiscussion) request.getAttribute(WebKeysExt.VCMS_DISCUSSION);
String discussionId = ParamUtil.getString(request, "discussionId","");

String discussionContent = (discussion != null) ? discussion.getContent() : StringPool.BLANK;

VcmsArticle article = null;

if ((discussion != null) && Validator.isNotNull(discussion.getArticleId())) {
	article = VcmsArticleServiceUtil.getArticle(discussion.getArticleId());
}



%>

<script type="text/javascript">
	function <portlet:namespace />saveDiscussion() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= discussion == null ? Constants.ADD : Constants.UPDATE %>";
		document.<portlet:namespace />fm.<portlet:namespace />content.value = parent.<portlet:namespace />discussionContent.getHTML();
		submitForm(document.<portlet:namespace />fm);
	}
	
	function <portlet:namespace />removeAttachment(attachmentId) {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "remove_attachment";
		document.<portlet:namespace />fm.<portlet:namespace />attachmentId.value = attachmentId;
		submitForm(document.<portlet:namespace />fm);
	}
	
	function <portlet:namespace />initDiscussionContentEditor() {
		document.<portlet:namespace />fm.<portlet:namespace />content.value = "<%= UnicodeFormatter.toString(discussionContent) %>";
		return "<%= UnicodeFormatter.toString(discussionContent) %>";
	};
</script>

<form action="<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/vcms/edit_discussion" /></portlet:actionURL>" method="post" name="<portlet:namespace />fm" onSubmit="<portlet:namespace />saveDiscussion(); return false;" enctype="multipart/form-data">
<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="">
<input name="<portlet:namespace />attachmentId" type="hidden" value="">
<input name="<portlet:namespace />redirect" type="hidden" value="<%= redirect %>">
<input name="<portlet:namespace />discussionId" type="hidden" value="<%= (discussion != null) ? discussion.getDiscussionId() : "" %>">
<input name="<portlet:namespace />groupId" type="hidden" value="<%= groupId %>">

<liferay-ui:error exception="<%= InvalidDiscussionVisitorNameException.class %>" message="portlet.vcms.discussion.exception.please-enter-a-valid-visitor-name" />
<liferay-ui:error exception="<%= InvalidDiscussionVisitorEmailException.class %>" message="portlet.vcms.discussion.exception.please-enter-a-valid-visitor-email" />
<liferay-ui:error exception="<%= InvalidDiscussionTitleException.class %>" message="portlet.vcms.discussion.exception.please-enter-a-valid-discussion-title" />
<liferay-ui:error exception="<%= InvalidDiscussionContentException.class %>" message="portlet.vcms.discussion.exception.please-enter-a-valid-discussion-content" />

<c:if test='<%= discussion != null %>'>
	<liferay-ui:tabs names="update" backURL="<%= redirect %>" />
</c:if>
<c:if test='<%= discussion == null %>'>
	<liferay-ui:tabs names="add" backURL="<%= redirect %>" />
</c:if>
	

<table border="0" cellpadding="0" cellspacing="0" width="100%">
<tr>
	<td width="60%" valign="top">
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr height="30">
				<td width="25%" align="left">
					<%= LanguageUtil.get(pageContext, "portlet.vcms.discussion.edit.language") %>:
				</td>
				<td width="65%" align="left">
					<input type="hidden" name="<portlet:namespace />language" value="<%= (discussion != null) ? discussion.getLanguage() : language %>" />
					<select name="<portlet:namespace />language" disabled>
						<%	String selectedLanguage = ((discussion != null) ? discussion.getLanguage() : language);
							for (int i = 0; i < locales.length; i++) {%>
						
							<option <%= (selectedLanguage.equals(locales[i].getLanguage() + "_" + locales[i].getCountry())) ? "selected" : "" %> value="<%= locales[i].getLanguage() + "_" + locales[i].getCountry() %>"><%= locales[i].getDisplayName(locales[i]) %></option>
						<%}%>
					</select>
				</td>
			</tr>
						
			<tr height="30">
				<td width="30%" align="left">
					<%= LanguageUtil.get(pageContext, "portlet.vcms.discussion.edit.visitor-name") %>:
				</td>
				<td width="70%" align="left">
					<input type="text" style="width: 300px" maxlength="100" name="<portlet:namespace />visitorName" value="<%= (discussion != null) ? discussion.getVisitorName() : "" %>" />
				</td>
			</tr>
				
			<tr height="30">
				<td width="30%" align="left">
					<%= LanguageUtil.get(pageContext, "portlet.vcms.discussion.edit.visitor-email") %>:
				</td>
				<td width="70%" align="left">
					<input type="text" style="width: 300px" maxlength="75" name="<portlet:namespace />visitorEmail" value="<%= (discussion != null) ? discussion.getVisitorEmail() : "" %>" />
				</td>
			</tr>
			<tr height="30">
				<td width="30%" align="left">
					<%= LanguageUtil.get(pageContext, "portlet.vcms.discussion.edit.visitor-phone") %>:
				</td>
				<td width="70%" align="left">
					<input type="text" style="width: 300px" maxlength="30" name="<portlet:namespace />visitorPhone" value="<%= (discussion != null) ? discussion.getVisitorPhone() : "" %>" />
				</td>
			</tr>
			<tr height="30">
				<td width="30%" align="left">
					<%= LanguageUtil.get(pageContext, "portlet.vcms.discussion.edit.title") %>:
				</td>
				<td width="70%" align="left">
					<input type="text" style="width: 300px" maxlength="200" name="<portlet:namespace />title" value="<%= (discussion != null) ? discussion.getTitle() : "" %>" />
				</td>
			</tr>
			<tr height="30">
				<td width="100%" colspan="2" align="left">
					<b><%= LanguageUtil.get(pageContext, "portlet.vcms.discussion.edit.content") %>:</b>
				</td>			
			</tr>
			<tr>
				<td width="100%" colspan="2">
					<vportal:input-editor name="<%= renderResponse.getNamespace() + \"discussionContent\" %>" editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY_DEFAULT %>" toolbarSet="Basic" width="95%" height="200" initMethod="<%= renderResponse.getNamespace() + "initDiscussionContentEditor" %>" />
					<input type="hidden" name="<portlet:namespace />content" />
				</td>
			</tr>
			</table>
		</td>
		<td width="40%" valign="top">
		
			<p style="margin: 0px; padding: 0px; margin-top: 10px" />
			<fieldset style="border:1px solid %>">
				<legend><%= LanguageUtil.get(pageContext, "portlet.vcms.discussion.article") %></legend>
				<table border="0" cellpadding="4" cellspacing="0" width="100%">
					<tr>
						<td align="left">
							<c:if test="<%= article != null %>">
								<b><%= article.getTitle() %></b>
								<input type="hidden" name="<portlet:namespace />articleId" value="<%= article.getArticleId() %>" />
							</c:if>
							<c:if test="<%= article == null %>">
							<%	List articles = VcmsArticleServiceUtil.getArticleByP_L_S_D(groupId, language, statusId, true);								
								if (articles != null) {%>
								<select name="<portlet:namespace />articleId" style="width: 300px">
									<%for (int i = 0; i < articles.size(); i ++) {
										VcmsArticle anotherArticle = (VcmsArticle) articles.get(i);%>									
										<option value="<%= anotherArticle.getArticleId() %>"><%= anotherArticle.getTitle() %></option>									
									<%}%>
								</select>
							<%}%>
							</c:if>
						</td>
					</tr>
				</table>
			</fieldset>
			<p style="margin: 0px; padding: 0px; margin-top: 10px" />
			<fieldset style="border:1px solid%>">
				<legend><b><%= LanguageUtil.get(pageContext, "portlet.vcms.discussion.edit.approval") %></b></legend>
				<table border="0" cellpadding="4" cellspacing="0" width="100%">
					<tr>
						<td align="left">
							<%= LanguageUtil.get(pageContext, "portlet.vcms.discussion.edit.approval-to") %>: 
							<select name="<portlet:namespace />approved">
								<option value="true" <%= ((discussion != null) && discussion.getApproved()) ? "selected" : "" %>><%= LanguageUtil.get(pageContext, "portlet.vcms.discussion.edit.approved") %></option>
								<option value="false" <%= ((discussion != null) && !discussion.getApproved()) ? "selected" : "" %>><%= LanguageUtil.get(pageContext, "portlet.vcms.discussion.edit.un-approved") %></option>
							</select>
						</td>
					</tr>
				</table>
			</fieldset>
			<p style="margin: 0px; padding: 0px; margin-top: 10px" />
			<fieldset style="border:1px solid %>">
				<legend><%= LanguageUtil.get(pageContext, "portlet.vcms.discussion.edit.attachment") %></legend>
				<table border="0" cellpadding="4" cellspacing="0" width="100%">				
				<tr>
					<td>		
						<vportal:file-upload entryId="<%=GetterUtil.getLong(discussionId , 0)%>" entryClass="<%=VcmsDiscussion.class%>" maxAttachment="<%=maxDiscussionAttachment%>" />	
					</td>
				</tr>				
				</table>
			</fieldset>
		</td>
	</tr>
</table>
<br>
<div align="center">
	<input class="portlet-form-button" type="submit" value='<%= LanguageUtil.get(pageContext, "portlet.vcms.button.save") %>'>
	<input class="portlet-form-button" type="button" value='<%= LanguageUtil.get(pageContext, "portlet.vcms.button.cancel") %>' onClick="self.location = '<%= redirect %>';">
</div>
			

</form>


<c:if test="<%= windowState.equals(WindowState.MAXIMIZED) %>">
	<script type="text/javascript">
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />visitorName);
	</script>
</c:if>		
<%!
public static final String EDITOR_WYSIWYG_IMPL_KEY_DEFAULT = "editor.wysiwyg.default";
%> 