package bookMyShow;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Hall {
    private int hallId;
    private List<Seat> seats;
}
