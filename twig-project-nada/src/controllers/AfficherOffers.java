package controllers;

import entities.OfferJoinCollab;
import entities.Offers;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import services.OffersService;


public class AfficherOffers implements Initializable{
    boolean verif=false;
    
    @FXML
    private TableColumn<OfferJoinCollab, Date> terminationDateP;

    @FXML
    private TableColumn<OfferJoinCollab, String> lastName;

    @FXML
    private TableColumn<OfferJoinCollab, String> categoryP;

    @FXML
    private TableColumn<OfferJoinCollab, Integer> minHourlyFeeF;

    @FXML
    private TableColumn<OfferJoinCollab, String> titleP;

    @FXML
    private Pane pnlOverview;

    @FXML
    private TableColumn<OfferJoinCollab, String> titleT;

    @FXML
    private TableColumn<OfferJoinCollab, String> languagesF;

    @FXML
    private Button confirm;

    @FXML
    private TableColumn<OfferJoinCollab, String> firstName;

    @FXML
    private TableColumn<OfferJoinCollab, Integer> freelancerId;

    @FXML
    private TableColumn<OfferJoinCollab, Integer> maxHourlyFeeF;

    @FXML
    private Button ignore;

    @FXML
    private TableColumn<OfferJoinCollab, String> motivationalLetterO;

    @FXML
    private TableView<OfferJoinCollab> tableview;

    @FXML
    private TableColumn<OfferJoinCollab, Integer> id;

    @FXML
    private TableColumn<OfferJoinCollab, Date> offerDateO;

    @FXML
    private TableColumn<OfferJoinCollab, String> cvLinkF;

    @FXML
    private TableColumn<OfferJoinCollab, Integer> bidO;

    @FXML
    private TableColumn<OfferJoinCollab, Integer> projectId;

    @FXML
    private TableColumn<OfferJoinCollab, Integer> taskId;

    @FXML
    private TableColumn<OfferJoinCollab, String> email;

    @FXML
    private TableColumn<OfferJoinCollab, Integer> durationO;
    
    @FXML
    private TableColumn<OfferJoinCollab, String> picturePath;
    
    @FXML
    private MenuItem txtDetail;

    @FXML
    private Button retour;
    
    ObservableList<OfferJoinCollab> ob;

    @FXML
    void confirmer(ActionEvent event) {       
        OfferJoinCollab o=new OfferJoinCollab();
        o= tableview.getSelectionModel().getSelectedItem();
        OffersService oservice=new OffersService();
        if(o.getTaskId()==0){
            oservice.isert(new Offers(null,o.getProjectId(),o.getFreelancerId(),o.getId()));
            System.out.println("c bon sans tache");
            verif=true;
        }
        else{
            oservice.isert(new Offers(o.getTaskId(),o.getProjectId(),o.getFreelancerId(),o.getId()));
            System.out.println("c bon avec tache");
            verif=true;
        }
        if(verif==true){
            JOptionPane.showMessageDialog(null, "Offer is confirmed and a colabs is added successfully", null, JOptionPane.DEFAULT_OPTION);
            ob.clear();
            tableview.setItems(getObservableListeToReload());
        }
    }
    
    @FXML
    private void ignorer(ActionEvent event) {
       int reply=JOptionPane.showConfirmDialog(null, "Are you sure to ignore this offer", "Delete project", JOptionPane.YES_NO_OPTION);
        if(reply==JOptionPane.YES_OPTION){
            OfferJoinCollab o=new OfferJoinCollab();
            o= tableview.getSelectionModel().getSelectedItem();
            System.out.println(o);
            OffersService oservice=new OffersService();
            oservice.delete(o.getId());
            ob.clear();
            tableview.setItems(getObservableListeToReload()); 
        }
    }
    
    @FXML
    void voirdetail(ActionEvent event) {
        OfferJoinCollab o=tableview.getSelectionModel().getSelectedItem();
        Popup2.displayOffer(o);        
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        OffersService oservice= new OffersService();
        ArrayList<OfferJoinCollab> list=(ArrayList<OfferJoinCollab>) oservice.displayOffer(2);
        ob= FXCollections.observableArrayList(list);
        id.setCellValueFactory(new PropertyValueFactory("id"));
        projectId.setCellValueFactory(new PropertyValueFactory("projectId"));
        titleP.setCellValueFactory(new PropertyValueFactory("titleP"));
        terminationDateP.setCellValueFactory(new PropertyValueFactory("terminationDateP"));
        categoryP.setCellValueFactory(new PropertyValueFactory("categoryP"));
        taskId.setCellValueFactory(new PropertyValueFactory("taskId"));
        titleT.setCellValueFactory(new PropertyValueFactory("titleT"));
        firstName.setCellValueFactory(new PropertyValueFactory("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory("lastName"));
        email.setCellValueFactory(new PropertyValueFactory("email"));
        freelancerId.setCellValueFactory(new PropertyValueFactory("freelancerId"));
        languagesF.setCellValueFactory(new PropertyValueFactory("languagesF"));
        minHourlyFeeF.setCellValueFactory(new PropertyValueFactory("minHourlyFeeF"));
        maxHourlyFeeF.setCellValueFactory(new PropertyValueFactory("maxHourlyFeeF"));
        cvLinkF.setCellValueFactory(new PropertyValueFactory("cvLinkF"));
        bidO.setCellValueFactory(new PropertyValueFactory("bidO"));
        durationO.setCellValueFactory(new PropertyValueFactory("durationO"));
        offerDateO.setCellValueFactory(new PropertyValueFactory("offerDateO"));
        motivationalLetterO.setCellValueFactory(new PropertyValueFactory("motivationalLetterO"));
        picturePath.setCellValueFactory(new PropertyValueFactory("picturePath"));
        tableview.setItems(ob);
        
       
    }
    
    public ObservableList<OfferJoinCollab> getObservableListeToReload(){
        OffersService oservice= new OffersService();
        ArrayList<OfferJoinCollab> list=(ArrayList<OfferJoinCollab>) oservice.displayOffer(2);
        ob= FXCollections.observableArrayList(list);
        id.setCellValueFactory(new PropertyValueFactory("id"));
        projectId.setCellValueFactory(new PropertyValueFactory("projectId"));
        titleP.setCellValueFactory(new PropertyValueFactory("titleP"));
        terminationDateP.setCellValueFactory(new PropertyValueFactory("terminationDateP"));
        categoryP.setCellValueFactory(new PropertyValueFactory("categoryP"));
        taskId.setCellValueFactory(new PropertyValueFactory("taskId"));
        titleT.setCellValueFactory(new PropertyValueFactory("titleT"));
        firstName.setCellValueFactory(new PropertyValueFactory("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory("lastName"));
        email.setCellValueFactory(new PropertyValueFactory("email"));
        freelancerId.setCellValueFactory(new PropertyValueFactory("freelancerId"));
        languagesF.setCellValueFactory(new PropertyValueFactory("languagesF"));
        minHourlyFeeF.setCellValueFactory(new PropertyValueFactory("minHourlyFeeF"));
        maxHourlyFeeF.setCellValueFactory(new PropertyValueFactory("maxHourlyFeeF"));
        cvLinkF.setCellValueFactory(new PropertyValueFactory("cvLinkF"));
        bidO.setCellValueFactory(new PropertyValueFactory("bidO"));
        durationO.setCellValueFactory(new PropertyValueFactory("durationO"));
        offerDateO.setCellValueFactory(new PropertyValueFactory("offerDateO"));
        motivationalLetterO.setCellValueFactory(new PropertyValueFactory("motivationalLetterO"));
        picturePath.setCellValueFactory(new PropertyValueFactory("picturePath"));
        return ob;
    }

}
