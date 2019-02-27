package home.scrumBoard.Entity;

import javafx.scene.input.DataFormat;

import java.io.Serializable;
import java.util.Date;

public class scrumNotes implements Serializable {
    public static final DataFormat DATA_FORMAT = new DataFormat("home.scrumBoard.Entity.scrumNote");
    private int id;
    private String title;
    private String description;
    private String postedOn;
    private String state;
    private int userId;
    private int scrumboardId;

    public scrumNotes(int id, String title, String description, String postedOn, int userId,int scrumboardId,String state) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.postedOn = postedOn;
        this.userId = userId;
        this.scrumboardId = scrumboardId;
        this.state=state;
    }

    public scrumNotes(int id, String title, String description, String postedOn, int userId,int scrumboardId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.postedOn = postedOn;
        this.userId = userId;
        this.scrumboardId = scrumboardId;
    }

    public scrumNotes(String title, String description, String postedOn, int userId,int scrumboardId) {
        this.title = title;
        this.description = description;
        this.postedOn = postedOn;
        this.userId = userId;
        this.scrumboardId = scrumboardId;
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

    public int getScrumboardId() {
        return scrumboardId;
    }

    public void setScrumboardId(int scrumboardId) {
        this.scrumboardId = scrumboardId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
