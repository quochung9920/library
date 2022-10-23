<%-- 
    Document   : reservation
    Created on : Aug 22, 2022, 11:02:55 AM
    Author     : Admin
--%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="containerbb container-fluid">
    <div class="row d-flex justify-content-center align-items-center">
        <div class="col-md-6">
            <form id="regForm"  style="padding: 0">
                <h1 id="register" class="text-success" style="font-weight: 700;">ĐẶT VÉ</h1>
                <div class="all-steps mt-0" id="all-steps">
                    <span class="step" style="background-color: black"></span> 
                    <span class="step"></span> 
                    <span class="step"></span> 
                    <span class="step"></span> 
                </div>
                <h3 class="text-center text-info mb-4" style="font-family: ui-rounded;">Chọn ghế</h3>
                <div class="row chooseSeatInfo">
                    <div>  
                        <div class="row borderArround">
                            <div class="col-sm-6 text-center text-secondary"><p class="mb-0" style="font-family: ui-monospace;">Tầng dưới <i class="fas fa-download"></i></p></div>
                            <div class="col-sm-6 text-center text-secondary"><p class="mb-0" style="font-family: ui-monospace;"><i class="fas fa-upload"></i> Tầng trên</p></div>
                        </div>
                    </div>
                    <div style="display: flex" class="mt-3">
                        <div class="col-sm-6" style="margin-right: 18px">
                            <div class="row">
                                <c:forEach items="${listSeatA}" var="seat" begin="0" end="0">
                                    <c:choose>
                                        <c:when test="${seat.active eq 1}">
                                            <div class="col-sm-8 mb-2"><button type="button" disabled name="seats" class="disableBtn">${seat.name}</button></div> 
                                            </c:when>
                                            <c:otherwise>
                                            <div class="col-sm-8 mb-2 seats"><button class="activeBtn" type="button" id="seat-${seat.id}" onclick="addToPay(${seat.id}, '${seat.name}', ${price}, ${pasCar.id}, ${tripId})">${seat.name}</button></div>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                    <c:forEach items="${listSeatA}" var="seat" begin="1" end="1">
                                        <c:choose>
                                            <c:when test="${seat.active eq 1}">
                                            <div class="col-sm-1 mb-2"><button class="disableBtn" type="button" disabled name="seats">${seat.name}</button></div>
                                            </c:when>
                                            <c:otherwise>
                                            <div class="col-sm-1 mb-2 seats"><button class="activeBtn" type="button" id="seat-${seat.id}" onclick="addToPay(${seat.id}, '${seat.name}', ${price}, ${pasCar.id}, ${tripId})">${seat.name}</button></div>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                            </div>
                            <div class="row">
                                <c:forEach items="${listSeatA}" var="seat" begin="2" end="4">
                                    <c:choose>
                                        <c:when test="${seat.active eq 1}">
                                            <div class="col mb-2"><button class="disableBtn" type="button" disabled name="seats">${seat.name}</button></div>
                                            </c:when>
                                            <c:otherwise>
                                            <div class="col mb-2"><button class="activeBtn" type="button" id="seat-${seat.id}" onclick="addToPay(${seat.id}, '${seat.name}', ${price}, ${pasCar.id}, ${tripId})">${seat.name}</button></div>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                            </div>
                            <div class="row">
                                <c:forEach items="${listSeatA}" var="seat" begin="5" end="7">
                                    <c:choose>
                                        <c:when test="${seat.active eq 1}">
                                            <div class="col mb-2"><button class="disableBtn" type="button" name="seats" disabled>${seat.name}</button></div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="col mb-2"><button class="activeBtn" type="button" id="seat-${seat.id}" onclick="addToPay(${seat.id}, '${seat.name}', ${price}, ${pasCar.id}, ${tripId})">${seat.name}</button></div>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                            </div>
                            <div class="row">
                                <c:forEach items="${listSeatA}" var="seat" begin="8" end="10">
                                    <c:choose>
                                        <c:when test="${seat.active eq 1}">
                                            <div class="col mb-2"><button class="disableBtn" type="button" name="seats" disabled">${seat.name}</button></div>
                                            </c:when>
                                            <c:otherwise>
                                            <div class="col mb-2"><button class="activeBtn" type="button" id="seat-${seat.id}" onclick="addToPay(${seat.id}, '${seat.name}', ${price}, ${pasCar.id}, ${tripId})">${seat.name}</button></div>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                            </div>
                            <div class="row">
                                <c:forEach items="${listSeatA}" var="seat" begin="11" end="13">
                                    <c:choose>
                                        <c:when test="${seat.active eq 1}">
                                            <div class="col mb-2"><button class="disableBtn" type="button" name="seats" disabled>${seat.name}</button></div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="col mb-2"><button class="activeBtn" type="button" id="seat-${seat.id}" onclick="addToPay(${seat.id}, '${seat.name}', ${price}, ${pasCar.id}, ${tripId})">${seat.name}</button></div>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                            </div>
                            <div class="row">
                                <c:forEach items="${listSeatA}" var="seat" begin="14">
                                    <c:choose>
                                        <c:when test="${seat.active eq 1}">
                                            <div class="col mb-2"><button class="disableBtn" type="button" name="seats" disabled>${seat.name}</button></div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="col mb-2"><button class="activeBtn" type="button" id="seat-${seat.id}" onclick="addToPay(${seat.id}, '${seat.name}', ${price}, ${pasCar.id}, ${tripId})">${seat.name}</button></div>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                            </div>
                        </div>

                        <div class="col-sm-6">
                            <div class="row">
                                <c:forEach items="${listSeatB}" var="seat" begin="0" end="0">
                                    <c:choose>
                                        <c:when test="${seat.active eq 1}">
                                            <div class="col-sm-8 mb-2"><button class="disableBtn" type="button" name="seats" disabled>${seat.name}</button></div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="col-sm-8 mb-2"><button class="activeBtn" type="button" id="seat-${seat.id}" onclick="addToPay(${seat.id}, '${seat.name}', ${price}, ${pasCar.id}, ${tripId})">${seat.name}</button></div>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                    <c:forEach items="${listSeatB}" var="seat" begin="1" end="1">
                                        <c:choose>
                                            <c:when test="${seat.active eq 1}">
                                            <div class="col-sm-1 mb-2"><button class="disableBtn" type="button" name="seats" disabled>${seat.name}</button></div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="col-sm-1 mb-2"><button class="activeBtn" type="button" id="seat-${seat.id}" onclick="addToPay(${seat.id}, '${seat.name}', ${price}, ${pasCar.id}, ${tripId})">${seat.name}</button></div>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                            </div>
                            <div class="row">
                                <c:forEach items="${listSeatB}" var="seat" begin="2" end="4">
                                    <c:choose>
                                        <c:when test="${seat.active eq 1}">
                                            <div class="col mb-2"><button class="disableBtn" type="button" name="seats" disabled>${seat.name}</button></div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="col mb-2"><button class="activeBtn" type="button" id="seat-${seat.id}" onclick="addToPay(${seat.id}, '${seat.name}', ${price}, ${pasCar.id}, ${tripId})">${seat.name}</button></div>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                            </div>
                            <div class="row">
                                <c:forEach items="${listSeatB}" var="seat" begin="5" end="7">
                                    <c:choose>
                                        <c:when test="${seat.active eq 1}">
                                            <div class="col mb-2"><button class="disableBtn" type="button" name="seats" disabled>${seat.name}</button></div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="col mb-2"><button class="activeBtn" type="button" id="seat-${seat.id}" onclick="addToPay(${seat.id}, '${seat.name}', ${price}, ${pasCar.id}, ${tripId})">${seat.name}</button></div>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                            </div>
                            <div class="row">
                                <c:forEach items="${listSeatB}" var="seat" begin="8" end="10">
                                    <c:choose>
                                        <c:when test="${seat.active eq 1}">
                                            <div class="col mb-2"><button class="disableBtn" type="button" name="seats" disabled>${seat.name}</button></div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="col mb-2"><button class="activeBtn" type="button" id="seat-${seat.id}" onclick="addToPay(${seat.id}, '${seat.name}', ${price}, ${pasCar.id}, ${tripId})">${seat.name}</button></div>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                            </div>
                            <div class="row">
                                <c:forEach items="${listSeatB}" var="seat" begin="11" end="13">
                                    <c:choose>
                                        <c:when test="${seat.active eq 1}">
                                            <div class="col mb-2"><button class="disableBtn" type="button" name="seats" disabled>${seat.name}</button></div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="col mb-2"><button class="activeBtn" type="button" id="seat-${seat.id}" onclick="addToPay(${seat.id}, '${seat.name}', ${price}, ${pasCar.id}, ${tripId})">${seat.name}</button></div>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                            </div>
                            <div class="row">
                                <c:forEach items="${listSeatB}" var="seat" begin="14">
                                    <c:choose>
                                        <c:when test="${seat.active eq 1}">
                                            <div class="col mb-2"><button class="disableBtn" type="button" name="seats" disabled>${seat.name}</button></div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="col mb-2"><button class="activeBtn" type="button" id="seat-${seat.id}" onclick="addToPay(${seat.id}, '${seat.name}', ${price}, ${pasCar.id}, ${tripId})" name="seats" >${seat.name}</button></div>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                            </div>
                        </div>
                    </div>
                    <div class="seatStatus">
                        <div class="status-item">
                            <div class="textActive"></div>
                            <div class="textSeatInfo">Ghế trống</div>
                        </div>
                        <div class="status-item">
                            <div class="textDisable"></div>
                            <div class="textSeatInfo">Đã đặt</div>
                        </div>
                    </div>
                    <div>
                        <p class="formatP" style="font-weight: bold;">Số lượng vé chọn: <span id="count" class="text-info">${counter}</span></p>
                    </div>
                </div>

                        <div style="overflow:auto;" id="nextprevious">
                    <div style="float:right;"> 
                        <a type="button" id="nextBtn" class="button btn btn-success" href="<c:url value="/reservation/${tripId}/confirm-seat"/>"> Tiếp tục</a> 
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="<c:url value="/js/reservation.js"/>"></script>