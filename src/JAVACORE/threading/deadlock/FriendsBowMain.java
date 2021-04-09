package JAVACORE.threading.deadlock;

/**
 * Deadlock
 * Deadlock describes a situation where two or more threads are blocked forever, waiting for each other.
 * Here's an example.
 *
 * Alphonse and Gaston are friends, and great believers in courtesy. A strict rule of courtesy is
 * that when you bow to a friend, you must remain bowed until your friend has a chance to return the bow.
 * Unfortunately, this rule does not account for the possibility that two friends might bow to each other at the same time.
 * This example application, Deadlock, models this possibility:
 */
public class FriendsBowMain {
    public static void main(String[] args) {
        Friend dan = new Friend("Dan");

        Friend gran = new Friend("Gran");

        Thread t1 = new Thread(new FriendsBow(dan, gran));

        Thread t2 = new Thread(new FriendsBow(gran, dan));

        t1.start();
        t2.start();
    }
}
