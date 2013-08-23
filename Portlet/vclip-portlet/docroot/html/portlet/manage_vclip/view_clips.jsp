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
</script>


<%
//Kiem tra add button permission
boolean showAddClipButton = showButtons && PortletPermissionUtil.contains(permissionChecker , plid.longValue() , WebKeysVClip.Clip_type_id , ActionKeysClipExt.ADD_CLIP);

%>

<%
	ClipType searchClipType=new ClipTypeImpl();
	//searchClipType.setLanguage(language);
	
	List clipTypeList=ClipTypeServiceUtil.findClipType(searchClipType);
		
	List findedList = (List)request.getAttribute(WebKeysVClip.CLIP_RESULT_SEARCH);
	if(findedList==null){
		Clip searchClip=new ClipImpl();
		//searchClip.setLanguage(language);
		findedList=ClipServiceUtil.findClip(searchClip);
	}
%>

<portlet:renderURL var = "addClip"
		windowState="<%=WindowState.MAXIMIZED.toString()%>">
		<portlet:param name="type" value="clip" />
		<portlet:param name="jspPage" value="/html/portlet/manage_vclip/edit_clip.jsp" />
		<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.EDIT%>" />	
		<portlet:param name="tabs1" value="<%=tabs1%>" />
		<portlet:param name="language" value="<%=language %>" />
		<portlet:param name="redirect" value="<%=currentURL.toString()%>" />
</portlet:renderURL>
<c:if test="<%=showAddClipButton%>">
<input class="portlet-form-button" type="button" value="<%=LanguageUtil.get(pageContext,"vportal.vclip.addClip") %>" 
onClick="self.location = '<%=addClip %>';" >
</c:if>	
<br>
<input type="hidden" name="<%=Constants.CMD %>" value="<%=Constants.SEARCH %>"  >
	
	<input type="hidden" name="<%=Constants.CMD %>" value="<%=Constants.SEARCH %>"  >
	
<%
	List headerNames = new ArrayList();
	headerNames.add(StringPool.SPACE);
	headerNames.add(LanguageUtil.get(pageContext,"vportal.vclip.clip.name"));
	headerNames.add(LanguageUtil.get(pageContext,"vportal.vclip.clip.url"));
	headerNames.add(LanguageUtil.get(pageContext,"vportal.vclip.cliptitle.createdDate"));	
	headerNames.add(LanguageUtil.get(pageContext,"vportal.vclip.cliptitle.modifiedDate"));
	headerNames.add(StringPool.SPACE);
	portletURL.setParameter("language", language);
	
	int total = findedList.size();
	SearchContainer searchContainer = new SearchContainer(
			renderRequest, null, null,
			SearchContainer.DEFAULT_CUR_PARAM, 20, portletURL,
			headerNames, null);
	searchContainer.setTotal(total);

	List results = ListUtil.subList(findedList,
			searchContainer.getStart(), searchContainer.getEnd());
	searchContainer.setResults(results);
	List resultRows = searchContainer.getResultRows();
	
	List clipTypeFindedList=new ArrayList(clipTypeList);
	for(int i=0;i<clipTypeFindedList.size();i++){
		ClipType c=(ClipType)clipTypeFindedList.get(i);
		boolean b=false;
		for(int j=0;j<results.size();j++){
			Clip item=(Clip)results.get(j);
			if(item.getClipTypeId().equals(c.getId())){
				b=true;
				break;
			}
		}
		if(!b){
			clipTypeFindedList.remove(i);
			i=i-1;
		}
	}
	
	for(int j=0;j<clipTypeFindedList.size();j++){
		ClipType clipType=(ClipType)clipTypeFindedList.get(j);
		
		ResultRow cRow=new ResultRow(clipType,clipType.getId(),j);
		cRow.addText("");
		if(clipType.getTitle().length()<18){
			cRow.addText("<Strong>"+clipType.getTitle()+"<Strong>");
		}else{
			cRow.addText("<Strong>"+clipType.getTitle().substring(0,18)+"<Strong>");
		}
		
		cRow.addText("");
		cRow.addText("");
		cRow.addText("");
		cRow.addText("");
		//cRow.addText("");
		resultRows.add(cRow);
		
		int index=1;
		
		for (int i = 0; i < results.size(); i++) {
	
			Clip bean = (Clip) results.get(i);
			if (bean.getClipTypeId().equals(clipType.getId())) {
				ResultRow row = new ResultRow(bean, bean.getId(), i);
				
				PortletURL rowURL = renderResponse.createRenderURL();
				rowURL.setWindowState(WindowState.MAXIMIZED);
				rowURL.setParameter("jspPage", "/html/portlet/manage_vclip/view_clip_detail.jsp");
				rowURL.setParameter(Constants.CMD, Constants.VIEW);
				rowURL.setParameter("language", language);
				rowURL.setParameter(WebKeysVClip.CLIP_ID, bean.getId());
				rowURL.setParameter("redirect", currentURL.toString());
				rowURL.setParameter("tabs1", tabs1);
				
				row.addText(""+(index++), rowURL);
				//Name
				if(bean.getName().length()<40){
					row.addText(bean.getName(), rowURL);
				}else{
					row.addText(bean.getName().substring(0,40)+"...", rowURL);
				}
				
				//URL
				if(bean.getUrl().length()<20){
					row.addText(bean.getUrl(), rowURL);
				}else{
					row.addText(bean.getUrl().substring(0,20)+"...", rowURL);
				}
				
				//CreatedDate
				if(bean.getCreatedDate()==null){
					row.addText("", rowURL);
				}else{
					row.addText(""+formatter.format(bean.getCreatedDate()), rowURL);
				}
			
				//ModifiedDate
				if(bean.getModifiedDate()==null){
					row.addText("", rowURL);
				}else{
					row.addText(""+formatter.format(bean.getModifiedDate()), rowURL);
				}
				
				//Description
				/*
				String desc=" ";
				if(bean.getDescription().length()<100){
					desc += bean.getDescription();
				}else{
					desc += bean.getDescription().substring(0,100);
				}
				desc += "...";
				row.addText(desc, rowURL);
				*/
				// Action
				row.addJSP("right", SearchEntry.DEFAULT_VALIGN,
				"/html/portlet/manage_vclip/button_action.jsp",application,request,response);
		
				// Add result row
				resultRows.add(row);	
			}
		}
	}
%><liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
	
</fieldset>


	
	
	
	
	
	
	
	
	
	
	
	