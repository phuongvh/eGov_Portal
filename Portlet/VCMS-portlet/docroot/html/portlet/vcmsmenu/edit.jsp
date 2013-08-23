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
<%
/**
 * Copyright (c) 2000-2008 VietSoftware, Inc. All rights reserved.
 */
%>
<%@ include file="/html/portlet/vcmsmenu/init.jsp" %>

<%
	List selectPortletLayoutIds = (List)request.getAttribute("SELECT_PORTLET_LAYOUT_IDS");
	String portionIdSelected = ParamUtil.getString(request, "portionIdSelected","");
	if(!portionIdSelected.equals("")){
	   portionId = portionIdSelected;
	}
	if(selectPortletLayoutIds == null && Validator.isNotNull(layoutPortletId)){
		try{
			selectPortletLayoutIds = LayoutPortletUtil.getPortletIdsByLayout(Long.parseLong(layoutPortletId));
		}catch(Exception ex){
		}
	}
	String plid_layout = (String)request.getAttribute("PLID_LAYOUT");

	if(Validator.isNull(plid_layout)||(Validator.isNotNull(plid_layout) && plid_layout.equals("0"))){
		plid_layout = layoutPortletId;
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
	String portionId2="";
	String parentId2 = "";
	if (Validator.isNotNull(portionId) && (portionId.indexOf("|") > 0)) {
		String[] ppIds = StringUtil.split(portionId, "|");
		portionId2 = ppIds[0];
		parentId2 = ppIds[1];
	 }
%>

<script type="text/javascript">
	var cObjects = document.getElementsByName("<portlet:namespace />category");		
	
	function <portlet:namespace/>checkAll(){
		if(document.<portlet:namespace />fm.<portlet:namespace />checkboxAll.checked){
				for (i = 0; (cObjects != null) && (i < cObjects.length); i ++) {
					cObjects[i].checked = true;
				}	
		}else{
				for (i = 0; (cObjects != null) && (i < cObjects.length); i ++) {
					cObjects[i].checked = false;
				}
		}
	}
	
	function <portlet:namespace />savePreferences() {
		var categories = '';
		var categoriesStyle = '';
		
		for (i = 0; (cObjects != null) && (i < cObjects.length); i ++) {
			if (cObjects[i].checked) {
				categories += cObjects[i].value + ',';
				var styleValue = document.getElementById("<portlet:namespace />select_style_menu_"+cObjects[i].value).value;
				categoriesStyle += styleValue + ',';
			}
		}
		var layoutPlId = document.<portlet:namespace />fm.<portlet:namespace />layoutPortletId.value;
		if(layoutPlId != "0" && layoutPlId!= ""){
			document.<portlet:namespace />fm.<portlet:namespace />layoutIdSelected.value = layoutPlId;
		}else{
			document.<portlet:namespace />fm.<portlet:namespace />cmd.value = "";
		}
		document.<portlet:namespace />fm.<portlet:namespace />categories.value = categories;
		document.<portlet:namespace />fm.<portlet:namespace />categoriesStyle.value = categoriesStyle;
		submitForm(document.<portlet:namespace />fm);
		<%-- submitForm(document.<portlet:namespace />fm,'<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>" name="savePreferences"></portlet:actionURL>'); --%>
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
			submitForm(document.<portlet:namespace />fm);
		}
	}
	function <portlet:namespace/>findPortion(){
		var portionId = document.<portlet:namespace />fm.<portlet:namespace />portionId.value;
		document.<portlet:namespace />fm.<portlet:namespace />portionIdSelected.value = portionId;
		submitForm(document.<portlet:namespace />fm);

	}
</script>
<form action="<portlet:actionURL><portlet:param name="jspPage" value="/html/portlet/vcmsmenu/edit.jsp" /></portlet:actionURL>" method="post" name="<portlet:namespace />fm">
<input name="<portlet:namespace />portionIdSelected" type="hidden" value="<%=portionId%>"/>
<input name="<portlet:namespace />categories" type="hidden" value=""/>
<input name="<portlet:namespace />categoriesStyle" type="hidden" value=""/>
<input name="<portlet:namespace />categoriesChecked" type="hidden" value="<%=categories%>"/>
<input name="<portlet:namespace />categoriesStyleSelected" type="hidden" value="<%=categoriesStyle%>"/>
<input name="<portlet:namespace />layoutIdSelected" type="hidden" value="<%=plid_layout%>"/>	
<input name="<portlet:namespace />cmd" type="hidden" value="SELECT_LAYOUT"/>	
<input name="<portlet:namespace />strPortletIds" type="hidden" value="<%=strPortletIds%>"/>		
		<fieldset style="border:1px dotted gray">
				<legend><b>C&#7845;u hình chung</b></legend>
                <table width="100%" border="0" cellpadding="4" cellspacing="1">
                  <tr>
                    <td colspan="2" style="margin-left:10px">
    						<%if(selectLayouts == null || selectLayouts.size()==0){%>
    							<img src="/html/portlet/vcmsmenu/images/g_n.gif"/> Hi&#7879;n t&#7841;i ch&#432;a có Layout nào ch&#7913;a <b>Portlet hi&#7875;n th&#7883; bài vi&#7871;t</b>!<br/>
    							<img src="/html/portlet/vcmsmenu/images/g_n.gif"/> B&#7841;n hãy kh&#7903;i t&#7841;o <b>Portlet hi&#7875;n th&#7883; bài vi&#7871;t </b> &#7903; b&#7845;t k&#7923; Layout nào &#273;&#7875; c&#7845;u hình nh&#7919;ng thu&#7897;c tính &#7903; d&#432;&#7899;i!
    						    <hr width="70%"  align="left" style="dotted gray"/>
	    					<%}%>
						</td>
					</tr>
                  <tr>
                    <td width="70%"><table width="100%" border="0" cellpadding="4" cellspacing="1">
                      <tr>
                        <td width="7%"><input type="radio" name="<portlet:namespace/>selectPortletLayout" value="1" <%=(Validator.isNotNull(selectPortletLayout) && selectPortletLayout.equals("1"))?"checked":""%> onclick="javascript:<portlet:namespace/>selectPortleId(1);"/></td>
                        <td width="93%">T&#7921; &#273;&#7897;ng t&igrave;m <b> Portlet hi&#7875;n th&#7883; bài vi&#7871;t <b/>cho chuyên m&#7909;c</td>
                      </tr>
                      <tr>
                        <td><input type="radio"  name="<portlet:namespace/>selectPortletLayout" value="2" <%=(Validator.isNotNull(selectPortletLayout) && selectPortletLayout.equals("2"))?"checked":""%> onclick="javascript:<portlet:namespace/>selectPortleId(2);"/></td>
                        <td>Ch&#7885;n <b>Portlet hi&#7875;n th&#7883; bài vi&#7871;t </b> cho chuy&ecirc;n m&#7909;c </td>
                      </tr>
                      <tr>
                        <td colspan="2">
    						<div id="<portlet:namespace/>choicePortletId" <%=(Validator.isNotNull(selectPortletLayout) && selectPortletLayout.equals("2"))?"style='display:block;margin-left:10px'":"style='display:none;margin-left:10px'"%>>
    							<table width="100%" border="0" cellpadding="4" cellspacing="1">
								    <tr>
								    	<td width="65%">
											<img src="/html/portlet/vcmsmenu/images/editcopy.png"/> L&#7921;a ch&#7885;n Layout Tab <b>ch&#7913;a Portlet Hi&#7875;n th&#7883; bài vi&#7871;t</b> :								    	</td>
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
											</select>								    	</td>
								    </tr>
									<tr>
								    	<td width="65%">
											<img src="/html/portlet/vcmsmenu/images/editcopy.png"/> L&#7921;a ch&#7885;n <b>Portlet Hi&#7875;n th&#7883; bài vi&#7871;t</b>:								    	</td>
										<td>
										<%
											if(selectPortletLayoutIds != null && selectPortletLayoutIds.size()>0){
										%>
											<select name="<portlet:namespace/>portletSelectId">
												<%
													for(int count = 0; count<selectPortletLayoutIds.size();count++){
														String portletLayoutId = (String)selectPortletLayoutIds.get(count);
												%>
														<option value="<%=portletLayoutId%>"><%=portletLayoutId%></option>
												<%}%>
											</select>
										<%}
										%>								    	</td>
								    </tr>
    							</table
    						></div>    					</td>
                      </tr>   
					  <tr>
					    <td colspan="3">&nbsp;</td>
					  </tr>  				  
					<tr>
						<td colspan="3">
   					      <table class="lfr-table">                              
                              <tr><td colspan="4">&nbsp;</td></tr>
							  <tr height="25">
								   <td colspan="4">
								   <input type="radio" name="<portlet:namespace/>styleBorder" id="<portlet:namespace/>styleBorder_1" value="Style1" <%= styleBorder.equals("Style1") ? "checked":"" %>/>
								     <label for="<portlet:namespace/>styleBorder_1"><strong>Style 1</strong></label>
								   </td>
							  </tr>
							  <tr height="25">
								   <td colspan="4">
								   <input type="radio" name="<portlet:namespace/>styleBorder" id="<portlet:namespace/>styleBorder_1" value="Style2" <%= styleBorder.equals("Style2") ? "checked":"" %>/>
								     <label for="<portlet:namespace/>styleBorder_1"><strong>Style 2</strong></label>
								   </td>
							  </tr>
							  <tr height="25">
								   <td colspan="4">
								   <input type="radio" name="<portlet:namespace/>styleBorder" id="<portlet:namespace/>styleBorder_1" value="Style3" <%= styleBorder.equals("Style3") ? "checked":"" %>/>
								     <label for="<portlet:namespace/>styleBorder_1"><strong>Style 3 - (Trang &#273;&#417;n v&#7883;)</strong></label>
								   </td>
							  </tr>
							  <tr height="25">
								   <td colspan="4">
								   <input type="radio" name="<portlet:namespace/>styleBorder" id="<portlet:namespace/>styleBorder_1" value="Style5" <%= styleBorder.equals("Style5") ? "checked":"" %>/>
								     <label for="<portlet:namespace/>styleBorder_1"><strong>Style 5</strong></label>
								   </td>
							  </tr>		
							  <tr height="25">
								   <td colspan="4">
								   <input type="radio" name="<portlet:namespace/>styleBorder" id="<portlet:namespace/>styleBorder_1" value="Style6" <%= styleBorder.equals("Style6") ? "checked":"" %>/>
								     <label for="<portlet:namespace/>styleBorder_1"><strong>Style 6</strong></label>
								   </td>
							  </tr>	
							  <tr height="25">
								   <td colspan="4">
								   <input type="radio" name="<portlet:namespace/>styleBorder" id="<portlet:namespace/>styleBorder_1" value="Style7" <%= styleBorder.equals("Style7") ? "checked":"" %>/>
								     <label for="<portlet:namespace/>styleBorder_1"><strong>Style 7</strong></label>
								   </td>
							  </tr>							  
                            </table>
						</td>
   				  </tr>
                    </table></td>
                    <td width="30%">&nbsp;</td>
                  </tr>
        </table>
		</fieldset>
		<fieldset style="border:1px dotted gray">
				<legend><b>C&#7845;u hình hi&#7875;n th&#7883; chuyên m&#7909;c</b></legend>
				<table border="0" cellpadding="4" cellspacing="0" width="100%">
				<tr>
					<td colspan="2" align="center">
					   <select name="<portlet:namespace/>portionId" onchange="javascript:<portlet:namespace/>findPortion();">
						<%
							out.println(ActionUtil.getCategoryTree(groupId, language, portionId, categoryId,permissionChecker));
					    %>
					</select>							
					</td>
				</tr>
				<tr>	
					<td colspan="2"></td>
				</tr>
				<%
				if(!portionId.equals("")){
				    List listCategory = VcmsCategoryServiceUtil.getCategoriesByP_P(groupId, portionId2, parentId2,language);
				  
				%>
				<tr>
					<td colspan="2"><input type="checkbox" name="<portlet:namespace />checkboxAll" id="<portlet:namespace />checkboxAll" onclick="javascript:<portlet:namespace/>checkAll();" <%=(isCheckedAllCats)?"checked":""%>/><label for="<portlet:namespace />checkboxAll"> L&#7921;a ch&#7885;n t&#7845;t c&#7843;</label></td>
				</tr>
					<%= ActionUtilMenu.getCategory(listCategory,renderResponse.getNamespace(),permissionChecker) %>
				<%	}	%>	
				</table>
		</fieldset>			

	<br/>
	<input type="button" value="<liferay-ui:message key="save" />" onClick="<portlet:namespace />savePreferences();" />

</form>
<script type="text/javascript">
	var catsChecked	= document.<portlet:namespace />fm.<portlet:namespace />categoriesChecked.value;
	var catsStyleSelected	= document.<portlet:namespace />fm.<portlet:namespace />categoriesStyleSelected.value;

	var arrCatsChecked = new Array();
	var arrCatsStyleSelected = new Array();
	arrCatsChecked = catsChecked.split(",");
	arrCatsStyleSelected = catsStyleSelected.split(",");
	
	var catObjects = document.getElementsByName("<portlet:namespace />category");
	for (i = 0; (arrCatsChecked != null) && (i < arrCatsChecked.length); i ++) {
		for (j = 0; (catObjects != null) && (j < catObjects.length); j ++) {
			if(catObjects[j].value == arrCatsChecked[i]){
				catObjects[j].checked = true;
				var selectedValue = arrCatsStyleSelected[j];
				var selectName = "<portlet:namespace />select_style_menu_"+cObjects[j].value;
			}
		}
	}
</script>