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
<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("jspPage", "/html/portlet/vimagegalleryview/view.jsp");
	
	/* String categoryId = (String)request.getAttribute("categoryId");	 */		
			
	String categoryId = ParamUtil.getString(request, "categoryId");
	
	//Phan trang
	int numberPage = ParamUtil.getInteger(request, "pagenum", 1);
	int total = 0;
	String title="";
	List listImage = null;
	
	boolean flagImage = false;
   
	if(Validator.isNotNull(categoryId)){						
	    total = TFImageServiceUtil.countByG_C_I(groupId,Long.parseLong(categoryId), true);	
	    TFCategory category = TFCategoryServiceUtil.findCategory(Long.valueOf(categoryId));
	    title = category.getName();
	    listImage = TFImageServiceUtil.getByG_C_I(groupId, Long.parseLong(categoryId), true);
	}else{		
		total = TFImageServiceUtil.countByG_I(groupId, true);
		title = "Th&#432; vi&#7879;n &#7843;nh";
		listImage = TFImageServiceUtil.getByGroupId(groupId);
	}
	
	if(listImage.size() != 0) flagImage = true;
	
	
	int per = Integer.parseInt(numOfImagePerPage);
	int pages = (total % per == 0) ? total / per : total / per + 1;
	
	int begin = per * (numberPage - 1);
	int end = (total>per * numberPage) ? per * numberPage : total;	

	String temp1 = "box_left_portlet " + styleBullet + " " +styleTitle;
	String temp2 = styleBorder;	

%>
<style type="text/css">
/* body {margin:50px 0px; padding:0px; background-color: #000000;color: #ffffff;} */
#contentImg {width:620px; margin:0px auto; height: 425px ;}
#desc {margin:10px; float:left; font-family: Arial, sans-serif; font-size: 12px;}
</style>

<!-- include CSS always before including js -->
<link type="text/css" rel="stylesheet" href="/vimagegallery-portlet/css/tn3.css"></link>
<!-- include jQuery library -->
<script type="text/javascript" src="/vimagegallery-portlet/js/jquery.min.js"></script>
<!-- include tn3 plugin -->
<script type="text/javascript" src="/vimagegallery-portlet/js/jquery.tn3lite.min.js"></script>

<!--  initialize the TN3 when the DOM is ready -->
<script type="text/javascript">
	$(document).ready(function() {
		//Thumbnailer.config.shaderOpacity = 1;
		var tn1 = $('.mygallery').tn3({
skinDir:"/vimagegallery-portlet/html",
imageClick:"fullscreen",
image:{
maxZoom:1.5,
crop:true,
clickEvent:"dblclick",
transitions:[{
type:"blinds"
},{
type:"grid"
},{
type:"grid",
duration:460,
easing:"easeInQuad",
gridX:1,
gridY:8,
// flat, diagonal, circle, random
sort:"random",
sortReverse:false,
diagonalStart:"bl",
// fade, scale
method:"scale",
partDuration:360,
partEasing:"easeOutSine",
partDirection:"left"
}]
}
		});
	});
</script>
<div class="wd-boxs">
		<c:if test="<%=!flagImage %>">
		 	<div align="left"><b>Not found image</b></div>
		</c:if>
		
		<c:if test="<%=flagImage %>">
	    <div id="contentImg">
	    <div class="mygallery">
		<div class="tn3 album">
		    <h4>Fixed Dimensions</h4>
		    <div class="tn3 description"><%= title %></div>
		    <div class="tn3 thumb"></div>
		    <ol>
		    <% 
		    	for (int i=0;i<listImage.size();i++){
		    	TFImage image = (TFImage)listImage.get(i);
		    %>
			<li>
			    <h4><%= image.getName() %></h4>
			    <div class="tn3 description"><%= image.getDescription() %></div>
			    <a href="<%=themeDisplay.getPathImage() %>/vimagegallery?img_id=<%= image.getImage() %>&lage=1">
				<img src="<%=themeDisplay.getPathImage() %>/vimagegallery?img_id=<%= image.getImage() %>&small=1" />
			    </a>
			</li>
			<% } %>
		    </ol>
		</div>
	    </div>
	  </div>
	  </c:if>
</div>



