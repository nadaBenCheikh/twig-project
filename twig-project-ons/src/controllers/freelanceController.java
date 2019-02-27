package controllers;

import entite.users;

import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import service.UserServices;



public class freelanceController {

    @FXML
    private TextField picturePath;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private PasswordField password;

    @FXML
    private TextField phone;

    @FXML
    private Pane pnlOverview;

    @FXML
    private TextField description;

    @FXML
    private Button Sign;
     @FXML
    private Button uploadimg;

    @FXML
    private TextField region;
  

    @FXML
    private TextField email;
    private Object FilePath;

 @FXML
    void sign(ActionEvent event) throws IOException {
      
            UserServices us=new UserServices();
            String s="freelancer";
            us.insert(new users(firstName.getText(),lastName.getText(),email.getText(),password.getText(),s,Integer.parseInt(phone.getText()),region.getText(),description.getText(),picturePath.getText()));
            System.out.println("ajout reussi");
            
            /*send maill
            try {
                    String host = "smtp.gmail.com";
                    String userM = "ons.mtar@esprit.tn";
                    String pass = "183JFT1359";
                
                    String to = email.getText();
                    String from = userM;
                    String subject = " welcome for new user ";//objet
                    String messageText = "welcome "+firstName.getText()+" "+lastName.getText();//contenu
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
                    msg.setSubject(subject);
                    msg.setSentDate(new Date());
                    msg.setText(messageText);

                    Transport transport = mailSession.getTransport("smtp");
                    transport.connect(host, userM, pass);
                    transport.sendMessage(msg, msg.getAllRecipients());
                    transport.close();
                    System.out.println("message send successfully");
                } catch (Exception ex) {
                    System.out.println(ex);
                }*/
        Stage primaryStage=new Stage();
        Parent root= FXMLLoader.load(getClass().getResource("../Fxml/mainPane_4.fxml"));
        Scene scene = new Scene(root);
        System.out.println("sign in"); 
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
//      }

    }
        @FXML
    void uploadImage(ActionEvent event) {
         FileChooser fileChooser = new FileChooser();
//        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (.jpeg)", ".jpeg");
//        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (.png)", ".png");
//        fileChooser.getExtensionFilters().addAll(extFilterJPG,extFilterPNG);
        File file = fileChooser.showOpenDialog(null);
        System.out.println("file "+ file);
        picturePath.setText(file.getName());
        Image img = new Image("http://localhost/images/" + file.getName());
//      ImageUp.imageProperty().set(img);//img view

    }
    
 

    }


