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
public class DonneurJoinProject {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
    private int rating;
    private int phone;
    private String region;
    private String description;
    private String picturePath;
    private int state;
    private int idP;
    private String title;
    private String descriptionP;
    private Date creationDateP;
    private String locationP;      
    private String categoryP;
    private Date terminationDateP;
    private int ownerId;
    private String statusP;

    public DonneurJoinProject() {
    }

    public DonneurJoinProject(int id, String firstName, String lastName, String email, String password, String role, int rating, int phone, String region, String description, String picturePath, int state, int idP, String title, String descriptionP, Date creationDateP, String locationP, String categoryP, Date terminationDateP, int ownerId, String statusP) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.rating = rating;
        this.phone = phone;
        this.region = region;
        this.description = description;
        this.picturePath = picturePath;
        this.state = state;
        this.idP = idP;
        this.title = title;
        this.descriptionP = descriptionP;
        this.creationDateP = creationDateP;
        this.locationP = locationP;
        this.categoryP = categoryP;
        this.terminationDateP = terminationDateP;
        this.ownerId = ownerId;
        this.statusP = statusP;
    }
    
    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptionP() {
        return descriptionP;
    }

    public void setDescriptionP(String descriptionP) {
        this.descriptionP = descriptionP;
    }

    public Date getCreationDateP() {
        return creationDateP;
    }

    public void setCreationDateP(Date creationDateP) {
        this.creationDateP = creationDateP;
    }

    public String getLocationP() {
        return locationP;
    }

    public void setLocationP(String locationP) {
        this.locationP = locationP;
    }

    public String getCategoryP() {
        return categoryP;
    }

    public void setCategoryP(String categoryP) {
        this.categoryP = categoryP;
    }

    public Date getTerminationDateP() {
        return terminationDateP;
    }

    public void setTerminationDateP(Date terminationDateP) {
        this.terminationDateP = terminationDateP;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getStatusP() {
        return statusP;
    }

    public void setStatusP(String statusP) {
        this.statusP = statusP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "DonneurJoinProject{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password + ", role=" + role + ", rating=" + rating + ", phone=" + phone + ", region=" + region + ", description=" + description + ", picturePath=" + picturePath + ", state=" + state + ", idP=" + idP + ", title=" + title + ", descriptionP=" + descriptionP + ", creationDateP=" + creationDateP + ", locationP=" + locationP + ", categoryP=" + categoryP + ", terminationDateP=" + terminationDateP + ", ownerId=" + ownerId+ ", statusP=" + statusP + '}';
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.idP;
        hash = 29 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DonneurJoinProject other = (DonneurJoinProject) obj;
        if (this.idP != other.idP) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
}
