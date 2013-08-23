<%@page import="com.liferay.portal.kernel.captcha.CaptchaTextException"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@ include file="/html/portlet/vcontactview/init.jsp" %>
<%@taglib prefix="vportal" uri="http://www.vietsoftware.com/tld" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<script  src="/html/portlet/vcontactview/vietuni.js" type="text/javascript"></script>
<script>	
	function <portlet:namespace />submitForm(type) {		
		
		var myform = document.<portlet:namespace />fm;		
		
		var name = document.<portlet:namespace />fm.<portlet:namespace />guestName;
		var email = document.<portlet:namespace />fm.<portlet:namespace />email;
		var title = document.<portlet:namespace />fm.<portlet:namespace />title;
		var content = document.<portlet:namespace />fm.<portlet:namespace />content;
		alert('abc');		
		if(name.value==""){
			alert("<%=LanguageUtil.get(pageContext,"vportal.portlet.gcadmin.mustEnterName")%>");
			showErrorField(name);			
			return false;
		}
		if(name.value.length > 99){
			alert("<%=LanguageUtil.get(pageContext,"vportal.portlet.gcadmin.characterLestThan")+" 300" %>");
			showErrorField(name);
			return false;
		}
		
		//Validate Email
		var r = new RegExp(/^\w+(\.[a-zA-Z]+)*\w*@(\w+\.([a-zA-Z])+){1,4}$/);
		

			
		if(!r.test(email.value)){
			alert("<%=LanguageUtil.get(pageContext,"vportal.portlet.gcadmin.invalidEmail")%>");
			showErrorField(email);
			clearField(email)
			return false;
		}
		
		if(title.value==""){
			alert("<%=LanguageUtil.get(pageContext,"vportal.portlet.gcadmin.mustEnterTitle")%>");
			showErrorField(title);
			return false;
		}
				
		if(title.value.length > 300){
			alert("<%=LanguageUtil.get(pageContext,"vportal.portlet.gcadmin.characterLestThan")+" 300"%>");
			showErrorField(title);
			return false;
		}
		
		if(content.value==""){
			alert("<%=LanguageUtil.get(pageContext,"vportal.portlet.gcadmin.mustEnterContent")%>");
			showErrorField(content);
			return false;
		}		
		if(content.length > 30000){
			alert("<%=LanguageUtil.get(pageContext,"vportal.portlet.gcadmin.characterLestThan")+" 10000"%>");
			showErrorField(content);
			return false;
		}
		submitForm(document.<portlet:namespace />fm, '<portlet:actionURL windowState="<%=WindowState.MAXIMIZED.toString()%>" name="_add"></portlet:actionURL>');
	}
	
	
	function <portlet:namespace />Clear(){
		var myform = document.<portlet:namespace />fm;		
		var name = document.<portlet:namespace />fm.<portlet:namespace />guestName;
		var email = document.<portlet:namespace />fm.<portlet:namespace />email;
		var title = document.<portlet:namespace />fm.<portlet:namespace />title;
		var phone = document.<portlet:namespace />fm.<portlet:namespace />phone;
		var content = document.<portlet:namespace />fm.<portlet:namespace />content;
		var address = document.<portlet:namespace />fm.<portlet:namespace />address;
		var fax = document.<portlet:namespace />fm.<portlet:namespace />fax;
		
		clearField(name);
		clearField(email);
		clearField(title);
		clearField(phone);
		clearField(address);
		clearField(content);
		clearField(fax);
	}
	
	function gf(p_el) {	}
	function lf(p_el) {	}
	setTypingMode(4); 
</script>
	
<script language="JavaScript1.2" src="/html/portlet/vcontactview/vietuni.js" type="text/javascript"></script>
<script language="JavaScript1.2"> setTypingMode(4); </script>
<script language="JavaScript"></script>	
	
<%

	
	
	VContact vcontact = (VContact)request.getAttribute("contact");
	if (vcontact == null){
		vcontact = new VContactImpl();
	}
	
	String Id = ((vcontact != null && Long.toString(vcontact.getId()) != null) ? Long.toString(vcontact.getId()) : null);
	
	String isPhone = prefs.getValue("isPhone","true");
	String isFax = prefs.getValue("isFax","true");
	String isAddress = prefs.getValue("isAddress","true");
	String isAttach  = prefs.getValue("isAttach","true");
	String isTyping = prefs.getValue("isTyping","true");
	String isCodeActive = prefs.getValue("isCodeActive","true");
	String numberAtt = prefs.getValue("numberAtt","1");
	String style = prefs.getValue("style","1");
	String title = prefs.getValue("title","");
	String titlePortlet = prefs.getValue("titlePortlet","Liên h&#7879;");
	
	boolean _isCodeActive = Boolean.valueOf(isCodeActive);
	boolean _isPhone = Boolean.valueOf(isPhone);
	boolean _isFax = Boolean.valueOf(isFax);
	boolean _isAddress = Boolean.valueOf(isAddress);
	boolean _isAttach = Boolean.valueOf(isAttach);
	boolean _isTyping = Boolean.valueOf(isTyping);	
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/vcontactview/view");
	
	
%>	
<liferay-ui:error exception="<%= CaptchaTextException.class %>" message="text-verification-failed" />	
<form action="<portlet:actionURL><portlet:param name="struts_action" value="/vcontactview/view" />
	</portlet:actionURL>" method="post" name="<portlet:namespace />fm" enctype="multipart/form-data">
	<input type="hidden" name="<portlet:namespace />cmd" value="doadd" />
	<input type="hidden" name="<portlet:namespace />Id" value="" /> 
	<input type="hidden" name="<portlet:namespace />redirect" value="<%=portletURL%>" />
	<input type="hidden" name="<portlet:namespace />groupId" value="<%=groupId%>" />

	<h2 class="wd-tlh1-5">Li&#234;n H&#7879; C&#7893;ng</h2>
	<div class="wd-boxs wd-boxs-contact">	
		<div class="wd-introduction">
			<div class="wd-contact">
				<div class="wd-sidebar-contact">
					<h3 class="wd-tlh3-sidebar">Th&#244;ng tin li&#234;n h&#7879;</h3>
						<ul class="wd-list-contact">
							<li>
								<p class="wd-c-upper">CÔNG TY CỔ PHẦN PHẦN MỀM VIỆT (VIETSOFTWARE)</p>
								<p><strong>Trụ sở:  Tầng 12A, số 18 Tam Trinh - VTC Online Building, Hà Nội, Việt Nam</strong></p>
								<p>ĐT: (84-4) 3974 5699 - Fax: (84-4) 3974 5700</p>
								<p>Website: <a href="http://vietsoftware.com">http://vietsoftware.com</a></p>
							</li>
							<li>
							<div>
								<p class="wdt-email">Email:&nbsp;</p>
								<ul class="wd-link-mail">
									<li><a href="mailto:contact@vietsoftware.com">contact@vietsoftware.com</a></li>
<!-- 									<li><a href="mailto:congdan@hanoi.gov.vn">congdan@hanoi.gov.vn</a></li> -->
<!-- 									<li><a href="mailto:kythuat_cgtdt@hanoi.gov.vn">kythuat_cgtdt@hanoi.gov.vn</a></li> -->
								</ul>
							</div>
							</li>
						</ul>
						<ul class="wd-editorial">
							<li><strong>Phòng quản trị mạng và hệ thống</strong><span class="wd-tel">043.974.5699 (107)</span></li>
<!-- 							<li><strong>Ph&#242;ng Bi&#234;n t&#7853;p - Ph&#243;ng vi&#234;n</strong><span class="wd-tel">04.35.121.395</span></li> -->
<!-- 							<li><strong>Ph&#242;ng H&#224;nh ch&#237;nh c&#244;ng</strong><span class="wd-tel">04 35.123.123</span></li> -->
<!-- 							<li><strong>Ph&#242;ng Quay phim</strong><span class="wd-tel">04.35.123.806</span></li> -->
							<li><strong>Phòng hỗ trợ và chăm sóc khách hàng</strong><span class="wd-tel">043.974.5678</span></li>
							<li><strong>Hỗ trợ kỹ thuật</strong><span class="wd-tel">043.974.5699 (105)</span></li>
						</ul>
					</div>
					<div class="wd-content-contact">
						<h3>Gửi góp ý tới Công ty Cổ phần Phần mềm việt (VietSoftware)
						</h3>
					<fieldset>		
					<div class="wd-input">
						<label for="name"><%= LanguageUtil.get(pageContext, "com.vportal.portlet.vcontact.name") %>:</label>
						<input type="text" id="name" name="<portlet:namespace />guestName" onKeyUp="telexingVietUC(this,event);">
					</div>
														
					<div class="wd-input">
						<label for="email">Email:</label>
						<input type="text" name="<portlet:namespace />email" >
					</div>
									
					<c:if test="<%= _isPhone%>">
						<div class="wd-input">
							<label for="phone"><%= LanguageUtil.get(pageContext, "com.vportal.portlet.vcontact.phone") %>:</label>
							<input type="text" name="<portlet:namespace />phone" onKeyUp="telexingVietUC(this,event);" >
						</div>
					</c:if>
											
					<c:if test="<%= _isFax%>">
						<div class="wd-input">
							<label for="address">S&#7889; fax</label>
							<input type="text" name="<portlet:namespace />fax" onKeyUp="telexingVietUC(this,event);">
						</div>
					</c:if>								
					<c:if test="<%= _isAddress%>">
						<div class="wd-input">
							<label for="wtitle"><%= LanguageUtil.get(pageContext, "com.vportal.portlet.vcontact.address") %>:</label>
							<input type="text" name="<portlet:namespace />address" onKeyUp="telexingVietUC(this,event);">
						</div>
					</c:if>
						
					<div class="wd-input">
						<label for="wtitle"><%= LanguageUtil.get(pageContext, "com.vportal.portlet.vcontact.title") %>:</label>
						<input type="text" name="<portlet:namespace />title" onKeyUp="telexingVietUC(this,event);">
					</div>
						
					<div class="wd-input wd-area">
						<label for="message"><%= LanguageUtil.get(pageContext, "com.vportal.portlet.vcontact.content") %>:</label>
						<c:if test="<%= _isTyping%>">						
							<c:if test="<%= style.equals(\"1\")%>">
								<label><input type="radio" name="<portlet:namespace/>switch" value="OFF"   onFocus="setTypingMode(0)" />T&#7855;t</label>
								<label><input type="radio" name="<portlet:namespace/>switch" value="TELEX" onFocus="setTypingMode(1)" checked>T&#7921; &#273;&#7897;ng</label>
								<label><input type="radio" name="<portlet:namespace/>switch" value="TELEX" onFocus="setTypingMode(1)" />Telex</label>
								<label><input type="radio" name="<portlet:namespace/>switch" value="VNI" 	onFocus="setTypingMode(2)" />VNI</label>
								<label><input type="radio" name="<portlet:namespace/>switch" value="VIQR" 	onFocus="setTypingMode(3)" />VIQR</label>
							</c:if>
							<c:if test="<%= style.equals(\"2\")%>">
								<label><input type="radio" name="<portlet:namespace/>switch" value="OFF"   onFocus="setTypingMode(0)" /><%= LanguageUtil.get(pageContext, "com.vportal.portlet.vcontact.type") %></label>
								<label><input type="radio" name="<portlet:namespace/>switch" value="TELEX" onFocus="setTypingMode(1)" checked>Telex</label>	
							</c:if>			
						</c:if>			
						<textarea name="<portlet:namespace />content" style="width:375px; height:120px" onKeyUp="initTyper(this)"></textarea>
					</div>
						
					<c:if test="<%= _isAttach%>">
						<label>Ch&#7885;n file:</label>
						<vportal:file-upload entryId="<%=GetterUtil.getLong(Id , 0)%>" entryClass="<%=VContact.class%>" maxAttachment="<%= Integer.valueOf(numberAtt)%>" style="2"/>
					</c:if>	
					<div class="wd-input">
    					 <label for="code">M&#227; captcha:</label>
    					 <div class="wd-verification">
      						<portlet:resourceURL var="captchaURL" />
      						<liferay-ui:captcha url="<%= captchaURL.toString() %>" />
     					</div>
     
    				</div>
    				<div class="wd-input">
     					<label style="width:108px;" for="code">Nh&#7853;p m&#227;:</label>
     					<input type="text" id="validatorCaptchaId" style="width: 13%;"  name="<portlet:namespace/>validatorCaptcha" value="" />     
   	 				</div>
					<div class="wd-submit">
						<input  type="button" value="<liferay-ui:message key="send" />" onclick="<portlet:namespace />submitForm(1)">
					</div>
					</fieldset>
				</div>
			</div>
		</div>
	</div>			
</form>


