package phonePeHackathon.strategy.sorting;

import phonePeHackathon.models.Problem;

import java.util.List;

public class DefaultSortingStrategy implements SortingStrategy {
    @Override
    public void sort(List<Problem> problemList) {
        problemList.sort((p1, p2) -> p2.getScore() - p1.getScore());
    }
}
