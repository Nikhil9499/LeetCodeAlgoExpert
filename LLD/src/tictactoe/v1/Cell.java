package tictactoe.v1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cell {
    private Symbol symbol;

    @Override
    public String toString() {
        return symbol == null ? " " : symbol.toString();
    }
}
