package latch;

import lombok.Getter;

@Getter
public class CountDownLatch {

    private int count;

    public CountDownLatch(int count) {
        this.count = count;
    }

    public synchronized void await() throws InterruptedException {

        while(count > 0){
            System.out.println(Thread.currentThread().getName() + " is waiting.");
            wait();
        }
        System.out.println(Thread.currentThread().getName() + " exiting waiting state.");
    }

    public synchronized void countDown() {
        this.count--;
        if(count == 0){
            notifyAll();
        }
        System.out.println(Thread.currentThread().getName() + " decreased the count.");
    }
}
