package chess.v1;

import lombok.Getter;

@Getter
public enum PieceType {
    PAWN("P"),
    ROOK("R"),
    KNIGHT("N"),
    QUEEN("Q"),
    KING("K"),
    BISHOP("B");

    private String val;

    PieceType(String val) {
        this.val = val;
    }
}
