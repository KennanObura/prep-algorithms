package JAVACORE.threading;

public class BasicThreadDriver {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new BasicThread("ONE"));
        Thread t2 = new Thread(new BasicThread("TWO"));
        Thread t3 = new Thread(new BasicThread("THREE"));

        System.out.println(Thread.currentThread());

        t1.start();

//        t1.join();

        t2.start();
        t3.setPriority(Thread.MAX_PRIORITY);
//        Thread.yield();
//        t2.join();
        System.out.println("starting two and three in any order");
        t3.start();

    }
}
