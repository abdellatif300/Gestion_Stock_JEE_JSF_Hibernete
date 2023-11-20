<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 5/28/2023
  Time: 2:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="includes/headerVisitor.jsp" %>

<div class="container Signup__">
    <div class="row justify-content-md-center">
        <div class="col-md-6">
            <h2 class="text-center text-dark mt-5">SignUp Form</h2>
            <div class="card my-3">

                <form action="signup" method="POST" class="card-body cardbody-color p-lg-3"  data-aos="fade-down">
                    <div class="text-center">
                        <img src="asset/avatar.png" class="img-fluid profile-image-pic img-thumbnail rounded-circle my-3"
                             width="200px" alt="profile">
                    </div>
                    <div class="invalid">
                        <s:actionerror />
                    </div>
                    <div class="mb-3 input-group">
                        <span class="input-group-text" id="inputGroupPrepend">@</span>
                        <input type="text" class="form-control" id="Username" name="username" aria-describedby="emailHelp"
                               placeholder="UserName" required>
                    </div>
                    <div class="mb-3">
                        <input type="email" name="email" class="form-control" id="email" placeholder="Email" required>
                    </div>
                    <div class="mb-3">
                        <input type="password" name="password" class="form-control" id="password" placeholder="Password" required>
                    </div>
                    <div class="mb-3">
                        <input type="password" name="cPassword" class="form-control" id="cPassword" placeholder="Confirm Password"
                               required>
                    </div>
                    <div class="invalid-feedback">
                        Please choose a username.
                    </div>
                    <div class="text-center">
                        <button type="submit" class="btn btn-color px-5 mb-3 w-100">Sign Up</button>
                    </div>
                    <div id="emailHelp" class="form-text text-center mb-5 text-dark">Already
                        Registered? <a href="index.jsp" class="text-dark fw-bold"> Login here!</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%@ include file="includes/footer.jsp" %>