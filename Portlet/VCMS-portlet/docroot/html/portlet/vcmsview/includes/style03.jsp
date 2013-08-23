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
		<%
		if(Validator.isNotNull(selectCategories) && selectCategories.length > 0){
			%>
			<table width="100%" class="box-left" border="0" cellspacing="0" cellpadding="0">
	          <tr>
	            <td>
			<%
			for(int i=0; i<selectCategories.length; i++){
				VcmsCategory category = VcmsCategoryServiceUtil.getCategory(selectCategories[i]);
				if(Validator.isNotNull(category)){
						%>
						<a <%= i==0?"class=\"top\"":"" %> href="<portlet:renderURL><portlet:param name="struts_action" value="/vcmsview/view" /><portlet:param name="catId" value="<%= String.valueOf(category.getCategoryId()) %>" /></portlet:renderURL>"><%= category.getName() %></a>
						<%
					String catId = ParamUtil.getString(renderRequest, "catId", "");
					String subCatId = ParamUtil.getString(renderRequest, "subCatId", "");
					if(Validator.isNotNull(subCatId)){
						VcmsCategory cat= VcmsCategoryServiceUtil.getCategory(subCatId);
						if(Validator.isNotNull(cat)){
							catId = String.valueOf(cat.getParentId());
						}
					}
					if(catId.equals(category.getCategoryId())){
						List subCats = VcmsCategoryServiceUtil.getCategoriesByParent(groupId, catId, language);
						if(Validator.isNotNull(subCats) && subCats.size() > 0){
						%>
					   <div class="sub-menu">
					    <%
					    for(int j=0; j<subCats.size(); j++){
					    	VcmsCategory cat = (VcmsCategory) subCats.get(j);
					    %>
					     <a <%= (i==subCats.size()-1)?"class=\"end\"":"" %> href="<portlet:renderURL><portlet:param name="struts_action" value="/vcmsview/view" /><portlet:param name="subCatId" value="<%= String.valueOf(cat.getCategoryId()) %>" /></portlet:renderURL>"><%= cat.getName() %></a>
					    <%
						}
					    %>
					   </div>
					<%
						}
					}
				}
			}
			%>
				</td>
	          </tr>
	        </table>
			<%
		}
		%>
