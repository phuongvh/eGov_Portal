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

<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.vportal.portlet.vdoc.service.util.PortletKeysExt"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.vportal.portlet.vdoc.model.vdocOrg"%>
<%@page import="com.vportal.portlet.vdoc.service.vdocDORelServiceUtil"%>
<%@page import="com.vportal.portlet.vdoc.service.vdocDocumentServiceUtil"%>
<%@page import="com.vportal.portlet.vdoc.model.vdocDORel"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@ include file="/html/portlet/vdocview/init.jsp" %>

<%
		vdocDocument vdoc = null;		
		String docId =  ParamUtil.getString(request, "docId", StringPool.BLANK);

		List listOtherDoc = new ArrayList();
		
		listOtherDoc = vdocDocumentServiceUtil.getOtherDoc(groupId,language, docId,2,0, 5);

		vdocDocument doc = vdocDocumentServiceUtil.getDocument(docId);
		String orgRels = "";
		vdocOrg org = new vdocOrgImpl();
		List<vdocDORel> list = vdocDORelServiceUtil.getRelByDoc(docId);	
		int i = 0;
		for( i=0; i<list.size(); i++){
			vdocDORel vdocrel = (vdocDORel)list.get(i);
			org = vdocOrgServiceUtil.getOrg(vdocrel.getOrgId());
			if(i==0){
		    	orgRels = org.getName();
			}else{
				orgRels = orgRels+","+org.getName();
			}
		}
%>

				<div class="wd-boxs">
					<h2 class="wd-tlh1-2"><%= LanguageUtil.get(pageContext, "portlet.vdoc.title") %></h2>
					<div class="wd-introduction">
						<div class="wd-bor-dotted">
							<h2><%=doc.getTitle()%></h2>
						</div>
						<div class="wd-bor-dotted">
							<p class="wd-upper"><b>Tr&igrave;nh t&#7921; th&#7921;c hi&#7879;n</b></p>
							<p><%=doc.getProcess()%>.</p>
						</div>
						<div class="wd-bor-dotted">
							<p class="wd-upper"><b>C&#225;ch th&#7913;c th&#7921;c hi&#7879;n</b></p>
							<p><%=doc.getStyle()%></p>
						</div>
						<div class="wd-bor-dotted">
							<p class="wd-upper"><b>Th&#224;nh ph&#7847;n s&#7889; l&#432;&#7907;ng h&#7891; s&#417;</b></p>
							<ul class="wd-profile">
								<li><%=doc.getContent()%></li>
							</ul>
						</div>
						<div class="wd-bor-dotted">
							<p class="wd-upper"><b>Th&#7901;i h&#7841;n gi&#7843;i quy&#7871;t</b></p>
							<p><%=doc.getTime()%></p>	
						</div>
						<div class="wd-bor-dotted">
							<p class="wd-upper"><b>&#272;&#7889;i t&#432;&#7907;ng th&#7921;c hi&#7879;n</b></p>
							<p><%=doc.getObjects()%></p>	
						</div>
						<div class="wd-bor-dotted">
							<p class="wd-upper"><b>C&#417; quan th&#7921;c hi&#7879;n</b></p>
							<p><%=orgRels%></p>	
						</div>
						<div class="wd-bor-dotted">
							<p class="wd-upper"><b>K&#7871;t qu&#7843; th&#7921;c hi&#7879;n th&#7911; t&#7909;c h&#224;nh ch&#237;nh</b></p>
							<p><%=doc.getResult()%></p>	
						</div>
						<div class="wd-bor-dotted">
							<p class="wd-upper">L&#7879; ph&#237;</p>
							<p><%=doc.getCost()%></p>	
						</div>
						<div class="wd-bor-dotted">
							<p class="wd-upper"><b>T&#234;n m&#7851;u &#273;&#417;n, m&#7851;u t&#7901; khai</b></p>
							<p> <a href="#"><%=doc.getNote()%></a></p>	
						</div>
						<div class="wd-bor-dotted">
							<p class="wd-upper">Y&#234;u c&#7847;u, &#273;i&#7873;u ki&#7879;n th&#7921;c hi&#7879;n</p>
							<p><%=doc.getRequire()%></p>	
						</div>
						<div class="wd-bor-dotted wd-no-dotted">
							<p class="wd-upper"><b>C&#417; s&#7903; ph&#225;p l&#253;</b></p>
							<p><%=doc.getBase()%></p>
						</div>
						<div class="wd-bortop">
							<ul class="wd-outside-support">
								<li><a href="javascript:print()" class="wd-print"><%= LanguageUtil.get(pageContext, "portlet.vdoc.print") %></a></li>
								<li><a href="mailto:abc@gmail.com" class="wd-email"><%= LanguageUtil.get(pageContext, "portlet.vdoc.email") %></a></li>
								<li><a href="#" class="wd-back"><%= LanguageUtil.get(pageContext, "portlet.vdoc.back") %></a></li>
							</ul>
						</div>
						<div>
						<%
							if (listOtherDoc.size()  > 0) {
						%>
						<h3 class="wd-tlh3-3"><%= LanguageUtil.get(pageContext, "portlet.vdoc.otheranswer") %></h3>
						<% } %>
						<%
							PortletURL otherDocURL = renderResponse.createRenderURL();	
							for (int j = 0; j < listOtherDoc.size(); j++) {
								vdocDocument vdoc1 = (vdocDocument) listOtherDoc.get(j);
								otherDocURL.setWindowState(WindowState.MAXIMIZED);
								otherDocURL.setParameter("jspPage", "/html/portlet/vdocview/view_doc_detail.jsp");
								otherDocURL.setParameter("docId", vdoc1.getDocId());
								
						%>
						<ul class="wd-other-news">

							<li>
								<a  href="<%=otherDocURL.toString()%>"><%=StringUtil.shorten(HtmlUtil.extractText(vdoc1.getTitle()),100)%> </a><br>
							 </li>

						</ul>
						<% } %>
						</div>
					</div>
				</div>
			

