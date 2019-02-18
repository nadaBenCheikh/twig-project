/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Colabs;
import entities.OfferJoinCollab;
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
 * @author esprit
 */
public class ColabsService implements Iservices<Colabs>{
 
    private connexionDb connexion;
    private PreparedStatement pst;
    private ResultSet rst;

    public ColabsService() {
        connexion = connexionDb.getInstance(); 
    }
    
    @Override
    public void isert(Colabs t) {
        System.out.println("deja ajouter a partir de loffre");
    }

    @Override
    public void delete(Colabs t) {
        String requete="DELETE FROM colabs WHERE id=?";
        try {
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setInt(1, t.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ColabsService.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }

    @Override
    public void update(Colabs t) {
        String requete="update colabs set state=? where id=?";
        try {
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setString(1,"fired");
            pst.setInt(2, t.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ColabsService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Colabs> displayAllProjects(int x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Colabs getById(Colabs t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    public List<Colabs> displayAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //en tant que donneur d'ordre je veux consulter les collaborateurs pour les projets et leurs taches sachant que le freelancer est referencé a la table user
        
}
