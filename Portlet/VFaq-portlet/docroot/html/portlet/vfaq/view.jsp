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

<%@ include file="/html/portlet/vfaq/init.jsp" %>
<%
	String redirect = ParamUtil.getString(request, "redirect"); 	

	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("jspPage", "/html/portlet/vfaq/view.jsp");
	portletURL.setParameter("tabs1", tabs1);
	portletURL.setParameter("language", language);
	portletURL.setParameter("groupId", String.valueOf(groupId));
	portletURL.setWindowState(WindowState.MAXIMIZED);
	
	PortletURL redirectURL = renderResponse.createRenderURL();
	redirectURL.setParameter("jspPage", "/html/portlet/vfaq/view.jsp");
	redirectURL.setParameter("tabs1", tabs1);
	redirectURL.setParameter("tabs2", tabs2);
	redirectURL.setParameter("language", language);
	redirectURL.setParameter("groupId", String.valueOf(groupId));
	redirectURL.setWindowState(WindowState.MAXIMIZED);
	
	
	String tabNames = "faq-statistics,faq-question,faq-answer,faq-comment,faq-category,faq-report";
%>

<liferay-ui:tabs names="<%=tabNames%>" url="<%=portletURL.toString()%>" param="tabs1"/>  
    
<form action="<%= portletURL.toString() %>" method="post" name="<portlet:namespace />fm">
<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="" />
<input name="<portlet:namespace />tabs1" type="hidden" value="<%= tabs1 %>">
<input name="<portlet:namespace />tabs2" type="hidden" value="<%= tabs2 %>">
<input name="<portlet:namespace />tabs3" type="hidden" value="<%= tabs3 %>">	
<%-- <input name="<portlet:namespace />redirect" type="hidden" 
	value="<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>">
	<portlet:param name="jspPage" value="/html/portlet/vfaq/view.jsp"/>
	<portlet:param name="tabs1" value="<%= tabs1 %>" />
	<portlet:param name="tabs2" value="<%= tabs2 %>" />
	<portlet:param name="tabs3" value="<%= tabs3 %>" />
	</portlet:renderURL>"> --%>
	
<c:choose>
	<c:when test='<%= tabs1.equals("faq-question") %>'>
		<%@ include file="/html/portlet/vfaq/show_question.jsp" %>	
	</c:when>	
	<c:when test='<%= tabs1.equals("faq-answer") %>'>		
		<%@ include file="/html/portlet/vfaq/show_answer.jsp" %>
	</c:when>
	<c:when test='<%= tabs1.equals("faq-comment") %>'>
		<%@ include file="/html/portlet/vfaq/show_comment.jsp" %>	
	</c:when>
	<c:when test='<%= tabs1.equals("faq-category") %>'>	
		<%@ include file="/html/portlet/vfaq/show_category.jsp" %>	
	</c:when>
	<c:when test='<%= tabs1.equals("faq-report") %>'>	
		<%@ include file="/html/portlet/vfaq/report/show_report.jsp" %>	
	</c:when>
	<c:otherwise>	
		<%@ include file="/html/portlet/vfaq/show_statistics.jsp" %>
	</c:otherwise>
</c:choose>
</form>
	
<script type="text/javascript">
	function <portlet:namespace />deleteAnswer() {
		var listsChecked = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
		if(listsChecked != ""){	
			if (confirm('<%= LanguageUtil.get(pageContext, "pFAQ.title.confirm-delete-answer") %>')) {
				document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.DELETE %>";
				document.<portlet:namespace />fm.<portlet:namespace />deleteAnswerIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
				submitForm(document.<portlet:namespace />fm, "<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="jspPage" value="/html/portlet/vfaq/edit_answer.jsp" /><portlet:param name="redirect" value="<%= currentURL %>" /></portlet:actionURL>");
			}
		} else{
			alert("<%= LanguageUtil.get(pageContext, "portlet.vfaq.answer.listchecked.warning")%>");
		}	
	}
</script>	