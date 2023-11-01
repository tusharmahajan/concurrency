package signaling.sorting;

public class Worker implements Runnable{

    private final int number;
    private final Object lock;

    public Worker(int number, Object lock) {
        this.number = number;
        this.lock = lock;
    }

    @Override
    public void run() {

        synchronized (lock){
            while(SortingSimulator.curr != number){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(number);
            SortingSimulator.curr++;
            lock.notifyAll();
        }

    }

}
