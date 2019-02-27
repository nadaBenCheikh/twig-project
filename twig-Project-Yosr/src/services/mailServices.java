/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.users;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author user
 */
public class mailServices {
    
     public void sendMail( String receiverMailAddress /*, String friendName*/)
        {
            
        
        try{
            String host ="smtp.gmail.com" ;
            String user = "chater.yosr@gmail.com";
            String pass = "YosrEsprit2018";
            String to = receiverMailAddress; // adresse mail destinataire
            String from = "Yosr";
            String subject = "You have been recommanded to a task";
             String messageText = "Your friend  recommanded a task for you, Check your profile to see more details about the task if you want to confim it.";
           // String messageText = "Your friend " + friendName + "recommanded a task for you, Check your profile to see more details about the task if you want to confim it.";
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(messageText);

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("email sent successfully");
        }catch(Exception ex)
        {
            System.out.println(ex);
        }
        
        }
    
}
