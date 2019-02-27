/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author user
 */
public class MessageBox {
    
    private int id;
    private int receiverID;
    private int senderID;
    private String message;
  
        
    private String senderFirstName;
    private String senderLastName;
    private int reply;

    public void setReply(int reply) {
        this.reply = reply;
    }

    public int getReply() {
        return reply;
    }

    public MessageBox(int receiverID, int senderID, String message, String senderFirstName, String senderLastName) {
        this.receiverID = receiverID;
        this.senderID = senderID;
        this.message = message;
        this.senderFirstName = senderFirstName;
        this.senderLastName = senderLastName;
    }


    public int getId() {
        return id;
    }

    public int getReceiverID() {
        return receiverID;
    }

    public int getSenderID() {
        return senderID;
    }

    public String getMessage() {
        return message;
    }

    public String getSenderFirstName() {
        return senderFirstName;
    }

    public String getSenderLastName() {
        return senderLastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReceiverID(int receiverID) {
        this.receiverID = receiverID;
    }

    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSenderFirstName(String senderFirstName) {
        this.senderFirstName = senderFirstName;
    }

    public void setSenderLastName(String senderLastName) {
        this.senderLastName = senderLastName;
    }

    public MessageBox(int id, int receiverID, int senderID, String message) {
        this.id = id;
        this.receiverID = receiverID;
        this.senderID = senderID;
        this.message = message;
    }
    
    public MessageBox( int receiverID, int senderID, String message) {
     
        this.receiverID = receiverID;
        this.senderID = senderID;
        this.message = message;
    }


    
}
