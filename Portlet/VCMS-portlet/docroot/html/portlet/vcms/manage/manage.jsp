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
/**
 * Copyright (c) 2000-2006 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
%>
<%
	String tabs2Names = "";

	if(showTabPortions){
		tabs2Names += "portlet.vcms.tabs.portion";
	}
	if(showTabCategorys){
		tabs2Names += ",portlet.vcms.tabs.category";
	}	
	if(showAddStatus){
		tabs2Names += ",portlet.vcms.tabs.manage-status";
	}
	
	if(showTabType){
		tabs2Names += ",portlet.vcms.tabs.type";
	}
	if(showTabConfigs){
		tabs2Names += ",portlet.vcms.tabs.configuration";
	}
%>
    <liferay-ui:tabs names="<%= tabs2Names %>" url="<%=portletURL.toString()%>" param="tabs2"/>
	 <c:choose>
			<c:when test='<%= tabs2.equals("portlet.vcms.tabs.type") && showTabType %>'>
				<%@ include file="/html/portlet/vcms/manage/type/types.jsp"%>
			</c:when>
			<c:when test='<%= tabs2.equals("portlet.vcms.tabs.manage-status") && showAddStatus %>'>
				<%@ include file="/html/portlet/vcms/manage/status/status.jsp" %>
			</c:when>
			<c:when test='<%= tabs2.equals("portlet.vcms.tabs.configuration") && showTabConfigs %>'>
				<%@ include file="/html/portlet/vcms/manage/configuration.jsp" %>
			</c:when> 
			<c:when test='<%= tabs2.equals("portlet.vcms.tabs.category") && showTabCategorys %>'>
				<%@ include file="/html/portlet/vcms/manage/categories/categories.jsp" %>
			</c:when>
			<c:when test='<%=  showTabPortions %>'>
				<%@ include file="/html/portlet/vcms/manage/portion/portions.jsp" %>
			</c:when>
			<c:otherwise>
				<p>B&#7841;n kh&#244;ng c&#243; quy&#7873;n xem n&#7897;i dung n&#224;y.</p>
			</c:otherwise>
	</c:choose> 