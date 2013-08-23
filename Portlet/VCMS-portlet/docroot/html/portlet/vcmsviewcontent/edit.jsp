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
<%@ include file="/html/portlet/vcmsviewcontent/init.jsp" %>	
<%
	
String redirect = ParamUtil.getString(request, "redirect");

List selectLayouts = (List)request.getAttribute("SELECT_LAYOUTS");
List selectPortletLayoutIds = (List)request.getAttribute("SELECT_PORTLET_LAYOUT_IDS");
List articleTypes = VcmsTypeServiceUtil.getTypesByS_L(groupId,	language);

if(selectPortletLayoutIds == null && Validator.isNotNull(layoutPortletId)){
	try{
		selectPortletLayoutIds = LayoutPortletUtil.getPortletIdsByLayout(Long.parseLong(layoutPortletId));
	}catch(Exception ex){

	}
}

PortletURL actionURL = renderResponse.createActionURL();
actionURL.setParameter("jspPage","/html/portlet/vcmsviewcontent/edit.jsp");
String portionId2="";
String parentId2 = "";
if (Validator.isNotNull(portionId) && (portionId.indexOf("|") > 0)) {
	String[] ppIds = StringUtil.split(portionId, "|");
	portionId2 = ppIds[0];
	parentId2 = ppIds[1];
 }
 
String[] strPortion = null;
String[] strCategory = null;

String plid_layout = (String)request.getAttribute("PLID_LAYOUT");
System.out.println("PLID_LAYOUT" + plid_layout); 
if(Validator.isNull(plid_layout)||(Validator.isNotNull(plid_layout) && plid_layout.equals("0"))){
	plid_layout = layoutPortletId;
	//hoan
	if(layoutPortletId.equals(StringPool.BLANK)){
		plid_layout = String.valueOf( layout.getPlid());
		selectPortletLayoutIds =  LayoutPortletUtil.getPortletIdsByLayout(layout.getPlid());
		portletSelectId = portletDisplay.getId();				
	}
	//hoan
}

int nextNewByNewest = GetterUtil.getInteger(prefs.getValue(ConstantsExt.NEXT_NEWS_BY_NEWEST,"5"));

int nextNewByOrder = GetterUtil.getInteger(prefs.getValue(ConstantsExt.NEXT_NEWS_BY_ORDER,"5"));

int nextNewByInFlow = GetterUtil.getInteger(prefs.getValue(ConstantsExt.NEXT_NEWS_BY_IN_FLOW,"5"));

int numberArticlesInCat = GetterUtil.getInteger(prefs.getValue(ConstantsExt.NUMBER_ARTICLES_IN_CAT_DEFAULT,"5"));

int numberArticlesNextInCat = GetterUtil.getInteger(prefs.getValue(ConstantsExt.NUMBER_ARTICLES_NEXT_IN_CAT_DEFAULT,"5"));

int articleDisplayInType = GetterUtil.getInteger(prefs.getValue("articleDisplayInType","5"));

boolean pagingDisplay = GetterUtil.getBoolean(prefs.getValue(ConstantsExt.PAGING_DISPLAY,"true"));

boolean isDisplaySendEmail = GetterUtil.getBoolean(prefs.getValue(ConstantsExt.IS_DISPLAY_SEND_EMAIL,"true"));

boolean isDisplayPrintArticle = GetterUtil.getBoolean(prefs.getValue(ConstantsExt.IS_DISPLAY_PRINT_ARTICLE,"true"));

boolean isDisplayImageNew = GetterUtil.getBoolean(prefs.getValue("isDisplayImageNew","false"));

boolean isDisplayDiscussion = GetterUtil.getBoolean(prefs.getValue(ConstantsExt.IS_DISPLAY_DISCUSSION_ARTICLE,"true"));

boolean isDisplayDate = GetterUtil.getBoolean(prefs.getValue("isDisplayDate","true"));

boolean pagingType = GetterUtil.getBoolean(prefs.getValue("pagingType","true"));

int columnDisplay = GetterUtil.getInteger(prefs.getValue("columnDisplay","1"));

int pagingStyle = GetterUtil.getInteger(prefs.getValue(ConstantsExt.PAGING_STYLE,"5"));

int numberOfStickedNews = GetterUtil.getInteger(prefs.getValue(ConstantsExt.NUMBER_OF_STICKED_NEWS,"5"));

int numberOfNewestArticle = GetterUtil.getInteger(prefs.getValue(ConstantsExt.NUMBER_OF_NEWEST_ARTICLE,"5"));

int displayStyle = GetterUtil.getInteger(prefs.getValue(ConstantsExt.DISPLAY_STYLE,"5"));	

String categoryId = prefs.getValue("categoryId","");

String typeId = prefs.getValue("typeId","");

String emailSubject = prefs.getValue(ConstantsExt.EMAIL_SUBJECT,"C&#7893;ng thông tin &#273;i&#7879;n t&#7917;: Th&#432; m&#7901;i &#273;&#7885;c bi vi&#7871;t t&#7915; b&#7841;n [$FROM_NAME$]:");

String emailContent = prefs.getValue(ConstantsExt.EMAIL_CONTENT,"Dear [$TO_NAME$],<br/> [$FROM_NAME$] &#273; g&#7917;i cho b&#7841;n 1 tin nh&#7855;n <br/> [$MESSAGE$] <br/><br/> ------------------------------------------------------------------- <br/> Hy click vo link sau &#273;&#7875; xem chi ti&#7871;t bi vi&#7871;t <br/> [$ARTICLE_LINK$]. <br/> Sincerely,<br/><br/>[$FROM_NAME$] <br/> [$PORTAL_URL$]");


String displayContent = prefs.getValue("displayContent","default");

String defaultStyle = prefs.getValue("defaultStyle",""); // Style of View Default
	
String tabsStyle = prefs.getValue("tabsStyle","");	// Style of View Tabs

String stickyStyle = prefs.getValue("stickyStyle","");	// Style of View Sticky

String typeStyle = prefs.getValue("typeStyle","");	// Style of View Article by Type

String newestStyle = prefs.getValue("newestStyle","");

//hoan
int numberArticles = GetterUtil.getInteger(prefs.getValue(ConstantsExt.NUMBER_OF_ARTICLES,"5"));
int numberArticlesDisplayImages = GetterUtil.getInteger(prefs.getValue(ConstantsExt.NUMBER_OF_ARTICLES_DISPLAY_IMAGES,"1"));
boolean groupCategory = GetterUtil.getBoolean(prefs.getValue(ConstantsExt.GROUP_CATEGORYS, "true"));
//hoan
%>

		
<script>
	var cObjects = document.getElementsByName("<portlet:namespace />category");	
	var catIds = document.getElementsByName("<portlet:namespace />categoryId");	

	function <portlet:namespace />initDiscussionEmailEditor() {
	
		document.<portlet:namespace />fm.<portlet:namespace />emailContent.value = "<%= UnicodeFormatter.toString(emailContent) %>";
		return "<%= UnicodeFormatter.toString(emailContent) %>";
	}
	
	function <portlet:namespace />saveConfiguration() {		
		var categories = '';		
		for (i = 0; i < cObjects.length; i ++) {
			if (cObjects[i].checked) {
				categories += cObjects[i].value + ',';			
			}
			
		}
		
		
		var layoutPlId = document.<portlet:namespace />fm.<portlet:namespace />layoutPortletId.value;
		if(layoutPlId != "0"){
			document.<portlet:namespace />fm.<portlet:namespace />layoutIdSelected.value = layoutPlId;
		}
		document.<portlet:namespace />fm.<portlet:namespace />categories.value = categories;
		
		document.<portlet:namespace />fm.<portlet:namespace />emailContent.value = $('[<portlet:namespace />emailContent]').html();
		
		/* $('[name=<portlet:namespace />categories]').val(categories);
		$('[name=<portlet:namespace />emailContent]').val(""); */
				
		submitForm(document.<portlet:namespace />fm, '<portlet:actionURL name="saveConfiguration" windowState="<%= WindowState.MAXIMIZED.toString() %>"></portlet:actionURL>');
	}
	
	function <portlet:namespace/>findPortletLayout(){
		var layoutPlId = document.<portlet:namespace />fm.<portlet:namespace />layoutPortletId.value;
		if(layoutPlId != "0"){
			document.<portlet:namespace />fm.<portlet:namespace />layoutIdSelected.value = layoutPlId;
		
			submitForm(document.<portlet:namespace />fm, '<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/vcmsviewcontent/edit" /></portlet:renderURL>');
		}
	}
	
	function <portlet:namespace />changeStyleDisplay(styleObj) {	
		if(styleObj)
			
			if(styleObj.value=='default'){				
				document.getElementById("<portlet:namespace/>viewDefault").style.display = '';
				document.getElementById("<portlet:namespace/>viewTabs").style.display = 'none';
				document.getElementById("<portlet:namespace/>viewSticky").style.display = 'none';
				document.getElementById("<portlet:namespace/>viewType-of-article").style.display = 'none';	
				document.getElementById("<portlet:namespace/>selectCategory").style.display = '';				
				document.getElementById("<portlet:namespace/>viewnewestArticle").style.display = 'none';	
			} else if(styleObj.value=='sticky'){
				document.getElementById("<portlet:namespace/>viewDefault").style.display = 'none';
				document.getElementById("<portlet:namespace/>viewTabs").style.display = 'none';
				document.getElementById("<portlet:namespace/>viewSticky").style.display = '';
				document.getElementById("<portlet:namespace/>viewType-of-article").style.display = 'none';	
				document.getElementById("<portlet:namespace/>selectCategory").style.display = 'none';				
				document.getElementById("<portlet:namespace/>viewnewestArticle").style.display = 'none';	
				
			}else if(styleObj.value=='tabs'){				
				document.getElementById("<portlet:namespace/>viewDefault").style.display = 'none';
				document.getElementById("<portlet:namespace/>viewTabs").style.display = '';
				document.getElementById("<portlet:namespace/>viewSticky").style.display = 'none';
				document.getElementById("<portlet:namespace/>viewType-of-article").style.display = 'none';	
				document.getElementById("<portlet:namespace/>selectCategory").style.display = 'none';				
				document.getElementById("<portlet:namespace/>viewnewestArticle").style.display = 'none';	
				
			} else if(styleObj.value=='type-of-article'){
				document.getElementById("<portlet:namespace/>viewDefault").style.display = 'none';
				document.getElementById("<portlet:namespace/>viewTabs").style.display = 'none';
				document.getElementById("<portlet:namespace/>viewSticky").style.display = 'none';
				document.getElementById("<portlet:namespace/>viewType-of-article").style.display = '';	
				document.getElementById("<portlet:namespace/>selectCategory").style.display = '';				
				document.getElementById("<portlet:namespace/>viewnewestArticle").style.display = 'none';	
				
			}
	}
</script>
	 
<form  method="post" name="<portlet:namespace/>fm" >

<input name="<portlet:namespace />layoutIdSelected" type="hidden" value="<%=plid_layout%>"/>	
<input name="<portlet:namespace />categories" type="hidden" value=""/>
<input name="<portlet:namespace />categoriesChecked" type="hidden" value="<%=categories%>"/>
<input name="<portlet:namespace />cmd" type="hidden" value="SELECT_LAYOUT"/>	

<liferay-ui:tabs
	names="general-config,config-category,config-display-article,display-config-new"
	param="tabs3"
	refresh="<%= false %>">

<div style="border-left:2px solid #BFDCEB;border-bottom:2px solid #BFDCEB;border-right:2px solid #BFDCEB;">	
	<liferay-ui:section>
	<div style="padding-left:10px;padding-right:5px;">	
		<table width="100%" border="0" cellpadding="4" cellspacing="1">
		<tr>
			<td width="35%"><img src="/VCMS-portlet/html/portlet/vcmsviewcontent/images/editcopy.png">
				<liferay-ui:message key="select-layout-tab-to-display-article" />:</td>			
			<td>
				<select name="<portlet:namespace/>layoutPortletId" onchange="javascript:<portlet:namespace/>findPortletLayout();">
					<option value="0">---------</option>
					<%	if(selectLayouts != null && selectLayouts.size()>0){
						for(int count = 0; count<selectLayouts.size();count++){
							
							Layout selectLayout = (Layout)selectLayouts.get(count);
							%>
							
							<option value="<%=selectLayout.getPlid()%>" <%=(Validator.isNotNull(plid_layout) && plid_layout.equals(String.valueOf(selectLayout.getPlid())))?"selected":""%>><%=selectLayout.getHTMLTitle(language)%></option>
					<%}}%>
				</select>
	    	</td>
		</tr>
					
		<tr>
	    	<td><img src="/VCMS-portlet/html/portlet/vcmsviewcontent/images/editcopy.png" >
				<liferay-ui:message key="select-portlet-to-display-article" />:</td>
	    		
			<td>
				<select name="<portlet:namespace/>portletSelectId">
					<%	if(selectPortletLayoutIds != null && selectPortletLayoutIds.size()>0){
							for(int count = 0; count<selectPortletLayoutIds.size();count++){
								String portletLayoutId = (String)selectPortletLayoutIds.get(count);%>
					
									<option value="<%=portletLayoutId%>" <%=(Validator.isNotNull(portletSelectId) && portletSelectId.equals(portletLayoutId))?"selected":""%>><%=portletLayoutId%></option>
					<%}}%>
				</select>
	    	</td>
	    </tr>
	    
	    <tr><td colspan="2">&nbsp;</td></tr>
	    
	  	<tr>
			<td align="left"><liferay-ui:message key="email-title" />:</td>
			<td><input type="text" class="form-text" style="width: 300px" id="<portlet:namespace />emailSubject" name="<portlet:namespace />emailSubject" value="<%= Validator.isNull(emailSubject) ? StringPool.BLANK : emailSubject %>" /></td>
		</tr>
			
		<tr>
			<td valign="top"><liferay-ui:message key="email-content" />:</td>
			<td>
				<liferay-ui:input-editor name="<%= renderResponse.getNamespace() + \"emailContent\" %>" editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY_DEFAULT %>" toolbarSet="Basic" width="70%" height="200" initMethod="<%= renderResponse.getNamespace() + \"initDiscussionEmailEditor\" %>"/>
<%-- 				<vportal:input-editor name="<%= renderResponse.getNamespace() + \"emailContent\" %>" editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY_DEFAULT %>" toolbarSet="Basic" width="70%" height="200" initMethod="<%= renderResponse.getNamespace() + \"initDiscussionEmailEditor\" %>" /> --%>
				<input type="hidden" name="<portlet:namespace />emailContent" /></td>
		</tr>
		</table>
		<br>	
		
		<div>
			<input type="button" value="<liferay-ui:message key="save" />" onclick="javascript:<portlet:namespace/>saveConfiguration();"/>
			<input type="button" value="<liferay-ui:message key="back" />" onClick="self.location = '<%= redirect %>';"/>	
		</div>
		<br/>	
	</div>			
	</liferay-ui:section>
				
	<liferay-ui:section>
	<div style="padding-left:10px;padding-right:5px;">		
		<table width="100%" border="0" cellpadding="4" cellspacing="1">
		<tr height="25">	
			<td colspan="2"><strong><liferay-ui:message key="config-display-by-category" /></strong></td>			
		</tr>
			
		<tr>
			<td colspan="2">
				<table width="100%" border="0" cellpadding="4" cellspacing="1">
				<tr height="25">
					<td width="50%"><img src="/VCMS-portlet/html/portlet/vcmsviewcontent/images/pages.png" >&nbsp;<liferay-ui:message key="number-of-article-display-by-category" /></td>
    				<td>
	    				<select name="<portlet:namespace/>numberArticlesInCat">
	    				<%for (int i = 1; i < 20; i++) {%>
							<option value="<%= i %>" <%=numberArticlesInCat==i?"selected":""%>><%= i %></option>
						<%}%>
	    				</select>
	    			</td>
				</tr>
				<tr height="25">
					<td><img src="/VCMS-portlet/html/portlet/vcmsviewcontent/images/pages.png" >&nbsp;<liferay-ui:message key="number-of-article-display-by-category-next" /></td>	
					<td>
	    				<select name="<portlet:namespace/>numberArticlesNextInCat">
	    				<%for (int i = 1; i < 20; i++) {%>
							<option value="<%= i %>" <%=numberArticlesNextInCat==i?"selected":""%>><%= i %></option>
						<%}%>
	    				</select>
	    			</td>
				</tr>
				<tr height="25">
					<td><img src="/VCMS-portlet/html/portlet/vcmsviewcontent/images/date.png" >&nbsp;<label for="<portlet:namespace/>isDisplayDate"><liferay-ui:message key="display-function-get-article-by-date" /></label></td>	
					<td>
	    				<input type="checkbox" name="<portlet:namespace/>isDisplayDate" id="<portlet:namespace/>isDisplayDate" <%=isDisplayDate?"checked":""%> />
	    			</td>
				</tr>
				<tr height="25">
					<td><img src="/VCMS-portlet/html/portlet/vcmsviewcontent/images/orphan_pages.png" >&nbsp;<label for="<portlet:namespace/>isDisplayPaging"><liferay-ui:message key="display-function-sub-list-article" /></label></td>	
					<td>
	    				<input type="checkbox" name="<portlet:namespace/>pagingDisplay" id="<portlet:namespace/>isDisplayPaging" <%=pagingDisplay?"checked":""%> />
	    			</td>
				</tr>												
				</table>
			</td>
		</tr>	
		</table>
		<br/>					
		<div>
			<input type="button" value="<liferay-ui:message key="save" />" onclick="javascript:<portlet:namespace/>saveConfiguration();"/>
			<input type="button" value="<liferay-ui:message key="back" />" onClick="self.location = '<%= redirect %>';"/>	
		</div>
		<br/>					
	</div>							
	</liferay-ui:section>
		
	<!--Tabs4-->
	<liferay-ui:section>
	<div style="padding-left:10px;padding-right:5px;">	
	<table width="100%" border="0" cellpadding="4" cellspacing="1">
		<tr height="25">				
			<td colspan="2"><strong><liferay-ui:message key="config-display-detail-article" /></strong></td>			
		</tr>
		<tr>
			<td width="50%" valign="top">	
				<table width="100%" border="0" cellpadding="4" cellspacing="1">
				<tr height="25">	
	    			<td width="80%"><img src="/VCMS-portlet/html/portlet/vcmsviewcontent/images/pages.png" >&nbsp;<liferay-ui:message key="number-of-article-next" /></td>
	    			<td align="left">
	    				<select name="<portlet:namespace/>nextNewByNewest">
	    				<%for (int i = 5; i < 25; i=i+5) {%>
							<option value="<%= i %>" <%= (nextNewByNewest == i) ? "selected" : "" %>><%= i %></option>
						<%}%>
	    				</select>
	    			</td>
	    		</tr>
				<tr height="25">	
	    			<td><img src="/VCMS-portlet/html/portlet/vcmsviewcontent/images/pages.png" >&nbsp;<liferay-ui:message key="number-of-article-older" /></td>
	    			<td>
						<select name="<portlet:namespace/>nextNewByOrder">
	    				<%for (int i = 5; i < 25; i=i+5) {%>
							<option value="<%= i %>" <%= (nextNewByOrder == i) ? "selected" : "" %>><%= i %></option>
						<%}%>
	    				</select>
	    			</td>
	    		</tr>
				<tr height="25">	
	    			<td><img src="/VCMS-portlet/html/portlet/vcmsviewcontent/images/pages.png" >&nbsp;<liferay-ui:message key="number-of-article-in-thread" /></td>
	    			<td>
	    				<select name="<portlet:namespace />nextNewByInFlow">
						<%for (int i = 5; i < 25; i=i+5) {%>
						<option value="<%= i %>" <%= (nextNewByInFlow == i) ? "selected" : "" %>><%= i %></option>
						<%}%>
						</select>		
	    			</td>
	    		</tr>	
	    					
				<tr height="25">	
	    			<td><img src="/VCMS-portlet/html/portlet/vcmsviewcontent/images/edit_guest" >&nbsp;<label for="<portlet:namespace/>isDisplayDiscussion"><liferay-ui:message key="enabled-to-send-discuss" /></label></td>
	    			<td>
	    				<input type="checkbox" name="<portlet:namespace/>isDisplayDiscussion" id="<portlet:namespace/>isDisplayDiscussion" <%=isDisplayDiscussion?"checked":""%>>	
	    			</td>
	    		</tr>
	    			
				<tr height="25">	
	    			<td><img src="/VCMS-portlet/html/portlet/vcmsviewcontent/images/mail_send.png" >&nbsp;<label for="<portlet:namespace/>isDisplaySendEmail"><liferay-ui:message key="enabled-to-send-email" /><label></td>
	    			<td>
	    				<input type="checkbox" name="<portlet:namespace/>isDisplaySendEmail" id="<portlet:namespace/>isDisplaySendEmail" <%=isDisplaySendEmail?"checked":""%>>	
	    			</td>
	    		</tr>						
	    		
				<tr height="25">	
	    			<td>
	    				<img src="/VCMS-portlet/html/portlet/vcmsviewcontent/images/fileprint.png" >&nbsp;<label for="<portlet:namespace/>isDisplayPrintArticle"><liferay-ui:message key="enabled-to-print-article" /></label></td>
	    			<td>
	    				<input type="checkbox" name="<portlet:namespace/>isDisplayPrintArticle" id="<portlet:namespace/>isDisplayPrintArticle" <%=isDisplayPrintArticle?"checked":""%>>	
	    			</td>
	    		</tr>	
				</table>
			</td>
					
			<td valign="top">		
				<table width="100%" border="0" cellpadding="4" cellspacing="1">
				<tr height="25">	
	    			<td width="80%"><img src="/VCMS-portlet/html/portlet/vcmsviewcontent/images/pages.png" >&nbsp;<label for="<portlet:namespace/>isDisplayImageNew"><liferay-ui:message key="display-image-new-article" /></label></td>
	    			<td align="left">
	    				<input type="checkbox" name="<portlet:namespace/>isDisplayImageNew" id="<portlet:namespace/>isDisplayImageNew" <%=isDisplayImageNew?"checked":""%> >
	    			</td>
	    		</tr>
	    		</table>			
			</td>	
		</tr>	
		</table>
		<br/>			
		<div>
			<input type="button" value="<liferay-ui:message key="save" />" onclick="javascript:<portlet:namespace/>saveConfiguration();"/>
			<input type="button" value="<liferay-ui:message key="back" />" onClick="self.location = '<%= redirect %>';"/>	
		</div>
		<br/>			
	</div>										
	</liferay-ui:section>
	
	<liferay-ui:section>		<!--Tab config new-->
	<div style="padding-left:10px;padding-right:10px;">	
		
			<!-- View Portlet by Tabs -->			
				
		<table width="100%" border="0" cellpadding="4" cellspacing="1">
		<tr height="25">	
			<td colspan="2"><strong><liferay-ui:message key="config-display-by-category" /></strong></td>
			<td>Tieu De:<input type="text" name="<portlet:namespace/>titlecategory" value="<%= titlecategory%>"></td>					
		</tr>
			
		<tr>
			<td colspan="2">
				<table width="100%" border="0" cellpadding="4" cellspacing="1">
				<tr height="25">
					<td width="50%"><img src="/VCMS-portlet/html/portlet/vcmsviewcontent/images/pages.png" >&nbsp;<liferay-ui:message key="number-of-article-display" /></td>
    				<td>
	    				<select name="<portlet:namespace/>numberArticles">
	    				<%for (int i = 1; i <= 20; i++) {%>
							<option value="<%= i %>" <%=numberArticles==i?"selected":""%>><%= i %></option>
						<%}%>
	    				</select>
	    			</td>
				</tr>
				<tr height="25">
					<td style="padding-left:25px;"><img src="/VCMS-portlet/html/portlet/vcmsviewcontent/images/pages.png" >&nbsp;<liferay-ui:message key="number-of-article-display-images" /></td>	
					<td>
	    				<select name="<portlet:namespace/>numberArticlesDisplayImages">
	    				<%for (int i = 1; i <= 20; i++) {%>
							<option value="<%= i %>" <%=numberArticlesDisplayImages==i?"selected":""%>><%= i %></option>
						<%}%>
	    				</select>
	    			</td>
				</tr>
				<tr height="25">
					<td><img src="/VCMS-portlet/html/portlet/vcmsviewcontent/images/orphan_pages.png" >&nbsp;<label for="<portlet:namespace/>isDisplayPaging"><liferay-ui:message key="display-function-sub-list-article" /></label></td>	
					<td>
	    				<input type="checkbox" name="<portlet:namespace/>pagingDisplay" id="<portlet:namespace/>isDisplayPaging" <%=pagingDisplay?"checked":""%> />
	    			</td>
				</tr>			
				<tr height="25">
					<td><img src="/VCMS-portlet/html/portlet/vcmsviewcontent/images/date.png" >&nbsp;<label for="<portlet:namespace/>isDisplayDate"><liferay-ui:message key="display-function-get-article-by-date" /></label></td>	
					<td>
	    				<input type="checkbox" name="<portlet:namespace/>isDisplayDate" id="<portlet:namespace/>isDisplayDate" <%=isDisplayDate?"checked":""%> />
	    			</td>
				</tr>
				<tr height="25">				
						<td width="60%"><img src="/VCMS-portlet/html/portlet/vcmsviewcontent/images/orphan_pages.png" >&nbsp;
							<liferay-ui:message key="enabled-pagging" /></td>		
						<td>
							<input type="checkbox" name="<portlet:namespace/>pagingType" <%=pagingType?"checked":""%>/>
						</td>		
					</tr>
				<tr height="25">				
						<td width="60%"><img src="/VCMS-portlet/html/portlet/vcmsviewcontent/images/orphan_pages.png" >&nbsp;
							<liferay-ui:message key="group-category" /></td>		
						<td>
							<input type="checkbox" name="<portlet:namespace/>groupCategory" <%=groupCategory?"checked":""%>/>
						</td>		
					</tr>											
				</table>
			</td>
		</tr>	
		</table>
		
		<div id="<portlet:namespace/>articleInCategory" >
			<table border="0" cellpadding="4" cellspacing="0" width="100%">
			<tr height="25">		
				<td>
					<img src="/VCMS-portlet/html/portlet/vcmsviewcontent/images/category.png" >
					<strong><liferay-ui:message key="select-category-to-display" /></strong></td>					
			</tr>
			<tr>
				<td>
					<div style="overflow: auto; height: 200px; border:1px solid">
						<table cellspacing="3" cellpadding="0" width="100%" border="0">
							<%= ActionUtil.getCategoryTree(groupId,language, renderResponse.getNamespace(),permissionChecker,strPortion,strCategory ) %>
						</table>
					</div>	
				</td>
			</tr>
			<tr>
				<tr height="25"><td><liferay-ui:message key="select-style-to-display" /></td></tr>
						<tr height="25">	
							<td><input type="radio" name="<portlet:namespace />defaultStyle" value="style_01" <%=defaultStyle.equals("style_01")?"checked":""%>>&nbsp;
								<%= LanguageUtil.get(pageContext, "vcms.style.default.style1") %></td>
						</tr>							
						<tr height="25">	
							<td><input type="radio" name="<portlet:namespace />defaultStyle" value="style_02" <%=defaultStyle.equals("style_02")?"checked":""%>>&nbsp;
								<%= LanguageUtil.get(pageContext, "vcms.style.default.style2") %></td>
						</tr>
						<tr height="25">	
							<td><input type="radio" name="<portlet:namespace />defaultStyle" value="style_03" <%=defaultStyle.equals("style_03")?"checked":""%>>&nbsp;
								<%= LanguageUtil.get(pageContext, "vcms.style.default.style3") %></td>
						</tr>
						<tr height="25">	
							<td><input type="radio" name="<portlet:namespace />defaultStyle" value="style_04" <%=defaultStyle.equals("style_04")?"checked":""%>>&nbsp;
								<%= LanguageUtil.get(pageContext, "vcms.style.default.style4") %></td>
						</tr>
						<tr height="25">	
							<td><input type="radio" name="<portlet:namespace />defaultStyle" value="style_05" <%=defaultStyle.equals("style_05")?"checked":""%>>&nbsp;
								<%= LanguageUtil.get(pageContext, "vcms.style.default.style5") %></td>
						</tr>
					</table>
				</td>
			</tr>
			</table>		
		</div>
		<!-- hoan Newest Article-->
		<table border="0" cellpadding="4" cellspacing="0" width="100%">			
			<tr>
			<td valign="top" colspan="2">		
					<c:if test="<%=Validator.isNotNull(articleTypes) && articleTypes.size()>0%>"> 	
			  		<table border="0" cellpadding="4" cellspacing="0" width="100%">
			  		<tr height="25"><td colspan="2"><strong><liferay-ui:message key="select-type-display-of-article" /></strong></td></tr>
			  		<%	for(int i=0;i<articleTypes.size();i++){
			  				VcmsType vType = (VcmsType)articleTypes.get(i);%>
		  			<tr height="25">	
		  				<td width="5%" align="center"><input type="radio" name="<portlet:namespace/>typeId" id="<portlet:namespace/>typeId_<%=vType.getTypeId()%>" value="<%=vType.getTypeId()%>" <%=typeId.equals(vType.getTypeId())?"checked":""%>>
		  				<td align="left"><label for="<portlet:namespace/>typeId_<%=vType.getTypeId()%>"><%=vType.getName()%></label></td>	
		  			</tr>
			  		<%}%>
			  		</table>				
				  	</c:if>	
				</td>		
			</tr>
			</table>			
	    <br/>
		<div>
			<input type="button" value="<liferay-ui:message key="save" />" onclick="<portlet:namespace/>saveConfiguration();"/>
			<input type="button" value="<liferay-ui:message key="back" />" onClick="self.location = '<%= redirect %>';"/>	
		</div>			
		<br/>	
	</div>	
	</liferay-ui:section>	
</div>			
</liferay-ui:tabs>
</form>

<%!
public static final String EDITOR_WYSIWYG_IMPL_KEY_DEFAULT = "editor.wysiwyg.default";
%>
<script type="text/javascript">
	var catsChecked	= document.<portlet:namespace />fm.<portlet:namespace />categoriesChecked.value;
	var arrCatsChecked = new Array();
	arrCatsChecked = catsChecked.split(",");
	
	var catObjects = document.getElementsByName("<portlet:namespace />category");
	for (i = 0; (arrCatsChecked != null) && (i < arrCatsChecked.length); i ++) {
		for (j = 0; (catObjects != null) && (j < catObjects.length); j ++) {
			if(catObjects[j].value == arrCatsChecked[i]){
				catObjects[j].checked = true;
			}
		}
	}
</script> 