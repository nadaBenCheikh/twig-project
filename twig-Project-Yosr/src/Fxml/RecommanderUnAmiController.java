/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fxml;

import entities.Friends;
import entities.users;
import java.awt.Color;
import java.awt.Paint;
import java.net.URL;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import services.FriendsService;
import services.UserServices;
import services.mailServices;

/**
 * FXML Controller class
 *
 * @author user
 */
public class RecommanderUnAmiController implements Initializable {

    @FXML
    private VBox amisVB;
    @FXML
    private TextField searchName;
    @FXML
    private Button search_Btn;
    @FXML
    private CheckBox is_coworker;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        FriendsService fs = new FriendsService();
        List<users> us=fs.getFriendsById(2); // id user seesion!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        Iterator iterator = us.iterator();
        HBox hbu;
         
        for (int i = 0; i < us.size(); i++) {
            hbu= new HBox(10);
               hbu.setSpacing(20); // espace horizontal entre deux images
            for (int j = 0; j < 3; j++) {
                if(iterator.hasNext())
                {hbu.getChildren().add(createVBAmie((users) iterator.next()));    
                }
            }
            amisVB.getChildren().add(hbu);
            
            
        }
        
        
        // TODO
    }
    
    public VBox createVBAmie(users f){
        mailServices off = new mailServices();
        VBox vbFriends = new VBox();
        vbFriends.setStyle("background-color : #ffffff; padding-right: 0px");
        vbFriends.setSpacing(10);
        ImageView img = new ImageView(new Image(f.getPicturePath())); //f.getPicturePath()
        //http://localhost/pi/image/f.getPicturePath()
        img.setPreserveRatio(false);
        //img.setX(100);
        //img.setY(100);
        img.setFitHeight(220);
        img.setFitWidth(170);
        Label nomJ = new Label(f.getLastName()+" "+f.getFirstName());
        nomJ.setFont(Font.font("Amble CN", FontWeight.BOLD, 20));
        Label description = new Label(f.getDescription());
        description.setFont(Font.font("Amble CN", FontWeight.BOLD, 15));
        
        //  Label nomJ1 = new Label(f.getEmail());
       
        
        //HBox hbnote = new HBox();
        //FriendsService js = new FriendsService();
        //double rate=js.getNoteJardinier(j);
        
        //ArrayList<FontAwesomeIconView> note = new ArrayList<>();
        //FontAwesomeIconView fullstar =new FontAwesomeIconView(FontAwesomeIcon.STAR_HALF_EMPTY);
        //FontAwesomeIconView empstar =new FontAwesomeIconView(FontAwesomeIcon.STAR_HALF_EMPTY);
        //FontAwesomeIconView halfstar =new FontAwesomeIconView(FontAwesomeIcon.STAR_HALF_EMPTY);
        //fullstar.setStyle("color:gold");
        //halfstar.setStyle("color:gold");
       // note.add(new FontAwesomeIconView(FontAwesomeIcon.STAR_HALF_EMPTY));
        //hbnote.getChildren().addAll(note);
        Button recommander = new Button("recommander");
       
        recommander.setStyle("-fx-background-color: #FF4500; -fx-text-fill: #000000; -fx-font-size: 15;");
     
      // final String receiverMailAdress="";
    
        
        recommander.setOnAction((event) -> {
            
            System.out.println(f.getLastName());
             System.out.println(f.getFirstName());
            System.out.println( "sending email to: " + f.getEmail());
   
            off.sendMail(f.getEmail()); // recupere ID user Connecté SESSION!!!!
            // ay code de mail ...
        });
        //for(int i=0; i<rate%1; i++) note.add(fullstar);
        //if(rate%1!=0) note.add(empstar);
        //for(int i=0; i<rate%1+4; i++) note.add(fullstar);
        vbFriends.getChildren().add(img);
        vbFriends.getChildren().add(nomJ);
        vbFriends.getChildren().add(description);
       
        //vbFriends.getChildren().add(hbnote);
        vbFriends.getChildren().add(recommander);
        
     
        
        return vbFriends;
        
    }

    @FXML
    private void filterResults(ActionEvent event) {
        
         amisVB.getChildren().clear();
        Boolean isCowr = is_coworker.selectedProperty().get();

        
        String Name = "";
        Name = searchName.getText();
       
     
        //Constructin de la requette 
        String requestPart = "";
         if (isCowr) {
           requestPart = requestPart + " AND coworker=1";
        };
        
        if (!"".equals(Name)) {
            requestPart = requestPart + " and firstName Like '%" + Name + "%'"+ " or lastName Like '%" + Name + "%'";
        };
      


        try {
            List<users> list = new FriendsService().getAllFriendsByFilter(requestPart,2);

            System.out.println(list);
        Iterator iterator = list.iterator();
        HBox hbu;
        for (int i = 0; i < list.size()/3+1; i++) {
            hbu= new HBox(10);
            for (int j = 0; j < 3; j++) {
                if(iterator.hasNext())hbu.getChildren().add(createVBAmie((users) iterator.next()));  
                 hbu.setSpacing(20); 
                
            }
            amisVB.getChildren().add(hbu);
            
        }
           
           
           
           
           
           
           
        } catch (SQLException ex) {
            Logger.getLogger(AddFriendsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
        
        
    }
    
