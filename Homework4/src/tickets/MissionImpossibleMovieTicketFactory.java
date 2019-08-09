package tickets;

import java.util.Calendar;

public class MissionImpossibleMovieTicketFactory implements IMovieTicketFactory {
    private static final MissionImpossibleMovieTicketFactory instance = new MissionImpossibleMovieTicketFactory();
    private static final MovieTicket movieTicket = new MovieTicket("Mission Impossible", "DreamWorks", "JJ Abrams");
    
    private MissionImpossibleMovieTicketFactory(){ }

    public static IMovieTicketFactory getInstance() {
        return instance;
    }

    @Override
    public IMovieTicket createTicket(Calendar showtime) {
        return new MovieTicketFlyweight(movieTicket, showtime);
    }
}
