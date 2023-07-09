<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:f="http://java.sun.com/jsf/core"
    xmlns:h="http://java.sun.com/jsf/html" version="2.0">
    <jsp:directive.page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
    <jsp:text><![CDATA[ <?xml version="1.0" encoding="UTF-8" ?> ]]></jsp:text>
    <jsp:text><![CDATA[ <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> ]]></jsp:text>
    <html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="../css/accueil.css" /> 
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
    
    </head>
    <body>
        <f:view>
            <div class="form-box">
                <h1><i class="fas fa-user-shield"></i></h1>
                <h:form id="loginForm">
                    <h:outputText value="Access Code" /><br/>
                    <br/>
                    <h:inputSecret id="code" value="#{acces.code}" required="true" />
                    <br/><br/>
                    <h:commandButton value="Login" action="#{acces.loginUser}" />
                    
                </h:form>
                <br/>
                <br/>
                <br/>
                <H3>Wellcome in Login Page</H3>
            </div>
        </f:view>
    </body>
    </html>
</jsp:root>
