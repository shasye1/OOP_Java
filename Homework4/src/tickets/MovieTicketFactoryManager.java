package tickets;

public class MovieTicketFactoryManager {

    public static IMovieTicketFactory getMissionImpossibleMovieTicketFactory() {
        return MissionImpossibleMovieTicketFactory.getInstance();
    }

    public static IMovieTicketFactory getStarWarsMovieTicketFactory() {
        return StarWarsMovieTicketFactory.getInstance();
    }

    public static IMovieTicketFactory getSpidermanMovieTicketFactory() {
        return SpidermanMovieTicketFactory.getInstance();
    }

}
