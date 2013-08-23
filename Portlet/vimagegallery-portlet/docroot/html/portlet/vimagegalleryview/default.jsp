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

<%@include file="/html/portlet/vimagegalleryview/init.jsp"%>

<link href="/html/portlet/vimagegalleryview/lh.css" rel="stylesheet" type="text/css" />
<script src="/html/portlet/vcontactview/lh_view.js" type="text/javascript"></script>
<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("jspPage", "/html/portlet/vimagegalleryview/view.jsp");
	
	/* String categoryId = (String)request.getAttribute("categoryId");	 */		
			
	String categoryId = ParamUtil.getString(request, "categoryId");
	//Phan trang
	int numberPage = ParamUtil.getInteger(request, "pagenum", 1);
	int total = 0;
	String title="";
	
	if(Validator.isNotNull(categoryId)){						
	    total = TFImageServiceUtil.countByG_C_I(groupId,Long.parseLong(categoryId), true);	
	    TFCategory category = TFCategoryServiceUtil.findCategory(Long.valueOf(categoryId));
	    title = category.getName();
	}else{		
		total = TFImageServiceUtil.countByG_I(groupId, true);
		title = "Th&#432; vi&#7879;n &#7843;nh";
	}
	
	int per = Integer.parseInt(numOfImagePerPage);
	int pages = (total % per == 0) ? total / per : total / per + 1;
	
	int begin = per * (numberPage - 1);
	int end = (total>per * numberPage) ? per * numberPage : total;	

	String temp1 = "box_left_portlet " + styleBullet + " " +styleTitle;
	String temp2 = styleBorder;	

%>
<script type="text/javascript">
	var <portlet:namespace />imgArray1 = new Array();
	var <portlet:namespace />descArray = new Array();

	<%			
		List categorys = new ArrayList();
		List images = new ArrayList();
		
		categorys = TFCategoryServiceUtil.getByGroupId(groupId);
		
		if(Validator.isNotNull(categoryId)){						
			images = TFImageServiceUtil.getByG_C_I(groupId,Long.parseLong(categoryId),true,begin,end);
		}else{		
			images = TFImageServiceUtil.getByG_I(groupId,true,begin,end);
		}
		
		for	(int i = 0; i < images.size(); i++) {			
			TFImage image = (TFImage)images.get(i);
	%>

		<portlet:namespace />imgArray1[<%= i %>] = "<%= themeDisplay.getPathImage() %>/vimagegallery?img_id=<%= image.getImage() %>&large=1" ;		
		<portlet:namespace />descArray[<%= i %>] = "<%= image.getName()%>";
	<%
	}

		int defaultSpeed = Integer.parseInt(speed)*1000;
	%>

	var <portlet:namespace />imgArrayPos = 0		
	var <portlet:namespace />speed = <%= defaultSpeed %>;
	var <portlet:namespace />timeout = 0;

	function <portlet:namespace />pause() {
		clearInterval(<portlet:namespace />timeout);
		<portlet:namespace />timeout = 0;
	}

	function <portlet:namespace />play() {
		if (<portlet:namespace />timeout == 0) {
			<portlet:namespace />timeout = setInterval("<portlet:namespace />showNext()", <portlet:namespace />speed);
		}
	}

	function <portlet:namespace />showNext() {
		<portlet:namespace />imgArrayPos++;

		if (<portlet:namespace />imgArrayPos == <portlet:namespace />imgArray1.length){
			<portlet:namespace />imgArrayPos = 0;
		}			
		document.images.<portlet:namespace />slideShow1.src = <portlet:namespace />imgArray1[<portlet:namespace />imgArrayPos];	
		
	}

	function <portlet:namespace />showPrevious() {
		<portlet:namespace />imgArrayPos--;

		if (<portlet:namespace />imgArrayPos < 0) {
			<portlet:namespace />imgArrayPos = <portlet:namespace />imgArray1.length - 1;
		}		
		document.images.<portlet:namespace />slideShow1.src = <portlet:namespace />imgArray1[<portlet:namespace />imgArrayPos];		
	}
	<portlet:namespace />play();
</script>	


<form name="<portlet:namespace />fm" method="POST">	
<input name="<portlet:namespace />imageId" type="hidden" value="">

<% if(themeType.equals("1")){%> <!-- THEMES DIEN BIEN -->
<div class="<%=temp1%>">
	<div class="title">
		<div class="title_wrap">
			<div><%=titlePortlet%></div>
		</div> 
	</div>		
	
	<div align="center" class="<%=temp2%>">
		<br/><br/>
		
			<%if (Validator.isNotNull(title)){%>
				<div><%=title%></div><br/>
			<%}%>	
			
			<div style="border: 1px solid rgb(204, 204, 204); padding: 15px; width: 500px;">		
				<%	 if (images.size() > 0) {
				TFImage image = (TFImage)images.get(0);%>				
					<img border="0" name="<portlet:namespace />slideShow1" width="500"
						src="<%= themeDisplay.getPathImage() %>/vimagegallery?img_id=<%= image.getImage() %>&large=1">
				<%}%>
			</div>			
				
			<br/><br/>
				
			<table border="0" cellpadding="4" cellspacing="0" align="center">
			<tr>
				<td align="center">
					
					<div class="portlet-font" style="font-weight: bold; float: left; margin-right: 10px">			    	
						<input type="button" value="<liferay-ui:message key="play" />" onClick="<portlet:namespace />play();" /></div>					
						
					<div class="portlet-font" style="font-weight: bold; float: left; margin-right: 10px">		
						<input type="button" value="<liferay-ui:message key="pause" />" onClick="<portlet:namespace />pause();" /></div>					
						
					<div class="portlet-font" style="font-weight: bold; float: left; margin-right: 10px">				
						<input type="button" value="<liferay-ui:message key="slideshow" />" onClick="var slideShowWindow = window.open('<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>">
							<portlet:param name="jspPage" value="/html/portlet/vimagegalleryview/popup.jsp" />						
							</portlet:renderURL>', 'slideShow', 'directories=no,width=600,height=600,location=no,menubar=no,resizable=yes,left='.concat((screen.width - 400)/2).concat(',top=').concat((screen.height - 300)/2)); void(''); slideShowWindow.focus();" /></div>						
				</td>
			</tr>
			</table>
				
			<br/>
					
		    <table cellspacing="0" cellpadding="0" border="0" width="100%">
		    <tr><td height="10">&nbsp;</td></tr> 
		    <tr><td colspan="6">&nbsp;</td></tr>
	        <tr>
			   <td width="5"></td>
			   <td>
			     <c:if test='<%= pages > 1 %>'>	
			       <table width="100%" cellpadding="0" cellspacing="0" border="0">
			         <tr>
						<td height="40" align="right" nowrap="nowrap" style="font-size: 14px;font-weight: bold;" valign="middle"> 
						<%	if(numberPage >1){
								int intPrev = numberPage-1;%>
								<span><a class="style1" href="#" onclick="self.location = '<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>"> 
									<portlet:param name="jspPage" value="/html/portlet/vimagegalleryview/view.jsp" />
									<portlet:param name="pagenum" value="<%= String.valueOf(intPrev) %>" />				
									<%if(Validator.isNotNull(categoryId)){%>
										<portlet:param name="categoryId" value="<%=categoryId%>"/>
									<%}%>
									</portlet:renderURL>';" >
									<img src="/html/portlet/vimagegalleryview/images/aback.jpg" title="Quay l&#7841;i"></a></span>
						<%} else {%>	
								<span><img src="/html/portlet/vimagegalleryview/images/anoback.jpg" title="Không có quay l&#7841;i"></span>
						<% }%>				
						</td></tr>	
				       </table>	
				       </c:if>	
				   </td>
				    <td width="5"></td>	
				    					   
				    <td align="center">
				    <!--<div style="border: 1px solid rgb(204, 204, 204); padding: 5px; ">	-->
			          <table cellspacing="0" cellpadding="0" border="0" width="100%">	
				        <%   for(int i = 0; i < images.size(); i++) {			
							TFImage image = (TFImage)images.get(i);
							if(i%per==0){ %>
				        <tr>
				        <%	} %>
				          <td align="center">
				            <table cellspacing="0" cellpadding="0" border="0" width="100%">
					        <tr>
					           <td align="center">
				                 <table cellspacing="0" cellpadding="0" border="0" width="100%">
								        <tr>
								         <td align="center">
								             <a href="#" onClick="var slideShowWindow = window.open('<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>">
												<portlet:param name="jspPage" value="/html/portlet/vimagegalleryview/popup.jsp" />
												<portlet:param name="imageId" value="<%=Long.toString(image.getId())%>" />
												</portlet:renderURL>', 'slideShow', 'directories=no,width=600,height=600,location=no,menubar=no,resizable=yes,left='.concat((screen.width - 400)/2).concat(',top=').concat((screen.height - 300)/2)); void(''); slideShowWindow.focus();">
												<img src="<%= themeDisplay.getPathImage() %>/vimagegallery?img_id=<%= image.getImage() %>&large=1" width="100" border="0">
												</a>									      
								        	 </td>
								         </tr>
							        </table> 
						            </td>
						         </tr>
						         <tr>
						         <td align="center" >
						            <a href="#" onClick="var slideShowWindow = window.open('<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>">
											<portlet:param name="jspPage" value="/html/portlet/vimagegalleryview/popup.jsp" />
											<portlet:param name="imageId" value="<%=Long.toString(image.getId())%>" />
											</portlet:renderURL>', 'slideShow', 'directories=no,width=600,height=600,location=no,menubar=no,resizable=yes,left='.concat((screen.width - 400)/2).concat(',top=').concat((screen.height - 300)/2)); void(''); slideShowWindow.focus();">
						          	 <%= image.getName()%>
						           </a>
						         </td>
						         </tr>
						         <tr>
						          <td height="5">
						          </td>
						        </tr> 
					        </table>
				          </td>
				          	  
				          <td width="5">
				          </td>
					        <%
					        if(i%per==per-1){
					        %>  
					        </tr>
					        <tr>
					          <td height="10">
					          </td>
					        </tr>
					        <% }} %>
				     </table> 
				     <!--</div>	   -->
			        </td>
			        	 
			         <td width="5">
			       </td>
			        <td >
				     <c:if test='<%= pages > 1 %>'>	
				       <table width="100%" cellpadding="0" cellspacing="0" border="0">
				         <tr>
							<td height="40" align="left" nowrap="nowrap" style="font-size: 14px;font-weight: bold;" valign="middle"> 
							<% 	if(numberPage < pages){
									int intNext = numberPage + 1;%>
									
									<span><a href="#" onclick="self.location = '<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>"> 
										<portlet:param name="jspPage" value="/html/portlet/vimagegalleryview/view.jsp" />
										<portlet:param name="pagenum" value="<%= String.valueOf(intNext) %>" />					
								    	<%if(Validator.isNotNull(categoryId)){%>
											<portlet:param name="categoryId" value="<%=categoryId%>"/>
										<%}	%>
									</portlet:renderURL>';" >
										<img src="/html/portlet/vimagegalleryview/images/anext.jpg" title="Ti&#7871;p theo">		
									</a></span></td>
							<%} else {%>	
									<span><img src="/html/portlet/vimagegalleryview/images/anonext.jpg" title="Không có ti&#7871;p theo"></span>
							<%}%>				
							</td>
							</tr>	
				       </table>	
				       </c:if>	
				   </td>
			       <td width="5">
			       </td>
		        </tr>
		        
		        <tr>
		         <td height="10">
		         </td>
		        </tr> 
		    </tbody>
		   </table>  
		</div>
	</div>
<% } else if(themeType.equals("2")){%>

<table cellspacing="0" cellpadding="0" border="0" width="98%" align="center">
<tr>	
	<td class="bg_title_news2">
	<table cellspacing="0" cellpadding="0" border="0" align="left" width="100%">
	<tr>
		<td width="40">&nbsp;</td>
		<td width="<%=titlePortlet.length() + 100%>" align="center" class="title_news"><%=titlePortlet%></td>
		<td>&nbsp;</td>
	</tr>
	</table>
	</td>
</tr>	
</table>					

	
<div align="center">

	<%if (Validator.isNotNull(title)){%>
		<div><%=title%></div><br/>
	<%}%>
			
	<br/>		
	<div style="border: 1px solid rgb(204, 204, 204); padding: 15px; width: 500px;">		
		<%	 if (images.size() > 0) {
		TFImage image = (TFImage)images.get(0);%>				
			<img border="0" name="<portlet:namespace />slideShow1" width="500"
				src="<%= themeDisplay.getPathImage() %>/vimagegallery?img_id=<%= image.getImage() %>&large=1">
		<%}%>
	</div>			
				
	<br/><br/>
		
	<table border="0" cellpadding="4" cellspacing="0" align="center">
	<tr>
		<td align="center">
			
			<div class="portlet-font" style="font-weight: bold; float: left; margin-right: 10px">			    	
				<input type="button" value="<liferay-ui:message key="play" />" onClick="<portlet:namespace />play();" /></div>					
				
			<div class="portlet-font" style="font-weight: bold; float: left; margin-right: 10px">		
				<input type="button" value="<liferay-ui:message key="pause" />" onClick="<portlet:namespace />pause();" /></div>					
				
			<div class="portlet-font" style="font-weight: bold; float: left; margin-right: 10px">				
				<input type="button" value="<liferay-ui:message key="slideshow" />" onClick="var slideShowWindow = window.open('<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>">
					<portlet:param name="jspPage" value="/html/portlet/vimagegalleryview/popup.jsp" />						
					</portlet:renderURL>', 'slideShow', 'directories=no,width=600,height=600,location=no,menubar=no,resizable=yes,left='.concat((screen.width - 400)/2).concat(',top=').concat((screen.height - 300)/2)); void(''); slideShowWindow.focus();" /></div>						
		</td>
	</tr>
	</table>
		
	<br/>
			
    <table cellspacing="0" cellpadding="0" border="0" width="100%">
    <tr><td height="10">&nbsp;</td></tr> 
    <tr><td colspan="6">&nbsp;</td></tr>
    <tr>
	   <td width="5"></td>
	   <td>
	     <c:if test='<%= pages > 1 %>'>	
	       <table width="100%" cellpadding="0" cellspacing="0" border="0">
	         <tr>
				<td height="40" align="right" nowrap="nowrap" style="font-size: 14px;font-weight: bold;" valign="middle"> 
				<%	if(numberPage >1){
						int intPrev = numberPage-1;%>
						<span><a class="style1" href="#" onclick="self.location = '<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>"> 
							<portlet:param name="jspPage" value="/html/portlet/vimagegalleryview/view.jsp" />
							<portlet:param name="pagenum" value="<%= String.valueOf(intPrev) %>" />				
							<%if(Validator.isNotNull(categoryId)){%>
								<portlet:param name="categoryId" value="<%=categoryId%>"/>
							<%}%>
							</portlet:renderURL>';" >
							<img src="/html/portlet/vimagegalleryview/images/aback.jpg" title="Quay l&#7841;i"></a></span>
				<%} else {%>	
						<span><img src="/html/portlet/vimagegalleryview/images/anoback.jpg" title="Không có quay l&#7841;i"></span>
				<% }%>				
				</td></tr>	
		       </table>	
		       </c:if>	
		   </td>
		    <td width="5"></td>	
		    					   
		    <td align="center">
		    <!--<div style="border: 1px solid rgb(204, 204, 204); padding: 5px; ">	-->
	          <table cellspacing="0" cellpadding="0" border="0" width="100%">	
		        <%   for(int i = 0; i < images.size(); i++) {			
					TFImage image = (TFImage)images.get(i);
					if(i%per==0){ %>
		        <tr>
		        <%	} %>
		          <td align="center">
		            <table cellspacing="0" cellpadding="0" border="0" width="100%">
			        <tr>
			           <td align="center">
		                 <table cellspacing="0" cellpadding="0" border="0" width="100%">
						        <tr>
						         <td align="center">
						             <a href="#" onClick="var slideShowWindow = window.open('<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>">
										<portlet:param name="jspPage" value="/html/portlet/vimagegalleryview/popup.jsp" />
										<portlet:param name="imageId" value="<%=Long.toString(image.getId())%>" />
										</portlet:renderURL>', 'slideShow', 'directories=no,width=600,height=600,location=no,menubar=no,resizable=yes,left='.concat((screen.width - 400)/2).concat(',top=').concat((screen.height - 300)/2)); void(''); slideShowWindow.focus();">
										<img src="<%= themeDisplay.getPathImage() %>/vimagegallery?img_id=<%= image.getImage() %>&large=1" width="100" border="0">
										</a>									      
						        	 </td>
						         </tr>
					        </table> 
				            </td>
				         </tr>
				         <tr>
				         <td align="center" >
				            <a href="#" onClick="var slideShowWindow = window.open('<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>">
									<portlet:param name="jspPage" value="/html/portlet/vimagegalleryview/popup.jsp" />
									<portlet:param name="imageId" value="<%=Long.toString(image.getId())%>" />
									</portlet:renderURL>', 'slideShow', 'directories=no,width=600,height=600,location=no,menubar=no,resizable=yes,left='.concat((screen.width - 400)/2).concat(',top=').concat((screen.height - 300)/2)); void(''); slideShowWindow.focus();">
				          	 <%= image.getName()%>
				           </a>
				         </td>
				         </tr>
				         <tr>
				          <td height="5">
				          </td>
				        </tr> 
			        </table>
		          </td>
		          	  
		          <td width="5">
		          </td>
			        <%
			        if(i%per==per-1){
			        %>  
			        </tr>
			        <tr>
			          <td height="10">
			          </td>
			        </tr>
			        <% }} %>
		     </table> 
		     <!--</div>	   -->
	        </td>
	        	 
	         <td width="5">
	       </td>
	        <td >
		     <c:if test='<%= pages > 1 %>'>	
		       <table width="100%" cellpadding="0" cellspacing="0" border="0">
		         <tr>
					<td height="40" align="left" nowrap="nowrap" style="font-size: 14px;font-weight: bold;" valign="middle"> 
					<% 	if(numberPage < pages){
							int intNext = numberPage + 1;%>
							
							<span><a href="#" onclick="self.location = '<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>"> 
								<portlet:param name="jspPage" value="/html/portlet/vimagegalleryview/view.jsp" />
								<portlet:param name="pagenum" value="<%= String.valueOf(intNext) %>" />					
						    	<%if(Validator.isNotNull(categoryId)){%>
									<portlet:param name="categoryId" value="<%=categoryId%>"/>
								<%}	%>
							</portlet:renderURL>';" >
								<img src="/html/portlet/vimagegalleryview/images/anext.jpg" title="Ti&#7871;p theo">		
							</a></span></td>
					<%} else {%>	
							<span><img src="/html/portlet/vimagegalleryview/images/anonext.jpg" title="Không có ti&#7871;p theo"></span>
					<%}%>				
					</td>
					</tr>	
		       </table>	
		       </c:if>	
		   </td>
	       <td width="5">
	       </td>
        </tr>
        
        <tr>
         <td height="10">
         </td>
        </tr> 
    </tbody>
   </table>  
</div>										
					
<% } else if(themeType.equals("3")){%>	<!-- THEMES TRANG Du khach- Doanh nghiep-->
					
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr>
	<td width="4" align="left" height="5">
		<img src="<%= themeDisplay.getPathThemeImage() %>/DB_image/1.gif" width="4" height="5"/></td>	
	<td height="3" background="<%= themeDisplay.getPathThemeImage() %>/DB_image/3.gif"></td>
	<td width="4" align="right">
		<img src="<%= themeDisplay.getPathThemeImage() %>/DB_image/2.gif" width="4" height="5" /></td>
</tr>
		
<tr>
   	<td width="4" align="left" background="<%= themeDisplay.getPathThemeImage() %>/DB_image/7.gif"></td>
	<td>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" >
		<tr><td height="3px"></td></tr>
	
		<tr><td width="3px"></td>
		    <td>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="17"><img src="<%= themeDisplay.getPathThemeImage() %>/DB_image/9.gif" width="17" height="30"/></td>
					<td width="100%" background="<%= themeDisplay.getPathThemeImage() %>/DB_image/10.gif" height="30" style="color:#FFFFFF;font-size:11px;font-weight:bold;text-transform:uppercase;" valign="middle">&nbsp;<%=titlePortlet%></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
									
					<%if (Validator.isNotNull(title)){%>
						<div><%=title%></div><br/>
					<%}%>	
					
					<div style="border: 1px solid rgb(204, 204, 204); padding: 15px; width: 500px;">		
						<%	 if (images.size() > 0) {
						TFImage image = (TFImage)images.get(0);%>				
							<img border="0" name="<portlet:namespace />slideShow1" width="500"
								src="<%= themeDisplay.getPathImage() %>/vimagegallery?img_id=<%= image.getImage() %>&large=1">
						<%}%>
					</div>			
						
					<br/><br/>
						
					<table border="0" cellpadding="4" cellspacing="0" align="center">
					<tr>
						<td align="center">
							
							<div class="portlet-font" style="font-weight: bold; float: left; margin-right: 10px">			    	
								<input type="button" value="<liferay-ui:message key="play" />" onClick="<portlet:namespace />play();" /></div>					
								
							<div class="portlet-font" style="font-weight: bold; float: left; margin-right: 10px">		
								<input type="button" value="<liferay-ui:message key="pause" />" onClick="<portlet:namespace />pause();" /></div>					
								
							<div class="portlet-font" style="font-weight: bold; float: left; margin-right: 10px">				
								<input type="button" value="<liferay-ui:message key="slideshow" />" onClick="var slideShowWindow = window.open('<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>">
									<portlet:param name="jsp" value="/html/portlet/vimagegalleryview/popup.jsp" />						
									</portlet:renderURL>', 'slideShow', 'directories=no,width=600,height=600,location=no,menubar=no,resizable=yes,left='.concat((screen.width - 400)/2).concat(',top=').concat((screen.height - 300)/2)); void(''); slideShowWindow.focus();" /></div>						
						</td>
					</tr>
					</table>
						
					<br/>
							
				    <table cellspacing="0" cellpadding="0" border="0" width="100%">
				    <tr><td height="10">&nbsp;</td></tr> 
				    <tr><td colspan="6">&nbsp;</td></tr>
			        <tr>
					   <td width="5"></td>
					   <td>
					     <c:if test='<%= pages > 1 %>'>	
					       <table width="100%" cellpadding="0" cellspacing="0" border="0">
					         <tr>
								<td height="40" align="right" nowrap="nowrap" style="font-size: 14px;font-weight: bold;" valign="middle"> 
								<%	if(numberPage >1){
										int intPrev = numberPage-1;%>
										<span><a class="style1" href="#" onclick="self.location = '<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>"> 
											<portlet:param name="jspPage" value="/html/portlet/vimagegalleryview/view.jsp" />
											<portlet:param name="pagenum" value="<%= String.valueOf(intPrev) %>" />				
											<%if(Validator.isNotNull(categoryId)){%>
												<portlet:param name="categoryId" value="<%=categoryId%>"/>
											<%}%>
											</portlet:renderURL>';" >
											<img src="/html/portlet/vimagegalleryview/images/aback.jpg" title="Quay l&#7841;i"></a></span>
								<%} else {%>	
										<span><img src="/html/portlet/vimagegalleryview/images/anoback.jpg" title="Không có quay l&#7841;i"></span>
								<% }%>				
								</td></tr>	
						       </table>	
						       </c:if>	
						   </td>
						    <td width="5"></td>	
						    					   
						    <td align="center">
						    <!--<div style="border: 1px solid rgb(204, 204, 204); padding: 5px; ">	-->
					          <table cellspacing="0" cellpadding="0" border="0" width="100%">	
						        <%   for(int i = 0; i < images.size(); i++) {			
									TFImage image = (TFImage)images.get(i);
									if(i%per==0){ %>
						        <tr>
						        <%	} %>
						          <td align="center">
						            <table cellspacing="0" cellpadding="0" border="0" width="100%">
							        <tr>
							          
							           <td align="center">
						                <table cellspacing="0" cellpadding="0" border="0" width="100%">
									    <tr>
									     <td align="center">
									         <a href="#" onClick="var slideShowWindow = window.open('<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>">
												<portlet:param name="jspPage" value="/html/portlet/vimagegalleryview/popup.jsp" />
												<portlet:param name="imageId" value="<%=Long.toString(image.getId())%>" />
												</portlet:renderURL>', 'slideShow', 'directories=no,width=600,height=600,location=no,menubar=no,resizable=yes,left='.concat((screen.width - 400)/2).concat(',top=').concat((screen.height - 300)/2)); void(''); slideShowWindow.focus();">
												<img src="<%= themeDisplay.getPathImage() %>/vimagegallery?img_id=<%= image.getImage() %>&large=1" width="100" border="0">
												</a>									      
									    	 </td>
									     </tr>
									     </table> 
										</td>
								         </tr>
								         <tr>
								         <td align="center" >
								            <a href="#" onClick="var slideShowWindow = window.open('<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>">
													<portlet:param name="jspPage" value="/html/portlet/vimagegalleryview/popup.jsp" />
													<portlet:param name="imageId" value="<%=Long.toString(image.getId())%>" />
													</portlet:renderURL>', 'slideShow', 'directories=no,width=600,height=600,location=no,menubar=no,resizable=yes,left='.concat((screen.width - 400)/2).concat(',top=').concat((screen.height - 300)/2)); void(''); slideShowWindow.focus();">
								          	 <%= image.getName()%>
								           </a>
								         </td>
								         </tr>
								         <tr>
								          <td height="5">
								          </td>
								        </tr> 
							        </table>
						          </td>
						          	  
						          <td width="5">
						          </td>
							        <%
							        if(i%per==per-1){
							        %>  
							        </tr>
							        <tr>
							          <td height="10">
							          </td>
							        </tr>
							        <% }} %>
						     </table> 
						     <!--</div>	   -->
					        </td>
					        	 
					         <td width="5">
					       </td>
					        <td >
						     <c:if test='<%= pages > 1 %>'>	
						       <table width="100%" cellpadding="0" cellspacing="0" border="0">
						         <tr>
									<td height="40" align="left" nowrap="nowrap" style="font-size: 14px;font-weight: bold;" valign="middle"> 
									<% 	if(numberPage < pages){
											int intNext = numberPage + 1;%>
											
											<span><a href="#" onclick="self.location = '<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>"> 
												<portlet:param name="jspPage" value="/html/portlet/vimagegalleryview/view.jsp" />
												<portlet:param name="pagenum" value="<%= String.valueOf(intNext) %>" />					
										    	<%if(Validator.isNotNull(categoryId)){%>
													<portlet:param name="categoryId" value="<%=categoryId%>"/>
												<%}	%>
											</portlet:renderURL>';" >
												<img src="/html/portlet/vimagegalleryview/images/anext.jpg" title="Ti&#7871;p theo">		
											</a></span></td>
									<%} else {%>	
											<span><img src="/html/portlet/vimagegalleryview/images/anonext.jpg" title="Không có ti&#7871;p theo"></span>
									<%}%>				
									</td>
									</tr>	
						       </table>	
						       </c:if>	
						   </td>
					       <td width="5">
					       </td>
				        </tr>
				        
				        <tr>
				         <td height="10">
				         </td>
				        </tr> 
				   </table>  
										
					</td>
				</tr>
				</table>
			</td>
			<td width="3px"></td>
		</tr>

		</table>
	</td>
	<td width="4" align="right" background="<%= themeDisplay.getPathThemeImage() %>/DB_image/8.gif"></td>	
</tr>
			
<tr>
	<td width="4" align="left" height="5">
	<img src="<%= themeDisplay.getPathThemeImage() %>/DB_image/6.gif" width="4" height="5"/></td>
	<td background="<%= themeDisplay.getPathThemeImage() %>/DB_image/4.gif" height="5"></td>
	<td width="4" align="right">
	<img src="<%= themeDisplay.getPathThemeImage() %>/DB_image/5.gif" width="4" height="5" /></td>

</tr>
	
<tr><td height="4px" colspan="3"></td></tr>		 	
</table>					
					
<%}%>					
</form>