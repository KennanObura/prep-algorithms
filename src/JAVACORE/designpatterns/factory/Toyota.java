package JAVACORE.designpatterns.factory;

public class Toyota implements Car {
    @Override
    public void applyBraking() {
        System.out.println("Applying braking  to Toyota");
    }

    @Override
    public void openRareCamera() {
        System.out.println("Opening rare cam to Toyota");
    }
}
