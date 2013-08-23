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

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/portlet/vlinksmanview/init.jsp"%>
	
<portlet:defineObjects />
<script>
	//Choice style 	
	var cObjects = document.getElementsByName("<portlet:namespace />linkGroupIds");		
	
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
	};
	
	function <portlet:namespace />changeStyle(styleObj) {
		if(styleObj)
			if(styleObj.value==2){
				document.getElementById("style-02").style.display = '';								
			}
		if(styleObj)
			if(styleObj.value==3){
				document.getElementById("style-03").style.display = '';								
			}		
		if(styleObj.value==4){
			document.getElementById("style-04").style.display = '';								
		}else{
				document.getElementById("style-01").style.display = 'none';
			}
	}
	
	function <portlet:namespace />changeTheme(styleObj) {
		if(styleObj)
			if(styleObj.value==1){
				document.getElementById("<portlet:namespace/>themes_DIENBIEN").style.display = '';
				document.getElementById("<portlet:namespace/>themes_SBN").style.display = 'none';
			}else if(styleObj.value==2){
				document.getElementById("<portlet:namespace/>themes_DIENBIEN").style.display = 'none';
				document.getElementById("<portlet:namespace/>themes_SBN").style.display = '';
			}else if(styleObj.value==3){
				document.getElementById("<portlet:namespace/>themes_DIENBIEN").style.display = 'none';
				document.getElementById("<portlet:namespace/>themes_SBN").style.display = 'none';
			}
	}

	function <portlet:namespace />changeType(styleObj) {
		if(styleObj)
			if(styleObj.value==3 || styleObj.value==4 ){
				document.getElementById("<portlet:namespace/>select").style.display = 'none';
				document.getElementById("<portlet:namespace/>choice").style.display = '';
			}else {
				document.getElementById("<portlet:namespace/>select").style.display = '';
				document.getElementById("<portlet:namespace/>choice").style.display = 'none';
			}
		
		
		
	}
	
	//Save Preferences		
	function <portlet:namespace />savePreferences() {
		submitForm(document.<portlet:namespace />fm, 
		'<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>"></portlet:actionURL>');
	}
	
</script>
	
<%
	String redirect = ParamUtil.getString(request, "redirect");
	List linkGroups = new ArrayList();
	List links = new ArrayList();
	
	links = LinksServiceUtil.getByGroupId(groupId);
	linkGroups = LinkGroupServiceUtil.getByGroupId(groupId);
	
	String _linkgroupId = ParamUtil.getString(request,"linkgroupId");

%>

<form name="<portlet:namespace />fm" method="POST">	
	<input name="<portlet:namespace />redirect" type="hidden" value="<%= currentURL %>" />	
	<input name="<portlet:namespace />cmd" type="hidden" value=""/>
	
<table  width="100%" cellspacing="1" cellpadding="4" border="0" >	
<tr>
	<td width="100%" valign="top">		
		<fieldset style="border:1px dotted gray;">
		<legend><strong>C&#7845;u h&#236;nh Portlet</strong></legend>
		<table  class="lfr-table">	
		<tr height="30">
			<td><b>T&#249;y bi&#7871;n ti&#234;u &#273;&#7873; :</b></td>
			<td><input type="text" name="<portlet:namespace/>titlePortlet" value="<%=titlePortlet%>" style="width:180px;"></td>
		</tr>
	
		
					
		<tr><td colspan="2">&nbsp;</td></tr>
		
<!-- 		<tr> -->
<%-- 			<td colspan="2" id="<portlet:namespace/>themes_DIENBIEN" <%= (themeType.equals("1"))?"":"style=\"display:none\"" %>> --%>
<!-- 			<table width="100%"> -->
<!-- 			<tr height="30"> -->
<!-- 				<td><b>Ch&#7885;n ki&#7875;u vi&#7873;n</b></td> -->
<!-- 				<td><b>Ch&#7885;n ki&#7875;u bullet</b></td> -->
<!-- 				<td><b>Ch&#7885;n ki&#7875;u n&#7873;n ti&#234;u &#273;&#7873;</b></td> -->
<!-- 				<td><b>M&#224;u n&#7873;n n&#7897;i dung</b></td> -->
<!-- 			</tr> -->
					  	  
<!-- 			<tr> -->
<%-- 				<td><input type="radio" name="<portlet:namespace/>styleBorder" value="border_blue" <%= styleBorder.equals("border_blue") ? "checked":"" %>/> --%>
<!-- 				&nbsp; Xanh bi&#7875;n <span class="border_blue">&nbsp;&nbsp;&nbsp;&nbsp;</span></td> -->
				
<%-- 				<td><input type="radio" name="<portlet:namespace/>styleBullet" value="bullet_yellow" <%= styleBullet.equals("bullet_yellow") ? "checked":"" %>/> --%>
<%-- 				&nbsp; V&#224;ng <img src="<%= themeDisplay.getPathThemeImage() %>/DB_image/bullet_yellow.gif" /></td> --%>
					
<%-- 				<td><input type="radio" name="<portlet:namespace/>styleTitle" value="title_blue" <%= styleTitle.equals("title_blue") ? "checked":"" %>/> --%>
<%-- 				&nbsp; Xanh bi&#7875;n <img src="<%= themeDisplay.getPathThemeImage() %>/DB_image/title_bg_wrap_blue.gif" /></td> --%>
					
<%-- 				<td><input type="radio" name="<portlet:namespace/>styleContent" value="content_blue" <%= styleContent.equals("content_blue") ? "checked":"" %>/> --%>
<!-- 				&nbsp; Xanh nh&#7841;t <span class="content_blue">&nbsp;&nbsp;&nbsp;&nbsp;</span> </td> -->
<!-- 			</tr> -->
					
<!-- 		    <tr height="30"> -->
<%--                 <td><input type="radio" name="<portlet:namespace/>styleBorder" value="border_light_blue" <%= styleBorder.equals("border_light_blue") ? "checked":"" %>/> --%>
<!--                   &nbsp; Xanh ng&#7885;c <span class="border_light_blue">&nbsp;&nbsp;&nbsp;&nbsp;</span></td> -->
                
<%-- 	            <td><input type="radio" name="<portlet:namespace/>styleBullet" value="bullet_white_green" <%= styleBullet.equals("bullet_white_green") ? "checked":"" %>/> --%>
<%-- 	              &nbsp; Tr&#7855;ng xanh ng&#7885;c <img src="<%= themeDisplay.getPathThemeImage() %>/DB_image/bullet_white_green.gif" /></td> --%>
	                
<%-- 	            <td><input type="radio" name="<portlet:namespace/>styleTitle" value="title_light_blue" <%= styleTitle.equals("title_light_blue") ? "checked":"" %>/> --%>
<%-- 	              &nbsp; Xanh ng&#7885;c <img src="<%= themeDisplay.getPathThemeImage() %>/DB_image/title_bg_wrap_light_blue.gif" /></td> --%>
	            
<%-- 	            <td><input type="radio" name="<portlet:namespace/>styleContent" value="content_orange" <%= styleContent.equals("content_orange") ? "checked":"" %>/> --%>
<!--                   &nbsp; V&#224;ng nh&#7841;t <span class="content_orange">&nbsp;&nbsp;&nbsp;&nbsp;</span> </td>     -->
			 
<!--            </tr> -->
           			
<!--     	    <tr height="30"> -->
<%--                 <td><input type="radio" name="<portlet:namespace/>styleBorder" value="border_orange" <%= styleBorder.equals("border_orange") ? "checked":"" %>/> --%>
<!--                   &nbsp; Da cam  <span class="border_orange">&nbsp;&nbsp;&nbsp;&nbsp;</span></td> -->
                
<%--                 <td><input type="radio" name="<portlet:namespace/>styleBullet" value="bullet_white_orange" <%= styleBullet.equals("bullet_white_orange") ? "checked":"" %>/> --%>
<%--                   &nbsp; Tr&#7855;ng cam <img src="<%= themeDisplay.getPathThemeImage() %>/DB_image/bullet_white_orange.gif" /></td> --%>
                    
<%--                 <td><input type="radio" name="<portlet:namespace/>styleTitle" value="title_orange" <%= styleTitle.equals("title_orange") ? "checked":"" %>/> --%>
<%--                   &nbsp; Da cam <img src="<%= themeDisplay.getPathThemeImage() %>/DB_image/title_bg_wrap_orange.gif" /></td> --%>
                    
<!-- 			   	<td>&nbsp;</td> -->
<!--               </tr>		 -->
           	
<!--            	  <tr height="30"> -->
<%--                 <td><input type="radio" name="<portlet:namespace/>styleBorder" value="border_green" <%= styleBorder.equals("border_green") ? "checked":"" %>/> --%>
<!--                   &nbsp; Xanh l&#225; c&#226;y <span class="border_green">&nbsp;&nbsp;&nbsp;&nbsp;</span></td> -->
<!--                 <td></td> -->
<%--                 <td><input type="radio" name="<portlet:namespace/>styleTitle" value="title_green" <%= styleTitle.equals("title_green") ? "checked":"" %>/> --%>
<%--                   &nbsp; Xanh l&#225; c&#226;y <img src="<%= themeDisplay.getPathThemeImage() %>/DB_image/title_bg_wrap_green.gif" /></td> --%>
<!-- 			    <td></td>			       -->
<!--           	 </tr> 		 -->
          	
<!--             <tr height="30"> -->
<%-- 	            <td><input type="radio" name="<portlet:namespace/>styleBorder" value="" <%= styleBorder.equals("") ? "checked":"" %>/> --%>
<!-- 	              <i>&nbsp; M&#7863;c &#273;&#7883;nh (Không có vi&#7873;n)</i></td> -->
	              
<%-- 	            <td><input type="radio" name="<portlet:namespace/>styleBullet" value="" <%= styleBullet.equals("") ? "checked":"" %>/> --%>
<!-- 	              <i>&nbsp; M&#7863;c &#273;&#7883;nh (Không có bullet)</i></td> -->
	                
<%-- 	            <td><input type="radio" name="<portlet:namespace/>styleTitle" value="" <%= styleTitle.equals("") ? "checked":"" %>/> --%>
<!-- 	              <i>&nbsp; M&#7863;c &#273;&#7883;nh (Không có n&#7873;n ti&#234;u &#273;&#7873;)</i></td> -->
	                
<%-- 			    <td><input type="radio" name="<portlet:namespace/>styleContent" value="" <%= styleContent.equals("") ? "checked":"" %>/> --%>
<!-- 	              <i>&nbsp; M&#7863;c &#273;&#7883;nh (Không có n&#7873;n )</i></td> -->
<!--             </tr> 	   -->
<!--            </table> -->
<!--            </td> -->
<!--         </tr> -->
        			
	    <tr>
	<td colspan="2" id="<portlet:namespace/>themes_SBN" <%= (themeType.equals("2"))?"":"style=\"display:none\"" %>>
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
		 	 
		 <tr height="25">	 
		 	 <td>
		 	 	<select name="<portlet:namespace />paddingLeft" >
		 	 	<%for(int i=0;i<10;i++){%>
		 	 		<option value="<%=i%>" <%=(paddingLeft==i)?"selected":""%>><%=i%></option>
		 	 	<%}%>
		 	 	</select>
		 	 </td>
		 	 <td>C&#259;n l&#7873; trái</td>		
		 </tr>	 
		 <tr height="25">	 
		 	 <td>
		 	 	<select name="<portlet:namespace />paddingRight" >
		 	 	<%for(int j=0;j<10;j++){%>
		 	 		<option value="<%=j%>" <%=(paddingRight==j)?"selected":""%>><%=j%></option>
		 	 	<%}%>
		 	 	</select>
		 	 </td>
		 	 <td>C&#259;n l&#7873; ph&#7843;i</td>		
		 </tr>	 	 	 
		</table>
		</td>
			 
		<td valign="top">	 
		 <table width="100%">
	 	 <tr height="25">
		 	 <td bgcolor="#eff8e8" width="20" >&nbsp;&nbsp;</span></td>
		 	 <td align="left" style="padding-left:20px;">&nbsp;<input type="radio" name="<portlet:namespace/>bgcolor" id="<portlet:namespace/>bgcolor_1" value="#eff8e8" <%=bgcolor.equals("#eff8e8")?"checked":""%>>
		 	 <label for="<portlet:namespace/>bgcolor_1">Ch&#7885;n ki&#7875;u màu 1</label></td>
		 </tr>
		 <tr height="25">
		 	 <td bgcolor="#e0f1ff" width="20" >&nbsp;&nbsp;</span></td>
		 	 <td align="left" style="padding-left:20px;">&nbsp;<input type="radio" name="<portlet:namespace/>bgcolor" id="<portlet:namespace/>bgcolor_2" value="#e0f1ff" <%=bgcolor.equals("#e0f1ff")?"checked":""%>>
		 	 <label for="<portlet:namespace/>bgcolor_2">Ch&#7885;n ki&#7875;u màu 2</label></td>
		 </tr>
		 <tr height="25">
		 	 <td bgcolor="#fff4e8" width="20" >&nbsp;&nbsp;</span></td>
		 	 <td align="left" style="padding-left:20px;">&nbsp;<input type="radio" name="<portlet:namespace/>bgcolor" id="<portlet:namespace/>bgcolor_3" value="#fff4e8" <%=bgcolor.equals("#fff4e8")?"checked":""%>>
		 	 <label for="<portlet:namespace/>bgcolor_3">Ch&#7885;n ki&#7875;u màu 3</label></td>
		 </tr>
		 <tr height="25">
		 	 <td bgcolor="#ffffff" width="20" >&nbsp;&nbsp;</span></td>
		 	 <td align="left" style="padding-left:20px;">&nbsp;<input type="radio" name="<portlet:namespace/>bgcolor" id="<portlet:namespace/>bgcolor_4" value="#ffffff" <%=bgcolor.equals("#ffffff")?"checked":""%>>
		 	 <label for="<portlet:namespace/>bgcolor_4">M&#7863;c &#273;&#7883;nh</label></td>
		 </tr>
	 	 </table>	
		</td>	
	</tr>
   </table>
   </td>
</tr>	
	
		<tr><td colspan="2">&nbsp;</td></tr>
				
		<tr height="30">	
			<td valign="top"><b>Ch&#7885;n ki&#7875;u hi&#7875;n th&#7883; :</b></td>
			<td>
				<table>				
				<tr>
					<td><input type="radio" name="<portlet:namespace/>typeDisplay" id="<portlet:namespace/>type_2" value="2" 
						<%=(typeDisplay==2)?"checked":""%> onchange="<portlet:namespace />changeType(this)">
						<label for="<portlet:namespace/>type_2">B&#7843;n &#273;&#7891; h&#224;nh ch&#237;nh</label></td>
						
					<td><input type="radio" name="<portlet:namespace/>typeDisplay" id="<portlet:namespace/>type_3" value="3" 
						<%=(typeDisplay==3)?"checked":""%> onchange="<portlet:namespace />changeType(this)">
						<label for="<portlet:namespace/>type_3">Li&#234;n k&#7871;t kh&#244;ng c&#243; &#7843;nh</label></td>
			
					<td><input type="radio" name="<portlet:namespace/>typeDisplay" id="<portlet:namespace/>type_4" value="4" 
						<%=(typeDisplay==4)?"checked":""%> onchange="<portlet:namespace />changeType(this)">
						<label for="<portlet:namespace/>type_4">Li&#234;n k&#7871;t c&#243; &#7843;nh</label></td>
				</tr>
				<tr>			
					<td valign="top"><img src="/html/portlet/vlinksmanview/images/combo.JPG" border="1" /></td>
					<td valign="top"><img src="/html/portlet/vlinksmanview/images/list.JPG" border="1" /></td>
<%-- 					<td valign="top"><label for="<portlet:namespace/>type_3">&nbsp;Tùy ch&#7885;n liên k&#7871;t & hi&#7875;n th&#7883; theo c&#7897;t</label></td> --%>
				</tr>	
				</table>
			</td>
		</tr>
		</table>
	
		<div id="<portlet:namespace/>select" <%= (typeDisplay==3 || typeDisplay==4 )? "style=\"display:none\"":""%>>
<!-- 		<table width="100%">	 -->
<!-- 		<tr height="30"> -->
<!-- 			<td><b>Ch&#7885;n liên k&#7871;t :</b></td> -->
<!-- 			<td> -->
<%-- 				<input type="radio" name="<%= renderResponse.getNamespace() %>style" value="1" id="<portlet:namespace/>style_1" --%>
<%-- 					<%= (style==1)?"checked":"" %> onchange="<portlet:namespace />changeStyle(this)" /> --%>
<%-- 			 		<label for="<portlet:namespace/>style_1">Hi&#7875;n th&#7883; liên k&#7871;t theo nhóm.</label> --%>
<!-- 			</td> -->
<!-- 		</tr>			 -->
<!-- 		<tr height="30"> -->
<!-- 			<td/> -->
<!-- 			<td> -->
<%-- 				<input type="radio" name="<%= renderResponse.getNamespace() %>style" value="3" id="<portlet:namespace/>style_3" --%>
<%-- 					<%= (style==3)?"checked":"" %> onchange="<portlet:namespace />changeStyle(this)" /> --%>
<%-- 			 		<label for="<portlet:namespace/>style_3">Hi&#7875;n th&#7883; t&#7845;t c&#7843; liên k&#7871;t.</label> --%>
<!-- 			</td> -->
<!-- 		</tr> -->
<!-- 		</table> -->
		
		<!-- Style 01 -->			
		</div>	
		
		<div id="<portlet:namespace/>choice" >
		<table width="100%">
		<tr height="30"><td colspan="2"><b>Ch&#7885;n nh&#243;m li&#234;n k&#7871;t hi&#7875;n th&#7883;</b></td></tr>	
		<%	
			List cats = new ArrayList();
			if(Validator.isNotNull(linkGroupIds))
				for(int j=0;j<linkGroupIds.length;j++){
					cats.add(linkGroupIds[j]);
				}
		
			for(int i=0;i < linkGroups.size();i++){
				LinkGroup linkGroup = (LinkGroup)linkGroups.get(i);
		%>	
		<tr height="25">
			<td><input type="checkbox" name="<portlet:namespace/>linkGroupIds" value="<%=linkGroup.getLinkgroupId()%>"
				id="<portlet:namespace/>groupSelect_<%=linkGroup.getLinkgroupId()%>" <%= (cats.contains(String.valueOf(linkGroup.getLinkgroupId())) ? "checked":"" )%>></td>
			<td><label for="<portlet:namespace/>groupSelect_<%=linkGroup.getLinkgroupId()%>">&nbsp;<%=linkGroup.getName()%></td>
		</tr>
		<%}%>
		<!--<tr><td>
				<input type="checkbox" name="<portlet:namespace/>checkboxAll" id="<portlet:namespace/>checkAll" onclick="javascript:<portlet:namespace/>checkAll();"></td>
			<td>
				<label for="<portlet:namespace/>checkAll">Ch&#7885;n t&#7845;t c&#7843;</label></td>
			
			</tr>-->
		</table>	
		</div>	
		</fieldset>
	</td>
</tr>
</table>

<div class="portlet-font" style="font-weight:bold;float:left; margin-right:10px">
	<input type="button" class="portlet-form-button" value="<liferay-ui:message key="save" />" onClick="<portlet:namespace />savePreferences();"/>		
</div>
<br/><br/>
</form>
	