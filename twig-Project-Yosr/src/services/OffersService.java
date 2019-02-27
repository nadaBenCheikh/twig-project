/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Offers;
import entities.ProjectJoinTasks;
import java.sql.Date;
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
 * @author esprit
 */
public class OffersService  {
     private connexionDb connexion;
    private PreparedStatement pst;
      private Statement ste;
    private ResultSet rst;
private static int selectedOffer;
    public OffersService() {
        connexion= connexionDb.getInstance(); 
     
         try {
             ste = connexion.getCnx().createStatement();
         } catch (SQLException ex) {
             Logger.getLogger(OffersService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    

  
    public void insert( Offers t) {
        int idStatic=1;
        String requete1 = "select projectId from tasks  where id=?";
         try {
             pst = connexion.getCnx().prepareStatement(requete1);
             //pst.setInt(1,t.getTaskId());
              pst.setObject(1, t.getTaskId(),java.sql.Types.INTEGER);
         }  
         catch (SQLException ex) {
             Logger.getLogger("erreur ligne 38");
         }
           
 String requete="INSERT INTO offers (taskId, projectId, freelancerId, bid, duration,motivationalLetter) VALUES (?,?,?,?,?,?)";
        try {
            pst = connexion.getCnx().prepareStatement(requete);
            pst.setObject(1, t.getTaskId(),java.sql.Types.INTEGER);
            pst.setInt(2, t.getProjectId());
            pst.setInt(3, idStatic);
            pst.setInt(4, t.getBid());
            pst.setInt(5, t.getDuration());
           // pst.setDate(6, t.getOfferDate());
            pst.setString(6, t.getMotivationalLetter()); 
          
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectsService.class.getName()).log(Level.SEVERE, null, ex);
        }
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    public void delete(int x) {
       
        String requete="delete from offers where id=?";
        try {
           pst= connexion.getCnx().prepareStatement(requete);
           pst.setInt(1, x);
           pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectsService.class.getName()).log(Level.SEVERE, null, ex);
        } 
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

              

    
    
    
    public void update(Offers t) {
        
    String requete="UPDATE offers SET bid=?, duration=?, motivationalLetter=?  WHERE id=?";
        try {
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setInt(1, t.getBid());
            pst.setInt(2, t.getDuration());
            pst.setString(3, t.getMotivationalLetter());
            pst.setInt(4, t.getId());
        
            pst.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(ProjectsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public List<Offers> displayAll() {
      // L'id du freelancer dans la requette est statique il faut le changer (session) !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        ArrayList <Offers> tab = new ArrayList ();     
        
     /*  String req1= "SELECT t.title as 'taskTitle', t.id as 'taskId',p.title as 'proTitle',p.id as 'proID' ,o.*"
               +"FROM offers o , projects p ,tasks t"
               +"where p.id=o.projectId and t.id=taskId and o.freelancerId= 1";*/
        String req1="SELECT t.title as 'taskTitle', t.id as 'taskId' ,p.title as 'proTitle' , p.id as 'proID' ,o.*"
                + " FROM offers o , projects p ,tasks t "
              + "where p.id=o.projectId and t.id=taskId and o.freelancerId= 1 ";
         try {
             
             ResultSet res = ste.executeQuery(req1);
             while(res.next())
                 
             {
                 Offers o = new Offers(res.getInt("id"), res.getInt("taskId"), res.getInt("projectId"), res.getInt("bid"), res.getInt("duration"),res.getString(2),res.getString(1));
                // System.out.println(o);
                // System.out.println(res.getString(1));
                 o.setTaskTitle(res.getString(1));
                 o.setProTitle(res.getString(2));
                 //System.out.println(res.getString(2));
                 tab.add(o);
                 
             }
         } catch (SQLException ex) {
             Logger.getLogger(OffersService.class.getName()).log(Level.SEVERE, null, ex);
         }
        
       return tab;
     // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Offers getById(Offers t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    //**************************************************************************************************************************************
    //**************************************************************************************************************************************
    //**************************************************************************************************************************************
    
    // retourner la liste des offres(postulations d'un freelancer)
    public List<Offers> getOffersById() {
        //a changer avec id de la session du user connecter
        int id=1;
        ArrayList <Offers> tab = new ArrayList ();         
        String req1="SELECT `id`, `taskId`, `projectId`, `freelancerId`, "
                + "`bid`, `duration`, `offerDate`, "
                + "`motivationalLetter` FROM `offers` where freelancerId =?";
         try {
             pst=connexion.getCnx().prepareStatement(req1);
             pst.setInt(1,id);
             ResultSet res = pst.executeQuery();
             while(res.next())
                 
             {
                 Offers o = new Offers(res.getInt(1), res.getInt("taskId"),res.getInt("projectId"), res.getInt("freelancerId"), res.getInt("bid"), res.getInt("duration"), res.getDate("offerDate"), res.getString("motivationalLetter") );
                 System.out.println("Affichage "+o);
                 tab.add(o);
                 
             }
         } catch (SQLException ex) {
             Logger.getLogger(OffersService.class.getName()).log(Level.SEVERE, null, ex);
         }
        
       return tab;       
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        public List<ProjectJoinTasks> getOffersBytask(int idTask,int idProject) {
        //a changer avec id de la session du user connecter
        int id=1;
        ArrayList <ProjectJoinTasks> tab = new ArrayList ();         
        String req1="SELECT t.title ,p.title ,p.description,t.description,p.category "
                + " FROM  projects p ,tasks t "
                + "where p.id=? and t.id=?  ";
         try {
             pst=connexion.getCnx().prepareStatement(req1);
             pst.setInt(1,idProject);
             pst.setInt(2, idTask);
             ResultSet res = pst.executeQuery();
             while(res.next())
                 
             {
                 ProjectJoinTasks pt = new ProjectJoinTasks();
                 pt.setTitle(res.getString(2));
                 pt.setTitleT(res.getString(1));
                 pt.setDescription(res.getString(3));
                 pt.setDescriptionT(res.getString(4));
                 pt.setCategory(res.getString(5));
                 //*********** badaltou **********
                 
                 pt.setId(idProject);
                 pt.setIdT(idTask);
                 
                 tab.add(pt);
             }
         } catch (SQLException ex) {
             Logger.getLogger(OffersService.class.getName()).log(Level.SEVERE, null, ex);
         }
        
       return tab;       
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
 
        
        
        
     public static int getSelectedOffer() {
        return selectedOffer;
    }

    public static void setSelectedOffer(int selectedOffer1) {
        OffersService.selectedOffer = selectedOffer;
    }
}
