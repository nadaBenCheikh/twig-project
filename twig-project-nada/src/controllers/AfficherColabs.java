package controllers;

import entities.ColabsJoinProject;
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
import javax.swing.JOptionPane;
import services.ColabsService;
import services.SendMail;

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
    private Button retour;
    
    ObservableList<ColabsJoinProject> ob;

    @FXML
    void jobOfferMailing(ActionEvent event) {
        ColabsJoinProject c=new ColabsJoinProject();
        c= tableview.getSelectionModel().getSelectedItem();
        System.out.println(c);
        String letter="Dear "+c.getFirstName()+" "+c.getLastName()+"\nOur company is pleased to offer you the position of Assistant Director, Customer Relations. Your skills and experience will be an ideal fit for our customer service department. As we discussed, your starting date will be February 1, 20XX. The starting salary is $48,000 per year and is paid on a weekly basis. Direct deposit is available Full family medical coverage will be provided through our company's employee benefit plan and will be effective on March 1. Dental and optical insurance are also available. ABCD offers a flexible paid time-off plan which includes vacation, personal, and sick leave. Time off accrues at the rate of one day per month for your first year, then increases based on your tenure with the company. Eligibility for the company retirement plan begins 90 days after your start date.If you choose to accept this job offer, please sign the second copy of this letter and return it to me at your earliest convenience. When your acknowledgment is received, we will send you employee benefit enrollment forms and an employee handbook which details our benefit plans and retirement plan. We look forward to welcoming you to the ABCD team Please let me know if you have any questions or I can provide any additional information Sincerely";
        SendMail s=new SendMail(c.getMail(), "Job Offer", letter);
        JOptionPane.showMessageDialog(null, "an email will be sent to inform him", null,JOptionPane.DEFAULT_OPTION);
    }

    @FXML
    void firedUpDelete(ActionEvent event) {
        int reply=JOptionPane.showConfirmDialog(null, "send an email", "Employee warning notice email", JOptionPane.YES_NO_OPTION);
        if(reply==JOptionPane.YES_OPTION){
            ColabsJoinProject c=new ColabsJoinProject();
            c= tableview.getSelectionModel().getSelectedItem();
            String letter="Dear "+c.getFirstName()+" "+c.getLastName()+"\n As we’ve recently discussed, We take [attendance at work] seriously and we expect all our employees to [comply with our company’s policy regarding time off]. \nThis is your [first] warning notice. We expect you to correct your behavior and [request time off in advance and in a formal way (e.g. via email to your manager or through our HRIS.)] Otherwise, we will have to take further disciplinary action, up to and including termination.";
            SendMail s=new SendMail(c.getMail(), "Employee warning notice email", letter);

            int x=c.getId();
            System.out.println(c);
            ColabsService cservice=new ColabsService();
            cservice.updateState(x);
            JOptionPane.showMessageDialog(null, "an email is sent to inform him", null,JOptionPane.DEFAULT_OPTION);
            ob.clear();
            tableview.setItems(getObservableListeToReload()); 
        } 
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ColabsService cservice=new ColabsService();
        ArrayList<ColabsJoinProject> list= (ArrayList<ColabsJoinProject>) cservice.displayColabs(2);
        ob=FXCollections.observableArrayList(list);
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
        ob=FXCollections.observableArrayList(list);
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
        return ob;
    }


}
