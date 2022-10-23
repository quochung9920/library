/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global fetch */

const form = document.getElementById("submitFormDriver");
const formDriver = document.getElementById("formDriver");
const formUser = document.getElementById("formUser");

let userId;

let dateOfBirth = document.getElementById('dateOfBirth');
let username = document.getElementById('username');
let name = document.getElementById('name');
let email = document.getElementById('email');
let address = document.getElementById('address');
let license = document.getElementById('license');
let phoneInput = document.getElementById('phone');
let cmndInput = document.getElementById('identityCard');
let passwordInput = document.getElementById('password');
let confirmPasswordInput = document.getElementById('confirmPassword');

let textValidatePass = document.getElementById('invalid-feedback-password');
let textValidateCFPass = document.getElementById('invalid-feedback-cfpassword');
let textValidatePhone = document.getElementById('invalid-feedback-phone');
let textValidateCMND = document.getElementById('invalid-feedback-cmnd');
let textValidateName = document.getElementById('invalid-feedback-name');
let textValidateEmail = document.getElementById('invalid-feedback-email');
let textValidateAd = document.getElementById('invalid-feedback-ad');
let textValidateLicense = document.getElementById('invalid-feedback-license');
let textValidateUName = document.getElementById('invalid-feedback-uname');

const isValidEmail = email => /^[A-Za-z0-9+_.-]+@(.+)$/.test(email);

const isValidPhone = phone =>
    /(([03+[2-9]|05+[6|8|9]|07+[0|6|7|8|9]|08+[1-9]|09+[1-4|6-9]]){3})+[0-9]{7}\b/g.test(phone);

const isValidCMND = id => /^\d{9}$/.test(id) || /^\d{12}$/.test(id);

if (dateOfBirth) {
    const currentDate = new Date();
    let year = currentDate.getFullYear() - 20;
    let month = currentDate.getMonth() + 1;
    let date = currentDate.getDate();

    if (month < 10) {
        month = `0${month}`;
    }
    if (date < 10) {
        date = `0${date}`;
    }

    dateOfBirth.setAttribute('max', `${year}-${month}-${date}`);
}

const handleValidateForm = (event, inputType) => {
    switch (inputType) {
        case 'name':
            if (event.target.value.length === 0) {
                event.target.classList.add('is-invalid');
                textValidateName.textContent = 'Bạn phải điền tên tài xế!!!';
            } else {
                event.target.classList.remove('is-invalid');
            }
            break;
        case 'email':
            if (!isValidEmail(event.target.value)) {
                event.target.classList.add('is-invalid');
                textValidateEmail.textContent = 'Email bạn điền không hợp lệ, phải chứa kí tự @';
            } else {
                event.target.classList.remove('is-invalid');
            }
            break;
        case 'address':
            if (event.target.value.length === 0) {
                event.target.classList.add('is-invalid');
                textValidateAd.textContent = 'Bạn phải điền địa chỉ!!!';
            } else {
                event.target.classList.remove('is-invalid');
            }
            break;
        case 'license':
            if (event.target.value.length === 0) {
                event.target.classList.add('is-invalid');
                textValidateLicense.textContent = 'Bạn phải điền hạng bằng lái xe!!!';
            } else {
                event.target.classList.remove('is-invalid');
            }
            break;
        case 'username':
            if (event.target.value.length === 0) {
                event.target.classList.add('is-invalid');
                textValidateUName.textContent = 'Bạn phải điền tên đăng nhập!!!';
            } else {
                event.target.classList.remove('is-invalid');
            }
            break;
        case 'phone':
            if (!isValidPhone(event.target.value)) {
                event.target.classList.add('is-invalid');
                textValidatePhone.textContent = 'Số điện thoại bạn nhập không hợp lệ!';
            } else {
                event.target.classList.remove('is-invalid');
            }
            break;
        case 'cmnd':
            if (!isValidCMND(event.target.value)) {
                event.target.classList.add('is-invalid');
                textValidateCMND.textContent = 'Số CMND/CCCD bạn nhập không hợp lệ!';
            } else {
                event.target.classList.remove('is-invalid');
            }
            break;
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

phoneInput.addEventListener('change', (event) => handleValidateForm(event, 'phone'));

cmndInput.addEventListener('change', (event) => handleValidateForm(event, 'cmnd'));

passwordInput.addEventListener('change', (event) => handleValidateForm(event, 'password'));

confirmPasswordInput.addEventListener('change', (event) => handleValidateForm(event, 'confirmPassword'));

name.addEventListener('change', (event) => handleValidateForm(event, 'name'));

email.addEventListener('change', (event) => handleValidateForm(event, 'email'));

address.addEventListener('change', (event) => handleValidateForm(event, 'address'));

license.addEventListener('change', (event) => handleValidateForm(event, 'license'));

username.addEventListener('change', (event) => handleValidateForm(event, 'username'));

function submitUserDriver() {
    event.preventDefault();
    console.log(form.checkValidity());
    const data = new FormData();
    const file = document.getElementById('upload_avatar').files[0];
    data.append("file", file);
    data.append("upload_preset", "upload_for_web");
    if (form.checkValidity()) {
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
                return fetch("/BookingTicketWeb/api/admin/add-user", {
                    method: 'post',
                    body: JSON.stringify({
                        "name": form.elements.name.value,
                        "username": form.elements.username.value,
                        "password": form.elements.password.value,
                        "confirmPassword": form.elements.confirmPassword.value,
                        "email": form.elements.email.value,
                        "phone": form.elements.phone.value,
                        "avt": data.secure_url
                    }),
                    headers: {
                        "Content-Type": "application/json"
                    }
                });
            } else {
                throw Error("Có lỗi xảy ra, vui lòng quay lại sau!!");
            }
        }).then((res) => {
            return res.json();
        }).then((data) => {
            if (data && data.id > 0) {
                userId = data.id;
                return fetch("/BookingTicketWeb/api/admin/add-driver", {
                    method: 'post',
                    body: JSON.stringify({
                        "userIdDriver": userId,
                        "identityCard": form.elements.identityCard.value,
                        "address": form.elements.address.value,
                        "dateOfBirth": form.elements.dateOfBirth.value,
                        "license": form.elements.license.value
                    }),
                    headers: {
                        "Content-Type": "application/json"
                    }
                });
            } else {
                throw Error("Có lỗi xảy ra, vui lòng quay lại sau!!");
            }
        }).then((res) => {
            return res.json();
        }).then(data => {
            if (data) {
                alert('Thêm tài xế thành công!');
                document.location.href = "/BookingTicketWeb/admin/drivers/list";
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

function updateDriver() {
    event.preventDefault();
    console.log(formUser.checkValidity());
    console.log(formDriver.checkValidity());
    if (formUser.checkValidity() && formDriver.checkValidity()) {
        fetch("/BookingTicketWeb/api/admin/update-user-driver", {
            method: 'put',
            body: JSON.stringify({
                "userIdDriver": formUser.elements.id.value,
                "name": formUser.elements.name.value,
                "email": formUser.elements.email.value,
                "phone": formUser.elements.phone.value
            }),
            headers: {
                "Content-Type": "application/json"
            }
        }).then((code) => {
            return console.log(code);
        }).then(() => {
            return fetch("/BookingTicketWeb/api/admin/update-driver", {
                method: 'put',
                body: JSON.stringify({
                    "userIdDriver": formUser.elements.id.value,
                    "identityCard": formDriver.elements.identityCard.value,
                    "address": formDriver.elements.address.value,
                    "dateOfBirth": formDriver.elements.dateOfBirth.value,
                    "license": formDriver.elements.license.value
                }),
                headers: {
                    "Content-Type": "application/json"
                }
            });
        }).then((code) => {
            return console.log(code);
        }).then(() => {
            alert('Thay đổi thông tin tài xế thành công!');
            document.location.href = "/BookingTicketWeb/admin/drivers/list";
        }).catch((error) => {
            const errEle = document.getElementById('error-message');
            errEle.textContent = "Có lỗi xảy ra, vui lòng thử lại lần nữa!!";
            console.error(error);
        });
    }
}

function deleteDriver(endpoint, id) {
    let d = document.getElementById("load" + id);
    d.style.display = "block";
    fetch(endpoint, {
        method: "delete"
    }).then(function (res) {
        if (res.status === 204)
            location.reload();
    }).catch(function (err) {
        console.error(err);
    });
}


