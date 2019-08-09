package tickets;

import java.util.Calendar;

public class SpidermanMovieTicketFactory implements IMovieTicketFactory {

    private static final SpidermanMovieTicketFactory instance = new SpidermanMovieTicketFactory();
    private static final MovieTicket movieTicket = new MovieTicket("Spiderman", "MGM", "Steven Spielberg");
    
    private SpidermanMovieTicketFactory(){ }

    public static IMovieTicketFactory getInstance() {
        return instance;
    }

    @Override
    public IMovieTicket createTicket(Calendar showtime) {
        return new MovieTicketFlyweight(movieTicket, showtime);
    }
}
