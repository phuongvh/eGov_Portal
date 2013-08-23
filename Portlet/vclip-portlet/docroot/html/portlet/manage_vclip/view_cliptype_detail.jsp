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
<%	
	ClipType searchBean=(ClipType)request.getAttribute(WebKeysVClip.CLIP_TYPE);
	List clipList = null;
		
	if(searchBean==null){
		System.out.println("searchBean is null");
		searchBean=new ClipTypeImpl();
	}else{
		Clip searchClip=new ClipImpl();
		searchClip.setClipTypeId(searchBean.getId());
		
		clipList=ClipServiceUtil.findClip(searchClip);
	}
	
	if(clipList==null){
		System.out.println("clipList is null");
		clipList=new ArrayList();
	}
	
%>
<liferay-ui:tabs names="<%=tab1Names %>" url="<%=portletURL.toString() %>">		
</liferay-ui:tabs>
<fieldset>
<legend><%=LanguageUtil.get(pageContext,"vportal.vclip.result") %></legend>
<table align="center">
	<input type="hidden" name="<%=Constants.CMD %>" value="<%=Constants.SEARCH %>"  >
	<tr>		
		<td colspan="2" align="center"><Strong><%=LanguageUtil.get(pageContext,"vportal.vclip.cliptype.info") %><br></Strong></td>		
	</tr>
	<tr>
		<td><%= LanguageUtil.get(pageContext, "portlet.vcms.language") %>:</td>
		<td >
			<%/*
			for (int i = 0; i < locales.length; i++) {
				if(language.equals(locales[i].getLanguage() + "_" + locales[i].getCountry())){
			%>
					<input readonly="readonly"  size="60" name="language" value="<%= locales[i].getDisplayName(locales[i]) %>" >
			<% 	
					break;
				}
			}*/
			%>
		</td>
	</tr>		
	<tr>		
		<td><%=LanguageUtil.get(pageContext,"vportal.vclip.cliptitle.name") %>:</td>		
		<td><input readonly="readonly" size="60" name="name" value="<%=searchBean.getName() %>" ></td>		
	</tr>
	<tr>		
		<td><%=LanguageUtil.get(pageContext,"vportal.vclip.cliptitle.createdDate") %>:</td>		
		<td><input readonly="readonly"  size="60" name="createdDate" value="<%=(searchBean.getCreatedDate()==null)?"":formatter.format(searchBean.getCreatedDate() )%>" ></td>		
	</tr>
	<tr>		
		<td><%=LanguageUtil.get(pageContext,"vportal.vclip.cliptitle.modifiedDate") %>:</td>	
		<td><input readonly="readonly" size="60" name="modifiedDate" value="<%=(searchBean.getModifiedDate()==null)?"":formatter.format(searchBean.getModifiedDate())%>" ></td>		
	</tr>
	
	<tr>
		<td valign="top"><%=LanguageUtil.get(pageContext,"vportal.vclip.cliptitle.description") %>:</td>
		<td> </td>	
	</tr>
	
	<tr>
		<td colspan="2"><textarea readonly="readonly"  rows="5" cols="80"><%=searchBean.getDescription() %></textarea></td>
	</tr>
</table>
</fieldset>
<br>
<fieldset>
<legend><%=LanguageUtil.get(pageContext,"vportal.vclip.clip.list") %>:</legend>
<%
	List headerNames = new ArrayList();
	headerNames.add(StringPool.SPACE);
	headerNames.add(LanguageUtil.get(pageContext,"vportal.vclip.clip.name"));
	headerNames.add(LanguageUtil.get(pageContext,"vportal.vclip.clip.url"));
	headerNames.add(LanguageUtil.get(pageContext,"vportal.vclip.cliptitle.createdDate"));	
	//headerNames.add(LanguageUtil.get(pageContext,"vportal.vclip.cliptitle.description"));
	headerNames.add(StringPool.SPACE);
	
	portletURL.setParameter("language", language);
	
	int total = clipList.size();
	SearchContainer searchContainer = new SearchContainer(
			renderRequest, null, null,
			SearchContainer.DEFAULT_CUR_PARAM, 20, portletURL,
			headerNames, null);
	searchContainer.setTotal(total);

	// Row checker
	//RowChecker rowChecker = new RowChecker(renderResponse);
	//searchContainer.setRowChecker(rowChecker);

	List results = ListUtil.subList(clipList,
			searchContainer.getStart(), searchContainer.getEnd());
	searchContainer.setResults(results);
	List resultRows = searchContainer.getResultRows();

	int index=1;
	for (int i = 0; i < results.size(); i++) {

		Clip bean = (Clip) results.get(i);

		ResultRow row = new ResultRow(bean, bean.getId(), i);

		PortletURL rowURL = renderResponse.createRenderURL();
		rowURL.setWindowState(WindowState.MAXIMIZED);
		rowURL.setParameter("struts_action", "/vclip/clip");
		rowURL.setParameter(Constants.CMD, Constants.VIEW);
		rowURL.setParameter(WebKeysVClip.CLIP_ID, bean.getId());
		rowURL.setParameter("redirect", currentURL.toString());
		rowURL.setParameter("tabs1", tabs1);
		
		row.addText(""+index++, rowURL);
		
		//name
		if(bean.getName().length() < 40){
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
		
		//Description
		/*
		if(bean.getDescription().length()<20){
			row.addText(bean.getDescription(), rowURL);
		}else{
			row.addText(bean.getDescription().substring(0,20)+"...", rowURL);
		}
		*/
		// Action
		row.addJSP("right", SearchEntry.DEFAULT_VALIGN,
		"/html/portlet/vclip/button_action.jsp");

		// Add result row
		resultRows.add(row);
	}
%><liferay-ui:search-iterator searchContainer="<%=searchContainer%>" /><liferay-ui:search-paginator searchContainer="<%=searchContainer%>" />
</fieldset>
<br>
<table align="center">
  <tr>    
    <td> 
    	<input class="portlet-form-button" type="button" value="<%=LanguageUtil.get(pageContext,"vportal.vclip.cancel") %>"
			onclick="javascript:document.location='<portlet:renderURL>
			<portlet:param name="struts_action" value="/vclip/clip" />
			<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.CANCEL%>" />
			<portlet:param name="language" value="<%=language %>" />
			<portlet:param name="tabs1" value="<%=tabs1%>" />
		</portlet:renderURL>'" >
	</td>
  </tr>
</table>

	
	
	
	
	
	
	
	
	
	
	
	
	