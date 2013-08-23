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
	VcmsCategory category = (VcmsCategory)request.getAttribute(ConstantsExt.CATEGORY);
	VcmsArticle article = (VcmsArticle)request.getAttribute(ConstantsExt.ARTICLE);
	List olderArticles = (List)request.getAttribute(ConstantsExt.LIST_NEXT_OLDER_ARTICLE);
	List threadsArticle = (List)request.getAttribute(ConstantsExt.LIST_NEXT_IN_FLOW_ARTICLE);
	List newestArticles = (List)request.getAttribute(ConstantsExt.LIST_NEXT_NEWEST_ARTICLE);
	
	PortletURL catURL;
	if (openNewTab > 0) {
		catURL = PortletURLFactoryUtil.create(request, portletName, plId, PortletRequest.RENDER_PHASE);
	} else {
		catURL = renderResponse.createRenderURL();
	}
	catURL.setParameter("jspPage", "/html/portlet/vcmsview/view.jsp");
	catURL.setParameter("categoryId", category.getCategoryId());


	PortletURL articleURL;
	if (openNewTab > 0) {
		articleURL = PortletURLFactoryUtil.create(request, portletName, plId, PortletRequest.RENDER_PHASE);
	} else {
		articleURL = renderResponse.createRenderURL();
	}
	articleURL.setParameter("jspPage", "/html/portlet/vcmsview/view.jsp");
	articleURL.setParameter("articleId", article.getArticleId());
	articleURL.setParameter("categoryId", category.getCategoryId());
%>
	<hr />
	<div style="background: #ccc;"><a href="<%= catURL %>"><%= category.getName() %></a></div>
	<div><strong><a href="<%= articleURL %>"><%= article.getTitle() %></a></strong></div>
	<div><%= article.getLead() %></div>
	<div><%= article.getContent() %></div>
<!-- newest articles -->
<%
	if (newestArticles.size() > 0) {
		out.print("<div>Newest articles</div>");
	}
	for (int j = 0; j < newestArticles.size(); j++) {
		VcmsArticle articleNew = (VcmsArticle)newestArticles.get(j);

		PortletURL articleNewURL;
		if (openNewTab > 0) {
			articleNewURL = PortletURLFactoryUtil.create(request, portletName, plId, PortletRequest.RENDER_PHASE);
		} else {
			articleNewURL = renderResponse.createRenderURL();
		}
		articleNewURL.setParameter("jspPage", "/html/portlet/vcmsview/view.jsp");
		articleNewURL.setParameter("articleId", articleNew.getArticleId());
		articleNewURL.setParameter("categoryId", category.getCategoryId());
%>
		<div style="border: 1px solid #ffaaee;"><a href="<%= articleNewURL %>"><%= articleNew.getTitle() %></a></div>
<%
	}
%>
<!-- older articles -->
<%
	if (olderArticles.size() > 0) {
		out.print("<div>Older articles</div>");
	}
	for (int j = 0; j < olderArticles.size(); j++) {
		VcmsArticle articleOld = (VcmsArticle)olderArticles.get(j);

		PortletURL articleOldURL;
		if (openNewTab > 0) {
			articleOldURL = PortletURLFactoryUtil.create(request, portletName, plId, PortletRequest.RENDER_PHASE);
		} else {
			articleOldURL = renderResponse.createRenderURL();
		}
		articleOldURL.setParameter("jspPage", "/html/portlet/vcmsview/view.jsp");
		articleOldURL.setParameter("articleId", articleOld.getArticleId());
		articleOldURL.setParameter("categoryId", category.getCategoryId());
%>
		<div style="border: 1px solid #ffaaee;"><a href="<%= articleOldURL %>"><%= articleOld.getTitle() %></a></div>
<%
	}
%>
<!-- in thread articles -->
<%
	if (threadsArticle.size() > 0) {
		out.print("<div>Threads articles</div>");
	}
	for (int j = 0; j < threadsArticle.size(); j++) {
		VcmsArticle articleThread = (VcmsArticle)threadsArticle.get(j);

		PortletURL articleThreadURL;
		if (openNewTab > 0) {
			articleThreadURL = PortletURLFactoryUtil.create(request, portletName, plId, PortletRequest.RENDER_PHASE);
		} else {
			articleThreadURL = renderResponse.createRenderURL();
		}
		articleThreadURL.setParameter("jspPage", "/html/portlet/vcmsview/view.jsp");
		articleThreadURL.setParameter("articleId", articleThread.getArticleId());
		articleThreadURL.setParameter("categoryId", category.getCategoryId());
%>
		<div style="border: 1px solid #ffaaee;"><a href="<%= articleThreadURL %>"><%= articleThread.getTitle() %></a></div>
<%
	}
%>
