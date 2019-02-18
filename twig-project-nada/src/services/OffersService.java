/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.OfferJoinCollab;
import entities.Offers;
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
public class OffersService implements Iservices<Offers>{
    private connexionDb connexion;
    private PreparedStatement pst;
    private PreparedStatement pst1;
    private ResultSet rst;

    public OffersService() {
        connexion=connexionDb.getInstance();
    }
    
    @Override
    public void isert(Offers t) {
        String requete1="INSERT INTO colabs (freelancerId, projectId, taskId, state) VALUES (?,?,?,?)";
        String requete2="delete from offers where id=?";
        try {
            pst=connexion.getCnx().prepareStatement(requete1);
            pst1=connexion.getCnx().prepareStatement(requete2);
            pst.setInt(1, t.getFreelancerId());
            pst.setInt(2, t.getProjectId());
            pst.setObject(3,t.getTaskId(),java.sql.Types.INTEGER); //La classe qui définit les constantes utilisées pour identifier les types SQL génériques, appelés types
            pst.setString(4, "hired");
            pst1.setInt(1, t.getId());
            pst.executeUpdate();
            pst1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ColabsService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void delete(Offers t) {
        String requete="delete from offers where id=?";
        try {
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setInt(1, t.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OffersService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<Offers> displayAllProjects(int x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Offers getById(Offers t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Offers t) {
        System.out.println("partie de yosr");
    }
    
    //en tant que donneur d'ordre je veux consulter les offres des freelancer qui ont postulé pour les projets et leurs taches sachant que le freelancer est referencé a la table user
    public List<OfferJoinCollab> displayOffer(int x){
        String requete="SELECT o.id,p.id,p.title,p.description,p.creationDate,p.terminationDate,p.location,p.category,t.id,t.title,t.description,u.firstName,u.lastName,u.email,f.id,f.languages,f.minHourlyFee,f.maxHourlyFee,f.cvLink,o.bid,o.duration,o.offerDate,o.motivationalLetter from tasks t right join projects p on t.projectId=p.id inner join offers o on o.projectId=p.id INNER join freelancer f on o.freelancerId=f.id inner join users u on f.userId=u.id where p.ownerId=?";
        List<OfferJoinCollab> list=new ArrayList<>();
        try {
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setInt(1, x);
            rst=pst.executeQuery();
            while(rst.next()){
                list.add(new OfferJoinCollab(rst.getInt(1),rst.getInt(2),rst.getString(3),rst.getString(4),rst.getDate(5),rst.getDate(6),rst.getString(7),rst.getString(8),rst.getInt(9),rst.getString(10),rst.getString(11),rst.getString(12),rst.getString(13),rst.getString(14),rst.getInt(15),rst.getString(16),rst.getInt(17),rst.getInt(18),rst.getString(19),rst.getInt(20),rst.getInt(21),rst.getDate(22),rst.getString(23)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OffersService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
