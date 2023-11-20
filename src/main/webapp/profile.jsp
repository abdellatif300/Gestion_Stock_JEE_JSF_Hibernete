<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="currentPage" value="Profile" />
<c:set var="pageTitle" value="Profile" />
<%@ include file="includes/header.jsp" %>
<div class="profile-wrapper container">
    <h1>My profile</h1>
    <br/>

    <spring:eval expression="@stDao.getUserByName(sessionScope.loggedInUser)" var="user" />
        <div class="mb-5">
            <h4 class="font-weight-bold" style="margin-bottom: -20px">UserName</h4><hr/>
            <h5>${user.getLogin()}</h5>
        </div>


        <div class="mb-5">
            <h4 class="font-weight-bold" style="margin-bottom: -20px">Email address</h4><hr/>
            <h5>${user.getEmail()}</h5>
        </div>

        <div class="nav-button" style="display: flex;justify-content: flex-end;">
            <a class="nav-button-link" href="updateProfile.jsp"><i class="fas fa-tags"></i>Update profile/Password</a>
        </div>
</div>

<%@ include file="includes/footer.jsp"%>