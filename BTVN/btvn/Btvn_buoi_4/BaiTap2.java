package Btvn_buoi_4;

import java.util.Scanner;
import java.util.regex.Pattern;

public class BaiTap2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào số điện thoại cần kiểm tra: ");
        String phone = sc.nextLine();

        Pattern p = Pattern.compile("^0[0-9]{9}$");
        Pattern p1 = Pattern.compile("^\\+84[0-9]{9}$");
        Pattern p2 = Pattern.compile("^84[0-9]{9}$");
        Pattern p3 = Pattern.compile("^[0-9]{4}.[0-9]{3}.[0-9]{3}$");
        Pattern p4 = Pattern.compile("^[0-9]{4}-[0-9]{3}-[0-9]{3}$");

        if(p.matcher(phone).find() || p1.matcher(phone).find() || p2.matcher(phone).find() || p3.matcher(phone).find() || p4.matcher(phone).find()) {
            System.out.println("Số điện thoại của bạn hợp lệ!");
        }
        else{
            System.err.println("Số điện thoại của bạn không hợp lệ!!!");
        }

    }
}
