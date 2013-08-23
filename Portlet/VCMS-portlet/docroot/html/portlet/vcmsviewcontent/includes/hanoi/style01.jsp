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
<%@page import="com.vportal.portlet.vcms.action.ActionUtil"%>
<%@page import="com.vportal.portlet.vcms.model.VcmsCARelation"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="com.vportal.portlet.vcms.service.VcmsCARelationServiceUtil"%>
<%@page import="com.vportal.portlet.vcms.model.VcmsArticle"%>


<div class="wd-boxs">
		<%
				  VcmsType vType = null;
	             if(Validator.isNotNull(typeId)){
	             	 vType = (VcmsType) VcmsTypeServiceUtil.getType(typeId);		                    	
	             }
				String catDefault="";
				PortletURL catURL = PortletURLFactoryUtil.create(request,portletSelectId, plId, PortletRequest.RENDER_PHASE);
				catURL.setParameter("jspPage","/html/portlet/vcmsviewcontent/view.jsp");
// 				for(int i=0;i<listCategory.length;i++){
// 				VcmsCategory category = (VcmsCategory)VcmsCategoryServiceUtil.getCategory(listCategory[i]);
				VcmsCategory category = (VcmsCategory)VcmsCategoryServiceUtil.getCategory(listCategory[0]);
				catURL.setParameter("categoryId", category.getCategoryId());				
			%>		
			
			<h2 class="wd-tlh1-2"><%=(Validator.isNotNull(typeId))? vType.getName() : category.getName() %></h2>						
				<%									
// 					}	      
				%>	
		<div class="wd-introduction">
			<%						
					for(int i=0;i<newestArticles.size();i++){
						VcmsArticle article = (VcmsArticle)newestArticles.get(i);                              		 		                                		 				
							PortletURL articleURL= PortletURLFactoryUtil.create(request,portletSelectId, plId, PortletRequest.RENDER_PHASE);
							articleURL.setParameter("jspPage", "/html/portlet/vcmsviewcontent/view.jsp");
							articleURL.setParameter("articleId", article.getArticleId());	
							List listCategories = VcmsCARelationServiceUtil.getRelationsByArticle(article.getArticleId());
							if(listCategories.size() >0){
								articleURL.setParameter("categoryId", ((VcmsCARelation)listCategories.get(0)).getCategoryId());
							}
							if(i==0){
					%>
					<div class="wd-intro-content">
					<%if(article.getHasImage() == false){ %>	
					<h3 class="wd-tlh3-2">
						<a href="<%=articleURL%>"><%=article.getTitle() %></a>
					</h3>
					<p class="wd-date">Ng&#224;y &#273;&#259;ng: <%=ActionUtil.dateParser(article.getPublishedDate()) %></p>
					<p><%=StringUtil.shorten(HtmlUtil.extractText(article.getContent()),200)%></p>
					<%}else{ %>
					<h3 class="wd-tlh3-2">
						<a href="<%=articleURL%>"><%=article.getTitle() %></a>
					</h3>
					<div class="wd-image wd-image-two">
						<img width="137" height="102" alt="" src="<%=themeDisplay.getPathImage() + "/images?img_id="+ article.getImage()%>">
					</div>
					<p><%=StringUtil.shorten(HtmlUtil.extractText(article.getContent()),200)%></p>
					<%} %>
				</div>	
				<h3 class="wd-tlh3-3">C&#225;c tin kh&#225;c</h3>
				<ul class="wd-other-news">						
					<%}else{ %>
					<li><a href="<%=articleURL%>"><%=article.getTitle() %>&nbsp;<span>(<%=ActionUtil.dateParser(article.getPublishedDate()) %>)</span></a></li>
					
					<%} %>
					
					<%
	}
%>				</ul>
			</div>
			<div class="wd-rss">
				<a class="link-read-more" href="<%= catURL%>">Xem ti&#7871;p</a>
			</div>

</div>
