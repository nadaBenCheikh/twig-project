/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;



public class ReferalList  {

   private int  id;
   private int idUser;
   private int idReferedFriend;
   private int idEntreprise;

    public ReferalList(int id, int idUser, int idReferedFriend, int idEntreprise) {
        this.id = id;
        this.idUser = idUser;
        this.idReferedFriend = idReferedFriend;
        this.idEntreprise = idEntreprise;
    }
    
    
        public ReferalList(int id) {
        this.id = id;
       
    }
    
        public ReferalList( int idUser, int idReferedFriend, int idEntreprise) {
        this.id = id;
        this.idUser = idUser;
        this.idReferedFriend = idReferedFriend;
        this.idEntreprise = idEntreprise;
    }

    public int getId() {
        return id;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getIdReferedFriend() {
        return idReferedFriend;
    }

    public int getIdEntreprise() {
        return idEntreprise;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setIdReferedFriend(int idReferedFriend) {
        this.idReferedFriend = idReferedFriend;
    }

    public void setIdEntreprise(int idEntreprise) {
        this.idEntreprise = idEntreprise;
    }
   
   
   
    
}