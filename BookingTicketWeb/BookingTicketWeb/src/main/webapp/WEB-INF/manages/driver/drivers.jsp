<%-- 
    Document   : drivers
    Created on : Aug 14, 2022, 6:29:27 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!---->
<h1 class="text-center text-danger">DANH SÁCH TÀI XẾ</h1>

<c:url value="/admin/drivers/search" var="search" />
<form:form action="${search}" method="get">
    <div class="input-group">
        <div class="form-outline">
            <input id="search-input" type="search" class="form-control" name="kw" placeholder="Nhập từ khóa cần tìm..." />
        </div>
        <div>
            <button id="search-button" type="submit" class="btn btn-default">
                <i class="fas fa-search"></i>
            </button>
        </div>
    </div>
</form:form>


<c:if test="${listDrivers.size()==0}">
    <p><em>Không có tài xế nào có thông tin bạn đang tìm!!!</em></p>
</c:if> 

<div class="mailbox-border" style="float: right">
    <div class="float-left">
        <div class="btn btn_1 mrg5R">
            <c:url value="/admin/drivers/adddriver" var="add" />
            <a style="color: green" title="Thêm" href="${add}"><i class="fa fa-plus"></i></a>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>

<table class="table table-bordered">
    <thead class="admin-table text-center">
        <tr>
            <th style="width: 30px">Mã TX</th>
            <th>Họ và tên</th>
            <th>Ngày sinh</th>
            <th>CMND</th>
            <th>Email</th>
            <th>Số điện thoại</th>
            <th>Địa chỉ</th>
            <th style="width: 30px">Hạng bằng</th>
            <th colspan="2" style="width: 25px">Chức năng</th>
        </tr>
        </thead>
    <tbody>
        <c:forEach items="${listDrivers}" var="r">
            <tr>
                <td>${r.userIdDriver}</td>
                <td>${r.user.name}</td>
                <td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${r.dateofbirth}" /></td>
                <td>${r.identitycard}</td>
                <td>${r.user.email}</td>
                <td>${r.user.phone}</td>
                <td>${r.address}</td>
                <td>${r.license}</td>
                <td>
                    <c:url value="/admin/drivers/editdriver/${r.userIdDriver}" var="edit" />
                    <a style="color: #7c4c02" href="${edit}"title="Sửa" style="margin-right: 5px"><i class="fa fa-edit"></i></a>
                </td>
                <td>
                    <c:url value="/admin/drivers/deletedriver/${r.userIdDriver}" var="delete" />
                    <a href="#" style="color: tomato" onclick="showMess(${r.userIdDriver})" 
                       title="Xóa"><i class="bi bi-trash"></i></a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<nav aria-label="Page navigation example" style="float: right">
    <ul class="pagination">
        <c:forEach var="i" begin="0" end="${totalItem}">
            <c:url value="/admin/drivers/list/${i+1}" var="action" />
            <li class="page-item"><a class="page-link" href="${action}"><c:out value="${i+1}"/></a></li>
            </c:forEach>
    </ul>
</nav>
<script>
    function showMess(id) {
        var option = confirm('Bạn có chắc chắn muốn xóa không?');
        if (option === true)
            alert('Vì tài xế liên quan đến nhiều trường dữ liệu khác nhau => KHÔNG được phép xóa!\n\
                                        VUI LÒNG QUAY LẠI!');
    }
</script>
