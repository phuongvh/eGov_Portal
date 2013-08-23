<%--/**
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
 */ --%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@ include file="/html/portlet/vclipmenu/init.jsp" %>
<script>
	//Save Preferences		
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
			submitForm(document.<portlet:namespace />fm,'<portlet:actionURL></portlet:actionURL>');
		}
	}
	
	function <portlet:namespace />changeTheme(styleObj) {
		if(styleObj)
			if(styleObj.value==3){				
				document.getElementById("<portlet:namespace/>themes_SBN").style.display = 'none';			
			}else if(styleObj.value==2){
				
				document.getElementById("<portlet:namespace/>themes_SBN").style.display = '';
			}
	}
		
</script>

<%		
	
	List selectPortletLayoutIds = (List)request.getAttribute("SELECT_PORTLET_LAYOUT_IDS");	

	if(selectPortletLayoutIds == null && Validator.isNotNull(layoutPortletId) && !layoutPortletId.equals("")){
		try{
			selectPortletLayoutIds = LayoutPortletUtil.getPortletIdsByLayout(Long.parseLong(layoutPortletId));
		}catch(Exception ex){
			System.out.println(ex.toString());
		}
	}
	String plid_layout = (String)request.getAttribute("PLID_LAYOUT");

	if(Validator.isNull(plid_layout)||(Validator.isNotNull(plid_layout) && plid_layout.equals("0"))){
		plid_layout = layoutPortletId;
		if(layoutPortletId.equals("") || layoutPortletId.equals("0") ){
			plid_layout = String.valueOf(layout.getPlid());
			selectPortletLayoutIds =  LayoutPortletUtil.getPortletIdsByLayout(layout.getPlid());
			portletSelectId = portletDisplay.getId();
					
		}
	}
	
	String strPortletIds = "";
			
	if((selectPortletLayoutIds == null) && Validator.isNotNull(portletIds)){
		String ids[] = StringUtil.split(portletIds,",");
		for(int i=0;i<ids.length;i++){
			selectPortletLayoutIds.add(ids[i]);
		}
		strPortletIds = portletIds;
	}	
	
	if(selectPortletLayoutIds != null && selectPortletLayoutIds.size()>0 && Validator.isNull(portletIds)){
		for(int i=0;i<selectPortletLayoutIds.size();i++){
			strPortletIds += selectPortletLayoutIds.get(i) + ",";
		}
	}
	
	if(Validator.isNull(selectPortletLayout) || Validator.isNotNull(ParamUtil.getString(request,"selectPortletLayout"))){
		selectPortletLayout = ParamUtil.getString(request,"selectPortletLayout");
	}
	
	String redirect = ParamUtil.getString(request, "redirect");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.MAXIMIZED);	
	portletURL.setParameter("jspPage", "/html/portlet/vclipmenu/edit.jsp");
	
%>

<form  action="<portlet:actionURL>
	</portlet:actionURL>" name="<portlet:namespace />fm" method="POST">	
	<input name="<portlet:namespace />redirect" type="hidden" value="<%= currentURL %>" />	
	<input name="<portlet:namespace />layoutIdSelected" type="hidden" value=""/>	
	<input name="<portlet:namespace />cmd" type="hidden" value="SELECT_LAYOUT"/>	
	<input name="<portlet:namespace />strPortletIds" type="hidden" value="<%=strPortletIds%>"/>	
	
	

<fieldset style="border:1px dotted gray;">
<legend><strong>C&#7845;u hình Portlet</strong></legend>
	
<table width="100%" border="0" cellpadding="4" cellspacing="1">
<tr>
	<td width="50%">
		<img src="/html/portlet/vlegaldraftmenu/images/editcopy.png"/> L&#7921;a ch&#7885;n Layout Tab <b>ch&#7913;a Portlet hi&#7875;n th&#7883; </b> :
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
		<img src="/html/portlet/vlegaldraftmenu/images/editcopy.png"/> L&#7921;a ch&#7885;n <b>Portlet Hi&#7875;n th&#7883;</b>:
	</td>
	<td>
		<select name="<portlet:namespace/>portletSelectId">
		<option value="0">---------</option>
			<%	if(selectPortletLayoutIds != null && selectPortletLayoutIds.size()>0){
				for(int count = 0; count<selectPortletLayoutIds.size();count++){
					String portletLayoutId = (String)selectPortletLayoutIds.get(count);
			%>
					<option value="<%=portletLayoutId%>" <%=(Validator.isNotNull(portletSelectId) && portletSelectId.equals(portletLayoutId))?"selected":""%>><%=portletLayoutId%></option>
			<%	}}%>
		</select>
	</td>
</tr>
</table>	
	
	
<table width="100%" cellspacing="1" cellpadding="4" border="0">	
<tr height="30">
	<td><b>Tùy bi&#7871;n tiêu &#273;&#7873; PORTLET:</b></td>
	<td><input type="text" name="<portlet:namespace/>titlePortlet" value="<%=titlePortlet%>" style="width:180px;"></td>
</tr>	

			
<tr><td colspan="2" height="5"></td></tr>
	
		

<tr><td colspan="2" height="5"></td></tr>			
</table>
</fieldset>	
				
<div class="portlet-font" style="font-weight:bold;float:left; margin-right:10px">
	<input type="button" class="portlet-form-button" value="<liferay-ui:message key="save" />" onClick="<portlet:namespace />savePreferences();"/>		
</div>
<br/><br/>		

</form>