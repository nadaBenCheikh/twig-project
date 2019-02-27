package home.utils.entity;

public class user {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
    private String region;
    private String 	picturePath;

    public user(int id, String firstName, String lastName, String picturePath) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.picturePath = picturePath;
    }

    public user(int id, String firstName, String lastName, String email, String password, String role, String region, String picturePath) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.region = region;
        this.picturePath = picturePath;
    }

    public user(String firstName, String lastName, String email, String password, String role, String region, String picturePath) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.region = region;
        this.picturePath = picturePath;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }
}
