/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

public class Friends{
    
    private int id;
    private int idUser;
    private int idFriend;
    private int coworker;
    private int closeFriend;

        public Friends(int id) {
        this.id = id;
     
    }
        
    public Friends(int id, int coworker, int closeFriend) {
        this.id = id;
        this.coworker = coworker;
        this.closeFriend = closeFriend;
    }
  
    
    public Friends(int id, int idUser, int idFriend, int coworker, int closeFriend) {
        this.id = id;
        this.idUser = idUser;
        this.idFriend = idFriend;
        this.coworker = coworker;
        this.closeFriend = closeFriend;
    }
        public Friends( int idUser, int idFriend, int coworker, int closeFriend) {
    
        this.idUser = idUser;
        this.idFriend = idFriend;
        this.coworker = coworker;
        this.closeFriend = closeFriend;
    }
        
       public Friends( int idUser, int idFriend) {
    
        this.idUser = idUser;
        this.idFriend = idFriend;

    }

    public int getId() {
        return id;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getIdFriend() {
        return idFriend;
    }

    public int getCoworker() {
        return coworker;
    }

    public int getCloseFriend() {
        return closeFriend;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setIdFriend(int idFriend) {
        this.idFriend = idFriend;
    }

    public void setCoworker(int coworker) {
        this.coworker = coworker;
    }

    public void setCloseFriend(int closeFriend) {
        this.closeFriend = closeFriend;
    }

  

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Friends other = (Friends) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
    
}