<%-- 
    Document   : header
    Created on : Aug 3, 2022, 1:57:21 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-sm">
    <div class="container-fluid">
        <a href="<c:url value="/" />"><img src="<c:url value="/img/logo.png"/>" style="width: 200px; height: 60px;"  ></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item" style="margin-left: 30px">
                    <c:url value="/" var="action" />
                    <a class="nav-link" href="${action}">Trang chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-secondary" href="<c:url value="/admin" />">Quản trị</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-success" href="<c:url value="/tickets/list" />">Quản lý vé</a>
                </li>
                
                <li class="nav-item">
                    <a class="nav-link" href="tel:0222.33.44.55"><i class="fas fa-phone-alt callNumber"></i> 0222.33.44.55</a>
                </li>
            </ul>
            <ul class="navbar-nav me-auto" style="margin-left:250px"> 
                <!--    Khi đăng nhập thất bại hiện ra link login -->
                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <li class="nav-item">
                        <a class="nav-link text-success" href="<c:url value="/login" />">
                            <i class="fa fa-user" aria-hidden="true"></i>  Đăng nhập
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-danger" href="<c:url value="/register" />">
                            <i class="fa-solid fa-user-plus" aria-hidden="true"></i> Đăng ký
                        </a>
                    </li>
                </c:if>
                    
                <!-- Ngược lại thì hiện ra logout và tên -->
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <li class="nav-item">
                        <!--<a href="<c:url value="/"/>" class="nav-link text-info">-->
                        <c:if test="${currentUser.avatar != null}">
                            <!--<img style="width:30px;" src="${currentUser.avatar}" class="rounded-circle" />-->

                            <div class="dropdown pb-2 nav-link text-info ">
                                <a href="#" class="d-flex align-items-center text-black text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                                    <img src="${currentUser.avatar}" width="30" height="30" class="rounded-circle">
                                    <span class="d-none d-sm-inline mx-1">${currentUser.name}</span>
                                </a>
                                <ul class="dropdown-menu text-small shadow">
                                    <li><a class="dropdown-item" href="<c:url value="/user-profile" />">Trang cá nhân</a></li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>
                                    <li><a class="dropdown-item" href="<c:url value="/logout" />">Đăng xuất</a></li>
                                </ul>
                            </div>

                        </c:if>
                        <c:if test="${currentUser.avatar == null}">
                            <i class="fa fa-user" aria-hidden="true"></i>
                        </c:if> 
                       
                    </li>
                    
                </c:if>
            </ul>

        </div>
    </div>
</nav>



