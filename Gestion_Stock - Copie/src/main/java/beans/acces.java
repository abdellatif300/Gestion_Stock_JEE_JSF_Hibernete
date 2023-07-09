package beans;

import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class acces {
	private String code;
	private boolean loggedIn;

	//function loginUser
	public String loginUser() {
	    if ("abdellatif2022".equals(code)) {
	        loggedIn = true;
	        FacesContext facesContext = FacesContext.getCurrentInstance();
	        ExternalContext externalContext = facesContext.getExternalContext();
	        HttpSession session = (HttpSession) externalContext.getSession(true);
	        session.setAttribute("code", code);
	        return "success";
	    } else {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
	                "Code d'accès incorrect", "Veuillez entrer un code d'accès valide"));
	        return "failure";
	    }
	}

	//geterse et seterse

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}
}