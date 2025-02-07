package BTVN.btvn.BaiKiemTraThucHanh2;

import java.util.*;

public class EmployeeManager {
    public List<Account> AccountManager = new ArrayList<Account>();
    public List<Employee> employees = new ArrayList();
    public List<Transaction> transactions = new ArrayList();
    Account account;
    Account account2;
    Employee employee;
    Set<String> listAccountNumbers = new HashSet<String>();

    public Employee getRandomEmployee() throws Exception {
        if(!employees.isEmpty()) {
            Random rand = new Random();
            return employees.get(rand.nextInt(employees.size()));
        }
        else{
            throw new Exception("Danh sách nhân viên rỗng!");
        }
    }

    public void themTaiKhoan() throws Exception {
        account = new Account();
        account.nhapThongTinTaiKhoan();
        if(listAccountNumbers.contains(account.getAccountNumber())){
            System.err.println("Số tài khoản đã có người đăng kí!!!");
        }
        else{
            AccountManager.add(account);
            listAccountNumbers.add(account.getAccountNumber());
            try{
                employee = getRandomEmployee();
            }catch(Exception e){
                System.err.println(e.getMessage());
            }

                List<Account> listAccount = employee.getManageAccounts();
                listAccount.add(account);
                employee.setManageAccounts(listAccount);
                account.setEmployeeInCharge(employee);
                System.out.println("Tài khoản được thêm thành công!");
                account.inThongTinTaiKhoan();

        }
    }

    public Account getAccount(String accountNumber) {
        for(Account a : AccountManager){
            if((accountNumber).equals(a.getAccountNumber())){
                return a;
            }
        }
        return null;
    }

    public void suaThongTinTaiKhoan(){
        String acNumber = Utils.getString("Nhập vào số tài khoản để xác định tài khoản cần sửa: ");
        if(listAccountNumbers.contains(acNumber)){
            String tenChuTaiKhoanMoi = Utils.getString("Nhập vào tên chủ tài khoản mới: ");
            account = getAccount(acNumber);
            account.setAccountHolder(tenChuTaiKhoanMoi);
            AccountManager.add(account);
            System.out.println("Tài khoản được cập nhật thành công!");
            System.out.println("Số tài khoản: " + account.getAccountNumber());
            System.out.println("Tên chủ tài khoản mới: " + account.getAccountHolder());
        }
        else{
            System.err.println("Số tài khoản không tồn tại!");
        }
    }

    public void xoaTaiKhoan(){
        String acNumber = Utils.getString("Nhập vào số tài khoản cần xóa: ");
        account = getAccount(acNumber);
        if(listAccountNumbers.contains(acNumber) && account.getBalance() > 0){
            System.err.println("Số tài khoản " + account.getAccountNumber());
            System.err.println("Lỗi: Không thể xóa tài khoản " + account.getAccountNumber() + " vì tài khoản còn số dư " + account.getBalance());
            return;
        }
        else if(!account.getTransactions().isEmpty()){
            System.err.println("Tài khoản có giao dịch liên quan, không được phép xóa!");
            return;
        }
        AccountManager.remove(account);
        listAccountNumbers.remove(acNumber);
        System.out.println("Tài khoản " + acNumber + " đã được xóa thành công!");
    }

    public void timKiemTaiKhoan(){
        String acNumber = Utils.getString("Nhập vào thông tin số tài khoản cần tìm kiếm: ");
        account = getAccount(acNumber);
        if(AccountManager.contains(account)){
            System.out.println("Tìm thấy tài khoản: ");
            account.inThongTinTaiKhoan();
        }
        else{
            System.err.println("Không tìm thấy tài khoản!!!");
        }
    }

    public void napTien(){
        String acNumber = Utils.getString("Nhập vào số tài khoản cần nạp: ");
        account = getAccount(acNumber);
        double soTienCanNap = Utils.getDouble("Nhập vào số tiền cần nạp: ");
        try{
            account.deposit(soTienCanNap);
            System.out.println("Nạp tiền thành công!");
            System.out.println("Số tài khoản: " + acNumber);
            System.out.println("Số tiền nạp: " + soTienCanNap);
            System.out.println("Số dư mới: " + account.getBalance());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    public void rutTien(){
        String acNumber = Utils.getString("Nhập vào số tài khoản cần rút: ");
        account = getAccount(acNumber);
        double soTienCanRut = Utils.getDouble("Nhập vào số tiền cần rút: ");
        try{
            account.withdraw(soTienCanRut);
            System.out.println("Nạp tiền thành công!");
            System.out.println("Số tài khoản: " + acNumber);
            System.out.println("Số tiền rút: " + soTienCanRut);
            System.out.println("Số dư mới: " + account.getBalance());
        }catch(Exception e){
            System.err.println("Số tài khoản: " + acNumber);
            System.err.println("Số tiền rút: " + soTienCanRut);
            System.err.println("Lỗi: Số dư không đủ để thực hiện giao dịch. Số dư hiện tại: " + account.getBalance());
        }
    }

    public void chuyenKhoan() throws Exception {
        String soTaiKhoanGui = Utils.getString("Nhập vào số tài khoản gửi: ");
        String soTaiKhoanNhan = Utils.getString("Nhập vào số tài khoản nhận: ");
        double soTienChuyen = Utils.getDouble("Nhập vào số tiền chuyển: ");
        boolean check = false;
        double soDuTaiKhoanNguoiGui = 0;
        double soDuTaiKhoanNguoiNhan = 0;
        if(listAccountNumbers.contains(soTaiKhoanGui) && listAccountNumbers.contains(soTaiKhoanNhan) && soTienChuyen > 0){
            check = true;
            account = getAccount(soTaiKhoanGui);
            soDuTaiKhoanNguoiGui = account.getBalance();
            account2 = getAccount(soTaiKhoanNhan);
            soDuTaiKhoanNguoiNhan = account.getBalance();
        }
        else if(!listAccountNumbers.contains(soTaiKhoanNhan) && listAccountNumbers.contains(soTaiKhoanGui)){
            System.err.println("Không tồn tại tài khoản của người nhận trong hệ thống !");
        }
        else if(soTienChuyen < 0){
            System.err.println("Số tiền chuyển phải lớn hơn 0!");
        }
        else{
            System.err.println("Không tồn tại tài khoản của người gửi trong hệ thống !");
        }

        if(check && soDuTaiKhoanNguoiGui > soTienChuyen){
            try{
                account.withdraw(soTienChuyen);
            }
            catch(Exception e){
                System.err.println(e.getMessage());
            }

            try{
                account2.deposit(soTienChuyen);
            }
            catch(Exception e){
                System.err.println(e.getMessage());
            }

            Transaction nguoiGui = new Transaction("Withdraw", soTienChuyen, getRandomEmployee());
            account.addTransaction(nguoiGui);
            Transaction nguoiNhan = new Transaction("Deposit", soTienChuyen, getRandomEmployee());
            account2.addTransaction(nguoiNhan);

            transactions.add(nguoiGui);
            transactions.add(nguoiNhan);

            System.out.println("Chuyển tiền thành công!");
            System.out.println("Tài khoản gửi: " + account.getBalance());
            System.out.println("Tài khoản nhận: " + account2.getBalance());
            System.out.println("Số tiền chuyển: " + soTienChuyen);
            System.out.println("Số dư mới của tài khoản gửi: " + account.getBalance());
            System.out.println("Số dư mới của tài khoản nhận: " + account2.getBalance());

        }
        else{
            System.err.println("Số tiền chuyển lớn hơn số dư tài khoản người gửi, không hợp lệ !");
        }
    }

    public void hienThiLichSuGiaoDich(){
        String acNumber = Utils.getString("Nhập vào số tài khoản mà bạn muốn hiển thị giao dịch: ");
        List<Transaction> listTrans;
        account = getAccount(acNumber);
        int cnt = 0;
        if(account.getTransactions().isEmpty()){
            System.err.println("Tài khoản chưa có giao dịch!");
        }
        else{
            listTrans = account.getTransactions();
            for(Transaction trans : listTrans){
                System.out.print(++cnt + ". ");
                trans.inThongTinGiaoDich();
            }
        }
    }

    public void hienThiToanBoLichSuGiaoDich(){
        int cnt = 0;
        for(Transaction trans : transactions){
            System.out.print(++cnt + ". ");
            trans.inThongTinGiaoDich();
        }
    }

    public void themNhanVienMoi(){
        String id = Utils.getString("Nhập vào id của nhân viên mới: ");
        boolean check = true;
        for(Employee e : employees){
            if(id.equalsIgnoreCase(e.getId())){
                check = false;
            }
        }
        if(check){
            String name = Utils.getString("Nhập vào tên của nhân viên mới: ");
            double salary = Utils.getDouble("Nhập vào lương cơ bản của nhân viên mới: ");
            employee = new Employee(id, name, salary);
            employees.add(employee);
            System.out.println("Nhân viên được thêm thành công!");
            employee.hienThiThongTinNhanVien();
        }
        else{
            System.err.println("Mã id đã tồn tại trong hệ thống !");
        }
    }

    public Employee getEmployee(String id){
        for(Employee e : employees){
            if(id.equalsIgnoreCase(e.getId())){
                return e;
            }
        }
        return null;
    }

    public void danhSachNhanVien(){
        if(employees.isEmpty()){
            System.err.println("Không có nhân viên trong hệ thống !");
            return;
        }
        for(Employee e : employees){
            e.hienThiThongTinNhanVien();
            try{
                if(e.laySoLuongTaiKhoanQuanLy() > 0){
                    System.out.println("Số lượng tài khoản đang quản lý: " + e.laySoLuongTaiKhoanQuanLy());
                    System.out.println();
                }
                else{
                    System.out.println("Số lượng tài khoản đang quản lý: 0");
                }
            }catch(Exception ex){
                System.err.println(ex.getMessage());
            }
        }
    }

    public void ganTaiKhoanChoNhanVien() throws Exception {
        String id = Utils.getString("Nhập id để tìm kiếm nhân viên: ");
        String acNumber = Utils.getString("Nhập số tài khoản để tìm kiếm: ");
        employee = getEmployee(id);
        if(employee == null){
            System.err.println("Id của nhân viên không tồn tại!");
            return;
        }
        account = getAccount(acNumber);
        if(account == null){
            System.err.println("Số tài khoản không tồn tại!");
            return;
        }
        List<Account> listAccount = employee.getManageAccounts();
        listAccount.add(account);
        account.setEmployeeInCharge(employee);
        System.out.println("Tài khoản " + acNumber + " đã được gán thành công cho nhân viên " + id);
    }

}
