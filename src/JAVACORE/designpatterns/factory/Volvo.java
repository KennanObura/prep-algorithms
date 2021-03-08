package JAVACORE.designpatterns.factory;

public class Volvo implements Car{

    @Override
    public void applyBraking() {
        System.out.println("Applying  breaking to Volvo");
    }

    @Override
    public void openRareCamera() {
        System.out.println("Opening rare cam to Volvo");
    }
}
