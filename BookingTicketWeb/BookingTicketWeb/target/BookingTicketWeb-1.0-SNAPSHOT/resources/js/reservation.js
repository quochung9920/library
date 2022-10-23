/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global fetch */

//var currentTab = 0;
//document.addEventListener("DOMContentLoaded", function (event) {
//    showTab(currentTab);
//
//});
//
//function showTab(n) {
//    var x = document.getElementsByClassName("tab");
//    x[n].style.display = "block";
//    if (n === 0) {
//        document.getElementById("prevBtn").style.display = "none";
//    } else {
//        document.getElementById("prevBtn").style.display = "inline";
//    }
//    if (n === (x.length - 1)) {
//        document.getElementById("nextBtn").innerHTML = "Thanh toán";
//    } else {
//        document.getElementById("nextBtn").innerHTML = "Tiếp tục";
//    }
//    fixStepIndicator(n);
//}
//
//function nextPrev(n) {
//    var x = document.getElementsByClassName("tab");
//    if (n === 1 && !validateForm())
//        return false;
//    x[currentTab].style.display = "none";
//    currentTab = currentTab + n;
//    if (currentTab >= x.length) {
//        // document.getElementById("regForm").submit();
//        // return false;
//        //alert("sdf");
//        document.getElementById("nextprevious").style.display = "none";
//        document.getElementById("all-steps").style.display = "none";
//        document.getElementById("register").style.display = "none";
//        document.getElementById("text-message").style.display = "block";
//    }
//    showTab(currentTab);
//}
//
//function validateForm() {
//    var x, y, i, valid = true;
//    x = document.getElementsByClassName("tab");
//    y = x[currentTab].getElementsByTagName("input");
//    for (i = 0; i < y.length; i++) {
//        if (y[i].value === "") {
//            y[i].className += " invalid";
//            valid = false;
//        }
//    }
//    if (valid) {
//        document.getElementsByClassName("step")[currentTab].className += " finish";
//    }
//    return valid;
//}
//
//function fixStepIndicator(n) {
//    var i, x = document.getElementsByClassName("step");
//    for (i = 0; i < x.length; i++) {
//        x[i].className = x[i].className.replace(" active", "");
//    }
//    x[n].className += " active";
//}

function addToPay(id, name, price, pasCarId, tripId) {
    event.preventDefault();
    let btn = document.getElementById(`seat-${id}`);
    btn.style.background = "#f8beab";
    btn.disabled = "true";

    fetch("/BookingTicketWeb/api/reservation", {
        method: 'post',
        body: JSON.stringify({
            "id": id,
            "name": name,
            "pasCarId": pasCarId,
            "tripId": tripId,
            "price": price,
            "quantity": 1
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        let counter = document.getElementById("count");
        counter.innerHTML = data;
    });
}

function deleteSeat(seatId) {
    var option = confirm('Bạn có chắc chắn muốn xóa không?');
    if (option === true) {
        fetch(`/BookingTicketWeb/api/reservation/delete/${seatId}`, {
            method: "delete"
        }).then(function (res) {
            return res.json();
        }).then(function (data) {
            let counter = document.getElementById("count");
            counter.innerHTML = data.counter;
            let amount = document.getElementById("amount");
            amount.innerHTML = data.amount;
        });
    }

    let s = document.getElementById(`s-${seatId}`);
    s.style.display = "none";

}

function pay(tripId, method) {
    var option = confirm('Bạn chắc chắn muốn thanh toán?');
    if (option === true) {
        fetch("/BookingTicketWeb/api/pay", {
            method: 'post',
        body: JSON.stringify({
            "method": method
        }),
        headers: {
            "Content-Type": "application/json"
        }
        }).then(function (res) {
            return res.json();
        }).then(function (code) {
            console.log(code);
            document.location.href = `/BookingTicketWeb/reservation/${tripId}/confirm-seat/user-information/success`;
        });
    }
}