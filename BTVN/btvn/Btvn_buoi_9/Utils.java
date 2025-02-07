package Btvn_buoi_9;

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
        System.out.println("1. Add student to list.");
        System.out.println("2. Remove student from list.");
        System.out.println("3. Print student list.");
        System.out.println("4. Search student by name.");
        System.out.println("5. Sort list student by test score.");
        System.out.println("6. Check student exist by ID.");
        System.out.println("7. Exit!!!");
        System.out.println("======================================");
    }

}
