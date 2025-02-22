package vn.com.t3h.book.model;

public class ProductModel {
    private Integer id;
    private String name;
    private Double price;
    private Double discount;
    private Integer quantity;
    private Integer totalBuy;
    private String author;
    private Integer pages;
    private String publisher;
    private String yearPublishing;
    private String description;
    private String imageName;
    private Integer shop;
    private String createdAt;
    private String updatedAt;
    private String startsAt;
    private String endsAt;
    private String created_by;

    public ProductModel() {}

    public ProductModel(Integer id, String name, Double price, Double discount, Integer quantity,
                        Integer totalBuy, String author, Integer pages, String publisher, String yearPublishing,
                        String description, String imageName, Integer shop, String createdAt, String updatedAt,
                        String startsAt, String endsAt, String created_by) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.quantity = quantity;
        this.totalBuy = totalBuy;
        this.author = author;
        this.pages = pages;
        this.publisher = publisher;
        this.yearPublishing = yearPublishing;
        this.description = description;
        this.imageName = imageName;
        this.shop = shop;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.startsAt = startsAt;
        this.endsAt = endsAt;
        this.created_by = created_by;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTotalBuy() {
        return totalBuy;
    }

    public void setTotalBuy(Integer totalBuy) {
        this.totalBuy = totalBuy;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getYearPublishing() {
        return yearPublishing;
    }

    public void setYearPublishing(String yearPublishing) {
        this.yearPublishing = yearPublishing;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Integer getShop() {
        return shop;
    }

    public void setShop(Integer shop) {
        this.shop = shop;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(String startsAt) {
        this.startsAt = startsAt;
    }

    public String getEndsAt() {
        return endsAt;
    }

    public void setEndsAt(String endsAt) {
        this.endsAt = endsAt;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", quantity=" + quantity +
                ", totalBuy=" + totalBuy +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", publisher='" + publisher + '\'' +
                ", yearPublishing='" + yearPublishing + '\'' +
                ", description='" + description + '\'' +
                ", imageName='" + imageName + '\'' +
                ", shop=" + shop +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", startsAt='" + startsAt + '\'' +
                ", endsAt='" + endsAt + '\'' +
                ", created_by='" + created_by + '\'' +
                '}';
    }
}
