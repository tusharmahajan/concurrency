package signaling;


public class ThreadSignalingBasics {

    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();

        Thread t1 = new Thread(new Waiter(lock));
        Thread t2 = new Thread(new Waiter(lock));
        Thread t3 = new Thread(new Notifier(lock));

        t1.start();
        t2.start();
        Thread.sleep(3);
        t3.start();

    }
}
