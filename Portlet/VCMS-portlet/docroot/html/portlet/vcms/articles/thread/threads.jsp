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
boolean showAddThreadButton = showButtons && PortletPermissionUtil.contains(permissionChecker , plid.longValue() , PortletKeysExt.VCMS , ActionKeysExt.ADD_THREAD);

boolean showDeleteAllThreadButton = showButtons && PortletPermissionUtil.contains(permissionChecker , plid.longValue() , PortletKeysExt.VCMS , ActionKeysExt.DELETE_ALL_THREAD);

List headerNames = new ArrayList();

headerNames.add("portlet.vcms.thread.title");
headerNames.add("#article");
headerNames.add(StringPool.BLANK);
	
SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, headerNames, null);
searchContainer.setEmptyResultsMessage("there-are-no-threads");
RowChecker rowChecker = new RowChecker(renderResponse);
searchContainer.setRowChecker(rowChecker);

List threads = VcmsThreadServiceUtil.getThreadsByP_L(groupId, language);

if (threads == null) {
	threads = new ArrayList();
}

List results = new ArrayList();
for (int i = 0; i < threads.size(); i++) {
	VcmsThread thread = (VcmsThread)threads.get(i);
	results.add(thread);
}

// Collections.sort(results);

int total = results.size();
searchContainer.setTotal(total);
results = ListUtil.subList(results, searchContainer.getStart(), searchContainer.getEnd());
searchContainer.setResults(results);

List resultRows = searchContainer.getResultRows();
for (int i = 0; i < results.size(); i++) {
	VcmsThread thread = (VcmsThread)results.get(i);
	
	ResultRow row = new ResultRow(thread, thread.getPrimaryKey().toString(), i);
	
	PortletURL rowURL = renderResponse.createRenderURL();
		
	rowURL.setWindowState(WindowState.MAXIMIZED);	
	rowURL.setParameter("jspPage","/html/portlet/vcms/articles/thread/edit_thread.jsp");
	rowURL.setParameter("redirect", currentURL);
	rowURL.setParameter("threadId", thread.getThreadId());
	
	// Name and description
	
	StringBuffer sb = new StringBuffer();
	
	String title = thread.getTitle();
	String description = thread.getDescription();
	int countArticleOfThread = 0;
	countArticleOfThread = VcmsArticleServiceUtil.countArticleByT_P_L_S(thread.getThreadId(), groupId, language, statusId);
	
	sb.append("<b><a href=\"" + rowURL.toString() + "\">" + title + "</a></b>");
	
	if (Validator.isNotNull(description)) {
		sb.append("<br /><span style=\"font-size: xx-small;\">");
		sb.append(description);
		sb.append("</span>");
	}
	
	row.addText(sb.toString());
	row.addText(String.valueOf(countArticleOfThread));
	
	// Actions
	
	row.addJSP("right", SearchEntry.DEFAULT_VALIGN,"/html/portlet/vcms/articles/thread/thread_action.jsp" ,application,request,response);
	
	// Add result row	
	
	resultRows.add(row);
}
%>
	<c:if test="<%=showAddThreadButton%>">
		<div class="portlet-font" style="font-weight: bold; float: left; margin-right: 10px">
			<input class="portlet-form-button" type="button" value='<%= LanguageUtil.get(pageContext, "portlet.vcms.button.add") %>' onClick="javascript:<portlet:namespace />updateThread('<%= Constants.ADD %>', true);" />			
		</div>
	</c:if>

	<c:if test="<%=showDeleteAllThreadButton && results.size()>0%>">
		<div class="portlet-font" style="font-weight: bold; float: left; margin-right: 10px">
			<input class="portlet-form-button" type="button" value='<%= LanguageUtil.get(pageContext, "portlet.vcms.button.delete") %>' onClick="<portlet:namespace />deleteThreads();" />
			<input type="hidden" name="<portlet:namespace />threadId" value="" />
		</div>
	</c:if>
	<br><br><div class="beta-separator"></div><br>

<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
