<%@ include file="/html/portlet/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.DateFormats"%>
<%@ page import="com.vportal.portlet.vcontact.*" %>
<%@ page import="com.vportal.portlet.vcontact.model.*" %>
<%@ page import="com.vportal.portlet.vcontact.model.impl.*" %>
<%@ page import="com.vportal.portlet.vcontact.action.*" %>
<%@ page import="com.vportal.portlet.vcontact.service.*" %>
<%@ page import="com.vportal.portlet.vcontact.service.impl.*" %>
<%@taglib uri="http://www.vietsoftware.com/tld" prefix="vportal" %>
<%@ page import="com.vportal.portlet.vcontact.util.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.vportal.portal.util.*" %>
<%@ page import="com.vportal.portal.model.*" %>
<%@ page import="com.vportal.portal.service.*" %>
<%@ page import="com.vportal.portal.attachment.AttachmentManager" %>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>	

	
	
	
<script language="javascript">
	function showErrorField(field) {
		field.style.border="2px solid red";
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
	DateFormat dateFormatDateTime = DateFormats.getDateTime(locale, timeZone);
	
	long groupId = ParamUtil.getLong(request, "groupId",0);	
	if(groupId == 0){
		groupId = portletGroupId.longValue();
	}
	boolean showButtons = false;	
	//boolean showTabs = false;
	if (portletConfig.getPortletName().equals(PortletKeysExt.VCONTACT)) {
		showButtons = true;	
	//	showTabs = true;
	}
    
	String tabs1 = ParamUtil.getString(request, "tabs1");
	
	String tabsNames = "VContact.title.received-pending,VContact.title.received,VContact.title.decline";
	
	int status = 0;
	if (tabs1.trim().equals("VContact.title.received")){
		status = 1;
	} else if (tabs1.trim().equals("VContact.title.decline")){
		status = 2;
	}	
%>