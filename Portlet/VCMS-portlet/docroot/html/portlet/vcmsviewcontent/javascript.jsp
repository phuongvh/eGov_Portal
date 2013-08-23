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
<script type="text/javascript">

//Send article to friend...
function sentToFriend(){
	var toname = $("#toname").val();
	var toaddress = $("#toaddress").val();
	var fromname = $("#fromname").val();
	var fromaddress = $("#fromaddress").val();
	var content = $("#content").val();
	var articleId = $("#articleid").val();
	var pathArticle = location.href;

	if(fromname == ""){
		alert('Please enter a Sender Name!');
		document.form_gopy.fromname.focus();
		return;
	}else if(fromaddress == ""){
		alert('Please enter a Sender Email!');
		document.form_gopy.fromaddress.focus();
		return;
	}else if(checkmail(fromaddress) == false){
		alert('Sender Email is Wrong!');
		document.form_gopy.fromaddress.focus();
		return;
	}else if(toname == ""){
		alert('Please enter a Receiver Name!');
		document.form_gopy.toname.focus();
		return;
	}else if(toaddress == ""){
		alert('Please enter a Receiver Email!');
		document.form_gopy.toaddress.focus();
		return;
	}else if(checkmail(toaddress) == false){
		alert('Receiver Email is Wrong!');
		document.form_gopy.toaddress.focus();
		return;
	}else{
		jQuery.ajax({
		  type: "POST",
		  url: "<portlet:actionURL><portlet:param name='struts_action' value='/vcmsviewcontent/ajax'/></portlet:actionURL>",
		  data: "cmd=sent_to_friend&articleId=" + articleId +
				"&pathArticle="+encodeURIComponent(pathArticle)+
				"&toname="+toname+
				"&toaddress="+toaddress+
				"&fromname="+fromname+
				"&fromaddress="+fromaddress+
				"&content="+content,
	      dataType: "json",
		  complete: function(jo){
				jQuery(".sign_success").css("display","block");
				document.getElementById('submit').disabled = true;
		  }
		});
	}
}

function showPrintArticle(articleId){
	var MessagesMessageBox = Liferay.Popup({modal:true, title: '<%= LanguageUtil.get(pageContext, "portlet.vcms.article.message-list") %>', width: 600,height:500});
	url = "/html/portlet/vcmsviewcontent/print_article.jsp?printArticleId="+articleId;
	//alert(url);
	AjaxUtil.update(url, MessagesMessageBox , {onComplete: function(){Liferay.Popup.center()}});
}

function showSendFriend(close){
	if(jQuery.browser.msie) {
		jQuery("html").css("overflow","hidden");
	}
	jQuery('.overlay').css("display", "block");
	if(close=='false') {
		jQuery("#box_guiban").slideUp("slow");
		jQuery('.overlay').css("display", "none");
		jQuery('html').css('overflow','auto');
		jQuery('select').show();
	} else {
		jQuery("#box_guiban").slideDown(600);
		jQuery('select').hide();
	}
}

function doTextCounter( field, countfield, maxlimit ) {
	var inputField = document.getElementById(field);
	var countField = document.getElementById(countfield);
	if ( inputField.value.length > maxlimit ) {
		countField.innerHTML = 0;
		return false;
	} else {
		countField.innerHTML = maxlimit - inputField.value.length;
	}
}

function checkmail(e){
	var emailfilter=/^\w+[\+\.\w-]*@([\w-]+\.)*\w+[\w-]*\.([a-z]{2,4}|\d+)$/i;
	var returnval=emailfilter.test(e)
	return returnval;
}


function expandingWindow(website) {
	var windowprops = "width=100,height=100,scrollbars=yes,status=yes,resizable=no";
	var heightspeed = 20; // vertical scrolling speed (higher = slower)
	var widthspeed = 20;  // horizontal scrolling speed (higher = slower)
	var leftdist = 10;    // distance to left edge of window
	var topdist = 10;     // distance to top edge of window
	var winwidth = 670;
	var winheight = 700;
	if (window.resizeTo && navigator.userAgent.indexOf("Opera") == -1) {
		var sizer = window.open("", "", "left=" + leftdist + ",top=" + topdist + "," + windowprops);
		for (sizeheight = 1; sizeheight < winheight; sizeheight += heightspeed) {
			sizer.resizeTo("1", sizeheight);
		}
		for (sizewidth = 1; sizewidth < winwidth; sizewidth += widthspeed) {
			sizer.resizeTo(sizewidth, sizeheight);
		}
		sizer.location = website;
	} else {
		
		window.open(website, "mywindow");
	}
}


</script>