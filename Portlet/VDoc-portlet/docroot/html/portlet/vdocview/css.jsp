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
/*abc*/

.left{
	width: 30%;
	float: left;
	padding-left:20px;
}
.center{
	width: 30%;
	float: left;
	padding-left:20px;
}
.right{
	width: auto;
	float: none;		
}

a
{
	text-decoration: none;
}
a:HOVER
{
	color: #FFFFFF;
}

#div_title
{
	display:block;
	height:30px;
	background:url(/VDoc-portlet/html/portlet/vdocview/Images/background_title.jpg) repeat-x;
	font-size:12px;
	font-weight:bold;
	text-transform:uppercase;
	color:white;
	padding:8px 0px 0px 10px;
	margin:0px;
}

#div_content
{
	padding-top: 15px;
	width: 100%;
}

#div_content #tb_content
{
	width: 100%;
}

#div_content #tb_content tr
{
	width: 100%;
}

#div_content #tb_content #tr_content td
{
	background-color: #FFFFFF;
/* 	background:url(/VDoc-portlet/html/portlet/vdocview/Images/background_title.jpg) repeat-x; */
	border: solid 1px #C0C0C0;
	text-align: center;
	font-weight: bold;
	height: 30px;
	color: #FFFFFF;
}

#div_content #tb_content #tr_content_01 td
{
	border: solid 1px #C0C0C0;
	text-align: center;
	font-weight: normal;
	height: 30px;
	color: #000000;
}

#div_content #tb_content #tr_content_01 a
{
	color: #5c5c5c;
}

#div_content #tb_content #tr_content_01 a:hover
{
	color: #0000FF;
}

.div_content
{
	width: 100%;
	font-family: Tahoma, Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
}

.div_content .div_summary
{
	padding-top: 5px;
	padding-bottom: 15px;
}

.div_content .tb_content
{
	width: 100%;
}

.div_content .tb_content tr
{
	width: 100%;
}

.div_content .tb_content tr td
{	
	padding: 5px 0px 5px 15px;
	border: solid 1px #C0C0C0;
}

.div_content .tb_content tr .td_content
{
	width: 20%;
}

.select_org{
	display:block;
	width:40%;
	float:left;
	margin-top:10px;
	padding-left:10px;
}

.option_org{
	width:50%;
	display:block;
	float:left;
	margin-top:8px;
}

.name_doc{
	width:30%;
	display:block;
	float:left;
	margin-top:10px;
	padding-left:10px;
}

.text_name_doc{
	width:40%;
	display:block;
	float:left;
	margin-top:6px;
}

.search_button{
	display:block;
	float:left;
	height: 25px;
	margin-left:3px;
	margin-top:6px;
}

#search_page_level2_administrative_procedures{
	height:36px;
	background:#ffffff;
}
#left_level2_administrative_procedures{
	width:45%;
	float:left;
}
#right_level2_administrative_procedures{
	width:55%;
	float:left;
}

.wd-boxs {
    background-color: #FFFFFF;
    border: 1px solid #C3C3C3;
    border-radius: 4px 4px 4px 4px;
    margin-top: 11px;
    padding: 3px;
}
/*-------------------------------------CSS Bo thu tuc hành chính cấp 1-----------------------------------------*/
.list_procedures{
	list-style-type:none;
	padding:0px;
}
.list_procedures ul{
	padding:0px;
	list-style-type:none;
}

.title_tenthutuc{
	display:block;
/* 	width:380px; */
	height:23px;
	background:#FFFFFF;
	float:left;
	margin-right:1px;
	color:black;
	font-weight:bold;
	padding-top:7px;
	padding-left:10px;
	margin-bottom:1px;
}
.title_coquanthuchien{
	display:block;
/* 	width:225px; */
	float:left;
	background:#FFFFFF;
	height:23px;
	margin-right:1px;
	color:black;
	font-weight:bold;
	padding-top:7px;
	padding-left:10px;
	margin-bottom:1px;
}
.title_taive{
	font-weight:bold;
	display:block;
	float:left;
	background:#ffffff;
	height:23px;
/* 	width:63px; */
	color:black;
	padding-top:7px;
	padding-left:10px;
	margin-bottom:1px;
}
.thutuc01{
	display:block;
/* 	width:380px; */
	height:33px;
/* 	background:#eff0f0; */
	float:left;
	margin-right:1px;
	color:#5c5c5c;
	font-weight:bold;
	text-transform:uppercase;
	padding-top:17px;
	padding-left:10px;
}
.coquanthuchien01{
	display:block;
/* 	width:225px; */
	float:left;
/* 	background:#eff0f0; */
	height:33px;
	margin-right:1px;
	color:#5c5c5c;
	padding-top:17px;
	padding-left:10px;
	margin-bottom:1px;
}
.buton_download_01{
	display:block;
	float:left;
	background:#eff0f0;
	height:33px;
	width:63px;
	color:#FFF;
	padding-top:17px;
	padding-left:10px;
	margin-bottom:1px;
}
.thutuc02{
	display:block;
	width:380px;
	height:33px;
	background:#e4e5e5;
	float:left;
	margin-right:1px;
	color:#5c5c5c;
	font-weight:bold;
	text-transform:uppercase;
	padding-top:17px;
	padding-left:10px;
}
.coquanthuchien02{
	display:block;
	width:225px;
	float:left;
	background:#e4e5e5;
	height:33px;
	margin-right:1px;
	color:#5c5c5c;
	padding-top:17px;
	padding-left:10px;
	margin-bottom:1px;
}
.buton_download_02{
	display:block;
	float:left;
	background:#e4e5e5;
	height:33px;
	width:63px;
	color:#FFF;
	padding-top:17px;
	padding-left:10px;
	margin-bottom:1px;
}

/*-------------------------------------Noi dung chi tiet thu tuc-----------------------------------------*/

table.sample1 {
    background-color: white;
    border: 1px outset gray;
    border-collapse: collapse;
    border-spacing: 2px;
}
table.sample1 td {
    background-color: white;
    border: 1px inset gray;
    padding: 5px;
}
</style>