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
public class participant {
    private int id;
    private int eventID ;
    private int feelancerID  ;

    public participant() {
    }

    public participant( int eventID, int feelancerID,int id) {
        this.eventID = eventID;
        this.feelancerID = feelancerID;
        this.id = id;

    }
    
    public participant(int id) {
        this.id = id;
       
    }
    public participant( int eventID, int feelancerID) {
        
        this.eventID = eventID;
        this.feelancerID = feelancerID;
    }
    

    public int getEventID() {
        return eventID;
    }

    public int getId() {
        return id;
    }

    public int getFeelancerID() {
        return feelancerID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public void setFeelancerID(int feelancerID) {
        this.feelancerID = feelancerID;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id : "+id+" eventID : " +eventID+ "freelancerID:" +feelancerID; //To change body of generated methods, choose Tools | Templates.
    }
    
 
    
}

