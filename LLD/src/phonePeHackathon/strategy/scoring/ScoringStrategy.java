package phonePeHackathon.strategy.scoring;

import phonePeHackathon.models.Problem;

public interface ScoringStrategy {
    int score(Problem problem);
}
