<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.vportal.portal.util.PortalUtilExt"%>

<%
	int memberOnline = PortalUtilExt.getCurrentOnlineUsers(String.valueOf(companyId));
%>				
<div class="wd-boxs">
	<h2 class="wd-tlh1-1 wd-alignment"><%=LanguageUtil.get(pageContext, "memberOnline")%></h2>
	<%
	int number = 0;
	if (memberOnline<0) memberOnline=-memberOnline; // maybe you'd like to support negatives
	List<Integer> digits = new LinkedList<Integer>();

	while (memberOnline>0) {
	    digits.add(0, memberOnline%10);
	    memberOnline=memberOnline/10;
	}
	
	if(digits.size() < 8) number = 8 - digits.size();
	
	%>
	<div class="wd-visited">
		<ul class="wd-access">
	<%for(int j = 0; j<number;j++){ %>
		<li><span>0</span></li>
	<%} %>
	<%for (int i = 0; i< digits.size(); i++){ %>
			<li><span><%=digits.get(i) %></span></li>
	<%} %>
		</ul>
	</div>
</div>