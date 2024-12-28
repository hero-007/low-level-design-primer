package questions.movieTicketBookingSystem;

public class Seat {
  private int row;
  private int col;
  private SeatType type;
  private SeatStatus status;

  public Seat(int row, int col, SeatType type, SeatStatus status) {
    this.row = row;
    this.col = col;
    this.type = type;
    this.status = status;
  }

  public String getSeatId() {
    return "Row:"+row+" | Column:"+col;
  }

  public SeatType getType() {
    return type;
  }

  public SeatStatus getStatus() {
    return status;
  }

  public void bookingSeat() {
    this.status = SeatStatus.BOOKING;
  }

  public void bookedSeat() {
    this.status = SeatStatus.BOOKED;
  }

  public void openSeat() {
    this.status = SeatStatus.AVAILABLE;
  }

  public void unavailableSeat() {
    this.status = SeatStatus.UNAVAILABLE;
  }
}
