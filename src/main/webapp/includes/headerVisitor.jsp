<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:if test="${empty currentPage}">
  <c:set var="currentPage" value="" />
</c:if>
<c:if test="${empty pageTitle}">
  <c:set var="pageTitle" value="" />
</c:if>


<c:set var="loggedInUser" value="${sessionScope.loggedInUser}" />

<c:if test="${!empty sessionScope.loggedInUser}">
  <c:redirect url="index.jsp" />
</c:if>

<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta charset="UTF-8">
  <meta http-equiv="Pragma" content="no-cache">
  <meta http-equiv="Expires" content="0">
  <meta http-equiv="Cache-Control" content="public, max-age=86400">
  <title>${pageTitle} - Gestion de vente</title>
  <link rel="stylesheet" href="./asset/bootstrap/css/bootstrap.min.css?version=1.0">
  <link rel="stylesheet" href="./asset/fontawesome/css/all.min.css?version=1.0">
  <link href="./asset/aos-master/aos.css?version=1.0" rel="stylesheet">
  <link rel="stylesheet" href="./asset/NavBar.css?version=1.0">
  <link rel="stylesheet" href="./asset/index.css?version=1.0">

</head>
<body>


<header class="header-mainbg">
  <nav class="navbar navbar-expand-custom">
    <a class="navbar-brand navbar-logo" href="#">Ray-Run</a>
    <button class="navbar-toggler" type="button" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <i class="fas fa-bars text-white"></i>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item ${fn:containsIgnoreCase(currentPage, 'Home')?"active":""}">
          <a class="nav-link" href="index.jsp"><i class="fas fa-home"></i>Home</a>
        </li>
        <div class="list-buttons">
          <div class="nav-button">
            <a class="nav-button-link" href="login.jsp">Login</a>
          </div>
          <div class="nav-button main">
            <a class="nav-button-link" href="signup.jsp">Sign Up</a>
          </div>
          <!-- <div class="nav-button main">
              <a class="nav-button-link" href="javascript:void(0);"><i class="fas fa-sign-out-alt"></i>Logout</a>
          </div> -->
        </div>
      </ul>
    </div>
  </nav>

</header>
