package carRentalZoom.costStrategy;

import lombok.Builder;

@Builder
public class HourlyCostStrategy implements CostStrategy {
    @Override
    public int getPrice() {
        return 100;
    }
}
