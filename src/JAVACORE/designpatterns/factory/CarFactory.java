package JAVACORE.designpatterns.factory;

import java.util.function.Supplier;

enum TypeCar {
    TOYOTA(Toyota::new),
    VOLVO(Volvo::new),
    FORD(Ford::new);

    private final Supplier<Car> carSupplier;

    TypeCar(Supplier<Car> carSupplier) {
        this.carSupplier = carSupplier;
    }

    Supplier<Car> getCar() {
        return this.carSupplier;
    }
}


public class CarFactory {
    public static Car getCar(TypeCar typeCar) {
        return typeCar.getCar().get();
    }
}
