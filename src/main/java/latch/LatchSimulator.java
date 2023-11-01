package latch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LatchSimulator {

    static int sum = 0;
     public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);
        CountDownLatch countDownLatch = new CountDownLatch(4);

        List<Thread> list = new ArrayList<>();
        list.add(new Thread(new SumWorker(numbers, 0, 1, countDownLatch)));
        list.add(new Thread(new SumWorker(numbers, 2, 3, countDownLatch)));
        list.add(new Thread(new SumWorker(numbers, 4, 5, countDownLatch)));
        list.add(new Thread(new SumWorker(numbers, 6, 7, countDownLatch)));

        Thread printThread = new Thread(new PrintWorker(countDownLatch));

        for(Thread thread: list){
            thread.start();
        }

        printThread.start();
    }
}
