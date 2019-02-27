/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.users;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import project.database;
import pi_1.pkg0.connexionDb;
/**
 *
 * @author esprit
 */
public class UserServices /* implements IService<users>*/{
    private connexionDb connexion;
    private PreparedStatement pst; 
    private ResultSet rs; 
    private Statement ste;
    private String requete;

    public UserServices() {
         connexion= connexionDb.getInstance();
    }
   
    
    //@Override
    public void insert(users u){
        requete="INSERT INTO users( firstName, lastName, email, password, role, rating, phone,region, description, picturePath, state) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
             pst =connexion.getCnx().prepareStatement(requete);
             pst.setString(1, u.getFirstName());
             pst.setString(2, u.getLastName());
             pst.setString(3, u.getEmail());
             pst.setString(4, u.getPassword());
             pst.setString(5, u.getRole());
             pst.setInt(6,0);
             pst.setInt(7, u.getPhone());
             pst.setString(8, u.getRegion());
             pst.setString(9, u.getDescription());
             pst.setString(10, u.getPicturePath());
             pst.setInt(11, 1); //1:actif_____0:desactivé
             pst.executeUpdate(); 
         } catch (SQLException ex) {
             Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

  //  @Override
    public void delete(users u) {
        String requete="DELETE FROM users WHERE id=?";
        try {
            pst = connexion.getCnx().prepareStatement(requete);
             pst.setInt(1,u.getId());
             pst.executeUpdate();    
        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

   // @Override
    public void update(users u) {
        String requete="UPDATE users SET firstName=?,lastName=?,email=?,password=?,role=?,rating=?,phone=?,region=?,description=?,picturePath=?,state=? WHERE id=?";
        try {
            pst=connexion.getCnx().prepareStatement(requete);
              pst.setString(1, u.getFirstName());
             pst.setString(2, u.getLastName());
             pst.setString(3, u.getEmail());
             pst.setString(4, u.getPassword());
             pst.setString(5, u.getRole());
             pst.setInt(6, u.getRating());
             pst.setInt(7, u.getPhone());
             pst.setString(8, u.getRegion());
             pst.setString(9, u.getDescription());
             pst.setString(10, u.getPicturePath());
             pst.setInt(11, u.getState());
             pst.setInt(12, u.getId());
             pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        }
               
    }

   // @Override
    public List<users> displayAll() {
        List<users> list=new ArrayList<>();
        
        String requete="select * from users";
        
        try {
            ste=connexion.getCnx().createStatement();
            rs=ste.executeQuery(requete);
            while(rs.next()){
               list.add (new users (rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getInt(12)));
                 
             }
        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          return list;
    }
    

  //  @Override
    public users getById(users u) {
        String requete="select * from users where id=?";
        users u1= new users();
        try {
            pst=connexion.getCnx().prepareStatement(requete);
             pst.setInt(1,u.getId());
             rs=pst.executeQuery();
              while(rs.next()){
                u1= new users(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6),rs.getInt(7),rs.getInt(8), rs.getString(9),rs.getString(10),rs.getString(11),rs.getInt(12));
                 
              }
        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u1;
    }
  

    public users getByEmail(String mail) {
        String requete="select * from users where email=?";
        users u1= new users();
        //Boolean x =false;
        try {
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setString(1,mail);
            rs=pst.executeQuery();
            while(rs.next()){
                u1= new users(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6),rs.getInt(7),rs.getInt(8), rs.getString(9),rs.getString(10),rs.getString(11),rs.getInt(12));
                //x = true; 
              }
        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u1;
        
    }
    
    // **********************************************************************************
    //******************* YOSSSSSSSSSSSRR************************************************
    //***********************************************************************************
    
      // @Override
    public List<users> GetAllFreelancers() {
        List<users> list=new ArrayList<>();
        
        String requete="select * from users where role=\"freelancer\"";
        
        try {
            ste=connexion.getCnx().createStatement();
            rs=ste.executeQuery(requete);
            while(rs.next()){
               list.add (new users (rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getInt(12)));
                 
             }
        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          return list;
    }
    
    
    public ArrayList<users> getAllFreelancersByFilter(String requestPart) throws SQLException{
            ArrayList<users> ListeUsersFilter= new ArrayList<users>(); 
            String request = "select * from users where role=\'freelancer\'" +" " + requestPart;  // achanger
                  System.out.println(request);
                  System.out.println(request);
            try {
                 ste=connexion.getCnx().createStatement();
                ResultSet rese = ste.executeQuery(request);
                while(rese.next()){
                   // System.out.println("te");
                    int id_user = rese.getInt(1);
                    String first_Name = rese.getString(2);
                    String last_Name = rese.getString(3);
                    String email = rese.getString(4);
                    String password = rese.getString(5);
                   // System.out.println("te");
                    String role = rese.getString(6);
                    int raiting =rese.getInt(7);
                    int phone =rese.getInt(8);
                    String region = rese.getString(9);
                    String description = rese.getString(10);
                    String picture_Path = rese.getString(11);
                     int state =rese.getInt(12);

                     
                    users u = new users(id_user,first_Name,last_Name,email,password,role,raiting,phone,region,description,picture_Path,state);
              
                    ListeUsersFilter.add(u);
                    
                }
                           
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
            return ListeUsersFilter;
        }
    

}