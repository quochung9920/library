<%-- 
    Document   : userdetail
    Created on : Aug 31, 2022, 1:25:19 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">
    <div class="main-body">
        <div class="row gutters-sm">
            <div class="col-md-4 mb-3 mb-3u">
                <div class="card cardu">
                    <div class="card-body cardu-body">
                        <div class="d-flex flex-column align-items-center">
                            <img src="${user.avatar}" alt="${user.name}" class="rounded-circle" width="150">
                            <div class="mt-3">
                                <h4 class=" text-center">${user.username}</h4>
                                <button class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#myAvartar">Đổi avatar</button>
                                <div class="modal" id="myAvartar">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h4 class="modal-title text-secondary">THAY ĐỔI AVARTAR</h4>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal">&times;</button>
                                            </div>
                                            <div class="modal-body">
                                                <div id="error-message" class="text-center alert-danger mb-3"></div>
                                                <form id="formImageAvatar">
                                                    <div class="mb-3">
                                                        <input type="text" class="form-control" value="${user.avatar}" id="display-image" readonly="true"/>

                                                        <label for="firstimg"><i class="btn btn-danger" style = "margin: 5px 0 5px 0; cursor: pointer;">Chọn ảnh</i></label>
                                                        <input type = "file" id = "firstimg" hidden="hidden" onchange="getImage()"/>
                                                    </div>
                                                </form>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-success" onclick="updateAvatar(${user.id})">Thay đổi</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <button class="btn btn-outline-success" data-bs-toggle="modal" data-bs-target="#myPassword">Đổi mật khẩu</button>
                                <!-- The Modal -->
                                <div class="modal" id="myPassword">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h4 class="modal-title text-secondary">THAY ĐỔI THÔNG TIN ĐĂNG NHẬP</h4>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal">&times;</button>
                                            </div>
                                            <div class="modal-body">
                                                <div id="error-message" class="text-center alert-danger"></div>
                                                <form id="formUPassword">
                                                    <div class="form-group mb-3">
                                                        <label for="name">Tên đăng nhập: </label>
                                                        <input type="text" id="username" name="username" class="form-control" value="${user.username}"/>
                                                    </div>
<!--                                                    <div class="form-group mb-3">
                                                        <label for="password" class="form-label">Mật khẩu hiện tại</label>
                                                        <input type="password" required name="passwordO" id="passwordO" class="form-control" value="${pass}""/>
                                                        <div id="invalid-feedback-password" class="invalid-feedback"></div>
                                                    </div>-->
                                                    <div class="form-group mb-3">
                                                        <label for="password" class="form-label">Mật khẩu mới</label>
                                                        <input type="password" required name="passwordN" id="passwordN" class="form-control" placeholder="Nhập mật khẩu mới..."/>
                                                        <div id="invalid-feedback-password" class="invalid-feedback"></div>
                                                    </div>
                                                    <div class="form-group mb-3">
                                                        <label for="confirmPassword">Xác nhận mật khẩu</label>
                                                        <input type="password" required name="confirmPassword" 
                                                               id="confirmPassword" class="form-control" 
                                                               placeholder="Nhập mật khẩu xác nhận..."
                                                               data-bs-toggle="tooltip" data-bs-placement="right" title="Bạn phải nhập mật khẩu xác nhận!"/>
                                                        <div class="invalid-feedback" id="invalid-feedback-cfpassword"></div>
                                                    </div>
                                                    <input type="checkbox" onclick="myFunction()"> Hiện mật khẩu
                                                </form>
                                            </div>

                                            <!-- Modal footer -->
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-success" onclick="updateUPass(${user.id})">Thay đổi</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-8">
                <div class="card cardu mb-3 mb-3u">
                    <div class="card-body cardu-body">
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Tên đầy đủ</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                ${user.name}
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Email</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                ${user.email}
                                <c:if test="${user.email==null}">
                                    Không có thông tin!
                                </c:if>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Số điện thoại</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                ${user.phone}
                                <c:if test="${user.phone==null}">
                                    Không có thông tin!
                                </c:if>
                            </div>
                        </div>
                        <hr>
                        <c:if test="${user.userrole!='Customer'}"> 
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Ngày sinh</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    ${user.employee.dateofbirth}
                                    ${user.driver.dateofbirth}
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">CMND/CCCD</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    ${user.employee.identitycard}
                                    ${user.driver.identitycard}
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Địa chỉ</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    ${user.employee.address}
                                    ${user.driver.address}
                                </div>
                            </div>
                            <hr>
                        </c:if>
                        <c:if test="${user.userrole=='Employee'||user.userrole=='Admin'}">  
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Giới tính</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    ${user.employee.gender}
                                </div>
                            </div>
                            <hr>
                        </c:if>

                        <c:if test="${user.userrole=='Driver'}">  
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Hạng bằng lái</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    ${user.driver.license}
                                </div>
                            </div>
                            <hr>
                        </c:if>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Vai trò</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                ${user.userrole}
                            </div>
                        </div>
                        <hr>     
                        <c:if test="${user.userrole=='Employee'||user.userrole=='Driver'}">
                            <div class="row">
                                <div class="col-sm-12">
                                    <button type="button" class="btn btn-warning" onclick="showMess()">Thay đổi</button>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${user.userrole=='Admin'}">
                            <div class="row">
                                <div class="col-sm-12">
                                    <a class="btn btn-warning" href="<c:url value="/admin/employees/list" />">Thay đổi</a>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${user.userrole=='Customer'}">
                            <div class="row">
                                <div class="col-sm-12">
                                    <!-- Button to Open the Modal -->
                                    <button type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#myModal">
                                        Thay đổi
                                    </button>
                                    <!-- The Modal -->
                                    <div class="modal" id="myModal">
                                        <div class="modal-dialog">
                                            <div class="modal-content">

                                                <!-- Modal Header -->
                                                <div class="modal-header">
                                                    <h4 class="modal-title text-secondary">THAY ĐỔI THÔNG TIN</h4>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal">&times;</button>
                                                </div>

                                                <!-- Modal body -->
                                                <div class="modal-body">
                                                    <div id="error-message" class="text-center alert-danger"></div>
                                                    <form id="formChangeInfo">
                                                        <div class="form-group mb-3">
                                                            <label for="name">Tên đầy đủ: </label>
                                                            <input type="text" id="name" name="name" class="form-control" value="${user.name}"/>
                                                        </div>
                                                        <div class="form-group mb-3">
                                                            <label for="email">Email: </label>
                                                            <input type="email" id="email" name="email" class="form-control" value="${user.email}"/>
                                                        </div>
                                                        <div class="form-group mb-3">
                                                            <label for="phone">Số điện thoại: </label>
                                                            <input type="number" id="phone" name="phone" class="form-control" value="${user.phone}"/>
                                                        </div>
                                                    </form>
                                                </div>

                                                <!-- Modal footer -->
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-success" onclick="updateUProfile(${user.id})">Thay đổi</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<c:url value="/js/user.js"/>"></script>
<script type="text/javascript">
    function getImage()
    {
        const fileChoose = document.getElementById('firstimg');
        document.getElementById('display-image').setAttribute('value',
                fileChoose.value.match(/[\/\\]([\w\d\s\.\-\(\)]+)$/)[1]);
    }
    function showMess() {
        alert('Liên hệ ADMIN nếu bạn cần thay đổi thông tin');
    }
    function myFunction() {
        var x = document.getElementById("passwordN");
        var z = document.getElementById("confirmPassword");
        if (x.type === "password"||z.type === "password") {
          x.type = "text";z.type = "text"; 
        } else {
          x.type = "password";z.type = "password";
        }
}
</script>