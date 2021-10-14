package dev.shailendra.models;

import javax.persistence.*;

@Entity
@Table(name="useraccount")
public class AccountBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "empid")
    private User user;

    private Integer amount;
    private Integer awarded;
    private Integer pending;

    public AccountBalance() {
    }

    public AccountBalance(User user, Integer amount, Integer awarded, Integer pending) {
        this.user = user;
        this.amount = amount;
        this.awarded = awarded;
        this.pending = pending;
    }

    public AccountBalance(Integer id, User user, Integer amount, Integer awarded, Integer pending) {
        this.id = id;
        this.user = user;
        this.amount = amount;
        this.awarded = awarded;
        this.pending = pending;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAwarded() {
        return awarded;
    }

    public void setAwarded(Integer awarded) {
        this.awarded = awarded;
    }

    public Integer getPending() {
        return pending;
    }

    public void setPending(Integer pending) {
        this.pending = pending;
    }

    @Override
    public String toString() {
        return "AccountBalance{" +
                "id=" + id +
                ", user=" + user +
                ", amount=" + amount +
                ", awarded=" + awarded +
                ", pending=" + pending +
                '}';
    }
}
