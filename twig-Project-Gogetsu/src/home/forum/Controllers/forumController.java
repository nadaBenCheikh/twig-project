package home.forum.Controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class forumController implements Initializable,linkForumController {
    @FXML
    private Label author;
    @FXML
    private TextArea description;
    @FXML
    private Label subject;
    @FXML
    private Label postedOn;
    @FXML
    private Button leftPane;

    @FXML
    private Pane pnlCustomer;

    @FXML
    private VBox pnItems;

    private linkForumController linkForumController;

    public void setLinkForumController(linkForumController linkForumController) {
        this.linkForumController = linkForumController;
    }

    public String getAuthor() {
        return author.getText();
    }

    public void setAuthor(String author) {
        this.author.setText(author);
    }

    public String getDescription() {
        return description.getText();
    }

    public void setDescription(String description) {
        this.description.setText(description);
    }

    public String getSubject() {
        return subject.getText();
    }

    public void setSubject(String subject) {
        this.subject.setText(subject);
    }

    public String getPostedOn() {
        return postedOn.getText();
    }

    public void setPostedOn(String postedOn) {
        this.postedOn.setText(postedOn);
    }

    @FXML
    void goBack(ActionEvent event) {
        linkForumController.goBack();
    }
    public void addComment(int index,String comment,String name,String postedOn,String imagePath)
    {
        FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("../fxml/comments.fxml"));
        try {
            pnItems.getChildren().add(index,fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        commentsController controller = fxmlLoader.<commentsController>getController();
        controller.setComment(comment);
        controller.setName(name);
        controller.setPostedOn(postedOn);
        controller.setPicture(new Image(getClass().getResourceAsStream(imagePath)));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addComment(pnItems.getChildren().size(),"aaaaaaa","mon3im","23/05/2018","../../image/avatar/02.jpg");
        FXMLLoader fxmlLoader1 =new FXMLLoader(getClass().getResource("../fxml/sendComment.fxml"));
        try {
            pnItems.getChildren().add(fxmlLoader1.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        commentsController controller1 = fxmlLoader1.<commentsController>getController();
        controller1.setLinkForumController(this);
    }
    @Override
    public void addCommentToUi(String comment,String name,String postedOn)
    {
        System.out.println(comment);
        addComment(pnItems.getChildren().size()-1,comment,name,postedOn,"../../image/avatar/01.jpg");
    }
}
