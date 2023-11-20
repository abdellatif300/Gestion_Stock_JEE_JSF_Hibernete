package com.service.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.service.dao.Functtions;
import com.service.Entitys.User;
public class SignUp extends ActionSupport {
   
	private String username;
	private String email;
	private String password;
	private String cPassword;
	
	public SignUp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SignUp(String username, String email, String password, String cPassword) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.cPassword = cPassword;
	}
	public String executeSignUp() throws Exception {
		if((this.username.isEmpty())||( this.password.isEmpty())||(this.email.isEmpty())||(this.cPassword.isEmpty())) {
			addActionError("All fields must be filled in");
			return "error";
		}else if (!password.equals(this.cPassword)) {
				addActionError("The password confirmation does not match");
				return "error";
			}else {
				Functtions fn=ContextProvider.provideContext().getBean("stDao",Functtions.class);
				if (fn.getUserByName(this.username)!=null) {
					addActionError("The username has already been taken");
					return "error";
				}else {
					User user=ContextProvider.provideContext().getBean("user",User.class);
					user.setLogin(this.username);
					user.setEmail(this.email);
					user.setPass(this.password);
					fn.addUser(user);
					return "success";
				}
			}
		
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

	public String getcPassword() {
		return cPassword;
	}

	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}

}
