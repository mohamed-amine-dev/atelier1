package ma.fstt.atelier1.entities;


import java.time.LocalDateTime;

public class Order {
    private long id;
    private long clientId;
    private LocalDateTime dateCommand;
    private double totalAmount;

    // Constructors
    public Order() {}

    public Order(long id, long clientId, LocalDateTime dateCommand, double totalAmount) {
        this.id = id;
        this.clientId = clientId;
        this.dateCommand = dateCommand;
        this.totalAmount = totalAmount;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getDateCommand() {
        return dateCommand;
    }

    public void setDateCommand(LocalDateTime dateCommand) {
        this.dateCommand = dateCommand;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", dateCommand=" + dateCommand +
                ", totalAmount=" + totalAmount +
                '}';
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
