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

<%@ include file="/html/portlet/vimagegallerymenu/init.jsp" %>	
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
			submitForm(document.<portlet:namespace />fm,'<portlet:actionURL></portlet:actionURL>');
		}
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
	portletURL.setParameter("jspPage", "/html/portlet/vsitemapview/edit.jsp");	

%>

<form  action="<portlet:actionURL>
	</portlet:actionURL>" name="<portlet:namespace />fm" method="POST">	
	<input name="<portlet:namespace />redirect" type="hidden" value="<%= currentURL %>" />
	<input name="<portlet:namespace />layoutIdSelected" type="hidden" value=""/>	
	<input name="<portlet:namespace />cmd" type="hidden" value="SELECT_LAYOUT"/>	
	<input name="<portlet:namespace />strPortletIds" type="hidden" value="<%=strPortletIds%>"/>	

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


<table width="100%">
<tr height="30">
	<td><b>Tùy bi&#7871;n tiêu &#273;&#7873; PORTLET</b></td>
	<td><input type="text" name="<portlet:namespace/>title" value="<%=title%>" style="width:200px;">
</tr>
<tr height="30">
	<td><b>Tùy bi&#7871;n theo THEMES</b></td>
	<td>
		<input type="radio" value="1" name="<portlet:namespace/>themeType" id="<portlet:namespace/>themeType_1" 
			<%=themeType.equals("1")?"checked":""%> onchange="<portlet:namespace />changeTheme(this)">
			<label for="<portlet:namespace/>themeType_1">Themes các s&#7903; ban ngành</label>
		&nbsp;&nbsp;
		<input type="radio" value="2" name="<portlet:namespace/>themeType" id="<portlet:namespace/>themeType_2" 
			<%=themeType.equals("2")?"checked":""%> onchange="<portlet:namespace />changeTheme(this)">
			<label for="<portlet:namespace/>themeType_2">Trang Doanh nghi&#7879;p, Ng&#432;&#7901;i dân, Du khách</label>
		&nbsp;&nbsp;
		<input type="radio" value="3" name="<portlet:namespace/>themeType" id="<portlet:namespace/>themeType_3" 
			<%=themeType.equals("3")?"checked":""%> onchange="<portlet:namespace />changeTheme(this)">
			<label for="<portlet:namespace/>themeType_3">Ha Noi 6.1</label>
	</td>
</tr>
			
<tr>
	<td colspan="2" id="<portlet:namespace/>themes_SBN" <%= (themeType.equals("1"))?"":"style=\"display:none\"" %>>
	<table width="100%">
	<tr>
		<td width="50%"  valign="top">
		<table>
		 <tr height="25">
			<td><input type="radio" value="title_menuleft_xanh2" name="<portlet:namespace/>themeSelected" id="<portlet:namespace/>custom" <%= (themeSelected.equals("title_menuleft_xanh2"))?"checked":"" %>></td>
			<td><label for="<portlet:namespace/>custom">Tr&#432;&#7901;ng h&#7907;p &#273;&#7863;c bi&#7879;t</label></td>
		</tr> 
		 <tr height="25">
			<td><input type="radio" value="" name="<portlet:namespace/>themeSelected" id="<portlet:namespace/>default" <%= (themeSelected.equals(""))?"checked":"" %>></td>
			<td><label for="<portlet:namespace/>default">M&#7863;c &#273;&#7883;nh</label></td>
		</tr>
		 <tr height="25">
		 	 <td><input type="checkbox" name="<portlet:namespace/>isBorder" id="<portlet:namespace/>isBorder" <%=isBorder?"checked":""%>></td>
		 	 <td><label for="<portlet:namespace/>isBorder">Hi&#7875;n th&#7883; vi&#7873;n</label></td>
		 </tr>
		</table>
		<td width="50%">
		<table>
		 <tr height="25">	 
		 	 <td>
		 	 	<select name="<portlet:namespace />paddingLeft" >
		 	 	<%for(int i=0;i<10;i++){%>
		 	 		<option value="<%=i%>" <%=(paddingLeft==i)?"selected":""%>><%=i%></option>
		 	 	<%}%>
		 	 	</select>
		 	 </td>
		 	 <td>&nbsp;C&#259;n l&#7873; trái</td>		
		 </tr>	 
		 <tr height="25">	 
		 	 <td>
		 	 	<select name="<portlet:namespace />paddingRight" >
		 	 	<%for(int j=0;j<10;j++){%>
		 	 		<option value="<%=j%>" <%=(paddingRight==j)?"selected":""%>><%=j%></option>
		 	 	<%}%>
		 	 	</select>
		 	 </td>
		 	 <td>&nbsp;C&#259;n l&#7873; ph&#7843;i</td>		
		 </tr>	 	
		</table>			
		</td>	
	</tr>
	</table>
	</td>
</tr>
</table>
</fieldset>
					
<br/>
<div class="portlet-font" style="font-weight:bold;float:left; margin-right:10px">		
	<input type="button" class="portlet-form-button" value="<liferay-ui:message key="save" />" onClick="<portlet:namespace />savePreferences();"/>		
</div>
<br/>
</form>
