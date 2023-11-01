package deadlocks.basics;

public class DeadLockCondition {

    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread t1 = new Thread(new MyRunnable(lock1, lock2));
        Thread t2 = new Thread(new MyRunnable(lock2, lock1));

        t1.start();
        t2.start();
    }
}
