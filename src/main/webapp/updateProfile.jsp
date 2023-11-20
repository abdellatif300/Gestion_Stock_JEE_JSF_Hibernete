<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="currentPage" value="Update my profile" />
<c:set var="pageTitle" value="Update my profile" />
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="includes/header.jsp" %>
<div class="container">
<h1>Update my profile</h1>
<br/>
<spring:eval expression="@stDao.getUserByName(sessionScope.loggedInUser)" var="user" />
<form method="post" action="updateInfo">
    <div class="invalid">
        <s:actionerror />
    </div>
    <input type="hidden" name="id" value="${user.getCodeUser()}">
    <input type="hidden" name="name" value="${sessionScope.loggedInUser}">
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label font-weight-bold">UserName</label>
        <input type="text" class="form-control"  name="username" value="${user.getLogin()}"
               id="exampleInputEmail2" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label font-weight-bold">Email address</label>
        <input type="email" class="form-control" name="email" value="${user.getEmail()}"
               id="exampleInputEmail1" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label font-weight-bold">Password</label>
        <input type="password" class="form-control" name="password"
               id="exampleInputPassword1">
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label font-weight-bold">New Password</label>
        <input type="password" class="form-control" name="newPassword"
               id="exampleInputPassword2">
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label  font-weight-bold">Confirm New Password</label>
        <input type="password" class="form-control" name="cnewPassword"
               id="exampleInputPassword3">
    </div>
    <div class="nav-button" style="display: flex;justify-content: flex-end;">
        <button type="submit" class="nav-button-link">Update</button>
    </div>
</form>
</div>

<%@ include file="includes/footer.jsp"%>