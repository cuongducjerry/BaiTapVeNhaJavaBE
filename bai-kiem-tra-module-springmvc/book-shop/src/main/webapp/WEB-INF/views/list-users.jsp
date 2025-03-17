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

    <title>Admin: Quản lý user</title>

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
                    <a class="nav-link" href="/api/users/"><i class="bi bi-people"></i> Quản lý người dùng</a>
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

<div class="container">
    <div class="card search-card">
        <div class="card-body">
            <h4 class="card-title text-center mb-3">🔍 Search Users</h4>
            <form action="/api/users/search-target" method="post">
                <div class="mb-3">
                    <label class="form-label">Username</label>
                    <input type="text" class="form-control" placeholder="Enter username" name="username">
                </div>
                <div class="mb-3">
                    <label class="form-label">Phone</label>
                    <input type="text" class="form-control" placeholder="Enter phone number" name="phone">
                </div>
                <div class="mb-3">
                    <label class="form-label">Email</label>
                    <input type="email" class="form-control" placeholder="Enter email" name="email">
                </div>
                <div class="mb-3">
                    <label class="form-label">Address</label>
                    <input type="text" class="form-control" placeholder="Enter address" name="address">
                </div>
                <div class="mb-3">
                    <label class="form-label">Identity Card</label>
                    <input type="text" class="form-control" placeholder="Enter address" name="identityCard">
                </div>
                <div class="mb-3">
                    <label class="form-label">Role</label>
                    <select class="form-select" name="roles">
                        <option value="ADMIN">ADMIN</option>
                        <option value="USER" selected>USER</option>
                        <option value="EMPLOYEE">EMPLOYEE</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary btn-search">Search</button>
            </form>
        </div>
    </div>
</div>

<section class="section-content">
    <div class="container">
        <header class="section-heading py-4 d-flex justify-content-between">
            <h3 class="section-title">Quản lý user</h3>
            <a class="btn btn-primary" href="/api/users/create" role="button" style="height: fit-content;">Thêm user</a>
        </header> <!-- section-heading.// -->
        <main class="table-responsive-xl mb-5">
            <table class="table table-bordered table-striped table-hover align-middle">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Username</th>
                    <th scope="col">Address</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Email</th>
                    <th scope="col">Identity Card</th>
                    <th scope="col">Role</th>
                    <th scope="col">Handle</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.username}</td>
                        <td>${user.address}</td>
                        <td>${user.phone}</td>
                        <td>${user.email}</td>
                        <td>${user.identityCard.identityNumber}</td>

                        <td>
                            <c:forEach var="role" items="${user.roles}">
                                ${role.roleName}
                            </c:forEach>
                        </td>

                        <td>
                            <a class="btn btn-primary" href="/api/users/${user.id}">View</a>
                            <a class="btn btn-success" href="/api/users/update/${user.id}">Edit</a>
                            <a class="btn btn-danger" href="/api/users/delete/${user.id}">Delete</a>
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
