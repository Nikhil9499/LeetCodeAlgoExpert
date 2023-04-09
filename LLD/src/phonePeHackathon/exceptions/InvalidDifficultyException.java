package phonePeHackathon.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InvalidDifficultyException extends RuntimeException {
    private String message;
}
