
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

<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.service.permission.PortletPermissionUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@include file="/html/portlet/vfaq/init.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%
	ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	long id = 0;
	Object contentObj = row.getObject();
	String url = "/html/portlet/vfaq/edit_question.jsp";
	String parameter = "questionId";
	String className = FAQQuestion.class.getName();
	String description = "";
	
// 	boolean showAddAnswer = showButtons && PortletPermissionUtil.
// 	contains(permissionChecker , plid.longValue(), WebKeysExt.VFAQ, ActionKeysExt.ADD_ANSWER);	
%>	

<liferay-ui:icon-menu>
<c:choose>
	<c:when test='<%= tabs1.equals("faq-category") %>'>
		<% 
			FAQCategory content = (FAQCategory)contentObj;
			id = content.getId();
			url = "/html/portlet/vfaq/edit_category.jsp";
			parameter = "categoryId";
			className = FAQCategory.class.getName();
			description = content.getName();
		%>	
		
		<c:if test="<%= FAQCategoryPermission.contains(permissionChecker, themeDisplay.getPortletGroupId(), id, ActionKeys.UPDATE) %>">
			<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>" var="editURL">
				<portlet:param name="jspPage" value="<%= url %>" />
				<portlet:param name="<%= parameter %>" value="<%= Long.toString(id) %>" />
				<portlet:param name="tabs1" value="<%= tabs1 %>" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
			</portlet:renderURL>
			<liferay-ui:icon image="edit" url="<%= editURL %>" />
		</c:if>
					
		<c:if test="<%= permissionChecker.hasPermission(layout.getGroupId(), WebKeysExt.VFAQ, id, ActionKeys.DELETE) %>">
			<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>" var="deleteURL" name="deleteCategory">
				<portlet:param name="jspPage" value="<%= url %>" />
				<portlet:param name="<%= parameter %>" value="<%= Long.toString(id) %>" />
				<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE %>" />
				<portlet:param name="tabs1" value="<%= tabs1 %>" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
			</portlet:actionURL>
			<liferay-ui:icon-delete url="<%= deleteURL %>" />
		</c:if>

		<c:if test="<%= FAQCategoryPermission.contains(permissionChecker, themeDisplay.getPortletGroupId(), id, ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL 
			modelResource="<%= className %>" 
			modelResourceDescription='<%= "Check permission" %>' 
			resourcePrimKey="<%= String.valueOf(id) %>" 
			var="permissonURL" />
		<liferay-ui:icon image="permissions" url="<%= permissonURL %>" />
		</c:if>
	</c:when>

	<c:when test='<%= tabs1.equals("faq-comment") %>'>
		<% 
			FAQComment content = (FAQComment)contentObj;
			id = content.getId();
			url = "/html/portlet/vfaq/edit_comment.jsp";
			parameter = "commentId";
			className = FAQComment.class.getName();
			description = content.getApproveByUser();
		%>	

		<c:if test="<%= FAQCommentPermission.contains(permissionChecker, themeDisplay.getPortletGroupId(), id, ActionKeys.UPDATE) %>">
			<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>" var="editURL">
				<portlet:param name="jspPage" value="<%= url %>" />
				<portlet:param name="<%= parameter %>" value="<%= Long.toString(id) %>" />
				<portlet:param name="tabs1" value="<%= tabs1 %>" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
			</portlet:renderURL>
			<liferay-ui:icon image="edit" url="<%= editURL %>" />
		</c:if>
					
		<c:if test="<%= permissionChecker.hasPermission(layout.getGroupId(), WebKeysExt.VFAQ, id, ActionKeys.DELETE) %>">
			<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>" var="deleteURL" name="deleteComment">
				<portlet:param name="jspPage" value="<%= url %>" />
				<portlet:param name="<%= parameter %>" value="<%= Long.toString(id) %>" />
				<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE %>" />
				<portlet:param name="tabs1" value="<%= tabs1 %>" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
			</portlet:actionURL>
			<liferay-ui:icon-delete url="<%= deleteURL %>" />
		</c:if>

		<c:if test="<%= FAQCommentPermission.contains(permissionChecker, themeDisplay.getPortletGroupId(), id, ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL 
			modelResource="<%= className %>" 
			modelResourceDescription='<%= "Check permission" %>' 
			resourcePrimKey="<%= String.valueOf(id) %>" 
			var="permissonURL" />
		<liferay-ui:icon image="permissions" url="<%= permissonURL %>" />
		</c:if>

	</c:when>
	<c:when test='<%= tabs1.equals("faq-answer") %>'>
		<% 
			FAQAnswer content = (FAQAnswer)contentObj;
			id = content.getId();
			url = "/html/portlet/vfaq/edit_answer.jsp";
			parameter = "answerId";			
			className = FAQAnswer.class.getName();
			description = content.getAnsweredByUser();
		%>	

		<c:if test="<%= FAQAnswerPermission.contains(permissionChecker, themeDisplay.getPortletGroupId(), id, ActionKeys.UPDATE) %>">
			<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>" var="editURL">
				<portlet:param name="jspPage" value="<%= url %>" />
				<portlet:param name="<%= parameter %>" value="<%= Long.toString(id) %>" />				
				<portlet:param name="tabs1" value="<%= tabs1 %>" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
			</portlet:renderURL>
			<liferay-ui:icon image="edit" url="<%= editURL %>" />
		</c:if>
					
		<c:if test="<%= permissionChecker.hasPermission(layout.getGroupId(), WebKeysExt.VFAQ, id, ActionKeys.DELETE) %>">
			<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>" var="deleteURL" name="deleteAnswer">
				<portlet:param name="jspPage" value="<%= url %>" />
				<portlet:param name="<%= parameter %>" value="<%= Long.toString(id) %>" />
				<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE %>" />
				<portlet:param name="tabs1" value="<%= tabs1 %>" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
			</portlet:actionURL>
			<liferay-ui:icon-delete url="<%= deleteURL %>" />
		</c:if>

		<c:if test="<%= FAQAnswerPermission.contains(permissionChecker, themeDisplay.getPortletGroupId(), id, ActionKeys.PERMISSIONS) %>">
			<liferay-security:permissionsURL 
				modelResource="<%= className %>" 
				modelResourceDescription='<%= "Check permission" %>' 
				resourcePrimKey="<%= String.valueOf(id) %>" 
				var="permissonURL" />
			<liferay-ui:icon image="permissions" url="<%= permissonURL %>" />
		</c:if>

		<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>" var="replyURL">
			<portlet:param name="jspPage" value="/html/portlet/vfaq/edit_comment.jsp" />
			<portlet:param name="answerId" value="<%= Long.toString(id) %>" />
			<portlet:param name="tabs1" value="<%= tabs1 %>" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
		</portlet:renderURL>
		<liferay-ui:icon image="reply" url="<%= replyURL %>" message="<%= LanguageUtil.get(pageContext, \"pFAQ.form.postComment\") %>" />
	</c:when>
	<c:otherwise>
		<% 
		FAQQuestion content = (FAQQuestion)contentObj;
			id = content.getId();
			description = content.getTitle();
		%>
		
		
		<c:if test="<%= FAQQuestionPermission.contains(permissionChecker, themeDisplay.getPortletGroupId(), id, ActionKeys.UPDATE) %>">
			<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>" var="editURL">
				<portlet:param name="jspPage" value="<%= url %>" />
				<portlet:param name="<%= parameter %>" value="<%= Long.toString(id) %>" />
				<portlet:param name="tabs1" value="<%= tabs1 %>" />
				<portlet:param name="tabs2" value="<%= tabs2 %>" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
			</portlet:renderURL>
			<liferay-ui:icon image="edit" url="<%= editURL %>" />
		</c:if>
					
		<c:if test="<%= permissionChecker.hasPermission(layout.getGroupId(), WebKeysExt.VFAQ, id, ActionKeys.DELETE) %>">
			<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>" var="deleteURL" name="deleteQuestion">
				<portlet:param name="jspPage" value="<%= url %>" />
				<portlet:param name="<%= parameter %>" value="<%= Long.toString(id) %>" />
				<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE %>" />
				<portlet:param name="tabs1" value="<%= tabs1 %>" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
			</portlet:actionURL>
			<liferay-ui:icon-delete url="<%= deleteURL %>" />
		</c:if>

		<c:if test="<%= FAQQuestionPermission.contains(permissionChecker, themeDisplay.getPortletGroupId(), id, ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL 
			modelResource="<%= className %>" 
			modelResourceDescription='<%= "Check permission" %>' 
			resourcePrimKey="<%= String.valueOf(id) %>" 
			var="permissonURL" />
		<liferay-ui:icon image="permissions" url="<%= permissonURL %>" />
		</c:if>
		<c:if test="<%=showAddAnswer==true %>">
			<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>" var="replyURL">
				<portlet:param name="jspPage" value="/html/portlet/vfaq/edit_answer.jsp"/>
				<portlet:param name="questionId" value="<%= Long.toString(id) %>" />
				<portlet:param name="tabs1" value="<%= tabs1 %>" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
			</portlet:renderURL>
			<liferay-ui:icon image="reply" url="<%= replyURL %>" message="<%= LanguageUtil.get(pageContext, \"pFAQ.form.postAnswer\") %>" />
		</c:if>
		
		<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>" var="replyURL">
			<portlet:param name="jspPage" value="/html/portlet/vfaq/view.jsp" />
			<portlet:param name="questionId" value="<%= Long.toString(id) %>" />
			<portlet:param name="list_answer" value="view_list_answer_by_question"/>
			<portlet:param name="tabs1" value="faq-answer" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
		</portlet:renderURL>
		<liferay-ui:icon image="reply" url="<%= replyURL %>" message="Danh s&#225;ch c&#226;u tr&#7843; l&#7901;i" />
		
	</c:otherwise>
</c:choose>

</liferay-ui:icon-menu>