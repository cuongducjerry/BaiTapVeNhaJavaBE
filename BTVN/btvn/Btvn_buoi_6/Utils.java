package Btvn_buoi_6;

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
        System.out.println("===== MENU CHÍNH =====");
        System.out.println("1: Xem số dư");
        System.out.println("2: Rút tiền");
        System.out.println("3: Gửi tiền");
        System.out.println("4: Thoát!!!");
    }

}
