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
                            <button type="button" onclick="popUpdate(
                                    ${w.watch_id},
                                            `${w.product_name}`,
                                            `${w.price}`,
                                            `${w.image_url}`,
                                            ${w.quantity},
                                            `${w.new_product}`,
                                            `${w.gender}`
                                            )">Sửa</button>
                            <button type="button" onclick="popDelete(${w.watch_id})">Xóa</button>
                        </div>
                    </div>     
                </c:forEach>
            </c:if> 
            <!--.Khối popup update-->
            <div class="popup popUpdate" id="popUpdate">
                <h2>Cập nhật sản phẩm</h2>
                <form action="updateproduct" method="post">
                    <div class="inUpdate">
                        <div><label>Mã số: </label><input type="text" name="watch_id" value="" readonly id="Id"></div>
                        <div><label>Tên: </label><input type="text" name="product_name" value="" id="name" required></div>
                        <div><label>Giá: </label><input type="text" name="price" value="" id="price" required></div>
                        <!--<div><label>Hãng: </label><input type="text" name="brand" value="" id="brand" required></div>-->
                        <!--<div><label>Loại máy: </label><input type="text" name="movement_id" value="" id="movement"></div>-->
                        <input type="hidden" name="old_price" id="old_price" value="">
                        <div><label>Ảnh: </label><input type="text" name="image_url" id="image" value="" required></div>
                        <div><label>Số lượng: </label><input type="text" name="quantity" value="" id="quantity" required></div>
                        <div><label>Thời gian: </label><input type="date" name="new_product" value="" id="new"></div>
                        <div><label>Giới Tính: </label> <select name="gender">
                                <option value="" id="default"></option>
                                <option value="male">Male</option>
                                <option value="female">Female</option>
                                <option value="couple">Couple</option>
                            </select>
                        </div>
                        <div> <button type="submit">Lưu</button></div>
                        <div id="close"> <button type="button" onclick="closeUpdate()">X</button> </div>
                    </div>
                </form>
            </div>
            <!--.-->
            <div id="overlay"></div>

            <!--.-->
            <!--.Khối popup delete-->
            <div class="popup popDelete" id="popDelete">
                <h2>Bạn có thực sự muốn xóa không!</h2>
                <form action="deleteProduct" method="post">
                    <input type="hidden" name="id_product" value="" id="idDelete">
                    <button type="submit" name="delete" value="agree"  onclick="closeDelete()">Đồng ý</button>
                    <button type="button" name="delete" value="cancel" onclick="closeDelete()">Hủy</button>
                </form>
            </div>
            <!--.-->
        </div>
        <script>
            let popD = document.querySelector("#popDelete");
            let idDelete = document.querySelector("#idDelete");
            let popU = document.querySelector("#popUpdate");
            let overlay = document.querySelector("#overlay");
            function popDelete(id) {
                idDelete.value = id;
                overlay.classList.add("active");
                popD.classList.add("openPopDelete");
            }
            function closeDelete() {
                overlay.classList.remove("active");
                popD.classList.remove("openPopDelete");
            }
            // function update
            let id_raw = document.querySelector("#Id");
            let name_raw = document.querySelector("#name");
            let price_raw = document.querySelector("#price");
//            let brand_raw = document.querySelector("#brand");
//            let mov_raw = document.querySelector("#movement");
//            let strap_raw = document.querySelector("#strap");
            let image_raw = document.querySelector("#image");
            let oldPrice_raw = document.querySelector("#old_price");
            let quan_raw = document.querySelector("#quantity");
            let new_raw = document.querySelector("#new");
            let gender_raw = document.querySelector("#default");

            function popUpdate(id, name, price, images, quantity, time, gender) {
                id_raw.value = id;
                name_raw.value = name;
                price_raw.value = price;
//                brand_raw.value = brand;
//                mov_raw.value = movement;
//                strap_raw.value = strap;
                image_raw.value = images;
                oldPrice_raw.value = price;
                quan_raw.value = quantity;
                new_raw.value = time;
                gender_raw.value = gender;
                gender_raw.innerHTML = gender;
                popU.classList.add("openPopDelete");
                overlay.classList.add("active");
            }
            function closeUpdate() {
                popU.classList.remove("openPopDelete");
                overlay.classList.remove("active");

            }            
        </script>
    </body>
</html>
