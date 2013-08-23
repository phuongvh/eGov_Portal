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
<%@ include file="/html/portlet/vcounter/init.jsp" %>

<script language="javascript">	

	//Save Preferences		
	function <portlet:namespace />savePreferences() {
		submitForm(document.<portlet:namespace />fm, '<portlet:actionURL name="savePreferences" windowState="<%= WindowState.MAXIMIZED.toString() %>"></portlet:actionURL>');
		
	}	
	
	function <portlet:namespace />changeTheme(styleObj) {
		if(styleObj)
			if(styleObj.value==2){				
				document.getElementById("<portlet:namespace/>themes_SBN").style.display = 'none';			
			}else if(styleObj.value==1){
				
				document.getElementById("<portlet:namespace/>themes_SBN").style.display = '';
			}
	}
</script>

<%	
	String redirect = ParamUtil.getString(request, "redirect");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.MAXIMIZED);	
	portletURL.setParameter("jspPage", "/html/portlet/vcounter/edit.jsp");
%>	

<form  action="<portlet:actionURL><portlet:param name="struts_action" value="/vcounter/edit" />
	</portlet:actionURL>" name="<portlet:namespace />fm" method="POST">	
	
<table width="100%" cellspacing="0" cellpadding="0" border="0">
<tr>
	<td valign="top">
	<fieldset style="border:1px dotted gray;">
		<legend><strong>C&#7845;u hình Portlet</strong></legend>
		<table class="lfr-table" width="100%">
			<tr>
				<td colspan="3">Ch&#7885;n ki&#7875;u th&#7889;ng kê :</td>
			</tr>
			<tr><td colspan="3">&nbsp;</td></tr>
			<tr height="25">
				<td width="5">&nbsp;</td>
				<td width="10">
					<input type="radio" name="<portlet:namespace/>style" id="<portlet:namespace/>style_1" value="1" <%= style.equals("1")?"checked":"" %>/>				
				</td>
				<td><label for="<portlet:namespace/>style_1">S&#7889; l&#432;&#7907;ng truy c&#7853;p</label></td>
				
			</tr>
			<tr height="25">
				<td width="5">&nbsp;</td>
				<td width="10">
					<input type="radio" name="<portlet:namespace/>style" id="<portlet:namespace/>style_2" value="2" <%= style.equals("2")?"checked":"" %>/>
				</td>
				<td><label for="<portlet:namespace/>style_2">S&#7889; ng&#432;&#7901;i &#273;ang tr&#7921;c tuy&#7871;n</label></td>
			</tr>
			<tr height="25">
				<td width="5">&nbsp;</td>
				<td width="10">
					<input type="radio" name="<portlet:namespace/>style" id="<portlet:namespace/>style_3" value="3" <%= style.equals("3")?"checked":"" %>/>
				</td>
				<td><label for="<portlet:namespace/>style_3">S&#7889; th&#224;nh vi&#234;n tr&#7921;c tuy&#7871;n</label></td>
			</tr>
			
			<tr height="25">
				<td colspan="3">
				<table width="100%">
				<tr height="30">
					<td><b>Tùy bi&#7871;n tiêu &#273;&#7873; PORTLET</b></td>
					<td><input type="text" name="<portlet:namespace/>titlePortlet" value="<%=titlePortlet%>" style="width:200px;">
				</tr>											
				
				</table>
				</td>	
			</tr>		
		</table>	
	</fieldset>
	</td>
</tr>
</table>
	
<br/>
<div class="portlet-font" style="font-weight:bold;float:left; margin-right:10px">
	<input type="button" class="portlet-form-button" value="<liferay-ui:message key="save" />" onClick="<portlet:namespace />savePreferences();"/>		
</div>
<br/>
<br/>
	
</form>
							

