<%-- 
    Document   : routes
    Created on : Aug 7, 2022, 5:27:57 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!---->
<h1 class="text-center text-danger">DANH SÁCH CÁC TUYẾN XE</h1>

<c:url value="/admin/routes/search" var="search" />
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

<c:if test="${listRoutes.size()==0}">
    <p><em>Không có tuyến xe nào có thông tin bạn đang tìm!!!</em></p>
</c:if>

<div class="mailbox-border" style="float: right">
    <div class="float-left">
        <div class="btn btn_1 mrg5R">
            <c:url value="/admin/routes/addroute" var="add" />
            <a style="color: green" title="Thêm" href="${add}"><i class="fa fa-plus"> </i></a>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>

<table class="table table-bordered text-center">
    <thead class="admin-table text-center">
        <tr>
            <th style="width: 50px">Mã tuyến</th>
            <th>Ảnh tuyến</th>
            <th>Tên tuyến</th>
            <th>Điểm đi</th>
            <th>Điểm đến</th>
            <th>Giá tiền</th>
            <th>Giá tăng</th>
            <th colspan="3" style="width: 20px">Chức năng</th>
        </tr>
    </thead>
    <tbody> 
        <c:forEach items="${listRoutes}" var="r">
            <tr>
                <td>${r.id}</td>
                <td><img src="${r.image}" width="50px" alt="${r.routename}"/></td>
                <td>${r.routename}</td>
                <td>${r.startingpoint}</td>
                <td>${r.destination}</td>
                <td><fmt:formatNumber value="${r.price}" maxFractionDigits="3" type = "number" /></td>
                <td><fmt:formatNumber value="${r.specialprice}" maxFractionDigits="3" type = "number" /></td>
                <td>
                    <c:url value="/admin/routes/editroute/${r.id}" var="edit" />
                    <a href="${edit}" style="color: #7c4c02"
                       title="Sửa" style="margin-right: 5px"><i class="fa fa-edit"></i></a>
                </td>
                 <td>
                    <c:url value="/admin/routes/deleteroute/${r.id}" var="delete" />
                    <a href="#" onclick="showMess(${r.id})" style="color: tomato"
                       title="Xóa"><i class="bi bi-trash"></i></a>
   
                </td>
                <td>
                    <c:url value="/admin/routes/editroute/image/${r.id}" var="edit" />
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
            <c:url value="/admin/routes/list/${i+1}" var="action" />
            <li class="page-item"><a class="page-link" href="${action}"><c:out value="${i+1}"/></a></li>
        </c:forEach>
    </ul>
</nav>
<script>
    function showMess(id){
        var option = confirm('Bạn có chắc chắn muốn xóa không?');
        if(option === true){
            window.location.href='/BookingTicketWeb/admin/routes/deleteroute/'+id;
        }
    }
</script>