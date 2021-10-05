package dev.shailendra.models;

import javax.persistence.*;


import java.sql.Time;
import java.sql.Date;
@Entity
@Table(name = "reimapplication")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appid")
    private Integer id;

     @Column(name ="eventype")
    private String eventType;
    private String description;
    private double fees;

    @Column(name = "appdate")
    private Date date;


    @Column(name = "apptime")
    private Time time;

    @Column(name = "applocation")
    private String location;

    @Column(name = "appjustification")
    private String justification;
    private boolean supervisor;
    private boolean manager;
    private boolean benco;

    @ManyToOne
    @JoinColumn(name = "empid")
    private User user;

    public Application() {
    }

    public Application(String eventType, String description, double fees, Date date, Time time, String location, String justification, boolean supervisor, boolean manager, boolean benco, User user) {
        this.eventType = eventType;
        this.description = description;
        this.fees = fees;
        this.date = date;
        this.time = time;
        this.location = location;
        this.justification = justification;
        this.supervisor = supervisor;
        this.manager = manager;
        this.benco = benco;
        this.user = user;
    }

    public Application(Integer id, String eventType, String description, double fees, Date date, Time time, String location, String justification, boolean supervisor, boolean manager, boolean benco, User user) {
        this.id = id;
        this.eventType = eventType;
        this.description = description;
        this.fees = fees;
        this.date = date;
        this.time = time;
        this.location = location;
        this.justification = justification;
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

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public boolean isSupervisor() {
        return supervisor;
    }

    public void setSupervisor(boolean supervisor) {
        this.supervisor = supervisor;
    }

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }

    public boolean isBenco() {
        return benco;
    }

    public void setBenco(boolean benco) {
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
                ", eventType='" + eventType + '\'' +
                ", description='" + description + '\'' +
                ", fees=" + fees +
                ", date=" + date +
                ", time=" + time +
                ", location='" + location + '\'' +
                ", justification='" + justification + '\'' +
                ", supervisor=" + supervisor +
                ", manager=" + manager +
                ", benco=" + benco +
                ", user=" + user +
                '}';
    }
}
