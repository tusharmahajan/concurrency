package latch;

import java.util.List;

public class SumWorker implements Runnable {

    private final List<Integer> numbers;
    private final int i;
    private final int j;
    private final CountDownLatch countDownLatch;

    public SumWorker(List<Integer> numbers, int i, int j, CountDownLatch countDownLatch) {
        this.numbers = numbers;
        this.i = i;
        this.j = j;
        this.countDownLatch = countDownLatch;
    }


    @Override
    public void run() {
        int a = 0;
        for(int itr = i;itr<=j;itr++){
            a+=numbers.get(itr);
        }
        synchronized (countDownLatch){
            LatchSimulator.sum+=a;
        }
        countDownLatch.countDown();
    }
}
