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
<input type="hidden" name="<portlet:namespace />flag-search-logger" value="true"/>
<div style="float: left; padding-right: 5px;">
	<b><%= LanguageUtil.get(pageContext, "portlet.vcms.logger.search.keyword") %>:</b>
</div>
<div style="float: left; padding-right: 5px;">
	<input class="form-text" name="<portlet:namespace />keyword-logger" size="20" type="text" value="<%=Validator.isNotNull(keyword_logger)?keyword_logger:""%>">
</div>
<div style="float: left; padding-right: 10px;">
	<b><%= LanguageUtil.get(pageContext, "portlet.vcms.logger.search.from") %>:</b>
	<liferay-ui:input-date
		disableNamespace="<%= false %>"
		formName='<%= renderResponse.getNamespace() + "fm" %>'
		monthParam="fromMonthLogger"
		monthValue="<%= fromMonthLogger %>"
		dayParam="fromDayLogger"
		dayValue="<%= fromDayLogger %>"
		yearParam="fromYearLogger"
		yearValue="<%=fromYearLogger %>"
		yearRangeStart="<%= curYear-1 %>"
		yearRangeEnd="<%= curYear+10 %>"
		firstDayOfWeek="<%= currentDate.getFirstDayOfWeek() - 1 %>"
		disabled="<%= false %>"
	/>
</div>
<div style="float: left; padding-right: 5px;">
	<b><%= LanguageUtil.get(pageContext, "portlet.vcms.logger.search.by") %>:</b>
</div>
<div style="float: left; padding-right: 15px;">
	<select name="<portlet:namespace />search-by-action" onchange="javascript:<portlet:namespace />submitForm();">
		<option value="5" selected><%= LanguageUtil.get(pageContext, "portlet.vcms.logger.search.action.1") %></option>
		<option value="0" <%=(Validator.isNotNull(select_action) && Validator.equals(select_action,"0"))?"selected":""%>><%= LanguageUtil.get(pageContext, "portlet.vcms.logger.search.action.2") %></option>
		<option value="1" <%=(Validator.isNotNull(select_action) && Validator.equals(select_action,"1"))?"selected":""%>><%= LanguageUtil.get(pageContext, "portlet.vcms.logger.search.action.3") %></option>
		<option value="2" <%=(Validator.isNotNull(select_action) && Validator.equals(select_action,"2"))?"selected":""%>><%= LanguageUtil.get(pageContext, "portlet.vcms.logger.search.action.4") %></option>
		<option value="3" <%=(Validator.isNotNull(select_action) && Validator.equals(select_action,"3"))?"selected":""%>><%= LanguageUtil.get(pageContext, "portlet.vcms.logger.search.action.5") %></option>
		<option value="4" <%=(Validator.isNotNull(select_action) && Validator.equals(select_action,"4"))?"selected":""%>><%= LanguageUtil.get(pageContext, "portlet.vcms.logger.search.action.6") %></option>
	</select>
</div>
<div style="float: left; padding-right: 5px">
	<input class="portlet-form-button" type="button" value="<%= LanguageUtil.get(pageContext, "search") %>" onclick="javascript:<portlet:namespace />doSearchLoggers()">
</div>
