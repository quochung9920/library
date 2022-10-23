<%-- 
    Document   : confirmseat
    Created on : Sep 2, 2022, 10:22:17 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="containerbb container-fluid">
    <div class="row d-flex justify-content-center align-items-center">
        <div class="col-md-6">
            <form id="regForm"  style="padding: 0">
                <h1 id="register" class="text-success" style="font-weight: 700;">ĐẶT VÉ</h1>
                <div class="all-steps mt-0" id="all-steps">
                    <span class="step" style="background-color: green"></span> 
                    <span class="step" style="background-color: black"></span> 
                    <span class="step"></span> 
                    <span class="step"></span> 
                </div>
                <c:if test="${seat==null}">
                    <h3 class="text-center text-info mb-4" style="font-family: ui-rounded;">Xác nhận ghế đặt</h3>
                    <p class="text-danger formatP"><i>Không có ghế nào được đặt!</i></p>

                </c:if>

                <c:if test="${seat!=null}">
                    <h3 class="text-center text-info mb-4" style="font-family: ui-rounded;">Xác nhận ghế đặt</h3>
                    <div class="container-fluid chooseSeatInfo">
                        <table class="table">
                            <tr>
                                <th class="formatP">Số thứ tự</th>
                                <th class="formatP">Vị trí ngồi</th>
                                <th class="formatP">Giá vé đơn</th>
                                <th class="formatP">Xóa</th>
                            </tr>
                            <c:forEach var="c" items="${seat}">
                                <tr id="s-${c.id}">
                                    <td class="formatP">${c.id}</td>
                                    <td class="formatP">${c.name}</td>
                                    <td class="formatP">${c.price}</td>
                                    <td class="formatP">
                                        <a href="javascrip:;" style="color: tomato" onclick="deleteSeat(${c.id})" 
                                           title="Xóa"><i class="fa-solid fa-trash-can"></i></a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                        <div style="display: flex">
                            <div style="margin-right: 150px">
                                <p class="formatP" style="font-weight: bold;">Tổng số lượng vé: <span id="count" class="text-info">${counter}</span></p>
                            </div>
                            <div>
                                <strong class="text-danger formatP" style="float: right">Tổng tiền:
                                    <span id="amount"><fmt:formatNumber value="${seatStats.amount}" maxFractionDigits="3" type = "number" /></span> VNĐ</strong>
                            </div>
                        </div>
                        <!--<div style="float: right"><button class="btn btn-warning" onclick="pay()">Thanh toán</button></div>-->

                    </div>
                </c:if>
                <div style="overflow:auto;" id="nextprevious">
                    <div style="float:right;"> 
                        <a type="button" id="prevBtn" class="button btn btn-secondary" href="<c:url value="/reservation/${tripId}"/>">Quay lại</a> 
                        <a type="button" id="nextBtn" class="button btn btn-success"
                           href="<c:url value="/reservation/${tripId}/confirm-seat/user-information"/>"> Tiếp tục</a> 
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="<c:url value="/js/reservation.js"/>"></script>

