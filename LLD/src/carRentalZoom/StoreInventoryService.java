package carRentalZoom;

import carRentalZoom.enums.City;
import carRentalZoom.enums.VehicleStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

@AllArgsConstructor
@Builder
public class StoreInventoryService {
    private List<Store> storeList;

    public void addStore(Store store) {
        storeList.add(store);
    }

    public void removeStore(Store store) {
        storeList.remove(store);
    }

    public List<Store> getStores() {
        return storeList;
    }

    public List<Store> getStoresBasedOnCity(City city) {
        return storeList.stream()
                .filter(store -> city.equals(store.getLocation().getCity()))
                .toList();
    }

    public List<Vehicle> getAvailableVehicles(Store store) {
        return store.getVehicleList().stream()
                .filter(vehicle -> vehicle.getVehicleStatus() == VehicleStatus.AVAILABLE)
                .toList();
    }

    public void updateVehicleStatusWrtStore(int storeId, int vehicleNumber, VehicleStatus vehicleStatus) {
        List<Vehicle> vehicleList = storeList.stream().filter(store -> store.getStoreId() == storeId).findFirst().get().getVehicleList();

        vehicleList.forEach(vehicle -> {
            if (vehicle.getVehicleNumber() == vehicleNumber) {
                vehicle.setVehicleStatus(vehicleStatus);
            }
        });
    }

}
