<%@ include file="/html/portlet/vcontact/init.jsp"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);	
	VContact bean = (VContact) row.getObject();
%>

<liferay-ui:icon-menu>
	<!-- Edit -->
	<portlet:renderURL windowState="<%=WindowState.MAXIMIZED.toString()%>"
		var="editURL">
	<portlet:param name="jspPage" value="/html/portlet/vcontact/edit.jsp" />
		<portlet:param name="cmd" value="showupdate" />
		<portlet:param name="redirect" value="<%=currentURL.toString()%>" />
		<portlet:param name="Id" value="<%=String.valueOf(bean.getId())%>" />
	</portlet:renderURL>
	<liferay-ui:icon image="edit" url="<%=editURL%>" />


	<!-- Permission -->

	<liferay-security:permissionsURL
		modelResource="<%=VContact.class.getName()%>"
		modelResourceDescription="<%=bean.getTitle()%>"
		resourcePrimKey="<%=String.valueOf(bean.getId())%>"
		var="permissionsURL" />
	<liferay-ui:icon image="permissions" url="<%=permissionsURL%>" />


	<!-- Delete -->

	<portlet:actionURL windowState="<%=WindowState.MAXIMIZED.toString()%>"
		var="deleteURL" name="_delete">
		<portlet:param name="cmd" value="dodelete" />
		<portlet:param name="redirect" value="<%=currentURL%>" />
		<portlet:param name="Ids" value="<%=Long.toString(bean.getId())%>" />
	</portlet:actionURL>
	<liferay-ui:icon image="delete" url="<%=deleteURL%>" />
	
</liferay-ui:icon-menu>

