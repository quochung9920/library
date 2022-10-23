<%-- 
    Document   : updateroute
    Created on : Aug 11, 2022, 8:07:25 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2 class="text-center text-secondary">THAY ĐỔI THÔNG TIN TUYẾN XE</h2>
<c:url value="/admin/routes/editroute" var="edit" />
<form:form action="${edit}" modelAttribute="route" method="post" enctype="multipart/form-data" acceptCharset="UTF-8">
    <div class="mb-3">
        <label class="form-label">Mã tuyến</label>
        <form:input type="text" class="form-control" path="id" readonly="true"/>
    </div>
    <div class="mb-3">
        <label class="form-label">Tên tuyến</label>
        <form:input type="text" class="form-control" path="routename"/>
        <form:errors path="routename" cssClass="text-danger" element="div"/>
    </div>
    <div class="mb-3">
        <label class="form-label">Điểm đi</label>
        <form:input type="text" class="form-control" path="startingpoint"/>
        <form:errors path="startingpoint" cssClass="text-danger" element="div"/>
    </div>
    <div class="mb-3">
        <label class="form-label">Điểm đến</label>
        <form:input type="text" class="form-control" path="destination"/>
        <form:errors path="destination" cssClass="text-danger" element="div"/>
    </div>
    <div class="mb-3">
        <label class="form-label">Giá tiền</label>
        <form:input type="number" class="form-control" path="price"/>
        <form:errors path="price" cssClass="text-danger" element="div"/>
    </div>
    <div class="mb-3">
        <label class="form-label">Giá đặc biệt</label>
        <form:input type="number" class="form-control" path="specialprice"/>
    </div>
    <div class="mb-3">
        <label class="form-label">Ảnh tuyến</label>
        <form:input type="text" class="form-control" path="image" readonly="true"/>
    </div>
    <div>
        <input class="btn btn-warning" type="submit" value="Sửa"/>     
        <a href="<c:url value="/admin/routes/list" />" class="btn btn-info" type="button" data-toggle="tooltip" 
           data-placement="top" title="Hủy"><i class="fas fa-undo"></i></a> 
    </div>
</form:form>
