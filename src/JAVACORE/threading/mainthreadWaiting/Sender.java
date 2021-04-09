package JAVACORE.threading.mainthreadWaiting;


public class Sender implements Runnable {

    private Message message;

    Sender(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        try {
            countNumbers();
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }

    }

    private void countNumbers() throws InterruptedException {
        for (int i = 0; i < 60; i++) {
            Thread.sleep(6000);
            this.message.printIt(i + "% in progress... ");
        }
    }
}
