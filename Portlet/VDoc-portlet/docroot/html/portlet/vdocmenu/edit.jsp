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

<%@page import="com.vportal.portlet.vdoc.service.util.ActionUtil"%>
<%@page import="com.vportal.portlet.vdoc.service.vdocOrgServiceUtil"%>
<%@page import="com.vportal.portlet.vdoc.service.util.LayoutPortletUtil"%>

<%@page import="javax.portlet.ActionRequest"%>

<%@page import="com.vportal.portlet.vdoc.service.vdocFieldServiceUtil"%>
<%@ include file="/html/portlet/vdocmenu/init.jsp" %>

<%
	
	// layout
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
	
	PortletURL savePrefsURL = renderResponse.createActionURL();
	savePrefsURL.setParameter(ActionRequest.ACTION_NAME, "savePreferences");
%>

<script type="text/javascript">
	
	var cObjects = document.getElementsByName("<portlet:namespace />field");
	var cOrgs = document.getElementsByName("<portlet:namespace />org");
	var cOrgsHN = document.getElementsByName("<portlet:namespace />orgHN");
	
	function <portlet:namespace />savePreferences() {
		var fields = '';
		var orgs = '';
		var orgsHN = '';
		
		for (var i = 0; (cObjects != null) && (i < cObjects.length); i ++) {
			if (cObjects[i].checked) {
				fields += cObjects[i].value + ',';
			}
		}
		
		for (var j = 0; (cOrgs != null) && (j < cOrgs.length); j ++) {
			if (cOrgs[j].checked) {
				orgs += cOrgs[j].value + ',';
			}
		}
		
		for (var j = 0; (cOrgsHN != null) && (j < cOrgsHN.length); j ++) {
			if (cOrgsHN[j].checked) {
				orgsHN += cOrgsHN[j].value + '.';
			}
		}		
		
		document.<portlet:namespace />fm.<portlet:namespace />fields.value = fields;
		document.<portlet:namespace />fm.<portlet:namespace />orgs.value = orgs;
		document.<portlet:namespace />fm.<portlet:namespace />orgsHN.value = orgsHN;
		submitForm(document.<portlet:namespace />fm, '<%= savePrefsURL %>');
	}	
	
	function <portlet:namespace />changeTheme(styleObj) {
		if(styleObj)
			if(styleObj.value==1){
				document.getElementById("<portlet:namespace/>themes_DIENBIEN").style.display = '';
				document.getElementById("<portlet:namespace/>themes_SBN").style.display = 'none';
				document.getElementById("<portlet:namespace/>themes_ABC").style.display = 'none';
			}else if(styleObj.value==2){
				document.getElementById("<portlet:namespace/>themes_DIENBIEN").style.display = 'none';
				document.getElementById("<portlet:namespace/>themes_SBN").style.display = '';
				document.getElementById("<portlet:namespace/>themes_ABC").style.display = 'none';
			}else if(styleObj.value==3){
				document.getElementById("<portlet:namespace/>themes_DIENBIEN").style.display = 'none';
				document.getElementById("<portlet:namespace/>themes_SBN").style.display = 'none';
				document.getElementById("<portlet:namespace/>themes_ABC").style.display = '';
			}else if(styleObj.value==4){
				document.getElementById("<portlet:namespace/>themes_DIENBIEN").style.display = 'none';
				document.getElementById("<portlet:namespace/>themes_SBN").style.display = 'none';
				document.getElementById("<portlet:namespace/>themes_ABC").style.display = 'none';
			}
		}

	
	function <portlet:namespace/>selectPortleId(choice){
		if(choice == 1){
			jQuery("#<portlet:namespace/>choicePortletId").slideUp('fast');
		}else if(choice == 2){
			jQuery("#<portlet:namespace/>choicePortletId").slideDown('fast');
		}
	}	
	function <portlet:namespace/>findPortletLayout(){
		var layoutPlId = document.<portlet:namespace />fm.<portlet:namespace />layoutPortletId.value;
		if(layoutPlId != "0"){
			document.<portlet:namespace />fm.<portlet:namespace />layoutIdSelected.value = layoutPlId;
			submitForm(document.<portlet:namespace />fm,'<portlet:actionURL></portlet:actionURL>');
		}
	}
		
	function <portlet:namespace />changeStyle(styleObj) {
		if(styleObj)
			if(styleObj.value==1){
				document.getElementById("<portlet:namespace/>style-01").style.display = '';
				document.getElementById("<portlet:namespace/>style-02").style.display = 'none';
				document.getElementById("<portlet:namespace/>style-03").style.display = 'none';
				document.getElementById("<portlet:namespace/>style-04").style.display = 'none';
			}else if(styleObj.value==2){
				document.getElementById("<portlet:namespace/>style-01").style.display = 'none';
				document.getElementById("<portlet:namespace/>style-02").style.display = '';
				document.getElementById("<portlet:namespace/>style-03").style.display = 'none';
				document.getElementById("<portlet:namespace/>style-04").style.display = 'none';
			}else if(styleObj.value==3){
				document.getElementById("<portlet:namespace/>style-01").style.display = 'none';
				document.getElementById("<portlet:namespace/>style-02").style.display = 'none';
				document.getElementById("<portlet:namespace/>style-03").style.display = '';
				document.getElementById("<portlet:namespace/>style-04").style.display = 'none';
			}else if(styleObj.value==4){
				document.getElementById("<portlet:namespace/>style-01").style.display = 'none';
				document.getElementById("<portlet:namespace/>style-02").style.display = 'none';
				document.getElementById("<portlet:namespace/>style-03").style.display = 'none';
				document.getElementById("<portlet:namespace/>style-04").style.display = '';
			}
	}	

</script>
	
<%
		List listField = (List)vdocFieldServiceUtil.getFieldByG_L_P(groupId, language, "0");
		
		List listOrg = (List)vdocOrgServiceUtil.getOrgByG_L_P(groupId, language, "0");

%>
<form name="<portlet:namespace />fm" Method="post" >	
	<input name="<portlet:namespace />fields" type="hidden" value=""/>	
	<input name="<portlet:namespace />fieldsChecked" type="hidden" value="<%=fields%>"/>
	<input name="<portlet:namespace />orgs" type="hidden" value=""/>	
	<input name="<portlet:namespace />orgsChecked" type="hidden" value="<%=orgs%>"/>
	<input name="<portlet:namespace />orgsHN" type="hidden" value=""/>	
	<input name="<portlet:namespace />orgsHNChecked" type="hidden" value="<%=orgsHN%>"/>


<fieldset style="border:1px dotted gray;">

	<legend><strong>C&#7845;u hình PORTLET</strong></legend>	
<table width="100%" border="0" cellpadding="4" cellspacing="1">
<tr>
	<td width="50%">
		<img src="/vimagegallery-portlet/html/portlet/vimagegallerymenu/images/vlegal/edit.gif"/> L&#7921;a ch&#7885;n Layout Tab <b>ch&#7913;a Portlet Hi&#7875;n th&#7883; &#7843;nh</b> :
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
		<img src="/vimagegallery-portlet/html/portlet/vimagegallerymenu/images/vlegal/edit.gif"/> L&#7921;a ch&#7885;n <b>Portlet Hi&#7875;n th&#7883; &#7843;nh</b>:
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
</table>

<table width="100%" border="0" cellpadding="4" cellspacing="1">
						
<tr><td>&nbsp;</td></tr>
	
<tr>
	<td>
	<table width="100%" border="0" cellpadding="4" cellspacing="1">
	<tr height="30">
		<td>
			<b>Tuy bien tieu de</b>&nbsp;&nbsp;<input type="text" name="<portlet:namespace />title" value="<%=title%>" style="width:250px;"/></td>
	</tr>
	
	<tr height="30">
		<td>
			<b>Tuy bien URL</b>&nbsp;&nbsp;<input type="text" name="<portlet:namespace />url" value="<%=url%>" style="width:250px;"/></td>
	</tr>
	
	
	<tr height="30">
		<td>
			<b>Chon kieu hien thi Portlet</b></td>
	</tr>
		
	<tr height="30">	
		<td>
			<table width="100%">
			<tr>
				<td><input type="radio" name="<portlet:namespace/>styleDisplay" id="<portlet:namespace/>style_1" 
					value="1" <%=(styleDisplay==1)?"checked":""%> onchange="<portlet:namespace />changeStyle(this)"></td>
				<td><label for="<portlet:namespace/>style_1">Thu tuc moi nhat</label></td>
			</tr>
			<tr>
				<td><input type="radio" name="<portlet:namespace/>styleDisplay" id="<portlet:namespace/>style_2" 
					value="2" <%=(styleDisplay==2)?"checked":""%> onchange="<portlet:namespace />changeStyle(this)"></td>
				<td><label for="<portlet:namespace/>style_2">Hien thi theo linh vuc</label></td>
			</tr>
			<tr>
				<td><input type="radio" name="<portlet:namespace/>styleDisplay" id="<portlet:namespace/>style_3" 
					value="3" <%=(styleDisplay==3)?"checked":""%> onchange="<portlet:namespace />changeStyle(this)"></td>
				<td><label for="<portlet:namespace/>style_3">Hien thi theo don vi/to chuc</label></td>
			</tr>
			<tr>
				<td><input type="radio" name="<portlet:namespace/>styleDisplay" id="<portlet:namespace/>style_4" 
					value="4" <%=(styleDisplay==4)?"checked":""%> onchange="<portlet:namespace />changeStyle(this)"></td>
				<td><label for="<portlet:namespace/>style_4">Hanoi6.1</label></td>
			</tr>
			</table>		
		</td>
	</tr>
		
	<tr><td>&nbsp;</td></tr>	
	</table>
	</td>
</tr>	
</table>

<div id="<portlet:namespace/>style-01" <%= (styleDisplay==1)?"":"style=\"display:none\"" %>>
	<table width="100%" cellspacing="1" cellpadding="0" border="0" >
	<tr>
		<td width="30%">So thu tuc duoc hien thi</td>
		<td>
			<select name="<portlet:namespace />documentPerPortlet" style="width:50px">
			<%	for(int i=5; i< 30;i=i+5){	%>
				<option value="<%=i%>" <%= (documentPerPortlet == i )? "selected":"" %>><%=i%></option>
			<%	}  %>
			</select>
		</td>
	</tr>
				
	<tr>
		<td width="20%">Thu tuc duoc xuat ban cach day</td>
		<td>
			<select name="<portlet:namespace/>period">
				<option value="1" <%= (period==1) ? "selected":""%>>1 tháng</option>
				<option value="3" <%= (period==3) ? "selected":""%>>3 tháng</option>
				<option value="6" <%= (period==6) ? "selected":""%>>6 tháng</option>
				<option value="12" <%= (period==12) ? "selected":""%>>12 tháng</option>
			</select>
		</td>
	</tr>	
	</table>
</div>
			
<div id="<portlet:namespace/>style-02" <%= (styleDisplay==2)?"":"style=\"display:none\"" %>>
	<table width="100%" cellspacing="1" cellpadding="0" border="0" >
	<tr height="30">
		<td><b>Chon linh vuc hien thi</b></td>
	</tr>
	<tr><td>
		<%=	ActionUtil.getFieldCheckbox(listField, renderResponse.getNamespace())%>
	</td></tr>
	</table>
</div>
	
<div id="<portlet:namespace/>style-03" <%= (styleDisplay==3)?"":"style=\"display:none\"" %>>
	<table width="100%" cellspacing="1" cellpadding="0" border="0" >
	<tr height="30">
		<td><b>Chon don vi / to chuc hien thi</b></td>
	</tr>
	<tr><td>
		<%=	ActionUtil.getOrgCheckbox(listOrg, renderResponse.getNamespace())%>
	</td></tr>
	</table>
</div>	
			
<div id="<portlet:namespace/>style-04" <%= (styleDisplay==4)?"":"style=\"display:none\"" %>>
	<table width="100%" cellspacing="1" cellpadding="0" border="0" >
	<tr height="30">
		<td><b>Hanoi6.1</b></td>
	</tr>
	<tr><td>
		<%=	ActionUtil.getOrgCheckboxHN(listOrg, renderResponse.getNamespace())%>
	</td></tr>
	</table>
</div>		
<br/>

</fieldset>
<br/>		
<div class="portlet-font" style="font-weight:bold;float:left; margin-right:10px">
	<input type="button" value="Save" onClick="<portlet:namespace />savePreferences();">		
</div>
<br/>			
</form>
	
<script type="text/javascript">
	var fieldsChecked = document.<portlet:namespace />fm.<portlet:namespace />fieldsChecked.value;
	var orgsChecked = document.<portlet:namespace />fm.<portlet:namespace />orgsChecked.value;
	var orgsHNChecked = document.<portlet:namespace />fm.<portlet:namespace />orgsHNChecked.value;
	var arrFieldsChecked = new Array();	
	arrFieldsChecked = fieldsChecked.split(",");
	
	var arrOrgsChecked = new Array();
	arrOrgsChecked = orgsChecked.split(",");
	
	var arrOrgsHNChecked = new Array();
	arrOrgsHNChecked = orgsHNChecked.split(",");
	
	
	var catObjects = document.getElementsByName("<portlet:namespace />field");
	for (var i = 0; (arrFieldsChecked != null) && (i < arrFieldsChecked.length); i ++) {
		for (var j = 0; (catObjects != null) && (j < catObjects.length); j ++) {
			if(catObjects[j].value == arrFieldsChecked[i]){
				catObjects[j].checked = true;
			}
		}
	}
	
	var orgObjects = document.getElementsByName("<portlet:namespace />org");
	for (var i = 0; (arrOrgsChecked != null) && (i < arrOrgsChecked.length); i ++) {
		for (var j = 0; (orgObjects != null) && (j < orgObjects.length); j ++) {
			if(orgObjects[j].value == arrOrgsChecked[i]){
				orgObjects[j].checked = true;
			}
		}
	}
	
	var orgObjectsHN = document.getElementsByName("<portlet:namespace />orgHN");
	for (var i = 0; (arrOrgsHNChecked != null) && (i < arrOrgsHNChecked.length); i ++) {
		for (var j = 0; (orgObjectsHN != null) && (j < orgObjectsHN.length); j ++) {
			if(orgObjectsHN[j].value == arrOrgsHNChecked[i]){
				orgObjectsHN[j].checked = true;
			}
		}
	}
</script>	