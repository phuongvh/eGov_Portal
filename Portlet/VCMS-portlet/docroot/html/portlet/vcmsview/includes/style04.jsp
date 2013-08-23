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
		if(Validator.isNotNull(selectCategories)){
			for(int i=0; i<selectCategories.length; i++){
				VcmsCategory category = VcmsCategoryServiceUtil.getCategory(selectCategories[i]);
				if(Validator.isNotNull(category)){
				%>
					<table width="100%" align="center" class="new-vb org" border="0" cellspacing="0" cellpadding="0">
		              <tr>
		                <th class="t4"><%= category.getName() %></th>
		              </tr>
		              <tr>
		                <td>
		                  <table class="f-table" align="center" border="0" cellspacing="0" cellpadding="0">
		                    <tr>
		                      <td><a href="#"><img src="<%= category.getHasImage() ? ("/image/images?img_id="+category.getImage()):"/html/portlet/vcmsview/images/f01.gif" %>" width="156" height="101" border="0"></a></td>
		                    </tr>
		                  </table></td>
		              </tr>
		            </table>
				<%
				}
			}
		}
		%>
