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

<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="com.vportal.portlet.vdoc.service.vdocDocumentServiceUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="javax.portlet.RenderRequest" %>
<%@ page import="javax.portlet.RenderResponse" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>

<%@ page import="java.util.List" %>
<%@ page import="com.vportal.portlet.vdoc.service.util.ActionUtil" %>
<%@ page import="com.vportal.portlet.vdoc.model.vdocField" %>
<%@ page import="com.vportal.portlet.vdoc.model.impl.vdocFieldImpl"%>
<%@ page import="com.vportal.portlet.vdoc.service.vdocFieldService"%>
<%@ page import="com.vportal.portlet.vdoc.service.vdocFieldServiceUtil" %>

<portlet:defineObjects />
<liferay-theme:defineObjects/>
<%
	// Add field
	PortletURL addFieldURL = renderResponse.createRenderURL();
	addFieldURL.setParameter("jspPage","/html/portlet/vdoc_manage/general_manage/edit_field.jsp");
	
	// Render search container
	PortletURL renderTabFieldURL = renderResponse.createRenderURL();
	renderTabFieldURL.setParameter("jspPage","/html/portlet/vdoc_manage/view.jsp?tabs1=generalmanage-tab&tabs2=portlet.vdoc.general-manage.fields-tab");
	
	PortletURL subFieldURL = renderResponse.createRenderURL();
	subFieldURL.setParameter("jspPage", "/html/portlet/vdoc_manage/view.jsp?tabs1=generalmanage-tab&tabs2=field-tab");
	
	PortletURL fieldURL = renderResponse.createRenderURL();
 	// 	PortletURL updatePositionURL = renderResponse.createActionURL();
// 	updatePositionURL.setParameter(ActionRequest.ACTION_NAME, "updatePositionField");
	
	String listParent="";
	String listURL = "";
	
	String parentIds[]=null;	
	if(!parentId1.equals(StringPool.BLANK) && !parentId1.equals("0")){
		listParent = ActionUtil.getListParentField(parentId1);
		parentIds = listParent.split(",");
	}
	if(!listParent.equals("")){
		listURL = "<a href=\""+fieldURL.toString()+"\">Th&#432; m&#7909;c g&#7889;c</a>";
		for(int i=parentIds.length-1;i>=0;i--){
	vdocField vField = vdocFieldServiceUtil.getField(parentIds[i]);
	fieldURL.setParameter("parentId1", vField.getFieldId());	
	listURL = listURL +" >> " + "<a href=\""+fieldURL.toString()+"\">"+vField.getName()+"</a>";
		}
	}
%>

<input type="button" value='<%=LanguageUtil.get(pageContext, "portlet.vdoc.add-field")%>' onclick="window.location.href='<%=addFieldURL.toString()%>' " />
<br/>
<%=listURL%>

<br/><br/>
<%
	List<vdocField> listVdocField = vdocFieldServiceUtil.getFieldByG_L_P(groupId,language,parentId1);
	int count = vdocFieldServiceUtil.countFieldByG_L_P(groupId,language,parentId1);
%>

<form method="post" name="<portlet:namespace />fm" onsubmit="submitForm(this); return false;">
<liferay-ui:search-container emptyResultsMessage='<%=LanguageUtil.get(pageContext, "portlet.vdoc.general-manage.field.empty-result-message")%>' delta="15" iteratorURL="<%=renderTabFieldURL%>">
	<liferay-ui:search-container-results>
		<%
			results = ListUtil.subList(listVdocField, searchContainer.getStart(), searchContainer.getEnd());
			total = listVdocField.size();			
			pageContext.setAttribute("results", results);
			pageContext.setAttribute("total", total);
		%>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="com.vportal.portlet.vdoc.model.vdocField" modelVar="field" keyProperty="fieldId">
		<%			
			List<vdocField> children = vdocFieldServiceUtil.getFieldByG_L_P(groupId, language, field.getFieldId());
			int childrenCount = 0;
			childrenCount = children.size();
			
			PortletURL rowURL = renderResponse.createRenderURL();
			rowURL.setParameter("jspPage", "/html/portlet/vdoc_manage/view.jsp?tabs1=generalmanage-tab&tabs2=field-tab");
			rowURL.setParameter("parentId1", field.getFieldId());
			
			StringBuffer sb = new StringBuffer();
			sb.append("<table cellspacing='3' cellpadding='0' width='100%' border='0'>");
			sb.append("<tr>");
			sb.append("<td width='1%'><img src='" + themeDisplay.getPathThemeImages() + "/phutho2012/category.gif' valign='middle' /></td>");
			sb.append("<td width='99%'><b><a href=\""+	rowURL.toString()+"\">" + field.getName() + "</a></b></td>");
			sb.append("</tr>");		
			
			if (childrenCount > 0) {
				sb.append("<tr>");
				sb.append("<td width='1%'><img src='" + themeDisplay.getPathThemeImages() + "/phutho2012/children.gif' valign='middle' /></td>");
				sb.append("<td width='99%' align='left'><span style='font-size: xx-small;'><b><u>" + LanguageUtil.get(pageContext, "portlet.vdoc.field.list.sub-field","sub-field") + "</u>:");
				for (int j = 0; j < childrenCount; j ++) {
					vdocField child = (vdocField) children.get(j);
				
					subFieldURL.setParameter("fieldId",child.getFieldId());
					subFieldURL.setParameter("parentId1",child.getFieldId());
					sb.append("<a href=\""+subFieldURL.toString()+"\">"+child.getName()+"</a>");
					
					if (j < childrenCount - 1) {
						sb.append(", ");
					}
				}
				sb.append("</b></span></td>");
				sb.append("</tr>");
			}
			
			sb.append("</table>");
		%>
			<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(pageContext, "portlet.vdoc.general-manage.name-fields") %>' value='<%= field.getFieldId() %>' />
		<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(pageContext, "portlet.vdoc.general-manage.name-fields") %>' value='<%= sb.toString() %>' />
		<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(pageContext, "portlet.vdoc.general-manage.position") %>'>
			<select name="<portlet:namespace/>position"  onchange="javascript:<portlet:namespace/>updatePosition(this);">
			<% for(int i =0; i < count ; i++){ %>
				<option value="<%= i+1 +"|" + field.getPrimaryKey() %>" <%=(field.getPosition() == (i+1)) ? "selected" : "" %> ><%= i+1 %>  </option>
				<%} %>
			</select>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(pageContext, "portlet.vdoc.general-manage.num-doc") %>' value="<%= String.valueOf(vdocDocumentServiceUtil.countDocByG_L_F(groupId, language, field.getFieldId()))  %>" />
		<liferay-ui:search-container-column-jsp path="/html/portlet/vdoc_manage/general_manage/field_actions.jsp" align="right"/>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
</liferay-ui:search-container>
</form>

<portlet:actionURL name="updatePositionField" var="updatePositionFieldURL" />
<script type="text/javascript">
	function <portlet:namespace/>updatePosition(selector){
		//document.<portlet:namespace/>fm.<portlet:namespace/>position.value  = selector.value;
		submitForm(document.<portlet:namespace />fm, '<%=updatePositionFieldURL.toString() %>');
		//alert(selector.value);
	};
</script>


