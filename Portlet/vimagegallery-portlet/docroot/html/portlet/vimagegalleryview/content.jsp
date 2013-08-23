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

<!-- List Image by Category -->
<%@include file="/html/portlet/vimagegalleryview/init.jsp"%>

<%
	TFCategory category = TFCategoryServiceUtil.findCategory(Long.valueOf(categoryId));	
	portletURL.setParameter("categoryId",String.valueOf(category.getId()));	
%>
<script type="text/javascript">
	var <portlet:namespace />imgArray1 = new Array();
	var <portlet:namespace />descArray = new Array();

	<%		
		List images = (List)request.getAttribute("listImage");
		
		for	(int i = 0; i < images.size(); i++) {			
			TFImage image = (TFImage)images.get(i);
	%>

		<portlet:namespace />imgArray1[<%= i %>] = "<%= themeDisplay.getPathImage() %>/vimagegallery?img_id=<%= image.getImage() %>&large=1" ;		
		<portlet:namespace />descArray[<%= i %>] = "<%= image.getName()%>";
	<%
	}

		int defaultSpeed = 3000;
	%>

	var <portlet:namespace />imgArrayPos = 0		
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

	
<script type="text/javascript">
	<portlet:namespace />play();
</script>


<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
  <tbody>
    <tr>
      <td><img src="<%= themeDisplay.getPathThemeImage() %>/DB_image/k_01.gif" width="23" border="0" height="23" /></td>
      <td width="100%" background="<%= themeDisplay.getPathThemeImage() %>/DB_image/kbg_01.gif"></td>
      <td><img src="<%= themeDisplay.getPathThemeImage() %>/DB_image/k_02.gif" width="23" border="0" height="23" /></td>
    </tr>
    <tr>
      <td background="<%= themeDisplay.getPathThemeImage() %>/DB_image/kbg_02.gif"></td>
      <td><div style="color:#FF3300;margin-bottom:10px;font-size:16px;" align="center">
      <strong >Tr&#236;nh di&#7877;n &#7843;nh <%=category.getName()%></strong></div>
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
						Ch&#7885;n t&#7889;c &#273;&#7897; trình di&#7877;n &#7843;nh <%=category.getName()%>
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
			<tr>
			 <td>&nbsp;
			 </td>
			</tr> 
		</table>
		</form>
		<div align="center">
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
		</div>
					  
	  </td>
      <td background="<%= themeDisplay.getPathThemeImage() %>/DB_image/kbg_03.gif"></td>
    </tr>
    <tr>
      <td><img src="<%= themeDisplay.getPathThemeImage() %>/DB_image/k_03.gif" width="23" border="0" height="23" /></td>
      <td width="100%" background="<%= themeDisplay.getPathThemeImage() %>/DB_image/kbg_04.gif"></td>
      <td><img src="<%= themeDisplay.getPathThemeImage() %>/DB_image/k_04.gif" width="23" border="0" height="23" /></td>
    </tr>
  </tbody>
</table>

</body>
</html>
