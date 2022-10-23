<%-- 
    Document   : edit_image_trip
    Created on : Aug 29, 2022, 10:28:53 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2 class="text-center text-secondary">THAY ĐỔI ẢNH CHUYẾN XE</h2>
<div id="error-message" class="text-center alert-danger"></div>
<form:form id="imageTrip" modelAttribute="trip" enctype="multipart/form-data" acceptCharset="UTF-8">
    <div class="mb-3">
        <label class="form-label">Mã chuyến</label>
        <form:input type="text" class="form-control" path="id" readonly="true"/>
    </div>
    <div class="mb-3">
        <label class="form-label">Ảnh</label>
        <form:input type="text" class="form-control" path="image" id="display-image" readonly="true"/>

        <label for="firstimg"><i class="btn btn-secondary" style = "margin: 5px 0 5px 0; cursor: pointer;">Chọn ảnh </i></label>
        <input type = "file" id = "firstimg" hidden="hidden" onchange="getImage()"/>
    </div>
    <div>
        <input class="btn btn-warning" type="submit" onclick="updateImageTrip()" value="Sửa"/>     
        <a href="<c:url value="/admin/trips/list" />" class="btn btn-info" type="button" data-toggle="tooltip" 
           data-placement="top" title="Hủy"><i class="fas fa-undo"></i></a> 
    </div>
</form:form>
<script type="text/javascript">
    function getImage()
    {
        const fileChoose = document.getElementById('firstimg');
        document.getElementById('display-image').setAttribute('value',
                fileChoose.value.match(/[\/\\]([\w\d\s\.\-\(\)]+)$/)[1]);
    }
</script>
<script src="<c:url value="/js/trip.js"/>"></script>
