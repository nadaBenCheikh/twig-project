package home.scrumBoard.Entity;

import java.util.Date;

public class scrumNotes {

    private int id;
    private String title;
    private String description;
    private String postedOn;
    private int userId;
    private int projectId;

    public scrumNotes(int id, String title, String description, String postedOn, int userId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.postedOn = postedOn;
        this.userId = userId;
    }

    public scrumNotes(String title, String description, String postedOn, int userId) {
        this.title = title;
        this.description = description;
        this.postedOn = postedOn;
        this.userId = userId;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(String postedOn) {
        this.postedOn = postedOn;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
}
