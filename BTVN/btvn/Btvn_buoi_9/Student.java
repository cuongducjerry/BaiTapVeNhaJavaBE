package Btvn_buoi_9;

public class Student {
    private String ID;
    private String name;
    private double score;

    public Student(String ID, String name, double score) {
        this.ID = ID;
        this.name = name;
        this.score = score;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
