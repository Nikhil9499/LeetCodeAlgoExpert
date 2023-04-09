package phonePeHackathon.strategy.scoring;

import phonePeHackathon.models.Problem;

public class DefaultScoringStrategy implements ScoringStrategy {

    @Override
    public int score(Problem problem) {
        return problem.getScore();
    }
}
