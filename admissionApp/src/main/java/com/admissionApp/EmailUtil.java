/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admissionApp;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.activation.DataHandler;

/**
 *
 * @author D
 */
public class EmailUtil {
    
    public static void main(String email) throws Exception {
   // Set up email account credentials
      String host = "smtp.gmail.com";
      String username = "umurerwaalice240@gmail.com";
      String password = "alice@12345";
      
      // Set up email message properties
      String to = email;
      String from = "your_email@gmail.com";
      String subject = "Test email";
      String body = "Test JavaMail API.";

      // Set up email session properties
      Properties props = new Properties();
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.port", "587");

      // Create a Session object
      Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username, password);
            }
         });

      try {
         // Create a message object and set its properties
         Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress(from));
         message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(to));
         message.setSubject("Registration is successfull your information is being processed");
         message.setText(body);

         // Send the email message
         Transport.send(message);

         System.out.println("Email sent successfully!");
      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
    }
}
