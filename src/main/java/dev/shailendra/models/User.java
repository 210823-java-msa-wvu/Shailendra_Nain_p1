package dev.shailendra.models;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "employees")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empid")
    private Integer id;

    private String firstName;
    private String lastName;
    private String email;
    private String userPass;
    private String jobTitle;

//    @OneToOne
//    @JoinColumn(name="empid")
    private Integer departmentId;

    public User() {
    }

    public User(String email, String userPass) {
        this.email = email;
        this.userPass = userPass;
    }

    public User(String firstName, String lastName, String email, String userPass, String jobTitle, Integer departmentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userPass = userPass;
        this.jobTitle = jobTitle;
        this.departmentId = departmentId;
    }

    public User(Integer id, String firstName, String lastName, String email, String userPass, String jobTitle, Integer departmentId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userPass = userPass;
        this.jobTitle = jobTitle;
        this.departmentId = departmentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", userPass='" + userPass + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }
}
