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
<%@ include file="/html/portlet/vcounter/init.jsp" %>
<c:choose>
    <c:when test="<%= style.equals(\"3\") %>"><!--So thanh vien truc tuyen-->
    	<%@ include file="/html/portlet/vcounter/includes/style03.jsp" %>
    </c:when>
    <c:when test="<%= style.equals(\"2\") %>"><!--So nguoi dang truc tuyen-->
    	<%@ include file="/html/portlet/vcounter/includes/style02.jsp" %>
    </c:when>
	<c:when test="<%= style.equals(\"1\") %>"><!--So luong truy cap-->
        <%@ include file="/html/portlet/vcounter/includes/style01.jsp" %>
    </c:when>    
</c:choose>