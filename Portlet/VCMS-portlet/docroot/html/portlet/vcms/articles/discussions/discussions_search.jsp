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
<input type="hidden" name="<portlet:namespace />flag-search" value="true"/>
<input type="hidden" name="<portlet:namespace />articleId" value="<%=(Validator.isNotNull(articleId))?articleId:""%>"/>
	
<table width="100%" border="0" align="center" class="portlet-section-body">	
<tr height="30">	
	<td width="15%">
		<b><%= LanguageUtil.get(pageContext, "portlet.vcms.discussion.display") %> :</b></td>
	<td colspan="2">
		<select name="<portlet:namespace />showApproved" onChange="javascript:<portlet:namespace />submitForm();">			
			<option value="false" <%= !showApproved ? "selected" : "" %>><%= LanguageUtil.get(pageContext, "portlet.vcms.discussion.approval-pending") %></option>
			<option value="true" <%= showApproved ? "selected" : "" %>><%= LanguageUtil.get(pageContext, "portlet.vcms.discussion.approved") %></option>
		</select>
	</td>
</tr>
<tr height="30">		
	<td width="15%">
		<b><%= LanguageUtil.get(pageContext, "portlet.vcms.discussion.search.keyword") %> :</b>
	</td>
	<td width="50%">
		<input class="form-text" name="<portlet:namespace />keyword-discussion" size="60" type="text" value="<%=Validator.isNotNull(keyword_discussion)?keyword_discussion:""%>">
	</td>
	<td><input class="portlet-form-button" type="button" value="<%= LanguageUtil.get(pageContext, "search") %>" onclick="javascript:<portlet:namespace />doSearchDiscussions()"></td>	
</tr>
	
<tr height="30">		
	<td width="15%">
		<b><%= LanguageUtil.get(pageContext, "portlet.vcms.discussion.search.option") %> :</b>
	</td>
	<td colspan="2">
		<input class="form-text" name="<portlet:namespace />checkbox-title-discussion" id="<portlet:namespace />checkbox-title-discussion" type="checkbox" <%=(isTitleDiscussion)?"checked":""%>>
			<label for="<portlet:namespace />checkbox-title-discussion"><%= LanguageUtil.get(pageContext, "portlet.vcms.discussion.search.title-discussion")%></label>
		&nbsp;&nbsp;
		<input class="form-text" name="<portlet:namespace />checkbox-content-discussion" id="<portlet:namespace />checkbox-content-discussion" type="checkbox" <%=(isContentDiscussion)?"checked":""%>>
			<label for="<portlet:namespace />checkbox-content-discussion"><%= LanguageUtil.get(pageContext, "portlet.vcms.discussion.search.content-discussion")%></label>
		&nbsp;&nbsp;
		<select name="<portlet:namespace />selectAndOrDiscussion" onchange="javascript:<portlet:namespace />submitForm();">
			<option value="0" <%=Validator.equals(selectAndOrDiscussion,"0")?"selected":""%>><%= LanguageUtil.get(pageContext, "portlet.vcms.discussion.search.select-or") %> </option>
			<option value="1" <%=Validator.equals(selectAndOrDiscussion,"1")?"selected":""%>><%= LanguageUtil.get(pageContext, "portlet.vcms.discussion.search.select-and") %></option>
		</select>
	</td>	
</tr>	
</table>	
