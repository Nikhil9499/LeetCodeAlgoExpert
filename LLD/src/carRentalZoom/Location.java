package carRentalZoom;

import carRentalZoom.enums.City;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Location {
    private String country;
    private int pinCode;
    private City city;
}
