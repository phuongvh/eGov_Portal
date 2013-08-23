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

<div class="wd-boxs" style="text-align: left">
	<h2 class="wd-tlh1-1 wd-alignment"><%=titlePortlet %></h2>
	<ul class="wd-list-link">
		<%	for (int i=0;i<contactList.size();i++){	
				FAQCategory g = (FAQCategory)contactList.get(i);
					categoryURL.setParameter("categoryId",String.valueOf(g.getId()));								
		%>
	   		
		   	<li><a href="<%=categoryURL%>"><%=StringUtil.shorten(HtmlUtil.extractText(g.getName()),42)%></a></li>
		<%
			}
		%>
	</ul>
</div>
