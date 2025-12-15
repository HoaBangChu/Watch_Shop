<%-- 
    Document   : home
    Created on : Dec 5, 2025, 10:42:56 PM
    Author     : DELL P5530
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="header">
               <jsp:include page="header.jsp"/>
            </div>
            <div class="menu">
               <jsp:include page="menu.jsp"/>
            </div>
            <div class="frame_content">
                <jsp:include page="../Content_Home/brand.jsp"/>
                <jsp:include page="../Content_Home/bestseller.jsp"/>
                <jsp:include page="../Content_Home/newProduct.jsp"/>
            </div>
                <jsp:include page="../Content_Home/delivery.jsp"/>
            <!--.footer-->
            <div class="footer">
               <jsp:include page="footer.jsp"/>
            </div>
        </div>
    </body>
</html>
