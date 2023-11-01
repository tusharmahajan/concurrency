package producerConsumer.problemWithWaitNotify;

public class Notifier implements Runnable {

    String s2 = "abc";

    @Override
    public void run() {

        synchronized (s2){
            System.out.println(s2.hashCode());

            s2.notifyAll();
            System.out.println("work done by notifier");
        }
    }
}
