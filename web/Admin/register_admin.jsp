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
            <div class="home">
                <a href="${pageContext.request.contextPath}/home">Trang chủ</a>
            </div>
            <div class="box box_regis_admin">
                <h2>ĐĂNG KÍ BÁN HÀNG</h2>
            <form action="registeradmin" method="post">
                <div class="user">
                    <label>Số điện thoại</label>
                    <input type="number" name="phone" max-length="10" placeholder="Số điện thoại" required>
                </div>
                <div class="password">
                   <label>Email</label>
                   <input type="email" name="email" placeholder="Email" required>
                </div>
                <button type="submit" class="btn reg1">Đăng kí</button>
            </form>
            <c:if test="${sessionScope.err_register != null}">
                <h4 style="color: red">${requestScope.err_register}</h4>
            </c:if>
            <c:if test="${sessionScope.suss_register != null}">
                <h4 style="color: green">${requestScope.suss_register}</h4>
            </c:if>
                </div>
        </div>
    </body>
</html>
