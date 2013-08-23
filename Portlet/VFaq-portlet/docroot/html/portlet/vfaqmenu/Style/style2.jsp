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

<style>
	div.menu-faq {
    background-color: #4B8BC4;
    border: 1px solid white;    
    height: 30px;
}

	div.menu-faq a,div.menu-faq p{
	color: white;
	font-weight: bold;
	padding-left: 10px;
	line-height: 30px;
	}
	
	div.menu-faq a:hover{
		color: tan;
	}
	table td {
    	border: 0px;
	}
	table th, table td {
	    padding: 0px;
	    text-align: left;
	}
</style>	
<table class="vfaq-menu" cellspacing="0" cellpadding="0" border="0" width="100%">
	<tr>
		<td>
			<div class="menu-faq">
				<p align="center" style="font-size: 14px;">
					<%=titlePortlet %>
				</p>
			</div>
		</td>			
	</tr>
	
	<tr>				 
	   <td align="left" valign="top" class="bg_04" height="100%">
		<%	for (int i=0;i<contactList.size();i++){	
				FAQCategory g = (FAQCategory)contactList.get(i);
					categoryURL.setParameter("categoryId",String.valueOf(g.getId()));								
		%>
	   		<div class="menu-faq">
		   		<a class="menuleft2" href="<%=categoryURL%>">		   			   			
		   			<%=StringUtil.shorten(HtmlUtil.extractText(g.getName()),42)%>
		   		</a>			   	
		   	</div>
		<%
			}
		%>
	   	</td>  
	</tr>
	<tr><td bgcolor="#CAE0FF" height="10"></td></tr>
	
</table>