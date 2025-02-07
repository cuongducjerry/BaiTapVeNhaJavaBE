package BTVN.btvn.BaiKiemTraThucHanh2;

import java.time.LocalDateTime;

public class Transaction {
    private String transactionId;
    protected Account account;
    protected Employee employee;
    private String type;
    private double amount;
    private LocalDateTime timestamp;
    private static int count = 0;

    public Transaction(){};

    public Transaction(String type, double amount, Employee employee) {
        count++;
        this.transactionId = "T" + String.format("%03d", count);
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
        this.employee = employee;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void inThongTinGiaoDich(){
        System.out.println("ID: " + this.transactionId + ", " + "Loại:" + this.type + ", "
                + "Số tiền: " + this.amount + ", " + "Thời gian: " + this.timestamp + ", " + "Nhân viên: " + this.employee.getName());
    }

}
