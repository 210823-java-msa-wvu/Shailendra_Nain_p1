package dev.shailendra.models;

import javax.persistence.*;

@Entity
@Table(name="benefitsbalance")
public class AccountBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bid")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "empid")
    private User user;

    @Column(name = "bamount")
    private double blanceAmount;

    @Column(name="awamount")
    private double awardedAmount;

    @Column(name="penamount")
    private double pendingAmount;

    public AccountBalance() {
    }

    public AccountBalance(User user, double blanceAmount, double awardedAmount, double pendingAmount) {
        this.user = user;
        this.blanceAmount = blanceAmount;
        this.awardedAmount = awardedAmount;
        this.pendingAmount = pendingAmount;
    }

    public AccountBalance(Integer id, User user, double blanceAmount, double awardedAmount, double pendingAmount) {
        this.id = id;
        this.user = user;
        this.blanceAmount = blanceAmount;
        this.awardedAmount = awardedAmount;
        this.pendingAmount = pendingAmount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getBlanceAmount() {
        return blanceAmount;
    }

    public void setBlanceAmount(double blanceAmount) {
        this.blanceAmount = blanceAmount;
    }

    public double getAwardedAmount() {
        return awardedAmount;
    }

    public void setAwardedAmount(double awardedAmount) {
        this.awardedAmount = awardedAmount;
    }

    public double getPendingAmount() {
        return pendingAmount;
    }

    public void setPendingAmount(double pendingAmount) {
        this.pendingAmount = pendingAmount;
    }

    @Override
    public String toString() {
        return "AccountBalance{" +
                "id=" + id +
                ", user=" + user +
                ", blanceAmount=" + blanceAmount +
                ", awardedAmount=" + awardedAmount +
                ", pendingAmount=" + pendingAmount +
                '}';
    }
}
