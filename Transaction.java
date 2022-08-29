package co.misiontic;

import java.util.Date;

/**
 *
 * @author Marieth Perpiñan
 */
public class Transaction {
        
    private String concept;
    private float amount;
    private User user;
    private Enterprise enterprise;
    private Date createdAt;
    private Date updatedAt;

    public Transaction() {
    }

    public Transaction(String concept, float amount, User user, Enterprise enterprise, Date createdAt, Date updatedAt) {
        this.concept = concept;
        this.amount = amount;
        this.user = user;
        this.enterprise = enterprise;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
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

    @Override
    public String toString() {
        return "Transaction{" + "concept=" + concept + ", amount=" + amount + ", user=" + user + ", enterprise=" + enterprise + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }
    
}
