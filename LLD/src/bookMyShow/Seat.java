package bookMyShow;

import bookMyShow.enums.SeatType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Seat {
    private int seatId;
    private SeatType seatType;
    private double price;
    private boolean isFree;
    private String position;
}
