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
<%@ include file="/html/portlet/vcmsviewcontent/init.jsp" %>
<%
	String categoryId = ParamUtil.getString(request, ConstantsExt.CATEGORY_ID);	

	String articleId = ParamUtil.getString(request, ConstantsExt.ARTICLE_ID);
	if(articleId.equalsIgnoreCase("0")){
		articleId = "";
	}
	String categoryStyle = (String)session.getAttribute("CATEGORY_STYLE");
	
	String strSelectedDisplayCats = (String)session.getAttribute("STR_DISPLAY_CATS_IN_CONTENT");
		
	String categoriesConfiguration = (String)session.getAttribute("SELETED_DISPLAY_CATS_IN_CONTENT");
	
	int displayStyle = GetterUtil.getInteger(prefs.getValue(ConstantsExt.DISPLAY_STYLE,"5"));
	
	int newsPerCat = GetterUtil.getInteger(prefs.getValue(ConstantsExt.NUMBER_OF_NEWS,"5"));
	
	int nextNewByCategory = GetterUtil.getInteger(prefs.getValue(ConstantsExt.NEXT_NEWS_BY_NEWEST,"5"));
	
	int numberArticlesInCat = GetterUtil.getInteger(prefs.getValue(ConstantsExt.NUMBER_ARTICLES_IN_CAT_DEFAULT,"5"));
	
	int numberArticlesNextInCat = GetterUtil.getInteger(prefs.getValue(ConstantsExt.NUMBER_ARTICLES_NEXT_IN_CAT_DEFAULT,"5"));
	
	int nextNewByOrder = GetterUtil.getInteger(prefs.getValue(ConstantsExt.NEXT_NEWS_BY_ORDER,"5"));
	
	int numberOfStickedNews = GetterUtil.getInteger(prefs.getValue(ConstantsExt.NUMBER_OF_STICKED_NEWS,"5"));
	
	String newestStyle = GetterUtil.getString(prefs.getValue("newestStyle",""));
		
	
	int articleDisplayInType = GetterUtil.getInteger(prefs.getValue("articleDisplayInType","5"));
	
	String displayDefaultCatId = GetterUtil.getString(prefs.getValue(ConstantsExt.IS_DISPLAY_DEFAULT_CATEGORY,"0"));
	
	String listCategory [] = displayDefaultCatId.split(",");	
	
	boolean pagingType = GetterUtil.getBoolean(prefs.getValue("pagingType","true"));
	
	boolean isDisplaySendEmail = GetterUtil.getBoolean(prefs.getValue(ConstantsExt.IS_DISPLAY_SEND_EMAIL,"false"));

	boolean isDisplayPrintArticle = GetterUtil.getBoolean(prefs.getValue(ConstantsExt.IS_DISPLAY_PRINT_ARTICLE,"false"));

	boolean isDisplayDiscussion = GetterUtil.getBoolean(prefs.getValue(ConstantsExt.IS_DISPLAY_DISCUSSION_ARTICLE,"false"));
	
	boolean isDisplayDate = GetterUtil.getBoolean(prefs.getValue("isDisplayDate","true"));
	
	String displayContent = prefs.getValue("displayContent","default");
	
	String catId = prefs.getValue("categoryId","");
	
	String typeId = prefs.getValue("typeId","");
	
	String defaultStyle = prefs.getValue("defaultStyle",""); // Style of View Default
	
	String tabsStyle = prefs.getValue("tabsStyle","");	// Style of View Tabs

	String stickyStyle = prefs.getValue("stickyStyle","");	// Style of View Sticky

	String typeStyle = prefs.getValue("typeStyle","");	// Style of View Article by Type
	
	//hoan
	int numberArticles = GetterUtil.getInteger(prefs.getValue(ConstantsExt.NUMBER_OF_ARTICLES,"5"));
	int numberArticlesDisplayImages = GetterUtil.getInteger(prefs.getValue(ConstantsExt.NUMBER_OF_ARTICLES_DISPLAY_IMAGES,"1"));
	boolean groupCategory = GetterUtil.getBoolean(prefs.getValue(ConstantsExt.GROUP_CATEGORYS, "true"));
	//hoan
	
%>
<script type="text/javascript">
	function <portlet:namespace/>displayRSS(catId){
		var url_view = "<portlet:renderURL windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>"><portlet:param name="jspPage" value="/html/portlet/vcmsviewcontent/view.jsp"  /><portlet:param name="cmd" value="PUBLISHED_RSS" /></portlet:renderURL>";
		url_view = url_view + "&categoryId="+catId;
		AjaxUtil.update(url_view, "<portlet:namespace/>display_content_rss");
	}
	
	function <portlet:namespace/>submitFormRSS(){
		document.<portlet:namespace/>fmRSS.action = "<portlet:actionURL><portlet:param name="jspPage" value="/html/portlet/vcmsviewcontent/rss.jsp" /></portlet:actionURL>";
		document.<portlet:namespace/>fmRSS.submit();
	}

</script>
<c:if test="<%=Validator.isNotNull(articleId)  && Validator.isNotNull(categoryId)%>">
	<%@ include file="/html/portlet/vcmsviewcontent/view_article.jspf" %>
</c:if>
	
<c:if test="<%=Validator.isNull(articleId) && Validator.isNull(categoryId)%>">
	<%@ include file="/html/portlet/vcmsviewcontent/view_overall.jspf" %>
	<%--@ include file="/html/portlet/vcmsviewcontent/category_view_default.jsp" --%>
</c:if>
	
<c:if test="<%=Validator.isNull(articleId) && Validator.isNotNull(categoryId)%>">
	<%@ include file="/html/portlet/vcmsviewcontent/view_category.jspf" %>
	<%--@ include file="/html/portlet/vcmsviewcontent/overall_view.jsp" --%>
</c:if>
		