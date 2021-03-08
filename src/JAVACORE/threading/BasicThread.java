package JAVACORE.threading;

import java.util.Random;

public class BasicThread implements Runnable {
    String name;
    int time;

    BasicThread(String name) {
        this.name = name;
        this.time = 1;

    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread());
//            for (int i = 1; i < 12; i++) {
                time = new Random(10).nextInt();
                System.out.printf("Thread %s is sleeping for %d", this.name, this.time);
                System.out.println();
//                Thread.sleep(1000);
            Thread.yield();
                System.out.printf("Thread %s is is continuing", this.name);
                System.out.println();
//            }

        } catch (Exception e) {
            System.out.println("Opps" + e);
        }

    }

}
