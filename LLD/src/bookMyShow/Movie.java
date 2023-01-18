package bookMyShow;

import bookMyShow.enums.Genre;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Movie {
    private int movieId;
    private String movieName;
    private Genre genre;
    private List<String> actors;
}
