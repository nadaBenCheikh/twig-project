package home.forum.Controllers;
import com.jfoenix.controls.JFXButton;
import home.forum.Service.PostsCommentsService;
import home.forum.Service.PostsService;
import home.forum.entity.CommentsForum;
import home.utils.service.userService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import tray.notification.TrayNotification;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static home.Login1.controllers.loginController.userConnect;

public class forumController implements Initializable,linkForumController {
    @FXML
    private ImageView image;
    @FXML
    private JFXButton deletePostButton;
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
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
    public void addComment(int id,int index,String comment,String name,String postedOn,String imagePath)
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
        controller.setId(id);
        controller.setPicture(new Image(getClass().getResourceAsStream(imagePath)));
        if (name.equals(userConnect.getFirstName()+" "+userConnect.getLastName()))
            controller.enableDelete();
    }
    public void getComments(){
        PostsCommentsService postsCommentsService = new PostsCommentsService();
        userService userService = new userService();
        for (CommentsForum c: postsCommentsService.getAll(id)) {
            System.out.println(userService.get(c.getIdUser()).getPicturePath());
            addComment(c.getId(),pnItems.getChildren().size(),c.getCommentaire(),c.getFullName(),c.getDate(),"../../image/"+userService.get(c.getIdUser()).getPicturePath());
        }
        FXMLLoader fxmlLoader1 =new FXMLLoader(getClass().getResource("../fxml/sendComment.fxml"));
        try {
            pnItems.getChildren().add(fxmlLoader1.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        commentsController controller1 = fxmlLoader1.<commentsController>getController();
        //System.out.println("../../"+UserInstance.getUser1().getPicturePath());
        //controller1.setMyPicture(new Image(getClass().getResourceAsStream("../../"+userConnect.getPicturePath())));
        controller1.setLinkForumController(this);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        deletePostButton.setDisable(false);
    }
    @Override
    public void addCommentToUi(String comment,String name,String postedOn)
    {
        PostsCommentsService postsCommentsService =new PostsCommentsService();
        CommentsForum commentsForum =postsCommentsService.insert(new CommentsForum(userConnect.getId(),comment,postedOn,id));
        addComment(commentsForum.getId(),pnItems.getChildren().size()-1,comment,name,postedOn,"../../image/"+userConnect.getPicturePath());
    }
    @FXML
    void deletePost(ActionEvent event) {
        PostsService postsService = new PostsService();
        postsService.delete(id);
        linkForumController.setPosts();
        linkForumController.goBack();
        Image whatsAppImg = new Image("https://cdn4.iconfinder.com/data/icons/iconsimple-logotypes/512/whatsapp-128.png");
        TrayNotification tray = new TrayNotification();
        tray.setImage(whatsAppImg);
        tray.setRectangleFill(Paint.valueOf("#2A9A84"));
        tray.setTitle("sucess");
        tray.setMessage("suppression avec succes");
        tray.showAndDismiss(Duration.seconds(2));
        //System.out.println(id);
    }
}
