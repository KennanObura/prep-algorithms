package kennan.co.ke.objectOriented.objectReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Example {
    private int num;
    private double max;

    public Example(int num) {
        this.num = num;
        this.max = 0.0;
    }

    public Example() {
        this.num = 0;
        this.max = 0.0;
    }

    Example(int num, double max) {
        this.num = num;
        this.max = max;
    }

    private void setNum(int num) {
        System.out.println("Current num " + this.num + " setting to" + num);
        num = num;
    }

    public void printMax() {
        System.out.println("Max is " + this.max);
    }



}
