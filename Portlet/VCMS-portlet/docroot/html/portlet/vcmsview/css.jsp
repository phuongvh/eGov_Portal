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
.r-table{
	background:#FC9149 url(/html/portlet/vcmsview/images/snd_tr.gif) right top no-repeat;
	margin-bottom:4px;
}
.col-01{
	width:172px;
	background-color:#fff;
	vertical-align:top;
	height:550px;
}

.t-col{
	width:168px;
}

.new-vb{
	margin-bottom:0.5em;
}
.new-vb th{
	text-align:left;
	font-size:12px;
	padding-left:22px;
}
.new-vb th,
.new-vb td,
.new-vb a{
	color:#fff;
}
.org th,
.org td{
	color:#297fb4;
}
.new-vb a,
.blue a,
.org a,
.org2 a{
	display:block;
	background-image:url(/html/portlet/vcmsview/images/bull_w.gif);
	background-position:3px 7px;
	background-repeat:no-repeat;
	padding:2px 0px;
	padding-left:13px;
}
.org a{
	color:#ff6701;
	background-image:url(/html/portlet/vcmsview/images/bull_o.gif);
}
.org2 a{
	color:#ff8a3b;
	background-image:url(/html/portlet/vcmsview/images/bull_o.gif);
}
.blue a{
	color:#008ad3;
	background-image:url(/html/portlet/vcmsview/images/bull_b.gif);
}
.new-vb b{
	display:block;
	margin-bottom:4px;
}
.f-table{
	border:#E5A275 solid 1px;
	margin:0.5em 0;
	padding:4px;
}
.f-table a{
	background-image:none;
	padding:0px;
}
.link-b{
	text-align:right;
	line-height:18px;
}
p.link-b{
	border:#3797ce solid 1px;
	border-width:1px 0px 1px 0px;
}
.link-b,
.link-b a{
	color:#3797ce;
}
.link-b a:hover{
	text-decoration:none;
}
p.white{
	border-color:#fff;
}
.white,
.white a{
	color:#fff;
}
.white a:hover{
}

.intro-mode td{
	text-align:center;
}
.intro-mode a{
	display:block;
}
.intro-mode p{
	background:url(/html/portlet/vcmsview/images/i_dot.gif) center repeat-x;
	width:80%;
	height:20px;
	margin:0px auto 0px auto;
}
.chanel-news{
	margin-bottom:5px;
}
.chanel-news th{
	text-align:left;
	font-size:12px;
	background:url(/html/portlet/vcmsview/images/h_line.gif) 100% 70% no-repeat;
}
.chanel-news th,
.chanel-news th a{
	color:#0c6fa4;
	font-size:12px;
}
.chanel-news th a:hover{
	text-decoration:none;
}
.chanel-news a.title{
	display:block;
	font-weight:bold;
	margin-bottom:5px;
	color:#006fb3;
}
.chanel-news .t2,
.chanel-news .t6{
	float:left;
	width:auto;
	background-color:#fff;
	padding-left:22px;
	padding-right:3px;
	line-height:20px;
}
.chanel-news .n-img{
	float:left;
	padding:4px;
	margin-top:1em;
	margin-right:15px;
	border:#78A3B9 solid 1px;
	background-color:#fff;
}
/*.chanel-news .n-img img{
	width:115px;
	height:auto;
}*/

.indent{
	margin-left:10px;
}

.next,
.next a{
	color:#0c6fa4;
}

.ta-link img{
	float:left;
	border:#78A3B9 solid 1px;
	width:38px;
	height:auto;
	margin-right:10px;
}

/* --- tab style --- */
#container-1{
	background-color:#F8FCFF;
	border:#78A3B9 solid 1px;
	margin-bottom:15px;
}
.ui-tabs-nav{
	list-style:none;
	margin:0px;
	padding:0px;
	background:url(/html/portlet/vcmsview/images/bg_tab.png) top repeat-x;
	min-height:22px;
}
.ui-tabs-hide{display:none;}
.ui-tabs-nav li{
    float:left;
    margin:0px;
}

.ui-tabs-nav li a{
	float:left;
	display:block;
	color:#0c6fa4;
	font-weight:bold;
	font-size:12px;
	text-align:center;
	background-image:url(/html/portlet/vcmsview/images/tab.png);
	background-position:0 -29px;
	background-repeat:no-repeat;
	line-height:22px;
}

.ui-tabs-nav a:hover{
}

.ui-tabs-nav a#first{
	width:137px;
	background-position:-1px -29px;
}
.ui-tabs-nav a#second{
	width:146px;
}
.ui-tabs-nav a#third{
	width:146px;
}

.ui-tabs-nav li.ui-tabs-selected a{
	color:#f4711a;
	text-decoration:none;
	background-image:url(/html/portlet/vcmsview/images/tab.png);
	background-position:-1px 0;
	background-repeat:no-repeat;
}
.ui-tabs-nav li.ui-tabs-selected a#first{
	background-position:-1px 0;
}
.ui-tabs-nav li.ui-tabs-selected a#second,
.ui-tabs-nav li.ui-tabs-selected a#third{
	background-position:0 0;
}
.ui-tabs-nav li.ui-tabs-selected a:hover{
	text-decoration:none;
}
.ui-tabs-container{
	padding:10px 0px;
}
.w-tab{width:419px;}
.h-tab{height:15px; *height:5px;}/* --- end tab style --- */

.slide{
	position:relative;
	width:354px;
	height:120px;
	border:#78A3B9 solid 1px;
}
.bg-s01,
.bg-s02,
.bg-s03,
.bg-s04{
	width:354px;
	height:120px;
	background-repeat:no-repeat;
}
.bg-s01{
	background-image:url(/html/portlet/vcmsview/images/slide01.jpg);
}
.tab-s{
	position:absolute;
	top:0px;
	right:0px;
}
.tab-s a{
	display:block;
	line-height:30px;
	color:#fff;
	font-weight:bold;
	text-align:center;
	background-image:url(/html/portlet/vcmsview/images/slide_tab.gif);
	background-position:0 -30px;
	background-repeat:no-repeat;
	padding:0px 15px;
	padding-left:22px;
}
.tab-s a:hover{
	text-decoration:none;
	background-position:0 -60px;
}
a.tab-s-select,
a.tab-s-select:hover{
	background-position:0 0;
}

.title01,
.title01 a{
	display:block;
	color:#ff8a3b;
	font-size:12px;
	font-weight:bold;
}
.f-s16{
	font-size:16px;
}

.date-current{
	float:right;
	color:#ff8e44;
	font-size:11px;
	font-weight:normal;
	margin-right:5px;
	padding-bottom:7px;
}
.time{
	font-size:10px;
	color:#9c9c9c;
}
.news-other{
	display:block;
	color:#f1721c;
	font-size:12px;
}
.hot-line{
	font-style:italic;
	color:#9c9c9c;
	display:block;
}
.m5{margin-top:5px;}
.bread-crum,
.bread-crum a{
	/*color:#9c9c9c;*/
	color:#008ad3;
}
.bread-crum a{
	padding:2px 0px;
	padding-left:10px;
	background:url(/html/portlet/vcmsview/images/bull_b.gif) 3px 7px no-repeat;
	font-weight:bold;
}
.bread-crum a:hover{
}
.author{
	font-size:11px;
	margin-left:20px;
}


.footer{
	background:#018CD3 url(/html/portlet/vcmsview/images/bg_footer.png) top repeat-x;
}
.footer td,
.footer a{
	color:#fff;
	line-height:18px;
	text-align:center;
}

/* --- */
.no-top{margin-top:0px;}
.no-top-i{
	margin-top:0px;
}
.no-top-f{
	margin-top:1em;
}
.no-bot{margin-bottom:0px;}
.no-bg{background:none;}
.no-bg a{background-image:none; padding-left:0px;}
.u a{
	text-decoration:underline;
}
.u a:hover{
	text-decoration:none;
}
.j-align{
	text-align:justify;
}

/* --- new style update - March 1, 2008 --- */
.f-left{
	float:left;
}
.title01 span{
	color:#ab7550;
	font-size:11px;
}
.t7{
	background:url(/html/portlet/vcmsview/images/g_ap.gif) 0px 0px no-repeat;
}
.t8{
	background:url(/html/portlet/vcmsview/images/g_ap2.gif) 0px 0px no-repeat;
	line-height:19px;
}
.t9{
	background:url(/html/portlet/vcmsview/images/g_ch.gif) 0px 2px no-repeat;
}
.t10{
	background:url(/html/portlet/vcmsview/images/g_pq.gif) 0px 0px no-repeat;
}
.t11{
	background:url(/html/portlet/vcmsview/images/g_tc.gif) 3px 0px no-repeat;
}
.t12{
	background:url(/html/portlet/vcmsview/images/g_se.gif) 0px 2px no-repeat;
}
.chanel-news .t2,
.chanel-news .t6,
.chanel-news .t7,
.chanel-news .t9,
.chanel-news .t10,
.chanel-news .t11,
.chanel-news .t12{
	float:left;
	width:auto;
	background-color:#fff;
	padding-left:22px;
	padding-right:3px;
	line-height:20px;
}
.chanel-news .t7{
	padding-left:18px;
}
.chanel-news .t11{
	padding-left:25px;
}
.a-p{
	padding-top:5px;
}
.a-p a{
	background-image:none;
	border-bottom:#FEC197 solid 1px;
	padding:4px;
	margin:0px 5px;
	font-weight:bold;
}
.a-p a:hover{
	text-decoration:none;
	color:#fff;
}

.ap-search input{
	float:left;
}
.ap-search input.textField{
	color:#BF7340;
	border:#BF7340 solid 1px;
	width:117px;
	margin-right:3px;
	padding-top:2px;
	height:20px;
}
.alp,
.alp a{
	color:#fff;
}
.alp p{
	margin-top:5px;
	margin-bottom:4px;
	
}
.alp a{
	display:block;
	float:left;
	padding:4px;
}

.o-news select{
	color:#0081c4;
	margin-right:15px;
}
.o-news input.btn{
	color:#fff;
	background:url(/html/portlet/vcmsview/images/bg_btn.gif) right bottom no-repeat;
	border:none;
	font-size:11px;
	cursor:pointer;
	height:21px;
	padding:1px 10px 5px 7px;
	*padding:2px 10px 4px 7px;
}

.left-side{
	width:195px;
	vertical-align:top;
}

.box-left{
	margin-bottom:9px;
}
.box-left .left{
	background:url(/html/portlet/vcmsview/images/bg_lmn_l.gif) left repeat-y;
	vertical-align:top;
}
.box-left .right{
	background:url(/html/portlet/vcmsview/images/bg_lmn_r.gif) right repeat-y;
	vertical-align:top;
}
.box-left .bot{
	background:url(/html/portlet/vcmsview/images/bg_lmn_b.gif) bottom repeat-x;
}

.box-left th{
	color:#0091dc;
	text-align:left;
	font-size:12px;
	padding:10px 0px;
}
.box-left th.gy,
.box-left th.htx{
	background-image:url(/html/portlet/vcmsview/images/g_gy.gif);
	background-position:6px 10px;
	background-repeat:no-repeat;
	padding-left:27px;
	padding-bottom:5px;
}
.box-left th.htx{
	background-image:url(/html/portlet/vcmsview/images/g_dc.gif);
	background-position:6px 11px;
}
.box-left a{
	display:block;
	margin:0px 5px;
	color:#ff8a3b;
	font-size:12px;
	font-weight:bold;
	background:url(/html/portlet/vcmsview/images/bull_o.gif) 0px 10px no-repeat;
	padding:5px 0px;
	padding-left:10px;
	border-top:#CCCCCC dashed 1px;
}
.box-left a.top{
	border-top:none;
}

.box-left div.sub-menu a{
	font-size:11px;
	font-weight:normal;
	background:none;
	padding-top:2px;
	padding-bottom:2px;
	border:none;
	background:none;
}
.box-left div.sub-menu a.end{
	padding-bottom:5px;
}

.box-left a:hover{
	color:#ff8a3b;
}
.question{
	font-size:11px;
	text-align:justify;
	color:#484848;
}
.question a,
.send-mail{
	display:block;
	color:#ff8a3b;
	font-size:12px;
	font-weight:bold;
	margin-bottom:3px;
}
.send-mail{
	text-decoration:underline;
}
.send-mail:hover{
	text-decoration:none;
}

.tb-link a,
.tb-link p,
.tb-link b{
	color:#ff8a3b;
}
.tb-link a{
	font-weight:bold;
	padding:0px 5px;
}
.tb-link p a{
	font-size:12px;
	background:url(/html/portlet/vcmsview/images/bull_o.gif) 0px 6px no-repeat;
	padding:0px;
	padding-left:10px;
}
.tb-link p{
	margin:8px 0px;
}
.tb-link span{
	color:#a0a0a0;
	font-weight:bold;
	font-style:italic;
}
.tb-link b{
	display:block;
	margin:7px 0px;
}
.page-link,
.page-link a,
.page-link span{
	color:#4d9ac3;
	font-weight:bold;
	padding:0px 4px;
}
.page-link span{
	font-style:normal;
}

.grey-line{
	border-bottom:#D7D7D7 solid 1px;
	padding:7px 0px;
}

.o-link-u a{
	color:#ff8a3b;
	font-size:12px;
	font-weight:bold;
	text-decoration:underline;
}
.o-link-u a:hover{
	text-decoration:none;
}
.o-link-u{
	padding-top:5px;
}

.t-gallery td{
	text-align:center;
	vertical-align:top;
}
.t-gallery b{
	display:block;
	margin:5px 0px;
	color:#fa8536;
	font-size:12px;
}
.t-gallery img{
	width:200px;
	height:auto;
}



.f-head{
	background:#FC914A url(/html/portlet/vcmsview/images/bg_fhead.gif) right repeat-y;
	color:#fff;
	padding:5px 0px;
	padding-left:10px;
}

.f-head select{
	margin:0px 5px;
}
.f-head select,
.f-head label{
	float:left;
}
.f-head label{
	margin-top:3px;
}

.box-add td{
	color:#5b5b5b;
	padding:5px 0px;
	padding-left:10px;
}
.box-add b,
.box-add a{
	color:#ff8532;
}

.box-list th,
.box-list td{
	padding:5px;
	padding-left:15px;
	vertical-align:top;
}
.box-list th{
	color:#5b5b5b;
	background:#E9F8FF url(/html/portlet/vcmsview/images/bg_list.gif) left repeat-y;
	text-align:left;
	font-weight:normal;
}
.box-list td.h-space{
	width:6px;
	padding:0px;
}
.box-list td{
	color:#5e5e5e;
}
.box-list b,
.box-list strong,
.box-list a{
	color:#ff8532;
}
.box-list b{
	font-size:12px;
	display:block;
	margin-bottom:5px;
}
.box-list p{
	margin:5px;
	background:url(/html/portlet/vcmsview/images/bull_list.gif) 0px 5px no-repeat;
	padding-left:7px;
}

.title02{
	color:#0c6fa4;
	font-size:11px;
	font-weight:bold;
	text-transform:uppercase;
	padding-left:16px;
	background:url(/html/portlet/vcmsview/images/bull_title02.gif) 0px 2px no-repeat;
}

hr{
	border:none;
	*border:#fff solid 1px;
	border-bottom:#BBBBBB solid 1px;
	width:525px;
	margin-top:15px;
}

.w-pad{
	width:12px;
}
.l-vb td{
	vertical-align:top;
	font-size:12px;
}
.l-vb p{
	background:url(/html/portlet/vcmsview/images/icon_vb.gif) 0px 5px no-repeat;
	padding:4px 0px;
	padding-left:20px;
	margin:0px;
	color:#999999;
}
.l-vb a,
.l-vb a:visited{
	color:#ff8532;
	font-weight:bold;
}
.blue-t{
	display:block;
	font-size:12px;
	color:#3cbbfc;
	padding-left:22px;
	margin-top:10px;
	margin-bottom:5px;
}
.box-news2{
	margin-bottom:15px;
	clear:both;
}
.box-news2 th,
.box-news2 td{
	border-right:#fff solid 1px;
	padding:5px 12px;
}
.box-news2 th{
	text-align:left;
	color:#0c6fa4;
	font-size:12px;
	padding-left:22px;
	background:#8FD9FF url(/html/portlet/vcmsview/images/bull_boxnews2.gif) 7px 1px no-repeat;
}
.box-news2 th.end{
	padding-right:5px;
}
.box-news2 td{
	vertical-align:top;
}
.color{
	background-color:#DFF4FF;
}
.s-vb{
	margin-bottom:1px;
	background-color:#3CBBFC;
}
.s-vb td td{
	padding:0px;
}
.s-vb label,
.s-vb a{
	color:#fff;
	font-size:12px;
	font-weight:bold;
}
.s-vb a{
	text-decoration:underline;
}
.s-vb a:hover{
	text-decoration:none;
}
.s-vb label{
	margin-right:5px;
}
.s-vb input.textField{
	width:155px;
	*margin-right:5px;
}
.s-vb table.n-w{
	margin-top:3px;
}
.bt-link span{
	color:#ababab;
}
.bt-link span,
.bt-link a,
.bt-link a:visited{
	padding:0px 3px;
}
.bt-link a:hover{
	color:#236fb6;
	text-decoration:none;
}

.cc-tc{
	border:#1caaf4 solid 1px;
}
.cc-tc td{
	text-align:center;
	color:#0c6fa4;
	font-size:12px;
	padding:10px 10px;
}
.cc-tc td td{
	padding:0px;
}

.preson{
	width:160px;
	margin:0px auto 0px auto;
}
.preson table{
	width:117px;
	border:#348BC1 solid 1px;
}
.preson p{
	margin-top:5px;
}
.preson img{
	width:109px;
	height:auto;
}

.site-map a{
	display:block;
	color:#0c6fa4;
	font-weight:bold;
	background-color:#DEF1FA;
	/*background-color:#1B74DD;*/
	padding:3px 5px 3px 10px;
	margin:4px 1px;
	width:165px;
	font-size:12px;
}
.site-map a:hover{
	text-decoration:none;
	background-color:#E6F4FC;
}
.site-map a.homepage{
	color:#fff;
	background-color:#E5262F;
	text-transform:uppercase;
	text-align:center;
	width:130px;
	padding:5px 0px;
	margin:0px;
}
.site-map a.hdr{
	color:#fff;
	background-color:#E5262F;
	text-transform:uppercase;
}
.site-map th{
	width:150px;
}
.sub-smap a{
	font-weight:normal;
	color:#008ad3;
	background:url(/html/portlet/vcmsview/images/bull_b.gif) 0px 8px no-repeat;
	width:150px;
	margin:0px;
	font-size:11px;
}
.sub-smap a:hover{
	background:none;
}
.sub-smap{
	width:180px;
}
.sub-smap td{
	border-bottom:#EDF5FF solid 1px;
}

.no-m{margin:0px;}
</style>