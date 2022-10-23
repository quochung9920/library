<%-- 
    Document   : tickets
    Created on : Sep 4, 2022, 3:23:55 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!---->
<h1 class="text-center text-danger">THÔNG TIN VÉ XE</h1>

<c:url value="/tickets/search" var="search" />
<form:form action="${search}" method="get">
    <div class="input-group mb-4">
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


<c:if test="${listTrips.size()==0}">
    <p><em>Không có vé nào có thông tin bạn đang tìm!!!</em></p>
</c:if> 

<table class="table table-bordered">
    <thead class="admin-table text-center">
        <tr>
            <th style="width: 5px">Mã vé</th>
            <th style="width: 100px">Người mua</th>
            <th style="width: 5px">SĐT</th>
            <th style="width: 30px">Vị trí ngồi</th>
            <th style="width: 80px">Phương thức trả</th>
            <th style="width: 90px">Xe</th>
            <th style="width: 150px">Chuyến</th>
            <th>Ngày mua</th>
            <th>Tổng tiền</th>
            <th style="width: 15px">Chức năng</th>
        </tr>
    </thead>
    <tbody>

        <c:forEach items="${listTickets}" var="r">
            <tr>
                <td>${r.id}</td>
                <td>${r.userId.name}</td>
                <td>${r.userId.phone}</td>
                <td>${r.seatId.name}</td>
                <td>${r.paymentmethod}</td>
                <td>${r.passengercarId.name}</td>
                <td>${r.tripId.coachname}</td>
                <td><fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${r.createddate}" /></td>
                <td><fmt:formatNumber value="${r.totalprice}" maxFractionDigits="3" type = "number" /></td>
                <td class="text-center">
                    <a href="#"style="color: #7c4c02"
                       title="Sửa"><i class="fas fa-file-export"></i></a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<nav aria-label="Page navigation example" style="float: right">
    <ul class="pagination">
        <c:forEach var="i" begin="0" end="${totalItem}">
            <c:url value="/tickets/list/${i+1}" var="action" />
            <li class="page-item"><a class="page-link" href="${action}"><c:out value="${i+1}"/></a></li>
            </c:forEach>
    </ul>
</nav>
