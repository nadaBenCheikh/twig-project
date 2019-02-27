/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author esprit
 */
public class jointure {
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

    private int userId;
    private String languages ;
    private int minHourlyFee ;
    private int gender ;
    private String cvLink;
    private int maxHourlyFee;
    private String ranking ;

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

    public jointure(int id, String firstName, String lastName, String email, String password, String role, int rating, int phone, String region, String description, String picturePath, int state, int userId, String languages, int minHourlyFee, int gender, String cvLink, int maxHourlyFee, String ranking) {
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
        this.userId = userId;
        this.languages = languages;
        this.minHourlyFee = minHourlyFee;
        this.gender = gender;
        this.cvLink = cvLink;
        this.maxHourlyFee = maxHourlyFee;
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return "jointure{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password + ", role=" + role + ", rating=" + rating + ", phone=" + phone + ", region=" + region + ", description=" + description + ", picturePath=" + picturePath + ", state=" + state + ", userId=" + userId + ", languages=" + languages + ", minHourlyFee=" + minHourlyFee + ", gender=" + gender + ", cvLink=" + cvLink + ", maxHourlyFee=" + maxHourlyFee + ", ranking=" + ranking + '}';
    }
    
    
    
    
}
