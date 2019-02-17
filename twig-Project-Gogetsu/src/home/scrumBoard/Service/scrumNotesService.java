package home.scrumBoard.Service;

import home.scrumBoard.Entity.scrumNotes;
import home.utils.Connexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class scrumNotesService {
    private Connexion cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public scrumNotesService() {
        this.cnx = Connexion.getInstance();
    }
    public scrumNotes insert(scrumNotes notes)
    {
        try {
            String req = "INSERT INTO scrumnotes (description,postedDate,userId,title) values(?,?,?,?)";

            pst= Connexion.getCnx().prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, notes.getDescription());
            pst.setString(2, notes.getPostedOn());
            pst.setInt(3, 5);
            pst.setString(4, notes.getTitle());

            if(pst.executeUpdate()==1){
                rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    notes.setId(rs.getInt(1));
                    return notes;
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public void delete(scrumNotes notes) {
        String request="DELETE FROM scrumnotes WHERE id ="+notes.getId();
        try {
            ste = cnx.getCnx().createStatement();
            ste.executeUpdate(request);
        } catch (SQLException ex) {
            Logger.getLogger(scrumNotesService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean update(scrumNotes notes){

        try {
            String req = "UPDATE scrumnotes SET description=?,postedDate=?,title=? where id=?";

            pst= Connexion.getCnx().prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, notes.getDescription());
            pst.setString(2, notes.getPostedOn());
            pst.setString(3, notes.getTitle());
            pst.setInt(4, notes.getId());

            if(pst.executeUpdate()==1){
                rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    notes.setId(rs.getInt(1));
                }
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public List<scrumNotes> getAll() {
        String request = "SELECT * from personne";
        List<scrumNotes> list = new ArrayList<>();
        try {
            ste = cnx.getCnx().createStatement();
            rs = ste.executeQuery(request);
            while (rs.next()){
                list.add(new scrumNotes(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"),new Date().toString(),5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(scrumNotesService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
