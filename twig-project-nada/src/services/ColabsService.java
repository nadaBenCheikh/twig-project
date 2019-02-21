/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Colabs;
import entities.ColabsJoinProject;
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
public class ColabsService implements Iservices<Colabs>{
 
    private connexionDb connexion;
    private PreparedStatement pst;
    private ResultSet rst;

    public ColabsService() {
        connexion = connexionDb.getInstance(); 
    }
    
    @Override
    public void isert(Colabs t) {
        System.out.println("deja ajouter a partir de loffre");
    }

    @Override
    public void delete(int x) {
        String requete="DELETE FROM colabs WHERE id=?";
        try {
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setInt(1, x);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ColabsService.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }

    @Override
    public void update(Colabs t) {
        String requete="update colabs set state=? where id=?";
        try {
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setString(1,"fired");
            pst.setInt(2, t.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ColabsService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Colabs> displayAllProjects(int x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Colabs getById(Colabs t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    public List<Colabs> displayAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void updateState(int x) {
        String requete="update colabs set state=? where id=?";
        try {
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setString(1,"fired");
            pst.setInt(2, x);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ColabsService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //en tant que donneur d'ordre je veux consulter les collaborateurs pour les projets et leurs taches sachant que le freelancer est referencé a la table user
     public List<ColabsJoinProject> displayColabs(int x) {
        String requete="SELECT c.id,p.id,p.title,p.terminationDate,t.id,t.title,c.state,u.firstName,u.lastName,u.email,f.id,f.languages from tasks t right join projects p on t.projectId=p.id inner join colabs c on c.projectId=p.id INNER join freelancer f on c.freelancerId=f.id inner join users u on f.userId=u.id where p.ownerId=?";
        List<ColabsJoinProject> list=new ArrayList<>();
         try {
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setInt(1, x);
            rst=pst.executeQuery();
            while(rst.next()){
                list.add(new ColabsJoinProject(rst.getInt(1),rst.getInt(2),rst.getString(3),rst.getDate(4),rst.getInt(5),rst.getString(6),rst.getString(7),rst.getString(8),rst.getString(9),rst.getString(10),rst.getInt(11),rst.getString(12)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ColabsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list; 
     }  
}
