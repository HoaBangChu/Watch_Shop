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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shop.css"/>
        <title>Shop_Admin Page</title>
    </head>
    <body>
        <div class="container">
            <div class="header">
               <jsp:include page="../Home/header.jsp"/>
            </div>
<!--            <div class="menu">
               <jsp:include page="../Home/menu.jsp"/>
            </div>-->
            <div class="myshop">
                <h2>Cửa hàng của tôi</h2>
            </div>
            <div class="frame_content"> 
                <div class="add_product">
                    <a href="${pageContext.request.contextPath}/home">Trang chủ</a>
                    <a href="${pageContext.request.contextPath}/addProduct">+ Thêm sản phẩm</a>
               </div>
               <jsp:include page="./searchProductAdmin.jsp"/>
               <jsp:include page="./admin_product.jsp"/>
               
            </div>
<!--                <jsp:include page="../Content_Home/delivery.jsp"/>
            .footer
            <div class="footer">
               <jsp:include page="../Home/footer.jsp"/>
            </div>-->
        </div>
    </body>
</html>
