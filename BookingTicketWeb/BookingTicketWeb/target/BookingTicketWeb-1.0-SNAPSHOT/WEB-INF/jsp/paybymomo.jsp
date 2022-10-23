<%-- 
    Document   : paybymomo
    Created on : Aug 24, 2022, 9:05:52 AM
    Author     : dieuh
--%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="containerbb container-fluid">
    <div class="row d-flex justify-content-center align-items-center">
        <div class="col-md-6">
            <form id="regForm"  style="padding: 0">
                <h1 id="register" class="text-success" style="font-weight: 700;">ĐẶT VÉ</h1>
                <div class="all-steps mt-0" id="all-steps">
                    <span class="step" style="background-color: green"></span> 
                    <span class="step" style="background-color: green"></span> 
                    <span class="step" style="background-color: green"></span>
                    <span class="step" style="background-color: black"></span> 
                </div>
                <h3 class="text-center text-info mb-4" style="font-family: ui-rounded;">Thanh toán MoMo </h3>
                <div class="card" style="width:400px; margin-left: 18%;">
                    <img class="card-img-top" src="https://res.cloudinary.com/dvsqhstsi/image/upload/v1662561968/t%E1%BA%A3i_xu%E1%BB%91ng_1_buk34j.png" alt="Card image" >
                </div>
                <h4 class="card-title text-center text-secondary">Đang chờ thanh toán</h4>
                <p class="card-text text-danger" style="font-weight: bold">Thời gian quét mã QR để thanh toán còn <span id="container"></span> giây! </p>
                <h5>Thanh toán với ví momo bằng mã QR  </h5>
                <p class="formatP">Hướng dẫn thanh toán</p>
                <li class="formatP">Bước 1: Mở ứng dụng momo</li>
                <li class="formatP">Bước 2: Chọn "Thanh toán" <i class="fa-solid fa-qrcode"></i> và quét mã QR</li>
                <li class="formatP">Bước 3: Xác nhận thanh toán ở ứng dụng</li>
                <div style="float:right;"> 
                    <a type="button" class="btn btn-info" href="<c:url value="/"/>">Trở về</a> 
                </div>
            </form>
        </div>
    </div>
</div>


<script type="text/javascript">
    var time = 90;
    var page = "/BookingTicketWeb";
    function countDown() {
        time--;
        gett("container").innerHTML = time;
        if (time === 0) {
            window.location = page;
        }
    }
    function gett(id) {
        if (document.getElementById)
            return document.getElementById(id);
        if (document.all)
            return document.all.id;
        if (document.layers)
            return document.layers.id;
        if (window.opera)
            return window.opera.id;
    }
    function init() {
        if (gett('container')) {
            setInterval(countDown, 1000);
            gett("container").innerHTML = time;
        } else {
            setTimeout(init, 50);
        }
    }
    document.onload = init();
</script>