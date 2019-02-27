package home.scrumBoard.Service;

import home.scrumBoard.Entity.scrumBoard;
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

public class scrumBoardService {
    private Connexion cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public scrumBoardService() {
        this.cnx = Connexion.getInstance();
    }
    public scrumBoard insert(scrumBoard Board)
    {
        try {
            String req = "INSERT INTO scrumboard (description,title,projectId) values(?,?,?)";

            pst= Connexion.getCnx().prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, Board.getDescription());
            pst.setString(2, Board.getTitle());
            pst.setInt(3,5);  //tijbid il id mil project ki tisna3 projet yit3mal coworking space

            if(pst.executeUpdate()==1){
                rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    Board.setId(rs.getInt(1));
                    return Board;
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public boolean update(scrumBoard Board){

        try {
            String req = "UPDATE scrumboard SET description=?,title=? where id=?";

            pst= Connexion.getCnx().prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, Board.getDescription());
            pst.setString(2, Board.getTitle());
            pst.setInt(3,Board.getId());

            if(pst.executeUpdate()==1){
                rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    Board.setId(rs.getInt(1));
                }
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public scrumBoard getsingle(int id) {
        String request = "SELECT * from scrumboard where projectId="+id;
        try {
            ste = cnx.getCnx().createStatement();
            rs = ste.executeQuery(request);
            while (rs.next()){
               scrumBoard scrumBoard =new scrumBoard(rs.getInt("id"), rs.getInt("projectId"), rs.getString("title"),rs.getString("description"));
                return scrumBoard;
            }
        } catch (SQLException ex) {
            Logger.getLogger(scrumBoardService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
