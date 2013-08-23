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
<%@ include file="/html/portlet/vcms/init.jsp" %>
<%	
	String redirect = ParamUtil.getString(request, "redirect");
	String articleId = ParamUtil.getString(request,"articleId");
	
	VcmsArticle article = (VcmsArticle) request.getAttribute(WebKeysExt.VCMS_ARTICLE);
	if(Validator.isNotNull(articleId)){
		article = (VcmsArticle)VcmsArticleServiceUtil.getArticle(articleId);
	}

	
	String strCatId = "";
	String strPortionId = "";
	String threadId = "";
	String strType = "";

	List listTypeId = (List)VcmsArticleTypeLocalServiceUtil.getByArticleId(articleId);
	List listCategoryId = (List)VcmsCARelationServiceUtil.getRelationsByArticle(articleId);
	List listPortionId = (List)VcmsPARelationServiceUtil.getRelationsByArticle(articleId);
	List listThreadId = (List)VcmsTARelationServiceUtil.getRelationsByArticle(articleId);
	
	if(Validator.isNotNull(listThreadId) && listThreadId.size()>0){
		for(int i=0;i<listThreadId.size();i++){
			VcmsTARelation TA = (VcmsTARelation)listThreadId.get(0);
			threadId = TA.getThreadId();
		}
	}

	if (Validator.isNotNull(listCategoryId) && listCategoryId.size()>0){
		for (int i = 0; i < listCategoryId.size();i ++){
			VcmsCARelation CA = (VcmsCARelation)listCategoryId.get(i);		
			strCatId += CA.getCategoryId() + (i < listCategoryId.size() -1 ? ",":"");				
		}
	}

	if (Validator.isNotNull(listPortionId) && listPortionId.size()>0){
		for (int i = 0; i < listPortionId.size();i ++){
			VcmsPARelation PA = (VcmsPARelation)listPortionId.get(i);		
			strPortionId += PA.getPortionId() + (i < listPortionId.size() -1 ? ",":"");				
		}
	}


	if (Validator.isNotNull(listTypeId) && listTypeId.size()>0){
		for (int i = 0; i < listTypeId.size();i ++){
			VcmsArticleType vArticleType = (VcmsArticleType)listTypeId.get(i);		
			strType += String.valueOf(vArticleType.getTypeId()) + (i < listTypeId.size() -1 ? ",":"");				
		}
	}

	String[] strPortion = ((article != null) ? StringUtil.split(strPortionId, StringPool.COMMA): null);
	String[] strCategory = ((article != null) ? StringUtil.split(strCatId, StringPool.COMMA): null);
	String[] strTypeId = ((article != null) ? StringUtil.split(strType, StringPool.COMMA): null);	
	
	// Initial date values
	Calendar currentDate = new GregorianCalendar();
	int curYear = currentDate.get(Calendar.YEAR);
	int curMonth = currentDate.get(Calendar.MONTH);
	int curDay = currentDate.get(Calendar.DATE);
	
	// Requested values
	
	int sedM = ParamUtil.get(request, "sedMonth", curMonth);
	int sedD = ParamUtil.get(request, "sedDay", curDay);
	int sedY = ParamUtil.get(request, "sedYear", curYear);
	Date toDate = new GregorianCalendar(sedY, sedM, sedD).getTime();
	
	// Publish Date of Article
	int publishedM = ParamUtil.get(request, "publishedMonth", curMonth);
	int publishedD = ParamUtil.get(request, "publishedDay", curDay);
	int publishedY = ParamUtil.get(request, "publishedYear", curYear);
	Date publishedDate = new GregorianCalendar(publishedY, publishedM, publishedD).getTime();
	
	// Effective Date of Article
	int effectiveM = ParamUtil.get(request, "effectiveMonth", curMonth);
	int effectiveD = ParamUtil.get(request, "effectiveDay", curDay);
	int effectiveY = ParamUtil.get(request, "effectiveYear", curYear);
	Date effectiveDate = new GregorianCalendar(effectiveY, effectiveM, effectiveD).getTime();
	
	// Expire Date of Article
	int expireM = ParamUtil.get(request, "expireMonth", curMonth);
	int expireD = ParamUtil.get(request, "expireDay", curDay);
	int expireY = ParamUtil.get(request, "expireYear", curYear);
	Date expireDate = new GregorianCalendar(expireY, expireM, expireD).getTime();
	
//	long companyId = PortalUtil.getCompanyId(request);
	String autoMessage = VCMSUtil.getPrefsPropsUtil(companyId, PropsUtilExt.VCMS_ARTICLE_AUTO_REQUEST_MESSAGE);
		
	List listType = new ArrayList();
	listType = VcmsTypeServiceUtil.getTypesByS_L(groupId, language);
%>

<c:if test="<%= article != null %>">

<script type="text/javascript">
	function <portlet:namespace />publishArticle() {
		var categories = '';
		var portions = '';
		var websites = '';
		var threads = '';
		var typeIds = '';
		
		var cObjects = document.getElementsByName("<portlet:namespace />category");
		var pObjects = document.getElementsByName("<portlet:namespace />portion");
		var tObjects = document.getElementsByName("<portlet:namespace />thread");	
		
		for (i = 0; (cObjects != null) && (i < cObjects.length); i ++) {
			if (cObjects[i].checked) {
				categories += cObjects[i].value + ',';
			}
		}
		
		for (i = 0; (pObjects != null) && (i < pObjects.length); i ++) {
			if (pObjects[i].checked) {
				portions += pObjects[i].value + ',';
			}
		}
		
		for (i = 0; (tObjects != null) && (i < tObjects.length); i ++) {
			if (tObjects[i].checked) {
				threads += tObjects[i].value + ',';
			}
		}
		
		
		// Validate..
		if ((categories == '') && (portions == '')) {
			alert('<%= LanguageUtil.get(pageContext, "portlet.vcms.article.publish.you-need-to-select-at-least-one-categories-and-or-portions") %>');
			return false;
		}
		
		
		document.<portlet:namespace />fm.<portlet:namespace />portions.value = portions;
		document.<portlet:namespace />fm.<portlet:namespace />categories.value = categories;
		document.<portlet:namespace />fm.<portlet:namespace />threads.value = threads;
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = 'publish';
		submitForm(document.<portlet:namespace />fm,'<portlet:actionURL name="publishArticle" windowState="<%= WindowState.MAXIMIZED.toString() %>"></portlet:actionURL>');
		
	}
</script>

<form action="<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>">
</portlet:actionURL>" method="post" name="<portlet:namespace />fm" 
onSubmit="<portlet:namespace />publishArticle(); return false;">
<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="">
<input name="<portlet:namespace />redirect" type="hidden" value="<%= redirect %>">
<input name="<portlet:namespace />portions" type="hidden" value="">
<input name="<portlet:namespace />categories" type="hidden" value="">
<input name="<portlet:namespace />websites" type="hidden" value="">
<input name="<portlet:namespace />threads" type="hidden" value="">	
<input name="<portlet:namespace />articleIds" type="hidden" value="<%= article.getArticleId() %>">
<input name="<portlet:namespace />groupId" type="hidden" value="<%= groupId %>">


<table width="100%" cellpadding="0" cellspacing="0">
<tr>
	<td width="15%"><b>
		<font style="font-size: 10pt; font-family: tahoma, arial" ><%= LanguageUtil.get(pageContext, "portlet.vcms.article.publish.title") %> :</font></b></td>
	<td>
		<font style="font-size: 13pt; font-family: tahoma, arial" color="red"><%= article.getTitle() %></font></td>
</tr>

<tr>
	<td align="center">
		<%if(article.getHasImage()){%>					
			<img width="80" height="60" style="float: left; padding-right: 5px;border-color:#999999"  src="<%= themeDisplay.getPathImage() + "/images?img_id=" + WebKeysExt.VCMS_ARTICLE_SMALL_IMAGE_KEY + article.getArticleId() %>" border="1" />
		<%}else {%>
			<img width="80" height="60" style="float: left; padding-right: 5px;border-color:#999999" src="/html/portlet/vcms/images.jpg" />
		<%}%>	
	</td>
	<td align="justify" valign="top">	
		<%=article.getLead()%>
	</td>	
</tr>
</table>		 

	
	<div class="beta-separator"></div><br>
	<table border="0" cellpadding="4" cellspacing="0" width="100%">
		<tr>
			<td align="left" width="100%" valign="top">
				<fieldset style="border:1px solid ">
					<legend><b><%= LanguageUtil.get(pageContext, "portlet.vcms.article.publish.panel1.label") %></b></legend>
					<table border="0" cellpadding="4" cellspacing="0" width="100%">
					<tr>
						<td align="left" width="50%" valign="top">
							<div class="portlet-section-alternate" style="padding: 4px">
								<table cellspacing="0" cellpadding="0" width="100%" border="0">
									<tr>
										<td width="1%" valign="middle"><img src="<%= themeDisplay.getPathThemeImage() %>/vcms/category.gif" valign="middle" /></td>
										<td width="99%" valign="middle" style="padding-left: 5px"><%= LanguageUtil.get(pageContext, "portlet.vcms.article.publish.panel1.category") %></td>
									</tr>
								</table>
							</div>
							<div style="overflow: auto; height: 200px; border:1px solid">
								<table cellspacing="3" cellpadding="0" width="100%" border="0">										
									<%= ActionUtil.getCategoryTree(groupId, language, renderResponse.getNamespace(),permissionChecker,strPortion, strCategory) %>
								</table>
							</div>
						</td>
				
						<td align="left" width="50%" valign="top">
							<div class="portlet-section-alternate" style="padding: 4px">
								<table cellspacing="0" cellpadding="0" width="100%" border="0">
									<tr>
										<td width="1%" valign="middle"><img src="<%= themeDisplay.getPathThemeImage() %>/vcms/website.gif" valign="middle" /></td>
										<td width="99%" valign="middle" style="padding-left: 5px"><%= LanguageUtil.get(pageContext, "portlet.vcms.article.publish.panel1.website") %></td>
									</tr>
								</table>
							</div>
						</td>
					</tr>
						<tr>
							<td align="left" width="100%" colspan="2" >
								<div class="portlet-section-alternate" style="padding: 4px">
								<b><%= LanguageUtil.get(pageContext, "portlet.vcms.article.publish.panel1.attached-message") %></b>
								</div>
								<div align="center" style="border:1px solid;">
									<div align="left" style="padding: 8px; font-size: x-small; border-bottom: 1px dotted">
										<b><u><%= LanguageUtil.get(pageContext, "portlet.vcms.article.publish.panel1.attached-message.note") %></u></b>:<%= LanguageUtil.get(pageContext, "portlet.vcms.article.publish.panel1.attached-message.note-content") %>
									</div>
									<textarea name="<portlet:namespace />attachedMessage" style="border: 1px dotted #666666; width: 98%; margin: 5px; padding: 5px" rows="3"><%= autoMessage %></textarea>
								</div>
							</td>
						</tr>
					</table>
				</fieldset>
			</td>
		</tr>
		<tr>
			<td align="left" width="100%" valign="top">
				<fieldset style="border:1px solid">
					<legend><b><%= LanguageUtil.get(pageContext, "portlet.vcms.article.publish.panel2.label") %></b></legend>
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
						<tr>
							<td align="left" width="49%" valign="top">
								<table border="0" cellpadding="0" cellspacing="0" width="100%">
								<tr>
									<td align="left" colspan="2" width="100%" valign="top">
										<div class="portlet-section-alternate" style="padding: 4px" style="background-color:#99CCCC">
										<%= LanguageUtil.get(pageContext, "portlet.vcms.article.publish.panel2.follow-the-following-threads") %>
										</div>
										<div style="overflow: auto; height: 150px; border:1px solid">
											<table cellspacing="3" cellpadding="0" border="0" width="100%">
											<%= ActionUtil.getThreads(groupId, language, renderResponse.getNamespace(),permissionChecker, threadId) %>
											</table>
										</div>
									</td>
								</tr>
							
								<tr>
									<td align="left" colspan="2" width="100%" valign="top">
										<div class="portlet-section-alternate" style="padding: 4px">
										<%= LanguageUtil.get(pageContext, "portlet.vcms.article.publish.panel2.follow-the-following-types") %>
										</div>
										<div style="overflow: auto; height: 120px; border:1px solid">
											<table cellspacing="3" cellpadding="0" border="0" width="100%">
											<%	if(Validator.isNotNull(listType) && listType.size()>0){
													for(int i=0;i<listType.size();i++){
														VcmsType vType = (VcmsType)listType.get(i);%>
											<tr>
												<td width="30">&nbsp;<input type="checkbox" name="<portlet:namespace/>typeIds" id="<portlet:namespace/>typeId_<%=vType.getTypeId()%>" 
																<% if(Validator.isNotNull(strType)){
																	for(int j=0;j<strTypeId.length;j++){%>	
																	<%= strTypeId[j].equals(vType.getTypeId())? "checked=\"checked\"" : "" %>
																<%}}%> value="<%=vType.getTypeId()%>"></td>
												<td><label for="<portlet:namespace/>typeId_<%=vType.getTypeId()%>"><%=vType.getName()%></label></td>			
											</tr>				
											<%}}%>
											</table>
										</div>
									</td>
								</tr>
								</table>
							</td>
							
							<td width="2%">&nbsp;</td>
							
							<td align="left" width="49%" valign="top">
								<table border="0" cellpadding="0" cellspacing="0" width="100%">			
								<tr>
									<td align="left" colspan="2" width="100%" valign="top">
										<div class="portlet-section-alternate" style="padding: 4px">
										<table cellspacing="0" cellpadding="0" border="0" width="100%">
											<tr>
												<td align="left" width="1%" valign="middle">
													<input type="checkbox" id="<portlet:namespace />sticky" name="<portlet:namespace />sticky" value="true" />
												</td>
												<td align="left" width="99%" valign="middle">
													<label for="<portlet:namespace />sticky">&nbsp;<strong><%= LanguageUtil.get(pageContext, "portlet.vcms.article.publish.panel2.sticky") %></strong></label>
												</td>
											</tr>
										</table>
										</div>
								
										<div style="padding: 4px; padding-top: 8px; padding-bottom: 8px; border:1px solid">
											<table cellspacing="0" cellpadding="3" width="100%" border="0">
												<tr>
													<td width="1%" align="right">
														<input type="checkbox" id="<portlet:namespace />stickyNeverExpired" name="<portlet:namespace />stickyNeverExpired" value="true" />
													</td>
													<td width="99%" align="left">
														<label for="<portlet:namespace />stickyNeverExpired">&nbsp;<%= LanguageUtil.get(pageContext, "portlet.vcms.article.publish.panel2.sticky-never-expired") %></label>
													</td>
												</tr>
												<tr>
													<td width="1%" align="right" style="border-top: 1px solid">&nbsp;</td>
														
													
													<td width="99%" align="left" style="border-top: 1px solid">
														<div style="margin: 0px; padding: 0px; margin-bottom: 3px"><%= LanguageUtil.get(pageContext, "portlet.vcms.article.publish.panel2.sticky-expire-date") %>:</div>
														<liferay-ui:input-date
															disableNamespace="<%= false %>"
															formName='<%= renderResponse.getNamespace() + "fm" %>'
															monthParam="sedMonth"
															monthValue="<%= sedM %>"
															dayParam="sedDay"
															dayValue="<%= sedD %>"
															yearParam="sedYear"
															yearValue="<%= sedY %>"
															yearRangeStart="2000"
															yearRangeEnd="<%= curYear %>"
															firstDayOfWeek="<%= currentDate.getFirstDayOfWeek() - 1 %>"
															disabled="<%= false %>"
														/>
													</td>
												</tr>
											</table>
										</div>
										</td>
									</tr>
		
									<tr>
										<td align="left" colspan="2" width="100%" valign="top">
											<div class="portlet-section-alternate" style="padding: 4px">
											<table cellspacing="0" cellpadding="0" border="0" width="100%">
												<tr>
													<td align="left" width="1%" valign="middle">
														<input type="checkbox" id="<portlet:namespace />selectPublishedDate" name="<portlet:namespace />selectPublishedDate" value="true" />
													</td>
													<td align="left" width="99%" valign="middle">
														<label for="<portlet:namespace />selectPublishedDate">&nbsp;<%= LanguageUtil.get(pageContext, "portlet.vcms.article.publish.panel2.select-published-date") %></label>
													</td>
												</tr>
											</table>
											</div>
											<div style="padding: 4px; padding-top: 8px; padding-bottom: 8px; border:1px solid">
												<table cellspacing="0" cellpadding="3" width="100%" border="0">
													<tr>
														<td width="1%" align="right">&nbsp;
															
														</td>
														<td width="99%" align="left">
															<div style="margin: 0px; padding: 0px; margin-bottom: 3px"></div>
															<liferay-ui:input-date
																disableNamespace="<%= false %>"
																formName='<%= renderResponse.getNamespace() + "fm" %>'
																monthParam="publishedMonth"
																monthValue="<%= publishedM %>"
																dayParam="publishedDay"
																dayValue="<%= publishedD %>"
																yearParam="publishedYear"
																yearValue="<%= publishedY %>"
																yearRangeStart="2000"
																yearRangeEnd="<%= curYear %>"
																firstDayOfWeek="<%= currentDate.getFirstDayOfWeek() - 1 %>"
																disabled="<%= false %>"
															/>
														</td>
													</tr>
												</table>
											</div>
										</td>
									</tr>
															
									<tr>
										<td align="left" colspan="2" width="100%" valign="top">
											<div class="portlet-section-alternate" style="padding: 4px">
											<table cellspacing="0" cellpadding="0" border="0" width="100%">
												<tr>
													<td align="left" width="1%" valign="middle">
														<input type="checkbox" id="<portlet:namespace />selectExpireDate" name="<portlet:namespace />selectExpireDate" value="true" />
													</td>
													<td align="left" width="99%" valign="middle">
														<label for="<portlet:namespace />selectExpireDate">&nbsp;<%= LanguageUtil.get(pageContext, "portlet.vcms.article.publish.panel2.select-expire-date") %></label>
													</td>
												</tr>
											</table>
											</div>
											<div style="padding: 4px; padding-top: 8px; padding-bottom: 8px; border:1px solid">
												<table cellspacing="0" cellpadding="3" width="100%" border="0">
													<tr>
														<td width="1%" align="right">&nbsp;
															
														</td>
														<td width="99%" align="left">
															<div style="margin: 0px; padding: 0px; margin-bottom: 3px"></div>
															<liferay-ui:input-date
																disableNamespace="<%= false %>"
																formName='<%= renderResponse.getNamespace() + "fm" %>'
																monthParam="expireMonth"
																monthValue="<%= expireM %>"
																dayParam="expireDay"
																dayValue="<%= expireD %>"
																yearParam="expireYear"
																yearValue="<%= expireY %>"
																yearRangeStart="2000"
																yearRangeEnd="<%= curYear %>"
																firstDayOfWeek="<%= currentDate.getFirstDayOfWeek() - 1 %>"
																disabled="<%= false %>"
															/>
														</td>
													</tr>
												</table>
											</div>
										</td>
									</tr>						
											
									<tr>
										<td align="left" colspan="2" width="100%" valign="top">
											<div class="portlet-section-alternate" style="padding: 4px">
											<table cellspacing="0" cellpadding="0" border="0" width="100%">
												<tr>
													<td align="left" width="1%" valign="middle">
														<input type="checkbox" id="<portlet:namespace />selectEffectiveDate" name="<portlet:namespace />selectEffectiveDate" value="true" />
													</td>
													<td align="left" width="99%" valign="middle">
														<label for="<portlet:namespace />selectEffectiveDate">&nbsp;<%= LanguageUtil.get(pageContext, "portlet.vcms.article.publish.panel2.select-effective-date") %></label>
													</td>
												</tr>
											</table>
											</div>
											<div style="padding: 4px; padding-top: 8px; padding-bottom: 8px; border:1px solid">
												<table cellspacing="0" cellpadding="3" width="100%" border="0">
													<tr>
														<td width="1%" align="right">&nbsp;
															
														</td>
														<td width="99%" align="left">
															<div style="margin: 0px; padding: 0px; margin-bottom: 3px"></div>
															<liferay-ui:input-date
																disableNamespace="<%= false %>"
																formName='<%= renderResponse.getNamespace() + "fm" %>'
																monthParam="effectiveMonth"
																monthValue="<%= effectiveM %>"
																dayParam="effectiveDay"
																dayValue="<%= effectiveD %>"
																yearParam="effectiveYear"
																yearValue="<%= effectiveY %>"
																yearRangeStart="2000"
																yearRangeEnd="<%= curYear %>"
																firstDayOfWeek="<%= currentDate.getFirstDayOfWeek() - 1 %>"
																disabled="<%= false %>"
															/>
														</td>
													</tr>
												</table>
											</div>
										</td>
									</tr>
											
									<tr>
										<td align="left" width="1%" valign="middle">
											<input type="checkbox" id="<portlet:namespace />discussible" name="<portlet:namespace />discussible" value="true" />
										</td>							
										<td align="left" width="99%" valign="middle">
											<label for="<portlet:namespace />discussible">&nbsp;<strong><%= LanguageUtil.get(pageContext, "portlet.vcms.article.publish.panel2.discussible") %></strong></label>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</fieldset>
			</td>
		</tr>
		
		<tr height="5"><td>&nbsp;</td></tr>
											
		<tr>
			<td align="center" width="100%" valign="top">
				
				<input class="portlet-form-button" type="submit" value='<%= LanguageUtil.get(pageContext, "portlet.vcms.button.publish") %>'>
				
				<input class="portlet-form-button" type="button" value='<%= LanguageUtil.get(pageContext, "portlet.vcms.button.return") %>' onClick="self.location = '<%= redirect %>';">
				
			</td>
		</tr>
	</table>
</form>
</c:if>

<c:if test="<%= article == null %>">
	Error: article not found!
</c:if>