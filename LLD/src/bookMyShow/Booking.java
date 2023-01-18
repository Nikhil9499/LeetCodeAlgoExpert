package bookMyShow;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Booking {
    private int bookingId;
    private Show show;
    private List<Seat> seatsBooked;
    private User user;
    private Payment payment;
}
