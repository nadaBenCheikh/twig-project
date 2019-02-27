package controllers;

import entities.event;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class detailEventController implements Initializable{

    @FXML
    private TextField txt_titre;

  

    @FXML
    private TextField txt_tadresse;

    @FXML
    private Pane pnlOverview;

    @FXML
    private TextField txt_category;

    @FXML
    private Button ajout;

    @FXML
    private TextArea txt_desc;
        @FXML
    private ImageView image;


    @FXML
    void ajouterTest(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
     
       
    }
  public void detail (event e)
    { 
        String i ;
 txt_titre.setText(e.getTitre());
 txt_desc.setText(e.getDescription());
  txt_tadresse.setText(e.getAdresse());
  txt_category.setText(e.getCategory());
  //Image img = new Image("http://localhost/image/" + e.getImage()); 
 // image.setImage(img);  
   image = new ImageView(new Image(e.getImage())); 

    
  
  
       
     
        
        
   
}
}
