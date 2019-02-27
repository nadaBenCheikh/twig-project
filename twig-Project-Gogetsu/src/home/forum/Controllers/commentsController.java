package home.forum.Controllers;

import home.forum.Service.PostsCommentsService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Date;

import static home.Login1.controllers.loginController.userConnect;


public class commentsController {

    @FXML
    private Label name;

    @FXML
    private Label postedOn;

    @FXML
    private TextArea comment;

    @FXML
    private ImageView picture;
    @FXML
    private TextField textTosend;

    @FXML
    private VBox sendBox;

    @FXML
    private HBox itemC;

    @FXML
    private Button send;

    @FXML
    private ImageView myPicture;

    @FXML
    private Button delete;

    @FXML
    private HBox pane;

    private linkForumController linkForumController;
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLinkForumController(linkForumController linkForumController) {
        this.linkForumController = linkForumController;
    }
    void enableDelete(){
        delete.setDisable(false);
    }
    @FXML
    void sendButton(ActionEvent event) {
        linkForumController.addCommentToUi(textTosend.getText(), userConnect.getFirstName()+" "+userConnect.getLastName(),new Date().toString());
        textTosend.clear();
    }
    @FXML
    void deleteMethod(ActionEvent event) {
            PostsCommentsService postsCommentsService = new PostsCommentsService();
            postsCommentsService.delete(id);
            pane.getChildren().clear();
    }

    public String getName() {
        return name.getText();
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public String getPostedOn() {
        return postedOn.getText();
    }

    public void setPostedOn(String postedOn) {
        this.postedOn.setText(postedOn);
    }

    public String getComment() {
        return comment.getText();
    }

    public void setComment(String comment) {
        this.comment.setText(comment);
    }

    public ImageView getPicture() {
        return picture;
    }

    public void setPicture(Image picture) {
        this.picture.setImage(picture);
    }

    public ImageView getMyPicture() {
        return myPicture;
    }

    public void setMyPicture(Image  myPicture) {
        this.myPicture.setImage(myPicture);
    }

}
