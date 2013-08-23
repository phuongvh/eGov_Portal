<%@page import="com.vportal.portal.util.PortalUtilExt"%>
<%@page import="com.liferay.portal.model.Layout"%>
<script type="text/javascript" src="/vclip-portlet/html/portlet/view_vclip/swfobject.js"></script>
<%
String clipURL[]= new String[5];
String imageURL[]= new String[5];
%>

<%	
	long groupId = PortalUtilExt.getPortletGroupId(request);
	long currentPlid = PortalUtilExt.getPlid(request);
	long plId = 0;
	try{
		if(Validator.isNotNull(selectPortletLayout) && selectPortletLayout.equals("1")){
		
		Layout firstLayout = (Layout)selectLayouts.get(0);
		long firstLayoutId = firstLayout.getPlid();			
		String firstPortletId = LayoutPortletUtil.getPortletIdsByLayout(firstLayoutId).get(0).toString();			
			plId = PortalUtilExt.getPlid(groupId, currentPlid, firstPortletId);			
			portletSelectId = firstPortletId;			
		}else{
			plId = PortalUtilExt.getPlid(groupId, currentPlid, portletSelectId);
		}
	}catch(Exception ex){
		System.out.println(ex.toString());
	}	
	PortletURL categoryURL = PortletURLFactoryUtil.create(request,portletSelectId, plId, PortletRequest.RENDER_PHASE);
	categoryURL.setParameter("jspPage","/html/portlet/vclipcontent/view.jsp");
	categoryURL.setParameter("groupId", String.valueOf(groupId));
	List listTopClip = (List)request.getAttribute(WebKeysVClip.LIST_TOP_CLIP);
%>

					<div class="wd-boxs">
						<h2 class="wd-tlh1-2">Videos</h2>
						<div class="wd-introduction">		
							<div class="wd-video">
								<div class="wd-object"  id="vclipview-container">
							<script>
							function getPlayer(gid) {		
								if(navigator.appName.indexOf("Microsoft") != -1) {
									return window[gid];
								} else {
									return document[gid];
								}
								
							};
							
							var player;
							
							function playerStopC(){
								
								player.sendEvent("STOP");
							}
							function playerStartC(){
								player.sendEvent("PLAY");
							}
							function playerNextC(){
								player.sendEvent("NEXT");
							}
							function playerPrevC(){
								player.sendEvent("PREV");
							}
							
							function playerReady(obj){
								
								player = getPlayer('plyc');
								
								var objArray = new Array(<%=listTopClip.size()%>);		
 								var lst = new Array();	
								//loop url vao mang gom cac tp khac
								for(var j = 0; j < <%=listTopClip.size()%>; j++) 
								{
									
									objArray[j] = {file:itemArray[j], type: 'video', title:'video 1', duration:0, start: 0,image:itemImage[j]};			
 									if(itemArray[j] != "null")
									{
 										lst[j] = objArray[j];
 									}
										
 								}
								player.sendEvent("LOAD",lst);		
						
							};	 	
						</script>
						</div>
						<ul class="wd-playerlist">
						<%
	                    	int indexList = listTopClip.size()<=3?listTopClip.size():3;	
							//PortletURL menuURL = PortletURLFactoryUtil.create(request,portletResource,plId1, PortletRequest.RENDER_PHASE);
							//menuURL.setParameter("jspPage","/html/portlet/view_vclip/view.jsp");			
							for(int i=0;i < indexList;i++){
								Clip clipBean = (Clip)listTopClip.get(i);		
								categoryURL.setParameter("clipId",String.valueOf(clipBean.getId()));													
								categoryURL.setParameter(WebKeysVClip.CLIP_TYPE_ID,String.valueOf(clipBean.getClipTypeId()));
								if(i==0){
									
								
						%>		
								<li> 
									 <p><a href="<%=categoryURL.toString()%>"><%=StringUtil.shorten(clipBean.getName(),40) %></a></p>
								</li>													
						<%
								}else{
									try{
						%>	
								<li> <a class="wd-img-news" href="<%=categoryURL.toString()%>"> 
									<img alt="" width=78 height="55" src="<%= themeDisplay.getPathImage() %>/image_gallery?img_id=<%= clipBean.getImage() %>"></a>
									 <p><a href="<%=categoryURL.toString()%>"><%=StringUtil.shorten(clipBean.getName(),40) %></a></p>
								</li>	
						<%
									}catch(Exception ex){
										
										
									}
								}
							}
						%>	
						</ul>
							</div>
						</div>
					</div>



<script type="text/javascript">           
		var s1 = new SWFObject("/vclip-portlet/html/portlet/view_vclip/player.swf","plyc","100%","100%","9","#FFFFFF");		      		      
		s1.addParam("allowfullscreen","true");
		s1.addParam("allowscriptaccess","always");
		s1.addParam("wmode","transparent");			  
		s1.addParam("flashvars",'&displayclick=play&autostart=false&playlist=none&fullscreen=true');
		s1.write("vclipview-container");	    
</script>
<script>
	var itemArray = new Array(<%=listTopClip.size()%>);
	var itemImage = new Array(<%=listTopClip.size()%>);		
</script>
<%
	for(int i=0;i< listTopClip.size();i++)
	{	
		Clip clipBean = (Clip)listTopClip.get(i);		
		clipURL[i] = themeDisplay.getPortalURL()+themeDisplay.getPathContext()+"/documents/" + themeDisplay.getScopeGroupId() +clipBean.getUrl();			
		imageURL[i] =  //themeDisplay.getPathImage()+"/image_gallery?img_id="+ clipBean.getImage();	
				themeDisplay.getPortalURL()+themeDisplay.getPathContext() + "/documents/"  + themeDisplay.getScopeGroupId() + clipBean.getImage();
		%>
			<script>		
				//dua url vao mang String				
				itemArray[<%=i%>] = "<%=clipURL[i]%>";
				itemImage[<%=i%>] = "<%=imageURL[i]%>";
			</script>		
		<%	
	}
%>