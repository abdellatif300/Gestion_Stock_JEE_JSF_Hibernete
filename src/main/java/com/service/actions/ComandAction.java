package com.service.actions;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.opensymphony.xwork2.ActionSupport;
import com.service.Entitys.Articles_Stock;
import com.service.Entitys.Commandes;
import com.service.Entitys.Invoice;
import com.service.dao.Functtions;

import com.service.test.PdfTest;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ComandAction extends ActionSupport {

    private List<Integer> ids;
    private List<String> nameProduits;
    private List<String> prix;
    private List<Integer> quantite;
    private List<Integer> pOfError;
    private int idInvoice;
    private float total;

    public int getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(int idInvoice) {
        this.idInvoice = idInvoice;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public ComandAction() {
        super();
    }

    public List<Integer> getpOfError() {
        return pOfError;
    }

    public void setpOfError(List<Integer> pOfError) {
        this.pOfError = pOfError;
    }

    public ComandAction(List<Integer> ids, List<String> nameProduits, List<String> prix, List<Integer> quantite) {
        this.ids = ids;
        this.nameProduits = nameProduits;
        this.prix = prix;
        this.quantite = quantite;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public List<String> getNameProduits() {
        return nameProduits;
    }

    public void setNameProduits(List<String> nameProduits) {
        this.nameProduits = nameProduits;
    }

    public List<String> getPrix() {
        return prix;
    }

    public void setPrix(List<String> prix) {
        this.prix = prix;
    }

    public List<Integer> getQuantite() {
        return quantite;
    }

    public void setQuantite(List<Integer> quantite) {
        this.quantite = quantite;
    }
   // public static Functtions fn= ContextProvider.provideContext().getBean("stDao",Functtions.class);



    public String saveCommand() throws UnsupportedEncodingException {

        //create object by spring
        Functtions fn=ContextProvider.provideContext().getBean("stDao",Functtions.class);
       // get session
        HttpSession session = ServletActionContext.getRequest().getSession();
        // creat array for stack the ids of invoice line have problem
        List<Integer> ee=new ArrayList<>();
        // variable to stock the price total of invoice = (quantity * price)
        float prix_total=0;
        // chek is a variable for check the lines of invoice
        boolean chek=false;
        // for loop
        for(int i=0; i<ids.size();i++){
            //check the quantity selected is available in stock
            if (quantite.get(i) > fn.getQuantiteByProduct(ids.get(i))){
                // if we get an error we add the aid of this line in ee array
                ee.add(ids.get(i));
                //we get a problem
                chek=true;
            }
            // calculate the total price
            prix_total+= (quantite.get(i)*Float.parseFloat(prix.get(i)));
        }
        // if we get an error in any line of invoice we return an error
        if (chek){
            this.setpOfError(ee);
            // we return an array of errors
            addActionError(this.pOfError.toString());
            return "error";
        }
        else {
            /// if all is oky
            // we create an invoice
            Invoice invoice=ContextProvider.provideContext().getBean("invoice", Invoice.class);
           // Commandes c=ContextProvider.provideContext().getBean("command", Commandes.class);
           // add the total to invoice
            invoice.setPrix_total(prix_total);
            // get the user from session
            invoice.setClient((String) session.getAttribute("loggedInUser"));
            //we save the id of invoice
            int id_invoice=fn.addInvoice(invoice);
            // for loop for add each  invoice line in the invoice
            for(int i=0; i<ids.size();i++){
                Commandes c=ContextProvider.provideContext().getBean("command", Commandes.class);
                c.setCodeArt(ids.get(i));
                c.setInvoice_id(id_invoice);
                c.setClient((String) session.getAttribute("loggedInUser"));
                c.setQteCmd(quantite.get(i));
                fn.addCommande(c);
                fn.decreaseQuantite(ids.get(i),(fn.getQuantiteByProduct(ids.get(i))-quantite.get(i)));
            }
            // we use this variable : just we need them don't remove them hhhhh
            this.setIdInvoice(id_invoice);
            this.setTotal(prix_total);
             fn.deleteAllCart((String) session.getAttribute("loggedInUser"));
             session.setAttribute("invoiceID",id_invoice);
             session.setAttribute("total",prix_total);
           // pdfAction(id_invoice,(String) session.getAttribute("loggedInUser"),prix_total);
            return "success";
        }

    }

}
