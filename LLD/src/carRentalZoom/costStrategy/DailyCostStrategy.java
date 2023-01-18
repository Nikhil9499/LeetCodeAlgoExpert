package carRentalZoom.costStrategy;

import lombok.Builder;

@Builder
public class DailyCostStrategy implements CostStrategy {
    @Override
    public int getPrice() {
        return 2200;
    }
}
