package controllers;

import static controllers.loginController.userConnect;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

import service.UserServices;

public class afficherprofilController implements Initializable{

    @FXML
    private Button btnPROFESSIONAL;
    @FXML
    private Pane pnlOrders;
    @FXML
    private Button btnSignout;
    @FXML
    private Button btnGENERAL;
    @FXML
    private Pane pnlCustomer;
    @FXML
    private Button btndesactivate;
    @FXML
    private ImageView imageProfil;
    @FXML
    private Label nomUser;
     @FXML
    private Button btnout;
    
    UserServices us =new UserServices();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomUser.setText(userConnect.getFirstName()+" "+ userConnect.getLastName());
        Image img = new Image("http://localhost/images/" + userConnect.getPicturePath());
        imageProfil.imageProperty().set(img);
        System.out.println("user ====> " + userConnect.getPicturePath() + "  "+ userConnect.getFirstName());
        if("donneur d'ordre".equals(userConnect.getRole())){
            btnPROFESSIONAL.visibleProperty().set(false);
        }
    }  
      
    @FXML
    void GENERALINFORMATION(ActionEvent event) throws IOException {
        Parent piParent = FXMLLoader.load(getClass().getResource("../Fxml/affichegeneral_1.fxml"));
        Scene piScene = new Scene(piParent);//profess info
        Stage piStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        piStage.setScene(piScene);
        piStage.show();

    }

   

    @FXML
    void PROFESSIONALINFORMATION(ActionEvent event) throws IOException {
        Parent piParent = FXMLLoader.load(getClass().getResource("../Fxml/afficheprof_1.fxml"));
        Scene piScene = new Scene(piParent);//profess info
        Stage piStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        piStage.setScene(piScene);
        piStage.show();
    }
    
    @FXML
    void CHANGEPASSWORD(ActionEvent event) throws IOException {
        Parent piParent = FXMLLoader.load(getClass().getResource("../Fxml/changepassword_1.fxml"));
        Scene piScene = new Scene(piParent);
        Stage piStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        piStage.setScene(piScene);
        piStage.show();
    }
    
    @FXML
    void desactiver(ActionEvent event) throws IOException {
        int retour = JOptionPane.showConfirmDialog(null,"Are you sure that you want to desactive your account", 
            "information",JOptionPane.OK_CANCEL_OPTION);
        if(retour == 0){
            us.updatestate(userConnect.getEmail());
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Fxml/mainPane_4.fxml"));
            Parent HomeParent = fxmlLoader.load();
            Scene HomeScene = new Scene(HomeParent);
            Stage Home = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Home.setScene(HomeScene);
            Home.show();
        }
        
    }
    
    @FXML
    void Signout(ActionEvent event) throws IOException {
        JOptionPane.showMessageDialog(null, "you are deconnected !","erreur",JOptionPane.ERROR_MESSAGE);
        System.out.println("you are deconnected");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Fxml/mainPane_4.fxml"));
        Parent HomeParent = fxmlLoader.load();
        Scene HomeScene = new Scene(HomeParent);
        Stage Home = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Home.setScene(HomeScene);
        Home.show();
    }
}
