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

<%@ include file ="init.jsp"%>
<script type="text/javascript">
//Save Preferences		
	function <portlet:namespace />savePreferences() {
		submitForm(document.<portlet:namespace />fm, 
		'<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>"></portlet:actionURL>');
	}
</script>

<form action = "<portlet:actionURL><portlet:param name = "struts_action" value = "/vfaqcontent/contentedit"/>
</portlet:actionURL>" name = "<portlet:namespace/>fm" method = "POST">
<input name="<portlet:namespace />cmd" type="hidden" value="update">
<input name="<portlet:namespace />redirect" type="hidden" value="<%= currentURL %>" />

<fieldset style="border:1px dotted gray; margin: 7px;">
<legend><strong>C&#7845;u h&igrave;nh chung</strong></legend>
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding: 7px;">	
<tr><td height="5"></td></tr>		

<tr>
	<td>
	<table width="100%">	
	<tr height="30">
		<td><b>Tùy bi&#7871;n tiêu &#273;&#7873; PORTLET:</b></td>
		<td><input type="text" name="<portlet:namespace/>titlePortlet" value="<%=titlePortlet%>" style="width:180px;"></td>
	</tr>
	<tr height="30">
		<td><b>Nh&#7853;p &#273;&#432;&#7901;ng &#273;&#7851;n t&#7899;i ph&#7847;n g&#7917;i câu h&#7887;i:</b></td>
		<td><input type="text" name="<portlet:namespace/>url" value="<%=url%>" style="width:180px;"></td>
	</tr>
	<tr height="30">
		<td><b>Tùy bi&#7871;n theo THEMES</b></td>
		<td>
			<input type="radio" value="1" name="<portlet:namespace/>themeType" id="<portlet:namespace/>themeType_1" 
				<%=themeType.equals("1")?"checked":""%> >
				<label for="<portlet:namespace/>themeType_1"><%=LanguageUtil.get(pageContext, "com.vportal.portlet.vfaqcontent.hanoitheme") %></label>
			
			<input type="radio" value="2" name="<portlet:namespace/>themeType" id="<portlet:namespace/>themeType_2" 
				<%=themeType.equals("2")?"checked":""%> >
				<label for="<portlet:namespace/>themeType_2">Themes các s&#7903; ban ngành</label>
			&nbsp;&nbsp;
			<input type="radio" value="3" name="<portlet:namespace/>themeType" id="<portlet:namespace/>themeType_3" 
				<%=themeType.equals("3")?"checked":""%> >
				<label for="<portlet:namespace/>themeType_3">Trang Doanh nghi&#7879;p, Ng&#432;&#7901;i dân, Du khách</label>
		</td>
	</tr>
		
	<tr height="30">
      <td><b><%= LanguageUtil.get(pageContext,"com.vportal.portlet.vfaqcontent.default-question-number") %>: </b></td>
      <td>
	  	  <select name="<portlet:namespace />questionNumber">
			<%for (int i = 5; i < 30;i=i+5) {%>
				<option value="<%= i %>" <%= (Integer.valueOf(questionNumber) == i) ? "selected" : "" %>><%= i %></option>
			<%}%>
		</select>								  
		</td>
   </tr>	
				
	<tr height="30">
		<td><b><%= LanguageUtil.get(pageContext,"com.vportal.portlet.vfaqcontent.other-question-number") %>: </b></td>
		<td>
			<select name = "<portlet:namespace/>otherQuestionNumber">
				<%for(int i = 5; i < 20;i=i+5){%>	
					<option value="<%= i%>" <%=(Integer.valueOf(otherQuestionNumber) == i)? "selected" : "" %>> <%= i%></option>
				<%}%>
			</select>				
		</td>
	</tr>					
	</table>
	</td>	
</tr>
</table>					
</fieldset>
						
<div class="portlet-font" style="float:left; margin:10px">
	<input type="button" class="portlet-form-button" value="<liferay-ui:message key="save" />" onClick="<portlet:namespace />savePreferences();" />
</div>
<br><br>
</form>
