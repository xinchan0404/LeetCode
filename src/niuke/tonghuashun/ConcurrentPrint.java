package niuke.tonghuashun;

import java.util.Objects;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xinchan
 * @version 1.0.1 2023-02-20
 */
public class ConcurrentPrint {
    private Lock lock = new ReentrantLock();
    private static int state;
    private int times;

    public ConcurrentPrint(int times) {
        this.times = times;
    }

    public void printer(int threadNum) {
        for (int i = 0; i < times;) {
            try {
                lock.lock();
                if (state % times == threadNum) {
                    state++;
                    i++;
                    System.out.print(Thread.currentThread().getName() + threadNum);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ConcurrentPrint print = new ConcurrentPrint(4);

        new Thread(() -> print.printer(0), "A").start();
        new Thread(() -> print.printer(1), "B").start();
        new Thread(() -> print.printer(2), "C").start();
        new Thread(() -> print.printer(3), "D").start();
    }
}

class ConcurrentPrint_1 {
    private Lock lock = new ReentrantLock();
    private static int state;
    private int times;
    private Condition t1 = lock.newCondition();
    private Condition t2 = lock.newCondition();
    private Condition t3 = lock.newCondition();
    private Condition t4 = lock.newCondition();

    public ConcurrentPrint_1(int times) {
        this.times = times;
    }

    public void printer(int threadNum, Condition cur, Condition next) {
        for (int i = 0; i < times;) {
            try {
                lock.lock();
                if (state % times != threadNum) {
                    cur.await();  // block current thread
                }
                state++;
                i++;
                System.out.print(Thread.currentThread().getName());
                next.signal();  // awaken next thread
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ConcurrentPrint_1 print = new ConcurrentPrint_1(4);

        new Thread(() -> print.printer(0, print.t1, print.t2), "A").start();
        new Thread(() -> print.printer(1, print.t2, print.t3), "B").start();
        new Thread(() -> print.printer(2, print.t3, print.t4), "C").start();
        new Thread(() -> print.printer(3, print.t4, print.t1), "D").start();
    }
}

class ConcurrentPrint_2 {
    private Object lock;
    private static int state;
    private int times;

    public ConcurrentPrint_2(int times) {
        lock = new Object();
        this.times = times;
    }

    public void printer(int threadNum) {
        for (int i = 0; i < times;) {
            synchronized (lock) {
                while (state % times != threadNum) {  // only while, not if
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                state++;
                i++;
                System.out.print(Thread.currentThread().getName());
                lock.notifyAll();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        ConcurrentPrint_2 print = new ConcurrentPrint_2(4);

        new Thread(() -> print.printer(0), "A").start();
        new Thread(() -> print.printer(1), "B").start();
        new Thread(() -> print.printer(2), "C").start();
        new Thread(() -> print.printer(3), "D").start();
    }
}
