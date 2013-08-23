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
<div id="container-1"> 
			<%
		String tabs1 = ParamUtil.getString(request, "tabs1", StringPool.BLANK);

		if(Validator.isNotNull(selectCategories) && selectCategories.length > 0){
			VcmsCategory category = VcmsCategoryServiceUtil.getCategory(selectCategories[0]);
			String tabs1_names = category.getName();
			for(int i=1; i<selectCategories.length; i++){
				VcmsCategory tmp_category = VcmsCategoryServiceUtil.getCategory(selectCategories[i]);
				if(tmp_category.getName().equals(tabs1))
					category = tmp_category;
				
				tabs1_names += "," + tmp_category.getName();
			}
		%>
			<%
			PortletURL portletURL = renderResponse.createRenderURL();

			portletURL.setWindowState(WindowState.NORMAL);

			portletURL.setParameter("struts_action", "/vcmsview/view");
			portletURL.setParameter("tabs1", tabs1);
			%>
			<liferay-ui:tabs names="<%= tabs1_names %>" url="<%= portletURL.toString() %>" />
		<%
		
			if(Validator.isNotNull(category)){
				List articles = new ArrayList();
				articles = VcmsArticleServiceUtil.getArticleByC_P_L_S(category.getCategoryId(), groupId , language , VcmsArticleServiceImpl.PUBLISHED);
				if(Validator.isNotNull(articles) && articles.size() > 0){
					%>
			  		<div class="ui-tabs-container" id="fragment-1"><table width="100%" class="chanel-news w-tab" align="center" border="0" cellspacing="0" cellpadding="0">
            			<tr>
						  <td width="15">&nbsp;</td>
			              <td>
					<%
					for(int j=0; j<articles.size(); j++){
						VcmsArticle article = (VcmsArticle) articles.get(j);
						if(j == 0){
						%>
							<% if(article.getHasImage()) {%>
								<div class="n-img"><img src="/image/images?img_id=<%= article.getImage() %>" width="115" height="99" align="absmiddle"></div>
							<% } %>
							<p><a class="title" href="<portlet:renderURL><portlet:param name="struts_action" value="/vcmsview/view" /><portlet:param name="categoryId" value="<%= String.valueOf(category.getCategoryId()) %>" /><portlet:param name="articleId" value="<%= String.valueOf(article.getArticleId()) %>" /></portlet:renderURL>"><%= article.getTitle() %></a></p>
							<p><%= article.getLead() %> <span class="next u"><a href="<portlet:renderURL><portlet:param name="struts_action" value="/vcmsview/view" /><portlet:param name="categoryId" value="<%= String.valueOf(category.getCategoryId()) %>" /><portlet:param name="articleId" value="<%= String.valueOf(article.getArticleId()) %>" /></portlet:renderURL>">Xem ti&#7871;p</a> &raquo;</span></p>
							<div class="clear h-tab"><img src="/html/portlet/vcmsview/images/0.gif"></div>
		  					<table width="100%" class="ta-link blue no-bg" border="0" cellspacing="0" cellpadding="0">
						<%
						}else{ 
							if(j % 2 == 1 ){%>
			                <tr>
			                  <td><% if(article.getHasImage()) {%><img src="/image/images?img_id=<%= article.getImage() %>" width="38" height="38"><% } %></td>
			                  <td><a href="<portlet:renderURL><portlet:param name="struts_action" value="/vcmsview/view" /><portlet:param name="categoryId" value="<%= String.valueOf(category.getCategoryId()) %>" /><portlet:param name="articleId" value="<%= String.valueOf(article.getArticleId()) %>" /></portlet:renderURL>"><%= article.getTitle() %></a></td>
							  <td width="15">&nbsp;</td>
							 <%
							}else{
							 %>
			                  <td><% if(article.getHasImage()) {%><img src="/image/images?img_id=<%= article.getImage() %>" width="38" height="38"><% } %></td>
			                  <td><a href="<portlet:renderURL><portlet:param name="struts_action" value="/vcmsview/view" /><portlet:param name="categoryId" value="<%= String.valueOf(category.getCategoryId()) %>" /><portlet:param name="articleId" value="<%= String.valueOf(article.getArticleId()) %>" /></portlet:renderURL>"><%= article.getTitle() %></a></td>
			                </tr>
			                <tr>
			                  <td colspan="5">&nbsp;</td>
			                </tr>
						<%
							}
							if(j == articles.size() - 1){
							%>
							</table>
							<%
							}
						}
					} %>
							</td>
			  				<td width="10">&nbsp;</td>
            			</tr>
			        </table></div>
					<%
				}
			}
		}
		%>
</div>