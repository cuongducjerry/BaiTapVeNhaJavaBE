function createUser(){

    // Ngăn chặn form submit mặc định
    event.preventDefault();

    const username = $('#username').val();
    const password = $('#password').val();
    const code = $('#code').val();
    const email = $('#email').val();
    const firstName = $('#firstName').val();
    const lastName = $('#lastName').val();
    const phone = $('#phone').val();
    const address = $('#address').val();

    const stringBase64Avatar = window.base64Avatar;

    const requestData = {
        username,
        password,
        code,
        email,
        firstName,
        lastName,
        phone,
        address,
        stringBase64Avatar
    }

    $.ajax({
        url: `http://localhost:8080/api/user/create`,  // Truyền tham số page và PAGE_SIZE
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(requestData),
        success: function(response) {

            window.location.href = "http://localhost:8080/cms/user-manager";

        },
        error: function(error) {
            console.error('Lỗi khi lấy dữ liệu:', error);
        }
    });

}

$('#formAccountSettings').on('submit', createUser);




