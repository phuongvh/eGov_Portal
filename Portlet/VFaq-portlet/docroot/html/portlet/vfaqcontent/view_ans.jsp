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

<%@page import="javax.sound.midi.SysexMessage"%>
<%@page import="com.liferay.portlet.documentlibrary.NoSuchFileEntryException"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://www.vietsoftware.com/tld" prefix="vportal" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<link href="/html/portlet/vfaqcontent/css/vfaq.css" rel="stylesheet" type="text/css" />
<%@ include file="/html/portlet/vfaqcontent/init.jsp"%>
<jsp:directive.page import="com.vportal.portlet.vfaq.util.WebKeysEDDepartment" />
	
<%		
	
// 	FAQQuestion question = (FAQQuestion)request.getAttribute(WebKeysEDDepartment.QUESTION);	
	FAQQuestion question = null;
	
	PortletURL backURL = renderResponse.createRenderURL();	
	backURL.setParameter("jspPage","/html/portlet/vfaqcontent/view.jsp");
	
	String questionId = ParamUtil.getString(request,"questionId", "0");
 	String categoryId = ParamUtil.getString(request,"categoryId", StringPool.BLANK);
 	
	if(!questionId.equals("0")){
		question = FAQQuestionLocalServiceUtil.getQuestion(Long.valueOf(questionId));
	}
 	
	PortletURL questionURL = null;		
	
	List listOtherQuestion = new ArrayList();	
    listOtherQuestion = FAQQuestionLocalServiceUtil.getOrtherQuestionByParam(question.getGroupId(),question.getLanguage(), question.getId(),0,true,0,5);
    
%>
	
<div class="wd-boxs">
	<h2 class="wd-tlh1-2"><%=titlePortlet%></h2>
	<div class="wd-introduction">
		<h3 class="wd-tlh3-6"><%=question.getTitle()%></h3>							
		<p><%=question.getContent()%></p>
		<p class="wd-send-post"><span><%=LanguageUtil.get(pageContext, "pFAQ.form.sentByUser") %>: <strong><%=question.getSentByUser() %></strong></span> ( <%= dateFormatDateTime.format(question.getSentDate()) %>) </p>
		<h3 class="wd-tlh3-6 wd-reply"><%= LanguageUtil.get(pageContext, "com.vportal.portlet.vfaqcontent.answer-title") %></h3>

		<%	List ans_list = (List) FAQAnswerLocalServiceUtil.getByQuestion(Long.valueOf(questionId));
				if(ans_list.size()== 0){	%>
			<tr>
				<td>
					<p><%= LanguageUtil.get(pageContext, "com.vportal.portlet.vfaqcontent.answer-exists") %></p>
				</td>
			</tr>
				
		<%}else if (ans_list.size()>1){%>
			<p style="font-size: 14px; color: blue;"><strong><%= LanguageUtil.get(pageContext, "pFAQ.form.yes") %> <%=ans_list.size() %> <%= LanguageUtil.get(pageContext, "pFAQ.form.answer") %></strong></p>
			<%	for(int i = 0; i < ans_list.size(); i++){
					FAQAnswer answer = (FAQAnswer)ans_list.get(i);
						
			%>
			<p style="color: red;"><strong><%= LanguageUtil.get(pageContext, "pFAQ.form.answer") %> <%=i+1 %> :</strong></p>
			<p><%=answer.getContent()%></p>
			<c:if test='<%= Validator.isNotNull(answer.getAttachName())%>'>	
			<%
			String fileName = "";
			String name ="";
			long folderId = 0;
			List attachmentList = (List) AttachmentLocalServiceUtil.getAttachments(answer.getId(), FAQAnswer.class);		
				for (int j=0; j < attachmentList.size(); j++) { 
						Attachment att = (Attachment)attachmentList.get(j);
						DLFileEntry entry = null;									
						try{
							entry = (DLFileEntry)DLFileEntryLocalServiceUtil.getFileEntry(att.getFileEntryId());
						}catch(NoSuchFileEntryException ex){
							System.out.println("Not exist file entry...");
						}
						
						if(entry != null){
						fileName = entry.getTitle();
						name = entry.getName();
						folderId = entry.getFolderId();													
					}
				}
					
			 %>
			<p><strong><%= LanguageUtil.get(pageContext, "pFAQ.file") %>:</strong> <a href="/c/document_library/get_file?p_l_id=<%= themeDisplay.getPlid()%>&folderId=<%=answer.getFolderId()%>&name=<%=HttpUtil.encodeURL(HtmlUtil.unescape(answer.getAttachName()))%>" class="wd-download-word"><%=fileName%></a></p>
			</c:if>								
			<%} %>
		<%}else	{%>
				<%	for(int i = 0; i < ans_list.size(); i++){
					FAQAnswer answer = (FAQAnswer)ans_list.get(i);
				
					%>
					<p><%=answer.getContent()%></p>
					<c:if test='<%= Validator.isNotNull(answer.getAttachName())%>'>	
					<%
					String fileName = "";
					String name ="";
					long folderId = 0;
					List attachmentList = (List) AttachmentLocalServiceUtil.getAttachments(answer.getId(), FAQAnswer.class);		
						for (int j=0; j < attachmentList.size(); j++) { 
								Attachment att = (Attachment)attachmentList.get(j);
								DLFileEntry entry = null;									
								try{
									entry = (DLFileEntry)DLFileEntryLocalServiceUtil.getFileEntry(att.getFileEntryId());
								}catch(NoSuchFileEntryException ex){
									System.out.println("Not exist file entry...");
								}
								
								if(entry != null){
								fileName = entry.getTitle();
								name = entry.getName();
								folderId = entry.getFolderId();													
							}
						}
							
					 %>
					<p><strong><%= LanguageUtil.get(pageContext, "pFAQ.file") %>:</strong> <a href="/c/document_library/get_file?p_l_id=<%= themeDisplay.getPlid()%>&folderId=<%=answer.getFolderId()%>&name=<%=HttpUtil.encodeURL(HtmlUtil.unescape(answer.getAttachName()))%>" class="wd-download-word"><%=fileName%></a></p>
					</c:if>								
					<%} %>
				<%} %>
		
		
		<div class="wd-bortop">
			<ul class="wd-outside-support">
				<li><a href="javascript:print()" class="wd-print"><%= LanguageUtil.get(pageContext, "com.vportal.portlet.vfaqcontent.print") %></a></li>
				<li><a href="mailto:abc@gmail.com" class="wd-email"><%= LanguageUtil.get(pageContext, "com.vportal.portlet.vfaqcontent.SendEmail") %></a></li>
				<li><a href="<%=backURL %>" class="wd-back"><%= LanguageUtil.get(pageContext, "pFAQ.form.back") %></a></li>
			</ul>
		</div>
		<%if(listOtherQuestion.size() > 0){%>
		<h3 class="wd-tlh3-3"><%=LanguageUtil.get(pageContext,"com.vportal.portlet.vfaqcontent.other-question") %></h3>
		<ul class="wd-other-news">
			<%
			PortletURL otherQuestionURL = renderResponse.createRenderURL();			
			for(int i=0;i < listOtherQuestion.size();i++){
					FAQQuestion beanQuestion = (FAQQuestion)listOtherQuestion.get(i);							
					otherQuestionURL.setParameter("jspPage","/html/portlet/vfaqcontent/view_ans.jsp");
					otherQuestionURL.setParameter("categoryId",categoryId);
					otherQuestionURL.setParameter("questionId",String.valueOf(beanQuestion.getId()));
					otherQuestionURL.setParameter(WebKeysEDDepartment.OBJECT, FAQQuestion.class.getName());
					otherQuestionURL.setParameter(WebKeysEDDepartment.QUESTION_ID, String.valueOf(beanQuestion.getId()));	
			%>			
				<li><a href="<%=otherQuestionURL.toString()%>"><%=StringUtil.shorten(HtmlUtil.extractText(beanQuestion.getTitle()),100)%> </a><span>(<%=dateFormat.format(beanQuestion.getSentDate())%>)</span></li>
			<%}%>
		</ul>
		<%} %>
	</div>
</div>						

					
