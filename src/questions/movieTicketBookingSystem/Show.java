package questions.movieTicketBookingSystem;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

public class Show {
  private Movie movie;
  private Theater theater;
  private Instant startTime;
  private Instant endTime;
  private List<Seat> seats;
  private ShowStatus status;

  public Show(Movie movie, Theater theater, Instant startTime, Instant endTime, List<Seat> seats, ShowStatus showStatus) {
    this.movie = movie;
    this.theater = theater;
    this.startTime = startTime;
    this.endTime = endTime;
    this.seats = seats;
    this.status = showStatus;
  }

  public List<Seat> getSeats(SeatType type) {
    List<Seat> availableSeats = seats.stream().filter(seat -> seat.getStatus() == SeatStatus.AVAILABLE).collect(Collectors.toList());

    if (type == null) return availableSeats;
    return availableSeats.stream().filter(seat -> seat.getType() == type).collect(Collectors.toList());
  }

  public Ticket bookTicket(List<Seat> selectedSeats) {
    // 1 - validate the selected seats should have status as available
    // 2 - compute the price and then generate a ticket with PENDING status and selected seats should have status as BOOKING
    validateSeats(selectedSeats);
    Double price = computeTicketPrice(selectedSeats);

    selectedSeats.forEach(seat -> seat.bookingSeat());

    Ticket ticket = new Ticket(this, 0.0, selectedSeats);
    return ticket;
  }


  private Double computeTicketPrice(List<Seat> selectedSeats) {
    // We can follow different strategy to compute price - use strategy pattern
    return 100.0;
  }

  private void validateSeats(List<Seat> selectedSeats) {
    for (Seat seat : selectedSeats) {
      if (seat.getStatus() != SeatStatus.AVAILABLE)
        throw new IllegalArgumentException("You cannot book seat "+seat.getSeatId()+" as it is already booked");
    }
  }

}
