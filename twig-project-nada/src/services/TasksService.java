/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.ProjectJoinTasks;
import entities.Tasks;
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
public class TasksService implements Iservices<Tasks>{
    private connexionDb connexion;
    private PreparedStatement pst;
    private ResultSet rst;

    public TasksService() {
        connexion=connexionDb.getInstance();
    }
    
    @Override
    public void isert(Tasks t) {
        String requete="INSERT INTO tasks (projectId, title, description) VALUES (?,?,?)";
        try {
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setInt(1, t.getProjectId());
            pst.setString(2, t.getTitle());
            pst.setString(3, t.getDescription());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TasksService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Tasks t) {
        String requete="delete from tasks where id=?";
        try {
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setInt(1, t.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TasksService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void update(Tasks t) {
        String requete="update tasks set title=?, description=? where id=?";
        try {
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setString(1, t.getTitle());
            pst.setString(2, t.getDescription());
            pst.setInt(3, t.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TasksService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //allTasks for one project
    @Override
    public List<Tasks> displayAllProjects(int x) {  
        String requete="select * from tasks where projectId=?";
        List<Tasks> list=new ArrayList<>();
        try {
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setInt(1, x);
            rst=pst.executeQuery();
            while(rst.next()){
                list.add(new Tasks(rst.getInt(1),x,rst.getString(3),rst.getString(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TasksService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list; 
    }

    @Override
    public Tasks getById(Tasks t) {
        System.out.println("cest pas necessaire pour une tache");
        return t;
    }
    
    //Afficher tous les projets et leurs taches s’ils existes d’un donneur d’ordre
    public List<ProjectJoinTasks> displayAllProjectsAndTasks(int x){ 
        String requete="SELECT p.title,p.description,p.creationDate,p.terminationDate,p.location,p.category,t.title,t.description from projects p left join tasks t on p.id=t.projectId where p.ownerId=?";
        List<ProjectJoinTasks> list=new ArrayList<>();
        try {
        pst=connexion.getCnx().prepareStatement(requete);
        pst.setInt(1, x);
        rst=pst.executeQuery();
        while(rst.next()){
            list.add(new ProjectJoinTasks(rst.getString(1),rst.getString(2),rst.getDate(3),rst.getDate(4),rst.getString(5),rst.getString(6),rst.getString(7),rst.getString(8)));
        }
        } catch (SQLException ex) {
            Logger.getLogger(TasksService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
}
