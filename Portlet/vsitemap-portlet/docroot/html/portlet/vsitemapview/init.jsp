<%@ include file="/html/portlet/init.jsp" %>
<%@page import="com.vportal.portlet.vsitemap.model.*"%>
<%@page import="com.vportal.portlet.vsitemap.service.*"%>
<%@page import="com.vportal.portlet.vsitemap.util.*"%>
<%@ include file="/html/portlet/vsitemapview/css.jsp"%>
   
<%
	PortletPreferences prefs = renderRequest.getPreferences();

	String portletResource = ParamUtil.getString(request, "portletResource");

	if (Validator.isNotNull(portletResource)) {
		prefs = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}

	String language = ParamUtil.getString(request, "language", "vi_VN");
	long groupId = ParamUtil.getLong(request, "groupId",0);	
	if(groupId == 0){
		groupId = portletGroupId.longValue();
	}

	
	long questionId = GetterUtil.getLong(prefs.getValue("question-id", StringPool.BLANK));
	String titlePortlet = prefs.getValue("titlePortlet", "S&#417; &#273;&#7891; trang");
	
	String themeType = prefs.getValue("themeType","2");
	String themeSelected = prefs.getValue("themeSelected","");
	boolean isBorder = GetterUtil.getBoolean(prefs.getValue("isBorder",""), false);
	String bgcolor = prefs.getValue("bgcolor","#ffffff");
%>