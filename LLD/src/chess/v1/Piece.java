package chess.v1;

import lombok.Getter;

@Getter
public abstract class Piece {
    private PieceType pieceType;
    private Color color;

    public Piece(PieceType pieceType, Color color) {
        this.pieceType = pieceType;
        this.color = color;
    }

    public abstract boolean isValidMove();
}
