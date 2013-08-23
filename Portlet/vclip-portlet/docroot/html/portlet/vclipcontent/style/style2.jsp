<%
	
	String newRootURL = themeDisplay.getPortalURL()+themeDisplay.getPathContext()+"/documents/" +themeDisplay.getScopeGroupId();
	String selectedType = ParamUtil.getString(request,"selectedType");
	boolean ajaxType = ParamUtil.getBoolean(request,"ajax_type", false);
	List clipTypeList = null;
	List clipList = null;
	
	if(!ajaxType) {
		clipTypeList = (List)request.getAttribute("clipTypeList");
	}
	clipList = (List)request.getAttribute("clipList");
	
	/*
	List clipListByType = (List)request.getAttribute("clipListByType");
	if(Validator.isNotNull(clipListByType))
	{
		clipList = null;
		clipList = clipListByType;
	}
	*/
	
	//Phan trang
	String sPageNum = ParamUtil.getString(request, "pagenum", "1");
	int numberPage = GetterUtil.getInteger(sPageNum, 1);
	int total = clipList.size();
	int per = GetterUtil.getInteger(displayClipNumber);
	int pages = (total % per == 0) ? total / per : total / per + 1;		
	int begin = per * (numberPage - 1);
	int end = (total>per * numberPage) ? per * numberPage : total;
	
	List listItem = clipList.subList(begin,end);
	PortletURL portletURL = renderResponse.createRenderURL();
// 	portletURL.setParameter("jspPage","/html/portlet/vclipcontent/view.jsp");
%>

<% if(!ajaxType) {  newRootURL = themeDisplay.getPortalURL()+themeDisplay.getPathContext()+"/documents/" +themeDisplay.getScopeGroupId(); %>
<script type="text/javascript" src="/vclip-portlet/html/portlet/vclipcontent/swfobject.js"></script>
<script type="text/javascript">

	function <portlet:namespace />playswf() {
          var s1 = new SWFObject("/vclip-portlet/html/portlet/vclipcontent/player.swf","jstest","320","260","3","0x000000");
          s1.addParam("allowfullscreen","true");
          s1.addParam("allowscriptaccess","always");
          s1.addParam("wmode","transparent");
          s1.addParam("flashvars","&autostart=true&repeat=none&playlist=none&fullscreen=true;");
          s1.write("<portlet:namespace />clipContent");
          
	} 
   
	function <portlet:namespace />getFileUrl(clipURL){
	
		player.sendEvent("LOAD",'<%=newRootURL.toString()%>'+clipURL);
	};
	
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
	};
	
	function stateListener(obj) { //get State
		currentState = obj.newstate;
		previousState = obj.oldstate;
	}
	
	function playerReady(obj){
		player = getPlayer('jstest');
		<% Clip clip = (Clip)listItem.get(0);
		//System.out.println(newRootURL.toString() + clip.getUrl());%>
		var objArray = new Array();		
		//loop url vao mang gom cac tp khac		
		objArray = {file:'<%= newRootURL+clip.getUrl()%>' , type:'video', title:'video 1', duration:0, start: 0,image:''};		
		player.sendEvent("LOAD",objArray);		

		addListeners();
	}
	
	function <portlet:namespace />changeClipType(selectedType){		
 			<portlet:renderURL windowState="<%= LiferayWindowState.EXCLUSIVE.toString()%>" var="clipTypeURL"> 
				<portlet:param name="jspPage" value="/html/portlet/vclipcontent/view.jsp" />
			</portlet:renderURL>
			check = false;
 			url = "<%= clipTypeURL%>"; 
			url = url + "&ajax_type=true&selectedType="+selectedType.value;			
			jQuery("#displayChange").load(url);				
	}
</script>

<div style="padding: 8px;">
   	<table width="100%">
   		<tr>
   			<td id="left_top_tab"></td>		    			
   			<td>
   				<div align="left" class="title1">VIDEO CLIP</div>
   			</td>
			<td id="right_top_tabs"></td>
   		</tr>
	</table>

	<div style="padding: 10px; background-color: #fff">
		<table width="100%">	

			<tr>
				<td valign="top" id="displayChange">
<% } %>
					<table width="100%">
						<tr>
							<td>&nbsp;</td>
							<td width="33%">&nbsp;</td>
							<td width="33%">&nbsp;</td>
						</tr>				
						<%					
							for(int i=0; i < listItem.size();i++)						
							{
								Clip clipObj = (Clip)listItem.get(i);
								if(i%3==0)
								{
									//System.out.println(newRootURL.toString() + clipObj.getUrl().toString());
							%>
												
								<td align="center" style="vertical-align: top;">
									<a style="cursor:pointer;" onclick="<portlet:namespace />getFileUrl('<%=clipObj.getUrl().toString() %>','<%=clipObj.getId() %>')">
										<%
											if(Validator.isNotNull(clipObj.getImage())){
										%>
											<img onclick="inceaseCounterview(<%=clipObj.getId()%>)" class="thumbnailborder" width="120" height="90" src="<%= themeDisplay.getPortalURL() %>/image/image_gallery?img_id=<%= (Long.valueOf(clipObj.getImage())+1) %>" />
										<%
											}else{
												
										%>
											<img onclick="inceaseCounterview(<%=clipObj.getId()%>)" class="thumbnailborder" width="120" height="90" src="/html/portlet/vcms/images.jpg" />
										<%																
											}
										%>
									</a><br>							
									<p class="text_none">
										<a style="cursor:pointer; text-decoration: none;" onclick="<portlet:namespace />getFileUrl('<%=clipObj.getUrl() %>','<%=clipObj.getId() %>');inceaseCounterview(<%=clipObj.getId()%>)"><%=clipObj.getTitle() %></a>
									</p>								
								</td>
							<%
								}else if(i%3==1){
							%>
								<td align="center" style="vertical-align: top;">
									<a style="cursor:pointer;" onclick="<portlet:namespace />getFileUrl('<%=clipObj.getUrl() %>','<%=clipObj.getId() %>')">
										<%
											if(Validator.isNotNull(clipObj.getImage())){
										%>
											<img onclick="inceaseCounterview(<%=clipObj.getId()%>)" class="thumbnailborder" width="120" height="90" src="<%= themeDisplay.getPortalURL() %>/image/image_gallery?img_id=<%= (Long.valueOf(clipObj.getImage())+1) %>" />
										<%
											}else{
												
										%>
											<img onclick="inceaseCounterview(<%=clipObj.getId()%>)" class="thumbnailborder" width="120" height="90" src="/html/portlet/vcms/images.jpg" />
										<%																
											}
										%>
									</a><br>							
									<p class="text_none" style="vertical-align: bottom;">
										<a style="cursor:pointer; text-decoration: none;" onclick="<portlet:namespace />getFileUrl('<%=clipObj.getUrl() %>','<%=clipObj.getId() %>');inceaseCounterview(<%=clipObj.getId()%>)"><%=clipObj.getTitle() %></a>
									</p>								
								</td>					
							<%
								}else{
							%>
								<td align="center" style="vertical-align: top;">
									<a style="cursor:pointer;" onclick="<portlet:namespace />getFileUrl('<%=clipObj.getUrl() %>','<%=clipObj.getId() %>')">
										<%
											if(Validator.isNotNull(clipObj.getImage())){
										%>
											<img onclick="inceaseCounterview(<%=clipObj.getId()%>)" class="thumbnailborder" width="120" height="90" src="<%= themeDisplay.getPortalURL() %>/image/image_gallery?img_id=<%= (Long.valueOf(clipObj.getImage())+1)%>" />
										<%
											}else{
												
										%>
											<img onclick="inceaseCounterview(<%=clipObj.getId()%>)" class="thumbnailborder" width="120" height="90" src="/html/portlet/vcms/images.jpg" />
										<%																
											}
										%>
									</a><br>							
									<p class="text_none">
										<a style="cursor:pointer; text-decoration: none;" onclick="<portlet:namespace />getFileUrl('<%=clipObj.getUrl() %>','<%=clipObj.getId() %>');inceaseCounterview(<%=clipObj.getId()%>)"><%=clipObj.getTitle() %></a>
									</p>								
								</td>
								
							<%
								}				
							}
							
						%>
						
							
					<c:if test='<%= pages > 1 %>'>			
					<tr>
						<td class="text_none" height="40" colspan="3">
						<p>
							<strong>&nbsp;&nbsp;&nbsp;Trang&nbsp;&nbsp;</strong>
							<% 	
								if(numberPage >1){
									int intPrev = numberPage-1;%>
									<span><a class="style1" href="#" onclick="self.location = '<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>"> 
										<portlet:param name="jspPage" value="/html/portlet/vclipcontent/view.jsp" />
										<portlet:param name="pagenum" value="<%= String.valueOf(intPrev) %>" />
										<%
											if(selectedType != null||!selectedType.equalsIgnoreCase("")){						
										%>
											<portlet:param name="selectedType" value="<%=String.valueOf(selectedType)%>"/>
										<%
											}	
										%>										
										</portlet:renderURL>';" >&lsaquo;&lsaquo; Tr&#432;&#7899;c</a></span>
				
							<%
								}
							%>				
							
							<% 
								for(int i = 1;i <= pages;i++){ 	
									if( i == numberPage ){%>
									<strong><a class="menu_left" href="#" onclick="self.location = '<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>"> 
										<portlet:param name="jspPage" value="/html/portlet/vclipcontent/view.jsp" />
										<portlet:param name="pagenum" value="<%= String.valueOf(i) %>" />
										<%
											if(selectedType != null||!selectedType.equalsIgnoreCase("")){						
										%>
											<portlet:param name="selectedType" value="<%=String.valueOf(selectedType)%>"/>
										<%
											}	
										%>									
										</portlet:renderURL>';" > <%=i%></a></strong>
							<%
								}else{
									
							%>	
									<strong><a class="text_download" href="#" onclick="self.location = '<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>"> 
										<portlet:param name="jspPage" value="/html/portlet/vclipcontent/view.jsp" />
										<portlet:param name="pagenum" value="<%= String.valueOf(i) %>" />
										<%
											if(selectedType != null||!selectedType.equalsIgnoreCase("")){						
										%>
											<portlet:param name="selectedType" value="<%=String.valueOf(selectedType)%>"/>
										<%
											}	
										%>	
										</portlet:renderURL>';" > <%=i%></a></strong>
							<%
									}
							 	} 
						 	%>
						 	
								
							<% 	
								if(numberPage < pages){
									int intNext = numberPage + 1;
							%>
									<a class="text_download" href="#" onclick="self.location = '<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>"> 
										<portlet:param name="jspPage" value="/html/portlet/vclipcontent/view.jsp" />
										<portlet:param name="pagenum" value="<%= String.valueOf(intNext) %>" />
										<%
											if(selectedType != null||!selectedType.equalsIgnoreCase("")){						
										%>
											<portlet:param name="selectedType" value="<%=String.valueOf(selectedType)%>"/>
										<%
											}	
										%>	
										</portlet:renderURL>';" >Ti&#7871;p &rsaquo;&rsaquo;</a>
							<%
								}
							%>		
						</td>
					</tr>
					</c:if>	
					</table>	
<% if(!ajaxType) { %>
				</td>
				<td width="10"> &nbsp; </td>
				<td width="33%" style="vertical-align:top;">
					<div id="<portlet:namespace />clipContent">
		
						<script type="text/javascript">	
							<portlet:namespace />playswf();
		                </script>
					</div>
				</td>											
			</tr>
		</table>
   </div>

	<table width="100%">
		<tr>
			<td width="4"><img src="/vclip-portlet/html/portlet/vclipcontent/images/i_34.gif" width="4" height="4"/></td>
			<td id="center_bottom_background"></td>
			<td width="4"><img src="/vclip-portlet/html/portlet/vclipcontent/images/i_35.gif" width="4" height="4"/></td>
		</tr>
	</table>
</div>
<% } %>