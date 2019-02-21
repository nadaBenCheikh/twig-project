package controllers;

import entities.ColabsJoinProject;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;
import services.ColabsService;

public class AfficherColabs implements Initializable{

    @FXML
    private TableColumn<ColabsJoinProject, String> lastName;

    @FXML
    private TableColumn<ColabsJoinProject, String> mail;

    @FXML
    private TableColumn<ColabsJoinProject, String> languages;

    @FXML
    private TableColumn<ColabsJoinProject, String> titleP;

    @FXML
    private Pane pnlOverview;

    @FXML
    private TableColumn<ColabsJoinProject, Integer> idF;

    @FXML
    private MenuItem jobOffer;

    @FXML
    private TableColumn<ColabsJoinProject, String> titleT;

    @FXML
    private Button delete;

    @FXML
    private TableColumn<ColabsJoinProject, String> firstName;

    @FXML
    private TableColumn<ColabsJoinProject, Integer> idP;

    @FXML
    private MenuItem firedUp;

    @FXML
    private TableColumn<ColabsJoinProject, Integer> idT;

    @FXML
    private TableColumn<ColabsJoinProject, Date> terminationDtae;

    @FXML
    private TableView<ColabsJoinProject> tableview;

    @FXML
    private TableColumn<ColabsJoinProject, Integer> id;

    @FXML
    private TableColumn<ColabsJoinProject, String> state;

    @FXML
    void jobOfferMailing(ActionEvent event) {
        ColabsJoinProject c=new ColabsJoinProject();
        c= tableview.getSelectionModel().getSelectedItem();
        System.out.println(c);
        //lui envoyer un maillll
    }

    @FXML
    void firedUpDelete(ActionEvent event) {
        int reply=JOptionPane.showConfirmDialog(null, "Are you sure to ignore this offer", "Delete project", JOptionPane.YES_NO_OPTION);
        if(reply==JOptionPane.YES_OPTION){
            ColabsJoinProject c=new ColabsJoinProject();
            c= tableview.getSelectionModel().getSelectedItem();
            int x=c.getId();
            System.out.println(c);
            ColabsService cservice=new ColabsService();
            cservice.updateState(x);
            JOptionPane.showMessageDialog(null, "an email will be sent to inform him", null,JOptionPane.DEFAULT_OPTION);
            tableview.setItems(getObservableListeToReload()); 
        } 
    }

    @FXML
    void supprimer(ActionEvent event) {
        int reply=JOptionPane.showConfirmDialog(null, "Are you sure to ignore this offer", "Delete project", JOptionPane.YES_NO_OPTION);
        if(reply==JOptionPane.YES_OPTION){
            ColabsJoinProject c=new ColabsJoinProject();
            c= tableview.getSelectionModel().getSelectedItem();
            System.out.println(c);
            ColabsService cservice=new ColabsService();
            cservice.delete(c.getId());
            tableview.setItems(getObservableListeToReload()); 
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ColabsService cservice=new ColabsService();
        ArrayList<ColabsJoinProject> list= (ArrayList<ColabsJoinProject>) cservice.displayColabs(2);
        ObservableList ob=FXCollections.observableArrayList(list);
        id.setCellValueFactory(new PropertyValueFactory("id"));
        idP.setCellValueFactory(new PropertyValueFactory("idP"));
        titleP.setCellValueFactory(new PropertyValueFactory("titleP"));
        terminationDtae.setCellValueFactory(new PropertyValueFactory("terminationDtae"));
        idT.setCellValueFactory(new PropertyValueFactory("idT"));
        titleT.setCellValueFactory(new PropertyValueFactory("titleT"));
        firstName.setCellValueFactory(new PropertyValueFactory("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory("lastName"));
        mail.setCellValueFactory(new PropertyValueFactory("mail"));
        idF.setCellValueFactory(new PropertyValueFactory("idF"));
        languages.setCellValueFactory(new PropertyValueFactory("languages"));
        state.setCellValueFactory(new PropertyValueFactory("state"));
        tableview.setItems(ob);
        
    }
    
    public ObservableList<ColabsJoinProject> getObservableListeToReload(){
        ColabsService cservice=new ColabsService();
        ArrayList<ColabsJoinProject> list= (ArrayList<ColabsJoinProject>) cservice.displayColabs(2);
        ObservableList ob=FXCollections.observableArrayList(list);
        return ob;
    }


}
