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
<%@ include file="/html/portlet/vcms/init.jsp" %>
<style type="text/css">
button_close{
margin: 0 auto;
}
</style>
<%
	
	String articleId = ParamUtil.getString(request,"articleId");
	List listMessages = null;
	if(Validator.isNotNull(articleId)){
		listMessages = (List) VcmsAttachedMessageServiceUtil.getMessages(articleId);
	}
	
	if(listMessages!= null && listMessages.size()>0){
		for(int i=0;i<listMessages.size();i++){
			VcmsAttachedMessage message = (VcmsAttachedMessage)listMessages.get(i);
%>
	<table width="100%">
		<tr>
			<td height="30px">
				<img src="<%=themeDisplay.getPathThemeImage()%>/vcms/message-notation.gif" valign="middle" />
					<b><%=message.getContent()%></b>
				<div class="beta-separator"></div>
			</td>
		</tr>
	</table>
<%}
	}%>
