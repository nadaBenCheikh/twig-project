package controllers;

import entities.jointureTable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class passerTestController implements Initializable{

    @FXML
    private TextField question;

    @FXML
    private TextField booneRep;

    @FXML
    private Label testName;
      @FXML
    private Button valid;
        @FXML
    void validerRep(ActionEvent event) {
        
        jointureTable f = null;
        if(booneRep.getText()==f.getBonneRep())
        {
            JOptionPane.showMessageDialog(null, "bonne réponse");
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
      public void detail (jointureTable e)
    {
        
        testName.setText(e.getNom());
         question.setText(e.getQuestion());
       booneRep.getText();
       
       
    }
    }
    


