package vn.com.t3h.book.model;

public class OrderTemp {
    private Integer id;
    private String name;
    private double price;
    private int quantity;
    private int customerId;

    public OrderTemp(){
    }

    public OrderTemp(Integer id, String name, double price, int quantity, int customerId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.customerId = customerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "OrderTemp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", customerId=" + customerId +
                '}';
    }
}
