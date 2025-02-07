package Btvn_buoi_8;

public class GiamDoc extends NguoiLamViec {
    protected double coPhan;

    public GiamDoc() {
        super();
        super.setLuong1Ngay(300);
    }

    public double getCoPhan() {
        return coPhan;
    }

    public void setCoPhan(double coPhan) {
        this.coPhan = coPhan;
    }

    @Override
    public void nhapThongTinNhanVien(){
        System.out.println("Nhập vào thông tin của giám đốc: ");
        super.nhapThongTinNhanVien();
        this.coPhan = Utils.getDouble("Nhập vào cổ phần: ");
    }

    @Override
    public double luongThang(){
        return this.luong1Ngay * this.soNgayLamViec;
    }

    @Override
    public void hienThiNhanVien(){
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("Thông tin của giám đốc: ");
        super.hienThiNhanVien();
        System.out.println("Lương 1 ngày: " + super.getLuong1Ngay());
        System.out.println("Lương 1 tháng: " + luongThang());
        System.out.println("Số cổ phần của giám đốc: " + this.coPhan + "%");
        System.out.println("-----------------------------------------------------------------------------------------------------");
    }

}
