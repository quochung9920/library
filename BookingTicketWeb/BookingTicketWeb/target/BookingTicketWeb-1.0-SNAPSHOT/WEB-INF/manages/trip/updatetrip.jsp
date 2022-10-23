<%-- 
    Document   : updatetrip
    Created on : Aug 14, 2022, 3:18:23 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<h2 class="text-center text-secondary">THAY ĐỔI THÔNG TIN CHUYẾN XE</h2>
<div id="error-message" class="text-center alert alert-danger"></div>

<form:form id="formUpdateTrip" modelAttribute="trip" enctype="multipart/form-data" acceptCharset="UTF-8">
    <div class="mb-3">
        <label class="form-label">Mã chuyến</label>
        <form:input type="text" class="form-control" path="id" id="id" name="id" readonly="true"/>
    </div>
    <div class="mb-3">
        <label class="form-label">Tên chuyến</label>
        <form:input type="text" class="form-control" id="coachname" name="coachname" path="coachname"/>
        <div class="invalid-feedback" id="invalid-feedback-coach"></div>
    </div>
    <div class="mb-3">
        <label class="form-label" for="departureday">Ngày khởi hành</label>
        <form:input type="date" class="form-control" path="departureday" id="departureday" name="departureday"/>
        <div class="invalid-feedback" id="invalid-feedback-day"> </div>
    </div>
    <div class="mb-3">
        <label class="form-label" for="departuretime">Giờ khởi hành</label>
        <form:input type="text" class="form-control" path="departuretime" id="departuretime" name="departuretime"/>
        <div id="invalid-feedback-departT" class="invalid-feedback"></div>
    </div>
    <div class="mb-3">
        <label class="form-label" for="arrivaltime">Giờ đến</label>
        <form:input type="text" class="form-control" path="arrivaltime" name="arrivaltime"  id="arrivaltime"/>
        <div id="invalid-feedback-arrival" class="invalid-feedback"></div>
    </div>
    <div class="mb-3">
        <label class="form-label">Tuyến xe</label>
        <form:select path="routeId" class="form-select" id="routeId" name="routeId">
            <option value="${trip.routeId.id}">${trip.routeId.routename}</option>
            <c:forEach items="${routes}" var="r">
                <option value="${r.id}">${r.routename}</option>
            </c:forEach>
        </form:select>
    </div>
    <div class="mb-3">
        <label class="form-label">Nhân viên phụ trách</label>
        <form:select path="" class="form-select" id="userIdEmployee" name="userIdEmployee">
            <option value="${trip.userIdEmployee.userIdEmployee}">${trip.userIdEmployee.user.name}</option>
            <c:forEach items="${users}" var="r">
                <option value="${r.id}">${r.name}</option>
            </c:forEach>
        </form:select>
    </div>
    <div class="mb-3">
        <label class="form-label">Xe</label>
        <form:select class="form-select" id="passengercarId" name="passengercarId" path="passengercarId">
            <option value="${trip.passengercarId.id}">${trip.passengercarId.name}</option>
            <c:forEach items="${pcars}" var="r">
                <option value="${r.id}">${r.name}</:option>
                </c:forEach>
            </form:select>
    </div>
    <div class="mb-3">
        <label class="form-label">Trạng thái</label>
        <form:select class="form-select" path="active" id="active" name="active">
            <option value="true" ${trip.active =="true"?"selected":""}>true</option>
            <option value="false" ${trip.active =="false"?"selected":""}>false</option>
        </form:select>
    </div>
    <div class="mb-3">
        <label class="form-label">Ảnh chuyến</label>
        <form:input type="text" class="form-control" id="image" name="image" path="image" readonly="true"/>
    </div>
    <div>
        <input class="btn btn-warning" type="submit" onclick="updateTrip()" value="Sửa"/>     
        <a href="<c:url value="/admin/trips/list" />" class="btn btn-info" type="button" data-toggle="tooltip" 
           data-placement="top" title="Hủy"><i class="fas fa-undo"></i></a> 
    </div>
</form:form>
<script src="<c:url value="/js/trip.js"/>"></script>