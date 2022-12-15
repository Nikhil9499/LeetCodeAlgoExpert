package tictactoe.v1;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Symbol {
    private SymbolType symbolType;

    @Override
    public String toString() {
        return symbolType == null ? " " : symbolType.getVal();
    }
}
