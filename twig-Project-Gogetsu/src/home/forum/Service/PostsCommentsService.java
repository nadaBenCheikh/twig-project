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
            String req = "INSERT INTO postscomments (idUser,commentaire,postedOn) values(?,?,?)";

            pst= Connexion.getCnx().prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, comment.getIdUser());
            pst.setString(2, comment.getCommentaire());
            pst.setString(3,comment.getDate());

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
    public void delete(CommentsForum comment) {
        String request="DELETE FROM postscomments WHERE id ="+comment.getId();
        try {
            ste = cnx.getCnx().createStatement();
            ste.executeUpdate(request);
        } catch (SQLException ex) {
            Logger.getLogger(PostsCommentsService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<CommentsForum> getAll() {
        String request = "SELECT * from postscomments";
        List<CommentsForum> list = new ArrayList<>();
        try {
            ste = cnx.getCnx().createStatement();
            rs = ste.executeQuery(request);
            while (rs.next()){
                list.add(new CommentsForum(rs.getInt("id"), rs.getInt("idUser"), rs.getString("commentaire"),rs.getString("postedOn")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(scrumNotesService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
