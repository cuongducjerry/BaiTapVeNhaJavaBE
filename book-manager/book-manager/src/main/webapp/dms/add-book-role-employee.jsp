<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/18/2025
  Time: 9:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <title>Employee: Thêm sản phẩm</title>

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
            <h3>Shop Bán Sách : Employee</h3>
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
          <a class="nav-link" href="#">Quản lý người dùng</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Quản lý thể loại</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="#">Quản lý sản phẩm</a>
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
      <h3 class="section-title">Thêm sản phẩm</h3>
    </header> <!-- section-heading.// -->
    <main class="add-book-form mb-5">
      <form action="/add-book-role-employee" class="w-50" method="post">
        <div class="mb-3">
          <label for="add-book-title" class="form-label">Tên sách</label>
          <input type="text" class="form-control" id="add-book-title" name="name">
        </div>
        <div class="mb-3">
          <label for="add-book-author" class="form-label">Tác giả</label>
          <input type="text" class="form-control" id="add-book-author" name="author">
        </div>
        <div class="mb-3">
          <label for="add-book-pages" class="form-label">Số trang</label>
          <input type="number" class="form-control" id="add-book-pages" name="pages">
        </div>
        <div class="mb-3">
          <label for="add-book-publisher" class="form-label">Nhà xuất bản</label>
          <input type="text" class="form-control" id="add-book-publisher" name="publisher">
        </div>
        <div class="mb-3">
          <label for="add-book-yearPublishing" class="form-label">Năm phát hành</label>
          <input type="number" class="form-control" id="add-book-yearPublishing" name="yearPublishing">
        </div>
        <div class="mb-3">
          <label for="add-book-price" class="form-label">Giá</label>
          <input type="number" class="form-control" id="add-book-price" name="price">
        </div>
        <div class="mb-3">
          <label for="add-book-discount" class="form-label">Khuyến mãi</label>
          <input type="number" class="form-control" id="add-book-discount" name="discount">
        </div>
        <div class="mb-3">
          <label for="add-book-quantity" class="form-label">Số lượng trong kho</label>
          <input type="number" class="form-control" id="add-book-quantity" name="quantity">
        </div>
        <div class="mb-3">
          <label for="add-book-description" class="form-label">Mô tả</label>
          <textarea class="form-control" id="add-book-description" rows="5" name="description"></textarea>
        </div>
        <div class="mb-3">
          <label for="add-book-imageName" class="form-label">Hình</label>
          <input type="file" class="form-control" id="add-book-imageName" name="image">
        </div>
        <input type="hidden" id="timestamp" name="timestamp">
        <button type="submit" class="btn btn-primary">Thêm sản phẩm</button>
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
