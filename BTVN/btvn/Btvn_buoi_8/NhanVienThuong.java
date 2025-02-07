package Btvn_buoi_8;

public class NhanVienThuong extends NguoiLamViec {
    protected TruongPhong truongPhong;

    public NhanVienThuong() {
        super();
        super.setLuong1Ngay(100);
    }

    public TruongPhong getTruongPhong() {
        return truongPhong;
    }

    public void setTruongPhong(TruongPhong truongPhong) {
        this.truongPhong = truongPhong;
    }

    @Override
    public void nhapThongTinNhanVien(){
        System.out.println("Nhập vào thông tin của nhân viên: ");
        super.nhapThongTinNhanVien();
    }

    @Override
    public double luongThang(){
        return super.getLuong1Ngay() * super.getSoNgayLamViec();
    }

    @Override
    public void hienThiNhanVien() {
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("Thông tin nhân viên: ");
        super.hienThiNhanVien();
        System.out.println("Lương 1 ngày: " + super.getLuong1Ngay());
        System.out.println("Lương 1 tháng: " + luongThang());
        if(truongPhong!=null){
            System.out.println("Thông tin trưởng phòng quản lý: " + truongPhong.getHoTen() + ", mã số: " + truongPhong.getMaSo());
        }
        System.out.println("-----------------------------------------------------------------------------------------------------");
    }

}
