

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlock {

    public static void main(String[] args) {
        Lock l1 = new ReentrantLock();
        Lock l2 = new ReentrantLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                l1.lock();
                System.out.println("L1 lock applied");
                try {
                    this.wait(500);
                    l2.lock();
                    System.out.println("L1 lock applied");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                l2.lock();
                System.out.println("L2 lock applied");
                try {
                    this.wait(5000);
                    l1.lock();
                    System.out.println("L1 lock applied");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
        t1.start();
        t2.start();
    }
}