<%--/**
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
 */ --%>

<portlet:actionURL windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>" var="deleteURL">
	<portlet:param name="struts_action" value="/vclipcontent/view" />
	<portlet:param name="<%= Constants.CMD %>" value="<%= WebKeysVClip.HITCOUNT %>" />
</portlet:actionURL>

<portlet:actionURL windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>" var="increaseviewURL">
	<portlet:param name="struts_action" value="/vclipcontent/view" />
	<portlet:param name="<%= Constants.CMD %>" value="<%= WebKeysVClip.HITCOUNTVIEW %>" />
</portlet:actionURL>


<script type="text/javascript">
	function inceaseCounter(clipId) {
		url = "<%= deleteURL %>";
		url = url + "&clipId=" + clipId;
		AjaxUtil.update(url, "");
	}
	function inceaseCounterview(clipId) {
		url = "<%= increaseviewURL %>";
		url = url + "&clipId=" + clipId;
		AjaxUtil.update(url, "");
	}	
   function playswf(url, img)
   {
          var s1 = new SWFObject("/vclip-portlet/html/portlet/vclipcontent/player.swf","jstest","320","260","3","0x000000");
          s1.addParam("allowfullscreen","true");
          s1.addParam('allowscriptaccess','always');
          s1.addVariable("image",img);
          s1.addVariable("file",escape(url));                    
          s1.write("container");
   }
  </script>
<%	
	String clipTypeId = ParamUtil.getString(request, WebKeysVClip.CLIP_TYPE_ID);	
	List clipList = new ArrayList();
	if (clipTypeId == null||clipTypeId.equals("")) {
		clipList = ClipServiceUtil.getAll();
	} else {
		clipList = ClipServiceUtil.findByClipTypeId(clipTypeId);
	}
	
	Clip reqClip=(Clip)request.getAttribute(WebKeysVClip.CLIP);
	List cList=clipList;
	if(reqClip==null){
		reqClip= new ClipImpl();
	}
	if(cList==null){
		cList= new ArrayList();
	}
	if(Validator.isNotNull(reqClip.getId())){
		//lay title clipType khi khong chon tu category
		Clip clipObject = ClipServiceUtil.findById(reqClip.getId());
		clipTypeId = clipObject.getClipTypeId();
		ClipType clipType = new ClipTypeImpl();		
		if(Validator.isNotNull(clipType))			
		{		
			try{
				 clipType = ClipTypeServiceUtil.findById(clipTypeId);
				 	
			   }
			catch(Exception ex)
			{}
		}
		%>
<div class="content_border">		
	<table width="100%">
		<tr><th colspan="3"><div class="title_center"><%=clipType.getTitle().toUpperCase() %></div></th></tr>
		<tr><td colspan="3">&nbsp;</td></tr>			
		<tr valign="top">
			<td>
				<div id="container">					 
					<script type="text/javascript">
	                      	<%
	                      		String clipURL = reqClip.getUrl();
	                      	
	                      	%>                        
	                     	playswf('<%= themeDisplay.getPathMain() %>/document_library/get_file?p_l_id=<%= themeDisplay.getPlid() %><%= clipURL %>','<%= themeDisplay.getPathImage() %>/image_gallery?img_id=<%= reqClip.getImage() %>');                        		   
	                  	</script>
	                  	<script type="text/javascript">						
					
						function getPlayer(gid) {
							if(navigator.appName.indexOf("Microsoft") != -1) {
								return window[gid];
							} else {
								return document[gid];
							}
						};
						
						function addListeners() {
							if (player) { 
								player.addModelListener("STATE", "stateListener");
							} else {
								setTimeout("addListeners()",100);
							}
						}
	
						function stateListener(obj) { //get State
							currentState = obj.newstate; 
							previousState = obj.oldstate; 
							if(currentState=="PLAYING"){
								//increase view number
								inceaseCounterview(<%=reqClip.getId()%>);
							}		
						}
						function playerReady(obj){		
							player = getPlayer('jstest');
							addListeners();
						};
						
					</script>
	                  	           
	              	</div>
         			<br>
         			<div style="width: 30%; float: left"><a style="text-decoration: underline" href="<%= themeDisplay.getPathMain()%>/document_library/get_file?p_l_id=<%= themeDisplay.getPlid() %><%= clipURL %>" onclick= "inceaseCounter(<%=reqClip.getId()%>)"><%= LanguageUtil.get(pageContext, "com.vportal.portlet.vclip.download_title") %></a></div>
          			<div style="float: right;"><%=LanguageUtil.get(pageContext,"com.vportal.portlet.vclip.clip-viewcounter") %>: <b><%=reqClip.getHitcountview() %></b>&nbsp&nbsp <%=LanguageUtil.get(pageContext,"com.vportal.portlet.vclip.download_counter") %> : <b> <%=reqClip.getHitcount() %></b></div>                	
              </td>
              <td width="12"></td>                
		<td width="42%" valign="top">
			<span class="public_title"><%=reqClip.getTitle() %></span>
			<span><p align = "left" id = "dong2"><%=reqClip.getDescription() %></p></span>
			<span><b><%=LanguageUtil.get(pageContext,"com.vportal.portlet.vclip.date-create") %>: </b><%=dateFormatDateTime.format((reqClip.getCreatedDate()))%><br></span>
			<span><b><%=LanguageUtil.get(pageContext,"com.vportal.portlet.vclip.clip-type") %>: </b><%=clipType.getTitle() %></span>					
			</td>
		</tr>
	</table>
</div>
	
	<%
	}else{
	%>
<div class="ctn-center clearfix">
	<div class="line-top">
	   	<div class="line-bottom">
	       	<div class="line-left">
	           	<div class="line-right">
	               	<div class="goc-left-top">
	                   	<div class="goc-right-top">
	                       	<div class="goc-left-bottom">
	                           	<div class="goc-right-bottom">
								<div class="ct" width="100%">															
												
	<%	
		int total = cList.size();	
		int per = 9;		
		String sPageNum = ParamUtil.getString(request, "pagenum", "1");		
		int numberPage = 1;
		if(Validator.isNotNull(sPageNum)){
			numberPage = Integer.parseInt(sPageNum);
		}
		
		int pages = (total % per == 0) ? total / per : total / per + 1;
		
		int begin = per * (numberPage - 1);
		int end = (total>per * numberPage) ? per * numberPage : total;
		List listItem = cList.subList(begin,end);
		
		PortletURL portletURL = renderResponse.createRenderURL();
		portletURL.setParameter("jspPage", "/html/portlet/vclipcontent/view.jsp");
		portletURL.setParameter(WebKeysVClip.CLIP_TYPE_ID,String.valueOf(clipTypeId));	
		
		//lay title cliptype khi chon tu category
		ClipType clipTypeNew = new ClipTypeImpl();
	
		if(Validator.isNotNull(clipTypeId))
		{
			clipTypeNew = ClipTypeServiceUtil.findById(clipTypeId);
		%>			
			<table width="100%" height="28">
				<tr>
					<td class="left_top_title_cms"></td>
					<td class="icon_top_title_cms"></td>
					<td class="title"><b><%=clipTypeNew.getTitle()%></b></td>
					<td class="right_top_title_cms"></td>
				</tr>
			</table>  	
		<%	
		}	
		else{	
		%>		
			<table width="100%" height="28">
				<tr>
					<td class="left_top_title_cms"></td>
					<td class="icon_top_title_cms"></td>
					<td class="title"><b><%= LanguageUtil.get(pageContext, "com.vportal.portlet.vclip.clip-list") %></b></td>
					<td class="right_top_title_cms"></td>
				</tr>
			</table>
		<%
		}
		%>				
			
	
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>&nbsp;</td>
				<td width="33%"></td>
				<td width="33%"></td>
			</tr>
			<%
				int i;
				long groupId = PortalUtilExt.getPortletGroupId(request);
				long currentPlid = PortalUtilExt.getPlid(request);
				long plId = 0;
				try{
					plId = PortalUtilExt.getPlid(groupId,currentPlid,"vclipcontent");
				}
				catch(Exception ex)
				{}	
						
				for (i = 0; i < listItem.size(); i++) {	
					
			%>		
				<%@ include file="/html/portlet/vclipcontent/style/display_item.jsp"%>	
			<%	
				}
			%>			
		</table>
	
		<div id="clip_fhead">
					<span > 
						<c:if test='<%= pages > 1 %>'>
							<script>
								function goPage(){
									document.<portlet:namespace/>fm.pagenum.value = document.<portlet:namespace/>fm.selectPage.value;
									document.<portlet:namespace/>fm.submit();
								}
							</script> 
							<form action="<%= portletURL.toString() %>" method="post" name="<portlet:namespace />fm" onSubmit="submitForm(this); return false;">
							<input type="hidden" name="pagenum" value="<%= sPageNum %>" />
								<label><%=LanguageUtil.get(pageContext,"com.vportal.portlet.vclip.clip-page") %> <label>
									<select name="selectPage" style="width:35px; " onchange="goPage();">
										<%
											for(int k = 1;k <= pages;k++){ 
										%>
											<option value="<%= k %>" <%= k == numberPage ? "selected" : "" %> ><%= k %></option>
										<% 
											} 
										%>
									</select>
								<label><%=LanguageUtil.get(pageContext,"com.vportal.portlet.vclip.clip-total") %> <%= pages %> </label>
							</form>
						</c:if>
						<c:if test='<%= (pages == 1) || (listItem.size() == 0) %>'>
							<lable><%=LanguageUtil.get(pageContext,"com.vportal.portlet.vclip.clip-show") %> <%= listItem.size()%> clip</label>
						</c:if>
					</span>
			  </div>
			 </div>
		   </div>
		  </div>
		 </div>
		</div>
	   </div>
	 </div>
   </div>
 </div>
</div>
<%
	}
%>

