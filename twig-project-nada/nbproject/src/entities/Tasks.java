/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author esprit
 */
public class Tasks {
    private int id;
    private int projectId;
    private String title;
    private String description;

    public Tasks() {
    }
    //supprimer
    public Tasks(int id) {
        this.id=id;
    }
    
     //ajouter
    public Tasks(int ProjectId, String title, String description) {
        this.projectId=ProjectId;
        this.title = title;
        this.description = description;
    }
    
    //modifier
    public Tasks(String title, String description,int id) {
        this.title = title;
        this.description = description;
        this.id=id;
    }
    
    //affichage
    public Tasks(int id, int projectId, String title, String description) {
        this.id = id;
        this.projectId = projectId;
        this.title = title;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "id:"+id+" projectId:"+projectId+" title:"+title+" description:"+description;
    }

    @Override
    public boolean equals(Object obj) {
            if(obj == null)
            return false;
        if(this.getClass()!= obj.getClass())
            return false;
        Tasks t = (Tasks) obj;
        return this.getId()==t.getId();
    }
}
