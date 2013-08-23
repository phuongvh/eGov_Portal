<%--/**
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
 */ --%>
<%@ include file="/html/portlet/vclipcontent/init.jsp" %>

<script>

	
	function getObj(id){  
	    var d=document;
	    var obj=d.getElementById(id);
	    if(obj==null){
	            try{ obj=d.all(id);} catch(ex){};
	            if(obj==null){
	               try{ obj=d.layers[id];}catch(ex){};
	            }
	    }
	    if(obj==null && id.innerHTML) {
	        obj=id;
	    }    
	    return obj;
	}
	
	
	function hideshow(index){
		if(index == 1){
			getObj("divStyle1").style.display = "block";
			getObj("divStyle2").style.display="none";
		}
		else if(index == 2){
			getObj("divStyle1").style.display = "none";
			getObj("divStyle2").style.display="block";
		}
	}
</script>
<portlet:actionURL name="EditPreferenceAction" var="EditPreferenceActionURL"/>
<form name="<portlet:namespace />fm" method="POST" action="<%= EditPreferenceActionURL.toString()%>">
<input type="hidden" name="<portlet:namespace/><%=Constants.CMD%>" value="<%=Constants.UPDATE%>">
	<fieldset class="text_none" style="border: 1px dotted gray">
		<legend> Ch&#7885;n style </legend>
			<table width="100%">
				<tr>
					<td height="30"><input onClick="hideshow(1);"  id="<portlet:namespace/>displayStyle" type="radio" name="<portlet:namespace/>displayStyle" value="1" <%=displayStyle.equals("2")?"checked='true'":""%>/></td>
					<td>Style 1 (1 column)</td>
				</tr>
				<tr>
					<td height="30" width="25"><input onClick="hideshow(2);" type="radio"  id="<portlet:namespace/>displayStyle" name="<portlet:namespace/>displayStyle" value="2" <%=displayStyle.equals("1")?"checked='true'":""%> /></td>
					<td>Style 2 (2 column)</td>
				</tr>
			</table>
			<table>
				<tr height="25">
					<td colspan="3"><b>C&#7845;u h&#236;nh chung</b></td>
				</tr>
				<tr height="25">
					<td>Hi&#7875;n th&#7883; mi&#234;u t&#7843; clip : </td>
					<td width="15"></td>
					<td>
						<input type="checkbox" name="<portlet:namespace/>allowDescription" id="<portlet:namespace/>allowDescription" value="true" <%=allowDescription.equals("true")?"checked":""%> />
					</td>
				</tr>
				<tr height="25">
					<td>Cho ph&#233;p t&#7843;i v&#7873; : </td>
					<td></td>
					<td>
						<input type="checkbox" name="<portlet:namespace/>allowDownload" id="<portlet:namespace/>allowDownload" value="true" <%=allowDownload.equals("true")?"checked":""%>/>
					</td>
				</tr>
				<tr height="25">
					<td>S&#7889; clip hi&#7875;n th&#7883;</td>
					<td></td>
					<td>
						<select name="<portlet:namespace/>displayClipNumber">
							<%
								for(int i=1;i<30;i++){
							%>
							<option value="<%=i%>" <%=displayClipNumber.equals(String.valueOf(i))?"selected":""%> ><%=i%></option>
							<%
								}
							%>
						</select>
					</td>
				</tr>
			</table>	
			<table>
				<tr>
					<td>
							<div id="divStyle1" style="<%=displayStyle.equals("1")?"display:none":""%>">
								
							</div>	
					</td>
				</tr>
			</table>
			<table>
				<tr>
					<td>
							<div id="divStyle2" style="<%=displayStyle.equals("2")?"display:none":""%>">
								
							</div>	
					</td>
				</tr>				
			</table>
			
	</fieldset>
	<div>
		<input type="submit" class="portlet-form-button" value="<liferay-ui:message key="save" />" />
	</div>
</form>
