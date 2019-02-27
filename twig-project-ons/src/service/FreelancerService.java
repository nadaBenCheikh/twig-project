/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Freelancer;
import entite.jointure;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import project.database;

/**
 *
 * @author esprit
 */
public class FreelancerService implements IService<Freelancer> {
    
    private  database connexion;
    private PreparedStatement pst; 
    private ResultSet rs; 
    private Statement ste;
    
    public FreelancerService () {
         connexion= database.getInstance();
    }

    @Override
    public void insert(Freelancer f) {
        String requete="INSERT INTO freelancer(userId,languages, minHourlyFee,gender,cvLink,maxHourlyFee,ranking) VALUES (?,?,?,?,?,?,?)";
        try {
            pst =connexion.getCnx().prepareStatement(requete);
            pst.setInt (1,f.getUserId());
            pst.setString(2,f.getLanguages());
            pst.setInt(3,f.getMinHourlyFee());
            pst.setInt(4,f.getGender());
            pst.setString(5,f.getCvLink());
            pst.setInt(6,f.getMaxHourlyFee());
            pst.setString(7,f.getRanking());
            pst.executeUpdate(); 
           
        } catch (SQLException ex) {
            Logger.getLogger(FreelancerService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Freelancer f) {
        String requete="DELETE FROM freelancer WHERE id=?";
        try {
            pst = connexion.getCnx().prepareStatement(requete);
             pst.setInt(1,f.getId());
             pst.executeUpdate();    
        } catch (SQLException ex) {
            Logger.getLogger(FreelancerService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Freelancer f) {
        String requete="UPDATE freelancer SET userId=?,languages=?,minHourlyFee=?,gender=?,cvLink=?,maxHourlyFee=?,ranking=? WHERE id=?";
        try {
            pst=connexion.getCnx().prepareStatement(requete);
            pst =connexion.getCnx().prepareStatement(requete);
            pst.setInt (1,f.getUserId());
            pst.setString(2,f.getLanguages());
            pst.setInt(3,f.getMinHourlyFee());
            pst.setInt(4,f.getGender());
            pst.setString(5,f.getCvLink());
            pst.setInt(6,f.getMaxHourlyFee());
            pst.setString(7,f.getRanking());
            pst.setInt(8,f.getId());
        } catch (SQLException ex) {
            Logger.getLogger(FreelancerService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Freelancer> displayAll() {
       List<Freelancer> list=new ArrayList<>();
       String requete="select * from freelancer ";
        try {
            ste=connexion.getCnx().createStatement();
             rs=ste.executeQuery(requete);
               while(rs.next()){
               list.add (new Freelancer (rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8)));
               }   
        } catch (SQLException ex) {
            Logger.getLogger(FreelancerService.class.getName()).log(Level.SEVERE, null, ex);
        }
          return list;
    }
  
    public List<jointure> display() {
       List<jointure> list=new ArrayList<>();
       String requete="select Freelancer.*, users.* from Freelancer inner join users on users.id=Freelancer.userId ";
        try {
            ste=connexion.getCnx().createStatement();
             rs=ste.executeQuery(requete);
               while(rs.next()){
               list.add (new jointure (rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getInt(12),
                       rs.getInt(13), rs.getString(14), rs.getInt(15),rs.getInt(16),rs.getString(17),rs.getInt(18),rs.getString(19)));
               }   
        } catch (SQLException ex) {
            Logger.getLogger(FreelancerService.class.getName()).log(Level.SEVERE, null, ex);
        }
          return list;
    }

    @Override
    public Freelancer getById(Freelancer f) {
        String requete="select * from freelancer where id=?";
        Freelancer f1= new Freelancer();
        try {
            pst=connexion.getCnx().prepareStatement(requete);
             pst.setInt(1,f.getId());
             rs=pst.executeQuery();
              while(rs.next()){
               f1=new Freelancer (rs.getInt(1),rs.getInt(2),rs.getString(3), rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8));
               }   
             
        } catch (SQLException ex) {
            Logger.getLogger(FreelancerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f1;
    }
      
    public Freelancer getByIdFreelancer(int x) {
        String requete="select * from freelancer where userId=?";
        Freelancer f1= new Freelancer();
        try {
            pst=connexion.getCnx().prepareStatement(requete);
             pst.setInt(1,x);
             rs=pst.executeQuery();
              while(rs.next()){
               f1=new Freelancer (rs.getInt(1),rs.getInt(2),rs.getString(3), rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8));
               }   
             
        } catch (SQLException ex) {
            Logger.getLogger(FreelancerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f1;
    }
      
   
    
    
}
