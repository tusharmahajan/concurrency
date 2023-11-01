package signaling.example2;

import java.util.ArrayList;
import java.util.List;

public class Appointments {

    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        List<Integer> appointments = new ArrayList<>();

        for(int i = 0;i<10;i++) appointments.add(i);

        TickingBoard tickingBoard = new TickingBoard(appointments);

        for(int i = 9;i>=0;i--){
            customers.add(new Customer(appointments.get(i), tickingBoard));
        }

        for(int i = 0;i<10;i++) new Thread(customers.get(i)).start();

    }
}
