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


<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.util.PwdGenerator"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@ include file="/html/portlet/vcms/init.jsp" %>
<%
	String tabsNames = "portlet.vcms.tabs.information";

// 	if(showTabArticles){
		tabsNames += ",portlet.vcms.tabs.article";
// 	}
	
// 	if(showTabPortions || showTabCategorys || showTabConfigs){
		tabsNames += ",portlet.vcms.tabs.manage";
// 	}
	
// 	if (showTabReport){
		tabsNames += ",portlet.vcms.tabs.report";
// 	}
	
// 	if(showTabLogs){
		tabsNames += ",portlet.vcms.tabs.logging";
// 	}
	
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.MAXIMIZED);
	portletURL.setParameter("jspPage", "/html/portlet/vcms/view.jsp");
	portletURL.setParameter("tabs1", tabs1);
	portletURL.setParameter("tabs2", tabs2);
	portletURL.setParameter("language", language);
	portletURL.setParameter("groupId", String.valueOf(groupId));
	portletURL.setParameter("portionId", portionId);
	portletURL.setParameter("parentId", parentId);
	
	PortletURL categoryURL = renderResponse.createRenderURL();
	categoryURL.setWindowState(WindowState.MAXIMIZED);
	/* categoryURL.setParameter("struts_action", "/vcms/view"); */
	categoryURL.setParameter("jspPage","/html/portlet/vcms/view.jsp");
	categoryURL.setParameter("tabs1", "portlet.vcms.tabs.manage");
	categoryURL.setParameter("tabs2", "portlet.vcms.tabs.category");
	categoryURL.setParameter("language", language);
	categoryURL.setParameter("groupId", String.valueOf(groupId));
	

	User vUser = UserLocalServiceUtil.getUser(userId);
	String uploadProgressId = PwdGenerator.getPassword(PwdGenerator.KEY3, 4);
	
	
/* 	PortletURL popupMessage = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.MAXIMIZED);
	portletURL.setParameter("jspPage", "/html/portlet/vcms/articles/article_message.jsp"); */
%>
<style type="text/css">
.button_close{
margin: 0 auto;
}
</style>
<portlet:renderURL var="popupMessage" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
  <portlet:param name="jspPage" value="/html/portlet/vcms/articles/article_message.jsp"/>
</portlet:renderURL>
<%
	SessionErrors.clear(request);
%>
<script type="text/javascript">
	function <portlet:namespace />submitForm() {
		submitForm(document.<portlet:namespace />fm, '<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/vcms/view" /></portlet:renderURL>');
	}
	
	function <portlet:namespace />doSearchArticles() {
		submitForm(document.<portlet:namespace />fm, '<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="jspPage" value="/html/portlet/vcms/view.jsp" /></portlet:renderURL>');
		<%= uploadProgressId %>.startProgress();
	}
	
	function <portlet:namespace />doSearchDiscussions() {
		submitForm(document.<portlet:namespace />fm, '<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/vcms/view" /></portlet:renderURL>');
	}
	
	function <portlet:namespace />doSearchLoggers() {
		submitForm(document.<portlet:namespace />fm, '<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/vcms/view" /></portlet:renderURL>');
	}
	
	function <portlet:namespace />updatePortion(cmd, render) {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = cmd;
		
		if (render) {
			submitForm(document.<portlet:namespace />fm, '<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="jspPage" value="/html/portlet/vcms/manage/portion/edit_portion.jsp"/></portlet:renderURL>');
		} else {
			submitForm(document.<portlet:namespace />fm, '<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/vcms/edit_portion" /></portlet:actionURL>');
		}
	}
	
	function <portlet:namespace />updateType(cmd, render){
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = cmd;
		
		if (render) {
			submitForm(document.<portlet:namespace />fm, '<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="jspPage" value="/html/portlet/vcms/manage/type/edit_type.jsp" /></portlet:renderURL>');
		} else {
			submitForm(document.<portlet:namespace />fm, '<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/vcms/edit_type" /></portlet:actionURL>');
		}
	}
	
	function <portlet:namespace />updateCategory(cmd, render) {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = cmd;
		
		if (render) {
			submitForm(document.<portlet:namespace />fm, '<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="jspPage" value="/html/portlet/vcms/manage/categories/edit_category.jsp"/></portlet:renderURL>');
		} else {
			submitForm(document.<portlet:namespace />fm, '<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/vcms/edit_category" /></portlet:actionURL>');
		}
	}
	
	function <portlet:namespace />updateCategoryPosition(selector) {
		document.<portlet:namespace />fm.<portlet:namespace />position.value = selector.value;
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = 'update_position';
		submitForm(document.<portlet:namespace />fm, '<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="<%= ActionRequest.ACTION_NAME %>" value="updateCategoryPosition" /></portlet:actionURL>');
	}
	
	function <portlet:namespace />updateArticle(cmd, render) {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = cmd;
		
		if (render) {
			submitForm(document.<portlet:namespace />fm, '<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="jspPage" value="/html/portlet/vcms/articles/edit_article.jsp" /></portlet:renderURL>');
		} else {
			submitForm(document.<portlet:namespace />fm, '<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/vcms/edit_article" /></portlet:actionURL>');
		}
	}
	
	Liferay.provide( window,'<portlet:namespace />deleteArticles', function() {
		var Ids = '';
		var listsChecked =  document.getElementsByName("<portlet:namespace />rowIds");		
		for (i = 0; (listsChecked != null) && (i < listsChecked.length); i ++) {
			if (listsChecked[i].checked) {						
				Ids += listsChecked[i].value +  (i<listsChecked.length-1 ? ',':'');						
			}
		}				
		if(Ids.length>0){
			if(confirm('<%= LanguageUtil.get(pageContext, "portlet.vcms.article.delete-all")%>')){
				document.<portlet:namespace />fm.<portlet:namespace />articleIds.value = Ids;
				document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = '<%= Constants.DELETE %>';
				submitForm(document.<portlet:namespace />fm, '<portlet:actionURL name="deleteArticle" windowState="<%= WindowState.MAXIMIZED.toString() %>"></portlet:actionURL>');					
			}			
		} else if(Ids == '') {
			alert("<%= LanguageUtil.get(pageContext, "portlet.vcms.article.listchecked.warning")%>");
		}
	},['liferay-util-list-fields']
    );
	
	function <portlet:namespace />approveAllArticles(){
		var listsChecked = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
		if (listsChecked != ""){
			if(confirm('<%= LanguageUtil.get(pageContext, "portlet.vcms.article.approve-all")%>')){
				document.<portlet:namespace />fm.<portlet:namespace />articleIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
				document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = 'APPROVE_ALL_ARTICLES';
				submitForm(document.<portlet:namespace />fm, '<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/vcms/edit_article" /></portlet:actionURL>');
			}
		}else {
			alert("<%= LanguageUtil.get(pageContext, "portlet.vcms.article.listchecked.warning")%>");
		}
	}

	function <portlet:namespace />updateThread(cmd, render) {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = cmd;
		
		if (render) {
			submitForm(document.<portlet:namespace />fm, '<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="jspPage" value="/html/portlet/vcms/articles/thread/edit_thread.jsp" /></portlet:renderURL>');
		} else {
			submitForm(document.<portlet:namespace />fm, '<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/vcms/edit_thread" /></portlet:actionURL>');
		}
	}
	
	function <portlet:namespace />deleteThreads(){
		document.<portlet:namespace />fm.<portlet:namespace />threadIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = '<%= Constants.DELETE %>';
		submitForm(document.<portlet:namespace />fm, '<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/vcms/edit_thread" /></portlet:actionURL>');
	}
	
	function <portlet:namespace />updateStatus(cmd, render) {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = cmd;
		
		if (render) {
			submitForm(document.<portlet:namespace />fm, '<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="jspPage" value="/html/portlet/vcms/manage/status/edit_status.jsp" /></portlet:renderURL>');
		} else {
			submitForm(document.<portlet:namespace />fm, '<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/vcms/edit_status" /></portlet:actionURL>');
		}
	}
	
	function <portlet:namespace />updateDiscussion(cmd, render) {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = cmd;
		
		if (render) {
			submitForm(document.<portlet:namespace />fm, '<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="jspPage" value="/html/portlet/vcms/articles/discussions/edit_discussion.jsp" /></portlet:renderURL>');
		} else {
			submitForm(document.<portlet:namespace />fm, '<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/vcms/edit_discussion" /></portlet:actionURL>');
		}
	}
	
	function <portlet:namespace />deleteDiscussions(){
		document.<portlet:namespace />fm.<portlet:namespace />discussionIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = '<%= Constants.DELETE %>';
		submitForm(document.<portlet:namespace />fm, '<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/vcms/edit_discussion" /></portlet:actionURL>');
	}
	
	 Liferay.provide(
			 window, 
			 '<portlet:namespace />deleteLogs',
 		function() {
			var ids = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
			if (ids.length >0){
				if (confirm('<%=UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-delete-the-selected-items")%>')) {
					document.<portlet:namespace />fm.<portlet:namespace />loggerIds.value = ids;
					document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = '<%= Constants.DELETE %>';
		
					submitForm(document.<portlet:namespace />fm, '<portlet:actionURL name="deleteLogs" windowState="<%= WindowState.MAXIMIZED.toString() %>"></portlet:actionURL>');
				}
			}
		},
	['liferay-util-list-fields']
	);
	 
	var <portlet:namespace />MessagesMessageBox = null;
	var messageID = null;
	function <portlet:namespace />closeMessagesMessageBox(){
		document.getElementById(messageID).innerHTML = <portlet:namespace />MessagesMessageBox.innerHTML;
	};
	
	function showMessagesList(messageId){
		
		<%-- messageID = messageId;
		var MessagesMessageBox = Liferay.Popup({modal:true, title: '<%= LanguageUtil.get(pageContext, "portlet.vcms.article.message-list") %>', width: 600});
		//document.getElementById(messageId).innerHTML = "";
		url = "<%= themeDisplay.getPathMain() %>/vcms/article_message?articleId="+messageID;
		AjaxUtil.update(url, MessagesMessageBox , {onComplete: function(){Liferay.Popup.center()}}); --%>
		 AUI().use('aui-dialog', 'aui-io', 'event', 'event-custom', function(A) {
			   
		    var dialog = new A.Dialog({
		            title: '<%= LanguageUtil.get(pageContext, "portlet.vcms.article.message-list") %>',
		            centered: true,
		            draggable: true,
		            modal: true,
		            width: 600,
		            buttons:[                   
		                     {
		                    	 cssClass: 'button_close',
		                    	 text:'Close',handler:function() {
		                         this.close();
		                        }
		                     }
		                ]
		        }).plug(A.Plugin.IO, {data: {articleId:messageId},uri: '<%=popupMessage %>'}).render();
		       
		        dialog.show();
		       
		  });
	};
	
	// Quick Action
	function <portlet:namespace />choiceAction(){
		var type = document.<portlet:namespace/>fm.<portlet:namespace/>action.value;
		if (type == 1){
			<portlet:namespace />updateArticle('<%= Constants.ADD %>', true);
		} else if (type == 2){
			<portlet:namespace />updateCategory('<%= Constants.ADD %>',true)
		} else if (type == 3){
			<portlet:namespace />updatePortion('<%= Constants.ADD %>', true);
		} else if (type == 4){
			<portlet:namespace />updateThread('<%= Constants.ADD %>', true);
		} else if (type == 5){
			<portlet:namespace />updateType('<%= Constants.ADD %>', true);
		} else if (type == 6){
			<portlet:namespace />updateStatus('<%= Constants.ADD %>', true);
		}
	};
	
	function <portlet:namespace />sendAllArticles(){
		var Ids = '';
		var listsChecked =  document.getElementsByName("<portlet:namespace />rowIds");
		
		for (i = 0; (listsChecked != null) && (i < listsChecked.length); i ++) {
			if (listsChecked[i].checked) {
				Ids += listsChecked[i].value +  (i<listsChecked.length-1 ? ',':'');
			}
		}				
		if(Ids.length>0){
			if(confirm('<%= LanguageUtil.get(pageContext, "portlet.vcms.article.send-all")%>')){
				document.<portlet:namespace />fm.<portlet:namespace />articleIds.value = Ids;
				document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = 'send';
				submitForm(document.<portlet:namespace />fm, '<portlet:actionURL name="sendArticle" windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="status" value="true" /></portlet:actionURL>');
			}
		} else if(Ids == '') {
			alert("<%= LanguageUtil.get(pageContext, "portlet.vcms.article.send.listchecked.warning")%>");
		}
	}
</script>

<%--
	// BEGIN: Website list.
--%>

<form action="<%= portletURL.toString() %>" method="post" name="<portlet:namespace />fm" onSubmit="submitForm(this);return false;">
	<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="">
	<input name="<portlet:namespace />tabs1" type="hidden" value="<%= tabs1 %>">
	<input name="<portlet:namespace />tabs2" type="hidden" value="<%= tabs2 %>">
	<input name="<portlet:namespace />tabs3" type="hidden" value="<%= tabs3 %>">	
	<input name="<portlet:namespace />redirect" type="hidden" value="<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/vcms/view" /><portlet:param name="tabs1" value="<%= tabs1 %>" /><portlet:param name="tabs2" value="<%= tabs2 %>" /><portlet:param name="portionId" value="<%= portionId %>" /><portlet:param name="parentId" value="<%= parentId %>" /><portlet:param name="groupId" value="<%= String.valueOf(groupId) %>" /></portlet:renderURL>">
	
	<br />
		
	<table width="100%">	
		<tr>
			<td align="left" style="padding-left:5px;font-weight: bold; ">
				<%= LanguageUtil.get(pageContext, "portlet.vcms.language") %>:&nbsp;
				<select name="<portlet:namespace />language" onChange="javascript:<portlet:namespace />submitForm();">		
				<%	for (int i = 0; i < locales.length; i++) {	%>			
					<option <%= (language.equals(locales[i].getLanguage() + "_" + locales[i].getCountry())) ? "selected" : "" %> value="<%= locales[i].getLanguage() + "_" + locales[i].getCountry() %>"><%= locales[i].getDisplayName(locales[i]) %></option>
				<%	}	%>
				</select>
			</td>			
			
			<td align="right" style="padding-right:5px;">
		<select name="<portlet:namespace/>action" onchange="<portlet:namespace/>choiceAction()">
			<option value="0">-- <%= LanguageUtil.get(pageContext, "portlet.vcms.select.action") %> --</option>
			<c:if test="<%= PortletPermissionUtil.contains(permissionChecker , plid.longValue() , PortletKeysExt.VCMS , ActionKeysExt.ADD_ARTICLE) %>">
				<option value="1"><%= LanguageUtil.get(pageContext, "portlet.vcms.add.article") %></option>
			</c:if>
			<c:if test="<%= PortletPermissionUtil.contains(permissionChecker , plid.longValue() , PortletKeysExt.VCMS , ActionKeysExt.ADD_CATEGORY) %>">
				<option value="2"><%= LanguageUtil.get(pageContext, "portlet.vcms.add.category") %></option>
			</c:if>
			<c:if test="<%= PortletPermissionUtil.contains(permissionChecker , plid.longValue() , PortletKeysExt.VCMS , ActionKeysExt.ADD_PORTION) %>">
				<option value="3"><%= LanguageUtil.get(pageContext, "portlet.vcms.add.portion") %></option>
			</c:if>
			<c:if test="<%= PortletPermissionUtil.contains(permissionChecker , plid.longValue() , PortletKeysExt.VCMS , ActionKeysExt.ADD_THREAD) %>">
				<option value="4"><%= LanguageUtil.get(pageContext, "portlet.vcms.add.thread") %></option>
			</c:if>
			<c:if test="<%= PortletPermissionUtil.contains(permissionChecker , plid.longValue() , PortletKeysExt.VCMS , \"ADD_TYPE\") %>">
				<option value="5"><%= LanguageUtil.get(pageContext, "portlet.vcms.add.type") %></option>
			</c:if>
			<c:if test="<%= PortletPermissionUtil.contains(permissionChecker , plid.longValue() , PortletKeysExt.VCMS , \"ADD_STATUS\") %>">
				<option value="6"><%= LanguageUtil.get(pageContext, "portlet.vcms.add.status") %></option>
			</c:if>
		</select>
	</td>
		</tr>	

	<tr height="30">
		<td align="left" style="padding-left:5px;">		
			<b><%= LanguageUtil.get(pageContext, "account-name") %> :</b> <%=UserLocalServiceUtil.getUser(userId).getFullName()%>
		</td>
		<td align="right" style="padding-right:5px;padding-top:5px;">
		<div>
			<%if(unreadMessagesTotal>0){%>
			<img src='<%=themeDisplay.getPathThemeImage() + "/vcms/alert.png" %>' title="<%= LanguageUtil.get(pageContext, "new-message-notification") %>"/>&nbsp;		
			<%}%>
			<img src='<%=themeDisplay.getPathThemeImage() + "/vcms/unread.png" %>' name="<portlet:namespace/>mail" onClick ="javascript:showMessagesList('','<%=groupId%>');" title="<%= LanguageUtil.get(pageContext, "message") %>"/>&nbsp;		
			
			<img src='<%=themeDisplay.getPathThemeImage() + "/vcms/sign_out.png" %>' onClick="self.location = '/c/portal/logout';"  title="<%= LanguageUtil.get(pageContext, "sign-out") %>"/>
		</div>
		</td>
	</tr>	
		
	</table>	
	
	<br><div class="beta-separator"></div><br>
	
	<liferay-ui:tabs names="<%=tabsNames%>" url="<%=portletURL.toString()%>" param="tabs1"/>
	<c:choose>

		 	<c:when test='<%= tabs1.equals(\"portlet.vcms.tabs.logging\") %>'>
				<%@ include file="/html/portlet/vcms/logs/logs.jsp" %>
			</c:when>
			<c:when test='<%= tabs1.equals(\"portlet.vcms.tabs.article\") %>'>
				<%@ include file="/html/portlet/vcms/articles/articles.jsp" %>
			</c:when>
			<c:when test='<%= tabs1.equals(\"portlet.vcms.tabs.manage\") %>'>
				<%@ include file="/html/portlet/vcms/manage/manage.jsp" %>
			</c:when>
			 <c:when test='<%= tabs1.equals(\"portlet.vcms.tabs.report\") %>'>
				<%@ include file="/html/portlet/vcms/report/report_view.jsp" %>
			</c:when>	
			<c:otherwise>
				<%@ include file="/html/portlet/vcms/statistics/statistics.jsp" %>
			</c:otherwise> 
	</c:choose>
</form>
