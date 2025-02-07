package BaiKiemTraThucHanh;

public class Student {
    private String name;
    private int age;
    private String id;

    public Student(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void updateStudentByID() {
        String newID, currentID;
        currentID = this.id;
        do{
            newID = Utils.updateString(currentID, "Enter the new ID you to want update: ");
            if(newID.equals(currentID)) {
                System.err.println("Duplicated ID!");
            }
            else{
                this.id = newID;
            }
        }while(currentID.equals(newID));
        this.name = Utils.updateString(this.name, "Enter the new name: ");
        this.age = Utils.updateInt(this.age, "Enter the new age: ");
        System.out.println("You have updated successfully!");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                '}';
    }
}