package tickets;

import java.util.Calendar;

public class StarWarsMovieTicketFactory implements IMovieTicketFactory {
    private static final StarWarsMovieTicketFactory instance = new StarWarsMovieTicketFactory();
    private static MovieTicket movieTicket = new MovieTicket("Star Wars", "LucasFilm", "George Lucas");

    private StarWarsMovieTicketFactory(){ }

    public static IMovieTicketFactory getInstance() {
        return instance;
    }

    @Override
    public IMovieTicket createTicket(Calendar showtime) {
        return new MovieTicketFlyweight(movieTicket, showtime);
    }
}
