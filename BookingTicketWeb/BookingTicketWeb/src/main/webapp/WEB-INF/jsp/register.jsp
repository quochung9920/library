<%-- 
    Document   : register
    Created on : Aug 10, 2022, 7:38:45 PM
    Author     : dieuh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>--%>
<div class="container register">
    <h1 class="text-center text-danger">ĐĂNG KÝ</h1><!-- comment -->
    <p class="text-center text-primary">Vui lòng điền đầy đủ thông tin để đăng ký tài khoản!</p>
    <c:if test="${errMsg != null}">
        <div class="alert alert-danger">${errMsg}</div> 
    </c:if>

    <c:url value="/register" var="action" />

    <form:form method="post" action="${action}" enctype="multipart/form-data" modelAttribute="user" style=" border: 1px solid #ebedee; border-radius: 8px;">

        <div class="form-group">
            <label for="name">Tên đầy đủ</label>
            <form:input type="text" path="name" id="name" class="form-control" />
            <form:errors path="name"  cssClass="text-danger" element="div"/>
        </div>

        <div class="form-group">
            <label for="username">Tên đăng nhập</label>
            <form:input type="text" path="username" id="username" class="form-control" />
            <form:errors path="username" cssClass="text-danger" element="div"/>
        </div>

        <div class="form-group">
            <label for="password">Mật khẩu</label>
            <form:input type="password" id="password" path ="password" class="form-control" />
            <form:errors path="password"  cssClass="text-danger" element="div"/>
        </div>

        <div class="form-group">
            <label for="confirm-password">Xác nhận mật khẩu</label>
            <form:input type="password" id="confirm-password" path ="confirmPassword" class="form-control" />

        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <form:input type="email" id="email" path ="email" class="form-control" />
            <form:errors path="email" cssClass="text-danger" element="div"/>
        </div>

        <div class="form-group">
            <label for="phone">Số điện thoại</label>
            <form:input type="number" id="phone" path ="phone" class="form-control" />
            <form:errors path="phone"  cssClass="text-danger" element="div"/>
        </div>

        <div class="form-group">
            <label for="avatar">Ảnh đại diện</label>
            <form:input type="file" id="avatar" path ="avt" class="form-control" />
            <form:errors path="avatar"  cssClass="text-danger" element="div"/>
        </div>
        <div style="display: flex">
            <div class="form-group">
                <input type="submit" value="Đăng ký" class="btn btn-danger" />
            </div>
            <div class="form-group">
                <a class="btn btn-info" href="<c:url value="/"/>">Trở lại</a>
            </div>
        </div>
    </form:form>
</div>
