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
        <title>Admin_Product</title>
    </head>
    <body>
        <h2>Sản phẩm của tôi</h2>
        <div class="best_seller">
            <c:set var="watch_list" value="${requestScope.product_admin}"/>
            <c:if test="${empty watch_list}">
                <h2>Không tìm thấy sản phẩm này!</h2>
            </c:if>
            <c:if test="${not empty watch_list}">
            <c:forEach items="${watch_list}" var="w">
                <div class="best_product">
                    <img src="./images/${w.image_url}" alt="alt"/>
                    <h4>${w.product_name}</h4>
                    <p>Hãng: ${w.brand.brand_name}</p>
                    <p>Giá: ${w.price}</p>
                    
                    <div id="update_delete">
                            <button type="submit" onclick="popUpdate()">Sửa</button>
                            <button type="button" onclick="popDelete()">Xóa</button>
                    </div>
                </div>
                    <!--.Khối popup update-->
                
                    
              
                    <!--.Khối popup delete-->
                    <div class="popDelete" id="popDelete">
                        <h2>Bạn có thực sự muốn xóa không!</h2>
                        <form action="deleteProduct">
                            <input type="hidden" name="name_product" value="${w.product_name}">
                            <button type="submit" name="delete" value="agree" onclick="closeDelete()">Đồng ý</button>
                            <button type="submit" name="delete" value="cancel" onclick="closeDelete()">Hủy</button>
                        </form>
                    </div>
            </c:forEach>
            </c:if>    
        </div>
            <script>
                let popD = document.getElementById("popDelete");
                function popDelete() {
                    popD.classList.add("openPopDelete");
                }
                function closeDelete(){
                    popD.classList.remove("openPopDelete");
                } 
            </script>
    </body>
</html>
