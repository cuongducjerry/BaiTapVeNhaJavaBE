package Btvn_buoi_2;

import java.util.Scanner;

public class BaiTap1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tongTien = 200000;
        final int menhGia1000 = 1000;
        final int menhGia2000 = 2000;
        final int menhGia5000 = 5000;
        for(int i = 0; i <= tongTien / menhGia1000; i++){
            for(int j = 0; j <= tongTien / menhGia2000; j++){
                for(int k = 0; k <= tongTien / menhGia5000; k++){
                    int total = i * menhGia1000 + j * menhGia2000 + k * menhGia5000;
                    if(total == tongTien){
                        System.out.println("Tổng tiền 200.000 với mệnh " +
                                "giá tương ứng sau(1000đ - " + i + " ,2000đ - " + j + " ,5000đ - " + k);
                    }
                }
            }
        }
    }
}
