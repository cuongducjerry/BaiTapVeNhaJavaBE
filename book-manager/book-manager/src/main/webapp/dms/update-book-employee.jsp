<%@ page import="vn.com.t3h.book.dao.ProductDao" %>
<%@ page import="vn.com.t3h.book.dao.impl.ProductDaoImpl" %>
<%@ page import="vn.com.t3h.book.service.ProductService" %>
<%@ page import="vn.com.t3h.book.service.impl.ProductServiceImpl" %>
<%@ page import="vn.com.t3h.book.model.ProductModel" %>
<%@ page import="vn.com.t3h.book.dao.ProductEmployeeDao" %>
<%@ page import="vn.com.t3h.book.dao.impl.ProductEmployeeDaoImpl" %>
<%@ page import="vn.com.t3h.book.service.ProductEmployeeService" %>
<%@ page import="vn.com.t3h.book.service.impl.ProductEmployeeServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/18/2025
  Time: 7:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Admin: Cập nhật sản phẩm</title>

    <link href="img/favicon.ico" rel="shortcut icon" type="image/x-icon">

    <!-- Bootstrap v5.0.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>

</head>

<body>

<header class="section-header">
    <section class="header-main border-bottom">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-11 py-3">
                    <a class="text-body" href="./home.html">
                        <h3>Shop Bán Sách : Admin</h3>
                    </a>
                </div> <!-- col.// -->
                <div class="col-1">
                    <ul class="nav col-12 col-lg-auto my-2 my-lg-0 justify-content-center justify-content-lg-end text-small">
                        <li>
                            <a href="#" class="nav-link text-body">
                                <i class="bi bi-window d-block text-center fs-3"></i>
                                Client
                            </a>
                        </li>
                    </ul>
                </div> <!-- col.// -->
            </div> <!-- row.// -->
        </div> <!-- container.// -->
    </section> <!-- header-main.// -->
</header> <!-- section-header.// -->

<nav class="navbar navbar-main navbar-expand-lg navbar-light border-bottom">
    <div class="container">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="/cms/users">Quản lý người dùng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Quản lý thể loại</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="/cms/books">Quản lý sản phẩm</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Quản lý giỏ hàng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Quản lý đơn hàng</a>
                </li>
            </ul>
        </div>
    </div> <!-- container.// -->
</nav> <!-- navbar-main.// -->

<section class="section-content">
    <div class="container">
        <header class="section-heading py-4 d-flex justify-content-between">
            <h3 class="section-title">Cập nhật thông tin sản phẩm</h3>
        </header> <!-- section-heading.// -->
        <main class="add-book-form mb-5">
            <form action="/update-book-employee" class="w-50" method="post">
                <%
                    ProductEmployeeDao productEmployeeDao = new ProductEmployeeDaoImpl();
                    ProductEmployeeService productEmployeeService = new ProductEmployeeServiceImpl(productEmployeeDao);
                    String id = request.getParameter("id");
                    ProductModel productModel = productEmployeeService.findProductEmployeeById(Integer.parseInt(id));
                    request.setAttribute("productModel", productModel);
                    request.getSession().setAttribute("productModel", productModel);
                %>
                <div class="mb-3">
                    <label class="form-label">Name</label>
                    <input type="text" class="form-control" name="name" value="${productModel.name}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Price</label>
                    <input type="text" class="form-control" name="price" value="${productModel.price}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Diccount</label>
                    <input type="text" class="form-control" name="discount" value="${productModel.discount}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Quantity</label>
                    <input type="text" class="form-control" name="quantity" value="${productModel.quantity}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Total Buy</label>
                    <input type="text" class="form-control" name="totalBuy" value="${productModel.totalBuy}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Author</label>
                    <input type="text" class="form-control" name="author" value="${productModel.author}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Pages</label>
                    <input type="text" class="form-control" name="pages" value="${productModel.pages}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Publisher</label>
                    <input type="text" class="form-control" name="publisher" value="${productModel.publisher}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Year Publishing</label>
                    <input type="text" class="form-control" name="yearPublishing" value="${productModel.yearPublishing}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Description</label>
                    <textarea class="form-control" name="description" value="${productModel.description}" rows="5"></textarea>
                </div>
                <div class="mb-3">
                    <label class="form-label">Image Name</label>
                    <input type="text" class="form-control" name="imageName" value="${productModel.imageName}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Shop</label>
                    <input type="text" class="form-control" name="shop" value="${productModel.shop}"></textarea>
                </div>

                <input type="hidden" id="timestamp" name="timestamp">
                <button type="submit" class="btn btn-primary">Cập Nhật Sản Phẩm</button>
                <button type="reset" class="btn btn-warning ms-2">Tẩy trống</button>
                <button type="button" class="btn btn-light ms-2">Hủy</button>
            </form>
        </main> <!-- add-book-form.// -->
    </div> <!-- container.// -->
</section> <!-- section-content.// -->

<footer class="section-footer">
    <section class="footer-bottom text-center bg-light border-top py-3">
        <div class="container-fluid">© 2021 — Shop Bán Sách</div> <!-- container-fluid.// -->
    </section> <!-- footer-bottom.// -->
</footer> <!-- section-footer.// -->

<script>
    function addTimestamp() {
        const now = new Date();
        const timestamp = now.toISOString(); // Định dạng thời gian ISO
        document.getElementById('timestamp').value = timestamp;
    }
</script>

</body>

</html>