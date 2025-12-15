<%-- 
    Document   : login
    Created on : Dec 6, 2025, 12:08:50 PM
    Author     : DELL P5530
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <form action="login" method="post">
                <div class="user">
                    <label>User</label>
                    <input type="text" name="user" placeholder="User" required>
                </div>
                <div class="password">
                   <label>Password</label>
                   <input type="password" name="password" minlength="8" placeholder="Password" required>
                </div>
                <div class="remember">
                  <input type="checkbox" name="remember" value="ON">Remember me
                </div>
                <button type="submit" class="btn lg1">Login</button>
            </form>
                <h4 style="color: red">${requestScope.err_login}</h4>
        
            <div class="re-log reg">
                <a href="${pageContext.request.contextPath}/register">Register</a>
            </div>
                </div>
        </div>
    </body>
</html>
