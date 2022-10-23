<%-- 
    Document   : adddriverdt
    Created on : Aug 15, 2022, 6:51:25 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2 class="text-center text-secondary">GÁN TÀI XẾ CHẠY CÁC CHUYẾN XE</h2>
<c:url value="/admin/driverdetails/savedriver" var="save" />
<form:form action="${save}" modelAttribute="driver" method="post">
    <div class="mb-3">
        <label class="form-label">Tên tuyến</label>
        <form:select path="tripId" class="form-select">
            <c:forEach items="${trips}" var="r">
                <option value="${r.id}">${r.coachname}</option>
            </c:forEach>
        </form:select>
    </div>
    <div class="mb-3">
        <label class="form-label">Tài xế</label>
        <form:select path="userIdDriver" class="form-select">
            <c:forEach items="${users}" var="r">
                <option value="${r.id}">${r.name}</option>
            </c:forEach>
        </form:select>
    </div>
    <div class="mb-3">
        <label class="form-label">Vị trí</label>
        <form:select path="driverrole" class="form-select">
                <option>MainDriver</option>
                <option>Driver</option>
                <option>Assistant</option>
        </form:select>
    </div>
    <div>
        <input class="btn btn-success" type="submit" value="Thêm"/>

        <a href="<c:url value="/admin/driverdetails/adddriver" />" class="btn btn-info" type="button" data-toggle="tooltip" 
           data-placement="top" title="Quay lại"><i class="fas fa-undo"></i></a>

        <a href="<c:url value="/admin/driverdetails/list" />" class="btn btn-secondary" type="button" data-toggle="tooltip" 
           data-placement="top" title="Danh sách"> <i class="fas fa-list"></i></a> 
    </div>
</form:form>
