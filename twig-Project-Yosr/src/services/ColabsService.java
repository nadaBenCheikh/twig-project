/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Colabs;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Colabs t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Colabs> displayAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Colabs getById(Colabs t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
