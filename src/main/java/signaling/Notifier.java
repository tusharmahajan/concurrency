package signaling;

public class Notifier implements Runnable {

    private final Object lock;

    public Notifier(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            lock.notifyAll();
        }
    }
}
