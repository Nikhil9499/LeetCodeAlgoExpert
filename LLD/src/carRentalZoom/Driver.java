package carRentalZoom;

import carRentalZoom.enums.City;

import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        CarRentalSystem carRentalSystem = CarRentalSystem.builder()
                .storeInventoryService(StoreInventoryService.builder()
                        .storeList(new ArrayList<>())
                        .build())
                .vehicleInventoryService(VehicleInventoryService.builder()
                        .vehicleList(new ArrayList<>())
                        .build())
                .build();

        carRentalSystem.initialise();
        carRentalSystem.createBooking(City.DELHI);
        carRentalSystem.createBooking(City.BANGALORE);
        carRentalSystem.createBooking(City.BANGALORE);
    }
}
