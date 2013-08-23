<%@include file="init.jsp"%>

<%
	String idTemp = ParamUtil.getString(request, "Id");
	VContact bean = null;
	if(Validator.isNotNull(idTemp) && !idTemp.equals("")){
		bean = VContactServiceUtil.getContact(Long.valueOf(idTemp));
	}
	else{
		bean = new VContactImpl();
	}
	String redirect = ParamUtil.getString(request, "redirect");
	List attachmentList = (List)request.getAttribute("vportal:fileupload:attachmentList");
	
	if (attachmentList == null){
		attachmentList = new ArrayList();
	}
	String portletId = PortletKeysExt.VCONTACT;
/* 	AttachmentManager am = new AttachmentManager(portletId,
		VContact.class, bean.getId());

	attachmentList = (List)am.getFileEntries(); */
	
	String extension = StringPool.BLANK;
%>
<c:if test="<%= bean != null %>">
	<liferay-ui:tabs names="<%= LanguageUtil.get(pageContext, \"VContact.form.edit\") %>" backURL="<%= redirect %>" />
</c:if>
	
<script language="javascript">

</script>

<form action="<portlet:actionURL name="_update">
	</portlet:actionURL>" method="post" name="<portlet:namespace />fm">
	<input name="<portlet:namespace />Id" type="hidden" value="<%= bean.getId() %>">
	<input name="<portlet:namespace />cmd" type="hidden" value="doupdate">
	<input name="<portlet:namespace />redirect" type="hidden" value="<%= redirect%>">


<table class="lfr-table">
<tr height="30">
	<td>Tên ng&#432;&#7901;i g&#7917;i:</td>
	<td><liferay-ui:input-field model="<%= VContact.class %>" bean="<%= bean %>" field="guestName" /></td>
</tr>
	
<tr height="30">	
	<td>Email:</td>
	<td><liferay-ui:input-field model="<%= VContact.class %>" bean="<%= bean %>" field="email" /></td>
</tr>
	
<tr height="30">	
	<td>Tiêu &#273;&#7873;:</td>
	<td><liferay-ui:input-field model="<%= VContact.class %>" bean="<%= bean %>" field="title" /></td>
</tr>

<tr height="30">	
	<td>&#272;&#7883;a ch&#7881;:</td>
	<td><liferay-ui:input-field model="<%= VContact.class %>" bean="<%= bean %>" field="address" /></td>
</tr>

<tr height="30">	
	<td>S&#7889; &#273;i&#7879;n tho&#7841;i:</td>
	<td><liferay-ui:input-field model="<%= VContact.class %>" bean="<%= bean %>" field="phone" /></td>
</tr>
	
<tr height="30">	
	<td>S&#7889; Fax:</td>
	<td><liferay-ui:input-field model="<%= VContact.class %>" bean="<%= bean %>" field="fax" /></td>
</tr>

<tr height="30">	
	<td>N&#7897;i dung:</td>
	<td><textarea name="<portlet:namespace />content" class="lfr-textarea" ><%= bean.getContent()%></textarea></td>
</tr>

<c:if test="<%= attachmentList.size() >0 %>">
<tr height="30">
	<td>Tài li&#7879;u &#273;ính kèm:</td>
	<td>
		<vportal:file-download entryId="<%= bean.getId()%>" entryClass="<%= VContact.class%>" />
	</td>	
</tr>
</c:if>

	
<tr height="30">
	<td>Tr&#7841;ng thái:</td>
	<td>
		<select name="<portlet:namespace />status">
			<option <%= (bean.getStatus() == 0)? "selected" : ""%> value="0" ><%=LanguageUtil.get(pageContext,"VContact.title.received-pending") %></option>
			<option <%= (bean.getStatus() == 1)? "selected" : ""%> value="1" ><%=LanguageUtil.get(pageContext,"VContact.title.received") %></option>
			<option <%= (bean.getStatus() == 2)? "selected" : ""%> value="2" ><%=LanguageUtil.get(pageContext,"VContact.title.decline") %></option>
		</select>
	</td>
</tr>
</table>
<br/>	
<input type="submit" class="portlet-form-button" value="<liferay-ui:message key="save" />"/>
<input type="button" class="portlet-form-button" value="<liferay-ui:message key="cancel" />" onClick="self.location = '<%= redirect %>';" />

</form>
