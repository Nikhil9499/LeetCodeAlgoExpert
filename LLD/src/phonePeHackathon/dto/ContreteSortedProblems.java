package phonePeHackathon.dto;

import lombok.Builder;
import phonePeHackathon.models.Problem;
import phonePeHackathon.strategy.sorting.DefaultSortingStrategy;
import phonePeHackathon.strategy.sorting.SortingStrategy;

import java.util.List;


public class ContreteSortedProblems extends SortedProblems {
    public ContreteSortedProblems(SortingStrategy sortingStrategy) {
        super(new DefaultSortingStrategy());
    }

    @Override
    public void sort(List<Problem> problemList) {
        super.sort(problemList);
    }
}
