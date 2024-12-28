package questions.movieTicketBookingSystem;

import java.util.List;
import java.util.UUID;

public class Ticket {
  private UUID uuid;
  private Show show;
  private Double price;
  private TicketStatus ticketStatus;

  private List<Seat> bookedSeats;

  public Ticket(Show show, Double price, List<Seat> bookedSeats) {
    this.uuid = UUID.randomUUID();

    this.show = show;
    this.price = price;
    this.ticketStatus = TicketStatus.PENDING;
    this.bookedSeats = bookedSeats;
  }

  public UUID getUuid() {
    return uuid;
  }

  public List<Seat> getBookedSeats() {
    return bookedSeats;
  }

  public void payForTicket() {
    bookedSeats.forEach(seat -> seat.bookedSeat());
    this.ticketStatus = TicketStatus.CONFIRMED;
  }

  public void cancelTicket() {
    bookedSeats.forEach(seat -> seat.openSeat());
    this.ticketStatus = TicketStatus.CANCELLED;
  }

}
