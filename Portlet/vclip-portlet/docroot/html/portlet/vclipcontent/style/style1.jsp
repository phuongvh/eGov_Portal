
<script type="text/javascript" src="/vclip-portlet/html/portlet/vclipcontent/swfobject.js">	
  </script>
<%	
	String clipTypeId = ParamUtil.getString(request, WebKeysVClip.CLIP_TYPE_ID);

	List clipTypeList = null;
	List clipList = null;
	
	clipTypeList = (List)request.getAttribute("clipTypeList");
	clipList = (List)request.getAttribute("clipList");
	Clip reqClip= (Clip)request.getAttribute(WebKeysVClip.CLIP);
	
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
						 

				                    	           
		<div class="wd-boxs">
			<h2 class="wd-tlh1-2"><%=clipType.getName()%></h2>
			<div class="wd-introduction">
				<div class="wd-border-title">
					<h3 class="wd-tlh3-5"><%=reqClip.getTitle() %></h3>
								<p class="wd-date wd-date-2"><%=LanguageUtil.get(pageContext,"com.vportal.portlet.vclip.date-create") %>: 
								<%=dateFormatDateTime.format((reqClip.getCreatedDate()))%></p>
				</div>
				<div class="wd-video">
					<div class="wd-object"  id="container">
						<script type="text/javascript">
				           	<%
			               		String clipURL = reqClip.getUrl();				                     	
				            %> 
				       	   function playswf(url, img)
				           {
				           		var s1 = new SWFObject("/vclip-portlet/html/portlet/vclipcontent/player.swf","jstest","100%","100%","3","0x000000");
				                s1.addParam("allowfullscreen","true");
				                s1.addParam("wmode","transparent");
				               	s1.addParam('allowscriptaccess','always');
				                s1.addVariable("image",img);
				                s1.addVariable("file",escape(url));
				                s1.write("container");
				            }
					        playswf('<%= themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"  + themeDisplay.getScopeGroupId()%><%= clipURL %>','<%= themeDisplay.getPathImage() %>/image_gallery?img_id=<%= reqClip.getImage() %>');                        		   
<%-- 					    playswf(' <%= themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"  + themeDisplay.getScopeGroupId() + StringPool.SLASH + item.getFolderId() + StringPool.SLASH + HttpUtil.encodeURL(HtmlUtil.unescape(item.getName())) %>');                        		    --%>
							
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
				</div>
			</div>
		</div>	
	
	<%
	}else{
	%>

	<%	
		int total = cList.size();	
		int per = Integer.parseInt(displayClipNumber);		
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
			<div class="wd-boxs">
				<h2 class="wd-tlh1-2"><%=clipTypeNew.getName()%></h2>			    											
															
		<%	
		}	
		else{	
		%>
			<div class="wd-boxs">
				<h2 class="wd-tlh1-2"><%= LanguageUtil.get(pageContext, "com.vportal.portlet.vclip.clip-list") %></h2>
			
		<%
		}
		%>				
			<div class="wd-introduction">
				<%	
				
				
					for (int i = 0; i < listItem.size(); i++) {							
				%>		
					<%@ include file="/html/portlet/vclipcontent/style/display_item.jsp" %>					
				<div class="wd-paging">
							<c:if test='<%= pages > 0 %>'>
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
								<p class="sum-page"><lable><%=LanguageUtil.get(pageContext,"com.vportal.portlet.vclip.clip-show") %> <%= listItem.size()%> clip</label></p>
							</c:if>

				</div>
			</div>	
		</div>



	<%	
		}
	%>

