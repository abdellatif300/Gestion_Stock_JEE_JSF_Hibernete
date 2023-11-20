package com.service.actions;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.opensymphony.xwork2.ActionSupport;
import com.service.Entitys.Articles_Stock;
import com.service.Entitys.Commandes;
import com.service.dao.Functtions;
import org.apache.struts2.ServletActionContext;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.List;

public class PdfAction extends ActionSupport {

    public static Functtions fn= ContextProvider.provideContext().getBean("stDao",Functtions.class);
    public String downloadPdf() throws UnsupportedEncodingException {
        HttpSession session = ServletActionContext.getRequest().getSession();
        this.pdfAction((int) session.getAttribute("invoiceID"),(String) session.getAttribute("loggedInUser"),(float) session.getAttribute("total"));
        /*session.removeAttribute("invoiceID");
        session.removeAttribute("total");*/
        return "success";
    }
    public String sendInEmail() throws MessagingException, IOException {
        HttpSession session = ServletActionContext.getRequest().getSession();
        SendEmail emailSend= ContextProvider.provideContext().getBean("email",SendEmail.class);
        String usernam=(String) session.getAttribute("loggedInUser");
        emailSend.sand(this.writeUsingIText("invoice.pdf",(int)session.getAttribute("invoiceID"),usernam,(float) session.getAttribute("total")),fn.getUserByName(usernam).getEmail(),usernam);
        /*session.removeAttribute("invoiceID");
        session.removeAttribute("total");*/
        return "success";
    }

    public void pdfAction(int idInvoice,String username,float total) throws UnsupportedEncodingException {
        //PdfTest pd=ContextProvider.provideContext().getBean("pdfTest" ,PdfTest.class);
        String filePath = "invoice.pdf";
        File pdfFile = this.writeUsingIText(filePath,idInvoice,username,total);

        // Set the response headers for downloading the file
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/pdf");
        String encodedFileName = URLEncoder.encode(pdfFile.getName(), "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + encodedFileName);

        try {
            // Open an input stream to the generated PDF file
            FileInputStream fis = new FileInputStream(pdfFile);
            OutputStream os = response.getOutputStream();

            // Read from the input stream and write to the response output stream
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }

            // Close the streams
            fis.close();
            os.flush();
            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        //return "true";
    }
    public  File writeUsingIText(String filePath, int idInvoice,String username,float total) {
        File file = new File(filePath);
        try {
            FileOutputStream outputStream = new FileOutputStream(file);

            ConverterProperties converterProperties = new ConverterProperties();
            HtmlConverter.convertToPdf(this.pdfForma(idInvoice,username,total), outputStream, converterProperties);

            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }

    public  String pdfForma(int idInvoice,String username,float total){
        List<Object[]> results = fn.getAllCommandesByInvoice(idInvoice);
        LocalDate dateCmd = ((Commandes) results.get(0)[0]).getDateCmd();
        System.out.println(dateCmd);
        String contentHTML="";
        contentHTML+="<!DOCTYPE html>\n" +
                "<html lang=\"fr\">\n" +
                "<head>\n" +
                "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
                "  <meta charset=\"UTF-8\">\n" +
                "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "\n" +
                "</head>";
        contentHTML+=" "+"<body style=\"background-color: #f5f5f5; padding: 0; text-align: center; background: rgb(236, 236, 236);\" bgcolor=\"rgb(236,\">\n" +
                "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" height=\"100%\" width=\"100%\" class=\"yaymail-template-customer_completed_order\">\n" +
                "  <tr><td style=\"font-family: inherit;\">\n" +
                "    <table width=\"605\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"center\" class=\"web-main-row\" id=\"web8ffa62b5-7258-42cc-ba53-7ae69638c1fe\" style=\"height: 100%; background-color: #FFFFFF; min-width: 605px;\" height=\"100%\" bgcolor=\"#FFFFFF\">\n" +
                "      <tbody>\n" +
                "      <tr>\n" +
                "        <td id=\"web8ffa62b5-7258-42cc-ba53-7ae69638c1fe-img\" align=\"center\" class=\"web-img-wrap\" style=\"font-family: inherit; text-align: center; padding: 15px 0px 15px 0px;\">\n" +
                "          <a href=\"#\" target=\"_blank\" style=\"color: #557da1; font-weight: normal; border: none; text-decoration: none;\">\n" +
                "            <img class=\"web-img\" border=\"0\" src=\"C:\\Users\\dell\\Desktop\\master-s2\\jee\\sales_management\\gestion_vend\\src\\main\\webapp\\asset\\images\\Logo_.svg\" width=\"172\" height=\"auto\" style=\"border: none; display: inline-block; font-size: 14px; font-weight: bold; height: auto; outline: none; text-decoration: none; text-transform: capitalize; vertical-align: middle; margin-right: 10px; max-width: 100%;\">\n" +
                "          </a>\n" +
                "        </td>\n" +
                "      </tr>\n" +
                "      </tbody>\n" +
                "    </table>\n" +
                "  </td></tr>\n" +
                "  <tr><td style=\"font-family: inherit;\">\n" +
                "    <table width=\"605\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"center\" class=\"web-main-row\" id=\"web802bfe24-7af8-48af-ac5e-6560a81345b3\" style=\"height: 100%; background-color: #D18202; min-width: 605px;\" height=\"100%\" bgcolor=\"#D18202\">\n" +
                "      <tbody>\n" +
                "      <tr>\n" +
                "        <td id=\"web-802bfe24-7af8-48af-ac5e-6560a81345b3el-text\" class=\"web-el-text\" align=\"left\" style=\"font-size: 13px; line-height: 22px; font-family: Helvetica,Roboto,Arial,sans-serif; padding: 36px 48px 36px 48px; color: #ffffff;\">\n" +
                "          <div class=\"element-text-content\" style=\"min-height: 10px;\">\n" +
                "            <h1 style=\"text-shadow: unset; text-align: inherit; font-size: 30px; font-weight: 300; line-height: normal; margin: 0; color: inherit; font-family: Helvetica,Roboto,Arial,sans-serif;\"><span style=\"font-size: 24px;\">Your invoice is complete</span></h1>\t\t</div>\n" +
                "        </td>\n" +
                "      </tr>\n" +
                "      </tbody>\n" +
                "    </table>\n" +
                "  </td></tr>\n" +
                "  <tr><td style=\"font-family: inherit;\">\n" +
                "    <table width=\"605\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"center\" class=\"web-main-row\" id=\"webb035d1f1-0cfe-41c5-b79c-0478f144ef5f\" style=\"height: 100%; background-color: #fff; min-width: 605px;\" height=\"100%\" bgcolor=\"#fff\">\n" +
                "      <tbody>\n" +
                "      <tr>\n" +
                "        <td id=\"web-b035d1f1-0cfe-41c5-b79c-0478f144ef5fel-text\" class=\"web-el-text\" align=\"left\" style=\"font-size: 13px; line-height: 22px; font-family: Helvetica,Roboto,Arial,sans-serif; padding: 47px 50px 0px 50px; color: #636363;\">\n" +
                "          <div class=\"element-text-content\" style=\"min-height: 10px;\">\n" +
                "            <p style=\"margin: 0px;\">Hello! <span style=\"font-size: 14px;\">"+ username
                +",</span></p>\n" +
                "            <p style=\"margin: 0px;\">Thank you for your order on Ray-Run.</p>\n" +
                "            <p style=\"margin: 0px;\"> We hope you are satisfied with the products received.</p>\n" +
                "            <p style=\"margin: 0px;\"> Your opinion is important to us, do not hesitate to send us your comments. </p>\n" +
                "            <p style=\"margin: 0px;\"> We are here to help you. </p>\n" +
                "            <p style=\"margin: 0px;\">Cordially,</p>\n" +
                "            <p style=\"margin: 0px;\">The Ray-Run team</p>\n" +
                "          </div>\n" +
                "        </td>\n" +
                "      </tr>\n" +
                "      </tbody>\n" +
                "    </table>\n" +
                "  </td></tr>\n" +
                "  <tr><td style=\"font-family: inherit;\">\n" +
                "    <table width=\"605\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"center\" class=\"web-main-row\" id=\"webad422370-f762-4a26-92de-c4cf3878h0oirt\" style=\"background-color: #fff; min-width: 605px;\" bgcolor=\"#fff\">\n" +
                "      <tbody>\n" +
                "      <tr>\n" +
                "        <td id=\"web-ad422370-f762-4a26-92de-c4cf3878h0oirt-tracking-item\" class=\"web-tracking-item\" align=\"left\" style=\"font-size: 13px; line-height: 22px; font-family: Helvetica,Roboto,Arial,sans-serif; padding: 0px 50px 0px 50px;\">\n" +
                "          <div class=\"yaymail_items_border_custom\" style=\"color: #7f54b3;\">\n" +
                "\n" +
                "            <!-- Table Items has Border -->\n" +
                "          </div>\n" +
                "          <div class=\"yaymail-items-item-download\" style=\"min-height: 5px; color: #636363; border-color: #e5e5e5;\">\n" +
                "\n" +
                "            <!-- Table Items has Border -->\n" +
                "          </div>\n" +
                "        </td>\n" +
                "      </tr>\n" +
                "      </tbody>\n" +
                "    </table>\n" +
                "  </td></tr>\n" +
                "  <tr><td style=\"font-family: inherit;\">\n" +
                "\n" +
                "    <table width=\"605\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"center\" class=\"web-main-row\" id=\"webad422370-f762-4a26-92de-c4cf3878h0oi\" style=\"background-color: #fff; min-width: 605px;\" bgcolor=\"#fff\">\n" +
                "      <tbody>\n" +
                "      <tr>\n" +
                "        <td id=\"web-ad422370-f762-4a26-92de-c4cf3878h0oi-order-item\" class=\"web-order-item\" align=\"left\" style=\"font-size: 13px; line-height: 22px; font-family: Helvetica,Roboto,Arial,sans-serif; padding: 15px 50px 15px 50px;\">\n" +
                "          <div style=\"min-height: 10px; color: #636363;\">\n" +
                "            <h2 class=\"yaymail_builder_order\" style=\"text-align: inherit; margin-bottom: .83em; display: block; font-family: inherit; line-height: 130%; margin: 0 0 18px; font-size: 18px; font-weight: 700; color: #D0021B;\">\n" +
                "              <div class=\"yaymail_builder_order_title\" style=\"font-family: Helvetica,Roboto,Arial,sans-serif;\">\n" +
                "                <h2 class=\"yaymail_builder_link\" style=\"display: block; line-height: 130%; font-family: inherit; text-align: inherit; margin: 0px; font-weight: normal; font-size: 18px; color: #D0021B;\">\n" +
                "                  <span class=\"yaymail-underline\">[Order "+idInvoice+"]</span> " +
                "         ";
        contentHTML+=""+dateCmd;
        contentHTML+="</h2></div>\n" +
                "            </h2>\n" +
                "            <div>\n" +
                "              <table class=\"yaymail_builder_table_items_content yaymail_order_items_content yaymail_element_order_item\" cellspacing=\"0\" cellpadding=\"6\" border=\"1\" width=\"100%\" style=\"border-collapse: separate; color: #636363; border: 1px solid #e5e5e5; font-family: Helvetica,Roboto,Arial,sans-serif;\">\n" +
                "\n" +
                "                <thead class=\"yaymail_element_head_order_item\">\n" +
                "                <tr>\n" +
                "                  <th colspan=\"1\" class=\"td yaymail_item_product_title\" scope=\"col\" style=\"border: 1px solid #e4e4e4; color: inherit; text-align: left; vertical-align: middle; padding: 12px; font-size: 14px; border-width: 1px; border-style: solid; border-color: #e5e5e5;\" align=\"left\">\n" +
                "                    Product\t\t</th>\n" +
                "                  <th colspan=\"1\" class=\"td yaymail_item_quantity_title\" scope=\"col\" style=\"border: 1px solid #e4e4e4; color: inherit; text-align: left; vertical-align: middle; padding: 12px; font-size: 14px; border-width: 1px; border-style: solid; border-color: #e5e5e5;\" align=\"left\">\n" +
                "                    Quantity\t\t</th>\n" +
                "                  <th colspan=\"1\" class=\"td yaymail_item_price_title\" scope=\"col\" style=\"border: 1px solid #e4e4e4; color: inherit; width: 30%; text-align: left; vertical-align: middle; padding: 12px; font-size: 14px; border-width: 1px; border-style: solid; border-color: #e5e5e5;\" width=\"30%\" align=\"left\">\n" +
                "                    Price\t\t</th>\n" +
                "                </tr>\n" +
                "                </thead>"+"<tbody class=\"yaymail_element_body_order_item\" style=\"border-color: inherit;\">";
        for (Object[] result : results) {
            Commandes commandes = (Commandes) result[0];
            Articles_Stock articlesStock = (Articles_Stock) result[1];
            System.out.println(articlesStock.getNomArt());
            System.out.println(commandes.getQteCmd());
            System.out.println(commandes.getQteCmd()*articlesStock.getPrixArt());
            contentHTML+=" <tr class=\"order_item\" style=\"border-color: inherit;\">\n" +
                    "                    <th colspan=\"1\" class=\"td\" style=\"border: 1px solid #e4e4e4; color: inherit; text-align: left; font-weight: normal; vertical-align: middle; padding: 12px; font-size: 14px; border-width: 1px; border-style: solid; border-color: #e5e5e5;\" align=\"left\">\n" +
                    "                      <div class=\"yaymail-product-image\" style=\"float: left; margin-bottom: 5px;\">\n" +
                    "                      </div>\n" +
                    "                      <div class=\"yaymail-product-texts\" style=\"padding: 5px 0;\">\n" +
                    "                        <span class=\"yaymail-product-name\">";
                    contentHTML+=""+articlesStock.getNomArt();

                    contentHTML+="</span>\n" +
                    "                      </div>\n" +
                    "                    </th>\n" +
                    "                    <th colspan=\"1\" class=\"td yaymail_item_quantity_content\" style=\"border: 1px solid #e4e4e4; color: inherit; text-align: left; font-weight: normal; vertical-align: middle; padding: 12px; font-size: 14px; border-width: 1px; border-style: solid; border-color: #e5e5e5;\" align=\"left\">\n" +
                    "                     ";
                    contentHTML+=""+commandes.getQteCmd();

                  contentHTML+= "\t</th>\n" +
                    "                    <th colspan=\"1\" class=\"td yaymail_item_price_content\" style=\"border: 1px solid #e4e4e4; color: inherit; text-align: left; font-weight: normal; vertical-align: middle; padding: 12px; font-size: 14px; border-width: 1px; border-style: solid; border-color: #e5e5e5;\" align=\"left\">\n" +
                    "                    <span class=\"woocommerce-Price-amount amount\">";
                    contentHTML+=""+(commandes.getQteCmd()*articlesStock.getPrixArt());
                    contentHTML+=
                    "\n" +
                    "                      <span class=\"woocommerce-Price-currencySymbol\">DH</span></span></th>\n" +
                    "                  </tr>\n";

        }
        contentHTML+=" </tbody>\n" +
                "                <tfoot class=\"yaymail_element_foot_order_item\">\n" +
                "\n" +
                "                <tr class=\"yaymail_item_total_title_row\">\n" +
                "                  <th class=\"td yaymail_item_total_title\" scope=\"row\" colspan=\"2\" style=\"border: 1px solid #e4e4e4; color: inherit; text-align: left; vertical-align: middle; padding: 12px; font-size: 14px; border-width: 1px; border-style: solid; border-color: #e5e5e5;\" align=\"left\">\n" +
                "                    Total :\t\t</th>\n" +
                "                  <th class=\"td\n" +
                "\t\tyaymail_item_total_content\t\t\" style=\"border: 1px solid #e4e4e4; color: inherit; font-weight: normal; text-align: left; vertical-align: middle; padding: 12px; font-size: 14px; border-width: 1px; border-style: solid; border-color: #e5e5e5;\" align=\"left\">\n" +
                "                    <span class=\"woocommerce-Price-amount amount\">"+total+" <span class=\"woocommerce-Price-currencySymbol\">DH</span></span>\t\t</th>\n" +
                "                </tr>\n" +
                "\n" +
                "                </tfoot>\n" +
                "              </table>\n" +
                "            </div>\n" +
                "          </div>\n" +
                "        </td>\n" +
                "      </tr>\n" +
                "      </tbody>\n" +
                "    </table>\n" +
                "  </td></tr>\n" +
                "  <tr><td style=\"font-family: inherit;\">\n" +
                "    <table width=\"605\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"center\" class=\"web-main-row\" id=\"webde242956-a617-4213-9107-138842oi4tch\" style=\"background-color: #fff; min-width: 605px;\" bgcolor=\"#fff\">\n" +
                "      <tbody>\n" +
                "\n" +
                "                </table>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "\n" +
                "          </div>\n" +
                "        </td>\n" +
                "      </tr>\n" +
                "      </tbody>\n" +
                "    </table>\n" +
                "  </td></tr>\n" +
                "  <tr><td style=\"font-family: inherit;\">\n" +
                "    <table width=\"605\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"center\" class=\"web-main-row\" id=\"webb39bf2e6-8c1a-4384-a5ec-37663da27c8d\" style=\"height: 100%; background-color: #fff; min-width: 605px;\" height=\"100%\" bgcolor=\"#fff\">\n" +
                "      <tbody>\n" +
                "      <tr>\n" +
                "        <td id=\"web-b39bf2e6-8c1a-4384-a5ec-37663da27c8del-text\" class=\"web-el-text\" align=\"left\" style=\"font-size: 13px; line-height: 22px; font-family: Helvetica,Roboto,Arial,sans-serif; padding: 0px 50px 38px 50px; color: #636363;\">\n" +
                "          <div class=\"element-text-content\" style=\"min-height: 10px;\">\n" +
                "            <p style=\"margin: 0px;\"><span style=\"font-size: 14px;\">Thank you for your purchase.</span></p>\t\t</div>\n" +
                "        </td>\n" +
                "      </tr>\n" +
                "      </tbody>\n" +
                "    </table>\n" +
                "  </td></tr>\n" +
                "  <tr><td style=\"font-family: inherit;\">\n" +
                "    <table width=\"605\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"center\" class=\"web-main-row\" id=\"webb39bf2e6-8c1a-4384-a5ec-37663da27c8ds\" style=\"height: 100%; background-color: #ececec; min-width: 605px;\" height=\"100%\" bgcolor=\"#ececec\">\n" +
                "      <tbody>\n" +
                "      <tr>\n" +
                "        <td id=\"web-b39bf2e6-8c1a-4384-a5ec-37663da27c8dsel-text\" class=\"web-el-text\" align=\"left\" style=\"font-size: 13px; line-height: 22px; font-family: Helvetica,Roboto,Arial,sans-serif; padding: 15px 50px 15px 50px; color: #8a8a8a;\">\n" +
                "          <div class=\"element-text-content\" style=\"min-height: 10px;\">\n" +
                "            <p style=\"font-size: 14px; margin: 0px 0px 16px; text-align: center;\" align=\"center\">Ray-Run-Sale Glasses in Morocco</p>\t\t</div>\n" +
                "        </td>\n" +
                "      </tr>\n" +
                "      </tbody>\n" +
                "    </table>\n" +
                "  </td></tr>\n" +
                "</table>\n" +
                "</body>\n" +
                "</html>";
        return contentHTML ;
    }


}
