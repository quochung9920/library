<%-- 
    Document   : trip
    Created on : Aug 11, 2022, 4:11:26 PM
    Author     : dieuh
--%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div id="demo" class="carousel slide" data-bs-ride="carousel" style="padding-top:10px;">

    <!-- Indicators/dots -->
    <div class="carousel-indicators">
        <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
        <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
        <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
    </div>

    <!-- The slideshow/carousel -->
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="<c:url value="/img/xekhach1.jpg"/>" alt="Los Angeles" class="d-block w-100 " style="height: 400px;">
            <div class="carousel-caption">
                <h1 style="padding-top: 100px; ">CHUYẾN XE ĐỒNG HÀNH CÙNG CÁC BẠN</h1>
                <p>We will give you a great experience!!!</p>
            </div>
        </div>

        <div class="carousel-item">
            <img src="<c:url value="/img/xekhach2.jpg"/>" alt="Los Angeles" class="d-block w-100 " style="height: 400px;">
            <div class="carousel-caption">
                <h1 style="padding-top: 100px; " >CHUYẾN XE ĐỒNG HÀNH CÙNG CÁC BẠN</h1>
                <p>We will give you a great experience!!!</p>
            </div>
        </div>

        <div class="carousel-item">
            <img src="<c:url value="/img/xekhach3.jpg"/>" alt="Los Angeles" class="d-block w-100 " style="height: 400px;">
            <div class="carousel-caption">
                <h1 style="padding-top:100px; ">CHUYẾN XE ĐỒNG HÀNH CÙNG CÁC BẠN</h1>
                <p>We will give you a great experience!!!</p>
            </div>
        </div>
    </div>

    <!-- Left and right controls/icons -->
    <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
        <span class="carousel-control-prev-icon"></span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
        <span class="carousel-control-next-icon"></span>
    </button>
</div>

<form action="" style="margin-top: 70px;">
    <div id="search-departureday">
        <div style="width: 100%;display: flex; margin-top: 20px;">
            <label style="width: 20%; font-size:20px; margin-left: 80px; margin-top: 45px;">Chọn ngày đi  </label>
            <input type="date" name="kw" id="departureday1"  class="form-control" /> 

        </div>  
        <input type="submit" value="Tìm" id="submitdepartureday" class="btn btn-dark"/>
    </div>  
</form>

<div class="row trip-body" style="margin-top: 70px;">
    <div>
        <h1 id="nen">Danh sách các chuyến đi</h1>
    </div>
    <c:if test="${tripDeparturedays.size() == 0}">
        <div class="alert alert-danger" style="margin-left: 27%; width: 50%; font-size: 20px; text-align: center">Hôm nay không có chuyến xe nào khởi hành !!!</div>  
    </c:if>
    <hr> 
    <c:forEach var="tripDepartureday" items="${tripDeparturedays}">
        <div id="blocktrip">  
            <div class="card" style="width: 35%;">
                <img style=" height: 300px;" class=" img-fluid card-header" id="trip-img" src="<c:url value="${tripDepartureday.image}"/>" alt="${tripDepartureday.coachname}" />  
            </div>
            <div id="trip-right">
                <div style="display: flex">   
                    <h1> <i class="fa-solid fa-bus" id="coachname"></i> ${tripDepartureday.routeId.startingpoint} - ${tripDepartureday.routeId.destination}</h1>
                    <h9 style="margin-left: 170px; margin-top: 18px;"><i class="fa-solid fa-calendar-check"> </i> <fmt:formatDate pattern = "dd/MM/yyyy" value = "${tripDepartureday.departureday}" /></h9>
                </div>
                <hr>                   
                <div id="trip-p">
                    <p id="p-1" ><i class="fa-solid fa-hourglass-start"></i> Thời gian đi: <fmt:formatDate type = "time" value = "${tripDepartureday.departuretime}" />  </p>  
                    <p id="p-2" ><i class="fa-solid fa-hourglass-end"></i> Thời gian đến: <fmt:formatDate type = "time" value = "${tripDepartureday.arrivaltime}" /> </p>
                </div>  

                <div id="trip-p">
                    <p id="p-1" ><i class="fa-solid fa-chair"></i> Ghế trống: <input style=" border: none;background-color: white" id="result-${tripDepartureday.id}"
                                                                                     onmouseover ="cRemain(${tripDepartureday.id})"/></p>
                    <p id="p-2" ><i class="fa-solid fa-bus-simple"></i> Loại: ${tripDepartureday.passengercarId.categoryId.categoryname}</p>
                </div>
                <div> </div>

                <div id="trip-a" >                        
                    <c:if test="${pageContext.request.userPrincipal.name == null}">
                        <a href="<c:url value="/login"/>" id="priceInfo"  class="btn btn-dark action">Đặt</a>
                    </c:if>
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <a href="<c:url value="/reservation/${tripDepartureday.id}"/>" id="priceInfo"  class="btn btn-dark action">Đặt</a>
                    </c:if>                    
                    <a href="<c:url value="/comment/${tripDepartureday.id}"/>"  id="priceInfo" style="margin-left: 80px;" class="btn btn-dark action">Phản hồi</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

<script src="<c:url value="/js/trip.js"/>"></script>