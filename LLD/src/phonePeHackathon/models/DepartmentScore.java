package phonePeHackathon.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class DepartmentScore {
    private String name;
    private double score;

    public void addScore(double s) {
        score+= s;
    }
}
