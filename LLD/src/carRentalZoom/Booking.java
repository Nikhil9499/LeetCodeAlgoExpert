package carRentalZoom;

import carRentalZoom.enums.BookingStatus;
import carRentalZoom.enums.BookingType;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Booking {
    private int bookingId;
    private Vehicle vehicle;
    private Payment payment;
    private BookingType bookingType;
    private Date startDate;
    private int duration;
    private long startTime;
    private long endTime;
    private BookingStatus bookingStatus;
    private Date createdAt;
    private double cost;
}
