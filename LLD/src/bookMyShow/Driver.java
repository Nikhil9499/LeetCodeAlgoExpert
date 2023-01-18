package bookMyShow;

import bookMyShow.enums.City;

public class Driver {
    public static void main(String[] args) {
        BookMyShow bookMyShow = BookMyShow.builder()
                .movieDao(new MovieDao())
                .theatreDao(new TheatreDao())
                .build();

        bookMyShow.initialise();

        //user1
        bookMyShow.createBooking(City.BANGALORE, "Avengers");
        //user2
        bookMyShow.createBooking(City.BANGALORE, "Avengers");

    }
}
