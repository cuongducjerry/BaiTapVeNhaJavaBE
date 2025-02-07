package Buoi10;

public class Main {
    public static void main(String[] args) {
        System.out.println("---------- Main started ----------");
        Thread1 t1 = new Thread1("task 1");
        Thread2 t2 = new Thread2("task 2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        int sumTotal = t1.getSum() + t2.getSum();
        System.out.println("Sum from 1 to 10: " + sumTotal);
        System.out.println("----------- Main ended -----------");
    }
}
