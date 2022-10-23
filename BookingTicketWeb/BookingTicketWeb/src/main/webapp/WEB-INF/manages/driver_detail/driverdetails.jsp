<%-- 
    Document   : driverdetails
    Created on : Aug 14, 2022, 10:42:42 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-danger">DANH SÁCH PHÂN CÔNG TÀI XẾ</h1>

<div>
    <c:url value="/admin/driverdetails/search" var="search" />
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
</div>

<c:if test="${listDrivers.size()==0}">
    <p><em>Không có tài xế nào có thông tin bạn đang tìm!!!</em></p>
</c:if>

<div class="mailbox-border" style="float: right">
    <div class="float-left">
        <div class="btn btn_1 mrg5R">
            <c:url value="/admin/driverdetails/adddriver" var="add" />
            <a style="color: green" title="Thêm" href="${add}"><i class="fa fa-plus"> </i></a>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>

<table class="table table-bordered text-center">
    <thead class="admin-table text-center">
        <tr>
            <th style="width: 30px">STT</th>
            <th>Chuyến đi</th>
            <th>Tên tài xế</th>
            <th>Vị trí</th>
            <th>Chức năng</th>
        </tr>
    </thead>
    <tbody> 
        <c:forEach items="${listDrivers}" var="r">
            <tr>
                <td>${r.id}</td>
                <td>${r.tripId.coachname}</td>
                <td>${r.userIdDriver.user.name}</td>
                <td>${r.driverrole}</td>
                <td>
                    <c:url value="/admin/driverdetails/editdriver/${r.id}" var="edit" />
                    <a href="${edit}" style="color: #7c4c02"
                       title="Sửa" style="margin-right: 5px"><i class="fa fa-edit"></i></a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation example" style="float: right">
    <ul class="pagination">
        <c:forEach var="i" begin="0" end="${totalItem}">
            <c:url value="/admin/driverdetails/list/${i+1}" var="action" />
            <li class="page-item"><a class="page-link" href="${action}"><c:out value="${i+1}"/></a></li>
        </c:forEach>
    </ul>
</nav>
<script src="<c:url value="/js/route.js"/>"></script>