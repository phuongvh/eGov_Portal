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

<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@ include file="/html/portlet/vdocmenu/init.jsp" %>
<table width="100%">
<%	
	String parentId = ParamUtil.getString(request, "field_parent");
	PortletURL fieldURL = PortletURLFactoryUtil.create(request, portletSelectId, plid, PortletRequest.RENDER_PHASE);
	List listFieldByParent = (List)vdocFieldServiceUtil.getFieldByG_L_P(groupId ,language ,parentId);
	if(Validator.isNotNull(listFieldByParent) && listFieldByParent.size()>0){
		for(int j=0;j<listFieldByParent.size();j++){
			vdocField subField = (vdocField)listFieldByParent.get(j);
				fieldURL.setParameter("fieldId",subField.getFieldId());
// 				fieldURL.setParameter("field_parent",field.getFieldId());
			int	countDoc = vdocDocumentServiceUtil.countDocByG_L_F(subField.getGroupId(),subField.getLanguage(), subField.getFieldId());
%>	
	
	<tr>
		<td>
			&nbsp;&nbsp;&nbsp;<a href="">- <%=subField.getName()%> (<%=countDoc%>)</a>	</div>
		</td>
	</tr>	
<%}}%>

</table>



