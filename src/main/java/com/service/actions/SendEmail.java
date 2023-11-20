package com.service.actions;

import com.opensymphony.xwork2.ActionSupport;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail {

    //SETUP MAIL SERVER PROPERTIES
    //DRAFT AN EMAIL
    //SEND EMAIL
    static Session newSession = null;
    static MimeMessage mimeMessage = null;
    public  void sand(File invoice , String email,String username) throws AddressException, MessagingException, IOException
    {

          setupServerProperties();
        draftEmail(invoice,email,username);
        sendEmail();
    }

    private static void sendEmail() throws MessagingException {
        String fromUser = "hm01.oussama@gmail.com";  //Enter sender email id
        String fromUserPassword = "h f j u sofzlt u acmup";  //Enter sender gmail password , this will be authenticated by gmail smtp server
        String emailHost = "smtp.gmail.com";
        Transport transport = newSession.getTransport("smtp");
        transport.connect(emailHost, fromUser, fromUserPassword);
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();
        System.out.println("Email successfully sent!!!");
    }

    private static MimeMessage draftEmail(File invoice , String email ,String username ) throws AddressException, MessagingException, IOException {
        String emailSubject = "Ray-Run Invoice";
        String emailBody = "Dear "+username+",\n";
        emailBody+="I hope this email finds you well.\n" +
                "We would like to extend our gratitude for your continuedsupport as our valued client.\n" +
                "As requested, please find attached the invoice \n";
        emailBody+="Best regards,\n";
        emailBody+="Ray-Run Team\n";
        mimeMessage = new MimeMessage(newSession);
        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

        mimeMessage.setSubject(emailSubject);

        // CREATE MIMEMESSAGE
        // CREATE MESSAGE BODY PARTS
        // CREATE MESSAGE MULTIPART
        // ADD MESSAGE BODY PARTS ----> MULTIPART
        // FINALLY ADD MULTIPART TO MESSAGECONTENT i.e. mimeMessage object


        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(emailBody,"text/plain");

        MimeBodyPart attachmentBodyPart = new MimeBodyPart();
        attachmentBodyPart.attachFile(invoice);

        MimeMultipart multiPart = new MimeMultipart();
        multiPart.addBodyPart(bodyPart);
        multiPart.addBodyPart(attachmentBodyPart);
        mimeMessage.setContent(multiPart);
        return mimeMessage;
    }

    private static void setupServerProperties() {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        newSession = Session.getDefaultInstance(properties,null);
    }
}
