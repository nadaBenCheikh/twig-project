/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.Login1.entite;

/**
 *
 * @author esprit
 */
public class Freelancer {
    private int id;
    private int userId;
    private String languages ;
    private int minHourlyFee ;
    private int gender ;
    private String cvLink;
    private int maxHourlyFee;
    private String ranking ;

    public Freelancer() {
    }

    public Freelancer(String languages, int minHourlyFee, int gender, 
            String cvLink, int maxHourlyFee, String ranking) {
        this.languages = languages;
        this.minHourlyFee = minHourlyFee;
        this.gender = gender;
        this.cvLink = cvLink;
        this.maxHourlyFee = maxHourlyFee;
        this.ranking = ranking;
    }

    public Freelancer(int id, int userId, String languages, int minHourlyFee, 
            int gender, String cvLink, int maxHourlyFee, String ranking) {
        this.id = id;
        this.userId = userId;
        this.languages = languages;
        this.minHourlyFee = minHourlyFee;
        this.gender = gender;
        this.cvLink = cvLink;
        this.maxHourlyFee = maxHourlyFee;
        this.ranking = ranking;
    }

    public Freelancer(int userId, String languages, int minHourlyFee, int gender,
            String cvLink, int maxHourlyFee, String ranking) {
        this.userId = userId;
        this.languages = languages;
        this.minHourlyFee = minHourlyFee;
        this.gender = gender;
        this.cvLink = cvLink;
        this.maxHourlyFee = maxHourlyFee;
        this.ranking = ranking;
    }
    


    public Freelancer(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getMinHourlyFee() {
        return minHourlyFee;
    }

    public void setMinHourlyFee(int minHourlyFee) {
        this.minHourlyFee = minHourlyFee;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getCvLink() {
        return cvLink;
    }

    public void setCvLink(String cvLink) {
        this.cvLink = cvLink;
    }

    public int getMaxHourlyFee() {
        return maxHourlyFee;
    }

    public void setMaxHourlyFee(int maxHourlyFee) {
        this.maxHourlyFee = maxHourlyFee;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return "Freelancer{" + "id=" + id + ", userId=" + userId + ", languages=" +
                languages + ", minHourlyFee=" + minHourlyFee + ", gender=" + 
                gender + ", cvLink=" + cvLink + ", maxHourlyFee=" + maxHourlyFee 
                + ", ranking=" + ranking + '}';
    }
    
    
  
    
}
