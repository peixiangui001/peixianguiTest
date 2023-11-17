package demo;

public class VolatileTest extends Thread {
    static volatile long num = Long.MAX_VALUE;

    @Override
    public synchronized void run() {
        num = num >> 1;
        System.out.println(num);
    }

    public static void main(String[] args) {
       new VolatileTest().start();
       new VolatileTest().start();
       new VolatileTest().start();
       new VolatileTest().start();
    }


}
