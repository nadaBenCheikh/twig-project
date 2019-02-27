/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.event;
import entities.jointureParticipant;
import entities.participant;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import projet.Projet;

/**
 *
 * @author rim
 */
public class participantService implements Iserv<participant>{
     private Projet connexion;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public participantService() {
        connexion=Projet.getInstance();
    }
    

    @Override
    public void insertPST(participant t) {
       String requette="INSERT INTO participant(eventID , feelancerID) VALUES (?,?)";

         try {
             pst=connexion.getCnx().prepareStatement(requette);
             pst.setInt(1, t.getEventID());
             pst.setInt(2, t.getFeelancerID());
             pst.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(participantService.class.getName()).log(Level.SEVERE, null, ex);
         }

    }

    @Override
    public void delete(participant t) {
        String requete="delete from participant where id=?";
         try {
       pst=connexion.getCnx().prepareStatement(requete);
         pst.setInt(1, t.getId());
       pst.executeUpdate();

         } 
         catch (SQLException ex) {
             Logger.getLogger(participantService.class.getName()).log(Level.SEVERE, null, ex);
         }

    }

    @Override
    public void update(participant t) {
String requete="update participant set eventID=?,feelancerID =? where id=?";
         try {
             pst=connexion.getCnx().prepareStatement(requete);
             pst.setInt(1,t.getEventID());
             pst.setInt(2, t.getFeelancerID());
             pst.setInt(3, t.getId());
             pst.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(participantService.class.getName()).log(Level.SEVERE, null, ex);
         }

    }

    @Override
    public List<participant> getAll() {
          List<participant> list = new ArrayList<>();
             String requete ="select * from participant";
         try {
             
             ste=connexion.getCnx().createStatement();
              rs=ste.executeQuery(requete);
             while(rs.next()){
                 list.add(new participant(rs.getInt("id"), rs.getInt("eventID"),rs.getInt("feelancerID")));
                 
             }
         } catch (SQLException ex) {
             Logger.getLogger(participantService.class.getName()).log(Level.SEVERE, null, ex);
         }
return list; 
            
    }

    @Override
    public participant getById(participant t) {
         String requete="select * from participant where id=?";
             participant particip1= new participant();
        
         try {
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setInt(1, t.getId());
             rs=pst.executeQuery();
             while(rs.next()){
                 particip1= new participant(rs.getInt("id"),rs.getInt("eventID"),rs.getInt("feelancerID"));
         } 
         }
         catch (SQLException ex) {
             Logger.getLogger(participantService.class.getName()).log(Level.SEVERE, null, ex);
         }
         return particip1;
    }
    public List<participant> displayAllParticipant(int x) {
        String requete="SELECT * FROM participant where eventID=?";
        List<participant> list =new ArrayList<>();
        try {
            
        pst=connexion.getCnx().prepareStatement(requete);
          pst.setInt(1, x);
          rs=pst.executeQuery();
            while(rs.next()){
                list.add(new participant(rs.getInt("id"),rs.getInt("eventID"),rs.getInt("feelancerID")));
            }
            } catch (SQLException ex) {
                Logger.getLogger(participantService.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
          
        return list;
    }
     public List<jointureParticipant> displaypPArtici() {
        String requete="SELECT * FROM event e LEFT join participant p on e.id=p.eventID INNER join freelancer f on p.feelancerID=f.id INNER join users u ON f.userId=u.id";
        List<jointureParticipant> list =new ArrayList<>();
        try {
            
        pst=connexion.getCnx().prepareStatement(requete);
         
          rs=pst.executeQuery();
            while(rs.next()){
       list.add(new jointureParticipant(rs.getInt("id"),rs.getInt("eventID"),rs.getInt("feelancerID"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("email")));
            }
            } catch (SQLException ex) {
                Logger.getLogger(participantService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
    
}
}
     

 
  

    
    
    
    

