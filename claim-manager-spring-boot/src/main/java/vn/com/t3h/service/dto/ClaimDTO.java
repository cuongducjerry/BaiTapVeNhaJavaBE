package vn.com.t3h.service.dto;


import java.time.LocalDate;

public class ClaimDTO {

    private String code;
    private String customerName;
    private String email;
    private String phone;
    private String nameProduct;
    private LocalDate claimDate;
    private String coverageProduct;
    private String statusName;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(LocalDate claimDate) {
        this.claimDate = claimDate;
    }

    public String getCoverageProduct() {
        return coverageProduct;
    }

    public void setCoverageProduct(String coverageProduct) {
        this.coverageProduct = coverageProduct;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
