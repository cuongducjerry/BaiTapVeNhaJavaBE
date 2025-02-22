package vn.com.t3h.book.model;

public class OrderedModel {
    private int idOrdered;
    private String datePurchase;
    private String nameProduct;
    private double price;
    private String status;
    private int customerId;

    public OrderedModel(){
    }

    public OrderedModel(int idOrdered, String datePurchase, String nameProduct, double price, String status, int customerId) {
        this.idOrdered = idOrdered;
        this.datePurchase = datePurchase;
        this.nameProduct = nameProduct;
        this.price = price;
        this.status = status;
        this.customerId = customerId;
    }

    public int getIdOrdered() {
        return idOrdered;
    }

    public void setIdOrdered(int idOrdered) {
        this.idOrdered = idOrdered;
    }

    public String getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(String datePurchase) {
        this.datePurchase = datePurchase;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "OrderedModel{" +
                "idOrdered=" + idOrdered +
                ", datePurchase='" + datePurchase + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", customerId=" + customerId +
                '}';
    }
}
