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
<%
/**
 * Copyright (c) 2000-2008 VietSoftware, Inc. All rights reserved.
 */
%>
<%@ include file="init.jsp" %>
	
<%
String language = themeDisplay.getLanguageId();
List listPortion = VcmsPortionServiceUtil.getPortionsByS_L(groupId, language);

int arrangement = (Integer)request.getAttribute(ConstantsExt.ARRANGEMENT);
int numberOfNews = (Integer)request.getAttribute(ConstantsExt.NUMBER_OF_NEWS);
int displayNews = (Integer)request.getAttribute(ConstantsExt.DISPLAY_NEWS);
int nextNewByNewest = (Integer)request.getAttribute(ConstantsExt.NEXT_NEWS_BY_NEWEST);
int nextNewByOrder = (Integer)request.getAttribute(ConstantsExt.NEXT_NEWS_BY_ORDER);
int nextNewByInFlow = (Integer)request.getAttribute(ConstantsExt.NEXT_NEWS_BY_IN_FLOW);
boolean pagingDisplay = (Boolean)request.getAttribute(ConstantsExt.PAGING_DISPLAY);
int pagingStyle = (Integer)request.getAttribute(ConstantsExt.PAGING_STYLE);
boolean stickedNews = (Boolean)request.getAttribute(ConstantsExt.STICKED_NEWS);
int numberOfStickedNews = (Integer)request.getAttribute(ConstantsExt.NUMBER_OF_STICKED_NEWS);
int displayStyle = (Integer)request.getAttribute(ConstantsExt.DISPLAY_STYLE);
String[][] categoryList = (String[][])request.getAttribute("categoryDisplay");
List listLayout = (List)request.getAttribute(ConstantsExt.LIST_LAYOUT);

PortletURL actionURL = renderResponse.createActionURL();
actionURL.setParameter("jspPage","/html/portlet/vcmsview/edit.jsp" );
actionURL.setParameter("cmd", "update");


PortletURL redirectURL = renderResponse.createRenderURL();
redirectURL.setWindowState(WindowState.MAXIMIZED);
redirectURL.setParameter("jspPage","/html/portlet/vcmsview/edit.jsp");
redirectURL.setParameter("portletResource", portletResource);
%>
<style type="text/css">
.vcmsview_title {
	background:#CCCCCC none repeat scroll 0%;
	color:#000000;
	font-weight:bold;
	height:30px;
	list-style-image:none;
	list-style-position:outside;
	list-style-type:none;
}
.vcmsview_title div {
	border:1px solid #FFFFFF;
	float:left;
	height:30px;
	list-style-type:none;
	text-align:center;
}
.vcmsview_portion div {
	border:1px solid #FFFFFF;
	float:left;
	height:30px;
	list-style-type:none;
	text-align: left;
}
.vcmsview_category, .vcmsview_portion {
	height: 30px;	
}
.vcmsview_category div {
	border:1px solid #FFFFFF;
	float:left;
	height:30px;
	list-style-type:none;
	text-align: left;
}
</style>
<form action="<%= actionURL %>" method="post">
	<input type="hidden" name="redirect" value="<%= redirectURL %>" />
	<div class="vcmsview_title">Cau hinh chung</div>
	<ul>
		<li><strong>Sap xep:</strong></li>
		<li><input type="radio" name="arrangement" value="1"<%= arrangement == 1 ? "checked" : "" %> />Ngay tao tin</li>
		<li><input type="radio" name="arrangement" value="2"<%= arrangement == 2 ? "checked" : "" %> />Ngay sua tin</li>
		<li><input type="radio" name="arrangement" value="3"<%= arrangement == 3 ? "checked" : "" %> />Ngay xuat ban tin</li>
	</ul>
	<%--
		<div>Xem tung chuyen muc:</div>
		<ul>
			<li>So tin hien thi: <input type="text" name="numberOfNews" value="<%= numberOfNews %>" /></li>
			<li>So tin hien thi mo ta: <input type="text" name="displayNews" value="<%= displayNews %>" /></li>
		</ul>
		<div>Xem chi tiet tin:</div>
		<ul>
			<li>So tin moi nhat: <input type="text" name="nextNewByNewest" value="<%= nextNewByNewest %>" /></li>
			<li>So tin tiep theo: <input type="text" name="nextNewByOrder" value="<%= nextNewByOrder %>" /></li>
			<li>So tin trong luong: <input type="text" name="nextNewByInFlow" value="<%= nextNewByInFlow %>" /></li>
		</ul>
		<div>Phan trang</div>
		<ul>
			<li>Hien thi phan trang: <input type="checkbox" name="pagingDisplay" value="true"<%= pagingDisplay ? "checked=\"true\"" : "" %> /></li>
			<li>Kieu phan trang:
			<select name="pagingStyle" />
				<option value="1"<%= pagingStyle == 1? "checked" : "" %>>Style 1</option>
				<option value="2"<%= pagingStyle == 2? "checked" : "" %>>Style 2</option>
				<option value="3"<%= pagingStyle == 3? "checked" : "" %>>Style 3</option>
				<option value="4"<%= pagingStyle == 4? "checked" : "" %>>Style 4</option>
			</select>
			</li>
		</ul>
	--%>
		<div>Mo ra tren trang moi:
			<select name="openNewTab">
				<option value="0"> - </option>
				<% 
					for (int i = 0; i < listLayout.size(); i++) { 
						Layout openLayout = (Layout)listLayout.get(i);
				%>
				<option value="<%= openLayout.getPlid() %>"<%= openNewTab == openLayout.getPlid() ? "selected=\"true\"" : "" %>><%= openLayout.getHTMLTitle(language) %></option>
				<% } %>
			</select>

	<div class="vcmsview_title">Tin treo dau trang</div>
	<ul>
		<li>Hien thi / an: <input type="checkbox" name="stickedNews" value="true"<%= stickedNews ? "checked=\"true\"" : "" %> /></li>
		<li>So tin hien thi: <input type="text" name="numberOfStickedNews" value="<%= numberOfStickedNews %>" /></li>
	</ul>
	<div class="vcmsview_title">
		<div style="width: 59%">Chuyen muc</div>
		<div style="width: 20%">So tin</div>
		<div style="width: 20%; border-right: none;">Tin hieu mo ta</div>
	</div>
<%
	for (int i = 0; i < listPortion.size(); i++) {
		VcmsPortion portion = (VcmsPortion)listPortion.get(i);
%>
		<div class="vcmsview_portion">
			<div style="width: 59%"><%= portion.getName() %></div>
			<div style="width: 20%"></div>
			<div style="width: 20%"></div>
		</div>
		<%
		List listCategory = VcmsCategoryServiceUtil.getCategoriesByPortion(groupId, portion.getPortionId(), language);
		for (int j = 0; j < listCategory.size(); j++) {
			VcmsCategory category = (VcmsCategory)listCategory.get(j);
			String categoryId = category.getCategoryId();
			int categoryIndex = -1;
			
			for (int k = 0; k < categoryList.length; k++) {
				String selectedCategory = categoryList[k][0];
				if (categoryId.equals(selectedCategory)) {
					categoryIndex = k;
					break;
				}
			}
			if (categoryIndex != -1) {
		%>
				<div class="vcmsview_category">
					<div style="width: 59%">
						<input type="checkbox" name="categoryId" value="<%= categoryId %>" checked="true" />
						<%= category.getName() %>
					</div>
					<div style="width: 20%">
						<input type="text" name="articleText_<%= categoryId %>" value="<%= categoryList[categoryIndex][1] %>" style="width: 30px;"/>
					</div>
					<div style="width: 20%">
						<input type="text" name="articleNoText_<%= categoryId %>" value="<%= categoryList[categoryIndex][2] %>" style="width: 30px;"/>
					</div>
				</div>
		<%
			} else {
		%>
				<div class="vcmsview_category">
					<div style="width: 59%">
						<input type="checkbox" name="categoryId" value="<%= categoryId %>" />
						<%= category.getName() %>
					</div>
					<div style="width: 20%">
						<input type="text" name="articleText_<%= categoryId %>" value="" style="width: 30px;"/>
					</div>
					<div style="width: 20%">
						<input type="text" name="articleNoText_<%= categoryId %>" value="" style="width: 30px;"/>
					</div>
				</div>
		
		<%
			}
		}
	}
	
%>
	<div class="vcmsview_title">Kieu hien thi </div>
	<ul>
		<li><input type="radio" name="displayStyle" value="1"<%= displayStyle == 1 ? "checked" : "" %> />Kieu 1: </li>
		<li><input type="radio" name="displayStyle" value="2"<%= displayStyle == 2 ? "checked" : "" %> />Kieu 2: </li>
	</ul>

	<div>
		<input type="submit" value="Submit" />
	</div>
	<div>
		<input type="button" value="Cancel" />
	</div>
</form>