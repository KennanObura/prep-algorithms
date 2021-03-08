package JAVACORE;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class BlockingQueuePC {



    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(20);
        int poisonPill = -1;

        Thread tc = new Thread(new Consumer(queue, poisonPill));

        Thread tp = new Thread(new Producer(queue, poisonPill));

        tc.start();
        tp.start();
    }
}


class Consumer implements Runnable {

    BlockingQueue<Integer> queue;
    int poisonPill;

    Consumer(BlockingQueue<Integer> queue, int poisonPill) {
        super();
        this.queue = queue;
        this.poisonPill = poisonPill;
    }

    @Override
    public void run() {
        try {
            consume();
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }

    }


    private void consume() throws InterruptedException {
        while (true) {
            Integer item = queue.take();
            if(item.equals(poisonPill)) return;
            System.out.println("Consumer taken " + item);
        }
    }
}

class Producer implements Runnable {
    BlockingQueue<Integer> queue;
    int poisonPill;

    Producer(BlockingQueue<Integer> queue, int poisonPill) {
        super();
        this.queue = queue;
        this.poisonPill = poisonPill;
    }


    @Override
    public void run() {
        try {
            produce();
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }

    }

    private void produce() throws InterruptedException {
        for (int i = 1; i <= 13; i++) {
            Thread.sleep(2000);
            Integer item = ThreadLocalRandom.current().nextInt(100);
            System.out.println("Produced :" + item);
            queue.put(item);
        }
        queue.put(poisonPill);
    }
}
