package latch;

public class PrintWorker implements Runnable {

    private final CountDownLatch countDownLatch;

    public PrintWorker(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(LatchSimulator.sum);
    }
}
