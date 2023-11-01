package signaling.example2;

public class Customer implements Runnable{

    private final Integer appointmentId;
    private final TickingBoard tickingBoard;

    public Customer(Integer appointmentId, TickingBoard tickingBoard) {
        this.appointmentId = appointmentId;
        this.tickingBoard = tickingBoard;
    }


    @Override
    public void run() {
        synchronized (tickingBoard){
            while(!tickingBoard.isMyTurn(appointmentId)){
                try {
                    System.out.println("Entry denied: " + appointmentId);
                    tickingBoard.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Hi I am appointment id: " + appointmentId);
            tickingBoard.notifyAll();
        }
    }
}
