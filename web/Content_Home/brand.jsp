<%-- 
    Document   : brand
    Created on : Dec 13, 2025, 4:58:17 PM
    Author     : DELL P5530
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/content.css"/>
        <title>Brand</title>
    </head>
    <body>
        <h2>Thương Hiệu</h2>
        <div class="brand-images">
            <c:set var="list_brand" value="${requestScope.brand_list}"/>
            <c:forEach items="${list_brand}" var="lb">
                <a href="#"><img src="./images/${lb.images}" alt="alt"/></a>
            </c:forEach>
        </div>
    </body>
</html>
