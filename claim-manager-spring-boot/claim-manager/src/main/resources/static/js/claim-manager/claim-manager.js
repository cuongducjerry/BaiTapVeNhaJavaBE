const PAGE_SIZE = 3; // // Số lượng mục hiển thị trên mỗi trang

// function fetchClaims(page = 0) {
//
//     const claimCode = $('#search-ma-yeu-cau').val();
//     const fromDate = $('#from-date').val();
//     const toDate = $('#to-date').val();
//     const statusCode = $('#trang-thai-yeu-cau').val();
//
//     const requestData = {
//         claimCode,
//         fromDate,
//         toDate,
//         statusCode
//     };
//
//     fetch('http://localhost:8080/api/claim?page=' + page + '&size=' + PAGE_SIZE, {
//         method: 'POST',  // Phương thức là POST
//         headers: {
//             'Content-Type': 'application/json'  // Đảm bảo server nhận dạng được dữ liệu là JSON
//         },
//         body: JSON.stringify(requestData)  // Chuyển đổi requestData thành chuỗi JSON
//     })
//         .then(response => {
//             if (!response.ok) {
//                 throw new Error('Call API error');  // Nếu response không thành công, ném lỗi
//             }
//             return response.json();  // Trả về dữ liệu JSON từ response
//         })
//         .then(dataResponse => {
//             console.log(dataResponse);  // Xem dữ liệu nhận về từ server
//
//             renderTable(dataResponse.data);  // Hiển thị dữ liệu trên bảng
//
//             const pageIndex = dataResponse.pageIndex;  // Trang hiện tại
//             const totalPage = dataResponse.totalPage;  // Tổng số trang
//             renderPagination(pageIndex, totalPage);  // Hiển thị phân trang
//         })
//         .catch(error => {
//             console.error('Lỗi khi lấy dữ liệu:', error);  // Xử lý lỗi nếu có
//         });
// }

function fetchClaims(page = 0) {
    const claimCode = $('#search-ma-yeu-cau').val();
    const fromDate = $('#from-date').val();
    const toDate = $('#to-date').val();
    const statusCode = $('#trang-thai-yeu-cau').val();

    const requestData = {
        claimCode,
        fromDate,
        toDate,
        statusCode
    };

    $.ajax({
        url: `http://localhost:8080/api/claim?page=${page}&size=` + PAGE_SIZE,  // Truyền tham số page và PAGE_SIZE
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
    const pagination = $('#pagination');
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
$(document).on('click', '#pagination .page-link', function(e) {
    e.preventDefault();  // Ngăn chặn hành động mặc định của liên kết
    const page = $(this).data('page');  // Lấy số trang từ thuộc tính data-page
    fetchClaims(page);  // Gọi lại hàm fetchClaims với trang mới
});


// function getAllClaimFromServer(page = 0){
//     fetch('http://localhost:8080/api/claim?page=' + page + '&size=' + PAGE_SIZE)
//         .then(response => {
//             if(!response.ok){
//                 throw new Error('call api error');
//             }
//             return response.json();
//         })
//         .then(dataResponse => {
//             console.log(dataResponse);
//
//             renderTable(dataResponse.data);
//
//             const pageIndex = dataResponse.pageIndex;  // Trang hiện tại
//             const totalPage = dataResponse.totalPage;  // Tổng số trang
//             renderPagination(pageIndex, totalPage);
//
//         })
// }

$('#search-button').on('click', function() {
    fetchClaims(0);
});

function renderTable(claims){
    // lay ra body cua table
    var bodyTable = document.getElementById('claims-table-body');
    // xóa bỏ toàn bộ dữ liệu đã có của table
    bodyTable.innerHTML = '';
    for(let i = 0; i < claims.length; i++){
        let claim = claims[i];
        let rowTable = `<tr>
        <td><input type="checkbox" class="selectRow"></td>
        <td>${claim.code}</td>
        <td>${claim.customerName}</td>
        <td>${claim.nameProduct}</td>
        <td>${claim.claimDate}</td>
        <td>${claim.coverageProduct}</td>
        <td><span class="badge bg-label-primary me-1">${claim.statusName}</span></td>
      </tr>`
        bodyTable.innerHTML += rowTable;
    }
}

window.onload = function (){
    fetchClaims(0);
}