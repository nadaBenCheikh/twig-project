package home.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connexion {

    /**
     * @param args the command line arguments
     */
    private static String url="jdbc:mysql://localhost:3306/pi_mytest";
    private static String login="root";
    private static String pwd= "";
    private static Connection cnx;
    private static Connexion conn;
    public Connexion(){
        try {
            cnx = DriverManager.getConnection(url, login, pwd);

        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Connexion getInstance(){
        if (conn==null)
            conn= new Connexion();
        return conn;
    }

    public static Connection getCnx() {
        return cnx;
    }



}
