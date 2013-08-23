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
<%@ include file="/html/portlet/vcms/init.jsp" %>
<script language="javascript">
	function <portlet:namespace />save(){		
		
		var content = document.getElementsByName("<portlet:namespace />messageContent");
		alert(content.value);
		
		//var content = document.<portlet:namespace/>fm.<portlet:namespace/>messageContent.value;
		//document.<portlet:namespace />fm.<portlet:namespace />messageContent.value = content;				
		//document.getElementById('<portlet:namespace />articlesMessage').innerHTML = '[<a href="#addMessage" onClick="javascript:<portlet:namespace />showFormMessage()"><%= LanguageUtil.get(pageContext, "portlet.vcms.article.edit.add-message") %>...</a>] ' + '<br/>'+content;
	}
	
</script>	
	

	
<table cellspacing="0" cellpadding="4" width="100%" border="0">	
<tr>	
	<td valign="top"><%= LanguageUtil.get(pageContext, "portlet.vcms.article.message.content") %> :</td>	
	<td>
		<input type="text" name="<portlet:namespace />messageContent" style="width:250px;" value="" />
	</td>
</tr>
		
<tr>
	<td align="center" colspan="2">
		<input class="form-button" type="button" value="<liferay-ui:message key="save" />" style="margin: 10px" onClick="javascript:<portlet:namespace />save();"/>
		<input class="form-button" type="button" value="<liferay-ui:message key="close" />" style="margin: 10px" onClick="Liferay.Popup.close(this);"/>
	</td>		
</tr>
