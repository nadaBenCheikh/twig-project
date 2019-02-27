/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.Login1.service;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 *
 * @author GUIZANI
 */
public class ValidationService {
    
    public boolean validateTextField(TextField fields){
        if(fields.getText().equals("")){
            return false;
        }
        return true;
    }
    
    public boolean validateDateField(DatePicker fields){
        if(fields.getValue() == null){
            return false;
        }
        return true;
    }
    
    /*public boolean validateMail(TextField fields){
        if(comboBox.getSelectionModel().getSelectedIndex() <= -1){
            return false;
        }
        return true;
    }*/

    
    
    
    
    
    
}
