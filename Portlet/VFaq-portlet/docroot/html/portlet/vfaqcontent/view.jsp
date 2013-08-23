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

<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/portlet/vfaqcontent/init.jsp"%>	

<!-- include jQuery library -->
<script type="text/javascript" src="/VFaq-portlet/js/jquery.min.js"></script>
<%	
	String redirect = ParamUtil.get(request, "redirect", currentURL);	
    String categoryId = ParamUtil.getString(request,"categoryId", StringPool.BLANK);
	String title = ParamUtil.getString(request,"title");
	String sentByUser = ParamUtil.getString(request,"sentByUser");
	String cmd = ParamUtil.getString(request, "cmd","");
	String clickValue = ParamUtil.getString(request, "clickValue","");
	String arrange = ParamUtil.getString(request, "arrange","");
	PortletURL searchURL = renderResponse.createRenderURL();
	searchURL.setParameter("jspPage", "/html/portlet/vfaqcontent/view.jsp");	
	searchURL.setParameter("language", language);		
	searchURL.setParameter("groupId", String.valueOf(groupId));
	searchURL.setParameter("cmd","searchBasic");
	
	List listQuestion = new ArrayList();
	List listOtherQuestion = new ArrayList();
	List listCategory = (List)FAQCategoryLocalServiceUtil.getCategoriesByG_L(groupId , language);
	
	String categoryTitle = LanguageUtil.get(pageContext,"com.vportal.portlet.vfaqcontent.list-question");
	int total = 0;
	
	if( Validator.isNotNull(categoryId) ||  cmd.equals("searchBasic")){
		total = FAQQuestionLocalServiceUtil.countQuestionByParam(groupId, language, Long.parseLong(categoryId),title,sentByUser,true);	
	}	else {
		total = FAQQuestionLocalServiceUtil.countApprovedQuestions(groupId);
	}	
	
	int pageSelected = ParamUtil.getInteger(request, "pageSelected",0);
	
	int numberPage = ParamUtil.getInteger(request, "pagenum", 1);
	if(Validator.isNotNull(pageSelected)&& pageSelected!=0){		
		numberPage = Integer.valueOf(pageSelected);
	}
	
	int per = Integer.parseInt(questionNumber);
	int pages = (total % per == 0) ? total / per : total / per + 1;
	int begin = per * (numberPage - 1);
	int end = (total>per * numberPage) ? per * numberPage : total;

	int beginOtherQuestion = end;
	int endOtherQuestion = ((end+per) >=total)? total:end+per;

	
	if( Validator.isNotNull(categoryId) ||  cmd.equals("searchBasic")){	
		listQuestion = FAQQuestionLocalServiceUtil.getQuestionByParam(groupId, language, Long.parseLong(categoryId), title, sentByUser, true, clickValue, arrange, begin, end);
	} else {
		
		listQuestion = FAQQuestionLocalServiceUtil.getApprovedQuestions(groupId,begin,end);
	} 

%>
<form method="post" class="vfaqView" name="<portlet:namespace />fm" >
<input type="hidden" name="<portlet:namespace/>cmd" value=""/>
<input name="<portlet:namespace />clickValue" type="hidden" value="<%=clickValue%>"/>
<input name="<portlet:namespace />arrange" type="hidden" value="<%=arrange%>"/>
<c:choose>
	<c:when test='<%= themeType.equals("1") %>'>
		<%@ include file="/html/portlet/vfaqcontent/Styles/style1.jsp" %>
	</c:when>
	<c:when test='<%= themeType.equals("2") %>'>
		<%@ include file="/html/portlet/vfaqcontent/Styles/style2.jsp" %>
	</c:when>
	<c:when test='<%= themeType.equals("3") %>'>
		<%@ include file="/html/portlet/vfaqcontent/Styles/style3.jsp" %>
	</c:when>
</c:choose>
</form>
	
<script language ="javascript">
	var clickValue;
	var arrange;

	function sortByField(val){
		 var arrayField = jQuery(val).attr("title").split('|');
		 var status = arrayField[0];
		 var field = arrayField[1];
		 status = (status*1);
		 if((status % 2) == 0){
		  status = (status -1);
		 }else{
		  status = (status + 1);
		 }
			jQuery(val).attr("title",status+'|'+field);
		 
		 return jQuery(val).attr("title");
	 
	}
	

	function <portlet:namespace/>submitForm(val){
		var a = document.<portlet:namespace />fm.<portlet:namespace />clickValue.value;
		a = (a * 1);
		var str = sortByField(val).split('|');
		arrange = str[1];
		if(a!=""){
			if((a % 2) == 0){
				  clickValue = a - 1;
				 }else{
				  clickValue = a + 1;
				 } 
		}else{
			clickValue = str[0];
		}
		document.<portlet:namespace />fm.<portlet:namespace />arrange.value = arrange;
		document.<portlet:namespace />fm.<portlet:namespace />clickValue.value = clickValue;
		submitForm(document.<portlet:namespace />fm, '<%= searchURL.toString() %>');
	}
	
	function <portlet:namespace/>submitForm(){
		var myform = document.<portlet:namespace />fm;
		myform.action="<%= searchURL.toString() %>";
		myform.submit();
	}
</script>
<script type="text/javascript">
	function <portlet:namespace />Submit() {				
		submitForm(document.<portlet:namespace/>fm, '<portlet:renderURL windowState="<%= WindowState.NORMAL.toString()%>">
				<portlet:param name = "jspPage" value = "/html/portlet/vfaqcontent/view.jsp" />				
				</portlet:renderURL>');
	}
	
</script>
	