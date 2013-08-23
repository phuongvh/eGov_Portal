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

<%@page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@page import="com.vportal.portlet.vfaq.service.FAQAnswerLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="com.vportal.portal.service.AttachmentLocalServiceUtil"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<liferay-theme:defineObjects />
<div class="wd-boxs">
	<h2 class="wd-tlh1-2"><%=titlePortlet%>:</h2>
	<div class="wd-introduction">
		<fieldset>
			<div class="wd-form-keyword">
				<div class="wd-asked">
					<div class="wd-input">
						<label for="keyword"><%=LanguageUtil.get(pageContext, "pFAQ.form.questiontitle")%></label>
						<input type="text" placeholder="<%= LanguageUtil.get(pageContext, "com.vportal.portlet.vfaqcontent.keyword") %>" name="<portlet:namespace/>title"  value="<%=title%>" />
					</div>
					<div class="wd-form-1">
						<label for="asked"><%= LanguageUtil.get(pageContext, "pFAQ.form.threadquestion") %></label>
						<select style="text-align: left;" class="choose" name="<portlet:namespace/>categoryId"  onchange="<portlet:namespace />submitForm();">
								<option style="text-align: left;" value="0">--- <%= LanguageUtil.get(pageContext, "pFAQ.form.selectedtopics") %> ---</option>
							<%	for(int i=0;i<listCategory.size();i++){
								 FAQCategory cat = (FAQCategory)listCategory.get(i);%>											
								<option value="<%=cat.getId()%>" <%=(categoryId.equals(String.valueOf(cat.getId()))?"selected":"")%>><%=cat.getName()%></option>
							<%}%>
						</select>
					</div>
					<div class="wd-form-2">
						<label for="asked"><%=LanguageUtil.get(pageContext, "pFAQ.form.sentByUser")%></label>
						<input type="text" id="people" placeholder="<%= LanguageUtil.get(pageContext, "com.vportal.portlet.vfaqcontent.keyword") %>" name="<portlet:namespace/>sentByUser"  value="<%=sentByUser%>" />
					</div>
				</div>
				<div class="wd-submit">
					<input type="submit" class="wd-bt-search" value="<%= LanguageUtil.get(pageContext, "search") %>" onclick="<portlet:namespace />submitForm();" />
				</div>
			</div>
		</fieldset>
		<div class="wd-table wd-table-three">
			<table cellspacing="0" cellpadding="0">
				<thead>
					<tr>
						<th><%= LanguageUtil.get(pageContext, "pFAQ.numberorder") %></th>
						<th width="300"><%= LanguageUtil.get(pageContext, "pFAQ.question") %><a class="wd-up-down" href="#"  title = "1|name"  onclick="<portlet:namespace />submitForm(this);">&nbsp;</a></th>
						<th><%= LanguageUtil.get(pageContext, "pFAQ.person.send") %><a class="wd-up-down" href="#" title = "1|person" onclick="<portlet:namespace />submitForm(this);">&nbsp;</a></th>
						<th width="98"><%= LanguageUtil.get(pageContext, "pFAQ.date.send") %><a class="wd-up-down" href="#" title = "1|date" onclick="<portlet:namespace />submitForm(this);">&nbsp;</a></th>
						<th><%= LanguageUtil.get(pageContext, "pFAQ.status") %><%-- <a class="wd-up-down" href="#" title = "1|status" onclick="<portlet:namespace />submitForm(this);">&nbsp;</a> --%>&nbsp;</th>
						<th><%= LanguageUtil.get(pageContext, "pFAQ.file") %></th>
					</tr>
				</thead>
				<tbody>
					<%	
						String folderFile = "";
						String nameFile = "";
						List listAttachment = null;
						DLFileEntry fileEntry = null;
						PortletURL answerURL = renderResponse.createRenderURL();				
						for(int j=0; j<listQuestion.size(); j++){
							FAQQuestion question = (FAQQuestion) listQuestion.get(j);
							    int countanswer = FAQAnswerLocalServiceUtil.countQuestion(question.getId());
								answerURL.setParameter("jspPage","/html/portlet/vfaqcontent/view_ans.jsp");
								answerURL.setParameter("categoryId",categoryId);
								answerURL.setParameter("questionId",String.valueOf(question.getId()));
								answerURL.setParameter(WebKeysEDDepartment.OBJECT, FAQQuestion.class.getName());
								answerURL.setParameter(WebKeysEDDepartment.QUESTION_ID, String.valueOf(question.getId()));
								
							listAttachment = AttachmentLocalServiceUtil.getDLFileEntries(FAQQuestion.class, question.getId());
							for (int i = 0; i < listAttachment.size(); i++) {
								fileEntry = (DLFileEntry) listAttachment.get(i);
								folderFile = String.valueOf(fileEntry.getFolderId()) ;
								nameFile = fileEntry.getName();
							}
					%>
						<tr>
							<td><%=begin+j+1 %></td>
							<td><p><a href="<%=answerURL.toString() %>"><%= StringUtil.shorten(HtmlUtil.extractText(question.getTitle()), 200) %> </a></p></td>
							<td><p><%= question.getSentByUser() %></p></td>
							<td><p><%= dateFormatDateTime.format(question.getSentDate()) %></p></td>
							<td><p><%= LanguageUtil.get(pageContext, "pFAQ.form.yes") %> <%=countanswer %> <%= LanguageUtil.get(pageContext, "pFAQ.form.answer") %></p></td>
							<%if(listAttachment.size() > 0 ){ %>
							<td>
								<a href="/c/document_library/get_file?p_l_id=<%= layout.getPlid()%>&fileEntryId=<%=fileEntry.getFileEntryId()%>">
								<%-- <a href = "<%=themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + folderFile + StringPool.SLASH + HttpUtil.encodeURL(fileEntry.getTitle(), true)%>"> --%>
								<img src="<%=themeDisplay.getPathThemeImages() %>/han6/icon/icon-word.png" alt="" width="16" height="16" />
								</a>
							</td>
							<%}else{ %>
							<td></td>
							<%} %>
						<tr>
					<%
						}		
					%>
				</tbody>
			</table>
		</div>
		<div class="wd-paging">
			<p class="sum-page"><%= LanguageUtil.get(pageContext, "pFAQ.total") %> <%=total %> <%= LanguageUtil.get(pageContext, "pFAQ.title.question") %> / <%=pages %> trang</p>
			
			<!-- Phan trang -->		
			<c:if test='<%= pages > 1 %>'>
				<span><%= LanguageUtil.get(pageContext, "pFAQ.page") %>: </span>
				<ul class="yiiPager">	
					<% 	
						if(pages > 0 && numberPage > 2 ){									
					%> <li class="first"><a class="style1" href="#"
							onclick="self.location = '<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>"> 
									<portlet:param name="jspPage" value="/html/portlet/vfaqcontent/view.jsp" />
									<portlet:param name="pagenum" value="<%= String.valueOf(1) %>" />				
									<%	
										if(Validator.isNotNull(categoryId)){	
									%>
									<portlet:param name="categoryId" value="<%=categoryId%>"/>
									<%	
										}if (Validator.isNotNull(cmd) && cmd.equalsIgnoreCase("searchBasic")) {
									%>
									<portlet:param name="cmd" value="searchBasic"/>
									<portlet:param name="title" value="<%=title %>"/>
									<portlet:param name="sentByUser" value="<%=sentByUser %>"/>
									<%
										}
									%>	
									</portlet:renderURL>';"
							title="<%= LanguageUtil.get(pageContext, "pFAQ.form.firstpage") %>">&nbsp;</a>
					</li><%	
						}	
					%> <%
						if(numberPage >1){
							int intPrev = numberPage-1;
					%> <li class="previous"><a class="style1" href="#"
							onclick="self.location = '<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>"> 
								<portlet:param name="jspPage" value="/html/portlet/vfaqcontent/view.jsp" />
								<portlet:param name="pagenum" value="<%= String.valueOf(intPrev) %>" />				
								<%	
									if(Validator.isNotNull(categoryId)){											
								%>
									<portlet:param name="categoryId" value="<%=categoryId%>"/>
								<%	
									}if (Validator.isNotNull(cmd) && cmd.equalsIgnoreCase("searchBasic")) {
								%>
								<portlet:param name="cmd" value="searchBasic"/>
								<portlet:param name="title" value="<%=title %>"/>
								<portlet:param name="sentByUser" value="<%=sentByUser %>"/>
								<%}%>	
								</portlet:renderURL>';"
							title="<%= LanguageUtil.get(pageContext, "pFAQ.form.previouspage") %>">&nbsp;</a>
					</li><%	}	%> 
					<% 
						for(int i = 1;i <= pages;i++){ 	
							if( i == numberPage ){
					%> 
					<li class="page selected"><a class="text_download"
							href="#"
							onclick="self.location = '<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>"> 
								<portlet:param name="jspPage" value="/html/portlet/vfaqcontent/view.jsp" />
								<portlet:param name="pagenum" value="<%= String.valueOf(i) %>" />
								<%
									if(Validator.isNotNull(categoryId)){
								%>
									<portlet:param name="categoryId" value="<%=categoryId%>"/>
								<%	
									}
									if (Validator.isNotNull(cmd) && cmd.equalsIgnoreCase("searchBasic")) {
								%>
									<portlet:param name="cmd" value="searchBasic"/>
									<portlet:param name="title" value="<%=title %>"/>
									<portlet:param name="sentByUser" value="<%=sentByUser %>"/>
								<%
									}
								%>	
									</portlet:renderURL>';"><%=i%></a>
					</li>
						<%
							/* i > numberPage-5 && i < numberPage  */
							}else if(i > numberPage && i < numberPage+5){
						%> 
					<li class="page"><a href="#"
							onclick="self.location = '<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>"> 
								<portlet:param name="jspPage" value="/html/portlet/vfaqcontent/view.jsp" />
								<portlet:param name="pagenum" value="<%= String.valueOf(i) %>" />
								<%
									if(Validator.isNotNull(categoryId)){
								%>
								<portlet:param name="categoryId" value="<%=categoryId%>"/>
								<%
									}if (Validator.isNotNull(cmd)&& cmd.equalsIgnoreCase("searchBasic")) {
								%>
								<portlet:param name="cmd" value="searchBasic"/>
								<portlet:param name="title" value="<%=title %>"/>
								<portlet:param name="sentByUser" value="<%=sentByUser %>"/>
								<%
									}
								%>	
								</portlet:renderURL>';"><%=i%></a>
					</li>
					<%		}
						}
					%>
					
					<% 	
						if(numberPage < pages){
							int intNext = numberPage + 1;
					%> <li class="next"><a href="#"
							onclick="self.location = '<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>"> 
							<portlet:param name="jspPage" value="/html/portlet/vfaqcontent/view.jsp" />
							<portlet:param name="pagenum" value="<%= String.valueOf(intNext) %>" />					
							<%	
								if(Validator.isNotNull(categoryId)){	
							%>
							<portlet:param name="categoryId" value="<%=categoryId%>"/>
							<%	
								}if (Validator.isNotNull(cmd) && cmd.equalsIgnoreCase("searchBasic")) {
							%>
								<portlet:param name="cmd" value="searchBasic"/>
								<portlet:param name="title" value="<%=title %>"/>
								<portlet:param name="sentByUser" value="<%=sentByUser %>"/>
							<%
								}
							%>				
								</portlet:renderURL>';"
							title="<%= LanguageUtil.get(pageContext, "pFAQ.form.nextpage") %>">&nbsp;</a>
					</li><%
						}
					%> <% 	
						if(pages > 10 && numberPage != pages){
					%> <li class="last"><a class="style1" href="#"
							onclick="self.location = '<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>"> 
									<portlet:param name="jspPage" value="/html/portlet/vfaqcontent/view.jsp"/>
									<portlet:param name="pagenum" value="<%= String.valueOf(pages) %>" />				
									<%	
										if(Validator.isNotNull(categoryId)){	
									%>
									<portlet:param name="categoryId" value="<%=categoryId%>"/>
									<%	
										}if (Validator.isNotNull(cmd) && cmd.equalsIgnoreCase("searchBasic")) {
									%>
									<portlet:param name="cmd" value="searchBasic"/>
									<portlet:param name="title" value="<%=title %>"/>
									<portlet:param name="sentByUser" value="<%=sentByUser %>"/>
									<%
										}
									%>	
									</portlet:renderURL>';"
							title="<%= LanguageUtil.get(pageContext, "pFAQ.form.lastpage") %>">&nbsp;</a>
					</li><%	
						}	
					%>
				</ul>
			</c:if>	
		</div>
	</div>
</div>
