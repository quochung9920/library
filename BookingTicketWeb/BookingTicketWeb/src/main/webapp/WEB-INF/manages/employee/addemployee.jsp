<%-- 
    Document   : addemployee
    Created on : Aug 14, 2022, 6:38:50 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2 class="text-center text-secondary">THÊM NHÂN VIÊN</h2>
<div id="error-message" class="text-center alert-danger"></div>

<form id="submitFormEmployee" onsubmit="submitUserEmployee()" acceptCharset="UTF-8" novalidate>
    <div class="form-group mb-3">
        <label for="name" class="form-label">Tên nhân viên</label>
        <input type="text" class="form-control" required id="name" name="name" placeholder="Nhập tên nhân viên..."/>
    <div class="invalid-feedback" id="invalid-feedback-name"></div>
    </div>
    <div class="form-group mb-3">
        <label for="email" class="form-label">Email</label>
        <input type="email" class="form-control" id="email" name="email" placeholder="Nhập địa chỉ email..."/>
    <div class="invalid-feedback" id="invalid-feedback-email"> </div>
    </div>
    <div class="form-group mb-3">
        <label for="phone" class="form-label">Số điện thoại</label>
        <input name="phone" required type="number" id="phone" class="form-control" placeholder="Nhập số điện thoại..."/>
    <div id="invalid-feedback-phone" class="invalid-feedback"></div>
    </div>
    <div class="form-group mb-3">
        <label for="identityCard" class="form-label">CMND/CCCD</label>
        <input type="number" required name="identityCard" id="identityCard" class="form-control" placeholder="Nhập CMND/CCCD..."/>
    <div  id="invalid-feedback-cmnd" class="invalid-feedback"></div>
    </div>
    <div class="form-group mb-3">
        <label for="address" class="form-label">Địa chỉ</label>
        <input type="text" required name="address" id="address" class="form-control" placeholder="Nhập điạ chỉ hiện tại..."/>
    <div class="invalid-feedback" id="invalid-feedback-ad"></div>
    </div>
    <div class="form-group mb-3">
        <label for="dateOfBirth" class="form-label">Ngày tháng năm sinh</label>
        <input type="date" required name="dateOfBirth" id="dateOfBirth" value="" max="" class="form-control" />
    <div class="invalid-feedback" id="invalid-feedback-license"></div>
    </div>
    <div class="form-group mb-3">
        <label for="gender" class="form-label">Chọn giới tính</label>
        <select class="form-select" required name="gender" id="gender">
            <option value="Nam">Nam</option>
            <option value="Nữ">Nữ</option>
        </select>
    </div>
    <div class="form-group mb-3">
        <label for="username" class="form-label">Tên đăng nhập</label>
        <input name="username" required id="username" class="form-control" placeholder="Nhập tên tài khoản..."/>
    <div class="invalid-feedback" id="invalid-feedback-uname"></div>
    </div>
    <div class="form-group mb-3">
        <label for="password" class="form-label">Mật khẩu</label>
        <input type="password" required name="password" id="password" class="form-control" placeholder="Nhập mật khẩu..."/>
    <div id="invalid-feedback-password" class="invalid-feedback"></div>
    </div>
    <div class="form-group mb-3">
        <label for="confirmPassword">Xác nhận mật khẩu</label>
        <input type="password" required name="confirmPassword" 
               id="confirmPassword" class="form-control" 
               placeholder="Nhập mật khẩu xác nhận..."
               data-bs-toggle="tooltip" data-bs-placement="right" title="Bạn phải nhập mật khẩu xác nhận!"/>
    <div class="invalid-feedback" id="invalid-feedback-cfpassword"></div>
    </div>
    <div class="form-group mb-3">
        <label for="avt" class="form-label">Ảnh đại diện</label>
        <input class="form-control" required type="file" id="upload_avatar">
    </div>
    <div class="form-group mb-3">
        <label for="userrole" class="form-label">Vai trò</label>
        <select class="form-select" required name="userrole" id="userrole">
            <option value="Admin">Admin</option>
            <option value="Employee">Employee</option>
        </select>
    </div>

    <div class="form-group">
        <input class="btn btn-success" type="submit" value="Thêm"/>

        <a href="<c:url value="/admin/employees/addemployee" />" class="btn btn-info" type="button" data-toggle="tooltip" 
           data-placement="top" title="Quay lại"><i class="fas fa-undo"></i></a>

        <a href="<c:url value="/admin/employees/list" />" class="btn btn-secondary" type="button" data-toggle="tooltip" 
           data-placement="top" title="Danh sách"> <i class="fas fa-list"></i></a> 
    </div>
</form>

<script src="<c:url value="/js/employee.js"/>"></script>
