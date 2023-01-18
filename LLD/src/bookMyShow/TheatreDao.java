package bookMyShow;


import bookMyShow.enums.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreDao {

    Map<City, List<Theatre>> cityVsTheatre;
    List<Theatre> allTheatre;

    TheatreDao() {
        cityVsTheatre = new HashMap<>();
        allTheatre = new ArrayList<>();
    }

    void addTheatre(Theatre theatre, City city) {

        allTheatre.add(theatre);

        List<Theatre> theatres = cityVsTheatre.getOrDefault(city, new ArrayList<>());
        theatres.add(theatre);
        cityVsTheatre.put(city, theatres);
    }


    Map<Theatre, List<Show>> getAllShow(Movie movie, City city) {

        //get all the theater of this city
        Map<Theatre, List<Show>> theatreVsShows = new HashMap<>();

        List<Theatre> theatres = cityVsTheatre.get(city);

        //filter the theatres which run this movie
        for (Theatre theatre : theatres) {

            List<Show> givenMovieShows = new ArrayList<>();
            List<Show> shows = theatre.getShows();

            for (Show show : shows) {
                if (show.getMovie().getMovieId() == movie.getMovieId()) {
                    givenMovieShows.add(show);
                }
            }
            if (!givenMovieShows.isEmpty()) {
                theatreVsShows.put(theatre, givenMovieShows);
            }
        }

        return theatreVsShows;
    }
}

