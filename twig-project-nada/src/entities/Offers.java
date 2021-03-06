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
public class Offers {
    private int id;
    private Integer taskId;
    private int projectId;
    private int freelancerId;
    private int bid;
    private int duration;
    private Date offerDate;
    private String motivationalLetter;

    public Offers() {
    }

    //ignorer offre
    public Offers(int id) {
       this.id=id;
    }
    
    //confirmer offre
    public Offers(Integer taskId, int projectId, int freelancerId,int id) {
        this.taskId = taskId;
        this.projectId = projectId;
        this.freelancerId = freelancerId;
        this.id = id;
    }
    
    //affichage
    public Offers(int id, Integer taskId, int projectId, int freelancerId, int bid, int duration, Date offerDate, String motivationalLetter) {
        this.id = id;
        this.taskId = taskId;
        this.projectId = projectId;
        this.freelancerId = freelancerId;
        this.bid = bid;
        this.duration = duration;
        this.offerDate = offerDate;
        this.motivationalLetter = motivationalLetter;
    }

    public int getBid() {
        return bid;
    }

    public int getDuration() {
        return duration;
    }

    public int getFreelancerId() {
        return freelancerId;
    }

    public int getId() {
        return id;
    }

    public String getMotivationalLetter() {
        return motivationalLetter;
    }

    public Date getOfferDate() {
        return offerDate;
    }

    public int getProjectId() {
        return projectId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setFreelancerId(int freelancerId) {
        this.freelancerId = freelancerId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMotivationalLetter(String motivationalLetter) {
        this.motivationalLetter = motivationalLetter;
    }

    public void setOfferDate(Date offerDate) {
        this.offerDate = offerDate;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    @Override
    public String toString() {
        return "id: "+id+"taskId: "+taskId+"projectId: "+projectId+"freelancerId: "+freelancerId+"bid: "+bid+"duration: "+duration+"offerDate: "+offerDate+"motivationalLetter: "+motivationalLetter;
    }

    @Override
    public boolean equals(Object obj) {
           if(obj == null)
            return false;
        if(this.getClass()!= obj.getClass())
            return false;
        Offers o = (Offers) obj;
        return this.getId()==o.getId()&&this.getFreelancerId()==o.getFreelancerId();
    }    
}
