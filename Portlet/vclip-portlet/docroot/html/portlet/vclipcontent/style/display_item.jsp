
<%@page import="javax.portlet.RenderRequest"%>
<%@page import="javax.portlet.PortletURL"%>
<%	
	Clip bean = (Clip) listItem.get(i);	
	PortletURL menuURL = renderResponse.createRenderURL();	
	menuURL.setParameter("groupId", String.valueOf(groupId));
	menuURL.setParameter("clipId",String.valueOf(bean.getId()));
	menuURL.setParameter(WebKeysVClip.CLIP_TYPE_ID,String.valueOf(bean.getClipTypeId()));
	if(i % 3 == 0) {		
		try{			
%>
		<ul class="wd-list-video">
		<li>
			<a href="<%=menuURL%>"> 
<%-- 			<img alt="" width="242" height="158" src="<%= themeDisplay.getPathImage() %>/image_gallery?img_id=<%= bean.getImage() %>">	 --%>
 			 	<img alt="" width="242" height="158" src="<%= themeDisplay.getPortalURL() +  
			themeDisplay.getPathContext() + "/documents/"  + themeDisplay.getScopeGroupId()%><%= bean.getImage() %>">		 
			</a>	
			<p class="wd-text-player">
				<a href="<%=menuURL%>"><%=bean.getTitle() %></a>	
			</p>					
		</li>
		<%	
			}catch(Exception ex){
				
			}
			}else if(i % 3 == 1) {
				try{
		%>
		<li class="wd-li-center">
			<a href="<%=menuURL%>"> 	
<%-- 				<img alt="" width="242" height="158" src="<%= themeDisplay.getPathImage() %>/image_gallery?img_id=<%= bean.getImage() %>">						 --%>
  			<img alt="" width="242" height="158" src= "<%= themeDisplay.getPortalURL() +  
			themeDisplay.getPathContext() + "/documents/"  + themeDisplay.getScopeGroupId()%><%= bean.getImage() %>">				
			</a>
			<p class="wd-text-player">
				<a href="<%=menuURL%>"><%=bean.getTitle() %></a>	
			</p>
		</li>
		<%	
				}catch(Exception ex){
					
				}		
			}else {
				try{
		%>
		<li>
			<a href="<%=menuURL%>"> 
 			<img alt="" width="242" height="158" src="<%= themeDisplay.getPortalURL() +  
 			themeDisplay.getPathContext() + "/documents/"  + themeDisplay.getScopeGroupId()%><%= bean.getImage() %>">
<%-- 			<img alt="" width="242" height="158" src="<%= themeDisplay.getPathImage() %>/image_gallery?img_id=<%= bean.getImage() %>">						  --%>
			</a>
			<p class="wd-text-player">
				<a href="<%=menuURL%>"><%=bean.getTitle() %></a>	
			</p>
		</li>
		</ul>
		<%
				}catch(Exception ex){
					
				}
				}
		}
		%>
 		</ul>