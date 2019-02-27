/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.event;
import entities.jointureTable;
import entities.questions;
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
public class questionServ implements Iserv<questions>{
     private Projet connexion;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public questionServ() {
      connexion=Projet.getInstance();
      

    }

    @Override
    public void insertPST(questions t) {
        String requette="INSERT INTO questions(testID, question, bonneRep) VALUES (?,?,?)";
         try {
            pst=connexion.getCnx().prepareStatement(requette);
            pst.setInt(1, t.getTestID());
            pst.setString(2, t.getQuestion());
            pst.setString(3, t.getBonneRep());
            pst.executeUpdate();
            
         } catch (SQLException ex) {
             Logger.getLogger(questionServ.class.getName()).log(Level.SEVERE, null, ex);
         }

    }

    @Override
    public void delete(questions t) {
                     String requete="delete from questions where id=?";

         try {
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setInt(1, t.getId());
            pst.executeUpdate();

         } catch (SQLException ex) {
             Logger.getLogger(questionServ.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @Override
    public void update(questions t) {
      String requete="update questions set testID=?,question=?,bonneRep=? where id=?";

         try {
             pst=connexion.getCnx().prepareStatement(requete);
             pst.setInt(1, t.getTestID());
             pst.setString(2, t.getQuestion());
             pst.setString(3, t.getBonneRep());
             pst.setInt(4, t.getId());
             pst.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(questionServ.class.getName()).log(Level.SEVERE, null, ex);
         }
 

    }

    @Override
    public List<questions> getAll() {
           List<questions> list = new ArrayList<>();
             String requete ="select * from questions";
         try {
          
             ste=connexion.getCnx().createStatement();
             rs=ste.executeQuery(requete);
             while(rs.next()){
list.add(new questions(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4)));
             }
         } catch (SQLException ex) {
             Logger.getLogger(questionServ.class.getName()).log(Level.SEVERE, null, ex);
         }
         return list;
    }

    @Override
    public questions getById(questions t) {
         String requete="select * from questions where id=?";
             questions ques=new questions();
         try {
            pst=connexion.getCnx().prepareStatement(requete);
             pst.setInt(1, t.getId());
          rs=pst.executeQuery();
             while(rs.next()){
   ques= new questions(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4));
             }
            
         } catch (SQLException ex) {
             Logger.getLogger(questionServ.class.getName()).log(Level.SEVERE, null, ex);
         }
         return ques;

    }
     public List<questions> displayAllQuestions(int x) {
         String requete="SELECT * FROM questions where testID=?"; //(afficher le test du question)
 //  String requete="SELECT q.*, t.score, t.duree,t.type FROM questions q inner join test t on t.id = q.testID where q.testID=?";
             List<questions> list =new ArrayList<>();
     
         try {
             
             pst=connexion.getCnx().prepareStatement(requete);
               pst.setInt(1, x);
          rs=pst.executeQuery();
             while(rs.next()){
    list.add(new questions(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4)));
             }
             
         } catch (SQLException ex) {
             Logger.getLogger(questionServ.class.getName()).log(Level.SEVERE, null, ex);
         }

return list;
    
}
  /*   public List<jointureTable> display(int x){
       String requete="SELECT q.*, t.score, t.duree,t.type FROM questions q inner join test t on t.id = q.testID where q.testID=?";   
       List<jointureTable> list=new ArrayList<>();
       try {
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setInt(1, x);
            rs=pst.executeQuery();
            while(rs.next()){
            list.add(new jointureTable(rs.getInt("id"),rs.getInt("testID"),rs.getString("question"),rs.getString("bonneRep"),rs.getInt("score"),rs.getTime("duree"),rs.getString("type")));
            }
       } catch (SQLException ex) {
             Logger.getLogger(questionServ.class.getName()).log(Level.SEVERE, null, ex);
       }
          return list;
}*/
       public List<jointureTable> display(){
       String requete="SELECT q.*, t.score, t.duree,t.type,t.nom FROM questions q right join test t on t.id = q.testID";   
       List<jointureTable> list=new ArrayList<>();
       try {
            pst=connexion.getCnx().prepareStatement(requete);
           rs=pst.executeQuery();
            while(rs.next()){
            list.add(new jointureTable(rs.getInt("id"),rs.getInt("testID"),rs.getString("question"),rs.getString("bonneRep"),rs.getInt("score"),rs.getTime("duree"),rs.getString("type"),rs.getString("nom")));
            }
       } catch (SQLException ex) {
             Logger.getLogger(questionServ.class.getName()).log(Level.SEVERE, null, ex);
       }
          return list;
}
}