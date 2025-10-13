package ma.fstt.atelier1.entities;



public class Product {
    private long id;
    private double price;
    private String description;
    private String productName;
    private int stock;
    private String category;

    // Constructors
    public Product() {}

    public Product(long id, double price, String description, String productName, int stock, String category) {
        this.id = id;
        this.price = price;
        this.description = description;
        this.productName = productName;
        this.stock = stock;
        this.category = category;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", productName='" + productName + '\'' +
                ", stock=" + stock +
                ", category='" + category + '\'' +
                '}';
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
