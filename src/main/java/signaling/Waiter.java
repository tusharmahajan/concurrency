package signaling;

public class Waiter implements Runnable {

    private final Object lock;

    public Waiter(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            System.out.println("Hi I am " + Thread.currentThread().getName());
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Executed " + Thread.currentThread().getName());
        }

    }
}
