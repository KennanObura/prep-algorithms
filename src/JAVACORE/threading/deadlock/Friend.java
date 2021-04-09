package JAVACORE.threading.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Friend {
    String name;
    Lock lock;

    public Friend(String name) {
        this.name = name;
        this.lock = new ReentrantLock();
    }


    private boolean isImpendingBow(Friend friend) {
        boolean myLock = false;
        boolean friendsLock = false;

        try {
            myLock = this.lock.tryLock();
            friendsLock = friend.lock.tryLock();
        } finally {
            if (!(myLock && friendsLock)) {
                if (myLock)
                    this.lock.unlock();

                if (friendsLock)
                    friend.lock.unlock();
            }
        }

        return myLock && friendsLock;
    }

    public void bow(Friend friend) {
        if(isImpendingBow(friend)){
            try {
                System.out.println();
                System.out.printf("%s has bowed to me , i must bow back", this.name);
                bowBack(this);
            }finally {
                this.lock.unlock();
                friend.lock.unlock();
            }
        }else {
            System.out.println();
            System.out.printf("%s tried to bow to me , but got me busy", this.name);
        }

    }


    public void bowBack(Friend friend) {
        System.out.println();
        System.out.printf("%s is bowing back to %s", this.name, friend.name);
    }
}
