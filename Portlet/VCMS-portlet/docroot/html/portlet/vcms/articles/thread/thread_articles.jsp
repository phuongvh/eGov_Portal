<%
/**
 * Copyright (c) 2000-2006 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
%>
<%@ include file="/html/portlet/vcms/init.jsp" %>
<script language="javascript">
	function <portlet:namespace />selectThreads(){
		var threadId = '';	
		var threadTitle = '';	
		var threadIds = document.getElementsByName('<portlet:namespace />threadId');
		var threadTitles = document.getElementsByName('<portlet:namespace />threadTitles');
		alert(threadTitles);
		if (threadIds && (threadIds.length > 0)) {
			for (i = 0; i < threadIds.length; i ++) {
				if (threadIds[i].checked) {
					threadId = threadIds[i].value;
					threadTitle = threadTitles[i-1].value;
				}
			}
		}
		
		document.<portlet:namespace />fm.<portlet:namespace />threadId.value = threadId;
		document.getElementById('<portlet:namespace />threadContainer').innerHTML = '[<a href="#browseThread" onClick="javascript:<portlet:namespace />showThreadsList()"><%= LanguageUtil.get(pageContext, "portlet.vcms.article.edit.browse-thread") %>...</a>] ' + '<br/>'+threadTitle;
		Liferay.Popup.close(this);
	}
	
</script>	
<%
	
	List results = new ArrayList();
	results = VcmsThreadServiceUtil.getThreadsByP_L(groupId, language);
%>	

<table cellspacing="0" cellpadding="4" width="100%" border="0">	
<tr>	
	<td>
		<fieldset>
		<legend><%= LanguageUtil.get(pageContext, "portlet.vcms.article.select-thread") %></legend>					
			<div style="overflow: auto; height: 350px; border:1px solid; border-color:#CCCCCC" >
				<table cellspacing="0" cellpadding="5" width="100%" border="0">						
				<%if(Validator.isNotNull(results)&& results.size()>0){
					for(int i=0;i<results.size();i++){
						VcmsThread thread = (VcmsThread)results.get(i);%>
				<tr height="22">	
					<td style="padding-left:5px;">
						<input type="radio" name="<portlet:namespace />threadId" id="<portlet:namespace />threadId_<%=thread.getThreadId()%>" value="<%=thread.getThreadId()%>">
						<input type="hidden" name="<portlet:namespace />threadTitles" value="<%=thread.getTitle()%>" />	</td>
									
					<td><label for="<portlet:namespace/>threadId_<%=thread.getThreadId()%>"><%=thread.getTitle()%></label></td>	
				</tr>			
				<%}}%>	
				</table>
			</div>							
		</fieldset>	
	</td>
</tr>		
		
<tr>
	<td align="center">
		<input class="form-button" type="button" value="<liferay-ui:message key="portlet.vcms.article.edit.select-threads" />" style="margin: 10px" onClick="javascript:<portlet:namespace />selectThreads();"/>
		<input class="form-button" type="button" value="<liferay-ui:message key="close" />" style="margin: 10px" onClick="Liferay.Popup.close(this);"/>
	</td>		
</tr>


	

