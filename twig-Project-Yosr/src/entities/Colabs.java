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
public class Colabs {
    private int id;
    private int freelancerId;
    private int projectId;
    private int taskId;
    private String state;

    public Colabs() {
    }
    
    public Colabs(int freelancerId, int projectId, int taskId, String state) {
        this.freelancerId = freelancerId;
        this.projectId = projectId;
        this.taskId = taskId;
        this.state = state;
    }
    
    public Colabs(int id, int freelancerId, int projectId, int taskId, String state) {
        this.id = id;
        this.freelancerId = freelancerId;
        this.projectId = projectId;
        this.taskId = taskId;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public int getFreelancerId() {
        return freelancerId;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getState() {
        return state;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFreelancerId(int freelancerId) {
        this.freelancerId = freelancerId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
    
    @Override
    public String toString() {
        return "id: "+id+"freelancerId: "+freelancerId+"projectId: "+projectId+"taskId: "+taskId+"state: "+state;
    }

    @Override
    public boolean equals(Object obj) {
            if(obj == null)
            return false;
        if(this.getClass()!= obj.getClass())
            return false;
        Colabs c = (Colabs) obj;
        return this.getId()==c.getId()&&this.getFreelancerId()==c.getFreelancerId();
    }          
}
