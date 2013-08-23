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
<%@page import="com.vportal.portal.util.PropsUtilExt"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.vportal.portlet.vcms.service.VcmsTypeServiceUtil"%>
<%@page import="com.vportal.portlet.vcms.service.VcmsThreadServiceUtil"%>
<%@page import="com.vportal.portlet.vcms.service.VcmsCategoryServiceUtil"%>
<%@page import="com.vportal.portlet.vcms.service.VcmsPortionServiceUtil"%>
<%@page import="com.vportal.portlet.vcms.util.VCMSUtil"%>
<%@page import="com.vportal.portlet.vcms.service.VcmsDiscussionServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.vportal.portlet.vcms.service.VcmsArticleServiceUtil"%>
<%
	int draftArticles = VcmsArticleServiceUtil.countByStatus(groupId, language, 0);

/* 	int imageWidth = GetterUtil.getInteger(PrefsPropsUtil.getString(companyId, PropsUtilExt.VCMS_ARTICLE_THUMB_IMAGE_WIDTH), 100);
	int imageHeight = GetterUtil.getInteger(PrefsPropsUtil.getString(companyId, PropsUtilExt.VCMS_ARTICLE_THUMB_IMAGE_HEIGHT), 100); */
	
	int imageWidth = GetterUtil.getInteger(VCMSUtil.getPrefsPropsUtil(companyId, PropsUtilExt.VCMS_ARTICLE_THUMB_IMAGE_WIDTH), 100);

	int imageHeight = GetterUtil.getInteger(VCMSUtil.getPrefsPropsUtil(companyId, PropsUtilExt.VCMS_ARTICLE_THUMB_IMAGE_HEIGHT), 100);
	
	int unapprovedDiscussions = VcmsDiscussionServiceUtil.countByApproval(groupId, language, false);
	/* boolean autoApproveDiscussion = PrefsPropsUtil.getBoolean(companyId, PropsUtilExt.VCMS_DISCUSSION_AUTO_APPROVE); */
	boolean autoApproveDiscussion = VCMSUtil.getBooleanPrefsPropsUtil(companyId, PropsUtilExt.VCMS_DISCUSSION_AUTO_APPROVE);
	
	int categorizablePortions = VcmsPortionServiceUtil.countByCategorizable(groupId, true);
	int uncategorizablePortions = VcmsPortionServiceUtil.countByCategorizable(groupId, false);
	
	int numberOfCategories = VcmsCategoryServiceUtil.countByP_L(groupId, language);
	int numberOfThreads = VcmsThreadServiceUtil.countThreadsByP_L(groupId, language);
	int numberOfTypes = VcmsTypeServiceUtil.countTypesByS_L(groupId, language);
	
	//List attachedUnreadMessages = VcmsAttachedMessageServiceUtil.getMessagesUnread(false);
	PortletURL articleURL = renderResponse.createRenderURL();	
	articleURL.setWindowState(WindowState.MAXIMIZED);
	articleURL.setParameter("jspPage", "/html/portlet/vcms/view.jsp");
	articleURL.setParameter("tabs1", "portlet.vcms.tabs.article");	
	
	PortletURL catURL = renderResponse.createRenderURL();	
	catURL.setWindowState(WindowState.MAXIMIZED);
	catURL.setParameter("jspPage", "/html/portlet/vcms/view.jsp");
	catURL.setParameter("tabs1", "portlet.vcms.tabs.manage");
	catURL.setParameter("tabs2", "portlet.vcms.tabs.category");	
	
	PortletURL portionURL = renderResponse.createRenderURL();	
	portionURL.setWindowState(WindowState.MAXIMIZED);
	portionURL.setParameter("jspPage", "/html/portlet/vcms/view.jsp");	
	portionURL.setParameter("tabs1", "portlet.vcms.tabs.manage");
	portionURL.setParameter("tabs2", "portlet.vcms.tabs.portion");
	
	PortletURL discussionURL = renderResponse.createRenderURL();	
	discussionURL.setWindowState(WindowState.MAXIMIZED);
	discussionURL.setParameter("jspPage", "/html/portlet/vcms/view.jsp");
	discussionURL.setParameter("tabs1", "portlet.vcms.tabs.article");
	discussionURL.setParameter("tabs2", "portlet.vcms.tabs.articles.discussion");
	
	PortletURL threadURL = renderResponse.createRenderURL();	
	threadURL.setWindowState(WindowState.MAXIMIZED);
	threadURL.setParameter("jspPage", "/html/portlet/vcms/view.jsp");
	threadURL.setParameter("tabs1", "portlet.vcms.tabs.article");
	threadURL.setParameter("tabs2", "portlet.vcms.tabs.articles.thread");
	
	PortletURL configURL = renderResponse.createRenderURL();	
	configURL.setWindowState(WindowState.MAXIMIZED);
	configURL.setParameter("jspPage", "/html/portlet/vcms/view.jsp");
	configURL.setParameter("tabs1", "portlet.vcms.tabs.manage");
	configURL.setParameter("tabs2", "portlet.vcms.tabs.configuration");
	
	PortletURL typeURL = renderResponse.createRenderURL();	
	typeURL.setWindowState(WindowState.MAXIMIZED);
	typeURL.setParameter("jspPage", "/html/portlet/vcms/view.jsp");
	typeURL.setParameter("tabs1", "portlet.vcms.tabs.manage");
	typeURL.setParameter("tabs2", "portlet.vcms.tabs.type");
	
%>
<table border="0" cellpadding="4" cellspacing="0" width="100%">
	<tr>
		<td align="left" width="50%" valign="top">
			<fieldset>
				<legend><%= LanguageUtil.get(pageContext, "portlet.vcms.statistics.panel1.label") %></legend>
				<table border="0" cellpadding="4" cellspacing="0" width="100%" height="350px">
					<tr>
						<td align="left" width="1%" valign="middle">
							<img src="<%= themeDisplay.getPathThemeImage() %>/vcms/dot.gif" valign="middle" />
						</td>
						<td align="left" width="99%" valign="middle">
							<b><%= LanguageUtil.get(pageContext, "portlet.vcms.statistics.panel1.statistics") %></b>
						</td>
					</tr>
	
					<tr>
						<td align="left" width="1%" valign="middle">
							<img src="<%= themeDisplay.getPathThemeImage() %>/vcms/arrow.png" valign="middle" />
						</td>
						<td align="left" width="99%" valign="middle">
							<%= LanguageUtil.get(pageContext, "portlet.vcms.statistics.panel1.draft-article") %>: <b><%=draftArticles%></b>
						</td>
					</tr>
	
					<%	int countAticles = 0;
						if(totalStatus > 0)
							for(int i=0; i<totalStatus; i++){
								VcmsStatus status = (VcmsStatus) statusResults.get(i);
								
								countAticles = VcmsArticleServiceUtil.countByStatus(groupId, language, status.getStatusId());
								articleURL.setParameter("tabs2",String.valueOf(status.getStatusId()));
					%>
					<tr>
						<td align="left" width="1%" valign="middle">
							<img src="<%= themeDisplay.getPathThemeImage() %>/vcms/arrow.png" valign="middle" />
						</td>
						<td align="left" width="99%" valign="middle">
							<%if(permissionChecker.isOmniadmin()){%>
									<a href="<%=articleURL%>"><%= status.getName() %>:</a> <b><%=countAticles%></b>
							<%}else{%>
								<%= status.getName() %>: <b><%=countAticles%></b>
							<%}%>
						</td>						
					</tr>
					<%}%>	
				
					<tr>
						<td align="left" width="1%" valign="middle">
							<img src="<%= themeDisplay.getPathThemeImage() %>/vcms/arrow.png" valign="middle" />
						</td>
						<td align="left" width="99%" valign="middle">
							<%if(permissionChecker.isOmniadmin()){%>
								<a href="<%=threadURL%>"><%= LanguageUtil.get(pageContext, "portlet.vcms.statistics.panel1.threads") %>:</a> <b><%= numberOfThreads %></b>
							<%}else{%>
								<%= LanguageUtil.get(pageContext, "portlet.vcms.statistics.panel1.threads") %>: <b><%= numberOfThreads %></b>
							<%}%>	
						</td>
					</tr>
							
					<tr>
						<td align="left" width="1%" valign="middle">
							<img src="<%= themeDisplay.getPathThemeImage() %>/vcms/arrow.png" valign="middle" />
						</td>
						<td align="left" width="99%" valign="middle">
							<%if(permissionChecker.isOmniadmin()){%>
								<a href="<%=typeURL%>"><%= LanguageUtil.get(pageContext, "portlet.vcms.statistics.panel1.types") %>:</a> <b><%= numberOfTypes %></b>
							<%}else{%>
								<%= LanguageUtil.get(pageContext, "portlet.vcms.statistics.panel1.types") %>: <b><%= numberOfTypes %></b>
							<%}%>	
						</td>
					</tr>		
					<tr>
						<td align="left" width="1%" valign="middle">
							<img src="<%= themeDisplay.getPathThemeImage() %>/vcms/dot.gif" valign="middle" />
						</td>	
						<td align="left" width="99%" valign="middle">							
							<%if(permissionChecker.isOmniadmin()){%>
								<b><a href="<%=configURL%>"><%= LanguageUtil.get(pageContext, "portlet.vcms.statistics.panel1.configuration") %></a></b>
							<%}else{%>
								<b><%= LanguageUtil.get(pageContext, "portlet.vcms.statistics.panel1.configuration") %></b>	
							<%}%>
						</td>
					</tr>					
					
					<tr>
						<td align="left" width="1%" valign="middle">
							<img src="<%= themeDisplay.getPathThemeImage() %>/vcms/arrow.png" valign="middle" />
						</td>
						<td align="left" width="99%" valign="middle">
							<%= LanguageUtil.get(pageContext, "portlet.vcms.statistics.panel1.max-attachment") %>: <b><%= maxArticleAttachment %></b>
						</td>
					</tr>
					<tr>
						<td align="left" width="1%" valign="middle">
							<img src="<%= themeDisplay.getPathThemeImage() %>/vcms/arrow.png" valign="middle" />
						</td>
						<td align="left" width="99%" valign="middle">
							<%= LanguageUtil.get(pageContext, "portlet.vcms.statistics.panel1.max-dimension") %>: <b><%= imageWidth %> x <%= imageHeight %></b>
						</td>
					</tr>
				</table>
			</fieldset>
		</td>
		<td align="right" width="50%" valign="top">
			<fieldset>
				<legend><%= LanguageUtil.get(pageContext, "portlet.vcms.statistics.panel2.label") %></legend>
				<table border="0" cellpadding="4" cellspacing="0" width="100%" height="350px">
					<tr>
						<td align="left" width="1%" valign="middle">
							<img src="<%= themeDisplay.getPathThemeImage() %>/vcms/dot.gif" valign="middle" />
						</td>
						<td align="left" width="99%" valign="middle">							
							<%if(permissionChecker.isOmniadmin()){%>
								<b><a href="<%=discussionURL%>"><%= LanguageUtil.get(pageContext, "portlet.vcms.statistics.panel2.discussion") %></a></b>
							<%}else{%>
								<b><%= LanguageUtil.get(pageContext, "portlet.vcms.statistics.panel2.discussion") %></b>
							<%}%>
						</td>
					</tr>
					<tr>
						<td align="left" width="1%" valign="middle">
							<img src="<%= themeDisplay.getPathThemeImage() %>/vcms/arrow.png" valign="middle" />
						</td>
						<td align="left" width="99%" valign="middle">
							<%= LanguageUtil.get(pageContext, "portlet.vcms.statistics.panel2.unapproved-discussion") %>: <b><%= unapprovedDiscussions %></b>
						</td>
					</tr>
					<tr>
						<td align="left" width="1%" valign="middle">
							<img src="<%= themeDisplay.getPathThemeImage() %>/vcms/arrow.png" valign="middle" />
						</td>
						<td align="left" width="99%" valign="middle">
							<%= LanguageUtil.get(pageContext, "portlet.vcms.statistics.panel2.max-attachment") %>: <b><%= maxDiscussionAttachment %></b>
						</td>
					</tr>
					<tr>
						<td align="left" width="1%" valign="middle">
							<img src="<%= themeDisplay.getPathThemeImage() %>/vcms/arrow.png" valign="middle" />
						</td>
						<td align="left" width="99%" valign="middle">
							<%= LanguageUtil.get(pageContext, "portlet.vcms.statistics.panel2.auto-approve") %>: <b><font style="color: <%= autoApproveDiscussion ? "Red" : "Blue"%>"><%= autoApproveDiscussion ? LanguageUtil.get(pageContext, "yes") : LanguageUtil.get(pageContext, "no") %></font></b>
						</td>
					</tr>
					<tr>
						<td align="left" width="1%" valign="middle">
							<img src="<%= themeDisplay.getPathThemeImage() %>/vcms/dot.gif" valign="middle" />
						</td>
						<td align="left" width="99%" valign="middle">
							<%if(permissionChecker.isOmniadmin()){%>
								<b><a href="<%=portionURL%>"><%= LanguageUtil.get(pageContext, "portlet.vcms.statistics.panel2.portion") %></a></b>
							<%}else{%>
								<b><%= LanguageUtil.get(pageContext, "portlet.vcms.statistics.panel2.portion") %></b>
							<%}%>
						</td>
					</tr>
					<tr>
						<td align="left" width="1%" valign="middle">
							<img src="<%= themeDisplay.getPathThemeImage() %>/vcms/arrow.png" valign="middle" />
						</td>
						<td align="left" width="99%" valign="middle">
							<%= LanguageUtil.get(pageContext, "portlet.vcms.statistics.panel2.number-of-categorizable-portion") %>: <b><%= categorizablePortions + "/" + (uncategorizablePortions + categorizablePortions)%></b>
						</td>
					</tr>
					<tr>
						<td align="left" width="1%" valign="middle">
							<img src="<%= themeDisplay.getPathThemeImage() %>/vcms/arrow.png" valign="middle" />
						</td>
						<td align="left" width="99%" valign="middle">
							<%= LanguageUtil.get(pageContext, "portlet.vcms.statistics.panel2.number-of-uncategorizable-portion") %>: <b><%= uncategorizablePortions + "/" + (uncategorizablePortions + categorizablePortions)%></b>
						</td>
					</tr>
					<tr>
						<td align="left" width="1%" valign="middle">
							<img src="<%= themeDisplay.getPathThemeImage() %>/vcms/dot.gif" valign="middle" />
						</td>
						<td align="left" width="99%" valign="middle">							
							<%if(permissionChecker.isOmniadmin()){%>
								<b><a href="<%=catURL%>"><%= LanguageUtil.get(pageContext, "portlet.vcms.statistics.panel2.category") %></a></b>								
							<%}else{%>
								<b><%= LanguageUtil.get(pageContext, "portlet.vcms.statistics.panel2.category") %></b>								
							<%}%>
						</td>
					</tr>
					<tr>
						<td align="left" width="1%" valign="middle">
							<img src="<%= themeDisplay.getPathThemeImage() %>/vcms/arrow.png" valign="middle" />
						</td>
						<td align="left" width="99%" valign="middle">
							<%= LanguageUtil.get(pageContext, "portlet.vcms.statistics.panel2.number-of-category") %>: <b><%= numberOfCategories %></b>
						</td>
					</tr>
				</table>
			</fieldset>
		</td>
	</tr>
</table>