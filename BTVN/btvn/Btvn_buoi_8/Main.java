package Btvn_buoi_8;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        CongTy congTy = new CongTy();
        int choice;
        do{
            Utils.menu();
            choice = Utils.getInt("Nhập vào lựa chọn trong menu: ");
            switch(choice){
                case 1:
                    congTy.nhapThongTinCongTy();
                    break;
                case 2:
                    congTy.phanBoNhanVienVaoPhong();
                    break;
                case 3:
                    System.out.println("1. Thêm nhân sự.");
                    System.out.println("2. Xóa nhân sự");
                    int choice2 = Utils.getInt("Nhập lựa chọn: ");
                        if(choice2==1){
                            congTy.themNhanSu();
                        }
                        else if(choice2==2){
                            congTy.xoaNhanVien();
                        }
                        else{
                            System.err.println("Bạn đã nhập sai, chỉ được nhập 1 hoặc 2.");
                        }
                    break;
                case 4:
                    congTy.hienThiToanBoNhanVien();
                    break;
                case 5:
                    congTy.inTongLuongToanBoCongTy();
                    break;
                case 6:
                    congTy.timNhanVienLuongCaoNhat();
                    break;
                case 7:
                    congTy.timTruongPhongCoNhieuNhanVien();
                    break;
                case 8:
                    congTy.sapXepNhanVienTheoTen();
                    break;
                case 9:
                    congTy.sapXepLuongGiamDan();
                    break;
                case 10:
                    congTy.timGiamDocCoPhanLonNhat();
                    break;
                case 11:
                    congTy.xuatTongThuNHapCacGiamDoc();
                    break;
            }
        }while(choice != 12);
    }
}