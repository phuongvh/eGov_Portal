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

<%@page import="com.vportal.portlet.vfaq.service.FAQQuestionLocalServiceUtil"%>
<%@page import="com.vportal.portlet.vfaq.service.FAQCommentLocalServiceUtil"%>
<%@page import="com.vportal.portlet.vfaq.service.FAQCategoryLocalServiceUtil"%>
<%@page import="com.vportal.util.HtmlExt"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.vportal.portlet.vfaq.action.ActionUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.vportal.portlet.vfaq.service.FAQAnswerLocalServiceUtil"%>
<%@page import="com.vportal.portlet.vfaq.model.FAQQuestion"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.service.permission.PortletPermissionUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchEntry"%>
<%@page import="com.liferay.portal.kernel.dao.search.TextSearchEntry"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>

<%
	//count Qestion
	int unapprovedQuestion = FAQQuestionLocalServiceUtil.countQuestionByParam(groupId, language, 0, "", "", false);
	int approvedQuestion = FAQQuestionLocalServiceUtil.countQuestionByParam(groupId, language, 0, "", "", true);
	int numberOfQuestion = unapprovedQuestion + approvedQuestion;
	
	//count Answer
	int unapprovedAnswer = FAQAnswerLocalServiceUtil.countByParam(groupId, language, false, "", "", 0);
	int approvedAnswer = FAQAnswerLocalServiceUtil.countByParam(groupId, language, true, "", "", 0);
	int numberOfAnswer = unapprovedAnswer + approvedAnswer;
	
	//count Category
	int numberOfCategory = FAQCategoryLocalServiceUtil.countAll(groupId);
	
	//count Comments
	int numberOfComment = FAQCommentLocalServiceUtil.countAll(groupId);
	
	PortletURL aqURL = renderResponse.createRenderURL();	
	aqURL.setWindowState(WindowState.MAXIMIZED);
	aqURL.setParameter("jspPage", "/html/portlet/vfaq/view.jsp");	
	aqURL.setParameter("tabs1", "faq-question");
	aqURL.setParameter("tabs2", "approved");
	
	PortletURL uaqURL = renderResponse.createRenderURL();	
	uaqURL.setWindowState(WindowState.MAXIMIZED);
	uaqURL.setParameter("jspPage", "/html/portlet/vfaq/view.jsp");	
	uaqURL.setParameter("tabs1", "faq-question");
	uaqURL.setParameter("tabs2", "un-approved");
	
	PortletURL uaaURL = renderResponse.createRenderURL();	
	uaaURL.setWindowState(WindowState.MAXIMIZED);
	uaaURL.setParameter("jspPage", "/html/portlet/vfaq/view.jsp");	
	uaaURL.setParameter("tabs1", "faq-answer");
	uaaURL.setParameter("tabs2", "un-approved");
	
	PortletURL aaURL = renderResponse.createRenderURL();	
	aaURL.setWindowState(WindowState.MAXIMIZED);
	aaURL.setParameter("jspPage", "/html/portlet/vfaq/view.jsp");	
	aaURL.setParameter("tabs1", "faq-answer");
	aaURL.setParameter("tabs2", "approved");
	
	PortletURL catURL = renderResponse.createRenderURL();	
	catURL.setWindowState(WindowState.MAXIMIZED);
	catURL.setParameter("jspPage", "/html/portlet/vfaq/view.jsp");
	catURL.setParameter("tabs1", "faq-category");
	
	PortletURL coURL = renderResponse.createRenderURL();	
	coURL.setWindowState(WindowState.MAXIMIZED);
	coURL.setParameter("jspPage", "/html/portlet/vfaq/view.jsp");
	coURL.setParameter("tabs1", "faq-comment");
	
%>

<table border="0" cellpadding="4" cellspacing="0" width="100%">
<tr>
		<td align="left" width="50%" valign="top">
			<fieldset>
				<legend><%= LanguageUtil.get(pageContext, "com.vportal.portlet.vfaq.label") %></legend>
				<table border="0" cellpadding="4" cellspacing="0" width="100%" height="350px">
					<tr>
						<td align="left" width="1%" valign="middle">
							<img src="<%= themeDisplay.getPathThemeImage() %>/vcms/dot.gif" valign="middle" />
						</td>
						<td align="left" width="99%" valign="middle">
							<b><%= LanguageUtil.get(pageContext, "com.vportal.portlet.vfaq.statistics2") %></b>
						</td>
					</tr>
	
					<tr>
						<td align="left" width="1%" valign="middle">
							<img src="<%= themeDisplay.getPathThemeImage() %>/vcms/arrow.png" valign="middle" />
						</td>
						<td align="left" width="99%" valign="middle">
							<a href="<%=catURL%>"><%= LanguageUtil.get(pageContext, "com.vportal.portlet.vfaq.nCategory") %></a>: <b><%=numberOfCategory%></b>
						</td>
					</tr>
				
					<tr>
						<td align="left" width="1%" valign="middle">
							<img src="<%= themeDisplay.getPathThemeImage() %>/vcms/dot.gif" valign="middle" />
						</td>	
						<td align="left" width="99%" valign="middle">
							<b><%= LanguageUtil.get(pageContext, "com.vportal.portlet.vfaq.statistics") %></b>
						</td>
					</tr>
	
					<tr>
						<td align="left" width="1%" valign="middle">
							<img src="<%= themeDisplay.getPathThemeImage() %>/vcms/arrow.png" valign="middle" />
						</td>
						<td align="left" width="99%" valign="middle">
							<%= LanguageUtil.get(pageContext, "com.vportal.portlet.vfaq.nQuestions") %>: <b><%=numberOfQuestion%></b>
						</td>
					</tr>
	
					<tr>
						<td align="left" width="1%" valign="middle">
							<img src="<%= themeDisplay.getPathThemeImage() %>/vcms/arrow.png" valign="middle" />
						</td>
						<td align="left" width="99%" valign="middle">
							<a href="<%=aqURL%>"><%= LanguageUtil.get(pageContext, "com.vportal.portlet.vfaq.approvedQuestion") %></a>: <b><%=approvedQuestion%></b>
						</td>
					</tr>
					
					<tr>
						<td align="left" width="1%" valign="middle">
							<img src="<%= themeDisplay.getPathThemeImage() %>/vcms/arrow.png" valign="middle" />
						</td>
						<td align="left" width="99%" valign="middle">
							<a href="<%=uaqURL%>"><%= LanguageUtil.get(pageContext, "com.vportal.portlet.vfaq.unapprovedQuestion") %></a>: <b><%=unapprovedQuestion%></b>
						</td>
					</tr>
					
					<tr>
						<td align="left" width="1%" valign="middle">
							<img src="<%= themeDisplay.getPathThemeImage() %>/vcms/dot.gif" valign="middle" />
						</td>
						<td align="left" width="99%" valign="middle">
							<b><%= LanguageUtil.get(pageContext, "com.vportal.portlet.vfaq.statistics1") %></b>
						</td>
					</tr>
	
					<tr>
						<td align="left" width="1%" valign="middle">
							<img src="<%= themeDisplay.getPathThemeImage() %>/vcms/arrow.png" valign="middle" />
						</td>
						<td align="left" width="99%" valign="middle">
							<%= LanguageUtil.get(pageContext, "com.vportal.portlet.vfaq.nAnswer") %>: <b><%=numberOfAnswer%></b>
						</td>
					</tr>
	
					<tr>
						<td align="left" width="1%" valign="middle">
							<img src="<%= themeDisplay.getPathThemeImage() %>/vcms/arrow.png" valign="middle" />
						</td>
						<td align="left" width="99%" valign="middle">
							<a href="<%=aaURL%>"><%= LanguageUtil.get(pageContext, "com.vportal.portlet.vfaq.approvedQuestion") %></a>: <b><%=approvedAnswer%></b>
						</td>
					</tr>
					
					<tr>
						<td align="left" width="1%" valign="middle">
							<img src="<%= themeDisplay.getPathThemeImage() %>/vcms/arrow.png" valign="middle" />
						</td>
						<td align="left" width="99%" valign="middle">
							<a href="<%=uaaURL%>"><%= LanguageUtil.get(pageContext, "com.vportal.portlet.vfaq.unapprovedQuestion") %></a>: <b><%=unapprovedAnswer%></b>
						</td>
					</tr>
					
					<tr>
						<td align="left" width="1%" valign="middle">
							<img src="<%= themeDisplay.getPathThemeImage() %>/vcms/dot.gif" valign="middle" />
						</td>
						<td align="left" width="99%" valign="middle">
							<b><%= LanguageUtil.get(pageContext, "com.vportal.portlet.vfaq.statistics3") %></b>
						</td>
					</tr>
	
					<tr>
						<td align="left" width="1%" valign="middle">
							<img src="<%= themeDisplay.getPathThemeImage() %>/vcms/arrow.png" valign="middle" />
						</td>
						<td align="left" width="99%" valign="middle">
							<a href="<%=coURL%>"><%= LanguageUtil.get(pageContext, "com.vportal.portlet.vfaq.nComment") %></a>: <b><%=numberOfComment%></b>
						</td>
					</tr>
				
				</table>
			</fieldset>
		</td>
</tr>

</table>
