/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author rim
 */
public class questions {
    private int id;
    private int testID;
    private String question;
   private String bonneRep ;

    public questions() {
    }

    public questions(int id, int testID, String question, String bonneRep) {
        this.id = id;
        this.testID = testID;
        this.question = question;
        this.bonneRep = bonneRep;
    }
      public questions( String bonneRep) {
       
        this.bonneRep = bonneRep;
    }
     public questions(int id)
     {
         this.id=id;
     }
     
     public questions( int testID, String question, String bonneRep) {
        this.testID = testID;
        this.question = question;
        this.bonneRep = bonneRep;
    }

    public String getBonneRep() {
        return bonneRep;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public int getTestID() {
        return testID;
    }

    public void setBonneRep(String bonneRep) {
        this.bonneRep = bonneRep;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTestID(int testID) {
        this.testID = testID;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
  return "id : "+id+"testID=" +testID+ "question"+question+ "bonneRep"+bonneRep;

    }
   
    
}
