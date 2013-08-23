<%@page import="com.vportal.portlet.vfaq.service.FAQQuestionLocalServiceUtil"%>
<%@page import="com.vportal.portlet.vfaq.util.FAQUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.vportal.portlet.vfaq.model.FAQAnswer"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.vportal.portlet.vfaq.service.FAQAnswerLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%
	PortletURL viewQuestion = renderResponse.createRenderURL();
	viewQuestion.setParameter("tabs1", tabs1);
	viewQuestion.setParameter("tabs2", tabs2);
	viewQuestion.setParameter("tabs3", tabs3);
	viewQuestion.setWindowState(WindowState.MAXIMIZED);
	
	List headerNames = new ArrayList();
	headerNames.add("pFAQ.title.question");	
	headerNames.add("Ng&#432;&#7901;i tr&#7843; l&#7901;i");
	headerNames.add("pFAQ.title.createdDate");
	headerNames.add("pFAQ.form.approvedByUser");
	headerNames.add("pFAQ.status");
	
	SearchContainer searchCtn = new SearchContainer(renderRequest,
			null, null, SearchContainer.DEFAULT_CUR_PARAM, 15,
			viewQuestion, headerNames, null);
	
	searchCtn.setEmptyResultsMessage("there-are-no-answers");	
	
	int  total = 0;
	List result = new ArrayList();
	

	result = FAQAnswerLocalServiceUtil.getAnswer(groupId, language, 0, searchCtn.getStart(), searchCtn.getEnd());
	total = FAQAnswerLocalServiceUtil.countAnswer(groupId, language, 0);		
	
	searchCtn.setTotal(total);
	searchCtn.setDelta(15);
	//searchCtn.setRowChecker(new RowChecker(renderResponse));
	List resultRows = searchCtn.getResultRows();
	ResultRow row = null;
	String rowApproved = "";
	for (int i = 0; i < result.size(); i++) {
		FAQAnswer content = (FAQAnswer)result.get(i);
		
		long questionId = content.getQuestionid();
		FAQQuestion question = FAQQuestionLocalServiceUtil.getQuestion(groupId, questionId);
		
		row = new ResultRow(content, content.getPrimaryKey(),	i);

		//title
		PortletURL rowURL = renderResponse.createRenderURL();
		rowURL.setWindowState(WindowState.MAXIMIZED);
		rowURL.setParameter("jspPage","/html/portlet/vfaq/edit_answer.jsp");
		rowURL.setParameter("answerId", Long.toString(content.getId()));
		rowURL.setParameter("questionId",Long.toString(question.getId()));		
		rowURL.setParameter("redirect",currentURL);
		rowURL.setParameter("tabs1", tabs1);		
		
		//TextSearchEntry rowTextEntry = new TextSearchEntry(SearchEntry.DEFAULT_ALIGN, SearchEntry.DEFAULT_VALIGN, StringUtil.shorten(HtmlExt.extractText(question.getTitle()),200), rowURL.toString());
		TextSearchEntry rowTextEntry = new TextSearchEntry();
		rowTextEntry.setHref(rowURL.toString());
		rowTextEntry.setName(StringUtil.shorten(HtmlExt.extractText(question.getTitle()),200));
		rowTextEntry.setTarget("_blank");
		rowTextEntry.setTitle(StringUtil.shorten(HtmlExt.extractText(question.getTitle()),200));
		row.addText(rowTextEntry);
		
		row.addText(content.getAnsweredByUser());		
		row.addText(FAQUtil.dateParser(content.getAnsweredDate()));	
		row.addText(content.getApprovedByUser());
		if(content.getApproved()){
			rowApproved = LanguageUtil.get(pageContext, "com.vportal.portlet.vfaq.approvedQuestion");
		}else{
			rowApproved = LanguageUtil.get(pageContext, "com.vportal.portlet.vfaq.unapprovedQuestion");
		}
		row.addText(rowApproved);
		//row.addJSP("right", SearchEntry.DEFAULT_VALIGN, "/html/portlet/vfaq/button.jsp",application,request,response);
		
		resultRows.add(row);
	}
%>
<liferay-ui:search-iterator searchContainer="<%= searchCtn %>" />