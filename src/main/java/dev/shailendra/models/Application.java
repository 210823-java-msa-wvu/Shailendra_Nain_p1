package dev.shailendra.models;




import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.type.TimeType;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;


@Entity
@Table(name = "reimapplication")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appid")
    private Integer id;

    private String eventype;
    private String description;
    private Integer fees;
    private String grade;
    private String appdate;
    private String apptime;
    private String applocation;
    private String appjustification;
    private String supervisor;
    private String manager;
    private String benco;

    @ManyToOne
    @JoinColumn(name = "empid")
    private User user;

    public Application() {
    }

    public Application(Integer id, String supervisor, String manager, String benco) {
        this.id = id;
        this.supervisor = supervisor;
        this.manager = manager;
        this.benco = benco;
    }

    public Application(String eventype, String description, Integer fees, String grade, String appdate, String apptime, String applocation, String appjustification, User user) {
        this.eventype = eventype;
        this.description = description;
        this.fees = fees;
        this.grade = grade;
        this.appdate = appdate;
        this.apptime = apptime;
        this.applocation = applocation;
        this.appjustification = appjustification;
        this.user = user;
    }

    public Application(String eventype, String description, Integer fees, String grade, String appdate, String apptime, String applocation, String appjustification, String supervisor, String manager, String benco, User user) {
        this.eventype = eventype;
        this.description = description;
        this.fees = fees;
        this.grade = grade;
        this.appdate = appdate;
        this.apptime = apptime;
        this.applocation = applocation;
        this.appjustification = appjustification;
        this.supervisor = supervisor;
        this.manager = manager;
        this.benco = benco;
        this.user = user;
    }

    public Application(Integer id, String eventype, String description, Integer fees, String grade, String appdate, String apptime, String applocation, String appjustification, String supervisor, String manager, String benco, User user) {
        this.id = id;
        this.eventype = eventype;
        this.description = description;
        this.fees = fees;
        this.grade = grade;
        this.appdate = appdate;
        this.apptime = apptime;
        this.applocation = applocation;
        this.appjustification = appjustification;
        this.supervisor = supervisor;
        this.manager = manager;
        this.benco = benco;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEventype() {
        return eventype;
    }

    public void setEventype(String eventype) {
        this.eventype = eventype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getFees() {
        return fees;
    }

    public void setFees(Integer fees) {
        this.fees = fees;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getAppdate() {
        return appdate;
    }

    public void setAppdate(String appdate) {
        this.appdate = appdate;
    }

    public String getApptime() {
        return apptime;
    }

    public void setApptime(String apptime) {
        this.apptime = apptime;
    }

    public String getApplocation() {
        return applocation;
    }

    public void setApplocation(String applocation) {
        this.applocation = applocation;
    }

    public String getAppjustification() {
        return appjustification;
    }

    public void setAppjustification(String appjustification) {
        this.appjustification = appjustification;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getBenco() {
        return benco;
    }

    public void setBenco(String benco) {
        this.benco = benco;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", eventype='" + eventype + '\'' +
                ", description='" + description + '\'' +
                ", fees=" + fees +
                ", grade='" + grade + '\'' +
                ", appdate=" + appdate +
                ", apptime=" + apptime +
                ", applocation='" + applocation + '\'' +
                ", appjustification='" + appjustification + '\'' +
                ", supervisor='" + supervisor + '\'' +
                ", manager='" + manager + '\'' +
                ", benco='" + benco + '\'' +
                ", user=" + user +
                '}';
    }
}
