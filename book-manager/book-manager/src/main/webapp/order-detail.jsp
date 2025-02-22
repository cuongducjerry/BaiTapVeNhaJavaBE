<%@ page import="vn.com.t3h.book.dao.ProductDao" %>
<%@ page import="vn.com.t3h.book.dao.impl.ProductDaoImpl" %>
<%@ page import="vn.com.t3h.book.service.ProductService" %>
<%@ page import="vn.com.t3h.book.model.ProductModel" %>
<%@ page import="vn.com.t3h.book.service.impl.ProductServiceImpl" %>
<%@ page import="vn.com.t3h.book.model.UserModel" %>
<%@ page import="vn.com.t3h.book.dao.UserDao" %>
<%@ page import="vn.com.t3h.book.dao.impl.UserDaoImpl" %>
<%@ page import="vn.com.t3h.book.service.UserService" %>
<%@ page import="vn.com.t3h.book.service.impl.UserServiceImpl" %>
<%@ page import="vn.com.t3h.book.dao.OrderDao" %>
<%@ page import="vn.com.t3h.book.dao.impl.OrderDaoImpl" %>
<%@ page import="vn.com.t3h.book.service.OrderService" %>
<%@ page import="vn.com.t3h.book.service.impl.OrderServiceImpl" %>
<%@ page import="vn.com.t3h.book.model.OrderTemp" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.com.t3h.book.util.SessionUtil" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/20/2025
  Time: 7:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Thông tin đơn hàng</title>

    <style>
        a {
            text-decoration: none;
        }

        .footer-top li {
            margin-bottom: 0.5rem;
        }

        .item-grid .card:hover {
            box-shadow: 0 4px 15px rgb(153 153 153 / 30%);
            transition: 0.3s;
        }

        .item-grid .card:active {
            box-shadow: inset 0 4px 15px rgb(153 153 153 / 30%);
        }

        /* category */

        .section-pagetop {
            padding: 40px 0;
        }

        .padding-y {
            padding-top: 40px;
            padding-bottom: 40px;
        }

        .filter-group {
            border-bottom: 1px solid #e4e4e4;
        }

        .filter-group:last-child {
            border-bottom: 0;
        }

        .filter-group .card-header {
            border-bottom: 0;
            background-color: unset;
        }

        /* product */

        .section-pagetop-2 {
            padding: 20px 0;
        }

        .section-pagetop-2 .breadcrumb {
            margin-bottom: 0;
        }

        .rating-stars i {
            color: #ccc;
        }

        .rating-stars i.active {
            color: orange;
        }

        /* cart */

        .cart-table th, .cart-table td {
            padding: 0.75rem 1rem;
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
                    <a class="text-body" href="./home">
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
            <a class="btn btn-primary" href="${applicationScope.baseUrl}/logout" role="button">Đăng xuất</a>
        </div>
    </div> <!-- container.// -->
</nav> <!-- navbar-main.// -->

<section class="section-pagetop bg-light">
    <div class="container">
        <h2 class="title-page">Thông tin giỏ hàng #1</h2>
    </div> <!-- container.// -->
</section> <!-- section-pagetop.// -->

<section class="section-content padding-y">
    <div class="container">
        <div class="row">

            <%
                UserModel currentUser = (UserModel) SessionUtil.getValue(request, SessionUtil.SESSION_ID_CURRENT_USER);
                request.setAttribute("currentUser", currentUser);
            %>

            <aside class="col-md-3 mb-md-0 mb-3">
                <nav class="list-group">
                    <a class="list-group-item" href="update-customer.jsp"> Tài khoản </a>
                    <a class="list-group-item" href="/ordered-list?id=${currentUser.id}"> Đơn hàng của tôi </a>
                    <a class="list-group-item" href="/add-order-temp?id2=${currentUser.id}"> Giỏ hàng </a>
                </nav>
            </aside> <!-- col.// -->

            <main class="col-md-9">

                <article class="card mb-4">

                    <header class="card-header">
                        <strong class="d-inline-block me-4">Mã giỏ hàng: ${productModel.id}</strong>
                        <span> Giỏ hàng </span>
                    </header> <!-- card-header.// -->

                    <%
                        String id2 = request.getParameter("id2");
                        UserDao userDao = new UserDaoImpl();
                        UserService userService = new UserServiceImpl(userDao);
                        UserModel userModel = userService.findUserById(Integer.parseInt(id2));
                        request.setAttribute("userModel", userModel);
                    %>

                    <div class="card-body pb-0">
                        <div class="row">
                            <div class="col-lg-8">
                                <h6 class="text-muted fw-bold">Người nhận</h6>
                                <p class="lh-lg fw-bold">
                                    ${userModel.fullname}<br>
                                    Số điện thoại: ${userModel.phoneNumber} <br>
                                    Địa chỉ: ${userModel.address}
                                </p>
                            </div>
                        </div> <!-- row.// -->
                    </div> <!-- card-body.// -->

<%--                    <%--%>
<%--                        OrderTemp orderTempNew = new OrderTemp();--%>
<%--                        ProductModel productModelNew = (ProductModel) request.getSession().getAttribute("currentProduct");--%>
<%--                        System.out.println("1. " + productModelNew);--%>

<%--                        orderTempNew.setName(productModelNew.getName());--%>
<%--                        System.out.println(productModelNew.getName());--%>

<%--                        orderTempNew.setPrice(productModelNew.getPrice());--%>
<%--                        System.out.println(productModelNew.getPrice());--%>

<%--                        orderTempNew.setQuantity(Integer.parseInt(request.getParameter("quantity")));--%>
<%--                        System.out.println(Integer.parseInt(request.getParameter("quantity")));--%>

<%--                        orderTempNew.setCustomerId(userModel.getId());--%>
<%--                        System.out.println(userModel.getId());--%>

<%--                        System.out.println("2. " + orderTempNew);--%>
<%--                        OrderDao orderDao = new OrderDaoImpl();--%>
<%--                        OrderService orderService = new OrderServiceImpl(orderDao);--%>
<%--                        orderService.addOrderIdTemp(orderTempNew);--%>
<%--                    %>--%>

                    <hr class="m-0">

                    <div class="table-responsive">
                        <table class="cart-table table table-borderless">
                            <thead class="text-muted">
                                <tr class="small text-uppercase">
                                    <th scope="col" style="min-width: 280px;">Sản phẩm</th>
                                    <th scope="col" width="150" style="min-width: 150px;">Giá</th>
                                    <th scope="col" width="150" style="min-width: 150px;">Số lượng</th>
                                    <th scope="col" width="150" style="min-width: 50px;"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="orderTemp" items="${orderTemps}">
                                        <tr>
                                            <td>
                                                <figure class="itemside">
                                                    <div class="float-start me-3"><img src=""></div>
                                                    <figcaption class="info">
                                                        <a href="#" class="title">${orderTemp.name}</a>
                                                    </figcaption>
                                                </figure>
                                            </td>
                                            <td>
                                                <div class="price-wrap">
                                                    <span class="price">${orderTemp.price}₫</span>
                                                </div>
                                            </td>
                                            <td>
                                                <span class="quantity">${orderTemp.quantity}</span>
                                            </td>
                                            <td>
                                                <form action="/delete-order-temp?id=${orderTemp.id}&id2=${userModel.id}" method="post">
                                                    <button class="btn btn-primary">Xóa</button>
                                                </form>
                                            </td>
                                        </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div> <!-- table.responsive-md.// -->

                    <%
                        List<OrderTemp> listOrderTemps = (List<OrderTemp>) request.getAttribute("orderTemps");
                        double tong = 0;
                        for(OrderTemp orderTemp : listOrderTemps){
                            tong += (orderTemp.getQuantity()) * (orderTemp.getPrice());
                        }
                        tong += 10000;
                        request.setAttribute("tong", tong);
                    %>

                    <div class="me-3 text-end">
                        <h6 class="text-muted">Hình thức thanh toán</h6>
                        <span class="text-success">
                                    <i class="fab fa-lg fa-cc-visa"></i>
                                    Giao tiêu chuẩn
                                </span>
                        <p class="lh-lg">
                            Tạm tính: ${sessionScope.currentProduct.price} <br>
                            Phí vận chuyển: 10.000₫ <br>
                            <strong>Tổng cộng: ${tong}₫</strong>
                        </p>
                    </div>

                    <div class="text-end card-footer py-3">
                        <form action="/ordered-list?id=${userModel.id}" method="POST">
                            <button class="btn btn-primary">Thanh toán</button>
                        </form>
                    </div> <!-- card-footer.// -->

                </article>

            </main> <!-- col.// -->

        </div> <!-- row.// -->
    </div> <!-- container.// -->
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

</body>

</html>
