package home.forum.Controllers;

import com.jfoenix.controls.JFXButton;
import home.forum.Service.PostsService;
import home.forum.entity.PostsForum;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import tray.notification.TrayNotification;

import java.util.Calendar;
import java.util.Date;


public class forumAddController {

    @FXML
    private JFXButton addPostButton;

    @FXML
    private Button leftPane;

    @FXML
    private Label subject1;

    @FXML
    private Label author;

    @FXML
    private Label subject;

    @FXML
    private TextArea description;

    @FXML
    private Pane pnlCustomer;

    @FXML
    private VBox pnItems;
    @FXML
    private TextField category;

    @FXML
    private TextField title;
    private linkForumController linkForumController;
    public void setLinkForumController(linkForumController linkForumController) {
        this.linkForumController = linkForumController;
    }
    @FXML
    void goBack(ActionEvent event) {
        linkForumController.goBack();
    }

    @FXML
    void addModal(ActionEvent event) {
        PostsService postsService = new PostsService();
        if (!subject.getText().isEmpty()&&!description.getText().isEmpty()&&!category.getText().isEmpty()) {
            //Date date =new Date();
            PostsForum postsForum = new PostsForum(subject.getText(),category.getText(),description.getText(), new java.sql.Date(Calendar.getInstance().getTime().getTime()));
            postsService.insert(postsForum);
            Image whatsAppImg = new Image("https://cdn4.iconfinder.com/data/icons/iconsimple-logotypes/512/whatsapp-128.png");
            TrayNotification tray = new TrayNotification();
            tray.setImage(whatsAppImg);
            tray.setRectangleFill(Paint.valueOf("#2A9A84"));
            tray.setTitle("sucess");
            tray.setMessage("Ajout avec succes");
            tray.showAndDismiss(Duration.seconds(2));
            linkForumController.setPosts();
            linkForumController.goBack();
        }
    }

}
