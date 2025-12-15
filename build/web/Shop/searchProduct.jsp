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
        <title>Shop Page</title>
    </head>
    <body>
        <div class="findProduct">
        <form action="search" method="post">
            <div class="frame_find">
                <div class="filter">
                    <p>Lọc:</p>
                    <label>Dây:&nbsp;</label>
                    <input type="text" name="strap" placeholder="Chất Dây"><br><hr>
                    <label>Máy:&nbsp;</label>
                    <input type="text" name="movement" placeholder="Loại máy"><br><hr>
                    <label>Giá:&nbsp;&nbsp;</label>
                     <input type="text" name="pricefrom" placeholder="Từ">&nbsp;&nbsp;
                    <input type="text" name="priceto" placeholder="Đến"><br><hr>
                    <c:if test="${requestScope.error_price != null}">
                        <p style="color: red">${requestScope.error_price}</p>
                    </c:if>
                    <div id="l">
                         <button type="submit" name="btnfilter" value="filter">Lọc</button>
                    </div>
                </div>
                <div class="search">
                    <input type="search" name="search" placeholder="Tìm kiếm">
                    <button type="submit" name="btnsearch" value="search"><i class="fa-solid fa-magnifying-glass"></i></button>
                </div>
            </div>
        </form>
            </div>
    </body>
</html>
