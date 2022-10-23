<%-- 
    Document   : updateemployee
    Created on : Aug 14, 2022, 6:39:02 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2 class="text-center text-secondary">THAY ĐỔI THÔNG TIN NHÂN VIÊN</h2>
<div id="error-message" class="text-center alert-danger"></div>

<form:form id="formUser" modelAttribute="user" method="post">
    <div class="mb-3">
        <label class="form-label">Mã nhân viên</label>
        <form:input type="number" class="form-control" name="id" id="id" path="id" readonly="true"/>
    </div>
    <div class="mb-3">
        <label class="form-label">Tên nhân viên</label>
        <form:input type="text" class="form-control" path="name" id="name" name="name"/>
     <div class="invalid-feedback" id="invalid-feedback-name"></div>
    </div>
    <div class="mb-3">
        <label class="form-label">Email</label>
        <form:input type="text" class="form-control" path="email" id="email" name="email"/>
    <div class="invalid-feedback" id="invalid-feedback-email"> </div>
    </div>
    <div class="mb-3">
        <label class="form-label">Số điện thoại</label>
        <form:input type="number" class="form-control" path="phone" id="phone" name="phone"/>
     <div id="invalid-feedback-phone" class="invalid-feedback"></div>
    </div>
</form:form>
<form:form id="formEmployee" modelAttribute="employee">
    <div class="mb-3">
        <label class="form-label">CMND/CCCD</label>
        <form:input type="number" class="form-control" name="identityCard" id="identityCard" path="identitycard"/>
    <div  id="invalid-feedback-cmnd" class="invalid-feedback"></div>
    </div>
    <div class="mb-3">
        <label class="form-label">Địa chỉ</label>
        <form:input type="text" class="form-control" name="address" id="address" path="address"/>
     <div class="invalid-feedback" id="invalid-feedback-ad"></div>
    </div>
    <div class="mb-3">
        <label class="form-label">Ngày tháng năm sinh</label>
        <form:input type="date" class="form-control" name="dateOfBirth" id="dateOfBirth" path="dateofbirth"/>
     <div class="invalid-feedback" id="invalid-feedback-license"></div>
    </div>
    <div class=" mb-3">
        <label for="gender" class="form-label">Chọn giới tính</label>
        <select class="form-select" name="gender" id="gender">
            <option value="Nam" ${employee.gender =="Nam"?"selected":""}>Nam</option>
            <option value="Nữ" ${employee.gender =="Nữ"?"selected":""}>Nữ</option>
        </select>
    </div>
</form:form>

<div>
    <button class="btn btn-warning" onclick="updateEmployee()">Sửa</button>   
    <a href="<c:url value="/admin/employees/list" />" class="btn btn-info" type="button" data-toggle="tooltip" 
       data-placement="top" title="Hủy"><i class="fas fa-undo"></i></a> 
</div>

<script src="<c:url value="/js/employee.js"/>"></script>
