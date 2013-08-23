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

<%@ include file="init.jsp" %>
<script type="text/javascript">
	var <portlet:namespace />imgArray1 = new Array();
	var <portlet:namespace />descArray = new Array();

	<%	String strCategoryId = ParamUtil.getString(request,"categoryId","0");
		TFCategory category = (TFCategory) request.getAttribute("category");
		if(category == null){
			category = new TFCategoryImpl();
		}
		
		List categorys = new ArrayList();
		List images = new ArrayList();
		
		categorys = TFCategoryServiceUtil.getByGroupId(groupId);
		if(strCategoryId.equals("0")){
			images= TFImageServiceUtil.getByGroupId(groupId);
		}else{
			images = TFImageServiceUtil.getByG_C(groupId, Long.parseLong(strCategoryId));
		}
		for	(int i = 0; i < images.size(); i++) {			
			TFImage image = (TFImage)images.get(i);
	%>

		<portlet:namespace />imgArray1[<%= i %>] = "<%= themeDisplay.getPathImage() %>/vimagegallery?img_id=<%= image.getImage() %>&large=1" ;		
		<portlet:namespace />descArray[<%= i %>] = "<%= image.getName()%>";
	<%
	}

		int defaultSpeed = 3000;
	%>

	var <portlet:namespace />imgArrayPos = 0;		
	var <portlet:namespace />speed = <%= defaultSpeed %>;
	var <portlet:namespace />timeout = 0;

	function <portlet:namespace />pause() {
		clearInterval(<portlet:namespace />timeout);
		<portlet:namespace />timeout = 0;
	}

	function <portlet:namespace />play() {
		if (<portlet:namespace />timeout == 0) {
			<portlet:namespace />timeout = setInterval("<portlet:namespace />showNext()", <portlet:namespace />speed);
		}
	}

	function <portlet:namespace />showNext() {
		<portlet:namespace />imgArrayPos++;

		if (<portlet:namespace />imgArrayPos == <portlet:namespace />imgArray1.length){
			<portlet:namespace />imgArrayPos = 0;
		}			
		document.images.<portlet:namespace />slideShow1.src = <portlet:namespace />imgArray1[<portlet:namespace />imgArrayPos];	
		
	}

	function <portlet:namespace />showPrevious() {
		<portlet:namespace />imgArrayPos--;

		if (<portlet:namespace />imgArrayPos < 0) {
			<portlet:namespace />imgArrayPos = <portlet:namespace />imgArray1.length - 1;
		}		
		document.images.<portlet:namespace />slideShow1.src = <portlet:namespace />imgArray1[<portlet:namespace />imgArrayPos];		
	}
</script>
<form>

<table border="0" cellpadding="4" cellspacing="0" align="center">
	<tr>
		<td>
			<div class="portlet-font" style="font-weight: bold; float: left; margin-right: 10px">
				<input type="button" value="<liferay-ui:message key="previous" />" onClick="<portlet:namespace />showPrevious();" />
			</div>	
			<div class="portlet-font" style="font-weight: bold; float: left; margin-right: 10px">			    	
				<input type="button" value="<liferay-ui:message key="play" />" onClick="<portlet:namespace />play();" />
			</div>
			<div class="portlet-font" style="font-weight: bold; float: left; margin-right: 10px">		
				<input type="button" value="<liferay-ui:message key="pause" />" onClick="<portlet:namespace />pause();" />
			</div>
			<div class="portlet-font" style="font-weight: bold; float: left; margin-right: 10px">				
				<input type="button" value="<liferay-ui:message key="next" />" onClick="<portlet:namespace />showNext();" />
			</div>		

			<div class="portlet-font" style="font-weight: bold; float: left; margin-right: 10px">		
				Ch&#7885;n t&#7889;c &#273;&#7897; trình di&#7877;n &#7843;nh
			</div>
			<div class="portlet-font" style="font-weight: bold; float: left; margin-right: 10px">				
				<select onChange="<portlet:namespace />pause(); <portlet:namespace />speed = this[this.selectedIndex].value * 1000; <portlet:namespace />play();">
					<%
					for (int i = 1; i <= 10; i++) {
					%>	
						<option <%= (defaultSpeed / 1000) == i ? "selected" : "" %> value="<%= i %>"><%= i %></option>
					<%
					}
					%>
				</select>
			</div>					
		</td>
	</tr>
</table>
</form>
	
<script type="text/javascript">
	<portlet:namespace />play();
</script>

<br>

<table border="0" cellpadding="4" cellspacing="0" align="center">
	<%
		if (images.size() > 0) {
		TFImage image = (TFImage)images.get(0);
	%>
		
	<tr>			
		<td>	
			<img border="0" name="<portlet:namespace />slideShow1" 
				src="<%= themeDisplay.getPathImage() %>/vimagegallery?img_id=<%= image.getImage() %>&large=1">
		</td>		
	</tr>	

	<%
		}
	%>	
</table>