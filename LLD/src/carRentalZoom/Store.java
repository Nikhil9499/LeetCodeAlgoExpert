package carRentalZoom;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@ToString(onlyExplicitlyIncluded = true)
public class Store {
    private int storeId;
    @ToString.Include
    private String storeName;
    private Location location;
    private List<Vehicle> vehicleList;
}
