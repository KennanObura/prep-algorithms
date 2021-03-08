package JAVACORE.threading.synchronizedexample;

public class ShapeThread implements Runnable {
    String name;


    public ShapeThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            if (this.name.equals("CIRCLE")) ShapeBuilder.build(this.name);
            else ShapeBuilder.paint(this.name, "RED");
        } catch (Exception e) {
            System.out.println(e);
        }

    }


    public static void main(String[] args) {
        Thread thread = new Thread(new ShapeThread("CIRCLE"));
        Thread thread1 = new Thread(new ShapeThread("RECT"));

        thread.start();
        thread1.start();
    }
}

