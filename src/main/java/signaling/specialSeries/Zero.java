package signaling.specialSeries;

public class Zero implements Runnable {

    private final Object lock;

    public Zero(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        synchronized (lock){
            while(SeriesSimulator.curr <= SeriesSimulator.total){
                if(!SeriesSimulator.isZeroLast){
                    System.out.println(0);
                    SeriesSimulator.isZeroLast = true;
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
