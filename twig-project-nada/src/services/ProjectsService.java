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
public class ProjectsService implements Iservices<Projects>{
    
    private connexionDb connexion;
    private PreparedStatement pst;
    private PreparedStatement pst1;
    private PreparedStatement pst2;
    private ResultSet rst;

    public ProjectsService() {
        connexion= connexionDb.getInstance();   
    }
    
    @Override
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

    @Override
    public void delete(Projects t) {
        String requete="delete from projects where id=?";
        try {
           pst= connexion.getCnx().prepareStatement(requete);
           pst.setInt(1, t.getId());
           pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectsService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Projects t) {
        String requete="UPDATE projects SET title=?, description=?, location=?, category=?, terminationDate=?, status=? WHERE id=?";
        try {
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setString(1, t.getTitle());
            pst.setString(2, t.getDescription());
            pst.setString(3, t.getLocation());
            pst.setString(4, t.getCategory());
            pst.setDate(5, t.getTerminationDate());
            pst.setString(6, t.getStatus());
            pst.setInt(7, t.getId());
            pst.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(ProjectsService.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    //afficher un projet
    @Override
    public Projects getById(Projects t) {  
        String requete="select * from projects where id=?";
        Projects p=new Projects();
        try { 
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setInt(1, t.getId());
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
    @Override
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
    
    public List<DonneurJoinProject> display(){  //en tant qu'admin 
        String requete="SELECT * FROM users u inner join projects p on p.ownerId=u.id";
        List<DonneurJoinProject> list=new ArrayList<>();
        try {
            pst=connexion.getCnx().prepareStatement(requete);
            rst=pst.executeQuery();
            while(rst.next()){
               list.add(new DonneurJoinProject(rst.getInt("id"),rst.getString("firstName"),rst.getString("lastName"),rst.getString("email"),rst.getString("password"),rst.getString("role"),rst.getInt("rating"),rst.getInt("phone"),rst.getString("region"),rst.getString("description"),rst.getString("picturePath"),rst.getInt("state"),rst.getInt("id"),rst.getString("title"),rst.getString("description"),rst.getDate("creationDate"),rst.getString("location"),rst.getString("category"),rst.getDate("terminationDate"),rst.getInt("ownerId"),rst.getString("status")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public void state(Projects t){
        String requete1="UPDATE projects SET status=? where id=?";
        String requete2="delete from tasks where projectId=?";
        String requete3="update colabs set state=? where projectId=?";
        try {
            pst=connexion.getCnx().prepareStatement(requete1);
            pst1=connexion.getCnx().prepareStatement(requete2);
            pst2=connexion.getCnx().prepareStatement(requete3);
            pst.setString(1, "completed");
            pst.setInt(2, t.getId());
            pst1.setInt(1, t.getId());
            pst2.setString(1, "finishedWork");
            pst2.setInt(2, t.getId());
            pst.executeUpdate();
            pst1.executeUpdate();
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
}