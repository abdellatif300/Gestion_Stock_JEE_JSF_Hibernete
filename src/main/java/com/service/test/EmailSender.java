package com.service.test;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

public class EmailSender {
    public static void sendEmailWithAttachment(String recipientEmail, String subject, String message, String attachmentFilePath) {
        // SMTP server configuration
        String host = "localhost"; // FakeSMTP server host
        int port = 25; // FakeSMTP server port
        String username = "hammouchama.01@gmail.com";
        String password = "oussama2001";

        // Sender and recipient email addresses
        String senderEmail = "thumb.loop@gmail.com";

        // Create properties for the SMTP session
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Create a session with authentication
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a new message
            Message emailMessage = new MimeMessage(session);

            // Set the sender and recipient addresses
            emailMessage.setFrom(new InternetAddress(senderEmail));
            emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));

            // Set the email subject
            emailMessage.setSubject(subject);

            // Create the message body
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(message);

            // Create the attachment
            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(attachmentFilePath);
            attachmentBodyPart.setDataHandler(new DataHandler(source));
            attachmentBodyPart.setFileName(source.getName());

            // Create a multipart message to combine the body and attachment
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentBodyPart);

            // Set the content of the message to be the multipart message
            emailMessage.setContent(multipart);

            // Send the email
            Transport.send(emailMessage);

            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String recipientEmail = "hm01.oussama@gmail.com";
        String subject = "Email with PDF Attachment";
        String message = "Hello,\n\nPlease find the attached PDF file.";

        String pdfFilePath = "generated.pdf";

        sendEmailWithAttachment(recipientEmail, subject, message, pdfFilePath);
    }
}
