package home.forum.Controllers;

public interface linkForumController {
   default void goBack(){};
   default void addCommentToUi(String comment,String name,String postedOn){};
}
