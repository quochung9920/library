<%-- 
    Document   : menu
    Created on : Aug 11, 2022, 2:39:04 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<div class="col-auto col-md-3 col-xl-2 px-sm-2 px-0 menu">
    <div class="d-flex flex-column align-items-center align-items-sm-start px-3 pt-2 text-white min-vh-100">
        <ul class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start" id="menu">
            <li>
                <c:url value="/admin" var="dashboard" />
                <a href="${dashboard}" class="nav-link px-0 align-middle ">
                    <i class="fa-solid fa-gauge"></i> <span class="ms-1 d-none d-sm-inline">Điều khiển</span></a>
            </li>
            <li>
                <a href="#" aria-expanded="false" data-bs-toggle="collapse" class="nav-link px-0 align-middle"
                   data-bs-target="#info">
                    <i class="fas fa-chart-pie"></i><span class="ms-1 d-none d-sm-inline">Thống kê</span> 
                </a>
                <ul class="collapse collapse-horizontal nav flex-column mb-0" id="info" style="padding-left: 10px">
                    <li><a class="nav-link px-0 text-success" href="<c:url value="/admin/tripstatistics" />">
                            <i class="fas fa-star-half"></i> Mật độ chuyến</a></li>
                    <li><a class="nav-link px-0 text-success" href="<c:url value="/admin/tripsmonthstats" />">
                            <i class="fas fa-star-half"></i> Theo tháng</a></li>
                    <li><a class="nav-link px-0 text-success" href="<c:url value="/admin/tripsquarterstats" />">
                            <i class="fas fa-star-half"></i> Theo quý</a></li>
                    <li><a class="nav-link px-0 text-success" href="<c:url value="/admin/tripsyearstats" />">
                            <i class="fas fa-star-half"></i> Theo năm</a></li>
                </ul>
            </li>
            <li>
                <c:url value="/admin/trips/list" var="trip" />
                <a href="${trip}" class="nav-link px-0 align-middle ">
                    <i class="fas fa-bus-alt"></i> <span class="ms-1 d-none d-sm-inline">Chuyến xe</span></a>
            </li>
            <li>
                <c:url value="/admin/routes/list" var="route" />
                <a href="${route}" class="nav-link px-0 align-middle">
                    <i class="fas fa-route"></i> <span class="ms-1 d-none d-sm-inline">Tuyến xe</span> </a>
            </li>
            <li>
                <c:url value="/admin/drivers/list" var="driver" />
                <a href="${driver}" class="nav-link px-0 align-middle">
                    <i class="fas fa-address-card"></i> <span class="ms-1 d-none d-sm-inline">Tài xế</span></a>
            </li>

            <li>
                <c:url value="/admin/employees/list" var="employee" />
                <a href="${employee}" class="nav-link px-0 align-middle">
                    <i class="fas fa-user-friends"></i> <span class="ms-1 d-none d-sm-inline">Nhân viên</span> </a>
            </li>
            <li>
                <c:url value="/admin/driverdetails/list" var="driverdt" />
                <a href="${driverdt}" class="nav-link px-0 align-middle">
                    <i class="fas fa-user-edit"></i> <span class="ms-1 d-none d-sm-inline">Gán tài xế</span></a>
            </li>
            <li>
                <c:url value="/tickets/list" var="ticket" />
                <a href="${ticket}" class="nav-link px-0 align-middle">
                    <i class="fas fa-ticket"></i> <span class="ms-1 d-none d-sm-inline">Quản lý vé</span></a>
            </li>
        </ul>
        <hr>
    </div>
</div>