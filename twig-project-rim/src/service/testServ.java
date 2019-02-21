/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import entities.test;
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
public class testServ implements Iserv<test>{
     private Projet connexion;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public testServ() {
      connexion=Projet.getInstance();

    }
    

    @Override
    public void insertPST(test t) {
  String requette="INSERT INTO test(score, duree, type, nom, description) VALUES (?,?,?,?,?)";
       try {
             pst=connexion.getCnx().prepareStatement(requette);
             pst.setInt(1, t.getScore());
             pst.setTime(2, t.getDuree());
             pst.setString(3, t.getType());
             pst.setString(4, t.getNom());
             pst.setString(5, t.getDescription());
             pst.executeUpdate();
            
         } catch (SQLException ex) {
             Logger.getLogger(testServ.class.getName()).log(Level.SEVERE, null, ex);
         } 
    }

    @Override
    public void delete(test t) {
  


    }

    @Override
    public void update(test t) {
        String requete="update test set score=?,duree=?,type=? where id=?";
         try {
             pst=connexion.getCnx().prepareStatement(requete);
               pst.setInt(1, t.getScore());
             pst.setTime(2, t.getDuree());
             pst.setString(3, t.getType());
             pst.setInt(4, t.getId());
               pst.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(testServ.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @Override
    public List<test> getAll() {
         List<test> list = new ArrayList<>();
             String requete="select * from test";
         try {
             ste=connexion.getCnx().createStatement();
             rs=ste.executeQuery(requete);
               while(rs.next()){
list.add(new test(rs.getInt("id"),rs.getInt("score"),rs.getTime("duree"),rs.getString("type"),rs.getString("nom"),rs.getString("description")));
             }
        } 
          catch (SQLException ex) {
             Logger.getLogger(testServ.class.getName()).log(Level.SEVERE, null, ex);
         }
         return list;
      
      
    }

    @Override
    public test getById(test t) {
        String requete="select * from test where id=?";
             test test4=new test();
         try {
           pst=connexion.getCnx().prepareStatement(requete);
             pst.setInt(1, t.getId());
          rs=pst.executeQuery();
             while(rs.next()){
   test4=new test(rs.getInt("id"),rs.getInt("score"),rs.getTime("duree"),rs.getString("type"),rs.getString("nom"),rs.getString("description"));
         }
         }catch (SQLException ex) {
             Logger.getLogger(testServ.class.getName()).log(Level.SEVERE, null, ex);
         }
         return test4;

    }
      public List<test> getNomId() {
         List<test> list = new ArrayList<>();
             String requete="select test.id , test.nom FROM test";
         try {
             ste=connexion.getCnx().createStatement();
             rs=ste.executeQuery(requete);
               while(rs.next()){
list.add(new test(rs.getInt("id"),rs.getString("nom"))); 
             }
        } 
          catch (SQLException ex) {
             Logger.getLogger(testServ.class.getName()).log(Level.SEVERE, null, ex);
         }
         return list;
      
      
    }
}
    

