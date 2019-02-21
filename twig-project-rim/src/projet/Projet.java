/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rim
 */
public class Projet {
   private String url="jdbc:mysql://localhost:3306/pi";
   private String login="root";
   private String pwd="";
   private Connection cnxe;
   private static Projet conn;
   private Projet()
   {
        try {
             cnxe=DriverManager.getConnection(url, login, pwd);
             System.out.println("connexion établie");

         } catch (SQLException ex) {
             Logger.getLogger(Projet.class.getName()).log(Level.SEVERE, null, ex);
         }
   }
    public static Projet getInstance(){
        if(conn==null)
            conn=new Projet();
        return conn;
    }

    public Connection getCnx() {
        return cnxe;
    }
       
   }

    