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

<%@ include file="/html/portlet/vimagegalleryview/init.jsp" %>
<script language="javascript">		
	function <portlet:namespace />savePreferences() {
		submitForm(document.<portlet:namespace />fm,'<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>">
		<portlet:param name="struts_action" value="/vimagegalleryview/edit" /></portlet:actionURL>');
	}
	
	function <portlet:namespace />changeTheme(styleObj) {
		if(styleObj)
			if(styleObj.value==1){
				document.getElementById("<portlet:namespace/>themes_DIENBIEN").style.display = '';
			}else if(styleObj.value==2){
				document.getElementById("<portlet:namespace/>themes_DIENBIEN").style.display = 'none';
			}else if(styleObj.value==3){
				document.getElementById("<portlet:namespace/>themes_DIENBIEN").style.display = 'none';
			}
			
	}		
</script>	
		
<form  action="<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>">
	<portlet:param name="struts_action" value="/vimagegalleryview/edit" /></portlet:actionURL>" name="<portlet:namespace />fm" method="POST">	
	<input name="<portlet:namespace />cmd" type="hidden" value="update">


<fieldset style="border:1px dotted gray;">
	<legend><strong>Tùy bi&#7871;n hi&#7875;n th&#7883;</strong></legend>
<table  width="100%" cellspacing="1" cellpadding="4" border="0">		
<tr height="30">
	<td><b>Tùy bi&#7871;n theo THEMES</b></td>
	<td>
		<input type="radio" value="1" name="<portlet:namespace/>themeType" id="<portlet:namespace/>themeType_1" 
			<%=themeType.equals("1")?"checked":""%> onchange="<portlet:namespace />changeTheme(this)">
			<label for="<portlet:namespace/>themeType_1">Themes &#272;i&#7879;n Biên</label>
		&nbsp;&nbsp;
		<input type="radio" value="2" name="<portlet:namespace/>themeType" id="<portlet:namespace/>themeType_2" 
			<%=themeType.equals("2")?"checked":""%> onchange="<portlet:namespace />changeTheme(this)">
			<label for="<portlet:namespace/>themeType_2">Themes các s&#7903; ban ngành</label>
		&nbsp;&nbsp;
		<input type="radio" value="3" name="<portlet:namespace/>themeType" id="<portlet:namespace/>themeType_3" 
			<%=themeType.equals("3")?"checked":""%> onchange="<portlet:namespace />changeTheme(this)">
			<label for="<portlet:namespace/>themeType_3">Trang Doanh nghi&#7879;p, Du khách, Ng&#432;&#7901;i dân</label>
	</td>
</tr>
					
<tr><td colspan="2">&nbsp;</td></tr>

<tr>
	<td colspan="2" id="<portlet:namespace/>themes_DIENBIEN" <%= (themeType.equals("1"))?"":"style=\"display:none\"" %>>
	<table width="100%">
	<tr height="30">
		<td><b>Ch&#7885;n ki&#7875;u vi&#7873;n</b></td>
		<td><b>Ch&#7885;n ki&#7875;u bullet</b></td>
		<td><b>Ch&#7885;n ki&#7875;u n&#7873;n ti&#234;u &#273;&#7873;</b></td>
		<td><b>M&#224;u n&#7873;n n&#7897;i dung</b></td>
	</tr>
					  	  
	<tr>
		<td><input type="radio" name="<portlet:namespace/>styleBorder" value="border_blue" <%= styleBorder.equals("border_blue") ? "checked":"" %>/>
		&nbsp; Xanh bi&#7875;n <span class="border_blue">&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
		
		<td><input type="radio" name="<portlet:namespace/>styleBullet" value="bullet_yellow" <%= styleBullet.equals("bullet_yellow") ? "checked":"" %>/>
		&nbsp; V&#224;ng <img src="<%= themeDisplay.getPathThemeImage() %>/DB_image/bullet_yellow.gif" /></td>
			
		<td><input type="radio" name="<portlet:namespace/>styleTitle" value="title_blue" <%= styleTitle.equals("title_blue") ? "checked":"" %>/>
		&nbsp; Xanh bi&#7875;n <img src="<%= themeDisplay.getPathThemeImage() %>/DB_image/title_bg_wrap_blue.gif" /></td>
			
		<td><input type="radio" name="<portlet:namespace/>styleContent" value="content_blue" <%= styleContent.equals("content_blue") ? "checked":"" %>/>
		&nbsp; Xanh nh&#7841;t <span class="content_blue">&nbsp;&nbsp;&nbsp;&nbsp;</span> </td>
	</tr>
					
    <tr height="30">
        <td><input type="radio" name="<portlet:namespace/>styleBorder" value="border_light_blue" <%= styleBorder.equals("border_light_blue") ? "checked":"" %>/>
          &nbsp; Xanh ng&#7885;c <span class="border_light_blue">&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
        
        <td><input type="radio" name="<portlet:namespace/>styleBullet" value="bullet_white_green" <%= styleBullet.equals("bullet_white_green") ? "checked":"" %>/>
          &nbsp; Tr&#7855;ng xanh ng&#7885;c <img src="<%= themeDisplay.getPathThemeImage() %>/DB_image/bullet_white_green.gif" /></td>
            
        <td><input type="radio" name="<portlet:namespace/>styleTitle" value="title_light_blue" <%= styleTitle.equals("title_light_blue") ? "checked":"" %>/>
          &nbsp; Xanh ng&#7885;c <img src="<%= themeDisplay.getPathThemeImage() %>/DB_image/title_bg_wrap_light_blue.gif" /></td>
        
        <td><input type="radio" name="<portlet:namespace/>styleContent" value="content_orange" <%= styleContent.equals("content_orange") ? "checked":"" %>/>
          &nbsp; V&#224;ng nh&#7841;t <span class="content_orange">&nbsp;&nbsp;&nbsp;&nbsp;</span> </td>    
	 
   </tr>
           			
    <tr height="30">
        <td><input type="radio" name="<portlet:namespace/>styleBorder" value="border_orange" <%= styleBorder.equals("border_orange") ? "checked":"" %>/>
          &nbsp; Da cam  <span class="border_orange">&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
        
        <td><input type="radio" name="<portlet:namespace/>styleBullet" value="bullet_white_orange" <%= styleBullet.equals("bullet_white_orange") ? "checked":"" %>/>
          &nbsp; Tr&#7855;ng cam <img src="<%= themeDisplay.getPathThemeImage() %>/DB_image/bullet_white_orange.gif" /></td>
            
        <td><input type="radio" name="<portlet:namespace/>styleTitle" value="title_orange" <%= styleTitle.equals("title_orange") ? "checked":"" %>/>
          &nbsp; Da cam <img src="<%= themeDisplay.getPathThemeImage() %>/DB_image/title_bg_wrap_orange.gif" /></td>
            
	   	<td>&nbsp;</td>
      </tr>		
           	
   	  <tr height="30">
        <td><input type="radio" name="<portlet:namespace/>styleBorder" value="border_green" <%= styleBorder.equals("border_green") ? "checked":"" %>/>
          &nbsp; Xanh l&#225; c&#226;y <span class="border_green">&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
        <td></td>
        <td><input type="radio" name="<portlet:namespace/>styleTitle" value="title_green" <%= styleTitle.equals("title_green") ? "checked":"" %>/>
          &nbsp; Xanh l&#225; c&#226;y <img src="<%= themeDisplay.getPathThemeImage() %>/DB_image/title_bg_wrap_green.gif" /></td>
	    <td></td>			      
  	 </tr> 		
          	
        <tr height="30">
            <td><input type="radio" name="<portlet:namespace/>styleBorder" value="" <%= styleBorder.equals("") ? "checked":"" %>/>
              <i>&nbsp; M&#7863;c &#273;&#7883;nh (Không có vi&#7873;n)</i></td>
              
            <td><input type="radio" name="<portlet:namespace/>styleBullet" value="" <%= styleBullet.equals("") ? "checked":"" %>/>
              <i>&nbsp; M&#7863;c &#273;&#7883;nh (Không có bullet)</i></td>
                
            <td><input type="radio" name="<portlet:namespace/>styleTitle" value="" <%= styleTitle.equals("") ? "checked":"" %>/>
              <i>&nbsp; M&#7863;c &#273;&#7883;nh (Không có n&#7873;n ti&#234;u &#273;&#7873;)</i></td>
                
		    <td><input type="radio" name="<portlet:namespace/>styleContent" value="" <%= styleContent.equals("") ? "checked":"" %>/>
              <i>&nbsp; M&#7863;c &#273;&#7883;nh (Không có n&#7873;n )</i></td>
        </tr> 	  
       </table>
       </td>
    </tr>
        			
    <!--<tr>
    	<td colspan="2" id="<portlet:namespace/>themes_SBN" <%= (themeType.equals("2"))?"":"style=\"display:none\"" %>>
    	<table width="100%">
    	<tr height="25">
    		<td><input type="radio" name="<portlet:namespace/>themeSelected" value="title_menuleft_xanh" <%=themeSelected.equals("title_menuleft_xanh")?"checked":""%>
    			id="<portlet:namespace/>themeSelect_1"><label for="<portlet:namespace/>themeSelect_1">&nbsp;S&#7903; Giáo D&#7909;c, Nông nghi&#7879;p</label></td>
    	</tr>
    	<tr height="25">
    		<td><input type="radio" name="<portlet:namespace/>themeSelected" value="title_menuleft_xanh2" <%=themeSelected.equals("title_menuleft_xanh2")?"checked":""%>
    			id="<portlet:namespace/>themeSelect_2"><label for="<portlet:namespace/>themeSelect_2">&nbsp;S&#7903; T&#432; Pháp, Tài Nguyên, N&#7897;i V&#7909;, Lao &#272;&#7897;ng, TP &#272;i&#7879;n Biên</label></td>
    	</tr>
    	<tr height="25">		
    		<td><input type="radio" name="<portlet:namespace/>themeSelected" value="" <%=themeSelected.equals("")?"checked":""%>
    			id="<portlet:namespace/>themeSelect_3"><label for="<portlet:namespace/>themeSelect_3">&nbsp;S&#7903; Tài Chính</label></td>
    	</tr>
    	</table>
    	</td>
    </tr>-->
        	
    <tr><td colspan="2">&nbsp;</td></tr>		
</table>
</fieldset>
	
	

<fieldset style="border:1px dotted gray;">
	<legend><strong>C&#7845;u hình hi&#7875;n th&#7883;</strong></legend>			
	<table width="100%" cellspacing="1" cellpadding="4" border="0">
	<tr height="30">
		<td width="20%">Tùy bi&#7871;n tiêu &#273;&#7873; Portlet</td>
		<td>								
			<input type="text" name="<portlet:namespace/>titlePortlet" style="width:210px" value="<%= titlePortlet%>">
		</td>							
	</tr>
	
	<tr height="30">
		<td width="20%">S&#7889; &#7843;nh hi&#7875;n th&#7883; trên 1 trang</td>
		<td>								
			<select name="<portlet:namespace />numOfImagePerPage">
				<%for(int i=1;i<=10;i++){%>
					<option value="<%=i%>" <%= (numOfImagePerPage.equals(String.valueOf(i))) ? "selected" : "" %>><%=i%></option>
				<%}%>						
			</select>
		</td>							
	</tr>
				
	<tr height="30">								
		<td>Ch&#7885;n t&#7889;c &#273;&#7897; trình di&#7877;n &#7843;nh</td>
		<td>								
			<select name="<portlet:namespace />speed">
				<%for(int i=1;i<=10;i++){%>
					<option value="<%=i%>" <%= (speed.equals(String.valueOf(i))) ? "selected" : "" %>><%=i%></option>
				<%}%>						
			</select> &nbsp;giây
		</td>	
	</tr>
				
	<!--<tr height="30">				
		<td><label for="<portlet:namespace/>showDesc">Hi&#7875;n th&#7883; mô t&#7843; c&#7911;a &#7843;nh</label></td>
		<td><input type="checkbox" name="<portlet:namespace/>showDesc"  id="<portlet:namespace/>showDesc" <%=showDesc?"checked":""%>></td>
	</tr>	

	<tr height="30">				
		<td><label for="<portlet:namespace/>showControl">Hi&#7875;n th&#7883; thanh &#273;i&#7873;u khi&#7875;n</label></td>
		<td><input type="checkbox" name="<portlet:namespace/>showControl"  id="<portlet:namespace/>showControl" <%=showControl?"checked":""%>></td>
	</tr>-->	
	</table>
</fieldset>

						
<br/>
<table>	
	<div class="portlet-font" style="font-weight:bold;float:left; margin-right:10px">		
		<input type="submit" class="portlet-form-button" value="<liferay-ui:message key="save" />" onClick="<portlet:namespace />savePreferences();"/>		
	</div>
</table>

</form>