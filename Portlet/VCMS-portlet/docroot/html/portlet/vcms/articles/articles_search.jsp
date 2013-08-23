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

<%

	String redirect = ParamUtil.getString(request,"redirect",StringPool.BLANK);

	
	VcmsPortion portion = null;
	List categories = null;
	List portions = VcmsPortionServiceUtil.getPortionsByS_L(groupId, language);
	
	if (Validator.isNull(portionId)) {
		categories = VcmsCategoryServiceUtil.getCategoriesByParent(groupId, parentId, language);
	} else {
		categories = VcmsCategoryServiceUtil.getCategoriesByP_P(groupId, portionId, parentId, language);
		portion = VcmsPortionServiceUtil.getPortion(portionId);
	}
	

	if (categories == null) {
		categories = new ArrayList();
	}
	
	List listType = new ArrayList();
	listType = VcmsTypeServiceUtil.getTypesByS_L(groupId, language);
%>
<script language="javascript">
	var flag = true;
	function <portlet:namespace/>enabledInputDate(){
		if(document.<portlet:namespace/>fm.<portlet:namespace/>isDate.checked == true){
			document.<%= renderResponse.getNamespace() + "fm" %>.fromMonth.disabled = false;
			//document.<%= renderResponse.getNamespace() + "fm" %>toDate.disabled = false;
		}else{
			//document.<%= renderResponse.getNamespace() + "fm" %>fromDate.disabled = true;
			//document.<%= renderResponse.getNamespace() + "fm" %>toDate.disabled = true;
		}
	}
	
	function <portlet:namespace/>miximizeSearchAdvance(){
		if(flag == true){
			document.getElementById('<portlet:namespace/>advanced_search').style.display ="none";
			document.<portlet:namespace/>fm.<portlet:namespace/>button_custom_search.src = '<%=themeDisplay.getPathThemeImage() + "/vcms/maximize_search.gif" %>';
			document.<portlet:namespace/>fm.<portlet:namespace/>button_custom_search.title = "<%= LanguageUtil.get(pageContext, "portlet.vcms.button.search.maximize") %>";

			flag = false;
		}else{
			document.getElementById('<portlet:namespace/>advanced_search').style.display ="";
			document.<portlet:namespace/>fm.<portlet:namespace/>button_custom_search.src = '<%=themeDisplay.getPathThemeImage() + "/vcms/miximize_search.gif" %>';
			document.<portlet:namespace/>fm.<portlet:namespace/>button_custom_search.title = "<%= LanguageUtil.get(pageContext, "portlet.vcms.button.search.miximize") %>";
			flag = true;
		}
	}
</script>

	<input type="hidden" name="<portlet:namespace />cmd-search-flag" value="true"/>
	<input type="hidden" name="<portlet:namespace />redirect" value="<%= redirect%>"/>
	
	<input type="hidden" name="<portlet:namespace />fromTypeId" value="<%= (Validator.isNotNull(fromTypeId))?fromTypeId:""%>"/>
	<input type="hidden" name="<portlet:namespace />fromCategoryId" value="<%= (Validator.isNotNull(fromCateogryId))?fromCateogryId:""%>"/>
	<input type="hidden" name="<portlet:namespace />fromPortionId" value="<%= (Validator.isNotNull(fromPortionId))?fromPortionId:""%>"/>
	<input type="hidden" name="<portlet:namespace />threadId" value="<%= (Validator.isNotNull(threadId))?threadId:""%>"/>
		
	<input type="hidden" name="<portlet:namespace />cmd_category" value="<%= (Validator.isNotNull(cmd_category))?cmd_category:""%>"/>
	<input type="hidden" name="<portlet:namespace />cmd_portion" value="<%= (Validator.isNotNull(cmd_portion))?cmd_portion:""%>"/>
	<input type="hidden" name="<portlet:namespace />cmd_thread" value="<%= (Validator.isNotNull(cmd_thread))?cmd_thread:""%>"/>
	<input type="hidden" name="<portlet:namespace />cmd_type" value="<%= (Validator.isNotNull(cmd_type))?cmd_type:""%>"/>

		
<table width="100%" border="0" align="center" class="portlet-section-body">	
<tr height="30">	
	<td width="15%">
		<b><%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.portion-article") %> </b></td>
	<td>
		<select style="width: 180px" name="<portlet:namespace />portionId" onChange="javascript:<portlet:namespace />submitForm();" onmousemove="Liferay.Portal.ToolTip.show( this,'<b><liferay-ui:message key="portlet.vcms.tooltip.select.portion" /></b>')">
			<option selected value=""><%= LanguageUtil.get(pageContext, "portlet.vcms.category.search-panel.all-portion") %></option>
			<%	for (int i = 0; i < portions.size(); i++) {
					VcmsPortion portion2 = (VcmsPortion) portions.get(i);														
					if (!portion2.getCategorizable()) {
						continue;
					}														
			%>	
				<option <%= portionId.equals(portion2.getPortionId()) ? "selected" : "" %> value="<%= portion2.getPortionId() %>"><%= portion2.getName() %></option>													
			<%	} %>
		</select>
	</td>
	<td>
		<b><%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.category-article") %> </b></td>	
	<td>		
		<select style="width: 200px" name="<portlet:namespace />parentId" <%= ((portion != null) && (portion.getCategorizable())) ? "" : "disabled" %>  onChange="javascript:<portlet:namespace />submitForm();" onmousemove="Liferay.Portal.ToolTip.show( this,'<b><liferay-ui:message key="portlet.vcms.tooltip.select.category" /></b>')">
			<option value="0" <%= ("0".equals(parentId)) ? "selected" : "" %>>-- <%= LanguageUtil.get(pageContext, "portlet.vcms.category.search-panel.root-category") %> --</option>
			
			<%									
				if (portion != null) {
					out.println(ActionUtil.getCategoryTree(portionId, parentId));
				}
			%>
		</select>	
	</td>	
</tr>	
			
<tr height="30">	
	<td width="15%">
		<b><%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.typeArticle") %>:</b></td>
	<td colspan="3">
		<select name="<portlet:namespace/>typeId" style="width:180px;" onchange="javascript:<portlet:namespace />submitForm();" onmousemove="Liferay.Portal.ToolTip.show( this,'<b><liferay-ui:message key="portlet.vcms.tooltip.select.type" /></b>')">
			<option value="">-- <%= LanguageUtil.get(pageContext, "all") %> --</option>
			<%	if(Validator.isNotNull(listType) && listType.size()>0){
					for(int i=0;i<listType.size();i++){
						VcmsType vType = (VcmsType)listType.get(i);%>
				<option value="<%=vType.getTypeId()%>" <%= fromTypeId.equals(vType.getTypeId())? "selected" : "" %>><%=vType.getName()%></option>
			<%}}%>
		</select>
	</td>	
</tr>
			
<tr height="30">
	<td><b><%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.keyword") %></b></td>
	<td colspan="3">
		<!--<input class="ui-tags-input ui-autocomplete-input" autocomplete="off" type="text" name="<portlet:namespace />keyword" size="50px" value="<%= HtmlUtil.escape(keyword) %>" onBlur="if (this.value == '') { this.value = '<%= unicodeDefaultKeywords %>'; }" onFocus="if (this.value == '<%= unicodeDefaultKeywords %>') { this.value = ''; }"/></td>-->			
		<input class="ui-tags-input ui-autocomplete-input" autocomplete="off" type="text" name="<portlet:namespace />keyword" size="50px" value="<%= HtmlUtil.escape(keyword) %>" /></td>
</tr>			

<tr><td colspan="4">&nbsp;</td></tr>
</table>	
					  
<div id="<portlet:namespace/>advanced_search">
<table width="100%" border="0" align="center" class="portlet-section-body">
<tr  height="30">
	<td>
	<table width="100%" border="0"  align="center" >
	      <tr>
	            <td width="3%"><input type="checkbox" id="<portlet:namespace />keyword-in-title" name="<portlet:namespace />keyword-in-title" <%=isTitle?"checked":""%> disabled/></td>
	            <td width="20%"><label for="<portlet:namespace />keyword-in-title"><%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.title-in-article") %></label> </td>
	            <td width="3%"><input type="checkbox" id="<portlet:namespace />keyword-in-lead" name="<portlet:namespace />keyword-in-lead" <%=isLead?"checked":""%> /></td>
	            <td width="25%"><label for="<portlet:namespace />keyword-in-lead"><%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.lead-in-article") %></label> </td>
	            <td width="3%"><input type="checkbox" id="<portlet:namespace />keyword-in-content" name="<portlet:namespace />keyword-in-content" <%=isContent?"checked":""%>/></td>
	            <td width="20%"><label for="<portlet:namespace />keyword-in-content"><%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.content-in-article") %></label> </td>
	            <td width="10%">
	    			<select name="<portlet:namespace />selectAndOr" onchange="javascript:<portlet:namespace />submitForm();">
	              		<option value="0" <%=Validator.equals(selectAndOr,"0")?"selected":""%>><%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.select-or") %> </option>
	              		<option value="1" <%=Validator.equals(selectAndOr,"1")?"selected":""%>><%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.select-and") %></option>
	                </select>
	    		</td>
	      </tr>
	</table>
	</td>
</tr>
					  
<tr  height="30">
	<td>
	<table width="100%" border="0" align="center">
	    <tr>
	     
	  	<td width="3%"><input type="checkbox" id="<portlet:namespace />isDate" name="<portlet:namespace />isDate" <%=isDate?"checked":""%>/></td>	          
	  	<td width="10%"><label for="<portlet:namespace/>isDate"><%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.from-date") %></label></td>
	      <td width="40%">
			<liferay-ui:input-date
				disableNamespace="<%= false %>"
				formName='<%= renderResponse.getNamespace() + "fm" %>'
				monthParam="fromMonth"
				monthValue="<%= fromMonth %>"
				dayParam="fromDay"
				dayValue="<%= fromDay %>"
				yearParam="fromYear"
				yearValue="<%=fromYear %>"
				yearRangeStart="<%= curYear-10 %>"
				yearRangeEnd="<%= curYear+10 %>"
				firstDayOfWeek="<%= currentDate.getFirstDayOfWeek() - 1 %>"
				disabled="<%= false %>"
			/>
		  </td>
	      <td width="10%"><%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.to-date") %></td>
	      <td width="40%">
	      	<liferay-ui:input-date
				disableNamespace="<%= false %>"
				formName='<%= renderResponse.getNamespace() + "fm" %>'
				monthParam="toMonth"
				monthValue="<%= toMonth %>"
				dayParam="toDay"
				dayValue="<%= toDay %>"
				yearParam="toYear"
				yearValue="<%=curYear %>"
				yearRangeStart="<%= curYear-10 %>"
				yearRangeEnd="<%= curYear+10 %>"
				firstDayOfWeek="<%= currentDate.getFirstDayOfWeek() - 1 %>"
				disabled="<%= false %>"/>
		  </td>
	    </tr>
	</table>
	</td>
</tr>
</table>					
</div>
					
<table width="100%" border="0" align="center" class="portlet-section-body">				    
<tr align="right"  height="30">
	<td align="left">
		<img src="<%=themeDisplay.getPathThemeImage() + "/vcms/miximize_search.gif" %>" name="<portlet:namespace/>button_custom_search" onClick ="javascript:<portlet:namespace/>miximizeSearchAdvance();" title="<%= LanguageUtil.get(pageContext, "portlet.vcms.button.search.miximize") %>"/>
	</td>
	<td></td>
	<td>
		<input class="portlet-form-button" type="button" style="width:150px;height:23px;font-weight:bold" value="<%= LanguageUtil.get(pageContext, "search") %>" onclick="javascript:<portlet:namespace />doSearchArticles();">
	</td>
</tr>
 </table>
    
<liferay-ui:upload-progress
    id="<%= uploadProgressId %>"
    message="searching"
    redirect="<%= HtmlUtil.escape(redirect) %>"
/>
 
