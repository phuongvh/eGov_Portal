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
boolean showAddDiscussionButton = showButtons && PortletPermissionUtil.contains(permissionChecker , plid.longValue() , PortletKeysExt.VCMS , ActionKeysExt.ADD_DISCUSSION);

boolean showDeleteDiscussionButton = showButtons && PortletPermissionUtil.contains(permissionChecker , plid.longValue() , PortletKeysExt.VCMS , ActionKeysExt.DELETE_ALL_DISCUSSION);


	
//Search aritcle parameters 
String flag_search = ParamUtil.getString(request,"flag-search",StringPool.BLANK);
String keyword_discussion = ParamUtil.getString(request,"keyword-discussion",StringPool.BLANK);

Boolean isTitleDiscussion = ParamUtil.getBoolean(request,"checkbox-title-discussion",false);
Boolean isContentDiscussion = ParamUtil.getBoolean(request,"checkbox-content-discussion",false);
String selectAndOrDiscussion = ParamUtil.getString(request,"selectAndOrDiscussion",StringPool.BLANK);

String articleId = ParamUtil.getString(request,"articleId",StringPool.BLANK);
String redirect = ParamUtil.getString(request,"redirect",StringPool.BLANK);
boolean showApproved = ParamUtil.getBoolean(request, "showApproved");

List headerNames = new ArrayList();

headerNames.add("portlet.vcms.discussion.title");
headerNames.add("create-user");
headerNames.add("portlet.vcms.discussion.sent-date");
headerNames.add(StringPool.BLANK);

SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, headerNames, null);
searchContainer.setEmptyResultsMessage("there-are-no-discussion");	

RowChecker rowChecker = new RowChecker(renderResponse);
searchContainer.setRowChecker(rowChecker);

List discussions = null;
VcmsArticle article = null;

if(Validator.isNotNull(articleId)){
	article = VcmsArticleServiceUtil.getArticle(articleId);
	if(Validator.isNull(flag_search)){
		discussions = VcmsDiscussionServiceUtil.getDiscussionsByA_P_L_A(articleId ,groupId, language, showApproved);
	}else if(Validator.equals(flag_search,"true")){
		discussions = VcmsDiscussionServiceUtil.searchDiscussionByA_P_L_K(articleId ,groupId, language, keyword_discussion, showApproved,isTitleDiscussion,isContentDiscussion,selectAndOrDiscussion);
	}
}else{
	if(Validator.isNotNull(flag_search) && Validator.equals(flag_search,"true")){
		discussions = VcmsDiscussionServiceUtil.searchDiscussionByA_P_L_K(null ,groupId, language, keyword_discussion, showApproved,isTitleDiscussion,isContentDiscussion,selectAndOrDiscussion);
	}else{
		discussions = VcmsDiscussionServiceUtil.getDiscussionsByP_L_A(groupId, language, showApproved);
	}
}

if (discussions == null) {
	discussions = new ArrayList();
}

List results = new ArrayList();
for (int i = 0; i < discussions.size(); i++) {
	VcmsDiscussion discussion = (VcmsDiscussion)discussions.get(i);
	results.add(discussion);
}

// Collections.sort(results);

int total = results.size();

searchContainer.setTotal(total);
results = ListUtil.subList(results, searchContainer.getStart(), searchContainer.getEnd());
searchContainer.setResults(results);

List resultRows = searchContainer.getResultRows();
for (int i = 0; i < results.size(); i++) {
	VcmsDiscussion discussion = (VcmsDiscussion)results.get(i);
	
	ResultRow row = new ResultRow(discussion, discussion.getPrimaryKey().toString(), i);
	
	PortletURL rowURL = renderResponse.createRenderURL();
	
	rowURL.setWindowState(WindowState.MAXIMIZED);
	
	rowURL.setParameter("jspPage", "/html/portlet/vcms/articles/discussions/edit_discussion.jsp");
	rowURL.setParameter("redirect", currentURL);
	rowURL.setParameter("discussionId", discussion.getDiscussionId());
	
	// Name and date
	
	String title = discussion.getTitle();
	Date postedDate = discussion.getPostedDate();
	
	row.addText("<b>" + title + "</b>", rowURL);
	row.addText("<div><b>"+discussion.getVisitorName()+"</b></div>");
	row.addText("<div align='center'><b>"+dateFormatDateTime.format(postedDate).toString()+"</div>");
	
	// Actions
	
	row.addJSP("right", SearchEntry.DEFAULT_VALIGN, "/html/portlet/vcms/articles/discussions/discussion_action.jsp",application,request,response);
	
	// Add result row
	
	resultRows.add(row);
}
%>
		<!--Discussion search-->
<%@ include file="/html/portlet/vcms/articles/discussions/discussions_search.jsp"%>	

<c:if test="<%=(Validator.isNotNull(articleId))%>">
	
<table width="100%" border="0" align="center" cellspacing="5" cellpadding="5">
<%if(discussions != null && discussions.size()>0){%>
<tr height="30">
	<td>
		<b><%= LanguageUtil.get(pageContext, "portlet.vcms.discussion.notification.1") %> :&nbsp;</b><font color="red"><%=article.getTitle()%></font></td>
	
</tr>
<tr height="30">
	<%if(showApproved){%>
	<td>
		<%= LanguageUtil.get(pageContext, "portlet.vcms.discussion.notification.2") %>
		<b><%= LanguageUtil.get(pageContext, "portlet.vcms.discussion.notification.3") %></b> : <%=discussions.size()%>	
	 </td>
	<%}else{%>
	<td>
		<%= LanguageUtil.get(pageContext, "portlet.vcms.discussion.notification.2") %>
		<b><%= LanguageUtil.get(pageContext, "portlet.vcms.discussion.notification.4") %></b> : <%=discussions.size()%>		
	</td>
	<%}%>
</tr>
<%}else{%>
<tr height="30">
	<td style="padding-left:5px;">
	<%if(showApproved){%>
		<%if(Validator.isNotNull(flag_search)){%>
			<%= LanguageUtil.get(pageContext, "portlet.vcms.discussion.notification.5") %>
		<%}else{%>
			<%= LanguageUtil.get(pageContext, "portlet.vcms.discussion.notification.6") %>
		<%}%>
	<%}else{%>
		<%if(Validator.isNotNull(flag_search)){%>
			<%= LanguageUtil.get(pageContext, "portlet.vcms.discussion.notification.7") %>
		<%}else{%>
			<%= LanguageUtil.get(pageContext, "portlet.vcms.discussion.notification.8") %>
		<%}%>
	<%}%>
	</td>
</tr>
<%}%>
<tr>		
	<td align="right">
		<img src='<%=themeDisplay.getPathThemeImage()%>/vcms/forward_nav.gif' valign='middle' /><a href="#" onClick="self.location = '<%= redirect %>';"><%= LanguageUtil.get(pageContext, "back") %></a>
	</td>
</tr>	
</table>
<input type="hidden" name="<portlet:namespace />articleId" value="<%=articleId%>" />
</c:if>
		
<c:if test="<%=(Validator.isNotNull(flag_search)) && Validator.isNull(articleId)%>">
	<%if(discussions.size() == 0){%>
		<br/><font color="red"><b><%= LanguageUtil.get(pageContext, "portlet.vcms.discussion.search.notification.1") %></b></font><br/>
	<%}else{%>
		<br/><font color="red"><b><%= LanguageUtil.get(pageContext, "portlet.vcms.discussion.search.notification.2") %> : <%=discussions.size()%></b></font><br/>
	<%}%>
</c:if>
		
<hr width="100%"/><br><div class="beta-separator"></div>
	
<c:if test="<%=showAddDiscussionButton%>">
	<div class="portlet-font" style="font-weight: bold; float: left; margin-right: 10px">
		<input class="portlet-form-button" type="button" value='<%= LanguageUtil.get(pageContext, "portlet.vcms.button.add") %>' onClick="javascript:<portlet:namespace />updateDiscussion('<%= Constants.ADD %>', true);" />
	</div>
</c:if>
	
<c:if test="<%=showDeleteDiscussionButton && results.size()>0%>">
	<div class="portlet-font" style="font-weight: bold; float: left; margin-right: 10px">
		<input class="portlet-form-button" type="button" value='<%= LanguageUtil.get(pageContext, "portlet.vcms.button.delete") %>' onClick="javascript:<portlet:namespace />deleteDiscussions();" />
		<input type="hidden" name="<portlet:namespace />discussionIds" value="" />
	</div>
</c:if>

<br><br>

<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
