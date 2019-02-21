/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.sql.Date;


/**
 *
 * @author rim
 */
public class event {
    private int id;
    private String titre  ;
    private String description  ;
    private Date dateCreation ;
    private String adresse  ;
    private int nmbreMax ;
    private String category  ;
    private String image  ;

    public event() {
    }

    public event(int id, String titre, String description, Date dateCreation , String adresse, int nmbreMax, String category, String image) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.dateCreation  = dateCreation ;
        this.adresse = adresse;
        this.nmbreMax = nmbreMax;
        this.category = category;
        this.image = image;
    }
    public event( int id,String titre, String description, String adresse, int nmbreMax, String category, String image) {
       this.id = id;
        this.titre = titre;
        this.description = description;
       this.adresse = adresse;
        this.nmbreMax = nmbreMax;
        this.category = category;
        this.image = image;
         
    }
     public event(int id) {
        this.id = id;
        
    }
     public event( String titre, String description, Date dateCreation , String adresse, int nmbreMax, String category, String image,int id) {
        
        this.titre = titre;
        this.description = description;
        this.dateCreation  = dateCreation ;
        this.adresse = adresse;
        this.nmbreMax = nmbreMax;
        this.category = category;
        this.image = image;
        this.id=id;
    }
     public event(String titre, String description, Date dateCreation , String adresse, int nmbreMax, String category, String image) {
        this.titre = titre;
        this.description = description;
        this.dateCreation  = dateCreation ;
        this.adresse = adresse;
        this.nmbreMax = nmbreMax;
        this.category = category;
        this.image = image;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getCategory() {
        return category;
    }

    public Date getDateCreation() {
        return dateCreation ;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public int getNmbreMax() {
        return nmbreMax;
    }

    public String getTitre() {
        return titre;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDateCreation(Date dateCreation ) {
        this.dateCreation  = dateCreation ;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setNmbreMax(int nmbreMax) {
        this.nmbreMax = nmbreMax;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public String toString() {
return "id : "+id+ " titre:" +titre+ "description"+description+ "dateCreation "+dateCreation+ "adresse"+adresse+ "nmbre"+nmbreMax+ "category"+category+ "image"+image;

    }
     
      
    
    
    
}
