package JAVACORE.designpatterns.factory;

public class Main {



    public static void main(String[] args) {
        Car volvo = CarFactory.getCar(TypeCar.VOLVO);

        Car toyota = CarFactory.getCar(TypeCar.TOYOTA);

        volvo.applyBraking();
        toyota.openRareCamera();
    }
}
