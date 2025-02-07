package Btvn_buoi_2;

import java.util.Scanner;

public class BaiTap3 {

    public static boolean SoHoanHao(int n) {
        int tong = 1;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                if(i != n/i){
                    tong += i + n/i;
                }
            }
        }
        return tong == n;
    }

    public static int Count(int n) {
        int cnt = 0;
        while(n != 0){
            cnt++;
            n /= 10;
        }
        return cnt;
    }

    public static boolean Armstrong(int n){
        int m = n;
        int exp = Count(n);
        int sum = 0;
        while(n != 0){
            sum += (int)Math.pow(n % 10, exp);
            n /= 10;
        }
        return sum == m;
    }

    public static boolean SoDoiXung(int n){
        String n1 = String.valueOf(n);
        int size = n1.length();
        int l = 0, r = size - 1;
        while(l < r){
            if(n1.charAt(l) != n1.charAt(r)){
                return false;
            }
            l++; r--;
        }
        return true;
    }

    public static int tinhTongChuSo(int n){
        int sum = 0;
        while(n != 0){
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String []num = sc.nextLine().split("\\s++");
        for(String i : num){
            int number = Integer.parseInt(i);

            //check SoHoanHao
            if(SoHoanHao(number)){
                System.out.println(number + " là số hoàn hảo.");
            }
            else{
                System.out.println(number + " không phải là số hoàn hảo.");
            }

            //check Armstrong
            if(Armstrong(number)){
                System.out.println(number + " là số Armstrong.");
            }
            else{
                System.out.println(number + " không phải là số Armstrong.");
            }

            //check SoDoiXung
            if(SoDoiXung(number)){
                System.out.println(number + " là số đối xứng.");
            }
            else{
                System.out.println(number + " không phải là số đối xứng.");
            }

            //In ra sum
            System.out.println("Tổng các chữ số của " + number + " là:" + tinhTongChuSo(number) + ".");
            System.out.println();

        }

    }
}
