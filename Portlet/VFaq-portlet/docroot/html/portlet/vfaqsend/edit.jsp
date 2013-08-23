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

<%@ include file ="/html/portlet/vfaqsend/init.jsp"%>
<script type="text/javascript">
//Save Preferences		
	function <portlet:namespace />savePreferences() {
		submitForm(document.<portlet:namespace />fm,'<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>"></portlet:actionURL>'); 
		
	}
</script>

<form  name = "<portlet:namespace/>fm" method = "POST">
<input name="<portlet:namespace />cmd" type="hidden" value="update">
<input name="<portlet:namespace />redirect" type="hidden" value="<%= currentURL %>" />

<fieldset style="border:1px dotted gray">	
	<legend>C&#7845;u hình PORTLET<legend>
	<table width="100%">
<!-- 	<tr height="30"> -->
<!-- 		<td><b>Tùy bi&#7871;n theo THEMES</b></td> -->
<!-- 		<td> -->
<%-- 			<input type="radio" value="2" name="<portlet:namespace/>themeType" id="<portlet:namespace/>themeType_2"  --%>
<%-- 				<%=themeType.equals("2")?"checked":""%> > --%>
<%-- 				<label for="<portlet:namespace/>themeType_2">Themes các s&#7903; ban ngành</label> --%>
<!-- 			&nbsp;&nbsp; -->
<%-- 			<input type="radio" value="3" name="<portlet:namespace/>themeType" id="<portlet:namespace/>themeType_3"  --%>
<%-- 				<%=themeType.equals("3")?"checked":""%> > --%>
<%-- 				<label for="<portlet:namespace/>themeType_3">Trang Doanh nghi&#7879;p, Ng&#432;&#7901;i dân, Du khách</label> --%>
<!-- 		</td> -->
<!-- 	</tr> -->
				
	<tr height="30">
		<td><b>Tùy bi&#7871;n tiêu &#273;&#7873; PORTLET:</b></td>
		<td><input type="text" name="<portlet:namespace/>titlePortlet" value="<%=titlePortlet%>" style="width:180px;"></td>
	</tr>
						
	<tr height="30">
		<td><b>Tùy bi&#7871;n tiêu &#273;&#7873; câu h&#7887;i</b></td>
		<td>
			<textarea name="<portlet:namespace/>titleQuestion" class="form-text" cols="70" rows="5"><%=titleQuestion%></textarea></td>							
	</tr>
	</table>								
</fieldset>	
							
<div class="portlet-font" style="float:left; margin:10px">
	<input type="button" class="portlet-form-button" value="<liferay-ui:message key="save" />" onClick="<portlet:namespace />savePreferences();" />
</div>
<br><br>
</form>
