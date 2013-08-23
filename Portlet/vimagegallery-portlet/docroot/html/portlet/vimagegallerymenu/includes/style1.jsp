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

<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<liferay-theme:defineObjects />
<script type="text/javascript" src="/vimagegallery-portlet/js/jquery-1.3.1.min.js"></script>
<script type="text/javascript">

$(document).ready(function() {		
	
	//Execute the slideShow
	slideShow();

});

function slideShow() {

	//Set the opacity of all images to 0
	$('#gallery a').css({opacity: 0.0});
	
	//Get the first image and display it (set it to full opacity)
	$('#gallery a:first').css({opacity: 1.0});
	
	//Set the caption background to semi-transparent
	$('#gallery .caption').css({opacity: 0.7});

	//Resize the width of the caption according to the image width
	$('#gallery .caption').css({width: $('#gallery a').find('img').css('width')});
	
	//Get the caption of the first image from REL attribute and display it
	$('#gallery .content').html($('#gallery a:first').find('img').attr('rel'))
	.animate({opacity: 0.7}, 400);
	
	//Call the gallery function to run the slideshow, 6000 = change to next image after 6 seconds
	setInterval('gallery()',6000);
	
}

function gallery() {
	
	//if no IMGs have the show class, grab the first image
	var current = ($('#gallery a.show')?  $('#gallery a.show') : $('#gallery a:first'));

	//Get next image, if it reached the end of the slideshow, rotate it back to the first image
	var next = ((current.next().length) ? ((current.next().hasClass('caption'))? $('#gallery a:first') :current.next()) : $('#gallery a:first'));	
	
	//Get next image caption
	var caption = next.find('img').attr('rel');	
	
	//Set the fade in effect for the next image, show class has higher z-index
	next.css({opacity: 0.0})
	.addClass('show')
	.animate({opacity: 1.0}, 1000);

	//Hide the current image
	current.animate({opacity: 0.0}, 1000)
	.removeClass('show');
	
	//Set the opacity to 0 and height to 1px
	$('#gallery .caption').animate({opacity: 0.0}, { queue:false, duration:0 }).animate({height: '1px'}, { queue:true, duration:300 });	
	
	//Animate the caption, opacity to 0.7 and heigth to 100px, a slide up effect
	$('#gallery .caption').animate({opacity: 0.7},100 ).animate({height: '100px'},500 );
	
	//Display the content
	$('#gallery .content').html(caption);
	
	
}

</script>
<style type="text/css">
/* body{
	font-family:arial
} */

.clear {
	clear:both
}

#gallery {
	position:relative;
	height:360px
}
	#gallery a {
		float:left;
		position:absolute;
	}
	
	#gallery a img {
		border:none;
	}
	
	#gallery a.show {
		z-index:500
	}

	#gallery .caption {
		z-index:600; 
		background-color:#000; 
		color:#ffffff; 
		height:100px; 
		width:100%; 
		position:absolute;
		bottom:0;
	}

	#gallery .caption .content {
		margin:5px
	}
	
	#gallery .caption .content h3 {
		margin:0;
		padding:0;
		color:#1DCCEF;
	}
	

</style>

<%
	TFCategory category = (TFCategory)listCategory.get(0);
	categoryURL.setParameter("categoryId", String.valueOf(category.getId()));
%>
<table width="580px" cellpadding="0" cellspacing="0" border="0">
<tr>
	<td width="100%">
		<div id="gallery">
		 	<a href="<%=categoryURL.toString()%>" class="show">
				<img src="<%= themeDisplay.getPathImage() %>/vimagegallery?img_id=<%= category.getImage() %>&large=1" alt="<%=category.getName() %>" width="580" height="360" title="" rel="<h3><%= category.getName() %></h3><%= category.getDescription()%> "/>
			</a>
			<%
			TFCategory category1 = null;
			String link = "";
			for (int i=1;i<listCategory.size();i++){
				category1 = (TFCategory)listCategory.get(i);
				categoryURL.setParameter("categoryId", String.valueOf(category1.getId()));
				link =  themeDisplay.getPathImage()+"/vimagegallery?img_id="+category1.getImage()+"&large=1";
			%>
			<a href="<%=categoryURL.toString()%>">
				<img src="<%= link %>" alt="<%=category1.getName() %>" width="580" height="360" title="" rel="<h3><%= category1.getName() %></h3><%= category1.getDescription()%> "/>
			</a>
			
			<%
			} %>
			<div class="caption"><div class="content"></div></div>
		</div>
		<div class="clear"></div>
		
		<br/><br/>
	</td>
</tr>
</table>







