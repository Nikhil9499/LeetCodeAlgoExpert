package phonePeHackathon.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
@ToString
public class LeaderboardEntry {
    private String name;
    private double score;
    @Builder.Default
    private Set<Problem> solvedProblems = new HashSet<>();
}
