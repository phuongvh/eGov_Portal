<%@ include file="/html/portlet/init.jsp" %>

<%@ page import="com.vportal.portlet.vcontact.*" %>
<%@ page import="com.vportal.portlet.vcontact.model.*" %>
<%@ page import="com.vportal.portlet.vcontact.model.impl.*" %>
<%@ page import="com.vportal.portlet.vcontact.action.*" %>
<%@ page import="com.vportal.portlet.vcontact.service.*" %>
<%@ page import="com.vportal.portlet.vcontact.service.impl.*" %>
<%@ page import="com.vportal.portlet.vcontact.util.*" %>


<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>

<%@ page import="com.vportal.portal.util.*" %>
<%@ page import="com.vportal.portal.model.*" %>
<%@ page import="com.vportal.portal.service.*" %>
<%@ page import="java.util.*" %>

<script language="javascript">

	function showErrorField(field) {
		//field.style.border="2px solid red";
		field.focus();
	}
	function resetField(field) {
		field.style.border="1px solid #CCC";
	}
	
	function clearField(field){
		field.value = "";
	}	

</script>

<%
	
	PortletPreferences prefs = renderRequest.getPreferences();

	String portletResource = ParamUtil.getString(request, "portletResource");

	if (Validator.isNotNull(portletResource)) {
		prefs = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
 	
 	long groupId = ParamUtil.getLong(request, "groupId",0);
	if(groupId == 0){
		groupId = portletGroupId.longValue();
	}
	
	String g = prefs.getValue("styleBorder","");
	String styleBullet = prefs.getValue("styleBullet","");
	String styleTitle = prefs.getValue("styleTitle","");
	String styleContent = prefs.getValue("styleContent","");
	
	String themeType = prefs.getValue("themeType","1");
	String themeSelected = prefs.getValue("themeSelected","");
%>