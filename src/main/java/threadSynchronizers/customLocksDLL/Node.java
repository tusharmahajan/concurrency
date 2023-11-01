package threadSynchronizers.customLocksDLL;

import lombok.Getter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
public class Node {

    public int val;
    public Node next;
    public Node prev;
    public Lock lock;

    public Node(int val) {
        this.val = val;
        this.lock = new ReentrantLock();
    }

}
