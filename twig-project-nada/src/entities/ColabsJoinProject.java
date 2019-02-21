/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author esprit
 */
public class ColabsJoinProject {
    private int id;
    private int idP;
    private String titleP;
    private Date terminationDtae;
    private int idT;
    private String titleT;
    private String state;
    private String firstName;
    private String lastName;
    private String mail;
    private int idF;
    private String Languages;

    public ColabsJoinProject() {
    }

    public ColabsJoinProject(int id, int idP,String titleP, Date terminationDtae, int idT, String titleT, String state, String firstName, String lastName, String mail, int idF, String Languages) {
        this.id = id;
        this.idP = idP;
        this.titleP=titleP;
        this.terminationDtae = terminationDtae;
        this.idT = idT;
        this.titleT = titleT;
        this.state = state;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.idF = idF;
        this.Languages = Languages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getTitleP() {
        return titleP;
    }

    public void setTitleP(String titleP) {
        this.titleP = titleP;
    }

    public Date getTerminationDtae() {
        return terminationDtae;
    }

    public void setTerminationDtae(Date terminationDtae) {
        this.terminationDtae = terminationDtae;
    }

    public int getIdT() {
        return idT;
    }

    public void setIdT(int idT) {
        this.idT = idT;
    }

    public String getTitleT() {
        return titleT;
    }

    public void setTitleT(String titleT) {
        this.titleT = titleT;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getIdF() {
        return idF;
    }

    public void setIdF(int idF) {
        this.idF = idF;
    }

    public String getLanguages() {
        return Languages;
    }

    public void setLanguages(String Languages) {
        this.Languages = Languages;
    }

    @Override
    public String toString() {
        return "ColabsJoinProject{" + "id=" + id + ", idP=" + idP + ", titleP=" + titleP + ", terminationDtae=" + terminationDtae + ", idT=" + idT + ", titleT=" + titleT + ", state=" + state + ", firstName=" + firstName + ", lastName=" + lastName + ", mail=" + mail + ", idF=" + idF + ", Languages=" + Languages + '}';
    }
    
}
