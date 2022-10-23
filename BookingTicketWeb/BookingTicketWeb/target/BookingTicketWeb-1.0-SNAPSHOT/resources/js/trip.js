/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global fetch */

const formT = document.getElementById("imageTrip");
const form = document.getElementById("submitFormTrip");
const formUT = document.getElementById("formUpdateTrip");

let coachname = document.getElementById('coachname');
let departureday = document.getElementById('departureday');
let departuretime = document.getElementById('departuretime');
let arrivaltime = document.getElementById('arrivaltime');

let textValidateCoach = document.getElementById('invalid-feedback-coach');
let textValidateDepartD = document.getElementById('invalid-feedback-day');
let textValidateDepartT = document.getElementById('invalid-feedback-departT');
let textValidateArrivalT = document.getElementById('invalid-feedback-arrival');

let dateT = document.getElementById('departureday');
if (dateT) {
    const currentDate = new Date();
    let year = currentDate.getFullYear();
    let month = currentDate.getMonth() +1;
    let date = currentDate.getDate();

    if (month < 10) {
        month = `0${month}`;
    }
    if (date < 10) {
        date = `0${date}`;
    }

    dateT.setAttribute('min', `${year}-${month}-${date}`);
}

const isValidTime = time => /(2[0-3]|[01][0-9]):[0-5][0-9]:[0-5][0-9]/.test(time);

const handleValidateForm = (event, inputType) => {
    switch (inputType) {
        case 'coachname':
            if (event.target.value.length === 0) {
                event.target.classList.add('is-invalid');
                textValidateCoach.textContent = 'Bạn phải điền tên chuyến xe!!!';
            } else {
                event.target.classList.remove('is-invalid');
            }
            break;
        case 'departureday':
            if (event.target.value.length === 0) {
                event.target.classList.add('is-invalid');
                textValidateDepartD.textContent = 'Bạn phải chọn ngày khởi hành của chuyến!!!';
            } else {
                event.target.classList.remove('is-invalid');
            }
            break;
        case 'departuretime':
            if (!isValidTime(event.target.value)) {
                event.target.classList.add('is-invalid');
                textValidateDepartT.textContent = 'Bạn phải điền đúng định dạng HH:mm:ss!!!';
            } else {
                event.target.classList.remove('is-invalid');
            }
            break;
        case 'arrivaltime':
            if (!isValidTime(event.target.value)) {
                event.target.classList.add('is-invalid');
                textValidateArrivalT.textContent = 'Bạn phải điền đúng định dạng HH:mm:ss!!!';
            } else {
                event.target.classList.remove('is-invalid');
            }
            break;
    }
};

coachname.addEventListener('change', (event) => handleValidateForm(event, 'coachname'));

departureday.addEventListener('change', (event) => handleValidateForm(event, 'departureday'));

departuretime.addEventListener('change', (event) => handleValidateForm(event, 'departuretime'));

arrivaltime.addEventListener('change', (event) => handleValidateForm(event, 'arrivaltime'));

function updateImageTrip() {
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
            return fetch("/BookingTicketWeb/api/admin/update-image-trip", {
                method: 'put',
                body: JSON.stringify({
                    "id": formT.elements.id.value,
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
        alert('Thay đổi ảnh chuyến xe thành công!');
        document.location.href = "/BookingTicketWeb/admin/trips/list";
    }).catch((error) => {
        const errEle = document.getElementById('error-message');
        errEle.textContent = "BẠN CẦN CHỌN ẢNH ĐỂ THAY ĐỔI!!!";
        console.error(error);
    });
}

function submitTrip() {
    event.preventDefault();
    console.log(form.checkValidity());
    const data = new FormData();
    const file = document.getElementById('upload_image').files[0];
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
                return fetch("/BookingTicketWeb/api/admin/add-trip", {
                    method: 'post',
                    body: JSON.stringify({
                        "coachname": form.elements.coachname.value,
                        "departureday": form.elements.departureday.value,
                        "departuretime": form.elements.departuretime.value,
                        "arrivaltime": form.elements.arrivaltime.value,
                        "routeId": form.elements.routeId.value,
                        "userIdEmployee": form.elements.userIdEmployee.value,
                        "passengercarId": form.elements.passengercarId.value,
                        "image": data.secure_url
                    }),
                    headers: {
                        "Content-Type": "application/json"
                    }
                });
            } else {
                throw Error("Có lỗi xảy ra, vui lòng quay lại sau!!");
            }
        }).then(function (res) {
            if (res.status === 201) {
                alert('Thêm chuyến xe thành công!');
                document.location.href = "/BookingTicketWeb/admin/trips/list";
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

function updateTrip() {
    event.preventDefault();
    console.log(formUT.checkValidity());
    if (formUT.checkValidity()) {
        fetch("/BookingTicketWeb/api/admin/update-trip", {
            method: 'put',
            body: JSON.stringify({
                "coachname": formUT.elements.coachname.value,
                "departureday": formUT.elements.departureday.value,
                "departuretime": formUT.elements.departuretime.value,
                "arrivaltime": formUT.elements.arrivaltime.value,
                "routeId": formUT.elements.routeId.value,
                "userIdEmployee": formUT.elements.userIdEmployee.value,
                "passengercarId": formUT.elements.passengercarId.value,
                "image": formUT.elements.image.value,
                "active": formUT.elements.active.value,
                "id": formUT.elements.id.value
            }),
            headers: {
                "Content-Type": "application/json"
            }
        }).then((code) => {
            return console.log(code);
        }).then(() => {
            alert('Thay đổi thông tin chuyến xe thành công!');
            document.location.href = "/BookingTicketWeb/admin/trips/list";
        }).catch((error) => {
            const errEle = document.getElementById('error-message');
            errEle.textContent = "Có lỗi xảy ra, vui lòng thử lại lần nữa!!";
            console.error(error);
        });
    }
}
function cRemain(tripId) {
//    const fSRemain = document.getElementById(`formShowRemain-${tripId}`);
    fetch("/BookingTicketWeb/api/trip/countRemain", {
        method: 'post',
        body: JSON.stringify({
            "tripId": tripId
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then((res) => {
        return res.json();
    }).then(data => {
        let show = document.getElementById(`result-${tripId}`);
        show.value = data;
//        alert(data);
    });
}
