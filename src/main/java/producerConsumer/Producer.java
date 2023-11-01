package producerConsumer;

public class Producer implements Runnable {

    private final MyQueue queue;

    public Producer(MyQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        for(int i = 0;i<500;i++){
            synchronized (queue){
                while (queue.isFull()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.push(i);
                System.out.println("Producer produced element: " + i);
                queue.notifyAll();
            }
        }
        synchronized (queue){
            while(queue.isFull()) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.push(-1);
            System.out.println("Producer produced -1");
            queue.notifyAll();
        }
    }
}
