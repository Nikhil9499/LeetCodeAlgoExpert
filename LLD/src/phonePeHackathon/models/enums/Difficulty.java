package phonePeHackathon.models.enums;

import lombok.Getter;

@Getter
public enum Difficulty {
    EASY, MEDIUM, HARD;

    public static Difficulty getDifficulty(String value) {
        for (Difficulty difficulty : values()) {
            if (difficulty.name().equalsIgnoreCase(value)) {
                return difficulty;
            }
        }
        return null;
    }
}
