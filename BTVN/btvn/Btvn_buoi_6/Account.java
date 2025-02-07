package Btvn_buoi_6;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Account {
    private int id;
    private double balance = 0.0;
    public double annuallnterestRate;
    Date dateCreated = new Date();

    public Account() {
    }

    public Account(int id, double balance, double annuallnterestRate) {
        this.id = id;
        this.balance = balance;
        this.annuallnterestRate = annuallnterestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnuallnterestRate() {
        return annuallnterestRate;
    }

    public void setAnnuallnterestRate(double annuallnterestRate) {
        this.annuallnterestRate = annuallnterestRate;
    }

    public String getDateCreated() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(dateCreated);
    }

    public double getMonthlyAnnuallnterestRate() {
        double laiSuatHangThang = this.annuallnterestRate / 12;
        return laiSuatHangThang;
    }

    public double getMonthlyInterest(){
        return this.balance * getMonthlyAnnuallnterestRate();
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

}
