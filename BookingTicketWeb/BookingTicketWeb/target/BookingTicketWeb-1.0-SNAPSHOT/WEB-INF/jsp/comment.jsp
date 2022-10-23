<%-- 
    Document   : comment
    Created on : Aug 13, 2022, 8:37:18 PM
    Author     : dieuh
--%>


<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">

<div>
    <p id="comment"  >BÌNH LUẬN CỦA KHÁCH HÀNG</p>
</div>


<div class="row" style="margin-top: 30px; margin-left: 25%">
    <div class="col-md-8 col-xs-6" style="padding:10px; margin: 10px;">
        <div class="card">
            <img style=" height: 300px;" class=" img1 img-fluid card-header" src="<c:url value="${trip.image}"/>" alt="${trip.coachname}" />                
            <div class="card-body ">
                <h2> <i class="fa-solid fa-bus"> ${trip.routeId.startingpoint} - ${trip.routeId.destination}</i> </h2>
                <hr>                   
                <h5><i class="fa-solid fa-calendar-check"></i> Ngày khởi hành: <fmt:formatDate pattern = "dd/MM/yyyy" value = "${trip.departureday}" /></h5>

                <div style="display: flex; margin-top: 10px; ">
                    <h5><i class="fa-solid fa-hourglass-start"></i>Thời gian đi <fmt:formatDate type = "time" value = "${trip.departuretime}" /> </h5>  
                    <h5 style="margin-left: 150px;"><i class="fa-solid fa-hourglass-end"></i> Thời gian đến <fmt:formatDate type = "time" value = "${trip.arrivaltime}" /></h5>
                </div>                    
            </div>
        </div>
    </div>
</div>



<c:if test="${comments.size() == 0}">
    <p>Không có bình luận</p>
</c:if>



<hr>
<br>
<h1 class=" divcomment comments-title ">Tổng số bình luận: ${commentCounter}</h1>

<div class="be-comment-block"  id="commentArea">
    <div class="be-comment" >
        <c:forEach items="${comments}" var="comment">
            <div class="be-img-comment">	
                <img  src="${comment.customerId.avatar}" class="rounded-circle be-ava-comment" />				
            </div>
            <div class="be-comment-content">

                <span class="be-comment-name">
                    <p>${comment.customerId.name}</p>
                </span>
                <span class="be-comment-time comment-date">
                    <i class="fa-solid fa-clock"></i>
                    ${comment.createddate}
                </span>

                <p class="be-comment-text">
                    ${comment.content}
                </p>
            </div>
        </c:forEach>
    </div> 
    <form class="form-block" onsubmit="addComment(event, ${tripId})">
        <div class="row" style="width:80%; margin-left: 13.5%">
            <div class="col-xs-12">
                <div class="form-group">
                    <textarea class="form-input" id="commentId" placeholder="Bình luận của bạn là..."></textarea>
                </div>
            </div>
            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <input id="sendcomment" onclick="showMess()" type="submit" style="width: 20%; margin-left: 30px;"   value="Gửi bình luận" />    
            </c:if>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <input id="sendcomment" type="submit" style="width: 20%; margin-left: 30px;" value="Gửi bình luận" />                         
            </c:if> 

        </div>
    </form>
</div>

<div>
    <ul class="pagination">
        <c:forEach begin="1" end="${Math.ceil(commentCounter/10)}" var="a">
            <li class="page-item"><a class="page-link" href="<c:url value="/comment/${tripId}" />?page=${a}">${a}</a></li>
            </c:forEach>
    </ul>
</div>

<script>
    window.onload = function () {
        let dates = document.getElementsByClassName("comment-date");
        for (let  i = 0; i < dates.length; i++)
            dates[i].innerText = "Ngày tạo: " + moment(dates[i].innerText).fromNow();
    };
</script>


<script>
    function showMess() {
        alert('Bạn cần phải đăng nhập trước khi bình luận!');
    }
</script>
<script src="<c:url value="/js/comment.js"/>"></script>