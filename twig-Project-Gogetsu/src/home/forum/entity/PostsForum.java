package home.forum.entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

public class PostsForum {
    private SimpleStringProperty subject, category,description;
    private Date postedOn;
    private Image photo;
    private SimpleIntegerProperty id;
    private SimpleIntegerProperty idUser;

    public PostsForum(String subject, String category,String description ,Date postedOn,int idUser) {
        this.category = new SimpleStringProperty(category);
        this.subject = new SimpleStringProperty(subject);
        this.description = new SimpleStringProperty(description);
        this.postedOn = postedOn;
        this.idUser = new SimpleIntegerProperty(idUser);
    }
    public PostsForum(String subject, String category,String description ,Date postedOn) {
        this.category = new SimpleStringProperty(category);
        this.subject = new SimpleStringProperty(subject);
        this.description = new SimpleStringProperty(description);
        this.postedOn = postedOn;
    }

    public PostsForum(int id, int idUser, String subject, String category, String description , Date postedOn) {
        this.category = new SimpleStringProperty(category);
        this.subject = new SimpleStringProperty(subject);
        this.description = new SimpleStringProperty(description);
        this.postedOn = postedOn;
        this.id = new SimpleIntegerProperty(id);
        this.idUser = new SimpleIntegerProperty(idUser);
    }
    public int getId() { return id.get(); }
    public void setId(int id) { this.id = new SimpleIntegerProperty(id); }
    public int getIdUser() { return idUser.get(); }
    public void setIdUser(int idUser) { this.idUser= new SimpleIntegerProperty(idUser); }

    public String getSubject() {
        return subject.get();
    }
    public void setSubject(String subject) {
        this.subject = new SimpleStringProperty(subject);
    }

    public String getCategory() {
        return category.get();
    }
    public void setCategory(String category) {
        this.category =  new SimpleStringProperty(category);
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description = new SimpleStringProperty(description);
    }

    public Date getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(Date postedOn) {
        this.postedOn = postedOn;
    }

    public String toString()
    {
        return String.format("%s %s %s %d %d", subject, description,category,id.get(),idUser.get());
    }
}
