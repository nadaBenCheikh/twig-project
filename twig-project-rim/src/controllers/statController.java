/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.net.URL;
import java.util.ResourceBundle;
   import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import service.BarChartSerives;

/**
 *
 * @author rim
 */
public class statController implements Initializable {
 



    @FXML
    private BarChart<?, ?> TrainingChart;

    @FXML
    private CategoryAxis event;

    @FXML
    private NumberAxis participants;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         BarChartSerives bcs = new BarChartSerives();
          // bcs.countNbOfferByCategory("design");
        XYChart.Series set1 = new XYChart.Series<>();
        set1.getData().add(new XYChart.Data<>("php",bcs.countNbOfferByCategory("php")));
         set1.getData().add(new XYChart.Data<>("javaFX",bcs.countNbOfferByCategory("javaFX")));
         set1.getData().add(new XYChart.Data<>("html",bcs.countNbOfferByCategory("html")));
         
            TrainingChart.getData().addAll(set1);
    }

}

