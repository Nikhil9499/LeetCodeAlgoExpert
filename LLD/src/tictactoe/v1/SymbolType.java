package tictactoe.v1;

import lombok.Getter;

@Getter
public enum SymbolType {
    X("X"),
    O("O"),
    Dollar("$"),
    Hash("#");

    private String val;

    SymbolType(String value) {
        this.val = value;
    }

    public static SymbolType fromString(String text) {
        for (SymbolType b : SymbolType.values()) {
            if (b.val.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
