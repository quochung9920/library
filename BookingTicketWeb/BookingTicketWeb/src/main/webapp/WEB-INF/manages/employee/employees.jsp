<%-- 
    Document   : employees
    Created on : Aug 14, 2022, 6:38:39 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!---->
<h1 class="text-center text-danger">DANH SÁCH NHÂN VIÊN</h1>

<c:url value="/admin/employees/search" var="search" />
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


<c:if test="${listEmployees.size()==0}">
    <p><em>Không có nhân viên nào có thông tin bạn đang tìm!!!</em></p>
</c:if>

<div class="mailbox-border" style="float: right">
    <div class="float-left">
        <div class="btn btn_1 mrg5R">
            <c:url value="/admin/employees/addemployee" var="add" />
            <a style="color: green" title="Thêm" href="${add}"><i class="fa fa-plus"> </i></a>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>

<table class="table table-bordered">
    <thead class="admin-table text-center">
        <tr>
            <th style="width: 20px">Mã NV</th>
            <th>Họ và tên</th>
            <th>Ngày sinh</th>
            <th>CMND</th>
            <th style="width: 150px">Email</th>
            <th style="width: 30px">Giới tính</th>
            <th style="width: 100px">Số điện thoại</th>
            <th>Địa chỉ</th>
            <th colspan="2" style="width: 25px">Chức năng</th>
        </tr>
    </thead>
    <tbody> 
        <c:forEach items="${listEmployees}" var="r">
            <tr>
                <td>${r.userIdEmployee}</td>
                <td>${r.user.name}</td>
                <td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${r.dateofbirth}" /></td>
                <td>${r.identitycard}</td>
                <td>${r.user.email}</td>

                <c:if test="${r.gender=='Nữ'}">
                    <td class="text-center"><i class="fas fa-venus"></i></td>
                    </c:if>
                    <c:if test="${r.gender=='Nam'}">
                    <td class="text-center"><i class="fas fa-mars"></i></td>
                    </c:if>

                <td>${r.user.phone}</td>
                <td>${r.address}</td>
                <td>
                    <c:url value="/admin/employees/editemployee/${r.userIdEmployee}" var="edit" />
                    <a href="${edit}" style="color: #7c4c02"
                       title="Sửa" style="margin-right: 5px"><i class="fa fa-edit"></i></a>
                </td>
                <td>
                    <c:url value="/admin/employees/deleteemployee/${r.userIdEmployee}" var="delete" />
                    <a href="#" onclick="showMess(${r.userIdEmployee})" style="color: tomato"
                       title="Xóa"><i class="bi bi-trash"></i></a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<nav aria-label="Page navigation example" style="float: right">
    <ul class="pagination">
        <c:forEach var="i" begin="0" end="${totalItem}">
            <c:url value="/admin/employees/list/${i+1}" var="action" />
            <li class="page-item"><a class="page-link" href="${action}"><c:out value="${i+1}"/></a></li>
        </c:forEach>
    </ul>
</nav>
<script>
    function showMess(id) {
        var option = confirm('Bạn có chắc chắn muốn xóa không?');
        if (option === true)
            alert('Vì nhân viên liên quan đến nhiều trường dữ liệu khác nhau => KHÔNG được phép xóa!\n\
                                        VUI LÒNG QUAY LẠI!');
    }
</script>