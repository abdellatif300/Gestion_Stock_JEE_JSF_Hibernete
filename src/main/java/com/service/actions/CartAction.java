package com.service.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.service.Entitys.Cart;
import com.service.dao.Functtions;
import com.service.test.PdfTest;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;

public class CartAction extends ActionSupport {
    private String  codeArt;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CartAction() {
        super();
    }

    public CartAction(String codeArt, String message) {
        this.codeArt = codeArt;
        this.message = message;
    }

    public String  getCodeArt() {
        return codeArt;
    }

    public void setCodeArt(String  codeArt) {
        this.codeArt = codeArt;
    }

    public String addToCart(){
        Functtions fn=ContextProvider.provideContext().getBean("stDao",Functtions.class);
        Cart cart=ContextProvider.provideContext().getBean("cart", Cart.class);
        HttpSession session = ServletActionContext.getRequest().getSession();
        cart.setUsername((String) session.getAttribute("loggedInUser"));
        cart.setCodeArt(Integer.parseInt(this.codeArt));
        fn.insertInCart(cart);
        setMessage("success");
        return "success";
    }
    public String deletFromCart(){
        Functtions fn=ContextProvider.provideContext().getBean("stDao",Functtions.class);
        HttpSession session = ServletActionContext.getRequest().getSession();
        int res=  fn.deletFromCart(Integer.parseInt(this.codeArt),(String) session.getAttribute("loggedInUser"));
        if (res!=0){
            setMessage("success");

        }else {
            setMessage("error");
        }
        return "success";
    }



}
