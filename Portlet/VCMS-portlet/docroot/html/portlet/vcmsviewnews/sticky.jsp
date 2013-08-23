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
<div id="fragment-1" class="title_search">
	<img src="<%= themeDisplay.getPathThemeImage() %>/HN_image/fragment-1.gif"/>
</div>
<div >
		
</div>
<div class="ctTab">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	  <tr>
		<td width="49%" style="padding: 10px 10px 10px 10px;">
		<%
		   List listTopArticles = VcmsArticleServiceUtil.getArticlesNewByL_S_S(groupId , language , 2 , true,4);
		    PortletURL articleNewURL= PortletURLFactoryUtil.create(request,portletSelectId, plId, PortletRequest.RENDER_PHASE);
			String categoryIdNext = "";
			if(listTopArticles.size()>0){
				VcmsArticle nextArticle = (VcmsArticle)listTopArticles.get(0);
				
				VcmsCARelation category =VcmsCARelationServiceUtil.findRelationsByArticle(nextArticle.getArticleId());
				if(category!= null){
					categoryIdNext = String.valueOf(category.getCategoryId());
				}
				articleNewURL.setParameter("struts_action", "/vcmsviewcontent/view");
				articleNewURL.setParameter("articleId", nextArticle.getArticleId());
				articleNewURL.setParameter("categoryId", categoryIdNext);
				String conetent = nextArticle.getLead();
				int ch=350;
				int space=0;
				if(conetent.length()>ch){
					  space=conetent.indexOf(" ",ch);
					  if(space>0){
						  conetent=conetent.substring(0,space);
					  }
				}
				
			%>
			 <table width="100%" border="0" cellspacing="0" cellpadding="0">
				  <tr>
						<td valign="top"> 
							<img src="<%= themeDisplay.getPathImage() + "/images?img_id=" + nextArticle.getImage()  %>" align="left"  height="195px" width="306px"/>
						</td>
				  </tr>
				  <tr>
						<td valign="top">
							 <div>						 	
							 	<div class="desc">
							 		<b><a href="<%=articleNewURL%>" style="padding-bottom:10px;" ><%=nextArticle.getTitle()%></a></b>
							 	</div> 
							   <div style="float:left;color:#000000;font:11px;font-weight:normal; text-align: justify;">
							      <%=conetent%>   	
								</div>
						      </div>
					  	</td>
				  </tr>
			</table> 
	       <%
		   }
		   %>
		   </td>		   
		 
		   <td valign="top" width="50%"> 
		      <table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						 <td>        
					        <div class="other_new2">
								<div class="other_new3">
								    <table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											  <td height="10">
											  </td>
										 </tr>
									 
									  <%
								   for(int i=1;i<listTopArticles.size();i++){
									 VcmsArticle nextArticle = (VcmsArticle)listTopArticles.get(i);
									 VcmsCARelation category =VcmsCARelationServiceUtil.findRelationsByArticle(nextArticle.getArticleId());
									if(category!= null){
										categoryIdNext = String.valueOf(category.getCategoryId());
									}
									 articleNewURL.setParameter("struts_action", "/vcmsviewcontent/view");
									 articleNewURL.setParameter("articleId", nextArticle.getArticleId());
									 articleNewURL.setParameter("categoryId", categoryIdNext);
									 int ch=300;
									int space=0;
									
									String title = nextArticle.getTitle();
									if(title.length()>ch){
										  space=title.indexOf(" ",ch);
									  if(space>0){
										  title=title.substring(0,space)+"...";
									  }
								}
								
								  if((i-1)%3==0){
								  
								 }
								 %>
								 	<tr>
										<td width="30%" align="left" valign="top">
										   <table width="100%" border="0" cellspacing="0" cellpadding="0">
												  <tr>
												  		<td colspan="3">
												  			<b><a style="font-size: 11px;" href="<%=articleNewURL%>"><%=title%></a></b>
												  		</td>
												  </tr>
												  <tr><td height="5"></td></tr>
												  <tr>
														<td align="left" valign="top"> 
															<img src="<%= themeDisplay.getPathImage() + "/images?img_id=" + nextArticle.getImage()  %>" height="60px" width="79px"/>
														</td>							  
													   <td width="5">													     
													   </td>							  
														<td align="left" valign="top"> 
														    <%=StringUtil.shorten(nextArticle.getLead(),180) %>
														</td>
												  </tr>
											</table>
										</td>
									</tr>
								 <%
								 	if(i < listTopArticles.size()-1){
								 %>
									<tr height="10" valign="middle">
										<td valign="middle" >
											<div class="textnone_01">
												
											</div>
											<br/>
										</td>
									</tr>
								<%
								 	}
								%>
									
								<%
								  if((i-1)%3==2){
								 
								 }
							 }
								 %>
								 <tr>
								  <td height="10">
								  </td>
								 </tr>
								</table>
							 </div> 
						</div>
					</td>
			</tr>
		</table>
	</td>
  </tr>	   
</table>
</div>