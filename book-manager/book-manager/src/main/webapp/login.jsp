
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Đăng nhập</title>
    <style>
        .notification {
            position: fixed;
            top: 20px;
            right: 20px;
            color: white;
            padding: 15px 20px;
            border-radius: 5px;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2);
            opacity: 0;
            transform: translateX(100%);
            transition: opacity 0.5s, transform 0.5s;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .success {
            background-color: #28a745;
        }

        .error {
            background-color: red;
        }

        .notification.show {
            opacity: 1;
            transform: translateX(0);
        }

        .notification .close-btn {
            font-size: 20px;
            cursor: pointer;
            margin-left: 15px;
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
                    <a class="text-body" href="./home.html">
                        <h3>Shop Bán Sách</h3>
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
                            <a href="#" class="nav-link text-body">
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
            </ul>
            <a class="btn btn-light me-2" href="#" role="button">Đăng ký</a>
        </div>
    </div> <!-- container.// -->
</nav> <!-- navbar-main.// -->

<section class="section-content" style="margin: 100px 0;">
    <div class="card mx-auto" style="max-width: 380px">
        <div class="card-body">
            <h4 class="card-title mb-4">Đăng nhập</h4>
            <form id="loginForm" action="/login" method="POST">
                <div class="mb-3">
                    <input name="username" class="form-control" placeholder="Tên đăng nhập" type="text" autocomplete="off">
                </div>
                <div class="mb-3">
                    <input name="password" class="form-control" placeholder="Mật khẩu" type="password" autocomplete="off">
                </div>
                <button type="submit" class="btn btn-primary w-100">Đăng nhập</button>
            </form>
        </div> <!-- card-body.// -->
    </div> <!-- card .// -->
    <p class="text-center mt-4">Không có tài khoản? <a href="#">Đăng ký</a></p>
</section> <!-- section-content.// -->

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

<c:choose>
    <c:when test="${not empty message}">
        <c:choose>
            <c:when test="${message == 'loginSuccess'}">
                <div id="loginSuccess" class="notification success show">
                    <span>Đăng nhập thành công!</span>
                    <span class="close-btn" onclick="closeNotification('loginSuccess')">×</span>
                </div>
            </c:when>
            <c:when test="${message == 'loginError'}">
                <div id="loginError" class="notification error show">
                    <span>Đăng nhập thất bại!</span>
                    <span class="close-btn" onclick="closeNotification('loginError')">×</span>
                </div>
            </c:when>
            <c:when test="${message == 'permissionDenied'}">
                <div id="permissionDenied" class="notification error show">
                    <span>Bạn không có quyền truy cập vào tài nguyên!</span>
                    <span class="close-btn" onclick="closeNotification('permissionDenied')">×</span>
                </div>
            </c:when>
            <c:when test="${message == 'dontLogin'}">
                <div id="dontLogin" class="notification error show">
                    <span>Đăng nhập  truy cập tài nguyen!</span>
                    <span class="close-btn" onclick="closeNotification('dontLogin')">×</span>
                </div>
            </c:when>
        </c:choose>
    </c:when>
</c:choose>


<script>
    function closeNotification(id) {
        var notification = document.getElementById(id);
        notification.classList.remove("show");
    }

    // document.getElementById("loginForm").addEventListener("submit", function(event) {
    //     event.preventDefault();
    //
    //     var notification = document.getElementById("notification");
    //     notification.classList.add("show");
    // });
</script>

</body>

</html>
