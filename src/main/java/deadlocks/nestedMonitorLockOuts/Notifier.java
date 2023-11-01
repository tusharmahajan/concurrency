package deadlocks.nestedMonitorLockOuts;

public class Notifier implements Runnable{

    private final Object lock1, lock2;

    public Notifier(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {

        synchronized (lock1){
            synchronized (lock2){
                lock2.notifyAll();
                System.out.println("notified");
            }
        }
    }
}
