package phonePeHackathon.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserDoesNotExistException extends RuntimeException {
    private String message;
}
