/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author rim
 */
public class test {
    private int id;
    private int score ;
    private Time duree ;
   private String type;
   private String nom;
   private String description ;

    public test() {
    }

    public test(int id, int score, Time duree, String type, String nom, String description) {
        this.id = id;
        this.score = score;
        this.duree = duree;
        this.type = type;
        this.nom = nom;
        this.description = description;
    }
     public test(int id, int score, Time duree, String type) {
        this.id = id;
        this.score = score;
        this.duree = duree;
        this.type = type;
      
    }
       public test(int id,String nom)
       {
           this.id=id;
         
           this.nom=nom;
       }
     public test( int score, Time duree, String type, String nom, String description,int id) {
        this.score = score;
        this.duree = duree;
        this.type = type;
        this.nom = nom;
        this.description = description;
        this.id=id;
    }
      public test( int score, Time duree, String type, String nom, String description) {
        this.score = score;
        this.duree = duree;
        this.type = type;
        this.nom = nom;
        this.description = description;
    }
       public test(int id) {
        this.id = id;
     
    }

    public String getDescription() {
        return description;
    }

    public Time getDuree() {
        return duree;
    }

    public String getNom() {
        return nom;
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public String getType() {
        return type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDuree(Time duree) {
        this.duree = duree;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "id : "+id+"score=" +score+ "duree"+duree+ "type"+type+ "nom"+nom+"description"+description;
    }
       
    
    
}
