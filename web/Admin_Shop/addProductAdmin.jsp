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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shop.css"/>
        <title>Shop_Admin Page</title>
    </head>
    <body>
        <div class="container">
            <div class="header">
                <jsp:include page="../Home/header.jsp"/>
            </div>
            <div class="myshop">
                <h2>Thêm sản phẩm</h2>
            </div>
            <div class="frame_content"> 
                <div class="addProduct">
                    <form action="addProduct" method="post">
                        <div> 
                            <label>Tên sản phẩm: </label>
                            <input type="text" name="product_name" placeholder="Tên sản phẩm" required>
                        </div>
                        <div>
                            <label>Hãng: </label>
                            <select name="brand" required>
                                <option value="" disabled selected>Hãng</option>
                                <c:forEach items="${requestScope.brand_list}" var="b">
                                    <option value="${b.brand_id}">${b.brand_name}</option>
                                </c:forEach>
                            </select>                       
                        </div>
                        <div>
                            <label>Giá Tiền: </label>
                            <input type="text" name="price" placeholder="Giá Tiền"required>
                        </div>
                        <div>
                            <label>Loại máy: </label>
                            <select name="movement"required>
                                <option value="" disabled selected>Loại máy</option>
                                <c:forEach items="${requestScope.movement_list}" var="m">
                                    <option value="${m.movement_id}">${m.movement_name}</option>
                                </c:forEach>
                            </select>                          </div>
                        <div>
                            <label>Loại dây: </label>
                            <select name="strap"required>
                                <option value="" disabled selected>Loại Dây</option>
                                <c:forEach items="${requestScope.strap_list}" var="s">
                                    <option value="${s.strap_id}">${s.strap_name}</option>
                                </c:forEach>
                            </select>                          </div>
                        <div>
                            <label>Ảnh: </label>
                            <input type="text" name="images" placeholder="Ảnh"required>
                        </div>
                        <div>
                            <label>Miêu tả: </label>
                            <input type="text" name="description" placeholder="Miêu tả"required>
                        </div>
                        <div>
                            <label>Số lượng: </label>
                            <input type="number" name="quantity" placeholder="Số lượng"required>
                        </div>
                        <div>
                            <label>Thời gian: </label>
                            <input type="date" name="new_product" placeholder="Thời gian"required>
                        </div>
                        <div>
                            <label>Giới Tính: </label>
                            <select name="gender"required>
                                <option value="" disabled selected>Giới Tính</option>
                                <option value="male">Male</option>
                                <option value="female">Female</option>
                                <option value="couple">Couple</option>
                            </select>
                        </div>
                        <div id="btn"><button type="submit">Thêm</button></div> 
                    </form>
                    <c:if test="${not empty sessionScope.add_sucess}">
                        <h3 style="color: green">${sessionScope.add_sucess}</h3>
                        <c:remove var="add_sucess" scope="session"/>
                    </c:if>

                    <c:if test="${not empty sessionScope.add_error}">
                        <h3 style="color: red">${sessionScope.add_error}</h3>
                        <c:remove var="add_error" scope="session"/>
                    </c:if>
                </div>
            </div>  
        </div>
    </body>
</html>
