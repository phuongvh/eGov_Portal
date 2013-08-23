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
	List categoryArticleList = (List)request.getAttribute(ConstantsExt.LIST_CATEGORY_ARTICLE);
	
	for (int i = 0; i < categoryArticleList.size(); i++) {
		Object[] obj = (Object[])categoryArticleList.get(i);
		VcmsCategory category = (VcmsCategory)obj[0];
		List listIntroArticle = (List)obj[1];
		List listLinkArticle = (List)obj[2];
		PortletURL catURL;
		if (openNewTab) {
			catURL = new PortletURLImpl(request,"vcmsviewcontent", plId, false);
		} else {
			catURL = renderResponse.createRenderURL();
		}
		catURL.setParameter(15: catURL.setParameter("jspPage","/html/portlet/vcmsviewcontent/view.jsp");  );
		catURL.setParameter("categoryId", category.getCategoryId());

%>
		<hr />
		<div style="background: #ccc;"><a href="<%= catURL %>"><%= category.getName() %></a></div>
<%
		for (int j = 0; j < listIntroArticle.size(); j++) {
			VcmsArticle article = (VcmsArticle)listIntroArticle.get(j);
			
			PortletURL articleURL;
			if (openNewTab) {
				articleURL = new PortletURLImpl(request,"vcmsviewcontent", plId, false);
			} else {
				articleURL = renderResponse.createRenderURL();
			}
			articleURL.setParameter(15: catURL.setParameter("jspPage","/html/portlet/vcmsviewcontent/view.jsp");  );
			articleURL.setParameter("articleId", article.getArticleId());
			articleURL.setParameter("categoryId", category.getCategoryId());
%>
			<div><strong><a href="<%= articleURL %>"><%= article.getTitle() %></a></strong></div>
			<div><%= article.getLead() %></div>
<%
		}
		
		for (int j = 0; j < listLinkArticle.size(); j++) {
			VcmsArticle article = (VcmsArticle)listLinkArticle.get(j);

			PortletURL articleURL;
			if (openNewTab) {
				articleURL = new PortletURLImpl(request,"vcmsviewcontent", plId, false);
			} else {
				articleURL = renderResponse.createRenderURL();
			}
			articleURL.setParameter(15: catURL.setParameter("jspPage","/html/portlet/vcmsviewcontent/view.jsp");  );
			articleURL.setParameter("articleId", article.getArticleId());
			articleURL.setParameter("categoryId", category.getCategoryId());
%>
			<div style="border: 1px solid #ffaaee;"><a href="<%= articleURL %>"><%= article.getTitle() %></a></div>
<%
		}
	}
%>
