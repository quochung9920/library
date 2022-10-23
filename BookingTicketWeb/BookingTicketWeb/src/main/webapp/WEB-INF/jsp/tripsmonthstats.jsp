<%-- 
    Document   : tripsmonthstats
    Created on : Aug 20, 2022, 12:58:54 PM
    Author     : dieuh
--%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h2 class="text-center text-danger">THỐNG KÊ THEO THÁNG </h2>

<section class="search-sec">
    <div class="container">
        <form action="#" method="post" novalidate="novalidate">
            <div style="display: flex">                                        
                <div class="row" style="width: 100%; display: flex;">   
                    <div  style="width: 48%;">
                        <label>Từ thời điểm</label>
                        <input type="date" name="fromDate" class="form-control mb-3" />
                    </div>
                    <div  style="margin-left: 10px; width: 48%;">
                        <label>Đến thời điểm</label>
                        <input type="date" name="toDate" class="form-control" />
                    </div> 
                </div>
                <div  style="margin-left: 10px; margin-top:12px; ">
                    <input type="submit" value="Thống kê" class="btn btn-success mt-3"/>
                </div>
            </div>
        </form>
    </div>
</section>

<div class="row">
     <h4 class="text-center text-secondary alert-success" style="width: 40%; margin-left: 30%;"> Bảng số liệu thống kê </h4>
    
        <table class="table" >
        <tr>
            <th>Thời gian </th>
            <th>Doanh thu </th>
        </tr>
        <c:forEach items="${tripMonthStats}" var="m">
            <tr>
                <td>${m[0]}/${m[1]}</td> 
                <td>${m[2]} VNĐ</td>
            </tr>
        </c:forEach>
    </table>
    
     <h4 class="text-center text-secondary alert-success" style="width: 40%; margin-left: 30%;">Thống kê theo dạng biểu đồ </h4>
    <div>
        <canvas id="myTripsMonthTurnoverTatisticsChart"></canvas>
    </div>
    <script>
        let tripMonthTurnoverLabels = [], tripMonthTurnoverInfo = []

        <c:forEach items="${tripMonthStats}" var="m">
        tripMonthTurnoverLabels.push('${m[0]}/${m[1]}')
            tripMonthTurnoverInfo.push(${m[2]})
        </c:forEach>
    </script>
</div>
<script>
    window.onload = function () {
        turnoverTatisticsByTripMonthChart("myTripsMonthTurnoverTatisticsChart", tripMonthTurnoverLabels, tripMonthTurnoverInfo);
    }
</script>