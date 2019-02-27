package home.forum.Service;

import home.forum.entity.CommentsForum;
import home.scrumBoard.Service.scrumNotesService;
import home.utils.Connexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostsCommentsService {
    private Connexion cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public PostsCommentsService() {
        this.cnx = Connexion.getInstance();
    }
    public CommentsForum insert(CommentsForum comment)
    {
        try {
            String req = "INSERT INTO postscomments (idUser,commentaire,postedOn,idPost) values(?,?,?,?)";

            pst= Connexion.getCnx().prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, comment.getIdUser());
            pst.setString(2, comment.getCommentaire());
            pst.setString(3,comment.getDate());
            pst.setInt(4,comment.getIdPost());

            if(pst.executeUpdate()==1){
                rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    comment.setId(rs.getInt(1));
                    return comment;
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public void delete(int id) {
        String request="DELETE FROM postscomments WHERE id ="+id;
        try {
            ste = cnx.getCnx().createStatement();
            ste.executeUpdate(request);
        } catch (SQLException ex) {
            Logger.getLogger(PostsCommentsService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<CommentsForum> getAll(int id) {
        String request = "SELECT * FROM `postscomments` JOIN users on postscomments.idUser = users.id where idPost="+id;
        List<CommentsForum> list = new ArrayList<>();
        try {
            ste = cnx.getCnx().createStatement();
            rs = ste.executeQuery(request);
            while (rs.next()){
                list.add(new CommentsForum(rs.getInt("id"), rs.getString("firstName")+" "+ rs.getString("lastName"), rs.getString("commentaire"),rs.getString("postedOn"),rs.getInt("idUser")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(scrumNotesService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
