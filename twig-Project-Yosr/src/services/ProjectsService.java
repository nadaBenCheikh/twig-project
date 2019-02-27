/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.DonneurJoinProject;
import entities.Projects;
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
public class ProjectsService {
    
    private connexionDb connexion;
    private PreparedStatement pst;
    private PreparedStatement pst1;
    private PreparedStatement pst2;
    private ResultSet rst;

    public ProjectsService() {
        connexion= connexionDb.getInstance();   
    }
    

    public void isert(Projects t) {
        String requete="INSERT INTO projects (title, description, location, category, terminationDate, ownerId, status) VALUES (?,?,?,?,?,?,?)";
        try {
            pst = connexion.getCnx().prepareStatement(requete);
            pst.setString(1, t.getTitle());
            pst.setString(2, t.getDescription());
            pst.setString(3, t.getLocation());
            pst.setString(4, t.getCategory());
            pst.setDate(5, t.getTerminationDate());
            pst.setInt(6, t.getOwnerId()); // a recuperer par comme_session du donneur d'ordre
            pst.setString(7, "available");
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   
    public void delete(int x) {
        String requete="delete from projects where id=?";
        try {
           pst= connexion.getCnx().prepareStatement(requete);
           pst.setInt(1, x);
           pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectsService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void update(Projects t) {
        String requete="UPDATE projects SET title=?, description=?, location=?, category=?, terminationDate=? WHERE id=?";
        try {
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setString(1, t.getTitle());
            pst.setString(2, t.getDescription());
            pst.setString(3, t.getLocation());
            pst.setString(4, t.getCategory());
            pst.setDate(5, t.getTerminationDate());
            pst.setInt(6, t.getId());
            pst.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(ProjectsService.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    //afficher un projet

    public Projects getById(int x) {  
        String requete="select * from projects where id=?";
        Projects p=new Projects();
        try { 
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setInt(1, x);
            rst=pst.executeQuery();
            while(rst.next()){
               p=new Projects(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getDate(4),rst.getString(5),rst.getString(6),rst.getDate(7),rst.getInt(8),rst.getString(9));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    //afficher tous les projets du donneur d'ordre
 
    public List<Projects> displayAllProjects(int x) {  
        String requete="SELECT * FROM projects where ownerId=?";
        List<Projects> list =new ArrayList<>();
        try {
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setInt(1, x);
            rst=pst.executeQuery();
            while(rst.next()){
                list.add(new Projects(rst.getInt("id"),rst.getString("title"),rst.getString("description"),rst.getDate("creationDate"),rst.getString("location"),rst.getString("category"),rst.getDate("terminationDate"),x,rst.getString("status")));
            }    
        } catch (SQLException ex) {
            Logger.getLogger(ProjectsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    //afficher tous les donneurs d'ordre et leurs projets
    public List<DonneurJoinProject> display(){  
        String requete="SELECT * FROM users u inner join projects p on p.ownerId=u.id where status=?";
        List<DonneurJoinProject> list=new ArrayList<>();
        try {
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setString(1, "available");
            rst=pst.executeQuery();
            while(rst.next()){
               list.add(new DonneurJoinProject(rst.getInt("id"),rst.getString("firstName"),rst.getString("lastName"),rst.getString("email"),rst.getString("password"),rst.getString("role"),rst.getInt("rating"),rst.getInt("phone"),rst.getString("region"),rst.getString("description"),rst.getString("picturePath"),rst.getInt("state"),rst.getInt(13),rst.getString("title"),rst.getString("description"),rst.getDate("creationDate"),rst.getString("location"),rst.getString("category"),rst.getDate("terminationDate"),rst.getInt("ownerId"),rst.getString("status")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public void state(int x){
        String requete1="UPDATE projects SET status=? where id=?";
        //String requete2="delete from tasks where projectId=?";
        String requete3="update colabs set state=? where projectId=?";
        try {
            pst=connexion.getCnx().prepareStatement(requete1);
            //pst1=connexion.getCnx().prepareStatement(requete2);
            pst2=connexion.getCnx().prepareStatement(requete3);
            pst.setString(1, "completed");
            pst.setInt(2, x);
            //pst1.setInt(1, x);
            pst2.setString(1, "finishedWork");
            pst2.setInt(2, x);
            pst.executeUpdate();
            //pst1.executeUpdate();
            pst2.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectsService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //afficher tous les projets du donneur d'ordre pour ajouter une tache  
    public List<Projects> displayAllProject(int x) {  
        String requete="SELECT id,title FROM projects where ownerId=?";
        List<Projects> list =new ArrayList<>();
        try {
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setInt(1, x);
            rst=pst.executeQuery();
            while(rst.next()){
                list.add(new Projects(rst.getInt("id"),rst.getString("title")));
            }    
        } catch (SQLException ex) {
            Logger.getLogger(ProjectsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    //nom unique
    public Projects getByTitle(String title) {  
        String requete="select * from projects where title=?";
        Projects p=new Projects();
        try { 
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setString(1, title);
            rst=pst.executeQuery();
            while(rst.next()){
               p=new Projects(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getDate(4),rst.getString(5),rst.getString(6),rst.getDate(7),rst.getInt(8),rst.getString(9));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
    //nekhdem bhedhi khir
    public boolean getByName(String title){
        String requete="select * from projects where title=?";
        String nom="";
        try {
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setString(1, title);
            rst=pst.executeQuery();
            while(rst.next()){
                nom=rst.getString("title");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(nom.equals(""))
            return false;
        return true;
    }
}
