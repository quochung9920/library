<%-- 
    Document   : addtrip
    Created on : Aug 14, 2022, 3:18:06 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2 class="text-center text-secondary">THÊM CHUYẾN XE</h2>
<div id="error-message" class="text-center alert-danger"></div>

<form id="submitFormTrip" onsubmit="submitTrip()" enctype="multipart/form-data" acceptCharset="UTF-8" novalidate>
    <div class="mb-3">
        <label class="form-label">Tên chuyến</label>
        <input type="text" class="form-control" id="coachname" required name="coachname" placeholder="Nhập tên chuyến..."/>
    <div class="invalid-feedback" id="invalid-feedback-coach"></div>
    </div>
    <div class="mb-3">
        <label class="form-label" for="departureday">Ngày khởi hành</label>
        <input type="date" class="form-control" id="departureday" required name="departureday" placeholder="Nhập ngày khởi hành..."/>
    <div class="invalid-feedback" id="invalid-feedback-day"> </div>
    </div>
    <div class="mb-3">
        <label class="form-label" for="departuretime">Giờ khởi hành </label>
        <input type="text" class="form-control" id="departuretime" required name="departuretime" placeholder="Nhập giờ khởi hành..."/>
    <div id="invalid-feedback-departT" class="invalid-feedback"></div>
    </div>
    <div class="mb-3">
        <label class="form-label" for="arrivaltime">Giờ đến</label>
        <input type="text" class="form-control" id="arrivaltime" required name="arrivaltime" placeholder="Nhập giờ đến..."/>
        <div id="invalid-feedback-arrival" class="invalid-feedback"></div>
    </div>
    <div class="mb-3">
        <label class="form-label">Tuyến xe</label>
        <select class="form-select" id="routeId" name="routeId">
            <c:forEach items="${routes}" var="r">
                <option value="${r.id}">${r.routename}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label class="form-label">Nhân viên phụ trách</label>
        <select class="form-select" id="userIdEmployee" name="userIdEmployee">
            <c:forEach items="${users}" var="r">
                <option value="${r.id}">${r.name}</option>
            </c:forEach>
        <select>
    </div>
    <div class="mb-3">
        <label class="form-label">Xe</label>
        <select class="form-select" id="passengercarId" name="passengercarId">
            <c:forEach items="${pcars}" var="r">
                <option value="${r.id}">${r.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label class="form-label">Ảnh</label>
        <input type="file" class="form-control" id="upload_image" placeholder="Chọn ảnh..."/>
    <div id="invalid-feedback-image" class="invalid-feedback"></div>
    </div>
    <div>
        <input class="btn btn-success" type="submit" value="Thêm"/>

        <a href="<c:url value="/admin/trips/addtrip" />" class="btn btn-info" type="button" data-toggle="tooltip" 
           data-placement="top" title="Quay lại"><i class="fas fa-undo"></i></a>

        <a href="<c:url value="/admin/trips/list" />" class="btn btn-secondary" type="button" data-toggle="tooltip" 
           data-placement="top" title="Danh sách"> <i class="fas fa-list"></i></a> 
    </div>
</form>
<script src="<c:url value="/js/trip.js"/>"></script>
