<%@page import="com.vportal.portlet.vclip.util.LayoutPortletUtil"%>
<%@ page import="com.liferay.portal.kernel.util.DateFormatFactoryUtil" %>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@ page import="java.text.DateFormat" %>
<%@ page import="com.liferay.portal.kernel.util.DateUtil" %>
<%@page import="com.vportal.portlet.vclip.service.ClipTypeServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.vportal.portal.util.PortalUtilExt"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<jsp:directive.page import="com.liferay.portal.model.Portlet"/>
<jsp:directive.page import="javax.portlet.PortletURL"/>
<%@ page import="javax.portlet.PortletRequest" %>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="com.liferay.portlet.PortletPreferencesFactoryUtil" %>
<%@ include file="/html/portlet/init.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>


<portlet:defineObjects />

<jsp:directive.page import="java.util.List"/>
<jsp:directive.page import="com.vportal.portlet.vclip.util.WebKeysVClip"/>
<jsp:directive.page import="java.util.ArrayList"/>
<jsp:directive.page import="com.vportal.portlet.vclip.model.ClipType"/>
<jsp:directive.page import="com.liferay.portal.model.Portlet"/>
<jsp:directive.page import="com.liferay.portal.kernel.util.WebKeys"/>
<jsp:directive.page import="com.vportal.portlet.vclip.model.Clip"/>
<jsp:directive.page import="com.vportal.portlet.vclip.model.impl.ClipImpl"/>
<jsp:directive.page import="com.vportal.portlet.vclip.model.impl.ClipTypeImpl"/>
<jsp:directive.page import="com.liferay.portal.kernel.dao.search.SearchContainer"/>
<jsp:directive.page import="javax.portlet.PortletURL"/>
<jsp:directive.page import="com.liferay.portal.kernel.dao.search.ResultRow"/>
<jsp:directive.page import="com.vportal.portlet.vclip.service.ClipServiceUtil"/>
<%@ page import="javax.portlet.WindowState" %>

<portlet:actionURL windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>" var="increaseDownloadURL">
	<portlet:param name="struts_action" value="/vclipcontent/view" />
	<portlet:param name="<%= Constants.CMD %>" value="<%= WebKeysVClip.HITCOUNT %>" />
</portlet:actionURL>

<portlet:actionURL windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>" var="increaseviewURL">
	<portlet:param name="struts_action" value="/vclipcontent/view" />
	<portlet:param name="<%= Constants.CMD %>" value="<%= WebKeysVClip.HITCOUNTVIEW %>" />
</portlet:actionURL>
<liferay-theme:defineObjects/>

<script language="javascript"><!--

	function inceaseCounter(clipId) {
		
		url = "<%= increaseDownloadURL %>";
		url = url + "&clipId=" + clipId;
		jQuery("#").load(url);
		
		
	}
	function inceaseCounterview(clipId) {
		
		url = "<%= increaseviewURL %>";
		url = url + "&clipId=" + clipId;		
		jQuery("#").load(url);
			
	}
</script>

<%
 	DateFormat dateFormatDateTime = DateFormat.getDateTimeInstance();	
	PortletPreferences prefs = renderRequest.getPreferences();
	String portletResource = ParamUtil.getString(request, "portletResource");
	if(Validator.isNotNull(portletResource)){
		prefs = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
	String portletSelectId = prefs.getValue("portletSelectId","");
	String portletIds = prefs.getValue("portletIds","");
	String selectPortletLayout = prefs.getValue("selectPortletLayout","");	
	String titlePortlet = prefs.getValue("titlePortlet","Chuyên m&#7909;c");
	String language = ParamUtil.getString(request, "language", "vi_VN");
	List selectLayouts = (List)request.getAttribute("SELECT_LAYOUTS");	
	String displayStyle = prefs.getValue("displayStyle","");
	String allowDescription = prefs.getValue("allowDescription","false");
	String allowDownload = prefs.getValue("allowDownload","false");
	String displayClipNumber = prefs.getValue("displayClipNumber","9");	
	String layoutPortletId = prefs.getValue("layoutPortletId","");
	if(portletSelectId.equals("")){
	List ListportletSelectId = LayoutPortletUtil.getPortletIdsByLayout(Long.valueOf(plid));
	if(ListportletSelectId.size()>0){
	portletSelectId = (String)ListportletSelectId.get(0);}
	}


%>		
<link href="/vclip-portlet/html/portlet/vclipcontent/css/clip.css" rel="stylesheet" type="text/css" />