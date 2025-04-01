const PAGE_SIZE_USER = 3;

function fetchUsers(page = 0) {
    const userCode = $('#search-ma-yeu-cau-user').val();
    const fromDate = $('#from-date-user').val();
    const toDate = $('#to-date-user').val();
    const phone = $('#phone-user').val();

    const requestData = {
        userCode,
        fromDate,
        toDate,
        phone
    };

    $.ajax({
        url: `http://localhost:8080/api/user?page=${page}&size=` + PAGE_SIZE_USER,  // Truyền tham số page và PAGE_SIZE
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(requestData),
        success: function(response) {
            renderTable(response.data);  // Hiển thị dữ liệu trên bảng

            const pageIndex = response.pageIndex;  // Trang hiện tại
            const totalPage = response.totalPage;  // Tổng số trang
            renderPagination(pageIndex, totalPage);  // Hiển thị phân trang
        },
        error: function(error) {
            console.error('Lỗi khi lấy dữ liệu:', error);
        }
    });
}

function renderPagination(pageNumber, totalPages) {
    const pagination = $('#pagination-user');
    pagination.empty();  // Xóa các nút phân trang cũ

    // Thêm nút "Trang trước" nếu không phải là trang đầu tiên
    if (pageNumber > 0) {
        pagination.append(`<li class="page-item"><a class="page-link" href="#" data-page="${pageNumber - 1}">&laquo;</a></li>`);
    }

    // Tạo các nút số trang
    for (let i = 0; i < totalPages; i++) {
        pagination.append(`<li class="page-item ${i === pageNumber ? 'active' : ''}">
            <a class="page-link" href="#" data-page="${i}">${i + 1}</a>
        </li>`);
    }

    // Thêm nút "Trang sau" nếu không phải là trang cuối cùng
    if (pageNumber < totalPages - 1) {
        pagination.append(`<li class="page-item"><a class="page-link" href="#" data-page="${pageNumber + 1}">&raquo;</a></li>`);
    }
}

// xử lý sự kiện phân trang
$(document).on('click', '#pagination-user .page-link', function(e) {
    e.preventDefault();  // Ngăn chặn hành động mặc định của liên kết
    const page = $(this).data('page');  // Lấy số trang từ thuộc tính data-page
    fetchUsers(page);  // Gọi lại hàm fetchClaims với trang mới
});

$('#search-button-user').on('click', function() {
    fetchUsers(0);
});

function renderTable(users){
    // lay ra body cua table
    var bodyTable = document.getElementById('users-table-body');
    // xóa bỏ toàn bộ dữ liệu đã có của table
    bodyTable.innerHTML = '';
    for(let i = 0; i < users.length; i++){
        let user = users[i];

        let urlDetail = 'http://localhost:8080/cms/detail-user/' + user.id;

        let rowTable = `<tr>
        <td><input type="checkbox" class="selectRow"></td>
        <td><a href=${urlDetail}> <strong>${user.code}</strong></a></td>
        <td>${user.username}</td>
        <td>${user.firstName + " " + user.lastName}</td>
        <td>${user.phone}</td>
        <td>${user.createdDate}</td>
        <td>${user.address}</td>
      </tr>`
        bodyTable.innerHTML += rowTable;
    }
}

window.onload = function (){
    fetchUsers(0);
}

function redirectPageCreateUser(){
    window.location.href = "http://localhost:8080/cms/create-user";
}

