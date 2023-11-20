<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="currentPage" value="Products" />
<c:set var="pageTitle" value="Products" />
<%@ include file="includes/header.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="container">
  <h1>All articles</h1>
  <br/>
  <div class="filterOptions">
    <div class="row">
      <div class="searchbar">
        <label for="myInput">
          <i class="fas fa-search"></i>
        </label>
        <input id="myInput" type="text" placeholder="Search..">
      </div>
    </div>
    <div class="row list-buttons">
      <div id="allCategories" class="active btn filterOption">All</div>
      <div id="sunglassesCategory" class="btn filterOption">SunGlasses</div>
      <div id="eyeglassesCategory" class="btn filterOption">EyeGlasses</div>
    </div>
  </div>
  <main class="grid products">
  <spring:eval expression="@stDao.getAllArticl()" var="myList" />
  <c:forEach var="item" items="${myList}">
    <article data-aos="fade-up">
      <div class="image">
        <div class="navbar-logo">Ray-Run</div>
        <img src="${item.getImage()}" alt="Sample photo">
      </div>
      <div class="desc">
        <div class="upper-desc">
        <h3>${item.getNomArt()}</h3>
         <form method="post" action="wearGlasses">
           <input type="hidden" name="idArt" value="${item.getCodeArt()}">
           <button type="submit" class="wearGlasses-btn"><i class="far fa-eye m-0"></i></button>
         </form>
        </div>


        <div class="bottom-desc" data-codeart="${item.getCodeArt()}">
          <div class="category">
            ${item.getCategory()}
          </div>

          <a class="btn btn-primary btn-block addCart" href="addToCartAction.action?codeArt=${item.getCodeArt()}" onclick="insertItem({CodeArt:${item.getCodeArt()},Quantity:1})">
            Add to cart <i class="fas fa-cart-plus"></i>
          </a>
          <a class="btn btn-secondary btn-block viewCart" href="cart.jsp">
            View in cart <i class="fa fa-arrow-right"></i>
          </a>
          <div class="price d-flex justify-content-center">
            <c:set var="splitNumber" value="${fn:split(item.getPrixArt(), '.')}"/>
            <c:set var="addedZeros" value='${(fn:length(splitNumber[1]) == 0) ? "00" : ""}' />
            <c:set var="addedZeros" value='${(fn:length(splitNumber[1]) == 1) ? "0" : ""}' />

            <span class="left" style="font-size: xx-large">${splitNumber[0]}</span>
            <span class="right d-flex flex-column justify-content-center" style="line-height: 15px;">
              <span class="currency">$</span>
              <span class="after">${splitNumber[1]}${addedZeros}</span>
            </span>
          </div>
        </div>
      </div>
    </article>
  </c:forEach>
  <input id="myCategory" type="text" value="${category}" hidden disabled>
  <div id="NotFound" style="display: none;">
    <h2>
      NOT FOUND
    </h2>
  </div>
  </main>





  <%--<table class="table">
    <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">name</th>
      <th scope="col">prix</th>
      <th scope="col">quantite</th>
      <th>Action</th>
    </tr>

    </thead>
    <tbody>
    <spring:eval expression="@stDao.getAllArticl()" var="myList" />
    <c:forEach var="item" items="${myList}">
      <tr>
        <th scope="row"><c:out value="${item.getCodeArt()}"/></th>
        <td>  <c:out value= "${item.getNomArt()}"/></td>
        <td> <c:out value="${item.getPrixArt()}"/></td>
        <td><c:out value="${ item.getQteArt()}"/></td>
        <td><a href="addToCartAction.action?codeArt=${item.getCodeArt()}" class="btn btn-info">
          Add<i class='fas fa-cart-plus'></i>
        </a>
        </td>
      </tr>


    </c:forEach>
    </tbody>
  </table>--%>

</div>

<%@ include file="includes/footer.jsp" %>
