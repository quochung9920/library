<%-- 
    Document   : admin
    Created on : Aug 7, 2022, 2:32:00 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2 class="text-center text-secondary">BẢNG ĐIỀU KHIỂN</h2>
<div class="container-fluid" style="display: flex">
    <div class="col" style="margin-right: 30px">
        <div class="card row-sm-6 mb-3 box">
            <div class="card-header"><button class="btn btn-success">Vé xé</button>
                <i class="fas fa-ticket iconAdmin"></i></div>
            <div class="card-body text-secondary">
                <pre>Tổng số lượng vé</pre>
                <p class="numberInfo">${totalTicket}</p></div>
            <label class="card-footer">
                <c:url value="/tickets/list" var="ticket" />
                <a class='pink-text' href='${ticket}'><b>Xem chi tiết</b></a>
            </label>
        </div>
        <div class="card row-sm-6 mb-3 box">
            <div class="card-header"><button class="btn btn-primary">Khách hàng</button>
            <i class="fas fa-users iconAdmin"></i></div>
            <div class="card-body text-secondary">
                <pre>Tổng số lượng khách</pre>
                <p class="numberInfo">${totalCustomer}</p></div>
            <label class="card-footer" style="float: right;">
                <c:url value="#" var="action" />
                <a class='pink-text' href='${action}'><b>Xem chi tiết</b></a>
            </label>
        </div>
        <div class="card row-sm-6 mb-3 box">
            <div class="card-header"><button class="btn btn-warning">Doanh thu</button>
            <i class="fas fa-money-bill iconAdmin"></i></div>
           <div class="card-body text-secondary">
                <pre>Tổng doanh thu</pre>
                <p class="numberInfo"><fmt:formatNumber value="${totalAmount}" maxFractionDigits="3" type = "number" /> VNĐ</p></div>
            <label class="card-footer" style="float: right;">
                <c:url value="#" var="action" />
                <a class='pink-text' href='${action}'><b>Xem chi tiết</b></a>
            </label>
        </div>
    </div>

    <div class="col" style="margin-right: 30px">
        <div class="card row-sm-6 mb-3 box1">
            <div class="card-header"><button class="btn btn-danger">Tuyến xe</button>
            <i class="fas fa-route iconAdmin"></i></div>
           <div class="card-body text-secondary">
                <pre>Tổng số tuyến</pre>
                <p class="numberInfo">${totalRoute}</p></div>
            <label class="card-footer" style="float: right;">
                <c:url value="/admin/routes/list" var="action" />
                <a class='pink-text' href='${action}'><b>Xem chi tiết</b></a>
            </label>
        </div>
        <div class="card row-sm-6 mb-3 box1">
            <div class="card-header"><button class="btn btn-dark">Tài xế</button>
            <i class="fas fa-address-card iconAdmin"></i></div>
            <div class="card-body text-secondary">
                <pre>Tổng số tài xế</pre>
                <p class="numberInfo">${totalDriver}</p></div>
            <label class="card-footer" style="float: right;">
                <c:url value="/admin/drivers/list" var="action" />
                <a class='pink-text' href='${action}'><b>Xem chi tiết</b></a>
            </label>
        </div>
    </div>

    <div class="col" style="margin-right: 30px">
        <div class="card row-sm-6 mb-3 box2">
            <div class="card-header"><button class="btn btn-info">Chuyến xe</button>
            <i class="fas fa-bus iconAdmin"></i></div>
            <div class="card-body text-secondary">
                <pre>Tổng số chuyến xe</pre>
                <p class="numberInfo">${totalTrip}</p></div>
            <label class="card-footer" style="float: right;">
                <c:url value="/admin/trips/list" var="action" />
                <a class='pink-text' href='${action}'><b>Xem chi tiết</b></a>
            </label>
        </div>
        <div class="card row-sm-6 mb-3 box2">
            <div class="card-header"><button class="btn btn-secondary">Nhân viên</button>
            <i class="fas fa-user-shield iconAdmin"></i></div>
            <div class="card-body text-secondary">
                <pre>Tổng số nhân viên</pre>
                <p class="numberInfo">${totalEmployee}</p></div>
            <label class="card-footer" style="float: right;">
                <c:url value="/admin/employees/list" var="action" />
                <a class='pink-text' href='${action}'><b>Xem chi tiết</b></a>
            </label>
        </div>
    </div>

    <div class="col">
        <div class="card row-sm-6 mb-3 box3">
            <div class="card-header"><button class="btn btn-warning">Xe</button>
            <i class="fas fa-car-side iconAdmin"></i></div>
            <div class="card-body text-secondary">
                <pre>Tổng số xe</pre>
                <p class="numberInfo">${totalPassenger}</p></div>
            <label class="card-footer" style="float: right;">
                <c:url value="#" var="action" />
                <a class='pink-text' href='${action}'><b>Xem chi tiết</b></a>
            </label>
        </div>
        <div class="card row-sm-6 mb-3 box3">
            <div class="card-header"><button class="btn btn-success">Admin</button>
            <i class="fas fa-user-lock iconAdmin"></i></div>
            <div class="card-body text-secondary">
                <pre>Tổng số admin</pre>
                <p class="numberInfo">${totalAdmin}</p></div>
            <label class="card-footer" style="float: right;">
                <c:url value="#" var="action" />
                <a class='pink-text' href='${action}'><b>Xem chi tiết</b></a>
            </label>
        </div>
    </div>  

</div>