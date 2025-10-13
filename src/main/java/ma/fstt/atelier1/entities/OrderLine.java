package ma.fstt.atelier1.entities;


public class OrderLine {
    private long id;
    private long productId;
    private long orderId;
    private double unitPrice;
    private int quantity;
    private double subTotal;

    // Constructors
    public OrderLine() {}

    public OrderLine(long id, long productId, long orderId, double unitPrice, int quantity, double subTotal) {
        this.id = id;
        this.productId = productId;
        this.orderId = orderId;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.subTotal = subTotal;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "id=" + id +
                ", productId=" + productId +
                ", orderId=" + orderId +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                ", subTotal=" + subTotal +
                '}';
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
}
