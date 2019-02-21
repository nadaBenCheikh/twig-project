/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import projet.Projet;
import entities.event;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rim
 */
public class eventService implements Iserv<event>{
    
    private Projet connexion;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public eventService() {
        connexion=Projet.getInstance();

    }
    

    @Override
    public void insertPST(event t) {
    String requette="INSERT INTO event(titre, description, dateCreation, adresse, nmbreMax, category, image) VALUES (?,?,?,?,?,?,?)";
    try {
                 pst=connexion.getCnx().prepareStatement(requette);
                 pst.setString(1, t.getTitre());
                 pst.setString(2, t.getDescription());
                 pst.setDate(3, t.getDateCreation());
                 pst.setString(4, t.getAdresse());
                 pst.setInt(5, t.getNmbreMax());
                 pst.setString(6, t.getCategory());
                 pst.setString(7, t.getImage());
                 pst.executeUpdate();
                 } catch (SQLException ex) {
                 Logger.getLogger(eventService.class.getName()).log(Level.SEVERE, null, ex);
             }
    }

    @Override
    public void delete(event t) {
         String requete="delete from event where id=?";
        try {
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setInt(1, t.getId());
            pst.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(eventService.class.getName()).log(Level.SEVERE, null, ex);
        }
 
 
    
    
    
    }

    @Override
    public void update(event t) {
        String requete="update event set titre=?,description=?,adresse =?,nmbreMax=?,category =?,image =?  where id=?";
        try {
            pst=connexion.getCnx().prepareStatement(requete);
            
            pst.setString(1, t.getTitre());
                 pst.setString(2, t.getDescription());
                 pst.setString(3, t.getAdresse());
                 pst.setInt(4, t.getNmbreMax());
                 pst.setString(5, t.getCategory());
                 pst.setString(6, t.getImage());
                 pst.setInt(7, t.getId());
                 pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(eventService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<event> getAll() {
        List<event> list = new ArrayList<>();
            String requete ="select * from event";
        try {
            
            ste=connexion.getCnx().createStatement();
            rs=ste.executeQuery(requete);
             while(rs.next()){
list.add(new event(rs.getInt("id"),rs.getString("titre"),rs.getString("description"),rs.getDate("dateCreation"),rs.getString("adresse"),rs.getInt("nmbreMax"),rs.getString("category"),rs.getString("image")));
             }
        } 
             catch (SQLException ex) {
            Logger.getLogger(eventService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
         
    }

    @Override
    public event getById(event t) {
          String requete="select * from event where id=?";
            event evenement= new event();
        try {
          pst=connexion.getCnx().prepareStatement(requete);
          pst.setInt(1, t.getId());
          rs=pst.executeQuery();
             while(rs.next()){
   evenement= new event(rs.getInt("id"),rs.getString("titre"),rs.getString("description"),rs.getDate("dateCreation"),rs.getString("adresse"),rs.getInt("nmbreMax"),rs.getString("category"),rs.getString("image"));
           }
        } catch (SQLException ex) {
            Logger.getLogger(eventService.class.getName()).log(Level.SEVERE, null, ex);
        }
         return evenement;
    }
    
    
    
}
