
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<spring:eval expression="@stDao.getAllCommandesByInvoice(idInvoice)" var="myList" />

<!DOCTYPE html>
<html lang="fr">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="./asset/fontawesome/css/all.min.css?version=1.0">
<style>

  /* NAV BUTTONS */
  #navbarSupportedContent ul .list-buttons{
    display: flex;
    gap: 10px;
    justify-content: space-around;
    align-items: center;
    margin-left: 15px;
  }
  .nav-button a,
  .nav-button button{
    margin: 8px;
    color: rgba(255,255,255,0.5);
    text-decoration: none;
    font-size: 15px;
    display: block;
    padding: 5px 15px;
    transition-duration:0.6s;
    transition-timing-function: cubic-bezier(0.68, -0.55, 0.265, 1.55);
    position: relative;
    border-radius: 15px;
    background: #fca311;
    border: 2px solid white;
    color: white;
  }
  .nav-button a:hover,
  .nav-button button:hover{
    background-color: #ffba4bb9;
    transition: all 0.7s;
  }

  .nav-button.main a,
  .nav-button.main button{
    background: white;
    border: 2px solid white;
    color: #fca311;
  }
  .nav-button.main a:hover,
  .nav-button.main button:hover{
    background-color: #ffe3b5;
    transition: all 0.7s;
  }

</style>
</head>
<body style="background-color: #f5f5f5; padding: 0; text-align: center; background: rgb(236, 236, 236);" bgcolor="rgb(236,">
<table border="0" cellpadding="0" cellspacing="0" height="100%" width="100%" class="yaymail-template-customer_completed_order">
  <tr><td style="font-family: inherit;">
    <table width="605" cellspacing="0" cellpadding="0" border="0" align="center" class="web-main-row" id="web8ffa62b5-7258-42cc-ba53-7ae69638c1fe" style="height: 100%; background-color: #FFFFFF; min-width: 605px;" height="100%" bgcolor="#FFFFFF">
      <tbody>
      <tr>
        <td id="web8ffa62b5-7258-42cc-ba53-7ae69638c1fe-img" align="center" class="web-img-wrap" style="font-family: inherit; text-align: center; padding: 15px 0px 15px 0px;">
          <a href="index.jsp" style="color: #557da1; font-weight: normal; border: none; text-decoration: none;">
            <img class="web-img" border="0" src="asset/images/Logo_.svg" width="172" height="auto" style="border: none; display: inline-block; font-size: 14px; font-weight: bold; height: auto; outline: none; text-decoration: none; text-transform: capitalize; vertical-align: middle; margin-right: 10px; max-width: 100%;">
          </a>
        </td>
      </tr>
      </tbody>
    </table>
  </td></tr>
  <tr><td style="font-family: inherit;">
    <table width="605" cellspacing="0" cellpadding="0" border="0" align="center" class="web-main-row" id="web802bfe24-7af8-48af-ac5e-6560a81345b3" style="height: 100%; background-color: #D18202; min-width: 605px;" height="100%" bgcolor="#D18202">
      <tbody>
      <tr>
        <td id="web-802bfe24-7af8-48af-ac5e-6560a81345b3el-text" class="web-el-text" align="left" style="font-size: 13px; line-height: 22px; font-family: Helvetica,Roboto,Arial,sans-serif; padding: 36px 48px 36px 48px; color: #ffffff;">
          <div class="element-text-content" style="min-height: 10px;">
            <h1 style="text-shadow: unset; text-align: inherit; font-size: 30px; font-weight: 300; line-height: normal; margin: 0; color: inherit; font-family: Helvetica,Roboto,Arial,sans-serif;"><span style="font-size: 24px;">Your invoice is complete</span></h1>		</div>
        </td>
      </tr>
      </tbody>
    </table>
  </td></tr>
  <tr><td style="font-family: inherit;">
    <table width="605" cellspacing="0" cellpadding="0" border="0" align="center" class="web-main-row" id="webb035d1f1-0cfe-41c5-b79c-0478f144ef5f" style="height: 100%; background-color: #fff; min-width: 605px;" height="100%" bgcolor="#fff">
      <tbody>
      <tr>
        <td id="web-b035d1f1-0cfe-41c5-b79c-0478f144ef5fel-text" class="web-el-text" align="left" style="font-size: 13px; line-height: 22px; font-family: Helvetica,Roboto,Arial,sans-serif; padding: 47px 50px 0px 50px; color: #636363;">
          <div class="element-text-content" style="min-height: 10px;">
            <p style="margin: 0px;">Hello! <span style="font-size: 14px;"><c:out value="${sessionScope.loggedInUser}" />,</span></p>
            <p style="margin: 0px;">Thank you for your order on Ray-Run.</p>
            <p style="margin: 0px;"> We hope you are satisfied with the products received.</p>
            <p style="margin: 0px;"> Your opinion is important to us, do not hesitate to send us your comments. </p>
            <p style="margin: 0px;"> We are here to help you. </p>
            <p style="margin: 0px;">Cordially,</p>
            <p style="margin: 0px;">The Ray-Run team</p>
          </div>
        </td>
      </tr>
      </tbody>
    </table>
  </td></tr>
  <tr><td style="font-family: inherit;">
    <table width="605" cellspacing="0" cellpadding="0" border="0" align="center" class="web-main-row" id="webad422370-f762-4a26-92de-c4cf3878h0oirt" style="background-color: #fff; min-width: 605px;" bgcolor="#fff">
      <tbody>
      <tr>
        <td id="web-ad422370-f762-4a26-92de-c4cf3878h0oirt-tracking-item" class="web-tracking-item" align="left" style="font-size: 13px; line-height: 22px; font-family: Helvetica,Roboto,Arial,sans-serif; padding: 0px 50px 0px 50px;">
          <div class="yaymail_items_border_custom" style="color: #7f54b3;">

            <!-- Table Items has Border -->
          </div>
          <div class="yaymail-items-item-download" style="min-height: 5px; color: #636363; border-color: #e5e5e5;">

            <!-- Table Items has Border -->
          </div>
        </td>
      </tr>
      </tbody>
    </table>
  </td></tr>
  <tr><td style="font-family: inherit;">

    <table width="605" cellspacing="0" cellpadding="0" border="0" align="center" class="web-main-row" id="webad422370-f762-4a26-92de-c4cf3878h0oi" style="background-color: #fff; min-width: 605px;" bgcolor="#fff">
      <tbody>
      <tr>
        <td id="web-ad422370-f762-4a26-92de-c4cf3878h0oi-order-item" class="web-order-item" align="left" style="font-size: 13px; line-height: 22px; font-family: Helvetica,Roboto,Arial,sans-serif; padding: 15px 50px 15px 50px;">
          <div style="min-height: 10px; color: #636363;">
            <h2 class="yaymail_builder_order" style="text-align: inherit; margin-bottom: .83em; display: block; font-family: inherit; line-height: 130%; margin: 0 0 18px; font-size: 18px; font-weight: 700; color: #D0021B;">
              <div class="yaymail_builder_order_title" style="font-family: Helvetica,Roboto,Arial,sans-serif;">
                <h2 class="yaymail_builder_link" style="display: block; line-height: 130%; font-family: inherit; text-align: inherit; margin: 0px; font-weight: normal; font-size: 18px; color: #D0021B;">
                  <span class="yaymail-underline">[Order ${idInvoice}]</span> (<c:out value="${myList[0][0]. getDateCmd()}"/>)</h2></div>
            </h2>
            <div>
              <table class="yaymail_builder_table_items_content yaymail_order_items_content yaymail_element_order_item" cellspacing="0" cellpadding="6" border="1" width="100%" style="border-collapse: separate; color: #636363; border: 1px solid #e5e5e5; font-family: Helvetica,Roboto,Arial,sans-serif;">

                <thead class="yaymail_element_head_order_item">
                <tr>
                  <th colspan="1" class="td yaymail_item_product_title" scope="col" style="border: 1px solid #e4e4e4; color: inherit; text-align: left; vertical-align: middle; padding: 12px; font-size: 14px; border-width: 1px; border-style: solid; border-color: #e5e5e5;" align="left">
                    Product		</th>
                  <th colspan="1" class="td yaymail_item_quantity_title" scope="col" style="border: 1px solid #e4e4e4; color: inherit; text-align: left; vertical-align: middle; padding: 12px; font-size: 14px; border-width: 1px; border-style: solid; border-color: #e5e5e5;" align="left">
                    Quantity		</th>
                  <th colspan="1" class="td yaymail_item_price_title" scope="col" style="border: 1px solid #e4e4e4; color: inherit; width: 30%; text-align: left; vertical-align: middle; padding: 12px; font-size: 14px; border-width: 1px; border-style: solid; border-color: #e5e5e5;" width="30%" align="left">
                    Price		</th>
                </tr>
                </thead>
                <tbody class="yaymail_element_body_order_item" style="border-color: inherit;">
                <!-- fooreach-->
                <c:set var="i" value="${0}" />
                <c:forEach var="item" items="${myList}">
                  <tr class="order_item" style="border-color: inherit;">
                    <th colspan="1" class="td" style="border: 1px solid #e4e4e4; color: inherit; text-align: left; font-weight: normal; vertical-align: middle; padding: 12px; font-size: 14px; border-width: 1px; border-style: solid; border-color: #e5e5e5;" align="left">
                      <div class="yaymail-product-image" style="float: left; margin-bottom: 5px;">
                      </div>
                      <div class="yaymail-product-texts" style="padding: 5px 0;">
                        <span class="yaymail-product-name"><c:out value="${myList[i][1].getNomArt()}"/></span>
                      </div>
                    </th>
                    <th colspan="1" class="td yaymail_item_quantity_content" style="border: 1px solid #e4e4e4; color: inherit; text-align: left; font-weight: normal; vertical-align: middle; padding: 12px; font-size: 14px; border-width: 1px; border-style: solid; border-color: #e5e5e5;" align="left">
                      <c:out value="${myList[i][0].getQteCmd()}"/>	</th>
                    <th colspan="1" class="td yaymail_item_price_content" style="border: 1px solid #e4e4e4; color: inherit; text-align: left; font-weight: normal; vertical-align: middle; padding: 12px; font-size: 14px; border-width: 1px; border-style: solid; border-color: #e5e5e5;" align="left">
                    <span class="woocommerce-Price-amount amount">
                      <c:set var="prixArt" value="${myList[i][0].getQteCmd() * myList[i][1].getPrixArt()}" />
                      <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${prixArt}"/>

                      <span class="woocommerce-Price-currencySymbol">DH</span></span></th>
                  </tr>
                  <c:set var="i" value="${i+1}" />
                </c:forEach>
                </tbody>
                <tfoot class="yaymail_element_foot_order_item">

                <tr class="yaymail_item_total_title_row">
                  <th class="td yaymail_item_total_title" scope="row" colspan="2" style="border: 1px solid #e4e4e4; color: inherit; text-align: left; vertical-align: middle; padding: 12px; font-size: 14px; border-width: 1px; border-style: solid; border-color: #e5e5e5;" align="left">
                    Total :		</th>
                  <th class="td yaymail_item_total_content" style="border: 1px solid #e4e4e4; color: inherit; font-weight: normal; text-align: left; vertical-align: middle; padding: 12px; font-size: 14px; border-width: 1px; border-style: solid; border-color: #e5e5e5;" align="left">

                    <span class="woocommerce-Price-amount amount"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${total}"/> <span class="woocommerce-Price-currencySymbol">DH</span></span>		</th>
                </tr>

                </tfoot>
              </table>
            </div>
          </div>
        </td>
      </tr>
      </tbody>
    </table>
  </td></tr>
  <tr><td style="font-family: inherit;">
    <table width="605" cellspacing="0" cellpadding="0" border="0" align="center" class="web-main-row" id="webde242956-a617-4213-9107-138842oi4tch" style="background-color: #fff; min-width: 605px;" bgcolor="#fff">
      <tbody>

                </table>
              </div>
            </div>

          </div>
        </td>
      </tr>
      </tbody>
    </table>
  </td></tr>
  <tr><td style="font-family: inherit;">
    <table width="605" cellspacing="0" cellpadding="0" border="0" align="center" class="web-main-row" id="webb39bf2e6-8c1a-4384-a5ec-37663da27c8d" style="height: 100%; background-color: #fff; min-width: 605px;" height="100%" bgcolor="#fff">
      <tbody>
      <tr>
        <td id="web-b39bf2e6-8c1a-4384-a5ec-37663da27c8del-text" class="web-el-text" align="left" style="font-size: 13px; line-height: 22px; font-family: Helvetica,Roboto,Arial,sans-serif; padding: 0px 50px 38px 50px; color: #636363;">
          <div class="element-text-content" style="min-height: 10px;">
            <p style="margin: 0px;"><span style="font-size: 14px;">Thank you for your purchase.</span></p></div>





          <div class="nav-button" style="display: flex;justify-content: space-around;">
            <a href="download.action" class="nav-button-link" style="padding: 10px 20px;">
              <i class="fas fa-file-download"></i> Download
            </a>
            <a href="sendByEmail.action" class="nav-button-link" style="padding: 10px 20px;">
              <i class="fas fa-envelope-open-text"></i> Send by Email
            </a>
          </div>

        </td>
      </tr>

      </tbody>
    </table>
  </td></tr>
  <tr><td style="font-family: inherit;">
    <table width="605" cellspacing="0" cellpadding="0" border="0" align="center" class="web-main-row" id="webb39bf2e6-8c1a-4384-a5ec-37663da27c8ds" style="height: 100%; background-color: #ececec; min-width: 605px;" height="100%" bgcolor="#ececec">
      <tbody>
      <tr>
        <td id="web-b39bf2e6-8c1a-4384-a5ec-37663da27c8dsel-text" class="web-el-text" align="left" style="font-size: 13px; line-height: 22px; font-family: Helvetica,Roboto,Arial,sans-serif; padding: 15px 50px 15px 50px; color: #8a8a8a;">
          <div class="element-text-content" style="min-height: 10px;">
            <p style="font-size: 14px; margin: 0px 0px 16px; text-align: center;" align="center">Ray-Run-Sale Glasses in Morocco</p>		</div>
        </td>
      </tr>
      </tbody>
    </table>
  </td></tr>

</table>

</body>

<script src="./asset/jquery-3.4.1.min.js"></script>
<script src="./asset/script.js"></script>

<script>
  $(document).ready(()=>{
      deleteAllItems()
  })
</script>
</html>
