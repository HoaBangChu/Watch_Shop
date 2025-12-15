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
        <title>Best Seller</title>
    </head>
    <body>
        <h2>Bán chạy nhất</h2>
        <div class="best_seller">
            <c:set var="watch_list" value="${requestScope.list_bestseller}"/>
            <c:forEach items="${watch_list}" var="w">
                <div class="best_product">
                    <img src="./images/${w.image_url}" alt="alt"/>
                    <h4>${w.product_name}</h4>
                    <p>Hãng: ${w.brand.brand_name}</p>
                    <p>Giá: ${w.price}</p>
                    
                    <div id="buy_now">
                    <a href="#">Mua ngay</a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
