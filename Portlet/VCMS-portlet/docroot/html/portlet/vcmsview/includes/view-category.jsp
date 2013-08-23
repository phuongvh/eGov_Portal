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
		<%
		VcmsCategory category = VcmsCategoryServiceUtil.getCategory(categoryId);
		if(Validator.isNotNull(category)){
			List articles = new ArrayList();
			articles = VcmsArticleServiceUtil.getArticleByC_P_L_S(categoryId , groupId , language , VcmsArticleServiceImpl.PUBLISHED);
			if(Validator.isNotNull(articles) && articles.size() > 0){
				%>
				  <table width="100%" class="chanel-news" border="0" cellspacing="0" cellpadding="0">
		            <tr>
		              <th><div class="t2" style="background:url(<%= category.getHasImage() ? ("/image/images?img_id="+category.getImage()):"/html/portlet/vcmsview/images/g_pq.gif" %>) 0px 0px no-repeat;float:left;	width:auto;	background-color:#fff;	padding-left:22px;	padding-right:3px;	line-height:20px;"><%= category.getName() %></div>
					  <div class="date-current"><%= dateFormatDateTime.format(new Date()) %></div></th>
		            </tr>
		          </table>
				<%
				for(int j=0; j<articles.size(); j++){
					VcmsArticle article = (VcmsArticle) articles.get(j);
					if(j<1){
					%>
					  <table width="100%" class="chanel-news no-bot" border="0" cellspacing="0" cellpadding="0">
			            <tr>
			              <td>
			            	<a class="title01" href="<portlet:renderURL><portlet:param name="jspPage" value="/html/portlet/vcmsview/view.jsp"/><portlet:param name="categoryId" value="<%= String.valueOf(category.getCategoryId()) %>" /><portlet:param name="articleId" value="<%= String.valueOf(article.getArticleId()) %>" /></portlet:renderURL>"><%= article.getTitle() %></a>
									<% if(article.getHasImage()) {%>
										<div class="n-img"><img src="/image/images?img_id=<%= article.getImage() %>" width="115" height="99" align="absmiddle"></div>
									<% } %>
									<p><%= article.getLead() %></p>
						  </td>
			            </tr>
			            <tr>
			              <td>&nbsp;</td>
			            </tr>
			          </table>
					  <p class="no-bot"><b class="news-other"><u>Các tin khác:</u></b></p>
					  <p class="org2 indent u">
					<%
					}else{
					%>
						<a href="<portlet:renderURL><portlet:param name="struts_action" value="/vcmsview/view" /><portlet:param name="categoryId" value="<%= String.valueOf(category.getCategoryId()) %>" /><portlet:param name="articleId" value="<%= String.valueOf(article.getArticleId()) %>" /></portlet:renderURL>"><%= article.getTitle() %></a>
					<%
					}
				}
				%>
				</p>
				<%
			}
		}
		%>