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
<%@page
	import="com.vportal.portlet.edirectory.service.EDFunctionDepartmentLocalServiceUtil"%>
<%@page
	import="com.vportal.portlet.edirectory.model.EDFunctionDepartment"%>
<%@page
	import="com.vportal.portlet.edirectory.service.EDFunctionServiceUtil"%>
<%@page import="com.vportal.portlet.edirectory.model.EDFunctionEmployee"%>
<%@page
	import="com.vportal.portlet.edirectory.service.EDFunctionEmployeeLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page
	import="com.vportal.portlet.edirectory.model.impl.EDDepartmentImpl"%>
<%@page
	import="com.vportal.portlet.edirectory.service.EDEmployeeLocalServiceUtil"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/html/content_edirectory/init.jsp"%>
<%@include file="/html/content_edirectory/css.jsp"%>
<portlet:defineObjects />

<%
	String language = ParamUtil.getString(request, "language", "vi_VN");
		long groupId = themeDisplay.getPortletGroupId();
		//System.out.println("GroupId View: " + groupId);
		/* Tim kiem Doc */
		PortletURL searchURL = renderResponse.createRenderURL();
		searchURL.setParameter("jspPage","/html/content_edirectory/view.jsp");
		searchURL.setParameter("language", language);		
		searchURL.setParameter("groupId", String.valueOf(groupId));
		
		
		String style = prefs.getValue("style", "default");
		long depId = ParamUtil.getLong(request, "depId");
		long functionId= ParamUtil.getLong(request, "functionId");
		
		if (style.equals("style3") && depId==0){
	depId=68105;
		}
		
		//System.out.println("Dep ID: " + depId);
		
		
		String name = ParamUtil.getString(request, "name", StringPool.BLANK);
		String phone = ParamUtil.getString(request, "phone", StringPool.BLANK);
		String email = ParamUtil.getString(request, "email", StringPool.BLANK);
		
		List<EDFunction> functionList = EDFunctionLocalServiceUtil.getAllFunction();
		List<EDDepartment> departmentList = EDDepartmentLocalServiceUtil.getByParent(0);
		
		// lay danh sach phong ban con
		List<EDDepartment> departmentListChild = EDDepartmentLocalServiceUtil.getByParent(1);
	

		boolean test = true;
		int total = 0;
		int numberPage = numberItem;
		int per = numberPage;
		int pages = 0	;
		int currentPage = ParamUtil.getInteger(request, "pagenum", 1);
		int begin = 0;
		int end = 0;
		
		List<EDEmployee> lstSearchEmployee = EDEmployeeLocalServiceUtil.searchEmployeeByDepartmentNamePhoneEmail(groupId, language, depId, name, phone, email);
		
		
		List<EDEmployee> employeeList = null;
		total = lstSearchEmployee.size();
		
		pages = (total % per == 0) ? total / per : total / per + 1;
		begin = per * (currentPage - 1);
		end = (total>per * currentPage) ? per * currentPage : total;
		employeeList = lstSearchEmployee.subList(begin, end);
		
		PortletURL renderURL = renderResponse.createRenderURL();
		renderURL.setParameter("jspPage", "/html/content_edirectory/view.jsp");
%>

<script type="text/javascript">		
	function <portlet:namespace />doSearchDocuments() {
		submitForm(document.<portlet:namespace />fm, '<%=searchURL%>');
	}
</script>

<portlet:renderURL var="searchDoc">
	<portlet:param name="jspPage" value="/html/content_edirectory/view.jsp" />
</portlet:renderURL>

<div class="wd-boxs">
	<h2 class="wd-tlh1-2"><%=(titlePortlet.equals("")) ? LanguageUtil.get(pageContext, "portlet.vdoc.view.title") : titlePortlet.toString()%></h2>


	<!-- Form tim kiem -->
	<div class="wd-introduction">
		<div class="wd-form-search-main">
			<form name="<portlet:namespace />fm" Method="post">
				<input type="hidden" name="<portlet:namespace/>cmd" value="" />
				<fieldset>

					<!-- Don vi -->
					<div class="wd-input">
						<label><%=LanguageUtil.get(pageContext, "portlet.vdoc.view.select-org")%></label>
						<select name="<portlet:namespace />depId"
							onchange="<portlet:namespace />submitForm();">
							<option value="0">
								---
								<liferay-ui:message
									key="managecontacts.staff.view-select.all-agency" />
								---
							</option>
							<%
								for(EDDepartment dep : departmentList){
							%>
							<option value="<%=dep.getId()%>"
								<%=dep.getId() == depId ? "selected" : ""%>>
								<%=dep.getName()%>
							</option>
							<%
								List<EDDepartment> subDepList = EDDepartmentLocalServiceUtil.getByParent(dep.getId());
								  					if(subDepList.size() > 0)
								  					for(EDDepartment dep2 : subDepList){
							%>
							<option value="<%=dep2.getId()%>"
								<%=dep2.getId() == depId ? "selected" : ""%>>
								&nbsp;&nbsp;&nbsp;&nbsp;<%=dep2.getName()%>
							</option>
							<%
								}
							%>
							<%
								}
							%>
						</select>
					</div>

					<!-- Ho va ten -->
					<div class="wd-input">
						<label><%=LanguageUtil.get(pageContext, "portlet.vdoc.view.name-doc")%></label>
						<input type="text" name="<portlet:namespace/>name"
							value="<%=name%>">
					</div>

					<!-- Điện thoại -->
					<div class="wd-input">
						<label><%=LanguageUtil.get(pageContext, "content.contact.phone")%></label>
						<input type="text" name="<portlet:namespace/>phone"
							value="<%=phone%>" />
					</div>


					<!-- Email -->
					<div class="wd-input">
						<label><%=LanguageUtil.get(pageContext, "content.contact.table.email")%></label>
						<input type="text" name="<portlet:namespace/>email"
							value="<%=email%>" />
					</div>


					<!-- Nút tìm kiếm -->
					<div class="wd-button">
						<input type="button" value="Tìm kiếm"
							onclick="<portlet:namespace />submitForm();">
					</div>

				</fieldset>

			</form>
			<%
				//End form search
			%>

			<div class="wd-result">
				<a class="wd-print" href="javascript:print()">Print</a>
				<!-- 			<h4 class="wd-title">Văn phòng</h4> -->


				<!-- 				<p> -->
				<!-- 					<strong>Địa chỉ: </strong>Số 9 phố Ngô Quyền Quận Hoàn Kiếm, Hà Nội -->
				<!-- 				</p> -->
				<!-- 				<p> -->
				<!-- 					<strong>Điện thoại: </strong>38258150 - <strong> Fax:</strong>38252559 -->
				<!-- 				</p> -->
				<p class="wd-upper">Danh Bạ</p>

				<table>
					<thead>
						<tr>
							<td width="40" rowspan="2">STT</td>
							<td width="130" rowspan="2">Họ và tên</td>
							<td width="150" rowspan="2">Chức danh</td>
							<td colspan="3">Điện thoại</td>
							<td rowspan="2">Email</td>
						</tr>
						<tr>
							<td>Cơ quan</td>
							<td>Nhà riêng</td>
							<td>Di động</td>
						</tr>
					</thead>


					<!-- Tu trang conntent_edirectory/view.jsp ===>  mot trong cac trang sau-->
					<form>
						<c:if test="<%=style.equals(\"default\")%>">
							<%@ include file="/html/content_edirectory/includes/default.jsp"%>
						</c:if>
						<c:if test="<%=style.equals(\"style1\")%>">
							<%@ include file="/html/content_edirectory/includes/style1.jsp"%>
						</c:if>
						<c:if test="<%=style.equals(\"style2\")%>">
							<%@ include file="/html/content_edirectory/includes/style2.jsp"%>
						</c:if>
						<c:if test="<%=style.equals(\"style3\")%>">
							<%@ include file="/html/content_edirectory/includes/style3.jsp"%>
						</c:if>

						<!-- Phan trang -->


					</form>
				</table>
			</div>
		</div>
		<div class="wd-paging">
			<p class="sum-page">
				Tổng số
				<%=total%>
				cán bộ /
				<%=pages%>
				trang
			</p>
			<span>Trang:</span>
			<ul class="yiiPager">
				<!-- Trang dau tien  -->
				<%
					if(pages > 0 && currentPage > 4){
				%>
				<li class="first"><a href="<%=renderURL%>"> <%
 	renderURL.setParameter("pagenum", String.valueOf(1));
 		if(Validator.isNotNull(email))
 		{
 			renderURL.setParameter("email", email);
 		}
 		if(Validator.isNotNull(phone))
 		{
 			renderURL.setParameter("phone", phone);
 		}
 		if(Validator.isNotNull(name))
 		{ 
 			renderURL.setParameter("name", name);
 		} 
 		if(Validator.isNotNull(depId))
 		{
 			renderURL.setParameter("depId", String.valueOf(depId));
 		}
 %>

				</a></li>

				<%
					}
				%>
				<!-- Trang truocdo -->
				<%
					if(currentPage > 1){
							int intPrev = currentPage - 1;
				%>
				<li class="previous"><a href="<%=renderURL%>"> <%
 	renderURL.setParameter("pagenum", String.valueOf(intPrev));
 			if(Validator.isNotNull(email))
 			{
 				renderURL.setParameter("email", email);
 			}
 			if(Validator.isNotNull(phone))
 			{
 				renderURL.setParameter("phone", phone);
 			}
 			if(Validator.isNotNull(name))
 			{ 
 				renderURL.setParameter("name", name);
 			} 
 			if(Validator.isNotNull(depId))
 			{
 				renderURL.setParameter("depId", String.valueOf(depId));
 			}
 %>
				</a></li>
				<%
					}
				%>

				<!-- Trang dang chon  -->
				<%
					for(int i = 1; i <= pages; i++)
							{
								renderURL.setParameter("pagenum", String.valueOf(i));
								if(i == currentPage)
								{//Nếu trang nào được chọn hiển thị màu khác
				%>
				<li class="page selected"><a href="<%=renderURL%>"><%=i%>
						<%
							if(Validator.isNotNull(email))
									{
										renderURL.setParameter("email", email);
									}
									if(Validator.isNotNull(phone))
									{
										renderURL.setParameter("phone", phone);
									}
									if(Validator.isNotNull(name))
									{ 
										renderURL.setParameter("name", name);
									} 
									if(Validator.isNotNull(depId))
									{
										renderURL.setParameter("depId", String.valueOf(depId));
									}
						%> </a></li>

				<!-- Cac trang trong tong so co -->
				<%
					}else if(i > currentPage - 5 && i < currentPage || i > currentPage && i <currentPage +5)//Ngược lại những trang nào không được chọn sẽ hiển thị một màu 
								//if(i != currentPage)
							{
				%>
				<li class="page"><a href="<%=renderURL%>"><%=i%> <%
 	if(Validator.isNotNull(email))
 			{
 				renderURL.setParameter("email", email);
 			}
 			if(Validator.isNotNull(phone))
 			{
 				renderURL.setParameter("phone", phone);
 			}
 			if(Validator.isNotNull(name))
 			{ 
 				renderURL.setParameter("name", name);
 			} 
 			if(Validator.isNotNull(depId))
 			{
 				renderURL.setParameter("depId", String.valueOf(depId));
 			}
 %> </a></li>

				<!-- Trang ke tiep -->
				<%
					}//end if else
						}//end for
						if(currentPage < pages)	//start if A01
						{
							int intNext = currentPage + 1;
				%>

				<li class="next"><a href="<%=renderURL%>"> <%
 	renderURL.setParameter("pagenum", String.valueOf(intNext));
 			if(Validator.isNotNull(email))
 			{
 				renderURL.setParameter("email", email);
 			}
 			if(Validator.isNotNull(phone))
 			{
 				renderURL.setParameter("phone", phone);
 			}
 			if(Validator.isNotNull(name))
 			{ 
 				renderURL.setParameter("name", name);
 			} 
 			if(Validator.isNotNull(depId))
 			{
 				renderURL.setParameter("depId", String.valueOf(depId));
 			}
 %>
				</a></li>

				<!-- Trang cuoi -->
				<%
					}
							if(pages > 10 && currentPage != pages){
				%>
				<li class="last"><a href="<%=renderURL%>"> <%
 	if(Validator.isNotNull(email))
 			{
 				renderURL.setParameter("email", email);
 			}
 			if(Validator.isNotNull(phone))
 			{
 				renderURL.setParameter("phone", phone);
 			}
 			if(Validator.isNotNull(name))
 			{ 
 				renderURL.setParameter("name", name);
 			} 
 			if(Validator.isNotNull(depId))
 			{
 				renderURL.setParameter("depId", String.valueOf(depId));
 			}
 %>
				</a></li>

				<%
					}
				%>

			</ul>
		</div>
	</div>
</div>


<script type="text/javascript">		
	function <portlet:namespace/>submitForm(){
		var myform = document.<portlet:namespace />fm;
		myform.action="<%=searchURL.toString()%>";
		myform.submit();
	}
</script>
