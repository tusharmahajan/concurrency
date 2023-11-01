package deadlocks.resolutionIn3Threads;


public class SameSequence {

    public static void main(String[] args) {
        MyLock lock1 = new MyLock(1);
        MyLock lock2 = new MyLock(2);
        MyLock lock3 = new MyLock(3);

        Thread t1 = new Thread(new Worker(lock1 ,lock2));
        Thread t2 = new Thread(new Worker(lock2 ,lock3));
        Thread t3 = new Thread(new Worker(lock3 ,lock1));

        t1.start();
        t2.start();
        t3.start();
    }
}
