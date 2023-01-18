package carRentalZoom;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class User {
    private String userName;
    private String password;
    private String email;
}
