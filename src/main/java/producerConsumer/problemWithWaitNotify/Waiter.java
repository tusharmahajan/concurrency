package producerConsumer.problemWithWaitNotify;

public class Waiter implements Runnable {

    String s1 = "abc";

    @Override
    public void run() {

        synchronized (s1){
            try {
                System.out.println(s1.hashCode());
                s1.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("work done by waiter");
        }
    }
}
