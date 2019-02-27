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
public class MessageBoxServices {
    
      private connexionDb connexion;
    private PreparedStatement pst;
    private ResultSet rst;

    public MessageBoxServices() {
        connexion= connexionDb.getInstance();   
    }
    
    
    
      public List<MessageBox> getMessageByIdReceiver(int id) // id of receiver  
      {
       
       
        ArrayList <MessageBox> tab = new ArrayList ();         
        String req1="SELECT  u.firstName as 'prenom sender' , u.lastName as 'nom sender' , m.* "
                + "FROM messagebox m INNER JOIN users u "
                + "where m.senderID =u.id  and m.reply=0 and m.receiverID= ?";
         try {
             pst=connexion.getCnx().prepareStatement(req1);
             pst.setInt(1,id);
             ResultSet res = pst.executeQuery();
        
             while(res.next())
                 
            
             {
                                          
              MessageBox m = new MessageBox( res.getInt("receiverID"), res.getInt("senderID"), res.getString("message"),res.getString(1),res.getString(2));
         
                m.setSenderFirstName(res.getString(1));
                m.setSenderLastName(res.getString(2));
           
            
                 tab.add(m);
                 
             }
         } catch (SQLException ex) {
             Logger.getLogger(MessageBoxServices.class.getName()).log(Level.SEVERE, null, ex);
         }
        
       return tab;       
      
    }
      
          public void sendMessage(MessageBox m) {
        String requete="INSERT INTO messagebox(receiverID,senderID, message, reply) VALUES (?,?,?,?)";
        try {
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setInt(1,m.getReceiverID());
            pst.setInt(2, m.getSenderID());
            pst.setString(3, m.getMessage());
            pst.setInt(4,0); // reply =0 initialement 
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MessageBoxServices.class.getName()).log(Level.SEVERE, null, ex);
        }
          }
          
          
          
        public void setMessageAsRead(int Id) // ne marche pas !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        {
   
          
          String requete="UPDATE messagebox SET reply=1 where id = ?";
        try {
            System.out.println("kkkkkkkkkkk");
            pst=connexion.getCnx().prepareStatement(requete);
             pst.setInt(1,Id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MessageBoxServices.class.getName()).log(Level.SEVERE, null, ex);
        }
                        
             }
        
        
        
         public void deleteMessage(int id) 
                 
         {
            
                String requete="delete from messagebox where id=?";
        try {
           pst= connexion.getCnx().prepareStatement(requete);
           pst.setInt(1, id);
           pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MessageBoxServices.class.getName()).log(Level.SEVERE, null, ex);
        } 
         }
         
         
         // calculer le nombre de message non lus
         
          
    public long countNbUnreadMessages(int idReceiver) 
    {
        long x=0;
        
                String req1="SELECT COUNT(*) FROM messagebox WHERE receiverID=? AND reply=0";
         try {
             pst=connexion.getCnx().prepareStatement(req1);
             pst.setInt(1,idReceiver);
             ResultSet res = pst.executeQuery();
     
             while(res.next())  
             {
               
                 x=res.getLong(1);
                
             }
         } catch (SQLException ex) {
             Logger.getLogger(MessageBoxServices.class.getName()).log(Level.SEVERE, null, ex);
         }
        
      
        
        return x ;
    }
      
                 
        
        
    }
      
      
      
      
      
