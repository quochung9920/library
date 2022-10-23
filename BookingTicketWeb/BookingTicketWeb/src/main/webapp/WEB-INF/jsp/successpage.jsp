<%-- 
    Document   : successpage
    Created on : Sep 2, 2022, 1:22:53 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
                <div class="thanks-message text-center" id="text-message"> <img src="https://i.imgur.com/O18mJ1K.png" width="100" class="mb-4">
                    <h3>Bạn đã thanh toán thành công!</h3> 
                    <span class="formatP">Cảm ơn bạn đã sử dụng dịch vụ của chúng tôi! Chúc bạn một ngày thật vui vẻ!</span>
                    <p class="formatP text-danger" style="font-weight: bold">Quay lại trang chủ trong vòng <span id="container"></span> giây!</p>
                </div>
                <div style="float:right;"> 
                 <a type="button" class="btn btn-info" href="<c:url value="/"/>">Trở về</a> 
                </div>
            </form>
        </div>
    </div>
</div>

<script type="text/javascript">
    var time = 15;
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
