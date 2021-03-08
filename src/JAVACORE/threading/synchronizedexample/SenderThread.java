package JAVACORE.threading.synchronizedexample;

public class SenderThread implements Runnable {
    Sender sender;
    String name;

    public SenderThread(String name, Sender sender) {
        this.sender = sender;
        this.name = name;
    }

    @Override
    public void run() {
        try{
            System.out.println(Thread.currentThread().getName() + " Is currently in progress ...");
            sender.send();
        }catch (Exception e){
            System.out.println(Thread.currentThread().getName() + " Is Interrupted");
        }

    }
}
