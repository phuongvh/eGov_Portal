<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@ include file="/html/portlet/vcontact/init.jsp"%>


<script type="text/javascript">
	Liferay.provide(
        window,
        '<portlet:namespace />deleteAll',
        function() {
		var Ids = document.<portlet:namespace/>fm.<portlet:namespace />Ids.value;
		Ids = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
		if (Ids.length > 0 ){
			if (confirm('<%=UnicodeLanguageUtil.get(pageContext,
					"are-you-sure-you-want-to-delete-the-selected-feedback")%>')) {
				document.<portlet:namespace />fm.<portlet:namespace />cmd.value = "dodelete";
				document.<portlet:namespace />fm.<portlet:namespace />Ids.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
				submitForm(document.<portlet:namespace />fm, '<portlet:actionURL windowState="<%=WindowState.MAXIMIZED.toString()%>" name="_delete"></portlet:actionURL>');
			}
		} else {
				alert("<%=LanguageUtil.get(pageContext,
					"you-must-select-a-feedback-to-delete")%> ");
		}
		},
		['liferay-util-list-fields']
	);

</script>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.MAXIMIZED);
	portletURL.setParameter("struts_action", "/vcontact/view");

	List contactList = VContactServiceUtil.getByG_S(groupId, status);

	//boolean showDeleteAll = showButtons && PortletPermissionUtil.
	//	contains(permissionChecker , plid.longValue(), PortletKeysExt.VCONTACT, ActionKeysExt.DELETE);
%>

<form action="<%=portletURL.toString()%>" method="POST"
	name="<portlet:namespace />fm">
	<input type="hidden" name="<portlet:namespace/>cmd" value="" /> <input
		name="<portlet:namespace />Ids" type="hidden" value=""> <input
		name="<portlet:namespace />redirect" type="hidden"
		value="<%=currentURL%>">

	<liferay-ui:tabs names="<%=tabsNames%>"
		url="<%=portletURL.toString()%>" />


	<%
		List headerNames = new ArrayList();
		headerNames.add(LanguageUtil.get(pageContext, "name"));
		headerNames.add(LanguageUtil.get(pageContext, "title"));
		headerNames.add(LanguageUtil.get(pageContext, "email"));
		headerNames.add(LanguageUtil.get(pageContext, "send-date"));
		headerNames.add(StringPool.SPACE);

		int total = contactList.size();
		SearchContainer searchContainer = new SearchContainer(
				renderRequest, null, null,
				SearchContainer.DEFAULT_CUR_PARAM, 20, portletURL,
				headerNames, null);

		searchContainer.setEmptyResultsMessage("there-are-no-contacts");

		List results = VContactServiceUtil.getByG_S(groupId, status,
				searchContainer.getStart(), searchContainer.getEnd());

		searchContainer.setResults(results);
		searchContainer.setTotal(total);

		if (status == 2) {
			searchContainer.setRowChecker(new RowChecker(renderResponse));
		}

		List resultRows = searchContainer.getResultRows();

		for (int i = 0; i < results.size(); i++) {

			VContact bean = (VContact) results.get(i);
			ResultRow row = new ResultRow(bean,
					String.valueOf(bean.getId()), i);

			PortletURL rowURL = renderResponse.createRenderURL();
			rowURL.setWindowState(WindowState.MAXIMIZED);
			rowURL.setParameter("struts_action", "/gcadmin/view");
			rowURL.setParameter("cmd", "edit");
			rowURL.setParameter("id", String.valueOf(bean.getId()));
			rowURL.setParameter("redirect", currentURL.toString());
			rowURL.setParameter("tabs1", tabs1);

			//Name		
			if (bean.getGuestName().length() < 20) {
				row.addText(bean.getGuestName());
			} 
			else {		
 				row.addText(bean.getGuestName().substring(0, 20) + "...");
			}

			//Title
			if (bean.getTitle().length() < 25) {
				row.addText(bean.getTitle());
			} else {
				row.addText( bean.getTitle().substring(0, 25) + "...");
			}

			//E-mail 		
			row.addText(bean.getEmail());

			//File attach
			//if(!bean.getFile().equals("")){
			//	TextSearchEntry rowFile = new TextSearchEntry(SearchEntry.DEFAULT_ALIGN,SearchEntry.DEFAULT_VALIGN,"<b>Có</b>");
			//	row.addText(rowFile);
			//} else{
			//	TextSearchEntry rowFile = new TextSearchEntry(SearchEntry.DEFAULT_ALIGN,SearchEntry.DEFAULT_VALIGN,"<i>Không</i>");
			//	row.addText(rowFile);
			//}

			//Create Date
		
			row.addText(VContactUtil.dateParser(bean.getCreatedDate()));

			row.addJSP("right", SearchEntry.DEFAULT_VALIGN,
					"/html/portlet/vcontact/action.jsp", application,
					request, response);
			resultRows.add(row);
		}
	%>
	<!-- Button deleteAll -->
	<c:if test="<%=(contactList.size() > 0) && (status == 2)%>">
		<input class="portlet-form-button" type="button"
			value="<liferay-ui:message key="delete" />"
			onclick="<portlet:namespace />deleteAll();" />
	</c:if>

	<br />
	<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />

</form>
