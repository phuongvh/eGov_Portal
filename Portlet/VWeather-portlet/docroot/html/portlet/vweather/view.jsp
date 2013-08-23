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
<%@page import="com.vportal.portlet.rate.action.Exrate"%>
<%@page import="com.vportal.portlet.rate.action.ExrateUtil"%>
<%@page import="com.vportal.portlet.vweather.action.GoldItem"%>
<%@page import="com.vportal.portlet.vweather.action.City"%>
<%@page import="com.vportal.portlet.vweather.action.GoldUtil"%>
<%@page import="com.vportal.portlet.vweather.action.GoldXml"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/html/portlet/vweather/init.jsp"%>
<%@ page import="com.vportal.portlet.vweather.action.WeatherUtil"%>
<%@include file="/init.jsp"%>

<%
	String error = "Hiện tại máy chủ cung cấp dữ liệu đang bận, vui lòng thử lại sau!";
	if (displayStyle.equals("1")) {
		renderResponse.setTitle("DỰ BÁO THỜI TIẾT");	
%>

<script type="text/javascript" 
	src="http://rilwis.googlecode.com/svn/trunk/weather.min.js">
</script>

<div id="ddd">
	
				 <h4>Hà Nội</h4>
				 <script type="text/javascript">
				  	showWeather('hanoi, vietnam');
				 </script>
				 <br/>
				 
				 <h4>Đà Nẵng</h4>
				 <script type="text/javascript">
				  	showWeather('danang, vietnam');
				 </script>
				 <br/>
				 
				 <h4>TP Hồ Chí Minh</h4>
				 <script type="text/javascript">
				 	showWeather('hochiminh, vietnam');
				 </script>
				 <br/>
	
</div>

<%
	}else if(displayStyle.equals("2")) {
		renderResponse.setTitle("GIÁ VÀNG TRONG NƯỚC");	
%>

<% 	
	City [] cities = GoldUtil.getAllCity("http://www.sjc.com.vn/xml/tygiavang.xml");

%>
<table cellspacing="0" cellpadding="0">
	<thead>
		<tr class="wd-even">
					<td>&nbsp; &nbsp; </td>
					<td>&nbsp; &nbsp; Loại Vàng</td>
					<td>&nbsp; &nbsp; Mua</td>
					<td>&nbsp; &nbsp; Bán</td>
		</tr>
				<%
				for(int i=0; i<cities.length; i++)
				{
				%>
				
		<tr class="wd-even">
			<td colspan="4">&nbsp; &nbsp; <%= cities[i].getName() %></td>
		</tr>
					<%
						GoldItem [] item = new GoldItem[cities[i].getGolds().size()];
						for(int k=0; k<item.length; k++)
							item[k] = cities[i].getGolds().get(k);
						if(item != null && item.length>0)
							for(int j=0; j<item.length; j++)
							{
					%>
					<tr class="wd-even">
						<td>&nbsp; &nbsp; </td>
						<td>&nbsp; &nbsp; <%= item[j].getType() %></td>
						<td style="padding-left: 10px;"><%= item[j].getBuy() %></td>
						<td style="padding-left: 10px;"><%= item[j].getSell() %></td>
					</tr>
					<%
							}
					%>
				</tr>
				<%
				}
				%>
			
	</thead>
</table>

<%
	}else if(displayStyle.equals("3")){
		renderResponse.setTitle("TỈ GIÁ");	
%>
<% 
// 	List<Exrate> rate = ExrateUtil.getRate("http://vietcombank.com.vn/ExchangeRates/ExrateXML.aspx");
// 	Exrate [] arrRate = new Exrate[rate.size()];
// 	for(int i=0; i<rate.size(); i++)
// 		arrRate[i] = rate.get(i);
// 	String dateUpdated = ExrateUtil.getDateUpdated();
// 	String source = ExrateUtil.getSource();
	
	ExrateUtil.ConvertText("http://vietcombank.com.vn/ExchangeRates/ExrateXML.aspx");
	String [] code = ExrateUtil.getCode();
	String [] name = ExrateUtil.getName();
	String [] buy = ExrateUtil.getBuy();
	String [] transfer = ExrateUtil.getTransfer();
	String [] sell = ExrateUtil.getSell();
	
%>


			<table id="Rate" width="100%" cellspacing="1" cellpadding="6" bordercolor="#ccc" border="1">
				<tr height='20'>
					<td>&nbsp; &nbsp; Mã NT</td>
<!-- 					<td>&nbsp; &nbsp; Tên Ngoại tệ</td> -->
					<td>&nbsp; &nbsp; Mua tiền mặt</td>
					<td>&nbsp; &nbsp; Mua chuyển khoản</td>
					<td>&nbsp; &nbsp; Bán</td>
				</tr>
				<%
				for(int i=0; i<code.length; i++)
				{
				%>
				<tr height='20'>
					<td>&nbsp; &nbsp; <%=code[i].equals("0") ? "-" : code[i] %></td>
<%-- 					<td>&nbsp; &nbsp; <%=name[i].equals("0") ? "-" : name[i] %></td> --%>
					<td>&nbsp; &nbsp; <%=buy[i].equals("0") ? "-" : buy[i] %></td>
					<td>&nbsp; &nbsp; <%=transfer[i].equals("0") ? "-" : transfer[i]%></td>
					<td>&nbsp; &nbsp; <%=sell[i].equals("0") ? "-" : sell[i] %></td>
				</tr>	
				<%
				}
				%>
			</table>


<%
	}
%>

