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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/profile.css"/>
        <title>Profile Page</title>
    </head>
    <body>
        <div class="container">
            <div class="home">
                <a href="javascript:history.back()">Quay lại</a>
            </div>
            <h2>Trang cá nhân</h2>
            <div class="frame_profile">
                <a href="${pageContext.request.contextPath}/registeradmin">Đăng kí trở thành người bán hàng</a>
            </div>
        </div>
    </body>
</html>
