package bookMyShow;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Show {
    private int showId;
    private Movie movie;
    @Builder.Default
    private List<Integer> bookedSeatIds = new ArrayList<>();
    private Hall hall;
    private String startTime;
}
