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

<%@page import="com.vportal.portlet.vpolls.util.WebKeysExt"%>
<%@page import="java.util.Iterator"%>
<%@ include file="/html/portlet/vpolls/init.jsp" %>
<%
	PollsQuestion question = (PollsQuestion)request.getAttribute(WebKeysExt.POLLS_QUESTION);
	List choices = (List)request.getAttribute("choices");
	//question = question.toEscapedModel();	
	String choiceId = (String)request.getAttribute("choiceId");
	System.out.println("question = " + question);
	System.out.println("ID = " + question.getQuestionId());
%>