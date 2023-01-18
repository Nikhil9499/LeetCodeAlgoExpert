package bookMyShow;

import bookMyShow.enums.City;
import bookMyShow.enums.Genre;
import bookMyShow.enums.SeatType;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Builder
public class BookMyShow {

    private MovieDao movieDao;
    private TheatreDao theatreDao;

    public void initialise() {
        initialiseMovies();
        initialiseTheatres();
    }

    public void createBooking(City userCity, String movieName) {

        //1. search movie by my location
        List<Movie> movies = movieDao.getMoviesByCity(userCity);

        //2. select the movie which you want to see. i want to see Avengers
        Movie interestedMovie = null;
        for (Movie movie : movies) {
            if ((movie.getMovieName()).equals(movieName)) {
                interestedMovie = movie;
            }
        }

        //3. get all show of this movie in Bangalore location
        Map<Theatre, List<Show>> showsTheatreWise = theatreDao.getAllShow(interestedMovie, userCity);

        //4. select the particular show user is interested in
        Map.Entry<Theatre, List<Show>> entry = showsTheatreWise.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();
        Show interestedShow = runningShows.get(0);

        //5. select the seat
        int seatNumber = 30;
        List<Integer> bookedSeats = interestedShow.getBookedSeatIds();
        if (!bookedSeats.contains(seatNumber)) {
            bookedSeats.add(seatNumber);
            //startPayment
            Booking booking = Booking.builder().build();
            List<Seat> myBookedSeats = new ArrayList<>();
            for (Seat screenSeat : interestedShow.getHall().getSeats()) {
                if (screenSeat.getSeatId() == seatNumber) {
                    myBookedSeats.add(screenSeat);
                }
            }
            booking.setSeatsBooked(myBookedSeats);
            booking.setShow(interestedShow);
        } else {
            //throw exception
            System.out.println("seat already booked, try again");
            return;
        }

        System.out.println("BOOKING SUCCESSFUL");
    }


    private void initialiseMovies() {
        Movie m1 = Movie.builder()
                .movieName("Avengers")
                .movieId(1)
                .genre(Genre.ACTION)
                .build();

        Movie m2 = Movie.builder()
                .movieName("Paathshaala")
                .movieId(1)
                .genre(Genre.ACTION)
                .build();

        movieDao.addMovie(m1, City.BANGALORE);
        movieDao.addMovie(m1, City.DELHI);

        movieDao.addMovie(m2, City.BANGALORE);
        movieDao.addMovie(m2, City.DELHI);
    }

    private void initialiseTheatres() {

        Movie avengerMovie = movieDao.getMovieByName("Avengers");
        Movie paathshaala = movieDao.getMovieByName("Paathshaala");

        List<Hall> halls = createHalls();

        Show inoxMorningShow = createShows(1, halls.get(0), avengerMovie, 8);
        Show inoxEveningShow = createShows(2, halls.get(0), paathshaala, 16);
        List<Show> inoxShows = new ArrayList<>();
        inoxShows.add(inoxMorningShow);
        inoxShows.add(inoxEveningShow);

        Theatre inoxTheatre = Theatre.builder()
                .shows(inoxShows)
                .theatreId(1)
                .halls(halls)
                .city(City.BANGALORE)
                .build();


        List<Show> pvrShows = new ArrayList<>();
        Show pvrMorningShow = createShows(3, halls.get(0), avengerMovie, 13);
        Show pvrEveningShow = createShows(4, halls.get(0), paathshaala, 20);
        pvrShows.add(pvrMorningShow);
        pvrShows.add(pvrEveningShow);

        Theatre pvrTheatre = Theatre.builder()
                .shows(pvrShows)
                .theatreId(2)
                .halls(halls)
                .city(City.DELHI)
                .build();

        theatreDao.addTheatre(inoxTheatre, City.BANGALORE);
        theatreDao.addTheatre(pvrTheatre, City.DELHI);

    }

    private List<Hall> createHalls() {

        List<Hall> halls = new ArrayList<>();
        Hall hall1 = Hall.builder()
                .hallId(1)
                .seats(createSeats())
                .build();
        halls.add(hall1);

        return halls;
    }

    private Show createShows(int showId, Hall hall, Movie movie, int showStartTime) {
        return Show.builder()
                .showId(showId)
                .hall(hall)
                .movie(movie)
                .startTime(String.valueOf(showStartTime)) //24 hrs time ex: 14 means 2pm and 8 means 8AM
                .build();
    }

    //creating 100 seats
    private List<Seat> createSeats() {

        //creating 100 seats for testing purpose, this can be generalised
        List<Seat> seats = new ArrayList<>();

        //1 to 40 : SILVER
        for (int i = 0; i < 40; i++) {
            Seat seat = Seat.builder()
                    .seatId(i)
                    .seatType(SeatType.SILVER)
                    .build();
            seats.add(seat);
        }

        //41 to 70 : GOLD
        for (int i = 40; i < 70; i++) {
            Seat seat = Seat.builder()
                    .seatId(i)
                    .seatType(SeatType.GOLD)
                    .build();
            seats.add(seat);
        }

        //1 to 40 : PLATINUM
        for (int i = 70; i < 100; i++) {
            Seat seat = Seat.builder()
                    .seatId(i)
                    .seatType(SeatType.PLATINUM)
                    .build();
            seats.add(seat);
        }

        return seats;
    }


}
