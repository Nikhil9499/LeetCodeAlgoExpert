package phonePeHackathon.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import phonePeHackathon.models.Contestant;

import java.util.Set;

@Getter
@Builder
@ToString
public class ProblemUsersWIthAvgTime {
    private double avgTime;
    private Set<Contestant> contestants;
}
