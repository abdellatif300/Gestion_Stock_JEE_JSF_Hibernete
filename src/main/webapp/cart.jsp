<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="currentPage" value="Cart" />
<c:set var="pageTitle" value="Shopping Cart" />
<%@ include file="includes/header.jsp" %>
<div class="container-md cart">
    <h1>Shopping Cart</h1>
    <br/>

    <spring:eval expression="@stDao.afficherCart()" var="myCart" />
    <c:if test="${myCart.size() > 0}">

        <div class="invalid">

        </div>

        <form action="commande" method="post">
            <input type="hidden" value="${pOfError}" name="pOfError" id="cart1-message">
            <table class="table">
                <input type="hidden" value="${message}" name="message" id="cart-message">
                <thead>
                <tr>
                    <th scope="col"></th>
                    <th scope="col">Product name</th>
                    <th scope="col">price</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">SubTotal</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>

                <tbody>

                <c:forEach var="item" items="${myCart}">

                    <c:set var="splitNumber" value="${fn:split(item.getPrixArt(), '.')}"/>
                    <c:set var="addedZeros" value='${(fn:length(splitNumber[1]) == 0) ? "00" : ""}' />
                    <c:set var="addedZeros" value='${(fn:length(splitNumber[1]) == 1) ? "0" : ""}' />
                    <tr id="tr${item.getCodeArt()}">
                        <td class="img">
                            <div class="image mini">
                                <div class="navbar-logo">Ray-Run</div>
                                <img src="${item.getImage()}" alt="Sample photo">
                            </div>
                        </td>
                        <input type="hidden" name="ids" value="${item.getCodeArt()}">
                        <td class="name name${item.getCodeArt()}"><c:out value= "${item.getNomArt()}"/></td>
                        <input type="hidden" name="nameProduits"  value="${item.getNomArt()}">
                        <td class="price"><c:out value="${item.getPrixArt()}${addedZeros}"/></td>
                        <input type="hidden" name="prix" value="${item.getPrixArt()}${addedZeros}" id="prix${item.getCodeArt()}">
                        <td class="qte"><input class="numberstyle qte${item.getCodeArt()}" name="quantite" onchange="changedQuantity(this.value,${item.getCodeArt()})" data-codeart="${item.getCodeArt()}" type="number" min="1" step="1" value="2"></td>
                        <td class="subTotal" id="subTotal${item.getCodeArt()}">0.00</td>
                        <td class="action"><a href="deletAction.action?codeArt=${item.getCodeArt()}" id="cart-delete-button_${item.getCodeArt()}" class="btn btn-danger" onclick="deleteItem(${item.getCodeArt()})">
                            <i class="fa fa-trash m-0" aria-hidden="true"></i>
                        </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
                <tfoot>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td class="totalText font-weight-bold">Total:</td>
                    <td class="totalPrice font-weight-bold">0.00</td>
                    <td></td>
                </tr>
                </tfoot>

            </table>
            <div class="text-right">
                <button class="order" type="submit">Complete order</button>
            </div>
        </form>
    </c:if>

    <c:if test="${myCart.size() == 0}">
        <div class="NotFound">
            <div class="img_emp_cart">
                <img src="asset/images/empty_cart.png"/>
            </div>
            <h4>
                Your cart is empty
            </h4>
            <p>Looks like you have not added anything to your cart. Go ahaid & explore RayRun products.</p>
            <div class="nav-button">
                <a class="nav-button-link" href="products.jsp"><i class="fas fa-tags"></i>View products</a>
            </div>
        </div>
    </c:if>










</div>
<%@ include file="includes/footer.jsp"%>