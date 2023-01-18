package carRentalZoom;

import carRentalZoom.enums.VehicleStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

@AllArgsConstructor
@Builder
public class VehicleInventoryService {
    private List<Vehicle> vehicleList;

    public void addVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicleList.remove(vehicle);
    }

    public List<Vehicle> getVehicles() {
        return vehicleList;
    }

}
