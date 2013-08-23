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
<jsp:directive.page import="com.vportal.portlet.vclip.model.Clip"/>
<%@ include file="/html/portlet/manage_vclip/init.jsp" %>
<script type="text/javascript">
   function playswf(url, img)
   {
          var s1 = new SWFObject("/html/portlet/vclip/mediaplayer.swf","mediaplayer","365","320","7");
       	s1.addParam("allowfullscreen","true");
        s1.addVariable("displayheight","300");
        s1.addVariable("width","365");
        s1.addVariable("height","320");       
      	s1.addVariable("image",img);
     	s1.addVariable("file",escape(url));
        s1.addVariable("showstop","false");
        s1.addVariable("autostart","false");
        s1.addVariable("backcolor","0x000000");
        s1.addVariable("lightcolor","0x000000");
        s1.addVariable("frontcolor","0xFEFEFE");
         s1.write("container");
   }
</script>

<%
	Clip clip=(Clip)request.getAttribute(WebKeysVClip.CLIP);
	if(clip==null){
		clip=new ClipImpl();
	}
	
	ClipType searchClipType=new ClipTypeImpl();
//	searchClipType.setLanguage(language);
	
	List clipTypeList=ClipTypeServiceUtil.findClipType(searchClipType);

	ClipType clipType=null;
	for(int i=0;i<clipTypeList.size();i++){
		clipType=(ClipType)clipTypeList.get(i);
		if(clipType.getId().equals(clip.getClipTypeId())){
			break;
		}
	}
	if(clipType==null){
		clipType=new ClipTypeImpl();
	}
%>
<liferay-ui:tabs names="<%=tab1Names %>" url="<%=portletURL.toString() %>">		
</liferay-ui:tabs>
<table align="center">
	<tr>		
		<td colspan="2" valign="top">
			<table align="center" >
				<input type="hidden" name="<%=Constants.CMD %>" value="<%=Constants.SEARCH %>"  >
				<tr>		
					<td colspan="2" align="center"><Strong>Clip Info<br></Strong></td>		
				</tr>
				<tr>
					<td><%= LanguageUtil.get(pageContext, "portlet.vcms.language") %>:</td>
					<td >
						<%
						
						for (int i = 0; i < locales.length; i++) {
							if(language.equals(locales[i].getLanguage() + "_" + locales[i].getCountry())){
						%>
								<input readonly="readonly"  size="60" name="language" value="<%= locales[i].getDisplayName(locales[i]) %>" >
						<% 	
								break;
							}
						}
						%>
					</td>
				</tr>		
				<tr>		
					<td><%=LanguageUtil.get(pageContext,"vportal.vclip.cliptitle.name") %>:</td>		
					<td><input readonly="readonly"  size="60" name="name" value="<%=clipType.getName() %>" ></td>
				</tr>
				
				<tr>		
					<td><%=LanguageUtil.get(pageContext,"vportal.vclip.clip.name") %>:</td>		
					<td><input readonly="readonly"  size="60" name="name" value="<%=clip.getName() %>" ></td>		
				</tr>
				
				<tr>		
					<td><%=LanguageUtil.get(pageContext,"vportal.vclip.clip.url") %>:</td>		
					<td><input readonly="readonly"  size="60" name="url" value="<%=clip.getUrl() %>" ></td>		
				</tr>
				
				<tr>		
					<td><%=LanguageUtil.get(pageContext,"vportal.vclip.cliptitle.createdDate") %>:</td>		
					<td><input readonly="readonly"  size="60" name="createdDate" value="<%=(clip.getCreatedDate()==null)?"":formatter.format(clip.getCreatedDate() )%>" ></td>		
				</tr>
				
				<tr>		
					<td><%=LanguageUtil.get(pageContext,"vportal.vclip.cliptitle.modifiedDate") %>:</td>	
					<td><input readonly="readonly" size="60" name="modifiedDate" value="<%=(clip.getModifiedDate()==null)?"":formatter.format(clip.getModifiedDate())%>"></td>		
				</tr>
				
				<tr>		
					<td valign="top"><%=LanguageUtil.get(pageContext,"vportal.vclip.cliptitle.title") %>:</td>		
					<td></td>		
				</tr>
				
				<tr>		
					<td colspan="2"><textarea readonly="readonly" rows="4" cols="90" name="title"><%=clip.getTitle() %></textarea></td>		
				</tr>
				
			</table>
		</td>
	</tr>
</table>
<br>
<div align="center" id="container">
	<script type="text/javascript">
		    <%
	    		String clipURL = clip.getUrl();	    	
	    	%>	    
	      playswf('<%= themeDisplay.getPathMain()%>/document_library/get_file?p_l_id=<%= themeDisplay.getPlid() %><%= clipURL %>','<%= themeDisplay.getPathImage() %>/image_gallery?img_id=<%= clip.getImage() %>');	    		   
	</script>
</div>
<br>
<fieldset>
<legend><%=LanguageUtil.get(pageContext,"vportal.vclip.cliptitle.description") %>:</legend>
	<%=clip.getDescription() %>	
	<br><br>
</fieldset>	
<br>
<div align="center">
	<input class="portlet-form-button" type="button" value="<%=LanguageUtil.get(pageContext,"vportal.vclip.cancel") %>"
		onclick="javascript:document.location='<portlet:renderURL>
		<portlet:param name="struts_action" value="/vclip/cliptype" />
		<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.CANCEL%>" />
		<portlet:param name="tabs1" value="<%=tabs1%>" />
		<portlet:param name="language" value="<%=language %>" />
		</portlet:renderURL>'" >
</div>
	

	