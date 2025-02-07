package Btvn_buoi_8;

import java.util.ArrayList;
import java.util.List;

public class TruongPhong extends NguoiLamViec {
    private List<NguoiLamViec> list = new ArrayList<NguoiLamViec>();

    public TruongPhong(){
        super();
        super.setLuong1Ngay(200);
    }

    public List<NguoiLamViec> getList() {
        return list;
    }

    public void setList(List<NguoiLamViec> list) {
        this.list = list;
    }

    @Override
    public void nhapThongTinNhanVien(){
        System.out.println("Nhập vào thông tin của trưởng phòng: ");
        super.nhapThongTinNhanVien();
        System.out.println();
    }

    @Override
    public double luongThang(){
        int soLuongNhanVien = this.list.size();
        return super.getLuong1Ngay() * super.getSoNgayLamViec() + 100 * soLuongNhanVien;
    }

    @Override
    public void hienThiNhanVien(){
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("Thông tin trưởng phòng: ");
        super.hienThiNhanVien();
        System.out.println("Lương 1 ngày: " + super.getLuong1Ngay());
        System.out.println("Lương 1 tháng: " + luongThang());
        System.out.println("Danh sách nhân viên mà trưởng phòng quản lý: ");
        for(NguoiLamViec nvc : list){
            if(nvc instanceof NhanVienThuong){
                System.out.println(nvc.getHoTen() + ", mã số: " + nvc.getMaSo());
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------------------");
    }

}
