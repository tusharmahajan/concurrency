package deadlocks.basics;

public class MyRunnable implements Runnable {

    private final Object lock1, lock2;

    public MyRunnable(Object lock1, Object lock2) {
        // locks are passed in different order to create a deadlock scenario
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {

        synchronized (lock1){
            for(int i = 0;i<100000;i++);
            synchronized (lock2){
                System.out.println("Hey i am done!!");
            }
        }
    }
}
