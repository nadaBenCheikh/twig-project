package controllers;

import entities.questions;
import javafx.collections.FXCollections;
import entities.test;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;

import service.questionServ;

import service.testServ;

public class questionControlleur {
  testServ pservice=new testServ();
        ArrayList <test> list=(ArrayList <test>) pservice.getNomId();
        
        Map<String, Integer> op=list.stream().collect(Collectors.toMap(test::getNom, test::getId, (a,b)->a+b));
        ObservableList<String> options=FXCollections.observableArrayList(op.keySet());
    

    @FXML
    private Button add;

    @FXML
    private TextField txt_question;

    @FXML
    private TextField txt_correct;

    @FXML
    private Pane pnlOverview;

    @FXML
    private Text txt_id;

    @FXML
    private ComboBox comboboxQues;
        @FXML

    
  private void initialize(){
        comboboxQues.setItems(options);
    }
   

    @FXML
    void ajouterQuestion(ActionEvent event) {
        
  questionServ pser=new questionServ();
   String c= (String) comboboxQues.getValue();
   System.out.println(c);
        System.out.println(c);
        int s=op.get(c);
        System.out.println(s);
         System.out.println("cccccccccccc");
    

        pser.insertPST(new questions(s,txt_question.getText(),txt_correct.getText()));
        JOptionPane.showMessageDialog(null, "question added");
       

    }

  

}
