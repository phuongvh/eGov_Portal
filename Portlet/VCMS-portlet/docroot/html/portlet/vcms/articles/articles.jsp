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
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.vportal.portal.kernel.security.permission.ActionKeysExt"%>
<%@page import="com.vportal.portal.util.PortletKeysExt"%>
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
<%@ include file="/html/portlet/vcms/javascript.jsp" %>
<%
	
	//Begin get the parameters of search article
		// Initial date values
	Calendar currentDate = new GregorianCalendar();
	int curYear = currentDate.get(Calendar.YEAR);
	int curMonth = currentDate.get(Calendar.MONTH);
	int curDay = currentDate.get(Calendar.DATE);
	
	int fromDay = ParamUtil.getInteger(request, "fromDay", curDay);
	int fromMonth = ParamUtil.getInteger(request, "fromMonth", curMonth);
	int fromYear = ParamUtil.getInteger(request, "fromYear", curYear-10);
	
	int toDay = ParamUtil.getInteger(request, "toDay", curDay);
	int toMonth = ParamUtil.getInteger(request, "toMonth", curMonth);
	int toYear = ParamUtil.getInteger(request, "toYear", curYear+10);	
	
		// Convert Date...
	Date dateFrom  = new GregorianCalendar(fromYear, fromMonth, fromDay).getTime();
	Date dateTo = new GregorianCalendar(toYear, toMonth, toDay).getTime();
	

	String defaultKeywords = LanguageUtil.get(pageContext, "search") + "...";
	String unicodeDefaultKeywords = UnicodeFormatter.toString(defaultKeywords);
	String keyword = ParamUtil.getString(request,"keyword","");
	
	Boolean isTitle = ParamUtil.getBoolean(request,"keyword-in-title",true);
	Boolean isLead = ParamUtil.getBoolean(request,"keyword-in-lead",false);
	Boolean isContent = ParamUtil.getBoolean(request,"keyword-in-content",false);
	Boolean isDate = ParamUtil.getBoolean(request,"isDate",false);
	
	String cmdSearchFlag = ParamUtil.getString(request,"cmd-search-flag",StringPool.BLANK);
	String cmdSearchStatus = ParamUtil.getString(request,"cmd-search-status",StringPool.BLANK);
	String selectAndOr = ParamUtil.getString(request,"selectAndOr",StringPool.BLANK);
	
		
	//Begin get the parameters of get artilce by thread
	String cmd_thread = ParamUtil.getString(request,"cmd_thread",StringPool.BLANK);
	String threadId = ParamUtil.getString(request,"threadId",StringPool.BLANK);
	//End get parameter
	
	//Begin get the parameters of get artilce by category
	String cmd_category = ParamUtil.getString(request,"cmd_category",StringPool.BLANK);
	String fromCateogryId = ParamUtil.getString(request,"parentId",StringPool.BLANK);
	String tempfromCateogryId ="";
	if(fromCateogryId.length()>0 && fromCateogryId.indexOf("'")<0);
		tempfromCateogryId="'"+fromCateogryId+"'";
	//End get parameter
	
	//Begin get the parameters of get artilce by portion
	String cmd_portion = ParamUtil.getString(request,"cmd_portion",StringPool.BLANK);
	String fromPortionId = ParamUtil.getString(request,"portionId",StringPool.BLANK);
	//End get parameter	
	
	//Begin get the parameters of get artilce by type
	String cmd_type = ParamUtil.getString(request,"cmd_type",StringPool.BLANK);
	String fromTypeId = ParamUtil.getString(request,"typeId",StringPool.BLANK);
	//End get parameter
	
	PortletURL portletURLRedirectCategory = renderResponse.createRenderURL();	
	portletURLRedirectCategory.setWindowState(WindowState.MAXIMIZED);
	
	portletURLRedirectCategory.setParameter("language", language);
	portletURLRedirectCategory.setParameter("groupId", String.valueOf(groupId));	
	portletURLRedirectCategory.setParameter("jspPage","/html/portlet/vcms/view.jsp" );
	portletURLRedirectCategory.setParameter("tabs1", "portlet.vcms.tabs.manage");
	portletURLRedirectCategory.setParameter("tabs2", "portlet.vcms.tabs.category");	
	
	PortletURL portletURLRedirectPortion = renderResponse.createRenderURL();	
	portletURLRedirectPortion.setWindowState(WindowState.MAXIMIZED);
	portletURLRedirectPortion.setParameter("jspPage", "/html/portlet/vcms/view.jsp" );
	portletURLRedirectPortion.setParameter("tabs1", "portlet.vcms.tabs.manage");
	portletURLRedirectPortion.setParameter("tabs2", "portlet.vcms.tabs.portion");
	
	PortletURL portletURLRedirectThread = renderResponse.createRenderURL();	
	portletURLRedirectThread.setWindowState(WindowState.MAXIMIZED);	
	portletURLRedirectThread.setParameter("jspPage", "/html/portlet/vcms/view.jsp" );
	portletURLRedirectThread.setParameter("tabs1", "portlet.vcms.tabs.article");
	portletURLRedirectThread.setParameter("tabs2", "portlet.vcms.tabs.articles.thread");
	
	PortletURL portletURLRedirectType = renderResponse.createRenderURL();	
	portletURLRedirectType.setWindowState(WindowState.MAXIMIZED);	
	portletURLRedirectType.setParameter("jspPage","/html/portlet/vcms/view.jsp" );
	portletURLRedirectType.setParameter("tabs1", "portlet.vcms.tabs.manage");
	portletURLRedirectType.setParameter("tabs2", "portlet.vcms.tabs.type");
	
	boolean showTabDiscussion = showTabs && PortletPermissionUtil.contains(permissionChecker , plid.longValue() , PortletKeysExt.VCMS , ActionKeysExt.VIEW_DISCUSSION);

	boolean showTabThread = showTabs && PortletPermissionUtil.contains(permissionChecker , plid.longValue() , PortletKeysExt.VCMS , ActionKeysExt.VIEW_THREAD);
	
	boolean showAddArticleButton = showButtons && PortletPermissionUtil.contains(permissionChecker , plid.longValue() , PortletKeysExt.VCMS , ActionKeysExt.ADD_ARTICLE);
		
	boolean showDeleteAllArticleButton = showButtons && PortletPermissionUtil.contains(permissionChecker , plid.longValue() , PortletKeysExt.VCMS , ActionKeysExt.DELETE_ALL_ARTICLE);

	boolean showSendAllArticleButton = showButtons && PortletPermissionUtil.contains(permissionChecker , plid.longValue() , PortletKeysExt.VCMS , ActionKeysExt.SEND_ALL_ARTICLE);
	
	String tabs2Names = "portlet.vcms.tabs.articles.draft";
	String tabs2Values = "0";
	
	if(totalStatus > 0)
		for(int i=0; i<totalStatus; i++){
			VcmsStatus status = (VcmsStatus) statusResults.get(i);
			
			tabs2Names += "," + status.getName();
			tabs2Values += "," + status.getStatusId();
		}

	if(showTabDiscussion){
		tabs2Names += ",portlet.vcms.tabs.articles.discussion";
		tabs2Values += ",portlet.vcms.tabs.articles.discussion";
	}
	
	if(showTabThread){
		tabs2Names += ",portlet.vcms.tabs.articles.thread";
		tabs2Values += ",portlet.vcms.tabs.articles.thread";
	}
%>

<liferay-ui:tabs names="<%= tabs2Names %>" tabsValues="<%= tabs2Values %>" param="tabs2" url="<%= portletURL.toString() %>" />
<c:choose>
	 <c:when test="<%= tabs2.equals(\"portlet.vcms.tabs.articles.discussion\") %>">
	 		<%@ include file="/html/portlet/vcms/articles/discussions/discussions.jsp" %>
	</c:when>
	<c:when test="<%= tabs2.equals(\"portlet.vcms.tabs.articles.thread\") %>">
			<%@ include file="/html/portlet/vcms/articles/thread/threads.jsp" %>
	</c:when> 

	<c:otherwise>
		<%
		long longTabs2 = GetterUtil.getLong(tabs2, 0);
			
			
		List headerNames = new ArrayList();
		headerNames.add("portlet.vcms.article.title");
		
		try {	
			if (longTabs2!=0){
				VcmsStatus vStatus = VcmsStatusLocalServiceUtil.getVcmsStatus(longTabs2);
				if (vStatus.getActive()){		
					headerNames.add("portlet.vcms.article.hasDiscussion");			
					headerNames.add("portlet.vcms.article.publisher");
					headerNames.add("portlet.vcms.article.published-date");
				} else {
					headerNames.add("portlet.vcms.article.modifier");
					headerNames.add("portlet.vcms.article.modified-date");
				}				
			} else {
				headerNames.add("portlet.vcms.article.creater");
				headerNames.add("portlet.vcms.article.created-date");
			}	
		}catch (Exception ex){}	
		
		headerNames.add(StringPool.BLANK);
		//hoan
		portletURL.setParameter("keyword", keyword);
		if(Validator.isNotNull(keyword))
			cmdSearchFlag="true";
		//hoan
		SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, headerNames, null);		
		searchContainer.setEmptyResultsMessage("there-are-no-articles");		
		RowChecker rowChecker = new RowChecker(renderResponse);
		searchContainer.setRowChecker(rowChecker);

		List results = new ArrayList();
				
		int articleStatusView = GetterUtil.getInteger(tabs2, 0);
		int total =0;
		
		if(Validator.isNotNull(cmdSearchFlag) && Validator.equals(cmdSearchFlag,"true")){
			if(Validator.isNotNull(fromCateogryId)){
				results  = VcmsArticleServiceUtil.getArticlesBySearchContainer(keyword,groupId,language,null,fromCateogryId,typeId,isTitle,isLead,isContent,isDate,dateFrom,dateTo,articleStatusView,selectAndOr, searchContainer.getStart(), searchContainer.getEnd());
				total  = VcmsArticleServiceUtil.countArticlesBySearchContainer(keyword,groupId,language,null,fromCateogryId,typeId,isTitle,isLead,isContent,isDate,dateFrom,dateTo,articleStatusView,selectAndOr);
			
			}else if(Validator.isNotNull(fromPortionId)){
				results  = VcmsArticleServiceUtil.getArticlesBySearchContainer(keyword,groupId,language,fromPortionId,null,typeId,isTitle,isLead,isContent,isDate,dateFrom,dateTo,articleStatusView,selectAndOr, searchContainer.getStart(), searchContainer.getEnd());
				total  = VcmsArticleServiceUtil.countArticlesBySearchContainer(keyword,groupId,language,fromPortionId,null,typeId,isTitle,isLead,isContent,isDate,dateFrom,dateTo,articleStatusView,selectAndOr);
	
			}else if(Validator.isNotNull(threadId)){
				results  = VcmsArticleServiceUtil.getArticlesBySearchContainer_T(parentId,typeId,keyword,groupId,language,threadId,isTitle,isLead,isContent,isDate,dateFrom,dateTo,articleStatusView,selectAndOr, searchContainer.getStart(), searchContainer.getEnd());
				total  = VcmsArticleServiceUtil.countArticlesBySearchContainer_T(parentId,typeId,keyword,groupId,language,threadId,isTitle,isLead,isContent,isDate,dateFrom,dateTo,articleStatusView,selectAndOr);
				
			}else if(Validator.isNotNull(fromTypeId)){			
				results  = VcmsArticleServiceUtil.getArticlesBySearchContainer(keyword,groupId,language,portionId,parentId,Long.parseLong(fromTypeId),isTitle,isLead,isContent,isDate,dateFrom,dateTo,articleStatusView,selectAndOr, searchContainer.getStart(), searchContainer.getEnd());
				total  = VcmsArticleServiceUtil.countArticlesBySearchContainer(keyword,groupId,language,portionId,parentId,Long.parseLong(fromTypeId),isTitle,isLead,isContent,isDate,dateFrom,dateTo,articleStatusView,selectAndOr);										
				
			}else{				
				results  = VcmsArticleServiceUtil.getArticlesBySearchContainer(keyword,groupId,language,portionId,parentId,typeId,isTitle,isLead,isContent,isDate,dateFrom,dateTo,articleStatusView,selectAndOr, searchContainer.getStart(), searchContainer.getEnd());
				total  = VcmsArticleServiceUtil.countArticlesBySearchContainer(keyword,groupId,language,portionId,parentId,typeId,isTitle,isLead,isContent,isDate,dateFrom,dateTo,articleStatusView,selectAndOr);										
			}
				
		}else{
			
			if(Validator.isNotNull(cmd_thread) && Validator.equals(cmd_thread,"VIEW_ARTICLES_BY_THREAD")){
		
				results = VcmsArticleServiceUtil.getArticleByT_P_L_S(threadId , groupId , language , articleStatusView, searchContainer.getStart(), searchContainer.getEnd());
				total = VcmsArticleServiceUtil.countArticleByT_P_L_S(threadId , groupId , language , articleStatusView);
		
			}else if(Validator.isNotNull(cmd_category) && Validator.equals(cmd_category,"VIEW_ARTICLES_BY_CATEGORY")){
						
				results = VcmsArticleServiceUtil.getArticleByC_P_L_S(tempfromCateogryId , groupId , language , articleStatusView, searchContainer.getStart(), searchContainer.getEnd());
				total = VcmsArticleServiceUtil.countArticleByC_P_L_S(tempfromCateogryId , groupId , language , articleStatusView);
		
			}else if(Validator.isNotNull(cmd_portion) && Validator.equals(cmd_portion,"VIEW_ARTICLES_BY_PORTION")){
			
				results = VcmsArticleServiceUtil.getArticleByP_P_L_S(fromPortionId , groupId , language , articleStatusView, searchContainer.getStart(), searchContainer.getEnd());
				total = VcmsArticleServiceUtil.countArticleByP_P_L_S(fromPortionId , groupId , language , articleStatusView);
				
			} else if(Validator.isNotNull(cmd_type) && Validator.equals(cmd_type, "VIEW_ARTICLES_BY_TYPE")){
				
				results = VcmsArticleServiceUtil.getArticleByG_L_S_T(groupId, language, articleStatusView, Long.parseLong(fromTypeId),searchContainer.getStart(), searchContainer.getEnd());
				total = VcmsArticleServiceUtil.countArticleByG_L_S_T(groupId, language, articleStatusView, Long.parseLong(fromTypeId));
				
		
			}else {
				//if (articleStatusView!=0){
				//	if(permissionChecker.isOmniadmin()){					
						results = VcmsArticleServiceUtil.getArticlesByL_S(groupId, language, articleStatusView, searchContainer.getStart(), searchContainer.getEnd());
						total = VcmsArticleServiceUtil.countArticlesByL_S(groupId, language, articleStatusView);
				//	} else {
				//		results = VcmsArticleServiceUtil.getArticlesByG_L_S_U(groupId, language, articleStatusView, String.valueOf(userId), searchContainer.getStart(), searchContainer.getEnd());
				//		total = VcmsArticleServiceUtil.countArticlesByG_L_S_U(groupId, language, articleStatusView, String.valueOf(userId));
				//	}
				//} else { // Draft Articles
				//	if(permissionChecker.isOmniadmin()){
						
				//		results = VcmsArticleServiceUtil.getArticlesByL_S(groupId, language, articleStatusView, searchContainer.getStart(), searchContainer.getEnd());
				//		total = VcmsArticleServiceUtil.countArticlesByL_S(groupId, language, articleStatusView);						
				
				//		results = VcmsArticleServiceUtil.getArticlesByG_L_S_U(groupId, language, articleStatusView, String.valueOf(userId), searchContainer.getStart(), searchContainer.getEnd());
				//		total = VcmsArticleServiceUtil.countArticlesByG_L_S_U(groupId, language, articleStatusView, String.valueOf(userId));
				//	}
				//}
			}
		}
			
		
		searchContainer.setTotal(total);	
		searchContainer.setResults(results);
		
		List resultRows = searchContainer.getResultRows();
		for (int i = 0; i < results.size(); i++) {
			VcmsArticle article = (VcmsArticle)results.get(i);
			
			ResultRow row = new ResultRow(article, article.getPrimaryKey().toString(), i);			
			
			PortletURL rowURL = renderResponse.createRenderURL();			
			rowURL.setWindowState(WindowState.MAXIMIZED);			
			rowURL.setParameter("jspPage","/html/portlet/vcms/articles/edit_article.jsp" );
			rowURL.setParameter("redirect", currentURL);
			rowURL.setParameter("articleId", article.getArticleId());
			rowURL.setParameter("tabs2", tabs2);
			
			StringBuffer sb = new StringBuffer();
			StringBuffer sb1 = new StringBuffer();
			
			String title = article.getTitle();
			String leadArticle = HtmlExt.extractText(article.getLead());
			String publishDate = String.valueOf(article.getPublishedDate());
			
			List listCategoryId = (List)VcmsCARelationServiceUtil.getRelationsByArticle(article.getArticleId());
			List listTypeId = (List)VcmsArticleTypeLocalServiceUtil.getByArticleId(article.getArticleId());
			
			String strCat = "";
			String strType = "";
			try{
				if (Validator.isNotNull(listCategoryId) && listCategoryId.size()>0){
					for (int count = 0; count < listCategoryId.size();count ++){
						VcmsCARelation CA = (VcmsCARelation)listCategoryId.get(count);
						strCat += VcmsCategoryServiceUtil.getCategory(CA.getCategoryId()).getName() + (count < listCategoryId.size() -1 ? ", ":"");
					}
				}

				if (Validator.isNotNull(listTypeId) && listTypeId.size()>0){
					for (int j = 0; j < listTypeId.size();j ++){		
						VcmsArticleType vType = (VcmsArticleType)listTypeId.get(j);					
						strType += VcmsTypeServiceUtil.getType(String.valueOf(vType.getTypeId())).getName() + (j < listTypeId.size() -1 ? ", ":"");				
				}
			}
			}catch(Exception ex){
				System.out.println(ex.toString());
			}
			
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
			
			String tooltip = "";
			if(Validator.isNotNull(strCat))
				tooltip = "<b>" + LanguageUtil.get(pageContext, "portlet.vcms.tabs.category") + "</b> : " +strCat+ "<br/>";
			if(Validator.isNotNull(strType))
				tooltip += "<b>" + LanguageUtil.get(pageContext, "portlet.vcms.tabs.type") + "</b> : " +strType + "";
			
			int readMessages = VcmsAttachedMessageServiceUtil.count(article.getArticleId(), true);
			int unreadMessages = VcmsAttachedMessageServiceUtil.count(article.getArticleId(), false);
			
			if (longTabs2!=0){
				VcmsStatus vStatus = VcmsStatusLocalServiceUtil.getVcmsStatus(longTabs2);
				if (vStatus.getActive()){					
					sb.append("<a href=\"javascript:expandingWindow('/VCMS-portlet/html/portlet/vcms/articles/print_article.jsp?printArticleId=" + article.getArticleId() + "')\"' onmousemove=\"Liferay.Portal.ToolTip.show(this,'" + tooltip + "')\" ><b>" + title + "</b></a>");
				} else {																									
					sb.append("<a href=\"" + rowURL.toString() + "\" onmousemove=\"Liferay.Portal.ToolTip.show( this,'" + tooltip + "')\"><b>" + title + "</b></a>");
				}				
			} else {
					sb.append("<a href=\"" + rowURL.toString() + "\"><b>" + title + "</b></a>");
			}	
				
			sb.append("<br/>");
			if(article.getHasImage()){
				sb.append("<img width='70' height='50' style='float: left; padding-right: 5px;' src='" + themeDisplay.getPathImage() + "/vcms?img_id=" + article.getImage() + "' valign='middle' />");
			} else {
				sb.append("<img width='70' height='50' style='float: left; padding-right: 5px;' src='/html/portlet/vcms/images.jpg' />");
				
			}
			sb.append(leadArticle + "<br/>");
			
			if ((readMessages + unreadMessages) > 0) {
				sb.append("<span style=\"font-size: xx-small;\"><img src='" + themeDisplay.getPathThemeImage() + "/vcms/message-notation.gif' valign='middle' />&nbsp;");
				sb.append("<b><u>" + LanguageUtil.get(pageContext, "portlet.vcms.article.attached-message") + "</u></b>: ");
				sb.append("<a href=\"javascript:void(0);\" onclick=\"javascript:showMessagesList("+article.getArticleId()+");\"><b><font color='red'>" + unreadMessages + " " + LanguageUtil.get(pageContext, "portlet.vcms.article.unread-attached-message") + "</font></b>/" + (readMessages + unreadMessages) + " " + LanguageUtil.get(pageContext, "portlet.vcms.article.attached-message") + "</a>");
				sb.append("</span>");
			}

			//view message list by pop-up
			List attachedMessages = new ArrayList();

			if (article != null ) {
				attachedMessages = VcmsAttachedMessageServiceUtil.getMessages(article.getArticleId());
			}
			
			sb.append("<div id="+article.getArticleId()+" style=\"display:none\">");
			sb.append("<table cellspacing='3' cellpadding='0' width='90%' border='0' align='center'>");
			sb.append("<tr>");
			sb.append("<td width='99%' align='left'><b>");
				for (int icount = 0; icount < attachedMessages.size(); icount ++) {
				VcmsAttachedMessage attachedMessage = (VcmsAttachedMessage) attachedMessages.get(icount);
				
				// Display...
				sb.append("<img src='" + themeDisplay.getPathThemeImage() + "/vcms/message-notation.gif' valign='middle' />");
				sb.append("L&#7901;i nh&#7855;n "+(icount+1)+" : ");
				sb.append(!attachedMessage.getReadMessage() ? ("<b>[" + LanguageUtil.get(pageContext, "portlet.vcms.article.edit.unread-message") + "]</b> ") : "");
				sb.append(attachedMessage.getContent());
				if (icount < attachedMessages.size() - 1) {
					sb.append("<br /><br /><div class=\"beta-separator\"></div><br />");
				}
				
				// Update status
				VcmsAttachedMessageServiceUtil.updateMessage(attachedMessage.getMessageId(), true);
			}
			
			sb.append("</td>");
			sb.append("</tr>");
			sb.append("</table>");
			sb.append("<br />");
			sb.append("</div>");
			
			row.addText(sb.toString());
						
			if (longTabs2!=0){
				VcmsStatus vStatus = VcmsStatusLocalServiceUtil.getVcmsStatus(longTabs2);
				if (vStatus.getActive()){
					if(article.getDiscussible()){
						sb1.append("<table cellspacing='3' cellpadding='0' width='100%' border='0'>");
						sb1.append("<tr>");
						sb1.append("<td align='center'><img src='" + themeDisplay.getPathThemeImage() + "/vcms/discussion.png' valign='middle' title='Bài vi&#7871;t có góp ý' /></td>");	
						sb1.append("</tr>");
						sb1.append("</table>");	
						row.addText(sb1.toString());
					} else {
						row.addText("");
					}
					try{	
						row.addText("<div><b>"+UserLocalServiceUtil.getUser(Long.parseLong(article.getPublishedByUser())).getFullName()+"</b></div>");
					}catch(Exception ex){
						row.addText("<div><b>Not Available</b></div>");	
					}
					//row.addText("<div><b>"+dateFormatDateTime.format(article.getPublishedDate()).toString()+"</b></div>");
				} else {
					try{
						row.addText("<div><b>"+UserLocalServiceUtil.getUser(Long.parseLong(article.getModifiedByUser())).getFullName()+"</b></div>");
					}catch(Exception ex){
						row.addText("<div><b>Not Available</b></div>");		
					}
					row.addText("<div><b>"+dateFormatDateTime.format(article.getModifiedDate()).toString()+"</b></div>");	
				}				
			} else {
				try{				
					row.addText("<div><b>"+UserLocalServiceUtil.getUser(Long.parseLong(article.getCreatedByUser())).getFullName()+"</b></div>");  // Draft Article
					}catch(Exception ex){
						row.addText("<div><b>Not Available</b></div>");					
					}
				try{
					row.addText("<div><b>"+article.getCreatedDate().toString()+"</b></div>");
				}catch(Exception ex){}
			}								   		
			// Actions
			row.addJSP("right", SearchEntry.DEFAULT_VALIGN, "/html/portlet/vcms/articles/article_action.jsp",application,request,response);
			
			// Add result row
			
			resultRows.add(row);
		}
		%>
		
		<%@ include file="/html/portlet/vcms/articles/articles_search.jsp" %>
			
		<c:if test="<%=(Validator.isNotNull(cmdSearchFlag) && (Validator.equals(cmdSearchFlag,\"true\")))%>">
			<%if((results != null) && (results.size()>0)){%>
				<br/><font color="red"><b><%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.notification.1") %> : <%=total%></b></font><br/>
			<%}else{%>
				<br/><font color="red"><b><%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.notification.2") %></b></font><br/>					
				<%if(Validator.isNotNull(threadId)){
					VcmsThread thread = (VcmsThread)VcmsThreadServiceUtil.getThread(threadId);%>
				<br/>	
				<div>
					<table width="100%">
					<tr>
						<td align="left"><img src='<%=themeDisplay.getPathThemeImage()%>/common/links.png' valign='middle' />&nbsp;<b><%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.notification.3") %> : <font color="red">"<%=thread.getTitle()%>"</font></b> &nbsp;&nbsp;</td>
						<td align="right"><a href="<%=portletURLRedirectThread%>"><img src='<%=themeDisplay.getPathThemeImage()%>/vcms/forward_nav.gif' valign='middle' /> <%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.notification.4") %></a></td>
					</tr>
					</table>
				</div>		
				<%}else if(Validator.isNotNull(fromCateogryId)){
					VcmsCategory fromCategory = (VcmsCategory)VcmsCategoryServiceUtil.getCategory(fromCateogryId);	%>							
				<br/>
				<div>
					<table width="100%">
					<tr>
						<td align="left"><b><%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.notification.6") %> : <font color="red">"<%=fromCategory.getName()%>"</font></b> &nbsp;&nbsp;</td>
						<td align="right"><a href="<%=portletURLRedirectCategory%>"><img src='<%=themeDisplay.getPathThemeImage()%>/vcms/forward_nav.gif' valign='middle' /> <%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.notification.7") %></a></td>
					</tr>
					</table>
				</div>				
				<%}else if (Validator.isNotNull(fromTypeId)){
					VcmsType fromType = (VcmsType) VcmsTypeServiceUtil.getType(fromTypeId);%>		
				<div>
					<table width="100%">
					<tr>
						<td align="left"><b><%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.notification.12") %> : <font color="red">"<%=fromType.getName()%>"</font></b> &nbsp;&nbsp;</td>
						<td align="right"><a href="<%=portletURLRedirectCategory%>"><img src='<%=themeDisplay.getPathThemeImage()%>/vcms/forward_nav.gif' valign='middle' /> <%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.notification.13") %></a></td>
					</tr>
					</table>
				</div>	
				<%}%>	
			<%}%>
		</c:if>
			
		<c:if test="<%=(Validator.isNotNull(cmd_thread) && (Validator.equals(cmd_thread,\"VIEW_ARTICLES_BY_THREAD\")))%>">
			<%if((results != null) && (results.size()>0)){
				VcmsThread thread = (VcmsThread)VcmsThreadServiceUtil.getThread(threadId);
			%>
				<br/>
				<div>
					<table width="100%">
					<tr>
						<td align="left"><img src='<%=themeDisplay.getPathThemeImage()%>/common/links.png' valign='middle' />&nbsp;<b><%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.notification.3") %> : <font color="red">"<%=thread.getTitle()%>"</font></b> &nbsp;&nbsp;</td>
						<td align="right"><a href="<%=portletURLRedirectThread%>"><img src='<%=themeDisplay.getPathThemeImage()%>/vcms/forward_nav.gif' valign='middle' /> <%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.notification.4") %></a></td>
					</tr>
					</table>
				</div>	
			<%}else{%>
				<c:if test="<%=Validator.isNull(cmdSearchFlag)%>">
				<br/>
				<div>
					<table width="100%">
					<tr>
						<td align="left"><img src='<%=themeDisplay.getPathThemeImage()%>/common/links.png' valign='middle' />&nbsp;<font color="red"><b><%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.notification.5") %></b></font
						<td align="right"><a href="<%=portletURLRedirectThread%>"><img src='<%=themeDisplay.getPathThemeImage()%>/vcms/forward_nav.gif' valign='middle' /> <%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.notification.4") %></td>
					</tr>
					</table>
				</div>
				</c:if>			
			<%}%>
		</c:if>
					
		<c:if test="<%=(Validator.isNotNull(cmd_category) && (Validator.equals(cmd_category,\"VIEW_ARTICLES_BY_CATEGORY\")))%>">
			<%if((results != null) && (results.size()>0)){
				VcmsCategory fromCategory = (VcmsCategory)VcmsCategoryServiceUtil.getCategory(fromCateogryId);
					portletURLRedirectCategory.setParameter("portionId", "");
					portletURLRedirectCategory.setParameter("parentId", "0");
			%>
				<br/>
				<div>
					<table width="100%">
					<tr>
						<td align="left"><b><%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.notification.6") %> : <font color="red">"<%=fromCategory.getName()%>"</font></b> &nbsp;&nbsp;</td>
						<td align="right"><a href="<%=portletURLRedirectCategory%>"><img src='<%=themeDisplay.getPathThemeImage()%>/vcms/forward_nav.gif' valign='middle' /> <%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.notification.7") %></a></td>
					</tr>
					</table>
				</div>					
			
			<%}else{%>				
				<c:if test="<%=Validator.isNull(cmdSearchFlag)%>">
				<br/>
				<div>
					<table width="100%">
					<tr>
						<td align="left"><font color="red"><b><%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.notification.8") %></b></font
						<td align="right"><a href="<%=portletURLRedirectCategory%>"><img src='<%=themeDisplay.getPathThemeImage()%>/vcms/forward_nav.gif' valign='middle' /> <%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.notification.7") %></td>
					</tr>
					</table>
				</div>
				</c:if>		
			<%}%>
		</c:if>
						
		<c:if test="<%=(Validator.isNotNull(cmd_portion) && (Validator.equals(cmd_portion,\"VIEW_ARTICLES_BY_PORTION\")))%>">
			<%if((results != null) && (results.size()>0)){
				VcmsPortion fromPortion = (VcmsPortion)VcmsPortionServiceUtil.getPortion(fromPortionId);
			%>
				<br/><b><%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.notification.9") %> :" <%=fromPortion.getName()%> "</b> &nbsp;&nbsp;
				<a href="<%=portletURLRedirectPortion%>"><img src='<%=themeDisplay.getPathThemeImage()%>/vcms/forward_nav.gif' valign='middle' /> <%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.notification.10") %></a><br/>
			<%}else{%>
				<c:if test="<%=Validator.isNull(cmdSearchFlag)%>">
				<br/>
				<div>
					<table width="100%">
					<tr>
						<td align="left"><font color="red"><b><%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.notification.11") %></b></font
						<td align="right"><a href="<%=portletURLRedirectPortion%>"><img src='<%=themeDisplay.getPathThemeImage()%>/vcms/forward_nav.gif' valign='middle' /> <%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.notification.10") %></td>
					</tr>
					</table>
				</div>
				</c:if>					
			<%}%>
		</c:if>
			
		<c:if test="<%=(Validator.isNotNull(cmd_type) && (Validator.equals(cmd_type,\"VIEW_ARTICLES_BY_TYPE\")))%>">
			<%if((results != null) && (results.size()>0)){				
				VcmsType fromType = (VcmsType)VcmsTypeServiceUtil.getType(fromTypeId);
			%>
				<br/>
				<div>
					<table width="100%">
					<tr>
						<td align="left"><b><%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.notification.12") %> : <font color="red">"<%=fromType.getName()%>"</font></b> &nbsp;&nbsp;</td>
						<td align="right"><a href="<%=portletURLRedirectType%>"><img src='<%=themeDisplay.getPathThemeImage()%>/vcms/forward_nav.gif' valign='middle' /> <%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.notification.13") %></a></td>
					</tr>
					</table>
				</div>					
			
			<%}else{%>
				<c:if test="<%=Validator.isNull(cmdSearchFlag)%>">
				<br/>
				<div>
					<table width="100%">
					<tr>
						<td align="left"><font color="red"><b><%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.notification.14") %></b></font
						<td align="right"><a href="<%=portletURLRedirectType%>"><img src='<%=themeDisplay.getPathThemeImage()%>/vcms/forward_nav.gif' valign='middle' /> <%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.notification.13") %></td>
					</tr>
					</table>
				</div>
				</c:if>					
			<%}%>
		</c:if>	
		
		<hr width="100%"/><br><div class="beta-separator"></div>
		
		<c:if test="<%=(longTabs2==0) && showAddArticleButton%>">	
			<div class="portlet-font" style="font-weight: bold; float: left; margin-right: 10px">
				<input class="portlet-form-button" type="button" value='<%= LanguageUtil.get(pageContext, "portlet.vcms.button.add") %>' onClick="javascript:<portlet:namespace />updateArticle('<%= Constants.ADD %>', true);" />
			</div>
		</c:if>	
			
		<%	if (longTabs2!=0){
				VcmsStatus vStatus = VcmsStatusLocalServiceUtil.getVcmsStatus(longTabs2);
				if (!vStatus.getActive() && showDeleteAllArticleButton && results.size()>0){	%>	
					<div class="portlet-font" style="font-weight: bold; float: left; margin-right: 10px">
						<input class="portlet-form-button" type="button" value='<%= LanguageUtil.get(pageContext, "portlet.vcms.button.delete") %>' onClick="javascript:<portlet:namespace />deleteArticles();" />
						<input type="hidden" name="<portlet:namespace />articleIds" value="" />
					</div>					
		<%}} else if (results.size()>0) {%>
			<div class="portlet-font" style="font-weight: bold; float: left; margin-right: 10px">
				<input class="portlet-form-button" type="button" value='<%= LanguageUtil.get(pageContext, "portlet.vcms.button.delete") %>' onClick="javascript:<portlet:namespace />deleteArticles();" />
				<input type="hidden" name="<portlet:namespace />articleIds" value="" />
			</div>
		<%}%>	
				
		<%
		
			try{
				VcmsStatus vStatusActive = VcmsStatusLocalServiceUtil.getVcmsStatus(statusId);
				
				if (longTabs2!=0){
					VcmsStatus vStatus = VcmsStatusLocalServiceUtil.getVcmsStatus(longTabs2);
					if ((vStatus.getPosition()<vStatusActive.getPosition()-1) && results.size()>0 && showSendAllArticleButton){
				%>			
				<div class="portlet-font" style="font-weight: bold; float: left; margin-right: 10px">
					<input class="portlet-form-button" type="button" value='<%= LanguageUtil.get(pageContext, "portlet.vcms.button.send") %>' onClick="javascript:<portlet:namespace />sendAllArticles();" />
				</div>		
		<%}} else if (results.size()>0){%>		
				<div class="portlet-font" style="font-weight: bold; float: left; margin-right: 10px">
					<input class="portlet-form-button" type="button" value='<%= LanguageUtil.get(pageContext, "portlet.vcms.button.send") %>' onClick="javascript:<portlet:namespace />sendAllArticles();" />
				</div>		
		<%			}
				}catch(Exception ex){}
		%>			
					
		<br><br><div></div>
			
		<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
		
		 <liferay-ui:upload-progress
		    id="<%= uploadProgressId %>"
		    message="uploading"
		    redirect="<%= HtmlUtil.escape(redirect) %>"
		  />

			
	</c:otherwise>
</c:choose>
