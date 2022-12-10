package snakesAndLadder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Jump {
    private int start, end;
    private JumpType jumpType;
}
