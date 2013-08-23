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
<%@page import="com.vportal.portlet.vcms.util.VCMSUtil"%>
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
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.vportal.portal.util.PropsUtilExt" %>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter" %>
<%@ taglib uri="http://www.vietsoftware.com/tld" prefix="vportal" %>
<%
	//long companyId = PortalUtil.getCompanyId(request);

	/* int imageWidth = GetterUtil.getInteger(PrefsPropsUtil.getString(companyId, PropsUtilExt.VCMS_ARTICLE_THUMB_IMAGE_WIDTH), 100);

	int imageHeight = GetterUtil.getInteger(PrefsPropsUtil.getString(companyId, PropsUtilExt.VCMS_ARTICLE_THUMB_IMAGE_HEIGHT), 100);

	int maxArticleAttachment = GetterUtil.getInteger(PrefsPropsUtil.getString(companyId, PropsUtilExt.VCMS_ARTICLE_MAX_ATTACHMENT), 5);

	boolean autoApprove = PrefsPropsUtil.getBoolean(companyId, PropsUtilExt.VCMS_ARTICLE_AUTO_APPROVE);

	// boolean autoPublish = PrefsPropsUtil.getBoolean(companyId, PropsUtilExt.VCMS_ARTICLE_AUTO_PUBLISH);

	String autoMessage = PrefsPropsUtil.getString(companyId, PropsUtilExt.VCMS_ARTICLE_AUTO_REQUEST_MESSAGE);

	boolean autoDiscussionApprove = PrefsPropsUtil.getBoolean(companyId, PropsUtilExt.VCMS_DISCUSSION_AUTO_APPROVE);

	int maxDiscussionAttachment = GetterUtil.getInteger(PrefsPropsUtil.getString(companyId, PropsUtilExt.VCMS_DISCUSSION_MAX_ATTACHMENT), 3);

	boolean sendThanksDiscussionEmail = PrefsPropsUtil.getBoolean(companyId, PropsUtilExt.VCMS_DISCUSSION_SEND_THANKS_EMAIL);

	String senderName = PrefsPropsUtil.getString(companyId,PropsUtilExt.VCMS_DISCUSSION_THANKS_SENDER_NAME);

	String senderEmail = PrefsPropsUtil.getString(companyId,PropsUtilExt.VCMS_DISCUSSION_THANKS_SENDER_EMAIL);

	String autoDiscussionEmailSubject = PrefsPropsUtil.getString(companyId, PropsUtilExt.VCMS_DISCUSSION_THANKS_EMAIL_SUBJECT);

	String autoDiscussionEmailContent = PrefsPropsUtil.getString(companyId, PropsUtilExt.VCMS_DISCUSSION_THANKS_EMAIL_CONTENT);

	int autoClearLog = GetterUtil.getInteger(PrefsPropsUtil.getString(companyId, PropsUtilExt.VCMS_LOGGING_AUTO_CLEAR), 30); */
	
	int imageWidth = GetterUtil.getInteger(VCMSUtil.getPrefsPropsUtil(companyId, PropsUtilExt.VCMS_ARTICLE_THUMB_IMAGE_WIDTH), 100);

	int imageHeight = GetterUtil.getInteger(VCMSUtil.getPrefsPropsUtil(companyId, PropsUtilExt.VCMS_ARTICLE_THUMB_IMAGE_HEIGHT), 100);
	
	//cho vao file init
	//int maxArticleAttachment = GetterUtil.getInteger(VCMSUtil.getPrefsPropsUtil(companyId, PropsUtilExt.VCMS_ARTICLE_MAX_ATTACHMENT), 5);

	boolean autoApprove = VCMSUtil.getBooleanPrefsPropsUtil(companyId, PropsUtilExt.VCMS_ARTICLE_AUTO_APPROVE);

	// boolean autoPublish = PrefsPropsUtil.getBoolean(companyId, PropsUtilExt.VCMS_ARTICLE_AUTO_PUBLISH);

	String autoMessage = VCMSUtil.getPrefsPropsUtil(companyId, PropsUtilExt.VCMS_ARTICLE_AUTO_REQUEST_MESSAGE);

	boolean autoDiscussionApprove = VCMSUtil.getBooleanPrefsPropsUtil(companyId, PropsUtilExt.VCMS_DISCUSSION_AUTO_APPROVE);
	
	//cho vao file init
	//int maxDiscussionAttachment = GetterUtil.getInteger(VCMSUtil.getPrefsPropsUtil(companyId, PropsUtilExt.VCMS_DISCUSSION_MAX_ATTACHMENT), 3);

	boolean sendThanksDiscussionEmail = VCMSUtil.getBooleanPrefsPropsUtil(companyId, PropsUtilExt.VCMS_DISCUSSION_SEND_THANKS_EMAIL);

	String senderName = VCMSUtil.getPrefsPropsUtil(companyId,PropsUtilExt.VCMS_DISCUSSION_THANKS_SENDER_NAME);

	String senderEmail = VCMSUtil.getPrefsPropsUtil(companyId,PropsUtilExt.VCMS_DISCUSSION_THANKS_SENDER_EMAIL);

	String autoDiscussionEmailSubject = VCMSUtil.getPrefsPropsUtil(companyId, PropsUtilExt.VCMS_DISCUSSION_THANKS_EMAIL_SUBJECT);

	String autoDiscussionEmailContent = VCMSUtil.getPrefsPropsUtil(companyId, PropsUtilExt.VCMS_DISCUSSION_THANKS_EMAIL_CONTENT);

	int autoClearLog = GetterUtil.getInteger(VCMSUtil.getPrefsPropsUtil(companyId, PropsUtilExt.VCMS_LOGGING_AUTO_CLEAR), 30);

%>

<script type="text/javascript">
	function <portlet:namespace />initDiscussionEmailEditor() {
		document.<portlet:namespace />fm.<portlet:namespace />autoDiscussionEmailContent.value = "<%= UnicodeFormatter.toString(autoDiscussionEmailContent) %>";
		return "<%= UnicodeFormatter.toString(autoDiscussionEmailContent) %>";
	}
	
	function <portlet:namespace />saveConfiguration() {
		document.<portlet:namespace />fm.<portlet:namespace />autoDiscussionEmailContent.value = parent.<portlet:namespace />autoDiscussionEmailContent.getHTML();
		submitForm(document.<portlet:namespace />fm, '<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>" name="updateConfiguration"><portlet:param name="jspPage" value="/html/portlet/vcms/manage/edit_configuration" /></portlet:actionURL>');
	}
</script>

<table border="0" cellpadding="4" cellspacing="0" width="100%">
	<tr>
		<td align="left" width="100%" valign="top">
			<fieldset>
				<legend><b><%= LanguageUtil.get(pageContext, "portlet.vcms.configuration.panel1.label") %></b></legend>
				<table border="0" cellpadding="4" cellspacing="0" width="100%">
					<tr>
						<td align="left" width="50%" valign="top">
							<table border="0" cellpadding="0" cellspacing="4" width="100%">
								<tr>
									<td align="left" width="100%" colspan="2" valign="top">
										<label for="<portlet:namespace />imageWidth"><%= LanguageUtil.get(pageContext, "portlet.vcms.configuration.panel1.max-dimension") %>:</label>
										<input type="text" class="form-text" style="width: 50px" id="<portlet:namespace />imageWidth" name="<portlet:namespace />imageWidth" value="<%= imageWidth %>" />
										&nbsp;x&nbsp;
										<input type="text" class="form-text" style="width: 50px" name="<portlet:namespace />imageHeight" value="<%= imageHeight %>" />
										&nbsp;(<%= LanguageUtil.get(pageContext, "portlet.vcms.configuration.panel1.pixcel") %>)
									</td>
								</tr>
								<tr>
									<td align="left" width="100%" colspan="2" valign="top">
										&nbsp;
									</td>
								</tr>
								<tr>
									<td align="left" width="100%" colspan="2" valign="top">
										<label for="<portlet:namespace />maxArticleAttachment"><%= LanguageUtil.get(pageContext, "portlet.vcms.configuration.panel1.max-attachment") %>:</label>
										
										<select class="form-text" id="<portlet:namespace />maxArticleAttachment" name="<portlet:namespace />maxArticleAttachment">
											<%
												for (int i = 1; i < 20; i ++) {
											%>
												<option value="<%= i %>" <%= (maxArticleAttachment == i) ? "selected" : "" %>><%= i %></option>
											<%
												}
											%>
										</select>
									</td>
								</tr>
								<tr>
									<td align="left" width="100%" colspan="2" valign="top">
										&nbsp;
									</td>
								</tr>
								<tr>
									<td align="left" width="1%" valign="middle">
										<input type="checkbox" class="form-text" valign="middle" id="<portlet:namespace />autoApprove" name="<portlet:namespace />autoApprove" <%= autoApprove ? "checked" : "" %> />
									</td>
									<td align="left" width="99%" valign="middle">
										<label for="<portlet:namespace />autoApprove"><%= LanguageUtil.get(pageContext, "portlet.vcms.configuration.panel1.auto-approve") %><label>
									</td>
								</tr>
								<%--
								<tr>
									<td align="left" width="1%" valign="middle">
										<input type="checkbox" class="form-text" valign="middle" id="<portlet:namespace />autoPublish" name="<portlet:namespace />autoPublish" <%= autoPublish ? "checked" : "" %> />
									</td>
									<td align="left" width="99%" valign="middle">
										<label for="<portlet:namespace />autoPublish"><%= LanguageUtil.get(pageContext, "portlet.vcms.configuration.panel1.auto-publish") %></label>
									</td>
								</tr>
								--%>
							</table>
						</td>
						<td align="left" width="50%" valign="top" >
							<table border="0" cellpadding="0" cellspacing="4" width="100%">
								<tr>
									<td align="left" width="100%" valign="top">
										<%= LanguageUtil.get(pageContext, "portlet.vcms.configuration.panel1.auto-message") %>:
									</td>
								</tr>
								<tr>
									<td align="left" width="100%" valign="top">
										<textarea style="width: 97%;border:1px dotted gray;" rows="5" id="<portlet:namespace />autoMessage" name="<portlet:namespace />autoMessage"><%= Validator.isNull(autoMessage) ? StringPool.BLANK : autoMessage %></textarea>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</fieldset>
		</td>
	</tr>
	<tr>
		<td align="left" width="100%" valign="top">
			<fieldset>
				<legend><b><%= LanguageUtil.get(pageContext, "portlet.vcms.configuration.panel2.label") %></b></legend>
				<table border="0" cellpadding="4" cellspacing="0" width="100%">
					<tr>
						<td align="left" width="50%" valign="top">
							<table border="0" cellpadding="0" cellspacing="4" width="100%">
								<tr>
									<td align="left" width="1%" valign="middle">
										<input type="checkbox" class="form-text" valign="middle" id="<portlet:namespace />autoDiscussionApprove" name="<portlet:namespace />autoDiscussionApprove" <%= autoDiscussionApprove ? "checked" : "" %> />
									</td>
									<td align="left" width="99%" valign="middle">
										<label for="<portlet:namespace />autoDiscussionApprove"><%= LanguageUtil.get(pageContext, "portlet.vcms.configuration.panel2.auto-approve") %><label>
									</td>
								</tr>
								<tr>
									<td align="left" width="100%" colspan="2" valign="top">
										&nbsp;
									</td>
								</tr>
								<tr>
									<td align="left" width="100%" colspan="2" valign="top">
										<label for="<portlet:namespace />maxDiscussionAttachment"><%= LanguageUtil.get(pageContext, "portlet.vcms.configuration.panel2.max-attachment") %>:</label>
										
										<select class="form-text" id="<portlet:namespace />maxDiscussionAttachment" name="<portlet:namespace />maxDiscussionAttachment">
											<%
												for (int i = 1; i < 20; i ++) {
											%>
												<option value="<%= i %>" <%= (maxDiscussionAttachment == i) ? "selected" : "" %>><%= i %></option>
											<%
												}
											%>
										</select>
									</td>
								</tr>
								<tr>
									<td align="left" width="100%" colspan="2" valign="top">
										&nbsp;
									</td>
								</tr>
								<tr>
									<td align="left" width="1%" valign="middle">
										<input type="checkbox" class="form-text" valign="middle" id="<portlet:namespace />sendThanksDiscussionEmail" name="<portlet:namespace />sendThanksDiscussionEmail" <%= sendThanksDiscussionEmail ? "checked" : "" %> />
									</td>
									<td align="left" width="99%" valign="middle">
										<label for="<portlet:namespace />sendThanksDiscussionEmail"><%= LanguageUtil.get(pageContext, "portlet.vcms.configuration.panel2.send-thanks-email") %><label>
									</td>
								</tr>
								<tr>
									<td align="left" width="100%" colspan="2" valign="top">
										<label for="<portlet:namespace />senderName"><%= LanguageUtil.get(pageContext, "portlet.vcms.configuration.panel2.sender-name") %>:</label>
									</td>
								</tr>
								<tr>
									<td align="left" width="100%" colspan="2" valign="top">
										<input type="text" class="form-text" style="width: 250px" id="<portlet:namespace />senderName" name="<portlet:namespace />senderName" value="<%= Validator.isNull(senderName) ? StringPool.BLANK : senderName %>" />
									</td>
								</tr>
								<tr>
									<td align="left" width="100%" colspan="2" valign="top">
										<label for="<portlet:namespace />senderEmail"><%= LanguageUtil.get(pageContext, "portlet.vcms.configuration.panel2.sender-email") %>:</label>
									</td>
								</tr>
								<tr>
									<td align="left" width="100%" colspan="2" valign="top">
										<input type="text" class="form-text" style="width: 250px" id="<portlet:namespace />senderEmail" name="<portlet:namespace />senderEmail" value="<%= Validator.isNull(senderEmail) ? StringPool.BLANK : senderEmail %>" />
									</td>
								</tr>
								<tr>
									<td align="left" width="100%" colspan="2" valign="top">
										<label for="<portlet:namespace />autoDiscussionEmailSubject"><%= LanguageUtil.get(pageContext, "portlet.vcms.configuration.panel2.email-subject") %>:</label>
									</td>
								</tr>
								<tr>
									<td align="left" width="100%" colspan="2" valign="top">
										<input type="text" class="form-text" style="width: 350px" id="<portlet:namespace />autoDiscussionEmailSubject" name="<portlet:namespace />autoDiscussionEmailSubject" value="<%= Validator.isNull(autoDiscussionEmailSubject) ? StringPool.BLANK : autoDiscussionEmailSubject %>" />
									</td>
								</tr>
							</table>
						</td>
						<td align="left" width="50%" valign="top" >
							<table border="0" cellpadding="0" cellspacing="4" width="100%">
								<tr>
									<td align="left" width="100%" valign="top">
										<%= LanguageUtil.get(pageContext, "portlet.vcms.configuration.panel2.email-body") %>:
									</td>
								</tr>
								<tr>
									<td align="left" width="100%" valign="top">
										<vportal:input-editor name="<%= renderResponse.getNamespace() + \"autoDiscussionEmailContent\" %>" editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY_DEFAULT %>" toolbarSet="Basic" width="100%" height="400px;" initMethod="<%= renderResponse.getNamespace() + \"initDiscussionEmailEditor\" %>" />
										<input type="hidden" name="<portlet:namespace />autoDiscussionEmailContent" />
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</fieldset>
		</td>
	</tr>
	<tr>
		<td align="left" width="100%" valign="top">
			<fieldset>
				<legend><b><%= LanguageUtil.get(pageContext, "portlet.vcms.configuration.panel3.label") %></b></legend>
				<table border="0" cellpadding="4" cellspacing="0" width="100%">
					<tr>
						<td align="left" width="100%" valign="top">
							<label for="<portlet:namespace />autoClearLog"><%= LanguageUtil.get(pageContext, "portlet.vcms.configuration.panel3.auto-lear-log-after") %>:</label>
							<input type="text" class="form-text" style="width: 50px" name="<portlet:namespace />autoClearLog" value="<%= autoClearLog %>" />
							&nbsp;(<%= LanguageUtil.get(pageContext, "portlet.vcms.configuration.panel3.day") %>)
						</td>
					</tr>
				</table>
			</fieldset>
		</td>
	</tr>
	<tr>
		<td align="center" width="100%" valign="top">
			<input class="portlet-form-button" type="button" value='<%= LanguageUtil.get(pageContext, "save") %>' onClick="javascript:<portlet:namespace />saveConfiguration();">
		</td>
	</tr>
</table>

<script type="text/javascript">
	document.<portlet:namespace />fm.<portlet:namespace />imageWidth.focus();
</script>

<%!
public static final String EDITOR_WYSIWYG_IMPL_KEY_DEFAULT = "editor.wysiwyg.default";
%>
