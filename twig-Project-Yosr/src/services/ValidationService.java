/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import javafx.scene.control.TextArea;
 import javafx.scene.control.TextField;

/**
 *
 * @author user
 */
public class ValidationService {
    
     public boolean validateTextField(TextField fields){
        if(fields.getText().equals("")){
            return false;
        }
        return true;
    }

    public boolean validateTextArea(TextArea fields) {
       
   if(fields.getText().equals("")){
            return false;
        }
        return true;
    }
}
