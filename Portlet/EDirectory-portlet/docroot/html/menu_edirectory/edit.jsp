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
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ include file="/html/menu_edirectory/init.jsp" %>	

<portlet:defineObjects />
<liferay-theme:defineObjects/>
<script type="text/javascript">
//Save preferences
	function <portlet:namespace />savePreferences() {
		var layoutPlId = document.<portlet:namespace />fm.<portlet:namespace />layoutPortletId.value;
		if(layoutPlId != "0"){	
			document.<portlet:namespace />fm.<portlet:namespace />layoutIdSelected.value = layoutPlId;					
		}
		submitForm(document.<portlet:namespace />fm, 
				'<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>"></portlet:actionURL>');
	}
	
	//Find Portlet Layout
	function <portlet:namespace/>findPortletLayout(){
		var layoutPlId = document.<portlet:namespace />fm.<portlet:namespace />layoutPortletId.value;
		if(layoutPlId != "0"){
			document.<portlet:namespace />fm.<portlet:namespace />layoutIdSelected.value = layoutPlId;
			document.<portlet:namespace />fm.<portlet:namespace />cmd = "SELECT_LAYOUT";
			submitForm(document.<portlet:namespace />fm,'<portlet:actionURL></portlet:actionURL>');
		}
	}
	

</script>

<% 
	
	//List selectLayouts = (List)request.getAttribute("SELECT_LAYOUTS");
	
// 	List selectLayouts = (List) renderRequest

	List selectPortletLayoutIds = (List)request.getAttribute("SELECT_PORTLET_LAYOUT_IDS");

	if(selectPortletLayoutIds == null && Validator.isNotNull(layoutPortletId)){
		try{
			selectPortletLayoutIds = LayoutPortletUtil.getPortletIdsByLayout(Long.parseLong(layoutPortletId));
		}catch(Exception ex){
		}
	}	
	String plid_layout = (String)request.getAttribute("PLID_LAYOUT");	

	if(Validator.isNull(plid_layout)||(Validator.isNotNull(plid_layout) && plid_layout.equals("0"))){
		plid_layout = layoutPortletId;
		if(portletSelectId.equals("")){
			plid_layout = String.valueOf( layout.getPlid());
			selectPortletLayoutIds =  LayoutPortletUtil.getPortletIdsByLayout(layout.getPlid());
			portletSelectId = portletDisplay.getId();

			}
	}
	
%>

<script type="text/javascript">
	function <portlet:namespace />saveConfiguration() {
		var layoutPlId = document.<portlet:namespace />fm.<portlet:namespace />layoutPortletId.value;
		if(layoutPlId != "0"){
			document.<portlet:namespace />fm.<portlet:namespace />layoutIdSelected.value = layoutPlId;
		}
		submitForm(document.<portlet:namespace />fm, '<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="jspPage" value="/html/menu_edirectory/edit.jsp" /></portlet:actionURL>');
	}
	
	function <portlet:namespace/>findPortletLayout(){
		var layoutPlId = document.<portlet:namespace />fm.<portlet:namespace />layoutPortletId.value;
		if(layoutPlId != "0"){
			document.<portlet:namespace />fm.<portlet:namespace />layoutIdSelected.value = layoutPlId;
		
			submitForm(document.<portlet:namespace />fm, '<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="jspPage" value="/html/menu_edirectory/edit.jsp" /></portlet:renderURL>');
		}
	}

</script>
<form  method="post" name="<portlet:namespace/>fm" >
<input name="<portlet:namespace />layoutIdSelected" type="hidden" value=""/>	
<input name="<portlet:namespace />cmd" type="hidden" value="SELECT_LAYOUT"/>
				
<fieldset>
<legend><b>C&#7845;u hình chung</b></legend>
<table width="100%" border="0" cellpadding="4" cellspacing="1">
<tr>
	<td width="50%">
		<img src="/vlegal-portlet/html/portlet/images/editcopy.png"/> L&#7921;a ch&#7885;n Layout Tab <b>ch&#7913;a Portlet Hi&#7875;n th&#7883; v&#259;n b&#7843;n pháp quy</b> :
	</td>
	<td>
		<select name="<portlet:namespace/>layoutPortletId" onchange="javascript:<portlet:namespace/>findPortletLayout();">
			<option value="0">---------</option>
			<%
			if(selectLayouts != null && selectLayouts.size()>0){
				for(int count = 0; count<selectLayouts.size();count++){
					Layout selectLayout = (Layout)selectLayouts.get(count);
			%>
					<option value="<%=selectLayout.getPlid()%>" <%=(Validator.isNotNull(plid_layout) && plid_layout.equals(String.valueOf(selectLayout.getPlid())))?"selected":""%>><%=selectLayout.getHTMLTitle(language)%></option>
			<%}
			}
			%>
		</select>
	</td>
</tr>
<tr>
	<td width="50%">
		<img src="/vlegal-portlet/html/portlet/images/editcopy.png"/> L&#7921;a ch&#7885;n <b>Portlet Hi&#7875;n th&#7883; v&#259;n b&#7843;n pháp quy</b>:
	</td>
	<td>
		<select name="<portlet:namespace/>portletSelectId">
			<%
				if(selectPortletLayoutIds != null && selectPortletLayoutIds.size()>0){
					for(int count = 0; count<selectPortletLayoutIds.size();count++){
						String portletLayoutId = (String)selectPortletLayoutIds.get(count);
			%>
							<option value="<%=portletLayoutId%>" <%=(Validator.isNotNull(portletSelectId) && portletSelectId.equals(portletLayoutId))?"selected":""%>><%=portletLayoutId%></option>
			<%
				}
			 }
			%>
		</select>
	</td>
</tr>
				

<tr><td colspan="2">&nbsp;</td></tr>
				
<tr>
	<td colspan="2">
		<table width="100%">
		<tr height="25">
			<td><b>Tùy bi&#7871;n tiêu &#273;&#7873; PORTLET</b></td>
			<td><input type="text" name="<portlet:namespace/>titlePortlet" value="<%=titlePortlet%>" style="width:200px;"></td>
		</tr>
</table>

</fieldset>
					
<br/>
<div class="portlet-font" style="font-weight:bold;float:left; margin-right:10px">		
	<input type="button" class="portlet-form-button" value="<liferay-ui:message key="save" />" onClick="<portlet:namespace />savePreferences();"/>		
</div>
<br/>
</form>

