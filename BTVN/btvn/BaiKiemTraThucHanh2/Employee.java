package BTVN.btvn.BaiKiemTraThucHanh2;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    public String id;
    public String name;
    public double salary;
    private List<Account> manageAccounts = new ArrayList<>();

    public Employee() {
    }

    public Employee(String id, String name){
        this.id = id;
        this.name = name;
    }

    public Employee(String id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Account> getManageAccounts() {
        return manageAccounts;
    }

    public void setManageAccounts(List<Account> manageAccounts) {
        this.manageAccounts = manageAccounts;
    }

    public void hienThiThongTinNhanVien(){
        System.out.println("ID: " + this.id);
        System.out.println("Tên: " + this.name);
        System.out.println("Lương cơ bản: " + this.salary);
    }

    public int laySoLuongTaiKhoanQuanLy() throws Exception{
        List<Account> accounts = getManageAccounts();

        if(accounts == null){
            throw new Exception("Danh sách tài khoản không tồn tại !");
        }

        if(!accounts.isEmpty()){
            return accounts.size();
        }

        return 0;
    }

}
