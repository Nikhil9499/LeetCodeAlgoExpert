package phonePeHackathon.models;

import lombok.NoArgsConstructor;
import phonePeHackathon.strategy.scoring.ScoringStrategy;

@NoArgsConstructor
public abstract class User {
    private ScoringStrategy scoringStrategy;

    public User(ScoringStrategy scoringStrategy) {
        this.scoringStrategy = scoringStrategy;
    }

    public int getScore(Problem problem) {
        return scoringStrategy.score(problem);
    }
}
