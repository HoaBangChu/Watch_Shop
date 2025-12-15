<%-- 
    Document   : register
    Created on : Dec 6, 2025, 12:08:57 PM
    Author     : DELL P5530
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="box">
                <h2>LOGIN</h2>
            <form action="register" method="post">
                <div class="user">
                    <label>User</label>
                    <input type="text" name="user" placeholder="User" required>
                </div>
                <div class="password">
                   <label>Password</label>
                   <input type="password" name="password" minlength="8" placeholder="Password" required>
                </div>
                <button type="submit" class="btn reg1">Register</button>
            </form>
            <c:if test="${requestScope.err_register != null}">
                <h4 style="color: red">${requestScope.err_register}</h4>
            </c:if>
            <c:if test="${requestScope.suss_register != null}">
                <h4 style="color: green">${requestScope.suss_register}</h4>
            </c:if>
            <div class="re-log lg">
                <a href="${pageContext.request.contextPath}/login">Log in</a>
            </div>
                </div>
        </div>
    </body>
</html>
