package Btvn_buoi_4;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class BaiTap1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào chuỗi: ");
        String s = sc.nextLine();
        String sCopy = s;
        String []s1 = s.split("[,.:\\s]+");
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
        for(String x : s1){
            StringBuilder sb = new StringBuilder();
            sb.append(Character.toUpperCase(x.charAt(0)));
            sb.append(x.substring(1).toLowerCase());
            String res = sb.toString();
            map.put(res,map.getOrDefault(res,0)+1);
        }
        // Đếm số lượng từ
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue() + " từ");
        }

        System.out.println();

        // Viết hoa chữ đầu trong mỗi từ
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey());
        }

        System.out.println();

        // Xóa các nguyên tâm trong câu
        for(int i = 0; i < sCopy.length(); i++){
            if(sCopy.charAt(i)=='A' || sCopy.charAt(i)=='a' || sCopy.charAt(i)=='O'
                    || sCopy.charAt(i)=='o' || sCopy.charAt(i)=='I' || sCopy.charAt(i)=='i'
                    || sCopy.charAt(i)=='U' || sCopy.charAt(i)=='u' || sCopy.charAt(i)=='E' || sCopy.charAt(i)=='e')
            {
                continue;
            }
            else{
                System.out.print(sCopy.charAt(i));
            }
        }

    }

}