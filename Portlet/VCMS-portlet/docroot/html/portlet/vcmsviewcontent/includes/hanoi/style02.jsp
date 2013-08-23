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
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>



<div class="wd-boxs">				                        
			 <%
				  VcmsType vType = null;
	             if(Validator.isNotNull(typeId)){
	             	 vType = (VcmsType) VcmsTypeServiceUtil.getType(typeId);		                    	
	             }
				String catDefault="";
				PortletURL catURL = PortletURLFactoryUtil.create(request,portletSelectId, plId, PortletRequest.RENDER_PHASE);
				catURL.setParameter("jspPage","/html/portlet/vcmsviewcontent/view.jsp");
				VcmsCategory category = (VcmsCategory)VcmsCategoryServiceUtil.getCategory(listCategory[0]);
				catURL.setParameter("categoryId", category.getCategoryId());				
			%>		
			
			<h2 class="wd-tlh1-2"><%=(Validator.isNotNull(typeId))? vType.getName() : category.getName() %></h2>						
							  			
					
	<div class="wd-introduction wd-introduction-two">
		<div class="wd-testimonial-one <portlet:namespace/>wd-testimonial">
			<ul class="wd-entry">
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
								%>
									
								<%if(i%2==0 & i != 0){ %>
						</ul>									
						<ul class="wd-entry">
						<%} %>
							<%if(article.getHasImage()==true){ %>
								<li>
									<div class="wd-image"><a href="#"><img alt="" src="<%=themeDisplay.getPathImage() + "/images?img_id="+ article.getImage()%>" width="66" height="46" /></a></div>
									<a href="<%= articleURL%>"><%=i+1%>. &nbsp;<%=StringUtil.shorten(HtmlUtil.extractText(article.getTitle()),100)%></a>
								</li>
							<%}else{ %>
							<li><a href="<%= articleURL%>"><%=i+1%>. &nbsp;<%=StringUtil.shorten(HtmlUtil.extractText(article.getTitle()),100)%></a></li>	
							<%}}%>											
						</ul>										
		</div>
		<div class="wd-control-one <portlet:namespace/>wd-control">
			<a class="wd-prev" href="#">tr&#432;&#7899;c</a>
			<span>|</span>
			<a class="wd-next" href="#">ti&#7871;p</a>
		</div>
	</div>
</div>

<script>
$(document).ready(function($){	
	$('.<portlet:namespace/>wd-testimonial')
		.cycle({
			fx:    'fade',
			speed: 500, 
			timeout: 0,
			next:  '.<portlet:namespace/>wd-control a.wd-next', 
			prev:  '.<portlet:namespace/>wd-control a.wd-prev'	
	});
});
</script>


