package deadlocks.cautionAlienMethodCalls;

import java.util.List;

public class Movie {

    private final String id;
    private final List<Theatre> theatres;

    public Movie(String id, List<Theatre> theatres) {
        this.id = id;
        this.theatres = theatres;
    }

    public void addTheatres(Theatre theatre){
        synchronized (this){  // moved this synchronized block one level down ie inside method to avoid deadlock
            this.theatres.add(theatre);  // alien method // open calls
        }
        theatre.addMovie(id);
    }

    public synchronized String getId(){
        return this.id;
    }
}
