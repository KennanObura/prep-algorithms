package JAVACORE.threading.mainthreadWaiting;

public class MainSender {
    static long startTime;
    static long maxWaiting = 1000 * 60 * 60;

    public static void main(String[] args) throws InterruptedException {

        Message message = new Message(Thread.currentThread().getName(), "started");
        Sender sender = new Sender(message);
        Thread thread = new Thread(sender);

        startTime = System.currentTimeMillis();
        thread.start();

        while (thread.isAlive()){
            message.printIt("waiting...");

            long currentTime = System.currentTimeMillis();

            thread.join(1000);

            if(thread.isAlive() && currentTime - startTime > maxWaiting){
                thread.interrupt(); //max time exceeded

                message.printIt("wont be long before  exits");
                thread.join();
            }
        }
    }
}
