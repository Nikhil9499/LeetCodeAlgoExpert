package carRentalZoom;

import carRentalZoom.costStrategy.CostStrategy;
import carRentalZoom.enums.VehicleStatus;
import carRentalZoom.enums.VehicleType;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Builder
@ToString(onlyExplicitlyIncluded = true)
public class Vehicle {
    private int vehicleNumber;
    @ToString.Include
    private String vehicleName;
    private long distanceTravelled;
    private VehicleType vehicleType;
    private VehicleStatus vehicleStatus;
    private List<CostStrategy> costStrategies;
}
