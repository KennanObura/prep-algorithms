package LEETCODE.threading;

import java.util.concurrent.Semaphore;

/**
 * 1114. Print in Order
 * <p>
 * Suppose we have a class:
 * <p>
 * public class Foo {
 * public void first() { print("first"); }
 * public void second() { print("second"); }
 * public void third() { print("third"); }
 * }
 * The same instance of Foo will be passed to three different threads. Thread A will call first(), thread B will call second(), and thread C will call third(). Design a mechanism and modify the program to ensure that second() is executed after first(), and third() is executed after second().
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * Output: "firstsecondthird"
 * Explanation: There are three threads being fired asynchronously. The input [1,2,3] means thread A calls first(), thread B calls second(), and thread C calls third(). "firstsecondthird" is the correct output.
 * Example 2:
 */

public class PrintInOrder {
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        Thread t1 = new Thread(new MyThread("first"));
        Thread t2 = new Thread(new MyThread("second"));
        Thread t3 = new Thread(new MyThread("third"));

        foo.first(t1);
        foo.second(t2);
        foo.third(t3);
    }
}

class MyThread implements Runnable {
    String name;

    MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(this.name);
    }
}

class Foo {

    Semaphore A;
    Semaphore B;

    public Foo() {
        try {
            this.A = new Semaphore(1);
            this.B = new Semaphore(1);

            A.acquire();
            B.acquire();

        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.

        printFirst.run();
        A.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        A.acquire();
        A.release();


        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();

        B.release();
    }

    public void third(Runnable printThird) throws InterruptedException {

        B.acquire();
        B.release();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
