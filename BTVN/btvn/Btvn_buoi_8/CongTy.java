package Btvn_buoi_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CongTy {
    private String tenCongTy;
    private String maSoThue;
    private double doanhThu;

    private double tongLuongNhanVien = 0;
    private double tongLuongTruongPhong = 0;
    private double tongLuongGiamDoc = 0;
    private double tongLuongToanBoCtyTrongThang = 0;

    private List<NguoiLamViec> danhSachNhanVien = new ArrayList<>();

    public CongTy(){
    }

    public CongTy(String tenCongTy, String maSoThue, double doanhThu) {
        this.tenCongTy = tenCongTy;
        this.maSoThue = maSoThue;
        this.doanhThu = doanhThu;
    }

    public void nhapThongTinCongTy(){
        this.tenCongTy = Utils.getString("Nhập vào tên công ty: ");
        this.maSoThue = Utils.getString("Nhập vào mã số thuế của công ty: ");
        this.doanhThu = Utils.getDouble("Nhập vào doanh thu của công ty: ");
    }

    public void hienThiToanBoNhanVien(){
        System.out.println("============ Thông tin toàn bộ nhân viên ============");
        for(NguoiLamViec nv : danhSachNhanVien){
            nv.hienThiNhanVien();
        }
        System.out.println("=====================================================");
    }

    public void themNhanSu(){
        System.out.println("Thêm một nhân viên.");
        System.out.println("Chọn chức vụ muốn thêm: ");
        System.out.println("1. Giám đốc");
        System.out.println("2. Trưởng phòng");
        System.out.println("3. Nhân viên");
        System.out.println("4. Hủy!");
        int luaChon = Utils.getInt("Nhập vào lựa chọn: ");
        NguoiLamViec nv = null;
        switch(luaChon){
            case 1 :
                nv = new GiamDoc();
                nv.nhapThongTinNhanVien();
                danhSachNhanVien.add(nv);
                break;
            case 2 :
                nv = new TruongPhong();
                nv.nhapThongTinNhanVien();
                danhSachNhanVien.add(nv);
                break;
            case 3 :
                nv = new NhanVienThuong();
                nv.nhapThongTinNhanVien();
                danhSachNhanVien.add(nv);
                break;
            case 4 :
                System.out.println("Thoát!");
                break;
        }
    }

    public void phanBoNhanVienVaoPhong(){
        String maNV = Utils.getString("Nhập vào mã nhân viên muốn đưa cho trưởng phòng: ");
        NguoiLamViec nv = timKiemNhanVien(maNV);
        if(!(nv instanceof NhanVienThuong)){
            System.err.println("Không tồn tại nhân viên với mã: " + maNV);
            return;
        }
        NhanVienThuong nhanVienThuong = (NhanVienThuong)nv;
        if(nhanVienThuong.getTruongPhong() != null){
            System.err.println("Nhân viên " + maNV + " đã được đưa vào cho trưởng phòng " + nhanVienThuong.getTruongPhong().getMaSo());
            return;
        }

        String maQuanLy = Utils.getString("Nhập vào mã trưởng phòng: ");
        NguoiLamViec tp = timKiemNhanVien(maQuanLy);
        if(!(tp instanceof TruongPhong)){
            System.err.println("Không tồn tại trưởng phòng với mã: " + maNV);
            return;
        }
        TruongPhong truongPhong = (TruongPhong)tp;
        nhanVienThuong.setTruongPhong(truongPhong);
        List<NguoiLamViec> newList = truongPhong.getList();
        newList.add(nhanVienThuong);
        truongPhong.setList(newList);
        System.out.println("Đã thêm nhân viên thành công!");

    }

    public void xoaNhanVien(){
        String maNV = Utils.getString("Nhập vào mã nhân viên: ");
        NguoiLamViec nvDelete = timKiemNhanVien(maNV);
        if(nvDelete == null){
            System.err.println("Không tìm thấy nhân viên mã: " + maNV);
            return;
        }

        if(nvDelete instanceof GiamDoc || nvDelete instanceof NhanVienThuong){
            this.danhSachNhanVien.remove(nvDelete);
        }
        else if(nvDelete instanceof TruongPhong){
            TruongPhong truongPhong = ((TruongPhong) nvDelete);
            for(NguoiLamViec nv : this.danhSachNhanVien){
                if(nv instanceof GiamDoc || nv instanceof TruongPhong){
                    continue;
                }
                NhanVienThuong nvThuong = (NhanVienThuong) nv;
                if(nvThuong.getTruongPhong() != null && nvThuong.getTruongPhong().getMaSo().equalsIgnoreCase(maNV)){
                    nvThuong.setTruongPhong(null);
                }
            }
            this.danhSachNhanVien.remove(nvDelete);
        }
    }

    public NguoiLamViec timKiemNhanVien(String maNV){
        for(NguoiLamViec nv : danhSachNhanVien){
            if(maNV.equalsIgnoreCase(nv.getMaSo())){
                return nv;
            }
        }
        return null;
    }

    public void inTongLuongToanBoCongTy(){
        System.out.println("----------------- Danh sách lương nhân viên -----------------");
        for(NguoiLamViec nvc : danhSachNhanVien){
            if(nvc instanceof NhanVienThuong){
                this.tongLuongNhanVien += nvc.luongThang();
                System.out.println("Họ và tên: " + nvc.getHoTen() + " - mã số: " + nvc.getMaSo());
            }
        }

        System.out.println("----------------- Danh sách lương trưởng phòng -----------------");
        for(NguoiLamViec nvc : danhSachNhanVien){
            if(nvc instanceof TruongPhong){
                this.tongLuongTruongPhong += nvc.luongThang();
                System.out.println("Họ và tên: " + nvc.getHoTen() + " - mã số: " + nvc.getMaSo());
            }
        }

        System.out.println("----------------- Giám đốc -----------------");
        for(NguoiLamViec nvc : danhSachNhanVien){
            if(nvc instanceof GiamDoc){
                this.tongLuongGiamDoc += nvc.luongThang();
                System.out.println("Họ và tên: " + nvc.getHoTen() + " - mã số: " + nvc.getMaSo());
            }
        }
        System.out.println("Tổng lương toàn bộ nhân viên: " + tongLuongNhanVien);
        System.out.println("Tổng lương toàn bộ trưởng phòng: " + tongLuongTruongPhong);
        System.out.println("Tổng lương giám đốc: " + tongLuongGiamDoc);
        this.tongLuongToanBoCtyTrongThang = this.tongLuongNhanVien + this.tongLuongTruongPhong + this.tongLuongGiamDoc;

        System.out.println("Tổng lương toàn bộ công ty: " + this.tongLuongToanBoCtyTrongThang);
        System.out.println("----------------------------------------------------------------");
    }

    public void timNhanVienLuongCaoNhat(){
        double maxLuong = Double.MIN_VALUE;
        for(NguoiLamViec nvc : danhSachNhanVien){
            if(nvc instanceof NhanVienThuong){
                if(((NhanVienThuong) nvc).luongThang() > maxLuong){
                    maxLuong = ((NhanVienThuong) nvc).luongThang();
                }
            }
        }
        System.out.println("Nhân viên có mức lương cao nhất: ");
        for(NguoiLamViec nvc : danhSachNhanVien){
            if(nvc instanceof NhanVienThuong){
                if(((NhanVienThuong) nvc).luongThang() == maxLuong){
                    ((NhanVienThuong) nvc).hienThiNhanVien();
                    break;
                }
            }
        }
    }

    public void timTruongPhongCoNhieuNhanVien(){
        int maxSoLuongNhanVien = Integer.MIN_VALUE;
        boolean check = false;
        for(NguoiLamViec nvc : danhSachNhanVien){
            if(nvc instanceof TruongPhong){
                if(((TruongPhong) nvc).getList().size() > maxSoLuongNhanVien && ((TruongPhong) nvc).getList().size() > 0){
                    maxSoLuongNhanVien = ((TruongPhong) nvc).getList().size();
                    check = true;
                }
            }
        }
        if (check) {
            System.out.println("Trưởng phòng có số lượng nhân viên dưới quyền nhiều nhất: ");
            for (NguoiLamViec nvc : danhSachNhanVien) {
                if (nvc instanceof TruongPhong) {
                    if (((TruongPhong) nvc).getList().size() == maxSoLuongNhanVien) {
                        ((TruongPhong) nvc).hienThiNhanVien();
                        break;
                    }

                }
            }
        }
        else{
            System.err.println("Chưa có trưởng phòng nào dưới quyền!!!");
        }
    }

    public void sapXepNhanVienTheoTen(){
        List<NguoiLamViec> sortByName = new ArrayList<>(danhSachNhanVien);
        Collections.sort(sortByName, new Comparator<NguoiLamViec>() {
            @Override
            public int compare(NguoiLamViec o1, NguoiLamViec o2) {
                return o1.getHoTen().compareTo(o2.getHoTen());
            }
        });
        System.out.println("Danh sách sau khi sắp xếp theo tên tăng dần: ");
        for(NguoiLamViec nvc : sortByName){
            System.out.println(nvc.getHoTen() + " , mã số: " + nvc.getMaSo());
        }
        System.out.println("-------------------------------------------------");
    }

    public void sapXepLuongGiamDan(){
        List<NguoiLamViec> sortBySalary = new ArrayList<>(danhSachNhanVien);
        Collections.sort(sortBySalary, new Comparator<NguoiLamViec>() {
            @Override
            public int compare(NguoiLamViec o1, NguoiLamViec o2) {
                return Double.compare(o2.luongThang(), o1.luongThang());
            }
        });
        System.out.println("Danh sách sau khi sắp xếp theo lương giảm dần: ");
        for(NguoiLamViec nvc : sortBySalary){
            System.out.println(nvc.getHoTen() + " , mã số: " + nvc.getMaSo() + ", lương tháng: " + nvc.luongThang());
        }
        System.out.println("-------------------------------------------------");
    }

    public void timGiamDocCoPhanLonNhat(){
        double coPhanMax = Double.MIN_VALUE;
        for(NguoiLamViec nvc : danhSachNhanVien){
            if(nvc instanceof GiamDoc){
                if(((GiamDoc) nvc).getCoPhan() > coPhanMax){
                    coPhanMax = ((GiamDoc) nvc).getCoPhan();
                }
            }
        }
        System.out.println("Giám đốc có cổ phần lớn nhất: ");
        for(NguoiLamViec nvc : danhSachNhanVien){
            if(nvc instanceof GiamDoc){
                if(((GiamDoc) nvc).getCoPhan() == coPhanMax){
                    ((GiamDoc) nvc).hienThiNhanVien();
                    break;
                }
            }
        }
    }

    public void xuatTongThuNHapCacGiamDoc(){
        for(NguoiLamViec nvc : danhSachNhanVien){
            if(nvc instanceof GiamDoc){
                double coPhan  = ((GiamDoc) nvc).getCoPhan();
                double luongThang = ((GiamDoc) nvc).luongThang();
                double loiNhuanCTy = this.doanhThu - this.tongLuongToanBoCtyTrongThang;
                double thuNhap = luongThang + (coPhan * loiNhuanCTy);
                System.out.println("Họ và tên: " + ((GiamDoc) nvc).getHoTen() + " , mã số: " + ((GiamDoc) nvc).getMaSo());
                System.out.println("Thu nhập: " + thuNhap);
            }
        }
    }

    public List<NguoiLamViec> getDanhSachNhanVien() {
        return danhSachNhanVien;
    }

    public String getTenCongTy() {
        return tenCongTy;
    }

    public void setTenCongTy(String tenCongTy) {
        this.tenCongTy = tenCongTy;
    }

    public String getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public double getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(double doanhThu) {
        this.doanhThu = doanhThu;
    }
}
