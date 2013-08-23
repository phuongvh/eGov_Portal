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

<%@include file="/html/portlet/vdocmenu/init.jsp" %>
<%@include file="/html/portlet/vdocmenu/css.jsp" %>

<html>
	<head>
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
		<script type="text/javascript">
			//Initialize Arrow Side Menu:
			ddaccordion.init({
				headerclass: "menuheaders", //Shared CSS class name of headers group
				contentclass: "menucontents", //Shared CSS class name of contents group
				revealtype: "clickgo", //Reveal content when user clicks or onmouseover the header? Valid value: "click", or "mouseover"
				mouseoverdelay: 200, //if revealtype="mouseover", set delay in milliseconds before header expands onMouseover
				collapseprev: true, //Collapse previous content (so only one open at any time)? true/false 
				defaultexpanded: [0], //index of content(s) open by default [index1, index2, etc]. [] denotes no content.
				onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)
				animatedefault: false, //Should contents open by default be animated into view?
				persiststate: true, //persist state of opened contents within browser session?
				toggleclass: ["unselected", "selected"], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
				togglehtml: ["none", "", ""], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
				animatespeed: 500, //speed of animation: integer in milliseconds (ie: 200), or keywords "fast", "normal", or "slow"
				oninit:function(expandedindices){ //custom code to run when headers have initalized
					//do nothing
				},
				onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
					//do nothing
				}
				});
		</script>

	
		
	</head>
	
	<body>
<%-- 	<% --%>
<!-- //     		List<vdocOrg> orgList1 = vdocOrgLocalServiceUtil.getOrgByParentId("0");  -->
<!-- //     		for(vdocOrg org : orgList1)  -->
<!-- //     		{   -->
<%--   	%>						 --%>
<!--   				<div class="menuheaders">			  -->
<%-- 							<a href="<liferay-portlet:actionURL name="ipcVdoc" >  --%>
<%-- 								<liferay-portlet:param name= "orgId" value= "<%= String.valueOf(org.getOrgId()) %>"  />   --%>
<%-- 						  	</liferay-portlet:actionURL>"><%= org.getName() %></a> --%>
<!-- 				</div> -->
<%-- 					<% --%>
<!-- //      						List<vdocOrg> orgList2 = vdocOrgLocalServiceUtil.getOrgByParentId(org.getOrgId());  -->
<!-- //      						if(Validator.isNotNull(orgList2)) {					 -->
<%--   					%>		   --%>
<!--  					<ul class="menucontents">		 -->
<%-- 						<% for(vdocOrg org2 : orgList2){ %>		 --%>
<!-- 						<li>					 -->
<%-- 							<a  href="<liferay-portlet:actionURL name="ipcVdoc">  --%>
<%-- 									<liferay-portlet:param name= "orgId" value= "<%= String.valueOf(org2.getOrgId()) %>"  />   --%>
<%-- 						  		</liferay-portlet:actionURL>">  <%= org2.getName() %></a>  --%>
						
<!-- 						</li> -->
<%-- 							<%}%> --%>
<!-- 						</ul> -->
<%-- 						<%} %>					 --%>
<%-- 	<% --%>
<!-- //    		} -->
<%--   	%> --%>
  	
	</body>
</html>
<%
// 	long groupId = themeDisplay.getLayout().getGroupId();
// 	String languageId = themeDisplay.getLanguageId();
%>

	  

<c:choose>
	<c:when test="<%= styleDisplay==1 %>">
            <%@ include file="/html/portlet/vdocmenu/style1.jsp" %>
    </c:when>	
    <c:when test="<%= styleDisplay==2 %>">
            <%@ include file="/html/portlet/vdocmenu/style2.jsp" %>
    </c:when>
    <c:when test="<%= styleDisplay==3 %>">
            <%@ include file="/html/portlet/vdocmenu/style3.jsp" %>
    </c:when>
    <c:when test="<%= styleDisplay==4 %>">
            <%@ include file="/html/portlet/vdocmenu/style4.jsp" %>
    </c:when>
</c:choose>