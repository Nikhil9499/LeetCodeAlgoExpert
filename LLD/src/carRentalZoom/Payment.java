package carRentalZoom;

import lombok.Builder;

@Builder
public class Payment {
    public boolean payBill(Booking booking) {return true;}
}
