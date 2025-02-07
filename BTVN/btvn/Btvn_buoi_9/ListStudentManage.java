package Btvn_buoi_9;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class ListStudentManage {

    public Scanner sc = new Scanner(System.in);

    public ArrayList<Student> students = new ArrayList<Student>();

    public Set<String> setID = new HashSet<>();

    public void addStudent() throws Exception {
        String ID = Utils.getString("Enter Student ID want to add: ");
        if(setID.contains(ID)){
            throw new Exception("Student with ID " + ID + " already exist!");
        }

        String name = Utils.getString("Enter Student Name want to add: ");
        double score = Utils.getDouble("Enter Student Score want to add: ");
        students.add(new Student(ID, name, score));
        setID.add(ID);
        System.out.println("Add student successfully!");
    }

    public void removeStudent() throws Exception {
        String ID = Utils.getString("Enter Student ID want to remove: ");
        boolean check = false;
        for(Student s : students){
            if(ID.equals(s.getID())){
                check = true;
                students.remove(s);
                break;
            }
        }
        if(!check){
            throw new Exception("Student with ID " + ID + " does not exist!");
        }
        System.out.println("Remove student successfully!");
    }

    public void printStudents() {
        System.out.println("-------------- Student List --------------");
        for(Student s : students){
            System.out.println(s);
        }
        System.out.println("------------------------------------------");
    }

    public void searchStudentByID() throws Exception {
        String ID = Utils.getString("Enter Student ID want to search: ");
        boolean check = false;
        for(Student s : students){
            if(ID.equals(s.getID())){
                check = true;
                System.out.println(s);
                break;
            }
        }
        if(!check){
            throw new Exception("Student with ID " + ID + " does not exist!");
        }
    }

    public void sortListByScore() throws Exception {
        ArrayList<Student> newList = (ArrayList<Student>) students.stream()
                .map(student -> new Student(student.getID(), student.getName(), student.getScore()))
                .collect(Collectors.toList());

        if(newList.isEmpty()){
            throw new Exception("List is empty!");
        }

        newList = (ArrayList<Student>) newList.stream().sorted((o1, o2) -> Double.compare(o1.getScore(), o2.getScore())).collect(Collectors.toList());

        System.out.println("List student after sorting: ");
        newList.forEach(student -> System.out.println(student.toString()));
        System.out.println();
    }

    public void checkStudentExists(){
        String ID = Utils.getString("Enter Student ID want to check: ");
        boolean check = false;
        for(Student s : students){
            if(setID.contains(ID)){
                check = true;
                System.out.println("Student with ID " + ID + " has existed!");
                break;
            }
        }
        if(!check){
            System.err.println("Student with ID " + ID + " does not exist!");
        }
    }

}
