package phonePeHackathon.models;

import lombok.*;
import phonePeHackathon.dto.SortedProblems;
import phonePeHackathon.models.enums.Difficulty;
import phonePeHackathon.strategy.sorting.DefaultSortingStrategy;
import phonePeHackathon.strategy.sorting.SortingStrategy;

@Builder
@Getter
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class Problem {
    @ToString.Include
    private String name;
    private String description;
    private String tag;
    private Difficulty difficulty;
    private int score;
    private int numSolvers; // 1
    private double avgTime;

    public void incrementNumberOfSolvers() {
        numSolvers++;
    }

    public void updateAvgTime(double time) {
        double totalTime = avgTime * numSolvers + time;
        avgTime = totalTime / (numSolvers + 1);
    }

    public void setScore(int score) {
        this.score = score;
    }
}
