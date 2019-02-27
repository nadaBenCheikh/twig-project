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
public class jointure2 {
      private String question;
    private String bonneRep;
  private String nom;

    public jointure2() {
    }

    public jointure2(String question, String bonneRep, String nom) {
        this.question = question;
        this.bonneRep = bonneRep;
        this.nom = nom;
    }

    public String getBonneRep() {
        return bonneRep;
    }

    public String getNom() {
        return nom;
    }

    public String getQuestion() {
        return question;
    }

    public void setBonneRep(String bonneRep) {
        this.bonneRep = bonneRep;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
 return  "nom : "+nom+"testID="+question+ "question"+bonneRep ;
    }
  
}