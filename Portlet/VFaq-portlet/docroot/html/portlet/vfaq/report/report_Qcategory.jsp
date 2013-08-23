<%@page import="com.vportal.portlet.vfaq.model.FAQCategory"%>
<%@page import="com.vportal.portlet.vfaq.service.FAQCategoryLocalServiceUtil"%>
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
	headerNames.add("Danh muc");	
	headerNames.add("com.vportal.portlet.vfaq.nQuestions");
	headerNames.add("totalApprovedQuestion");
	headerNames.add("totalUnApprovedQuestion");
	headerNames.add("com.vportal.portlet.vfaq.nAnswer");
	headerNames.add("totalApprovedAnswer");
	headerNames.add("totalUnApprovedAnswer");
	SearchContainer searchCtn = new SearchContainer(renderRequest,
			null, null, SearchContainer.DEFAULT_CUR_PARAM, 75,
			viewQuestion, headerNames, null);
	
	searchCtn.setEmptyResultsMessage("there-are-no-record");	
		
	int total = 0;
	List result = new ArrayList();
		
	result = FAQCategoryLocalServiceUtil.getByG_L(groupId, language, searchCtn.getStart(), searchCtn.getEnd());
	total = FAQCategoryLocalServiceUtil.countByG_L(groupId, language);
	//http://localhost:8081/vi/web/guest/duc?p_p_id=vfaq_WAR_VFaqportlet&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&_vfaq_WAR_VFaqportlet_jspPage=%2Fhtml%2Fportlet%2Fvfaq%2Fview.jsp&_vfaq_WAR_VFaqportlet_tabs1=faq-report&_vfaq_WAR_VFaqportlet_tabs2=&_vfaq_WAR_VFaqportlet_language=vi_VN&_vfaq_WAR_VFaqportlet_groupId=14&_vfaq_WAR_VFaqportlet_delta=20&_vfaq_WAR_VFaqportlet_keywords=&_vfaq_WAR_VFaqportlet_advancedSearch=false&_vfaq_WAR_VFaqportlet_andOperator=true&cur=2
	
	searchCtn.setTotal(total);
	searchCtn.setResults(result);
	
	
	searchCtn.setDelta(75);
	//searchCtn.setRowChecker(new RowChecker(renderResponse));
	List resultRows = searchCtn.getResultRows();
	
	String rowApproved = "";
	String rowReply = "";
	int qTotal = 0;
	int aQuestion = 0;
	int uqQestion = 0;
	int aTotal = 0;
	int aAnswer = 0;
	int uaAnswer = 0;
	
	for (int i = 0; i < result.size(); i++) {
		FAQCategory content = (FAQCategory) result.get(i);
		ResultRow row = new ResultRow(content, content.getPrimaryKey(), i);
		
		//get count question
		qTotal = FAQQuestionLocalServiceUtil.countQuestion(groupId, language, content.getId());
		aQuestion = FAQQuestionLocalServiceUtil.countQuestionByParam(groupId, language, content.getId(), "", "", true);
		uqQestion = FAQQuestionLocalServiceUtil.countQuestionByParam(groupId, language, content.getId(), "", "", false);
		
		//get count answer
		aTotal = FAQAnswerLocalServiceUtil.countAnswer(groupId, language, content.getId());
		aAnswer = FAQAnswerLocalServiceUtil.countByParam(groupId, language, true, "", "", content.getId());
		uaAnswer = FAQAnswerLocalServiceUtil.countByParam(groupId, language, false, "", "", content.getId());
		
		//TextSearchEntry rowFullName = new TextSearchEntry(SearchEntry.DEFAULT_ALIGN, SearchEntry.DEFAULT_VALIGN, StringUtil.shorten(content.getName(),50));
		TextSearchEntry rowFullName = new TextSearchEntry();
		rowFullName.setName(StringUtil.shorten(content.getName(),50));
		row.addText(rowFullName);		
		row.addText(String.valueOf(qTotal));
		row.addText(String.valueOf(aQuestion));
		row.addText(String.valueOf(uqQestion));
		
		row.addText(String.valueOf(aTotal));
		row.addText(String.valueOf(aAnswer));
		row.addText(String.valueOf(uaAnswer));
		
		resultRows.add(row);
	}
%>
<liferay-ui:search-iterator searchContainer="<%= searchCtn %>" />