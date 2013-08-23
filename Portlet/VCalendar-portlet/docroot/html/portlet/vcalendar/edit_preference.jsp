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
<%@ include file="/html/portlet/vcalendar/init.jsp" %>
<form action="<portlet:actionURL><portlet:param name="struts_action" value="/vcalendar/edit_preference" />
	</portlet:actionURL>" method="post" name="<portlet:namespace />fm1" >
<fieldset style="border:1px dotted gray">
<legend><b>C&#7845;u h&#236;nh l&#7883;ch c&#244;ng t&#225;c tu&#7847;n</b></legend>
<table cellpadding="0" cellspacing="0" width="100%" border="0">

 <tr>
  <td>
   <input type="text" name="<portlet:namespace />title" value="">
  </td>
 </tr> 
 <tr>
  <td height="5px">
  </td>
 </tr>

<tr>
 <td>
   <br>
   <input type="submit" value="<liferay-ui:message key="save" />" />
   
 </td>
</tr> 
</table>
</fieldset>  
</form>