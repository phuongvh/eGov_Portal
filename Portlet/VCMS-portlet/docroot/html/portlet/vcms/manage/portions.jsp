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
	 * Copyright (c) 2000-2006 Liferay, Inc. All rights reserved.
	 *
	 * Permission is hereby granted, free of charge, to any person obtaining a copy
	 * of this software and associated documentation files (the "Software"), to deal
	 * in the Software without restriction, including without limitation the rights
	 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
	 * copies of the Software, and to permit persons to whom the Software is
	 * furnished to do so, subject to the following conditions:
	 *
	 * The above copyright notice and this permission notice shall be included in
	 * all copies or substantial portions of the Software.
	 *
	 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
	 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
	 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
	 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
	 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
	 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
	 * SOFTWARE.
	 */
%>
<%@ page
	import="com.vportal.portlet.vcms.service.VcmsPortionServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page
	import="com.vportal.portlet.vcms.service.VcmsCategoryServiceUtil"%>
<%@ page import="com.vportal.portlet.vcms.DeletePortionException"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<%@ page import="com.vportal.portlet.vcms.action.ActionUtil"%>
<%
	/* boolean showAddPortionButton = showButtons && PortletPermissionUtil.contains(permissionChecker, plid.longValue(),PortletKeysExt.VCMS,ActionKeysExt.ADD_PORTION); */
	boolean showAddPortionButton = true;
%>
<liferay-ui:error exception="<%=DeletePortionException.class%>"
	message="portlet.vcms.portion.exception.you-cannot-delete-a-portion-which-contains-entries" />
<c:if test="<%=showAddPortionButton%>">
	<input class="portlet-form-button" type="button"
		value='<%=LanguageUtil.get(pageContext,
						"portlet.vcms.button.add")%>'
		onClick="javascript:<portlet:namespace />updatePortion('<%=Constants.ADD%>', true);" />
</c:if>
<br />
<br />
<liferay-ui:search-container
	emptyResultsMessage="<%=LanguageUtil.get(pageContext,\"portlet.vcms.tabs.viewportion\")%>" delta="5"
	iteratorURL="<%=portletURL%>">
	<liferay-ui:search-container-results
		results="<%=VcmsPortionServiceUtil.getPortionsByS_L(groupId,
						language, searchContainer.getStart(),
						searchContainer.getEnd())%>"
		total="<%=VcmsPortionServiceUtil.countPortionsByS_L(groupId,
						language)%>" />

	<liferay-ui:search-container-row
		className="com.vportal.portlet.vcms.model.VcmsPortion"
		escapedModel="<%=false%>" keyProperty="portionId" modelVar="portion">
		<%
			PortletURL rowURL = renderResponse.createRenderURL();
					rowURL.setParameter("jspPage",
							"/html/portlet/vcms/manager/edit_portion.jsp");
					rowURL.setParameter("redirect", currentURL);
					rowURL.setParameter("portionId",
							String.valueOf(portion.getPortionId()));
		%>
		<%-- 	<portlet:renderUrl var="rowURL" >
			<portlet:param name="jspPage" value="/html/portlet/vcms/manager/edit_portion.jsp"/>
			<portlet:param name="redirect" value="<%=currentURL %>"/>
			<portlet:param name="portionId" value="<%=String.valueOf(portion.getPortionId()) %>"/>
		</portlet:renderUrl> --%>
		<%
			rowURL.setParameter("row_portionid", portion.getPortionId());
					StringBuffer name = new StringBuffer();

					name.append("<img class = 'a' src='"
							+ themeDisplay.getPathThemeImage()
							+ "/vcms/portion.gif'/>");
					name.append("<a style='text-decoration:none' href='#' onclick='window.location.href=\""
							+ rowURL.toString()
							+ "\"'><b>"
							+ portion.getName()
							+ "</b></a><br>");
					
					List<VcmsCategory> children = VcmsCategoryServiceUtil
							.getCategoriesByP_P(groupId,
									portion.getPortionId(),
									ActionUtil.DEFAULT_CATEGORY_ID, language);

					if (children.size() > 0) {

						name.append("<img class='a' src='"
								+ themeDisplay.getPathThemeImage()
								+ "/vcms/children.gif'/>");
						name.append("<b style = 'text-decoration: underline;padding-right:10px'>"
								+ pageContext + ":</b>");
						for (VcmsCategory vcms : children) {
							rowURL.setParameter("row_categoryid",
									vcms.getCategoryId());
							name.append("<a style='text-decoration:none' href='#' onclick='window.location.href=\""
									+ rowURL.toString()
									+ "\"'>"
									+ vcms.getName() + "</a>,");
						}
						name.deleteCharAt(name.length() - 1);
					}
		%>
		<liferay-ui:search-container-column-text href="<%=rowURL%>"
			name="<%=LanguageUtil.get(pageContext,\"portlet.vcms.portion.list.name\")%>"
			value="<%=name.toString()%>" />
		<liferay-ui:search-container-column-text href="<%=rowURL%>"
			name="<%=LanguageUtil.get(pageContext,\"portlet.vcms.portion.list.code\")%>"
			property="code" />

		<liferay-ui:search-container-column-jsp align="right"
			path="/html/portlet/vcms/portion_action.jsp" valign="top" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

