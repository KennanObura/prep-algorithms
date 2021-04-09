package LEETCODE.threading;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzzMultithreaded {




}

class FizzBuzz {
    private int n;
    private Semaphore fizzSm;
    private Semaphore buzzSm;
    private Semaphore fizzBuzzSm;
    private Semaphore numSm;

    public FizzBuzz(int n) {
        this.n = n;
        fizzSm = new Semaphore(0);
        buzzSm = new Semaphore(0);
        fizzBuzzSm = new Semaphore(0);
        numSm = new Semaphore(1);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {

        for(int i = 3; i <= n; i+=3){


            if(i % 5 == 0) continue;
            fizzSm.acquire();
            printFizz.run();
            numSm.release();

        }

    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {

        for(int i = 5; i <= n; i+=5){

            if(i % 3 == 0) continue;
            buzzSm.acquire();
            printBuzz.run();
            numSm.release();

        }

    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {

        for(int i = 15; i <= n; i+=15){
            fizzBuzzSm.acquire();


            printFizzBuzz.run();
            numSm.release();

        }

    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {


        for(int i=1; i <= n; i+=1){
            numSm.acquire();
            if(i % 15 == 0){
                fizzBuzzSm.release();
            }else if( i % 5 ==0){
                buzzSm.release();
            }else if(i % 3 ==0){
                fizzSm.release();
            }else{
                printNumber.accept(i);
                numSm.release();
            }
        }

    }
}
