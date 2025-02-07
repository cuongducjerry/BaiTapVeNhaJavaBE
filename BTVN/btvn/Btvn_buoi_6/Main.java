package Btvn_buoi_6;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static Account[] acc;

    public static int cnt = 0;

    public static void xemSoDu(int index){
        System.out.print("Số dư hiện tại: $" + acc[index].getBalance());
        System.out.println();
    }

    public static void soTienCanRut(int index){
        double soTienCanRut = Utils.getDouble("Nhập số tiền cần rút: ");
        if(soTienCanRut < 0){
            System.err.println("Bạn đã nhập số tiền âm!!!");
        }
        else if(soTienCanRut > acc[index].getBalance()){
            System.err.println("Rút tiền vượt quá số dư!!!");
        }
        else{
            acc[index].setBalance(acc[index].getBalance() - soTienCanRut);
            System.out.println("Rút tiền thành công.");
        }
        System.out.println();
    }

    public static void soTienCanGui(int index){
        double soTienCanGui = Utils.getDouble("Nhập số tiền cần gửi: ");
        if(soTienCanGui < 0){
            System.err.println("Bạn đã nhập số tiền âm!!!");
        }
        else{
            acc[index].setBalance(acc[index].getBalance() + soTienCanGui);
            System.out.println("Gửi tiền thành công.");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        acc = new Account[10];
        acc[0] = new Account(0, 100, 4.0);
        acc[1] = new Account(0, 100, 4.1);
        acc[2] = new Account(0, 100, 4.2);
        acc[3] = new Account(0, 100, 4.3);
        acc[4] = new Account(0, 100, 4.4);
        acc[5] = new Account(0, 100, 4.5);
        acc[6] = new Account(0, 100, 4.6);
        acc[7] = new Account(0, 100, 4.7);
        acc[8] = new Account(0, 100, 4.8);
        acc[9] = new Account(0, 100, 4.9);

        int choice;
        while(true) {
            System.out.print("Nhập ID tài khoản của bạn: ");
            int idTaiKhoan = Integer.parseInt(sc.nextLine());
            do{
                Utils.menu();
                choice = Utils.getInt("Nhập vào lựa chọn của bạn: ");
                switch(choice){
                    case 1:
                        Main.xemSoDu(idTaiKhoan);
                        break;
                    case 2:
                        Main.soTienCanRut(idTaiKhoan);
                        break;
                    case 3:
                        Main.soTienCanGui(idTaiKhoan);
                        break;
                }
            }while(choice != 4);
        }

    }
}