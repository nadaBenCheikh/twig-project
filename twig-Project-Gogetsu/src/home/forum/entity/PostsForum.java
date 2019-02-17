package home.forum.entity;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;

import java.time.LocalDate;
import java.time.Period;

public class PostsForum {
    private SimpleStringProperty subject, category,description;
    private LocalDate postedOn;
    private Image photo;

    public PostsForum(String subject, String category,String description ,LocalDate postedOn) {
        this.category = new SimpleStringProperty(category);
        this.subject = new SimpleStringProperty(subject);
        this.description = new SimpleStringProperty(description);
        this.postedOn = postedOn;
    }

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

    public LocalDate getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(LocalDate postedOn) {
        this.postedOn = postedOn;
    }

    public String toString()
    {
        return String.format("%s %s %s", subject, description,category);
    }
}
