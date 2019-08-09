package tickets;

import java.util.Calendar;

public class MovieTicketFlyweight implements IMovieTicket {
    private final MovieTicket movieTicket;
    private final Calendar showTime;

    public MovieTicketFlyweight(MovieTicket movieTicket, Calendar showTime) {
        this.movieTicket = movieTicket;
        this.showTime = showTime;
    }

    @Override
    public String getMovieName() {
        return movieTicket.getMovieName();
    }

    @Override
    public String getMovieStudio() {
        return movieTicket.getMovieStudio();
    }

    @Override
    public String getDirector() {
        return movieTicket.getDirector();
    }

    @Override
    public Calendar getShowtime() {
        return showTime;
    }
}
