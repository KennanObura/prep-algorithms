package JAVACORE.threading.mainthreadWaiting;

public class Message {
    final private String message;
    final private String name;

    Message(String name, String message) {
        this.message = message;
        this.name = name;
        printIt();
    }

    private void printIt() {
        System.out.println("------------------------------");
        System.out.printf("%s is %s", this.name, this.message);
    }

    public void printIt(String message) {
        System.out.println("------------------------------");
        System.out.printf("%s is %s", this.name, message);
    }
}
