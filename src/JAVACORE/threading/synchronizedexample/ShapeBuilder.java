package JAVACORE.threading.synchronizedexample;

public class ShapeBuilder {


    public static synchronized void build(String shape) {
        System.out.println("Building " + shape + " ...");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Error :" + e);
        }
        System.out.println("Building " + shape + " finished");
    }


    public static synchronized void paint(String shape, String color) {
        System.out.println("Paining " + shape + " with color " + color + "...");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Error :" + e);
        }
        System.out.println("Paining " + shape + " finished");
    }


}
