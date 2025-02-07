package Btvn_buoi_4;

import java.util.*;

public class BaiTap3 {

    public static Scanner sc = new Scanner(System.in);

    public static int n;
    public static int []a;

    public static void nhapVaoMang(){
        System.out.print("Nhập vào số phần tử n của mảng a: ");
        n = sc.nextInt();
        a = new int[n];
        for(int i = 0; i < n; i++){
            System.out.print("Nhập vào giá trị a[" + i + "] : ");
            a[i] = sc.nextInt();
        }
    }

    public static void tinhTongPhanTuChanLe(){
        int tongChan = 0, tongLe = 0;
        for(int i = 0; i < n; i++){
            if(a[i] % 2 == 0){
                tongChan += a[i];
            }
            else{
                tongLe += a[i];
            }
        }
        System.out.println("Tổng các phần tử chẵn là : " + tongChan);
        System.out.println("Tổng các phần tử lẻ là : " + tongLe);
    }

    public static boolean checkSNT(int x){
        if(n < 2){
            return false;
        }
        for(int i = 2; i <= Math.sqrt(x); i++){
            if(x % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void inSoNguyenTo(){
        System.out.print("Các số nguyên tố trong mảng a là: ");
        for(int i = 0; i < n; i++){
            if(checkSNT(a[i])){
                System.out.print(a[i] + " ");
            }
        }
        System.out.println();
    }

    public static void sapXep(){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(a[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 % 2 == 0 && o2 % 2 == 0){
                    return o2 - o1;
                }
                else if(o1 % 2 == 1 && o2 % 2 == 1){
                    return o1 - o2;
                }
                else {
                    return o1 % 2 == 0 ? -1 : 1;  // Sắp xếp số chẵn lên trước
                }
            }
        });
        System.out.print("Mảng sau khi sắp xếp: ");
        for(int i : list){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void chiaMang(){
        int tong = 0;
        for(int i = 0; i < n; i++){
            tong += a[i];
        }
        int trungBinh = tong/n;
        int []m1 = new int[n];
        int []m2 = new int[n];
        int j = 0, k = 0;
        for(int i = 0; i < n; i++){
            if(a[i] <= trungBinh){
                m1[j++] = a[i];
            }
            else{
                m2[k++] = a[i];
            }
        }
        System.out.print("Mảng 1: ");
        for(int i = 0; i < j; i++){
            System.out.print(m1[i] + " ");
        }
        System.out.println();
        System.out.print("Mảng 2: ");
        for(int i = 0; i < k; i++){
            System.out.print(m2[i] + " ");
        }
    }

    public static void cacPhanTuTrungLap(){
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < n; i++){
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > 1){
                System.out.println(entry.getKey() + " : lặp lại " + entry.getValue() + " lần");
            }
        }
    }

    public static void themPhanTu(){
        int nNew = n + 1;
        System.out.print("Nhập vị trí bạn muốn thêm vào mảng a: ");
        int idx = sc.nextInt();
        System.out.print("Nhập phần tử bạn muốn thêm: ");
        int add = sc.nextInt();
        int []aNew = new int[nNew];
        for(int i = 0; i < nNew; i++){
            if(i < idx){
                aNew[i] = a[i];
            }
            else if(i == idx){
                aNew[i] = add;
            }
            else{
                aNew[i] = a[i-1];
            }
        }
        a = new int[nNew];
        n = nNew;
        for(int i = 0; i < nNew; i++){
            a[i] = aNew[i];
        }
        System.out.print("Phần tử đã được thêm vào mảng a: ");
        for(int i = 0; i < nNew; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void xoaPhanTu(){
        System.out.print("Nhập phần tử bạn muốn xóa: ");
        int sub = sc.nextInt();
        int ok = 0;
        int idx = 0;
        for(int i = 0; i < a.length; i++){
            if(sub == a[i]){
                ok = 1;
                idx = i;
                break;
            }
        }
        if(ok == 0){
            System.err.println("Phần tử bạn vừa nhập không có trong mảng!!!");
            return;
        }
        else{
            int nNew2 = n-1;
            n = nNew2;
            int []aNew2 = new int[nNew2];
            int v = 0;
            for(int i = 0; i < a.length; i++){
                if(i == idx){
                    continue;
                }
                else{
                    aNew2[v++] = a[i];
                }
            }
            a = new int[nNew2];
            for(int i = 0; i < nNew2; i++){
                a[i] = aNew2[i];
            }
            System.out.print("Mảng sau khi xóa 1 phần tử: ");
            for(int i = 0; i < nNew2; i++){
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
    }

    public static void Validate(){
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("1. Nhập 1 mảng các số nguyên.");
        System.out.println("2. Tính tổng các phần tử chẵn và tổng các phần tử lẻ trong mảng.");
        System.out.println("3. Tìm và in ra các số nguyên tố có trong mảng.");
        System.out.println("4. Sắp xếp mảng sao cho:\n"
                +"+ Các phần tử chẵn được sắp xếp theo thứ tự giảm dần.\n"
                +"+ Các phần tử lẻ được sắp xếp theo thứ tự tăng dần.");
        System.out.println("5. Chia mảng thành 2 mảng con:\n"
                +"Mảng 1: Chứa tất cả các phần tử có giá trị nhỏ hơn hoặc bằng trung bình của mảng.\n"
                +"Mảng 2: Chứa tất cả các phần tử có giá trị lớn hơn trung bình của mảng.");
        System.out.println("6. Tìm số lượng phần tử trùng lặp trong mảng và in ra các phần tử trùng lặp.");
        System.out.println("7. Thêm một phần tử vào mảng:\n"
                +"Cho phép người dùng thêm một phần tử vào mảng tại vị trí chỉ định (index).\n"
                +"Nếu mảng đã đầy, tự động mở rộng mảng.");
        System.out.println("8. Xóa một phần tử khỏi mảng:\n"
                +"Cho phép người dùng nhập vào một giá trị phần tử và xoá phần tử đó trong mảng.");
        System.out.println("0. Thoát chương trình !!!");
        System.out.println("----------------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        int n;
        do{
            BaiTap3.Validate();
            n = sc.nextInt();
            switch(n){
                case 1:
                    BaiTap3.nhapVaoMang();
                    break;
                case 2:
                    BaiTap3.tinhTongPhanTuChanLe();
                    break;
                case 3:
                    BaiTap3.inSoNguyenTo();
                    break;
                case 4:
                    BaiTap3.sapXep();
                    break;
                case 5:
                    BaiTap3.chiaMang();
                    break;
                case 6:
                    BaiTap3.cacPhanTuTrungLap();
                    break;
                case 7:
                    BaiTap3.themPhanTu();
                    break;
                case 8:
                    BaiTap3.xoaPhanTu();
                    break;
            }
        }while(n != 0);
    }
}
