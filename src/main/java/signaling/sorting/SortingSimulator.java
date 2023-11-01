package signaling.sorting;

import java.util.ArrayList;
import java.util.List;

public class SortingSimulator {

    public static int curr = 0;
    public static void main(String[] args) {
        Object lock = new Object();

        List<Worker> workers = new ArrayList<>();

        for(int i = 20;i>=0;i--){
            workers.add(new Worker(i, lock));
        }

        for(int i = 0;i<=20;i++){
            new Thread(workers.get(i)).start();
        }

    }
}
