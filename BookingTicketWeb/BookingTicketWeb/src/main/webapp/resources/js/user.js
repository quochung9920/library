/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global fetch */
const formChangeInfo = document.getElementById("formChangeInfo");
const formChangeUPass = document.getElementById("formUPassword");
let passwordInput = document.getElementById('passwordN');
let confirmPasswordInput = document.getElementById('confirmPassword');

let textValidatePass = document.getElementById('invalid-feedback-password');
let textValidateCFPass = document.getElementById('invalid-feedback-cfpassword');

const validateForm = (event, inputType) => {
    switch (inputType) {
        case 'password':
        case 'confirmPassword':
            if (event.target.value.length < 3) {
                event.target.classList.add('is-invalid');
                textValidatePass.textContent = 'Mật khẩu phải trên 2 ký tự!!!';
            } else if (event.target.value !== passwordInput.value &&
                    inputType === 'confirmPassword') {
                event.target.classList.add('is-invalid');
                textValidateCFPass.textContent = 'Mật khẩu không trùng khớp!';
            } else {
                event.target.classList.remove('is-invalid');
            }
            break;
    }
};

passwordInput.addEventListener('change', (event) => handleValidateForm(event, 'password'));

confirmPasswordInput.addEventListener('change', (event) => handleValidateForm(event, 'confirmPassword'));

function updateUProfile(userId) {
    event.preventDefault();
    console.log(formChangeInfo.checkValidity());
    if (formChangeInfo.checkValidity()) {
        fetch("/BookingTicketWeb/user-profile/edit/customer", {
            method: 'put',
            body: JSON.stringify({
                "userId": userId,
                "name": formChangeInfo.elements.name.value,
                "email": formChangeInfo.elements.email.value,
                "phone": formChangeInfo.elements.phone.value
            }),
            headers: {
                "Content-Type": "application/json"
            }
        }).then((res) => {
            if (res.status === 200) {
                alert('Thay đổi thông tin thành công!');
                document.location.href = "/BookingTicketWeb/user-profile";
            } else {
                throw Error("Có lỗi xảy ra, vui lòng quay lại sau!!");
            }
        }).catch((error) => {
            const errEle = document.getElementById('error-message');
            errEle.textContent = "Có lỗi xảy ra, vui lòng thử lại lần nữa!!";
            console.error(error);
        });
    }
}

function updateAvatar(userId) {
    event.preventDefault();

    const data = new FormData();
    const file = document.getElementById('firstimg').files[0];
    data.append("file", file);
    data.append("upload_preset", "update_avartar");
    fetch('https://api.cloudinary.com/v1_1/dvsqhstsi/upload', {
        method: "post",
        body: data
    }).then((res) => {
        if (res.ok) {
            resCopy = res.clone();
            console.log(res); //first consume it in console.log
            return res.json(); //then consume it again, the error happens
        }
    }).then((data) => {
        if (data && data.secure_url) {
            return fetch("/BookingTicketWeb/user-profile/edit/avatar", {
                method: 'put',
                body: JSON.stringify({
                    "id": userId,
                    "urlImage": data.secure_url
                }),
                headers: {
                    "Content-Type": "application/json"
                }
            });
        } else {
            throw Error("Có lỗi xảy ra, vui lòng quay lại sau!!");
        }
    }).then((code) => {
        return console.log(code);
    }).then(() => {
        alert('Thay đổi ảnh đại diện thành công!');
        document.location.href = "/BookingTicketWeb/user-profile";
    }).catch((error) => {
        const errEle = document.getElementById('error-message');
        errEle.textContent = "Bạn cần phải chọn ảnh để thay đổi!!!";
        console.error(error);
    });
}

function updateUPass(userId) {
    event.preventDefault();
    console.log(formChangeUPass.checkValidity());
    if (formChangeUPass.checkValidity()) {
        fetch("/BookingTicketWeb/user-profile/edit/upassword", {
            method: 'put',
            body: JSON.stringify({
                "id": userId,
                "username": formChangeUPass.elements.username.value,
                "passwordN": formChangeUPass.elements.passwordN.value
            }),
            headers: {
                "Content-Type": "application/json"
            }
        }).then((res) => {
            if (res.status === 200) {
                alert('Thay đổi thông tin thành công!');
                document.location.href = "/BookingTicketWeb/login";
            } else {
                throw Error("Có lỗi xảy ra, vui lòng quay lại sau!!");
            }
        }).catch((error) => {
            const errEle = document.getElementById('error-message');
            errEle.textContent = "Có lỗi xảy ra, vui lòng thử lại lần nữa!!";
            console.error(error);
        });
    }
}


