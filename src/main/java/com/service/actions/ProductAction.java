package com.service.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

public class ProductAction extends ActionSupport {

    private String category;

    public ProductAction() {
        super();
    }

    public ProductAction(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String selectCategory(){
        HttpSession session = ServletActionContext.getRequest().getSession();
        if (session.getAttribute("loggedInUser")==null){
            return "error";
        }
        return "success";
    }
}
