package producerConsumer;

import java.util.ArrayList;
import java.util.List;

public class MyQueue {

    private int front;
    private int rear;
    private final List<Integer> queue;
    private int capacity;

    public MyQueue(int capacity) {
        this.front = 0;
        this.rear = -1;
        this.capacity = capacity;
        this.queue = new ArrayList<>();
    }

    public boolean isFull(){
        return rear-front+1 == capacity;
    }

    public boolean isEmpty(){
        return this.front > this.rear;
    }

    public void push(int num){
        if(isFull()){
            throw new RuntimeException("Queue is Overflowed!!");
        }
        this.queue.add(num);
        rear++;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("Queue is Underflowed!!");
        }
        return this.queue.get(front++);
    }
}
