/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global fetch */
const form = document.getElementById("imageRoute");

function updateImageRoute() {
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
            return fetch("/BookingTicketWeb/api/admin/update-image-route", {
                method: 'put',
                body: JSON.stringify({
                    "id": form.elements.id.value,
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
        alert('Thay đổi ảnh tuyến xe thành công!');
        document.location.href = "/BookingTicketWeb/admin/routes/list";
    }).catch((error) => {
        const errEle = document.getElementById('error-message');
        errEle.textContent = "BẠN CẦN CHỌN ẢNH ĐỂ THAY ĐỔI!!!";
        console.error(error);
    });
}
