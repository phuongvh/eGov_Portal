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
	boolean showDeleteAllLogButton = showButtons && PortletPermissionUtil.contains(permissionChecker , plid.longValue() , PortletKeysExt.VCMS , ActionKeysExt.DELETE_ALL_LOG);
		// Initial date values
	Calendar currentDate = new GregorianCalendar();
	int curYear = currentDate.get(Calendar.YEAR);
	int curMonth = currentDate.get(Calendar.MONTH);
	int curDay = currentDate.get(Calendar.DATE);
	
		
	int fromDayLogger = ParamUtil.getInteger(request, "fromDayLogger", curDay);
	int fromMonthLogger = ParamUtil.getInteger(request, "fromMonthLogger", curMonth);
	int fromYearLogger = ParamUtil.getInteger(request, "fromYearLogger", curYear);
	
	Date dateFromLogger  = new GregorianCalendar(fromYearLogger, fromMonthLogger, fromDayLogger).getTime();
	
	String flag_search_logger = ParamUtil.getString(request,"flag-search-logger",StringPool.BLANK);
	String keyword_logger = ParamUtil.getString(request,"keyword-logger",StringPool.BLANK);
	String select_action = ParamUtil.getString(request,"search-by-action",StringPool.BLANK);	
	
List headerNames = new ArrayList();

headerNames.add("portlet.vcms.logger.list.content");
headerNames.add(StringPool.BLANK);

SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, headerNames, null);

RowChecker rowChecker = new RowChecker(renderResponse);
searchContainer.setRowChecker(rowChecker);
List results = null;
int total =0;
if(Validator.isNotNull(flag_search_logger) && Validator.equals(flag_search_logger,"true")){
	results = VcmsLoggerServiceUtil.findLogersByD_A_K(keyword_logger,Integer.parseInt(select_action),dateFromLogger,searchContainer.getStart(), searchContainer.getEnd());
	total = VcmsLoggerServiceUtil.countLogersByD_A_K(keyword_logger,Integer.parseInt(select_action),dateFromLogger);
}else{
	// Filter and get only appropriate portions to put into the searchContainer
	results = VcmsLoggerServiceUtil.findLogs(searchContainer.getStart(), searchContainer.getEnd());
	total = VcmsLoggerServiceUtil.countLogs();
}
searchContainer.setTotal(total);
searchContainer.setResults(results);
List resultRows = searchContainer.getResultRows();
for (int i = 0; i < results.size(); i++) {
	VcmsLogger logger = (VcmsLogger)results.get(i);
	
	ResultRow row = new ResultRow(logger, logger.getPrimaryKey().toString(), i);
	
	PortletURL rowURL = renderResponse.createRenderURL();
	
	rowURL.setWindowState(WindowState.MAXIMIZED);
	
	rowURL.setParameter("struts_action", "/vcms/edit_logger");
	rowURL.setParameter("redirect", currentURL);
	rowURL.setParameter("categoryId", logger.getLoggerId());
	
	// Name and description
	row.addText(logger.getContent());
	// Actions
	
	row.addJSP("right", SearchEntry.DEFAULT_VALIGN, "/html/portlet/vcms/logs/logs_action.jsp",application,request,response);
	
	// Add result row
	
	resultRows.add(row);
}

%>
	<!--<%@ include file="/html/portlet/vcms/logs/logs_search.jsp" %>
	<br><br><div class="beta-separator"></div><br>
	<c:if test="<%=(Validator.isNotNull(flag_search_logger) && Validator.equals(flag_search_logger,\"true\"))%>">
		<%if(results.size()>0){%>
			<b>K&#7871;t qu&#7843; tìm ki&#7871;m nh&#7853;t ký - T&#7893;ng s&#7889; nh&#7853;t ký tìm th&#7845;y : <%=results.size()%></b><br/>
		<%}else{%>
			<b>Không tìm th&#7845;y nh&#7853;t ký nào th&#7887;a mãn yêu c&#7847;u tìm ki&#7871;m!</b><br/>
		<%}%>
		(B&#7841;n &#273;ang tìm ki&#7871;m nh&#7853;t ký v&#7899;i t&#7915; khóa :<b>"<%=(Validator.isNotNull(keyword_logger))?keyword_logger:""%>"</b> T&#7915; ngày : <b><%=dateFormatDateTime.format(dateFromLogger)%></b> Theo tiêu chí : 
			<b><%
				switch(Integer.parseInt(select_action)){
					case 0 : out.print("Vùng bài vi&#7871;t");
						break;
					case 1 : out.print("Chuyên m&#7909;c bài vi&#7871;t");
						break;
					case 2 : out.print("Bài vi&#7871;t");
						break;
					case 3 : out.print("Th&#7843;o lu&#7853;n");
						break;
					case 4 : out.print("Lu&#7891;ng bài vi&#7871;t");
						break;
					case 5 : out.print("T&#7845;t c&#7843;");
						break;
				}
			%></b>)<br/><br/>
	</c:if>-->
<c:if test="<%=showDeleteAllLogButton%>">	
	<div class="portlet-font" style="float: left; margin-right: 10px">
		<input class="portlet-form-button" type="button" value='<%= LanguageUtil.get(pageContext, "portlet.vcms.button.delete") %>' onClick="javascript:<portlet:namespace />deleteLogs();" />
		<input type="hidden" name="<portlet:namespace />loggerIds" value="" />
	</div>
</c:if>
<br /><br />
<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
