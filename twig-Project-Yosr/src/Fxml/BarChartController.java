/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fxml;

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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import services.BarChartSerives;


/**
 * FXML Controller class
 *
 * @author user
 */
public class BarChartController implements Initializable {

    @FXML
    private BarChart<?, ?> OffersChart;
    @FXML
    private NumberAxis y;
    @FXML
    private CategoryAxis x;
    @FXML
    private Button btnRetour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        BarChartSerives bcs = new BarChartSerives();
        bcs.countNbOfferByCategory("design");
        XYChart.Series set1 = new XYChart.Series<>();
        set1.getData().add(new XYChart.Data<>("Design",bcs.countNbOfferByCategory("design")));
        set1.getData().add(new XYChart.Data<>("Developpement Mobile",bcs.countNbOfferByCategory("Developpement Mobile")));
        set1.getData().add(new XYChart.Data<>("Developpement Web",bcs.countNbOfferByCategory("Developpement Web")));
        set1.getData().add(new XYChart.Data<>("Administration des données", bcs.countNbOfferByCategory("Administration des données")));
        set1.getData().add(new XYChart.Data<>("Architecture et conception", bcs.countNbOfferByCategory("Architecture et conception")));	

         
        
        OffersChart.getData().addAll(set1);
        
       
    }    

    @FXML
    private void redirect(ActionEvent event) throws IOException {
                
        Parent parent = FXMLLoader.load(getClass().getResource("../Fxml/HomeYosr.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    
    
    
}
