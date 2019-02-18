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
public class ProjectJoinTasks {
    private String title;
    private String description;
    private Date creationDate;
    private Date terminationDate;
    private String location;
    private String category;
    private String titleT;
    private String descriptionT;

    public ProjectJoinTasks() {
    }

    public ProjectJoinTasks(String title, String description, Date creationDate, Date terminationDate, String location, String category, String titleT, String descriptionT) {
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.terminationDate = terminationDate;
        this.location = location;
        this.category = category;
        this.titleT = titleT;
        this.descriptionT = descriptionT;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitleT() {
        return titleT;
    }

    public void setTitleT(String titleT) {
        this.titleT = titleT;
    }

    public String getDescriptionT() {
        return descriptionT;
    }

    public void setDescriptionT(String descriptionT) {
        this.descriptionT = descriptionT;
    }

    @Override
    public String toString() {
        return "ProjectJoinTasks{" + "title=" + title + ", description=" + description + ", creationDate=" + creationDate + ", terminationDate=" + terminationDate + ", location=" + location + ", category=" + category + ", titleTask=" + titleT + ", descriptionTask=" + descriptionT + '}';
    }
    
}
