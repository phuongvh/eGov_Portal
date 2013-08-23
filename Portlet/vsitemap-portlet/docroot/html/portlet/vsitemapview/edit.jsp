<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ include file="/html/portlet/vsitemapview/init.jsp" %>
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:actionURL name="processAction" var="processActionUrl"/>

<script language="javascript">	
	//Save Preferences		
	function <portlet:namespace />savePreferences() {
		var myform = document.<portlet:namespace />fm;
		myform.action="<%= processActionUrl.toString() %>";
		myform.method="post";
		myform.submit();
	};	
</script>

<%
	String redirect = ParamUtil.getString(request, "redirect");		
%>

<form name="<portlet:namespace />fm">
	<input name="<portlet:namespace />redirect" type="hidden" value="<%= currentURL %>" />	
	<input name="<portlet:namespace />cmd" type="hidden" value=""/>
	
<table  width="100%" cellspacing="1" cellpadding="4" border="0" >	
<tr>
	<td width="100%" valign="top">		
		<fieldset style="border:1px dotted gray;">
		<legend><strong>C&#7845;u hình Portlet</strong></legend>
		<table  class="lfr-table">	
		<tr height="30">
			<td><b>Tùy bi&#7871;n tiêu &#273;&#7873; :</b></td>
			<td><input type="text" name="<portlet:namespace/>titlePortlet" value="<%=titlePortlet%>" style="width:180px;"></td>
		</tr>
	
		<tr height="30">
			<td><b>Tùy bi&#7871;n theo THEMES</b></td>
			<td>
				<input type="radio" value="2" name="<portlet:namespace/>themeType" id="<portlet:namespace/>themeType_2" 
					<%=themeType.equals("2")?"checked":""%> >
					<label for="<portlet:namespace/>themeType_2">Themes các s&#7903; ban ngành</label>
				&nbsp;&nbsp;
				<input type="radio" value="3" name="<portlet:namespace/>themeType" id="<portlet:namespace/>themeType_3" 
					<%=themeType.equals("3")?"checked":""%> >
					<label for="<portlet:namespace/>themeType_3">Trang Doanh nghi&#7879;p, Ng&#432;&#7901;i dân, Du khách</label>
			</td>
		</tr>
					
		<tr><td colspan="2">&nbsp;</td></tr>				
	
		</fieldset>
	</td>
</tr>
</table>

<div class="portlet-font" style="font-weight:bold;float:left; margin-right:10px">
	<input type="button" class="portlet-form-button" value="<liferay-ui:message key="save" />" onClick="<portlet:namespace />savePreferences();"/>		
</div>
<br/><br/>
</form>
	