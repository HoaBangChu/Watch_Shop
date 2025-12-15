<%-- 
    Document   : menu
    Created on : Dec 5, 2025, 10:43:13 PM
    Author     : DELL P5530
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <ul class="nav">
            <li> <a href="${pageContext.request.contextPath}/home">Trang chủ</a> </li>
            <li>  <a href="${pageContext.request.contextPath}/shop">Cửa hàng</a>   </li>
            <li> <a href="#">Nam</a>  </li>
            <li> <a href="#">Nữ</a>  </li>
            <li> <a href="#">Cặp Đôi</a>  </li>
            <li>  <a href="#">Liên hệ</a> </li>
        </ul>

    </body>
</html>
