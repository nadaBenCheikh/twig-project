package home.forum.entity;

public class CommentsForum {
    private int id;
    private int idUser;
    private String commentaire;
    private String date;
    private String FullName;

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    private int idPost;


    public CommentsForum(int idUser, String commentaire, String date,int idPost) {
        this.idUser = idUser;
        this.commentaire = commentaire;
        this.date = date;
        this.idPost= idPost;
    }

    public CommentsForum(int id, int idUser, String commentaire, String date) {
        this.id = id;
        this.idUser = idUser;
        this.commentaire = commentaire;
        this.date = date;
    }
    public CommentsForum(int id,String FullName, String commentaire, String date,int idUser) {
        this.id = id;
        this.commentaire = commentaire;
        this.date = date;
        this.FullName = FullName;
        this.idUser=idUser;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
