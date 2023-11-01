package deadlocks.nestedMonitorLockOuts;

public class NestedLockoutSimulator {

    public static void main(String[] args) throws InterruptedException {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread w = new Thread(new Waiter(lock1, lock2));
        Thread n = new Thread(new Notifier(lock1, lock2));

        w.start();
        Thread.sleep(1000);
        n.start();
    }
}
