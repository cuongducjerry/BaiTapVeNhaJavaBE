package BaiKiemTraThucHanh;

import java.util.Scanner;

public class StudentManager {

    public static Student[] list;

    public static int total = 0;

    public static Scanner sc = new Scanner(System.in);

    public static void addStudent(){
        String name = Utils.getString("Enter name of student: ");
        int age = Utils.getInt("Enter age of student: ");
        String id = Utils.getString("Enter id of student: ");
        Student newStudent = new Student(name, age, id);

        Student[] list2 = new Student[total+1];
        for(int i = 0; i < total; i++){
            if(list[i]!=null) {
                list2[i] = list[i];
            }
        }
        boolean check = false;
        for(int i = 0; i < total; i++){
            if(list[i]!=null && id.equalsIgnoreCase(list[i].getId())){
                System.err.println("ID duplicated!!!");
                return;
            }
        }
        list2[total] = newStudent;
        total++;
        list = new Student[total];
        for(int i = 0; i < total; i++){
            if(list2[i]!=null){
                list[i] = list2[i];
            }
        }
    }

    public static void updateStudent(){
        String id = Utils.getString("Enter id of student to update: ");
        for(int i = 0; i < list.length; i++){
            if(list[i]!=null && id.equalsIgnoreCase(list[i].getId())){
                list[i].updateStudentByID();
            }
        }
    }

    public static void deleteStudent(){
        String id = Utils.getString("Enter id of student to delete: ");
        Student[] newList = new Student[total-1];
        int index = 0;
        boolean check = false;
        for(int i = 0; i < total; i++){
            if(list[i]!=null && id.equalsIgnoreCase(list[i].getId())){
                check = true;
                continue;
            }
            else{
                if(index == total-1){
                    break;
                }
                else{
                    newList[index++] = list[i];
                }
            }
        }
        if(!check){
            System.err.println("ID you enter not exist to delete!");
        }
        else{
            total = total - 1;
            list = new Student[total];
            for(int i = 0; i < total; i++){
                list[i] = newList[i];
            }
            System.out.println("You have deleted successfully!");
        }
    }

    public static void searchStudentByName(){
        String name = Utils.getString("Enter name of student to search: ");
        boolean check = false;
        for(int i = 0; i < list.length; i++){
            if(list[i]!=null && name.equalsIgnoreCase(list[i].getName())){
                check = true;
                System.out.println(list[i]);
                break;
            }
        }
        if(!check){
            System.err.println("Student not found!");
        }
    }

    public static void printStudents(){
        for(int i = 0; i < total; i++){
            System.out.println(list[i]);
        }
    }

    public static void main(String[] args) {
        int choice;
        do{
            Utils.printMenu();
            choice = Utils.getInt("Enter choice of you: ");
            switch(choice){
                case 1 :
                    StudentManager.addStudent();
                    break;
                case 2 :
                    StudentManager.updateStudent();
                    break;
                case 3 :
                    StudentManager.deleteStudent();
                    break;
                case 4 :
                    StudentManager.searchStudentByName();
                    break;
                case 5 :
                    StudentManager.printStudents();
                    break;
            }
        }while(choice != 6);

        if(choice == 6){
            System.out.println("You have exited the program!");
        }

    }
}
