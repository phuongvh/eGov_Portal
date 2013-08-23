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
<%@page import="com.liferay.portal.kernel.util.Validator"%>
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
			<%if(Validator.isNotNull(titlecategory)){ %>
			<h2 class="wd-tlh1-2"><%=titlecategory %></h2>
			<%}else{ %>	
			<h2 class="wd-tlh1-2"><%=(Validator.isNotNull(typeId))? vType.getName() : category.getName() %></h2>						
				<%	
			}
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
							<div class="wd-image">
								<img width="264" height="184" alt="" src="<%=themeDisplay.getPathImage() + "/images?img_id="+ article.getImage()%>">
							</div>
							<a href="<%=articleURL%>">
								<h3 class="wd-tlh3-1"><%=article.getTitle() %></h3>
							</a>
							<p><%=StringUtil.shorten(HtmlUtil.extractText(article.getContent()),150)%></p>
						</div>
						<ul class="wd-list-news">
						<% } else{if(i==2){%>
				<li class="wd-li-center">
				<%}else{ %>
				<li>
				<%} %>
				<a href="<%=articleURL%>">
					<img width="146" height="108" alt="" src="<%=themeDisplay.getPathImage() + "/images?img_id="+ article.getImage()%>">
					<span><%=StringUtil.shorten(HtmlUtil.extractText(article.getTitle()),150)%></span>
					</a>
				</li>
				<%
					}
						}				
				%>
				</ul>

	</div>
	<div class="wd-rss">
		<a class="link-rss" href="#">RSS</a>
		<a class="link-read-more" href="<%= catURL%>">Xem ti&#7871;p</a>
	</div>
</div>
