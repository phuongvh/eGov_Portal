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

<%@page import="com.vportal.portlet.vfaq.service.FAQCategoryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%
	boolean showAddButton = showButtons && PortletPermissionUtil.
	contains(permissionChecker , plid.longValue(), WebKeysExt.VFAQ, ActionKeysExt.ADD_CATEGORY);	
	
	boolean showDeleteButton = showButtons && PortletPermissionUtil.
	contains(permissionChecker , plid.longValue(), WebKeysExt.VFAQ, ActionKeysExt.DELETE_CATEGORY);		

	PortletURL rootURL = renderResponse.createRenderURL();
	rootURL.setWindowState(WindowState.MAXIMIZED);
	rootURL.setParameter("tabs1", tabs1);
	rootURL.setParameter("jspPage", "/html/portlet/vfaq/view.jsp");
	rootURL.setParameter("redirect", currentURL);
	rootURL.setParameter("language", language);	
	rootURL.setParameter("groupId", String.valueOf(groupId));
	
	portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("jspPage","/html/portlet/vfaq/edit_category.jsp");
	portletURL.setParameter("tabs1", tabs1);
	portletURL.setParameter("redirect", redirectURL.toString());
	
	PortletURL subFieldURL = renderResponse.createRenderURL();	
	subFieldURL.setWindowState(WindowState.MAXIMIZED);
	subFieldURL.setParameter("jspPage", "/html/portlet/vfaq/view.jsp");
	subFieldURL.setParameter("tabs1", tabs1);
	subFieldURL.setParameter("redirect", currentURL);
	subFieldURL.setParameter("language", language);	
	subFieldURL.setParameter("groupId", String.valueOf(groupId));
	String listParent="";
	String listURL = "";
	String parentId[] = null;	
	
	if(!parentId1.equals(StringPool.BLANK)&&!parentId1.equals("0")){
		listParent = ActionUtil.getListParentCategory(Long.parseLong(parentId1));
		parentId = listParent.split(",");
		
	}
	
	if(!listParent.equals("")){
		listURL = "<a href=\""+rootURL.toString()+"\">Th&#432; m&#7909;c g&#7889;c</a>";
		for(int i=parentId.length-1;i>=0;i--){
			FAQCategory category = FAQCategoryLocalServiceUtil.getCategory(Long.parseLong(parentId[i]));
			rootURL.setParameter("parentId1", Long.toString(category.getId()));	
			listURL = listURL +" >> " + "<a href=\""+rootURL.toString()+"\">"+category.getName()+"</a>";
		}

	}

	List headerNames = new ArrayList();
	headerNames.add("title");
	headerNames.add("description");
	headerNames.add("create-date");
	//headerNames.add("#question");
	headerNames.add("");
	SearchContainer searchCtn = new SearchContainer(renderRequest,null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA,
			rootURL, headerNames, null);	
	searchCtn.setEmptyResultsMessage("there-are-no-categorys");	
	
	
	List results = FAQCategoryLocalServiceUtil.getByG_L_P(groupId, language, Long.parseLong(parentId1) ,searchCtn.getStart(), searchCtn.getEnd());	
	int total = FAQCategoryLocalServiceUtil.countByG_L_P(groupId, language, Long.parseLong(parentId1));	
	
	searchCtn.setRowChecker(new RowChecker(renderResponse));
	//searchCtn.setDelta(20);
	searchCtn.setTotal(total);
	searchCtn.setResults(results);
	
	List resultRows = searchCtn.getResultRows();
	for (int i = 0; i < results.size(); i++) {
		FAQCategory category = (FAQCategory) results.get(i);
		ResultRow row = new ResultRow(category, category.getPrimaryKey(),i);

		//title
		PortletURL rowURL = renderResponse.createRenderURL();
		rowURL.setWindowState(WindowState.MAXIMIZED);
		rowURL.setParameter("jspPage", "/html/portlet/vfaq/view.jsp");
		rowURL.setParameter("categoryId", Long.toString(category.getId()));
		rowURL.setParameter("parentId1", Long.toString(category.getId()));
		rowURL.setParameter("tabs1", tabs1);
		rowURL.setParameter("redirect", redirectURL.toString());
		
		StringBuffer sb = new StringBuffer();
		
		List children = new ArrayList();
		int childrenCount = 0;
		
		children = (List)FAQCategoryLocalServiceUtil.getByG_L_P(groupId, language, category.getId());
		childrenCount = FAQCategoryLocalServiceUtil.getByG_L_P(groupId, language, category.getId()).size();
			
		
		sb.append("<table cellspacing='3' cellpadding='0' width='100%' border='0'>");
		sb.append("<tr>");
		sb.append("<td width='1%'><img src='" + themeDisplay.getPathThemeImage() + "/vcms/category.gif' valign='middle' /></td>");
		sb.append("<td width='99%'><b><a href=\""+	rowURL.toString()+"\">" + category.getName() + "</a></b></td>");
		sb.append("</tr>");	
		
		if (childrenCount > 0) {
			sb.append("<tr>");
			sb.append("<td width='1%'><img src='" + themeDisplay.getPathThemeImage() + "/vcms/children.gif' valign='middle' /></td>");
			sb.append("<td width='99%' align='left'><span style='font-size: xx-small;'><b><u>" + LanguageUtil.get(pageContext, "portlet.vdoc.field.list.sub-org") + "</u>:");
			for (int j = 0; j < childrenCount; j ++) {
				FAQCategory child = (FAQCategory) children.get(j);
			
				subFieldURL.setParameter("categoryId",String.valueOf(child.getId()));
				subFieldURL.setParameter("parentId1",String.valueOf(child.getId()));
				sb.append("<a href=\""+subFieldURL.toString()+"\">"+child.getName()+"</a>");
				
				if (j < childrenCount - 1) {
					sb.append(", ");
				}
			}
			sb.append("</b></span></td>");
			sb.append("</tr>");
		}
		
		sb.append("</table>");
		
		row.addText(sb.toString());
		

		row.addText(FAQUtil.trimString(category.getDescription(), 100));
		row.addText(FAQUtil.dateParser(category.getCreatedDate()));		
		//row.addText("");
		row.addJSP("right", SearchEntry.DEFAULT_VALIGN, "/html/portlet/vfaq/button.jsp",application,request,response);
		
		resultRows.add(row);
		
	}
%>
<script type="text/javascript">
Liferay.provide(

        window,

        '<portlet:namespace />deleteCategory',

        function() {
		var listsChecked = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
		if(listsChecked != ""){	
			if (confirm('<%= LanguageUtil.get(pageContext, "pFAQ.title.confirm-delete-category") %>')) {
				document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.DELETE %>";
				document.<portlet:namespace />fm.<portlet:namespace />deleteCategoryIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
				submitForm(document.<portlet:namespace />fm, '<portlet:actionURL windowState="<%=WindowState.MAXIMIZED.toString()%>" name="deleteCategory"></portlet:actionURL>');
			}
		} else {
				alert("<%= LanguageUtil.get(pageContext, "portlet.vfaq.category.listchecked.warning")%>");	
		}	
	},

    ['liferay-util-list-fields']
);
</script>
<input name="<portlet:namespace />deleteCategoryIds" type="hidden" value="" />

<c:if test="<%=Validator.isNotNull(listURL)%>">	
<%=listURL %><br/><br/>
</c:if>	

	<c:if test="<%=showAddButton==true %>">
		<input type="button" value="<%=LanguageUtil.get(pageContext,"pFAQ.add.category") %>" onClick="self.location = '<%= portletURL %>';" />
	</c:if>
	<c:if test="<%=showDeleteButton %>">
		<input type="button" value="<%=LanguageUtil.get(pageContext,"delete") %>" onclick="<portlet:namespace />deleteCategory();" />
	</c:if>


<br/><br/>	
	
<liferay-ui:search-iterator searchContainer="<%= searchCtn %>" />
