package niuke.tonghuashun;

import java.util.concurrent.locks.Lock;

/**
 * @author xinchan
 * @version 1.0.1 2023-02-20
 */
public class Deadlock {
    private Object lock1;
    private Object lock2;

    public Deadlock() {
        this.lock1 = new Object();
        this.lock2 = new Object();
    }

    public void obtainedLock1() {
        while (true) {
            synchronized (lock1) {
                System.out.println("Obtained lock1");
                applyLock2();
            }
        }
    }

    public void applyLock1() {
        synchronized (lock1) {
            System.out.println("Applying lock1");
        }
    }

    public void obtainedLock2() {
        while (true) {
            synchronized (lock2) {
                System.out.println("Obtained lock2");
                applyLock1();
            }
        }
    }

    public void applyLock2() {
        synchronized (lock2) {
            System.out.println("Applying lock2");
        }
    }

    public static void main(String[] args) {
        Deadlock deadlock = new Deadlock();

        new Thread(() -> deadlock.obtainedLock1()).start();
        new Thread(() -> deadlock.obtainedLock2()).start();
    }
}
