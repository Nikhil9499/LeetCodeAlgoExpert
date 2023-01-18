package bookMyShow;

import bookMyShow.enums.City;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Theatre {
    private int theatreId;
    private City city;
    private List<Show> shows;
    private List<Hall> halls;
}
