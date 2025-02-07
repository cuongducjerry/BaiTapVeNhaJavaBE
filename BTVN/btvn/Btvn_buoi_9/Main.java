package Btvn_buoi_9;

import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ListStudentManage list = new ListStudentManage();
        int choice;
        do{
            Utils.menu();
            choice = Utils.getInt("Enter your choice: ");
            switch (choice){

                case 1:
                    try{
                        list.addStudent();
                    }catch(Exception e){
                        System.err.println(e.getMessage());
                    };
                    break;

                case 2:
                    try{
                        list.removeStudent();
                    }catch (Exception e){
                        System.err.println(e.getMessage());
                    }
                    break;

                case 3:
                    list.printStudents();
                    break;

                case 4:
                    try{
                        list.searchStudentByID();
                    }catch (Exception e){
                        System.err.println(e.getMessage());
                    }
                    break;

                case 5:
                    try{
                        list.sortListByScore();
                    }catch (Exception e){
                        System.err.println(e.getMessage());
                    }
                    break;

                case 6:
                    list.checkStudentExists();
                    break;

            }
        }while(choice != 7);
    }
}
