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
//	TFCategory tfCategory = TFCategoryServiceUtil.findCategory(Long.valueOf(_category));
//	catURL.setParameter("categoryId",String.valueOf(tfCategory.getId()));
%>

	<table class="new-vb org" width="100%" cellspacing="0" cellpadding="0" border="0" align="center">
		<tbody>
			<tr>
				<th class="t5">NÊN & KHÔNG NÊN</th>
			</td>
			<tr>
				<td>
					<table class="f-table" cellspacing="0" cellpadding="0" border="0" align="center">
						<tbody>
							<tr>
								<td>
									<a href="<%=catURL%>" ><!-- Get image of Category -->
										<img width="152" height="112" src="/html/portlet/vimagegallerymenu/images/f02.gif" title="NEN & KHONG NEN">
									</a>
								</td>
							</tr>							
						</tbody>
					</table>				
				</td>
			</tr>
		</tbody>
	</table>
		
	<div class="link-b u">
		<a href="<%=catURL%>">Xem ti&#7871;p </a>&raquo;
	</div>
