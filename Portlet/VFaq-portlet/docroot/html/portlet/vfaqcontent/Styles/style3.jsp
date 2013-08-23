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

<style>
	ul.faq-st3{
		color: #6A97BF;
		padding-left: 10px;		
	}
	
	ul.faq-st3 li{
		line-height: 25px;
		list-style-type: square;
		margin-left: 10px;
		float: left;
		clear: both;
	}
	
	ul.faq-st3 li.faq-link-st3 a{
		color: #6A97BF !important;	
	}
	
	ul.faq-st3 li.faq-link-st3 a:hover{
		color: #000066 !important;	
	}
	
</style>
<table width="100%" height="28">
	<tr>											
		<td class="title5"><%=titlePortlet%></td>
	</tr>
</table>
<ul class="faq-st3">
<%		
					PortletURL answerURL = renderResponse.createRenderURL();				
					for(int j=0; j<listQuestion.size(); j++){
						FAQQuestion question = (FAQQuestion) listQuestion.get(j);
						    int countanswer = FAQAnswerLocalServiceUtil.countQuestion(question.getId());
							answerURL.setParameter("jspPage","/html/portlet/vfaqcontent/view_ans.jsp");
							answerURL.setParameter("categoryId",categoryId);
							answerURL.setParameter("questionId",String.valueOf(question.getId()));
							answerURL.setParameter(WebKeysEDDepartment.OBJECT, FAQQuestion.class.getName());
							answerURL.setParameter(WebKeysEDDepartment.QUESTION_ID, String.valueOf(question.getId()));	
				%>
				<li class="faq-link-st3">
					<a href="<%=answerURL.toString() %>"><%= StringUtil.shorten(HtmlUtil.extractText(question.getTitle()), 100) %> </a>
				</li>
				<% } %>
</ul>