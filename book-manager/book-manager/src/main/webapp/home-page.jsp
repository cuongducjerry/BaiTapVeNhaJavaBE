<%@ page import="vn.com.t3h.book.util.SessionUtil" %>
<%@ page import="vn.com.t3h.book.model.UserModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Trang chủ</title>

    <style>
        .product-item {
            width: 270px;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 8px;
            text-align: center;
            background: #f9f9f9;
        }
        .product-item img {
            width: 100%;
            height: 400px;
            object-fit: cover;
            border-radius: 5px;
        }
    </style>

    <link href="img/favicon.ico" rel="shortcut icon" type="image/x-icon">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>

</head>

<body>

<header class="section-header">
    <section class="header-main border-bottom">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-3 py-3">
                    <a class="text-body" href="/home">
                        <h3>Shop Bán Sách: ${currentUser.role}</h3>
                    </a>
                </div> <!-- col.// -->
                <div class="col-lg-4 col-xl-5">
                    <form action="#" class="search">
                        <div class="input-group w-100">
                            <input type="text" class="form-control" placeholder="Nhập từ khóa cần tìm ...">
                            <button class="btn btn-primary" type="button">
                                <i class="bi bi-search"></i>
                            </button>
                        </div>
                    </form>
                </div> <!-- col.// -->
                <div class="col-lg-5 col-xl-4">
                    <ul class="nav col-12 col-lg-auto my-2 my-lg-0 justify-content-center justify-content-lg-end text-small">
                        <li>
                            <a href="#" class="nav-link text-body">
                                <i class="bi bi-person d-block text-center fs-3"></i>
                                Tài khoản
                            </a>
                        </li>
                        <li>
                            <a href="#" class="nav-link text-body">
                                <i class="bi bi-list-check d-block text-center fs-3"></i>
                                Đơn hàng
                            </a>
                        </li>
                        <li>
                            <a href="/add-order-temp?id2=${currentUser.id}" class="nav-link text-body">
                                <i class="bi bi-cart d-block text-center fs-3"></i>
                                Giỏ hàng
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
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        <strong><i class="bi bi-list"></i> Danh mục sản phẩm</strong>
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">Sách giáo khoa</a></li>
                        <li><a class="dropdown-item" href="#">Sách khoa học</a></li>
                        <li><a class="dropdown-item" href="#">Truyện tranh</a></li>
                        <li><a class="dropdown-item" href="#">Tiểu thuyết</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item" href="#">Tất cả danh mục</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Sản phẩm mới</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Sản phẩm bán chạy</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Khuyến mãi</a>
                </li>
                <li class="nav-item">
                    <c:if test="${not empty currentUser}">
                        <c:if test="${currentUser.role == \"ADMIN\"}">
                            <a class="nav-link" href="/cms/books">Quản Lý Nhân Viên, Sản Phẩm </a>
                        </c:if>
                        <c:if test="${currentUser.role == \"EMPLOYEE\"}">
                            <a class="nav-link" href="/dms/books-employee">Quản Lý Sản Phẩm</a>
                        </c:if>
                    </c:if>
                </li>
            </ul>
            <c:if test="${empty currentUser}">
                <a class="btn btn-light me-2" href="#" role="button">Đăng ký</a>
                <a class="btn btn-primary" href="${applicationScope.baseUrl}/login" role="button">Đăng nhập</a>
            </c:if>
            <c:if test="${not empty currentUser}">
                <a class="btn btn-primary" href="${applicationScope.baseUrl}/logout">Đăng xuất</a>
            </c:if>
        </div>
    </div> <!-- container.// -->
</nav> <!-- navbar-main.// -->

<section class="section-content mb-2">
    <div class="container">
        <header class="section-heading py-4 d-flex justify-content-between">
            <h3 class="section-title">Danh mục sản phẩm</h3>
            <a class="btn btn-secondary" href="#" role="button" style="height: fit-content;">Xem tất cả</a>
        </header> <!-- section-heading.// -->
        <div class="row item-grid">
            <div class="col-lg-3 col-md-6">
                <div class="card mb-4">
                    <div class="card-body">
                        <a href="#" class="stretched-link">
                            <div class="d-flex align-items-center">
                                <img src="">
                                <span class="category-title ms-3">Sách 1</span>
                            </div>
                        </a>
                    </div>
                </div>
            </div> <!-- col.// -->
            <div class="col-lg-3 col-md-6">
                <div class="card mb-4">
                    <div class="card-body">
                        <a href="#" class="stretched-link">
                            <div class="d-flex align-items-center">
                                <img src="">
                                <span class="category-title ms-3">Sách 2</span>
                            </div>
                        </a>
                    </div>
                </div>
            </div> <!-- col.// -->
            <div class="col-lg-3 col-md-6">
                <div class="card mb-4">
                    <div class="card-body">
                        <a href="#" class="stretched-link">
                            <div class="d-flex align-items-center">
                                <img src="">
                                <span class="category-title ms-3">Sách 3</span>
                            </div>
                        </a>
                    </div>
                </div>
            </div> <!-- col.// -->
            <div class="col-lg-3 col-md-6">
                <div class="card mb-4">
                    <div class="card-body">
                        <a href="#" class="stretched-link">
                            <div class="d-flex align-items-center">
                                <img src="">
                                <span class="category-title ms-3">Sách 4</span>
                            </div>
                        </a>
                    </div>
                </div>
            </div> <!-- col.// -->
            <div class="col-lg-3 col-md-6">
                <div class="card mb-4">
                    <div class="card-body">
                        <a href="#" class="stretched-link">
                            <div class="d-flex align-items-center">
                                <img src="">
                                <span class="category-title ms-3">Sách 5</span>
                            </div>
                        </a>
                    </div>
                </div>
            </div> <!-- col.// -->
            <div class="col-lg-3 col-md-6">
                <div class="card mb-4">
                    <div class="card-body">
                        <a href="#" class="stretched-link">
                            <div class="d-flex align-items-center">
                                <img src="">
                                <span class="category-title ms-3">Sách 6</span>
                            </div>
                        </a>
                    </div>
                </div>
            </div> <!-- col.// -->
            <div class="col-lg-3 col-md-6">
                <div class="card mb-4">
                    <div class="card-body">
                        <a href="#" class="stretched-link">
                            <div class="d-flex align-items-center">
                                <img src="">
                                <span class="category-title ms-3">Sách 7</span>
                            </div>
                        </a>
                    </div>
                </div>
            </div> <!-- col.// -->
            <div class="col-lg-3 col-md-6">
                <div class="card mb-4">
                    <div class="card-body">
                        <a href="#" class="stretched-link">
                            <div class="d-flex align-items-center">
                                <img src="">
                                <span class="category-title ms-3">Sách 8</span>
                            </div>
                        </a>
                    </div>
                </div>
            </div> <!-- col.// -->
            <div class="col-lg-3 col-md-6">
                <div class="card mb-4">
                    <div class="card-body">
                        <a href="#" class="stretched-link">
                            <div class="d-flex align-items-center">
                                <img src="">
                                <span class="category-title ms-3">Sách 9</span>
                            </div>
                        </a>
                    </div>
                </div>
            </div> <!-- col.// -->
            <div class="col-lg-3 col-md-6">
                <div class="card mb-4">
                    <div class="card-body">
                        <a href="#" class="stretched-link">
                            <div class="d-flex align-items-center">
                                <img src="">
                                <span class="category-title ms-3">Sách 10</span>
                            </div>
                        </a>
                    </div>
                </div>
            </div> <!-- col.// -->
            <div class="col-lg-3 col-md-6">
                <div class="card mb-4">
                    <div class="card-body">
                        <a href="#" class="stretched-link">
                            <div class="d-flex align-items-center">
                                <img src="">
                                <span class="category-title ms-3">Sách 11</span>
                            </div>
                        </a>
                    </div>
                </div>
            </div> <!-- col.// -->
            <div class="col-lg-3 col-md-6">
                <div class="card mb-4">
                    <div class="card-body">
                        <a href="#" class="stretched-link">
                            <div class="d-flex align-items-center">
                                <img src="">
                                <span class="category-title ms-3">Sách 12</span>
                            </div>
                        </a>
                    </div>
                </div>
            </div> <!-- col.// -->
        </div> <!-- row.// -->
    </div> <!-- container.// -->
</section> <!-- section-content.// -->

<section class="section-content mb-5">
    <div class="container">
        <header class="section-heading py-4 d-flex justify-content-between">
            <h3 class="section-title">Sản phẩm mới nhất</h3>
            <a class="btn btn-secondary" href="#" role="button" style="height: fit-content;">Xem tất cả</a>
        </header> <!-- section-heading.// -->

        <div class="row item-grid">
            <c:forEach var="productModel" items="${listProducts}">
                <div class="col-lg-3 col-md-6">
                    <div class="card p-3 mb-4">
                        <a href="product-user.jsp?id=${productModel.id}&id2=${sessionScope[SessionUtil.SESSION_ID_CURRENT_USER].id}" class="product-item img-wrap text-center">
                            <img class="img-fluid" src="https://www.sachbaokhang.vn/uploads/files/2023/05/01/van-5.jpg">
                        </a>
                        <figcaption class="info-wrap mt-2">
                            <a href="product-user.jsp?id=${productModel.id}&id2=${sessionScope[SessionUtil.SESSION_ID_CURRENT_USER].id}" class="title">${productModel.name}</a>
                            <div class="price mt-1 fw-bold">${productModel.price}đ</div>
                        </figcaption>
                    </div>
                </div>
            </c:forEach>
        </div> <!-- row.// -->
    </div> <!-- container.// -->
</section>

<footer class="section-footer">
    <section class="footer-top py-5 bg-light">
        <div class="container">
            <div class="row">
                <aside class="col-sm-6 col-lg-3">
                    <h6 class="pb-2">Giới thiệu</h6>
                    <ul class="list-unstyled">
                        <li><a href="#">Về Shop</a></li>
                        <li><a href="#">Tuyển dụng</a></li>
                        <li><a href="#">Chính sách thanh toán</a></li>
                        <li><a href="#">Chính sách bảo mật</a></li>
                        <li><a href="#">Giải quyết khiếu nại</a></li>
                        <li><a href="#">Hợp tác</a></li>
                    </ul>
                </aside>
                <aside class="col-sm-6 col-lg-3">
                    <h6 class="pb-2">Hỗ trợ khách hàng</h6>
                    <ul class="list-unstyled">
                        <li>Hotline: 1900-80xx</li>
                        <li><a href="#">Câu hỏi thường gặp</a></li>
                        <li><a href="#">Hướng dẫn đặt hàng</a></li>
                        <li><a href="#">Phương thức vận chuyển</a></li>
                        <li><a href="#">Chính sách đổi trả</a></li>
                    </ul>
                </aside>
                <aside class="col-lg-5">
                    <h6 class="pb-2">Đăng ký nhận tin</h6>
                    <form action="#">
                        <div class="input-group w-100">
                            <input type="text" class="form-control" placeholder="Email của bạn ...">
                            <button class="btn btn-primary" type="button">
                                Đăng ký
                            </button>
                        </div>
                    </form>
                </aside>
            </div> <!-- row.// -->
        </div> <!-- container.// -->
    </section> <!-- footer-top.// -->

    <section class="footer-bottom text-center bg-light border-top py-3">
        <div class="container-fluid">© 2021 — Shop Bán Sách</div> <!-- container-fluid.// -->
    </section> <!-- footer-bottom.// -->
</footer> <!-- section-footer.// -->

</body>

</html>