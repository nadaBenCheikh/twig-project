/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi_1.pkg0;
    
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author esprit
 */
public class connexionDb {
    private  String url="jdbc:mysql://localhost:3306/projet_integration";
    private  String login="root";
    private  String pwd="";
    private  Connection cnx; //interface jbc 
    private static connexionDb conn;

    public connexionDb() {
        try {
            cnx=DriverManager.getConnection(url, login, pwd);
            System.out.println("connexion etablie");
        } catch (SQLException ex) {
            Logger.getLogger(connexionDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static connexionDb getInstance(){
        if(conn==null)
            conn=new connexionDb();
        return conn;
    }
    
    public Connection getCnx(){
        return cnx;
    }   
}
