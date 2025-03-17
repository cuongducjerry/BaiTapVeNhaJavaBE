<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/27/2025
  Time: 8:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="vi">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Admin: Quản lý sản phẩm</title>

    <link href="/static/img/favicon.ico" rel="shortcut icon" type="image/x-icon">

    <!-- Bootstrap v5.0.1 -->
    <link href="/static/css/bootstrap.css" type="text/css" rel="stylesheet">
    <script src="/static/js/bootstrap.bundle.js" type="text/javascript"></script>

    <!-- Bootstrap Icons v1.5.0 -->
    <link href="/static/css/bootstrap-icons.css" type="text/css" rel="stylesheet">

    <!-- Custom Styles -->
    <link href="/static/css/styles.css" type="text/css" rel="stylesheet">
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
                    <a class="nav-link" href="#"><i class="bi bi-people"></i> Quản lý người dùng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"><i class="bi bi-tags"></i> Quản lý thể loại</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="#"><i class="bi bi-book"></i> Quản lý sản phẩm</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"><i class="bi bi-cart"></i> Quản lý giỏ hàng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"><i class="bi bi-inboxes"></i> Quản lý đơn hàng</a>
                </li>
            </ul>
            <a class="btn btn-primary" href="#" role="button">Đăng nhập</a>
        </div>
    </div> <!-- container.// -->
</nav> <!-- navbar-main.// -->

<section class="section-content">
    <div class="container">
        <header class="section-heading py-4 d-flex justify-content-between">
            <h3 class="section-title">Quản lý sản phẩm</h3>
            <a class="btn btn-primary" href="/add-productDTO" role="button" style="height: fit-content;">Thêm sản phẩm</a>
        </header> <!-- section-heading.// -->
        <main class="table-responsive-xl mb-5">
            <table class="table table-bordered table-striped table-hover align-middle">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Title</th>
                    <th scope="col">Author</th>
                    <th scope="col">Page</th>
                    <th scope="col">Publisher</th>
                    <th scope="col">PublicationYear</th>
                    <th scope="col">Genre</th>
                    <th scope="col">Price</th>
                    <th scope="col">Discount</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Handle</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="productDTO" items="${productDTOS}">
                    <tr>
                        <td>${productDTO.id}</td>
                        <td>${productDTO.bookTitle}</td>
                        <td>${productDTO.author}</td>
                        <td>${productDTO.pageCount}</td>
                        <td>${productDTO.publisher}</td>
                        <td>${productDTO.publicationYear}</td>
                        <td>${productDTO.genre}</td>
                        <td>${productDTO.price}</td>
                        <td>${productDTO.discount}</td>
                        <td>${productDTO.stockQuantity}</td>
                        <td>
                            <a class="btn btn-primary" href="/productDTO/${productDTO.id}">View</a>
                            <a class="btn btn-success" href="/productDTO/update/${productDTO.id}">Edit</a>
                            <a class="btn btn-danger" href="/productDTO/delete/${productDTO.id}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </main> <!-- book-manager-table.// -->
        <nav class="mt-3 mb-5">
            <ul class="pagination justify-content-center">
                <li class="page-item disabled"><a class="page-link" href="#">Trang trước</a></li>
                <li class="page-item active"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item"><a class="page-link" href="#">Trang sau</a></li>
            </ul>
        </nav>
    </div> <!-- container.// -->
</section> <!-- section-content.// -->

<footer class="section-footer">
    <section class="footer-bottom text-center bg-light border-top py-3">
        <div class="container-fluid">© 2021 — Shop Bán Sách</div> <!-- container-fluid.// -->
    </section> <!-- footer-bottom.// -->
</footer> <!-- section-footer.// -->

</body>

</html>