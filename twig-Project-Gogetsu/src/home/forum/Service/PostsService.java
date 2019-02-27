package home.forum.Service;

import home.forum.entity.PostsForum;
import home.scrumBoard.Service.scrumNotesService;
import home.utils.Connexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static home.Login1.controllers.loginController.userConnect;

public class PostsService {
    private Connexion cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public PostsService() {
        this.cnx = Connexion.getInstance();
    }
    public PostsForum insert(PostsForum posts)
    {
        try {
            String req = "INSERT INTO postsforum (description,subject,category,idUser,postedDate) values(?,?,?,?,?)";

            pst= Connexion.getCnx().prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, posts.getDescription());
            pst.setString(2, posts.getSubject());
            pst.setString(3, posts.getCategory());
            pst.setInt(4, userConnect.getId());  //tijbid il id mil project ki tisna3 projet yit3mal coworking space
            pst.setDate(5, posts.getPostedOn());
            if(pst.executeUpdate()==1){
                rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    posts.setId(rs.getInt(1));
                    return posts;
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public String getsingle(int id) {
        String request = "SELECT * FROM postsforum JOIN users ON postsforum.idUser = users.id WHERE postsforum.id="+id;
        try {
            ste = cnx.getCnx().createStatement();
            rs = ste.executeQuery(request);
            while (rs.next()){
                return rs.getString("firstName")+" "+rs.getString("lastName");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public List<PostsForum> getAll() {
        String request = "SELECT * from postsforum";
        List<PostsForum> list = new ArrayList<>();
        try {
            ste = cnx.getCnx().createStatement();
            rs = ste.executeQuery(request);
            while (rs.next()){
                list.add(new PostsForum(rs.getInt("id"), rs.getInt("idUser"), rs.getString("subject"),rs.getString("category"),rs.getString("description"),rs.getDate("postedDate")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(scrumNotesService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public void delete(int id) {
        String request="DELETE FROM postsforum WHERE id ="+id;
        try {
            ste = cnx.getCnx().createStatement();
            ste.executeUpdate(request);
        } catch (SQLException ex) {
            Logger.getLogger(PostsCommentsService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
