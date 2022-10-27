package TodoApp.model;

import java.util.Date;

public class Project {

    private int id;
    private String emailUser;
    private String name;
    private String Description;
    private Date createdAt;
    private Date updatedAt;

    public Project(int id, String emailUser, String name, String Description, Date createdAt, Date updatedAt) {
        this.id = id;
        this.emailUser = emailUser;
        this.name = name;
        this.Description = Description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Project() {
        this.createdAt = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    @Override
    public String toString() {
        return getName();
    }
    
    

}
