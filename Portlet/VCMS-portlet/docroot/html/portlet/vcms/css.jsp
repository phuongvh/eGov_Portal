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
<style type="text/css">
.text_none2 {
	font-family: Tahoma, Verdana, Arial, Helvetica, sans-serif;
	font-size: 11px;
	font-weight: bold;
	color: #3175b9;
	text-decoration: none;
	line-height: 16px;
}
.text_none {
	font-family: Tahoma, Verdana, Arial, Helvetica, sans-serif;
	font-size: 11px;
	font-weight: normal;
	color: #000000;
	text-decoration: none;
	line-height: 16px;
}


.text_detail {
	font-family: Tahoma, Verdana, Arial, Helvetica, sans-serif;
	font-size: 11px;
	font-weight: normal;
	color: #3175b9;
	text-decoration: none;
	line-height: normal;
	padding-top: 5px;
}

.n-img{
	float:left;
	padding:4px;
	margin-top:1em;
	margin-right:5px;
	border:#78A3B9 solid 1px;
	background-color:#fff;
}


/** Popup **/

.box_guiban {
	position:fixed;
	_position:absolute;
	top:30px;
	left:27%;
	width:439px;
	height:auto;
	padding:8px;
	background:#ffffff;
	border:3px solid #4A4A4A;
	z-index:10;
	display:none;
	_margin-top: expression(0 - parseInt(this.offsetHeight / 500) + (TBWindowMargin = document.documentElement && document.documentElement.scrollTop || document.body.scrollTop) + 'px');

}

.error_display{
	font-weight:bold;
	color:#FF0000;
}

.tit_guiban {
	background:url(/html/portlet/vcmsviewcontent/images/tit_guiban.gif) 0 0 repeat-x;
	height:23px;
	padding:4px 0 0 10px;
	font-size:16px;
	font-family:arial;
	margin:0 0 15px 0;
	vertical-align:bottom;
	font-weight:bold;
	color:WHITE;
}

.overlay {
	display:none;
	width:100%;
	_width:1500px;
	height:100%;
	_height:2500px;
	position:fixed;
	_position:absolute;
	top:0;
	left:0;
	background:#000;
	filter:alpha(opacity=50);
	-moz-opacity:.50;	
	opacity:.50;
	z-index:5;
	_overflow:hidden;
}

.sign_warning {
	background:url(/html/portlet/vcmsviewcontent/images/warning_small.gif) 8px no-repeat #fef8f8;
	border:#fadcdc solid 1px;
	width:82%;
	padding:8px;
	padding-left:60px;
	margin-bottom:10px;
	font-size:13px;
	display:none;
	line-height:20px;
}

.error {
	background:url(/html/portlet/vcmsviewcontent/images/warning_small.gif) 70px no-repeat;
	width:82%;
	padding:8px;
	padding-left:120px;
	margin-bottom:10px;
	font-size:13px;
	color:#FF0000;
	width:200px;
}

.sign_success {
	background:url(/html/portlet/vcmsviewcontent/images/done.png) 8px no-repeat;
	width:60%;
	padding:23px;
	padding-left:120px;
	margin-bottom:10px;
	font-size:16px;
	color:#3399FF;
	font-weight:bold;
	display:none;
	line-height:20px;
}

.close_popup {
	padding:23px;
	display:none;
	padding-left:40%;
}
.boder {
	border: 1px solid #6ac0f6;
}
</style>