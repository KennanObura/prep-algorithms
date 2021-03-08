package JAVACORE.threading.synchronizedexample;




public class Sender {
    String name;
    String message;

    public Sender(String name, String message) {
        this.name = name;
        this.message = message;
    }


    public synchronized void send() {

        System.out.printf("Sending message to %s", this.name);
        System.out.println();
        try {
            System.out.println(Thread.currentThread().getName() + " Is sleeping");
            Thread.sleep(1000);

        } catch (Exception e) {
            System.out.println("Error " + e);
        }

        System.out.printf("Message : %s is sent to %s on Thread id %s", this.message, this.name, Thread.currentThread().getId());
        System.out.println();

    }
}
