<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="currentPage" value="Home" />
<c:set var="pageTitle" value="Home" />

<%--CHOOSE THE HEADER DEPENDS ON THE AUTHENTIFICATION OF THE USER--%>
<c:choose>
    <c:when test="${empty sessionScope.loggedInUser}">
        <%@ include file="includes/headerVisitor.jsp" %>
    </c:when>
    <c:otherwise>
        <%@ include file="includes/header.jsp" %>
    </c:otherwise>
</c:choose>


<div class="container Home">
    <div class="cover" data-aos="zoom-out-down"></div>
    <main>
        <div class="categoryLink sunglasses" data-aos="zoom-in-left">
            <a href="selectCat.action?category=sunglasses">
                <span class="categoryTitle">SunGlasses</span>
            </a>
        </div>
        <div class="categoryLink eyeglasses" data-aos="zoom-in-right">
            <a href="selectCat.action?category=eyeglasses">
                <span class="categoryTitle">EyeGlasses</span>
            </a>
        </div>

    </main>
</div>

<%@ include file="includes/footer.jsp" %>
