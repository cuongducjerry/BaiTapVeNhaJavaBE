package Btvn_buoi_8;

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
            else{
                System.err.print("Nhập lại số n > 0 : ");
            }
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
            else{
                System.err.print("Nhập lại số n > 0 : ");
            }
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
        System.out.println("1. Nhập thông tin công ty.");
        System.out.println("2. Phân bổ nhân viên vào trưởng phòng.");
        System.out.println("3. Thêm hoặc xóa thông tin 1 nhân sự.");
        System.out.println("4. Xuất ra thông tin toàn bộ nhân viên.");
        System.out.println("5. In ra tổng lương của toàn bộ công ty.");
        System.out.println("6. Tìm nhân viên có lương cao nhất.");
        System.out.println("7. Tìm trưởng phòng có nhân viên dưới quyền nhiều nhất.");
        System.out.println("8. Sắp xếp nhân viên toàn công ty theo tên tăng dần.");
        System.out.println("9. Sắp xếp nhân viên toàn công ty theo thứ tự lương giảm dần.");
        System.out.println("10. Tìm giám đốc có số lượng cổ phần lớn nhất.");
        System.out.println("11. Tính và xuất tổng thu nhập từng giám đốc.");
        System.out.println("12. Thoát!!!");
        System.out.println("======================================");
    }

}
