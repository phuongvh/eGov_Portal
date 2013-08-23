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

<%@page import="com.liferay.portal.kernel.util.MathUtil"%>
<%@page import="com.vportal.portlet.vpolls.util.WebKeysExt"%>
<%@page import="java.text.NumberFormat"%>
<%@ include file="/html/portlet/vpolls/init.jsp" %>
<%
	NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
	NumberFormat percentFormat = NumberFormat.getPercentInstance(locale);
	
	PollsQuestion question = (PollsQuestion)request.getAttribute(WebKeysExt.POLLS_QUESTION);
	List choices = (List)request.getAttribute("choices");
	question = question.toEscapedModel();	
	int totalVotes = PollsVoteLocalServiceUtil.getQuestionVotesCount(question.getQuestionId());	
%>
<div class="wd-boxs">
	<div id="wd-overlay-sign" class="wd-dialog-overlay">&nbsp;</div>
	<div id="wd-popup-sign" class="wd-content-signup">
		<div class="wd-title-dialog">
			<h3><%= question.getDescription()%></h3>
			<a href="#" class="wd-btnclose-sign">&nbsp;</a>
		</div>
		<div class="wd-form-content">
			<p><script type="text/javascript">									
					var currentTime = new Date();
					var thu = currentTime.getDay();	
					dayname = new Array("Ch&#7911; Nh&#7853;t", "Th&#7913; Hai", "Th&#7913; Ba", "Th&#7913; T&#432;", "Th&#7913; N&#259;m", "Th&#7913; Sáu", "Th&#7913; B&#7843;y");
					t = dayname[thu];						
					var month = currentTime.getMonth() + 1;
					var day = currentTime.getDate();
					var year = currentTime.getFullYear();
					var hours = currentTime.getHours();
					var minutes = currentTime.getMinutes();
					if (minutes < 10)
						minutes = "0" + minutes;
						
					document.write(t + " , ");
					document.write(day + "/" + month + "/" + year + " , " + hours + ":" + minutes + " ");
						
					if(hours > 11){
						document.write("PM")
					} else {
						document.write("AM")
					}
				</script></p>
			<div class="wd-system-detail">
				<table>
					<tbody>
						<%
							for(int i=0;i < choices.size(); i++ ){
								PollsChoice choice = (PollsChoice)choices.get(i);
								choice = choice.toEscapedModel();	
															
								int choiceVotes = PollsVoteLocalServiceUtil.getChoiceVotesCount(choice.getChoiceId());
								
								String className = "portlet-section-body";
								String classHoverName = "portlet-section-body-hover";		
								
								if (MathUtil.isEven(i)) {
									className = "portlet-section-alternate";
									classHoverName = "portlet-section-alternate-hover";
								}						
								
								double votesPercent = 0.0;
								int votesPixelWidth = 200;
								int countPer = 0;
								
								if (totalVotes > 0) {
									votesPercent = (double)choiceVotes / totalVotes;	
								}
								
								int votesPercentWidth = (int)Math.floor(votesPercent * votesPixelWidth);
								
						%>
						<tr>
							<td><strong><%= choice.getDescription()%></strong></td>
							<td></td>
							<td><%= percentFormat.format(votesPercent) %></td>
							<td colspan="<%= votesPercentWidth > 0 ? "5" : "5" %>"><%= numberFormat.format(choiceVotes) %> phi&#7871;u</td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
			<p class="wd-bill-sum">T&#7893;ng c&#7897;ng : <%= totalVotes %> phi&#7871;u</p>
			<p><a href="javascript:window.close()">[Tr&#7903; v&#7873;]</a></p>
		</div>
	</div>
</div>