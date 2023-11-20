package com.service.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.service.Entitys.User;
import com.service.dao.Functtions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class LoginAction extends ActionSupport{
	private String username, password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute(){
		Functtions fn=ContextProvider.provideContext().getBean("stDao",Functtions.class);
		if(this.username.isEmpty()|| this.password.isEmpty()) {
			addActionError("All fields must be filled in");
			return "error";
		}else {
			User user=fn.getUserByName(this.username);
			if((user==null)||!(user.getPass().equals(this.password)) ) {
				addActionError("Password incorrect");
				return "error";
			}else{

				HttpServletRequest request = ServletActionContext.getRequest();
				HttpSession session = request.getSession();
				session.setAttribute("loggedInUser",this.username);
				//Functtions allArt = (Functtions) ContextProvider.provideContext().getBean("stDao");

				return "success";
			}
		}
	}
	public String logOut(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.invalidate();
		return "success";
	}
	
}
