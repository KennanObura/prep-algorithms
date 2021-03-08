package JAVACORE.threading.synchronizedexample;

public class SenderDriver {
    public static void main(String[] args) throws InterruptedException {
        Sender sender = new Sender("Bob", "Commit last message to members");
//        Sender sender2 = new Sender("Tracy", "Commit received with thanks");
//        Sender sender3 = new Sender("Glore", "I am in receipt");

        Thread thread1 = new Thread(new SenderThread("Ms1", sender));
        Thread thread2 = new Thread(new SenderThread("Ms2", sender));
        Thread thread3 = new Thread(new SenderThread("Ms3", sender));

        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();

        thread3.join();

        System.out.println("ALL FINISHED");

    }
}
