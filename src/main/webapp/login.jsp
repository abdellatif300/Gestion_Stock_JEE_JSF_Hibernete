<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--HERE IS THE PARAMS TO USE IN HEADER--%>
<c:set var="currentPage" value="Login" />
<c:set var="pageTitle" value="Login" />

<%@ include file="includes/headerVisitor.jsp" %>

<div class="container login__">
    <div class="row justify-content-md-center">
        <div class="col-md-6">
            <h2 class="text-center text-dark mt-5">Login Form</h2>
            <div class="card my-3">
                <form action="login" method="POST" class="card-body cardbody-color p-lg-3" data-aos="fade-down" >
                    <div class="text-center">
                        <img src="asset/avatar.png" class="img-fluid profile-image-pic img-thumbnail rounded-circle my-3"
                             width="200px" alt="profile">
                    </div>
                    <div class="invalid">
                        <s:actionerror />
                    </div>
                    <div class="mb-3">
                        <input type="text" class="form-control" id="Username" name="username" aria-describedby="emailHelp"
                               placeholder="User Name">
                    </div>
                    <div class="mb-3">
                        <input type="password" name="password" class="form-control" id="password" placeholder="password">
                    </div>
                    <div class="text-center"><button type="submit" class="btn btn-color px-5 mb-3 w-100">Login</button></div>
                    <div id="emailHelp" class="form-text text-center mb-5 text-dark">Not
                        Registered? <a href="signup.jsp" class="text-dark fw-bold"> Create an
                            Account</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<%@ include file="includes/footer.jsp" %>