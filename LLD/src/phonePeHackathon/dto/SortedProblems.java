package phonePeHackathon.dto;

import lombok.Builder;
import lombok.Getter;
import phonePeHackathon.models.Problem;
import phonePeHackathon.strategy.sorting.SortingStrategy;

import java.util.List;

@Getter
public abstract class SortedProblems {
    private SortingStrategy sortingStrategy;

    public SortedProblems(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void sort(List<Problem> problemList) {
        sortingStrategy.sort(problemList);
    }
}
