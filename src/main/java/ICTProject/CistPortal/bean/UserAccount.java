package ICTProject.CistPortal.bean;

import java.io.Serializable;

public class UserAccount implements Serializable {
    private String id;
    private String lastName;
    private String firstName;
    private String grade;
    private int roleId;

    public UserAccount() { }

    public UserAccount(String id, String lastName, String firstName, String grade, int roleId) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.grade = grade;
        this.roleId = roleId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}