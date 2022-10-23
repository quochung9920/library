<%-- 
    Document   : updatedriverdt
    Created on : Aug 14, 2022, 10:42:26 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2 class="text-center text-secondary">THAY ĐỔI TÀI XẾ CHUYẾN XE</h2>
<c:url value="/admin/driverdetails/editdriver" var="edit" />
<form:form action="${edit}" modelAttribute="driver" method="post">
    <div class="mb-3">
        <label class="form-label">Mã phân công</label>
        <form:input type="text" class="form-control" path="id" readonly="true"/>
    </div>
    <div class="mb-3">
        <label class="form-label">Mã tuyến</label>
        <form:input type="text" class="form-control" path="tripId.id" readonly="true"/>
    </div>
    <div class="mb-3">
        <label class="form-label">Tên tuyến</label>
        <form:input type="text" class="form-control" path="tripId.coachname" readonly="true"/>
    </div>
    <div class="mb-3">
        <label class="form-label">Tài xế</label>
        <form:select path="userIdDriver" class="form-select">
            <option>${driver.userIdDriver.user.name}</option>
            <c:forEach items="${users}" var="r">
                <option value="${r.id}">${r.name}</option>
            </c:forEach>
        </form:select>
    </div>
    <div class="mb-3">
        <label class="form-label">Vị trí</label>
        <form:select path="driverrole" class="form-select">
                <option>${driver.driverrole}</option>
                <option>MainDriver</option>
                <option>Driver</option>
                <option>Assistant</option>
        </form:select>
    </div>
    <div>
        <input class="btn btn-warning" type="submit" value="Sửa"/>     
        <a href="<c:url value="/admin/driverdetails/list" />" class="btn btn-info" type="button" data-toggle="tooltip" 
           data-placement="top" title="Hủy"><i class="fas fa-undo"></i></a> 
    </div>
</form:form>