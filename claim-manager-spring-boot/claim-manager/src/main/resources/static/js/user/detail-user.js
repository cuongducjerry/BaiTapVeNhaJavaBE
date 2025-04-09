function getUserDetail(){

    let currentUrl = window.location.href;
    let idUser = currentUrl.substring(currentUrl.lastIndexOf('/') + 1);
    let url =  window.location.origin + '/api/user/' + idUser;
    fetch(url)  // Bước 1: Gọi API, method fetch đang trả về 1 Promise
        .then(response => {  // Bước 2: Xử lý phản hồi (response) từ Promise
            if (!response.ok) {
                throw new Error('call api error');  // Bước 3: Nếu không thành công, ném lỗi
            }
            return response.json();  // Bước 4: Chuyển dữ liệu nhận được từ API thành JSON, trả về 1 Promise
        })
        .then(dataResponse => {  // Bước 5: Xử lý dữ liệu nhận được từ API hứng lại Promise từ Bước 4
            let user = dataResponse.data;
            setValue('id',user.id);
            setValue('username',user.username);
            setValue('password',user.password);
            setValue('code',user.code);
            setValue('email',user.email);
            setValue('firstName',user.firstName);
            setValue('lastName',user.lastName);
            setValue('phone',user.phone);
            setValue('address',user.address);
            setValue('createdDate',user.createdDate);
            //setValue('createdBy',user.createdBy);
            //setValue('lastModifiedDate',user.lastModifiedDate);
            //setValue('lastModifiedBy',user.lastModifiedBy);
            if (user.stringBase64Avatar && user.stringBase64Avatar !== window.base64Avatar) {
                window.base64Avatar = user.stringBase64Avatar; // Cập nhật avatar base64
                document.getElementById('uploadedAvatar').setAttribute('src', user.stringBase64Avatar);
            }
            //document.getElementById('uploadedAvatar').setAttribute('src',user.stringBase64Avatar);
        })
        .catch(error => {  // Bước 6: Xử lý lỗi (nếu có) xử lý nếu Bước 4 bắn ra lỗi
            console.log(error);  // In lỗi ra console nếu có
        });

}

function setValue(id,value){
    if (value == undefined || value == null){
        value = '';
    }
    document.getElementById(id).value = value;
}

function updateUser() {

    let currentUrl = window.location.href;
    let idUser = currentUrl.substring(currentUrl.lastIndexOf('/') + 1);
    let url2 =  window.location.origin + '/api/user/update/' + idUser;

    event.preventDefault();

    const username = $('#username').val();
    const password = $('#password').val();
    const email = $('#email').val();
    const firstName = $('#firstName').val();
    const lastName = $('#lastName').val();
    const phone = $('#phone').val();
    const address = $('#address').val();

    const stringBase64Avatar = window.base64Avatar;

    const requestData = {
        username,
        password,
        email,
        firstName,
        lastName,
        phone,
        address,
        stringBase64Avatar
    }

    $.ajax({
        url: `${url2}`,
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

window.onload = function () {
    getUserDetail();
}



