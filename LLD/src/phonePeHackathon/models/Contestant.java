package phonePeHackathon.models;

import lombok.*;
import phonePeHackathon.strategy.scoring.DefaultScoringStrategy;
import phonePeHackathon.strategy.scoring.ScoringStrategy;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Builder
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class Contestant extends User {
    @ToString.Include
    private String name;
    @ToString.Include
    private String departmentName;
    @Builder.Default
    private Set<Problem> solvedProblems = new HashSet<>();

    public Contestant(String name, String departmentName) {
        super(new DefaultScoringStrategy());
        this.name = name;
        this.departmentName = departmentName;
        solvedProblems = new HashSet<>();
    }

    public void solveProblem(Problem problem, double timeTaken) {
        problem.updateAvgTime(timeTaken);
        problem.incrementNumberOfSolvers();
        problem.setScore(this.getScore(problem));
        solvedProblems.add(problem);
    }

    public Set<Problem> getSolvedProblems() {
        return solvedProblems;
    }

    public int getTotalScore() {
        int totalScore = 0;
        for (Problem problem : solvedProblems) {
            totalScore += problem.getScore();
        }
        return totalScore;
    }
}
