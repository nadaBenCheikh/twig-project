package controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.fxml.FXMLLoader;

/**
 *
 * @author esprit
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
      
         
        Parent root= FXMLLoader.load(getClass().getResource("../Fxml/ajouterTache_1.fxml"));
        
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Hello World!");
        
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 //font awesome icons
 //java run time 8
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}