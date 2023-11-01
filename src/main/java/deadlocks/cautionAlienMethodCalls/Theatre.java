package deadlocks.cautionAlienMethodCalls;

import java.util.ArrayList;
import java.util.List;

public class Theatre {

    private final List<String> movieIds;

    public Theatre() {
        this.movieIds = new ArrayList<>();
    }

    public synchronized void addMovie(String movieId) {
        movieIds.add(movieId);
    }

    public boolean isMovieAvailable(Movie movie){
        boolean result;
        synchronized(this){     // moved this synchronized block from method level to more granular level
            result = this.movieIds.contains(movie.getId());
        }
        return result;
    }
}
