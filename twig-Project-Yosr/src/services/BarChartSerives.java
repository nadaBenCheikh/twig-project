/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.MessageBox;
import entities.users;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pi_1.pkg0.connexionDb;

/**
 *
 * @author user
 */
public class BarChartSerives {
    
    private connexionDb connexion;
    private PreparedStatement pst;
    private ResultSet rst;

    public BarChartSerives() {
        connexion= connexionDb.getInstance();   
    }
    
    public long countNbOfferByCategory(String category)
    {
        long x=0;
        
                String req1="SELECT COUNT(*) \n" +
"FROM (\n" +
"SELECT o.id 'id offer' , p.id as 'id du projet' , p.category as 'categorie du projet' \n" +
"FROM offers o \n" +
"INNER JOIN projects p \n" +
"where o.projectId=p.id and p.category= ? ) as nb";
         try {
             pst=connexion.getCnx().prepareStatement(req1);
             pst.setString(1,category);
             ResultSet res = pst.executeQuery();
      /*  ResultSet rec2=st.executeQuery("SELECT COUNT (*) FROM MATABLE");
rec2.next();*/
             while(res.next())  
             {
                // x=(int)res.getObject(1);
                 x=res.getLong(1);
                
             }
         } catch (SQLException ex) {
             Logger.getLogger(BarChartSerives.class.getName()).log(Level.SEVERE, null, ex);
         }
        
      
        
        return x ;
    }
    
}
