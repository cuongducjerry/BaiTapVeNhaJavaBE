package BTVN.btvn.BaiKiemTraThucHanh2;

import java.util.ArrayList;
import java.util.List;
// account
public class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private Employee employeeInCharge;
    private List<Transaction> transactions = new ArrayList<>();

    public Account() {
    }

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Account(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Employee getEmployeeInCharge() {
        return employeeInCharge;
    }

    public void setEmployeeInCharge(Employee employeeInCharge) {
        this.employeeInCharge = employeeInCharge;
    }

    public void deposit(double amount) throws Exception {
        if(amount > 0){
            this.balance += amount;
        }
        else{
            throw new Exception("Số tiền cần nạp phải lớn hơn 0!");
        }
    }

    public void withdraw(double amount) throws Exception {
        if(this.balance >= amount) {
            this.balance -= amount;
        }
        else{
            throw new Exception("Số tiền rút quá số dư hiện tại!");
        }
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void nhapThongTinTaiKhoan(){
        this.accountNumber = Utils.getString("Nhập vào số tài khoản của bạn: ");
        this.accountHolder = Utils.getString("Nhập vào tên chủ tài khoản: ");
        this.balance = Utils.getDouble("Nhập vào số dư ban đầu: ");
    }

    public void inThongTinTaiKhoan(){
        System.out.println("Số tài khoản: " + this.accountNumber);
        System.out.println("Tên chủ tài khoản: " + this.accountHolder);
        System.out.println("Số dư ban đầu: " + this.balance);
        System.out.println("Nhân viên phụ trách: " + this.employeeInCharge.getName());
    }

}
