package signaling.specialSeries;

public class Even implements Runnable {

    private final Object lock;

    public Even(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        synchronized (lock){
            while(SeriesSimulator.curr <= SeriesSimulator.total){
                if(SeriesSimulator.isZeroLast && SeriesSimulator.curr%2 == 0){
                    System.out.println(SeriesSimulator.curr);
                    SeriesSimulator.curr++;
                    SeriesSimulator.isZeroLast = false;
                    lock.notifyAll();
                }
                else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
