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

<%
	
	String redirect = ParamUtil.getString(request, "redirect");
	String articleId = ParamUtil.getString(request,"articleIds");
	String tabs = ParamUtil.getString(request,"tabs2");
	
	VcmsArticle article = VcmsArticleServiceUtil.getArticle(articleId);	
	
	String title = article.getTitle();
	String leadArticle = HtmlExt.welform(article.getLead(), false);
	
	int ch = 185;
	int ch1 = 65;
	int space = 0;
	if(leadArticle.length()>ch){
		  space = leadArticle.indexOf(" ",ch);
		  if(space>0){
			  leadArticle = leadArticle.substring(0,space) + " ...";
		  }
	}
	
	if(title.length()>ch1){
		  space = title.indexOf(" ",ch1);
		  if(space>0){
			  title = title.substring(0,space) + " ...";
		  }
	}
%>

<script type="text/javascript">
	function <portlet:namespace />cancelAPArticle() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "cancel_send";
		submitForm(document.<portlet:namespace />fm,'<portlet:actionURL name="publishArticle" windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="publish" value="false" /></portlet:actionURL>');
	}
</script>

<form action="<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>">
	</portlet:actionURL>" method="post" name="<portlet:namespace />fm" onSubmit="<portlet:namespace />cancelAPArticle(); return false;">
<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="">
<input name="<portlet:namespace />redirect" type="hidden" value="<%= redirect %>">
<input name="<portlet:namespace />articleIds" type="hidden" value="<%= article.getArticleId() %>">
<input name="<portlet:namespace />groupId" type="hidden" value="<%= groupId %>">
<input name="<portlet:namespace />tabs2" type="hidden" value="<%=tabs%>">

<liferay-ui:tabs names="<%= LanguageUtil.get(pageContext, \"widthdraw\") %>" backURL="<%= redirect %>" />
	
<table border="0" cellpadding="4" cellspacing="0" width="100%">
<tr>
	<td align="left">
		<b><font  style="font-size: 13pt; font-family: tahoma, arial"><%= title %></font></b><br/>
		<%if (article.getHasImage()){%>			
			<img width="80" height="60" style="float: left; padding-right: 5px;border-color:#999999"  src="<%= themeDisplay.getPathImage() + "/images?img_id=" + WebKeysExt.VCMS_ARTICLE_SMALL_IMAGE_KEY + article.getArticleId() %>" border="1" />
		<%} else {%>
			<img width="80" height="60" style="float: left; padding-right: 5px;" src="/html/portlet/vcms/images.jpg" />
		<%}%>	
		<%=leadArticle%>		
	</td>
</tr>
</table>
	
<div class="beta-separator"></div><br>
	
<table border="0" cellpadding="4" cellspacing="0" width="100%">
	<tr>
		<td align="left" width="100%" valign="top">
			<fieldset style="border:1px solid gray">
				<legend><%= LanguageUtil.get(pageContext, "portlet.vcms.article.cancel-ap.attached-message") %></legend>
				<table border="0" cellpadding="4" cellspacing="0" width="100%">
					<tr>
						<td align="left" width="100%">
							<textarea name="<portlet:namespace />attachedMessage" rows="10" style="border:1px dotted gray; font-family: verdana, arial, tahoma; font-size: 13px; padding: 10px; width: 97%"></textarea>
						</td>
					</tr>
				</table>
			</fieldset>
		</td>
	</tr>
</table>
<br/>
<table border="0" cellpadding="4" cellspacing="0" width="100%">
	<tr>
		<td align="center" width="100%" valign="top">
			
			<input class="portlet-form-button" type="submit" value="<%= LanguageUtil.get(pageContext, "widthdraw") %>">
			
			<input class="portlet-form-button" type="button" value="<%= LanguageUtil.get(pageContext, "back") %>" onClick="self.location = '<%= redirect %>';">
			
		</td>
	</tr>
</table>
</form>
<script type="text/javascript">
	document.<portlet:namespace />fm.<portlet:namespace />attachedMessage.focus();
</script>
