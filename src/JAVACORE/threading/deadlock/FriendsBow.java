package JAVACORE.threading.deadlock;

import java.util.Random;

public class FriendsBow implements Runnable {
    final Friend A;
    final Friend B;

    public FriendsBow(Friend A, Friend B) {
        this.A = A;
        this.B = B;
    }


    @Override
    public void run() {

        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(1000));
            bow();
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }

    private void bow() {
        A.bow(B);
    }

    private void bowBack(Friend friend, Friend bowee) {
        friend.bowBack(bowee);
    }


}
