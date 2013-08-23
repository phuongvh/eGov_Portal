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
	.vfaqView td.title5{
		background-color: #5293cb;
		color: white;
		padding-left: 10px;
		text-align: left;
		font-weight: bold;
		font-size: 14px;
	}
	
	.vfaqView .choose{
		height: 27px;
    	margin-top: 1px;
    	padding-top: 5px;
    	width: 200px;
	}
	
	.vfaqView .menusider {
    	height: 35px;
	}
	
	.vfaqView .portlet-form-button{
		width: 100px;
		border: 1px solid white;
		border-radius:5px;
		moz-border-radius:5px;
		
	}
	
	.vfaqView .linknumber b{
		color: white;
		font-weight: bold;
	}
	
	.vfaqView .linknumber a,.vfaqView span a{
		color: white;
	}
	
	.vfaqView .linknumber a:hover,.vfaqView span a:hover{
		color: blue;
	}
	
</style>
<table width="100%" height="28">
	<tr>											
		<td class="title5"><%=titlePortlet%></td>
	</tr>
</table>	
<table width="100%" border="0" cellspacing="0" align="center" cellpadding="0" >
	<tr>
		<td height="15">
		</td>
	</tr>
	<tr>
		<td>
			<table width="100%">
				<tr>						
					<td class="menusider" align="left" style="background-color:#5293cb ">
						<table>
						<tr height="100%" width="100%" style="display: inline-block;float: left;padding-left: 5px;color: white;padding-top: 5px;">
							<td><b><%= LanguageUtil.get(pageContext, "pFAQ.form.threadquestion") %></b>&nbsp;&nbsp;</td>	
							<td>
								<select style="text-align: left;" class="choose" name="<portlet:namespace/>categoryId"  onchange="<portlet:namespace />submitForm();">
									<option style="text-align: left;" value="0">--- <%= LanguageUtil.get(pageContext, "pFAQ.form.selectedtopics") %> ---</option>
								<%	for(int i=0;i<listCategory.size();i++){
									 FAQCategory cat = (FAQCategory)listCategory.get(i);%>											
									<option value="<%=cat.getId()%>" <%=(categoryId.equals(String.valueOf(cat.getId()))?"selected":"")%>><%=cat.getName()%></option>
								<%}%>
								</select>
							</td>
							<td></td>			
						</tr>
						<tr height="100%" width="100%" style="display: inline-block;float: left;padding: 5px 0px 5px 5px ;color: white;">
							<td><b><%=LanguageUtil.get(pageContext, "pFAQ.form.questiontitle")%></b></td>		
							<td style="padding-left: 4px;"><input size="34" type="text" name="<portlet:namespace/>title"  value="<%=title%>" ></td>
							<td>&nbsp;<b><%=LanguageUtil.get(pageContext, "pFAQ.form.sentByUser")%></b></td>		
							<td style="padding-left: 5px;"><input size="33" type="text" name="<portlet:namespace/>sentByUser"  value="<%=sentByUser%>" ></td>			
							<td>&nbsp;<input class="portlet-form-button"  type="button" value="<%= LanguageUtil.get(pageContext, "search") %>" onclick="<portlet:namespace />submitForm();"/></td>		
						</tr>						
						</table>
					</td>
				</tr>	
			</table>
		</td>
	<tr>
		<td height="15">
		</td>
	</tr>												
	<tr>												
		<td>
			<table width="100%" >
				
                    <tr bgcolor="#5293cb" style="border: 1px solid white;color: white;text-align: center;" height="30" >
                    	<td width="6%" style="border: 1px solid white;"><b>&nbsp;&nbsp; <%= LanguageUtil.get(pageContext, "pFAQ.numberorder") %></b></td>
                        <td style="border: 1px solid white;"><b>&nbsp;&nbsp;<%= LanguageUtil.get(pageContext, "pFAQ.question") %></b></td>
                        <td style="border: 1px solid white;" width="19%"><b><%= LanguageUtil.get(pageContext, "pFAQ.person.send") %></b></td>
                        <td style="border: 1px solid white;" width="17%"><b><%= LanguageUtil.get(pageContext, "pFAQ.date.send") %></b></td>
                        <td style="border: 1px solid white;" width="10%"><b><%= LanguageUtil.get(pageContext, "pFAQ.status") %></b></td>
                     </tr>		
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
					
					<tr style="border: 1px solid white;" <%=j%2!=0?"bgcolor=#e4e5e5":"" %> <%=j%2==0?"bgcolor=#eff0f0":"" %> height="50"> 
						<td align="center" style="border: 1px solid white;">
						 	<%=begin+j+1 %>
						</td>
						<td align="left" style="padding: 10px 5px;border: 1px solid white;"> 						
							<a href="<%=answerURL.toString() %>"><%= StringUtil.shorten(HtmlUtil.extractText(question.getTitle()), 200) %> </a>
						</td>
						<td align="center" style="border: 1px solid white;">
						  	<%= question.getSentByUser() %>
						</td>
						<td align="center" style="border: 1px solid white;">
						  	<%= dateFormatDateTime.format(question.getSentDate()) %>
						</td>
						<td align="center" style="border: 1px solid white;">
						  	<%=countanswer %> <%= LanguageUtil.get(pageContext, "pFAQ.form.answer") %>
						</td>
					</tr>
				<%
					}		
				%>
					<!-- Phan trang -->		
				<c:if test='<%= pages > 1 %>'>
				<tr><td height="20"></td></tr>
					<tr bgcolor="#5293cb" valign="middle" style="color: white;">
						<td height="40" colspan="5"
							style="text-align: right; padding-right: 15px;"><strong>&nbsp;&nbsp;&nbsp;<%= LanguageUtil.get(pageContext, "pFAQ.page") %>&nbsp;&nbsp;</strong>
							<% 	
							if(pages > 0 && numberPage > 4 ){									
						%> <span> <a class="style1" href="#"
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
								title="<%= LanguageUtil.get(pageContext, "pFAQ.form.firstpage") %>"> << <%= LanguageUtil.get(pageContext, "pFAQ.form.firstpage") %> </a>
						</span>&nbsp; <%	
							}	
						%> <%
							if(numberPage >1){
								int intPrev = numberPage-1;
						%> <span class="linknumber"> <a class="style1" href="#"
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
								title="<%= LanguageUtil.get(pageContext, "pFAQ.form.previouspage") %>"> < </a>
						</span>&nbsp; <%	}	%> <% 
							for(int i = 1;i <= pages;i++){ 	
								if( i == numberPage ){
						%> <span class="linknumber"> <a class="text_download"
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
										</portlet:renderURL>';">
									<b><%=i%></b>
							</a>
						</span>&nbsp; <%
							}else if(i > numberPage-5 && i < numberPage || i > numberPage && i < numberPage+5){
						%> <span class="linknumber"> <a href="#"
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
									</portlet:renderURL>';">
									<%=i%>
							</a>
						</span>&nbsp; <%		}
							}
						%> <% 	
							if(numberPage < pages){
								int intNext = numberPage + 1;
						%> <span class="linknumber"> <a href="#"
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
								title="<%= LanguageUtil.get(pageContext, "pFAQ.form.nextpage") %>"> > </a>
						</span>&nbsp; <%
							}
						%> <% 	
							if(pages > 10 && numberPage != pages){
						%> <span> <a class="style1" href="#"
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
								title="<%= LanguageUtil.get(pageContext, "pFAQ.form.lastpage") %>"> <%= LanguageUtil.get(pageContext, "pFAQ.form.lastpage") %> >> </a>
						</span> &nbsp; <%	
							}	
						%> <% 	
							if(pages > 8){
						%> <span> <select id="<portlet:namespace/>pageSelected"
								name="<portlet:namespace/>pageSelected"
								onchange="<portlet:namespace />Submit()"
								title="<%= LanguageUtil.get(pageContext, "pFAQ.form.selectpage") %>">
									<%
											for(int j = 1; j <= pages; j++){													
										%>
									<option value="<%=j %>"
										<%=j==pageSelected||j==numberPage?"selected":"" %>>
										<%=j %>
									</option>
									<%
											}
										%>
							</select>
						</span> &nbsp; <%	
							}	
						%></td>
					</tr>
				</c:if>	
			</table>												
			<br>														
		</td>
	</tr>
</table>