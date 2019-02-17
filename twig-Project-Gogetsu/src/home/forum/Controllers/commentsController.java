package home.forum.Controllers;

import home.forum.Service.PostsCommentsService;
import home.forum.entity.CommentsForum;
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
    private ImageView picture2;

    private linkForumController linkForumController;

    public void setLinkForumController(linkForumController linkForumController) {
        this.linkForumController = linkForumController;
    }

    @FXML
    void sendButton(ActionEvent event) {
        System.out.println(textTosend.getText()); //sajil fil comments DB
        PostsCommentsService postsCommentsService = new PostsCommentsService();
        CommentsForum commentsForum = new CommentsForum(5,textTosend.getText(),new Date().toString());
        //postsCommentsService.insert(commentsForum);
        linkForumController.addCommentToUi(textTosend.getText(),"gog",new Date().toString());
        textTosend.clear();

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

}
