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
	  <table width="100%" class="intro-mode" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td>
		<%
		if(Validator.isNotNull(selectCategories)){
			for(int i=0; i<selectCategories.length; i++){
				VcmsCategory category = VcmsCategoryServiceUtil.getCategory(selectCategories[i]);
				if(Validator.isNotNull(category)){
				%>
				    <a href="#"><img src="<%= category.getHasImage() ? ("/image/images?img_id="+category.getImage()):"/html/portlet/vcmsview/images/f01.gif" %>" width="158" height="88" border="0"></a>
					<p>&nbsp;</p>
				<%
				}
			}
		}
		%>
			</td>
        </tr>
      </table>
