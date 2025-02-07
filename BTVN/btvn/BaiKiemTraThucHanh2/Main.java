package BTVN.btvn.BaiKiemTraThucHanh2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        EmployeeManager em = new EmployeeManager();
        int choice;
        do{
            Utils.menu();
            choice = Utils.getInt("Nhập vào lựa chọn của bạn: ");
            switch(choice){
                case 1:
                    em.themTaiKhoan();
                    break;
                case 2:
                    em.suaThongTinTaiKhoan();
                    break;
                case 3:
                    em.xoaTaiKhoan();
                    break;
                case 4:
                    em.timKiemTaiKhoan();
                    break;
                case 5:
                    em.napTien();
                    break;
                case 6:
                    em.rutTien();
                    break;
                case 7:
                    em.chuyenKhoan();
                    break;
                case 8:
                    em.hienThiLichSuGiaoDich();
                    break;
                case 9:
                    em.hienThiToanBoLichSuGiaoDich();
                    break;
                case 10:
                    em.themNhanVienMoi();
                    break;
                case 11:
                    em.danhSachNhanVien();
                    break;
                case 12:
                    em.ganTaiKhoanChoNhanVien();
                    break;
            }
        }while(choice != 13);
        if(choice == 13){
            System.out.println("Hệ thống đã thoát. Cảm ơn bạn đã sử dụng!");
        }
    }
}
