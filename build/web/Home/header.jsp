<%-- 
    Document   : header
    Created on : Dec 5, 2025, 10:43:04 PM
    Author     : DELL P5530
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css"/>
        <title>Header Page</title>
    </head>
    <body>
            <div class="logo">
            <img src="./images/logo.jpg" alt="alt"/>
            <h3>Phố Đồng Hồ</h3>
            </div>
            <div class="login">
            <a href="#" id="avarta">X</a>
            <c:if test="${sessionScope.account != null}">
                <a href="${pageContext.request.contextPath}/logout" id="login">Logout</a>           
            </c:if>
            <c:if test="${sessionScope.account == null}">
                <a href="${pageContext.request.contextPath}/login" id="login">Login</a>
            </c:if>
                
        </div>
    </body>
</html>
