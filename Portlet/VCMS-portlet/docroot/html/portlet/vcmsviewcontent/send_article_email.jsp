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
	<!--Send Article to Friend-->
		<div class="overlay"></div>
		<div class="box_guiban" id="box_guiban" style="display:none">			
			<p class="tit_guiban bold white"><%= LanguageUtil.get(pageContext, "portlet.vcmsviewcontent.sendemail.title") %></p>
			<p class="sign_success"><%= LanguageUtil.get(pageContext, "portlet.vcmsviewcontent.sendemail.success") %> </p>
			<p class="close_popup"><a href="#demo" class="but_form bold white" onclick="showSendFriend('false'); return false; "><%= LanguageUtil.get(pageContext, "vportal.moc.cms.sent-friend.cancel") %></a></p>
					<form action="" method="POST" class="form-gopy" name="form_gopy">
							<input type="hidden" name="articleid" id="articleid" value="<%=article.getArticleId()%>" />
							<table width="100%" border="0" cellspacing="5" cellpadding="0" align="left">
					            <tr>
					              <td width="110"><label>Tên ng&#432;&#7901;i g&#7917;i:</label></td>
					              <td><input type="text" name="fromname" id="fromname" style="width:183px" value="" /></td>
					            </tr>
					            <tr>
					              <td><label>Email:</label></td>
					              <td><input type="text" name="fromaddress" id="fromaddress" style="width:183px" value="" /></td>
					            </tr>
								<tr>
					              <td><label>Tên ng&#432;&#7901;i nh&#7853;n:</label></td>
					              <td><input type="text" name="toname" id="toname" style="width:183px" value="" /></td>
					            </tr>
		
					            <tr>
					              <td><label>G&#7917;i &#273;&#7871;n (email):</label></td>
					              <td><input type="text" name="toaddress" id="toaddress" style="width:183px" value="" /></td>
					            </tr>
					            <tr>
					              <td><label>L&#7901;i nh&#7855;n:</label></td>
					              <td><textarea name="content" id="content" style="width:329px; height:120px"></textarea></td>
					            </tr>
					            <tr>
					              <td colspan="2" align="center">
					                <br/><input type="button" id = "submit" name="submit" onclick="javascript:sentToFriend()" value="G&#7917;i Email"> <input type="button" onclick="showSendFriend('false'); return false; " value="&#272;óng c&#7917;a s&#7893;">
					               </td>
					            </tr>
					          </table>
						</form>
		</div>