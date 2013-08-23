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

<%if(isBorder){%>		
<div align="center"  style="padding-left:<%=paddingLeft%>px;padding-right:<%=paddingRight%>px;padding-top:3px;" class="boder9b9e9f">	
<%}else{%>	
<div align="center"  style="padding-left:<%=paddingLeft%>px;padding-right:<%=paddingRight%>px;">		
<%}%>						
<table cellspacing="3" cellpadding="5" border="0" width="100%">
<tr>
    <td bgcolor="#ffffff">
    <table cellspacing="0" cellpadding="0" border="0" width="100%">	
	<tr>	
		<td <%=(Validator.isNotNull(themeSelected))? "class='title_menuleft_xanh2'":"class='title_menuleft_xanh'"%>>&nbsp;<%=titlePortlet%></td>	
	</tr>
	<tr>
		<td height="75" >
	 		<table cellspacing="0" cellpadding="0" border="0" width="100%" >    
			<tr>
				<td  bgcolor="<%=bgcolor%>">
				<table cellspacing="3" cellpadding="5" border="0" align="center" width="100%">
				<tr style="text-align: left;">
				<td colspan="2" style="padding-left:3px;padding-right:3px;">					
					<p align="justify"><%= question.getDescription()%></p>
				</td>
				</tr>
									
				<tr>
					<td colspan="2">
						<table>
						<%
							int windowHeight = 200;
							Iterator itr = choices.iterator();	
							while (itr.hasNext()) {
								PollsChoice choice = (PollsChoice)itr.next();
								choice = choice.toEscapedModel();
								windowHeight = windowHeight + 50;
						%>	
						<tr>
							<td style="padding-left:5px;">
								<input type="radio" name="<portlet:namespace />choiceId" id="<portlet:namespace />choiceId_<%=choice.getChoiceId()%>"
									value="<%= choice.getChoiceId() %>" style="margin: 1pt 5px 1pt 0pt;" 
									<%= (String.valueOf(choice.getChoiceId()).equals(choiceId)) ? "checked":""%>	/>
							</td>
							<td style="padding-top:10x;">
								<label for="<portlet:namespace />choiceId_<%=choice.getChoiceId()%>" style="cursor: pointer; color:#3175B9;" class="text_none" ><%=choice.getDescription()%></label>
							</td>
						</tr>
						<%	}	%>	
						</table>
					
					</td>
				</tr>
					
				<tr>
					<td style="padding-top:10px;padding-bottom:5px;" align="center">
						<input type="button" onClick="<portlet:namespace/>SubmitVote();" value="<liferay-ui:message key="vote" />"></td>									
					<td style="padding-top:10px;padding-bottom:5px;"  align="center"> 
						<input type="button" value="<liferay-ui:message key="vote-results" />" onClick="var slideShowWindow = window.open('<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>">
							<portlet:param name="jspPage" value="/html/portlet/vpolls/results.jsp"/>
							<portlet:param name="questionId" value="<%= String.valueOf(question.getQuestionId())%>" />
							</portlet:renderURL>', 'slideShow', 'directories=no,location=no,menubar=no,resizable=yes,width=400,height=<%= windowHeight%>,left='.concat((screen.width - 400)/2).concat(',top=').concat((screen.height - 300)/2)); void(''); slideShowWindow.focus();"> 
					</td>											
				</tr>
				</table>
				</td>	

			</tr>
			<tr><td height="5"></td></tr>			
		    </table>    			
		</td>		
	</tr>
	</table>	
	</td>	
</tr>
<tr><td height="5"></td></tr>				
</table>		
</div>