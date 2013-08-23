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
/**
 * Copyright (c) 2000-2008 VSI, Inc. All rights reserved.
 *
**/
%>

<%@ include file="/html/portlet/vcmsviewnews/init.jsp" %>		

	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	  <tr>
		<td>
		<div class="other_new">
			<div class="other_new_bg">
			<marquee height="280" direction="up" scrollamount="2" scrolldelay="0" onmouseout="this.start()" onmouseover="this.stop()">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
			  <tr>
				<td>
			<%
			List listTopArticles = new ArrayList();
			if (Validator.isNotNull(portionId) && (portionId.indexOf("|") > 0)) {
				String[] ppIds = StringUtil.split(portionId, "|");
				if(ppIds[1].equals("0")){
				listTopArticles = VcmsArticleServiceUtil.getHotNewArticles(groupId , language ,  ppIds[0] , "",2,numberNextArticle);
				}else{
				listTopArticles = VcmsArticleServiceUtil.getHotNewArticles(groupId , language , "" , ppIds[1],2,numberNextArticle);
				}
			 }else{
			    listTopArticles = VcmsArticleServiceUtil.getArticlesByL_S(groupId , language , 2 , 0,numberNextArticle);
			 }
			for(int i=0;i<listTopArticles.size();i++){
				VcmsArticle nextArticle = (VcmsArticle)listTopArticles.get(i);
				
				VcmsCARelation category =VcmsCARelationServiceUtil.findRelationsByArticle(nextArticle.getArticleId());
				String categoryIdNext = "";
				if(category!= null){
					categoryIdNext = String.valueOf(category.getCategoryId());
				}
				PortletURL articleNewURL;
				articleNewURL = PortletURLFactoryUtil.create(request,portletSelectId, plId, PortletRequest.RENDER_PHASE);
				articleNewURL.setParameter("struts_action", "/vcmsviewcontent/view");
				articleNewURL.setParameter("articleId", nextArticle.getArticleId());
				articleNewURL.setParameter("categoryId", categoryIdNext);
				
			%>
				<div align="left" class="<%= (i==(listTopArticles.size()-1))?"other_new_bg2_last":"other_new_bg2" %>"><a href="<%=articleNewURL%>"><%=nextArticle.getTitle()%></a></div>
			<%
			}
			%>
				   </td>
			  </tr>
			</table>	
			</marquee>
			  
			</div>
		</div>
		   </td>
	  </tr>
	</table>	
		