<%@ include file="/html/portlet/vcms/init.jsp" %>
<%@ include file="/html/portlet/vcms/javascript.jsp" %>
	
<%
	PortletURL portletURL = renderResponse.createRenderURL();

	String redirect = ParamUtil.getString(request, "redirect");
	
	PortletURL backURL = renderResponse.createRenderURL();	
	backURL.setWindowState(WindowState.MAXIMIZED);	
	backURL.setParameter("language", language);
	backURL.setParameter("groupId", String.valueOf(groupId));	
	backURL.setParameter("struts_action", "/vcms/view");
	backURL.setParameter("tabs1", "portlet.vcms.tabs.article");
	backURL.setParameter("tabs2", "portlet.vcms.tabs.articles.discussion");	
	
	String discussionId = ParamUtil.getString(request, "discussionId","");
		
	VcmsDiscussion vDiscussion = null;
	VcmsArticle article = null;
	List discussions = null;
		
	vDiscussion = VcmsDiscussionServiceUtil.getDiscussion(discussionId);	
	String articleId = vDiscussion.getArticleId();
	article = VcmsArticleServiceUtil.getArticle(articleId);
	
	discussions = VcmsDiscussionServiceUtil.getDiscussions(articleId);
	
	List headerNames = new ArrayList();

	headerNames.add("portlet.vcms.discussion.title");
	headerNames.add("create-user");
	headerNames.add("portlet.vcms.discussion.sent-date");
	headerNames.add("status");

	SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, headerNames, null);
	searchContainer.setEmptyResultsMessage("there-are-no-discussion");	

	//RowChecker rowChecker = new RowChecker(renderResponse);
	//searchContainer.setRowChecker(rowChecker);
	
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
	
	rowURL.setParameter("struts_action", "/vcms/edit_discussion");
	rowURL.setParameter("redirect", currentURL);
	rowURL.setParameter("discussionId", discussion.getDiscussionId());
	
	// Name and date
	StringBuffer sb = new StringBuffer();
	String title = discussion.getTitle();
	Date postedDate = discussion.getPostedDate();
	
	row.addText("<b>" + title + "</b>", rowURL);
	row.addText("<div><b>"+discussion.getVisitorName()+"</b></div>");
	row.addText("<div align='center'><b>"+dateFormatDateTime.format(postedDate).toString()+"</div>");
	
	String discussionImage = "";
	String tooltip = "";
	
	if(discussion.getApproved()){
		discussionImage = "published.gif";	
		tooltip = "<b>" + LanguageUtil.get(pageContext, "approved") + "</b>";
	}else {
		discussionImage = "publish_pending.gif";
	   	tooltip = "<b>" + LanguageUtil.get(pageContext, "approval-pending") + "</b>";
	
	}
	
	sb.append("<table cellspacing='3' cellpadding='0' width='100%' border='0'>");
	sb.append("<tr>");
	sb.append("<td><img src='" + themeDisplay.getPathThemeImage() + "/vlegal/" + discussionImage + "' valign='middle' onmousemove=\"Liferay.Portal.ToolTip.show(event, this,'" + tooltip + "')\" /></td>");	
	sb.append("</tr>");
	sb.append("</table>");
	
	row.addText(sb.toString());
	resultRows.add(row);
}
%>

<liferay-ui:tabs names="<%= LanguageUtil.get(pageContext, "portlet.vcms.discussion.list.of.article") %>" backURL="<%= backURL.toString() %>" />
	

<div>
	<table width="100%">
	<tr>
		<td align="left">			
			<b><font  style="font-size: 13pt; font-family: tahoma, arial"><%= article.getTitle() %></font></b><br/>
			<%if(article.getHasImage()){%>					
				<img width="80" height="60" style="float: left; padding-right: 5px;border-color:#999999"  src="<%= themeDisplay.getPathImage() + "/images?img_id=" + WebKeysExt.VCMS_ARTICLE_SMALL_IMAGE_KEY + article.getArticleId() %>" border="1" />
			<%}else {%>
				<img width="80" height="60" style="float: left; padding-right: 5px;border-color:#999999" src="/html/portlet/vcms/images.jpg" />
			<%}%>	
			<%=article.getLead()%>		
		</td>
	</tr>
	</table>
</div>
<br>
	
<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />	

<br>
<div>		
	<input class="portlet-form-button" type="button" value='<%= LanguageUtil.get(pageContext, "back") %>' onClick="self.location = '<%= backURL.toString() %>';">	
</div>		
	