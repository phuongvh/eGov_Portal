<%--/**
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
 */ --%>
<%@page import="com.vportal.portlet.vclip.util.WebKeysVClip"%>
<script>
	function <portlet:namespace />submit(){
		document.<portlet:namespace />fm.submit();
	}
	function setFocus(){
		document.<portlet:namespace />fm.<portlet:namespace />name.focus();
	}
</script>


<%
List allClipType =(List)request.getAttribute(WebKeysVClip.CLIP_TYPE_RESULT_SEARCH);
ClipType searchClipType = null;
	if(allClipType==null){
		searchClipType=new ClipTypeImpl();
	}
//Kiem tra add button permission
boolean showAddClipTypeButton = showButtons && PortletPermissionUtil.contains(permissionChecker , plid.longValue() , WebKeysVClip.Clip_type_id , ActionKeysClipExt.ADD_CLIPTYPE);
%>	
	
<portlet:renderURL var = "addClipType" windowState="<%=WindowState.MAXIMIZED.toString()%>">
		<portlet:param name="jspPage" value="/html/portlet/manage_vclip/edit_cliptype.jsp" />
		<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.EDIT%>" />	
		<portlet:param name="tabs1" value="<%=tabs1%>" />
		<portlet:param name="language" value="<%=language %>" />
		<portlet:param name="redirect" value="<%=currentURL.toString()%>" />
</portlet:renderURL>	
<c:if test="<%=showAddClipTypeButton%>">
<input class="portlet-form-button" type="button" value="<%=LanguageUtil.get(pageContext,"vportal.vclip.addClipType") %>" 
onClick="self.location = '<%=addClipType %>';" >
</c:if>
<br>
	
	<input type="hidden" name="<%=Constants.CMD %>" value="<%=Constants.SEARCH %>"  >

<%
	List headerNames = new ArrayList();
	headerNames.add(StringPool.SPACE);
	headerNames.add(LanguageUtil.get(pageContext,"vportal.vclip.cliptitle.title"));
	headerNames.add(LanguageUtil.get(pageContext,"vportal.vclip.cliptitle.name"));
	headerNames.add(LanguageUtil.get(pageContext,"vportal.vclip.cliptitle.createdDate"));	
	headerNames.add(LanguageUtil.get(pageContext,"vportal.vclip.cliptitle.description"));
	//headerNames.add("Action");
	headerNames.add(StringPool.SPACE);
	
	portletURL.setParameter("language", language);
	
	int total = ClipTypeServiceUtil.countClipType(searchClipType);
	SearchContainer searchContainer = new SearchContainer(
			renderRequest, null, null,
			SearchContainer.DEFAULT_CUR_PARAM, 20, portletURL,
			headerNames, null);
	searchContainer.setTotal(total);
	List results = ClipTypeServiceUtil.findClipType(searchClipType,searchContainer.getStart(), searchContainer.getEnd());
	List resultRows = searchContainer.getResultRows();
	searchContainer.setResults(results);
	int index=1;
	for (int i = 0; i < results.size(); i++) {

		ClipType bean = (ClipType) results.get(i);

		ResultRow row = new ResultRow(bean, bean.getId(), i);

		PortletURL rowURL = renderResponse.createRenderURL();
		rowURL.setWindowState(WindowState.MAXIMIZED);
		rowURL.setParameter(Constants.CMD, Constants.VIEW);
		rowURL.setParameter("language", language);
		rowURL.setParameter(WebKeysVClip.CLIP_TYPE_ID, bean.getId());
		rowURL.setParameter("redirect", currentURL.toString());
		rowURL.setParameter("tabs1", tabs1);
		
		row.addText(""+index++, rowURL);
		
		//Title
		if(bean.getTitle().length() < 20){
			row.addText(bean.getTitle(), rowURL);
		}else{
			row.addText(bean.getTitle().substring(0,20)+"...", rowURL);
		}
		
		//Name
		if(bean.getName().length()<20){
			row.addText(bean.getName(), rowURL);
		}else{
			row.addText(bean.getName().substring(0,20)+"...", rowURL);
		}
		
		//CreatedDate
		if(bean.getCreatedDate()==null){
			row.addText("", rowURL);
		}else{
			row.addText(""+formatter.format(bean.getCreatedDate()), rowURL);
		}
				
		//Description
		if(bean.getDescription().length()<20){
			row.addText(bean.getDescription(), rowURL);
		}else{
			row.addText(bean.getDescription().substring(0,20)+"...", rowURL);
		}
		// Action
		row.addJSP("right", SearchEntry.DEFAULT_VALIGN,
		"/html/portlet/manage_vclip/button_action.jsp",application,request,response);

		// Add result row
		resultRows.add(row);
	}
%>
<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
