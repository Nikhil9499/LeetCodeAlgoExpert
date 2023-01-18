package bookMyShow;

import bookMyShow.enums.City;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private String country;
    private int zipCode;
    private City city;
}
