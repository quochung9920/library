<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <img src="<c:url value="/img/a1.jpg"/>" alt="Los Angeles" class="d-block w-100 " style="height: 500px;">
            <div class="carousel-caption">
                <h1 style="padding-top: 100px; ">CÁC TUYẾN ĐƯỜNG PHỔ BIẾN</h1>
                <p>We will give you a great experience!!!</p>
            </div>
        </div>

        <div class="carousel-item">
            <img src="<c:url value="/img/a3.jpg"/>" alt="Los Angeles" class="d-block w-100 " style="height: 500px;">
            <div class="carousel-caption">
                <h1 style="padding-top: 100px; " >CÁC TUYẾN ĐƯỜNG PHỔ BIẾN</h1>
                <p>We will give you a great experience!!!</p>
            </div>
        </div>

        <div class="carousel-item">
            <img src="<c:url value="/img/a5.jpg"/>" alt="Los Angeles" class="d-block w-100 " style="height: 500px;">
            <div class="carousel-caption">
                <h1 style="padding-top:100px; ">CÁC TUYẾN ĐƯỜNG PHỔ BIẾN</h1>
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


<!--Khi chỉ có admin mới hiện ra link này-->
<sec:authorize access="hasRole('Admin')">
    <div> 
        <a href="<c:url value="/admin" />" class="btn btn-danger" >Quản lý đặt vé </a>
    </div> 
</sec:authorize>

<form action="">
    <div class="row searchRoute">
        <ul class="nav" >
            <div class="selectPoint">
                <h5>Điểm đi</h5>
                <li class="nav-item point" >
                    <input class="form-control" list="browsers" name="kw" id="startingpoint">
                    <datalist id="browsers">
                        <option value="Sài Gòn">
                        <option value="Bình Định">
                        <option value="Phú Yên">
                        <option value="Bạc Liêu">
                        <option value="Bến Tre">
                        <option value="Hà Nội">
                        <option value="Đà Nẵng">
                        <option value="Cần Thơ">
                    </datalist>
                </li>
            </div>
            <li class="nav-item " style=""><i class="fa-solid fa-arrow-right-arrow-left btnpoint"></i></li>
            <div class="selectPoint">
                <h5>Điểm đến</h5>
                <li class="nav-item point" style="">
                    <input class="form-control" list="browsers" name="kw1" id="destination">
                    <datalist id="browsers">
                        <option value="Sài Gòn">
                        <option value="Bình Định">
                        <option value="Phú Yên">
                        <option value="Bạc Liêu">
                        <option value="Bến Tre">
                        <option value="Hà Nội">
                        <option value="Đà Nẵng">
                        <option value="Cần Thơ">
                    </datalist>
                </li> 
            </div>
            <li class="nav-item btnSearch" >
                <input style="background-color: rgba(255, 99, 71, 0.5); border-color: orange; border-radius: 5px;" id="search-search" type="submit" value="Tìm" />
            </li>
        </ul> 
    </div>
</form>

<c:if test="${routes.size() == 0}">
    <div class="alert alert-danger" style="margin-left: 27%; margin-top: 70px; width: 50%; font-size: 20px; text-align: center">Không có tuyến bạn cần tìm !!!</div>
</c:if>
<c:if test="${routes.size() != 0}">
    <div>
        <ul class="pagination">
            <c:forEach begin="1" end="${Math.ceil(counter/6)}" var="a">
                <li class="page-item"><a class="page-link" href="<c:url value="/" />?page=${a}">${a}</a></li>
                </c:forEach>
        </ul>
    </div>
</c:if>
<div class="row">

    <c:forEach var="route" items="${routes}">        
        <div class="col-md-4 col-xs-12" style="padding:10px;">
            <div class="card">
                <img style=" height: 250px;" class=" img1 img-fluid card-header" src="<c:url value="${route.image}"/>" alt="${route.routename}" />                

                <div class="card-body ">
                    <h3 ><i class="fa-solid fa-map-location-dot">  ${route.startingpoint} - ${route.destination}</i></h3>
                    <hr>
                    <diV style="display: flex;" class="show-p">

                        <g><i class="fa-solid fa-location-dot" > ${route.stretch}km </i></g>
                        <p><i class="fa-solid fa-clock"> ${route.time}h </i></p>
                        <p class="product-carousel-price"><small> <i class="fa-solid fa-money-bill-wave">  ${route.price} VNĐ</i></small></p> 
                    </diV>
                    <a href="<c:url value="/trip/${route.id}"/>"  id="priceInfo" class="btn btn-dark action" style="width: 100%; font-size: 20px;">Xem chi tiết</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

<hr style="margin-top: 30px;">
<h1 style="margin-top: 30px; color:orange; font-size: 50px; font-family: SFProText;">CHẤT LƯỢNG LÀ DANH DỰ </h1>
<div style="margin-top: 30px; display: flex; " class="infomation">
    <div class ="info" >
        <h1 class="h1"><i class="fa-solid fa-people-group"></i> 20M</h1>
        <H4 style="margin:10px; color: orange;">Hơn 20 triệu lượt khách</H4>
        <P style="margin:10px; ">Phục vụ hơn 20 triệu lượt khách/bình quân 1 năm trên toàn quốc</P>
    </div>
    <div class ="info" >
        <h1 class="h1"><i class="fa-solid fa-house-chimney-window " ></i> 250</h1>
        <H4 style="margin:10px; color: orange;">Hơn 250 phòng vé, phòng khách</H4>
        <P style="margin:10px; ">Có hơn 250 phòng vé, trạm trung chuyển, bến xe...trên toàn hệ thống</P>
    </div >
    <div style=" border-style: dotted; color: orange;" >
        <h1 class="h1"><i class="fa-solid fa-bus"></i> 1600</h1>
        <H4 style="margin:10px; color: orange;">Hơn 1,600 chuyến mỗi ngày</H4>
        <P style="margin:10px; ">Phục vụ hơn 1600 chuyến xe đường dài và liên tỉnh mỗi ngày</P>
    </div>
</div>


<!--    <div class="card" style="width:400px">
  <img class="card-img-top" src="img_avatar1.png" alt="Card image">
  <div class="card-body">
    <h4 class="card-title">John Doe</h4>
    <p class="card-text">Some example text.</p>
    <a href="#" class="btn btn-primary">See Profile</a>
  </div>
</div>-->
