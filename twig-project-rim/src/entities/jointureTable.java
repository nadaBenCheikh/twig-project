/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Time;

/**
 *
 * @author rim
 */
public class jointureTable {
    private int id;
    private int testID;
    private String question;
    private String bonneRep;
    private int score ;
    private Time duree;
   private  String type;
   private String nom;

    public jointureTable() {
    }

    public jointureTable(int id,int testID, String question, String bonneRep, int score, Time duree, String type, String nom) {
       this.id = id;
       this.testID=testID;
        this.question = question;
        this.bonneRep = bonneRep;
        this.score = score;
        this.duree = duree;
        this.type = type;
        this.nom=nom;

    }
    public jointureTable(int id, String question, String bonneRep, int score, Time duree, String type, String nom) {
       this.id = id;
       
        this.question = question;
        this.bonneRep = bonneRep;
        this.score = score;
        this.duree = duree;
        this.type = type;
        this.nom=nom;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    

    public String getBonneRep() {
        return bonneRep;
    }

    public Time getDuree() {
        return duree;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public int getScore() {
        return score;
    }

    public int getTestID() {
        return testID;
    }

    public String getType() {
        return type;
    }

    public void setBonneRep(String bonneRep) {
        this.bonneRep = bonneRep;
    }

    public void setDuree(Time duree) {
        this.duree = duree;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setTestID(int testID) {
        this.testID = testID;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
     return  "id : "+id+"testID=" +testID+ "question"+question+ "bonneRep"+bonneRep+"score"+score+"duree"+duree+"type"+type+"nom"+nom;
    }
    
    
    
}

