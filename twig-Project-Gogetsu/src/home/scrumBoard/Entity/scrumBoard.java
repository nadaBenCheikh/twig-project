package home.scrumBoard.Entity;

public class scrumBoard {
    private int id;
    private int projectId;
    private String title;
    private String description;

    public scrumBoard(int id, int projectId, String title, String description) {
        this.id = id;
        this.projectId = projectId;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
