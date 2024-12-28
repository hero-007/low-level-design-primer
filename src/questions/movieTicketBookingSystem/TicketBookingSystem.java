package questions.movieTicketBookingSystem;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicketBookingSystem {
  private static TicketBookingSystem ticketBookingSystem;

  private Map<City, List<Movie>> cityToMoviesMap;
  private Map<Movie, List<Show>> movieToShow;

  private TicketBookingSystem() {
    this.cityToMoviesMap = new HashMap<>();
    this.movieToShow = new HashMap<>();
  }

  public TicketBookingSystem getInstance() {
    if (ticketBookingSystem == null)
      ticketBookingSystem = new TicketBookingSystem();

    return ticketBookingSystem;
  }


  public List<Movie> getAllMovies(City city) {
    return cityToMoviesMap.getOrDefault(city, Collections.EMPTY_LIST);
  }

  public List<Show> getAllShows(Movie movie) {
    return movieToShow.getOrDefault(movie, Collections.EMPTY_LIST);
  }

  public List<Seat> getAvailableSeats(Show show, SeatType type) {
    return show.getSeats(type);
  }

  public Ticket bookTicket(Show show, List<Seat> selectedSeats) {
    return show.bookTicket(selectedSeats);
  }

  public void payForTicket(Ticket ticket) {
    ticket.payForTicket();
  }

  public void cancelTicket(Ticket ticket) {
    ticket.cancelTicket();
  }
}
