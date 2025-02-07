package BTVN.btvn.BaiKiemTraThucHanh2;

import java.util.Scanner;

public class Utils {

    public static int getInt(String mess){
        while(true){
            System.out.print(mess);
            Scanner sc = new Scanner(System.in);
            int n = Integer.parseInt(sc.nextLine());
            if(n > 0){
                return n;
            }
            System.err.print("Enter number n > 0 : ");
        }
    }

    public static double getDouble(String mess){
        while(true){
            System.out.print(mess);
            Scanner sc = new Scanner(System.in);
            double n = Double.parseDouble(sc.nextLine());
            if(n > 0){
                return n;
            }
            System.err.print("Enter number số n > 0 : ");
        }
    }

    public static String getString(String mess){
        String result = "";
        boolean check = true;
        do{
            System.out.print(mess);
            Scanner sc = new Scanner(System.in);
            result = sc.nextLine();
            if(!result.isEmpty()){
                check = false;
            }
        }while(check);
        return result;
    }

    public static void menu(){
        System.out.println("================ MENU ================");

        System.out.println("--------- Quản lý tài khoản --------- ");

        System.out.println("1. Thêm tài khoản mới.");
        System.out.println("2. Sửa thông tin tài khoản.");
        System.out.println("3. Xóa tài khoản.");
        System.out.println("4. Tìm kiếm tài khoản.");

        System.out.println("--------- Giao dịch tài khoản ---------");

        System.out.println("5. Nạp tiền vào tài khoản.");
        System.out.println("6. Rút tiền từ tài khoản.");
        System.out.println("7. Chuyển khoản giữa 2 tài khoản.");

        System.out.println("--------- Quản lý giao dịch ---------");

        System.out.println("8. Hiển thị lịch sử giao dịch của một tài khoản.");
        System.out.println("9. Hiển thị toàn bộ giao dịch trong hệ thống.");

        System.out.println("--------- Quản lý nhân viên ---------");

        System.out.println("10. Thêm nhân viên mới.");
        System.out.println("11. Xem danh sách nhân viên.");
        System.out.println("12. Gán tài khoản cho nhân viên.");

        System.out.println("-------------------------------------");

        System.out.println("13. Thoát khỏi hệ thống!");
        System.out.println("======================================");
    }

}
