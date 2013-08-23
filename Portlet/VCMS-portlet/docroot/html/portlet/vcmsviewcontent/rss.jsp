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
<%@include file="/html/portlet/vcmsviewcontent/init.jsp"%>
<%
	String categoryId = ParamUtil.getString(request,"categoryId");
%>
<form name="<portlet:namespace/>fmRSS" method="POST">
<input type="hidden" name="categoryId" value="<%=categoryId%>"/>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
	      <tr>
			<td>
	        <table width="100%" border="0" cellspacing="0" cellpadding="0" align="left">
		          <tr>
		            <th class="hot-news"><p class="title01">RSS</p></th>
		          </tr>
        	</table>
	 	<table class="box-news" width="100%" border="0" cellspacing="0" cellpadding="0">
          
          <tr>
            <td>
              <p class="rss-title no-top">RSS là gì?</p>
			  <p class="al-j">RSS là t&#7915; vi&#7871;t t&#7855;t c&#7911;a Really Simple Syndication- D&#7883;ch v&#7909; cung c&#7845;p thông tin c&#7921;c kì &#273;&#417;n gi&#7843;n. D&#7883;ch v&#7909; này giúp b&#7841;n gi&#7843;i quy&#7871;t v&#7845;n &#273;&#7873; v&#7873; tính c&#7853;p nh&#7853;t c&#7911;a thông tin b&#7857;ng vi&#7879;c cung c&#7845;p cho b&#7841;n nh&#7919;ng thông tin m&#7899;i nh&#7845;t mà b&#7841;n &#273;ang quan tâm.</p>

<p>Hi&#7879;n t&#7841;i không ph&#7843;i b&#7845;t c&#7913; trang web nào c&#361;ng cung c&#7845;p RSS, nh&#432;ng d&#7883;ch v&#7909; này s&#7869; d&#7847;n tr&#7903; nên ph&#7893; bi&#7871;n. Nhi&#7873;u trang web tin t&#7913;c nh&#432; BBC, CNN, và New York Times &#273;ang cung c&#7845;p RSS.
</p>
			  <div class="rss-link">
			    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td>
                      		<a href="javascript:void(0);" onclick="javascript:<portlet:namespace/>submitFormRSS();">
			  					<img src="/html/portlet/vcmsviewcontent/images/rss.png" title="Xu&#7845;t b&#7843;n RSS"> <b>Xu&#7845;t b&#7843;n RSS cho chuyên m&#7909;c này</b>
			  				</a>
                    </td>
                  </tr>
                </table>
			  </div>
			  <p class="rss-title">Các gi&#7899;i h&#7841;n s&#7917; d&#7909;ng</p>
			  <p class="al-j">Nhìn chung, &#273;&#7847;u tiên b&#7841;n c&#7847;n có m&#7897;t th&#7913; g&#7885;i là trình &#273;&#7885;c tin (news reader). Có r&#7845;t nhi&#7873;u ki&#7875;u trình &#273;&#7885;c tin, m&#7897;t s&#7889; &#273;&#432;&#7907;c nhúng tr&#7921;c ti&#7871;p trong trình duy&#7879;t, m&#7897;t s&#7889; là các &#7913;ng d&#7909;ng có th&#7875; t&#7843;i v&#7873; t&#7915; Internet. T&#7845;t c&#7843; nh&#7919;ng công c&#7909; này s&#7869; giúp b&#7841;n có th&#7875; xem &#273;&#432;&#7907;c thông tin và &#273;&#259;ng kí s&#7917; d&#7909;ng danh m&#7909;c tin c&#7911;a RSS.</p>

<p class="al-j">Sau khi b&#7841;n &#273;ã ch&#7885;n &#273;&#432;&#7907;c m&#7897;t trình &#273;&#7885;c tin, t&#7845;t c&#7843; nh&#7919;ng gì b&#7841;n ph&#7843;i làm là l&#7921;a ch&#7885;n n&#7897;i dung thông tin mà b&#7841;n c&#7847;n. Ví d&#7909; nh&#432; b&#7841;n c&#7847;n thông tin m&#7899;i nh&#7845;t v&#7873; công ngh&#7879; thông tin, b&#7841;n có th&#7875; s&#7917; d&#7909;ng nút RSS màu cam c&#7911;a m&#7909;c Nh&#7883;p s&#7889;ng s&#7889;. Có th&#7875; kéo/th&#7843; nút này vào trong trình &#273;&#7885;c tin c&#7911;a b&#7841;n, ho&#7863;c c&#7855;t/dán Url vào ch&#7913;c n&#259;ng thêm danh m&#7909;c tin c&#7911;a trình &#273;&#7885;c tin.</p>

<p class="al-j">M&#7897;t s&#7889; trình duy&#7879;t, trong &#273;ó có Firefox, Opera và Safari, có ch&#7913;c n&#259;ng t&#7921; &#273;&#7897;ng ch&#7885;n danh m&#7909;c tin RSS cho b&#7841;n. N&#7871;u c&#7847;n bi&#7871;t thông tin c&#7909; th&#7875; h&#417;n, b&#7841;n có th&#7875; xem thông tin trên các trang ch&#7911; c&#7911;a các trình duy&#7879;t &#273;ó.</p>

<p class="al-j">Có r&#7845;t nhi&#7873;u lo&#7841;i trình &#273;&#7885;c tin khác nhau và các phiên b&#7843;n &#273;&#432;&#7907;c th&#432;&#7901;ng xuyên c&#7853;p nh&#7853;t. M&#7895;i lo&#7841;i trình &#273;&#7885;c tin l&#7841;i &#273;òi h&#7887;i m&#7897;t h&#7879; &#273;i&#7873;u hành khác nhau, do &#273;ó b&#7841;n ph&#7843;i cân nh&#7855;c v&#7873; &#273;i&#7873;u &#273;ó khi l&#7921;a ch&#7885;n trình &#273;&#7885;c tin.</p></td>
          </tr>
        </table>

		</td>
      </tr>
    </table>
</form>