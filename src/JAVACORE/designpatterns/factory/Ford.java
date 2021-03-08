package JAVACORE.designpatterns.factory;

public class Ford implements Car {
    @Override
    public void applyBraking() {
        System.out.println("Applying braking to Ford");
    }

    @Override
    public void openRareCamera() {
        System.out.println("Opening rare cam to Ford");
    }
}
