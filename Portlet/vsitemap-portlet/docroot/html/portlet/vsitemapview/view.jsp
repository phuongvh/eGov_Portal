<%@include file="init.jsp"%>
	
<%
	List listBranch = new ArrayList();	
	List listByParent = new ArrayList();	
%>	
	<div class="wd-boxs">
		<h2 class="wd-tlh1-1 wd-alignment">S&#416; &#272;&#7890; TRANG</h2>
		<div class="wd-introduction">
		<%
			listBranch = VsmBranchServiceUtil.getByG_L_P(groupId, language, 0);	
			for (int i=0;i<listBranch.size();i++){
				VsmBranch branch = (VsmBranch)listBranch.get(i);
		%>
				<h4 class="wd-title-chart"><a href="<%=branch.getHref()%>" target="_blank">
					<%= branch.getName()%></a></h4>
				<ul class="wd-chart">
				<%
					listByParent = VsmBranchServiceUtil.getByG_L_P(groupId, language,branch.getBranchId());
					for(int j=0;j<listByParent.size();j++){
						VsmBranch b = (VsmBranch)listByParent.get(j);
				%>
						<li><a href="<%=b.getHref()%>"><%= b.getName()%></li>
					<%
						}	
					%>
				</ul>
				<%} %>
			</div>
		</div>




