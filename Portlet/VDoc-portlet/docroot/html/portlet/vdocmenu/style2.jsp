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

<%PortletURL fieldURL = renderResponse.createRenderURL();
	fieldURL.setParameter("jspPage","/html/portlet/vdocmenu/view_sub_menu.jsp");	
List listFieldByParent = null;%>
<form name="<portlet:namespace/>fm" method="POST">
<table width="100%">
		<tr height="3"><td colspan="3"></td></tr>
		<tr class="center_top_background">
			<td id="left_top_tab"></td>		    			
			<td>
				<div align="left" class="title1"><%=title%></div>
			</td>
			<td id="right_top_tabs"></td>
		</tr>
	</table>
	<table width="100%" cellspacing="0" cellpadding="0" border="0">
		<tr>		
			<td class="boder_top" bgcolor="#FFFFFF" style="padding-top:0px;">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
			 	   <%	
						String arrfields[] = StringUtil.split(fields,StringPool.COMMA);		
							for(int i=0;i<arrfields.length;i++){														
								vdocField field = (vdocField)vdocFieldServiceUtil.getField(arrfields[i]);
								int count = vdocDocumentServiceUtil.countDocByG_L_F_S(field.getGroupId(), field.getLanguage(), field.getFieldId(), 2);
								
								if(field.getParentId().equals("0")){															
									fieldURL.setParameter("fieldId",field.getFieldId());
									fieldURL.setParameter("field_parent",field.getFieldId());
					%>       
					 <tr>  												    
						<td width="5"></td>													
						<td align="left" class="<%=(i==0)?"title_menu_first":"title_menu_tt" %>">
							<a href="<%=fieldURL%>">&nbsp;<%=field.getName()%> (<%=count%>)</a>
						</td>
						<td width="5"></td>													
					 </tr> 
					  
					
				 	  <%}}%>	  
				</table>
			</td>
		</tr>
	</table>						               
							                
	<table width="100%">
		<tr>
			<td width="4"><img src="<%= themeDisplay.getPathThemeImage() %>/HN_image/i_34.gif" width="4" height="4"/></td>
			<td id="center_bottom_background"></td>
			<td width="4"><img src="<%= themeDisplay.getPathThemeImage() %>/HN_image/i_35.gif" width="4" height="4"/></td>
		</tr>
		<tr height="3"><td colspan="3"></td></tr>
	</table>								
</form>