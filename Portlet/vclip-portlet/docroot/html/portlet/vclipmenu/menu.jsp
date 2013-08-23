<%@page import="com.liferay.portal.model.Layout"%>
<%@ include file="/html/portlet/vclipmenu/init.jsp" %>

<jsp:directive.page import="com.vportal.portlet.vclip.util.WebKeysVClip"/>
<jsp:directive.page import="com.vportal.portlet.vclip.service.*"/>
<jsp:directive.page import="com.vportal.portlet.vclip.model.*"/>
<jsp:directive.page import="com.vportal.portlet.vclip.model.impl.*"/>
<jsp:directive.page import="java.util.ArrayList"/>
<jsp:directive.page import="com.liferay.portal.model.Portlet"/>
<jsp:directive.page import="com.liferay.portal.kernel.util.WebKeys"/>
<%@page import="com.vportal.portal.util.PortalUtilExt"%>




<%
	
 	long groupId = PortalUtilExt.getPortletGroupId(request);
 	long currentPlid = PortalUtilExt.getPlid(request);
 	long plId = 0;
 	try{
 		if(Validator.isNotNull(selectPortletLayout) && selectPortletLayout.equals("1")){
			
			Layout firstLayout = (Layout)selectLayouts.get(0);
			long firstLayoutId = firstLayout.getPlid();			
			String firstPortletId = LayoutPortletUtil.getPortletIdsByLayout(firstLayoutId).get(0).toString();			
 			plId = PortalUtilExt.getPlid(groupId, currentPlid, firstPortletId);			
 			portletSelectId = firstPortletId;			
 		}else{
 			plId = PortalUtilExt.getPlid(groupId, currentPlid, portletSelectId);
 		}
 	}catch(Exception ex){
 		System.out.println(ex.toString());
 	}	
 	PortletURL categoryURL = PortletURLFactoryUtil.create(request,portletSelectId, plId, PortletRequest.RENDER_PHASE);
	categoryURL.setParameter("ajax_type", "ClipByType");
	categoryURL.setParameter("jspPage","/html/portlet/vclipcontent/view.jsp");
	categoryURL.setParameter("groupId", String.valueOf(groupId));	
	List clipTypeList = ClipTypeServiceUtil.findAll();

	%>
	
	<div class="wd-left-content">
		<div class="wd-boxs wd-boxs-first">
			<h2 class="wd-tlh1-1 wd-alignment">Chuy&#234;n m&#7909;c</h2>
			<ul class="wd-list-link">
				<%											
					for(int i=0;i<clipTypeList.size();i++){ 							
 						ClipType t=(ClipType)clipTypeList.get(i);	
						//PortletURL categoryURL = PortletURLFactoryUtil.create(request,portletSelectId,plId,PortletRequest.RENDER_PHASE);								
						categoryURL.setParameter(WebKeysVClip.CLIP_TYPE_ID,String.valueOf(t.getId()));							
				%>
					<li><a href="<%=categoryURL %>"><%= t.getTitle() %></a> </li>
	
				<%}%>
			</ul>
		</div>
	</div>

	