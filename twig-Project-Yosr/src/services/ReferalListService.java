/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.ReferalList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pi_1.pkg0.connexionDb;

/**
 *
 * @author user
 */
public class ReferalListService implements Iservices <ReferalList> {
    
    private connexionDb connexion;
    private PreparedStatement pst;
    private ResultSet rst;

    public ReferalListService() {
        connexion= connexionDb.getInstance();   
    }
    
    
  

    @Override
    public void isert(ReferalList t) {
          
         String requete="INSERT INTO referallist (id,idUser,idReferedFriend,idEntreprise) VALUES (?,?,?,?)";
        try {
            pst = connexion.getCnx().prepareStatement(requete);
            pst.setInt(1, t.getId());
            pst.setInt(2, t. getIdUser());
            pst.setInt(3, t.getIdReferedFriend());
            pst.setInt(4, t.getIdEntreprise());
          
          
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectsService.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int x) {
        
        String requete="delete from referallist where id=?";
        try {
           pst= connexion.getCnx().prepareStatement(requete);
           pst.setInt(1, x);
           pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectsService.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(ReferalList t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ReferalList> displayAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ReferalList getById(ReferalList t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}