package signaling.example2;

import java.util.List;

public class TickingBoard {
    
    private final List<Integer> appointments;
    private int curr;

    public TickingBoard(List<Integer> appointments) {
        this.appointments = appointments;
        this.curr = 0;
    }


    public boolean isMyTurn(Integer appointmentId){
        if(curr == appointments.size()) throw new RuntimeException("No more assignments");
        if(curr != appointmentId) return false;
        curr++;
        return true;
    }

}
