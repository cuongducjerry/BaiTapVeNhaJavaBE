<%@ page import="vn.com.t3h.book.dao.UserDao" %>
<%@ page import="vn.com.t3h.book.dao.impl.UserDaoImpl" %>
<%@ page import="vn.com.t3h.book.service.UserService" %>
<%@ page import="vn.com.t3h.book.service.impl.UserServiceImpl" %>
<%@ page import="vn.com.t3h.book.model.UserModel" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/17/2025
  Time: 8:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Admin: Cập nhật người dùng</title>

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
            <h3 class="section-title">Cập nhật thông tin người dùng</h3>
        </header> <!-- section-heading.// -->
        <main class="add-book-form mb-5">
            <form action="/update-user" class="w-50" method="post">
                <%
                    UserDao userDao = new UserDaoImpl();
                    UserService userService = new UserServiceImpl(userDao);
                    String id = request.getParameter("id");
                    UserModel userModel = userService.findUserById(Integer.parseInt(id));
                    request.setAttribute("userModel", userModel);
                    request.getSession().setAttribute("userModel", userModel);
                %>
                <div class="mb-3">
                    <label class="form-label">User name</label>
                    <input type="text" class="form-control" name="username" value="${userModel.username}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Full Name</label>
                    <input type="text" class="form-control" name="fullname" value="${userModel.fullname}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Email</label>
                    <input type="text" class="form-control" name="email" value="${userModel.email}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Phone Number</label>
                    <input type="text" class="form-control" name="phoneNumber" value="${userModel.phoneNumber}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Address</label>
                    <input type="text" class="form-control" name="address" value="${userModel.address}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Role</label>
                    <input type="text" class="form-control" name="role" value="${userModel.role}">
                </div>

                <input type="hidden" id="timestamp" name="timestamp">
                <button type="submit" class="btn btn-primary">Cập Nhật Người Dùng</button>
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
