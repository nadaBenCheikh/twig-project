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
public class jointureParticipant {
      private int id;
    private int eventID ;
    private int feelancerID  ;
     private String firstName;
    private String lastName;
    private String email;

    public jointureParticipant() {
    }

    public jointureParticipant(int id, int eventID, int feelancerID, String firstName, String lastName, String email) {
        this.id = id;
        this.eventID = eventID;
        this.feelancerID = feelancerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
      

    public int getEventID() {
        return eventID;
    }

    public String getEmail() {
        return email;
    }

    public int getFeelancerID() {
        return feelancerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public void setFeelancerID(int feelancerID) {
        this.feelancerID = feelancerID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "jointureParticipant{" + "id=" + id + ", eventID=" + eventID + ", feelancerID=" + feelancerID + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + '}';
    }

    
   
    
}

