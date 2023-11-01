package deadlocks.resolutionIn3Threads;

public class Worker implements Runnable {

    private final MyLock lock1, lock2;

    public Worker(MyLock lock1, MyLock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }


    @Override
    public void run() {
        MyLock l1, l2;
        if(lock1.getId() < lock2.getId()){
            l1 = lock1;
            l2 = lock2;
        }
        else{
            l1 = lock2;
            l2 = lock1;
        }

        synchronized (l1){
            for(int i = 0;i<100000;i++);
            synchronized (l2){
                System.out.println("Hey I am feeling great!!");
            }
        }
    }
}
