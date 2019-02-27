/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;



/**
 *
 * @author esprit
 */
public class Projects {
    private int id;
    private String title;
    private String description;
    private Date creationDate;
    private String location ;      
    private String category;
    private Date terminationDate;
    private int ownerId;
    private String status;     

    public Projects() {
 }
    
    public Projects(int id) {
        this.id=id;
    }
    
    //ajouter
    public Projects(String title, String description, String location, String category, Date terminationDate, int ownerId) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.category = category;
        this.terminationDate = terminationDate;
        this.ownerId = ownerId;
    }
    
    //modifier
    public Projects(int id,String title, String description, String location, String category, Date terminationDate) {
        this.id=id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.category = category;
        this.terminationDate = terminationDate;
    }
    
    //afficherAllProject du donneur d'ordre
    public Projects(int id, String title, String description, Date creationDate, String location, String category, Date terminationDate, int ownerId, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.location = location;
        this.category = category;
        this.terminationDate = terminationDate;
        this.ownerId = ownerId;
        this.status = status;
    }
    
    //combobox:afficher title and id
    public Projects(int id,String title){
        this.id=id;
        this.title=title;
    }

    public String getCategory() {
        return category;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public String getStatus() {
        return status;
    }

    public Date getTerminationDate() {
        return terminationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTerminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Projects{" + "id=" + id + ", ownerId=" + ownerId + ", title=" + title + ", description=" + description + ", creationDate=" + creationDate + ", location=" + location + ", category=" + category + ", terminationDate=" + terminationDate + ", status=" + status + '}';
    }
  
    
    @Override
    public boolean equals(Object obj) {
             if(obj == null)
            return false;
        if(this.getClass()!= obj.getClass())
            return false;
        Projects p = (Projects) obj;
        return this.getId()==p.getId();
    }     
}
