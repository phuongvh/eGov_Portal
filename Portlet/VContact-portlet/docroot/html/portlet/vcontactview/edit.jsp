<%@ include file="/html/portlet/vcontactview/init.jsp" %>
<script>
	
	function <portlet:namespace />savePreferences() {
		submitForm(document.<portlet:namespace />fm, '<portlet:actionURL windowState="<%=WindowState.MAXIMIZED.toString()%>" name="_savePreferences"></portlet:actionURL>');
	}
	
	//Attach file
	function <portlet:namespace />hide1(){
		var isAttach = document.getElementById('<portlet:namespace/>isAttach');
		var numberAtt = document.getElementById('<portlet:namespace/>numberAtt');
		if (isAttach.checked){	
			numberAtt.style.display = "";
		} else {
			numberAtt.style.display = "none";
		}
	}
	
	//Style typing
	function <portlet:namespace />hide2(){
		var isTyping = document.getElementById('<portlet:namespace/>isTyping');
		var style = document.getElementById('<portlet:namespace/>style');
		if (isTyping.checked){
			style.style.display = "";
		} else {
			style.style.display = "none";
		}
	}
	
		
	function <portlet:namespace />changeTheme(styleObj) {
		if(styleObj)
			if(styleObj.value==1){
				document.getElementById("<portlet:namespace/>themes_DIENBIEN").style.display = '';
			}else if(styleObj.value==2){
				document.getElementById("<portlet:namespace/>themes_DIENBIEN").style.display = 'none';			
			}
	}		
</script>
	
<%
	String redirect = ParamUtil.getString(request, "redirect");	

	// preference
	String isPhone = prefs.getValue("isPhone","false");
	String isFax = prefs.getValue("isFax","false");
	String isAddress = prefs.getValue("isAddress","false");
	String isAttach  = prefs.getValue("isAttach","true");
	String isTyping = prefs.getValue("isTyping","false");
	String style = prefs.getValue("style","2");
	//String isCodeActive	= prefs.getValue("isCodeActive","false");
	
	String numberAtt = prefs.getValue("numberAtt","1");
	String title = prefs.getValue("title","");
	String titlePortlet = prefs.getValue("titlePortlet","Liên h&#7879;");
	
	int _numberAtt = Integer.valueOf(numberAtt);
	boolean _isAttach = Boolean.valueOf(isAttach);
	boolean _isTyping = Boolean.valueOf(isTyping);
%>
<form enctype="multipart/form-data" action="<portlet:actionURL><portlet:param name="struts_action" value="/vcontactview/edit" />
	</portlet:actionURL>" name="<portlet:namespace />fm" method="POST">	
	<input name="<portlet:namespace />redirect" type="hidden" value="<%= currentURL %>" />
	<input name="<portlet:namespace />cmd" type="hidden" value=""/>

<fieldset style="border:1px dotted gray;">
<legend><strong>C&#7845;u h́nh hi&#7875;n th&#7883;</strong></legend>	
<table  width="100%" cellspacing="1" cellpadding="4" border="0" align="center">	
<tr>
	<td width="50%" valign="top">
		<table class="lfr-table">
		<tr height="30">
			<td><label for="<portlet:namespace/>isPhone">Hi&#7875;n th&#7883; tr&#432;&#7901;ng s&#7889; &#273;i&#7879;n tho&#7841;i:</label></td>
			<td><input type="checkbox" name="<portlet:namespace/>isPhone" id="<portlet:namespace/>isPhone" <%= isPhone.equals("true") ? "checked": ""%>></td>
		</tr>
		
		<tr height="30">
			<td><label for="<portlet:namespace/>isFax" >Hi&#7875;n th&#7883; tr&#432;&#7901;ng s&#7889; fax:</label></td>
			<td><input type="checkbox" name="<portlet:namespace/>isFax" id="<portlet:namespace/>isFax" <%= isFax.equals("true") ? "checked": ""%>></td>
		</tr>
			
		<tr height="30">
			<td><label for="<portlet:namespace/>isAddress">Hi&#7875;n th&#7883; tr&#432;&#7901;ng &#273;&#7883;a ch&#7881;:</label></td>
			<td><input type="checkbox" name="<portlet:namespace/>isAddress" id="<portlet:namespace/>isAddress" <%= isAddress.equals("true") ? "checked": ""%>></td>
		</tr>
			
		<tr height="30">
			<td><label for="<portlet:namespace/>isTyping">Hi&#7879;n th&#7883; b&#7897; g&#245; ti&#7871;ng vi&#7879;t:</label></td>
			<td><input type="checkbox" name="<portlet:namespace/>isTyping" id="<portlet:namespace/>isTyping" onClick ="javascript:<portlet:namespace/>hide2();" <%= isTyping.equals("true") ? "checked" :""%>></td>
		</tr>
		
		<tr id="<portlet:namespace/>style" style="display:<%= _isTyping ? "" : "none"%>">
			<td>
				<table>
				<tr height="30">
					<td width="5">
					<td><label for="<portlet:namespace/>style_1">B&#7897; g&#245; &#273;&#7847;y &#273;&#7911;</label></td>
					<td><input type="radio" name="<portlet:namespace/>style" id="<portlet:namespace/>style_1"  value="1" <%= style.equals("1")?"checked":"" %> /></td>
					
				</tr>
			
				<tr height="30">
					<td/>
					<td><label for="<portlet:namespace/>style_2">B&#7897; g&#245; &#273;&#417;n gi&#7843;n</label></td>
					<td><input type="radio" name="<portlet:namespace/>style"  id="<portlet:namespace/>style_2" value="2" <%= style.equals("2")?"checked":"" %> /></td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
	</td>
			
	<td valign="top">
		<table class="lfr-table">
		<!-- 
		<tr height="30">
			<td><label for="<portlet:namespace/>isCodeActive">Hi&#7875;n th&#7883; mă xác nh&#7853;n:</label></td>
			<td><input type="checkbox" name="<portlet:namespace/>isCodeActive" id="<portlet:namespace/>isCodeActive" ></td>
		</tr>
		-->
		
		<tr height="30">
			<td><label for="<portlet:namespace/>isAttach">G&#7917;i file &#273;&#237;nh k&#232;m:</label></td>
			<td><input type="checkbox" name="<portlet:namespace/>isAttach" id="<portlet:namespace/>isAttach" onClick ="javascript:<portlet:namespace/>hide1();" <%= isAttach.equals("true") ? "checked": ""%>></td>
		</tr>
		
		<tr height="30" id="<portlet:namespace/>numberAtt" style="display:<%= _isAttach ? "": "none" %>">
			<td>S&#7889; file &#273;&#237;nh k&#232;m:</td>
			<td>
				<select name="<portlet:namespace />numberAtt" style="width:50px">
				<%	for(int i=1; i< 6;i++){		%>
					<option value="<%=i%>" <%= Validator.equals(String.valueOf(i), numberAtt) ? "selected":"" %> ><%=i%></option>
				<%	} %>
				</select>
			</td>
		</tr>
			
		<%-- <tr height="30">
			<td>Tùy bi&#7871;n tiêu &#273;&#7873; liên hê:</td>
			<td><input type="text" name="<portlet:namespace/>title" style="width:210px" value="<%= title%>"></td>
		</tr>
			
		<tr height="30">
			<td>Tùy bi&#7871;n tiêu &#273;&#7873; Portlet</td>
			<td><input type="text" name="<portlet:namespace/>titlePortlet" style="width:210px" value="<%= titlePortlet%>"></td>
		</tr>	 --%>
		</table>
	</td>
</tr>
</table>	
</fieldset>
<div class="portlet-font" style="font-weight:bold;float:left; margin-right:10px">
	<input type="button" class="portlet-form-button" value="<liferay-ui:message key="save" />" onClick="<portlet:namespace />savePreferences();"/>		
</div>
<br/>
<br/>			
</form>
	