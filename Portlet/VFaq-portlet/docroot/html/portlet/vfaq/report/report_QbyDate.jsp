<%@page import="com.vportal.portlet.vfaq.service.FAQQuestionLocalServiceUtil"%>
<%@page import="com.vportal.util.HtmlExt"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.vportal.portlet.vfaq.action.ActionUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.vportal.portlet.vfaq.service.FAQAnswerLocalServiceUtil"%>
<%@page import="com.vportal.portlet.vfaq.model.FAQQuestion"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.service.permission.PortletPermissionUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchEntry"%>
<%@page import="com.liferay.portal.kernel.dao.search.TextSearchEntry"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>

<%	
	PortletURL viewQuestion = renderResponse.createRenderURL();
	viewQuestion.setParameter("tabs1", tabs1);
	viewQuestion.setParameter("tabs2", tabs2);
	viewQuestion.setParameter("tabs3", tabs3);
	viewQuestion.setWindowState(WindowState.MAXIMIZED);
	
	List headerNames = new ArrayList();
	headerNames.add("title");	
	headerNames.add("H&#7885; t&#234;n");
	headerNames.add("Email");
	headerNames.add("pFAQ.date.send");
	headerNames.add("pFAQ.status");
	headerNames.add("#answer-title");
	SearchContainer searchCtn = new SearchContainer(renderRequest,
			null, null, SearchContainer.DEFAULT_CUR_PARAM, 15,
			viewQuestion, headerNames, null);
	
	searchCtn.setEmptyResultsMessage("there-are-no-questions");	
		
	int total = 0;
	List result = new ArrayList();
		
	result = FAQQuestionLocalServiceUtil.getQuestion(groupId, language, 0, searchCtn.getStart(), searchCtn.getEnd());
	total = FAQQuestionLocalServiceUtil.countQuestion(groupId, language, 0);
	
	
	searchCtn.setTotal(total);
	searchCtn.setResults(result);
	
	searchCtn.setDelta(15);
	//searchCtn.setRowChecker(new RowChecker(renderResponse));
	List resultRows = searchCtn.getResultRows();
	
	String rowApproved = "";
	String rowReply = "";
	int count = 0;
	int count1 = 0;
	for (int i = 0; i < result.size(); i++) {
		FAQQuestion content = (FAQQuestion) result.get(i);
		ResultRow row = new ResultRow(content, content.getPrimaryKey(), i);
		
		count = FAQAnswerLocalServiceUtil.countByG_L_S_Q(groupId, language, true, content.getId());
		count1 = FAQAnswerLocalServiceUtil.countByG_L_S_Q(groupId, language, false, content.getId());

		//title
		PortletURL rowURL = renderResponse.createRenderURL();
		rowURL.setWindowState(WindowState.MAXIMIZED);
		rowURL.setParameter("jspPage", "/html/portlet/vfaq/edit_question.jsp");
		rowURL.setParameter("questionId", Long.toString(content.getId()));
		rowURL.setParameter("tabs1", tabs1);
		rowURL.setParameter("redirect", redirectURL.toString());
		//TextSearchEntry rowTextEntry = new TextSearchEntry(SearchEntry.DEFAULT_ALIGN, SearchEntry.DEFAULT_VALIGN, StringUtil.shorten(HtmlExt.extractText(content.getTitle()),200), rowURL.toString());
		TextSearchEntry rowTextEntry = new TextSearchEntry();
		rowTextEntry.setHref(rowURL.toString());
		rowTextEntry.setName(StringUtil.shorten(HtmlExt.extractText(content.getTitle()),200));
		rowTextEntry.setTarget("_blank");
		rowTextEntry.setTitle(StringUtil.shorten(HtmlExt.extractText(content.getTitle()),200));
		row.addText(rowTextEntry);
		
		rowTextEntry = (TextSearchEntry)rowTextEntry.clone();
		rowTextEntry.setName(StringUtil.shorten(content.getSentByUser(),50));
		row.addText(rowTextEntry);		
		if(Validator.isNotNull(content.getSenderEmail())){
			row.addText(StringUtil.shorten(content.getSenderEmail(),50));
		}else{
			row.addText("");
		}
		
		rowTextEntry = (TextSearchEntry)rowTextEntry.clone();
		rowTextEntry.setName(FAQUtil.dateParser(content.getSentDate()));
		row.addText(rowTextEntry);
		
		
		if(content.getApproved()){
			rowApproved = LanguageUtil.get(pageContext, "com.vportal.portlet.vfaq.approvedQuestion");
		}else{
			rowApproved = LanguageUtil.get(pageContext, "com.vportal.portlet.vfaq.unapprovedQuestion");
		}
		row.addText(rowApproved);
		
		//TextSearchEntry rowCount = new TextSearchEntry(SearchEntry.DEFAULT_ALIGN, SearchEntry.DEFAULT_VALIGN, String.valueOf(count));
		
		if(count + count1 == 0){
			rowReply = LanguageUtil.get(pageContext, "#un-reply");
		}else if(count + count != 0 ) {
			rowReply = LanguageUtil.get(pageContext, "#reply");
		}
		row.addText(rowReply);
		//row.addJSP("right", SearchEntry.DEFAULT_VALIGN, "/html/portlet/vfaq/button.jsp",application,request,response);
		
		resultRows.add(row);
	}
%>

<liferay-ui:search-iterator searchContainer="<%= searchCtn %>" />