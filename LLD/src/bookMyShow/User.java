package bookMyShow;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String userName;
    private Address address;
    private boolean isActive;
}
