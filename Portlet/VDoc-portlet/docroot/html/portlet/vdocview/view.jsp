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

<%@page import="javax.portlet.WindowState"%>
<%@page import="com.vportal.portlet.vdoc.service.util.ActionUtil"%>
<%@page import="com.vportal.portlet.vdoc.service.vdocDocumentServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.vportal.portal.service.AttachmentLocalServiceUtil"%>
<%@page import="com.vportal.portal.model.Attachment"%>
<%@ page import="java.util.ArrayList"%>
<%@ include file="/html/portlet/vdocview/init.jsp" %>
<%@ include file="/html/portlet/vdocview/css.jsp" %> 


<%

	/* Xem chi tiet Doc*/
	PortletURL viewURL = renderResponse.createRenderURL();
	viewURL.setParameter("jspPage", "/html/portlet/vdocview/view_doc_detail.jsp");


	
	String fieldId = ParamUtil.getString(request,"fieldId",StringPool.BLANK);
	String orgId = ParamUtil.getString(request,"orgId",StringPool.BLANK);
	String keywords = ParamUtil.getString(request,"keywords",StringPool.BLANK);
	
	String searchFlag = renderRequest.getParameter("cmd-sesarchdoc-flag");
	int styleOrder = ParamUtil.getInteger(request,"styleOrder",3);

	List<vdocDocument> listDoc = new ArrayList<vdocDocument>();
	
	int total = 0;
	total = vdocDocumentServiceUtil.searchDocument(groupId, language, fieldId, orgId,keywords, 2).size();
	
	int currentPage = ParamUtil.getInteger(request, "pagenum", 1);
	int itemPerPage = numberItem;
	int pages = (total % itemPerPage == 0) ? total / itemPerPage : total / itemPerPage + 1;
	
	int begin = itemPerPage * (currentPage - 1);
	int end = (total>itemPerPage * currentPage) ? itemPerPage * currentPage : total;
	
	int beginNextPage = end;
	int endNextPage = ((end+itemPerPage) >=total)?total:end+itemPerPage;
	listDoc = vdocDocumentServiceUtil.searchDocument(groupId, language, fieldId,orgId,keywords, 2, begin, end);
%>

<%
/* Tim kiem Doc */
PortletURL searchURL = renderResponse.createRenderURL();
searchURL.setWindowState(WindowState.NORMAL);
searchURL.setParameter("jspPage","/html/portlet/vdocview/view.jsp");
searchURL.setParameter("cmd-searchdoc-flag","true");
%>
<script>		
function <portlet:namespace />doSearchDocuments() {
	submitForm(document.<portlet:namespace />fm);
};
</script>

<form action="<%= searchURL.toString() %>" name="<portlet:namespace />fm" method="post" >
	<div class="wd-boxs">
		<h2 class="wd-tlh1-2"><%= LanguageUtil.get(pageContext, "portlet.vdoc.view.title") %></h2>
		<div class="wd-introduction">
			<fieldset>
				<div class="wd-form-keyword">
					<div class="wd-asked">
						<div class="wd-input">
							<label for="keyword"><%= LanguageUtil.get(pageContext, "portlet.vdoc.view.name-doc") %>:</label>
							<input type="text" placeholder="Enter text" name="<portlet:namespace/>keywords" value="<%= keywords %>" />
						</div>
						<div class="wd-form-1">
							<label for="asked"><%= LanguageUtil.get(pageContext, "portlet.vdoc.view.select-org") %>:</label>
							<select name="<portlet:namespace />orgId" class="option_org" onchange="javascript:<portlet:namespace />doSearchDocuments();">
								<option value="0">---<liferay-ui:message key="all" />---</option>
								<%			
									out.println(ActionUtil.getOrgTree(groupId,language,orgId,orgId));
								%>
							</select>
						</div>
						<div class="wd-form-1">
							<label for="asked" class="wd-organ"><%= LanguageUtil.get(pageContext, "portlet.vdoc.view.select-field") %>:</label>
							<select name="<portlet:namespace />fieldId" class="option_field" onchange="javascript:<portlet:namespace />doSearchDocuments();">
								<option value="0">---<liferay-ui:message key="all" />---</option>
								<%
									out.println(ActionUtil.getFieldTree(groupId, language, fieldId, fieldId));
								%>
							</select>
						</div>
					</div>
					<div class="wd-submit">
						<input type="button" value="<%= LanguageUtil.get(pageContext, "portlet.vdoc.view.search-button") %>" class="wd-bt-search" 
							onclick="javascript:<portlet:namespace />doSearchDocuments( );"/>
					</div>
				</div>
			</fieldset>
			
			<p class="wd-upper"><%= LanguageUtil.get(pageContext, "portlet.vdoc.title") %></p>
			<div class="wd-table wd-table-three">
				<table cellspacing="0" cellpadding="0">
					<thead>
						<tr>
							<th>STT</th>
							<th>T&#234;n th&#7911; t&#7909;c</th>
							<th>C&#417; quan th&#7921;c hi&#7879;n</th>
						</tr>
					</thead>
					
					<%	if (Validator.isNull(listDoc) || listDoc.size()==0 ){System.out.print("");}else{
						for(int i=0;i<listDoc.size();i++){
								vdocDocument doc = (vdocDocument)listDoc.get(i);		
								viewURL.setParameter("docId",doc.getDocId());
								if(Validator.isNotNull(fieldId)){		
										viewURL.setParameter("fieldId",fieldId);
								}
								if(Validator.isNotNull(orgId)){		
										viewURL.setParameter("orgId",orgId);
								}
										
					%>
					<tbody>
						<tr>
							<td><%=begin+i+1 %></td>
							<td><a href="<%=viewURL%>"><p><%=StringUtil.shorten(doc.getTitle(),100)%></p></a></td>
							<td><p><%= doc.getOrgRels() %></p></td>
						</tr>
						
					</tbody>
					<%}} %>
				</table>
			</div>
			<div class="wd-paging">
			
				<p class="sum-page">T&#7893;ng s&#7889; <%= total %> c&#226;u h&#7887;i / <%=pages %> trang</p>
				<!-- <span>Trang:</span>
				<ul class="yiiPager">
					<li class="first"><a href="#">&nbsp;</a></li>
					<li class="previous"><a href="#">&nbsp;</a></li>
					<li class="page selected"><a href="#">1</a></li>
					<li class="page"><a href="#">2</a></li>
					<li class="page"><a href="#">3</a></li>
					<li class="page"><a href="#">4</a></li>
					<li class="next"><a href="#">&nbsp;</a></li>
					<li class="last"><a href="#">&nbsp;</a>
					</li>
				</ul> -->
			
						<span>Trang:</span>
						<ul class="yiiPager">
						<% 	
							if(pages > 0 && currentPage > 2 ){									
						%> <li class="first">
							<a class="phantrang" href="<liferay-portlet:renderURL > 
										<liferay-portlet:param name= "pagenum" value= "<%= String.valueOf(1) %>"  />  
										<liferay-portlet:param name= "jspPage" value= "/html/portlet/vdocview/view.jsp"  />
										
										<%
										if(Validator.isNotNull(keywords))
										{ 
										%>
											<liferay-portlet:param name= "keywords" value= "<%= keywords %>"  />  
										<%
										} 
										if(Validator.isNotNull(orgId))
										{%>
											<liferay-portlet:param name= "orgId" value= "<%= orgId %>"  />
										<%
										}
										if(Validator.isNotNull(fieldId))
										{
										%>
											  <liferay-portlet:param name= "fieldId" value= "<%= fieldId %>"  />
										<%
										} 
										%>
							  		</liferay-portlet:renderURL>" >&nbsp;</a>
						</li><%	
							}	
						%>
						<%
							if(currentPage > 1){
								int intPrev = currentPage - 1;
						%>
						<li class="previous">	
							<a class="phantrang" href="<liferay-portlet:renderURL > 
										<liferay-portlet:param name= "pagenum" value= "<%= String.valueOf(intPrev) %>"  />  
										<liferay-portlet:param name= "jspPage" value= "/html/portlet/vdocview/view.jsp"  />
										
										<%
										if(Validator.isNotNull(keywords))
										{ 
										%>
											<liferay-portlet:param name= "keywords" value= "<%= keywords %>"  />  
										<%
										} 
										if(Validator.isNotNull(orgId))
										{%>
											<liferay-portlet:param name= "orgId" value= "<%= orgId %>"  />
										<%
										}
										if(Validator.isNotNull(fieldId))
										{
										%>
											  <liferay-portlet:param name= "fieldId" value= "<%= fieldId %>"  />
										<%
										} 
										%>
							  		</liferay-portlet:renderURL>" >&nbsp;</a>
						</li>				
						<%
							} 
						%>
						<%
							for(int i = 1; i <= pages; i++)
							{
								if(i == currentPage)
								{
						%>
								<li class="page selected">	
								<a class="phantrang" href="<liferay-portlet:renderURL > 
										<liferay-portlet:param name= "pagenum" value= "<%= String.valueOf(i) %>"  />  
										<liferay-portlet:param name= "jspPage" value= "/html/portlet/vdocview/view.jsp"  />
									
										<%
										if(Validator.isNotNull(keywords))
										{ 
										%>
											<liferay-portlet:param name= "keywords" value= "<%= keywords %>"  />  
										<%
										} 
										if(Validator.isNotNull(orgId))
										{%>
											<liferay-portlet:param name= "orgId" value= "<%= orgId %>"  />
										<%
										}
										if(Validator.isNotNull(fieldId))
										{
										%>
											  <liferay-portlet:param name= "fieldId" value= "<%= fieldId %>"  />
										<%
										} 
										%>
							  		</liferay-portlet:renderURL>" ><%= i %></a>
							</li>
							<%
								}
								else if(i > currentPage && i < currentPage+5)
								{
							%>
							<li class="page">	
								<a class="phantrang" href="<liferay-portlet:renderURL > 
										<liferay-portlet:param name= "pagenum" value= "<%= String.valueOf(i) %>"  />  
										<liferay-portlet:param name= "jspPage" value= "/html/portlet/vdocview/view.jsp"  />
										<%
										if(Validator.isNotNull(keywords))
										{ 
										%>
											<liferay-portlet:param name= "keywords" value= "<%= keywords %>"  />  
										<%
										} 
										if(Validator.isNotNull(orgId))
										{%>
											<liferay-portlet:param name= "orgId" value= "<%= orgId %>"  />
										<%
										}
										if(Validator.isNotNull(fieldId))
										{
										%>
											  <liferay-portlet:param name= "fieldId" value= "<%= fieldId %>"  />
										<%
										} 
										%>
							  		</liferay-portlet:renderURL>" ><%= i %></a>
							</li>
							<%
								}
							}
							%>
							<%
								if(currentPage < pages)
								{
									int intNext = currentPage + 1;
							%>
							 <li class="next">	
								<a class="phantrang" href="<liferay-portlet:renderURL > 
										<liferay-portlet:param name= "pagenum" value= "<%= String.valueOf(intNext) %>"  />  
										<liferay-portlet:param name= "jspPage" value= "/html/portlet/vdocview/view.jsp"  />
										<%-- <liferay-portlet:param name= "currentPage" value= "<%= String.valueOf(currentPage+1) %>"  /> --%>
										<%
										if(Validator.isNotNull(keywords))
										{ 
										%>
											<liferay-portlet:param name= "keywords" value= "<%= keywords %>"  />  
										<%
										} 
										if(Validator.isNotNull(orgId))
										{%>
											<liferay-portlet:param name= "orgId" value= "<%= orgId %>"  />
										<%
										}
										if(Validator.isNotNull(fieldId))
										{
										%>
											  <liferay-portlet:param name= "fieldId" value= "<%= fieldId %>"  />
										<%
										} 
										%>
							  		</liferay-portlet:renderURL>" >&nbsp;</a>
							</li>	
					
					<%
						}
					%> 	
					<% 	
						if(pages > 10 && currentPage != pages){
					%> <li class="last"><a class="phantrang" href="<liferay-portlet:renderURL > 
										<liferay-portlet:param name= "jspPage" value= "/html/portlet/vdocview/view.jsp"  />
										<liferay-portlet:param name= "pagenum" value= "<%= String.valueOf(pages) %>"  />
										<%
										if(Validator.isNotNull(keywords))
										{ 
										%>
											<liferay-portlet:param name= "keywords" value= "<%= keywords %>"  />  
										<%
										} 
										if(Validator.isNotNull(orgId))
										{%>
											<liferay-portlet:param name= "orgId" value= "<%= orgId %>"  />
										<%
										}
										if(Validator.isNotNull(fieldId))
										{
										%>
											  <liferay-portlet:param name= "fieldId" value= "<%= fieldId %>"  />
										<%
										} 
										%>
							  		</liferay-portlet:renderURL>" >&nbsp;</a>
					</li>	
					<%	
						}	
					%>	
					</ul>
			
			</div>
		</div>
	</div>
</form>







