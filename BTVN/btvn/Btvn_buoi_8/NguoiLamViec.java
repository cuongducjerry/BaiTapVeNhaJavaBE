package Btvn_buoi_8;

public abstract class NguoiLamViec {
    protected String maSo, hoTen, sdt;
    protected int soNgayLamViec;
    protected double luong1Ngay;

    public NguoiLamViec() {
    }

    public NguoiLamViec(String maSo, String hoTen, String sdt, int soNgayLamViec, double luong1Ngay) {
        this.maSo = maSo;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.soNgayLamViec = soNgayLamViec;
        this.luong1Ngay = luong1Ngay;
    }

    public String getMaSo() {
        return maSo;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getSoNgayLamViec() {
        return soNgayLamViec;
    }

    public void setSoNgayLamViec(int soNgayLamViec) {
        this.soNgayLamViec = soNgayLamViec;
    }

    public double getLuong1Ngay() {
        return luong1Ngay;
    }

    public void setLuong1Ngay(double luong1Ngay) {
        this.luong1Ngay = luong1Ngay;
    }

    public void nhapThongTinNhanVien(){
        this.maSo = Utils.getString("Nhập vào mã số nhân viên: ");
        this.hoTen = Utils.getString("Nhập vào họ tên: ");
        this.sdt = Utils.getString("Nhập vào số điện thoại: ");
        this.soNgayLamViec = Utils.getInt("Nhập vào số ngày làm việc: ");
    }

    public void hienThiNhanVien(){
        System.out.println("Mã số: " + this.maSo);
        System.out.println("Họ và tên: " + this.hoTen);
        System.out.println("Số điện thoại: " + this.sdt);
        System.out.println("Số ngày làm việc: " + this.soNgayLamViec);
    }

    public abstract double luongThang();

}
