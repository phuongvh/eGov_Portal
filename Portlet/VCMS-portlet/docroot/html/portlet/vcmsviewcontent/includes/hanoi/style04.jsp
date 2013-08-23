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
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%	
	Calendar currentDate = new GregorianCalendar();
	
	int publishFromDay = ParamUtil.getInteger(request, "fromDay", curDay);
	int publishFromMonth = ParamUtil.getInteger(request, "fromMonth", curMonth);
	int publishFromYear = ParamUtil.getInteger(request, "fromYear", curYear-1);
	
	int publishToDay = ParamUtil.getInteger(request, "toDay", curDay);
	int publishToMonth = ParamUtil.getInteger(request, "toMonth", curMonth);
	int publishToYear = ParamUtil.getInteger(request, "toYear", curYear);	
	
	Date dateFrom  = new GregorianCalendar(publishFromYear, publishFromMonth-1, publishFromDay).getTime();
	Date dateTo = new GregorianCalendar(publishToYear, publishToMonth-1, publishToDay+1).getTime();
	
    String parentId = (String)session.getAttribute("CAT_PARENT_ID");
    String cmd = ParamUtil.getString(request, "cmd","");
    
    int numberPage = ParamUtil.getInteger(request, "pagenum",1); 
    int total = 0;
    
    if (cmd.equals("search")){    	
		total = VcmsArticleServiceUtil.countArticleByG_L_S_C_D(groupId, language, statusId, listCategory[0], dateFrom, dateTo);
	} else if(Validator.isNull(cmd)) {
		total = VcmsArticleServiceUtil.countAllCategoryArticles(groupId, language,listCategory[0],statusId);
	} 
	
	int pages = (total % numberArticlesInCat == 0) ? total / numberArticlesInCat : total / numberArticlesInCat + 1;
	int begin = numberArticlesInCat * (numberPage - 1);
	int end = (total>numberArticlesInCat * numberPage) ? numberArticlesInCat * numberPage : total;
	
	int beginNextPage = end;
	int endNextPage = ((end+numberArticlesNextInCat) >=total)? total:end+numberArticlesNextInCat;

	List listIntroArticle = new ArrayList();

	if(cmd.equals("search")){
		listIntroArticle = VcmsArticleServiceUtil.getArticleByG_L_S_C_D(groupId, language, statusId, listCategory[0], dateFrom, dateTo, begin, end);		
	} else {
		listIntroArticle = VcmsArticleServiceUtil.getAllCategoryArticles(groupId, language,listCategory[0],statusId,begin,end);
	}
	

    VcmsCategory category = (VcmsCategory) VcmsCategoryServiceUtil.getCategory(listCategory[0]);
    PortletURL catURL = PortletURLFactoryUtil.create(request,portletSelectId, plId, PortletRequest.RENDER_PHASE);
	catURL.setParameter("jspPage","/html/portlet/vcmsviewcontent/view.jsp" );
	catURL.setParameter("categoryId", category.getCategoryId());
	catURL.setParameter("cat_parent", parentId);
	catURL.setParameter("cat_style", categoryStyle);
	catURL.setParameter("cmd",cmd);
	
	PortletURL searchURL = renderResponse.createRenderURL();
	searchURL.setParameter("jspPage","/html/portlet/vcmsviewcontent/view.jsp" );
	searchURL.setParameter("categoryId", category.getCategoryId());
	searchURL.setParameter("cat_parent", parentId);	
	searchURL.setParameter("cmd","search");
	
%>
<%
	if(Validator.isNotNull(parentId) && !parentId.equals("0")){
		VcmsCategory vcmsCategoryImage = VcmsCategoryServiceUtil.getCategory(parentId);
%>
	<c:if test="<%=vcmsCategoryImage.getHasImage() %>">
		<div style="padding-bottom: 6px;">
			<img src="<%= themeDisplay.getPathImage() + "/images?img_id=" + vcmsCategoryImage.getImage() %>" border="0"/>
		</div>
	</c:if>
	
<%	
	}else{
%>
	<c:if test="<%=category.getHasImage() %>">
		<div style="padding-bottom: 6px;">
			<img src="<%= themeDisplay.getPathImage() + "/images?img_id=" + category.getImage() %>" border="0"/>
		</div>
	</c:if>
<%
	}
%>
<style>
	
	td.details a{
		color: #333333;
	}

	td.details a:hover{
	color: #0158E1;
	}
	
	.viewcategory{
		margin-left: 10px;
	}	
	
	.viewcategory div.s7img,.viewcategory div.s7content{ 
		float: left;
	}
	
	.viewcategory .s7img img{
		border: 5px solid #e8e8e8;
	}
	
	.viewcategory .s7content{
		height :170px;
		margin-left: 5px;	
		position: relative;	
	}
	
	.viewcategory .s7content h3{
		margin-top: 5px;
		color: #58ACF2;
	}
	
	.viewcategory .s7content a.text-link{
		 color: #2E6A9F;
    	 font-weight: bold;
    	 line-height: 18px;
    	 position: absolute;    	
    	 bottom: 0;   
    	 right: 0;	
    	 padding-right: 10px;
	}
	
	.viewcategory .s7content a.text-link:hover{
		color: #000066;
	}
	
	.viewcategory hr{
		border: 1px solid #e8e8e8;
	}
	
	.viewcategory i{
		color: #2E6A9F;
	    display: block;
	    font-size: 16px;
	    font-weight: bold;
	    padding: 5px 5px 5px 0;
	}
	
	.viewcategory p a:HOVER i{
		color: #58ACF2;
	}
	
	.viewcategory .othernews p b{
		font-size: 16px;
		padding-top: 5px;
		display: block;
	}
	
	.viewcategory .othernews .text_09{
		padding-bottom: 5px;
	}
		
	.paging {
    	padding: 5px;
	}
	
	.paging {
    	margin: 5px 0 10px;
	}
	
	.paging span a, .paging span a:link, .paging span a:visited {
	    background: -moz-linear-gradient(center top , #FFFFFF, #EFEFEF) repeat scroll 0 0 #F6F6F6;
	    border: 1px solid #CCCCCC;
	    color: #555555;
	    cursor: pointer;
	    display: block;
	    float: left;
	    margin-right: 5px;
	    padding: 4px 8px;
	    text-decoration: none;
	}
	
	.paging span a:hover, .paging span a.current {
	    background: -moz-linear-gradient(center top , #FFFFFF, #CCCCCC) repeat scroll 0 0 #CCCCCC;
	    border: 1px solid #888888;
	    color: #222222;
	    overflow: visible;
	}
</style>
<div>
	<form  method="post" name="<portlet:namespace />fm">
		<input type="hidden" name="<portlet:namespace/>cmd" value=""/>
		<!-- <div class="viewcategory" > -->
		<div class="wd-main-content">
		<div class="wd-boxs">
			<h2 class="wd-tlh1-2"><%= category.getName() %></h2>
			<!-- <div class="r-menu" style="margin-bottom: 5px;"></div> -->
			
			<div class="wd-introduction">
				<ul class="wd-communication"> 
					<%						
							for(int i=0;i<listIntroArticle.size();i++){
								VcmsArticle article = (VcmsArticle)listIntroArticle.get(i);                              		 		                                		 				
									PortletURL articleURL= PortletURLFactoryUtil.create(request,portletSelectId, plId, PortletRequest.RENDER_PHASE);
									articleURL.setParameter("jspPage", "/html/portlet/vcmsviewcontent/view.jsp");
									articleURL.setParameter("articleId", article.getArticleId());	
									List listCategories = VcmsCARelationServiceUtil.getRelationsByArticle(article.getArticleId());
									if(listCategories.size() >0){
										articleURL.setParameter("categoryId", ((VcmsCARelation)listCategories.get(0)).getCategoryId());
									}									
										
										%>
						
							<li>
					<c:if test="<%=article.getHasImage()%>">
							<div class="wd-intro-content" >									
								<h3 class="wd-tlh3-2"><a class="text-link" href="<%= articleURL%>"><%=article.getTitle() %></a></h3>				
								<div class="wd-image wd-image-two">
									<a href="<%=articleURL%>">
										<img height="160px" width="95%" alt="" src="<%=themeDisplay.getPathImage() + "/images?img_id="+ article.getImage()%>"/>
									</a>
								</div>		
								<p>								
									<%=StringUtil.shorten(HtmlUtil.extractText(article.getContent()),200)%>
								</p>
									
								<%-- <a class="text-link" href="<%= articleURL%>">
									<%= LanguageUtil.get(pageContext, "VCMS.viewdetail") %>
								</a> --%>
							</div>								
					</c:if>
					<c:if test="<%= (article.getHasImage() == false) %>">												
							<div class="wd-intro-content" >
								<h3 class="wd-tlh3-2"><a class="text-link" href="<%= articleURL%>"><%=article.getTitle() %></a></h3>
								<div class="wd-image wd-image-two"></div>					
								<p>								
									<%=StringUtil.shorten(HtmlUtil.extractText(article.getContent()),600)%>
								</p>
								
								<%-- <a class="text-link" href="<%= articleURL%>">
									<%= LanguageUtil.get(pageContext, "VCMS.viewdetail") %>
								</a> --%>
							</div>								
					</c:if>
					</li>
					<% } %>
				</ul>
		
<!-- 					<hr width="100%"/> -->
		<%	List listNextArticle = VcmsArticleServiceUtil.getAllCategoryArticles(groupId, language,listCategory[0],statusId,beginNextPage,endNextPage);															
					if (listNextArticle.size() > 0) {
						String titleArticle = ""; %>	
							
			<!-- othernews -->			
					<h3 class="wd-tlh3-3"><%= LanguageUtil.get(pageContext, "com.vportal.portlet.vcmsviewcontent.otherview") %></h3>												
					<ul class="wd-other-news">
						<%	for (int j = 0; j < listNextArticle.size(); j++) {
								VcmsArticle articleNew = (VcmsArticle)listNextArticle.get(j);
								
								/*
					 			titleArticle = articleNew.getTitle();                                        			
								int ch = 65;
								int space = 0;
								if(titleArticle.length()>ch){
									  space = titleArticle.indexOf(" ",ch);
									  if(space>0){
										  titleArticle = titleArticle.substring(0,space) + " ...";
									  }
								}
								*/
								
								PortletURL articleNewURL;
						
								articleNewURL = PortletURLFactoryUtil.create(request,portletSelectId, plId, PortletRequest.RENDER_PHASE);
								articleNewURL.setParameter("jspPage","/html/portlet/vcmsviewcontent/view.jsp" );
								articleNewURL.setParameter("articleId", articleNew.getArticleId());
								articleNewURL.setParameter("categoryId", category.getCategoryId());
								articleNewURL.setParameter("cmd", cmd);
								
								articleNewURL.setParameter("fromDay",String.valueOf(publishFromDay) );
								articleNewURL.setParameter("fromMonth", String.valueOf(publishFromMonth));
								articleNewURL.setParameter("fromYear", String.valueOf(publishFromYear));
								articleNewURL.setParameter("toDay",String.valueOf(publishToDay) );
								articleNewURL.setParameter("toMonth", String.valueOf(publishToMonth));
								articleNewURL.setParameter("toYear", String.valueOf(publishToYear));
						%>
					<li><a href="<%= articleNewURL %>"><%= articleNew.getTitle() %></a>&nbsp;<span>(<%=ActionUtil.dateParser(articleNew.getPublishedDate())%>)</span></li>
					<%	}}%>
					</ul>													
			
		</div>			
	
			<c:if test="<%=(pages>1)%>">
			<div class="wd-paging">
				<p class="sum-page">T&#7893;ng s&#7889; <%=total %> b&#224;i / <%=pages %> trang</p>
				<span>Trang:</span>
				
	                    <ul class="yiiPager">
	                    	                    	
	                    	
							<% 	
								if(pages > 0 && numberPage > 4 ){									
							%>	
							<li class="first">
								<a href="#" onclick="self.location = '<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>"> 
										<portlet:param name="jspPage" value="/html/portlet/vcmsviewcontent/view.jsp" />
										<portlet:param name="pagenum" value="<%= String.valueOf(1) %>" />	
										<portlet:param name="categoryId" value="<%= category.getCategoryId() %>" />	
										<portlet:param name="cat_parent" value="<%= parentId %>" />
										<portlet:param name="cmd" value="<%= cmd %>" />
										
										<portlet:param name="fromDay" value="<%= String.valueOf(publishFromDay) %>" />
										<portlet:param name="fromMonth" value="<%= String.valueOf(publishFromMonth) %>" />
										<portlet:param name="fromYear" value="<%= String.valueOf(publishFromYear) %>" />
										<portlet:param name="toDay" value="<%= String.valueOf(publishToDay) %>" />
										<portlet:param name="toMonth" value="<%= String.valueOf(publishToMonth) %>" />
										<portlet:param name="toYear" value="<%= String.valueOf(publishToYear) %>" />			

										</portlet:renderURL>';" ></a>
										
							</li>
							<% } %>
							<% 	if(numberPage >1){
								int intPrev = numberPage-1;%>
							
									<li class="previous">
										<a href="#" onclick="self.location = '<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>"> 
										<portlet:param name="jspPage" value="/html/portlet/vcmsviewcontent/view.jsp" />
										<portlet:param name="pagenum" value="<%= String.valueOf(intPrev) %>" />	
										<portlet:param name="categoryId" value="<%= category.getCategoryId() %>" />	
										<portlet:param name="cat_parent" value="<%= parentId %>" />
										<portlet:param name="cmd" value="<%= cmd %>" />
											
										<portlet:param name="fromDay" value="<%= String.valueOf(publishFromDay) %>" />
										<portlet:param name="fromMonth" value="<%= String.valueOf(publishFromMonth) %>" />
										<portlet:param name="fromYear" value="<%= String.valueOf(publishFromYear) %>" />
										<portlet:param name="toDay" value="<%= String.valueOf(publishToDay) %>" />
										<portlet:param name="toMonth" value="<%= String.valueOf(publishToMonth) %>" />
										<portlet:param name="toYear" value="<%= String.valueOf(publishToYear) %>" />
										</portlet:renderURL>';" ></a>
									</li>
		
							<%	}	%>	
							<% 
								for(int i = 1;i <= pages;i++){ 	
									if( i == numberPage ){%>
										<li class="page selected">
										<a href="#" class="current" onclick="self.location = '<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>"> 
										<portlet:param name="jspPage" value="/html/portlet/vcmsviewcontent/view.jsp" />
										<portlet:param name="pagenum" value="<%= String.valueOf(i) %>" />	
										<portlet:param name="categoryId" value="<%= category.getCategoryId() %>" />	
										<portlet:param name="cat_parent" value="<%= parentId %>" />
										<portlet:param name="cmd" value="<%= cmd %>" />
											
										<portlet:param name="fromDay" value="<%= String.valueOf(publishFromDay) %>" />
										<portlet:param name="fromMonth" value="<%= String.valueOf(publishFromMonth) %>" />
										<portlet:param name="fromYear" value="<%= String.valueOf(publishFromYear) %>" />
										<portlet:param name="toDay" value="<%= String.valueOf(publishToDay) %>" />
										<portlet:param name="toMonth" value="<%= String.valueOf(publishToMonth) %>" />
										<portlet:param name="toYear" value="<%= String.valueOf(publishToYear) %>" />
										</portlet:renderURL>';" ><%= i %></a>
									</li>
									
									<% }else if(i > numberPage-5 && i < numberPage || i > numberPage && i < numberPage+5){ %>
										
									<li class="page">
										<a href="#" onclick="self.location = '<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>"> 
										<portlet:param name="jspPage" value="/html/portlet/vcmsviewcontent/view.jsp" />
										<portlet:param name="pagenum" value="<%= String.valueOf(i) %>" />	
										<portlet:param name="categoryId" value="<%= category.getCategoryId() %>" />	
										<portlet:param name="cat_parent" value="<%= parentId %>" />
										<portlet:param name="cmd" value="<%= cmd %>" />
										
										<portlet:param name="fromDay" value="<%= String.valueOf(publishFromDay) %>" />
										<portlet:param name="fromMonth" value="<%= String.valueOf(publishFromMonth) %>" />
										<portlet:param name="fromYear" value="<%= String.valueOf(publishFromYear) %>" />
										<portlet:param name="toDay" value="<%= String.valueOf(publishToDay) %>" />
										<portlet:param name="toMonth" value="<%= String.valueOf(publishToMonth) %>" />
										<portlet:param name="toYear" value="<%= String.valueOf(publishToYear) %>" />		
										</portlet:renderURL>';" ><%= i %></a>
									</li>
							
							<% }} %>
							<% 	if(numberPage < pages){
								int intNext = numberPage + 1;%>
								<li class="next">
									 <a href="#" onclick="self.location = '<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>"> 
									<portlet:param name="jspPage" value="/html/portlet/vcmsviewcontent/view.jsp" />
									<portlet:param name="pagenum" value="<%= String.valueOf(intNext) %>" />	
									<portlet:param name="categoryId" value="<%= category.getCategoryId() %>" />	
									<portlet:param name="cat_parent" value="<%= parentId %>" />
									<portlet:param name="cmd" value="<%= cmd %>" />
										
									<portlet:param name="fromDay" value="<%= String.valueOf(publishFromDay) %>" />
									<portlet:param name="fromMonth" value="<%= String.valueOf(publishFromMonth) %>" />
									<portlet:param name="fromYear" value="<%= String.valueOf(publishFromYear) %>" />
									<portlet:param name="toDay" value="<%= String.valueOf(publishToDay) %>" />
									<portlet:param name="toMonth" value="<%= String.valueOf(publishToMonth) %>" />
									<portlet:param name="toYear" value="<%= String.valueOf(publishToYear) %>" />
									
									</portlet:renderURL>';" ></a>
								</li>
							<%	}  %>
							
							 <% 	
								if(pages > 10 && numberPage != pages){
							%>
									<li class="last">
										<a href="#" onclick="self.location = '<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>"> 
										<portlet:param name="jspPage" value="/html/portlet/vcmsviewcontent/view.jsp" />
										<portlet:param name="pagenum" value="<%= String.valueOf(pages) %>" />	
										<portlet:param name="categoryId" value="<%= category.getCategoryId() %>" />	
										<portlet:param name="cat_parent" value="<%= parentId %>" />
										<portlet:param name="cmd" value="<%= cmd %>" />
											
										<portlet:param name="fromDay" value="<%= String.valueOf(publishFromDay) %>" />
										<portlet:param name="fromMonth" value="<%= String.valueOf(publishFromMonth) %>" />
										<portlet:param name="fromYear" value="<%= String.valueOf(publishFromYear) %>" />
										<portlet:param name="toDay" value="<%= String.valueOf(publishToDay) %>" />
										<portlet:param name="toMonth" value="<%= String.valueOf(publishToMonth) %>" />
										<portlet:param name="toYear" value="<%= String.valueOf(publishToYear) %>" />
										</portlet:renderURL>';" ></a>
									</li>
							<% } %>
							</div>		
	                    
					</c:if>
					
		<c:if test="<%=isDisplayDate%>">
		<div style="background:#FFF8EB; padding:10px"><%= LanguageUtil.get(pageContext, "com.vportal.portlet.vcmsviewcontent.date_publish") %>
			<select class="day" name="<portlet:namespace/>fromDay">
			<%for(int i=1;i<=31;i++){%>
				<option value="<%=i%>" <%=(publishFromDay==i)?"selected":""%>><%=i%></option>
			<%}%>
			</select>
							
			<select class="day" name="<portlet:namespace/>fromMonth">
			<%for(int i=1;i<=12;i++){%>
				<option value="<%=i%>" <%=(publishFromMonth==i)?"selected":""%>><%=i%></option>
			<%}%>
			</select>
							
			<select class="day" name="<portlet:namespace/>fromYear">
			<%for(int i=2000;i<=2020;i++){%>
				<option value="<%=i%>" <%=(publishFromYear==i)?"selected":""%>><%=i%></option>
			<%}%>
			</select>
			<%= LanguageUtil.get(pageContext, "com.vportal.portlet.vcmsviewcontent.to_date") %>
							
			<select class="day" name="<portlet:namespace/>toDay">
			<%for(int i=1;i<=31;i++){%>
				<option value="<%=i%>" <%=(publishToDay==i)?"selected":""%>><%=i%></option>
			<%}%>
			</select>
							
			<select class="day" name="<portlet:namespace/>toMonth">
			<%for(int i=1;i<=12;i++){%>
				<option value="<%=i%>" <%=(publishToMonth==i)?"selected":""%>><%=i%></option>
			<%}%>
			</select>
							
			<select class="day" name="<portlet:namespace/>toYear">
			<%for(int i=2000;i<=2020;i++){%>
				<option value="<%=i%>" <%=(publishToYear==i)?"selected":""%>><%=i%></option>
			<%}%>
			</select>
			<input type="button" name="button" value="<%= LanguageUtil.get(pageContext, "com.vportal.portlet.vcmsviewcontent.find") %>" onclick="<portlet:namespace />submitForm();"/>
		</div>
	</c:if>
					
		</div>
					
		</div>
			
	</form>
</div>
																
<script language ="javascript">		
	function <portlet:namespace/>submitForm(){
		var myform = document.<portlet:namespace />fm;
		myform.action="<%= searchURL.toString() %>";
		myform.submit();
	}
</script>																