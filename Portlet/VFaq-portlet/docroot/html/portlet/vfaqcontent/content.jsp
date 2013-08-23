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

<%@page import="com.vportal.portlet.vfaq.service.FAQQuestionLocalServiceUtil"%>
<div style="background-color: #F2FBFF;">
<table width="100%">
<%	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("struts_action", "/vfaqcontent/contentview");		
	portletURL.setParameter("language", language);		
	portletURL.setParameter("groupId", String.valueOf(groupId));
	String redirect = ParamUtil.get(request, "redirect", currentURL);	
	
	List articles = null;	
	List listOtherQuestion = null;
	
	//	title for page
	String categoryTitle="";
	if(bean == null){
		if(!defaultCategory.equals(""))	{
			//lay cau hoi duoc chon
			articles = FAQQuestionLocalServiceUtil.getQuestionApproveByCategory(groupId, language, Long.parseLong(defaultCategory) ,0, 65535, true);
			FAQCategory faqCategory =  FAQCategoryLocalServiceUtil.getCategory(groupId,Long.parseLong(defaultCategory));
			categoryTitle = faqCategory.getName();				
		}else{
		//lay tat ca cau hoi
			articles = FAQQuestionLocalServiceUtil.getApprovedQuestions(groupId);
			categoryTitle = LanguageUtil.get(pageContext,"com.vportal.portlet.vfaqcontent.list-question");
			}
		}
	else{
			//lay cau hoi theo category
			articles = FAQQuestionLocalServiceUtil.getQuestionApproveByCategory(groupId, language, bean.getId() ,0, 65535, true);			
			FAQCategory faqCategory =  FAQCategoryLocalServiceUtil.getCategory(groupId,bean.getId());
			categoryTitle = faqCategory.getName();			
			
		}	
	%>		
	
		
	<tr><th>&nbsp; <%= categoryTitle %></th></tr>		
	<%
		long groupId0 = PortalUtilExt.getPortletGroupId(request);
	    long newCurrentPlid = PortalUtilExt.getPlid(request);
	    long new_plId = 0;
	    new_plId = PortalUtilExt.getPlid(groupId0, newCurrentPlid, "vfaqsend");
		PortletURL questionURL = null;			
			questionURL = new PortletURLImpl(request,"vfaqsend", new_plId, PortletRequest.RENDER_PHASE);
			questionURL.setParameter("struts_action","/vfaqsend/view");	
	%>
	<tr align="right" >
		<td class = "sendquestion_link"><img src="/html/portlet/vfaqcontent/images/mail_send.png"/> &nbsp; <a onClick="self.location = '<%= questionURL %>';" ><%= LanguageUtil.get(pageContext, "com.vportal.portlet.vfaqcontent.sendquestion_title") %></a> &nbsp; &nbsp; </td>			
	</tr>			
	<%			
	
		String sPageNum = ParamUtil.getString(request, "pagenum", "1");
		int numberPage = 1;
		if(Validator.isNotNull(sPageNum)){
			numberPage = Integer.parseInt(sPageNum);
		}
		int total = articles.size();
		int per = Integer.valueOf(questionNumber);
		int pages = (total % per == 0) ? total / per : total / per + 1;
		int begin = per * (numberPage - 1);
		int end = (total>per * numberPage) ? per * numberPage : total;
		
		List listItem = articles.subList(begin,end);	
		
		int beginOtherQuestion = end;
		int endOtherQuestion = end+ Integer.valueOf(otherQuestionNumber);
		
		//cau hoi khac
		listOtherQuestion = FAQQuestionLocalServiceUtil.getOtherQuestion(groupId, language, true,beginOtherQuestion,endOtherQuestion);
			
		PortletURL answerURL = renderResponse.createRenderURL();				
		for(int j=0; j<listItem.size(); j++){
			FAQQuestion article = (FAQQuestion) listItem.get(j);
				answerURL.setParameter("struts_action","/vfaqcontent/contentview");
				answerURL.setParameter(WebKeysEDDepartment.OBJECT, FAQQuestion.class.getName());
				answerURL.setParameter(WebKeysEDDepartment.QUESTION_ID, String.valueOf(article.getId()));
				answerURL.setParameter(WebKeysEDDepartment.SEARCH_BEGIN_INDEX, String.valueOf(beginOtherQuestion));
				answerURL.setParameter(WebKeysEDDepartment.SEARCH_END_INDEX, String.valueOf(endOtherQuestion));			
				
	
		%>		
 			<tr>
				<td style="padding: 7px;"> 						
					<p><a class="title_new3" href="<%=answerURL.toString() %>"><%= article.getTitle() %> </a>
					<%= dateFormatDateTime.format(article.getSentDate()) %>
					 </p>					
					<p id = "dong2"><%= article.getContent() %>  </p>
				</td>
			</tr>
		<%
			}		
		%>
				
		
	<c:if test='<%= pages > 1 %>'>			
		<tr>
			<td height="40">			
				<strong>&nbsp;&nbsp;&nbsp;Trang&nbsp;&nbsp;</strong>
				<% 	
					if(numberPage >1){
						int intPrev = numberPage-1;%>
						<span><a class="style1" href="#" onclick="self.location = '<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>"> 
							<portlet:param name="jspPage" value="/html/portlet/vfaqcontent/content.jsp" />
							<portlet:param name="pagenum" value="<%= String.valueOf(intPrev) %>" />				
							<%
								if(bean != null){						
							%>
								<portlet:param name="newCategoryId" value="<%=String.valueOf(bean.getId())%>"/>
							<%
								}	
							%>
							</portlet:renderURL>';" >&lsaquo;&lsaquo; Tr&#432;&#7899;c</a></span>
	
				<%
					}
				%>				
				
				<% 
					for(int i = 1;i <= pages;i++){ 	
						if( i == numberPage ){%>
						<strong><a class="menu_left" href="#" onclick="self.location = '<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>"> 
							<portlet:param name="struts_action" value="/vfaqcontent/contentview" />
							<portlet:param name="pagenum" value="<%= String.valueOf(i) %>" />
							<%
								if(bean != null){						
							%>
								<portlet:param name="newCategoryId" value="<%=String.valueOf(bean.getId())%>"/>
							<%
								}	
							%>
							</portlet:renderURL>';" > <%=i%></a></strong>
				<%
					}else{
						
				%>	
						<strong><a class="text_download" href="#" onclick="self.location = '<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>"> 
							<portlet:param name="struts_action" value="/vfaqcontent/contentview" />
							<portlet:param name="pagenum" value="<%= String.valueOf(i) %>" />
							<%
								if(bean != null){						
							%>
								<portlet:param name="newCategoryId" value="<%=String.valueOf(bean.getId())%>"/>
							<%
								}	
							%>
							</portlet:renderURL>';" > <%=i%></a></strong>
				<%
						}
				 	} 
			 	%>
			 	
					
				<% 	
					if(numberPage < pages){
						int intNext = numberPage + 1;
				%>
						<a class="text_download" href="#" onclick="self.location = '<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>"> 
							<portlet:param name="struts_action" value="/vfaqcontent/contentview" />
							<portlet:param name="pagenum" value="<%= String.valueOf(intNext) %>" />					
							<%
								if(bean != null){						
							%>
								<portlet:param name="newCategoryId" value="<%=String.valueOf(bean.getId())%>"/>
							<%
								}	
							%>					
							</portlet:renderURL>';" >Ti&#7871;p &rsaquo;&rsaquo;</a>
				<%
					}
				%>		
			</td>
		</tr>
	</c:if>		
	<!-- Cau hoi khac-->	
</table>

<table>
	<%
		if(listOtherQuestion.size() > 0){
	%>
		<tr>
			<td>
				&nbsp; &nbsp; <%=LanguageUtil.get(pageContext,"com.vportal.portlet.vfaqcontent.other-question") %> :
				<br>
			</td>
		</tr>
	<%
	}
	%>	
		
	<%	

		long groupId1 = PortalUtilExt.getPortletGroupId(request);
	    long newCurrentPlid1 = PortalUtilExt.getPlid(request);
	    long new_plId1 = 0;
		try{
			new_plId1 = PortalUtilExt.getPlid(groupId, newCurrentPlid1, "vfaqcontent");			
		}				
		catch(Exception ex)
            {}
            PortletURL otherQuestionURL = new PortletURLImpl(request,"vfaqcontent", new_plId1, PortletRequest.RENDER_PHASE);
            otherQuestionURL.setParameter("struts_action","/vfaqcontent/contentview");
            for(int i=0;i < listOtherQuestion.size();i++)
            {
                  FAQQuestion beanQuestion = (FAQQuestion)listOtherQuestion.get(i);
                  otherQuestionURL.setParameter("struts_action","/vfaqcontent/contentview");
                  otherQuestionURL.setParameter(WebKeysEDDepartment.OBJECT, FAQQuestion.class.getName());
                  otherQuestionURL.setParameter(WebKeysEDDepartment.QUESTION_ID,String.valueOf(beanQuestion.getId()));
                  otherQuestionURL.setParameter(WebKeysEDDepartment.SEARCH_BEGIN_INDEX, String.valueOf(beginOtherQuestion));
                  otherQuestionURL.setParameter(WebKeysEDDepartment.SEARCH_END_INDEX, String.valueOf(endOtherQuestion));
	%>
	<tr>
		<td style="padding:0 7px;">
			<a class="li-text_boxleft_dn" href="<%=otherQuestionURL.toString()%>"><%=beanQuestion.getTitle()%> </a>(<%=dateFormat.format(beanQuestion.getSentDate())%>)<br>
		</td>
	</tr>
	<%
		}
	%>
</table>	
</div>