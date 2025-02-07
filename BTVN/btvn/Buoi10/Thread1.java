package Buoi10;

public class Thread1 extends Thread {
    private String name;
    private int sum = 0;

    public Thread1(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            sum += i;
        }
        System.out.println("Sum from 1 to 5: " + sum + "(" + name + ")");
    }

    public int getSum() {
        return sum;
    }
}
