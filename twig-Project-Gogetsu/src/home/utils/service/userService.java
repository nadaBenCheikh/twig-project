package home.utils.service;
import home.utils.Connexion;
import home.utils.entity.user;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class userService {
    private Connexion cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    public userService() {
        this.cnx = Connexion.getInstance();
    }

    public user get(int id){
        String request = "SELECT * from users where id="+id;
        try {
            ste = cnx.getCnx().createStatement();
            rs = ste.executeQuery(request);
            while (rs.next()){
                user scrumBoard =new user(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"),rs.getString("picturePath"));
                return scrumBoard;
            }
        } catch (SQLException ex) {
            Logger.getLogger(userService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public user getsingle(String email,String password) {
        String request = "SELECT * from users where password="+password;
        try {
            ste = cnx.getCnx().createStatement();
            rs = ste.executeQuery(request);
            while (rs.next()){
                user scrumBoard =new user(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"),rs.getString("picturePath"));
                return scrumBoard;
            }
        } catch (SQLException ex) {
            Logger.getLogger(userService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
