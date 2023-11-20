package com.service.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.service.Entitys.User;
import com.service.dao.Functtions;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UpdateInfo extends ActionSupport {
    private int id;
    //new Name
    private String username;
    //name actual
    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String password;
    private String newPassword;
    private String cnewPassword;

    public UpdateInfo() {
    }

    public UpdateInfo(int id, String username, String email, String password, String newPassword, String cnewPassword) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.newPassword = newPassword;
        this.cnewPassword = cnewPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getCnewPassword() {
        return cnewPassword;
    }

    public void setCnewPassword(String cnewPassword) {
        this.cnewPassword = cnewPassword;
    }

    public String update(){
        if((this.username.isEmpty())||( this.password.isEmpty())||(this.email.isEmpty())||(this.newPassword.isEmpty())||(this.cnewPassword.isEmpty())) {
            addActionError("All fields must be filled in");
            return "error";
        }else if (!newPassword.equals(this.cnewPassword)) {
            addActionError("The password confirmation does not match");
            return "error";
        }else {
            Functtions fn=ContextProvider.provideContext().getBean("stDao",Functtions.class);
            if ((!this.name.equals(this.username))&&(fn.getUserByName(this.username)!=null)) {
                addActionError("The username has already been taken");
                return "error";
            }else if(!fn.getUserByName(this.name).getPass().equals(this.password)) {
                addActionError("password is incorrect");
                return "error";
            }else {

                User user=ContextProvider.provideContext().getBean("user",User.class);
                user.setLogin(this.username);
                user.setEmail(this.email);
                user.setPass(this.newPassword);
                fn.updateUser(user,this.id);
                HttpServletRequest request = ServletActionContext.getRequest();
                HttpSession session = request.getSession();
                session.setAttribute("loggedInUser",this.username);
                return "success";
            }
        }
    }
}
