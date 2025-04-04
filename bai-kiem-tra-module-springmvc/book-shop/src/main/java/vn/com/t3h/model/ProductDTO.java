package vn.com.t3h.model;

public class ProductDTO {
    private int id;
    private String bookTitle;
    private String author;
    private int pageCount;
    private String publisher;
    private int publicationYear;
    private String genre;
    private double price;
    private double discount;
    private int stockQuantity;
    private String description;

    public ProductDTO() {}

    public ProductDTO(int id,
                      String bookTitle,
                      String author,
                      int pageCount,
                      String publisher,
                      int publicationYear,
                      String genre,
                      double price,
                      double discount,
                      int stockQuantity,
                      String description) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.author = author;
        this.pageCount = pageCount;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.genre = genre;
        this.price = price;
        this.discount = discount;
        this.stockQuantity = stockQuantity;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", bookTitle='" + bookTitle + '\'' +
                ", author='" + author + '\'' +
                ", pageCount=" + pageCount +
                ", publisher='" + publisher + '\'' +
                ", publicationYear=" + publicationYear +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", stockQuantity=" + stockQuantity +
                ", description='" + description + '\'' +
                '}';
    }
}
