package home.forum.entity;

public class CommentsForum {
    private int id;
    private int idUser;
    private String commentaire;
    private String date;

    public CommentsForum(int idUser, String commentaire, String date) {
        this.idUser = idUser;
        this.commentaire = commentaire;
        this.date = date;
    }

    public CommentsForum(int id, int idUser, String commentaire, String date) {
        this.id = id;
        this.idUser = idUser;
        this.commentaire = commentaire;
        this.date = date;
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
