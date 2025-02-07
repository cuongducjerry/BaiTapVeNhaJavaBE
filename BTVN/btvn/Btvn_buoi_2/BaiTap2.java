package Btvn_buoi_2;

import java.util.Scanner;

public class BaiTap2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String nhiPhan = "";
        while(n != 0){
            int soDu = n % 2;
            nhiPhan = soDu + nhiPhan;
            n /= 2;
        }
        System.out.println(nhiPhan);
    }
}
