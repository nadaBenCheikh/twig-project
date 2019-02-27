/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import entities.participant;

import entities.event;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import projet.Projet;

/**
 *
 * @author user
 */
public class BarChartSerives {
    
    private Projet connexion;
    private PreparedStatement pst;
    private ResultSet rst;

    public BarChartSerives() {
        connexion= projet.Projet.getInstance();
    }
    
    public long countNbOfferByCategory(String category)
    {
        long x=0;
        
 String req1="SELECT COUNT(*) FROM ( SELECT o.id 'id participant' , p.id as 'id du event' , p.category as 'categorie du event' FROM participant o INNER JOIN event p where o.eventID=p.id and p.category= ?  ) as nb ";
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
