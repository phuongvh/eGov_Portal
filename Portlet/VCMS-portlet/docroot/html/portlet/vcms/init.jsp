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
<%@ include file="/html/portlet/init.jsp" %>
<%@ page import="com.vportal.portlet.vcms.*" %>
<%@ page import="com.vportal.portlet.vcms.model.*" %>
<%@ page import="com.vportal.portlet.vcms.action.*" %>
<%@ page import="com.vportal.portlet.vcms.service.*" %>
<%@ page import="com.vportal.portlet.vcms.service.impl.*" %>
<%@ page import="com.vportal.portlet.vcms.service.permission.*" %>
<%@ page import="com.vportal.portlet.vcms.job.*" %>
<%@ page import="com.vportal.portlet.vcms.util.*" %>
<%@ page import="com.vportal.portlet.vcms.service.VcmsTypeServiceUtil" %>
<%@ page import="com.liferay.portlet.polls.model.*" %>
<%@ page import="com.liferay.portlet.polls.service.*" %>
<%-- <%@ page import="com.vportal.portlet.polls.service.*" %> --%>
<%@ page import="com.vportal.portal.util.AttachmentUtil" %>
<%@ page import="com.vportal.portal.util.PortalUtilExt" %>
<%@ page import="com.vportal.portal.util.PortletKeysExt" %>
<%@ page import="com.vportal.portlet.vcms.util.PortletKeysVCMS" %>
<%@ page import="com.vportal.portal.util.PropsUtilExt" %>
<%@ page import="com.vportal.portal.util.ValidatorExt" %>
<%@ page import="com.vportal.portlet.vcms.service.VcmsPortionServiceUtil" %>
<%@ page import="com.vportal.portal.kernel.security.permission.*" %>
<%@ page import="com.vportal.portal.model.*" %>
<%@ page import="com.vportal.portal.service.*" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.vportal.portal.kernel.security.permission.ActionKeysExt" %>
<%@ taglib uri="http://www.vietsoftware.com/tld" prefix="vportal" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ include file="/html/portlet/vcms/css.jsp"%>  
<%@ page import="com.vportal.portlet.vcms.model.VcmsCategory"%>
<%@ page import="com.liferay.portal.service.GroupLocalServiceUtil" %>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.kernel.dao.search.TextSearchEntry"%>
<%
DateFormat dateFormatDateTime = DateFormats.getDateTime(locale, timeZone);
Locale[] locales = LanguageUtil.getAvailableLocales();

/* String language = ParamUtil.getString(request, "language", "vi_VN"); */
//hoan
String language = themeDisplay.getLanguageId();
//hoan
long groupId = ParamUtil.getLong(request, "groupId",0);
if(groupId == 0){
	groupId = portletGroupId.longValue();
}


String tabs1 = ParamUtil.getString(request, "tabs1");
String tabs2 = ParamUtil.getString(request, "tabs2", "0");
String tabs3 = ParamUtil.getString(request,"tabs3");
String portionId = ParamUtil.get(request, "portionId", StringPool.BLANK);
String parentId = ParamUtil.get(request, "parentId", StringPool.BLANK);

long typeId = ParamUtil.getLong(request,"typeId");

if (Validator.isNull(parentId)) {
	parentId = ActionUtil.DEFAULT_CATEGORY_ID;
}
boolean showTabs = false;
boolean showButtons = false;

if (portletConfig.getPortletName().equals("vcms")) {
	showTabs = true;
	showButtons = true;
}
long userId = PortalUtilExt.getUserId(request);
long companyId = PortalUtil.getCompanyId(request);

int maxArticleAttachment = GetterUtil.getInteger(VCMSUtil.getPrefsPropsUtil(companyId, PropsUtilExt.VCMS_ARTICLE_MAX_ATTACHMENT));
int maxDiscussionAttachment = GetterUtil.getInteger(VCMSUtil.getPrefsPropsUtil(companyId, PropsUtilExt.VCMS_DISCUSSION_MAX_ATTACHMENT));

boolean showTabStatistics = showTabs && PortletPermissionUtil.contains(permissionChecker , plid.longValue() , PortletKeysVCMS.VCMS , ActionKeysExt.VIEW_STATISTICS);
boolean showTabPortions = showTabs && PortletPermissionUtil.contains(permissionChecker , plid.longValue() , PortletKeysVCMS.VCMS , ActionKeysExt.VIEW_PORTIONS);
boolean showTabCategorys = showTabs && PortletPermissionUtil.contains(permissionChecker , plid.longValue() , PortletKeysVCMS.VCMS , ActionKeysExt.VIEW_CATEGORYS);
boolean showTabArticles = showTabs && PortletPermissionUtil.contains(permissionChecker , plid.longValue() , PortletKeysVCMS.VCMS , ActionKeysExt.VIEW_ARTICLES);
boolean showTabLogs = showTabs && PortletPermissionUtil.contains(permissionChecker , plid.longValue() , PortletKeysVCMS.VCMS , ActionKeysExt.VIEW_LOGS);
boolean showTabConfigs = showTabs && PortletPermissionUtil.contains(permissionChecker , plid.longValue() , PortletKeysVCMS.VCMS , ActionKeysExt.VIEW_CONFIG); 

boolean showAddStatus = showTabs && PortletPermissionUtil.contains(permissionChecker , plid.longValue() , PortletKeysVCMS.VCMS , ActionKeysExt.VIEW_STATUS);;
boolean showTabType = showTabs && PortletPermissionUtil.contains(permissionChecker , plid.longValue() , PortletKeysVCMS.VCMS , ActionKeysExt.VIEW_TYPE);
boolean showTabReport = showTabs && PortletPermissionUtil.contains(permissionChecker , plid.longValue() , PortletKeysVCMS.VCMS , ActionKeysExt.VIEW_REPORT);


	
boolean showTabReportCategory = true;
boolean showTabReportUser = true;
boolean showTabReportByDate = true;
boolean showTabReportByType = true;

boolean showArticlePublished = showTabs && PortletPermissionUtil.contains(permissionChecker , plid.longValue() , PortletKeysVCMS.VCMS , ActionKeysExt.VIEW_ARTICLES_PUBLISHED);
boolean showArticleOfType = showTabs && PortletPermissionUtil.contains(permissionChecker , plid.longValue() , PortletKeysVCMS.VCMS , "VIEW_ARTICLES_OF_TYPE");

int totalStatus = VcmsStatusLocalServiceUtil.countByGroupId(groupId);
List statusResults = VcmsStatusLocalServiceUtil.getByGroupId(groupId,0, totalStatus);

long statusId = 0;
try{
	VcmsStatus vcmsStatus = VcmsStatusLocalServiceUtil.getByC_G_A(companyId, groupId, true);
	statusId = vcmsStatus.getStatusId();
} catch(Exception ex){}

int readMessagesTotal = VcmsAttachedMessageServiceUtil.countByG_R(groupId, true);
int unreadMessagesTotal = VcmsAttachedMessageServiceUtil.countByG_R(groupId, false);
%>
