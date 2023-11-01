package producerConsumer;

public class Consumer implements Runnable {

    private final MyQueue queue;

    public Consumer(MyQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        while (true){
            synchronized (queue){
                while (queue.isEmpty() && ProducerConsumerSimulator.cnt > 0){
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(ProducerConsumerSimulator.cnt == 0){
                    queue.notifyAll();
                    break;
                }
                int x = queue.pop();
                System.out.println("Consumer consumed value: " + x);
                if(x == -1) {
                    ProducerConsumerSimulator.cnt--;
                    break;
                }
                queue.notifyAll();
            }

        }

    }
}
