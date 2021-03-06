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
public class OfferJoinCollab {
    private int id;
    private int projectId;
    private String titleP;
    private Date terminationDateP;
    private String categoryP; 
    private int taskId;
    private String titleT;
    private String firstName;
    private String lastName;
    private String email;
    private int freelancerId;
    private String languagesF;
    private int minHourlyFeeF;
    private int maxHourlyFeeF;
    private String cvLinkF;
    private int bidO;
    private int durationO;
    private Date offerDateO;
    private String motivationalLetterO;
    private String picturePath;

    public OfferJoinCollab() {
    }

    public OfferJoinCollab(int id, int projectId, String titleP, Date terminationDateP, String categoryP, int taskId, String titleT, String firstName, String lastName, String email, int freelancerId, String languagesF, int minHourlyFeeF, int maxHourlyFeeF, String cvLinkF, int bidO, int durationO, Date offerDateO, String motivationalLetterO, String picturePath) {
        this.id = id;
        this.projectId = projectId;
        this.titleP = titleP;
        this.terminationDateP = terminationDateP;
        this.categoryP = categoryP;
        this.taskId = taskId;
        this.titleT = titleT;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.freelancerId = freelancerId;
        this.languagesF = languagesF;
        this.minHourlyFeeF = minHourlyFeeF;
        this.maxHourlyFeeF = maxHourlyFeeF;
        this.cvLinkF = cvLinkF;
        this.bidO = bidO;
        this.durationO = durationO;
        this.offerDateO = offerDateO;
        this.motivationalLetterO = motivationalLetterO;
        this.picturePath= picturePath;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getTitleP() {
        return titleP;
    }

    public void setTitleP(String titleP) {
        this.titleP = titleP;
    }

    public Date getTerminationDateP() {
        return terminationDateP;
    }

    public void setTerminationDateP(Date terminationDateP) {
        this.terminationDateP = terminationDateP;
    }

    public String getCategoryP() {
        return categoryP;
    }

    public void setCategoryP(String categoryP) {
        this.categoryP = categoryP;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTitleT() {
        return titleT;
    }

    public void setTitleT(String titleT) {
        this.titleT = titleT;
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

    public int getFreelancerId() {
        return freelancerId;
    }

    public void setFreelancerId(int freelancerId) {
        this.freelancerId = freelancerId;
    }

    public String getLanguagesF() {
        return languagesF;
    }

    public void setLanguagesF(String languagesF) {
        this.languagesF = languagesF;
    }

    public int getMinHourlyFeeF() {
        return minHourlyFeeF;
    }

    public void setMinHourlyFeeF(int minHourlyFeeF) {
        this.minHourlyFeeF = minHourlyFeeF;
    }

    public int getMaxHourlyFeeF() {
        return maxHourlyFeeF;
    }

    public void setMaxHourlyFeeF(int maxHourlyFeeF) {
        this.maxHourlyFeeF = maxHourlyFeeF;
    }

    public String getCvLinkF() {
        return cvLinkF;
    }

    public void setCvLinkF(String cvLinkF) {
        this.cvLinkF = cvLinkF;
    }

    public int getBidO() {
        return bidO;
    }

    public void setBidO(int bidO) {
        this.bidO = bidO;
    }

    public int getDurationO() {
        return durationO;
    }

    public void setDurationO(int durationO) {
        this.durationO = durationO;
    }

    public Date getOfferDateO() {
        return offerDateO;
    }

    public void setOfferDateO(Date offerDateO) {
        this.offerDateO = offerDateO;
    }

    public String getMotivationalLetterO() {
        return motivationalLetterO;
    }

    public void setMotivationalLetterO(String motivationalLetterO) {
        this.motivationalLetterO = motivationalLetterO;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    @Override
    public String toString() {
        return "OfferJoinCollab{" + "id=" + id + ", projectId=" + projectId + ", titleP=" + titleP + ", terminationDateP=" + terminationDateP + ", categoryP=" + categoryP + ", taskId=" + taskId + ", titleT=" + titleT + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", freelancerId=" + freelancerId + ", languagesF=" + languagesF + ", minHourlyFeeF=" + minHourlyFeeF + ", maxHourlyFeeF=" + maxHourlyFeeF + ", cvLinkF=" + cvLinkF + ", bidO=" + bidO + ", durationO=" + durationO + ", offerDateO=" + offerDateO + ", motivationalLetterO=" + motivationalLetterO + ", picturePath=" + picturePath + '}';
    }

    
}
