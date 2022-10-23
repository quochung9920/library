<%-- 
    Document   : trips
    Created on : Aug 14, 2022, 3:17:54 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!---->
<h1 class="text-center text-danger">DANH SÁCH CÁC CHUYẾN XE</h1>

<c:url value="/admin/trips/search" var="search" />
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
<div class="mailbox-border" style="float: right">
    <div class="float-left">
        <div class="btn btn_1 mrg5R">
            <c:url value="/admin/trips/addtrip" var="add" />
            <a style="color: green" title="Thêm" href="${add}"><i class="fa fa-plus"> </i></a>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>

<c:if test="${listTrips.size()==0}">
    <p><em>Không có chuyến xe nào có thông tin bạn đang tìm!!!</em></p>
</c:if> 

<table class="table table-bordered">
    <thead class="admin-table text-center">
        <tr>
            <th colspan="2" style="width: 5px">Mã chuyến</th>
            <th style="width: 80px">Tên chuyến</th>
            <th style="width: 100px">Ngày khởi hành</th>
            <th style="width: 100px">Giờ khởi hành</th>
            <th style="width: 100px">Giờ đến</th>
            <th style="width: 40px">Trạng thái</th>
            <th>Tuyến xe</th>
            <th>Nhân viên phụ trách</th> 
            <th>Xe</th> 
            <th colspan="3" style="width: 20px">Chức năng</th>
        </tr>
    </thead>
    <tbody>

        <c:forEach items="${listTrips}" var="r">
            <tr>
                <td>${r.id}</td>
                <td><img src="${r.image}" width="50px" alt="${r.coachname}"/></td>
                <td>${r.coachname}</td>
                <td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${r.departureday}" /></td>
                <td><fmt:formatDate type = "time" value = "${r.departuretime}" /></td>
                <td><fmt:formatDate type = "time" value = "${r.arrivaltime}" /></td>
                <c:if test="${r.active==true}">
                    <td class="text-center"><i class="fas fa-check-square"></i></td>
                    </c:if>
                    <c:if test="${r.active==false}">
                    <td class="text-center"><i class="fas fa-window-close"></i></td>
                    </c:if>
                <td>${r.routeId.routename}</td>
                <td>${r.userIdEmployee.user.name}</td>
                <td>${r.passengercarId.name}</td>
                <td>
                    <c:url value="/admin/trips/edittrip/${r.id}" var="edit" />
                    <a href="${edit}"style="color: #7c4c02"
                       title="Sửa" style="margin-right: 5px"><i class="fa fa-edit"></i></a>
                </td>
                <td>
                    <c:url value="/admin/trips/deletetrip/${r.id}" var="delete" />
                    <a href="#" onclick="showMess(${r.id})" style="color: tomato"
                       title="Xóa"><i class="bi bi-trash"></i></a>
                </td>
                <td>
                    <c:url value="/admin/trips/edittrip/image/${r.id}" var="edit" />
                    <a href="${edit}" style="color: #198754"
                       title="Sửa" style="margin-right: 5px"><i class="fas fa-file-edit"></i></a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<nav aria-label="Page navigation example" style="float: right">
    <ul class="pagination">
        <c:forEach var="i" begin="0" end="${totalItem}">
            <c:url value="/admin/trips/list/${i+1}" var="action" />
            <li class="page-item"><a class="page-link" href="${action}"><c:out value="${i+1}"/></a></li>
            </c:forEach>
    </ul>
</nav>

<script>
    function showMess(id) {
        var option = confirm('Bạn có chắc chắn muốn xóa không?');
        if (option === true)
            window.location.href = '/BookingTicketWeb/admin/trips/deletetrip/' + id;
    }
</script>
