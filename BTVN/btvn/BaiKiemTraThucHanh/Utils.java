package BaiKiemTraThucHanh;

import java.util.Scanner;

public class Utils {

    public static Scanner sc = new Scanner(System.in);

    public static String getString(String message){
        String result = "";
        boolean check = true;
        do{
            System.out.print(message);
            result = sc.nextLine();
            if(!result.isEmpty()){
                check = false;
            }
        }while(check);
        return result;
    }

    public static int getInt(String message){
        while(true){
            System.out.print(message);
            int n = Integer.parseInt(sc.nextLine());
            if(n > 0){
                return n;
            }
            else{
                System.out.println("Enter number greater than 0: ");
            }
        }
    }

    public static String updateString(String oldValue, String message){
        String result = oldValue;
        boolean check = true;
        do{
            System.out.print(message);
            String tmp = sc.nextLine();
            if(!tmp.isEmpty()){
                result = tmp;
                check = false;
            }
        }while(check);
        return result;
    }

    public static int updateInt(int oldValue, String message){
        int result = oldValue;
        while(true){
            System.out.print(message);
            int n = Integer.parseInt(sc.nextLine());
            if(n != result){
                result = n;
                return result;
            }
            else if(n == result){
                System.out.println("Duplicated!");
            }
        }
    }

    public static void printMenu(){
        System.out.println("==================== MENU ===================");
        System.out.println("1. Add student to list.");
        System.out.println("2. Update infomation of student through id.");
        System.out.println("3. Delete student from list.");
        System.out.println("4. Search student by name.");
        System.out.println("5. Show list of students.");
        System.out.println("6. Exit!");
        System.out.println("=============================================");
    }

    //Utils_Student

}
