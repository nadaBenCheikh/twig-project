/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.Friends;
import entities.Offers;
import entities.users;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pi_1.pkg0.connexionDb;
/**
 *
 * @author user
 */
public class FriendsService /*implements Iservices <Friends>*/ {
    
    private connexionDb connexion;
    private PreparedStatement pst;
    private ResultSet rst;
    private Statement ste;

    public FriendsService() {
        connexion= connexionDb.getInstance();   
    }

   // @Override
    public void insert(Friends t) {
        
         String requete="INSERT INTO friends (idUser,idFriend,coworker,closefriend) VALUES (?,?,?,?)";
        try {
            pst = connexion.getCnx().prepareStatement(requete);
            pst.setInt(1, t.getIdUser());
            pst.setInt(2, t. getIdFriend());
            pst.setInt(3,0);
            pst.setInt(4,0);
          
          
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectsService.class.getName()).log(Level.SEVERE, null, ex);
        }
            
          
    }

   
  

  //  @Override
    public List displayAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


   

   // @Override
    public void delete(int x) {
        
         String requete="delete from friends where idFriend=?";
        try {
            System.out.println("delete idFriend= " + x);
           pst= connexion.getCnx().prepareStatement(requete);
           pst.setInt(1, x);
           pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectsService.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   // @Override
    public void setAsCoworker() {
        
             
//    String requete="UPDATE friends SET coworker=1 WHERE idUser=? and idFriend=?";
//        try {
//            pst=connexion.getCnx().prepareStatement(requete);
//            pst.setInt(1, f.getIdUser());
//            pst.setInt(2, f.getIdFriend());
//         
//        
//            pst.executeUpdate(); 
//        } catch (SQLException ex) {
//            Logger.getLogger(ProjectsService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    public Friends getById(Friends t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
            
            
    public List<users> getFriendsById(int id) {
        //a changer avec id de la session du user connecter
       
        ArrayList <users> tab = new ArrayList ();         
        String req1="SELECT u.*,f.*FROM friends f "
                + "inner join users u on f.idFriend=u.id "
                + "where f.idUser=?";
         try {
             pst=connexion.getCnx().prepareStatement(req1);
             pst.setInt(1,id);
             ResultSet res = pst.executeQuery();
             while(res.next())
                 
             {
                 users u = new users();
                 u.setLastName(res.getString("lastName"));
                 u.setFirstName(res.getString("firstName"));
                 u.setDescription(res.getString("description"));
                 u.setPicturePath(res.getString("picturePath"));
                 u.setEmail(res.getString("email"));
                 u.setRegion(res.getString("region"));
                 u.setId(res.getInt("id"));
                 
              
             
             
                 tab.add(u);
                 
             }
         } catch (SQLException ex) {
             Logger.getLogger(OffersService.class.getName()).log(Level.SEVERE, null, ex);
         }
        
       return tab;       
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
      public ArrayList<users> getAllFriendsByFilter(String requestPart,int idUserConnecte) throws SQLException{
            ArrayList<users> ListeUsersFilter= new ArrayList<users>(); 
            String request = "SELECT u.*,f.*FROM friends f "
                + "inner join users u on f.idFriend=u.id "
                + "where f.idUser=?" + " " + requestPart;  // achanger
                  System.out.println(request);
                  System.out.println(request);

                  
                     try {
             pst=connexion.getCnx().prepareStatement(request);
             pst.setInt(1,idUserConnecte);
             ResultSet res = pst.executeQuery();
             while(res.next())
                 
             {
                 users u = new users();
                 u.setLastName(res.getString("lastName"));
                 u.setFirstName(res.getString("firstName"));
                 u.setDescription(res.getString("description"));
                 u.setPicturePath(res.getString("picturePath"));
                 u.setEmail(res.getString("email"));
                 u.setRegion(res.getString("region"));
                 
            
             
             
                ListeUsersFilter.add(u);
                 
             }
         } catch (SQLException ex) {
             Logger.getLogger(OffersService.class.getName()).log(Level.SEVERE, null, ex);
         }
        
       return ListeUsersFilter;       
                  
        }
    
      public long countNbFriends(int idUser) 
    {
        long x=0;
        
                String req1="SELECT COUNT(*) FROM friends WHERE idUser=?";
         try {
             pst=connexion.getCnx().prepareStatement(req1);
             pst.setInt(1,idUser);
             ResultSet res = pst.executeQuery();
     
             while(res.next())  
             {
               
                 x=res.getLong(1);
                
             }
         } catch (SQLException ex) {
             Logger.getLogger(FriendsService.class.getName()).log(Level.SEVERE, null, ex);
         }
        
      
        
        return x ;
    }
      
    
    
    
    
    
    
    
}
