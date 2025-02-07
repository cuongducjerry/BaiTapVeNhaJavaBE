package Buoi10;

public class Thread2 extends Thread {
    private String name;
    private int sum = 0;

    public Thread2(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 6; i <= 10; i++) {
            sum += i;
        }
        System.out.println("Sum from 6 to 10: " + sum + "(" + name + ")");
    }

    public int getSum() {
        return sum;
    }
}