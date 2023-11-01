package deadlocks.diningPhilosopherProblem;

public class PhilosopherWorker implements Runnable {

    private final String name;
    private final Chopstick left;
    private final Chopstick right;

    public PhilosopherWorker(Chopstick left, Chopstick right, String name) {
        this.left = left;
        this.right = right;
        this.name = name;
    }

    @Override
    public void run() {

        Chopstick lock1, lock2;

        if(left.getId() < right.getId()){
            lock1 = left;
            lock2 = right;
        }
        else{
            lock1 = right;
            lock2 = left;
        }
        while(true){
            System.out.println("Philospher: " + name + " is thinking!!");
            try {
                Thread.sleep(1000);
                synchronized (lock1){
                    Thread.sleep(2000);
                    synchronized (lock2){
                        System.out.println("Philosopher: " + name + " is eating yumm!!");
                        Thread.sleep(1000);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
